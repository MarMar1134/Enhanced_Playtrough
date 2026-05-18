package net.marmar.enhanced_playthrough.compat.jei.itemtransfer;

import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.transfer.IRecipeTransferInfo;
import net.marmar.enhanced_playthrough.compat.jei.category.MasonrySmeltingCategory;
import net.marmar.enhanced_playthrough.menu.EPMenuTypes;
import net.marmar.enhanced_playthrough.menu.epfurnace.MasonryFurnaceMenu;
import net.marmar.enhanced_playthrough.recipe.epsmelt.MasonrySmeltingRecipe;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;

import java.util.List;
import java.util.Optional;

public class MasonryFurnaceTransferInfo implements IRecipeTransferInfo<MasonryFurnaceMenu, MasonrySmeltingRecipe> {
    @Override
    public Class<? extends MasonryFurnaceMenu> getContainerClass() {
        return MasonryFurnaceMenu.class;
    }

    @Override
    public Optional<MenuType<MasonryFurnaceMenu>> getMenuType() {
        return Optional.of(EPMenuTypes.MASONRY_FURNACE_MENU.get());
    }

    @Override
    public RecipeType<MasonrySmeltingRecipe> getRecipeType() {
        return MasonrySmeltingCategory.MASONRY_SMELTING_TYPE;
    }

    @Override
    public boolean canHandle(MasonryFurnaceMenu container, MasonrySmeltingRecipe recipe) {
        return true;
    }

    @Override
    public List<Slot> getRecipeSlots(MasonryFurnaceMenu container, MasonrySmeltingRecipe recipe) {
        return List.of(container.getSlot(0), container.getSlot(1));
    }

    @Override
    public List<Slot> getInventorySlots(MasonryFurnaceMenu container, MasonrySmeltingRecipe recipe) {
        return container.slots.subList(3, 39);
    }
}
