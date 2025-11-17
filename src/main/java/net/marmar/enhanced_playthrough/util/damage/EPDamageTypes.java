package net.marmar.enhanced_playthrough.util.damage;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageEffects;
import net.minecraft.world.damagesource.DamageScaling;
import net.minecraft.world.damagesource.DamageType;

public interface EPDamageTypes {
    ResourceKey<DamageType> TALL_REED = registryKey("tall_reed");
    ResourceKey<DamageType> COBBLE = registryKey("cobble");
    ResourceKey<DamageType> BLEED = registryKey("bleed");

    static void bootstrap(BootstapContext<DamageType> pContext){
        pContext.register(TALL_REED, new DamageType("tallReed", 0.1f, DamageEffects.POKING));
        pContext.register(COBBLE, new DamageType("cobble", 0.1f));
        pContext.register(BLEED, new DamageType("bleed", DamageScaling.ALWAYS,0.1f));
    }

    private static ResourceKey<DamageType> registryKey(String name){
        return ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(EnhancedPlaythrough.MOD_ID, name));
    }
}
