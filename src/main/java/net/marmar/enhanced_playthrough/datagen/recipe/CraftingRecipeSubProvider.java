package net.marmar.enhanced_playthrough.datagen.recipe;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.block.EPBlocks;
import net.marmar.enhanced_playthrough.datagen.tag.EPTags;
import net.marmar.enhanced_playthrough.item.EPItems;
import net.marmar.enhanced_playthrough.recipe.crafting.EPShapelessRecipeBuilder;
import net.minecraft.advancements.critereon.EnterBlockTrigger;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class CraftingRecipeSubProvider extends RecipeProvider {
    public CraftingRecipeSubProvider(PackOutput pOutput) {
        super(pOutput);
    }

    public static void addCraftingRecipes(Consumer<FinishedRecipe> consumer) {
        //Foods
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, EPItems.EMPTY_MATE.get())
                .pattern("#")
                .pattern("I")
                .define('#', Items.IRON_INGOT)
                .define('I', EPItems.COOKED_ZAPALLO.get())
                .unlockedBy(getHasName(EPItems.COOKED_ZAPALLO.get()), has(EPItems.COOKED_ZAPALLO.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, EPItems.GROUNDED_YERBA_MATE.get())
                .pattern(" I ")
                .pattern("I I")
                .pattern(" I ")
                .define('I', EPItems.YERBA_MATE.get())
                .unlockedBy(getHasName(EPItems.YERBA_MATE.get()), has(EPItems.YERBA_MATE.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, EPItems.MATE.get())
                .requires(EPItems.EMPTY_MATE.get())
                .requires(EPItems.GROUNDED_YERBA_MATE.get())
                .unlockedBy(getHasName(EPItems.YERBA_MATE.get()), has(EPItems.YERBA_MATE.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, EPItems.RAW_ROTTEN_STEW.get())
                .requires(EPItems.ROTTEN_TOMATO.get()).requires(EPItems.ROTTEN_CARROT.get())
                .requires(EPItems.ROTTEN_CORN.get()).requires(EPItems.ROTTEN_ZAPALLO.get())
                .requires(EPItems.ROTTEN_EGGPLANT.get()).requires(Items.POISONOUS_POTATO)
                .requires(Items.BOWL)
                .unlockedBy("has_rotten_food", HAS_ROTTEN_FOOD())
                .unlockedBy(getHasName(Items.BOWL), has(Items.BOWL))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, EPItems.PEELED_WALNUT.get())
                .requires(EPItems.WALNUT.get())
                .unlockedBy(getHasName(EPItems.WALNUT.get()), has(EPItems.WALNUT.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, EPItems.YEAST.get(), 4)
                .requires(Items.BROWN_MUSHROOM, 2)
                .requires(Items.SUGAR)
                .unlockedBy(getHasName(Items.SUGAR), has(Items.SUGAR))
                .unlockedBy(getHasName(Items.BROWN_MUSHROOM), has(Items.BROWN_MUSHROOM))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, EPItems.WHEAT_FLOUR.get(), 3)
                .pattern("AAA")
                .define('A', Items.WHEAT)
                .unlockedBy(getHasName(Items.WHEAT), has(Items.WHEAT))
                .unlockedBy(getHasName(EPItems.WHEAT_FLOUR.get()), has(EPItems.WHEAT_FLOUR.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, EPItems.RICE_BOWL.get())
                .pattern("#I")
                .define('I', Items.BOWL)
                .define('#', EPItems.RICE_GRAINS.get())
                .unlockedBy(getHasName(EPItems.RICE_GRAINS.get()), has(EPItems.RICE_GRAINS.get()))
                .save(consumer);

        //Seeds
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, EPItems.TOMATO_SEEDS.get(), 2)
                .requires(EPItems.WILD_TOMATO.get())
                .unlockedBy(getHasName(EPItems.WILD_TOMATO.get()), has(EPItems.WILD_TOMATO.get()))
                .unlockedBy(getHasName(EPItems.TOMATO_SEEDS.get()), has(EPItems.TOMATO_SEEDS.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, EPItems.CORN_SEEDS.get(), 2)
                .requires(EPItems.WILD_CORN.get())
                .unlockedBy(getHasName(EPItems.WILD_CORN.get()), has(EPItems.WILD_CORN.get()))
                .unlockedBy(getHasName(EPItems.CORN_SEEDS.get()), has(EPItems.CORN_SEEDS.get()))
                .save(consumer);

        //Sulfur
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EPBlocks.SULFUR_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', EPItems.SULFUR.get())
                .unlockedBy(getHasName(EPItems.SULFUR.get()), has(EPItems.SULFUR.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, EPItems.SULFUR.get(), 9)
                .requires(EPBlocks.SULFUR_BLOCK.get())
                .unlockedBy(getHasName(EPBlocks.SULFUR_BLOCK.get()), has(EPBlocks.SULFUR_BLOCK.get()))
                .save(consumer);

        //Dyes
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.YELLOW_DYE, 2)
                .requires(EPItems.SULFUR.get())
                .unlockedBy(getHasName(EPItems.SULFUR.get()), has(EPItems.SULFUR.get()))
                .unlockedBy(getHasName(Items.YELLOW_DYE), has(Items.YELLOW_DYE))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.WHITE_DYE, 3)
                .requires(EPItems.LIME.get())
                .unlockedBy(getHasName(EPItems.LIME.get()), has(EPItems.LIME.get()))
                .unlockedBy(getHasName(Items.WHITE_DYE), has(Items.WHITE_DYE))
                .save(consumer);

        //Mud bricks
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, EPItems.MUD_BRICK.get(), 2)
                .requires(Items.DIRT)
                .requires(EPItems.PLANT_FIBER.get())
                .requires(Items.CLAY_BALL)
                .unlockedBy(getHasName(EPItems.PLANT_FIBER.get()), has(EPItems.PLANT_FIBER.get()))
                .unlockedBy(getHasName(Items.CLAY_BALL), has(Items.CLAY_BALL))
                .unlockedBy(getHasName(EPItems.MUD_BRICK.get()), has(EPItems.MUD_BRICK.get()))
                .save(consumer, recipeName(EPItems.MUD_BRICK.get(), "from_plant_fiber"));


        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, EPItems.MUD_BRICK.get(), 4)
                .requires(Items.DIRT)
                .requires(Items.WHEAT)
                .requires(Items.CLAY_BALL)
                .unlockedBy(getHasName(Items.WHEAT), has(Items.WHEAT))
                .unlockedBy(getHasName(Items.CLAY_BALL), has(Items.CLAY_BALL))
                .unlockedBy(getHasName(EPItems.MUD_BRICK.get()), has(EPItems.MUD_BRICK.get()))
                .save(consumer, recipeName(EPItems.MUD_BRICK.get(), "from_wheat"));

        //Aluminum
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EPItems.ALUMINUM_ROD.get(), 4)
                .pattern("A")
                .pattern("A")
                .define('A', EPItems.ALUMINUM_INGOT.get())
                .unlockedBy(getHasName(EPItems.ALUMINUM_INGOT.get()), has(EPItems.ALUMINUM_INGOT.get()))
                .unlockedBy(getHasName(EPItems.ALUMINUM_ROD.get()), has(EPItems.ALUMINUM_ROD.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, EPItems.ALUMINUM_ARROW.get(), 4)
                .pattern("F")
                .pattern("R")
                .pattern("A")
                .define('F', Items.FLINT)
                .define('R', EPItems.ALUMINUM_ROD.get())
                .define('A', Items.FEATHER)
                .unlockedBy(getHasName(EPItems.ALUMINUM_ROD.get()), has(EPItems.ALUMINUM_ROD.get()))
                .unlockedBy(getHasName(EPItems.ALUMINUM_ARROW.get()), has(EPItems.ALUMINUM_ARROW.get()))
                .save(consumer);

        //Purple gold
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EPItems.PURPLE_GOLD_ROD.get(), 4)
                .pattern("A")
                .pattern("A")
                .define('A', EPItems.PURPLE_GOLD_INGOT.get())
                .unlockedBy(getHasName(EPItems.PURPLE_GOLD_INGOT.get()), has(EPItems.PURPLE_GOLD_INGOT.get()))
                .unlockedBy(getHasName(EPItems.PURPLE_GOLD_ROD.get()), has(EPItems.PURPLE_GOLD_ROD.get()))
                .save(consumer);

        //Leather
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.LEATHER)
                .requires(EPItems.COW_HIDE.get(), 2)
                .group("leather")
                .unlockedBy(getHasName(EPItems.COW_HIDE.get()), has(EPItems.COW_HIDE.get()))
                .save(consumer, recipeName(Items.LEATHER, "from_cow_hide"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.LEATHER)
                .requires(EPItems.PIG_HIDE.get(), 2)
                .group("leather")
                .unlockedBy(getHasName(EPItems.PIG_HIDE.get()), has(EPItems.PIG_HIDE.get()))
                .save(consumer, recipeName(Items.LEATHER, "from_pig_hide"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.LEATHER)
                .requires(EPItems.WERELLAGER_HIDE.get(), 3)
                .group("leather")
                .unlockedBy(getHasName(EPItems.WERELLAGER_HIDE.get()), has(EPItems.WERELLAGER_HIDE.get()))
                .save(consumer, recipeName(Items.LEATHER, "from_werellager_hide"));

        EPShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, EPItems.LEATHER_STRIPS.get(), 3)
                .requires(Items.LEATHER)
                .requires(Items.SHEARS).consumeDurability()
                .durabilityToConsume(10)
                .unlockedBy(getHasName(Items.LEATHER), has(Items.LEATHER))
                .unlockedBy(getHasName(EPItems.LEATHER_STRIPS.get()), has(EPItems.LEATHER_STRIPS.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, EPItems.REINFORCED_STICK.get())
                .requires(EPItems.LEATHER_STRIPS.get())
                .requires(Items.STICK)
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .save(consumer);

        //String
        EPShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.STRING, 2)
                .requires(ItemTags.WOOL)
                .requires(Items.SHEARS).consumeDurability()
                .durabilityToConsume(15)
                .group("string")
                .unlockedBy("has_wool", has(ItemTags.WOOL))
                .unlockedBy(getHasName(Items.STRING), has(Items.STRING))
                .save(consumer, recipeName(Items.STRING, "from_wool"));

        EPShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.STRING, 2)
                .requires(Items.COBWEB)
                .requires(EPTags.Items.DAGGER).consumeDurability()
                .durabilityToConsume(4)
                .group("string")
                .unlockedBy(getHasName(Items.COBWEB), has(Items.COBWEB))
                .save(consumer, recipeName(Items.STRING, "from_cobweb"));

        //Plant fiber
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, EPItems.PLANT_FIBER.get())
                .requires(EPItems.REEDS_HEAD.get(), 2)
                .group("plant_fiber")
                .unlockedBy(getHasName(EPItems.REEDS_HEAD.get()), has(EPItems.REEDS_HEAD.get()))
                .unlockedBy(getHasName(EPItems.PLANT_FIBER.get()), has(EPItems.PLANT_FIBER.get()))
                .save(consumer, recipeName(EPItems.PLANT_FIBER.get(), "from_reeds_head"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, EPItems.PLANT_FIBER.get(), 2)
                .requires(EPItems.TALL_REEDS_HEAD.get(), 2)
                .group("plant_fiber")
                .unlockedBy(getHasName(EPItems.TALL_REEDS_HEAD.get()), has(EPItems.TALL_REEDS_HEAD.get()))
                .unlockedBy(getHasName(EPItems.PLANT_FIBER.get()), has(EPItems.PLANT_FIBER.get()))
                .save(consumer, recipeName(EPItems.PLANT_FIBER.get(), "from_tall_reeds_head"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, EPItems.PLANT_FIBER.get())
                .requires(EPItems.WATER_REEDS_HEAD.get(), 4)
                .group("plant_fiber")
                .unlockedBy(getHasName(EPItems.WATER_REEDS_HEAD.get()), has(EPItems.WATER_REEDS_HEAD.get()))
                .unlockedBy(getHasName(EPItems.PLANT_FIBER.get()), has(EPItems.PLANT_FIBER.get()))
                .save(consumer, recipeName(EPItems.PLANT_FIBER.get(), "from_water_reeds_head"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, EPItems.PLANT_FIBER.get(), 2)
                .requires(EPItems.KENAF_BRANCH.get(), 2)
                .group("plant_fiber")
                .unlockedBy(getHasName(EPItems.KENAF_BRANCH.get()), has(EPItems.KENAF_BRANCH.get()))
                .unlockedBy(getHasName(EPItems.PLANT_FIBER.get()), has(EPItems.PLANT_FIBER.get()))
                .save(consumer, recipeName(EPItems.PLANT_FIBER.get(), "from_kenaf_branch"));

        //Smithing templates
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, EPItems.REINFORCED_UPGRADE_SMITHING_TEMPLATE.get(), 2)
                .pattern("SAS")
                .pattern("SLS")
                .pattern("SSS")
                .define('A', EPItems.REINFORCED_UPGRADE_SMITHING_TEMPLATE.get())
                .define('L', Items.LEATHER)
                .define('S', Items.STICK)
                .unlockedBy(getHasName(EPItems.REINFORCED_UPGRADE_SMITHING_TEMPLATE.get()), has(EPItems.REINFORCED_UPGRADE_SMITHING_TEMPLATE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, EPItems.BRONZIUM_UPGRADE_SMITHING_TEMPLATE.get(), 2)
                .pattern("BAB")
                .pattern("BVB")
                .pattern("BBB")
                .define('A', EPItems.BRONZIUM_UPGRADE_SMITHING_TEMPLATE.get())
                .define('V', EPItems.BRONZIUM_INGOT.get())
                .define('B', Items.NETHER_BRICK)
                .unlockedBy(getHasName(EPItems.BRONZIUM_UPGRADE_SMITHING_TEMPLATE.get()), has(EPItems.BRONZIUM_UPGRADE_SMITHING_TEMPLATE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, EPItems.ALUMINUM_UPGRADE_SMITHING_TEMPLATE.get(), 2)
                .pattern("SAS")
                .pattern("SVS")
                .pattern("SSS")
                .define('A', EPItems.ALUMINUM_UPGRADE_SMITHING_TEMPLATE.get())
                .define('V', EPItems.ALUMINUM_INGOT.get())
                .define('S', EPTags.Items.TERRACOTTA_SHARD)
                .unlockedBy(getHasName(EPItems.ALUMINUM_UPGRADE_SMITHING_TEMPLATE.get()), has(EPItems.ALUMINUM_UPGRADE_SMITHING_TEMPLATE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, EPItems.GOLDEN_UPGRADE_SMITHING_TEMPLATE.get(), 2)
                .pattern("SAS")
                .pattern("SVS")
                .pattern("SSS")
                .define('A', EPItems.GOLDEN_UPGRADE_SMITHING_TEMPLATE.get())
                .define('V', Items.GOLD_INGOT)
                .define('S', EPItems.COBBLE.get())
                .unlockedBy(getHasName(EPItems.GOLDEN_UPGRADE_SMITHING_TEMPLATE.get()), has(EPItems.GOLDEN_UPGRADE_SMITHING_TEMPLATE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, EPItems.ANCIENT_ARMOR_TRIM_SMITHING_TEMPLATE.get(), 2)
                .pattern("SAS")
                .pattern("SVS")
                .pattern("SSS")
                .define('A', EPItems.ANCIENT_ARMOR_TRIM_SMITHING_TEMPLATE.get())
                .define('V', Items.GOLD_INGOT)
                .define('S', EPItems.COBBLE.get())
                .unlockedBy(getHasName(EPItems.ANCIENT_ARMOR_TRIM_SMITHING_TEMPLATE.get()), has(EPItems.ANCIENT_ARMOR_TRIM_SMITHING_TEMPLATE.get()))
                .save(consumer);

        //Block recipes
        //Wood
        //walnut wood
        woodRecipes(EPBlocks.WALNUT_LOG.get(), EPBlocks.STRIPPED_WALNUT_LOG.get(), EPBlocks.WALNUT_WOOD.get(), EPBlocks.STRIPPED_WALNUT_WOOD.get(),
                EPBlocks.WALNUT_PLANKS.get(), EPBlocks.WALNUT_DOOR.get(), EPBlocks.WALNUT_TRAPDOOR.get(),
                EPBlocks.WALNUT_STAIRS.get(), EPBlocks.WALNUT_SLAB.get(), EPBlocks.WALNUT_FENCE.get(), EPBlocks.WALNUT_FENCEGATE.get(),
                EPItems.WALNUT_SIGN.get(), EPItems.WALNUT_HANGING_SIGN.get(), EPItems.WALNUT_BOAT.get(), EPItems.WALNUT_CHEST_BOAT.get(),
                EPBlocks.WALNUT_BUTTON.get(), EPBlocks.WALNUT_PRESSURE_PLATE.get(), EPTags.Items.WALNUT_LOGS, consumer);

        //Apple wood
        woodRecipes(EPBlocks.APPLE_LOG.get(), EPBlocks.STRIPPED_APPLE_LOG.get(), EPBlocks.APPLE_WOOD.get(), EPBlocks.STRIPPED_APPLE_WOOD.get(),
                EPBlocks.APPLE_PLANKS.get(), EPBlocks.APPLE_DOOR.get(), EPBlocks.APPLE_TRAPDOOR.get(),
                EPBlocks.APPLE_STAIRS.get(), EPBlocks.APPLE_SLAB.get(), EPBlocks.APPLE_FENCE.get(), EPBlocks.APPLE_FENCEGATE.get(),
                EPItems.APPLE_SIGN.get(), EPItems.APPLE_HANGING_SIGN.get(), EPItems.APPLE_BOAT.get(), EPItems.APPLE_CHEST_BOAT.get(),
                EPBlocks.APPLE_BUTTON.get(), EPBlocks.APPLE_PRESSURE_PLATE.get(), EPTags.Items.APPLE_LOGS, consumer);

        //Orange wood
        woodRecipes(EPBlocks.ORANGE_LOG.get(), EPBlocks.STRIPPED_ORANGE_LOG.get(), EPBlocks.ORANGE_WOOD.get(), EPBlocks.STRIPPED_ORANGE_WOOD.get(),
                EPBlocks.ORANGE_PLANKS.get(), EPBlocks.ORANGE_DOOR.get(), EPBlocks.ORANGE_TRAPDOOR.get(),
                EPBlocks.ORANGE_STAIRS.get(), EPBlocks.ORANGE_SLAB.get(), EPBlocks.ORANGE_FENCE.get(), EPBlocks.ORANGE_FENCEGATE.get(),
                EPItems.ORANGE_SIGN.get(), EPItems.ORANGE_HANGING_SIGN.get(), EPItems.ORANGE_BOAT.get(), EPItems.ORANGE_CHEST_BOAT.get(),
                EPBlocks.ORANGE_BUTTON.get(), EPBlocks.ORANGE_PRESSURE_PLATE.get(), EPTags.Items.ORANGE_LOGS, consumer);

        //Lemon wood
        woodRecipes(EPBlocks.LEMON_LOG.get(), EPBlocks.STRIPPED_LEMON_LOG.get(), EPBlocks.LEMON_WOOD.get(), EPBlocks.STRIPPED_LEMON_WOOD.get(),
                EPBlocks.LEMON_PLANKS.get(), EPBlocks.LEMON_DOOR.get(), EPBlocks.LEMON_TRAPDOOR.get(),
                EPBlocks.LEMON_STAIRS.get(), EPBlocks.LEMON_SLAB.get(), EPBlocks.LEMON_FENCE.get(), EPBlocks.LEMON_FENCEGATE.get(),
                EPItems.LEMON_SIGN.get(), EPItems.LEMON_HANGING_SIGN.get(), EPItems.LEMON_BOAT.get(), EPItems.LEMON_CHEST_BOAT.get(),
                EPBlocks.LEMON_BUTTON.get(), EPBlocks.LEMON_PRESSURE_PLATE.get(), EPTags.Items.LEMON_LOGS, consumer);

        //Polished stone
        blockWithPolishedVersionRecipes(Blocks.STONE, EPBlocks.POLISHED_STONE.get(), EPBlocks.POLISHED_STONE_WALL.get(), EPBlocks.POLISHED_STONE_STAIRS.get(),
                EPBlocks.POLISHED_STONE_SLAB.get(), consumer);

        //Cobbled limestone
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, EPBlocks.COBBLED_LIMESTONE.get())
                .pattern("LL")
                .pattern("LL")
                .define('L', EPItems.LIMESTONE_COBBLE.get())
                .unlockedBy(getHasName(EPItems.LIMESTONE_COBBLE.get()), has(EPItems.LIMESTONE_COBBLE.get()))
                .unlockedBy(getHasName(EPBlocks.COBBLED_LIMESTONE.get()), has(EPBlocks.COBBLED_LIMESTONE.get()))
                .save(consumer);

        blockWithoutPolishedVersionRecipes(EPBlocks.COBBLED_LIMESTONE.get(), EPBlocks.COBBLED_LIMESTONE_WALL.get(), EPBlocks.COBBLED_LIMESTONE_STAIRS.get(),
                EPBlocks.COBBLED_LIMESTONE_SLAB.get(), consumer);

        //Limestone
        blockWithoutPolishedVersionRecipes(EPBlocks.LIMESTONE.get(), EPBlocks.LIMESTONE_WALL.get(), EPBlocks.LIMESTONE_STAIRS.get(),
                EPBlocks.LIMESTONE_SLAB.get(), consumer);

        //Polished limestone
        blockWithPolishedVersionRecipes(EPBlocks.LIMESTONE.get(), EPBlocks.POLISHED_LIMESTONE.get(), EPBlocks.POLISHED_LIMESTONE_WALL.get(),
                EPBlocks.POLISHED_LIMESTONE_STAIRS.get(), EPBlocks.POLISHED_LIMESTONE_SLAB.get(), consumer);

        //Limestone bricks
        blockWithPolishedVersionRecipes(EPBlocks.POLISHED_LIMESTONE.get(), EPBlocks.LIMESTONE_BRICKS.get(), EPBlocks.LIMESTONE_BRICK_WALL.get(),
                EPBlocks.LIMESTONE_BRICK_STAIRS.get(), EPBlocks.LIMESTONE_BRICK_SLAB.get(), consumer);

        //Cobbled soulstone
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, EPBlocks.COBBLED_SOULSTONE.get())
                .pattern("SS")
                .pattern("SS")
                .define('S', EPItems.SOULSTONE_COBBLE.get())
                .unlockedBy(getHasName(EPItems.SOULSTONE_COBBLE.get()), has(EPItems.SOULSTONE_COBBLE.get()))
                .unlockedBy(getHasName(EPBlocks.COBBLED_SOULSTONE.get()), has(EPBlocks.COBBLED_SOULSTONE.get()))
                .save(consumer);

        blockWithoutPolishedVersionRecipes(EPBlocks.COBBLED_SOULSTONE.get(), EPBlocks.COBBLED_SOULSTONE_WALL.get(), EPBlocks.COBBLED_SOULSTONE_STAIRS.get(),
                EPBlocks.COBBLED_SOULSTONE_SLAB.get(), consumer);

        //Soulstone
        blockWithoutPolishedVersionRecipes(EPBlocks.SOULSTONE.get(), EPBlocks.SOULSTONE_WALL.get(), EPBlocks.SOULSTONE_STAIRS.get(),
                EPBlocks.SOULSTONE_SLAB.get(), consumer);

        //Soulstone bricks
        blockWithPolishedVersionRecipes(EPBlocks.SOULSTONE.get(), EPBlocks.SOULSTONE_BRICKS.get(), EPBlocks.SOULSTONE_BRICK_WALL.get(),
                EPBlocks.SOULSTONE_BRICK_STAIRS.get(), EPBlocks.SOULSTONE_BRICK_SLAB.get(), consumer);

        //Firebricks
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, EPBlocks.FIREBRICKS.get())
                .pattern("FF")
                .pattern("FF")
                .define('F', EPItems.FIREBRICK.get())
                .unlockedBy(getHasName(EPItems.FIREBRICK.get()), has(EPItems.FIREBRICK.get()))
                .unlockedBy(getHasName(EPBlocks.FIREBRICKS.get()), has(EPBlocks.FIREBRICKS.get()))
                .save(consumer);

        blockWithoutPolishedVersionRecipes(EPBlocks.FIREBRICKS.get(), EPBlocks.FIREBRICK_WALL.get(), EPBlocks.FIREBRICK_STAIRS.get(),
                EPBlocks.FIREBRICK_SLAB.get(), consumer);

        //Calibrated quartz
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, EPBlocks.CALIBRATED_QUARTZ_BLOCK.get())
                .pattern("CC")
                .pattern("CC")
                .define('C', EPItems.CALIBRATED_QUARTZ.get())
                .unlockedBy(getHasName(EPBlocks.CALIBRATED_QUARTZ_BLOCK.get()), has(EPBlocks.CALIBRATED_QUARTZ_BLOCK.get()))
                .unlockedBy(getHasName(EPItems.CALIBRATED_QUARTZ.get()), has(EPItems.CALIBRATED_QUARTZ.get()))
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, EPItems.CALIBRATED_QUARTZ.get(), 4)
                .requires(EPBlocks.CALIBRATED_QUARTZ_BLOCK.get())
                .unlockedBy(getHasName(EPItems.CALIBRATED_QUARTZ.get()), has(EPItems.CALIBRATED_QUARTZ.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, EPBlocks.CALIBRATED_QUARTZ_PILLAR.get())
                .pattern("C")
                .pattern("C")
                .define('C', EPBlocks.CALIBRATED_QUARTZ_BLOCK.get())
                .unlockedBy(getHasName(EPBlocks.CALIBRATED_QUARTZ_BLOCK.get()), has(EPBlocks.CALIBRATED_QUARTZ_BLOCK.get()))
                .unlockedBy(getHasName(EPBlocks.CALIBRATED_QUARTZ_PILLAR.get()), has(EPBlocks.CALIBRATED_QUARTZ_PILLAR.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, EPBlocks.CALIBRATED_QUARTZ_BRICKS.get())
                .pattern("CC")
                .pattern("CC")
                .define('C', EPBlocks.CALIBRATED_QUARTZ_BLOCK.get())
                .unlockedBy(getHasName(EPBlocks.CALIBRATED_QUARTZ_BLOCK.get()), has(EPBlocks.CALIBRATED_QUARTZ_BLOCK.get()))
                .unlockedBy(getHasName(EPBlocks.CALIBRATED_QUARTZ_BRICKS.get()), has(EPBlocks.CALIBRATED_QUARTZ_BRICKS.get()))
                .save(consumer);

        //Block entities
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EPBlocks.ADOBE_FURNACE.get())
                .pattern("###")
                .pattern("# #")
                .pattern("III")
                .define('#', EPItems.MUD_BRICK.get())
                .define('I', ItemTags.STONE_CRAFTING_MATERIALS)
                .unlockedBy(getHasName(Blocks.COBBLESTONE), has(Blocks.COBBLESTONE))
                .unlockedBy(getHasName(EPItems.MUD_BRICK.get()), has(EPItems.MUD_BRICK.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EPBlocks.SOUL_FURNACE.get())
                .pattern("###")
                .pattern("# #")
                .pattern("###")
                .define('#', EPBlocks.COBBLED_SOULSTONE.get())
                .unlockedBy(getHasName(EPBlocks.COBBLED_SOULSTONE.get()), has(EPBlocks.COBBLED_SOULSTONE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EPBlocks.MASONRY_FURNACE.get())
                .pattern("III")
                .pattern("BFB")
                .pattern("CCC")
                .define('I', EPItems.BRONZE_INGOT.get())
                .define('B', EPBlocks.FIREBRICKS.get())
                .define('F', Blocks.FURNACE)
                .define('C', Blocks.COBBLESTONE)
                .unlockedBy(getHasName(Blocks.FURNACE), has(Blocks.FURNACE))
                .unlockedBy(getHasName(EPBlocks.MASONRY_FURNACE.get()), has(EPBlocks.MASONRY_FURNACE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EPBlocks.ADOBE_ALLOY_FURNACE.get())
                .pattern("###")
                .pattern("#A#")
                .pattern("III")
                .define('#', Blocks.BRICKS)
                .define('A', EPBlocks.ADOBE_FURNACE.get())
                .define('I', Blocks.COBBLESTONE)
                .unlockedBy(getHasName(EPBlocks.ADOBE_FURNACE.get()), has(EPBlocks.ADOBE_FURNACE.get()))
                .unlockedBy(getHasName(EPBlocks.ADOBE_ALLOY_FURNACE.get()), has(EPBlocks.ADOBE_ALLOY_FURNACE.get()))
                .unlockedBy(getHasName(EPItems.RAW_TIN.get()), has(EPItems.RAW_TIN.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EPBlocks.SUPER_ALLOY_FURNACE.get())
                .pattern("###")
                .pattern("#A#")
                .pattern("III")
                .define('#', EPItems.STEEL_INGOT.get())
                .define('A', EPBlocks.ADOBE_ALLOY_FURNACE.get())
                .define('I', Blocks.COBBLED_DEEPSLATE)
                .unlockedBy(getHasName(Blocks.COBBLED_DEEPSLATE), has(Blocks.COBBLED_DEEPSLATE))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EPBlocks.GEM_POLISHER.get())
                .pattern("###")
                .pattern("AIA")
                .pattern("AIA")
                .define('#', ItemTags.PLANKS)
                .define('A', ItemTags.LOGS_THAT_BURN)
                .define('I', Blocks.STONE)
                .unlockedBy(getHasName(Blocks.STONE), has(Blocks.STONE))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EPBlocks.PRIMAL_GRINDER.get())
                .pattern("AAA")
                .pattern("ABA")
                .pattern("CCC")
                .define('A', Blocks.MUD_BRICKS)
                .define('B', EPItems.BRONZE_INGOT.get())
                .define('C', Blocks.COBBLESTONE)
                .unlockedBy(getHasName(EPItems.BRONZE_INGOT.get()), has(EPItems.BRONZE_INGOT.get()))
                .unlockedBy(getHasName(Blocks.MUD_BRICKS), has(Blocks.MUD_BRICKS))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EPBlocks.MECHANICAL_GRINDER.get())
                .pattern("#A#")
                .pattern("SIS")
                .pattern("###")
                .define('#', ItemTags.STONE_CRAFTING_MATERIALS)
                .define('A', Items.IRON_BARS)
                .define('S', EPItems.STEEL_INGOT.get())
                .define('I', Items.REDSTONE)
                .unlockedBy(getHasName(EPBlocks.PRIMAL_GRINDER.get()), has(EPBlocks.PRIMAL_GRINDER.get()))
                .unlockedBy(getHasName(Items.REDSTONE), has(Items.REDSTONE))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, EPBlocks.GROWTH_DETECTOR.get())
                .pattern(" T ")
                .pattern("RLR")
                .pattern("SSS")
                .define('T', Items.REDSTONE_TORCH)
                .define('R', Items.REDSTONE)
                .define('L', EPItems.CALIBRATED_QUARTZ.get())
                .define('S', Items.STONE)
                .unlockedBy(getHasName(Items.REDSTONE), has(Items.REDSTONE))
                .unlockedBy(getHasName(EPBlocks.GROWTH_DETECTOR.get()), has(EPBlocks.GROWTH_DETECTOR.get()))
                .save(consumer);

        //TODO: Terminar el duplicador alquímico
//        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EPBlocks.ALCHEMICAL_DUPLICATOR.get())
//                .pattern("BBB")
//                .pattern("BSB")
//                .pattern("BBB")
//                .define('B', EPItems.BRONZIUM_INGOT.get())
//                .define('S', EPItems.SULFUR.get())
//                .unlockedBy(getHasName(EPBlocks.ALCHEMICAL_DUPLICATOR.get()), has(EPBlocks.ALCHEMICAL_DUPLICATOR.get()))
//                .unlockedBy(getHasName(EPItems.BRONZIUM_INGOT.get()), has(EPItems.BRONZIUM_INGOT.get()))
//                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EPBlocks.LEATHERWORKER_STATION.get())
                .pattern("SSS")
                .pattern("FDF")
                .pattern("FBF")
                .define('S', ItemTags.WOODEN_SLABS)
                .define('F', ItemTags.WOODEN_FENCES)
                .define('D', EPItems.BRONZE_DAGGER.get())
                .define('B', Items.BARREL)
                .unlockedBy(getHasName(Items.LEATHER), has(Items.LEATHER))
                .unlockedBy(getHasName(EPBlocks.LEATHERWORKER_STATION.get()), has(EPBlocks.LEATHERWORKER_STATION.get()))
                .save(consumer);

        //Equipment recipes
            //Other tools
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EPItems.FLINT_AND_COBBLE.get())
                    .pattern("C ")
                    .pattern(" F")
                    .define('C', EPTags.Items.COBBLE)
                    .define('F', Items.FLINT)
                    .unlockedBy("has_cobble", has(EPTags.Items.COBBLE))
                    .unlockedBy(getHasName(Items.FLINT), has(Items.FLINT))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EPItems.FLINT_AND_BRONZE.get())
                    .pattern("B ")
                    .pattern(" F")
                    .define('B', EPItems.BRONZE_INGOT.get())
                    .define('F', Items.FLINT)
                    .unlockedBy(getHasName(EPItems.BRONZE_INGOT.get()), has(EPItems.BRONZE_INGOT.get()))
                    .unlockedBy(getHasName(Items.FLINT), has(Items.FLINT))
                    .save(consumer);

            //Silver
            materialRecipes(EPItems.SILVER_INGOT.get(), EPItems.SILVER_NUGGET.get(), EPBlocks.SILVER_BLOCK.get(), consumer);
            materialRecipes(EPItems.RAW_SILVER.get(), EPBlocks.RAW_SILVER_BLOCK.get(), consumer);

            addGear(EPItems.SILVER_INGOT.get(), EPItems.SILVER_AXE.get(), EPItems.SILVER_PICKAXE.get(), EPItems.SILVER_SWORD.get(),
                    EPItems.SILVER_DAGGER.get(), EPItems.SILVER_SHOVEL.get(), EPItems.SILVER_HOE.get(), EPItems.SILVER_POLISHER.get(),
                    EPItems.SILVER_HELMET.get(), EPItems.SILVER_CHESTPLATE.get(), EPItems.SILVER_LEGGINGS.get(), EPItems.SILVER_BOOTS.get(),
                    consumer);

            addCustomHandleGear(EPItems.SILVER_INGOT.get(), EPItems.REINFORCED_STICK.get(), EPItems.REINFORCED_SILVER_AXE.get(), EPItems.REINFORCED_SILVER_PICKAXE.get(),
                    EPItems.REINFORCED_SILVER_SWORD.get(), EPItems.REINFORCED_SILVER_DAGGER.get(), EPItems.REINFORCED_SILVER_SHOVEL.get(),
                    EPItems.REINFORCED_SILVER_HOE.get(), EPItems.REINFORCED_SILVER_POLISHER.get(), consumer);

            addCustomHandleGear(EPItems.SILVER_INGOT.get(), EPItems.ALUMINUM_ROD.get(), EPItems.ALUMINUM_SILVER_AXE.get(), EPItems.ALUMINUM_SILVER_PICKAXE.get(),
                    EPItems.ALUMINUM_SILVER_SWORD.get(), EPItems.ALUMINUM_SILVER_DAGGER.get(), EPItems.ALUMINUM_SILVER_SHOVEL.get(),
                    EPItems.ALUMINUM_SILVER_HOE.get(), EPItems.ALUMINUM_SILVER_POLISHER.get(), consumer);

            addCustomHandleGear(EPItems.SILVER_INGOT.get(), EPItems.PURPLE_GOLD_ROD.get(), EPItems.PURPLE_GOLD_SILVER_AXE.get(), EPItems.PURPLE_GOLD_SILVER_PICKAXE.get(),
                    EPItems.PURPLE_GOLD_SILVER_SWORD.get(), EPItems.PURPLE_GOLD_SILVER_DAGGER.get(), EPItems.PURPLE_GOLD_SILVER_SHOVEL.get(),
                    EPItems.PURPLE_GOLD_SILVER_HOE.get(), EPItems.PURPLE_GOLD_SILVER_POLISHER.get(), consumer);

            //Aluminum
            materialRecipes(EPItems.ALUMINUM_INGOT.get(), EPItems.ALUMINUM_NUGGET.get(), EPBlocks.ALUMINUM_BLOCK.get(), consumer);
            materialRecipes(EPItems.RAW_ALUMINUM.get(), EPBlocks.RAW_ALUMINUM_BLOCK.get(),consumer);

            //Gold
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, EPItems.GOLDEN_POLISHER.get())
                    .pattern(" I")
                    .pattern("# ")
                    .define('I', Items.GOLD_INGOT)
                    .define('#', Tags.Items.RODS_WOODEN)
                    .unlockedBy(getHasName(Items.GOLD_INGOT), has(Items.GOLD_INGOT))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, EPItems.GOLDEN_DAGGER.get())
                    .pattern("I")
                    .pattern("#")
                    .define('I', Items.GOLD_INGOT)
                    .define('#', Tags.Items.RODS_WOODEN)
                    .unlockedBy(getHasName(Items.GOLD_INGOT), has(Items.GOLD_INGOT))
                    .unlockedBy(getHasName(EPItems.GOLDEN_DAGGER.get()), has(EPItems.GOLDEN_DAGGER.get()))
                    .save(consumer);

            addArmor(Items.GOLD_INGOT, Items.GOLDEN_HELMET, Items.GOLDEN_CHESTPLATE, Items.GOLDEN_LEGGINGS, Items.GOLDEN_BOOTS, consumer);

            addCustomHandleGear(Items.GOLD_INGOT, EPItems.REINFORCED_STICK.get(), EPItems.REINFORCED_GOLDEN_AXE.get(), EPItems.REINFORCED_GOLDEN_PICKAXE.get(),
                    EPItems.REINFORCED_GOLDEN_SWORD.get(), EPItems.REINFORCED_GOLDEN_DAGGER.get(), EPItems.REINFORCED_GOLDEN_SHOVEL.get(),
                    EPItems.REINFORCED_GOLDEN_HOE.get(), EPItems.REINFORCED_GOLDEN_POLISHER.get(), consumer);

            addCustomHandleGear(Items.GOLD_INGOT, EPItems.ALUMINUM_ROD.get(), EPItems.ALUMINUM_GOLDEN_AXE.get(), EPItems.ALUMINUM_GOLDEN_PICKAXE.get(),
                    EPItems.ALUMINUM_GOLDEN_SWORD.get(), EPItems.ALUMINUM_GOLDEN_DAGGER.get(), EPItems.ALUMINUM_GOLDEN_SHOVEL.get(),
                    EPItems.ALUMINUM_GOLDEN_HOE.get(), EPItems.ALUMINUM_GOLDEN_POLISHER.get(), consumer);

            addCustomHandleGear(Items.GOLD_INGOT, EPItems.PURPLE_GOLD_ROD.get(), EPItems.PURPLE_GOLD_GOLDEN_AXE.get(), EPItems.PURPLE_GOLD_GOLDEN_PICKAXE.get(),
                    EPItems.PURPLE_GOLD_GOLDEN_SWORD.get(), EPItems.PURPLE_GOLD_GOLDEN_DAGGER.get(), EPItems.PURPLE_GOLD_GOLDEN_SHOVEL.get(),
                    EPItems.PURPLE_GOLD_GOLDEN_HOE.get(), EPItems.PURPLE_GOLD_GOLDEN_POLISHER.get(), consumer);

            //Stone
            addStoneGear(Ingredient.of(Tags.Items.RODS_WOODEN), Items.STONE_AXE, Items.STONE_PICKAXE, Items.STONE_SWORD, EPItems.STONE_DAGGER.get(),
                    Items.STONE_SHOVEL, Items.STONE_HOE, EPItems.STONE_POLISHER.get(), consumer);

            //Copper
            ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, EPItems.COPPER_NUGGET.get(), 9)
                    .requires(Items.COPPER_INGOT)
                    .unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT))
                    .unlockedBy(getHasName(EPItems.COPPER_NUGGET.get()), has(EPItems.COPPER_NUGGET.get()))
                    .save(consumer, recipeName(EPItems.COPPER_NUGGET.get(), "from_ingots"));

            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.COPPER_INGOT)
                    .pattern("NNN")
                    .pattern("NNN")
                    .pattern("NNN")
                    .define('N', EPItems.COPPER_NUGGET.get())
                    .unlockedBy(getHasName(EPItems.COPPER_NUGGET.get()), has(EPItems.COPPER_NUGGET.get()))
                    .unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT))
                    .group("copper_ingot")
                    .save(consumer, recipeName(Items.COPPER_INGOT, "from_nuggets"));

            //Tin
            materialRecipes(EPItems.RAW_TIN.get(), EPBlocks.RAW_TIN_BLOCK.get(), consumer);
            materialRecipes(EPItems.TIN_INGOT.get(), EPItems.TIN_NUGGET.get(), EPBlocks.TIN_BLOCK.get(), consumer);

            //Zinc
            materialRecipes(EPItems.RAW_ZINC.get(), EPBlocks.RAW_ZINC_BLOCK.get(), consumer);
            materialRecipes(EPItems.ZINC_INGOT.get(), EPItems.ZINC_NUGGET.get(), EPBlocks.ZINC_BLOCK.get(), consumer);

            //Brass
            materialRecipes(EPItems.BRASS_INGOT.get(), EPItems.BRASS_NUGGET.get(), EPBlocks.BRASS_BLOCK.get(), consumer);

            addGear(EPItems.BRASS_INGOT.get(), EPItems.BRASS_AXE.get(), EPItems.BRASS_PICKAXE.get(), EPItems.BRASS_SWORD.get(),
                    EPItems.BRASS_DAGGER.get(), EPItems.BRASS_SHOVEL.get(), EPItems.BRASS_HOE.get(), EPItems.BRASS_POLISHER.get(),
                    EPItems.BRASS_HELMET.get(), EPItems.BRASS_CHESTPLATE.get(), EPItems.BRASS_LEGGINGS.get(), EPItems.BRASS_BOOTS.get(),
                    consumer);

            addCustomHandleGear(EPItems.BRASS_INGOT.get(), EPItems.REINFORCED_STICK.get(), EPItems.REINFORCED_BRASS_AXE.get(), EPItems.REINFORCED_BRASS_PICKAXE.get(),
                    EPItems.REINFORCED_BRASS_SWORD.get(), EPItems.REINFORCED_BRASS_DAGGER.get(), EPItems.REINFORCED_BRASS_SHOVEL.get(),
                    EPItems.REINFORCED_BRASS_HOE.get(), EPItems.REINFORCED_BRASS_POLISHER.get(), consumer);

            addCustomHandleGear(EPItems.BRASS_INGOT.get(), EPItems.ALUMINUM_ROD.get(), EPItems.ALUMINUM_BRASS_AXE.get(), EPItems.ALUMINUM_BRASS_PICKAXE.get(),
                    EPItems.ALUMINUM_BRASS_SWORD.get(), EPItems.ALUMINUM_BRASS_DAGGER.get(), EPItems.ALUMINUM_BRASS_SHOVEL.get(),
                    EPItems.ALUMINUM_BRASS_HOE.get(), EPItems.ALUMINUM_BRASS_POLISHER.get(), consumer);

            addCustomHandleGear(EPItems.BRASS_INGOT.get(), EPItems.PURPLE_GOLD_ROD.get(), EPItems.PURPLE_GOLD_BRASS_AXE.get(), EPItems.PURPLE_GOLD_BRASS_PICKAXE.get(),
                    EPItems.PURPLE_GOLD_BRASS_SWORD.get(), EPItems.PURPLE_GOLD_BRASS_DAGGER.get(), EPItems.PURPLE_GOLD_BRASS_SHOVEL.get(),
                    EPItems.PURPLE_GOLD_BRASS_HOE.get(), EPItems.PURPLE_GOLD_BRASS_POLISHER.get(), consumer);

            //Bronze
            materialRecipes(EPItems.BRONZE_INGOT.get(), EPItems.BRONZE_NUGGET.get(), EPBlocks.BRONZE_BLOCK.get(), consumer);

            addGear(EPItems.BRONZE_INGOT.get(), EPItems.BRONZE_AXE.get(), EPItems.BRONZE_PICKAXE.get(), EPItems.BRONZE_SWORD.get(),
                    EPItems.BRONZE_DAGGER.get(), EPItems.BRONZE_SHOVEL.get(), EPItems.BRONZE_HOE.get(), EPItems.BRONZE_POLISHER.get(),
                    EPItems.BRONZE_HELMET.get(), EPItems.BRONZE_CHESTPLATE.get(), EPItems.BRONZE_LEGGINGS.get(), EPItems.BRONZE_BOOTS.get(),
                    consumer);


            addCustomHandleGear(EPItems.BRONZE_INGOT.get(), EPItems.REINFORCED_STICK.get(), EPItems.REINFORCED_BRONZE_AXE.get(), EPItems.REINFORCED_BRONZE_PICKAXE.get(),
                    EPItems.REINFORCED_BRONZE_SWORD.get(), EPItems.REINFORCED_BRONZE_DAGGER.get(), EPItems.REINFORCED_BRONZE_SHOVEL.get(),
                    EPItems.REINFORCED_BRONZE_HOE.get(), EPItems.REINFORCED_BRONZE_POLISHER.get(), consumer);

            addCustomHandleGear(EPItems.BRONZE_INGOT.get(), EPItems.ALUMINUM_ROD.get(), EPItems.ALUMINUM_BRONZE_AXE.get(), EPItems.ALUMINUM_BRONZE_PICKAXE.get(),
                    EPItems.ALUMINUM_BRONZE_SWORD.get(), EPItems.ALUMINUM_BRONZE_DAGGER.get(), EPItems.ALUMINUM_BRONZE_SHOVEL.get(),
                    EPItems.ALUMINUM_BRONZE_HOE.get(), EPItems.ALUMINUM_BRONZE_POLISHER.get(), consumer);

            addCustomHandleGear(EPItems.BRONZE_INGOT.get(), EPItems.PURPLE_GOLD_ROD.get(), EPItems.PURPLE_GOLD_BRONZE_AXE.get(), EPItems.PURPLE_GOLD_BRONZE_PICKAXE.get(),
                    EPItems.PURPLE_GOLD_BRONZE_SWORD.get(), EPItems.PURPLE_GOLD_BRONZE_DAGGER.get(), EPItems.PURPLE_GOLD_BRONZE_SHOVEL.get(),
                    EPItems.PURPLE_GOLD_BRONZE_HOE.get(), EPItems.PURPLE_GOLD_BRONZE_POLISHER.get(), consumer);

            //Rose gold
            materialRecipes(EPItems.ROSE_GOLD_INGOT.get(), EPItems.ROSE_GOLD_NUGGET.get(), EPBlocks.ROSE_GOLD_BLOCK.get(), consumer);

            //Iron
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, EPItems.IRON_POLISHER.get())
                    .pattern(" I")
                    .pattern("# ")
                    .define('I', Items.IRON_INGOT)
                    .define('#', Tags.Items.RODS_WOODEN)
                    .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, EPItems.IRON_DAGGER.get())
                    .pattern("I")
                    .pattern("#")
                    .define('I', Items.IRON_INGOT)
                    .define('#', Tags.Items.RODS_WOODEN)
                    .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                    .unlockedBy(getHasName(EPItems.IRON_DAGGER.get()), has(EPItems.IRON_DAGGER.get()))
                    .save(consumer);

            addArmor(Items.IRON_INGOT, Items.IRON_HELMET, Items.IRON_CHESTPLATE, Items.IRON_LEGGINGS, Items.IRON_BOOTS, consumer);


            addCustomHandleGear(Items.IRON_INGOT, EPItems.REINFORCED_STICK.get(), EPItems.REINFORCED_IRON_AXE.get(), EPItems.REINFORCED_IRON_PICKAXE.get(),
                    EPItems.REINFORCED_IRON_SWORD.get(), EPItems.REINFORCED_IRON_DAGGER.get(), EPItems.REINFORCED_IRON_SHOVEL.get(),
                    EPItems.REINFORCED_IRON_HOE.get(), EPItems.REINFORCED_IRON_POLISHER.get(), consumer);

            addCustomHandleGear(Items.IRON_INGOT, EPItems.ALUMINUM_ROD.get(), EPItems.ALUMINUM_IRON_AXE.get(), EPItems.ALUMINUM_IRON_PICKAXE.get(),
                    EPItems.ALUMINUM_IRON_SWORD.get(), EPItems.ALUMINUM_IRON_DAGGER.get(), EPItems.ALUMINUM_IRON_SHOVEL.get(),
                    EPItems.ALUMINUM_IRON_HOE.get(), EPItems.ALUMINUM_IRON_POLISHER.get(), consumer);

            addCustomHandleGear(Items.IRON_INGOT, EPItems.PURPLE_GOLD_ROD.get(), EPItems.PURPLE_GOLD_IRON_AXE.get(), EPItems.PURPLE_GOLD_IRON_PICKAXE.get(),
                    EPItems.PURPLE_GOLD_IRON_SWORD.get(), EPItems.PURPLE_GOLD_IRON_DAGGER.get(), EPItems.PURPLE_GOLD_IRON_SHOVEL.get(),
                    EPItems.PURPLE_GOLD_IRON_HOE.get(), EPItems.PURPLE_GOLD_IRON_POLISHER.get(), consumer);

            //Green gold
            materialRecipes(EPItems.GREEN_GOLD_INGOT.get(), EPItems.GREEN_GOLD_NUGGET.get(), EPBlocks.GREEN_GOLD_BLOCK.get(), consumer);

            //Steel
            materialRecipes(EPItems.STEEL_INGOT.get(), EPItems.STEEL_NUGGET.get(), EPBlocks.STEEL_BLOCK.get(), consumer);

            addGear(EPItems.STEEL_INGOT.get(), EPItems.STEEL_AXE.get(), EPItems.STEEL_PICKAXE.get(), EPItems.STEEL_SWORD.get(),
                    EPItems.STEEL_DAGGER.get(), EPItems.STEEL_SHOVEL.get(), EPItems.STEEL_HOE.get(), EPItems.STEEL_POLISHER.get(),
                    EPItems.STEEL_HELMET.get(), EPItems.STEEL_CHESTPLATE.get(), EPItems.STEEL_LEGGINGS.get(), EPItems.STEEL_BOOTS.get(),
                    consumer);


            addCustomHandleGear(EPItems.STEEL_INGOT.get(), EPItems.REINFORCED_STICK.get(), EPItems.REINFORCED_STEEL_AXE.get(), EPItems.REINFORCED_STEEL_PICKAXE.get(),
                    EPItems.REINFORCED_STEEL_SWORD.get(), EPItems.REINFORCED_STEEL_DAGGER.get(), EPItems.REINFORCED_STEEL_SHOVEL.get(),
                    EPItems.REINFORCED_STEEL_HOE.get(), EPItems.REINFORCED_STEEL_POLISHER.get(), consumer);

            addCustomHandleGear(EPItems.STEEL_INGOT.get(), EPItems.ALUMINUM_ROD.get(), EPItems.ALUMINUM_STEEL_AXE.get(), EPItems.ALUMINUM_STEEL_PICKAXE.get(),
                    EPItems.ALUMINUM_STEEL_SWORD.get(), EPItems.ALUMINUM_STEEL_DAGGER.get(), EPItems.ALUMINUM_STEEL_SHOVEL.get(),
                    EPItems.ALUMINUM_STEEL_HOE.get(), EPItems.ALUMINUM_STEEL_POLISHER.get(), consumer);

            addCustomHandleGear(EPItems.STEEL_INGOT.get(), EPItems.PURPLE_GOLD_ROD.get(), EPItems.PURPLE_GOLD_STEEL_AXE.get(), EPItems.PURPLE_GOLD_STEEL_PICKAXE.get(),
                    EPItems.PURPLE_GOLD_STEEL_SWORD.get(), EPItems.PURPLE_GOLD_STEEL_DAGGER.get(), EPItems.PURPLE_GOLD_STEEL_SHOVEL.get(),
                    EPItems.PURPLE_GOLD_STEEL_HOE.get(), EPItems.PURPLE_GOLD_STEEL_POLISHER.get(), consumer);

            //Blue gold
            materialRecipes(EPItems.BLUE_GOLD_INGOT.get(), EPItems.BLUE_GOLD_NUGGET.get(), EPBlocks.BLUE_GOLD_BLOCK.get(), consumer);

            //Purple gold
            materialRecipes(EPItems.PURPLE_GOLD_INGOT.get(), EPItems.PURPLE_GOLD_NUGGET.get(), EPBlocks.PURPLE_GOLD_BLOCK.get(), consumer);

            //Diamond
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, EPItems.DIAMOND_POLISHER.get())
                    .pattern(" I")
                    .pattern("# ")
                    .define('I', Items.DIAMOND)
                    .define('#', Tags.Items.RODS_WOODEN)
                    .unlockedBy(getHasName(Items.DIAMOND), has(Items.DIAMOND))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, EPItems.DIAMOND_DAGGER.get())
                    .pattern("I")
                    .pattern("#")
                    .define('I', Items.DIAMOND)
                    .define('#', Tags.Items.RODS_WOODEN)
                    .unlockedBy(getHasName(Items.DIAMOND), has(Items.DIAMOND))
                    .unlockedBy(getHasName(EPItems.DIAMOND_DAGGER.get()), has(EPItems.DIAMOND_DAGGER.get()))
                    .save(consumer);

            addArmor(Items.DIAMOND, Items.DIAMOND_HELMET, Items.DIAMOND_CHESTPLATE, Items.DIAMOND_LEGGINGS, Items.DIAMOND_BOOTS, consumer);

            addCustomHandleGear(Items.DIAMOND, EPItems.REINFORCED_STICK.get(), EPItems.REINFORCED_DIAMOND_AXE.get(), EPItems.REINFORCED_DIAMOND_PICKAXE.get(),
                    EPItems.REINFORCED_DIAMOND_SWORD.get(), EPItems.REINFORCED_DIAMOND_DAGGER.get(), EPItems.REINFORCED_DIAMOND_SHOVEL.get(),
                    EPItems.REINFORCED_DIAMOND_HOE.get(), EPItems.REINFORCED_DIAMOND_POLISHER.get(), consumer);

            addCustomHandleGear(Items.DIAMOND, EPItems.ALUMINUM_ROD.get(), EPItems.ALUMINUM_DIAMOND_AXE.get(), EPItems.ALUMINUM_DIAMOND_PICKAXE.get(),
                    EPItems.ALUMINUM_DIAMOND_SWORD.get(), EPItems.ALUMINUM_DIAMOND_DAGGER.get(), EPItems.ALUMINUM_DIAMOND_SHOVEL.get(),
                    EPItems.ALUMINUM_DIAMOND_HOE.get(), EPItems.ALUMINUM_DIAMOND_POLISHER.get(), consumer);

            addCustomHandleGear(Items.DIAMOND, EPItems.PURPLE_GOLD_ROD.get(), EPItems.PURPLE_GOLD_DIAMOND_AXE.get(), EPItems.PURPLE_GOLD_DIAMOND_PICKAXE.get(),
                    EPItems.PURPLE_GOLD_DIAMOND_SWORD.get(), EPItems.PURPLE_GOLD_DIAMOND_DAGGER.get(), EPItems.PURPLE_GOLD_DIAMOND_SHOVEL.get(),
                    EPItems.PURPLE_GOLD_DIAMOND_HOE.get(), EPItems.PURPLE_GOLD_DIAMOND_POLISHER.get(), consumer);

        //New vanilla recipes
            //Food
            ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, Items.BREAD, 3)
                    .requires(EPItems.WHEAT_FLOUR.get(), 2)
                    .requires(EPItems.YEAST.get())
                    .unlockedBy(getHasName(EPItems.WHEAT_FLOUR.get()), has(EPItems.WHEAT_FLOUR.get()))
                    .unlockedBy(getHasName(Items.WHEAT), has(Items.WHEAT))
                    .save(consumer);

            ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, Items.COOKIE, 8)
                    .requires(EPItems.WHEAT_FLOUR.get(), 2)
                    .requires(Items.COCOA_BEANS, 2)
                    .requires(EPItems.YEAST.get())
                    .unlockedBy(getHasName(EPItems.WHEAT_FLOUR.get()), has(EPItems.WHEAT_FLOUR.get()))
                    .unlockedBy(getHasName(Items.WHEAT), has(Items.WHEAT))
                    .unlockedBy(getHasName(Items.COCOA_BEANS), has(Items.COCOA_BEANS))
                    .save(consumer);

            ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, Items.PUMPKIN_PIE)
                    .requires(EPItems.PUMPKIN_FLOUR.get(), 2)
                    .requires(EPItems.YEAST.get())
                    .unlockedBy(getHasName(EPItems.PUMPKIN_FLOUR.get()), has(EPItems.PUMPKIN_FLOUR.get()))
                    .unlockedBy(getHasName(Items.PUMPKIN), has(Items.PUMPKIN))
                    .save(consumer);

            //Redstone
            ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, Items.REPEATER)
                    .pattern("W W")
                    .pattern("R#R")
                    .pattern("III")
                    .define('W', Items.REDSTONE_TORCH)
                    .define('R', Items.REDSTONE)
                    .define('#', EPItems.CALIBRATED_QUARTZ.get())
                    .define('I', Blocks.STONE)
                    .unlockedBy(getHasName(Items.REDSTONE), has(Items.REDSTONE))
                    .unlockedBy(getHasName(Items.REPEATER), has(Items.REPEATER))
                    .save(consumer);

            ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, Items.COMPARATOR)
                    .pattern("WWW")
                    .pattern("AFA")
                    .pattern("III")
                    .define('W', Items.REDSTONE_TORCH)
                    .define('F', EPItems.CALIBRATED_QUARTZ.get())
                    .define('A', Items.REDSTONE)
                    .define('I', Blocks.STONE)
                    .unlockedBy(getHasName(Items.COMPARATOR), has(Items.COMPARATOR))
                    .unlockedBy(getHasName(Items.REDSTONE), has(Items.REDSTONE))
                    .save(consumer);

            ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, Blocks.OBSERVER)
                    .pattern("CCC")
                    .pattern("RRQ")
                    .pattern("CCC")
                    .define('C', Blocks.COBBLESTONE)
                    .define('R', Items.REDSTONE)
                    .define('Q', EPItems.CALIBRATED_QUARTZ.get())
                    .unlockedBy(getHasName(Items.REDSTONE), has(Items.REDSTONE))
                    .unlockedBy(getHasName(Blocks.OBSERVER), has(Blocks.OBSERVER))
                    .save(consumer);

            ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, Blocks.DAYLIGHT_DETECTOR)
                    .pattern("GGG")
                    .pattern("QQQ")
                    .pattern("SSS")
                    .define('G', Blocks.GLASS)
                    .define('Q', EPItems.CALIBRATED_QUARTZ.get())
                    .define('S', ItemTags.WOODEN_SLABS)
                    .unlockedBy(getHasName(Items.REDSTONE), has(Items.REDSTONE))
                    .unlockedBy(getHasName(EPItems.CALIBRATED_QUARTZ.get()), has(EPItems.CALIBRATED_QUARTZ.get()))
                    .unlockedBy(getHasName(Blocks.DAYLIGHT_DETECTOR), has(Blocks.DAYLIGHT_DETECTOR))
                    .save(consumer);

            //Items
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.FLINT_AND_STEEL)
                    .pattern("S ")
                    .pattern(" F")
                    .define('S', EPItems.STEEL_INGOT.get())
                    .define('F', Items.FLINT)
                    .unlockedBy(getHasName(EPItems.STEEL_INGOT.get()), has(EPItems.STEEL_INGOT.get()))
                    .unlockedBy(getHasName(Items.FLINT), has(Items.FLINT))
                    .save(consumer);

            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.SADDLE)
                    .pattern(" C ")
                    .pattern("CIC")
                    .define('C', Items.LEATHER)
                    .define('I', Items.IRON_INGOT)
                    .unlockedBy(getHasName(Items.LEATHER), has(Items.LEATHER))
                    .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                    .unlockedBy(getHasName(Items.SADDLE), has(Items.SADDLE))
                    .save(consumer);

            ShapelessRecipeBuilder.shapeless(RecipeCategory.BREWING, Items.GUNPOWDER)
                    .requires(EPItems.SULFUR.get())
                    .requires(Items.CHARCOAL)
                    .unlockedBy(getHasName(EPItems.SULFUR.get()), has(EPItems.SULFUR.get()))
                    .unlockedBy(getHasName(Items.CHARCOAL), has(Items.CHARCOAL))
                    .save(consumer);

            ShapelessRecipeBuilder.shapeless(RecipeCategory.BREWING, Items.BONE_MEAL, 3)
                    .requires(Items.BONE, 3)
                    .unlockedBy(getHasName(Items.BONE), has(Items.BONE))
                    .unlockedBy(getHasName(Items.BONE_MEAL), has(Items.BONE_MEAL))
                    .unlockedBy(getHasName(Items.BONE_BLOCK), has(Items.BONE_BLOCK))
                    .save(consumer);

            //New boat recipes
            newBoatRecipe(Blocks.OAK_PLANKS, Items.OAK_BOAT, consumer);
            newBoatRecipe(Blocks.BIRCH_PLANKS, Items.BIRCH_BOAT, consumer);
            newBoatRecipe(Blocks.SPRUCE_PLANKS, Items.SPRUCE_BOAT, consumer);
            newBoatRecipe(Blocks.ACACIA_PLANKS, Items.ACACIA_BOAT, consumer);
            newBoatRecipe(Blocks.MANGROVE_PLANKS, Items.MANGROVE_BOAT, consumer);
            newBoatRecipe(Blocks.CHERRY_PLANKS, Items.CHERRY_BOAT, consumer);
            newBoatRecipe(Blocks.JUNGLE_PLANKS, Items.JUNGLE_BOAT, consumer);
            newBoatRecipe(Blocks.DARK_OAK_PLANKS, Items.DARK_OAK_BOAT, consumer);


            //Blocks
                //Terracotta
                terracottaFromShardsRecipe(Blocks.TERRACOTTA, EPItems.TERRACOTTA_SHARD.get(), consumer);
                terracottaFromShardsRecipe(Blocks.WHITE_TERRACOTTA, EPItems.WHITE_TERRACOTTA_SHARD.get(), consumer);
                terracottaFromShardsRecipe(Blocks.ORANGE_TERRACOTTA, EPItems.ORANGE_TERRACOTTA_SHARD.get(), consumer);
                terracottaFromShardsRecipe(Blocks.MAGENTA_TERRACOTTA, EPItems.MAGENTA_TERRACOTTA_SHARD.get(), consumer);
                terracottaFromShardsRecipe(Blocks.LIGHT_BLUE_TERRACOTTA, EPItems.LIGHT_BLUE_TERRACOTTA_SHARD.get(), consumer);
                terracottaFromShardsRecipe(Blocks.YELLOW_TERRACOTTA, EPItems.YELLOW_TERRACOTTA_SHARD.get(), consumer);
                terracottaFromShardsRecipe(Blocks.LIME_TERRACOTTA, EPItems.LIME_TERRACOTTA_SHARD.get(), consumer);
                terracottaFromShardsRecipe(Blocks.PINK_TERRACOTTA, EPItems.PINK_TERRACOTTA_SHARD.get(), consumer);
                terracottaFromShardsRecipe(Blocks.GRAY_TERRACOTTA, EPItems.GRAY_TERRACOTTA_SHARD.get(), consumer);
                terracottaFromShardsRecipe(Blocks.LIGHT_GRAY_TERRACOTTA, EPItems.LIGHT_GRAY_TERRACOTTA_SHARD.get(), consumer);
                terracottaFromShardsRecipe(Blocks.CYAN_TERRACOTTA, EPItems.CYAN_TERRACOTTA_SHARD.get(), consumer);
                terracottaFromShardsRecipe(Blocks.PURPLE_TERRACOTTA, EPItems.PURPLE_TERRACOTTA_SHARD.get(), consumer);
                terracottaFromShardsRecipe(Blocks.BLUE_TERRACOTTA, EPItems.BLUE_TERRACOTTA_SHARD.get(), consumer);
                terracottaFromShardsRecipe(Blocks.BROWN_TERRACOTTA, EPItems.BROWN_TERRACOTTA_SHARD.get(), consumer);
                terracottaFromShardsRecipe(Blocks.GREEN_TERRACOTTA, EPItems.GREEN_TERRACOTTA_SHARD.get(), consumer);
                terracottaFromShardsRecipe(Blocks.RED_TERRACOTTA, EPItems.RED_TERRACOTTA_SHARD.get(), consumer);
                terracottaFromShardsRecipe(Blocks.BLACK_TERRACOTTA, EPItems.BLACK_TERRACOTTA_SHARD.get(), consumer);

            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.COBBLESTONE)
                    .pattern("CC")
                    .pattern("CC")
                    .define('C', EPItems.COBBLE.get())
                    .unlockedBy(getHasName(EPItems.COBBLE.get()), has(EPItems.COBBLE.get()))
                    .save(consumer);

            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.NETHERRACK)
                    .pattern("NN")
                    .pattern("NN")
                    .define('N', EPItems.NETHERRACK_RUBBLE.get())
                    .unlockedBy(getHasName(EPItems.NETHERRACK_RUBBLE.get()), has(EPItems.NETHERRACK_RUBBLE.get()))
                    .save(consumer);

            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.BLACKSTONE)
                    .pattern("CC")
                    .pattern("CC")
                    .define('C', EPItems.BLACKSTONE_COBBLE.get())
                    .unlockedBy(getHasName(EPItems.BLACKSTONE_COBBLE.get()), has(EPItems.BLACKSTONE_COBBLE.get()))
                    .save(consumer);

            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.COBBLED_DEEPSLATE)
                    .pattern("CC")
                    .pattern("CC")
                    .define('C', EPItems.DEEPSLATE_COBBLE.get())
                    .unlockedBy(getHasName(EPItems.DEEPSLATE_COBBLE.get()), has(EPItems.DEEPSLATE_COBBLE.get()))
                    .save(consumer);

            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.STONE_BRICKS, 4)
                    .pattern("AA")
                    .pattern("AA")
                    .define('A', EPBlocks.POLISHED_STONE.get())
                    .unlockedBy(getHasName(EPBlocks.POLISHED_STONE.get()), has(EPBlocks.POLISHED_STONE.get()))
                    .save(consumer);

            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.MUD, 2)
                    .pattern("#A")
                    .pattern("A#")
                    .define('#', Blocks.DIRT)
                    .define('A', Items.CLAY_BALL)
                    .unlockedBy(getHasName(Blocks.DIRT), has(Blocks.DIRT))
                    .unlockedBy(getHasName(Items.CLAY_BALL), has(Items.CLAY_BALL))
                    .save(consumer);

            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.MUD_BRICKS, 1)
                    .pattern("BB")
                    .pattern("BB")
                    .define('B', EPItems.MUD_BRICK.get())
                    .unlockedBy(getHasName(Items.PACKED_MUD), has(Items.PACKED_MUD))
                    .unlockedBy(getHasName(EPItems.MUD_BRICK.get()), has(EPItems.MUD_BRICK.get()))
                    .save(consumer);

            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Blocks.BLAST_FURNACE)
                    .pattern("III")
                    .pattern("IFI")
                    .pattern("###")
                    .define('I', EPItems.STEEL_INGOT.get())
                    .define('F', Blocks.FURNACE)
                    .define('#', Blocks.SMOOTH_STONE)
                    .unlockedBy(getHasName(Blocks.FURNACE), has(Blocks.FURNACE))
                    .save(consumer);

            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Blocks.FURNACE)
                    .pattern("III")
                    .pattern("#F#")
                    .pattern("###")
                    .define('I', EPItems.BRONZE_INGOT.get())
                    .define('F', EPBlocks.ADOBE_FURNACE.get())
                    .define('#', Blocks.COBBLESTONE)
                    .unlockedBy(getHasName(Blocks.FURNACE), has(Blocks.FURNACE))
                    .save(consumer);
    }

    //Helper methods
    @SuppressWarnings("removal")
    protected static ResourceLocation recipeName(ItemLike output, String from){
        return new ResourceLocation(EnhancedPlaythrough.MOD_ID, getItemName(output) + "_" + from);
    }

    protected static void materialRecipes(ItemLike pIngot, @Nullable ItemLike pNugget, Block pBlock, Consumer<FinishedRecipe> pConsumer){
        if (pNugget != null){
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, pIngot)
                    .pattern("NNN")
                    .pattern("NNN")
                    .pattern("NNN")
                    .define('N', pNugget)
                    .unlockedBy(getHasName(pNugget), has(pNugget))
                    .unlockedBy(getHasName(pIngot), has(pIngot))
                    .group(getItemName(pIngot))
                    .save(pConsumer, recipeName(pIngot, "from_nuggets"));

            ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, pNugget, 9)
                    .requires(pIngot)
                    .unlockedBy(getHasName(pIngot), has(pIngot))
                    .save(pConsumer);
        }

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, pIngot, 9)
                .requires(pBlock)
                .group(getItemName(pIngot))
                .unlockedBy(getHasName(pIngot), has(pIngot))
                .save(pConsumer, recipeName(pIngot, "from_block"));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, pBlock)
                .pattern("NNN")
                .pattern("NNN")
                .pattern("NNN")
                .define('N', pIngot)
                .unlockedBy(getHasName(pIngot), has(pIngot))
                .unlockedBy(getHasName(pBlock), has(pBlock))
                .save(pConsumer);
    }

    protected static InventoryChangeTrigger.TriggerInstance HAS_ROTTEN_FOOD(){
        return InventoryChangeTrigger.TriggerInstance.hasItems(EPItems.ROTTEN_TOMATO.get(),
                EPItems.ROTTEN_ZAPALLO.get(), EPItems.ROTTEN_EGGPLANT.get(), EPItems.ROTTEN_CORN.get(),
                EPItems.ROTTEN_CARROT.get(), Items.POISONOUS_POTATO);
    }

    protected static void materialRecipes(ItemLike pIngot, Block pBlock, Consumer<FinishedRecipe> pConsumer){
        materialRecipes(pIngot, null, pBlock, pConsumer);
    }

    protected static void woodRecipes(Block log, Block strippedLog, Block wood, Block strippedWood, Block plank,
                                      Block door, Block trapdoor, Block stairs, Block slab, Block fence, Block fenceGate,
                                      ItemLike sign, ItemLike hangingSign, ItemLike boat, ItemLike chestBoat, Block button, Block pressurePlate,
                                      TagKey<Item> blockTag, Consumer<FinishedRecipe> consumer){

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, wood, 3)
                .pattern("AA")
                .pattern("AA")
                .define('A', log)
                .unlockedBy(getHasName(log), has(log))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, strippedWood, 3)
                .pattern("AA")
                .pattern("AA")
                .define('A', strippedLog)
                .unlockedBy(getHasName(strippedLog), has(strippedLog))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, plank, 4)
                .requires(blockTag)
                .unlockedBy("has_log_or_wood", has(blockTag))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, door, 3)
                .pattern("AA")
                .pattern("AA")
                .pattern("AA")
                .define('A', plank)
                .unlockedBy(getHasName(plank), has(plank))
                .unlockedBy(getHasName(door), has(door))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, trapdoor, 2)
                .pattern("AAA")
                .pattern("AAA")
                .define('A', plank)
                .unlockedBy(getHasName(plank), has(plank))
                .unlockedBy(getHasName(trapdoor), has(trapdoor))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, button)
                .requires(plank)
                .unlockedBy(getHasName(plank), has(plank))
                .unlockedBy(getHasName(button), has(button))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, pressurePlate)
                .pattern("AA")
                .define('A', plank)
                .unlockedBy(getHasName(plank), has(plank))
                .unlockedBy(getHasName(pressurePlate), has(pressurePlate))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, slab, 6)
                .pattern("AAA")
                .define('A', plank)
                .unlockedBy(getHasName(plank), has(plank))
                .unlockedBy(getHasName(slab), has(slab))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, stairs, 4)
                .pattern("A  ")
                .pattern("AA ")
                .pattern("AAA")
                .define('A', plank)
                .unlockedBy(getHasName(plank), has(plank))
                .unlockedBy(getHasName(stairs), has(stairs))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, fence, 3)
                .pattern("ABA")
                .pattern("ABA")
                .define('A', plank)
                .define('B', Tags.Items.RODS_WOODEN)
                .unlockedBy(getHasName(plank), has(plank))
                .unlockedBy(getHasName(fence), has(fence))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, fenceGate)
                .pattern("BAB")
                .pattern("BAB")
                .define('A', plank)
                .define('B', Tags.Items.RODS_WOODEN)
                .unlockedBy(getHasName(plank), has(plank))
                .unlockedBy(getHasName(fenceGate), has(fenceGate))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, sign, 3)
                .pattern("AAA")
                .pattern("AAA")
                .pattern(" Z ")
                .define('A', plank)
                .define('Z', Tags.Items.RODS_WOODEN)
                .unlockedBy(getHasName(plank), has(plank))
                .unlockedBy(getHasName(sign), has(sign))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, hangingSign, 6)
                .pattern("Z Z")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', strippedLog)
                .define('Z', Items.CHAIN)
                .unlockedBy(getHasName(strippedLog), has(strippedLog))
                .unlockedBy(getHasName(hangingSign), has(hangingSign))
                .unlockedBy(getHasName(Items.CHAIN), has(Items.CHAIN))
                .save(consumer);

        newBoatRecipe(plank, boat, consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, chestBoat, 1)
                .requires(Blocks.CHEST)
                .requires(boat)
                .unlockedBy(getHasName(chestBoat), has(chestBoat))
                .unlockedBy(getHasName(Blocks.CHEST), has(Blocks.CHEST))
                .unlockedBy(getHasName(plank), has(plank))
                .save(consumer);
    }

    protected static void newBoatRecipe(Block plank, ItemLike boat, Consumer<FinishedRecipe> consumer){
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, boat, 1)
                .pattern("ABA")
                .pattern("AAA")
                .define('A', plank)
                .define('B', Items.WOODEN_SHOVEL)
                .unlockedBy("in_water", EnterBlockTrigger.TriggerInstance.entersBlock(Blocks.WATER))
                .unlockedBy(getHasName(boat), has(boat))
                .unlockedBy(getHasName(plank), has(plank))
                .save(consumer);
    }

    private static void baseAddRock(Block baseBlock, @Nullable Block polishedBlock, Block wallBlock, Block stairBlock, Block slabBlock, Consumer<FinishedRecipe> consumer){
        if (polishedBlock != null){
            wallBlockRecipe(polishedBlock, wallBlock, consumer);
            stairBlockRecipe(polishedBlock, stairBlock, consumer);
            slabBlockRecipe(polishedBlock, slabBlock, consumer);

            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, polishedBlock, 4)
                    .pattern("##")
                    .pattern("##")
                    .define('#', baseBlock)
                    .group(getItemName(polishedBlock))
                    .unlockedBy(getHasName(baseBlock), has(baseBlock))
                    .unlockedBy(getHasName(polishedBlock), has(polishedBlock))
                    .save(consumer);
        } else if (wallBlock != null){
            wallBlockRecipe(baseBlock, wallBlock, consumer);
        } else {
            stairBlockRecipe(baseBlock, stairBlock, consumer);
            slabBlockRecipe(baseBlock, slabBlock, consumer);
        }
    }

    public static void terracottaFromShardsRecipe(Block terracottaBlock, ItemLike terracottaShard, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, terracottaBlock)
                .pattern("##")
                .pattern("##")
                .define('#', terracottaShard)
                .unlockedBy(getHasName(terracottaShard), has(terracottaShard))
                .save(consumer);
    }

    protected static void blockWithPolishedVersionRecipes(Block baseBlock, Block polishedBlock, Block wallBlock, Block stairBlock, Block slabBlock, Consumer<FinishedRecipe> consumer){
        baseAddRock(baseBlock, polishedBlock,  wallBlock, stairBlock, slabBlock, consumer);
    }

    protected static void blockWithoutPolishedVersionRecipes(Block baseBlock, Block wallBlock, Block stairBlock, Block slabBlock, Consumer<FinishedRecipe> consumer){
        wallBlockRecipe(baseBlock, wallBlock, consumer);
        stairBlockRecipe(baseBlock, stairBlock, consumer);
        slabBlockRecipe(baseBlock, slabBlock, consumer);
    }

    private static void wallBlockRecipe(Block baseBlock, Block wallBlock, Consumer<FinishedRecipe> consumer){
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, wallBlock, 6)
                .pattern("###")
                .pattern("###")
                .define('#', baseBlock)
                .group(getItemName(wallBlock))
                .unlockedBy(getHasName(baseBlock), has(baseBlock))
                .unlockedBy(getHasName(wallBlock), has(wallBlock))
                .save(consumer);
    }

    private static void stairBlockRecipe(Block baseBlock, Block stairBlock, Consumer<FinishedRecipe> consumer){
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, stairBlock, 4)
                .pattern("#  ")
                .pattern("## ")
                .pattern("###")
                .define('#', baseBlock)
                .group(getItemName(stairBlock))
                .unlockedBy(getHasName(baseBlock), has(baseBlock))
                .unlockedBy(getHasName(stairBlock), has(stairBlock))
                .save(consumer);
    }

    private static void slabBlockRecipe(Block pBlock, Block slabBlock, Consumer<FinishedRecipe> consumer){
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, slabBlock, 6)
                .pattern("###")
                .define('#', pBlock)
                .group(getItemName(slabBlock))
                .unlockedBy(getHasName(pBlock), has(pBlock))
                .unlockedBy(getHasName(slabBlock), has(slabBlock))
                .save(consumer);
    }

    protected static void addArmor(ItemLike pMaterial, ItemLike pHelmet, ItemLike pChestplate, ItemLike pLeggings, ItemLike pBoots, Consumer<FinishedRecipe> pConsumer){
        if (pMaterial == Items.LEATHER){
            throw new RuntimeException("Leather can't be used to reinforce leather armor");
        }

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, pHelmet)
                .pattern("###")
                .pattern("#L#")
                .define('#', pMaterial)
                .define('L', Items.LEATHER_HELMET)
                .unlockedBy(getHasName(pMaterial), has(pMaterial))
                .unlockedBy(getHasName(pHelmet), has(pHelmet))
                .save(pConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, pChestplate)
                .pattern("# #")
                .pattern("#L#")
                .pattern(" # ")
                .define('#', pMaterial)
                .define('L', Items.LEATHER_CHESTPLATE)
                .unlockedBy(getHasName(pMaterial), has(pMaterial))
                .unlockedBy(getHasName(pChestplate), has(pChestplate))
                .save(pConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, pLeggings)
                .pattern("###")
                .pattern("#L#")
                .pattern("# #")
                .define('#', pMaterial)
                .define('L', Items.LEATHER_LEGGINGS)
                .unlockedBy(getHasName(pMaterial), has(pMaterial))
                .unlockedBy(getHasName(pLeggings), has(pLeggings))
                .save(pConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, pBoots)
                .pattern("# #")
                .pattern("#L#")
                .define('#', pMaterial)
                .define('L', Items.LEATHER_BOOTS)
                .unlockedBy(getHasName(pMaterial), has(pMaterial))
                .unlockedBy(getHasName(pBoots), has(pBoots))
                .save(pConsumer);
    }

    protected static void addGear(ItemLike pIngot, ItemLike pAxe, ItemLike pPickaxe, ItemLike pSword, ItemLike pDagger, ItemLike pShovel,
                                  ItemLike pHoe, ItemLike pPolisher,
                                  @Nullable ItemLike pHelmet, @Nullable ItemLike pChestplate, @Nullable ItemLike pLeggings, @Nullable ItemLike pBoots,
                                  Consumer<FinishedRecipe> pConsumer){
        //Armor
        if (pHelmet != null && pChestplate != null && pLeggings != null && pBoots != null){
            addArmor(pIngot, pHelmet, pChestplate, pLeggings, pBoots, pConsumer);
        } else if (pHelmet != null || pChestplate != null || pLeggings != null){
            throw new RuntimeException("The four armour pieces have to be null at the same time!");
        }

        //Tools
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, pSword)
                .pattern("I")
                .pattern("I")
                .pattern("#")
                .define('I', pIngot)
                .define('#', Tags.Items.RODS_WOODEN)
                .unlockedBy(getHasName(pIngot), has(pIngot))
                .unlockedBy(getHasName(pSword), has(pSword))
                .save(pConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, pDagger)
                .pattern("I")
                .pattern("#")
                .define('I', pIngot)
                .define('#', Tags.Items.RODS_WOODEN)
                .unlockedBy(getHasName(pIngot), has(pIngot))
                .unlockedBy(getHasName(pDagger), has(pDagger))
                .save(pConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, pPickaxe)
                .pattern("III")
                .pattern(" # ")
                .pattern(" # ")
                .define('I', pIngot)
                .define('#', Tags.Items.RODS_WOODEN)
                .unlockedBy(getHasName(pIngot), has(pIngot))
                .unlockedBy(getHasName(pPickaxe), has(pPickaxe))
                .save(pConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, pAxe)
                .pattern("II")
                .pattern("I#")
                .pattern(" #")
                .define('I', pIngot)
                .define('#', Tags.Items.RODS_WOODEN)
                .unlockedBy(getHasName(pIngot), has(pIngot))
                .unlockedBy(getHasName(pAxe), has(pAxe))
                .save(pConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, pShovel)
                .pattern("I")
                .pattern("#")
                .pattern("#")
                .define('I', pIngot)
                .define('#', Tags.Items.RODS_WOODEN)
                .unlockedBy(getHasName(pIngot), has(pIngot))
                .unlockedBy(getHasName(pShovel), has(pShovel))
                .save(pConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, pHoe)
                .pattern("II")
                .pattern(" #")
                .pattern(" #")
                .define('I', pIngot)
                .define('#', Tags.Items.RODS_WOODEN)
                .unlockedBy(getHasName(pIngot), has(pIngot))
                .unlockedBy(getHasName(pHoe), has(pHoe))
                .save(pConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, pPolisher)
                .pattern(" I")
                .pattern("# ")
                .define('I', pIngot)
                .define('#', Tags.Items.RODS_WOODEN)
                .unlockedBy(getHasName(pIngot), has(pIngot))
                .unlockedBy(getHasName(pPolisher), has(pPolisher))
                .save(pConsumer);
    }

    protected static void addCustomHandleGear(ItemLike pIngot, ItemLike pHandle, ItemLike pAxe, ItemLike pPickaxe, ItemLike pSword, ItemLike pDagger, ItemLike pShovel,
                                              ItemLike pHoe, ItemLike pPolisher, Consumer<FinishedRecipe> pConsumer){
        //Tools
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, pSword)
                .pattern("I")
                .pattern("I")
                .pattern("#")
                .define('I', pIngot)
                .define('#', pHandle)
                .unlockedBy("has_tool", has(pSword))
                .unlockedBy("has_handle", has(pHandle))
                //.unlockedBy("has_smithing_template", has(EPItems.ALUMINUM_UPGRADE_SMITHING_TEMPLATE.get()))
                .save(pConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, pDagger)
                .pattern("I")
                .pattern("#")
                .define('I', pIngot)
                .define('#', pHandle)
                .unlockedBy("has_tool", has(pDagger))
                .unlockedBy("has_handle", has(pHandle))
                //.unlockedBy("has_smithing_template", has(EPItems.ALUMINUM_UPGRADE_SMITHING_TEMPLATE.get()))
                .save(pConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, pPickaxe)
                .pattern("III")
                .pattern(" # ")
                .pattern(" # ")
                .define('I', pIngot)
                .define('#', pHandle)
                .unlockedBy("has_tool", has(pPickaxe))
                .unlockedBy("has_handle", has(pHandle))
                //.unlockedBy("has_smithing_template", has(EPItems.ALUMINUM_UPGRADE_SMITHING_TEMPLATE.get()))
                .save(pConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, pAxe)
                .pattern("II")
                .pattern("I#")
                .pattern(" #")
                .define('I', pIngot)
                .define('#', pHandle)
                .unlockedBy("has_tool", has(pAxe))
                .unlockedBy("has_handle", has(pHandle))
                //.unlockedBy("has_smithing_template", has(EPItems.ALUMINUM_UPGRADE_SMITHING_TEMPLATE.get()))
                .save(pConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, pShovel)
                .pattern("I")
                .pattern("#")
                .pattern("#")
                .define('I', pIngot)
                .define('#', pHandle)
                .unlockedBy("has_tool", has(pShovel))
                .unlockedBy("has_handle", has(pHandle))
                //.unlockedBy("has_smithing_template", has(EPItems.ALUMINUM_UPGRADE_SMITHING_TEMPLATE.get()))
                .save(pConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, pHoe)
                .pattern("II")
                .pattern(" #")
                .pattern(" #")
                .define('I', pIngot)
                .define('#', pHandle)
                .unlockedBy("has_tool", has(pHoe))
                .unlockedBy("has_handle", has(pHandle))
                //.unlockedBy("has_smithing_template", has(EPItems.ALUMINUM_UPGRADE_SMITHING_TEMPLATE.get()))
                .save(pConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, pPolisher)
                .pattern(" I")
                .pattern("# ")
                .define('I', pIngot)
                .define('#', pHandle)
                .unlockedBy("has_tool", has(pPolisher))
                .unlockedBy("has_handle", has(pHandle))
                //.unlockedBy("has_smithing_template", has(EPItems.ALUMINUM_UPGRADE_SMITHING_TEMPLATE.get()))
                .save(pConsumer);
    }

    protected static void addStoneGear(Ingredient pHandle, ItemLike pAxe, ItemLike pPickaxe, ItemLike pSword, ItemLike pDagger, ItemLike pShovel,
                                       ItemLike pHoe, ItemLike pPolisher, Consumer<FinishedRecipe> pConsumer){
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, pSword)
                .pattern(" I ")
                .pattern(" IS")
                .pattern(" # ")
                .define('I', EPTags.Items.COBBLE)
                .define('S', Tags.Items.STRING)
                .define('#', pHandle)
                .unlockedBy("has_cobble", has(EPTags.Items.COBBLE))
                .unlockedBy(getHasName(pSword), has(pSword))
                .save(pConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, pPickaxe)
                .pattern("III")
                .pattern(" #S")
                .pattern(" # ")
                .define('I', EPTags.Items.COBBLE)
                .define('S', Tags.Items.STRING)
                .define('#', pHandle)
                .unlockedBy("has_cobble", has(EPTags.Items.COBBLE))
                .unlockedBy(getHasName(pPickaxe), has(pPickaxe))
                .save(pConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, pAxe)
                .pattern("IIS")
                .pattern("I# ")
                .pattern(" # ")
                .define('I', EPTags.Items.COBBLE)
                .define('S', Tags.Items.STRING)
                .define('#', pHandle)
                .unlockedBy("has_cobble", has(EPTags.Items.COBBLE))
                .unlockedBy(getHasName(pAxe), has(pAxe))
                .save(pConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, pShovel)
                .pattern(" I ")
                .pattern(" #S")
                .pattern(" # ")
                .define('I', EPTags.Items.COBBLE)
                .define('S', Tags.Items.STRING)
                .define('#', pHandle)
                .unlockedBy("has_cobble", has(EPTags.Items.COBBLE))
                .unlockedBy(getHasName(pShovel), has(pShovel))
                .save(pConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, pHoe)
                .pattern("IIS")
                .pattern(" # ")
                .pattern(" # ")
                .define('I', EPTags.Items.COBBLE)
                .define('S', Tags.Items.STRING)
                .define('#', pHandle)
                .unlockedBy("has_cobble", has(EPTags.Items.COBBLE))
                .unlockedBy(getHasName(pHoe), has(pHoe))
                .save(pConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, pPolisher)
                .pattern("SI")
                .pattern("# ")
                .define('I', EPTags.Items.COBBLE)
                .define('S', Tags.Items.STRING)
                .define('#', pHandle)
                .unlockedBy("has_cobble", has(EPTags.Items.COBBLE))
                .unlockedBy(getHasName(pPolisher), has(pPolisher))
                .save(pConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, pDagger)
                .pattern("I ")
                .pattern("#S")
                .define('I', EPTags.Items.COBBLE)
                .define('S', Tags.Items.STRING)
                .define('#', pHandle)
                .unlockedBy("has_cobble", has(EPTags.Items.COBBLE))
                .unlockedBy(getHasName(pDagger), has(pDagger))
                .save(pConsumer);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
    }
}
