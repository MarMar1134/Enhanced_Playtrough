package net.marmar.enhanced_playthrough.compat.jei.category;

import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.gui.drawable.IDrawableStatic;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
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
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;

@SuppressWarnings("removal")
public class SuperAlloyingCategory implements IRecipeCategory<BlastAlloyRecipe> {
    public static final ResourceLocation UID = new ResourceLocation(EnhancedPlaythrough.MOD_ID, "super_ore_alloying");
    public static final ResourceLocation TEXTURE = new ResourceLocation(EnhancedPlaythrough.MOD_ID,
            "textures/gui/alloy_furnace_gui.png");

    public static final RecipeType<BlastAlloyRecipe> SUPER_ALLOYING_RECIPE_TYPE =
            new RecipeType<>(UID, BlastAlloyRecipe.class);

    private final IDrawable background;
    private final IDrawable flames;
    private final IDrawable arrow;
    private final IDrawable icon;

    public SuperAlloyingCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 4, 3, 168, 78);

        IDrawableStatic flameStatic = helper.createDrawable(TEXTURE, 176, 0, 14, 14);
        this.flames = helper.createAnimatedDrawable(flameStatic, 300, IDrawableAnimated.StartDirection.TOP, true);

        IDrawableStatic arrowStatic = helper.createDrawable(TEXTURE, 176, 14, 24, 17);
        this.arrow = helper.createAnimatedDrawable(arrowStatic, 100, IDrawableAnimated.StartDirection.LEFT, false);

        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(EPBlocks.SUPER_ALLOY_FURNACE.get()));
    }

    @Override
    public void draw(BlastAlloyRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
        this.flames.draw(guiGraphics, 52, 33);
        this.arrow.draw(guiGraphics, 76, 31);

        int recipeTime = recipe.getAlloyTime() / 20;
        Component timeText = Component.literal(recipeTime + "s");
        guiGraphics.drawString(Minecraft.getInstance().font, timeText, 124, 55, 0xFF808080, false);
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

    private List<ItemStack> getValidFuels() {
        return ForgeRegistries.ITEMS.getValues()
                .stream()
                .filter(item -> ForgeHooks.getBurnTime(new ItemStack(item), null) > 0)
                .map(ItemStack::new)
                .toList();
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, BlastAlloyRecipe recipe, IFocusGroup iFocusGroup) {
        builder.addSlot(RecipeIngredientRole.INPUT, 33, 14).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.INPUT, 70,14).addIngredients(recipe.getIngredients().get(1));

        builder.addSlot(RecipeIngredientRole.INPUT, 52, 50).addItemStacks(getValidFuels());

        builder.addSlot(RecipeIngredientRole.OUTPUT, 112, 32).addItemStack(recipe.getResultItem(null));
    }
}
