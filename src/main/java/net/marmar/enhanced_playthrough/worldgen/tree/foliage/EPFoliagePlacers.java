package net.marmar.enhanced_playthrough.worldgen.tree.foliage;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class EPFoliagePlacers {
    public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACERS = DeferredRegister.create(
            Registries.FOLIAGE_PLACER_TYPE, EnhancedPlaythrough.MOD_ID);

    public static final RegistryObject<FoliagePlacerType<AppleFoliagePlacer>> APPLE_FOLIAGE_PLACER = FOLIAGE_PLACERS.register(
            "apple_foliage_placer", () -> new FoliagePlacerType<>(AppleFoliagePlacer.CODEC));
    public static final RegistryObject<FoliagePlacerType<OrangeFoliagePlacer>> ORANGE_FOLIAGE_PLACER = FOLIAGE_PLACERS.register(
            "orange_foliage_placer", () -> new FoliagePlacerType<>(OrangeFoliagePlacer.CODEC));
    public static final RegistryObject<FoliagePlacerType<LemonFoliagePlacer>> LEMON_FOLIAGE_PLACER = FOLIAGE_PLACERS.register(
            "lemon_foliage_placer", () -> new FoliagePlacerType<>(LemonFoliagePlacer.CODEC));

    public static void register(IEventBus eventBus){
        EnhancedPlaythrough.LOGGER.info("Registering Enhanced Playthrough foliage placers...");
        FOLIAGE_PLACERS.register(eventBus);
    }
}
