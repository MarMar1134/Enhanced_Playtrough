package net.marmar.enhanced_playthrough.data.recipe;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.block.ModBlocks;
import net.marmar.enhanced_playthrough.data.tag.ModTags;
import net.marmar.enhanced_playthrough.item.ModItems;
import net.marmar.enhanced_playthrough.recipe.modsmelting.MasonrySmeltingRecipe;
import net.marmar.enhanced_playthrough.recipe.ModRecipes;
import net.marmar.enhanced_playthrough.recipe.modsmelting.BasicSmeltingRecipe;
import net.marmar.enhanced_playthrough.recipe.modsmelting.SoulBasicSmeltingRecipe;
import net.marmar.enhanced_playthrough.recipe.recipebuilder.ModSmeltingRecipeBuilder;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;

import java.util.List;
import java.util.function.Consumer;

public class SmeltingRecipeSubProvider extends RecipeProvider {
    //silver
    public static final List<ItemLike> SILVER_SMELTABLES;

    //tin
    public static final List<ItemLike> BASIC_TIN_SMELTABLES;
    public static final List<ItemLike> TIN_SMELTABLES;

    //zinc
    public static final List<ItemLike> BASIC_ZINC_SMELTABLES;
    public static final List<ItemLike> ZINC_SMELTABLES;

    //Cobalt
    public static final List<ItemLike> COBALT_SMELTABLES;

    //copper
    public static final List<ItemLike> BASIC_COPPER_SMELTABLES;
    public static final List<ItemLike> COPPER_SMELTABLES;

    public SmeltingRecipeSubProvider(PackOutput pOutput) {
        super(pOutput);
    }

    public static void addSmeltingRecipes(Consumer<FinishedRecipe> consumer){
        //Basic smelting recipes
        basicSmelting(consumer, Items.BEEF, Items.COOKED_BEEF, "beef");
        soulBasicSmelting(consumer, Items.BEEF, Items.COOKED_BEEF, "beef");

        basicSmelting(consumer, Items.CHICKEN, Items.COOKED_CHICKEN, "chicken");
        soulBasicSmelting(consumer, Items.CHICKEN, Items.COOKED_CHICKEN, "chicken");

        basicSmelting(consumer, Items.PORKCHOP, Items.COOKED_PORKCHOP, "porkchop");
        soulBasicSmelting(consumer, Items.PORKCHOP, Items.COOKED_PORKCHOP, "porkchop");

        basicSmelting(consumer, Items.MUTTON, Items.COOKED_MUTTON, "mutton");
        soulBasicSmelting(consumer, Items.MUTTON, Items.COOKED_MUTTON, "mutton");

        basicSmelting(consumer, Items.SALMON, Items.COOKED_SALMON, "salmon");
        soulBasicSmelting(consumer, Items.SALMON, Items.COOKED_SALMON, "salmon");

        basicSmelting(consumer, Items.COD, Items.COOKED_COD, "cod");
        soulBasicSmelting(consumer, Items.COD, Items.COOKED_COD, "cod");

        basicSmelting(consumer, Items.RABBIT, Items.COOKED_RABBIT, "rabbit");
        soulBasicSmelting(consumer, Items.RABBIT, Items.COOKED_RABBIT, "rabbit");

        basicSmelting(consumer, Items.POTATO, Items.BAKED_POTATO, "potato");
        soulBasicSmelting(consumer, Items.POTATO, Items.BAKED_POTATO, "potato");

        basicSmelting(consumer, Items.CACTUS, Items.GREEN_DYE, "cactus");
        soulBasicSmelting(consumer, Items.CACTUS, Items.GREEN_DYE, "cactus");

        basicSmelting(consumer, Items.CLAY_BALL, Items.BRICK, "clay_ball");
        soulBasicSmelting(consumer, Items.CLAY_BALL, Items.BRICK, "clay_ball");

        //Smelting Recipes
            //food
            smeltingByCampfire(consumer, ModItems.ZAPALLO.get(), RecipeCategory.FOOD, ModItems.COOKED_ZAPALLO.get(), 0.35f, "zapallo");
            smeltingByCampfire(consumer, ModItems.EGGPLANT.get(), RecipeCategory.FOOD, ModItems.COOKED_EGGPLANT.get(), 0.35f, "eggplant");
            smeltingByCampfire(consumer, ModItems.CORN.get(), RecipeCategory.FOOD, ModItems.COOKED_CORN.get(), 0.35f, "corn");

            basicSmelting(consumer, ModItems.ZAPALLO.get(), ModItems.COOKED_ZAPALLO.get(), "zapallo");
            basicSmelting(consumer, ModItems.EGGPLANT.get(), ModItems.COOKED_EGGPLANT.get(), "eggplant");
            basicSmelting(consumer, ModItems.CORN.get(), ModItems.COOKED_CORN.get(), "corn");

            soulBasicSmelting(consumer, ModItems.ZAPALLO.get(), ModItems.COOKED_ZAPALLO.get(), "zapallo");
            soulBasicSmelting(consumer, ModItems.EGGPLANT.get(), ModItems.COOKED_EGGPLANT.get(), "eggplant");
            soulBasicSmelting(consumer, ModItems.CORN.get(), ModItems.COOKED_CORN.get(), "corn");

            oreSmelting(consumer, ModItems.ZAPALLO.get(), RecipeCategory.FOOD, ModItems.COOKED_ZAPALLO.get(), 0.35f, "zapallo");
            oreSmelting(consumer, ModItems.EGGPLANT.get(), RecipeCategory.FOOD, ModItems.COOKED_EGGPLANT.get(), 0.35f, "eggplant");
            oreSmelting(consumer, ModItems.CORN.get(), RecipeCategory.FOOD, ModItems.COOKED_CORN.get(), 0.35f, "corn");

            smoking(consumer, ModItems.ZAPALLO.get(), RecipeCategory.FOOD, ModItems.COOKED_ZAPALLO.get(), 0.35f, "zapallo");
            smoking(consumer, ModItems.EGGPLANT.get(), RecipeCategory.FOOD, ModItems.COOKED_EGGPLANT.get(), 0.35f, "eggplant");
            smoking(consumer, ModItems.CORN.get(), RecipeCategory.FOOD, ModItems.COOKED_CORN.get(), 0.35f, "corn");

            //Gold
            oreBlasting(consumer, ModItems.GOLD_DUST.get(), RecipeCategory.MISC, Items.GOLD_INGOT, 1f, "gold_ingot");

            //Silver
            oreSmelting(consumer, SILVER_SMELTABLES, RecipeCategory.MISC, ModItems.SILVER_INGOT.get(), 0.7f, "silver_ingot");
            oreBlasting(consumer, SILVER_SMELTABLES, RecipeCategory.MISC, ModItems.SILVER_INGOT.get(), 0.7f,  "silver_ingot");

            oreSmelting(consumer, ModTags.Items.SILVER_MANUFACTURABLE, RecipeCategory.MISC, ModItems.SILVER_NUGGET.get(), 0.1f, "silver_nugget");
            oreBlasting(consumer, ModTags.Items.SILVER_MANUFACTURABLE, RecipeCategory.MISC, ModItems.SILVER_NUGGET.get(), 0.1f, "silver_nugget");

            oreBlasting(consumer, ModItems.SILVER_DUST.get(), RecipeCategory.MISC, ModItems.SILVER_INGOT.get(), 1f, "silver_ingot");

            //Bauxite
            oreBlasting(consumer, ModTags.Items.BAUXITE_ORE, RecipeCategory.MISC, ModItems.ALUMINUM_INGOT.get(), 1.2f, "aluminum_ingot");
            oreBlasting(consumer, ModItems.RAW_ALUMINUM.get(), RecipeCategory.MISC, ModItems.ALUMINUM_INGOT.get(), 1.2f, "aluminum_ingot");

            //Zinc
            smeltingByCampfire(consumer, ModItems.RAW_ZINC.get(), RecipeCategory.MISC, ModItems.ZINC_NUGGET.get(), 0.1f, "zinc_nugget");

            basicSmelting(consumer, BASIC_ZINC_SMELTABLES, ModItems.ZINC_INGOT.get(), "zinc_ingot");
            soulBasicSmelting(consumer, BASIC_ZINC_SMELTABLES, ModItems.ZINC_INGOT.get(), "zinc_ingot");

            oreSmelting(consumer, ZINC_SMELTABLES, RecipeCategory.MISC, ModItems.ZINC_INGOT.get(), 0.7f, "zinc_ingot");
            oreBlasting(consumer, ZINC_SMELTABLES, RecipeCategory.MISC, ModItems.ZINC_INGOT.get(), 0.7f, "zinc_ingot");

            oreBlasting(consumer, ModItems.ZINC_DUST.get(), RecipeCategory.MISC, ModItems.ZINC_INGOT.get(), 1f, "zinc_ingot");

            //tin
            smeltingByCampfire(consumer, ModItems.RAW_TIN.get(), RecipeCategory.MISC, ModItems.TIN_NUGGET.get(), 0.1f, "tin_nugget");

            basicSmelting(consumer, BASIC_TIN_SMELTABLES, ModItems.TIN_INGOT.get(), "tin_ingot");
            soulBasicSmelting(consumer, BASIC_TIN_SMELTABLES, ModItems.TIN_INGOT.get(), "tin_ingot");

            oreSmelting(consumer, TIN_SMELTABLES, RecipeCategory.MISC, ModItems.TIN_INGOT.get(), 0.7f, "tin_ingot");
            oreBlasting(consumer, TIN_SMELTABLES, RecipeCategory.MISC, ModItems.TIN_INGOT.get(), 0.7f, "tin_ingot");

            oreBlasting(consumer, ModItems.TIN_DUST.get(), RecipeCategory.MISC, ModItems.TIN_INGOT.get(), 1f, "tin_ingot");

            //Cobalt
            oreSmelting(consumer, COBALT_SMELTABLES, RecipeCategory.MISC, ModItems.COBALT.get(), 1f, "cobalt");
            oreBlasting(consumer, COBALT_SMELTABLES, RecipeCategory.MISC, ModItems.COBALT.get(), 1f, "cobalt");

            //copper
            smeltingByCampfire(consumer, Items.RAW_COPPER, RecipeCategory.MISC, ModItems.COPPER_NUGGET.get(), 0.1f, "copper_nugget");

            basicSmelting(consumer, BASIC_COPPER_SMELTABLES, Items.COPPER_INGOT, "copper_ingot");
            soulBasicSmelting(consumer, BASIC_COPPER_SMELTABLES, Items.COPPER_INGOT, "copper_ingot");

            oreSmelting(consumer, COPPER_SMELTABLES, RecipeCategory.MISC, Items.COPPER_INGOT, 0.7f, "copper_ingot");
            oreBlasting(consumer, COPPER_SMELTABLES, RecipeCategory.MISC, Items.COPPER_INGOT, 0.7f, "copper_ingot");

            oreBlasting(consumer, ModItems.COPPER_DUST.get(), RecipeCategory.MISC, Items.COPPER_INGOT, 1f, "copper_ingot");

            //brass
            oreSmelting(consumer, ModTags.Items.BRASS_MANUFACTURABLE, RecipeCategory.MISC, ModItems.BRASS_NUGGET.get(), 0.1f, "brass_nugget");
            oreBlasting(consumer, ModTags.Items.BRASS_MANUFACTURABLE, RecipeCategory.MISC, ModItems.BRASS_NUGGET.get(), 0.1f, "brass_nugget");

            oreBlasting(consumer, ModItems.BRASS_DUST.get(), RecipeCategory.MISC, ModItems.BRASS_INGOT.get(), 1f, "brass_ingot");

            //bronze
            oreSmelting(consumer, ModTags.Items.BRONZE_MANUFACTURABLE, RecipeCategory.MISC, ModItems.BRONZE_NUGGET.get(), 0.1f, "bronze_nugget");
            oreBlasting(consumer, ModTags.Items.BRONZE_MANUFACTURABLE, RecipeCategory.MISC, ModItems.BRONZE_NUGGET.get(), 0.1f, "bronze_nugget");

            oreBlasting(consumer, ModItems.BRONZE_DUST.get(), RecipeCategory.MISC, ModItems.BRONZE_INGOT.get(), 1f, "bronze_ingot");

            //rose gold
            oreSmelting(consumer, ModTags.Items.ROSE_GOLD_MANUFACTURABLE, RecipeCategory.MISC, ModItems.ROSE_GOLD_NUGGET.get(), 0.1f, "rose_gold_nugget");
            oreBlasting(consumer, ModTags.Items.ROSE_GOLD_MANUFACTURABLE, RecipeCategory.MISC, ModItems.ROSE_GOLD_NUGGET.get(), 0.1f, "rose_gold_nugget");

            oreBlasting(consumer, ModItems.ROSE_GOLD_DUST.get(), RecipeCategory.MISC, ModItems.ROSE_GOLD_INGOT.get(), 1f, "rose_gold_ingot");

            //Iron
            oreBlasting(consumer, ModItems.IRON_DUST.get(), RecipeCategory.MISC, Items.IRON_INGOT, 1f, "iron_ingot");

            //Bronzium
            oreBlasting(consumer, ModTags.Items.BRONZIUM_MANUFACTURABLE, RecipeCategory.MISC, ModItems.BRONZIUM_NUGGET.get(), 0.1f, "bronzium_nugget");

            oreBlasting(consumer, ModItems.BRONZIUM_DUST.get(), RecipeCategory.MISC, ModItems.BRONZIUM_INGOT.get(), 1f, "bronzium_ingot");

            //Green gold
            oreSmelting(consumer, ModTags.Items.GREEN_GOLD_MANUFACTURABLE, RecipeCategory.MISC, ModItems.GREEN_GOLD_NUGGET.get(), 0.1f, "green_gold_nugget");
            oreBlasting(consumer, ModTags.Items.GREEN_GOLD_MANUFACTURABLE, RecipeCategory.MISC, ModItems.GREEN_GOLD_NUGGET.get(), 0.1f, "green_gold_nugget");

            oreBlasting(consumer, ModItems.GREEN_GOLD_DUST.get(), RecipeCategory.MISC, ModItems.GREEN_GOLD_INGOT.get(), 1f, "green_gold_ingot");

            //Steel
            oreBlasting(consumer, ModItems.STEEL_DUST.get(), RecipeCategory.MISC, ModItems.STEEL_INGOT.get(), 1f, "steel_ingot");

            //Blue gold
            oreSmelting(consumer, ModTags.Items.BLUE_GOLD_MANUFACTURABLE, RecipeCategory.MISC, ModItems.BLUE_GOLD_NUGGET.get(), 0.1f, "blue_gold_nugget");
            oreBlasting(consumer, ModTags.Items.BLUE_GOLD_MANUFACTURABLE, RecipeCategory.MISC, ModItems.BLUE_GOLD_NUGGET.get(), 0.1f, "blue_gold_nugget");

            oreBlasting(consumer, ModItems.BLUE_GOLD_DUST.get(), RecipeCategory.MISC, ModItems.BLUE_GOLD_INGOT.get(), 1f, "blue_gold_ingot");

            //limestone
            oreSmelting(consumer, ModBlocks.COBBLED_LIMESTONE.get(), RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIMESTONE.get(), 0.1f, "limestone");

        //Masonry smelting recipes
        masonrySmelting(consumer, Blocks.COBBLESTONE, Blocks.STONE, "stone");
        masonrySmelting(consumer, Blocks.STONE, Blocks.SMOOTH_STONE, "smooth_stone");

        masonrySmelting(consumer, Blocks.STONE_BRICKS, Blocks.CRACKED_STONE_BRICKS, "cracked_stone_bricks");

        masonrySmelting(consumer, ModBlocks.COBBLED_LIMESTONE.get(), ModBlocks.LIMESTONE.get(), "limestone");

        masonrySmelting(consumer, Blocks.COBBLED_DEEPSLATE, Blocks.DEEPSLATE, "deepslate");

        masonrySmelting(consumer, Blocks.DEEPSLATE_BRICKS, Blocks.CRACKED_DEEPSLATE_BRICKS, "cracked_deepslate_bricks");

        masonrySmelting(consumer, Blocks.DEEPSLATE_TILES, Blocks.CRACKED_DEEPSLATE_TILES, "cracked_deepslate_tiles");

        masonrySmelting(consumer, Blocks.SAND, Blocks.GLASS, "glass");
        masonrySmelting(consumer, Blocks.RED_SAND, Blocks.GLASS, "glass");

        masonrySmelting(consumer, Blocks.SANDSTONE, Blocks.SMOOTH_SANDSTONE, "smooth_sandstone");
        masonrySmelting(consumer, Blocks.RED_SANDSTONE, Blocks.SMOOTH_RED_SANDSTONE, "smooth_red_sandstone");

        masonrySmelting(consumer, Items.CLAY_BALL, Items.BRICK, "brick");
        masonrySmelting(consumer, Blocks.CLAY, Blocks.TERRACOTTA, "terracotta");

        addTerracottaRecipes(consumer);

        masonrySmelting(consumer, Blocks.NETHERRACK, Items.NETHER_BRICK, "nether_brick");
        masonrySmelting(consumer, Blocks.NETHER_BRICKS, Blocks.CRACKED_NETHER_BRICKS, "cracked_nether_bricks");

        masonrySmelting(consumer, Blocks.BASALT, Blocks.SMOOTH_BASALT, "smooth_basalt");

        masonrySmelting(consumer, Blocks.POLISHED_BLACKSTONE_BRICKS, Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS, "cracked_polished_blackstone_bricks");

        masonrySmelting(consumer, Blocks.QUARTZ_BLOCK, Blocks.SMOOTH_QUARTZ, "smooth_quartz");
    }

    private static void addTerracottaRecipes(Consumer<FinishedRecipe> pConsumer){
        masonrySmelting(pConsumer, Blocks.WHITE_TERRACOTTA, Blocks.WHITE_GLAZED_TERRACOTTA, "white_glazed_terracotta");
        masonrySmelting(pConsumer, Blocks.BLACK_TERRACOTTA, Blocks.BLACK_GLAZED_TERRACOTTA, "black_glazed_terracotta");
        masonrySmelting(pConsumer, Blocks.YELLOW_TERRACOTTA, Blocks.YELLOW_GLAZED_TERRACOTTA, "yellow_glazed_terracotta");
        masonrySmelting(pConsumer, Blocks.RED_TERRACOTTA, Blocks.RED_GLAZED_TERRACOTTA, "red_glazed_terracotta");
        masonrySmelting(pConsumer, Blocks.BLUE_TERRACOTTA, Blocks.BLUE_GLAZED_TERRACOTTA, "blue_glazed_terracotta");
        masonrySmelting(pConsumer, Blocks.GREEN_TERRACOTTA, Blocks.GREEN_GLAZED_TERRACOTTA, "green_glazed_terracotta");
        masonrySmelting(pConsumer, Blocks.BROWN_TERRACOTTA, Blocks.BROWN_GLAZED_TERRACOTTA, "brown_glazed_terracotta");
        masonrySmelting(pConsumer, Blocks.PURPLE_TERRACOTTA, Blocks.PURPLE_GLAZED_TERRACOTTA, "purple_glazed_terracotta");
        masonrySmelting(pConsumer, Blocks.PINK_TERRACOTTA, Blocks.PINK_GLAZED_TERRACOTTA, "pink_glazed_terracotta");
        masonrySmelting(pConsumer, Blocks.MAGENTA_TERRACOTTA, Blocks.MAGENTA_GLAZED_TERRACOTTA, "magenta_glazed_terracotta");
        masonrySmelting(pConsumer, Blocks.CYAN_TERRACOTTA, Blocks.CYAN_GLAZED_TERRACOTTA, "cyan_glazed_terracotta");
        masonrySmelting(pConsumer, Blocks.LIGHT_BLUE_TERRACOTTA, Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA, "light_blue_glazed_terracotta");
        masonrySmelting(pConsumer, Blocks.GRAY_TERRACOTTA, Blocks.GRAY_GLAZED_TERRACOTTA, "gray_glazed_terracotta");
        masonrySmelting(pConsumer, Blocks.LIGHT_GRAY_TERRACOTTA, Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA, "light_gray_glazed_terracotta");
        masonrySmelting(pConsumer, Blocks.ORANGE_TERRACOTTA, Blocks.ORANGE_GLAZED_TERRACOTTA, "orange_glazed_terracotta");
        masonrySmelting(pConsumer, Blocks.LIME_TERRACOTTA, Blocks.LIME_GLAZED_TERRACOTTA, "lime_glazed_terracotta");
    }

    //Vanilla
    protected static void smeltingByCampfire(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike pIngredient, RecipeCategory pCategory, ItemLike pResult, float pExperience, String pGroup){
        oreCookingSerializer(pFinishedRecipeConsumer, RecipeSerializer.CAMPFIRE_COOKING_RECIPE, pIngredient, pCategory, pResult, pExperience, 600, pGroup, "_from_campfire");
    }
    protected static void smeltingByCampfire(Consumer<FinishedRecipe> pFinishedRecipeConsumer, TagKey<Item> pIngredient, RecipeCategory pCategory, ItemLike pResult, float pExperience, String pGroup){
        oreCookingSerializerWithTag(pFinishedRecipeConsumer, RecipeSerializer.CAMPFIRE_COOKING_RECIPE, pIngredient, pCategory, pResult, pExperience, 600, pGroup, "_from_campfire");
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike pIngredient, RecipeCategory pCategory, ItemLike pResult, float pExperience, String pGroup){
        oreCookingSerializer(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredient, pCategory, pResult, pExperience, 200, pGroup, "_from_smelting");
    }
    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, TagKey<Item> pIngredient, RecipeCategory pCategory, ItemLike pResult, float pExperience, String pGroup){
        oreCookingSerializerWithTag(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredient, pCategory, pResult, pExperience, 200, pGroup, "_from_smelting");
    }
    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, String pGroup) {
        oreCookingSerializerWithList(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, 200, pGroup, "_from_smelting");
    }

    protected static void smoking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike pIngredient, RecipeCategory pCategory, ItemLike pResult, float pExperience, String pGroup){
        oreCookingSerializer(pFinishedRecipeConsumer, RecipeSerializer.SMOKING_RECIPE, pIngredient, pCategory, pResult, pExperience, 100, pGroup, "_from_smoking");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike pIngredient, RecipeCategory pCategory, ItemLike pResult, float pExperience, String pGroup){
        oreCookingSerializer(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredient, pCategory, pResult, pExperience, 100, pGroup, "_from_blasting");
    }
    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, TagKey<Item> pIngredient, RecipeCategory pCategory, ItemLike pResult, float pExperience, String pGroup){
        oreCookingSerializerWithTag(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredient, pCategory, pResult, pExperience, 100, pGroup, "_from_blasting");
    }
    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, String pGroup) {
        oreCookingSerializerWithList(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, 100, pGroup, "_from_blasting");
    }

    //Basic smelt
    protected static void basicSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike ingredient, ItemLike result, String group){
        basicSmeltingSerializer(pFinishedRecipeConsumer, ingredient, result, group, ModRecipes.BASIC_SMELTING_SERIALIZER.get(), "from_basic_smelting");
    }
    protected static void basicSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> ingredients, ItemLike result, String group){
        basicSmeltingSerializerWithList(pFinishedRecipeConsumer, ingredients, result, group, ModRecipes.BASIC_SMELTING_SERIALIZER.get(), "from_basic_smelting");
    }
    protected static void soulBasicSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike ingredient, ItemLike result, String group){
        soulBasicSmeltingSerializer(pFinishedRecipeConsumer, ingredient, result, group, ModRecipes.SOUL_BASIC_SMELTING_SERIALIZER.get(), "from_soul_basic_smelting");
    }
    protected static void soulBasicSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> ingredients, ItemLike result, String group){
        soulBasicSmeltingSerializerWithList(pFinishedRecipeConsumer, ingredients, result, group, ModRecipes.SOUL_BASIC_SMELTING_SERIALIZER.get(), "from_soul_basic_smelting");
    }

    //Masonry smelt
    protected static void masonrySmelting(Consumer<FinishedRecipe> pConsumer, ItemLike input, ItemLike result, String group){
        masonrySmeltingSerializer(pConsumer, input, result, group, ModRecipes.MASONRY_SMELTING_SERIALIZER.get(), "from_masonry_smelting");
    }

    protected static void oreCookingSerializer(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, ItemLike pIngredient, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName){
        SimpleCookingRecipeBuilder.generic(Ingredient.of(pIngredient), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer)
                .group(pGroup)
                .unlockedBy(getHasName(pIngredient), has(pIngredient))
                .save(pFinishedRecipeConsumer, EnhancedPlaythrough.MOD_ID + ":" + getItemName(pResult) + "_" + pRecipeName + "_" + getItemName(pIngredient));
    }

    protected static void oreCookingSerializerWithTag(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, TagKey<Item> pIngredient, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName){
        SimpleCookingRecipeBuilder.generic(Ingredient.of(pIngredient), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer)
                .group(pGroup)
                .unlockedBy(pIngredient.toString(), has(pIngredient))
                .save(pFinishedRecipeConsumer, EnhancedPlaythrough.MOD_ID + ":" + getItemName(pResult) + "_" + pRecipeName);
    }

    protected static void oreCookingSerializerWithList(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for (ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup)
                    .unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, EnhancedPlaythrough.MOD_ID + ":" + getItemName(pResult) + "_" + pRecipeName + "_" + getItemName(itemlike));
        }
    }

    protected static void basicSmeltingSerializer(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike input, ItemLike output, String group, RecipeSerializer<BasicSmeltingRecipe> recipeSerializer, String recipeName){
        ModSmeltingRecipeBuilder.basicSmelting(Ingredient.of(input), output, group, recipeSerializer)
                .group(group)
                .unlockedBy(getHasName(input), has(input))
                .save(pFinishedRecipeConsumer, EnhancedPlaythrough.MOD_ID + ":" + getItemName(output) +  "_" + recipeName + "_" + getItemName(input));
    }

    protected static void basicSmeltingSerializerWithList(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> inputs, ItemLike output, String group, RecipeSerializer<BasicSmeltingRecipe> recipeSerializer, String recipeName){
        for (ItemLike itemlike : inputs) {
            ModSmeltingRecipeBuilder.basicSmelting(Ingredient.of(itemlike), output, group, recipeSerializer)
                    .group(group)
                    .unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, EnhancedPlaythrough.MOD_ID + ":" + getItemName(output) + "_" + recipeName + "_" + getItemName(itemlike));
        }
    }

    protected static void soulBasicSmeltingSerializer(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike input, ItemLike output, String group, RecipeSerializer<SoulBasicSmeltingRecipe> recipeSerializer, String recipeName){
        ModSmeltingRecipeBuilder.soulBasicSmelting(Ingredient.of(input), output, group, recipeSerializer)
                .group(group)
                .unlockedBy(getHasName(input), has(input))
                .save(pFinishedRecipeConsumer, EnhancedPlaythrough.MOD_ID + ":" + getItemName(output) +  "_" + recipeName + "_" + getItemName(input));
    }

    protected static void soulBasicSmeltingSerializerWithList(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> inputs, ItemLike output, String group, RecipeSerializer<SoulBasicSmeltingRecipe> recipeSerializer, String recipeName){
        for (ItemLike itemlike : inputs) {
            ModSmeltingRecipeBuilder.soulBasicSmelting(Ingredient.of(itemlike), output, group, recipeSerializer)
                    .group(group)
                    .unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, EnhancedPlaythrough.MOD_ID + ":" + getItemName(output) + "_" + recipeName + "_" + getItemName(itemlike));
        }
    }

    protected static void masonrySmeltingSerializer(Consumer<FinishedRecipe> pConsumer, ItemLike input, ItemLike output, String group, RecipeSerializer<MasonrySmeltingRecipe> pSerializer, String pRecipeName){
        ModSmeltingRecipeBuilder.masonrySmelting(Ingredient.of(input), output, group, pSerializer)
                .group(group)
                .unlockedBy(getHasName(input), has(input))
                .save(pConsumer, EnhancedPlaythrough.MOD_ID + ":" + getItemName(output) + "_" + pRecipeName + "_" + getItemName(input));
    }

    protected static void masonrySmeltingSerializerWithTag(Consumer<FinishedRecipe> pConsumer, TagKey<Item> input, ItemLike output, String group, RecipeSerializer<MasonrySmeltingRecipe> pSerializer, String pRecipeName){
        ModSmeltingRecipeBuilder.masonrySmelting(Ingredient.of(input), output, group, pSerializer)
                .group(group)
                .unlockedBy(input.toString(), has(input))
                .save(pConsumer, EnhancedPlaythrough.MOD_ID + ":" + getItemName(output) + pRecipeName + "_" + input);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
    }

    static {
        //Silver
        SILVER_SMELTABLES = List.of(ModItems.RAW_SILVER.get(), ModBlocks.SILVER_ORE.get(), ModBlocks.DEEPSLATE_SILVER_ORE.get());

        //Zinc
        BASIC_ZINC_SMELTABLES = List.of(ModItems.RAW_ZINC.get(), ModBlocks.ZINC_ORE.get(), ModBlocks.NETHER_ZINC_ORE.get());
        ZINC_SMELTABLES = List.of(ModItems.RAW_ZINC.get(), ModBlocks.ZINC_ORE.get(), ModBlocks.NETHER_ZINC_ORE.get(), ModBlocks.DEEPSLATE_ZINC_ORE.get());

        //Tin
        BASIC_TIN_SMELTABLES = List.of(ModItems.RAW_TIN.get(), ModBlocks.TIN_ORE.get());
        TIN_SMELTABLES = List.of(ModItems.RAW_TIN.get(), ModBlocks.TIN_ORE.get(), ModBlocks.DEEPSLATE_TIN_ORE.get());

        //Cobalt
        COBALT_SMELTABLES = List.of(ModBlocks.COBALT_ORE.get(), ModBlocks.DEEPSLATE_COBALT_ORE.get());

        //Copper
        BASIC_COPPER_SMELTABLES = List.of(Items.RAW_COPPER, Blocks.COPPER_ORE);
        COPPER_SMELTABLES = List.of(Items.RAW_COPPER, Blocks.COPPER_ORE, Blocks.DEEPSLATE_COPPER_ORE, ModBlocks.NETHER_COPPER_ORE.get());
    }
}
