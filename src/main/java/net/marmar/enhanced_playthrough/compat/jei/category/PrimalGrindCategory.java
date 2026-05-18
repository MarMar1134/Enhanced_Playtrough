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
import net.marmar.enhanced_playthrough.recipe.grind.PrimalGrindRecipe;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;

import java.util.List;

@SuppressWarnings("removal")
public class PrimalGrindCategory implements IRecipeCategory<PrimalGrindRecipe> {
    public static final ResourceLocation UID = new ResourceLocation(EnhancedPlaythrough.MOD_ID, "primal_grinding");
    public static final ResourceLocation TEXTURE = new ResourceLocation(EnhancedPlaythrough.MOD_ID,
            "textures/gui/primal_grinder_gui.png");

    public static final RecipeType<PrimalGrindRecipe> PRIMAL_GRINDING_RECIPE_RECIPE_TYPE =
            new RecipeType<>(UID, PrimalGrindRecipe.class);

    private final IDrawable background;
    private final IDrawable flames;
    private final IDrawable arrow;
    private final IDrawable icon;

    public PrimalGrindCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 4, 3, 168, 78);

        IDrawableStatic flameStatic = helper.createDrawable(TEXTURE, 176, 0, 14, 14);
        this.flames = helper.createAnimatedDrawable(flameStatic, 300, IDrawableAnimated.StartDirection.TOP, true);

        IDrawableStatic arrowStatic = helper.createDrawable(TEXTURE, 176, 14, 25, 17);
        this.arrow = helper.createAnimatedDrawable(arrowStatic, 200, IDrawableAnimated.StartDirection.LEFT, false);

        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(EPBlocks.PRIMAL_GRINDER.get()));
    }

    @Override
    public void draw(PrimalGrindRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
        this.flames.draw(guiGraphics, 40, 34);
        this.arrow.draw(guiGraphics, 76, 33);

        int recipeTime = 10;
        Component timeText = Component.literal(recipeTime + "s");
        guiGraphics.drawString(Minecraft.getInstance().font, timeText, 128, 57, 0xFF808080, false);
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

    private List<ItemStack> getValidFuels() {
        return ForgeRegistries.ITEMS.getValues()
                .stream()
                .filter(item -> ForgeHooks.getBurnTime(new ItemStack(item), null) > 0)
                .map(ItemStack::new)
                .toList();
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, PrimalGrindRecipe primalGrindRecipe, IFocusGroup iFocusGroup) {
        builder.addSlot(RecipeIngredientRole.INPUT, 40, 17).addIngredients(primalGrindRecipe.getIngredient());

        builder.addSlot(RecipeIngredientRole.INPUT, 40, 50).addItemStacks(getValidFuels());

        builder.addSlot(RecipeIngredientRole.OUTPUT, 125, 34).addItemStack(primalGrindRecipe.getResultItem(null));
    }
}
