package net.marmar.enhanced_playthrough.Util.enchantment;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantments;

public class FineMiningEnchantment extends Enchantment {
    public FineMiningEnchantment(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot... pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
    }

    @Override
    public boolean canEnchant(ItemStack pStack) {
        return pStack.getItem() instanceof DiggerItem && !(pStack.getItem() instanceof HoeItem);
    }

    @Override
    protected boolean checkCompatibility(Enchantment pOther) {
        return super.checkCompatibility(pOther) && pOther != Enchantments.SILK_TOUCH && pOther != ModEnchantments.ROUGH_MINING.get();
    }
}
