package net.marmar.enhanced_playthrough.Util;

import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

public class ModDamageSources{
    private final Registry<DamageType> damageTypes;

    private final DamageSource tall_reed;
    private final DamageSource cobble;

    public ModDamageSources(RegistryAccess registryAccess){
        this.damageTypes = registryAccess.registryOrThrow(Registries.DAMAGE_TYPE);

        this.tall_reed = this.source(ModDamageTypes.TALL_REED);
        this.cobble = this.source(ModDamageTypes.COBBLE);
    }

    public DamageSource tallReed(){
        return this.tall_reed;
    }

    public DamageSource cobble(){
        return this.cobble;
    }

    private DamageSource source(ResourceKey<DamageType> pDamageTypeKey) {
        return new DamageSource(this.damageTypes.getHolderOrThrow(pDamageTypeKey));
    }

    private DamageSource source(ResourceKey<DamageType> pDamageTypeKey, @Nullable Entity pEntity) {
        return new DamageSource(this.damageTypes.getHolderOrThrow(pDamageTypeKey), pEntity);
    }

    private DamageSource source(ResourceKey<DamageType> pDamageTypeKey, @Nullable Entity pCausingEntity, @Nullable Entity pDirectEntity) {
        return new DamageSource(this.damageTypes.getHolderOrThrow(pDamageTypeKey), pCausingEntity, pDirectEntity);
    }
}
