package net.marmar.enhanced_playthrough.entity.lycan;

import net.marmar.enhanced_playthrough.datagen.tag.EPTags;
import net.marmar.enhanced_playthrough.entity.EPMobType;
import net.marmar.enhanced_playthrough.util.enchantment.EPEnchantments;
import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public abstract class AbstractLycanMob extends Monster {
    private static final EntityDataAccessor<Integer> LYCAN_STATE = SynchedEntityData.defineId(AbstractLycanMob.class, EntityDataSerializers.INT);
    private final SoundEvent ambientSound;
    private final SoundEvent stepSound;
    private final SoundEvent hurtSound;
    private final SoundEvent deathSound;
    private boolean isTransformed;

    protected AbstractLycanMob(EntityType<? extends Monster> pEntityType, Level pLevel, SoundEvent pAmbientSound, SoundEvent pStepSound, SoundEvent pHurtSound, SoundEvent pDeathSound) {
        super(pEntityType, pLevel);
        this.ambientSound = pAmbientSound;
        this.stepSound = pStepSound;
        this.hurtSound = pHurtSound;
        this.deathSound = pDeathSound;
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(LYCAN_STATE, LycanState.HUMAN_FORM.ordinal());
    }

    public LycanState getState() {
        return LycanState.values()[this.entityData.get(LYCAN_STATE)];
    }

    @Override
    public MobType getMobType() {
        return EPMobType.LYCAN;
    }

    public void setState(LycanState state) {
        this.entityData.set(LYCAN_STATE, state.ordinal());
        this.refreshDimensions();
    }

    protected abstract void transform();

    @Override
    public boolean hurt(DamageSource pSource, float pAmount) {
        if (this.getState() == LycanState.LYCAN_FORM){
            if (pSource.getEntity() instanceof Player player){
                ItemStack attackItem = player.getItemBySlot(EquipmentSlot.MAINHAND);

                if (attackItem.is(EPTags.Items.HURTS_LYCAN)){
                    return super.hurt(pSource, pAmount * 1.5f);
                } else if (attackItem.getEnchantmentLevel(EPEnchantments.SILVER_BLESSING.get()) > 0) {
                    float damageMultiplier = attackItem.getEnchantmentLevel(EPEnchantments.SILVER_BLESSING.get()) * 1.2f;
                    return super.hurt(pSource, pAmount + damageMultiplier);
                } else {
                    return super.hurt(pSource, 1.0f);
                }
            }
        }

        return super.hurt(pSource, pAmount);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return this.getState() == LycanState.LYCAN_FORM ? this.ambientSound : SoundEvents.VILLAGER_AMBIENT;
    }

    @Override
    protected void playStepSound(BlockPos pPos, BlockState pState) {
        this.playSound(this.getState() == LycanState.LYCAN_FORM ? this.stepSound : SoundEvents.ZOMBIE_VILLAGER_STEP, 0.15F, 1.0F);
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return this.getState() == LycanState.LYCAN_FORM ? this.hurtSound : SoundEvents.VILLAGER_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return this.getState() == LycanState.LYCAN_FORM ? this.deathSound : SoundEvents.VILLAGER_DEATH;
    }

    public enum LycanState {
        HUMAN_FORM,
        LYCAN_FORM
    }
}
