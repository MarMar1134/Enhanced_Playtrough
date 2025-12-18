package net.marmar.enhanced_playthrough.recipe.alloy;

import net.marmar.enhanced_playthrough.recipe.recipecategory.AlloyRecipeCategory;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

public abstract class AbstractAlloyRecipe implements Recipe<SimpleContainer> {
    protected final RecipeType<?> recipeType;
    protected final NonNullList<Ingredient> inputs;
    protected final ItemStack output;
    protected final int alloyTime;
    protected final float xpAmount;
    protected final ResourceLocation recipeId;
    private final AlloyRecipeCategory category;
    private final String group;

    public AbstractAlloyRecipe(NonNullList<Ingredient> pInputs, ItemStack pOutput, int pAlloyTime, float pXpAmount, ResourceLocation pRecipeId, RecipeType<?> pType, AlloyRecipeCategory pCategory, String pGroup) {
        this.inputs = pInputs;
        this.output = pOutput;
        this.alloyTime = pAlloyTime;
        this.xpAmount = pXpAmount;
        this.recipeId = pRecipeId;
        this.recipeType = pType;
        this.category = pCategory;
        this.group = pGroup;
    }

    public int getAlloyTime(){
        return this.alloyTime;
    }

    public float getXpAmount(){
        return this.xpAmount;
    }

    @Override
    public boolean matches(SimpleContainer simpleContainer, Level level) {
        if (level.isClientSide){
            return false;
        }
        return inputs.get(0).test(simpleContainer.getItem(0)) && inputs.get(1).test(simpleContainer.getItem(1));
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return this.inputs;
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
}
