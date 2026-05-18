package net.marmar.enhanced_playthrough.compat.jei.itemtransfer;

import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.transfer.IRecipeTransferInfo;
import net.marmar.enhanced_playthrough.compat.jei.category.SoulBasicSmeltingCategory;
import net.marmar.enhanced_playthrough.menu.EPMenuTypes;
import net.marmar.enhanced_playthrough.menu.epfurnace.SoulFurnaceMenu;
import net.marmar.enhanced_playthrough.recipe.epsmelt.SoulBasicSmeltingRecipe;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;

import java.util.List;
import java.util.Optional;

public class SoulFurnaceTransferInfo implements IRecipeTransferInfo<SoulFurnaceMenu, SoulBasicSmeltingRecipe> {
    @Override
    public Class<? extends SoulFurnaceMenu> getContainerClass() {
        return SoulFurnaceMenu.class;
    }

    @Override
    public Optional<MenuType<SoulFurnaceMenu>> getMenuType() {
        return Optional.of(EPMenuTypes.SOUL_FURNACE_MENU.get());
    }

    @Override
    public RecipeType<SoulBasicSmeltingRecipe> getRecipeType() {
        return SoulBasicSmeltingCategory.SOUL_BASIC_SMELTING_TYPE;
    }

    @Override
    public boolean canHandle(SoulFurnaceMenu container, SoulBasicSmeltingRecipe recipe) {
        return true;
    }

    @Override
    public List<Slot> getRecipeSlots(SoulFurnaceMenu container, SoulBasicSmeltingRecipe recipe) {
        return List.of(container.getSlot(0), container.getSlot(1));
    }

    @Override
    public List<Slot> getInventorySlots(SoulFurnaceMenu container, SoulBasicSmeltingRecipe recipe) {
        return container.slots.subList(3, 39);
    }
}
