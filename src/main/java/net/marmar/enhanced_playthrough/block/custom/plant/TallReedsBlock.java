package net.marmar.enhanced_playthrough.block.custom.plant;

import net.marmar.enhanced_playthrough.item.EPItems;
import net.marmar.enhanced_playthrough.util.damage.EPDamageSources;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.phys.Vec3;

public class TallReedsBlock extends DoublePlantGrowingHeadBlock {
    public TallReedsBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
        if (pEntity instanceof LivingEntity){
            pEntity.makeStuckInBlock(pState, new Vec3(0.8F, 0.75F, 0.8F));

            if (!pLevel.isClientSide && (pEntity.xOld != pEntity.getX() || pEntity.zOld != pEntity.getZ())) {
                double d0 = Math.abs(pEntity.getX() - pEntity.xOld);
                double d1 = Math.abs(pEntity.getZ() - pEntity.zOld);
                if (d0 >= (double)0.003F || d1 >= (double)0.003F) {

                    pEntity.hurt(new EPDamageSources(pLevel.registryAccess()).tallReed(), 1.5F);
                }
            }
        }
    }

    @Override
    protected Item getDefaultHead() {
        return EPItems.TALL_REEDS_HEAD.get();
    }

    @Override
    public boolean canBeReplaced(BlockState pState, Fluid pFluid) {
        return false;
    }
}
