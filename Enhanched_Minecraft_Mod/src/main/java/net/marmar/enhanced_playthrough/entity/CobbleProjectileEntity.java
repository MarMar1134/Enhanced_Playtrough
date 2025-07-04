package net.marmar.enhanced_playthrough.entity;

import net.marmar.enhanced_playthrough.Util.damage.ModDamageSources;
import net.marmar.enhanced_playthrough.item.ModItems;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public class CobbleProjectileEntity extends ThrowableItemProjectile {
    private int cobbleDamage;

    public CobbleProjectileEntity(EntityType<? extends ThrowableItemProjectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public CobbleProjectileEntity(Level pLevel, LivingEntity pShooter, int pCobbleDamage) {
        super(ModEntities.THROWABLE_COBBLE.get(), pShooter, pLevel);
        this.cobbleDamage = pCobbleDamage;
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.COBBLE.get();
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        super.onHitEntity(pResult);
        Entity entity = pResult.getEntity();
        entity.hurt(new ModDamageSources(entity.level().registryAccess()).cobble(), this.cobbleDamage);
    }

    protected void onHit(HitResult pResult) {
        super.onHit(pResult);
        if (!this.level().isClientSide) {
            this.level().broadcastEntityEvent(this, (byte) 3);
            this.playSound(SoundEvents.STONE_BREAK, 1.0F, 1.2F / (this.random.nextFloat() * 0.2F + 0.9F));
            this.discard();
        }
    }

    private ParticleOptions getParticle(){
        ItemStack currentCobble = this.getItem();
        return currentCobble.isEmpty() ? ParticleTypes.ITEM_SNOWBALL : new ItemParticleOption(ParticleTypes.ITEM, currentCobble);
    }

    @Override
    public void handleEntityEvent(byte pId) {
        float randomSpread = 0;
        if (pId == 3) {
            ParticleOptions particle = this.getParticle();

            for(int i = 0; i < 8; ++i) {
                randomSpread += 0.1F * (this.random.nextFloat() / 2);
                this.level().addParticle(particle, this.getX(), this.getY(), this.getZ(), randomSpread, 0, randomSpread);
            }
        }
    }
}
