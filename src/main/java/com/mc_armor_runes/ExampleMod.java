package com.mc_armor_runes;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.Security;

public class ExampleMod implements ModInitializer {
    public static final String MOD_ID = "mc_armor_runes";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        // Register items
        ModItems.initialize();

        // Register server tick event
        ServerTickEvents.END_SERVER_TICK.register(this::onServerTick);

        LOGGER.info("MC Armor Runes initialized!");
    }

    //Checks Server Ticks and calls Method on Tick.
    private void onServerTick(MinecraftServer server) {
        for (ServerPlayer player : server.getPlayerList().getPlayers()) {
            ArmorEffects.applySeaArmorEffects(player);
            ArmorEffects.applyWoodArmorEffects(player);
        }
    }
}