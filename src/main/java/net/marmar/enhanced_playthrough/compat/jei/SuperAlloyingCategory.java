package net.marmar.enhanced_playthrough.compat.jei;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.block.EPBlocks;
import net.marmar.enhanced_playthrough.recipe.alloy.BlastAlloyRecipe;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

@SuppressWarnings("removal")
public class SuperAlloyingCategory implements IRecipeCategory<BlastAlloyRecipe> {
    public static final ResourceLocation UID = ResourceLocation.fromNamespaceAndPath(EnhancedPlaythrough.MOD_ID, "super_ore_alloying");
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(EnhancedPlaythrough.MOD_ID,
            "textures/gui/alloy_furnace_gui.png");

    public static final RecipeType<BlastAlloyRecipe> SUPER_ALLOYING_RECIPE_TYPE =
            new RecipeType<>(UID, BlastAlloyRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;

    public SuperAlloyingCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 82);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(EPBlocks.SUPER_ALLOY_FURNACE.get()));
    }

    @Override
    public RecipeType<BlastAlloyRecipe> getRecipeType() {
        return SUPER_ALLOYING_RECIPE_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("jei.enhanced_playthrough.super_alloying_furnace");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, BlastAlloyRecipe recipe, IFocusGroup iFocusGroup) {
        builder.addSlot(RecipeIngredientRole.INPUT, 37, 17).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.INPUT, 74,17).addIngredients(recipe.getIngredients().get(1));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 116, 35).addItemStack(recipe.getResultItem(null));
    }
}
