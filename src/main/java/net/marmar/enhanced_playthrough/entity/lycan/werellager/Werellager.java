package net.marmar.enhanced_playthrough.entity.lycan.werellager;

import net.marmar.enhanced_playthrough.entity.lycan.AbstractLycanMob;
import net.marmar.enhanced_playthrough.util.EPSoundEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraftforge.common.ForgeMod;

public class Werellager extends AbstractLycanMob {
    private static final EntityDataAccessor<Boolean> ATTACKING = SynchedEntityData.defineId(Werellager.class, EntityDataSerializers.BOOLEAN);

    public final AnimationState idleAnimationState = new AnimationState();
    public final AnimationState attackAnimationState = new AnimationState();
    public final AnimationState walkAnimationState = new AnimationState();

    public int attackAnimationTimeout = 0;

    public Werellager(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel, EPSoundEvents.WERELLAGER_AMBIENT.get(), EPSoundEvents.WERELLAGER_STEP.get(),
                EPSoundEvents.WERELLAGER_HURT.get(), EPSoundEvents.WERELLAGER_DEATH.get());
    }

    public static boolean isDayOfSpawn(ServerLevelAccessor pLevel){
        return pLevel.getLevel().getDayTime() / 24000 >= (pLevel.getDifficulty() == Difficulty.HARD ? 5 : 10);
    }

    public static boolean checkWerellagerSpawnRules(EntityType<? extends Werellager> pWerellager, ServerLevelAccessor pLevel, MobSpawnType pSpawnType, BlockPos pPos, RandomSource pRandom){
        return checkMobSpawnRules(pWerellager, pLevel, pSpawnType, pPos, pRandom) && (isDayOfSpawn(pLevel) && pPos.getY() >= 63);
    }

    @Override
    protected void updateWalkAnimation(float pPartialTick) {
        float walkSpeed;
        if(this.getPose() == Pose.STANDING) {
            walkSpeed = Math.min(pPartialTick * 6F, 1f);
        } else {
            walkSpeed = 0f;
        }
        this.walkAnimation.update(walkSpeed, 0.2f);
    }

    public void setAttacking(boolean attacking) {
        this.entityData.set(ATTACKING, attacking);
    }

    public boolean isAttacking() {
        return this.entityData.get(ATTACKING);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ATTACKING, false);
    }

    private void setupAnimationStates() {
        if(this.isAttacking()) {
            if(attackAnimationTimeout <= 0) {
                attackAnimationTimeout = 13;
                attackAnimationState.start(this.tickCount);
            }
            --this.attackAnimationTimeout;
        } else {
            attackAnimationState.stop();
            attackAnimationTimeout = 0;
        }

        if(this.isAlive()) {
            idleAnimationState.animateWhen(!this.isMoving(), this.tickCount);
            walkAnimationState.animateWhen(this.isMoving(), this.tickCount);
        }
    }

    private boolean isMoving() {
        return this.getDeltaMovement().horizontalDistance() > 0.01f;
    }

    private void updateMovementSpeed() {
        float speed = this.getState() == LycanState.LYCAN_FORM ? 0.3f : 0.2f;
        var speedAttribute = this.getAttribute(Attributes.MOVEMENT_SPEED);
        if (speedAttribute != null) {
            speedAttribute.setBaseValue(speed);
        }
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new WerellagerMeleeAttackGoal(this));
        this.goalSelector.addGoal(2, new WaterAvoidingRandomStrollGoal(this, 0.6f));
        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 8.0F, 1.0F));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));

        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Villager.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 40f)
                .add(Attributes.MOVEMENT_SPEED, 0.3f)
                .add(Attributes.ARMOR, 4f)
                .add(Attributes.ATTACK_DAMAGE, 5f)
                .add(Attributes.ATTACK_KNOCKBACK, 2f)
                .add(ForgeMod.ENTITY_REACH.get(), 4f)
                .add(Attributes.FOLLOW_RANGE, 15f);
    }

    protected void transform() {
        if (this.level() instanceof ServerLevel serverLevel) {
            long currentTime = serverLevel.getDayTime() % 24000;

            if (currentTime >= 13000) {
                setState(LycanState.LYCAN_FORM);
            } else {
                setState(LycanState.HUMAN_FORM);
            }
        }
    }

    @Override
    public EntityDimensions getDimensions(Pose pPose) {
        EntityDimensions baseDimensions = super.getDimensions(pPose);

        if (this.getState() == LycanState.LYCAN_FORM) {
            return baseDimensions.scale(1.5F, 1.5F);
        }

        return baseDimensions;
    }

    @Override
    public float getEyeHeight(Pose pPose) {
        if (this.getState() == LycanState.LYCAN_FORM) {
            return 1.62F;
        }

        return super.getEyeHeight(pPose);
    }

    @Override
    public void tick() {
        super.tick();
        if (this.level().isClientSide()){
            setupAnimationStates();
        } else {
            transform();
            updateMovementSpeed();
        }
    }

    public static class WerellagerMeleeAttackGoal extends MeleeAttackGoal {
        private final Werellager werellager;
        private int attackDelay = 5;
        private int ticksUntilNextAttack = 5;

        public WerellagerMeleeAttackGoal(Werellager pWerellager) {
            super(pWerellager, 1F, false);
            this.werellager = pWerellager;
        }

        @Override
        public boolean canUse() {
            return super.canUse() && this.werellager.getState() == LycanState.LYCAN_FORM;
        }

        @Override
        public void start() {
            this.werellager.setAttacking(true);
            super.start();
            this.attackDelay = 5;
            this.ticksUntilNextAttack = 5;
        }

        @Override
        protected void checkAndPerformAttack(LivingEntity pEnemy, double pDistToEnemySqr) {
            double attackReachSqr = this.getAttackReachSqr(pEnemy);

            if (pDistToEnemySqr > attackReachSqr) {
                this.ticksUntilNextAttack = 0;
                werellager.setAttacking(false);
            } else if (this.ticksUntilNextAttack <= 0) {
                werellager.setAttacking(true);
                this.mob.getLookControl().setLookAt(pEnemy.getX(), pEnemy.getEyeY(), pEnemy.getZ());
                performAttack(pEnemy);
                this.ticksUntilNextAttack = this.adjustedTickDelay(this.attackDelay);
            }
        }

        protected void resetAttackCooldown() {
            this.ticksUntilNextAttack = this.adjustedTickDelay(this.attackDelay * 2);
        }

        protected void performAttack(LivingEntity pEnemy) {
            this.resetAttackCooldown();
            this.mob.swing(InteractionHand.MAIN_HAND);
            this.mob.doHurtTarget(pEnemy);
        }

        @Override
        public void tick() {
            super.tick();
            if (ticksUntilNextAttack > 0) {
                ticksUntilNextAttack--;
            }
        }

        @Override
        public void stop() {
            this.werellager.setAttacking(false);
            super.stop();
        }
    }
}
