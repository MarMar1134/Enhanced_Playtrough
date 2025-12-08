package net.marmar.enhanced_playthrough.util.enchantment;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantments;

public class LivingTouchEnchantment extends Enchantment {
    protected LivingTouchEnchantment(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot... pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
    }
    @Override
    public boolean isTreasureOnly() {
        return true;
    }

    @Override
    public boolean isTradeable() {
        return false;
    }

    @Override
    public boolean canEnchant(ItemStack pStack) {
        return pStack.getItem() instanceof SwordItem;
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    public void doPostAttack(LivingEntity pAttacker, Entity pTarget, int pLevel) {
        if (pTarget instanceof LivingEntity entity){
            if (entity.getMobType() == MobType.UNDEAD){
                entity.addEffect(new MobEffectInstance(MobEffects.HEAL, 100, pLevel -1, false, true, true));
            } else {
                entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 100, pLevel - 1, false, true, true));
            }
        }

        super.doPostAttack(pAttacker, pTarget, pLevel);
    }
    @Override
    protected boolean checkCompatibility(Enchantment pOther) {
        return super.checkCompatibility(pOther) && pOther != Enchantments.FIRE_ASPECT && pOther != EPEnchantments.POISON_TOUCH.get()
                && pOther != EPEnchantments.BLOODY_BLADE.get() && pOther != EPEnchantments.FROSTBITE.get();
    }
}
