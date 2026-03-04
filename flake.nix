{
  description = "java development environment";

  inputs.nixpkgs.url = "github:NixOS/nixpkgs/nixos-unstable";
  inputs.nixgl = {
    url = "github:nix-community/nixGL";
    inputs.nixpkgs.follows = "nixpkgs";
  };

  outputs =
    {
      self,
      nixpkgs,
      nixgl,
    }:
    let
      systems = nixpkgs.lib.platforms.unix;
      eachSystem =
        f:
        nixpkgs.lib.genAttrs systems (
          system:
          f (
            import nixpkgs {
              inherit system;
              config = {
                allowUnfree = true;
              };
              overlays = [
                nixgl.overlay
                (_: prev: {
                  nixGL =
                    pkg:
                    (pkg.overrideAttrs (old: {
                      name = "nixGL-${pkg.name}";
                      buildCommand = ''
                        set -eo pipefail

                        ${
                          # Heavily inspired by https://stackoverflow.com/a/68523368/6259505
                          prev.lib.concatStringsSep "\n" (
                            map (outputName: ''
                              echo "Copying output ${outputName}"
                              set -x
                              cp -rs --no-preserve=mode "${pkg.${outputName}}" "''$${outputName}"
                              set +x
                            '') (old.outputs or [ "out" ])
                          )
                        }

                        rm -rf $out/bin/*
                        shopt -s nullglob # Prevent loop from running if no files
                        for file in ${pkg.out}/bin/*; do
                          echo "#!${prev.bash}/bin/bash" > "$out/bin/$(basename $file)"
                          echo "exec -a \"\$0\" ${prev.nixgl.nixGLIntel}/bin/nixGLIntel $file \"\$@\"" >> "$out/bin/$(basename $file)"
                          chmod +x "$out/bin/$(basename $file)"
                        done
                        shopt -u nullglob # Revert nullglob back to its normal default state
                      '';
                    }));
                })
              ];
            }
          )
        );
      pname = "mcmod";
    in
    {
      devShells = eachSystem (
        pkgs:
        let
          java = pkgs.jetbrains.jdk-no-jcef;
          buildInputs = with pkgs; [
            libGL
            (nixGL glfw3-minecraft) # Not always needed, but in case it is, it's here.
            flite # TTS
            libpulseaudio # Required for audio
          ];
        in
        {
          default = pkgs.mkShellNoCC {
            inherit buildInputs;

            nativeBuildInputs = with pkgs; [
              java
            ];

            packages = with pkgs; [
              # jdk25_headless
              # jetbrains.idea
              # jdk
              (nixGL gradle_9)
              # gradle
            ];
            env = {
              LD_LIBRARY_PATH = pkgs.lib.makeLibraryPath buildInputs;
              JAVA_HOME = "${java.home}";
            };
            # _JAVA_OPTIONS = "-Dawt.useSystemAAFontSettings=lcd";
          };
        }
      );

      # TODO:
      # packages = eachSystem (
      #   pkgs:
      #   let
      #     fs = pkgs.lib.fileset;
      #     root = ./.;
      #   in
      #   {
      #     default = {
      #       inherit pname;
      #       version = "0.0.1";
      #       src = fs.toSource {
      #         inherit root;
      #         fileset = fs.intersection (fs.gitTracked root) (
      #           fs.unions [
      #           ]
      #         );
      #       };
      #     };
      #   }
      # );

      apps = eachSystem (
        pkgs:
        pkgs.lib.mapAttrs (_: drv: {
          type = "app";
          program = "${drv}${drv.passthru.exePath or "/bin/${drv.pname or drv.name}"}";
        }) self.packages.${pkgs.system}
      );
    };
}
