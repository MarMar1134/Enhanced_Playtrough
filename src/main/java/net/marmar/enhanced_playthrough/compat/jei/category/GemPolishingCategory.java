package net.marmar.enhanced_playthrough.compat.jei.category;

import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.gui.drawable.IDrawableStatic;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.block.EPBlocks;
import net.marmar.enhanced_playthrough.datagen.tag.EPTags;
import net.marmar.enhanced_playthrough.recipe.GemPolishingRecipe;
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
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;

@SuppressWarnings("removal")
public class GemPolishingCategory implements IRecipeCategory<GemPolishingRecipe> {
    public static final ResourceLocation UID = new ResourceLocation(EnhancedPlaythrough.MOD_ID, "gem_polishing");
    public static final ResourceLocation TEXTURE = new ResourceLocation(EnhancedPlaythrough.MOD_ID,
            "textures/gui/gem_polisher_gui.png");

    public static final RecipeType<GemPolishingRecipe> GEM_POLISHER_RECIPE_TYPE =
            new RecipeType<>(UID, GemPolishingRecipe.class);

    private final IDrawable background;
    private final IDrawable progressBar;
    private final IDrawable arrow;
    private final IDrawable icon;

    public GemPolishingCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 4, 3, 168, 78);

        IDrawableStatic progressBarStatic = helper.createDrawable(TEXTURE, 176, 0, 60, 12);
        this.progressBar = helper.createAnimatedDrawable(progressBarStatic, 400, IDrawableAnimated.StartDirection.RIGHT, true);

        IDrawableStatic arrowStatic = helper.createDrawable(TEXTURE, 176, 12, 41, 15);
        this.arrow = helper.createAnimatedDrawable(arrowStatic, 200, IDrawableAnimated.StartDirection.LEFT, false);

        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(EPBlocks.GEM_POLISHER.get()));
    }

    @Override
    public void draw(GemPolishingRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
        this.progressBar.draw(guiGraphics, 28, 58);
        this.arrow.draw(guiGraphics, 74, 32);

        float recipeTime = 2.5f;
        Component timeText = Component.literal(recipeTime + "s");
        guiGraphics.drawString(Minecraft.getInstance().font, timeText, 127, 51, 0xFF808080, false);
    }

    @Override
    public RecipeType<GemPolishingRecipe> getRecipeType() {
        return GEM_POLISHER_RECIPE_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("jei.enhanced_playthrough.gem_polisher");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    private List<ItemStack> getPolishers() {
        return ForgeRegistries.ITEMS.tags()
                .getTag(EPTags.Items.POLISHER)
                .stream()
                .map(ItemStack::new)
                .toList();
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, GemPolishingRecipe recipe, IFocusGroup focusGroup) {
        builder.addSlot(RecipeIngredientRole.INPUT, 4,6).addItemStacks(getPolishers());

        builder.addSlot(RecipeIngredientRole.INPUT, 51, 31).addIngredients(recipe.getIngredient());

        builder.addSlot(RecipeIngredientRole.OUTPUT, 126,30).addItemStack(recipe.getResultItem(null));
    }
}
