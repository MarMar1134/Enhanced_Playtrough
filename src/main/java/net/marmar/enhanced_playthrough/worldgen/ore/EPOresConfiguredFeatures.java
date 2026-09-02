package net.marmar.enhanced_playthrough.worldgen.ore;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.block.EPBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.DiskConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.RuleBasedBlockStateProvider;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class EPOresConfiguredFeatures {
    //Soulstone
    public static final ResourceKey<ConfiguredFeature<?, ?>> SOULSTONE_PATCH = registerKey("soulstone_patch");

    //Copper
    public static final ResourceKey<ConfiguredFeature<?, ?>> SMALL_COPPER_ORES = registerKey("small_copper_ores");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BIG_COPPER_ORES = registerKey("big_copper_ores");
    public static final ResourceKey<ConfiguredFeature<?, ?>> EXTRA_COPPER_ORES = registerKey("extra_copper_ores");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_COPPER_ORES = registerKey("nether_copper_ores");

    //Tin
    public static final ResourceKey<ConfiguredFeature<?, ?>> SMALL_TIN_ORES = registerKey("small_tin_ores");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BIG_TIN_ORES = registerKey("big_tin_ores");
    public static final ResourceKey<ConfiguredFeature<?, ?>> EXTRA_TIN_ORES = registerKey("extra_tin_ores");

    //Zinc
    public static final ResourceKey<ConfiguredFeature<?, ?>> SMALL_ZINC_ORES = registerKey("small_zinc_ores");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BIG_ZINC_ORES = registerKey("big_zinc_ores");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_ZINC_ORES = registerKey("nether_zinc_ores");

    //Iron
    public static final ResourceKey<ConfiguredFeature<?, ?>> SMALL_IRON_ORES = registerKey("small_iron_ores");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BIG_IRON_ORES = registerKey("big_iron_ores");
    public static final ResourceKey<ConfiguredFeature<?, ?>> EXTRA_IRON_ORES = registerKey("extra_iron_ores");

    //Sulfur
    public static final ResourceKey<ConfiguredFeature<?, ?>> SMALL_SULFUR_ORES = registerKey("small_sulfur_ores");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BIG_SULFUR_ORES = registerKey("big_sulfur_ores");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_SULFUR_ORES = registerKey("nether_sulfur_ores");

    //Silver
    public static final ResourceKey<ConfiguredFeature<?, ?>> SILVER_ORES = registerKey("silver_ores");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BADLANDS_SILVER_ORES = registerKey("badlands_silver_ores");

    //Bauxite
    public static final ResourceKey<ConfiguredFeature<?, ?>> BAUXITE_ORES = registerKey("bauxite_ores");

    //Sapphire
    public static final ResourceKey<ConfiguredFeature<?, ?>> SAPPHIRE_ORES = registerKey("sapphire_ores");
    public static final ResourceKey<ConfiguredFeature<?, ?>> EXTRA_SAPPHIRE_ORES = registerKey("extra_sapphire_ores");

    //Ruby
    public static final ResourceKey<ConfiguredFeature<?, ?>> RUBY_ORES = registerKey("ruby_ores");
    public static final ResourceKey<ConfiguredFeature<?, ?>> EXTRA_RUBY_ORES = registerKey("extra_ruby_ores");

    //Garnet
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_GARNET_ORES = registerKey("nether_garnet_ores");

    //Diamond
    public static final ResourceKey<ConfiguredFeature<?, ?>> LEGACY_DIAMOND_ORES = registerKey("legacy_diamond_ores");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BIG_DIAMOND_ORES = registerKey("big_diamond_ores");
    public static final ResourceKey<ConfiguredFeature<?, ?>> EXTRA_DIAMOND_ORES = registerKey("extra_diamond_ores");

    //Cobalt
    public static final ResourceKey<ConfiguredFeature<?, ?>> COBALT_ORES = registerKey("cobalt_ores");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?,?>> context){
        //Rule tests
        RuleTest stoneReplaceable = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceable = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherrackReplaceable = new BlockMatchTest(Blocks.NETHERRACK);

        //Terracotta
        RuleTest terracottaReplaceable = new BlockMatchTest(Blocks.TERRACOTTA);
        RuleTest whiteTerracottaReplaceable = new BlockMatchTest(Blocks.WHITE_TERRACOTTA);
        RuleTest lightGrayTerracottaReplaceable = new BlockMatchTest(Blocks.LIGHT_GRAY_TERRACOTTA);
        RuleTest brownTerracottaReplaceable = new BlockMatchTest(Blocks.BROWN_TERRACOTTA);
        RuleTest redTerracottaReplaceable = new BlockMatchTest(Blocks.RED_TERRACOTTA);
        RuleTest orangeTerracottaReplaceable = new BlockMatchTest(Blocks.ORANGE_TERRACOTTA);
        RuleTest yellowTerracottaReplaceable = new BlockMatchTest(Blocks.YELLOW_TERRACOTTA);

        //Soulstone
        register(context, SOULSTONE_PATCH, Feature.DISK, new DiskConfiguration(
                RuleBasedBlockStateProvider.simple(EPBlocks.SOULSTONE.get()), BlockPredicate.matchesBlocks(Blocks.NETHERRACK),
                UniformInt.of(2, 6), 4));

        //Copper
        List<OreConfiguration.TargetBlockState> copperOres = List.of(
                OreConfiguration.target(stoneReplaceable, Blocks.COPPER_ORE.defaultBlockState()),
                OreConfiguration.target(deepslateReplaceable, Blocks.DEEPSLATE_COPPER_ORE.defaultBlockState()));

        List<OreConfiguration.TargetBlockState> netherCopperOres = List.of(
                OreConfiguration.target(netherrackReplaceable, EPBlocks.NETHER_COPPER_ORE.get().defaultBlockState()));

        register(context, SMALL_COPPER_ORES, Feature.ORE, new OreConfiguration(copperOres, 8, 0.1f));
        register(context, BIG_COPPER_ORES, Feature.ORE, new OreConfiguration(copperOres, 12, 0.3f));
        register(context, EXTRA_COPPER_ORES, Feature.ORE, new OreConfiguration(copperOres, 12, 0.1f));

        register(context, NETHER_COPPER_ORES, Feature.ORE, new OreConfiguration(netherCopperOres, 8, 0.3f));

        //Tin
        List<OreConfiguration.TargetBlockState> tinOres = List.of(
                OreConfiguration.target(stoneReplaceable, EPBlocks.TIN_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceable, EPBlocks.DEEPSLATE_TIN_ORE.get().defaultBlockState())
        );

        register(context, SMALL_TIN_ORES, Feature.ORE, new OreConfiguration(tinOres, 5, 0.3f));
        register(context, BIG_TIN_ORES, Feature.ORE, new OreConfiguration(tinOres, 7, 0.6f));
        register(context, EXTRA_TIN_ORES, Feature.ORE, new OreConfiguration(tinOres, 7, 0.1f));

        //Zinc
        List<OreConfiguration.TargetBlockState> zincOres = List.of(
                OreConfiguration.target(stoneReplaceable, EPBlocks.ZINC_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceable, EPBlocks.DEEPSLATE_ZINC_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> netherZincOres = List.of(
                OreConfiguration.target(netherrackReplaceable, EPBlocks.NETHER_ZINC_ORE.get().defaultBlockState()));

        register(context, SMALL_ZINC_ORES, Feature.ORE, new OreConfiguration(zincOres, 3, 0.2f));
        register(context, BIG_ZINC_ORES, Feature.ORE, new OreConfiguration(zincOres, 5, 0.5f));
        register(context, NETHER_ZINC_ORES, Feature.ORE, new OreConfiguration(netherZincOres, 9, 0.3f));

        //Iron
        List<OreConfiguration.TargetBlockState> ironOres = List.of(
                OreConfiguration.target(stoneReplaceable, Blocks.IRON_ORE.defaultBlockState()),
                OreConfiguration.target(deepslateReplaceable, Blocks.DEEPSLATE_IRON_ORE.defaultBlockState()));

        register(context, SMALL_IRON_ORES, Feature.ORE, new OreConfiguration(ironOres, 5, 0.4f));
        register(context, BIG_IRON_ORES, Feature.ORE, new OreConfiguration(ironOres, 7, 0.6f));
        register(context, EXTRA_IRON_ORES, Feature.ORE, new OreConfiguration(ironOres, 8, 0.2f));

        //Sulfur
        List<OreConfiguration.TargetBlockState> sulfurOres = List.of(
                OreConfiguration.target(stoneReplaceable, EPBlocks.SULFUR_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceable, EPBlocks.DEEPSLATE_SULFUR_ORE.get().defaultBlockState()));

        register(context, SMALL_SULFUR_ORES, Feature.ORE, new OreConfiguration(sulfurOres, 5, 0.3f));
        register(context, BIG_SULFUR_ORES, Feature.ORE, new OreConfiguration(sulfurOres, 7, 0.4f));

        List<OreConfiguration.TargetBlockState> netherSulphurOres = List.of(
                OreConfiguration.target(netherrackReplaceable, EPBlocks.NETHER_SULFUR_ORE.get().defaultBlockState()));

        register(context, NETHER_SULFUR_ORES, Feature.ORE, new OreConfiguration(netherSulphurOres, 10));

        //Silver
        List<OreConfiguration.TargetBlockState> silverOres = List.of(
                OreConfiguration.target(stoneReplaceable, EPBlocks.SILVER_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceable, EPBlocks.DEEPSLATE_SILVER_ORE.get().defaultBlockState()));

        register(context, SILVER_ORES, Feature.ORE, new OreConfiguration(silverOres, 5, 0.5f));
        register(context, BADLANDS_SILVER_ORES, Feature.ORE, new OreConfiguration(silverOres, 5));

        //Bauxite
        List<OreConfiguration.TargetBlockState> bauxiteOres = List.of(
                OreConfiguration.target(terracottaReplaceable, EPBlocks.BAUXITE.get().defaultBlockState()),
                OreConfiguration.target(whiteTerracottaReplaceable, EPBlocks.WHITE_BAUXITE.get().defaultBlockState()),
                OreConfiguration.target(lightGrayTerracottaReplaceable, EPBlocks.LIGHT_GRAY_BAUXITE.get().defaultBlockState()),
                OreConfiguration.target(brownTerracottaReplaceable, EPBlocks.BROWN_BAUXITE.get().defaultBlockState()),
                OreConfiguration.target(redTerracottaReplaceable, EPBlocks.RED_BAUXITE.get().defaultBlockState()),
                OreConfiguration.target(orangeTerracottaReplaceable, EPBlocks.ORANGE_BAUXITE.get().defaultBlockState()),
                OreConfiguration.target(yellowTerracottaReplaceable, EPBlocks.YELLOW_BAUXITE.get().defaultBlockState()));

        register(context, BAUXITE_ORES, Feature.ORE, new OreConfiguration(bauxiteOres, 8));

        //Sapphire
        List<OreConfiguration.TargetBlockState> sapphireOres = List.of(
                OreConfiguration.target(stoneReplaceable, EPBlocks.SAPPHIRE_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceable, EPBlocks.DEEPSLATE_SAPPHIRE_ORE.get().defaultBlockState()));

        register(context, SAPPHIRE_ORES, Feature.ORE, new OreConfiguration(sapphireOres, 8, 0.4f));
        register(context, EXTRA_SAPPHIRE_ORES, Feature.ORE, new OreConfiguration(sapphireOres, 6, 0.6f));

        //Ruby
        List<OreConfiguration.TargetBlockState> rubyOres = List.of(
                OreConfiguration.target(stoneReplaceable, EPBlocks.RUBY_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceable, EPBlocks.DEEPSLATE_RUBY_ORE.get().defaultBlockState()));

        register(context, RUBY_ORES, Feature.ORE, new OreConfiguration(rubyOres, 6, 0.5f));
        register(context, EXTRA_RUBY_ORES, Feature.ORE, new OreConfiguration(rubyOres, 4, 0.6f));

        //Nether garnet
        List<OreConfiguration.TargetBlockState> garnetOres = List.of(
                OreConfiguration.target(netherrackReplaceable, EPBlocks.NETHER_GARNET_ORE.get().defaultBlockState()));

        register(context, NETHER_GARNET_ORES, Feature.ORE, new OreConfiguration(garnetOres, 5));

        //Diamond
        List<OreConfiguration.TargetBlockState> diamondOres = List.of(
                OreConfiguration.target(stoneReplaceable, Blocks.DIAMOND_ORE.defaultBlockState()),
                OreConfiguration.target(deepslateReplaceable, Blocks.DEEPSLATE_DIAMOND_ORE.defaultBlockState()));

        register(context, LEGACY_DIAMOND_ORES, Feature.ORE, new OreConfiguration(diamondOres, 3, 0.5f));
        register(context, BIG_DIAMOND_ORES, Feature.ORE, new OreConfiguration(diamondOres, 5, 0.7f));
        register(context, EXTRA_DIAMOND_ORES, Feature.ORE, new OreConfiguration(diamondOres, 3, 0.3f));

        //Cobalt
        List<OreConfiguration.TargetBlockState> cobaltOres = List.of(
                OreConfiguration.target(stoneReplaceable, EPBlocks.COBALT_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceable, EPBlocks.DEEPSLATE_COBALT_ORE.get().defaultBlockState()));

        register(context, COBALT_ORES, Feature.ORE, new OreConfiguration(cobaltOres, 5, 0.4f));
    }

    @SuppressWarnings("removal")
    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(EnhancedPlaythrough.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
