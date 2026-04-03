package com.mc_armor_runes;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricEntityLootTableProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.sheep.Sheep;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.concurrent.CompletableFuture;

public class ModEntityLootTableProvider extends FabricEntityLootTableProvider {

    protected ModEntityLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        add(EntityType.ENDER_DRAGON, LootTable.lootTable().withPool(LootPool.lootPool()
                .setRolls(UniformGenerator.between(6.0f, 8.0f))
                .add(LootItem.lootTableItem(ModItems.ENDER_DRAGON_SCALES)))

        );
        add(EntityType.ENDERMAN, LootTable.lootTable().withPool(LootPool.lootPool()
                .setRolls(UniformGenerator.between(1.0f, 1.0f))
                .add(LootItem.lootTableItem(ModItems.ENDER_HEART)))

        );
        add(EntityType.SKELETON, LootTable.lootTable().withPool(LootPool.lootPool()
                .setRolls(UniformGenerator.between(6.0f, 8.0f))
                .add(LootItem.lootTableItem(ModItems.ENDER_DRAGON_SCALES)))

        );
    }

}
