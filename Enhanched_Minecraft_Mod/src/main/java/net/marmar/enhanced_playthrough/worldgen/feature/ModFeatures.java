package net.marmar.enhanced_playthrough.worldgen.feature;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES =
            DeferredRegister.create(ForgeRegistries.FEATURES, EnhancedPlaythrough.MOD_ID);

    public static final RegistryObject<Feature<RandomPatchConfiguration>> WATER_REEDS = FEATURES.register("water_reeds_feature",
            () -> new WaterReedsFeature(RandomPatchConfiguration.CODEC));

    public static void register(IEventBus eventBus){
        FEATURES.register(eventBus);
    }
}
