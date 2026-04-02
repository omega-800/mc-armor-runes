package com.mc_armor_runes;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;
import org.jetbrains.annotations.NotNull;

import java.util.Map;


public class WoodsArmorMaterial {
    public static final int BASE_DURABILITY = 15;


    public static final TagKey<@NotNull Item> REPAIRS_WOODS_ARMOR = TagKey.create(BuiltInRegistries.ITEM.key(),
            Identifier.fromNamespaceAndPath(ExampleMod.MOD_ID, "repairs_rune_of_woods_armor"));
    public static final ResourceKey<@NotNull EquipmentAsset> WOODS_ARMOR_MATERIAL_KEY = ResourceKey.create(EquipmentAssets.ROOT_ID,
            Identifier.fromNamespaceAndPath(ExampleMod.MOD_ID, "rune_of_woods_armor"));
    public static final ArmorMaterial INSTANCE = new ArmorMaterial(
            BASE_DURABILITY,
            Map.of(
                    ArmorType.HELMET, 3,
                    ArmorType.CHESTPLATE, 7,
                    ArmorType.LEGGINGS, 6,
                    ArmorType.BOOTS, 3
            ),
            5,
            SoundEvents.ARMOR_EQUIP_IRON,
            0.0F,
            0.0F,
            REPAIRS_WOODS_ARMOR,
            WOODS_ARMOR_MATERIAL_KEY
    );
}
