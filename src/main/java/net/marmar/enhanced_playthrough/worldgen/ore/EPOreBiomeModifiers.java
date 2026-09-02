package net.marmar.enhanced_playthrough.worldgen.ore;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.datagen.tag.EPTags;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.OrePlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Set;

public class EPOreBiomeModifiers {
    //Vanilla ore generation removers
        //Copper
        public static final ResourceKey<BiomeModifier> REMOVE_COPPER_ORE = registerKey("remove_copper_ore");
        public static final ResourceKey<BiomeModifier> REMOVE_COPPER_LARGE_ORE = registerKey("remove_copper_large_ore");

        //Iron
        public static final ResourceKey<BiomeModifier> REMOVE_IRON_UPPER_ORE = registerKey("remove_iron_upper_ore");
        public static final ResourceKey<BiomeModifier> REMOVE_IRON_MIDDLE_ORE = registerKey("remove_iron_middle_ore");
        public static final ResourceKey<BiomeModifier> REMOVE_IRON_SMALL_ORE = registerKey("remove_iron_small_ore");

        //Diamond
        public static final ResourceKey<BiomeModifier> REMOVE_DIAMOND_ORE = registerKey("remove_diamond_ore");
        public static final ResourceKey<BiomeModifier> REMOVE_DIAMOND_LARGE_ORE = registerKey("remove_diamond_large_ore");
        public static final ResourceKey<BiomeModifier> REMOVE_DIAMOND_BURIED_ORE = registerKey("remove_diamond_buried_ore");

    //New ores
        //Soulstone
        public static final ResourceKey<BiomeModifier> ADD_SOULSTONE_PATCH = registerKey("add_soulstone_patch");

        //Copper
        public static final ResourceKey<BiomeModifier> ADD_MOUNTAINS_COPPER_ORES = registerKey("add_mountains_copper_ores");
        public static final ResourceKey<BiomeModifier> ADD_UPPER_COPPER_ORES = registerKey("add_upper_copper_ores");
        public static final ResourceKey<BiomeModifier> ADD_LOWER_COPPER_ORES = registerKey("add_lower_copper_ores");
        public static final ResourceKey<BiomeModifier> ADD_DRIPSTONE_CAVES_COPPER_ORES = registerKey("add_dripstone_caves_copper_ores");
        public static final ResourceKey<BiomeModifier> ADD_NETHER_COPPER_ORES = registerKey("add_nether_copper_ores");

        //Tin
        public static final ResourceKey<BiomeModifier> ADD_UPPER_TIN_ORES = registerKey("add_upper_tin_ores");
        public static final ResourceKey<BiomeModifier> ADD_LOWER_TIN_ORES = registerKey("add_lower_tin_ores");
        public static final ResourceKey<BiomeModifier> ADD_EXTRA_TIN_ORES = registerKey("add_extra_tin_ores");

        //Zinc
        public static final ResourceKey<BiomeModifier> ADD_SMALL_ZINC_ORES = registerKey("add_small_zinc_ores");
        public static final ResourceKey<BiomeModifier> ADD_BIG_ZINC_ORES = registerKey("add_big_zinc_ores");
        public static final ResourceKey<BiomeModifier> ADD_NETHER_ZINC_ORES = registerKey("add_nether_zinc_ores");

        //Iron
        public static final ResourceKey<BiomeModifier> ADD_UPPER_IRON_ORES = registerKey("add_upper_iron_ores");
        public static final ResourceKey<BiomeModifier> ADD_MIDDLE_IRON_ORES = registerKey("add_middle_iron_ores");
        public static final ResourceKey<BiomeModifier> ADD_LOWER_IRON_ORES = registerKey("add_lower_iron_ores");
        public static final ResourceKey<BiomeModifier> ADD_EXTRA_IRON_ORES = registerKey("add_extra_iron_ores");

        //Sulfur
        public static final ResourceKey<BiomeModifier> ADD_UPPER_SULFUR_ORES = registerKey("add_upper_sulfur_ores");
        public static final ResourceKey<BiomeModifier> ADD_LOWER_SULFUR_ORES = registerKey("add_lower_sulfur_ores");
        public static final ResourceKey<BiomeModifier> ADD_NETHER_SULFUR_ORES = registerKey("add_nether_sulfur_ores");

        //Silver
        public static final ResourceKey<BiomeModifier> ADD_SILVER_ORES = registerKey("add_silver_ores");
        public static final ResourceKey<BiomeModifier> ADD_EXTRA_SILVER_ORES = registerKey("add_extra_silver_ores");
        public static final ResourceKey<BiomeModifier> ADD_BADLANDS_SILVER_ORES = registerKey("add_badlands_silver_ores");

        //Bauxite
        public static final ResourceKey<BiomeModifier> ADD_BAUXITE_ORES = registerKey("add_bauxite_ores");

        //Sapphire
        public static final ResourceKey<BiomeModifier> ADD_SAPPHIRE_ORES = registerKey("add_sapphire_ores");
        public static final ResourceKey<BiomeModifier> ADD_EXTRA_SAPPHIRE_ORES = registerKey("add_extra_sapphire_ores");

        //Ruby
        public static final ResourceKey<BiomeModifier> ADD_RUBY_ORES = registerKey("add_ruby_ores");
        public static final ResourceKey<BiomeModifier> ADD_EXTRA_RUBY_ORES = registerKey("add_extra_ruby_ores");

        //Garnet
        public static final ResourceKey<BiomeModifier> ADD_NETHER_GARNET_ORES = registerKey("add_nether_garnet_ores");

        //Diamond
        public static final ResourceKey<BiomeModifier> ADD_LEGACY_DIAMOND_ORES = registerKey("add_legacy_diamond_ores");
        public static final ResourceKey<BiomeModifier> ADD_LOWER_DIAMOND_ORES = registerKey("add_lower_diamond_ores");
        public static final ResourceKey<BiomeModifier> ADD_EXTRA_DIAMOND_ORES = registerKey("add_extra_diamond_ores");

        //Cobalt
        public static final ResourceKey<BiomeModifier> ADD_COBALT_ORES = registerKey("add_cobalt_ores");

    private static void removeVanillaOres(BootstapContext<BiomeModifier> pContext){
        var placedFeatures = pContext.lookup(Registries.PLACED_FEATURE);
        var biomes = pContext.lookup(Registries.BIOME);

        //Copper
        pContext.register(REMOVE_COPPER_ORE, new ForgeBiomeModifiers.RemoveFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(OrePlacements.ORE_COPPER)),
                Set.of(GenerationStep.Decoration.UNDERGROUND_ORES)));

        pContext.register(REMOVE_COPPER_LARGE_ORE, new ForgeBiomeModifiers.RemoveFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(OrePlacements.ORE_COPPER_LARGE)),
                Set.of(GenerationStep.Decoration.UNDERGROUND_ORES)));

        //Iron
        pContext.register(REMOVE_IRON_UPPER_ORE, new ForgeBiomeModifiers.RemoveFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(OrePlacements.ORE_IRON_UPPER)),
                Set.of(GenerationStep.Decoration.UNDERGROUND_ORES)));

        pContext.register(REMOVE_IRON_MIDDLE_ORE, new ForgeBiomeModifiers.RemoveFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(OrePlacements.ORE_IRON_MIDDLE)),
                Set.of(GenerationStep.Decoration.UNDERGROUND_ORES)));

        pContext.register(REMOVE_IRON_SMALL_ORE, new ForgeBiomeModifiers.RemoveFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(OrePlacements.ORE_IRON_SMALL)),
                Set.of(GenerationStep.Decoration.UNDERGROUND_ORES)));

        //Diamond
        pContext.register(REMOVE_DIAMOND_ORE, new ForgeBiomeModifiers.RemoveFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(OrePlacements.ORE_DIAMOND)),
                Set.of(GenerationStep.Decoration.UNDERGROUND_ORES)));

        pContext.register(REMOVE_DIAMOND_LARGE_ORE, new ForgeBiomeModifiers.RemoveFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(OrePlacements.ORE_DIAMOND_LARGE)),
                Set.of(GenerationStep.Decoration.UNDERGROUND_ORES)));

        pContext.register(REMOVE_DIAMOND_BURIED_ORE, new ForgeBiomeModifiers.RemoveFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(OrePlacements.ORE_DIAMOND_BURIED)),
                Set.of(GenerationStep.Decoration.UNDERGROUND_ORES)));
    }
    
    private static void addNewOres(BootstapContext<BiomeModifier> pContext){
        var placedFeatures = pContext.lookup(Registries.PLACED_FEATURE);
        var biomes = pContext.lookup(Registries.BIOME);

        //Soulstone
        pContext.register(ADD_SOULSTONE_PATCH, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_NETHER),
                HolderSet.direct(placedFeatures.getOrThrow(EPOresPlacedFeatures.SOULSTONE_PATCH_PLACED)),
                GenerationStep.Decoration.UNDERGROUND_DECORATION));

        //Copper
        pContext.register(ADD_MOUNTAINS_COPPER_ORES, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_MOUNTAIN),
                HolderSet.direct(placedFeatures.getOrThrow(EPOresPlacedFeatures.MOUNTAINS_COPPER_ORES_PLACED)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        pContext.register(ADD_UPPER_COPPER_ORES, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(EPOresPlacedFeatures.UPPER_COPPER_ORES_PLACED)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        pContext.register(ADD_LOWER_COPPER_ORES, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(EPOresPlacedFeatures.LOWER_COPPER_ORES_PLACED)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        pContext.register(ADD_DRIPSTONE_CAVES_COPPER_ORES, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.DRIPSTONE_CAVES)),
                HolderSet.direct(placedFeatures.getOrThrow(EPOresPlacedFeatures.DRIPSTONE_CAVES_COPPER_ORES_PLACED)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        pContext.register(ADD_NETHER_COPPER_ORES, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_NETHER),
                HolderSet.direct(placedFeatures.getOrThrow(EPOresPlacedFeatures.NETHER_COPPER_ORE_PLACED)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        //Tin
        pContext.register(ADD_UPPER_TIN_ORES, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(EPOresPlacedFeatures.UPPER_TIN_ORES_PLACED)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        pContext.register(ADD_LOWER_TIN_ORES, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(EPOresPlacedFeatures.LOWER_TIN_ORES_PLACED)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        pContext.register(ADD_EXTRA_TIN_ORES, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(EPOresPlacedFeatures.EXTRA_TIN_ORES_PLACED)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        //Zinc
        pContext.register(ADD_SMALL_ZINC_ORES, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(EPOresPlacedFeatures.SMALL_ZINC_ORES_PLACED)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        pContext.register(ADD_BIG_ZINC_ORES, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(EPOresPlacedFeatures.BIG_ZINC_ORES_PLACED)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        pContext.register(ADD_NETHER_ZINC_ORES, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_NETHER),
                HolderSet.direct(placedFeatures.getOrThrow(EPOresPlacedFeatures.NETHER_ZINC_ORES_PLACED)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        //Iron
        pContext.register(ADD_UPPER_IRON_ORES, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(EPOresPlacedFeatures.UPPER_IRON_ORES_PLACED)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        pContext.register(ADD_MIDDLE_IRON_ORES, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(EPOresPlacedFeatures.MIDDLE_IRON_ORES_PLACED)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        pContext.register(ADD_LOWER_IRON_ORES, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(EPOresPlacedFeatures.LOWER_IRON_ORES_PLACED)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        pContext.register(ADD_EXTRA_IRON_ORES, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_MOUNTAIN),
                HolderSet.direct(placedFeatures.getOrThrow(EPOresPlacedFeatures.EXTRA_IRON_ORES_PLACED)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        //Sulfur
        pContext.register(ADD_UPPER_SULFUR_ORES, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(EPOresPlacedFeatures.UPPER_SULFUR_ORES_PLACED)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        pContext.register(ADD_LOWER_SULFUR_ORES, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(EPOresPlacedFeatures.LOWER_SULFUR_ORES_PLACED)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        pContext.register(ADD_NETHER_SULFUR_ORES, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_NETHER),
                HolderSet.direct(placedFeatures.getOrThrow(EPOresPlacedFeatures.NETHER_SULFUR_ORES_PLACED)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        //Silver
        pContext.register(ADD_SILVER_ORES, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(EPOresPlacedFeatures.SILVER_ORES_PLACED)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        pContext.register(ADD_EXTRA_SILVER_ORES, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(EPOresPlacedFeatures.EXTRA_SILVER_ORES_PLACED)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        pContext.register(ADD_BADLANDS_SILVER_ORES, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.BADLANDS)),
                HolderSet.direct(placedFeatures.getOrThrow(EPOresPlacedFeatures.BADLANDS_SILVER_ORES_PLACED)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        //Bauxite
        pContext.register(ADD_BAUXITE_ORES, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_BADLANDS),
                HolderSet.direct(placedFeatures.getOrThrow(EPOresPlacedFeatures.BAUXITE_ORES_PLACED)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        //Sapphire
        pContext.register(ADD_SAPPHIRE_ORES, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(EPTags.Biomes.HUMIDITY_BIOMES),
                HolderSet.direct(placedFeatures.getOrThrow(EPOresPlacedFeatures.SAPPHIRE_ORES_PLACED)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        pContext.register(ADD_EXTRA_SAPPHIRE_ORES, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(EPTags.Biomes.HUMIDITY_BIOMES),
                HolderSet.direct(placedFeatures.getOrThrow(EPOresPlacedFeatures.EXTRA_SAPPHIRE_ORES_PLACED)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        //Ruby
        pContext.register(ADD_RUBY_ORES, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(EPTags.Biomes.HUMIDITY_BIOMES),
                HolderSet.direct(placedFeatures.getOrThrow(EPOresPlacedFeatures.RUBY_ORES_PLACED)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        pContext.register(ADD_EXTRA_RUBY_ORES, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(EPTags.Biomes.HUMIDITY_BIOMES),
                HolderSet.direct(placedFeatures.getOrThrow(EPOresPlacedFeatures.EXTRA_RUBY_ORES_PLACED)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        //Nether garnet
        pContext.register(ADD_NETHER_GARNET_ORES, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_NETHER),
                HolderSet.direct(placedFeatures.getOrThrow(EPOresPlacedFeatures.NETHER_GARNET_ORES_PLACED)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        //Diamond
        pContext.register(ADD_LEGACY_DIAMOND_ORES, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(EPOresPlacedFeatures.LEGACY_DIAMOND_ORES_PLACED)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
        pContext.register(ADD_LOWER_DIAMOND_ORES, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(EPOresPlacedFeatures.LOWER_DIAMOND_ORES_PLACED)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
        pContext.register(ADD_EXTRA_DIAMOND_ORES, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_SAVANNA),
                HolderSet.direct(placedFeatures.getOrThrow(EPOresPlacedFeatures.EXTRA_DIAMOND_ORES_PLACED)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        //Cobalt
        pContext.register(ADD_COBALT_ORES, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(EPOresPlacedFeatures.COBALT_ORES_PLACED)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
    }

    public static void bootstrap(BootstapContext<BiomeModifier> pContext){
        removeVanillaOres(pContext);
        addNewOres(pContext);
    }

    @SuppressWarnings("removal")
    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(EnhancedPlaythrough.MOD_ID, name));
    }
}
