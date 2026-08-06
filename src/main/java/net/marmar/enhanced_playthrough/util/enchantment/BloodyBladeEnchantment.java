package net.marmar.enhanced_playthrough.util.enchantment;

import net.marmar.enhanced_playthrough.util.effect.EPMobEffects;
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
        if (pTarget instanceof LivingEntity entity && !(pTarget instanceof AbstractSkeleton)){
            if (pLevel == 1){
                entity.addEffect(new MobEffectInstance(EPMobEffects.BLEEDING.get(), 200, 0, false, true, true));
            } else {
                entity.addEffect(new MobEffectInstance(EPMobEffects.BLEEDING.get(), 100, pLevel - 1, false, true, true));
            }
        }
        super.doPostAttack(pAttacker, pTarget, pLevel);
    }

    @Override
    protected boolean checkCompatibility(Enchantment pOther) {
        return super.checkCompatibility(pOther) && pOther != EPEnchantments.POISON_TOUCH.get() && pOther != EPEnchantments.LIVING_TOUCH.get()
                && pOther != Enchantments.FIRE_ASPECT && pOther != EPEnchantments.FROSTBITE.get();
    }
}
