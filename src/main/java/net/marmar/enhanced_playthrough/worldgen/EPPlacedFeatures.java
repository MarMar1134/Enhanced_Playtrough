package net.marmar.enhanced_playthrough.worldgen;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.block.EPBlocks;
import net.marmar.enhanced_playthrough.worldgen.ore.EPOresPlacedFeatures;
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

    public static void  bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        EPOresPlacedFeatures.bootstrap(context);

        //Mud
        register(context, MUD_PATCH_PLACED, configuredFeatures.getOrThrow(EPConfiguredFeatures.MUD_PATCH),
                EPOrePlacement.commonOrePlacement(5,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-6), VerticalAnchor.absolute(66))));

        //Limestone
        register(context, LIMESTONE_PATCH_PLACED, configuredFeatures.getOrThrow(EPConfiguredFeatures.LIMESTONE_PATCH),
                EPOrePlacement.commonOrePlacement(8,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-10), VerticalAnchor.absolute(200))));

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
