package net.marmar.enhanced_playthrough.compat.jei.itemtransfer;

import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.transfer.IRecipeTransferInfo;
import net.marmar.enhanced_playthrough.compat.jei.category.SuperAlloyingCategory;
import net.marmar.enhanced_playthrough.menu.EPMenuTypes;
import net.marmar.enhanced_playthrough.menu.alloyfurnace.SuperAlloyFurnaceMenu;
import net.marmar.enhanced_playthrough.recipe.alloy.BlastAlloyRecipe;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;

import java.util.List;
import java.util.Optional;

public class SuperAlloyFurnaceTransferInfo implements IRecipeTransferInfo<SuperAlloyFurnaceMenu, BlastAlloyRecipe> {
    @Override
    public Class<? extends SuperAlloyFurnaceMenu> getContainerClass() {
        return SuperAlloyFurnaceMenu.class;
    }

    @Override
    public Optional<MenuType<SuperAlloyFurnaceMenu>> getMenuType() {
        return Optional.of(EPMenuTypes.SUPER_ALLOY_FURNACE_MENU.get());
    }

    @Override
    public RecipeType<BlastAlloyRecipe> getRecipeType() {
        return SuperAlloyingCategory.SUPER_ALLOY_RECIPE_TYPE;
    }

    @Override
    public boolean canHandle(SuperAlloyFurnaceMenu container, BlastAlloyRecipe recipe) {
        return true;
    }

    @Override
    public List<Slot> getRecipeSlots(SuperAlloyFurnaceMenu container, BlastAlloyRecipe recipe) {
        return List.of(container.getSlot(0), container.getSlot(1), container.getSlot(2));
    }

    @Override
    public List<Slot> getInventorySlots(SuperAlloyFurnaceMenu container, BlastAlloyRecipe recipe) {
        return container.slots.subList(4, 40);
    }
}
