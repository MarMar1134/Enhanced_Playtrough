package net.marmar.enhanced_playthrough.entity.zombieknight;

import net.marmar.enhanced_playthrough.item.EPItems;
import net.marmar.enhanced_playthrough.util.EPSoundEvents;
import net.marmar.enhanced_playthrough.worldgen.structure.EPStructureUtils;
import net.marmar.enhanced_playthrough.worldgen.structure.EPStructures;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;

public class ZombieKnight extends Zombie {
    public ZombieKnight(EntityType<? extends Zombie> pEntityType, Level pLevel) {
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
     * Static method that checks if the {@code Zombie Knight} can spawn.
     * <p>
     * It will spawn only if the current day is above 20 (on {@code HARD}) or 30 (on {@code NORMAL}).
     * It also spawns if {@code Y <= 10}, on any difficulty besides {@code PEACEFUL}.
     * </p>
     * <p>
     * On {@code EASY} mode, it will spawn only below {@code Y <= 10}.
     * </p>
     * <p>
     *     Additionally, if the mob tries to spawn on a structure, it will ignore the current light level, day of spawn and difficulty
     *     and spawn on the defined structure.
     * </p>
     */
    public static boolean checkZombieKnightSpawnRules(EntityType<ZombieKnight> pZombieKnight, ServerLevelAccessor pLevel, MobSpawnType pSpawnType, BlockPos pPos, RandomSource pRandom){
        if (EPStructureUtils.isInsideStructure(pLevel, pPos, EPStructures.ANCIENT_LORDS_DOMAIN)){
            return checkMonsterSpawnRules(pZombieKnight, pLevel, pSpawnType, pPos, pRandom);
        }

        if (pLevel.getDifficulty() == Difficulty.EASY) {
            return checkMonsterSpawnRules(pZombieKnight, pLevel, pSpawnType, pPos, pRandom) && pPos.getY() <= 10;
        }

        return checkMonsterSpawnRules(pZombieKnight, pLevel, pSpawnType, pPos, pRandom) && (isDayOfSpawn(pLevel) || pPos.getY() <= 10);
    }

    public static AttributeSupplier.Builder createAttributes(){
        return Monster.createMonsterAttributes()
                .add(Attributes.FOLLOW_RANGE, 40.0f)
                .add(Attributes.MOVEMENT_SPEED, 0.21f)
                .add(Attributes.ATTACK_DAMAGE, 5.0d)
                .add(Attributes.MAX_HEALTH, 30f)
                .add(Attributes.ARMOR, 4.0d)
                .add(Attributes.ARMOR_TOUGHNESS, 2.0d)
                .add(Attributes.SPAWN_REINFORCEMENTS_CHANCE);
    }

    @Override
    protected void populateDefaultEquipmentSlots(RandomSource pRandom, DifficultyInstance pDifficulty) {
        super.populateDefaultEquipmentSlots(pRandom, pDifficulty);
        if (pRandom.nextFloat() < (this.level().getDifficulty() == Difficulty.HARD ? 0.15F : 0.05F)) {
            int i = pRandom.nextInt(3);
            if (i == 0) {
                this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.DIAMOND_SWORD));
            } else {
                this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(EPItems.STEEL_SHOVEL.get()));
            }
        } else {
            this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(EPItems.STEEL_SWORD.get()));
        }
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return EPSoundEvents.ZOMBIE_KNIGHT_AMBIENT.get();
    }

    @Override
    protected SoundEvent getStepSound() {
        return EPSoundEvents.ZOMBIE_KNIGHT_STEP.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return EPSoundEvents.ZOMBIE_KNIGHT_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return EPSoundEvents.ZOMBIE_KNIGHT_DEATH.get();
    }

    @Override
    public int getExperienceReward() {
        return (int) (super.getExperienceReward() * 1.3D);
    }

    @Override
    public boolean isBaby() {
        return false;
    }

    @Override
    protected boolean convertsInWater() {
        return false;
    }

    @Override
    public boolean canBreakDoors() {
        return true;
    }
}
