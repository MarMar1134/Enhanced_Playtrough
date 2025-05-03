package net.marmar.enhanced_playthrough.Util;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageEffects;
import net.minecraft.world.damagesource.DamageType;

public interface ModDamageTypes {
    ResourceKey<DamageType> TALL_REED = registryKey("tall_reed");

    static void bootstrap(BootstapContext<DamageType> pContext){
        pContext.register(TALL_REED, new DamageType("tallReed", 0.2f, DamageEffects.POKING));
    }

    private static ResourceKey<DamageType> registryKey(String name){
        return ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(EnhancedPlaythrough.MOD_ID, name));
    }
}
