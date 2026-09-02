package net.marmar.enhanced_playthrough.worldgen.ore;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.worldgen.EPOrePlacement;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class EPOresPlacedFeatures {
    //Soulstone
    public static final ResourceKey<PlacedFeature> SOULSTONE_PATCH_PLACED = registerKey("soulstone_patch_placed");

    //Copper
    public static final ResourceKey<PlacedFeature> UPPER_COPPER_ORES_PLACED = registerKey("upper_copper_ores_placed");
    public static final ResourceKey<PlacedFeature> LOWER_COPPER_ORES_PLACED = registerKey("lower_copper_ores_placed");
    public static final ResourceKey<PlacedFeature> MOUNTAINS_COPPER_ORES_PLACED = registerKey("mountains_copper_ores_placed");
    public static final ResourceKey<PlacedFeature> DRIPSTONE_CAVES_COPPER_ORES_PLACED = registerKey("dripstone_caves_copper_ores_placed");
    public static final ResourceKey<PlacedFeature> NETHER_COPPER_ORE_PLACED = registerKey("nether_copper_ores_placed");

    //Tin
    public static final ResourceKey<PlacedFeature> UPPER_TIN_ORES_PLACED = registerKey("upper_tin_ores_placed");
    public static final ResourceKey<PlacedFeature> LOWER_TIN_ORES_PLACED = registerKey("lower_tin_ores_placed");
    public static final ResourceKey<PlacedFeature> EXTRA_TIN_ORES_PLACED = registerKey("extra_tin_ores_placed");

    //Zinc
    public static final ResourceKey<PlacedFeature> SMALL_ZINC_ORES_PLACED = registerKey("small_zinc_ores_placed");
    public static final ResourceKey<PlacedFeature> BIG_ZINC_ORES_PLACED = registerKey("big_zinc_ores_placed");
    public static final ResourceKey<PlacedFeature> NETHER_ZINC_ORES_PLACED = registerKey("nether_zinc_ores_placed");

    //Sulfur
    public static final ResourceKey<PlacedFeature> UPPER_SULFUR_ORES_PLACED = registerKey("upper_sulfur_ores_placed");
    public static final ResourceKey<PlacedFeature> LOWER_SULFUR_ORES_PLACED = registerKey("lower_sulfur_ores_placed");
    public static final ResourceKey<PlacedFeature> NETHER_SULFUR_ORES_PLACED = registerKey("nether_sulfur_ores_placed");

    //Iron
    public static final ResourceKey<PlacedFeature> UPPER_IRON_ORES_PLACED = registerKey("upper_iron_ores_placed");
    public static final ResourceKey<PlacedFeature> MIDDLE_IRON_ORES_PLACED = registerKey("middle_iron_ores_placed");
    public static final ResourceKey<PlacedFeature> LOWER_IRON_ORES_PLACED = registerKey("lower_iron_ores_placed");
    public static final ResourceKey<PlacedFeature> EXTRA_IRON_ORES_PLACED = registerKey("extra_iron_ores_placed");

    //Silver
    public static final ResourceKey<PlacedFeature> SILVER_ORES_PLACED = registerKey("silver_ores_placed");
    public static final ResourceKey<PlacedFeature> EXTRA_SILVER_ORES_PLACED = registerKey("extra_silver_ores_placed");
    public static final ResourceKey<PlacedFeature> BADLANDS_SILVER_ORES_PLACED = registerKey("badlands_silver_ores_placed");

    //Bauxite
    public static final ResourceKey<PlacedFeature> BAUXITE_ORES_PLACED = registerKey("bauxite_ores_placed");

    //Sapphire
    public static final ResourceKey<PlacedFeature> SAPPHIRE_ORES_PLACED = registerKey("sapphire_ores_placed");
    public static final ResourceKey<PlacedFeature> EXTRA_SAPPHIRE_ORES_PLACED = registerKey("extra_sapphire_ores_placed");

    //Ruby
    public static final ResourceKey<PlacedFeature> RUBY_ORES_PLACED = registerKey("ruby_ores_placed");
    public static final ResourceKey<PlacedFeature> EXTRA_RUBY_ORES_PLACED = registerKey("extra_ruby_ores_placed");

    //Garnet
    public static final ResourceKey<PlacedFeature> NETHER_GARNET_ORES_PLACED = registerKey("nether_garnet_ores_placed");

    //Diamond
    public static final ResourceKey<PlacedFeature> LEGACY_DIAMOND_ORES_PLACED = registerKey("legacy_diamond_ores_placed");
    public static final ResourceKey<PlacedFeature> LOWER_DIAMOND_ORES_PLACED = registerKey("lower_diamond_ores_placed");
    public static final ResourceKey<PlacedFeature> EXTRA_DIAMOND_ORES_PLACED = registerKey("extra_diamond_ores_placed");

    //Cobalt
    public static final ResourceKey<PlacedFeature> COBALT_ORES_PLACED = registerKey("cobalt_ores_placed");
    
    public static void bootstrap(BootstapContext<PlacedFeature> context){
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        //Soulstone
        register(context, SOULSTONE_PATCH_PLACED, configuredFeatures.getOrThrow(EPOresConfiguredFeatures.SOULSTONE_PATCH),
                EPOrePlacement.commonOrePlacement(5,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-10), VerticalAnchor.absolute(128))));

        //Copper
        register(context, MOUNTAINS_COPPER_ORES_PLACED, configuredFeatures.getOrThrow(EPOresConfiguredFeatures.EXTRA_COPPER_ORES),
                EPOrePlacement.commonOrePlacement(10,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(10), VerticalAnchor.top())));

        register(context, UPPER_COPPER_ORES_PLACED, configuredFeatures.getOrThrow(EPOresConfiguredFeatures.BIG_COPPER_ORES),
                EPOrePlacement.commonOrePlacement(12,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(104))));

        register(context, LOWER_COPPER_ORES_PLACED, configuredFeatures.getOrThrow(EPOresConfiguredFeatures.SMALL_COPPER_ORES),
                EPOrePlacement.commonOrePlacement(10,
                        HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(12))));

        register(context, DRIPSTONE_CAVES_COPPER_ORES_PLACED, configuredFeatures.getOrThrow(EPOresConfiguredFeatures.EXTRA_COPPER_ORES),
                EPOrePlacement.commonOrePlacement(6,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(104))));

        register(context, NETHER_COPPER_ORE_PLACED, configuredFeatures.getOrThrow(EPOresConfiguredFeatures.NETHER_COPPER_ORES),
                EPOrePlacement.commonOrePlacement(12,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(128))));

        //Tin
        register(context, UPPER_TIN_ORES_PLACED, configuredFeatures.getOrThrow(EPOresConfiguredFeatures.BIG_TIN_ORES),
                EPOrePlacement.commonOrePlacement(7,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(10), VerticalAnchor.absolute(130))));

        register(context, LOWER_TIN_ORES_PLACED, configuredFeatures.getOrThrow(EPOresConfiguredFeatures.SMALL_TIN_ORES),
                EPOrePlacement.commonOrePlacement(6,
                        HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(20))));

        register(context, EXTRA_TIN_ORES_PLACED, configuredFeatures.getOrThrow(EPOresConfiguredFeatures.EXTRA_TIN_ORES),
                EPOrePlacement.commonOrePlacement(8,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(0), VerticalAnchor.absolute(70))));

        //Zinc
        register(context, SMALL_ZINC_ORES_PLACED, configuredFeatures.getOrThrow(EPOresConfiguredFeatures.SMALL_ZINC_ORES),
                EPOrePlacement.commonOrePlacement(6,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(-10), VerticalAnchor.absolute(30))));

        register(context, BIG_ZINC_ORES_PLACED, configuredFeatures.getOrThrow(EPOresConfiguredFeatures.BIG_ZINC_ORES),
                EPOrePlacement.commonOrePlacement(9,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(-80), VerticalAnchor.absolute(-10))));

        register(context, NETHER_ZINC_ORES_PLACED, configuredFeatures.getOrThrow(EPOresConfiguredFeatures.NETHER_ZINC_ORES),
                EPOrePlacement.commonOrePlacement(16,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(128))));

        //Iron
        register(context, UPPER_IRON_ORES_PLACED, configuredFeatures.getOrThrow(EPOresConfiguredFeatures.BIG_IRON_ORES),
                EPOrePlacement.commonOrePlacement(5,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(70), VerticalAnchor.top())));

        register(context, MIDDLE_IRON_ORES_PLACED, configuredFeatures.getOrThrow(EPOresConfiguredFeatures.SMALL_IRON_ORES),
                EPOrePlacement.commonOrePlacement(8,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(12), VerticalAnchor.absolute(70))));

        register(context, LOWER_IRON_ORES_PLACED, configuredFeatures.getOrThrow(EPOresConfiguredFeatures.BIG_IRON_ORES),
                EPOrePlacement.commonOrePlacement(10,
                        HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(12))));

        register(context, EXTRA_IRON_ORES_PLACED, configuredFeatures.getOrThrow(EPOresConfiguredFeatures.EXTRA_IRON_ORES),
                EPOrePlacement.commonOrePlacement(10,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(24), VerticalAnchor.top())));

        //Sulfur
        register(context, UPPER_SULFUR_ORES_PLACED, configuredFeatures.getOrThrow(EPOresConfiguredFeatures.SMALL_SULFUR_ORES),
                EPOrePlacement.commonOrePlacement(6,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(-10), VerticalAnchor.absolute(160))));

        register(context, LOWER_SULFUR_ORES_PLACED, configuredFeatures.getOrThrow(EPOresConfiguredFeatures.BIG_SULFUR_ORES),
                EPOrePlacement.commonOrePlacement(8,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(-90), VerticalAnchor.absolute(20))));

        register(context, NETHER_SULFUR_ORES_PLACED, configuredFeatures.getOrThrow(EPOresConfiguredFeatures.NETHER_SULFUR_ORES),
                EPOrePlacement.commonOrePlacement(16,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(-60), VerticalAnchor.absolute(80))));

        //Silver
        register(context, SILVER_ORES_PLACED, configuredFeatures.getOrThrow(EPOresConfiguredFeatures.SILVER_ORES),
                EPOrePlacement.commonOrePlacement(6,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(32))));
        register(context, EXTRA_SILVER_ORES_PLACED, configuredFeatures.getOrThrow(EPOresConfiguredFeatures.SILVER_ORES),
                EPOrePlacement.commonOrePlacement(4,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(-40), VerticalAnchor.absolute(20))));
        register(context, BADLANDS_SILVER_ORES_PLACED, configuredFeatures.getOrThrow(EPOresConfiguredFeatures.BADLANDS_SILVER_ORES),
                EPOrePlacement.commonOrePlacement(10,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(260))));

        //Bauxite
        register(context, BAUXITE_ORES_PLACED, configuredFeatures.getOrThrow(EPOresConfiguredFeatures.BAUXITE_ORES),
                EPOrePlacement.commonOrePlacement(9,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(55), VerticalAnchor.absolute(150))));

        //Sapphire
        register(context, SAPPHIRE_ORES_PLACED, configuredFeatures.getOrThrow(EPOresConfiguredFeatures.SAPPHIRE_ORES),
                EPOrePlacement.commonOrePlacement(14,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(-40), VerticalAnchor.absolute(120))));
        register(context, EXTRA_SAPPHIRE_ORES_PLACED, configuredFeatures.getOrThrow(EPOresConfiguredFeatures.EXTRA_SAPPHIRE_ORES),
                EPOrePlacement.commonOrePlacement(8,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(-70), VerticalAnchor.absolute(40))));

        //Ruby
        register(context, RUBY_ORES_PLACED, configuredFeatures.getOrThrow(EPOresConfiguredFeatures.RUBY_ORES),
                EPOrePlacement.commonOrePlacement(8,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(-20), VerticalAnchor.absolute(130))));
        register(context, EXTRA_RUBY_ORES_PLACED, configuredFeatures.getOrThrow(EPOresConfiguredFeatures.EXTRA_RUBY_ORES),
                EPOrePlacement.commonOrePlacement(5,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(-70), VerticalAnchor.absolute(20))));

        //Nether garnet
        register(context, NETHER_GARNET_ORES_PLACED, configuredFeatures.getOrThrow(EPOresConfiguredFeatures.NETHER_GARNET_ORES),
                EPOrePlacement.commonOrePlacement(7,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-20), VerticalAnchor.absolute(100))));

        //Diamond
        register(context, LEGACY_DIAMOND_ORES_PLACED, configuredFeatures.getOrThrow(EPOresConfiguredFeatures.LEGACY_DIAMOND_ORES),
                EPOrePlacement.commonOrePlacement(5,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(0), VerticalAnchor.absolute(24))));
        register(context, LOWER_DIAMOND_ORES_PLACED, configuredFeatures.getOrThrow(EPOresConfiguredFeatures.BIG_DIAMOND_ORES),
                EPOrePlacement.commonOrePlacement(7,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(-80), VerticalAnchor.absolute(12))));
        register(context, EXTRA_DIAMOND_ORES_PLACED, configuredFeatures.getOrThrow(EPOresConfiguredFeatures.EXTRA_DIAMOND_ORES),
                EPOrePlacement.commonOrePlacement(4,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(-80), VerticalAnchor.absolute(80))));

        //Cobalt
        register(context, COBALT_ORES_PLACED, configuredFeatures.getOrThrow(EPOresConfiguredFeatures.COBALT_ORES),
                EPOrePlacement.commonOrePlacement(4,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(15))));
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
