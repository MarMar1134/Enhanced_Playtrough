package net.marmar.enhanced_playthrough.block.custom.alloyfurnace;

import net.marmar.enhanced_playthrough.block.EPBlockEntities;
import net.marmar.enhanced_playthrough.block.custom.alloyfurnace.entity.PrimitiveAlloyFurnaceBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class PrimitiveAlloyFurnaceBlock extends AbstractAlloyFurnaceBlock {
    public PrimitiveAlloyFurnaceBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new PrimitiveAlloyFurnaceBlockEntity(pPos, pState);
    }

    @Override
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        return createAlloyFurnaceTicker(pLevel, pBlockEntityType, EPBlockEntities.PRIMITIVE_ALLOY_FURNACE_BLOCK_ENTITY.get());
    }
}
