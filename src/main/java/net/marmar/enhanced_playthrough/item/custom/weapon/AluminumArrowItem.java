package net.marmar.enhanced_playthrough.item.custom.weapon;

import net.marmar.enhanced_playthrough.entity.projectile.AluminumArrowEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class AluminumArrowItem extends ArrowItem {
    public AluminumArrowItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public AbstractArrow createArrow(Level pLevel, ItemStack pStack, LivingEntity pShooter) {
        return new AluminumArrowEntity(pLevel, pShooter);
    }
}
