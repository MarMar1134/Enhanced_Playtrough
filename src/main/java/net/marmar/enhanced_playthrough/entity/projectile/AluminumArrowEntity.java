package net.marmar.enhanced_playthrough.entity.projectile;

import net.marmar.enhanced_playthrough.entity.EPEntityTypes;
import net.marmar.enhanced_playthrough.item.EPItems;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class AluminumArrowEntity extends AbstractArrow {
    public AluminumArrowEntity(EntityType<? extends AbstractArrow> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public AluminumArrowEntity(Level pLevel, double pX, double pY, double pZ) {
        this(EPEntityTypes.ALUMINUM_ARROW.get(), pLevel);
        this.setPos(pX, pY, pZ);
    }

    public AluminumArrowEntity(Level pLevel, LivingEntity pShooter){
        super(EPEntityTypes.ALUMINUM_ARROW.get(), pShooter, pLevel);
        this.setBaseDamage(4.0D);
    }

    @Override
    protected ItemStack getPickupItem() {
        return new ItemStack(EPItems.ALUMINUM_ARROW.get());
    }
}
