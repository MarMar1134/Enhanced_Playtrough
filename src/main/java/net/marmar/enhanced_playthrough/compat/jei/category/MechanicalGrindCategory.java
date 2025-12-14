package net.marmar.enhanced_playthrough.compat.jei.category;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.block.EPBlocks;
import net.marmar.enhanced_playthrough.recipe.grind.MechanicalGrindRecipe;
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
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("removal")
public class MechanicalGrindCategory implements IRecipeCategory<MechanicalGrindRecipe> {
    public static final ResourceLocation UID = new ResourceLocation(EnhancedPlaythrough.MOD_ID, "mechanical_grinding");
    public static final ResourceLocation TEXTURE = new ResourceLocation(EnhancedPlaythrough.MOD_ID,
            "textures/gui/mechanical_grinder_gui.png");

    public static final RecipeType<MechanicalGrindRecipe> GRINDING_RECIPE_RECIPE_TYPE =
            new RecipeType<>(UID, MechanicalGrindRecipe.class);
    private final IDrawable background;
    private final IDrawable icon;

    public MechanicalGrindCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 80);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(EPBlocks.MECHANICAL_GRINDER.get()));
    }
    @Override
    public RecipeType<MechanicalGrindRecipe> getRecipeType() {
        return GRINDING_RECIPE_RECIPE_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("jei.enhanced_playthrough.mechanical_grinder");
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
    public void setRecipe(IRecipeLayoutBuilder recipeLayoutBuilder, MechanicalGrindRecipe mechanicalGrindRecipe, IFocusGroup iFocusGroup) {
        recipeLayoutBuilder.addSlot(RecipeIngredientRole.INPUT, 49, 32).addIngredients(mechanicalGrindRecipe.getIngredient());

        recipeLayoutBuilder.addSlot(RecipeIngredientRole.OUTPUT, 132, 32).addItemStack(mechanicalGrindRecipe.getResultItem(null));
    }
}
