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

public class Items {
    public static final Item HELMET_OF_THE_SEA = register("helmet_of_the_sea", Item::new, new Item.Properties());
    //public static final Item HELMET_OF_SEA = register("helmet_of_sea", Item::new, new Item.Properties());

    public static final Item HELMET_OF_SEA = register(
            "helmet_of_sea",
            Item::new,
            new Item.Properties().humanoidArmor(GuiditeArmorMaterial.INSTANCE, ArmorType.HELMET)
                    .durability(ArmorType.HELMET.getDurability(GuiditeArmorMaterial.BASE_DURABILITY))
    );

    public static final Item CHESTPLATE_OF_SEA = register(
            "chestplate_of_sea",
            Item::new,
            new Item.Properties().humanoidArmor(GuiditeArmorMaterial.INSTANCE, ArmorType.CHESTPLATE)
                    .durability(ArmorType.CHESTPLATE.getDurability(GuiditeArmorMaterial.BASE_DURABILITY))
    );

    public static final Item BOOTS_OF_SEA = register(
            "boots_of_sea",
            Item::new,
            new Item.Properties().humanoidArmor(GuiditeArmorMaterial.INSTANCE, ArmorType.BOOTS)
                    .durability(ArmorType.BOOTS.getDurability(GuiditeArmorMaterial.BASE_DURABILITY))
    );

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
                    itemGroup.accept(Items.HELMET_OF_SEA);
                    itemGroup.accept(Items.CHESTPLATE_OF_SEA);
                    itemGroup.accept(Items.BOOTS_OF_SEA);
                    itemGroup.accept(Items.HELMET_OF_THE_SEA);
                });
    }
}

//                    itemGroup.accept(Items.HELMET_OF_THE_SEA)