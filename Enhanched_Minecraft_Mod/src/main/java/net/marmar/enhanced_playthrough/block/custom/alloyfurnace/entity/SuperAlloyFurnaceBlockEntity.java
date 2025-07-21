package net.marmar.enhanced_playthrough.block.custom.alloyfurnace.entity;

import net.marmar.enhanced_playthrough.block.EPBlockEntities;
import net.marmar.enhanced_playthrough.recipe.EPRecipes;
import net.marmar.enhanced_playthrough.menu.alloyfurnace.SuperAlloyFurnaceMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class SuperAlloyFurnaceBlockEntity extends AbstractAlloyFurnaceBlockEntity implements MenuProvider {

    public SuperAlloyFurnaceBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(EPBlockEntities.SUPER_ALLOY_FURNACE_BLOCK_ENTITY.get(), pPos, pBlockState, EPRecipes.SUPER_ALLOYING_TYPE.get());
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.enhanced_playthrough.super_alloy_furnace");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
        return new SuperAlloyFurnaceMenu(i, inventory, this, this.Data);
    }
}
