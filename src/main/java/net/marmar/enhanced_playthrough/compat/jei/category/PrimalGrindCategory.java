package net.marmar.enhanced_playthrough.compat.jei.category;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.block.EPBlocks;
import net.marmar.enhanced_playthrough.recipe.grind.PrimalGrindRecipe;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("removal")
public class PrimalGrindCategory implements IRecipeCategory<PrimalGrindRecipe> {
    public static final ResourceLocation UID = new ResourceLocation(EnhancedPlaythrough.MOD_ID, "primal_grinding");
    public static final ResourceLocation TEXTURE = new ResourceLocation(EnhancedPlaythrough.MOD_ID,
            "textures/gui/primal_grinder_gui.png");

    public static final RecipeType<PrimalGrindRecipe> PRIMAL_GRINDING_RECIPE_RECIPE_TYPE =
            new RecipeType<>(UID, PrimalGrindRecipe.class);
    private final IDrawable background;
    private final IDrawable icon;

    public PrimalGrindCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 80);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(EPBlocks.PRIMAL_GRINDER.get()));
    }
    @Override
    public RecipeType<PrimalGrindRecipe> getRecipeType() {
        return PRIMAL_GRINDING_RECIPE_RECIPE_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("jei.enhanced_playthrough.primal_grinder");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public @Nullable IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder recipeLayoutBuilder, PrimalGrindRecipe primalGrindRecipe, IFocusGroup iFocusGroup) {
        recipeLayoutBuilder.addSlot(RecipeIngredientRole.INPUT, 44, 20).addIngredients(primalGrindRecipe.getIngredient());

        recipeLayoutBuilder.addSlot(RecipeIngredientRole.OUTPUT, 129, 37).addItemStack(primalGrindRecipe.getResultItem(null));
    }
}
