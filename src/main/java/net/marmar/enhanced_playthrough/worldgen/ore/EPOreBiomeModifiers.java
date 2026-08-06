package net.marmar.enhanced_playthrough.worldgen.ore;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.datagen.tag.EPTags;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;

public class EPOreBiomeModifiers {
    public static final ResourceKey<BiomeModifier> ADD_NETHER_COPPER_ORES = registerKey("add_nether_copper_ores");
    public static final ResourceKey<BiomeModifier> ADD_SOULSTONE_PATCH = registerKey("add_soulstone_patch");

    public static final ResourceKey<BiomeModifier> ADD_SMALL_TIN_ORES = registerKey("add_small_tin_ores");
    public static final ResourceKey<BiomeModifier> ADD_BIG_TIN_ORES = registerKey("add_big_tin_ores");
    public static final ResourceKey<BiomeModifier> ADD_EXTRA_TIN_ORES = registerKey("add_extra_tin_ores");

    public static final ResourceKey<BiomeModifier> ADD_SMALL_ZINC_ORES = registerKey("add_small_zinc_ores");
    public static final ResourceKey<BiomeModifier> ADD_BIG_ZINC_ORES = registerKey("add_big_zinc_ores");
    public static final ResourceKey<BiomeModifier> ADD_NETHER_ZINC_ORES = registerKey("add_nether_zinc_ores");

    public static final ResourceKey<BiomeModifier> ADD_UPPER_SULFUR_ORES = registerKey("add_upper_sulfur_ores");
    public static final ResourceKey<BiomeModifier> ADD_EXTRA_SULFUR_ORES = registerKey("add_extra_sulfur_ores");
    public static final ResourceKey<BiomeModifier> ADD_LOWER_SULFUR_ORES = registerKey("add_lower_sulfur_ores");
    public static final ResourceKey<BiomeModifier> ADD_NETHER_SULFUR_ORES = registerKey("add_nether_sulfur_ores");

    public static final ResourceKey<BiomeModifier> ADD_SILVER_ORES = registerKey("add_silver_ores");
    public static final ResourceKey<BiomeModifier> ADD_EXTRA_SILVER_ORES = registerKey("add_extra_silver_ores");
    public static final ResourceKey<BiomeModifier> ADD_BADLANDS_SILVER_ORES = registerKey("add_badlands_silver_ores");

    public static final ResourceKey<BiomeModifier> ADD_BAUXITE_ORES = registerKey("add_bauxite_ores");

    public static final ResourceKey<BiomeModifier> ADD_SAPPHIRE_ORES = registerKey("add_sapphire_ores");
    public static final ResourceKey<BiomeModifier> ADD_EXTRA_SAPPHIRE_ORES = registerKey("add_extra_sapphire_ores");

    public static final ResourceKey<BiomeModifier> ADD_RUBY_ORES = registerKey("add_ruby_ores");
    public static final ResourceKey<BiomeModifier> ADD_EXTRA_RUBY_ORES = registerKey("add_extra_ruby_ores");

    public static final ResourceKey<BiomeModifier> ADD_NETHER_GARNET_ORES = registerKey("add_nether_garnet_ores");

    public static final ResourceKey<BiomeModifier> ADD_COBALT_ORES = registerKey("add_cobalt_ores");

    public static void bootstrap(BootstapContext<BiomeModifier> context){
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        //Copper
        context.register(ADD_NETHER_COPPER_ORES, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_NETHER),
                HolderSet.direct(placedFeatures.getOrThrow(EPOresPlacedFeatures.NETHER_COPPER_ORE_PLACED)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        //Soulstone
        context.register(ADD_SOULSTONE_PATCH, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_NETHER),
                HolderSet.direct(placedFeatures.getOrThrow(EPOresPlacedFeatures.SOULSTONE_PATCH_PLACED)),
                GenerationStep.Decoration.UNDERGROUND_DECORATION));

        //Tin
        context.register(ADD_SMALL_TIN_ORES, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(EPOresPlacedFeatures.SMALL_TIN_ORES_PLACED)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(ADD_BIG_TIN_ORES, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(EPOresPlacedFeatures.BIG_TIN_ORES_PLACED)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_EXTRA_TIN_ORES, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(EPOresPlacedFeatures.EXTRA_TIN_ORES_PLACED)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        //Zinc
        context.register(ADD_SMALL_ZINC_ORES, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(EPOresPlacedFeatures.SMALL_ZINC_ORES_PLACED)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(ADD_BIG_ZINC_ORES, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(EPOresPlacedFeatures.BIG_ZINC_ORES_PLACED)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_NETHER_ZINC_ORES, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_NETHER),
                HolderSet.direct(placedFeatures.getOrThrow(EPOresPlacedFeatures.NETHER_ZINC_ORES_PLACED)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        //Sulfur
        context.register(ADD_UPPER_SULFUR_ORES, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(EPOresPlacedFeatures.UPPER_SULFUR_ORES_PLACED)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(ADD_EXTRA_SULFUR_ORES, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.STONY_PEAKS), biomes.getOrThrow(Biomes.JAGGED_PEAKS),
                        biomes.getOrThrow(Biomes.SNOWY_SLOPES), biomes.getOrThrow(Biomes.FROZEN_PEAKS)),
                HolderSet.direct(placedFeatures.getOrThrow(EPOresPlacedFeatures.EXTRA_SULFUR_ORES_PLACED)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(ADD_LOWER_SULFUR_ORES, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(EPOresPlacedFeatures.LOWER_SULFUR_ORES_PLACED)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_NETHER_SULFUR_ORES, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_NETHER),
                HolderSet.direct(placedFeatures.getOrThrow(EPOresPlacedFeatures.NETHER_SULFUR_ORES_PLACED)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        //Silver
        context.register(ADD_SILVER_ORES, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(EPOresPlacedFeatures.SILVER_ORES_PLACED)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_EXTRA_SILVER_ORES, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(EPOresPlacedFeatures.EXTRA_SILVER_ORES_PLACED)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_BADLANDS_SILVER_ORES, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.BADLANDS)),
                HolderSet.direct(placedFeatures.getOrThrow(EPOresPlacedFeatures.BADLANDS_SILVER_ORES_PLACED)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        //Bauxite
        context.register(ADD_BAUXITE_ORES, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_BADLANDS),
                HolderSet.direct(placedFeatures.getOrThrow(EPOresPlacedFeatures.BAUXITE_ORES_PLACED)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        //Sapphire
        context.register(ADD_SAPPHIRE_ORES, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(EPTags.Biomes.HUMIDITY_BIOMES),
                HolderSet.direct(placedFeatures.getOrThrow(EPOresPlacedFeatures.SAPPHIRE_ORES_PLACED)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_EXTRA_SAPPHIRE_ORES, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(EPTags.Biomes.HUMIDITY_BIOMES),
                HolderSet.direct(placedFeatures.getOrThrow(EPOresPlacedFeatures.EXTRA_SAPPHIRE_ORES_PLACED)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        //Ruby
        context.register(ADD_RUBY_ORES, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(EPTags.Biomes.HUMIDITY_BIOMES),
                HolderSet.direct(placedFeatures.getOrThrow(EPOresPlacedFeatures.RUBY_ORES_PLACED)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_EXTRA_RUBY_ORES, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(EPTags.Biomes.HUMIDITY_BIOMES),
                HolderSet.direct(placedFeatures.getOrThrow(EPOresPlacedFeatures.EXTRA_RUBY_ORES_PLACED)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        //Nether garnet
        context.register(ADD_NETHER_GARNET_ORES, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_NETHER),
                HolderSet.direct(placedFeatures.getOrThrow(EPOresPlacedFeatures.NETHER_GARNET_ORES_PLACED)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        //Cobalt
        context.register(ADD_COBALT_ORES, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(EPOresPlacedFeatures.COBALT_ORES_PLACED)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
    }

    @SuppressWarnings("removal")
    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(EnhancedPlaythrough.MOD_ID, name));
    }
}
