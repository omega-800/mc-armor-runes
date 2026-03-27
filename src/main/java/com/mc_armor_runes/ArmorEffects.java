
package com.mc_armor_runes;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
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

    public static void applySeaArmorEffects(Player player) {
        int seaArmorPieces = 0;
        int woodArmorPieces = 0;

        for (EquipmentSlot slot : EquipmentSlot.values()) {
            if (slot.getType() == EquipmentSlot.Type.HUMANOID_ARMOR) {
                ItemStack armorPiece = player.getItemBySlot(slot);
                if (armorPiece.getItem() == ModItems.HELMET_OF_SEA
                        || armorPiece.getItem() == ModItems.BOOTS_OF_SEA
                        || armorPiece.getItem() == ModItems.CHESTPLATE_OF_SEA
                        || armorPiece.getItem() == ModItems.LEGGINGS_OF_SEA)
                    seaArmorPieces++;

            }
            {
                if (seaArmorPieces >= 1) {
                    player.addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 220, 0, false, false));
                }
                if (seaArmorPieces >= 2) {
                    player.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 220, 0, false, false));
                }
                if (seaArmorPieces == 4) {
                    player.addEffect(new MobEffectInstance(MobEffects.CONDUIT_POWER, 220, 0, false, false));

                }
            }
        }
    }
}




