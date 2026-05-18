package net.marmar.enhanced_playthrough.compat.jei.itemtransfer;

import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.transfer.IRecipeTransferInfo;
import net.marmar.enhanced_playthrough.compat.jei.category.PrimalGrindCategory;
import net.marmar.enhanced_playthrough.menu.EPMenuTypes;
import net.marmar.enhanced_playthrough.menu.grinder.PrimalGrinderMenu;
import net.marmar.enhanced_playthrough.recipe.grind.PrimalGrindRecipe;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;

import java.util.List;
import java.util.Optional;

public class PrimalGrinderTransferInfo implements IRecipeTransferInfo<PrimalGrinderMenu, PrimalGrindRecipe> {
    @Override
    public Class<? extends PrimalGrinderMenu> getContainerClass() {
        return PrimalGrinderMenu.class;
    }

    @Override
    public Optional<MenuType<PrimalGrinderMenu>> getMenuType() {
        return Optional.of(EPMenuTypes.PRIMAL_GRINDER_MENU.get());
    }

    @Override
    public RecipeType<PrimalGrindRecipe> getRecipeType() {
        return PrimalGrindCategory.PRIMAL_GRINDING_RECIPE_RECIPE_TYPE;
    }

    @Override
    public boolean canHandle(PrimalGrinderMenu container, PrimalGrindRecipe recipe) {
        return true;
    }

    @Override
    public List<Slot> getRecipeSlots(PrimalGrinderMenu container, PrimalGrindRecipe recipe) {
        return List.of(container.getSlot(0), container.getSlot(1));
    }

    @Override
    public List<Slot> getInventorySlots(PrimalGrinderMenu container, PrimalGrindRecipe recipe) {
        return container.slots.subList(3, 39);
    }
}
