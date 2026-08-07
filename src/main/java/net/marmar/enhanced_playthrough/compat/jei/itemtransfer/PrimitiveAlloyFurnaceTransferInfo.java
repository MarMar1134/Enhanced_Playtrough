package net.marmar.enhanced_playthrough.compat.jei.itemtransfer;

import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.transfer.IRecipeTransferInfo;
import net.marmar.enhanced_playthrough.compat.jei.category.PrimitiveAlloyingCategory;
import net.marmar.enhanced_playthrough.menu.EPMenuTypes;
import net.marmar.enhanced_playthrough.menu.alloyfurnace.PrimitiveAlloyFurnaceMenu;
import net.marmar.enhanced_playthrough.recipe.alloy.PrimitiveAlloyRecipe;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;

import java.util.List;
import java.util.Optional;

public class PrimitiveAlloyFurnaceTransferInfo implements IRecipeTransferInfo<PrimitiveAlloyFurnaceMenu, PrimitiveAlloyRecipe> {
    @Override
    public Class<? extends PrimitiveAlloyFurnaceMenu> getContainerClass() {
        return PrimitiveAlloyFurnaceMenu.class;
    }

    @Override
    public Optional<MenuType<PrimitiveAlloyFurnaceMenu>> getMenuType() {
        return Optional.of(EPMenuTypes.PRIMITIVE_ALLOY_FURNACE_MENU.get());
    }

    @Override
    public RecipeType<PrimitiveAlloyRecipe> getRecipeType() {
        return PrimitiveAlloyingCategory.PRIMITIVE_ALLOY_RECIPE_TYPE;
    }

    @Override
    public boolean canHandle(PrimitiveAlloyFurnaceMenu container, PrimitiveAlloyRecipe recipe) {
        return true;
    }

    @Override
    public List<Slot> getRecipeSlots(PrimitiveAlloyFurnaceMenu container, PrimitiveAlloyRecipe recipe) {
        return List.of(container.getSlot(0), container.getSlot(1), container.getSlot(2));
    }

    @Override
    public List<Slot> getInventorySlots(PrimitiveAlloyFurnaceMenu container, PrimitiveAlloyRecipe recipe) {
        return container.slots.subList(4, 40);
    }
}
