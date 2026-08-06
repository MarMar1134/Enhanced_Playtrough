package net.marmar.enhanced_playthrough.compat.jei.category;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.gui.drawable.IDrawableStatic;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.block.EPBlocks;
import net.marmar.enhanced_playthrough.recipe.epsmelt.MasonrySmeltingRecipe;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;

import java.util.List;

@SuppressWarnings("removal")
public class MasonrySmeltingCategory implements IRecipeCategory<MasonrySmeltingRecipe> {
    public static final ResourceLocation UID = new ResourceLocation(EnhancedPlaythrough.MOD_ID, "masonry_smelting");
    public static final ResourceLocation TEXTURE = new ResourceLocation(EnhancedPlaythrough.MOD_ID,
            "textures/gui/basic_furnace_gui.png");

    public static final RecipeType<MasonrySmeltingRecipe> MASONRY_SMELTING_TYPE =
            new RecipeType<>(UID, MasonrySmeltingRecipe.class);

    private final IDrawable background;
    private final IDrawable flames;
    private final IDrawable arrow;
    private final IDrawable icon;

    public MasonrySmeltingCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 4, 3, 168, 78);

        IDrawableStatic flameStatic = helper.createDrawable(TEXTURE, 176, 0, 14, 14);
        this.flames = helper.createAnimatedDrawable(flameStatic, 300, IDrawableAnimated.StartDirection.TOP, true);

        IDrawableStatic arrowStatic = helper.createDrawable(TEXTURE, 176, 14, 24, 17);
        this.arrow = helper.createAnimatedDrawable(arrowStatic, 100, IDrawableAnimated.StartDirection.LEFT, false);

        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(EPBlocks.MASONRY_FURNACE.get()));
    }

    @Override
    public void draw(MasonrySmeltingRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
        this.flames.draw(guiGraphics, 52, 33);
        this.arrow.draw(guiGraphics, 75, 31);

        int recipeTime = recipe.getCookTime() / 20;
        Component timeText = Component.literal(recipeTime + "s");
        guiGraphics.drawString(Minecraft.getInstance().font, timeText, 121, 55, 0xFF808080, false);
    }

    @Override
    public RecipeType<MasonrySmeltingRecipe> getRecipeType() {
        return MASONRY_SMELTING_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("jei.enhanced_playthrough.masonry_furnace");
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
    public void setRecipe(IRecipeLayoutBuilder builder, MasonrySmeltingRecipe recipe, IFocusGroup focusGroup) {
        builder.addSlot(RecipeIngredientRole.INPUT, 52, 14).addIngredients(recipe.getIngredient());

        builder.addSlot(RecipeIngredientRole.OUTPUT, 112,32).addItemStack(recipe.getResultItem(null));
    }
}
