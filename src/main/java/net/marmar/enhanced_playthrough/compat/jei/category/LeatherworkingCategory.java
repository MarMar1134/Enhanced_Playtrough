package net.marmar.enhanced_playthrough.compat.jei.category;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.forge.ForgeTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.block.EPBlocks;
import net.marmar.enhanced_playthrough.recipe.leatherwork.CuringRecipe;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("removal")
public class LeatherworkingCategory implements IRecipeCategory<CuringRecipe> {
    public static final ResourceLocation UID = new ResourceLocation(EnhancedPlaythrough.MOD_ID, "curing");
    public static final ResourceLocation TEXTURE = new ResourceLocation(EnhancedPlaythrough.MOD_ID,
            "textures/gui/leatherworker_station_gui.png");

    public static final RecipeType<CuringRecipe> LEATHERWORKING_RECIPE_TYPE =
            new RecipeType<>(UID, CuringRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;

    public LeatherworkingCategory(IGuiHelper helper){
        this.background = helper.createDrawable(TEXTURE, 4,3,168,78);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(EPBlocks.LEATHERWORKER_STATION.get()));
    }

    @Override
    public RecipeType<CuringRecipe> getRecipeType() {
        return LEATHERWORKING_RECIPE_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("jei.enhanced_playthrough.leatherworker_station");
    }

    @Override
    public @Nullable IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public @Nullable IDrawable getBackground() {
        return this.background;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, CuringRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 14,16).addIngredients(recipe.getCatalyst());

        builder.addSlot(RecipeIngredientRole.INPUT, 41, 16)
                .setFluidRenderer(1000, false, 12, 48)
                .addIngredient(ForgeTypes.FLUID_STACK, recipe.getFluidStack());

        builder.addSlot(RecipeIngredientRole.INPUT, 64,32).addIngredients(recipe.getInput());

        builder.addSlot(RecipeIngredientRole.OUTPUT, 134, 32).addItemStack(new ItemStack(recipe.getResultItem(null).getItem(), recipe.getOutputAmount()));
    }
}
