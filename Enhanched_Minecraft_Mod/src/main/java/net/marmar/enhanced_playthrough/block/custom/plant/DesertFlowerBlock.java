package net.marmar.enhanced_playthrough.block.custom.plant;

import net.marmar.enhanced_playthrough.data.tag.EPTags;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.Supplier;

public class DesertFlowerBlock extends FlowerBlock {
    public DesertFlowerBlock(Supplier<MobEffect> effectSupplier, int pEffectDuration, Properties pProperties) {
        super(effectSupplier, pEffectDuration, pProperties);
    }

    @Override
    protected boolean mayPlaceOn(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
        return pState.is(EPTags.Blocks.DESERT_FLOWER_BASE);
    }
}
