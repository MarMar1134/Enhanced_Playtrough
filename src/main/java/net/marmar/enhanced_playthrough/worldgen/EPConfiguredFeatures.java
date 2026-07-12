package net.marmar.enhanced_playthrough.worldgen;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.block.EPBlocks;
import net.marmar.enhanced_playthrough.block.custom.plant.DoublePlantGrowingHeadBlock;
import net.marmar.enhanced_playthrough.worldgen.feature.EPFeatures;
import net.marmar.enhanced_playthrough.worldgen.ore.EPOresConfiguredFeatures;
import net.marmar.enhanced_playthrough.worldgen.tree.foliage.AppleFoliagePlacer;
import net.marmar.enhanced_playthrough.worldgen.tree.foliage.LemonFoliagePlacer;
import net.marmar.enhanced_playthrough.worldgen.tree.foliage.OrangeFoliagePlacer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.RuleBasedBlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.BlockPredicateFilter;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraft.world.level.material.Fluids;

import java.util.List;

public class EPConfiguredFeatures {
    //Trees
    public static final ResourceKey<ConfiguredFeature<?, ?>> WALNUT_TREES = registerKey("walnut_trees");
    public static final ResourceKey<ConfiguredFeature<?, ?>> APPLE_TREES = registerKey("apple_trees");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GREEN_APPLE_TREES = registerKey("green_apple_trees");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORANGE_TREES = registerKey("orange_trees");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LEMON_TREES = registerKey("lemon_trees");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LIME_TREES = registerKey("lime_trees");

    //Nature
    public static final ResourceKey<ConfiguredFeature<?, ?>> LIMESTONE_PATCH = registerKey("limestone_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MUD_PATCH = registerKey("mud_patch");

    //Wild crops
    public static final ResourceKey<ConfiguredFeature<?, ?>> WILD_WHEAT = registerKey("wild_wheat");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WILD_TOMATO = registerKey("wild_tomato");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WILD_CORN = registerKey("wild_corn");

    //Plants
    public static final ResourceKey<ConfiguredFeature<?, ?>> SMALL_REEDS_OVERWORLD = registerKey("small_reeds_overworld");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SMALL_REEDS_PLATEAU = registerKey("small_reeds_plateau");

    public static final ResourceKey<ConfiguredFeature<?, ?>> REEDS = registerKey("reeds");

    public static final ResourceKey<ConfiguredFeature<?, ?>> TALL_REEDS = registerKey("tall_reeds");

    public static final ResourceKey<ConfiguredFeature<?, ?>> KENAF = registerKey("kenaf");

    public static final ResourceKey<ConfiguredFeature<?, ?>> WATER_REEDS_OVERWORLD = registerKey("water_reeds_overworld");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WATER_REEDS_SWAMP = registerKey("water_reeds_swamp");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WATER_REEDS_LUSH_CAVES = registerKey("water_reeds_lush_caves");

    //Flowers
    public static final ResourceKey<ConfiguredFeature<?, ?>> COLD_LYRIUM = registerKey("cold_lyrium");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SUCCULENT = registerKey("succulent");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        //Rule tests
        RuleTest stoneReplaceable = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);

        //Predicates
        BlockPredicate isCloseToWater = BlockPredicate.anyOf(
                BlockPredicate.matchesFluids(new BlockPos(1, -1, 0), Fluids.WATER, Fluids.FLOWING_WATER),
                BlockPredicate.matchesFluids(new BlockPos(-1, -1, 0), Fluids.WATER, Fluids.FLOWING_WATER),
                BlockPredicate.matchesFluids(new BlockPos(0, -1, 1), Fluids.WATER, Fluids.FLOWING_WATER),
                BlockPredicate.matchesFluids(new BlockPos(0, -1, -1), Fluids.WATER, Fluids.FLOWING_WATER));

        //Ores
        EPOresConfiguredFeatures.bootstrap(context);

        //Mud
        register(context, MUD_PATCH, Feature.DISK, new DiskConfiguration(
                RuleBasedBlockStateProvider.simple(Blocks.MUD), BlockPredicate.matchesBlocks(Blocks.DIRT, Blocks.SAND, Blocks.GRAVEL),
                UniformInt.of(1, 4), 2));

        //Limestone
        List<OreConfiguration.TargetBlockState> limestone = List.of(
                OreConfiguration.target(stoneReplaceable, EPBlocks.LIMESTONE.get().defaultBlockState()));

        register(context, LIMESTONE_PATCH, Feature.ORE, new OreConfiguration(limestone, 32));

        //trees
            //Walnut
            register(context, WALNUT_TREES, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                    BlockStateProvider.simple(EPBlocks.WALNUT_LOG.get()),
                    new StraightTrunkPlacer(4, 2, 1),

                    BlockStateProvider.simple(EPBlocks.WALNUT_LEAVES.get()),
                    new BlobFoliagePlacer(ConstantInt.of(3),ConstantInt.of(2),3),

                    new TwoLayersFeatureSize(2, 1, 3)).build());

            //Apple
            register(context, APPLE_TREES, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                    BlockStateProvider.simple(EPBlocks.APPLE_LOG.get()),
                    new StraightTrunkPlacer(3, 2, 1),

                    new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                            .add(EPBlocks.APPLE_LEAVES.get().defaultBlockState(), 3)
                            .add(EPBlocks.APPLE_LEAVES_WITH_FRUIT.get().defaultBlockState(), 1)
                            .build()),
                    new AppleFoliagePlacer(ConstantInt.of(3),ConstantInt.of(2),3),

                    new TwoLayersFeatureSize(2, 1, 2)).build());

            //Green apple
            register(context, GREEN_APPLE_TREES, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                    BlockStateProvider.simple(EPBlocks.APPLE_LOG.get()),
                    new StraightTrunkPlacer(3, 2, 1),

                    new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                            .add(EPBlocks.GREEN_APPLE_LEAVES.get().defaultBlockState(), 3)
                            .add(EPBlocks.GREEN_APPLE_LEAVES_WITH_FRUIT.get().defaultBlockState(), 1)
                            .build()),
                    new AppleFoliagePlacer(ConstantInt.of(3),ConstantInt.of(2),3),

                    new TwoLayersFeatureSize(2, 1, 2)).build());

            //Orange
            register(context, ORANGE_TREES, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                    BlockStateProvider.simple(EPBlocks.ORANGE_LOG.get()),
                    new StraightTrunkPlacer(3, 1, 1),

                    new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                            .add(EPBlocks.ORANGE_LEAVES.get().defaultBlockState(), 3)
                            .add(EPBlocks.ORANGE_LEAVES_WITH_FRUIT.get().defaultBlockState(), 1)
                            .build()),
                    new OrangeFoliagePlacer(ConstantInt.of(2),ConstantInt.of(0),3),

                    new TwoLayersFeatureSize(1, 1, 2)).build());

            //Lemon
            register(context, LEMON_TREES, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                    BlockStateProvider.simple(EPBlocks.LEMON_LOG.get()),
                    new StraightTrunkPlacer(4, 2, 1),

                    new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                            .add(EPBlocks.LEMON_LEAVES.get().defaultBlockState(), 4)
                            .add(EPBlocks.LEMON_LEAVES_WITH_FRUIT.get().defaultBlockState(), 2)
                            .build()),
                    new LemonFoliagePlacer(ConstantInt.of(2),ConstantInt.of(1),4),

                    new TwoLayersFeatureSize(2, 1, 2)).build());

            //Lime
            register(context, LIME_TREES, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                    BlockStateProvider.simple(EPBlocks.LEMON_LOG.get()),
                    new StraightTrunkPlacer(3, 1, 1),

                    new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                            .add(EPBlocks.LIME_LEAVES.get().defaultBlockState(), 4)
                            .add(EPBlocks.LIME_LEAVES_WITH_FRUIT.get().defaultBlockState(), 2)
                            .build()),
                    new LemonFoliagePlacer(ConstantInt.of(2),ConstantInt.of(1),4),

                    new TwoLayersFeatureSize(1, 1, 2)).build());

        //Wild crops
        register(context, WILD_WHEAT, Feature.RANDOM_PATCH,
                FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(EPBlocks.WILD_WHEAT_CROP.get()))));
        register(context, WILD_TOMATO, Feature.RANDOM_PATCH,
                FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(EPBlocks.WILD_TOMATO_CROP.get()))));
        register(context, WILD_CORN, Feature.RANDOM_PATCH,
                FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(EPBlocks.WILD_CORN_CROP.get()))));

        //Plants
        register(context, SMALL_REEDS_OVERWORLD, Feature.RANDOM_PATCH,
                new RandomPatchConfiguration(50, 15, 0, PlacementUtils.inlinePlaced(
                        Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(EPBlocks.SMALL_REEDS.get()))
                        , BlockPredicateFilter.forPredicate(BlockPredicate.allOf(BlockPredicate.ONLY_IN_AIR_PREDICATE, isCloseToWater)))));
        register(context, SMALL_REEDS_PLATEAU, Feature.RANDOM_PATCH,
                new RandomPatchConfiguration(40, 10, 0, PlacementUtils.inlinePlaced(
                        Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(EPBlocks.SMALL_REEDS.get())))));

        register(context, REEDS, Feature.RANDOM_PATCH,
                new RandomPatchConfiguration(80, 10, 0, PlacementUtils.inlinePlaced(
                        Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(EPBlocks.REEDS.get().defaultBlockState().setValue(DoublePlantGrowingHeadBlock.AGE, 1))),
                        BlockPredicateFilter.forPredicate(BlockPredicate.allOf(BlockPredicate.ONLY_IN_AIR_PREDICATE, isCloseToWater)))));

        register(context, TALL_REEDS, Feature.RANDOM_PATCH,
                new RandomPatchConfiguration(50, 5, 0, PlacementUtils.inlinePlaced(
                        Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(EPBlocks.TALL_REEDS.get().defaultBlockState().setValue(DoublePlantGrowingHeadBlock.AGE, 1))),
                        BlockPredicateFilter.forPredicate(BlockPredicate.allOf(BlockPredicate.ONLY_IN_AIR_PREDICATE, isCloseToWater)))));

        register(context, KENAF, Feature.RANDOM_PATCH,
                new RandomPatchConfiguration(32, 4, 0, PlacementUtils.inlinePlaced(
                        Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(EPBlocks.KENAF.get().defaultBlockState().setValue(DoublePlantGrowingHeadBlock.AGE, 1))))));

        register(context, WATER_REEDS_OVERWORLD, EPFeatures.WATER_REEDS.get(),
                new RandomPatchConfiguration(120, 3, 0, PlacementUtils.inlinePlaced(
                        Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(EPBlocks.WATER_REEDS.get())))));
        register(context, WATER_REEDS_SWAMP, EPFeatures.WATER_REEDS.get(),
                new RandomPatchConfiguration(60, 6, 0, PlacementUtils.inlinePlaced(
                        Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(EPBlocks.WATER_REEDS.get())))));
        register(context, WATER_REEDS_LUSH_CAVES, EPFeatures.WATER_REEDS.get(),
                new RandomPatchConfiguration(40, 3, 0, PlacementUtils.inlinePlaced(
                        Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(EPBlocks.WATER_REEDS.get())))));



        //Flowers
        register(context, COLD_LYRIUM, Feature.RANDOM_PATCH, FeatureUtils.simpleRandomPatchConfiguration(12,
                PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(EPBlocks.COLD_LYRIUM.get())))));
        register(context, SUCCULENT, Feature.RANDOM_PATCH, FeatureUtils.simpleRandomPatchConfiguration(8,
                PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(EPBlocks.SUCCULENT.get())))));
    }

    @SuppressWarnings("removal")
    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(EnhancedPlaythrough.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
