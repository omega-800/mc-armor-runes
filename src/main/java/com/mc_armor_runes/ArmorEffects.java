package com.mc_armor_runes;
import net.minecraft.core.Holder;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.biome.Biome;
import org.jetbrains.annotations.NotNull;

import java.util.regex.Pattern;

import static net.minecraft.advancements.criterion.TagPredicate.is;
import static net.minecraft.world.level.levelgen.placement.BiomeFilter.biome;

public class ArmorEffects {

    private static Holder<Biome> biome;

    public static void applySeaArmorEffects(Player player) {
        int seaArmorPieces = 0;


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

    public static void applyEndArmorEffects(Player player) {

        int endArmorPieces = 0;

        for (EquipmentSlot slot : EquipmentSlot.values()) {
            if (slot.getType() == EquipmentSlot.Type.HUMANOID_ARMOR) {
                ItemStack armorPiece = player.getItemBySlot(slot);
                if (armorPiece.getItem() == ModItems.CHESTPLATE_OF_END
                    || armorPiece.getItem() == ModItems.HELMET_OF_END
                    || armorPiece.getItem() == ModItems.BOOTS_OF_END
                    || armorPiece.getItem() == ModItems.LEGGINGS_OF_END)
                    endArmorPieces++;

            }
            {
                if (endArmorPieces >= 1) {
                    player.addEffect(new MobEffectInstance(MobEffects.RESISTANCE, 220, 0, true, true));
                }

                if (endArmorPieces >= 2) {
                    player.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING,220, 0, true, true));
                    }
                if (endArmorPieces >= 3) {
                    player.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 220, 1,true, true));
                    player.addEffect(new MobEffectInstance(MobEffects.RESISTANCE, 220, 1,true, true));

                }
                if (endArmorPieces >= 4) {
                    player.addEffect(new MobEffectInstance(MobEffects.STRENGTH, 220, 2, true, true));
                    player.addEffect(new MobEffectInstance(MobEffects.RESISTANCE, 220, 2, true, true));

                }

            }
        }
    }

    //WOOD ARMOR EFFECTS:
    public static void applyWoodArmorEffects(Player player) {
        int woodArmorPieces = 0;

        for (EquipmentSlot slot : EquipmentSlot.values()) { //Creates variable slot to loop through values of EquipmentSlot
            if (slot.getType() == EquipmentSlot.Type.HUMANOID_ARMOR) { //Checks Slot Type for HUMANOID_ARMOR
                ItemStack armorPiece = player.getItemBySlot(slot); //Creates Variable armorPiece and compares to worn Items.
                if (armorPiece.getItem() == ModItems.HELMET_OF_WOODS //
                        || armorPiece.getItem() == ModItems.BOOTS_OF_WOODS
                        || armorPiece.getItem() == ModItems.LEGGINGS_OF_WOODS
                        || armorPiece.getItem() == ModItems.CHESTPLATE_OF_WOODS)
                    woodArmorPieces++;
            }
        }



        Holder<Biome> biome = player.level().getBiome(player.blockPosition()); //Checking Players Position

    if (biome.is(BiomeTags.IS_FOREST)) {
            if (woodArmorPieces >= 1) {
                player.addEffect(new MobEffectInstance(MobEffects.SATURATION, 220, 0, false, false));
            }

            if (woodArmorPieces >= 2) {
                player.addEffect(new MobEffectInstance(MobEffects.STRENGTH, 220, 0, false, false));
            }

            if (woodArmorPieces == 4) {
                player.addEffect(new MobEffectInstance(MobEffects.REGENERATION,220, 0, false, false));
            }
        }
    }
}







