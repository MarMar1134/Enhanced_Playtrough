package net.marmar.enhanced_playthrough.compat.jei;

import mezz.jei.api.registration.*;
import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.block.EPBlocks;
import net.marmar.enhanced_playthrough.compat.jei.category.*;
import net.marmar.enhanced_playthrough.compat.jei.itemtransfer.*;
import net.marmar.enhanced_playthrough.item.EPItems;
import net.marmar.enhanced_playthrough.menu.screen.alchemicalduplicator.AlchemicalDuplicatorScreen;
import net.marmar.enhanced_playthrough.menu.screen.alloyfurnace.AdobeAlloyFurnaceScreen;
import net.marmar.enhanced_playthrough.menu.screen.alloyfurnace.SuperAlloyFurnaceScreen;
import net.marmar.enhanced_playthrough.menu.screen.modfurnace.AdobeFurnaceScreen;
import net.marmar.enhanced_playthrough.menu.screen.modfurnace.SoulFurnaceScreen;
import net.marmar.enhanced_playthrough.menu.screen.gempolisher.GemPolisherScreen;
import net.marmar.enhanced_playthrough.menu.screen.grinder.MechanicalGrinderScreen;
import net.marmar.enhanced_playthrough.menu.screen.grinder.PrimalGrinderScreen;
import net.marmar.enhanced_playthrough.menu.screen.modfurnace.MasonryFurnaceScreen;
import net.marmar.enhanced_playthrough.recipe.AlchemicalDuplicationRecipe;
import net.marmar.enhanced_playthrough.recipe.GemPolishingRecipe;
import net.marmar.enhanced_playthrough.recipe.epsmelt.MasonrySmeltingRecipe;
import net.marmar.enhanced_playthrough.recipe.grind.MechanicalGrindRecipe;
import net.marmar.enhanced_playthrough.recipe.EPRecipes;
import net.marmar.enhanced_playthrough.recipe.alloy.AlloyRecipe;
import net.marmar.enhanced_playthrough.recipe.alloy.BlastAlloyRecipe;
import net.marmar.enhanced_playthrough.recipe.epsmelt.BasicSmeltingRecipe;
import net.marmar.enhanced_playthrough.recipe.epsmelt.SoulBasicSmeltingRecipe;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import net.marmar.enhanced_playthrough.recipe.grind.PrimalGrindRecipe;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;

@JeiPlugin
@SuppressWarnings("removal")
public class EnhancedPlaythroughJEIPlugin implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(EnhancedPlaythrough.MOD_ID,"jei_plugin");
    }

    private void addIngredientsInfo(IRecipeRegistration registration){
        List<ItemStack> reeds = List.of(
                new ItemStack(EPItems.REEDS_HEAD.get()),
                new ItemStack(EPItems.TALL_REEDS_HEAD.get()),
                new ItemStack(EPItems.WATER_REEDS_HEAD.get()),
                new ItemStack(EPItems.KENAF_BRANCH.get())
        );

        List<ItemStack> dusts = List.of(
                new ItemStack(EPItems.TIN_DUST.get()),
                new ItemStack(EPItems.ZINC_DUST.get()),
                new ItemStack(EPItems.COPPER_DUST.get()),
                new ItemStack(EPItems.BRASS_DUST.get()),
                new ItemStack(EPItems.BRONZE_DUST.get()),
                new ItemStack(EPItems.BRONZIUM_DUST.get()),
                new ItemStack(EPItems.IRON_DUST.get()),
                new ItemStack(EPItems.SILVER_DUST.get()),
                new ItemStack(EPItems.GOLD_DUST.get()),
                new ItemStack(EPItems.STEEL_DUST.get()),
                new ItemStack(EPItems.ROSE_GOLD_DUST.get()),
                new ItemStack(EPItems.GREEN_GOLD_DUST.get()),
                new ItemStack(EPItems.BLUE_GOLD_DUST.get()),
                new ItemStack(EPItems.ALUMINUM_DUST.get())
        );

        //Nature objects
        registration.addIngredientInfo(EPItems.PLANT_FIBER.get(),
                Component.translatable("jei." + EnhancedPlaythrough.MOD_ID + ".plant_fiber.desc"));
        registration.addItemStackInfo(reeds, Component.translatable("jei." + EnhancedPlaythrough.MOD_ID + ".reeds_head.desc"));

        //Upgrade templates
        registration.addIngredientInfo(EPItems.BRONZIUM_UPGRADE_SMITHING_TEMPLATE.get(),
                Component.translatable("jei." + EnhancedPlaythrough.MOD_ID + ".bronzium_upgrade.desc"));
        registration.addIngredientInfo(EPItems.ALUMINUM_UPGRADE_SMITHING_TEMPLATE.get(),
                Component.translatable("jei." + EnhancedPlaythrough.MOD_ID + ".aluminum_upgrade.desc"));
        registration.addIngredientInfo(EPItems.GOLDEN_UPGRADE_SMITHING_TEMPLATE.get(),
                Component.translatable("jei." + EnhancedPlaythrough.MOD_ID + ".golden_upgrade.desc"));

        //Dusts
        registration.addItemStackInfo(dusts, Component.translatable("jei." + EnhancedPlaythrough.MOD_ID + ".dusts.desc"));

        //Others
        registration.addIngredientInfo(EPItems.CALIBRATED_QUARTZ.get(),
                Component.translatable("jei." + EnhancedPlaythrough.MOD_ID + ".calibrated_quartz.desc"));
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        //Basic furnaces
        registration.addRecipeCatalyst(new ItemStack(EPBlocks.ADOBE_FURNACE.get()), BasicSmeltingCategory.BASIC_SMELTING_TYPE);
        registration.addRecipeCatalyst(new ItemStack(EPBlocks.SOUL_FURNACE.get()), SoulBasicSmeltingCategory.SOUL_BASIC_SMELTING_TYPE);

        //Masonry furnace
        registration.addRecipeCatalyst(new ItemStack(EPBlocks.MASONRY_FURNACE.get()), MasonrySmeltingCategory.MASONRY_SMELTING_TYPE);

        //Alloy furnaces
        registration.addRecipeCatalyst(new ItemStack(EPBlocks.ADOBE_ALLOY_FURNACE.get()), OreAlloyingCategory.ALLOYING_FURNACE_RECIPE_RECIPE_TYPE);
        registration.addRecipeCatalyst(new ItemStack(EPBlocks.SUPER_ALLOY_FURNACE.get()), SuperAlloyingCategory.SUPER_ALLOYING_RECIPE_TYPE);

        //Gem polishing
        registration.addRecipeCatalyst(new ItemStack(EPBlocks.GEM_POLISHER.get()), GemPolishingCategory.GEM_POLISHER_RECIPE_TYPE);

        //Item grinding
        registration.addRecipeCatalyst(new ItemStack(EPBlocks.PRIMAL_GRINDER.get()), PrimalGrindCategory.PRIMAL_GRINDING_RECIPE_RECIPE_TYPE);
        registration.addRecipeCatalyst(new ItemStack(EPBlocks.MECHANICAL_GRINDER.get()), MechanicalGrindCategory.GRINDING_RECIPE_RECIPE_TYPE);

        //Alchemical duplication
        registration.addRecipeCatalyst(new ItemStack(EPBlocks.ALCHEMICAL_DUPLICATOR.get()), AlchemicalDuplicatingCategory.ALCHEMICAL_DUPLICATING_RECIPE_RECIPE_TYPE);
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

        //Alchemical duplication
        registration.addRecipeCategories(new AlchemicalDuplicatingCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();

        //Ingredients info
        addIngredientsInfo(registration);

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

        //Alchemical duplication
        List<AlchemicalDuplicationRecipe> alchemicalDuplicationRecipes = recipeManager.getAllRecipesFor(EPRecipes.ALCHEMICAL_DUPLICATING_TYPE.get());
        registration.addRecipes(AlchemicalDuplicatingCategory.ALCHEMICAL_DUPLICATING_RECIPE_RECIPE_TYPE, alchemicalDuplicationRecipes);
    }

    @Override
    public void registerRecipeTransferHandlers(IRecipeTransferRegistration registration) {
        //Basic smelting
        registration.addRecipeTransferHandler(new AdobeFurnaceTransferInfo());
        registration.addRecipeTransferHandler(new SoulFurnaceTransferInfo());

        //Masonry smelting
        registration.addRecipeTransferHandler(new MasonryFurnaceTransferInfo());

        //Ore alloying
        registration.addRecipeTransferHandler(new AlloyFurnaceTransferInfo());
        registration.addRecipeTransferHandler(new SuperAlloyFurnaceTransferInfo());

        //Gem polishing
        registration.addRecipeTransferHandler(new GemPolisherTransferInfo());

        //Grinding
        registration.addRecipeTransferHandler(new PrimalGrinderTransferInfo());
        registration.addRecipeTransferHandler(new MechanicalGrinderTransferInfo());
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

        //Ore alloying
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

        //Alchemical duplication
        registration.addRecipeClickArea(AlchemicalDuplicatorScreen.class, 86, 40, 4, 5,
                AlchemicalDuplicatingCategory.ALCHEMICAL_DUPLICATING_RECIPE_RECIPE_TYPE);
    }
}
