package net.marmar.enhanced_playthrough.block.custom.wood.sign.entity;

import net.marmar.enhanced_playthrough.block.EPBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class EPHangingSignBlockEntity extends SignBlockEntity {
    public EPHangingSignBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(EPBlockEntities.HANGING_SIGN_BLOCK_ENTITY.get(), pPos, pBlockState);
    }

    @Override
    public BlockEntityType<?> getType() {
        return EPBlockEntities.HANGING_SIGN_BLOCK_ENTITY.get();
    }
}
