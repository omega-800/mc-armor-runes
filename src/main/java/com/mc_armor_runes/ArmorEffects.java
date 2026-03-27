
package com.mc_armor_runes;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AnvilMenu;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;
import org.jetbrains.annotations.NotNull;
import com.mc_armor_runes.ModItems;

public class ArmorEffects {

    public static void registerTick(MinecraftServer server) {
        ServerTickEvents.START_SERVER_TICK.register(s -> {
            for (Player player : s.getPlayerList().getPlayers()) {
                applySeaArmorEffects(player);
            }
        });
    }

    public static void applySeaArmorEffects(Player player) {
        int seaArmorPieces = 0;



        for (ItemStack armorPiece : player.getInventory()) {
            if (armorPiece.getItem() == ModItems.HELMET_OF_SEA
                    || armorPiece.getItem() == ModItems.BOOTS_OF_SEA
                    || armorPiece.getItem() == ModItems.CHESTPLATE_OF_SEA
                    || armorPiece.getItem() == ModItems.LEGGINGS_OF_SEA)

                seaArmorPieces++;
        }

        {
            if (seaArmorPieces >= 1) {
                player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 220, 0));
            }
            if (seaArmorPieces >= 2) {
                player.addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 220, 0));
            }
            if (seaArmorPieces == 4) {
                player.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 220, 0));
            }
        }
    }
}



