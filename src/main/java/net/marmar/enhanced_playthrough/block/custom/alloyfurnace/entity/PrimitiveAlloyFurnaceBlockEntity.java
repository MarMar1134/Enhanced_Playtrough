package net.marmar.enhanced_playthrough.block.custom.alloyfurnace.entity;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.block.EPBlockEntities;
import net.marmar.enhanced_playthrough.menu.alloyfurnace.PrimitiveAlloyFurnaceMenu;
import net.marmar.enhanced_playthrough.recipe.EPRecipes;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class PrimitiveAlloyFurnaceBlockEntity extends AbstractAlloyFurnaceBlockEntity implements MenuProvider {
    public PrimitiveAlloyFurnaceBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(EPBlockEntities.PRIMITIVE_ALLOY_FURNACE_BLOCK_ENTITY.get(), pPos, pBlockState, EPRecipes.PRIMITIVE_ALLOY_TYPE.get());
    }


    @Override
    public Component getDisplayName() {
        return Component.translatable("block." + EnhancedPlaythrough.MOD_ID + ".primitive_alloy_furnace");
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new PrimitiveAlloyFurnaceMenu(pContainerId, pPlayerInventory, this, this.data);
    }
}
