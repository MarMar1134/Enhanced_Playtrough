package net.marmar.enhanced_playthrough.data.loot.block;

import net.marmar.enhanced_playthrough.block.EPBlocks;
import net.marmar.enhanced_playthrough.item.EPItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class EPIBlockLootTables extends BlockLootSubProvider implements IBlockLootTableBuilders {
    public EPIBlockLootTables(){
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        //Polished stone
        this.dropSelf(EPBlocks.POLISHED_STONE.get());
        this.add(EPBlocks.POLISHED_STONE_SLAB.get(),
                block -> createSlabItemTable(EPBlocks.POLISHED_STONE_SLAB.get()));
        this.dropSelf(EPBlocks.POLISHED_STONE_STAIRS.get());
        this.dropSelf(EPBlocks.POLISHED_STONE_WALL.get());

        //Cobbled limestone
        this.add(EPBlocks.COBBLED_LIMESTONE.get(), block ->
                createRockDrops(EPBlocks.COBBLED_LIMESTONE.get(), EPBlocks.COBBLED_LIMESTONE.get(), EPItems.LIMESTONE_COBBLE.get()));
        this.add(EPBlocks.COBBLED_LIMESTONE_SLAB.get(),
                block -> createSlabItemTable(EPBlocks.COBBLED_LIMESTONE_SLAB.get()));
        this.dropSelf(EPBlocks.COBBLED_LIMESTONE_STAIRS.get());
        this.dropSelf(EPBlocks.COBBLED_LIMESTONE_WALL.get());

        //Limestone
        this.add(EPBlocks.LIMESTONE.get(), block ->
                        createRockDrops(EPBlocks.LIMESTONE.get(), EPBlocks.COBBLED_LIMESTONE.get(), EPItems.LIMESTONE_COBBLE.get()));
        this.add(EPBlocks.LIMESTONE_SLAB.get(), block ->
                createSlabItemTable(EPBlocks.LIMESTONE_SLAB.get()));
        this.dropSelf(EPBlocks.LIMESTONE_STAIRS.get());
        this.dropSelf(EPBlocks.LIMESTONE_WALL.get());

        //Polished limestone
        this.dropSelf(EPBlocks.POLISHED_LIMESTONE.get());
        this.add(EPBlocks.POLISHED_LIMESTONE_SLAB.get(), block ->
                createSlabItemTable(EPBlocks.POLISHED_LIMESTONE_SLAB.get()));
        this.dropSelf(EPBlocks.POLISHED_LIMESTONE_STAIRS.get());
        this.dropSelf(EPBlocks.POLISHED_LIMESTONE_WALL.get());

        //Limestone bricks
        this.dropSelf(EPBlocks.LIMESTONE_BRICKS.get());
        this.add(EPBlocks.LIMESTONE_BRICK_SLAB.get(), block ->
                createSlabItemTable(EPBlocks.LIMESTONE_BRICK_SLAB.get()));
        this.dropSelf(EPBlocks.LIMESTONE_BRICK_STAIRS.get());
        this.dropSelf(EPBlocks.LIMESTONE_BRICK_WALL.get());

        //Cobbled soulstone
        this.add(EPBlocks.COBBLED_SOULSTONE.get(), block ->
                createRockDrops(EPBlocks.COBBLED_SOULSTONE.get(), EPBlocks.COBBLED_SOULSTONE.get(), EPItems.SOULSTONE_COBBLE.get()));
        this.add(EPBlocks.COBBLED_SOULSTONE_SLAB.get(),
                block -> createSlabItemTable(EPBlocks.COBBLED_SOULSTONE_SLAB.get()));
        this.dropSelf(EPBlocks.COBBLED_SOULSTONE_STAIRS.get());
        this.dropSelf(EPBlocks.COBBLED_SOULSTONE_WALL.get());

        //Soulstone
        this.add(EPBlocks.SOULSTONE.get(), block ->
                createRockDrops(EPBlocks.SOULSTONE.get(), EPBlocks.COBBLED_SOULSTONE.get(), EPItems.SOULSTONE_COBBLE.get()));
        this.add(EPBlocks.SOULSTONE_SLAB.get(), block ->
                createSlabItemTable(EPBlocks.SOULSTONE_SLAB.get()));
        this.dropSelf(EPBlocks.SOULSTONE_STAIRS.get());
        this.dropSelf(EPBlocks.SOULSTONE_WALL.get());

        //soulstone bricks
        this.dropSelf(EPBlocks.SOULSTONE_BRICKS.get());
        this.add(EPBlocks.SOULSTONE_BRICK_SLAB.get(), block ->
                createSlabItemTable(EPBlocks.SOULSTONE_BRICK_SLAB.get()));
        this.dropSelf(EPBlocks.SOULSTONE_BRICK_STAIRS.get());
        this.dropSelf(EPBlocks.SOULSTONE_BRICK_WALL.get());

        //Firebricks
        this.dropSelf(EPBlocks.FIREBRICKS.get());
        this.add(EPBlocks.FIREBRICK_SLAB.get(), block ->
                createSlabItemTable(EPBlocks.FIREBRICK_SLAB.get()));
        this.dropSelf(EPBlocks.FIREBRICK_STAIRS.get());
        this.dropSelf(EPBlocks.FIREBRICK_WALL.get());

        //ores
        this.add(EPBlocks.NETHER_COPPER_ORE.get(), block ->
                createNetherOreDrops(EPBlocks.NETHER_COPPER_ORE.get(), 2, 5, Items.RAW_COPPER));

        this.add(EPBlocks.TIN_ORE.get(), block ->
                createOreDrops(EPBlocks.TIN_ORE.get(), 1, 4, EPItems.RAW_TIN.get()));
        this.add(EPBlocks.DEEPSLATE_TIN_ORE.get(), block ->
                createDeepslateOreDrops(EPBlocks.DEEPSLATE_TIN_ORE.get(), 2, 6, EPItems.RAW_TIN.get()));

        this.add(EPBlocks.ZINC_ORE.get(), block ->
                createOreDrops(EPBlocks.ZINC_ORE.get(), 1, 3, EPItems.RAW_ZINC.get()));
        this.add(EPBlocks.DEEPSLATE_ZINC_ORE.get(), block ->
                createDeepslateOreDrops(EPBlocks.DEEPSLATE_ZINC_ORE.get(), 2, 5, EPItems.RAW_ZINC.get()));
        this.add(EPBlocks.NETHER_ZINC_ORE.get(), block ->
                createOreDrops(EPBlocks.NETHER_ZINC_ORE.get(), 3, 7, EPItems.RAW_ZINC.get()));

        this.add(EPBlocks.SULFUR_ORE.get(), block ->
                createOreDrops(EPBlocks.SULFUR_ORE.get(), 2, 5, EPItems.SULFUR.get()));
        this.add(EPBlocks.DEEPSLATE_SULFUR_ORE.get(), block ->
                createDeepslateOreDrops(EPBlocks.DEEPSLATE_SULFUR_ORE.get(), 3, 7, EPItems.SULFUR.get()));
        this.add(EPBlocks.NETHER_SULFUR_ORE.get(), block ->
                createNetherOreDrops(EPBlocks.NETHER_SULFUR_ORE.get(), 4, 9, EPItems.SULFUR.get()));

        this.add(EPBlocks.SILVER_ORE.get(), block ->
                createOreDrops(EPBlocks.SILVER_ORE.get(), EPItems.RAW_SILVER.get()));
        this.add(EPBlocks.DEEPSLATE_SILVER_ORE.get(), block ->
                createDeepslateOreDrops(EPBlocks.DEEPSLATE_SILVER_ORE.get(), EPItems.RAW_SILVER.get()));

        this.add(EPBlocks.RUBY_ORE.get(),
                block -> createGemsDrops(EPBlocks.RUBY_ORE.get(), EPItems.RAW_RUBY.get(), 2, EPItems.RUBY.get(), 1));
        this.add(EPBlocks.DEEPSLATE_RUBY_ORE.get(),
                block -> createDeepslateGemsDrops(EPBlocks.DEEPSLATE_RUBY_ORE.get(), EPItems.RAW_RUBY.get(), 3, EPItems.RUBY.get(), 2));

        this.add(EPBlocks.SAPPHIRE_ORE.get(),
                block -> createGemsDrops(EPBlocks.SAPPHIRE_ORE.get(), EPItems.RAW_SAPPHIRE.get(), 3, EPItems.SAPPHIRE.get(), 2));
        this.add(EPBlocks.DEEPSLATE_SAPPHIRE_ORE.get(),
                block -> createDeepslateGemsDrops(EPBlocks.DEEPSLATE_SAPPHIRE_ORE.get(), EPItems.RAW_SAPPHIRE.get(), 4, EPItems.SAPPHIRE.get(), 3));

        this.add(EPBlocks.NETHER_GARNET_ORE.get(),
                block -> createNetherGemsDrops(EPBlocks.NETHER_GARNET_ORE.get(), EPItems.RAW_GARNET.get(), 2, EPItems.GARNET.get(), 1));

        this.add(EPBlocks.COBALT_ORE.get(),
                block -> createOreDrops(EPBlocks.COBALT_ORE.get(), EPItems.COBALT.get()));
        this.add(EPBlocks.DEEPSLATE_COBALT_ORE.get(),
                block -> createDeepslateOreDrops(EPBlocks.DEEPSLATE_COBALT_ORE.get(), EPItems.COBALT.get()));

            //Bauxite
            this.add(EPBlocks.BAUXITE.get(),
                    block -> createBauxiteOreDrops(EPBlocks.BAUXITE.get(), EPItems.TERRACOTTA_SHARD.get()));
            this.add(EPBlocks.WHITE_BAUXITE.get(),
                    block -> createBauxiteOreDrops(EPBlocks.WHITE_BAUXITE.get(), EPItems.WHITE_TERRACOTTA_SHARD.get()));
            this.add(EPBlocks.LIGHT_GRAY_BAUXITE.get(),
                    block -> createBauxiteOreDrops(EPBlocks.LIGHT_GRAY_BAUXITE.get(), EPItems.LIGHT_GRAY_TERRACOTTA_SHARD.get()));
            this.add(EPBlocks.BROWN_BAUXITE.get(),
                    block -> createBauxiteOreDrops(EPBlocks.BROWN_BAUXITE.get(), EPItems.BROWN_TERRACOTTA_SHARD.get()));
            this.add(EPBlocks.RED_BAUXITE.get(),
                    block -> createBauxiteOreDrops(EPBlocks.RED_BAUXITE.get(), EPItems.RED_TERRACOTTA_SHARD.get()));
            this.add(EPBlocks.ORANGE_BAUXITE.get(),
                    block -> createBauxiteOreDrops(EPBlocks.ORANGE_BAUXITE.get(), EPItems.ORANGE_TERRACOTTA_SHARD.get()));
            this.add(EPBlocks.YELLOW_BAUXITE.get(),
                    block -> createBauxiteOreDrops(EPBlocks.YELLOW_BAUXITE.get(), EPItems.YELLOW_TERRACOTTA_SHARD.get()));

        //Raw ore blocks
        this.add(EPBlocks.RAW_TIN_BLOCK.get(), block -> createRawMaterialBlockDrops(EPBlocks.RAW_TIN_BLOCK.get(), EPItems.RAW_TIN.get()));
        this.add(EPBlocks.RAW_ZINC_BLOCK.get(), block -> createRawMaterialBlockDrops(EPBlocks.RAW_ZINC_BLOCK.get(), EPItems.RAW_ZINC.get()));
        this.add(EPBlocks.RAW_SILVER_BLOCK.get(), block -> createRawMaterialBlockDrops(EPBlocks.RAW_SILVER_BLOCK.get(), EPItems.RAW_SILVER.get()));
        this.add(EPBlocks.RAW_ALUMINUM_BLOCK.get(), block -> createRawMaterialBlockDrops(EPBlocks.RAW_ALUMINUM_BLOCK.get(), EPItems.RAW_ALUMINUM.get()));

        //ore blocks
        this.dropSelf(EPBlocks.SULFUR_BLOCK.get());
        this.dropSelf(EPBlocks.SILVER_BLOCK.get());
        this.dropSelf(EPBlocks.ALUMINUM_BLOCK.get());
        this.dropSelf(EPBlocks.TIN_BLOCK.get());
        this.dropSelf(EPBlocks.ZINC_BLOCK.get());
        this.dropSelf(EPBlocks.BRASS_BLOCK.get());
        this.dropSelf(EPBlocks.BRONZE_BLOCK.get());
        this.dropSelf(EPBlocks.ROSE_GOLD_BLOCK.get());
        this.dropSelf(EPBlocks.BRONZIUM_BLOCK.get());
        this.dropSelf(EPBlocks.STEEL_BLOCK.get());
        this.dropSelf(EPBlocks.GREEN_GOLD_BLOCK.get());
        this.dropSelf(EPBlocks.BLUE_GOLD_BLOCK.get());

        //Calibrated quartz
        this.dropSelf(EPBlocks.CALIBRATED_QUARTZ_BLOCK.get());
        this.dropSelf(EPBlocks.SMOOTH_CALIBRATED_QUARTZ_BLOCK.get());
        this.dropSelf(EPBlocks.CHISELED_CALIBRATED_QUARTZ_BLOCK.get());
        this.dropSelf(EPBlocks.CALIBRATED_QUARTZ_PILLAR.get());
        this.dropSelf(EPBlocks.CALIBRATED_QUARTZ_BRICKS.get());

        //Tree drops
            //walnut
            this.dropSelf(EPBlocks.WALNUT_SAPLING.get());
            this.dropSelf(EPBlocks.WALNUT_LOG.get());
            this.dropSelf(EPBlocks.STRIPPED_WALNUT_LOG.get());
            this.dropSelf(EPBlocks.WALNUT_WOOD.get());
            this.dropSelf(EPBlocks.STRIPPED_WALNUT_WOOD.get());

            this.add(EPBlocks.WALNUT_LEAVES.get(), block ->
                    createLeavesWithExternalFruitDrops(block, EPBlocks.WALNUT_SAPLING.get(), EPItems.WALNUT.get(), 4));

            this.dropSelf(EPBlocks.WALNUT_PLANKS.get());

            this.add(EPBlocks.WALNUT_DOOR.get(), block ->
                    createDoorTable(EPBlocks.WALNUT_DOOR.get()));

            this.dropSelf(EPBlocks.WALNUT_TRAPDOOR.get());

            this.dropSelf(EPBlocks.WALNUT_BUTTON.get());

            this.dropSelf(EPBlocks.WALNUT_PRESSURE_PLATE.get());

            this.dropSelf(EPBlocks.WALNUT_STAIRS.get());
            this.add(EPBlocks.WALNUT_SLAB.get(), block ->
                    createSlabItemTable(EPBlocks.WALNUT_SLAB.get()));

            this.dropSelf(EPBlocks.WALNUT_FENCE.get());
            this.dropSelf(EPBlocks.WALNUT_FENCEGATE.get());

            this.add(EPBlocks.WALNUT_SIGN.get(),
                    block -> createSingleItemTable(EPBlocks.WALNUT_SIGN.get()));
            this.add(EPBlocks.WALNUT_WALL_SIGN.get(),
                    block -> createSingleItemTable(EPBlocks.WALNUT_SIGN.get()));

            this.add(EPBlocks.WALNUT_HANGING_SIGN.get(),
                    block -> createSingleItemTable(EPBlocks.WALNUT_HANGING_SIGN.get()));
            this.add(EPBlocks.WALNUT_WALL_HANGING_SIGN.get(),
                    block -> createSingleItemTable(EPBlocks.WALNUT_HANGING_SIGN.get()));

            //Apple
            this.dropSelf(EPBlocks.APPLE_SAPLING.get());
            this.dropSelf(EPBlocks.GREEN_APPLE_SAPLING.get());
            this.dropSelf(EPBlocks.APPLE_LOG.get());
            this.dropSelf(EPBlocks.STRIPPED_APPLE_LOG.get());
            this.dropSelf(EPBlocks.APPLE_WOOD.get());
            this.dropSelf(EPBlocks.STRIPPED_APPLE_WOOD.get());

            this.add(EPBlocks.APPLE_LEAVES.get(),
                    block -> createLeavesWithFruitDrops(block, EPBlocks.APPLE_SAPLING.get(), Items.APPLE));
            this.add(EPBlocks.APPLE_LEAVES_WITH_FRUIT.get(),
                    block -> createLeavesWithExternalFruitDrops(block, EPBlocks.APPLE_SAPLING.get(), Items.APPLE, 2));
            this.add(EPBlocks.GREEN_APPLE_LEAVES.get(),
                    block -> createLeavesWithFruitDrops(block, EPBlocks.GREEN_APPLE_SAPLING.get(), EPItems.GREEN_APPLE.get()));
            this.add(EPBlocks.GREEN_APPLE_LEAVES_WITH_FRUIT.get(),
                    block -> createLeavesWithExternalFruitDrops(block, EPBlocks.GREEN_APPLE_SAPLING.get(), EPItems.GREEN_APPLE.get(), 2));

            this.dropSelf(EPBlocks.APPLE_PLANKS.get());

            this.add(EPBlocks.APPLE_DOOR.get(),
                    block -> createDoorTable(EPBlocks.APPLE_DOOR.get()));

            this.dropSelf(EPBlocks.APPLE_TRAPDOOR.get());

            this.dropSelf(EPBlocks.APPLE_BUTTON.get());

            this.dropSelf(EPBlocks.APPLE_PRESSURE_PLATE.get());

            this.dropSelf(EPBlocks.APPLE_STAIRS.get());
            this.add(EPBlocks.APPLE_SLAB.get(),
                    block -> createSlabItemTable(EPBlocks.APPLE_SLAB.get()));

            this.dropSelf(EPBlocks.APPLE_FENCE.get());
            this.dropSelf(EPBlocks.APPLE_FENCEGATE.get());

            this.add(EPBlocks.APPLE_SIGN.get(),
                    block -> createSingleItemTable(EPBlocks.APPLE_SIGN.get()));
            this.add(EPBlocks.APPLE_WALL_SIGN.get(),
                    block -> createSingleItemTable(EPBlocks.APPLE_SIGN.get()));

            this.add(EPBlocks.APPLE_HANGING_SIGN.get(),
                    block -> createSingleItemTable(EPBlocks.APPLE_HANGING_SIGN.get()));
            this.add(EPBlocks.APPLE_WALL_HANGING_SIGN.get(),
                    block -> createSingleItemTable(EPBlocks.APPLE_HANGING_SIGN.get()));

            //Orange
            this.dropSelf(EPBlocks.ORANGE_SAPLING.get());
            this.dropSelf(EPBlocks.ORANGE_LOG.get());
            this.dropSelf(EPBlocks.STRIPPED_ORANGE_LOG.get());
            this.dropSelf(EPBlocks.ORANGE_WOOD.get());
            this.dropSelf(EPBlocks.STRIPPED_ORANGE_WOOD.get());

            this.add(EPBlocks.ORANGE_LEAVES.get(),
                    block -> createLeavesWithFruitDrops(block, EPBlocks.ORANGE_SAPLING.get(), EPItems.ORANGE.get()));
            this.add(EPBlocks.ORANGE_LEAVES_WITH_FRUIT.get(),
                    block -> createLeavesWithExternalFruitDrops(block, EPBlocks.ORANGE_SAPLING.get(), EPItems.ORANGE.get(), 3));

            this.dropSelf(EPBlocks.ORANGE_PLANKS.get());

            this.add(EPBlocks.ORANGE_DOOR.get(),
                    block -> createDoorTable(EPBlocks.ORANGE_DOOR.get()));

            this.dropSelf(EPBlocks.ORANGE_TRAPDOOR.get());

            this.dropSelf(EPBlocks.ORANGE_BUTTON.get());

            this.dropSelf(EPBlocks.ORANGE_PRESSURE_PLATE.get());

            this.dropSelf(EPBlocks.ORANGE_STAIRS.get());
            this.add(EPBlocks.ORANGE_SLAB.get(),
                    block -> createSlabItemTable(EPBlocks.ORANGE_SLAB.get()));

            this.dropSelf(EPBlocks.ORANGE_FENCE.get());
            this.dropSelf(EPBlocks.ORANGE_FENCEGATE.get());

            this.add(EPBlocks.ORANGE_SIGN.get(),
                    block -> createSingleItemTable(EPBlocks.ORANGE_SIGN.get()));
            this.add(EPBlocks.ORANGE_WALL_SIGN.get(),
                    block -> createSingleItemTable(EPBlocks.ORANGE_SIGN.get()));

            this.add(EPBlocks.ORANGE_HANGING_SIGN.get(),
                    block -> createSingleItemTable(EPBlocks.ORANGE_HANGING_SIGN.get()));
            this.add(EPBlocks.ORANGE_WALL_HANGING_SIGN.get(),
                    block -> createSingleItemTable(EPBlocks.ORANGE_HANGING_SIGN.get()));

            //Lemon
            this.dropSelf(EPBlocks.LEMON_SAPLING.get());
            this.dropSelf(EPBlocks.LEMON_LOG.get());
            this.dropSelf(EPBlocks.STRIPPED_LEMON_LOG.get());
            this.dropSelf(EPBlocks.LEMON_WOOD.get());
            this.dropSelf(EPBlocks.STRIPPED_LEMON_WOOD.get());

            this.add(EPBlocks.LEMON_LEAVES.get(),
                    block -> createLeavesWithFruitDrops(block, EPBlocks.LEMON_SAPLING.get(), EPItems.LEMON.get()));
            this.add(EPBlocks.LEMON_LEAVES_WITH_FRUIT.get(),
                    block -> createLeavesWithExternalFruitDrops(block, EPBlocks.LEMON_SAPLING.get(), EPItems.LEMON.get(), 2));

            this.dropSelf(EPBlocks.LEMON_PLANKS.get());

            this.add(EPBlocks.LEMON_DOOR.get(),
                    block -> createDoorTable(EPBlocks.LEMON_DOOR.get()));

            this.dropSelf(EPBlocks.LEMON_TRAPDOOR.get());

            this.dropSelf(EPBlocks.LEMON_BUTTON.get());

            this.dropSelf(EPBlocks.LEMON_PRESSURE_PLATE.get());

            this.dropSelf(EPBlocks.LEMON_STAIRS.get());
            this.add(EPBlocks.LEMON_SLAB.get(),
                    block -> createSlabItemTable(EPBlocks.LEMON_SLAB.get()));

            this.dropSelf(EPBlocks.LEMON_FENCE.get());
            this.dropSelf(EPBlocks.LEMON_FENCEGATE.get());

            this.add(EPBlocks.LEMON_SIGN.get(),
                    block -> createSingleItemTable(EPBlocks.LEMON_SIGN.get()));
            this.add(EPBlocks.LEMON_WALL_SIGN.get(),
                    block -> createSingleItemTable(EPBlocks.LEMON_SIGN.get()));

            this.add(EPBlocks.LEMON_HANGING_SIGN.get(),
                    block -> createSingleItemTable(EPBlocks.LEMON_HANGING_SIGN.get()));
            this.add(EPBlocks.LEMON_WALL_HANGING_SIGN.get(),
                    block -> createSingleItemTable(EPBlocks.LEMON_HANGING_SIGN.get()));

            //Lime
            this.dropSelf(EPBlocks.LIME_SAPLING.get());
            this.add(EPBlocks.LIME_LEAVES.get(),
                    block -> createLeavesWithFruitDrops(block, EPBlocks.LIME_SAPLING.get(), EPItems.LIME_FRUIT.get()));
            this.add(EPBlocks.LIME_LEAVES_WITH_FRUIT.get(),
                    block -> createLeavesWithExternalFruitDrops(block, EPBlocks.LIME_SAPLING.get(), EPItems.LIME_FRUIT.get(), 2));

        //Crops
            //Yerba mate
            this.add(EPBlocks.YERBA_MATE_CROP.get(), createCropDrops(EPBlocks.YERBA_MATE_CROP.get(), EPItems.YERBA_MATE.get(),
                EPItems.YERBA_MATE_SEEDS.get(), YERBA_MATE_BUILDER));

            //Zapallo
            this.add(EPBlocks.ZAPALLO_CROP.get(), createCropWithRotDrops(EPItems.ZAPALLO.get(), EPItems.ROTTEN_ZAPALLO.get(),
                EPItems.ZAPALLO_SEEDS.get(), ZAPALLO_BUILDER));

            //Eggplant
            this.add(EPBlocks.EGGPLANT_CROP.get(), createCropWithRotDrops(EPItems.EGGPLANT.get(), EPItems.ROTTEN_EGGPLANT.get(),
                EPItems.EGGPLANT_SEEDS.get(), EGGPLANT_BUILDER));

            //Tomato
            this.add(EPBlocks.TOMATO_CROP.get(), createCropWithRotDrops(EPItems.TOMATO.get(), EPItems.ROTTEN_TOMATO.get(),
                EPItems.TOMATO_SEEDS.get(), TOMATO_BUILDER));

            //Corn
            this.add(EPBlocks.CORN_CROP.get(), createCropWithRotDrops(EPItems.CORN.get(), EPItems.ROTTEN_CORN.get(),
                 EPItems.CORN_SEEDS.get(), CORN_BUILDER));

        //Wild crops
        this.add(EPBlocks.WILD_WHEAT_CROP.get(), createPlantWithSeedsDrops(EPBlocks.WILD_WHEAT_CROP.get(), Items.WHEAT_SEEDS, 2, 0.125f));
        this.add(EPBlocks.WILD_TOMATO_CROP.get(), createPlantWithSeedsDrops(EPBlocks.WILD_TOMATO_CROP.get(), EPItems.WILD_TOMATO.get(), 2, 0.25f));
        this.add(EPBlocks.WILD_CORN_CROP.get(), createPlantWithSeedsDrops(EPBlocks.WILD_CORN_CROP.get(), EPItems.WILD_CORN.get(), 2, 0.25f));

        //Plants
        this.add(EPBlocks.SMALL_REEDS.get(), createPlantWithSeedsDrops(EPBlocks.SMALL_REEDS.get(), EPItems.REEDS_HEAD.get(), 2, 0.25f));
        this.add(EPBlocks.REEDS.get(), createPlantWithSeedsDrops(EPBlocks.REEDS.get(), EPItems.REEDS_HEAD.get(), 2, 0.25f));
        this.add(EPBlocks.KENAF.get(), createPlantWithSeedsDrops(EPBlocks.KENAF.get(), EPItems.KENAF_BRANCH.get(), 3, 0.25f));
        this.add(EPBlocks.TALL_REEDS.get(), createPlantWithSeedsDrops(EPBlocks.TALL_REEDS.get(), EPItems.TALL_REEDS_HEAD.get(), 3, 0.25f));
        this.add(EPBlocks.WATER_REEDS.get(), createPlantWithSeedsDrops(EPBlocks.WATER_REEDS.get(), EPItems.WATER_REEDS_HEAD.get(), 4, 0.125f));

        //Flowers
        this.add(EPBlocks.COLD_LYRIUM.get(), block -> createFlowerDrops(block, 1));
        this.add(EPBlocks.POTTED_COLD_LYRIUM.get(), createPotFlowerItemTable(EPBlocks.COLD_LYRIUM.get()));

        this.add(EPBlocks.SUCCULENT.get(), block -> createFlowerDrops(block, 2));
        this.add(EPBlocks.POTTED_SUCCULENT.get(), createPotFlowerItemTable(EPBlocks.SUCCULENT.get()));

        //Entity blocks
        this.dropSelf(EPBlocks.ADOBE_FURNACE.get());
        this.dropSelf(EPBlocks.SOUL_FURNACE.get());

        this.dropSelf(EPBlocks.MASONRY_FURNACE.get());

        this.dropSelf(EPBlocks.ADOBE_ALLOY_FURNACE.get());
        this.dropSelf(EPBlocks.SUPER_ALLOY_FURNACE.get());
        this.dropSelf(EPBlocks.SOUL_ALLOY_FURNACE.get());

        this.dropSelf(EPBlocks.GEM_POLISHER.get());

        this.dropSelf(EPBlocks.PRIMAL_GRINDER.get());
        this.dropSelf(EPBlocks.MECHANICAL_GRINDER.get());

        this.dropSelf(EPBlocks.ALCHEMICAL_DUPLICATOR.get());

        this.dropSelf(EPBlocks.LEATHERWORKER_STATION.get());

        this.dropSelf(EPBlocks.GROWTH_DETECTOR.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return EPBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
