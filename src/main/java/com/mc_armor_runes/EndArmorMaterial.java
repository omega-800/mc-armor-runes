package com.mc_armor_runes;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.logging.Level;

public class EndArmorMaterial {
    public static final int BASE_DURABILITY = 43;


    public static final TagKey<@NotNull Item> REPAIRS_END_ARMOR = TagKey.create(BuiltInRegistries.ITEM.key(),
            Identifier.fromNamespaceAndPath(ExampleMod.MOD_ID, "repairs_rune_of_end_armor"));
    public static final ResourceKey<@NotNull EquipmentAsset> END_ARMOR_MATERIAL_KEY = ResourceKey.create(EquipmentAssets.ROOT_ID,
            Identifier.fromNamespaceAndPath(ExampleMod.MOD_ID, "rune_of_end_armor"));
    public static final ArmorMaterial INSTANCE = new ArmorMaterial(
            BASE_DURABILITY,
            Map.of(
                    ArmorType.HELMET, 6,
                    ArmorType.CHESTPLATE, 12,
                    ArmorType.LEGGINGS, 10,
                    ArmorType.BOOTS, 7,
                    ArmorType.BODY, 13
            ),
            5,
            SoundEvents.ARMOR_EQUIP_IRON,
            4.0F,
            0.3F,
            REPAIRS_END_ARMOR,
            END_ARMOR_MATERIAL_KEY
    );


}


