package net.marmar.enhanced_playthrough.compat.jei.itemtransfer;

import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.transfer.IRecipeTransferInfo;
import net.marmar.enhanced_playthrough.compat.jei.category.BasicSmeltingCategory;
import net.marmar.enhanced_playthrough.menu.EPMenuTypes;
import net.marmar.enhanced_playthrough.menu.epfurnace.AdobeFurnaceMenu;
import net.marmar.enhanced_playthrough.recipe.epsmelt.BasicSmeltingRecipe;
import net.minecraft.client.Minecraft;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;

import java.util.List;
import java.util.Optional;

public class AdobeFurnaceTransferInfo implements IRecipeTransferInfo<AdobeFurnaceMenu, BasicSmeltingRecipe> {
    @Override
    public Class<? extends AdobeFurnaceMenu> getContainerClass() {
        return AdobeFurnaceMenu.class;
    }

    @Override
    public Optional<MenuType<AdobeFurnaceMenu>> getMenuType() {
        return Optional.of(EPMenuTypes.ADOBE_FURNACE_MENU.get());
    }

    @Override
    public RecipeType<BasicSmeltingRecipe> getRecipeType() {
        return BasicSmeltingCategory.BASIC_SMELTING_TYPE;
    }

    @Override
    public boolean canHandle(AdobeFurnaceMenu container, BasicSmeltingRecipe recipe) {
        return true;
    }

    @Override
    public List<Slot> getRecipeSlots(AdobeFurnaceMenu container, BasicSmeltingRecipe recipe) {
        return List.of(
                container.getSlot(0), container.getSlot(1)
        );
    }

    @Override
    public List<Slot> getInventorySlots(AdobeFurnaceMenu container, BasicSmeltingRecipe recipe) {
        return container.slots.subList(3, 39);
    }

}
