package net.marmar.enhanced_playthrough.compat.jei.itemtransfer;

import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.transfer.IRecipeTransferInfo;
import net.marmar.enhanced_playthrough.compat.jei.category.OreAlloyingCategory;
import net.marmar.enhanced_playthrough.menu.EPMenuTypes;
import net.marmar.enhanced_playthrough.menu.alloyfurnace.AdobeAlloyFurnaceMenu;
import net.marmar.enhanced_playthrough.recipe.alloy.AlloyRecipe;
import net.minecraft.client.Minecraft;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;

import java.util.List;
import java.util.Optional;

public class AlloyFurnaceTransferInfo implements IRecipeTransferInfo<AdobeAlloyFurnaceMenu, AlloyRecipe> {
    @Override
    public Class<? extends AdobeAlloyFurnaceMenu> getContainerClass() {
        return AdobeAlloyFurnaceMenu.class;
    }

    @Override
    public Optional<MenuType<AdobeAlloyFurnaceMenu>> getMenuType() {
        return Optional.of(EPMenuTypes.ADOBE_ALLOY_FURNACE_MENU.get());
    }

    @Override
    public RecipeType<AlloyRecipe> getRecipeType() {
        return OreAlloyingCategory.ALLOYING_FURNACE_RECIPE_RECIPE_TYPE;
    }

    @Override
    public boolean canHandle(AdobeAlloyFurnaceMenu container, AlloyRecipe recipe) {
        return true;
    }

    @Override
    public List<Slot> getRecipeSlots(AdobeAlloyFurnaceMenu container, AlloyRecipe recipe) {
        return List.of(container.getSlot(0), container.getSlot(1), container.getSlot(2));
    }

    @Override
    public List<Slot> getInventorySlots(AdobeAlloyFurnaceMenu container, AlloyRecipe recipe) {
        return container.slots.subList(4, 40);
    }
}
