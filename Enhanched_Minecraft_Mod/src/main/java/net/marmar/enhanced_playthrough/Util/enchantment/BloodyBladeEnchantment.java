package net.marmar.enhanced_playthrough.Util.enchantment;

import net.marmar.enhanced_playthrough.Util.effect.ModEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.AbstractSkeleton;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantments;

public class BloodyBladeEnchantment extends Enchantment {
    protected BloodyBladeEnchantment(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot... pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
    }

    @Override
    public boolean isTreasureOnly() {
        return false;
    }

    @Override
    public boolean isTradeable() {
        return true;
    }

    @Override
    public boolean isAllowedOnBooks() {
        return true;
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack) {
        return true;
    }

    @Override
    public boolean canEnchant(ItemStack pStack) {
        return pStack.getItem() instanceof SwordItem || pStack.getItem() instanceof AxeItem;
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    public void doPostAttack(LivingEntity pAttacker, Entity pTarget, int pLevel) {
        if (pTarget instanceof LivingEntity && !(pTarget instanceof AbstractSkeleton)){
            switch (pLevel){
                case 1:
                    ((LivingEntity) pTarget).addEffect(new MobEffectInstance(ModEffects.BLEEDING.get(), 200, 0, true, true));
                case 2:
                    ((LivingEntity) pTarget).addEffect(new MobEffectInstance(ModEffects.BLEEDING.get(), 100, 1, true, true));
                case 3:
                    ((LivingEntity) pTarget).addEffect(new MobEffectInstance(ModEffects.BLEEDING.get(), 100, 2, true, true));
            }
        }
        super.doPostAttack(pAttacker, pTarget, pLevel);
    }

    @Override
    protected boolean checkCompatibility(Enchantment pOther) {
        return super.checkCompatibility(pOther) && pOther != ModEnchantments.POISON_TOUCH.get() && pOther != ModEnchantments.LIVING_TOUCH.get()
                && pOther != Enchantments.FIRE_ASPECT;
    }
}
