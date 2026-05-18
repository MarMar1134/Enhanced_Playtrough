package net.marmar.enhanced_playthrough.compat.jei.itemtransfer;

import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.transfer.IRecipeTransferInfo;
import net.marmar.enhanced_playthrough.compat.jei.category.MechanicalGrindCategory;
import net.marmar.enhanced_playthrough.menu.EPMenuTypes;
import net.marmar.enhanced_playthrough.menu.grinder.MechanicalGrinderMenu;
import net.marmar.enhanced_playthrough.recipe.grind.MechanicalGrindRecipe;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;

import java.util.List;
import java.util.Optional;

public class MechanicalGrinderTransferInfo implements IRecipeTransferInfo<MechanicalGrinderMenu, MechanicalGrindRecipe> {
    @Override
    public Class<? extends MechanicalGrinderMenu> getContainerClass() {
        return MechanicalGrinderMenu.class;
    }

    @Override
    public Optional<MenuType<MechanicalGrinderMenu>> getMenuType() {
        return Optional.of(EPMenuTypes.MECHANICAL_GRINDER_MENU.get());
    }

    @Override
    public RecipeType<MechanicalGrindRecipe> getRecipeType() {
        return MechanicalGrindCategory.GRINDING_RECIPE_RECIPE_TYPE;
    }

    @Override
    public boolean canHandle(MechanicalGrinderMenu container, MechanicalGrindRecipe recipe) {
        return true;
    }

    @Override
    public List<Slot> getRecipeSlots(MechanicalGrinderMenu container, MechanicalGrindRecipe recipe) {
        return List.of(container.getSlot(0));
    }

    @Override
    public List<Slot> getInventorySlots(MechanicalGrinderMenu container, MechanicalGrindRecipe recipe) {
        return container.slots.subList(2, 38);
    }
}
