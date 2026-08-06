package net.marmar.enhanced_playthrough.compat.jei.itemtransfer;

import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.transfer.IRecipeTransferInfo;
import net.marmar.enhanced_playthrough.compat.jei.category.GemPolishingCategory;
import net.marmar.enhanced_playthrough.menu.EPMenuTypes;
import net.marmar.enhanced_playthrough.menu.gempolisher.GemPolisherMenu;
import net.marmar.enhanced_playthrough.recipe.GemPolishingRecipe;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;

import java.util.List;
import java.util.Optional;

public class GemPolisherTransferInfo implements IRecipeTransferInfo<GemPolisherMenu, GemPolishingRecipe> {
    @Override
    public Class<? extends GemPolisherMenu> getContainerClass() {
        return GemPolisherMenu.class;
    }

    @Override
    public Optional<MenuType<GemPolisherMenu>> getMenuType() {
        return Optional.of(EPMenuTypes.GEM_POLISHER_MENU.get());
    }

    @Override
    public RecipeType<GemPolishingRecipe> getRecipeType() {
        return GemPolishingCategory.GEM_POLISHER_RECIPE_TYPE;
    }

    @Override
    public boolean canHandle(GemPolisherMenu container, GemPolishingRecipe recipe) {
        return true;
    }

    @Override
    public List<Slot> getRecipeSlots(GemPolisherMenu container, GemPolishingRecipe recipe) {
        return List.of(container.getSlot(0), container.getSlot(1));
    }

    @Override
    public List<Slot> getInventorySlots(GemPolisherMenu container, GemPolishingRecipe recipe) {
        return container.slots.subList(3, 39);
    }
}
