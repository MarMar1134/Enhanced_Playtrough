package net.marmar.enhanced_playthrough.data.loot;

import net.marmar.enhanced_playthrough.block.ModBlocks;
import net.marmar.enhanced_playthrough.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider implements ILootTableBuilders {
    public ModBlockLootTables(){
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        //Stone
        this.dropSelf(ModBlocks.STONE_WALL.get());

        //D, A, G
        this.dropSelf(ModBlocks.POLISHED_DIORITE_WALL.get());
        this.dropSelf(ModBlocks.POLISHED_ANDESITE_WALL.get());
        this.dropSelf(ModBlocks.POLISHED_GRANITE_WALL.get());

        //Dripstone
        this.add(ModBlocks.DRIPSTONE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.DRIPSTONE_SLAB.get()));
        this.dropSelf(ModBlocks.DRIPSTONE_STAIRS.get());
        this.dropSelf(ModBlocks.DRIPSTONE_WALL.get());

        //Calcite
        this.add(ModBlocks.CALCITE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CALCITE_SLAB.get()));
        this.dropSelf(ModBlocks.CALCITE_STAIRS.get());
        this.dropSelf(ModBlocks.CALCITE_WALL.get());

        //Polished stone
        this.dropSelf(ModBlocks.POLISHED_STONE.get());
        this.add(ModBlocks.POLISHED_STONE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.POLISHED_STONE_SLAB.get()));
        this.dropSelf(ModBlocks.POLISHED_STONE_STAIRS.get());
        this.dropSelf(ModBlocks.POLISHED_STONE_WALL.get());

        //Cobbled limestone
        this.add(ModBlocks.COBBLED_LIMESTONE.get(), block ->
                createRockDrops(ModBlocks.COBBLED_LIMESTONE.get(), ModBlocks.COBBLED_LIMESTONE.get(), ModItems.LIMESTONE_COBBLE.get()));
        this.add(ModBlocks.COBBLED_LIMESTONE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.COBBLED_LIMESTONE_SLAB.get()));
        this.dropSelf(ModBlocks.COBBLED_LIMESTONE_STAIRS.get());
        this.dropSelf(ModBlocks.COBBLED_LIMESTONE_WALL.get());

        //Limestone
        this.add(ModBlocks.LIMESTONE.get(), block ->
                        createRockDrops(ModBlocks.LIMESTONE.get(), ModBlocks.COBBLED_LIMESTONE.get(), ModItems.LIMESTONE_COBBLE.get()));
        this.add(ModBlocks.LIMESTONE_SLAB.get(), block ->
                createSlabItemTable(ModBlocks.LIMESTONE_SLAB.get()));
        this.dropSelf(ModBlocks.LIMESTONE_STAIRS.get());
        this.dropSelf(ModBlocks.LIMESTONE_WALL.get());

        //Polished limestone
        this.dropSelf(ModBlocks.POLISHED_LIMESTONE.get());
        this.add(ModBlocks.POLISHED_LIMESTONE_SLAB.get(), block ->
                createSlabItemTable(ModBlocks.POLISHED_LIMESTONE_SLAB.get()));
        this.dropSelf(ModBlocks.POLISHED_LIMESTONE_STAIRS.get());
        this.dropSelf(ModBlocks.POLISHED_LIMESTONE_WALL.get());

        //Limestone bricks
        this.dropSelf(ModBlocks.LIMESTONE_BRICKS.get());
        this.add(ModBlocks.LIMESTONE_BRICK_SLAB.get(), block ->
                createSlabItemTable(ModBlocks.LIMESTONE_BRICK_SLAB.get()));
        this.dropSelf(ModBlocks.LIMESTONE_BRICK_STAIRS.get());
        this.dropSelf(ModBlocks.LIMESTONE_BRICK_WALL.get());

        //Soul
        this.dropSelf(ModBlocks.SOUL_MUD.get());
        this.dropSelf(ModBlocks.SOUL_MUD_BRICKS.get());
        this.add(ModBlocks.SOUL_MUD_BRICK_SLAB.get(), block ->
                createSlabItemTable(ModBlocks.SOUL_MUD_BRICK_SLAB.get()));
        this.dropSelf(ModBlocks.SOUL_MUD_BRICK_STAIRS.get());
        this.dropSelf(ModBlocks.SOUL_MUD_BRICK_WALL.get());

        //ores
        this.add(ModBlocks.NETHER_COPPER_ORE.get(), block ->
                createNetherOreDrops(ModBlocks.NETHER_COPPER_ORE.get(), 2, 5, Items.RAW_COPPER));

        this.add(ModBlocks.TIN_ORE.get(), block ->
                createOreDrops(ModBlocks.TIN_ORE.get(), 1, 4, ModItems.RAW_TIN.get()));
        this.add(ModBlocks.DEEPSLATE_TIN_ORE.get(), block ->
                createDeepslateOreDrops(ModBlocks.TIN_ORE.get(), 2, 6, ModItems.RAW_TIN.get()));

        this.add(ModBlocks.ZINC_ORE.get(), block ->
                createOreDrops(ModBlocks.ZINC_ORE.get(), 1, 3, ModItems.RAW_ZINC.get()));
        this.add(ModBlocks.DEEPSLATE_ZINC_ORE.get(), block ->
                createDeepslateOreDrops(ModBlocks.ZINC_ORE.get(), 2, 5, ModItems.RAW_ZINC.get()));
        this.add(ModBlocks.NETHER_ZINC_ORE.get(), block ->
                createOreDrops(ModBlocks.ZINC_ORE.get(), 3, 7, ModItems.RAW_ZINC.get()));

        this.add(ModBlocks.SULFUR_ORE.get(), block ->
                createOreDrops(ModBlocks.SULFUR_ORE.get(), 2, 5, ModItems.SULFUR.get()));
        this.add(ModBlocks.DEEPSLATE_SULFUR_ORE.get(), block ->
                createDeepslateOreDrops(ModBlocks.DEEPSLATE_SULFUR_ORE.get(), 3, 7, ModItems.SULFUR.get()));
        this.add(ModBlocks.NETHER_SULFUR_ORE.get(), block ->
                createNetherOreDrops(ModBlocks.NETHER_SULFUR_ORE.get(), 4, 9, ModItems.SULFUR.get()));

        this.add(ModBlocks.SILVER_ORE.get(), block ->
                createOreDrops(ModBlocks.SILVER_ORE.get(), ModItems.RAW_SILVER.get()));
        this.add(ModBlocks.DEEPSLATE_SILVER_ORE.get(), block ->
                createDeepslateOreDrops(ModBlocks.DEEPSLATE_SILVER_ORE.get(), ModItems.RAW_SILVER.get()));

        this.add(ModBlocks.RUBY_ORE.get(),
                block -> createGemsDrops(ModBlocks.RUBY_ORE.get(), ModItems.RAW_RUBY.get(), 2, ModItems.RUBY.get(), 1));
        this.add(ModBlocks.DEEPSLATE_RUBY_ORE.get(),
                block -> createDeepslateGemsDrops(ModBlocks.DEEPSLATE_RUBY_ORE.get(), ModItems.RAW_RUBY.get(), 3, ModItems.RUBY.get(), 2));

        this.add(ModBlocks.SAPPHIRE_ORE.get(),
                block -> createGemsDrops(ModBlocks.SAPPHIRE_ORE.get(), ModItems.RAW_SAPPHIRE.get(), 3, ModItems.SAPPHIRE.get(), 2));
        this.add(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get(),
                block -> createDeepslateGemsDrops(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get(), ModItems.RAW_SAPPHIRE.get(), 4, ModItems.SAPPHIRE.get(), 3));

        this.add(ModBlocks.NETHER_GARNET_ORE.get(),
                block -> createNetherGemsDrops(ModBlocks.NETHER_GARNET_ORE.get(), ModItems.RAW_GARNET.get(), 2, ModItems.GARNET.get(), 1));

        this.add(ModBlocks.COBALT_ORE.get(),
                block -> createOreDrops(ModBlocks.COBALT_ORE.get(), ModItems.COBALT.get()));
        this.add(ModBlocks.DEEPSLATE_COBALT_ORE.get(),
                block -> createDeepslateOreDrops(ModBlocks.DEEPSLATE_COBALT_ORE.get(), ModItems.COBALT.get()));

        //ore blocks
        this.dropSelf(ModBlocks.SILVER_BLOCK.get());
        this.dropSelf(ModBlocks.TIN_BLOCK.get());
        this.dropSelf(ModBlocks.ZINC_BLOCK.get());
        this.dropSelf(ModBlocks.BRASS_BLOCK.get());
        this.dropSelf(ModBlocks.BRONZE_BLOCK.get());
        this.dropSelf(ModBlocks.ROSE_GOLD_BLOCK.get());
        this.dropSelf(ModBlocks.BRONZIUM_BLOCK.get());
        this.dropSelf(ModBlocks.STEEL_BLOCK.get());
        this.dropSelf(ModBlocks.GREEN_GOLD_BLOCK.get());
        this.dropSelf(ModBlocks.BLUE_GOLD_BLOCK.get());

        //Tree drops
            //walnut
            this.dropSelf(ModBlocks.WALNUT_SAPLING.get());
            this.dropSelf(ModBlocks.WALNUT_LOG.get());
            this.dropSelf(ModBlocks.STRIPPED_WALNUT_LOG.get());
            this.dropSelf(ModBlocks.WALNUT_WOOD.get());
            this.dropSelf(ModBlocks.STRIPPED_WALNUT_WOOD.get());

            this.add(ModBlocks.WALNUT_LEAVES.get(), block ->
                    createLeavesWithFruitDrops(block, ModBlocks.WALNUT_SAPLING.get(), ModItems.WALNUT.get(), 4));

            this.dropSelf(ModBlocks.WALNUT_PLANKS.get());

            this.add(ModBlocks.WALNUT_DOOR.get(), block ->
                    createDoorTable(ModBlocks.WALNUT_DOOR.get()));

            this.dropSelf(ModBlocks.WALNUT_TRAPDOOR.get());

            this.dropSelf(ModBlocks.WALNUT_BUTTON.get());

            this.dropSelf(ModBlocks.WALNUT_PRESSURE_PLATE.get());

            this.dropSelf(ModBlocks.WALNUT_STAIRS.get());
            this.add(ModBlocks.WALNUT_SLAB.get(), block ->
                    createSlabItemTable(ModBlocks.WALNUT_SLAB.get()));

            this.dropSelf(ModBlocks.WALNUT_FENCE.get());
            this.dropSelf(ModBlocks.WALNUT_FENCEGATE.get());

            this.add(ModBlocks.WALNUT_SIGN.get(),
                    block -> createSingleItemTable(ModBlocks.WALNUT_SIGN.get()));
            this.add(ModBlocks.WALNUT_WALL_SIGN.get(),
                    block -> createSingleItemTable(ModBlocks.WALNUT_SIGN.get()));

            this.add(ModBlocks.WALNUT_HANGING_SIGN.get(),
                    block -> createSingleItemTable(ModBlocks.WALNUT_HANGING_SIGN.get()));
            this.add(ModBlocks.WALNUT_WALL_HANGING_SIGN.get(),
                    block -> createSingleItemTable(ModBlocks.WALNUT_HANGING_SIGN.get()));

            //Apple
            this.dropSelf(ModBlocks.APPLE_SAPLING.get());
            this.dropSelf(ModBlocks.GREEN_APPLE_SAPLING.get());
            this.dropSelf(ModBlocks.APPLE_LOG.get());
            this.dropSelf(ModBlocks.STRIPPED_APPLE_LOG.get());
            this.dropSelf(ModBlocks.APPLE_WOOD.get());
            this.dropSelf(ModBlocks.STRIPPED_APPLE_WOOD.get());

            this.add(ModBlocks.APPLE_LEAVES.get(),
                    block -> createLeavesWithFruitDrops(block, ModBlocks.APPLE_SAPLING.get(), Items.APPLE));
            this.add(ModBlocks.GREEN_APPLE_LEAVES.get(),
                    block -> createLeavesWithFruitDrops(block, ModBlocks.GREEN_APPLE_SAPLING.get(), ModItems.GREEN_APPLE.get()));

            this.dropSelf(ModBlocks.APPLE_PLANKS.get());

            this.add(ModBlocks.APPLE_DOOR.get(),
                    block -> createDoorTable(ModBlocks.APPLE_DOOR.get()));

            this.dropSelf(ModBlocks.APPLE_TRAPDOOR.get());

            this.dropSelf(ModBlocks.APPLE_BUTTON.get());

            this.dropSelf(ModBlocks.APPLE_PRESSURE_PLATE.get());

            this.dropSelf(ModBlocks.APPLE_STAIRS.get());
            this.add(ModBlocks.APPLE_SLAB.get(),
                    block -> createSlabItemTable(ModBlocks.APPLE_SLAB.get()));

            this.dropSelf(ModBlocks.APPLE_FENCE.get());
            this.dropSelf(ModBlocks.APPLE_FENCEGATE.get());

            this.add(ModBlocks.APPLE_SIGN.get(),
                    block -> createSingleItemTable(ModBlocks.APPLE_SIGN.get()));
            this.add(ModBlocks.APPLE_WALL_SIGN.get(),
                    block -> createSingleItemTable(ModBlocks.APPLE_SIGN.get()));

            this.add(ModBlocks.APPLE_HANGING_SIGN.get(),
                    block -> createSingleItemTable(ModBlocks.APPLE_HANGING_SIGN.get()));
            this.add(ModBlocks.APPLE_WALL_HANGING_SIGN.get(),
                    block -> createSingleItemTable(ModBlocks.APPLE_HANGING_SIGN.get()));

            //Orange
            this.dropSelf(ModBlocks.ORANGE_SAPLING.get());
            this.dropSelf(ModBlocks.ORANGE_LOG.get());
            this.dropSelf(ModBlocks.STRIPPED_ORANGE_LOG.get());
            this.dropSelf(ModBlocks.ORANGE_WOOD.get());
            this.dropSelf(ModBlocks.STRIPPED_ORANGE_WOOD.get());

            this.add(ModBlocks.ORANGE_LEAVES.get(),
                    block -> createLeavesWithFruitDrops(block, ModBlocks.ORANGE_SAPLING.get(), ModItems.ORANGE.get(), 3));

            this.dropSelf(ModBlocks.ORANGE_PLANKS.get());

            this.add(ModBlocks.ORANGE_DOOR.get(),
                    block -> createDoorTable(ModBlocks.ORANGE_DOOR.get()));

            this.dropSelf(ModBlocks.ORANGE_TRAPDOOR.get());

            this.dropSelf(ModBlocks.ORANGE_BUTTON.get());

            this.dropSelf(ModBlocks.ORANGE_PRESSURE_PLATE.get());

            this.dropSelf(ModBlocks.ORANGE_STAIRS.get());
            this.add(ModBlocks.ORANGE_SLAB.get(),
                    block -> createSlabItemTable(ModBlocks.ORANGE_SLAB.get()));

            this.dropSelf(ModBlocks.ORANGE_FENCE.get());
            this.dropSelf(ModBlocks.ORANGE_FENCEGATE.get());

            this.add(ModBlocks.ORANGE_SIGN.get(),
                    block -> createSingleItemTable(ModBlocks.ORANGE_SIGN.get()));
            this.add(ModBlocks.ORANGE_WALL_SIGN.get(),
                    block -> createSingleItemTable(ModBlocks.ORANGE_SIGN.get()));

            this.add(ModBlocks.ORANGE_HANGING_SIGN.get(),
                    block -> createSingleItemTable(ModBlocks.ORANGE_HANGING_SIGN.get()));
            this.add(ModBlocks.ORANGE_WALL_HANGING_SIGN.get(),
                    block -> createSingleItemTable(ModBlocks.ORANGE_HANGING_SIGN.get()));

            //Lemon
            this.dropSelf(ModBlocks.LEMON_SAPLING.get());
            this.dropSelf(ModBlocks.LEMON_LOG.get());
            this.dropSelf(ModBlocks.STRIPPED_LEMON_LOG.get());
            this.dropSelf(ModBlocks.LEMON_WOOD.get());
            this.dropSelf(ModBlocks.STRIPPED_LEMON_WOOD.get());

            this.add(ModBlocks.LEMON_LEAVES.get(),
                    block -> createLeavesWithFruitDrops(block, ModBlocks.LEMON_SAPLING.get(), ModItems.LEMON.get(), 2));

            this.dropSelf(ModBlocks.LEMON_PLANKS.get());

            this.add(ModBlocks.LEMON_DOOR.get(),
                    block -> createDoorTable(ModBlocks.LEMON_DOOR.get()));

            this.dropSelf(ModBlocks.LEMON_TRAPDOOR.get());

            this.dropSelf(ModBlocks.LEMON_BUTTON.get());

            this.dropSelf(ModBlocks.LEMON_PRESSURE_PLATE.get());

            this.dropSelf(ModBlocks.LEMON_STAIRS.get());
            this.add(ModBlocks.LEMON_SLAB.get(),
                    block -> createSlabItemTable(ModBlocks.LEMON_SLAB.get()));

            this.dropSelf(ModBlocks.LEMON_FENCE.get());
            this.dropSelf(ModBlocks.LEMON_FENCEGATE.get());

            this.add(ModBlocks.LEMON_SIGN.get(),
                    block -> createSingleItemTable(ModBlocks.LEMON_SIGN.get()));
            this.add(ModBlocks.LEMON_WALL_SIGN.get(),
                    block -> createSingleItemTable(ModBlocks.LEMON_SIGN.get()));

            this.add(ModBlocks.LEMON_HANGING_SIGN.get(),
                    block -> createSingleItemTable(ModBlocks.LEMON_HANGING_SIGN.get()));
            this.add(ModBlocks.LEMON_WALL_HANGING_SIGN.get(),
                    block -> createSingleItemTable(ModBlocks.LEMON_HANGING_SIGN.get()));

            //Lime
            this.dropSelf(ModBlocks.LIME_SAPLING.get());
            this.add(ModBlocks.LIME_LEAVES.get(),
                    block -> createLeavesWithFruitDrops(block, ModBlocks.LIME_SAPLING.get(), ModItems.LIME.get(), 2));

        //Crops
            //Yerba mate
            this.add(ModBlocks.YERBA_MATE_CROP.get(), createCropDrops(ModBlocks.YERBA_MATE_CROP.get(), ModItems.YERBA_MATE.get(),
                ModItems.YERBA_MATE_SEEDS.get(), YERBA_MATE_BUILDER));

            //Zapallo
            this.add(ModBlocks.ZAPALLO_CROP.get(), createCropDrops(ModBlocks.ZAPALLO_CROP.get(), ModItems.ZAPALLO.get(),
                ModItems.ZAPALLO_SEEDS.get(), ZAPALLO_BUILDER));

            //Eggplant
            this.add(ModBlocks.EGGPLANT_CROP.get(), createCropDrops(ModBlocks.EGGPLANT_CROP.get(), ModItems.EGGPLANT.get(),
                ModItems.EGGPLANT_SEEDS.get(), EGGPLANT_BUILDER));

            //Tomato
            this.add(ModBlocks.TOMATO_CROP.get(), createCropDrops(ModBlocks.TOMATO_CROP.get(), ModItems.TOMATO.get(),
                ModItems.TOMATO_SEEDS.get(), TOMATO_BUILDER));

            //Corn
            this.add(ModBlocks.CORN_CROP.get(), createCropDrops(ModBlocks.CORN_CROP.get(), ModItems.CORN.get(),
                 ModItems.CORN_SEEDS.get(), CORN_BUILDER));

        //Wild crops
        this.add(ModBlocks.WILD_WHEAT.get(), block -> createPlantWithSeedsDrops(ModBlocks.WILD_WHEAT.get(), Items.WHEAT_SEEDS, 2, 0.125f));
        this.add(ModBlocks.WILD_TOMATO.get(), block -> createPlantWithSeedsDrops(ModBlocks.WILD_TOMATO.get(), ModItems.WILD_TOMATO.get(), 2, 0.25f));
        this.add(ModBlocks.WILD_CORN.get(), block -> createPlantWithSeedsDrops(ModBlocks.WILD_CORN.get(), ModItems.WILD_CORN.get(), 2, 0.25f));

        //Plants
        this.add(ModBlocks.TALL_REEDS.get(), block ->
                createPlantWithSeedsDrops(ModBlocks.TALL_REEDS.get(), ModItems.REED_HEAD.get(), 3, 0.25f));
        this.add(ModBlocks.REEDS.get(), block ->
                createPlantWithSeedsDrops(ModBlocks.REEDS.get(), ModItems.REED_HEAD.get(), 2, 0.25f));
        this.add(ModBlocks.SMALL_REEDS.get(), block ->
                createPlantWithSeedsDrops(ModBlocks.SMALL_REEDS.get(), ModItems.REED_HEAD.get(), 2, 0.25f));
        this.add(ModBlocks.WATER_REEDS.get(), block ->
                createPlantWithSeedsDrops(ModBlocks.WATER_REEDS.get(), ModItems.WATER_REED_HEAD.get(), 4, 0.125f));

         //Entity blocks
        this.dropSelf(ModBlocks.ADOBE_FURNACE.get());
        this.dropSelf(ModBlocks.SOUL_FURNACE.get());

        this.dropSelf(ModBlocks.MASONRY_FURNACE.get());

        this.dropSelf(ModBlocks.ADOBE_ALLOYING_FURNACE.get());
        this.dropSelf(ModBlocks.SUPER_ALLOYING_FURNACE.get());
        this.dropSelf(ModBlocks.SOUL_ALLOY_FURNACE.get());

        this.dropSelf(ModBlocks.GEM_POLISHER.get());

        this.dropSelf(ModBlocks.PRIMAL_GRINDER.get());
        this.dropSelf(ModBlocks.MECHANICAL_GRINDER.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
