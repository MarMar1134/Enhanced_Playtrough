package net.marmar.enhanced_playthrough.block.modfurnace;

import net.marmar.enhanced_playthrough.block.ModBlockEntities;
import net.marmar.enhanced_playthrough.block.modfurnace.entity.SoulFurnaceBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class SoulFurnaceBlock extends AbstractModFurnaceBlock {
    public SoulFurnaceBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new SoulFurnaceBlockEntity(blockPos,blockState);
    }

    @Override
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        return CreateBasicFurnaceTicker(pLevel, pBlockEntityType, ModBlockEntities.SOUL_FURNACE_BLOCK_ENTITY.get());
    }
}
