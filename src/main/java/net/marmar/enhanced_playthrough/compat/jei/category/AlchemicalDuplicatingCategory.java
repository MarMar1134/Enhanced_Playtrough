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
import net.marmar.enhanced_playthrough.item.EPItems;
import net.marmar.enhanced_playthrough.recipe.alchemicalduplication.AlchemicalDuplicationRecipe;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("removal")
public class AlchemicalDuplicatingCategory implements IRecipeCategory<AlchemicalDuplicationRecipe> {
    public static final ResourceLocation UID = new ResourceLocation(EnhancedPlaythrough.MOD_ID, "alchemical_duplicating");
    public static final ResourceLocation TEXTURE = new ResourceLocation(EnhancedPlaythrough.MOD_ID,
            "textures/gui/alchemical_duplicator_gui.png");

    public static final RecipeType<AlchemicalDuplicationRecipe> ALCHEMICAL_DUPLICATING_RECIPE_RECIPE_TYPE =
            new RecipeType<>(UID, AlchemicalDuplicationRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;

    public AlchemicalDuplicatingCategory(IGuiHelper helper){
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 82);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(EPBlocks.ALCHEMICAL_DUPLICATOR.get()));
    }

    @Override
    public RecipeType<AlchemicalDuplicationRecipe> getRecipeType() {
        return ALCHEMICAL_DUPLICATING_RECIPE_RECIPE_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("jei.enhanced_playthrough.alchemical_duplicator");
    }

    @Override
    public @Nullable IDrawable getBackground() {
        return this.background;
    }

    @Override
    public @Nullable IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, AlchemicalDuplicationRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 16, 22).addItemStack(new ItemStack(EPItems.SULFUR.get()));
        builder.addSlot(RecipeIngredientRole.INPUT, 80, 22).addIngredients(recipe.getIngredients().get(0));

        ItemStack result = recipe.getResultItem(null);

        builder.addSlot(RecipeIngredientRole.OUTPUT, 33, 56).addItemStack(result);
        builder.addSlot(RecipeIngredientRole.OUTPUT, 65, 56).addItemStack(result);
        builder.addSlot(RecipeIngredientRole.OUTPUT, 97, 56).addItemStack(result);
        builder.addSlot(RecipeIngredientRole.OUTPUT, 129, 56).addItemStack(result);
    }


}
