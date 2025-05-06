package net.marmar.enhanced_playthrough.entity;

import net.marmar.enhanced_playthrough.Util.ModDamageSources;
import net.marmar.enhanced_playthrough.item.ModItems;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;

public class CobbleProjectileEntity extends ThrowableItemProjectile {
    public CobbleProjectileEntity(EntityType<? extends ThrowableItemProjectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public CobbleProjectileEntity(Level pLevel) {
        super(ModEntities.THROWABLE_COBBLE.get(), pLevel);
    }

    public CobbleProjectileEntity(Level pLevel, LivingEntity pShooter) {
        super(ModEntities.THROWABLE_COBBLE.get(), pShooter, pLevel);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.COBBLE.get();
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        super.onHitEntity(pResult);
        Entity entity = pResult.getEntity();
        entity.hurt(new ModDamageSources(entity.level().registryAccess()).cobble(), 2);
    }

    @Override
    protected void onHitBlock(BlockHitResult pResult) {
        super.onHitBlock(pResult);
        if (!this.level().isClientSide){
            this.level().playSound(this, pResult.getBlockPos(), SoundEvents.STONE_BREAK, SoundSource.AMBIENT, 0.1f, 0.4f);
            this.level().addParticle(new ItemParticleOption(ParticleTypes.ITEM, this.getItem()), this.getX(), this.getY(), this.getZ(), ((double)this.random.nextFloat() - (double)0.5F) * 0.08, ((double)this.random.nextFloat() - (double)0.5F) * 0.08, ((double)this.random.nextFloat() - (double)0.5F) * 0.08);
        }
    }
}
