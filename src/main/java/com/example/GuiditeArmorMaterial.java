package com.example;

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


public class GuiditeArmorMaterial {
    public static final int BASE_DURABILITY = 15;


    public static final TagKey<@NotNull Item> REPAIRS_GUIDITE_ARMOR = TagKey.create(BuiltInRegistries.ITEM.key(),
            Identifier.fromNamespaceAndPath(ExampleMod.MOD_ID, "repairs_helmet_of_sea_armor"));
    public static final ResourceKey<@NotNull EquipmentAsset> GUIDITE_ARMOR_MATERIAL_KEY = ResourceKey.create(EquipmentAssets.ROOT_ID,
            Identifier.fromNamespaceAndPath(ExampleMod.MOD_ID, "helmet_of_sea"));
    public static final ArmorMaterial INSTANCE = new ArmorMaterial(
            BASE_DURABILITY,
            Map.of(
                    ArmorType.HELMET, 3,
                    ArmorType.CHESTPLATE, 8,
                    ArmorType.LEGGINGS, 6,
                    ArmorType.BOOTS, 3
            ),
            5,
            SoundEvents.ARMOR_EQUIP_IRON,
            0.0F,
            0.0F,
            REPAIRS_GUIDITE_ARMOR,
            GUIDITE_ARMOR_MATERIAL_KEY
    );
}
