package net.marmar.enhanced_playthrough.worldgen;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.block.ModBlocks;
import net.marmar.enhanced_playthrough.worldgen.feature.ModFeatures;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.RuleBasedBlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.BlockPredicateFilter;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraft.world.level.material.Fluids;

import java.util.List;

public class ModConfiguredFeatures {
    //Trees
    public static final ResourceKey<ConfiguredFeature<?, ?>> WALNUT_KEY = registerKey("walnut");
    public static final ResourceKey<ConfiguredFeature<?, ?>> APPLE_KEY = registerKey("apple");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GREEN_APPLE_KEY = registerKey("green_apple");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORANGE_KEY = registerKey("orange");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LEMON_KEY = registerKey("lemon");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LIME_KEY = registerKey("lime");

    //Nature
    public static final ResourceKey<ConfiguredFeature<?, ?>> LIMESTONE_KEY = registerKey("limestone");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MUD_PATCH_KEY = registerKey("mud_patch");

    //Wild crops
    public static final ResourceKey<ConfiguredFeature<?, ?>> WILD_WHEAT_KEY = registerKey("wild_wheat");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WILD_TOMATO_KEY = registerKey("wild_tomato");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WILD_CORN_KEY = registerKey("wild_corn");

    //Plants
    public static final ResourceKey<ConfiguredFeature<?, ?>> TALL_REEDS_KEY = registerKey("tall_reeds");

    public static final ResourceKey<ConfiguredFeature<?, ?>> REEDS_KEY = registerKey("reeds");

    public static final ResourceKey<ConfiguredFeature<?, ?>> SMALL_REEDS_OVERWORLD_KEY = registerKey("small_reeds_overworld");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SMALL_REEDS_PLATEAU_KEY = registerKey("small_reeds_plateau");

    public static final ResourceKey<ConfiguredFeature<?, ?>> WATER_REEDS_OVERWORLD_KEY = registerKey("water_reeds_overworld");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WATER_REEDS_SWAMP_KEY = registerKey("water_reeds_swamp");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WATER_REEDS_LUSH_CAVES_KEY = registerKey("water_reeds_lush_caves");

    //Ores
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_COPPER_ORE_KEY = registerKey("nether_copper_ore");

    public static final ResourceKey<ConfiguredFeature<?, ?>> TIN_ORE_KEY = registerKey("tin_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> EXTRA_TIN_ORE_KEY = registerKey("extra_tin_ore");

    public static final ResourceKey<ConfiguredFeature<?, ?>> ZINC_ORE_KEY = registerKey("zinc_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_ZINC_ORE_KEY = registerKey("nether_zinc_ore");

    public static final ResourceKey<ConfiguredFeature<?, ?>> SILVER_ORE_KEY = registerKey("silver_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> EXTRA_SILVER_ORE_KEY = registerKey("extra_silver_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BADLANDS_SILVER_ORE_KEY = registerKey("badlands_silver_ore");

    public static final ResourceKey<ConfiguredFeature<?, ?>> SULFUR_ORE_KEY = registerKey("sulfur_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_SULFUR_ORE_KEY = registerKey("nether_sulfur_ore");

    public static final ResourceKey<ConfiguredFeature<?, ?>> COBALT_KEY = registerKey("cobalt_ore");

    public static final ResourceKey<ConfiguredFeature<?, ?>> RUBY_ORE_KEY = registerKey("ruby_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SAPPHIRE_ORE_KEY = registerKey("sapphire_ore");

    public static final ResourceKey<ConfiguredFeature<?, ?>> EXTRA_RUBY_ORE_KEY = registerKey("extra_ruby_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> EXTRA_SAPPHIRE_ORE_KEY = registerKey("extra_sapphire_ore");

    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_GARNET_ORE_KEY = registerKey("nether_garnet_ore");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceable = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceable = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherrackReplaceable = new BlockMatchTest(Blocks.NETHERRACK);

        RuleTest ironReplaceable = new TagMatchTest(BlockTags.IRON_ORES);

        BlockPredicate isCloseToWater = BlockPredicate.anyOf(
                BlockPredicate.matchesFluids(new BlockPos(1, -1, 0), Fluids.WATER, Fluids.FLOWING_WATER),
                BlockPredicate.matchesFluids(new BlockPos(-1, -1, 0), Fluids.WATER, Fluids.FLOWING_WATER),
                BlockPredicate.matchesFluids(new BlockPos(0, -1, 1), Fluids.WATER, Fluids.FLOWING_WATER),
                BlockPredicate.matchesFluids(new BlockPos(0, -1, -1), Fluids.WATER, Fluids.FLOWING_WATER));

        register(context, MUD_PATCH_KEY, Feature.DISK, new DiskConfiguration(
                RuleBasedBlockStateProvider.simple(Blocks.MUD), BlockPredicate.matchesBlocks(Blocks.DIRT, Blocks.SAND, Blocks.GRAVEL),
                UniformInt.of(1, 4), 2));

        //Limestone
        List<OreConfiguration.TargetBlockState> limestone = List.of(OreConfiguration.target(stoneReplaceable,
                ModBlocks.LIMESTONE.get().defaultBlockState()));

        register(context, LIMESTONE_KEY, Feature.ORE, new OreConfiguration(limestone, 32));

        //Nether copper ore
        List<OreConfiguration.TargetBlockState> netherCopperOres = List.of(OreConfiguration.target(netherrackReplaceable,
                ModBlocks.NETHER_COPPER_ORE.get().defaultBlockState()));

        register(context, NETHER_COPPER_ORE_KEY, Feature.ORE, new OreConfiguration(netherCopperOres, 8));

        //Tin ore
        List<OreConfiguration.TargetBlockState> tinOres = List.of(OreConfiguration.target(stoneReplaceable,
                        ModBlocks.TIN_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceable, ModBlocks.DEEPSLATE_TIN_ORE.get().defaultBlockState()));

        register(context, TIN_ORE_KEY, Feature.ORE, new OreConfiguration(tinOres, 7));
        register(context, EXTRA_TIN_ORE_KEY, Feature.ORE, new OreConfiguration(tinOres, 5));

        //Zinc ore
        List<OreConfiguration.TargetBlockState> zincOres = List.of(OreConfiguration.target(stoneReplaceable,
                ModBlocks.ZINC_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceable, ModBlocks.DEEPSLATE_ZINC_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> netherZincOres = List.of(OreConfiguration.target(netherrackReplaceable,
                        ModBlocks.NETHER_ZINC_ORE.get().defaultBlockState()));

        register(context, ZINC_ORE_KEY, Feature.ORE, new OreConfiguration(zincOres, 6));
        register(context, NETHER_ZINC_ORE_KEY, Feature.ORE, new OreConfiguration(netherZincOres, 10));

        //Silver ore
        List<OreConfiguration.TargetBlockState> silverOres = List.of(OreConfiguration.target(stoneReplaceable,
                        ModBlocks.SILVER_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceable, ModBlocks.DEEPSLATE_SILVER_ORE.get().defaultBlockState()));

        register(context, SILVER_ORE_KEY, Feature.ORE, new OreConfiguration(silverOres, 7));
        register(context, EXTRA_SILVER_ORE_KEY, Feature.ORE, new OreConfiguration(silverOres, 3));
        register(context, BADLANDS_SILVER_ORE_KEY, Feature.ORE, new OreConfiguration(silverOres, 4));

        //Sulphur ore
        List<OreConfiguration.TargetBlockState> sulphurOres = List.of(OreConfiguration.target(stoneReplaceable,
                ModBlocks.SULFUR_ORE.get().defaultBlockState()), OreConfiguration.target(deepslateReplaceable, ModBlocks.DEEPSLATE_SULFUR_ORE.get().defaultBlockState()));

        register(context, SULFUR_ORE_KEY, Feature.ORE, new OreConfiguration(sulphurOres, 6));

        List<OreConfiguration.TargetBlockState> netherSulphurOres = List.of(OreConfiguration.target(netherrackReplaceable,
                ModBlocks.NETHER_SULFUR_ORE.get().defaultBlockState()));

        register(context, NETHER_SULFUR_ORE_KEY, Feature.ORE, new OreConfiguration(netherSulphurOres, 10));

        //Cobalt ore
        List<OreConfiguration.TargetBlockState> cobaltOres = List.of(OreConfiguration.target(stoneReplaceable,
                ModBlocks.COBALT_ORE.get().defaultBlockState()), OreConfiguration.target(deepslateReplaceable, ModBlocks.DEEPSLATE_COBALT_ORE.get().defaultBlockState()));

        register(context, COBALT_KEY, Feature.ORE, new OreConfiguration(cobaltOres, 5));

        //Sapphire ore
        List<OreConfiguration.TargetBlockState> saphireOres = List.of(OreConfiguration.target(stoneReplaceable,
                        ModBlocks.SAPPHIRE_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceable, ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get().defaultBlockState()));

        register(context, SAPPHIRE_ORE_KEY, Feature.ORE, new OreConfiguration(saphireOres, 8));
        register(context, EXTRA_SAPPHIRE_ORE_KEY, Feature.ORE, new OreConfiguration(saphireOres, 6));

        //Ruby ore
        List<OreConfiguration.TargetBlockState> rubiOres = List.of(OreConfiguration.target(stoneReplaceable,
                        ModBlocks.RUBY_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceable, ModBlocks.DEEPSLATE_RUBY_ORE.get().defaultBlockState()));

        register(context, RUBY_ORE_KEY, Feature.ORE, new OreConfiguration(rubiOres, 6));
        register(context, EXTRA_RUBY_ORE_KEY, Feature.ORE, new OreConfiguration(rubiOres, 4));

        //Nether garnet ore
        List<OreConfiguration.TargetBlockState> garnetOres = List.of(OreConfiguration.target(netherrackReplaceable,
                ModBlocks.NETHER_GARNET_ORE.get().defaultBlockState()));

        register(context, NETHER_GARNET_ORE_KEY, Feature.ORE, new OreConfiguration(garnetOres, 5));

        //trees
            //Walnut
            register(context, WALNUT_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                    BlockStateProvider.simple(ModBlocks.WALNUT_LOG.get()),
                    new StraightTrunkPlacer(4, 2, 1),

                    BlockStateProvider.simple(ModBlocks.WALNUT_LEAVES.get()),
                    new BlobFoliagePlacer(ConstantInt.of(3),ConstantInt.of(2),3),

                    new TwoLayersFeatureSize(2, 1, 3)).build());

            //Apple
            register(context, APPLE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                    BlockStateProvider.simple(ModBlocks.APPLE_LOG.get()),
                    new StraightTrunkPlacer(3, 2, 1),

                    BlockStateProvider.simple(ModBlocks.APPLE_LEAVES.get()),
                    new BlobFoliagePlacer(ConstantInt.of(3),ConstantInt.of(2),3),

                    new TwoLayersFeatureSize(2, 1, 2)).build());

            //Green apple
            register(context, GREEN_APPLE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                    BlockStateProvider.simple(ModBlocks.APPLE_LOG.get()),
                    new StraightTrunkPlacer(3, 2, 1),

                    BlockStateProvider.simple(ModBlocks.GREEN_APPLE_LEAVES.get()),
                    new BlobFoliagePlacer(ConstantInt.of(2),ConstantInt.of(1),2),

                    new TwoLayersFeatureSize(2, 1, 2)).build());

            //Orange
            register(context, ORANGE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                    BlockStateProvider.simple(ModBlocks.ORANGE_LOG.get()),
                    new StraightTrunkPlacer(3, 1, 1),

                    BlockStateProvider.simple(ModBlocks.ORANGE_LEAVES.get()),
                    new BlobFoliagePlacer(ConstantInt.of(2),ConstantInt.of(0),2),

                    new TwoLayersFeatureSize(1, 1, 2)).build());

            //Lemon
            register(context, LEMON_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                    BlockStateProvider.simple(ModBlocks.LEMON_LOG.get()),
                    new StraightTrunkPlacer(4, 2, 1),

                    BlockStateProvider.simple(ModBlocks.LEMON_LEAVES.get()),
                    new BlobFoliagePlacer(ConstantInt.of(2),ConstantInt.of(0),2),

                    new TwoLayersFeatureSize(2, 1, 2)).build());

            //Lime
            register(context, LIME_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                    BlockStateProvider.simple(ModBlocks.LEMON_LOG.get()),
                    new StraightTrunkPlacer(3, 1, 1),

                    BlockStateProvider.simple(ModBlocks.LIME_LEAVES.get()),
                    new BlobFoliagePlacer(ConstantInt.of(2),ConstantInt.of(0),2),

                    new TwoLayersFeatureSize(1, 1, 2)).build());

        //Wild crops
        register(context, WILD_WHEAT_KEY, Feature.RANDOM_PATCH,
                FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.WILD_WHEAT.get()))));
        register(context, WILD_TOMATO_KEY, Feature.RANDOM_PATCH,
                FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.WILD_TOMATO.get()))));
        register(context, WILD_CORN_KEY, Feature.RANDOM_PATCH,
                FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.WILD_CORN.get()))));

        //Plants
        register(context, TALL_REEDS_KEY, Feature.RANDOM_PATCH,
                new RandomPatchConfiguration(50, 5, 0, PlacementUtils.inlinePlaced(
                        Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.TALL_REEDS.get()))
                        , BlockPredicateFilter.forPredicate(BlockPredicate.allOf(BlockPredicate.ONLY_IN_AIR_PREDICATE, isCloseToWater)))));

        register(context, REEDS_KEY, Feature.RANDOM_PATCH,
                new RandomPatchConfiguration(80, 10, 0, PlacementUtils.inlinePlaced(
                        Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.REEDS.get()))
                        , BlockPredicateFilter.forPredicate(BlockPredicate.allOf(BlockPredicate.ONLY_IN_AIR_PREDICATE, isCloseToWater)))));

        register(context, SMALL_REEDS_OVERWORLD_KEY, Feature.RANDOM_PATCH,
                new RandomPatchConfiguration(50, 15, 0, PlacementUtils.inlinePlaced(
                        Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.SMALL_REEDS.get()))
                        , BlockPredicateFilter.forPredicate(BlockPredicate.allOf(BlockPredicate.ONLY_IN_AIR_PREDICATE, isCloseToWater)))));
        register(context, SMALL_REEDS_PLATEAU_KEY, Feature.RANDOM_PATCH,
                new RandomPatchConfiguration(40, 10, 0, PlacementUtils.inlinePlaced(
                        Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.SMALL_REEDS.get())))));

        register(context, WATER_REEDS_OVERWORLD_KEY, ModFeatures.WATER_REEDS.get(),
                new RandomPatchConfiguration(120, 3, 0, PlacementUtils.inlinePlaced(
                        Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.WATER_REEDS.get())))));
        register(context, WATER_REEDS_SWAMP_KEY, ModFeatures.WATER_REEDS.get(),
                new RandomPatchConfiguration(60, 6, 0, PlacementUtils.inlinePlaced(
                        Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.WATER_REEDS.get())))));
        register(context, WATER_REEDS_LUSH_CAVES_KEY, ModFeatures.WATER_REEDS.get(),
                new RandomPatchConfiguration(40, 3, 0, PlacementUtils.inlinePlaced(
                        Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.WATER_REEDS.get())))));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(EnhancedPlaythrough.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
