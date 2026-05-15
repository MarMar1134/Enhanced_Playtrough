package net.marmar.enhanced_playthrough.worldgen;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.block.EPBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class EPPlacedFeatures {
    //Trees
    public static final ResourceKey<PlacedFeature> WALNUT_TREES_PLACED = registerKey("walnut_trees_placed");
    public static final ResourceKey<PlacedFeature> APPLE_TREES_PLACED = registerKey("apple_trees_placed");
    public static final ResourceKey<PlacedFeature> ORANGE_TREES_PLACED = registerKey("orange_trees_placed");
    public static final ResourceKey<PlacedFeature> LEMON_TREES_PLACED = registerKey("lemon_trees_placed");
    public static final ResourceKey<PlacedFeature> LIME_TREES_PLACED = registerKey("lime_trees_placed");

    //Nature
    public static final ResourceKey<PlacedFeature> LIMESTONE_PATCH_PLACED = registerKey("limestone_patch_placed");
    public static final ResourceKey<PlacedFeature> MUD_PATCH_PLACED = registerKey("mud_patch_placed");

    //Wild crops
    public static final ResourceKey<PlacedFeature> WILD_WHEAT_PLACED = registerKey("wild_wheat_placed");
    public static final ResourceKey<PlacedFeature> WILD_TOMATO_PLACED = registerKey("wild_tomato_placed");
    public static final ResourceKey<PlacedFeature> WILD_CORN_PLACED = registerKey("wild_corn_placed");

    //Plants
    public static final ResourceKey<PlacedFeature> SMALL_REEDS_OVERWORLD_PLACED = registerKey("small_reeds_overworld_placed");
    public static final ResourceKey<PlacedFeature> SMALL_REEDS_SWAMP_PLACED = registerKey("small_reeds_swamp_placed");
    public static final ResourceKey<PlacedFeature> SMALL_REEDS_PLATEAU_PLACED = registerKey("small_reeds_plateau_placed");

    public static final ResourceKey<PlacedFeature> REEDS_OVERWORLD_PLACED = registerKey("reeds_overworld_placed");
    public static final ResourceKey<PlacedFeature> REEDS_SWAMP_PLACED = registerKey("reeds_swamp_placed");

    public static final ResourceKey<PlacedFeature> TALL_REEDS_OVERWORLD_PLACED = registerKey("tall_reeds_overworld_placed");
    public static final ResourceKey<PlacedFeature> TALL_REEDS_SWAMP_PLACED = registerKey("tall_reeds_swamp_placed");

    public static final ResourceKey<PlacedFeature> KENAF_PLACED = registerKey("kenaf_placed");

    public static final ResourceKey<PlacedFeature> WATER_REEDS_OVERWORLD_PLACED = registerKey("water_reeds_overworld_placed");
    public static final ResourceKey<PlacedFeature> WATER_REEDS_SWAMP_PLACED = registerKey("water_reeds_swamp_placed");
    public static final ResourceKey<PlacedFeature> WATER_REEDS_LUSH_CAVES_PLACED = registerKey("water_reeds_lush_caves_placed");

    //Flowers
    public static final ResourceKey<PlacedFeature> COLD_LYRIUM_PLACED = registerKey("cold_lyrium_placed");
    public static final ResourceKey<PlacedFeature> SUCCULENT_PLACED = registerKey("succulent_placed");

    //Ores
    public static final ResourceKey<PlacedFeature> NETHER_COPPER_ORE_PLACED = registerKey("nether_copper_ores_placed");

    public static final ResourceKey<PlacedFeature> SMALL_TIN_ORES_PLACED = registerKey("small_tin_ores_placed");
    public static final ResourceKey<PlacedFeature> BIG_TIN_ORES_PLACED = registerKey("big_tin_ores_placed");
    public static final ResourceKey<PlacedFeature> EXTRA_TIN_ORES_PLACED = registerKey("extra_tin_ores_placed");

    public static final ResourceKey<PlacedFeature> SMALL_ZINC_ORES_PLACED = registerKey("small_zinc_ores_placed");
    public static final ResourceKey<PlacedFeature> BIG_ZINC_ORES_PLACED = registerKey("big_zinc_ores_placed");
    public static final ResourceKey<PlacedFeature> NETHER_ZINC_ORES_PLACED = registerKey("nether_zinc_ores_placed");

    public static final ResourceKey<PlacedFeature> UPPER_SULFUR_ORES_PLACED = registerKey("upper_sulfur_ores_placed");
    public static final ResourceKey<PlacedFeature> LOWER_SULFUR_ORES_PLACED = registerKey("lower_sulfur_ores_placed");
    public static final ResourceKey<PlacedFeature> EXTRA_SULFUR_ORES_PLACED = registerKey("extra_sulfur_ores_placed");
    public static final ResourceKey<PlacedFeature> NETHER_SULFUR_ORES_PLACED = registerKey("nether_sulfur_ores_placed");

    public static final ResourceKey<PlacedFeature> SILVER_ORES_PLACED = registerKey("silver_ores_placed");
    public static final ResourceKey<PlacedFeature> EXTRA_SILVER_ORES_PLACED = registerKey("extra_silver_ores_placed");
    public static final ResourceKey<PlacedFeature> BADLANDS_SILVER_ORES_PLACED = registerKey("badlands_silver_ores_placed");

    public static final ResourceKey<PlacedFeature> BAUXITE_ORES_PLACED = registerKey("bauxite_ores_placed");

    public static final ResourceKey<PlacedFeature> SAPPHIRE_ORES_PLACED = registerKey("sapphire_ores_placed");
    public static final ResourceKey<PlacedFeature> EXTRA_SAPPHIRE_ORES_PLACED = registerKey("extra_sapphire_ores_placed");

    public static final ResourceKey<PlacedFeature> RUBY_ORES_PLACED = registerKey("ruby_ores_placed");
    public static final ResourceKey<PlacedFeature> EXTRA_RUBY_ORES_PLACED = registerKey("extra_ruby_ores_placed");

    public static final ResourceKey<PlacedFeature> NETHER_GARNET_ORES_PLACED = registerKey("nether_garnet_ores_placed");

    public static final ResourceKey<PlacedFeature> COBALT_ORES_PLACED = registerKey("cobalt_ores_placed");

    public static void  bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        //Mud
        register(context, MUD_PATCH_PLACED, configuredFeatures.getOrThrow(EPConfiguredFeatures.MUD_PATCH),
                EPOrePlacement.commonOrePlacement(5,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-6), VerticalAnchor.absolute(66))));

        //Limestone
        register(context, LIMESTONE_PATCH_PLACED, configuredFeatures.getOrThrow(EPConfiguredFeatures.LIMESTONE_PATCH),
                EPOrePlacement.commonOrePlacement(8,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-10), VerticalAnchor.absolute(200))));

        //Copper
        register(context, NETHER_COPPER_ORE_PLACED, configuredFeatures.getOrThrow(EPConfiguredFeatures.NETHER_COPPER_ORES),
                EPOrePlacement.commonOrePlacement(12,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(128))));

        //Tin
        register(context, SMALL_TIN_ORES_PLACED, configuredFeatures.getOrThrow(EPConfiguredFeatures.SMALL_TIN_ORES),
                EPOrePlacement.commonOrePlacement(7,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(-40), VerticalAnchor.absolute(30))));

        register(context, BIG_TIN_ORES_PLACED, configuredFeatures.getOrThrow(EPConfiguredFeatures.BIG_TIN_ORES),
                EPOrePlacement.commonOrePlacement(12,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(20), VerticalAnchor.absolute(120))));

        register(context, EXTRA_TIN_ORES_PLACED, configuredFeatures.getOrThrow(EPConfiguredFeatures.SMALL_TIN_ORES),
                EPOrePlacement.commonOrePlacement(6,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(90), VerticalAnchor.absolute(140))));

        //Zinc
        register(context, SMALL_ZINC_ORES_PLACED, configuredFeatures.getOrThrow(EPConfiguredFeatures.SMALL_ZINC_ORES),
                EPOrePlacement.commonOrePlacement(6,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(-10), VerticalAnchor.absolute(30))));

        register(context, BIG_ZINC_ORES_PLACED, configuredFeatures.getOrThrow(EPConfiguredFeatures.BIG_ZINC_ORES),
                EPOrePlacement.commonOrePlacement(9,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(-80), VerticalAnchor.absolute(-10))));

        register(context, NETHER_ZINC_ORES_PLACED, configuredFeatures.getOrThrow(EPConfiguredFeatures.NETHER_ZINC_ORES),
                EPOrePlacement.commonOrePlacement(16,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(128))));

        //Sulfur
        register(context, UPPER_SULFUR_ORES_PLACED, configuredFeatures.getOrThrow(EPConfiguredFeatures.SMALL_SULFUR_ORES),
                EPOrePlacement.commonOrePlacement(6,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(-10), VerticalAnchor.absolute(160))));
        register(context, EXTRA_SULFUR_ORES_PLACED, configuredFeatures.getOrThrow(EPConfiguredFeatures.SMALL_SULFUR_ORES),
                EPOrePlacement.commonOrePlacement(5,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(70), VerticalAnchor.absolute(190))));
        register(context, LOWER_SULFUR_ORES_PLACED, configuredFeatures.getOrThrow(EPConfiguredFeatures.BIG_SULFUR_ORES),
                EPOrePlacement.commonOrePlacement(8,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(-90), VerticalAnchor.absolute(20))));

        register(context, NETHER_SULFUR_ORES_PLACED, configuredFeatures.getOrThrow(EPConfiguredFeatures.NETHER_SULFUR_ORES),
                EPOrePlacement.commonOrePlacement(16,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(-60), VerticalAnchor.absolute(80))));

        //Silver
        register(context, SILVER_ORES_PLACED, configuredFeatures.getOrThrow(EPConfiguredFeatures.SILVER_ORES),
                EPOrePlacement.commonOrePlacement(6,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(32))));
        register(context, EXTRA_SILVER_ORES_PLACED, configuredFeatures.getOrThrow(EPConfiguredFeatures.SILVER_ORES),
                EPOrePlacement.commonOrePlacement(4,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(-40), VerticalAnchor.absolute(20))));
        register(context, BADLANDS_SILVER_ORES_PLACED, configuredFeatures.getOrThrow(EPConfiguredFeatures.BADLANDS_SILVER_ORES),
                EPOrePlacement.commonOrePlacement(10,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(260))));

        //Bauxite
        register(context, BAUXITE_ORES_PLACED, configuredFeatures.getOrThrow(EPConfiguredFeatures.BAUXITE_ORES),
                EPOrePlacement.commonOrePlacement(9,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(55), VerticalAnchor.absolute(150))));

        //Sapphire
        register(context, SAPPHIRE_ORES_PLACED, configuredFeatures.getOrThrow(EPConfiguredFeatures.SAPPHIRE_ORES),
                EPOrePlacement.commonOrePlacement(14,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(-40), VerticalAnchor.absolute(120))));
        register(context, EXTRA_SAPPHIRE_ORES_PLACED, configuredFeatures.getOrThrow(EPConfiguredFeatures.EXTRA_SAPPHIRE_ORES),
                EPOrePlacement.commonOrePlacement(8,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(-70), VerticalAnchor.absolute(-40))));

        //Ruby
        register(context, RUBY_ORES_PLACED, configuredFeatures.getOrThrow(EPConfiguredFeatures.RUBY_ORES),
                EPOrePlacement.commonOrePlacement(8,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(-20), VerticalAnchor.absolute(130))));
        register(context, EXTRA_RUBY_ORES_PLACED, configuredFeatures.getOrThrow(EPConfiguredFeatures.EXTRA_RUBY_ORES),
                EPOrePlacement.commonOrePlacement(5,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(-70), VerticalAnchor.absolute(-20))));

        //Nether garnet
        register(context, NETHER_GARNET_ORES_PLACED, configuredFeatures.getOrThrow(EPConfiguredFeatures.NETHER_GARNET_ORES),
                EPOrePlacement.commonOrePlacement(7,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-20), VerticalAnchor.absolute(100))));

        //Cobalt
        register(context, COBALT_ORES_PLACED, configuredFeatures.getOrThrow(EPConfiguredFeatures.COBALT_ORES),
                EPOrePlacement.commonOrePlacement(4,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(15))));

        //Trees
            //Walnut
            register(context, WALNUT_TREES_PLACED, configuredFeatures.getOrThrow(EPConfiguredFeatures.WALNUT_TREES),
                    VegetationPlacements.treePlacement(PlacementUtils.countExtra(2, 0.1f, 3),
                            EPBlocks.WALNUT_SAPLING.get()));

            //Apple
            register(context, APPLE_TREES_PLACED, configuredFeatures.getOrThrow(EPConfiguredFeatures.APPLE_TREES),
                    VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1f, 1),
                            EPBlocks.APPLE_SAPLING.get()));

            //Orange
            register(context, ORANGE_TREES_PLACED, configuredFeatures.getOrThrow(EPConfiguredFeatures.ORANGE_TREES),
                    VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1f, 1),
                            EPBlocks.ORANGE_SAPLING.get()));

            //Lemon
            register(context, LEMON_TREES_PLACED, configuredFeatures.getOrThrow(EPConfiguredFeatures.LEMON_TREES),
                    VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1f, 1),
                            EPBlocks.LEMON_SAPLING.get()));

            //Lime
            register(context, LIME_TREES_PLACED, configuredFeatures.getOrThrow(EPConfiguredFeatures.LIME_TREES),
                    VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1f, 0),
                            EPBlocks.LIME_SAPLING.get()));

        //Wild crops
        register(context, WILD_WHEAT_PLACED, configuredFeatures.getOrThrow(EPConfiguredFeatures.WILD_WHEAT),
                List.of(new PlacementModifier[]{RarityFilter.onAverageOnceEvery(30), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()}));
        register(context, WILD_TOMATO_PLACED, configuredFeatures.getOrThrow(EPConfiguredFeatures.WILD_TOMATO),
                List.of(new PlacementModifier[]{RarityFilter.onAverageOnceEvery(40), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()}));
        register(context, WILD_CORN_PLACED, configuredFeatures.getOrThrow(EPConfiguredFeatures.WILD_CORN),
                List.of(new PlacementModifier[]{RarityFilter.onAverageOnceEvery(40), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()}));

        //Plants
        register(context, SMALL_REEDS_OVERWORLD_PLACED, configuredFeatures.getOrThrow(EPConfiguredFeatures.SMALL_REEDS_OVERWORLD),
                List.of(new PlacementModifier[]{RarityFilter.onAverageOnceEvery(3), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()}));
        register(context, SMALL_REEDS_SWAMP_PLACED, configuredFeatures.getOrThrow(EPConfiguredFeatures.SMALL_REEDS_OVERWORLD),
                List.of(new PlacementModifier[]{RarityFilter.onAverageOnceEvery(8), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()}));
        register(context, SMALL_REEDS_PLATEAU_PLACED, configuredFeatures.getOrThrow(EPConfiguredFeatures.SMALL_REEDS_PLATEAU),
                List.of(new PlacementModifier[]{RarityFilter.onAverageOnceEvery(6), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()}));

        register(context, REEDS_OVERWORLD_PLACED, configuredFeatures.getOrThrow(EPConfiguredFeatures.REEDS),
                List.of(new PlacementModifier[]{RarityFilter.onAverageOnceEvery(3), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()}));
        register(context, REEDS_SWAMP_PLACED, configuredFeatures.getOrThrow(EPConfiguredFeatures.REEDS),
                List.of(new PlacementModifier[]{RarityFilter.onAverageOnceEvery(6), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()}));

        register(context, TALL_REEDS_OVERWORLD_PLACED, configuredFeatures.getOrThrow(EPConfiguredFeatures.TALL_REEDS),
                List.of(new PlacementModifier[]{RarityFilter.onAverageOnceEvery(20), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()}));
        register(context, TALL_REEDS_SWAMP_PLACED, configuredFeatures.getOrThrow(EPConfiguredFeatures.TALL_REEDS),
                List.of(new PlacementModifier[]{RarityFilter.onAverageOnceEvery(3), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()}));

        register(context, KENAF_PLACED, configuredFeatures.getOrThrow(EPConfiguredFeatures.KENAF),
                List.of(new PlacementModifier[]{RarityFilter.onAverageOnceEvery(30), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()}));

        register(context, WATER_REEDS_OVERWORLD_PLACED, configuredFeatures.getOrThrow(EPConfiguredFeatures.WATER_REEDS_OVERWORLD),
                List.of(new PlacementModifier[]{RarityFilter.onAverageOnceEvery(10), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()}));
        register(context, WATER_REEDS_SWAMP_PLACED, configuredFeatures.getOrThrow(EPConfiguredFeatures.WATER_REEDS_SWAMP),
                List.of(new PlacementModifier[]{RarityFilter.onAverageOnceEvery(2), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()}));
        register(context, WATER_REEDS_LUSH_CAVES_PLACED, configuredFeatures.getOrThrow(EPConfiguredFeatures.WATER_REEDS_LUSH_CAVES),
                List.of(new PlacementModifier[]{RarityFilter.onAverageOnceEvery(4), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()}));

        //Flowers
        register(context, COLD_LYRIUM_PLACED, configuredFeatures.getOrThrow(EPConfiguredFeatures.COLD_LYRIUM),
                List.of(new PlacementModifier[]{RarityFilter.onAverageOnceEvery(6), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()}));
        register(context, SUCCULENT_PLACED, configuredFeatures.getOrThrow(EPConfiguredFeatures.SUCCULENT),
                List.of(new PlacementModifier[]{RarityFilter.onAverageOnceEvery(4), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()}));
    }

    @SuppressWarnings("removal")
    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(EnhancedPlaythrough.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
