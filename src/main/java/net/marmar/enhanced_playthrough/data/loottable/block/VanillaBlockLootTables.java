package net.marmar.enhanced_playthrough.data.loottable.block;

import net.marmar.enhanced_playthrough.item.EPItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.*;
import java.util.function.Predicate;

public class VanillaBlockLootTables extends BlockLootSubProvider implements BlockLootTableBuilders {

    public VanillaBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        //Leaves
        this.add(Blocks.OAK_LEAVES, block -> createLeavesWithoutFruitDrops(block, Blocks.OAK_SAPLING));

        //Plants
        this.add(Blocks.GRASS, block -> createPlantDrops(Blocks.GRASS));
        this.add(Blocks.TALL_GRASS, block -> createPlantDrops(Blocks.TALL_GRASS));

        this.add(Blocks.FERN, block -> createPlantDrops(Blocks.FERN));
        this.add(Blocks.LARGE_FERN, block -> createPlantDrops(Blocks.LARGE_FERN));

        this.add(Blocks.CARROTS, block -> createCropWithRotDrops(Items.CARROT, EPItems.ROTTEN_CARROT.get(),
                Items.CARROT, CARROT_BUILDER));

        //Terracotta
        this.add(Blocks.TERRACOTTA, block -> createTerracottaDrops(Blocks.TERRACOTTA, EPItems.TERRACOTTA_SHARD.get()));
        this.add(Blocks.WHITE_TERRACOTTA, block -> createTerracottaDrops(Blocks.WHITE_TERRACOTTA, EPItems.WHITE_TERRACOTTA_SHARD.get()));
        this.add(Blocks.ORANGE_TERRACOTTA, block -> createTerracottaDrops(Blocks.ORANGE_TERRACOTTA, EPItems.ORANGE_TERRACOTTA_SHARD.get()));
        this.add(Blocks.MAGENTA_TERRACOTTA, block -> createTerracottaDrops(Blocks.MAGENTA_TERRACOTTA, EPItems.MAGENTA_TERRACOTTA_SHARD.get()));
        this.add(Blocks.LIGHT_BLUE_TERRACOTTA, block -> createTerracottaDrops(Blocks.LIGHT_BLUE_TERRACOTTA, EPItems.LIGHT_BLUE_TERRACOTTA_SHARD.get()));
        this.add(Blocks.YELLOW_TERRACOTTA, block -> createTerracottaDrops(Blocks.YELLOW_TERRACOTTA, EPItems.YELLOW_TERRACOTTA_SHARD.get()));
        this.add(Blocks.LIME_TERRACOTTA, block -> createTerracottaDrops(Blocks.LIME_TERRACOTTA, EPItems.LIME_TERRACOTTA_SHARD.get()));
        this.add(Blocks.PINK_TERRACOTTA, block -> createTerracottaDrops(Blocks.PINK_TERRACOTTA, EPItems.PINK_TERRACOTTA_SHARD.get()));
        this.add(Blocks.GRAY_TERRACOTTA, block -> createTerracottaDrops(Blocks.GRAY_TERRACOTTA, EPItems.GRAY_TERRACOTTA_SHARD.get()));
        this.add(Blocks.LIGHT_GRAY_TERRACOTTA, block -> createTerracottaDrops(Blocks.LIGHT_GRAY_TERRACOTTA, EPItems.LIGHT_GRAY_TERRACOTTA_SHARD.get()));
        this.add(Blocks.CYAN_TERRACOTTA, block -> createTerracottaDrops(Blocks.CYAN_TERRACOTTA, EPItems.CYAN_TERRACOTTA_SHARD.get()));
        this.add(Blocks.PURPLE_TERRACOTTA, block -> createTerracottaDrops(Blocks.PURPLE_TERRACOTTA, EPItems.PURPLE_TERRACOTTA_SHARD.get()));
        this.add(Blocks.BLUE_TERRACOTTA, block -> createTerracottaDrops(Blocks.BLUE_TERRACOTTA, EPItems.BLUE_TERRACOTTA_SHARD.get()));
        this.add(Blocks.BROWN_TERRACOTTA, block -> createTerracottaDrops(Blocks.BROWN_TERRACOTTA, EPItems.BROWN_TERRACOTTA_SHARD.get()));
        this.add(Blocks.GREEN_TERRACOTTA, block -> createTerracottaDrops(Blocks.GREEN_TERRACOTTA, EPItems.GREEN_TERRACOTTA_SHARD.get()));
        this.add(Blocks.RED_TERRACOTTA, block -> createTerracottaDrops(Blocks.RED_TERRACOTTA, EPItems.RED_TERRACOTTA_SHARD.get()));
        this.add(Blocks.BLACK_TERRACOTTA, block -> createTerracottaDrops(Blocks.BLACK_TERRACOTTA, EPItems.BLACK_TERRACOTTA_SHARD.get()));

        //Stone
        this.add(Blocks.STONE, block -> createRockDrops(Blocks.STONE, Blocks.COBBLESTONE, EPItems.COBBLE.get()));
        this.add(Blocks.COBBLESTONE, block -> createRockDrops(Blocks.COBBLESTONE, Blocks.COBBLESTONE, EPItems.COBBLE.get()));

        //Deepslate
        this.add(Blocks.DEEPSLATE, block ->
                createHardRockDrops(Blocks.DEEPSLATE, Blocks.COBBLED_DEEPSLATE, EPItems.DEEPSLATE_COBBLE.get()));
        this.add(Blocks.COBBLED_DEEPSLATE, block ->
                createHardRockDrops(Blocks.COBBLED_DEEPSLATE, Blocks.COBBLED_DEEPSLATE, EPItems.DEEPSLATE_COBBLE.get()));

        //Netherrack
        this.add(Blocks.NETHERRACK, block ->
                createRockDrops(Blocks.NETHERRACK, Blocks.NETHERRACK, EPItems.NETHERRACK_RUBBLE.get()));

        //Blackstone
        this.add(Blocks.BLACKSTONE, block -> createRockDrops(Blocks.BLACKSTONE, Blocks.BLACKSTONE, EPItems.BLACKSTONE_COBBLE.get()));

        //Other blocks
            //Bricks
            this.add(Blocks.BRICKS, block -> createRoughMiningDrops(block, Items.BRICK, 4));
            this.add(Blocks.BRICK_SLAB, block -> createRoughMiningDrops(block, Items.BRICK, 2));
            this.add(Blocks.BRICK_STAIRS, block -> createRoughMiningDrops(block, Items.BRICK, 3));
            this.add(Blocks.BRICK_WALL, block -> createRoughMiningDrops(block, Items.BRICK, 2));

            //Nether bricks
            this.add(Blocks.NETHER_BRICKS, block -> createRoughMiningDrops(block, Items.NETHER_BRICK, 4));
            this.add(Blocks.NETHER_BRICK_SLAB, block -> createRoughMiningDrops(block, Items.NETHER_BRICK, 2));
            this.add(Blocks.NETHER_BRICK_STAIRS, block -> createRoughMiningDrops(block, Items.NETHER_BRICK, 3));
            this.add(Blocks.NETHER_BRICK_WALL, block -> createRoughMiningDrops(block, Items.NETHER_BRICK, 2));

        //Ores
            //Coal
            this.add(Blocks.COAL_ORE, block -> createOreDrops(Blocks.COAL_ORE, 1, 3, Items.COAL));
            this.add(Blocks.DEEPSLATE_COAL_ORE, block -> createDeepslateOreDrops(Blocks.DEEPSLATE_COAL_ORE, 1, 3, Items.COAL));

            //Copper
            this.add(Blocks.COPPER_ORE, block -> createOreDrops(Blocks.COPPER_ORE, 2, 5, Items.RAW_COPPER));
            this.add(Blocks.DEEPSLATE_COPPER_ORE, block -> createDeepslateOreDrops(Blocks.DEEPSLATE_COPPER_ORE, 2, 5, Items.RAW_COPPER));

            //Iron
            this.add(Blocks.IRON_ORE, block -> createOreDrops(Blocks.IRON_ORE, Items.RAW_IRON));
            this.add(Blocks.DEEPSLATE_IRON_ORE, block -> createDeepslateOreDrops(Blocks.DEEPSLATE_IRON_ORE, Items.RAW_IRON));

            //Gold
            this.add(Blocks.GOLD_ORE, block -> createOreDrops(Blocks.GOLD_ORE, Items.RAW_GOLD));
            this.add(Blocks.DEEPSLATE_GOLD_ORE, block -> createDeepslateOreDrops(Blocks.DEEPSLATE_GOLD_ORE, Items.RAW_GOLD));

            //Lapis
            this.add(Blocks.LAPIS_ORE, block -> createOreDrops(Blocks.LAPIS_ORE, 4, 9, Items.LAPIS_LAZULI));
            this.add(Blocks.DEEPSLATE_LAPIS_ORE, block ->
                    createDeepslateOreDrops(Blocks.DEEPSLATE_LAPIS_ORE, 4, 9, Items.LAPIS_LAZULI));

            //Redstone
            this.add(Blocks.REDSTONE_ORE, block -> createOreDrops(Blocks.REDSTONE_ORE, 4, 5, Items.REDSTONE));
            this.add(Blocks.DEEPSLATE_REDSTONE_ORE, block ->
                    createDeepslateOreDrops(Blocks.DEEPSLATE_REDSTONE_ORE, 4, 5, Items.REDSTONE));

            //Emerald
            this.add(Blocks.EMERALD_ORE, block ->
                    createGemsDrops(Blocks.EMERALD_ORE, EPItems.RAW_EMERALD.get(), 2, Items.EMERALD, 3));
            this.add(Blocks.DEEPSLATE_EMERALD_ORE, block ->
                    createDeepslateGemsDrops(Blocks.DEEPSLATE_EMERALD_ORE, EPItems.RAW_EMERALD.get(), 2,  Items.EMERALD, 3));

            //Diamond
            this.add(Blocks.DIAMOND_ORE, block ->
                    createGemsDrops(Blocks.DIAMOND_ORE, EPItems.RAW_DIAMOND.get(), 1, Items.DIAMOND, 1));
            this.add(Blocks.DEEPSLATE_DIAMOND_ORE, block ->
                    createDeepslateGemsDrops(Blocks.DEEPSLATE_DIAMOND_ORE, EPItems.RAW_DIAMOND.get(), 1,  Items.DIAMOND, 1));
    }

    private final Predicate<Block> overrideBlocks = block ->
        block == Blocks.OAK_LEAVES ||
        block == Blocks.GRASS || block == Blocks.TALL_GRASS ||
        block == Blocks.FERN || block == Blocks.LARGE_FERN ||

        block == Blocks.CARROTS ||

        block == Blocks.STONE || block == Blocks.COBBLESTONE ||
        block == Blocks.DEEPSLATE || block == Blocks.COBBLED_DEEPSLATE ||
        block == Blocks.NETHERRACK || block == Blocks.BLACKSTONE ||

        block == Blocks.TERRACOTTA || block == Blocks.WHITE_TERRACOTTA ||
        block == Blocks.ORANGE_TERRACOTTA || block == Blocks.MAGENTA_TERRACOTTA ||
        block == Blocks.LIGHT_BLUE_TERRACOTTA || block == Blocks.YELLOW_TERRACOTTA ||
        block == Blocks.LIME_TERRACOTTA || block == Blocks.PINK_TERRACOTTA ||
        block == Blocks.GRAY_TERRACOTTA || block == Blocks.LIGHT_GRAY_TERRACOTTA ||
        block == Blocks.CYAN_TERRACOTTA || block == Blocks.PURPLE_TERRACOTTA ||
        block == Blocks.BLUE_TERRACOTTA || block == Blocks.BROWN_TERRACOTTA ||
        block == Blocks.GREEN_TERRACOTTA || block == Blocks.RED_TERRACOTTA ||
        block == Blocks.BLACK_TERRACOTTA ||

        block == Blocks.BRICKS || block == Blocks.NETHER_BRICKS ||
        block == Blocks.BRICK_SLAB || block == Blocks.NETHER_BRICK_SLAB ||
        block == Blocks.BRICK_STAIRS || block == Blocks.NETHER_BRICK_STAIRS ||
        block == Blocks.BRICK_WALL || block == Blocks.NETHER_BRICK_WALL ||

        block == Blocks.COAL_ORE || block == Blocks.DEEPSLATE_COAL_ORE ||
        block == Blocks.COPPER_ORE || block == Blocks.DEEPSLATE_COPPER_ORE ||
        block == Blocks.IRON_ORE || block == Blocks.DEEPSLATE_IRON_ORE ||
        block == Blocks.GOLD_ORE || block == Blocks.DEEPSLATE_GOLD_ORE ||
        block == Blocks.LAPIS_ORE || block == Blocks.DEEPSLATE_LAPIS_ORE ||
        block == Blocks.REDSTONE_ORE || block == Blocks.DEEPSLATE_REDSTONE_ORE ||
        block == Blocks.EMERALD_ORE || block == Blocks.DEEPSLATE_EMERALD_ORE ||
        block == Blocks.DIAMOND_ORE || block == Blocks.DEEPSLATE_DIAMOND_ORE;

    @Override
    protected Iterable<Block> getKnownBlocks() {
           return ForgeRegistries.BLOCKS.getValues().stream().filter(overrideBlocks)::iterator;
    }
}
