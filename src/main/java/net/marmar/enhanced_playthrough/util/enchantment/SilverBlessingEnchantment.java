package net.marmar.enhanced_playthrough.util.enchantment;

import net.marmar.enhanced_playthrough.datagen.tag.EPTags;
import net.marmar.enhanced_playthrough.item.custom.tool.weapon.DaggerItem;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantments;

public class SilverBlessingEnchantment extends Enchantment {
    public SilverBlessingEnchantment(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot... pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack) {
        return true;
    }

    @Override
    public boolean canEnchant(ItemStack pStack) {
        return !pStack.is(EPTags.Items.HURTS_LYCAN) && (pStack.getItem() instanceof SwordItem || pStack.getItem() instanceof DaggerItem);
    }

    @Override
    protected boolean checkCompatibility(Enchantment pOther) {
        return pOther != Enchantments.SHARPNESS && pOther != Enchantments.SMITE && pOther != Enchantments.BANE_OF_ARTHROPODS;
    }
}
