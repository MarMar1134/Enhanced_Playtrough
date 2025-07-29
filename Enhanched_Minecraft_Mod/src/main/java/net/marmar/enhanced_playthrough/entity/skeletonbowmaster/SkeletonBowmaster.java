package net.marmar.enhanced_playthrough.entity.skeletonbowmaster;

import net.marmar.enhanced_playthrough.item.EPItems;
import net.marmar.enhanced_playthrough.item.custom.weapon.AluminumArrowItem;
import net.marmar.enhanced_playthrough.util.EPSoundEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.AbstractSkeleton;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jetbrains.annotations.Nullable;

public class SkeletonBowmaster extends AbstractSkeleton {
    public SkeletonBowmaster(EntityType<? extends AbstractSkeleton> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    /**
     * This method evaluates the current Minecraft day.
     * On HARD difficulty, returns true if is the 20'd day or above.
     * On NORMAL difficulty, returns true if is the 30'd day or above.
     */
    public static boolean isDayOfSpawn(ServerLevelAccessor pLevel){
        return pLevel.getLevel().getDayTime() / 24000 >= (pLevel.getDifficulty() == Difficulty.HARD ? 20 : 30);
    }

    /**
     * Static method that checks if the {@code Skeleton bowmaster} can spawn.
     * <p>
     * It will spawn only if the current day is above 20 (on {@code HARD}) or 30 (on {@code NORMAL}).
     * It also spawns if {@code Y <= 10}, on any difficulty besides {@code PEACEFUL}.
     * <p>
     * On {@code EASY} mode, it will spawn only below {@code Y <= 10}.
     */
    public static boolean checkSkeletonBowmasterSpawnRules(EntityType<SkeletonBowmaster> pSkeletonBowmaster, ServerLevelAccessor pLevel, MobSpawnType pSpawnType, BlockPos pPos, RandomSource pRandom){
        if (pLevel.getDifficulty() == Difficulty.EASY) {
            return checkMonsterSpawnRules(pSkeletonBowmaster, pLevel, pSpawnType, pPos, pRandom) && pPos.getY() <= 10;
        }

        return checkMonsterSpawnRules(pSkeletonBowmaster, pLevel, pSpawnType, pPos, pRandom) && (isDayOfSpawn(pLevel) || pPos.getY() <= 10);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 30f)
                .add(Attributes.ARMOR, 4f)
                .add(Attributes.ARMOR_TOUGHNESS, 2f)
                .add(Attributes.MOVEMENT_SPEED, 0.22D);
    }

    @Override
    protected AbstractArrow getArrow(ItemStack pArrowStack, float pVelocity) {
        AluminumArrowItem aluminumArrow = (AluminumArrowItem) (pArrowStack.getItem() instanceof AluminumArrowItem
                ? pArrowStack.getItem() : EPItems.ALUMINUM_ARROW.get());

        AbstractArrow abstractarrow = aluminumArrow.createArrow(this.level(), pArrowStack, this);

        abstractarrow.setEnchantmentEffectsFromEntity(this, pVelocity);

        return abstractarrow;
    }

    @Override
    protected @Nullable SoundEvent getAmbientSound() {
        return EPSoundEvents.SKELETON_BOWMASTER_AMBIENT.get();
    }

    @Override
    protected SoundEvent getStepSound() {
        return EPSoundEvents.SKELETON_BOWMASTER_STEP.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return EPSoundEvents.SKELETON_BOWMASTER_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return EPSoundEvents.SKELETON_BOWMASTER_DEATH.get();
    }

    @Override
    public boolean canFreeze() {
        return false;
    }

    @Override
    public int getExperienceReward() {
        return (int) (super.getExperienceReward() * 1.5d);
    }

    @Override
    protected void dropCustomDeathLoot(DamageSource pSource, int pLooting, boolean pRecentlyHit) {
        super.dropCustomDeathLoot(pSource, pLooting, pRecentlyHit);
        Entity entity = pSource.getEntity();
        if (entity instanceof Creeper creeper) {
            if (creeper.canDropMobsSkull()) {
                creeper.increaseDroppedSkulls();
                this.spawnAtLocation(Items.SKELETON_SKULL);
            }
        }

    }
}
