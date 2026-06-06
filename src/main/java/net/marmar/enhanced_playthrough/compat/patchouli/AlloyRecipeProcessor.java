package net.marmar.enhanced_playthrough.compat.patchouli;

import net.marmar.enhanced_playthrough.recipe.alloy.AbstractAlloyRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.level.Level;
import vazkii.patchouli.api.IComponentProcessor;
import vazkii.patchouli.api.IVariable;
import vazkii.patchouli.api.IVariableProvider;

@SuppressWarnings("removal")
public class AlloyRecipeProcessor implements IComponentProcessor {
    private AbstractAlloyRecipe alloyRecipe;

    @Override
    public void setup(Level level, IVariableProvider variables) {
        ResourceLocation id = new ResourceLocation(variables.get("recipe").asString());
        RecipeManager manager = level.getRecipeManager();
        this.alloyRecipe = (AbstractAlloyRecipe) manager.byKey(id).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public IVariable process(Level level, String key) {
        switch (key) {
            case "title" -> {
                ItemStack output = this.alloyRecipe.getResultItem(level.registryAccess());

                return IVariable.wrap(output.getHoverName().getString());
            }
            case "first_input" -> {
                ItemStack[] firstInputs = this.alloyRecipe.getFirstIngredient().getItems();
                ItemStack firstInput = firstInputs.length == 0 ? ItemStack.EMPTY : firstInputs[0];

                return IVariable.from(firstInput);
            }
            case "second_input" -> {
                ItemStack[] secondInputs = this.alloyRecipe.getSecondIngredient().getItems();
                ItemStack secondInput = secondInputs.length == 0 ? ItemStack.EMPTY : secondInputs[0];

                return IVariable.from(secondInput);
            }
            case "output" -> {
                ItemStack output = this.alloyRecipe.getResultItem(level.registryAccess());

                return IVariable.from(output);
            }
        }

        return null;
    }
}
