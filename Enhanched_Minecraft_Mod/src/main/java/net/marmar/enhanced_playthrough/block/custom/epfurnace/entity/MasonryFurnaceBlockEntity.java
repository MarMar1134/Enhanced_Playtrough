package net.marmar.enhanced_playthrough.block.custom.epfurnace.entity;

import net.marmar.enhanced_playthrough.block.EPBlockEntities;
import net.marmar.enhanced_playthrough.menu.epfurnace.MasonryFurnaceMenu;
import net.marmar.enhanced_playthrough.recipe.EPRecipes;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class MasonryFurnaceBlockEntity extends AbstractEPFurnaceBlockEntity implements MenuProvider {

    public MasonryFurnaceBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(EPBlockEntities.MASONRY_FURNACE_BLOCK_ENTITY.get(), pPos, pBlockState, EPRecipes.MASONRY_SMELTING_TYPE.get());
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.enhanced_playthrough.masonry_furnace");
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
        return new MasonryFurnaceMenu(i, inventory, this, this.data);
    }
}