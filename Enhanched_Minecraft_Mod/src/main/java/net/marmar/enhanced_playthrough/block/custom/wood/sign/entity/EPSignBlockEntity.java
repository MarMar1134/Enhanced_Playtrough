package net.marmar.enhanced_playthrough.block.custom.wood.sign.entity;

import net.marmar.enhanced_playthrough.block.EPBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class EPSignBlockEntity extends SignBlockEntity {
    public EPSignBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(EPBlockEntities.SIGN_BLOCK_ENTITY.get(), pPos, pBlockState);
    }

    @Override
    public BlockEntityType<?> getType() {
        return EPBlockEntities.SIGN_BLOCK_ENTITY.get();
    }
}
