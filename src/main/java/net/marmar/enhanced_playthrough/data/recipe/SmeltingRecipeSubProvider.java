package net.marmar.enhanced_playthrough.data.recipe;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.block.EPBlocks;
import net.marmar.enhanced_playthrough.data.tag.EPTags;
import net.marmar.enhanced_playthrough.item.EPItems;
import net.marmar.enhanced_playthrough.recipe.builder.EPSmeltingRecipeBuilder;
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
import net.minecraftforge.common.Tags;

import java.util.function.Consumer;

public class SmeltingRecipeSubProvider extends RecipeProvider {
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
            smeltingByCampfire(consumer, EPItems.ZAPALLO.get(), RecipeCategory.FOOD, EPItems.COOKED_ZAPALLO.get(), 0.35f, "zapallo");
            smeltingByCampfire(consumer, EPItems.EGGPLANT.get(), RecipeCategory.FOOD, EPItems.COOKED_EGGPLANT.get(), 0.35f, "eggplant");
            smeltingByCampfire(consumer, EPItems.CORN.get(), RecipeCategory.FOOD, EPItems.COOKED_CORN.get(), 0.35f, "corn");

            basicSmelting(consumer, EPItems.ZAPALLO.get(), EPItems.COOKED_ZAPALLO.get(), "zapallo");
            basicSmelting(consumer, EPItems.EGGPLANT.get(), EPItems.COOKED_EGGPLANT.get(), "eggplant");
            basicSmelting(consumer, EPItems.CORN.get(), EPItems.COOKED_CORN.get(), "corn");

            soulBasicSmelting(consumer, EPItems.ZAPALLO.get(), EPItems.COOKED_ZAPALLO.get(), "zapallo");
            soulBasicSmelting(consumer, EPItems.EGGPLANT.get(), EPItems.COOKED_EGGPLANT.get(), "eggplant");
            soulBasicSmelting(consumer, EPItems.CORN.get(), EPItems.COOKED_CORN.get(), "corn");

            smeltingByCampfire(consumer, EPItems.RAW_ROTTEN_STEW.get(), RecipeCategory.FOOD, EPItems.ROTTEN_STEW.get(), 0.5f, "rotten_stew");
            oreSmelting(consumer, EPItems.RAW_ROTTEN_STEW.get(), RecipeCategory.FOOD, EPItems.ROTTEN_STEW.get(), 0.5f, "rotten_stew");
            basicSmelting(consumer, EPItems.RAW_ROTTEN_STEW.get(), EPItems.ROTTEN_STEW.get(), "rotten_stew");
            soulBasicSmelting(consumer, EPItems.RAW_ROTTEN_STEW.get(), EPItems.ROTTEN_STEW.get(), "rotten_stew");

            oreSmelting(consumer, EPItems.ZAPALLO.get(), RecipeCategory.FOOD, EPItems.COOKED_ZAPALLO.get(), 0.35f, "zapallo");
            oreSmelting(consumer, EPItems.EGGPLANT.get(), RecipeCategory.FOOD, EPItems.COOKED_EGGPLANT.get(), 0.35f, "eggplant");
            oreSmelting(consumer, EPItems.CORN.get(), RecipeCategory.FOOD, EPItems.COOKED_CORN.get(), 0.35f, "corn");

            smoking(consumer, EPItems.ZAPALLO.get(), EPItems.COOKED_ZAPALLO.get(), "zapallo");
            smoking(consumer, EPItems.EGGPLANT.get(), EPItems.COOKED_EGGPLANT.get(), "eggplant");
            smoking(consumer, EPItems.CORN.get(), EPItems.COOKED_CORN.get(), "corn");

            //Sulfur
            basicSmelting(consumer, EPTags.Items.BASIC_SULFUR_ORES, EPItems.SULFUR.get(), "sulfur");
            soulBasicSmelting(consumer, EPTags.Items.BASIC_SULFUR_ORES, EPItems.SULFUR.get(), "sulfur");
            oreSmelting(consumer, EPTags.Items.SULFUR_ORES, EPItems.SULFUR.get(), 0.5f, "sulfur");
            oreBlasting(consumer, EPTags.Items.SULFUR_ORES, EPItems.SULFUR.get(), 0.5f, "sulfur");

            //Gold
            oreBlasting(consumer, EPItems.GOLD_DUST.get(), Items.GOLD_INGOT, 1f, "gold_ingot");

            //Silver
            oreSmelting(consumer, EPTags.Items.SILVER_ORES, EPItems.SILVER_INGOT.get(), 0.7f, "silver_ingot");
            oreBlasting(consumer, EPTags.Items.SILVER_ORES, EPItems.SILVER_INGOT.get(), 0.7f,  "silver_ingot");

            oreSmelting(consumer, EPTags.Items.SILVER_MANUFACTURABLE, EPItems.SILVER_NUGGET.get(), 0.1f, "silver_nugget");
            oreBlasting(consumer, EPTags.Items.SILVER_MANUFACTURABLE, EPItems.SILVER_NUGGET.get(), 0.1f, "silver_nugget");

            oreBlasting(consumer, EPItems.SILVER_DUST.get(), EPItems.SILVER_INGOT.get(), 0.7f, "silver_ingot");

            //Bauxite
            oreBlasting(consumer, EPTags.Items.BAUXITE_ORES, EPItems.ALUMINUM_INGOT.get(), 1.2f, "aluminum_ingot");
            oreBlasting(consumer, EPItems.RAW_ALUMINUM.get(), EPItems.ALUMINUM_INGOT.get(), 1.2f, "aluminum_ingot");

            //Zinc
            smeltingByCampfire(consumer, EPItems.RAW_ZINC.get(), RecipeCategory.MISC, EPItems.ZINC_NUGGET.get(), 0.1f, "zinc_nugget");

            basicSmelting(consumer, EPTags.Items.BASIC_ZINC_ORES, EPItems.ZINC_INGOT.get(), "zinc_ingot");
            basicSmelting(consumer, EPItems.RAW_ZINC.get(), EPItems.ZINC_INGOT.get(), "zinc_ingot");
            soulBasicSmelting(consumer, EPTags.Items.BASIC_ZINC_ORES, EPItems.ZINC_INGOT.get(), "zinc_ingot");
            soulBasicSmelting(consumer, EPItems.RAW_ZINC.get(), EPItems.ZINC_INGOT.get(), "zinc_ingot");

            oreSmelting(consumer, EPTags.Items.ZINC_ORES, EPItems.ZINC_INGOT.get(), 0.5f, "zinc_ingot");
            oreBlasting(consumer, EPTags.Items.ZINC_ORES, EPItems.ZINC_INGOT.get(), 0.5f, "zinc_ingot");

            oreBlasting(consumer, EPItems.ZINC_DUST.get(), EPItems.ZINC_INGOT.get(), 0.5f, "zinc_ingot");

            //tin
            smeltingByCampfire(consumer, EPItems.RAW_TIN.get(), RecipeCategory.MISC, EPItems.TIN_NUGGET.get(), 0.1f, "tin_nugget");

            basicSmelting(consumer, EPTags.Items.BASIC_TIN_ORES, EPItems.TIN_INGOT.get(), "tin_ingot");
            basicSmelting(consumer, EPItems.RAW_TIN.get(), EPItems.TIN_INGOT.get(), "tin_ingot");
            soulBasicSmelting(consumer, EPTags.Items.BASIC_TIN_ORES, EPItems.TIN_INGOT.get(), "tin_ingot");
            soulBasicSmelting(consumer, EPItems.RAW_TIN.get(), EPItems.TIN_INGOT.get(), "tin_ingot");

            oreSmelting(consumer, EPTags.Items.TIN_ORES, EPItems.TIN_INGOT.get(), 0.5f, "tin_ingot");
            oreBlasting(consumer, EPTags.Items.TIN_ORES, EPItems.TIN_INGOT.get(), 0.5f, "tin_ingot");

            oreBlasting(consumer, EPItems.TIN_DUST.get(), EPItems.TIN_INGOT.get(), 0.5f, "tin_ingot");

            //copper
            smeltingByCampfire(consumer, Items.RAW_COPPER, RecipeCategory.MISC, EPItems.COPPER_NUGGET.get(), 0.1f, "copper_nugget");

            basicSmelting(consumer, EPTags.Items.BASIC_COPPER_ORES, Items.COPPER_INGOT, "copper_ingot");
            basicSmelting(consumer, Items.RAW_COPPER, Items.COPPER_INGOT, "copper_ingot");
            soulBasicSmelting(consumer, EPTags.Items.BASIC_COPPER_ORES, Items.COPPER_INGOT, "copper_ingot");
            soulBasicSmelting(consumer, Items.RAW_COPPER, Items.COPPER_INGOT, "copper_ingot");

            oreSmelting(consumer, Tags.Items.ORES_COPPER, Items.COPPER_INGOT, 0.5f, "copper_ingot");
            oreBlasting(consumer, Tags.Items.ORES_COPPER, Items.COPPER_INGOT, 0.5f, "copper_ingot");

            oreBlasting(consumer, EPItems.COPPER_DUST.get(), Items.COPPER_INGOT, 0.5f, "copper_ingot");

            //brass
            oreSmelting(consumer, EPTags.Items.BRASS_MANUFACTURABLE, EPItems.BRASS_NUGGET.get(), 0.1f, "brass_nugget");
            oreBlasting(consumer, EPTags.Items.BRASS_MANUFACTURABLE, EPItems.BRASS_NUGGET.get(), 0.1f, "brass_nugget");

            oreBlasting(consumer, EPItems.BRASS_DUST.get(), EPItems.BRASS_INGOT.get(), 0.5f, "brass_ingot");

            //bronze
            oreSmelting(consumer, EPTags.Items.BRONZE_MANUFACTURABLE, EPItems.BRONZE_NUGGET.get(), 0.1f, "bronze_nugget");
            oreBlasting(consumer, EPTags.Items.BRONZE_MANUFACTURABLE, EPItems.BRONZE_NUGGET.get(), 0.1f, "bronze_nugget");

            oreBlasting(consumer, EPItems.BRONZE_DUST.get(), EPItems.BRONZE_INGOT.get(), 0.5f, "bronze_ingot");

            //rose gold
            oreSmelting(consumer, EPTags.Items.ROSE_GOLD_MANUFACTURABLE, EPItems.ROSE_GOLD_NUGGET.get(), 0.1f, "rose_gold_nugget");
            oreBlasting(consumer, EPTags.Items.ROSE_GOLD_MANUFACTURABLE, EPItems.ROSE_GOLD_NUGGET.get(), 0.1f, "rose_gold_nugget");

            oreBlasting(consumer, EPItems.ROSE_GOLD_DUST.get(), EPItems.ROSE_GOLD_INGOT.get(), 0.5f, "rose_gold_ingot");

            //Iron
            oreBlasting(consumer, EPItems.IRON_DUST.get(), Items.IRON_INGOT, 1f, "iron_ingot");

            //Bronzium
            oreBlasting(consumer, EPTags.Items.BRONZIUM_MANUFACTURABLE, EPItems.BRONZIUM_NUGGET.get(), 0.1f, "bronzium_nugget");

            oreBlasting(consumer, EPItems.BRONZIUM_DUST.get(), EPItems.BRONZIUM_INGOT.get(), 0.5f, "bronzium_ingot");

            //Green gold
            oreSmelting(consumer, EPTags.Items.GREEN_GOLD_MANUFACTURABLE, EPItems.GREEN_GOLD_NUGGET.get(), 0.1f, "green_gold_nugget");
            oreBlasting(consumer, EPTags.Items.GREEN_GOLD_MANUFACTURABLE, EPItems.GREEN_GOLD_NUGGET.get(), 0.1f, "green_gold_nugget");

            oreBlasting(consumer, EPItems.GREEN_GOLD_DUST.get(), EPItems.GREEN_GOLD_INGOT.get(), 0.5f, "green_gold_ingot");

            //Steel
            oreBlasting(consumer, EPItems.STEEL_DUST.get(), EPItems.STEEL_INGOT.get(), 0.5f, "steel_ingot");

            //Blue gold
            oreSmelting(consumer, EPTags.Items.BLUE_GOLD_MANUFACTURABLE, EPItems.BLUE_GOLD_NUGGET.get(), 0.1f, "blue_gold_nugget");
            oreBlasting(consumer, EPTags.Items.BLUE_GOLD_MANUFACTURABLE, EPItems.BLUE_GOLD_NUGGET.get(), 0.1f, "blue_gold_nugget");

            oreBlasting(consumer, EPItems.BLUE_GOLD_DUST.get(), EPItems.BLUE_GOLD_INGOT.get(), 0.5f, "blue_gold_ingot");

            //Cobalt
            oreSmelting(consumer, EPTags.Items.COBALT_ORES, EPItems.COBALT.get(), 0.6f, "cobalt");
            oreBlasting(consumer, EPTags.Items.COBALT_ORES, EPItems.COBALT.get(), 0.6f, "cobalt");

            //Sapphire
            oreSmelting(consumer, EPTags.Items.SAPPHIRE_ORES, EPItems.SAPPHIRE.get(), 1f, "sapphire");
            oreBlasting(consumer, EPTags.Items.SAPPHIRE_ORES, EPItems.SAPPHIRE.get(), 1f, "sapphire");

            //Ruby
            oreSmelting(consumer, EPTags.Items.RUBY_ORES, EPItems.RUBY.get(), 1f, "ruby");
            oreBlasting(consumer, EPTags.Items.RUBY_ORES, EPItems.RUBY.get(), 1f, "ruby");

            //limestone
            oreSmelting(consumer, EPBlocks.COBBLED_LIMESTONE.get(), RecipeCategory.BUILDING_BLOCKS, EPBlocks.LIMESTONE.get(), 0.1f, "limestone");

        //Masonry smelting recipes
        masonrySmelting(consumer, Blocks.COBBLESTONE, Blocks.STONE, "stone");
        masonrySmelting(consumer, Blocks.STONE, Blocks.SMOOTH_STONE, "smooth_stone");

        masonrySmelting(consumer, Blocks.STONE_BRICKS, Blocks.CRACKED_STONE_BRICKS, "cracked_stone_bricks");

        masonrySmelting(consumer, EPBlocks.COBBLED_LIMESTONE.get(), EPBlocks.LIMESTONE.get(), "limestone");

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

        oreSmelting(consumer, EPBlocks.CALIBRATED_QUARTZ_BLOCK.get(), RecipeCategory.BUILDING_BLOCKS, EPBlocks.SMOOTH_CALIBRATED_QUARTZ_BLOCK.get(),
                0.1f,"smooth_calibrated_quartz_block");
        masonrySmelting(consumer, EPBlocks.CALIBRATED_QUARTZ_BLOCK.get(), EPBlocks.SMOOTH_CALIBRATED_QUARTZ_BLOCK.get(), "smooth_calibrated_quartz_block");
    }

    public static void addTerracottaRecipes(Consumer<FinishedRecipe> pConsumer){
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
        oreCookingSerializer(pFinishedRecipeConsumer, RecipeSerializer.CAMPFIRE_COOKING_RECIPE, pIngredient, pCategory, pResult, pExperience, 600, pGroup, "from_campfire");
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike pIngredient, RecipeCategory pCategory, ItemLike pResult, float pExperience, String pGroup){
        oreCookingSerializer(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredient, pCategory, pResult, pExperience, 200, pGroup, "from_smelting");
    }
    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, TagKey<Item> pIngredient, ItemLike pResult, float pExperience, String pGroup){
        oreCookingSerializerWithTag(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredient, RecipeCategory.MISC, pResult, pExperience, 200, pGroup, "from_smelting");
    }

    protected static void smoking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike pIngredient, ItemLike pResult, String pGroup){
        oreCookingSerializer(pFinishedRecipeConsumer, RecipeSerializer.SMOKING_RECIPE, pIngredient, RecipeCategory.FOOD, pResult, 0.35f, 100, pGroup, "from_smoking");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike pIngredient, ItemLike pResult, float pExperience, String pGroup){
        oreCookingSerializer(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredient, RecipeCategory.MISC, pResult, pExperience, 100, pGroup, "from_blasting");
    }
    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, TagKey<Item> pIngredient, ItemLike pResult, float pExperience, String pGroup){
        oreCookingSerializerWithTag(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredient, RecipeCategory.MISC, pResult, pExperience, 100, pGroup, "from_blasting");
    }

    //Basic smelt
    protected static void basicSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike ingredient, ItemLike result, String group){
        basicSmeltingSerializer(pFinishedRecipeConsumer, ingredient, result, group);
    }
    protected static void basicSmelting(Consumer<FinishedRecipe> pConsumer, TagKey<Item> ingredients, ItemLike result, String group){
        basicSmeltingSerializerWithTag(pConsumer, ingredients, result, group);
    }
    protected static void soulBasicSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike ingredient, ItemLike result, String group){
        soulBasicSmeltingSerializer(pFinishedRecipeConsumer, ingredient, result, group);
    }
    protected static void soulBasicSmelting(Consumer<FinishedRecipe> pConsumer, TagKey<Item> ingredients, ItemLike result, String group){
        soulBasicSmeltingSerializerWithTag(pConsumer, ingredients, result, group);
    }

    //Masonry smelt
    protected static void masonrySmelting(Consumer<FinishedRecipe> pConsumer, ItemLike input, ItemLike result, String group){
        masonrySmeltingSerializer(pConsumer, input, result, group);
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

    protected static void basicSmeltingSerializer(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike input, ItemLike output, String group){
        EPSmeltingRecipeBuilder.basicSmelting(Ingredient.of(input), output, group)
                .group(group)
                .unlockedBy(getHasName(input), has(input))
                .save(pFinishedRecipeConsumer, EnhancedPlaythrough.MOD_ID + ":" + getItemName(output) +  "_from_basic_smelting_" + getItemName(input));
    }

    protected static void basicSmeltingSerializerWithTag(Consumer<FinishedRecipe> pFinishedRecipeConsumer, TagKey<Item> input, ItemLike output, String group){
        EPSmeltingRecipeBuilder.basicSmelting(Ingredient.of(input), output, group)
                .group(group)
                .unlockedBy(input.toString(), has(input))
                .save(pFinishedRecipeConsumer, EnhancedPlaythrough.MOD_ID + ":" + getItemName(output) +  "_from_basic_smelting");
    }

    protected static void soulBasicSmeltingSerializer(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike input, ItemLike output, String group){
        EPSmeltingRecipeBuilder.soulBasicSmelting(Ingredient.of(input), output, group)
                .group(group)
                .unlockedBy(getHasName(input), has(input))
                .save(pFinishedRecipeConsumer, EnhancedPlaythrough.MOD_ID + ":" + getItemName(output) +  "_from_soul_basic_smelting_" + getItemName(input));
    }

    protected static void soulBasicSmeltingSerializerWithTag(Consumer<FinishedRecipe> pFinishedRecipeConsumer, TagKey<Item> input, ItemLike output, String group){
        EPSmeltingRecipeBuilder.soulBasicSmelting(Ingredient.of(input), output, group)
                .group(group)
                .unlockedBy(input.toString(), has(input))
                .save(pFinishedRecipeConsumer, EnhancedPlaythrough.MOD_ID + ":" + getItemName(output) +  "_from_soul_basic_smelting");
    }

    protected static void masonrySmeltingSerializer(Consumer<FinishedRecipe> pConsumer, ItemLike input, ItemLike output, String group){
        EPSmeltingRecipeBuilder.masonrySmelting(Ingredient.of(input), output, group)
                .group(group)
                .unlockedBy(getHasName(input), has(input))
                .save(pConsumer, EnhancedPlaythrough.MOD_ID + ":" + getItemName(output) + "_from_masonry_smelting_" + getItemName(input));
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
    }
}
