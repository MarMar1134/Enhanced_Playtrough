package net.marmar.enhanced_playthrough.data.tag;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.block.EPBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

@SuppressWarnings("unchecked")
public class EPBlockTagGenerator extends BlockTagsProvider {

    public EPBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, EnhancedPlaythrough.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(BlockTags.SAPLINGS).add(
                EPBlocks.WALNUT_SAPLING.get(),
                EPBlocks.APPLE_SAPLING.get(),
                EPBlocks.GREEN_APPLE_SAPLING.get(),
                EPBlocks.ORANGE_SAPLING.get(),
                EPBlocks.LEMON_SAPLING.get(),
                EPBlocks.LIME_SAPLING.get()
        );

        this.tag(BlockTags.SMALL_FLOWERS).add(
                EPBlocks.COLD_LYRIUM.get(),
                EPBlocks.SUCCULENT.get()
        );

        this.tag(EPTags.Blocks.DESERT_FLOWER_BASE).add(
                Blocks.DIRT,
                Blocks.GRASS_BLOCK,
                Blocks.SAND,
                Blocks.RED_SAND
        );

        this.tag(BlockTags.SLABS).add(
                EPBlocks.POLISHED_STONE_SLAB.get(),
                EPBlocks.COBBLED_LIMESTONE_SLAB.get(),
                EPBlocks.LIMESTONE_SLAB.get(),
                EPBlocks.POLISHED_LIMESTONE_SLAB.get(),
                EPBlocks.LIMESTONE_BRICK_SLAB.get(),
                EPBlocks.SOUL_MUD_BRICK_SLAB.get(),
                EPBlocks.FIREBRICK_SLAB.get(),
                EPBlocks.WALNUT_SLAB.get(),
                EPBlocks.APPLE_SLAB.get(),
                EPBlocks.ORANGE_SLAB.get(),
                EPBlocks.LEMON_SLAB.get()

        );

        this.tag(BlockTags.STAIRS).add(
                EPBlocks.POLISHED_STONE_STAIRS.get(),
                EPBlocks.COBBLED_LIMESTONE_STAIRS.get(),
                EPBlocks.LIMESTONE_STAIRS.get(),
                EPBlocks.POLISHED_LIMESTONE_STAIRS.get(),
                EPBlocks.LIMESTONE_BRICK_STAIRS.get(),
                EPBlocks.SOUL_MUD_BRICK_STAIRS.get(),
                EPBlocks.FIREBRICK_STAIRS.get(),
                EPBlocks.WALNUT_STAIRS.get(),
                EPBlocks.APPLE_STAIRS.get(),
                EPBlocks.ORANGE_STAIRS.get(),
                EPBlocks.LEMON_STAIRS.get()
        );

        this.tag(BlockTags.WALLS).add(
                EPBlocks.POLISHED_STONE_WALL.get(),
                EPBlocks.LIMESTONE_WALL.get(),
                EPBlocks.COBBLED_LIMESTONE_WALL.get(),
                EPBlocks.POLISHED_LIMESTONE_WALL.get(),
                EPBlocks.LIMESTONE_BRICK_WALL.get(),
                EPBlocks.SOUL_MUD_BRICK_WALL.get(),
                EPBlocks.FIREBRICK_WALL.get()
        );

        this.tag(BlockTags.FENCES).add(
                EPBlocks.WALNUT_FENCE.get(),
                EPBlocks.APPLE_FENCE.get(),
                EPBlocks.ORANGE_FENCE.get(),
                EPBlocks.LEMON_FENCE.get()
        );

        this.tag(BlockTags.FENCE_GATES).add(
                EPBlocks.WALNUT_FENCEGATE.get(),
                EPBlocks.APPLE_FENCEGATE.get(),
                EPBlocks.ORANGE_FENCEGATE.get(),
                EPBlocks.LEMON_FENCEGATE.get()
        );

        this.tag(BlockTags.WOODEN_BUTTONS).add(
                EPBlocks.WALNUT_BUTTON.get(),
                EPBlocks.APPLE_BUTTON.get(),
                EPBlocks.ORANGE_BUTTON.get(),
                EPBlocks.LEMON_BUTTON.get()
        );

        this.tag(BlockTags.WOODEN_PRESSURE_PLATES).add(
                EPBlocks.WALNUT_PRESSURE_PLATE.get(),
                EPBlocks.APPLE_PRESSURE_PLATE.get(),
                EPBlocks.ORANGE_PRESSURE_PLATE.get(),
                EPBlocks.LEMON_PRESSURE_PLATE.get()
        );

        this.tag(BlockTags.LOGS_THAT_BURN).add(
                //Walnut
                EPBlocks.WALNUT_LOG.get(),
                EPBlocks.STRIPPED_WALNUT_LOG.get(),
                EPBlocks.WALNUT_WOOD.get(),
                EPBlocks.STRIPPED_WALNUT_WOOD.get(),

                //Apple
                EPBlocks.APPLE_LOG.get(),
                EPBlocks.STRIPPED_APPLE_LOG.get(),
                EPBlocks.APPLE_WOOD.get(),
                EPBlocks.STRIPPED_APPLE_WOOD.get(),

                //Orange
                EPBlocks.ORANGE_LOG.get(),
                EPBlocks.STRIPPED_ORANGE_LOG.get(),
                EPBlocks.ORANGE_WOOD.get(),
                EPBlocks.STRIPPED_ORANGE_WOOD.get(),

                //Lemon
                EPBlocks.LEMON_LOG.get(),
                EPBlocks.STRIPPED_LEMON_LOG.get(),
                EPBlocks.LEMON_WOOD.get(),
                EPBlocks.STRIPPED_LEMON_WOOD.get()
        );

        this.tag(BlockTags.OVERWORLD_NATURAL_LOGS).add(
                EPBlocks.WALNUT_LOG.get(),
                EPBlocks.APPLE_LOG.get(),
                EPBlocks.ORANGE_LOG.get(),
                EPBlocks.LEMON_LOG.get()
        );

        this.tag(BlockTags.LEAVES).add(
                EPBlocks.WALNUT_LEAVES.get(),
                EPBlocks.APPLE_LEAVES.get(),
                EPBlocks.GREEN_APPLE_LEAVES.get(),
                EPBlocks.ORANGE_LEAVES.get(),
                EPBlocks.LEMON_LEAVES.get(),
                EPBlocks.LIME_LEAVES.get()
        );

        this.tag(BlockTags.SIGNS).add(
                EPBlocks.WALNUT_SIGN.get(),
                EPBlocks.APPLE_SIGN.get(),
                EPBlocks.ORANGE_SIGN.get(),
                EPBlocks.LEMON_SIGN.get()
        );

        this.tag(BlockTags.WALL_SIGNS).add(
                EPBlocks.WALNUT_WALL_SIGN.get(),
                EPBlocks.APPLE_WALL_SIGN.get(),
                EPBlocks.ORANGE_WALL_SIGN.get(),
                EPBlocks.LEMON_WALL_SIGN.get()
        );

        this.tag(BlockTags.WALL_HANGING_SIGNS).add(
                EPBlocks.WALNUT_WALL_HANGING_SIGN.get(),
                EPBlocks.APPLE_WALL_HANGING_SIGN.get(),
                EPBlocks.ORANGE_WALL_HANGING_SIGN.get(),
                EPBlocks.LEMON_WALL_HANGING_SIGN.get()
        );

        this.tag(BlockTags.SWORD_EFFICIENT).add(
                EPBlocks.WALNUT_LEAVES.get(),
                EPBlocks.APPLE_LEAVES.get(),
                EPBlocks.GREEN_APPLE_LEAVES.get(),
                EPBlocks.ORANGE_LEAVES.get(),
                EPBlocks.LEMON_LEAVES.get(),
                EPBlocks.LIME_LEAVES.get()
        );

        this.tag(BlockTags.MINEABLE_WITH_HOE).add(
                EPBlocks.WALNUT_LEAVES.get(),
                EPBlocks.APPLE_LEAVES.get(),
                EPBlocks.GREEN_APPLE_LEAVES.get(),
                EPBlocks.ORANGE_LEAVES.get(),
                EPBlocks.LEMON_LEAVES.get(),
                EPBlocks.LIME_LEAVES.get()
        );

        this.tag(BlockTags.PLANKS).add(
                EPBlocks.WALNUT_PLANKS.get(),
                EPBlocks.APPLE_PLANKS.get(),
                EPBlocks.ORANGE_PLANKS.get(),
                EPBlocks.LEMON_PLANKS.get()
        );

        this.tag(BlockTags.WOODEN_DOORS).add(
                EPBlocks.WALNUT_DOOR.get(),
                EPBlocks.APPLE_DOOR.get(),
                EPBlocks.ORANGE_DOOR.get(),
                EPBlocks.LEMON_DOOR.get()
        );

        this.tag(BlockTags.WOODEN_TRAPDOORS).add(
                EPBlocks.WALNUT_TRAPDOOR.get(),
                EPBlocks.APPLE_TRAPDOOR.get(),
                EPBlocks.ORANGE_TRAPDOOR.get(),
                EPBlocks.LEMON_TRAPDOOR.get()
        );

        this.tag(BlockTags.MINEABLE_WITH_AXE).add(
                //Walnut
                EPBlocks.WALNUT_PLANKS.get(),
                EPBlocks.WALNUT_STAIRS.get(),
                EPBlocks.WALNUT_SLAB.get(),
                EPBlocks.WALNUT_BUTTON.get(),
                EPBlocks.WALNUT_FENCE.get(),
                EPBlocks.WALNUT_FENCEGATE.get(),
                EPBlocks.WALNUT_PRESSURE_PLATE.get(),
                EPBlocks.WALNUT_DOOR.get(),
                EPBlocks.WALNUT_TRAPDOOR.get(),
                EPBlocks.WALNUT_LOG.get(),
                EPBlocks.STRIPPED_WALNUT_LOG.get(),
                EPBlocks.WALNUT_WOOD.get(),
                EPBlocks.STRIPPED_WALNUT_WOOD.get(),

                //Apple
                EPBlocks.APPLE_PLANKS.get(),
                EPBlocks.APPLE_STAIRS.get(),
                EPBlocks.APPLE_SLAB.get(),
                EPBlocks.APPLE_BUTTON.get(),
                EPBlocks.APPLE_FENCE.get(),
                EPBlocks.APPLE_FENCEGATE.get(),
                EPBlocks.APPLE_PRESSURE_PLATE.get(),
                EPBlocks.APPLE_DOOR.get(),
                EPBlocks.APPLE_TRAPDOOR.get(),
                EPBlocks.APPLE_LOG.get(),
                EPBlocks.STRIPPED_APPLE_LOG.get(),
                EPBlocks.APPLE_WOOD.get(),
                EPBlocks.STRIPPED_APPLE_WOOD.get(),

                //Orange
                EPBlocks.ORANGE_PLANKS.get(),
                EPBlocks.ORANGE_STAIRS.get(),
                EPBlocks.ORANGE_SLAB.get(),
                EPBlocks.ORANGE_BUTTON.get(),
                EPBlocks.ORANGE_FENCE.get(),
                EPBlocks.ORANGE_FENCEGATE.get(),
                EPBlocks.ORANGE_PRESSURE_PLATE.get(),
                EPBlocks.ORANGE_DOOR.get(),
                EPBlocks.ORANGE_TRAPDOOR.get(),
                EPBlocks.ORANGE_LOG.get(),
                EPBlocks.STRIPPED_ORANGE_LOG.get(),
                EPBlocks.ORANGE_WOOD.get(),
                EPBlocks.STRIPPED_ORANGE_WOOD.get(),

                //Lemon
                EPBlocks.LEMON_PLANKS.get(),
                EPBlocks.LEMON_STAIRS.get(),
                EPBlocks.LEMON_SLAB.get(),
                EPBlocks.LEMON_BUTTON.get(),
                EPBlocks.LEMON_FENCE.get(),
                EPBlocks.LEMON_FENCEGATE.get(),
                EPBlocks.LEMON_PRESSURE_PLATE.get(),
                EPBlocks.LEMON_DOOR.get(),
                EPBlocks.LEMON_TRAPDOOR.get(),
                EPBlocks.LEMON_LOG.get(),
                EPBlocks.STRIPPED_LEMON_LOG.get(),
                EPBlocks.LEMON_WOOD.get(),
                EPBlocks.STRIPPED_LEMON_WOOD.get()
        );

        this.tag(EPTags.Blocks.BASIC_FURNACE).add(
                EPBlocks.ADOBE_FURNACE.get(),
                EPBlocks.SOUL_FURNACE.get()
        );

        this.tag(EPTags.Blocks.ALLOY_FURNACE).add(
                EPBlocks.ADOBE_ALLOY_FURNACE.get()
        );

        this.tag(Tags.Blocks.STONE).add(
                EPBlocks.COBBLED_LIMESTONE.get()
        );

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
                //Polished stone
                EPBlocks.POLISHED_STONE.get(),
                EPBlocks.POLISHED_STONE_SLAB.get(),
                EPBlocks.POLISHED_STONE_STAIRS.get(),
                EPBlocks.POLISHED_STONE_WALL.get(),

                //Limestone
                EPBlocks.LIMESTONE.get(),
                EPBlocks.LIMESTONE_SLAB.get(),
                EPBlocks.LIMESTONE_STAIRS.get(),
                EPBlocks.LIMESTONE_WALL.get(),

                EPBlocks.COBBLED_LIMESTONE.get(),
                EPBlocks.COBBLED_LIMESTONE_SLAB.get(),
                EPBlocks.COBBLED_LIMESTONE_STAIRS.get(),
                EPBlocks.COBBLED_LIMESTONE_WALL.get(),

                EPBlocks.POLISHED_LIMESTONE.get(),
                EPBlocks.POLISHED_LIMESTONE_SLAB.get(),
                EPBlocks.POLISHED_LIMESTONE_STAIRS.get(),
                EPBlocks.POLISHED_LIMESTONE_WALL.get(),

                EPBlocks.LIMESTONE_BRICKS.get(),
                EPBlocks.LIMESTONE_BRICK_SLAB.get(),
                EPBlocks.LIMESTONE_BRICK_STAIRS.get(),
                EPBlocks.LIMESTONE_BRICK_WALL.get(),

                //soul
                EPBlocks.SOUL_MUD.get(),
                EPBlocks.SOUL_MUD_BRICKS.get(),
                EPBlocks.SOUL_MUD_BRICK_SLAB.get(),
                EPBlocks.SOUL_MUD_BRICK_STAIRS.get(),
                EPBlocks.SOUL_MUD_BRICK_WALL.get(),

                //Firebricks
                EPBlocks.FIREBRICKS.get(),
                EPBlocks.FIREBRICK_SLAB.get(),
                EPBlocks.FIREBRICK_STAIRS.get(),
                EPBlocks.FIREBRICK_WALL.get(),

                //Entities
                EPBlocks.ADOBE_FURNACE.get(),
                EPBlocks.SOUL_FURNACE.get(),
                EPBlocks.MASONRY_FURNACE.get(),
                EPBlocks.ADOBE_ALLOY_FURNACE.get(),
                EPBlocks.SOUL_ALLOY_FURNACE.get(),
                EPBlocks.SUPER_ALLOY_FURNACE.get(),
                EPBlocks.PRIMAL_GRINDER.get(),
                EPBlocks.MECHANICAL_GRINDER.get(),
                EPBlocks.GEM_POLISHER.get(),

                //Ores
                EPBlocks.NETHER_COPPER_ORE.get(),
                EPBlocks.SULFUR_ORE.get(),
                EPBlocks.TIN_ORE.get(),
                EPBlocks.ZINC_ORE.get(),
                EPBlocks.SILVER_ORE.get(),
                EPBlocks.RUBY_ORE.get(),
                EPBlocks.SAPPHIRE_ORE.get(),
                EPBlocks.DEEPSLATE_TIN_ORE.get(),
                EPBlocks.DEEPSLATE_ZINC_ORE.get(),
                EPBlocks.NETHER_ZINC_ORE.get(),
                EPBlocks.DEEPSLATE_SILVER_ORE.get(),
                EPBlocks.DEEPSLATE_RUBY_ORE.get(),
                EPBlocks.DEEPSLATE_SAPPHIRE_ORE.get(),
                EPBlocks.NETHER_GARNET_ORE.get(),
                EPBlocks.DEEPSLATE_SULFUR_ORE.get(),
                EPBlocks.NETHER_SULFUR_ORE.get(),
                EPBlocks.COBALT_ORE.get(),
                EPBlocks.DEEPSLATE_COBALT_ORE.get(),
                EPBlocks.BAUXITE.get(),
                EPBlocks.WHITE_BAUXITE.get(),
                EPBlocks.LIGHT_GRAY_BAUXITE.get(),
                EPBlocks.BROWN_BAUXITE.get(),
                EPBlocks.RED_BAUXITE.get(),
                EPBlocks.ORANGE_BAUXITE.get(),
                EPBlocks.YELLOW_BAUXITE.get(),

                //ore blocks
                EPBlocks.SILVER_BLOCK.get(),
                EPBlocks.ALUMINUM_BLOCK.get(),
                EPBlocks.TIN_BLOCK.get(),
                EPBlocks.ZINC_BLOCK.get(),
                EPBlocks.BRASS_BLOCK.get(),
                EPBlocks.BRONZE_BLOCK.get(),
                EPBlocks.BRONZIUM_BLOCK.get(),
                EPBlocks.ROSE_GOLD_BLOCK.get(),
                EPBlocks.STEEL_BLOCK.get(),
                EPBlocks.GREEN_GOLD_BLOCK.get(),
                EPBlocks.BLUE_GOLD_BLOCK.get(),

                //Calibrated quartz
                EPBlocks.CALIBRATED_QUARTZ_BLOCK.get(),
                EPBlocks.SMOOTH_CALIBRATED_QUARTZ_BLOCK.get(),
                EPBlocks.CHISELED_CALIBRATED_QUARTZ_BLOCK.get(),
                EPBlocks.CALIBRATED_QUARTZ_PILLAR.get(),
                EPBlocks.CALIBRATED_QUARTZ_BRICKS.get()
        );

        this.tag(Tags.Blocks.NEEDS_WOOD_TOOL).add(
                //Polished stone
                EPBlocks.POLISHED_STONE.get(),
                EPBlocks.POLISHED_STONE_SLAB.get(),
                EPBlocks.POLISHED_STONE_STAIRS.get(),
                EPBlocks.POLISHED_STONE_WALL.get(),

                //Limestone
                EPBlocks.LIMESTONE.get(),
                EPBlocks.LIMESTONE_SLAB.get(),
                EPBlocks.LIMESTONE_STAIRS.get(),
                EPBlocks.LIMESTONE_WALL.get(),

                EPBlocks.COBBLED_LIMESTONE.get(),
                EPBlocks.COBBLED_LIMESTONE_SLAB.get(),
                EPBlocks.COBBLED_LIMESTONE_STAIRS.get(),
                EPBlocks.COBBLED_LIMESTONE_WALL.get(),

                EPBlocks.POLISHED_LIMESTONE.get(),
                EPBlocks.POLISHED_LIMESTONE_SLAB.get(),
                EPBlocks.POLISHED_LIMESTONE_STAIRS.get(),
                EPBlocks.POLISHED_LIMESTONE_WALL.get(),

                //Calibrated quartz
                EPBlocks.CALIBRATED_QUARTZ_BLOCK.get(),
                EPBlocks.SMOOTH_CALIBRATED_QUARTZ_BLOCK.get(),
                EPBlocks.CHISELED_CALIBRATED_QUARTZ_BLOCK.get(),
                EPBlocks.CALIBRATED_QUARTZ_PILLAR.get(),
                EPBlocks.CALIBRATED_QUARTZ_BRICKS.get(),

                //Entities
                EPBlocks.ADOBE_FURNACE.get(),
                EPBlocks.SOUL_FURNACE.get(),
                EPBlocks.SOUL_ALLOY_FURNACE.get(),
                EPBlocks.PRIMAL_GRINDER.get()
        );

        this.tag(EPTags.Blocks.BAUXITE_ORES).add(
                EPBlocks.BAUXITE.get(),
                EPBlocks.WHITE_BAUXITE.get(),
                EPBlocks.LIGHT_GRAY_BAUXITE.get(),
                EPBlocks.BROWN_BAUXITE.get(),
                EPBlocks.RED_BAUXITE.get(),
                EPBlocks.ORANGE_BAUXITE.get(),
                EPBlocks.YELLOW_BAUXITE.get()
        );

        this.tag(EPTags.Blocks.NEEDS_SILVER_TOOL).add(
                EPBlocks.RAW_SILVER_BLOCK.get(),
                EPBlocks.SILVER_BLOCK.get()
        );

        this.tag(BlockTags.NEEDS_STONE_TOOL).add(
                //Limestone bricks
                EPBlocks.LIMESTONE_BRICKS.get(),
                EPBlocks.LIMESTONE_BRICK_SLAB.get(),
                EPBlocks.LIMESTONE_BRICK_STAIRS.get(),
                EPBlocks.LIMESTONE_BRICK_WALL.get(),

                //Entities
                EPBlocks.MECHANICAL_GRINDER.get(),
                EPBlocks.GEM_POLISHER.get(),

                //Ores
                EPBlocks.BAUXITE.get(),
                EPBlocks.WHITE_BAUXITE.get(),
                EPBlocks.LIGHT_GRAY_BAUXITE.get(),
                EPBlocks.BROWN_BAUXITE.get(),
                EPBlocks.RED_BAUXITE.get(),
                EPBlocks.ORANGE_BAUXITE.get(),
                EPBlocks.YELLOW_BAUXITE.get(),
                EPBlocks.TIN_ORE.get(),
                EPBlocks.ZINC_ORE.get(),
                EPBlocks.NETHER_COPPER_ORE.get(),

                //Others
                EPBlocks.RAW_TIN_BLOCK.get(),
                EPBlocks.TIN_BLOCK.get(),
                EPBlocks.RAW_ZINC_BLOCK.get(),
                EPBlocks.ZINC_BLOCK.get()
        );

        this.tag(EPTags.Blocks.NEEDS_BRASS_TOOL).add(
                EPBlocks.BRASS_BLOCK.get()
        );

        this.tag(EPTags.Blocks.NEEDS_BRONZE_TOOL).add(
                Blocks.IRON_ORE,
                Blocks.IRON_BLOCK,
                Blocks.IRON_BARS,
                Blocks.IRON_DOOR,
                Blocks.IRON_TRAPDOOR,
                Blocks.RAW_IRON_BLOCK,
                Blocks.HOPPER,
                EPBlocks.BRONZE_BLOCK.get(),
                EPBlocks.NETHER_GARNET_ORE.get()
        );

        this.tag(EPTags.Blocks.NEEDS_ROSE_GOLD_TOOL).add(
                EPBlocks.ROSE_GOLD_BLOCK.get()
        );

        this.tag(EPTags.Blocks.NEEDS_BRONZIUM_TOOL).add(
                EPBlocks.BRONZIUM_BLOCK.get()
        );

        this.tag(BlockTags.NEEDS_IRON_TOOL).add(
                Blocks.END_STONE,
                EPBlocks.SILVER_ORE.get(),
                EPBlocks.SAPPHIRE_ORE.get(),
                EPBlocks.RUBY_ORE.get(),
                EPBlocks.ALUMINUM_BLOCK.get(),
                EPBlocks.RAW_ALUMINUM_BLOCK.get(),
                EPBlocks.FIREBRICKS.get(),
                EPBlocks.FIREBRICK_SLAB.get(),
                EPBlocks.FIREBRICK_STAIRS.get(),
                EPBlocks.FIREBRICK_WALL.get(),
                EPBlocks.MASONRY_FURNACE.get()
        );

        this.tag(EPTags.Blocks.NEEDS_STEEL_TOOL).add(
                EPBlocks.SUPER_ALLOY_FURNACE.get(),
                Blocks.DIAMOND_ORE,
                Blocks.DIAMOND_BLOCK,
                Blocks.DEEPSLATE,
                Blocks.DEEPSLATE_IRON_ORE,
                Blocks.DEEPSLATE_COPPER_ORE,
                Blocks.DEEPSLATE_GOLD_ORE,
                Blocks.DEEPSLATE_DIAMOND_ORE,
                Blocks.DEEPSLATE_EMERALD_ORE,
                Blocks.DEEPSLATE_LAPIS_ORE,
                Blocks.DEEPSLATE_REDSTONE_ORE,
                Blocks.DEEPSLATE_BRICK_SLAB,
                Blocks.DEEPSLATE_BRICK_STAIRS,
                Blocks.DEEPSLATE_BRICKS,
                Blocks.DEEPSLATE_BRICK_WALL,
                Blocks.DEEPSLATE_TILE_SLAB,
                Blocks.DEEPSLATE_TILE_STAIRS,
                Blocks.DEEPSLATE_TILES,
                Blocks.DEEPSLATE_TILE_WALL,
                Blocks.CHISELED_DEEPSLATE,
                Blocks.COBBLED_DEEPSLATE,
                Blocks.POLISHED_DEEPSLATE,
                Blocks.COBBLED_DEEPSLATE_SLAB,
                Blocks.COBBLED_DEEPSLATE_STAIRS,
                Blocks.COBBLED_DEEPSLATE_WALL,
                Blocks.CRACKED_DEEPSLATE_BRICKS,
                Blocks.CRACKED_DEEPSLATE_TILES,
                Blocks.POLISHED_DEEPSLATE_SLAB,
                Blocks.POLISHED_DEEPSLATE_STAIRS,
                Blocks.POLISHED_DEEPSLATE_WALL,
                EPBlocks.DEEPSLATE_TIN_ORE.get(),
                EPBlocks.DEEPSLATE_ZINC_ORE.get(),
                EPBlocks.DEEPSLATE_SULFUR_ORE.get(),
                EPBlocks.DEEPSLATE_SILVER_ORE.get(),
                EPBlocks.DEEPSLATE_RUBY_ORE.get(),
                EPBlocks.DEEPSLATE_SAPPHIRE_ORE.get(),
                EPBlocks.STEEL_BLOCK.get()
        );

        this.tag(EPTags.Blocks.NEEDS_GREEN_GOLD_TOOL).add(
                EPBlocks.GREEN_GOLD_BLOCK.get()
        );

        this.tag(EPTags.Blocks.NEEDS_BLUE_GOLD_TOOL).add(
                EPBlocks.BLUE_GOLD_BLOCK.get()
        );

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL).add(
                EPBlocks.COBALT_ORE.get(),
                EPBlocks.DEEPSLATE_COBALT_ORE.get()
        );

        this.tag(Tags.Blocks.ORES).add(
                EPBlocks.NETHER_COPPER_ORE.get(),
                EPBlocks.SULFUR_ORE.get(),
                EPBlocks.TIN_ORE.get(),
                EPBlocks.ZINC_ORE.get(),
                EPBlocks.SILVER_ORE.get(),
                EPBlocks.RUBY_ORE.get(),
                EPBlocks.SAPPHIRE_ORE.get(),
                EPBlocks.COBALT_ORE.get(),
                EPBlocks.DEEPSLATE_TIN_ORE.get(),
                EPBlocks.DEEPSLATE_ZINC_ORE.get(),
                EPBlocks.NETHER_ZINC_ORE.get(),
                EPBlocks.DEEPSLATE_SILVER_ORE.get(),
                EPBlocks.DEEPSLATE_RUBY_ORE.get(),
                EPBlocks.DEEPSLATE_SAPPHIRE_ORE.get(),
                EPBlocks.DEEPSLATE_SULFUR_ORE.get(),
                EPBlocks.NETHER_SULFUR_ORE.get(),
                EPBlocks.DEEPSLATE_COBALT_ORE.get(),
                EPBlocks.BAUXITE.get(),
                EPBlocks.WHITE_BAUXITE.get(),
                EPBlocks.LIGHT_GRAY_BAUXITE.get(),
                EPBlocks.BROWN_BAUXITE.get(),
                EPBlocks.RED_BAUXITE.get(),
                EPBlocks.ORANGE_BAUXITE.get(),
                EPBlocks.YELLOW_BAUXITE.get()
        );

        this.tag(BlockTags.BEACON_BASE_BLOCKS).add(
                EPBlocks.SILVER_BLOCK.get(),
                EPBlocks.ALUMINUM_BLOCK.get(),
                EPBlocks.TIN_BLOCK.get(),
                EPBlocks.ZINC_BLOCK.get(),
                EPBlocks.BRASS_BLOCK.get(),
                EPBlocks.BRONZE_BLOCK.get(),
                EPBlocks.ROSE_GOLD_BLOCK.get(),
                EPBlocks.BRONZIUM_BLOCK.get(),
                EPBlocks.STEEL_BLOCK.get(),
                EPBlocks.GREEN_GOLD_BLOCK.get(),
                EPBlocks.BLUE_GOLD_BLOCK.get()
        );
    }
}
