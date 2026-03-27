package com.example;

import java.util.function.Function;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.ArmorType;
import org.jetbrains.annotations.NotNull;

public class ModItems {


    public static final Item HELMET_OF_SEA = register(
            "helmet_of_sea",
            Item::new,
            new Item.Properties().humanoidArmor(SeaArmorMaterial.INSTANCE, ArmorType.HELMET)
                    .durability(ArmorType.HELMET.getDurability(SeaArmorMaterial.BASE_DURABILITY))
    );

    public static final Item CHESTPLATE_OF_SEA = register(
            "chestplate_of_sea",
            Item::new,
            new Item.Properties().humanoidArmor(SeaArmorMaterial.INSTANCE, ArmorType.CHESTPLATE)
                    .durability(ArmorType.CHESTPLATE.getDurability(SeaArmorMaterial.BASE_DURABILITY))
    );

    public static final Item BOOTS_OF_SEA = register(
            "boots_of_sea",
            Item::new,
            new Item.Properties().humanoidArmor(SeaArmorMaterial.INSTANCE, ArmorType.BOOTS)
                    .durability(ArmorType.BOOTS.getDurability(SeaArmorMaterial.BASE_DURABILITY))
    );

    public static final Item LEGGINGS_OF_SEA = register(
            "leggings_of_sea",
            Item::new,
            new Item.Properties().humanoidArmor(SeaArmorMaterial.INSTANCE, ArmorType.LEGGINGS)
                    .durability(ArmorType.LEGGINGS.getDurability(SeaArmorMaterial.BASE_DURABILITY))
    );



    public static final Item HELMET_OF_WOODS = register(
            "helmet_of_woods",
            Item::new,
            new Item.Properties().humanoidArmor(WoodsArmorMaterial.INSTANCE, ArmorType.HELMET)
                    .durability(ArmorType.HELMET.getDurability(WoodsArmorMaterial.BASE_DURABILITY))
    );

    public static final Item CHESTPLATE_OF_WOODS = register(
            "chestplate_of_woods",
            Item::new,
            new Item.Properties().humanoidArmor(WoodsArmorMaterial.INSTANCE, ArmorType.CHESTPLATE)
                    .durability(ArmorType.CHESTPLATE.getDurability(WoodsArmorMaterial.BASE_DURABILITY))
    );

    public static final Item BOOTS_OF_WOODS = register(
            "boots_of_woods",
            Item::new,
            new Item.Properties().humanoidArmor(WoodsArmorMaterial.INSTANCE, ArmorType.BOOTS)
                    .durability(ArmorType.BOOTS.getDurability(WoodsArmorMaterial.BASE_DURABILITY))
    );

    public static final Item LEGGINGS_OF_WOODS = register(
            "leggings_of_woods",
            Item::new,
            new Item.Properties().humanoidArmor(WoodsArmorMaterial.INSTANCE, ArmorType.LEGGINGS)
                    .durability(ArmorType.LEGGINGS.getDurability(WoodsArmorMaterial.BASE_DURABILITY))
    );

    public static final Item RUNE_OF_SEA = register("rune_of_sea", Item::new, new Item.Properties());

    public static <T extends Item> T register(
            String name, Function<Item.Properties, T> itemFactory, Item.Properties settings) {
        ResourceKey<@NotNull Item> itemKey = ResourceKey.create(
                Registries.ITEM, Identifier.fromNamespaceAndPath(ExampleMod.MOD_ID, name));

        T item = itemFactory.apply(settings.setId(itemKey));

        Registry.register(BuiltInRegistries.ITEM, itemKey, item);

        return item;
    }



    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.COMBAT)
                .register(itemGroup -> {
                    itemGroup.accept(ModItems.RUNE_OF_SEA);
                    itemGroup.accept(ModItems.HELMET_OF_SEA);
                    itemGroup.accept(ModItems.CHESTPLATE_OF_SEA);
                    itemGroup.accept(ModItems.BOOTS_OF_SEA);
                    itemGroup.accept(ModItems.LEGGINGS_OF_SEA);
                    itemGroup.accept(ModItems.LEGGINGS_OF_WOODS);
                    itemGroup.accept(ModItems.HELMET_OF_WOODS);
                    itemGroup.accept(ModItems.CHESTPLATE_OF_WOODS);
                    itemGroup.accept(ModItems.BOOTS_OF_WOODS);

                });
    }
}

//                    itemGroup.accept(Items.HELMET_OF_THE_SEA)