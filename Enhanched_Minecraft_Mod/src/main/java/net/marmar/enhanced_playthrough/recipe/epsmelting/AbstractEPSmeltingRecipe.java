package net.marmar.enhanced_playthrough.recipe.epsmelting;

import net.marmar.enhanced_playthrough.recipe.recipecategory.ModRecipeCategory;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.Level;

public abstract class AbstractEPSmeltingRecipe implements Recipe<SimpleContainer> {
    private final Ingredient input;
    private final ItemStack output;
    private final ResourceLocation recipeId;
    private final int cookTime;
    private final ModRecipeCategory category;
    private final String group;

    public AbstractEPSmeltingRecipe(Ingredient pInput, ItemStack pOutput, ResourceLocation pRecipeId, int pCookTime, ModRecipeCategory pCategory, String pGroup) {
        this.input = pInput;
        this.output = pOutput;
        this.recipeId = pRecipeId;
        cookTime = pCookTime;
        this.category = pCategory;
        this.group = pGroup;
    }

    public Ingredient getIngredient() {
        return this.input;
    }

    @Override
    public boolean matches(SimpleContainer simpleContainer, Level level) {
        if (level.isClientSide){
            return false;
        }
        return input.test(simpleContainer.getItem(0));
    }

    @Override
    public ItemStack assemble(SimpleContainer simpleContainer, RegistryAccess registryAccess) {
        return output.copy();
    }

    @Override
    public boolean canCraftInDimensions(int i, int i1) {
        return true;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess registryAccess) {
        return output.copy();
    }

    @Override
    public ResourceLocation getId() {
        return recipeId;
    }

    public int getCookTime(){
        return cookTime;
    }
}
