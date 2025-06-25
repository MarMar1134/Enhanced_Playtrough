package net.marmar.enhanced_playthrough.data.loot;

import net.marmar.enhanced_playthrough.item.ModItems;
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

        //Stone
        this.add(Blocks.STONE, block -> createRockDrops(Blocks.STONE, Blocks.COBBLESTONE, ModItems.COBBLE.get()));
        this.add(Blocks.COBBLESTONE, block -> createRockDrops(Blocks.COBBLESTONE, Blocks.COBBLESTONE, ModItems.COBBLE.get()));

        //Deepslate
        this.add(Blocks.DEEPSLATE, block ->
                createHardRockDrops(Blocks.DEEPSLATE, Blocks.COBBLED_DEEPSLATE, ModItems.DEEPSLATE_COBBLE.get()));
        this.add(Blocks.COBBLED_DEEPSLATE, block ->
                createHardRockDrops(Blocks.COBBLED_DEEPSLATE, Blocks.COBBLED_DEEPSLATE, ModItems.DEEPSLATE_COBBLE.get()));

        //Netherrack
        this.add(Blocks.NETHERRACK, block ->
                createRockDrops(Blocks.NETHERRACK, Blocks.NETHERRACK, ModItems.NETHERRACK_RUBBLE.get()));

        //Blackstone
        this.add(Blocks.BLACKSTONE, block -> createRockDrops(Blocks.BLACKSTONE, Blocks.BLACKSTONE, ModItems.BLACKSTONE_COBBLE.get()));

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
                    createGemsDrops(Blocks.EMERALD_ORE, ModItems.RAW_EMERALD.get(), 2, Items.EMERALD, 3));
            this.add(Blocks.DEEPSLATE_EMERALD_ORE, block ->
                    createDeepslateGemsDrops(Blocks.DEEPSLATE_EMERALD_ORE, ModItems.RAW_EMERALD.get(), 2,  Items.EMERALD, 3));

            //Diamond
            this.add(Blocks.DIAMOND_ORE, block ->
                    createGemsDrops(Blocks.DIAMOND_ORE, ModItems.RAW_DIAMOND.get(), 1, Items.DIAMOND, 1));
            this.add(Blocks.DEEPSLATE_DIAMOND_ORE, block ->
                    createDeepslateGemsDrops(Blocks.DEEPSLATE_DIAMOND_ORE, ModItems.RAW_DIAMOND.get(), 1,  Items.DIAMOND, 1));
    }

    private final Predicate<Block> overrideBlocks = block ->
        block == Blocks.OAK_LEAVES ||
        block == Blocks.GRASS || block == Blocks.TALL_GRASS ||
        block == Blocks.FERN || block == Blocks.LARGE_FERN ||

        block == Blocks.STONE || block == Blocks.COBBLESTONE ||
        block == Blocks.DEEPSLATE || block == Blocks.COBBLED_DEEPSLATE ||
        block == Blocks.NETHERRACK || block == Blocks.BLACKSTONE ||

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
