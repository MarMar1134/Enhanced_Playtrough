package net.marmar.enhanced_playthrough.compat.jei.category;

import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.gui.drawable.IDrawableStatic;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
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
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
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
    private final IDrawable led;
    private final IDrawable arrow;
    private final IDrawable icon;

    public MechanicalGrindCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 4, 3, 168, 78);

        this.led = helper.createDrawable(TEXTURE, 176,17, 17, 8);

        IDrawableStatic arrowStatic = helper.createDrawable(TEXTURE, 176, 0, 25, 17);
        this.arrow = helper.createAnimatedDrawable(arrowStatic, 200, IDrawableAnimated.StartDirection.LEFT, false);

        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(EPBlocks.MECHANICAL_GRINDER.get()));
    }

    @Override
    public void draw(MechanicalGrindRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
        this.led.draw(guiGraphics, 14, 33);
        this.arrow.draw(guiGraphics, 80, 28);

        float recipeTime = 7.5f;
        Component timeText = Component.literal(recipeTime + "s");
        guiGraphics.drawString(Minecraft.getInstance().font, timeText, 131, 52, 0xFF808080, false);
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
        recipeLayoutBuilder.addSlot(RecipeIngredientRole.INPUT, 45, 29).addIngredients(mechanicalGrindRecipe.getIngredient());

        recipeLayoutBuilder.addSlot(RecipeIngredientRole.OUTPUT, 128, 29).addItemStack(mechanicalGrindRecipe.getResultItem(null));
    }
}
