package net.marmar.enhanced_playthrough.worldgen;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.block.ModBlocks;
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

public class ModPlacedFeatures {
    //Trees
    public static final ResourceKey<PlacedFeature> WALNUT_PLACED_KEY = registerKey("walnut_placed");
    public static final ResourceKey<PlacedFeature> APPLE_PLACED_KEY = registerKey("apple_placed");
    public static final ResourceKey<PlacedFeature> ORANGE_PLACED_KEY = registerKey("orange_placed");
    public static final ResourceKey<PlacedFeature> LEMON_PLACED_KEY = registerKey("lemon_placed");
    public static final ResourceKey<PlacedFeature> LIME_PLACED_KEY = registerKey("lime_placed");

    //Nature
    public static final ResourceKey<PlacedFeature> LIMESTONE_PLACED_KEY = registerKey("limestone_placed");
    public static final ResourceKey<PlacedFeature> MUD_PATCH_PLACED_KEY = registerKey("mud_patch_placed");

    //Wild crops
    public static final ResourceKey<PlacedFeature> WILD_WHEAT_PLACED_KEY = registerKey("wild_wheat_placed");
    public static final ResourceKey<PlacedFeature> WILD_TOMATO_PLACED_KEY = registerKey("wild_tomato_placed");
    public static final ResourceKey<PlacedFeature> WILD_CORN_PLACED_KEY = registerKey("wild_corn_placed");

    //Plants
    public static final ResourceKey<PlacedFeature> TALL_REEDS_OVERWORLD_PLACED_KEY = registerKey("tall_reeds_overworld_placed");
    public static final ResourceKey<PlacedFeature> TALL_REEDS_SWAMP_PLACED_KEY = registerKey("tall_reeds_swamp_placed");

    public static final ResourceKey<PlacedFeature> REEDS_OVERWORLD_PLACED_KEY = registerKey("reeds_overworld_placed");
    public static final ResourceKey<PlacedFeature> REEDS_SWAMP_PLACED_KEY = registerKey("reeds_swamp_placed");

    public static final ResourceKey<PlacedFeature> SMALL_REEDS_OVERWORLD_PLACED_KEY = registerKey("small_reeds_overworld_placed");
    public static final ResourceKey<PlacedFeature> SMALL_REEDS_SWAMP_PLACED_KEY = registerKey("small_reeds_swamp_placed");
    public static final ResourceKey<PlacedFeature> SMALL_REEDS_PLATEAU_PLACED_KEY = registerKey("small_reeds_plateau_placed");

    public static final ResourceKey<PlacedFeature> WATER_REEDS_OVERWORLD_PLACED_KEY = registerKey("water_reeds_overworld_placed");
    public static final ResourceKey<PlacedFeature> WATER_REEDS_SWAMP_PLACED_KEY = registerKey("water_reeds_swamp_placed");
    public static final ResourceKey<PlacedFeature> WATER_REEDS_LUSH_CAVES_PLACED_KEY = registerKey("water_reeds_lush_caves_placed");

    //Ores
    public static final ResourceKey<PlacedFeature> NETHER_COPPER_ORE_PLACED_KEY = registerKey("nether_copper_ore_placed");

    public static final ResourceKey<PlacedFeature> TIN_ORE_PLACED_KEY = registerKey("tin_ore_placed");
    public static final ResourceKey<PlacedFeature> EXTRA_TIN_ORE_PLACED_KEY = registerKey("extra_tin_ore_placed");

    public static final ResourceKey<PlacedFeature> ZINC_ORE_PLACED_KEY = registerKey("zinc_ore_placed");
    public static final ResourceKey<PlacedFeature> NETHER_ZINC_ORE_PLACED_KEY = registerKey("nether_zinc_ore_placed");

    public static final ResourceKey<PlacedFeature> SILVER_ORE_PLACED_KEY = registerKey("silver_ore_placed");
    public static final ResourceKey<PlacedFeature> EXTRA_SILVER_ORE_PLACED_KEY = registerKey("extra_silver_ore_placed");
    public static final ResourceKey<PlacedFeature> BADLANDS_SILVER_ORE_PLACED_KEY = registerKey("badlands_silver_ore_placed");

    public static final ResourceKey<PlacedFeature> SULPHUR_ORE_PLACED_KEY = registerKey("sulphur_ore_placed");
    public static final ResourceKey<PlacedFeature> NETHER_SULPHUR_ORE_PLACED_KEY = registerKey("nether_sulphur_ore_placed");

    public static final ResourceKey<PlacedFeature> COBALT_PLACED_KEY = registerKey("cobalt_ore_placed");

    public static final ResourceKey<PlacedFeature> SAPPHIRE_ORE_PLACED_KEY = registerKey("sapphire_ore_placed");
    public static final ResourceKey<PlacedFeature> RUBI_ORE_PLACED_KEY = registerKey("rubi_ore_placed");

    public static final ResourceKey<PlacedFeature> EXTRA_SAPPHIRE_ORE_PLACED_KEY = registerKey("extra_sapphire_ore_placed");
    public static final ResourceKey<PlacedFeature> EXTRA_RUBI_ORE_PLACED_KEY = registerKey("extra_rubi_ore_placed");

    public static final ResourceKey<PlacedFeature> NETHER_GARNET_ORE_PLACED_KEY = registerKey("nether_garnet_ore_placed");

    public static final ResourceKey<PlacedFeature> BAUXITE_ORES_PLACED_KEY = registerKey("bauxite_ores_placed");

    public static void  bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        //Mud
        register(context, MUD_PATCH_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.MUD_PATCH_KEY),
                ModOrePlacement.commonOrePlacement(5,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-6), VerticalAnchor.absolute(66))));

        //Limestone
        register(context, LIMESTONE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.LIMESTONE_KEY),
                ModOrePlacement.commonOrePlacement(8,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-10), VerticalAnchor.absolute(200))));

        //Copper
        register(context, NETHER_COPPER_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHER_COPPER_ORE_KEY),
                ModOrePlacement.commonOrePlacement(12,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(128))));

        //Tin
        register(context, TIN_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.TIN_ORE_KEY),
                ModOrePlacement.commonOrePlacement(14,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(-40), VerticalAnchor.absolute(80))));

        register(context, EXTRA_TIN_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.EXTRA_TIN_ORE_KEY),
                ModOrePlacement.commonOrePlacement(15,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(90), VerticalAnchor.absolute(130))));

        //Zinc
        register(context, ZINC_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.ZINC_ORE_KEY),
                ModOrePlacement.commonOrePlacement(13,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(-50), VerticalAnchor.absolute(30))));

        register(context, NETHER_ZINC_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHER_ZINC_ORE_KEY),
                ModOrePlacement.commonOrePlacement(16,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(128))));

        //Silver
        register(context, SILVER_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SILVER_ORE_KEY),
                ModOrePlacement.commonOrePlacement(12,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(-32), VerticalAnchor.absolute(40))));
        register(context, EXTRA_SILVER_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.EXTRA_SILVER_ORE_KEY),
                ModOrePlacement.commonOrePlacement(4,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(41), VerticalAnchor.absolute(110))));
        register(context, BADLANDS_SILVER_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.BADLANDS_SILVER_ORE_KEY),
                ModOrePlacement.commonOrePlacement(10,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(-30), VerticalAnchor.absolute(90))));

        //Bauxite
        register(context, BAUXITE_ORES_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.BAUXITE_ORES_KEY),
                ModOrePlacement.commonOrePlacement(9,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(55), VerticalAnchor.absolute(150))));

        //Sulphur
        register(context, SULPHUR_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SULFUR_ORE_KEY),
                ModOrePlacement.commonOrePlacement(8,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(-60), VerticalAnchor.absolute(80))));
        register(context, NETHER_SULPHUR_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHER_SULFUR_ORE_KEY),
                ModOrePlacement.commonOrePlacement(16,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(-60), VerticalAnchor.absolute(80))));

        //Cobalt
        register(context, COBALT_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.COBALT_KEY),
                ModOrePlacement.commonOrePlacement(4,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(15))));

        //Sapphire
        register(context, SAPPHIRE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SAPPHIRE_ORE_KEY),
                ModOrePlacement.commonOrePlacement(14,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(-40), VerticalAnchor.absolute(120))));
        register(context, EXTRA_SAPPHIRE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.EXTRA_SAPPHIRE_ORE_KEY),
                ModOrePlacement.commonOrePlacement(8,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(-40), VerticalAnchor.absolute(120))));

        //Rubi
        register(context, RUBI_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.RUBY_ORE_KEY),
                ModOrePlacement.commonOrePlacement(8,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(-40), VerticalAnchor.absolute(120))));
        register(context, EXTRA_RUBI_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.EXTRA_RUBY_ORE_KEY),
                ModOrePlacement.commonOrePlacement(5,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(-40), VerticalAnchor.absolute(120))));

        //Garnet
        register(context, NETHER_GARNET_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHER_GARNET_ORE_KEY),
                ModOrePlacement.commonOrePlacement(5,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(64))));

        //Trees
            //Walnut
            register(context, WALNUT_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.WALNUT_KEY),
                    VegetationPlacements.treePlacement(PlacementUtils.countExtra(2, 0.1f, 3),
                            ModBlocks.WALNUT_SAPLING.get()));

            //Apple
            register(context, APPLE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.APPLE_KEY),
                    VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1f, 1),
                            ModBlocks.APPLE_SAPLING.get()));

            //Orange
            register(context, ORANGE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.ORANGE_KEY),
                    VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1f, 1),
                            ModBlocks.ORANGE_SAPLING.get()));

            //Lemon
            register(context, LEMON_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.LEMON_KEY),
                    VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1f, 1),
                            ModBlocks.LEMON_SAPLING.get()));

            //Lime
            register(context, LIME_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.LIME_KEY),
                    VegetationPlacements.treePlacement(PlacementUtils.countExtra(2, 0.1f, 1),
                            ModBlocks.LIME_SAPLING.get()));

        //Wild crops
        register(context, WILD_WHEAT_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.WILD_WHEAT_KEY),
                List.of(new PlacementModifier[]{RarityFilter.onAverageOnceEvery(30), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()}));
        register(context, WILD_TOMATO_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.WILD_TOMATO_KEY),
                List.of(new PlacementModifier[]{RarityFilter.onAverageOnceEvery(40), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()}));
        register(context, WILD_CORN_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.WILD_CORN_KEY),
                List.of(new PlacementModifier[]{RarityFilter.onAverageOnceEvery(40), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()}));

        //Plants
        register(context, TALL_REEDS_OVERWORLD_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.TALL_REEDS_KEY),
                List.of(new PlacementModifier[]{RarityFilter.onAverageOnceEvery(20), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()}));
        register(context, TALL_REEDS_SWAMP_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.TALL_REEDS_KEY),
                List.of(new PlacementModifier[]{RarityFilter.onAverageOnceEvery(3), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()}));

        register(context, REEDS_OVERWORLD_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.REEDS_KEY),
                List.of(new PlacementModifier[]{RarityFilter.onAverageOnceEvery(3), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()}));
        register(context, REEDS_SWAMP_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.REEDS_KEY),
                List.of(new PlacementModifier[]{RarityFilter.onAverageOnceEvery(6), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()}));

        register(context, SMALL_REEDS_OVERWORLD_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SMALL_REEDS_OVERWORLD_KEY),
                List.of(new PlacementModifier[]{RarityFilter.onAverageOnceEvery(3), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()}));
        register(context, SMALL_REEDS_SWAMP_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SMALL_REEDS_OVERWORLD_KEY),
                List.of(new PlacementModifier[]{RarityFilter.onAverageOnceEvery(8), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()}));
        register(context, SMALL_REEDS_PLATEAU_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SMALL_REEDS_PLATEAU_KEY),
                List.of(new PlacementModifier[]{RarityFilter.onAverageOnceEvery(6), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()}));

        register(context, WATER_REEDS_OVERWORLD_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.WATER_REEDS_OVERWORLD_KEY),
                List.of(new PlacementModifier[]{RarityFilter.onAverageOnceEvery(10), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()}));
        register(context, WATER_REEDS_SWAMP_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.WATER_REEDS_SWAMP_KEY),
                List.of(new PlacementModifier[]{RarityFilter.onAverageOnceEvery(2), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()}));
        register(context, WATER_REEDS_LUSH_CAVES_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.WATER_REEDS_LUSH_CAVES_KEY),
                List.of(new PlacementModifier[]{RarityFilter.onAverageOnceEvery(4), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()}));
    }


    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(EnhancedPlaythrough.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
