package net.marmar.enhanced_playthrough.Util.enchantment;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantments;

public class PoisonTouchEnchantment extends Enchantment {
    protected PoisonTouchEnchantment(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot... pApplicableSlots) {
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
        if(pTarget instanceof LivingEntity){
            switch (pLevel){
                case 1:
                    ((LivingEntity) pTarget).addEffect(new MobEffectInstance(MobEffects.POISON, 100, 0, false, true, true));
                    break;
                case 2:
                    ((LivingEntity) pTarget).addEffect(new MobEffectInstance(MobEffects.POISON, 100, 1, false, true, true));
                    break;
                case 3:
                    ((LivingEntity) pTarget).addEffect(new MobEffectInstance(MobEffects.POISON, 100, 2, false, true, true));
                    break;
            }
        }
        super.doPostAttack(pAttacker, pTarget, pLevel);
    }
    @Override
    protected boolean checkCompatibility(Enchantment pOther) {
        return super.checkCompatibility(pOther) && pOther != Enchantments.FIRE_ASPECT && pOther != ModEnchantments.LIVING_TOUCH.get()
                && pOther != ModEnchantments.SHARP_BLADE.get();
    }
}
