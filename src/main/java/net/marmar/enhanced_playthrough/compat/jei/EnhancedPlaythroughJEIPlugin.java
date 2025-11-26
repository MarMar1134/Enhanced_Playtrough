package net.marmar.enhanced_playthrough.compat.jei;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.menu.screen.alloyfurnace.AdobeAlloyFurnaceScreen;
import net.marmar.enhanced_playthrough.menu.screen.alloyfurnace.SuperAlloyFurnaceScreen;
import net.marmar.enhanced_playthrough.menu.screen.modfurnace.AdobeFurnaceScreen;
import net.marmar.enhanced_playthrough.menu.screen.modfurnace.SoulFurnaceScreen;
import net.marmar.enhanced_playthrough.menu.screen.gempolisher.GemPolisherScreen;
import net.marmar.enhanced_playthrough.menu.screen.grinder.MechanicalGrinderScreen;
import net.marmar.enhanced_playthrough.menu.screen.grinder.PrimalGrinderScreen;
import net.marmar.enhanced_playthrough.menu.screen.modfurnace.MasonryFurnaceScreen;
import net.marmar.enhanced_playthrough.recipe.GemPolishingRecipe;
import net.marmar.enhanced_playthrough.recipe.epsmelting.MasonrySmeltingRecipe;
import net.marmar.enhanced_playthrough.recipe.grind.MechanicalGrindRecipe;
import net.marmar.enhanced_playthrough.recipe.EPRecipes;
import net.marmar.enhanced_playthrough.recipe.alloy.AlloyRecipe;
import net.marmar.enhanced_playthrough.recipe.alloy.BlastAlloyRecipe;
import net.marmar.enhanced_playthrough.recipe.epsmelting.BasicSmeltingRecipe;
import net.marmar.enhanced_playthrough.recipe.epsmelting.SoulBasicSmeltingRecipe;
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
@SuppressWarnings("removal")
public class EnhancedPlaythroughJEIPlugin implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(EnhancedPlaythrough.MOD_ID,"jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        //Basic smelt recipes
        registration.addRecipeCategories(new BasicSmeltingCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new SoulBasicSmeltingCategory(registration.getJeiHelpers().getGuiHelper()));

        //Masonry furnace
        registration.addRecipeCategories(new MasonrySmeltingCategory(registration.getJeiHelpers().getGuiHelper()));

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

        //Basic smelting
        List<BasicSmeltingRecipe> basicSmeltingRecipes = recipeManager.getAllRecipesFor(EPRecipes.BASIC_SMELT_TYPE.get());
        registration.addRecipes(BasicSmeltingCategory.BASIC_SMELTING_TYPE, basicSmeltingRecipes);

        List<SoulBasicSmeltingRecipe> soulBasicSmeltingRecipes = recipeManager.getAllRecipesFor(EPRecipes.SOUL_BASIC_SMELT_TYPE.get());
        registration.addRecipes(SoulBasicSmeltingCategory.SOUL_BASIC_SMELTING_TYPE, soulBasicSmeltingRecipes);

        //Masonry smelting
        List<MasonrySmeltingRecipe> masonrySmeltingRecipes = recipeManager.getAllRecipesFor(EPRecipes.MASONRY_SMELT_TYPE.get());
        registration.addRecipes(MasonrySmeltingCategory.MASONRY_SMELTING_TYPE, masonrySmeltingRecipes);

        //Alloying
        List<AlloyRecipe> alloyingRecipes = recipeManager.getAllRecipesFor(EPRecipes.ALLOY_TYPE.get());
        registration.addRecipes(OreAlloyingCategory.ALLOYING_FURNACE_RECIPE_RECIPE_TYPE, alloyingRecipes);

        List<BlastAlloyRecipe> blastAlloyRecipes = recipeManager.getAllRecipesFor(EPRecipes.SUPER_ALLOY_TYPE.get());
        registration.addRecipes(SuperAlloyingCategory.SUPER_ALLOYING_RECIPE_TYPE, blastAlloyRecipes);

        //Gem polishing
        List<GemPolishingRecipe> gemPolishingRecipes = recipeManager.getAllRecipesFor(EPRecipes.POLISHING_TYPE.get());
        registration.addRecipes(GemPolishingCategory.GEM_POLISHER_RECIPE_TYPE, gemPolishingRecipes);

        //Grinding
        List<PrimalGrindRecipe> primalGrindRecipes = recipeManager.getAllRecipesFor(EPRecipes.PRIMAL_GRIND_TYPE.get());
        registration.addRecipes(PrimalGrindCategory.PRIMAL_GRINDING_RECIPE_RECIPE_TYPE, primalGrindRecipes);

        List<MechanicalGrindRecipe> mechanicalGrindRecipes = recipeManager.getAllRecipesFor(EPRecipes.MECHANICAL_GRIND_TYPE.get());
        registration.addRecipes(MechanicalGrindCategory.GRINDING_RECIPE_RECIPE_TYPE, mechanicalGrindRecipes);
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        //Basic smelting
        registration.addRecipeClickArea(AdobeFurnaceScreen.class, 80, 38, 14, 9,
                BasicSmeltingCategory.BASIC_SMELTING_TYPE);

        registration.addRecipeClickArea(SoulFurnaceScreen.class, 80, 38, 14, 9,
                SoulBasicSmeltingCategory.SOUL_BASIC_SMELTING_TYPE);

        //Masonry smelting
        registration.addRecipeClickArea(MasonryFurnaceScreen.class, 80, 38, 14, 9,
                MasonrySmeltingCategory.MASONRY_SMELTING_TYPE);

        //Alloying
        registration.addRecipeClickArea(AdobeAlloyFurnaceScreen.class, 59, 19, 13, 11,
                OreAlloyingCategory.ALLOYING_FURNACE_RECIPE_RECIPE_TYPE);

        registration.addRecipeClickArea(SuperAlloyFurnaceScreen.class, 59, 19, 13, 11,
                SuperAlloyingCategory.SUPER_ALLOYING_RECIPE_TYPE);

        //Gem polishing
        registration.addRecipeClickArea(GemPolisherScreen.class, 80, 33, 20, 30,
                GemPolishingCategory.GEM_POLISHER_RECIPE_TYPE);

        //Grinding
        registration.addRecipeClickArea(PrimalGrinderScreen.class, 86, 41, 13, 6,
                PrimalGrindCategory.PRIMAL_GRINDING_RECIPE_RECIPE_TYPE);

        registration.addRecipeClickArea(MechanicalGrinderScreen.class, 82, 24, 20, 30,
                MechanicalGrindCategory.GRINDING_RECIPE_RECIPE_TYPE);
    }
}
