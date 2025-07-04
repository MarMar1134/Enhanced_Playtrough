package net.marmar.enhanced_playthrough.entity;

import com.google.common.collect.Maps;
import net.marmar.enhanced_playthrough.util.enchantment.ModEnchantments;
import net.marmar.enhanced_playthrough.item.ModItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.AbstractIllager;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.raid.Raid;
import net.minecraft.world.entity.raid.Raider;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraftforge.common.ForgeMod;

import javax.annotation.Nullable;
import java.util.Map;

public class Bandit extends AbstractIllager {
    public static EntityDataAccessor<Boolean> ATTACKING;
    public final AnimationState attackAnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;

    public Bandit(EntityType<? extends AbstractIllager> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Override
    protected void updateWalkAnimation(float pPartialTick) {
        float f;
        if(this.getPose() == Pose.STANDING) {
            f = Math.min(pPartialTick * 6F, 1f);
        } else {
            f = 0f;
        }

        this.walkAnimation.update(f, 0.2f);
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
        if(this.isAttacking() && attackAnimationTimeout <= 0) {
            attackAnimationTimeout = 10; // Length in ticks of your animation
            attackAnimationState.start(this.tickCount);
        } else {
            --this.attackAnimationTimeout;
        }

        if(!this.isAttacking()) {
            attackAnimationState.stop();
        }
    }

    @Override
    public IllagerArmPose getArmPose() {
        if (this.isAttacking()) {
            return IllagerArmPose.ATTACKING;
        } else {
            return this.isCelebrating() ? IllagerArmPose.CELEBRATING : IllagerArmPose.CROSSED;
        }
    }

    @Override
    public void tick() {
        super.tick();
        if (this.level().isClientSide()){
            setupAnimationStates();
        }
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(2, new AbstractIllager.RaiderOpenDoorGoal(this));
        this.goalSelector.addGoal(3, new Raider.HoldGroundAttackGoal(this, 10.0F));
        this.goalSelector.addGoal(3, new AvoidEntityGoal<>(this, IronGolem.class, 4f, 1f, 1.2f));
        this.goalSelector.addGoal(4, new BanditMeleeAttackGoal(this));
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this, Raider.class)).setAlertOthers(Raider.class));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, true));
        this.goalSelector.addGoal(8, new RandomStrollGoal(this, 0.6));
        this.goalSelector.addGoal(9, new LookAtPlayerGoal(this, Player.class, 3.0F, 1.0F));
        this.goalSelector.addGoal(10, new LookAtPlayerGoal(this, Mob.class, 8.0F));
    }

    public static AttributeSupplier.Builder addAttributes(){
       return Monster.createMonsterAttributes()
               .add(Attributes.MAX_HEALTH, 24f)
               .add(Attributes.MOVEMENT_SPEED, 0.35f)
               .add(Attributes.ARMOR, 2.0f)
               .add(Attributes.ATTACK_DAMAGE, 1f)
               .add(ForgeMod.ENTITY_REACH.get(), 4f)
               .add(Attributes.FOLLOW_RANGE, 15f);
    }

    @Override
    protected void populateDefaultEquipmentSlots(RandomSource pRandom, DifficultyInstance pDifficulty) {
        switch (pDifficulty.getDifficulty()){
            case HARD -> this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ModItems.STEEL_DAGGER.get()));
            case NORMAL -> this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ModItems.IRON_DAGGER.get()));
            case EASY -> this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ModItems.STONE_DAGGER.get()));
        }
    }

    @Override
    protected void enchantSpawnedWeapon(RandomSource pRandom, float pChanceMultiplier) {
        super.enchantSpawnedWeapon(pRandom, pChanceMultiplier);
        if (pRandom.nextInt(300) == 0){
            ItemStack currentWeapon = this.getMainHandItem();
            Map<Enchantment, Integer> enchantments = EnchantmentHelper.getEnchantments(currentWeapon);
            if (currentWeapon.is(ModItems.STEEL_DAGGER.get())){
                enchantments.put(ModEnchantments.SHARP_BLADE.get(), 2);
            } else {
                enchantments.put(Enchantments.SHARPNESS, 2);
            }
        }
    }

    @Nullable
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor pLevel, DifficultyInstance pDifficulty, MobSpawnType pReason, @Nullable SpawnGroupData pSpawnData, @Nullable CompoundTag pDataTag) {
        RandomSource randomsource = pLevel.getRandom();
        this.populateDefaultEquipmentSlots(randomsource, pDifficulty);
        this.populateDefaultEquipmentEnchantments(randomsource, pDifficulty);
        return super.finalizeSpawn(pLevel, pDifficulty, pReason, pSpawnData, pDataTag);
    }

    @Override
    public void applyRaidBuffs(int pCurrentWave, boolean pUnused) {
        ItemStack daggerStack = this.getMainHandItem();
        Raid currentRaid = this.getCurrentRaid();
        int enchantLevelMultiplier = 1;
        boolean canEnchant = this.random.nextFloat() <= currentRaid.getEnchantOdds();

        if (pCurrentWave > currentRaid.getNumGroups(Difficulty.NORMAL)) {
            enchantLevelMultiplier = 2;
        } else if (pCurrentWave > currentRaid.getNumGroups(Difficulty.HARD)){
            enchantLevelMultiplier = 3;
        }

        if (canEnchant) {
            Map<Enchantment, Integer> enchantments = Maps.newHashMap();
            enchantments.put(Enchantments.SHARPNESS, enchantLevelMultiplier);
            enchantments.put(ModEnchantments.SHARP_BLADE.get(), enchantLevelMultiplier);
            EnchantmentHelper.setEnchantments(enchantments, daggerStack);
        }

        this.setItemSlot(EquipmentSlot.MAINHAND, daggerStack);
    }

    public boolean isAlliedTo(Entity pEntity) {
        if (super.isAlliedTo(pEntity)) {
            return true;
        } else if (pEntity instanceof LivingEntity && ((LivingEntity)pEntity).getMobType() == MobType.ILLAGER) {
            return this.getTeam() == null && pEntity.getTeam() == null;
        } else {
            return false;
        }
    }

    @Override
    public boolean canBeLeader() {
        return false;
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.PILLAGER_AMBIENT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.PILLAGER_DEATH;
    }

    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return SoundEvents.PILLAGER_HURT;
    }

    @Override
    public SoundEvent getCelebrateSound() {
        return SoundEvents.PILLAGER_CELEBRATE;
    }

    public static class BanditMeleeAttackGoal extends MeleeAttackGoal{
        private final Bandit bandit;
        private int attackDelay = 5;
        private int ticksUntilNextAttack = 5;

        public BanditMeleeAttackGoal(Bandit pBandit) {
            super(pBandit, 1F, false);
            this.bandit = pBandit;
        }

        @Override
        public void start() {
            this.bandit.setAttacking(true);
            super.start();
            this.attackDelay = 5;
            this.ticksUntilNextAttack = 5;
        }

        @Override
        protected void checkAndPerformAttack(LivingEntity pEnemy, double pDistToEnemySqr) {
            if (isEnemyWithinAttackDistance(pEnemy, pDistToEnemySqr)) {
                if (ticksUntilNextAttack <= 0) {
                    bandit.setAttacking(true);
                    this.mob.getLookControl().setLookAt(pEnemy.getX(), pEnemy.getEyeY(), pEnemy.getZ());
                    performAttack(pEnemy);
                    ticksUntilNextAttack = this.adjustedTickDelay(attackDelay); // Reinicia el cooldown después de atacar
                } else {
                    bandit.setAttacking(false);
                }
            } else {
                ticksUntilNextAttack = 0;
                bandit.setAttacking(false);
            }
        }

        private boolean isEnemyWithinAttackDistance(LivingEntity pEnemy, double pDistToEnemySqr) {
            return pDistToEnemySqr <= this.getAttackReachSqr(pEnemy);
        }

        protected void resetAttackCooldown() {
            this.ticksUntilNextAttack = this.adjustedTickDelay(attackDelay * 2);
        }

        protected boolean isTimeToAttack() {
            return this.ticksUntilNextAttack <= 0;
        }

        protected int getTicksUntilNextAttack() {
            return this.ticksUntilNextAttack;
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
            this.bandit.setAttacking(false);
            super.stop();
        }
    }

    static {
        ATTACKING = SynchedEntityData.defineId(Bandit.class, EntityDataSerializers.BOOLEAN);
    }
}
