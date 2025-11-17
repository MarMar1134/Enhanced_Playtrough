package net.marmar.enhanced_playthrough.data.recipe;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;

import java.util.function.Consumer;

public class EPRecipeProvider extends RecipeProvider{
    public EPRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        //Basic smelting, Smelting, Blast smelting, Smoking and Campfire cooking recipes
        SmeltingRecipeSubProvider.addSmeltingRecipes(consumer);

        //Alloy and Blast alloy recipes
        AlloyRecipeSubProvider.addAlloyRecipes(consumer);

        //Stone cutting, Item grinding, Gem polishing and smithing recipes
        GeneralRecipeSubProvider.addGeneralRecipes(consumer);

        //Shaped and shapeless recipes
        CraftingRecipeSubProvider.addCraftingRecipes(consumer);
    }
}