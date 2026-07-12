package net.marmar.enhanced_playthrough.worldgen;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.data.tag.EPTags;
import net.marmar.enhanced_playthrough.entity.EPEntityTypes;
import net.marmar.enhanced_playthrough.worldgen.ore.EPOreBiomeModifiers;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;

public class EPBiomeModifiers {
    //Trees
    public static final ResourceKey<BiomeModifier> ADD_WALNUT = registerKey("add_walnut");
    public static final ResourceKey<BiomeModifier> ADD_APPLE = registerKey("add_apple");
    public static final ResourceKey<BiomeModifier> ADD_ORANGE = registerKey("add_orange");
    public static final ResourceKey<BiomeModifier> ADD_LEMON = registerKey("add_lemon");
    public static final ResourceKey<BiomeModifier> ADD_LIME = registerKey("add_lime");

    //Nature
    public static final ResourceKey<BiomeModifier> ADD_LIMESTONE_PATCH = registerKey("add_limestone_patch");
    public static final ResourceKey<BiomeModifier> ADD_MUD_PATCH = registerKey("add_mud_patch");

    //Wild crops
    public static final ResourceKey<BiomeModifier> ADD_WILD_WHEAT = registerKey("add_wild_wheat");
    public static final ResourceKey<BiomeModifier> ADD_WILD_TOMATO = registerKey("add_wild_tomato");
    public static final ResourceKey<BiomeModifier> ADD_WILD_CORN = registerKey("add_wild_corn");

    //Plants
    public static final ResourceKey<BiomeModifier> ADD_SMALL_REEDS_OVERWORLD = registerKey("add_small_reeds_overworld");
    public static final ResourceKey<BiomeModifier> ADD_SMALL_REEDS_SWAMP = registerKey("add_small_reeds_swamp");
    public static final ResourceKey<BiomeModifier> ADD_SMALL_REEDS_PLATEAU = registerKey("add_small_reeds_plateau");

    public static final ResourceKey<BiomeModifier> ADD_REEDS_OVERWORLD = registerKey("add_reeds_overworld");
    public static final ResourceKey<BiomeModifier> ADD_REEDS_SWAMP = registerKey("add_reeds_swamp");

    public static final ResourceKey<BiomeModifier> ADD_KENAF = registerKey("add_kenaf");

    public static final ResourceKey<BiomeModifier> ADD_TALL_REEDS_OVERWORLD = registerKey("add_tall_reeds_overworld");
    public static final ResourceKey<BiomeModifier> ADD_TALL_REEDS_SWAMP = registerKey("add_tall_reeds_swamp");

    public static final ResourceKey<BiomeModifier> ADD_WATER_REEDS_OVERWORLD = registerKey("add_water_reeds_overworld");
    public static final ResourceKey<BiomeModifier> ADD_WATER_REEDS_SWAMP = registerKey("add_water_reeds_swamp");
    public static final ResourceKey<BiomeModifier> ADD_WATER_REEDS_LUSH_CAVES = registerKey("add_water_reeds_lush_caves");

    //Flowers
    public static final ResourceKey<BiomeModifier> ADD_COLD_LYRIUM = registerKey("add_cold_lyrium");
    public static final ResourceKey<BiomeModifier> ADD_SUCCULENT = registerKey("add_succulent");

    //Mobs
    public static final ResourceKey<BiomeModifier> ADD_ZOMBIE_KNIGHT_SPAWNS = registerKey("add_zombie_knight_spawns");
    public static final ResourceKey<BiomeModifier> ADD_ZOMBIE_KNIGHT_SPAWNS_ON_DESERT = registerKey("add_zombie_knight_spawns_on_desert");

    public static final ResourceKey<BiomeModifier> ADD_SKELETON_BOWMASTER_SPAWNS = registerKey("add_skeleton_bowmaster_spawns");
    public static final ResourceKey<BiomeModifier> ADD_SKELETON_BOWMASTER_SPAWNS_ON_SNOW = registerKey("add_skeleton_bowmaster_spawns_on_snow");

    public static final ResourceKey<BiomeModifier> ADD_WERELLAGER_SPAWNS = registerKey("add_werellager_spawns");

    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        //Ores
        EPOreBiomeModifiers.bootstrap(context);

        //Mud
        context.register(ADD_MUD_PATCH, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.RIVER), biomes.getOrThrow(Biomes.SWAMP)),
                HolderSet.direct(placedFeatures.getOrThrow(EPPlacedFeatures.MUD_PATCH_PLACED)),
                GenerationStep.Decoration.LAKES));

        //Limestone
        context.register(ADD_LIMESTONE_PATCH, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(EPPlacedFeatures.LIMESTONE_PATCH_PLACED)),
                GenerationStep.Decoration.UNDERGROUND_DECORATION));

        //Trees
            //Walnut
            context.register(ADD_WALNUT, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                    biomes.getOrThrow(BiomeTags.IS_TAIGA),
                    HolderSet.direct(placedFeatures.getOrThrow(EPPlacedFeatures.WALNUT_TREES_PLACED)),
                    GenerationStep.Decoration.VEGETAL_DECORATION));

            //Apple
            context.register(ADD_APPLE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.FOREST)),
                HolderSet.direct(placedFeatures.getOrThrow(EPPlacedFeatures.APPLE_TREES_PLACED)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

            //Orange
            context.register(ADD_ORANGE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.FLOWER_FOREST)),
                HolderSet.direct(placedFeatures.getOrThrow(EPPlacedFeatures.ORANGE_TREES_PLACED)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

            //Lemon
            context.register(ADD_LEMON, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.BIRCH_FOREST)),
                HolderSet.direct(placedFeatures.getOrThrow(EPPlacedFeatures.LEMON_TREES_PLACED)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

            //Lime
            context.register(ADD_LIME, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.BIRCH_FOREST)),
                HolderSet.direct(placedFeatures.getOrThrow(EPPlacedFeatures.LIME_TREES_PLACED)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        //Wild crops
        context.register(ADD_WILD_WHEAT, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.PLAINS)),
                HolderSet.direct(placedFeatures.getOrThrow(EPPlacedFeatures.WILD_WHEAT_PLACED)),
                GenerationStep.Decoration.LAKES));
        context.register(ADD_WILD_TOMATO, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.WINDSWEPT_HILLS), biomes.getOrThrow(Biomes.JAGGED_PEAKS)),
                HolderSet.direct(placedFeatures.getOrThrow(EPPlacedFeatures.WILD_TOMATO_PLACED)),
                GenerationStep.Decoration.VEGETAL_DECORATION));
        context.register(ADD_WILD_CORN, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.JUNGLE), biomes.getOrThrow(Biomes.SPARSE_JUNGLE)),
                HolderSet.direct(placedFeatures.getOrThrow(EPPlacedFeatures.WILD_CORN_PLACED)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        //Plants
        context.register(ADD_SMALL_REEDS_OVERWORLD, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(EPTags.Biomes.TEMPLATE_BIOMES),
                HolderSet.direct(placedFeatures.getOrThrow(EPPlacedFeatures.SMALL_REEDS_OVERWORLD_PLACED)),
                GenerationStep.Decoration.VEGETAL_DECORATION));
        context.register(ADD_SMALL_REEDS_SWAMP, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.SWAMP)),
                HolderSet.direct(placedFeatures.getOrThrow(EPPlacedFeatures.SMALL_REEDS_SWAMP_PLACED)),
                GenerationStep.Decoration.VEGETAL_DECORATION));
        context.register(ADD_SMALL_REEDS_PLATEAU, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.WINDSWEPT_HILLS), biomes.getOrThrow(Biomes.WINDSWEPT_FOREST)),
                HolderSet.direct(placedFeatures.getOrThrow(EPPlacedFeatures.SMALL_REEDS_PLATEAU_PLACED)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_REEDS_OVERWORLD, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(EPTags.Biomes.TEMPLATE_BIOMES),
                HolderSet.direct(placedFeatures.getOrThrow(EPPlacedFeatures.REEDS_OVERWORLD_PLACED)),
                GenerationStep.Decoration.VEGETAL_DECORATION));
        context.register(ADD_REEDS_SWAMP, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.SWAMP)),
                HolderSet.direct(placedFeatures.getOrThrow(EPPlacedFeatures.REEDS_SWAMP_PLACED)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_KENAF, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_SAVANNA),
                HolderSet.direct(placedFeatures.getOrThrow(EPPlacedFeatures.KENAF_PLACED)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_TALL_REEDS_OVERWORLD, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(EPTags.Biomes.TEMPLATE_BIOMES),
                HolderSet.direct(placedFeatures.getOrThrow(EPPlacedFeatures.TALL_REEDS_OVERWORLD_PLACED)),
                GenerationStep.Decoration.VEGETAL_DECORATION));
        context.register(ADD_TALL_REEDS_SWAMP, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.SWAMP)),
                HolderSet.direct(placedFeatures.getOrThrow(EPPlacedFeatures.TALL_REEDS_SWAMP_PLACED)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_WATER_REEDS_OVERWORLD, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(EPPlacedFeatures.WATER_REEDS_OVERWORLD_PLACED)),
                GenerationStep.Decoration.VEGETAL_DECORATION));
        context.register(ADD_WATER_REEDS_SWAMP, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.SWAMP), biomes.getOrThrow(Biomes.MANGROVE_SWAMP)),
                HolderSet.direct(placedFeatures.getOrThrow(EPPlacedFeatures.WATER_REEDS_SWAMP_PLACED)),
                GenerationStep.Decoration.VEGETAL_DECORATION));
        context.register(ADD_WATER_REEDS_LUSH_CAVES, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.LUSH_CAVES)),
                HolderSet.direct(placedFeatures.getOrThrow(EPPlacedFeatures.WATER_REEDS_LUSH_CAVES_PLACED)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        //Flowers
        context.register(ADD_COLD_LYRIUM, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.SPAWNS_SNOW_FOXES),
                HolderSet.direct(placedFeatures.getOrThrow(EPPlacedFeatures.COLD_LYRIUM_PLACED)),
                GenerationStep.Decoration.VEGETAL_DECORATION));
        context.register(ADD_SUCCULENT, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(EPTags.Biomes.DESERT_BIOMES),
                HolderSet.direct(placedFeatures.getOrThrow(EPPlacedFeatures.SUCCULENT_PLACED)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        //Zombie knight
        context.register(ADD_ZOMBIE_KNIGHT_SPAWNS, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(EPTags.Biomes.CAN_SPAWN_ZOMBIE_KNIGHT),
                List.of(new MobSpawnSettings.SpawnerData(EPEntityTypes.ZOMBIE_KNIGHT.get(), 80, 2, 4))));

        context.register(ADD_ZOMBIE_KNIGHT_SPAWNS_ON_DESERT, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(EPTags.Biomes.DESERT_BIOMES),
                List.of(new MobSpawnSettings.SpawnerData(EPEntityTypes.ZOMBIE_KNIGHT.get(), 30, 2, 4))));

        //Skeleton bowmaster
        context.register(ADD_SKELETON_BOWMASTER_SPAWNS, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(EPTags.Biomes.CAN_SPAWN_SKELETON_BOWMASTER),
                List.of(new MobSpawnSettings.SpawnerData(EPEntityTypes.SKELETON_BOWMASTER.get(), 70, 2, 4))));

        context.register(ADD_SKELETON_BOWMASTER_SPAWNS_ON_SNOW, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(EPTags.Biomes.FROZEN_BIOMES),
                List.of(new MobSpawnSettings.SpawnerData(EPEntityTypes.SKELETON_BOWMASTER.get(), 30, 2, 4))));

        //Werellager
        context.register(ADD_WERELLAGER_SPAWNS, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(EPTags.Biomes.CAN_SPAWN_WERELLAGER),
                List.of(new MobSpawnSettings.SpawnerData(EPEntityTypes.WERELLAGER.get(), 90, 2, 4))));
    }

    @SuppressWarnings("removal")
    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(EnhancedPlaythrough.MOD_ID, name));
    }
}
