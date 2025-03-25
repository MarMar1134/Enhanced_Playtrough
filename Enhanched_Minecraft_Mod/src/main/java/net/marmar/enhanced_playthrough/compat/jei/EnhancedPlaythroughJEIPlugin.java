package net.marmar.enhanced_playthrough.compat.jei;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.menu.alloyfurnace.screen.AdobeAlloyFurnaceScreen;
import net.marmar.enhanced_playthrough.menu.alloyfurnace.screen.SuperAlloyFurnaceScreen;
import net.marmar.enhanced_playthrough.menu.basicfurnace.screen.AdobeFurnaceScreen;
import net.marmar.enhanced_playthrough.menu.basicfurnace.screen.SoulFurnaceScreen;
import net.marmar.enhanced_playthrough.menu.gempolisher.screen.GemPolisherScreen;
import net.marmar.enhanced_playthrough.menu.grinder.screen.MechanicalGrinderScreen;
import net.marmar.enhanced_playthrough.menu.grinder.screen.PrimalGrinderScreen;
import net.marmar.enhanced_playthrough.recipe.GemPolishingRecipe;
import net.marmar.enhanced_playthrough.recipe.grind.MechanicalGrindRecipe;
import net.marmar.enhanced_playthrough.recipe.ModRecipes;
import net.marmar.enhanced_playthrough.recipe.alloy.AlloyRecipe;
import net.marmar.enhanced_playthrough.recipe.alloy.BlastAlloyRecipe;
import net.marmar.enhanced_playthrough.recipe.basicsmelt.BasicSmeltRecipe;
import net.marmar.enhanced_playthrough.recipe.basicsmelt.SoulBasicSmeltRecipe;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.marmar.enhanced_playthrough.recipe.grind.PrimalGrindRecipe;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;

@JeiPlugin
public class EnhancedPlaythroughJEIPlugin implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(EnhancedPlaythrough.MOD_ID, "jei_plugin");
    }
    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        //Basic smelt recipes
        registration.addRecipeCategories(new BasicSmeltingCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new SoulBasicSmeltingCategory(registration.getJeiHelpers().getGuiHelper()));

        //Alloy furnaces
        registration.addRecipeCategories(new OreAlloyingCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new SuperAlloyingCategory(registration.getJeiHelpers().getGuiHelper()));

        //Gem polish recipes
        registration.addRecipeCategories(new GemPolishingCategory(registration.getJeiHelpers().getGuiHelper()));

        //Grind recipes
        registration.addRecipeCategories(new PrimalGrindCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new MechanicalGrindCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();

        List<BasicSmeltRecipe> basicSmeltingRecipes = recipeManager.getAllRecipesFor(ModRecipes.BASIC_SMELTING_TYPE.get());
        registration.addRecipes(BasicSmeltingCategory.BASIC_SMELTING_TYPE, basicSmeltingRecipes);

        List<SoulBasicSmeltRecipe> soulBasicSmeltingRecipes = recipeManager.getAllRecipesFor(ModRecipes.SOUL_BASIC_SMELTING_TYPE.get());
        registration.addRecipes(SoulBasicSmeltingCategory.SOUL_BASIC_SMELTING_TYPE, soulBasicSmeltingRecipes);

        List<AlloyRecipe> alloyingRecipes = recipeManager.getAllRecipesFor(ModRecipes.ALLOYING_TYPE.get());
        registration.addRecipes(OreAlloyingCategory.ALLOYING_FURNACE_RECIPE_RECIPE_TYPE, alloyingRecipes);

        List<GemPolishingRecipe> gemPolishingRecipes = recipeManager.getAllRecipesFor(ModRecipes.POLISHING_TYPE.get());
        registration.addRecipes(GemPolishingCategory.GEM_POLISHER_RECIPE_TYPE, gemPolishingRecipes);

        List<BlastAlloyRecipe> blastAlloyRecipes = recipeManager.getAllRecipesFor(ModRecipes.SUPER_ALLOYING_TYPE.get());
        registration.addRecipes(SuperAlloyingCategory.SUPER_ALLOYING_RECIPE_TYPE, blastAlloyRecipes);

        List<PrimalGrindRecipe> primalGrindRecipes = recipeManager.getAllRecipesFor(ModRecipes.PRIMAL_GRINDING_TYPE.get());
        registration.addRecipes(PrimalGrindCategory.PRIMAL_GRINDING_RECIPE_RECIPE_TYPE, primalGrindRecipes);

        List<MechanicalGrindRecipe> mechanicalGrindRecipes = recipeManager.getAllRecipesFor(ModRecipes.MECHANICAL_GRINDING_TYPE.get());
        registration.addRecipes(MechanicalGrindCategory.GRINDING_RECIPE_RECIPE_TYPE, mechanicalGrindRecipes);
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(AdobeFurnaceScreen.class, 80, 38, 14, 9,
                BasicSmeltingCategory.BASIC_SMELTING_TYPE);

        registration.addRecipeClickArea(SoulFurnaceScreen.class, 80, 38, 14, 9,
                SoulBasicSmeltingCategory.SOUL_BASIC_SMELTING_TYPE);

        registration.addRecipeClickArea(AdobeAlloyFurnaceScreen.class, 59, 19, 13, 11,
                OreAlloyingCategory.ALLOYING_FURNACE_RECIPE_RECIPE_TYPE);


        registration.addRecipeClickArea(GemPolisherScreen.class, 80, 33, 20, 30,
                GemPolishingCategory.GEM_POLISHER_RECIPE_TYPE);

        registration.addRecipeClickArea(SuperAlloyFurnaceScreen.class, 59, 19, 13, 11,
                SuperAlloyingCategory.SUPER_ALLOYING_RECIPE_TYPE);

        registration.addRecipeClickArea(PrimalGrinderScreen.class, 86, 41, 13, 6,
                PrimalGrindCategory.PRIMAL_GRINDING_RECIPE_RECIPE_TYPE);

        registration.addRecipeClickArea(MechanicalGrinderScreen.class, 82, 24, 20, 30,
                MechanicalGrindCategory.GRINDING_RECIPE_RECIPE_TYPE);
    }
}
