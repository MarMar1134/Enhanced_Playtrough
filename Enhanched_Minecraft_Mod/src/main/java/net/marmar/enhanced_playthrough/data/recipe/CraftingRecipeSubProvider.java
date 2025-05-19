package net.marmar.enhanced_playthrough.data.recipe;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.block.ModBlocks;
import net.marmar.enhanced_playthrough.data.tag.ModTags;
import net.marmar.enhanced_playthrough.item.ModItems;
import net.minecraft.advancements.critereon.EnterBlockTrigger;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
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

    public static void addCraftingRecipes(Consumer<FinishedRecipe> consumer){
        //Foods
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.EMPTY_MATE.get())
                .pattern("#")
                .pattern("I")
                .define('#', Items.IRON_INGOT)
                .define('I', ModItems.COOKED_ZAPALLO.get())
                .unlockedBy(getHasName(ModItems.COOKED_ZAPALLO.get()), has(ModItems.COOKED_ZAPALLO.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.GROUNDED_YERBA_MATE.get())
                .pattern(" I ")
                .pattern("I I")
                .pattern(" I ")
                .define('I', ModItems.YERBA_MATE.get())
                .unlockedBy(getHasName(ModItems.YERBA_MATE.get()), has(ModItems.YERBA_MATE.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.MATE.get())
                .pattern("I")
                .pattern("A")
                .define('I', ModItems.GROUNDED_YERBA_MATE.get())
                .define('A', ModItems.EMPTY_MATE.get())
                .unlockedBy(getHasName(ModItems.YERBA_MATE.get()), has(ModItems.YERBA_MATE.get()))
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.YEAST.get(), 4)
                .requires(Items.BROWN_MUSHROOM, 2)
                .requires(Items.SUGAR)
                .unlockedBy(getHasName(Items.SUGAR), has(Items.SUGAR))
                .unlockedBy(getHasName(Items.BROWN_MUSHROOM), has(Items.BROWN_MUSHROOM))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.WHEAT_FLOUR.get(), 3)
                .pattern("AAA")
                .define('A', Items.WHEAT)
                .unlockedBy(getHasName(Items.WHEAT), has(Items.WHEAT))
                .unlockedBy(getHasName(ModItems.WHEAT_FLOUR.get()), has(ModItems.WHEAT_FLOUR.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.RICE_BOWL.get())
                .pattern("#I")
                .define('I', Items.BOWL)
                .define('#', ModItems.RICE_GRAINS.get())
                .unlockedBy(getHasName(ModItems.RICE_GRAINS.get()), has(ModItems.RICE_GRAINS.get()))
                .save(consumer);

        //Seeds
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.TOMATO_SEEDS.get(), 2)
                .requires(ModItems.WILD_TOMATO.get())
                .unlockedBy(getHasName(ModItems.WILD_TOMATO.get()), has(ModItems.WILD_TOMATO.get()))
                .unlockedBy(getHasName(ModItems.TOMATO_SEEDS.get()), has(ModItems.TOMATO_SEEDS.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.CORN_SEEDS.get(), 2)
                .requires(ModItems.WILD_CORN.get())
                .unlockedBy(getHasName(ModItems.WILD_CORN.get()), has(ModItems.WILD_CORN.get()))
                .unlockedBy(getHasName(ModItems.CORN_SEEDS.get()), has(ModItems.CORN_SEEDS.get()))
                .save(consumer);

        //Misc
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.MUD_BRICK.get(), 3)
                .requires(Items.DIRT)
                .requires(Items.WHEAT)
                .requires(Items.CLAY_BALL)
                .unlockedBy(getHasName(Items.WHEAT), has(Items.WHEAT))
                .unlockedBy(getHasName(Items.CLAY_BALL), has(Items.CLAY_BALL))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.VEGETABLE_FIBBER.get())
                .requires(ModItems.REED_HEAD.get(), 2)
                .group("vegetable_fiber")
                .unlockedBy(getHasName(ModItems.REED_HEAD.get()), has(ModItems.REED_HEAD.get()))
                .unlockedBy(getHasName(ModItems.VEGETABLE_FIBBER.get()), has(ModItems.VEGETABLE_FIBBER.get()))
                .save(consumer, recipeName(ModItems.VEGETABLE_FIBBER.get(), "from_reed_head"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.VEGETABLE_FIBBER.get())
                .requires(ModItems.WATER_REED_HEAD.get(), 4)
                .group("vegetable_fiber")
                .unlockedBy(getHasName(ModItems.WATER_REED_HEAD.get()), has(ModItems.WATER_REED_HEAD.get()))
                .unlockedBy(getHasName(ModItems.VEGETABLE_FIBBER.get()), has(ModItems.VEGETABLE_FIBBER.get()))
                .save(consumer, recipeName(ModItems.VEGETABLE_FIBBER.get(), "from_water_reed_head"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.COPPER_NUGGET.get(), 9)
                .requires(Items.COPPER_INGOT)
                .unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT))
                .save(consumer, recipeName(ModItems.COPPER_NUGGET.get(), "from_ingots"));


        //Smithing templates
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.BRONZIUM_SMITHING_UPGRADE_TEMPLATE.get(), 2)
                .pattern("DAD")
                .pattern("DVD")
                .pattern("CCC")
                .define('A', ModItems.BRONZIUM_SMITHING_UPGRADE_TEMPLATE.get())
                .define('V', ModItems.BRONZIUM_INGOT.get())
                .define('D', ModItems.ZINC_INGOT.get())
                .define('C', ModItems.TIN_INGOT.get())
                .unlockedBy(getHasName(ModItems.BRONZIUM_SMITHING_UPGRADE_TEMPLATE.get()), has(ModItems.BRONZIUM_SMITHING_UPGRADE_TEMPLATE.get()))
                .save(consumer);

        //Block recipes
            //Wood
                //walnut wood
                woodRecipes(ModBlocks.WALNUT_LOG.get(), ModBlocks.STRIPPED_WALNUT_LOG.get(), ModBlocks.WALNUT_WOOD.get(), ModBlocks.STRIPPED_WALNUT_WOOD.get(),
                        ModBlocks.WALNUT_PLANKS.get(), ModBlocks.WALNUT_DOOR.get(), ModBlocks.WALNUT_TRAPDOOR.get(),
                        ModBlocks.WALNUT_STAIRS.get(), ModBlocks.WALNUT_SLAB.get(), ModBlocks.WALNUT_FENCE.get(), ModBlocks.WALNUT_FENCEGATE.get(),
                        ModItems.WALNUT_SIGN.get(), ModItems.WALNUT_HANGING_SIGN.get(), ModItems.WALNUT_BOAT.get(), ModItems.WALNUT_CHEST_BOAT.get(),
                        ModBlocks.WALNUT_BUTTON.get(), ModBlocks.WALNUT_PRESSURE_PLATE.get(), ModTags.Items.WALNUT_LOGS, consumer);

                //Apple wood
                woodRecipes(ModBlocks.APPLE_LOG.get(), ModBlocks.STRIPPED_APPLE_LOG.get(), ModBlocks.APPLE_WOOD.get(), ModBlocks.STRIPPED_APPLE_WOOD.get(),
                        ModBlocks.APPLE_PLANKS.get(), ModBlocks.APPLE_DOOR.get(), ModBlocks.APPLE_TRAPDOOR.get(),
                        ModBlocks.APPLE_STAIRS.get(), ModBlocks.APPLE_SLAB.get(), ModBlocks.APPLE_FENCE.get(), ModBlocks.APPLE_FENCEGATE.get(),
                        ModItems.APPLE_SIGN.get(), ModItems.APPLE_HANGING_SIGN.get(), ModItems.APPLE_BOAT.get(), ModItems.APPLE_CHEST_BOAT.get(),
                        ModBlocks.APPLE_BUTTON.get(), ModBlocks.APPLE_PRESSURE_PLATE.get(), ModTags.Items.APPLE_LOGS, consumer);

                //Orange wood
                woodRecipes(ModBlocks.ORANGE_LOG.get(), ModBlocks.STRIPPED_ORANGE_LOG.get(), ModBlocks.ORANGE_WOOD.get(), ModBlocks.STRIPPED_ORANGE_WOOD.get(),
                        ModBlocks.ORANGE_PLANKS.get(), ModBlocks.ORANGE_DOOR.get(), ModBlocks.ORANGE_TRAPDOOR.get(),
                        ModBlocks.ORANGE_STAIRS.get(), ModBlocks.ORANGE_SLAB.get(), ModBlocks.ORANGE_FENCE.get(), ModBlocks.ORANGE_FENCEGATE.get(),
                        ModItems.ORANGE_SIGN.get(), ModItems.ORANGE_HANGING_SIGN.get(), ModItems.ORANGE_BOAT.get(), ModItems.ORANGE_CHEST_BOAT.get(),
                        ModBlocks.ORANGE_BUTTON.get(), ModBlocks.ORANGE_PRESSURE_PLATE.get(), ModTags.Items.ORANGE_LOGS, consumer);

                //Lemon wood
                woodRecipes(ModBlocks.LEMON_LOG.get(), ModBlocks.STRIPPED_LEMON_LOG.get(), ModBlocks.LEMON_WOOD.get(), ModBlocks.STRIPPED_LEMON_WOOD.get(),
                        ModBlocks.LEMON_PLANKS.get(), ModBlocks.LEMON_DOOR.get(), ModBlocks.LEMON_TRAPDOOR.get(),
                        ModBlocks.LEMON_STAIRS.get(), ModBlocks.LEMON_SLAB.get(), ModBlocks.LEMON_FENCE.get(), ModBlocks.LEMON_FENCEGATE.get(),
                        ModItems.LEMON_SIGN.get(), ModItems.LEMON_HANGING_SIGN.get(), ModItems.LEMON_BOAT.get(), ModItems.LEMON_CHEST_BOAT.get(),
                        ModBlocks.LEMON_BUTTON.get(), ModBlocks.LEMON_PRESSURE_PLATE.get(), ModTags.Items.LEMON_LOGS, consumer);

            //Stone
            wallBlockRecipe(Blocks.STONE, ModBlocks.STONE_WALL.get(), consumer);

            //Polished diorite, andesite and granite walls
            wallBlockRecipe(Blocks.POLISHED_DIORITE, ModBlocks.POLISHED_DIORITE_WALL.get(), consumer);
            wallBlockRecipe(Blocks.POLISHED_ANDESITE, ModBlocks.POLISHED_ANDESITE_WALL.get(), consumer);
            wallBlockRecipe(Blocks.POLISHED_GRANITE, ModBlocks.POLISHED_GRANITE_WALL.get(), consumer);

            //Dripstone
            blockWithoutPolishedVersionRecipes(Blocks.DRIPSTONE_BLOCK, ModBlocks.DRIPSTONE_WALL.get(), ModBlocks.DRIPSTONE_STAIRS.get(),
                    ModBlocks.DRIPSTONE_SLAB.get(), consumer);

            //Calcite
            blockWithoutPolishedVersionRecipes(Blocks.CALCITE, ModBlocks.CALCITE_WALL.get(), ModBlocks.CALCITE_STAIRS.get(),
                    ModBlocks.CALCITE_SLAB.get(), consumer);

            //Concrete
            blockWithoutWallNorPolished(Blocks.WHITE_CONCRETE, ModBlocks.WHITE_CONCRETE_STAIRS.get(), ModBlocks.WHITE_CONCRETE_SLAB.get(), consumer);
            blockWithoutWallNorPolished(Blocks.LIGHT_GRAY_CONCRETE, ModBlocks.LIGHT_GRAY_CONCRETE_STAIRS.get(), ModBlocks.LIGHT_GRAY_CONCRETE_SLAB.get(), consumer);
            blockWithoutWallNorPolished(Blocks.GRAY_CONCRETE, ModBlocks.GRAY_CONCRETE_STAIRS.get(), ModBlocks.GRAY_CONCRETE_SLAB.get(), consumer);
            blockWithoutWallNorPolished(Blocks.BLACK_CONCRETE, ModBlocks.BLACK_CONCRETE_STAIRS.get(), ModBlocks.BLACK_CONCRETE_SLAB.get(), consumer);
            blockWithoutWallNorPolished(Blocks.BROWN_CONCRETE, ModBlocks.BROWN_CONCRETE_STAIRS.get(), ModBlocks.BROWN_CONCRETE_SLAB.get(), consumer);
            blockWithoutWallNorPolished(Blocks.RED_CONCRETE, ModBlocks.RED_CONCRETE_STAIRS.get(), ModBlocks.RED_CONCRETE_SLAB.get(), consumer);
            blockWithoutWallNorPolished(Blocks.ORANGE_CONCRETE, ModBlocks.ORANGE_CONCRETE_STAIRS.get(), ModBlocks.ORANGE_CONCRETE_SLAB.get(), consumer);
            blockWithoutWallNorPolished(Blocks.YELLOW_CONCRETE, ModBlocks.YELLOW_CONCRETE_STAIRS.get(), ModBlocks.YELLOW_CONCRETE_SLAB.get(), consumer);
            blockWithoutWallNorPolished(Blocks.LIME_CONCRETE, ModBlocks.LIME_CONCRETE_STAIRS.get(), ModBlocks.LIME_CONCRETE_SLAB.get(), consumer);
            blockWithoutWallNorPolished(Blocks.GREEN_CONCRETE, ModBlocks.GREEN_CONCRETE_STAIRS.get(), ModBlocks.GREEN_CONCRETE_SLAB.get(), consumer);
            blockWithoutWallNorPolished(Blocks.CYAN_CONCRETE, ModBlocks.CYAN_CONCRETE_STAIRS.get(), ModBlocks.CYAN_CONCRETE_SLAB.get(), consumer);
            blockWithoutWallNorPolished(Blocks.LIGHT_BLUE_CONCRETE, ModBlocks.LIGHT_BLUE_CONCRETE_STAIRS.get(), ModBlocks.LIGHT_BLUE_CONCRETE_SLAB.get(), consumer);
            blockWithoutWallNorPolished(Blocks.BLUE_CONCRETE, ModBlocks.BLUE_CONCRETE_STAIRS.get(), ModBlocks.BLUE_CONCRETE_SLAB.get(), consumer);
            blockWithoutWallNorPolished(Blocks.PURPLE_CONCRETE, ModBlocks.PURPLE_CONCRETE_STAIRS.get(), ModBlocks.PURPLE_CONCRETE_SLAB.get(), consumer);
            blockWithoutWallNorPolished(Blocks.MAGENTA_CONCRETE, ModBlocks.MAGENTA_CONCRETE_STAIRS.get(), ModBlocks.MAGENTA_CONCRETE_SLAB.get(), consumer);
            blockWithoutWallNorPolished(Blocks.PINK_CONCRETE, ModBlocks.PINK_CONCRETE_STAIRS.get(), ModBlocks.PINK_CONCRETE_SLAB.get(), consumer);

            //Polished stone
            blockWithPolishedVersionRecipes(Blocks.STONE, ModBlocks.POLISHED_STONE.get(), ModBlocks.POLISHED_STONE_WALL.get(), ModBlocks.POLISHED_STONE_STAIRS.get(),
                    ModBlocks.POLISHED_STONE_SLAB.get(), consumer);

            //Cobbled limestone
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COBBLED_LIMESTONE.get())
                    .pattern("LL")
                    .pattern("LL")
                    .define('L', ModItems.LIMESTONE_COBBLE.get())
                    .unlockedBy(getHasName(ModItems.LIMESTONE_COBBLE.get()), has(ModItems.LIMESTONE_COBBLE.get()))
                    .unlockedBy(getHasName(ModBlocks.COBBLED_LIMESTONE.get()), has(ModBlocks.COBBLED_LIMESTONE.get()))
                    .save(consumer);

            blockWithoutPolishedVersionRecipes(ModBlocks.COBBLED_LIMESTONE.get(), ModBlocks.COBBLED_LIMESTONE_WALL.get(), ModBlocks.COBBLED_LIMESTONE_STAIRS.get(),
                    ModBlocks.COBBLED_LIMESTONE_SLAB.get(), consumer);

            //Limestone
            blockWithoutPolishedVersionRecipes(ModBlocks.LIMESTONE.get(), ModBlocks.LIMESTONE_WALL.get(), ModBlocks.LIMESTONE_STAIRS.get(),
                    ModBlocks.LIMESTONE_SLAB.get(), consumer);

            //Polished limestone
            blockWithPolishedVersionRecipes(ModBlocks.LIMESTONE.get(), ModBlocks.POLISHED_LIMESTONE.get(), ModBlocks.POLISHED_LIMESTONE_WALL.get(),
                    ModBlocks.POLISHED_LIMESTONE_STAIRS.get(), ModBlocks.POLISHED_LIMESTONE_SLAB.get(), consumer);

            //Limestone bricks
            blockWithPolishedVersionRecipes(ModBlocks.POLISHED_LIMESTONE.get(), ModBlocks.LIMESTONE_BRICKS.get(), ModBlocks.LIMESTONE_BRICK_WALL.get(),
                    ModBlocks.LIMESTONE_BRICK_STAIRS.get(), ModBlocks.LIMESTONE_BRICK_SLAB.get(), consumer);

            //Soul
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SOUL_MUD.get(), 4)
                    .pattern("MG")
                    .pattern("GM")
                    .define('M', Items.GRAVEL)
                    .define('G', Items.SOUL_SOIL)
                    .unlockedBy(getHasName(Items.SOUL_SOIL), has(Items.SOUL_SOIL))
                    .save(consumer);

            blockWithPolishedVersionRecipes(ModBlocks.SOUL_MUD.get(), ModBlocks.SOUL_MUD_BRICKS.get(), ModBlocks.SOUL_MUD_BRICK_WALL.get(),
                    ModBlocks.SOUL_MUD_BRICK_STAIRS.get(), ModBlocks.SOUL_MUD_BRICK_SLAB.get(), consumer);

            //Firebricks
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FIREBRICKS.get())
                    .pattern("FF")
                    .pattern("FF")
                    .define('F', ModItems.FIREBRICK.get())
                    .unlockedBy(getHasName(ModItems.FIREBRICK.get()), has(ModItems.FIREBRICK.get()))
                    .unlockedBy(getHasName(ModBlocks.FIREBRICKS.get()), has(ModBlocks.FIREBRICKS.get()))
                    .save(consumer);

            blockWithoutPolishedVersionRecipes(ModBlocks.FIREBRICKS.get(), ModBlocks.FIREBRICK_WALL.get(), ModBlocks.FIREBRICK_STAIRS.get(),
                    ModBlocks.FIREBRICK_SLAB.get(), consumer);

        //Entities
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ADOBE_FURNACE.get())
                .pattern("###")
                .pattern("# #")
                .pattern("III")
                .define('#', Blocks.PACKED_MUD)
                .define('I', ItemTags.STONE_CRAFTING_MATERIALS)
                .unlockedBy(getHasName(Blocks.COBBLESTONE), has(Blocks.COBBLESTONE))
                .unlockedBy(getHasName(Blocks.PACKED_MUD), has(Blocks.PACKED_MUD))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SOUL_FURNACE.get())
                .pattern("###")
                .pattern("# #")
                .pattern("###")
                .define('#', ModBlocks.SOUL_MUD.get())
                .unlockedBy(getHasName(ModBlocks.SOUL_MUD.get()), has(ModBlocks.SOUL_MUD.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.MASONRY_FURNACE.get())
                .pattern("III")
                .pattern("BFB")
                .pattern("CCC")
                .define('I', ModItems.BRONZE_INGOT.get())
                .define('B', ModBlocks.FIREBRICKS.get())
                .define('F', Blocks.FURNACE)
                .define('C', Blocks.COBBLESTONE)
                .unlockedBy(getHasName(Blocks.FURNACE), has(Blocks.FURNACE))
                .unlockedBy(getHasName(ModBlocks.MASONRY_FURNACE.get()), has(ModBlocks.MASONRY_FURNACE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ADOBE_ALLOYING_FURNACE.get())
                .pattern("###")
                .pattern("#A#")
                .pattern("III")
                .define('#', Blocks.BRICKS)
                .define('A', ModBlocks.ADOBE_FURNACE.get())
                .define('I', Blocks.COBBLESTONE)
                .unlockedBy(getHasName(ModBlocks.ADOBE_FURNACE.get()), has(ModBlocks.ADOBE_FURNACE.get()))
                .unlockedBy(getHasName(ModBlocks.ADOBE_ALLOYING_FURNACE.get()), has(ModBlocks.ADOBE_ALLOYING_FURNACE.get()))
                .unlockedBy(getHasName(ModItems.RAW_TIN.get()), has(ModItems.RAW_TIN.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SUPER_ALLOYING_FURNACE.get())
                .pattern("###")
                .pattern("#A#")
                .pattern("III")
                .define('#', ModItems.STEEL_INGOT.get())
                .define('A', ModBlocks.ADOBE_ALLOYING_FURNACE.get())
                .define('I', Blocks.COBBLED_DEEPSLATE)
                .unlockedBy(getHasName(Blocks.COBBLED_DEEPSLATE), has(Blocks.COBBLED_DEEPSLATE))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SOUL_ALLOY_FURNACE.get())
                .pattern("###")
                .pattern("#A#")
                .pattern("III")
                .define('#', ModBlocks.SOUL_MUD_BRICKS.get())
                .define('A', ModBlocks.SOUL_FURNACE.get())
                .define('I', Blocks.BLACKSTONE)
                .unlockedBy(getHasName(ModBlocks.SOUL_FURNACE.get()), has(ModBlocks.SOUL_FURNACE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.GEM_POLISHER.get())
                .pattern("###")
                .pattern("AIA")
                .pattern("AIA")
                .define('#', ItemTags.PLANKS)
                .define('A', ItemTags.LOGS_THAT_BURN)
                .define('I', Blocks.STONE)
                .unlockedBy(getHasName(Blocks.STONE), has(Blocks.STONE))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PRIMAL_GRINDER.get())
                .pattern("AAA")
                .pattern("ABA")
                .pattern("CCC")
                .define('A', Blocks.MUD_BRICKS)
                .define('B', ModItems.BRONZE_INGOT.get())
                .define('C', Blocks.COBBLESTONE)
                .unlockedBy(getHasName(ModItems.BRONZE_INGOT.get()), has(ModItems.BRONZE_INGOT.get()))
                .unlockedBy(getHasName(Blocks.MUD_BRICKS), has(Blocks.MUD_BRICKS))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.MECHANICAL_GRINDER.get())
                .pattern("#A#")
                .pattern("SIS")
                .pattern("###")
                .define('#', ItemTags.STONE_CRAFTING_MATERIALS)
                .define('A', Items.IRON_BARS)
                .define('S', ModItems.STEEL_INGOT.get())
                .define('I', Items.REDSTONE)
                .unlockedBy(getHasName(ModBlocks.PRIMAL_GRINDER.get()), has(ModBlocks.PRIMAL_GRINDER.get()))
                .unlockedBy(getHasName(Items.REDSTONE), has(Items.REDSTONE))
                .save(consumer);

        //Equipment recipes
            //Silver
            materialRecipes(ModItems.SILVER_INGOT.get(), ModItems.SILVER_NUGGET.get(), ModBlocks.SILVER_BLOCK.get(), consumer);

            addGear(ModItems.SILVER_INGOT.get(), ModItems.SILVER_AXE.get(), ModItems.SILVER_PICKAXE.get(), ModItems.SILVER_SWORD.get(),
                    ModItems.SILVER_DAGGER.get(), ModItems.SILVER_SHOVEL.get(), ModItems.SILVER_HOE.get(), ModItems.SILVER_POLISHER.get(),
                    ModItems.SILVER_HELMET.get(), ModItems.SILVER_CHESTPLATE.get(), ModItems.SILVER_LEGGINGS.get(), ModItems.SILVER_BOOTS.get(),
                    consumer);

            //Gold
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.GOLDEN_POLISHER.get())
                    .pattern(" I")
                    .pattern("# ")
                    .define('I', Items.GOLD_INGOT)
                    .define('#', Tags.Items.RODS_WOODEN)
                    .unlockedBy(getHasName(Items.GOLD_INGOT), has(Items.GOLD_INGOT))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.GOLDEN_DAGGER.get())
                    .pattern("I")
                    .pattern("#")
                    .define('I', Items.GOLD_INGOT)
                    .define('#', Tags.Items.RODS_WOODEN)
                    .unlockedBy(getHasName(Items.GOLD_INGOT), has(Items.GOLD_INGOT))
                    .unlockedBy(getHasName(ModItems.GOLDEN_DAGGER.get()), has(ModItems.GOLDEN_DAGGER.get()))
                    .save(consumer);

            //Stone
            addStoneGear(ModItems.STONE_POLISHER.get(), consumer);

            //Brass
            materialRecipes(ModItems.BRASS_INGOT.get(), ModItems.BRASS_NUGGET.get(), ModBlocks.BRASS_BLOCK.get(), consumer);

            addGear(ModItems.BRASS_INGOT.get(), ModItems.BRASS_AXE.get(), ModItems.BRASS_PICKAXE.get(), ModItems.BRASS_SWORD.get(),
                    ModItems.BRASS_DAGGER.get(), ModItems.BRASS_SHOVEL.get(), ModItems.BRASS_HOE.get(), ModItems.BRASS_POLISHER.get(),
                    ModItems.BRASS_HELMET.get(), ModItems.BRASS_CHESTPLATE.get(), ModItems.BRASS_LEGGINGS.get(), ModItems.BRASS_BOOTS.get(),
                    consumer);

            //Bronze
            materialRecipes(ModItems.BRONZE_INGOT.get(), ModItems.BRONZE_NUGGET.get(), ModBlocks.BRONZE_BLOCK.get(), consumer);

            addGear(ModItems.BRONZE_INGOT.get(), ModItems.BRONZE_AXE.get(), ModItems.BRONZE_PICKAXE.get(), ModItems.BRONZE_SWORD.get(),
                    ModItems.BRONZE_DAGGER.get(), ModItems.BRONZE_SHOVEL.get(), ModItems.BRONZE_HOE.get(), ModItems.BRONZE_POLISHER.get(),
                    ModItems.BRONZE_HELMET.get(), ModItems.BRONZE_CHESTPLATE.get(), ModItems.BRONZE_LEGGINGS.get(), ModItems.BRONZE_BOOTS.get(),
                    consumer);

            //Rose gold
            materialRecipes(ModItems.ROSE_GOLD_INGOT.get(), ModItems.ROSE_GOLD_NUGGET.get(), ModBlocks.ROSE_GOLD_BLOCK.get(), consumer);

            addGear(ModItems.ROSE_GOLD_INGOT.get(), ModItems.ROSE_GOLDEN_AXE.get(), ModItems.ROSE_GOLDEN_PICKAXE.get(), ModItems.ROSE_GOLDEN_SWORD.get(),
                    ModItems.ROSE_GOLDEN_DAGGER.get(), ModItems.ROSE_GOLDEN_SHOVEL.get(), ModItems.ROSE_GOLDEN_HOE.get(), ModItems.ROSE_GOLDEN_POLISHER.get(),
                    ModItems.ROSE_GOLDEN_HELMET.get(), ModItems.ROSE_GOLDEN_CHESTPLATE.get(), ModItems.ROSE_GOLDEN_LEGGINGS.get(), ModItems.ROSE_GOLDEN_BOOTS.get(),
                    consumer);

            //Iron
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.IRON_POLISHER.get())
                    .pattern(" I")
                    .pattern("# ")
                    .define('I', Items.IRON_INGOT)
                    .define('#', Tags.Items.RODS_WOODEN)
                    .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.IRON_DAGGER.get())
                    .pattern("I")
                    .pattern("#")
                    .define('I', Items.IRON_INGOT)
                    .define('#', Tags.Items.RODS_WOODEN)
                    .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                    .unlockedBy(getHasName(ModItems.IRON_DAGGER.get()), has(ModItems.IRON_DAGGER.get()))
                    .save(consumer);

            //Green gold
            materialRecipes(ModItems.GREEN_GOLD_INGOT.get(), ModItems.GREEN_GOLD_NUGGET.get(), ModBlocks.GREEN_GOLD_BLOCK.get(), consumer);

            addGear(ModItems.GREEN_GOLD_INGOT.get(), ModItems.GREEN_GOLDEN_AXE.get(), ModItems.GREEN_GOLDEN_PICKAXE.get(), ModItems.GREEN_GOLDEN_SWORD.get(),
                    ModItems.GREEN_GOLDEN_DAGGER.get(), ModItems.GREEN_GOLDEN_SHOVEL.get(), ModItems.GREEN_GOLDEN_HOE.get(), ModItems.GREEN_GOLDEN_POLISHER.get(),
                    ModItems.GREEN_GOLDEN_HELMET.get(), ModItems.GREEN_GOLDEN_CHESTPLATE.get(), ModItems.GREEN_GOLDEN_LEGGINGS.get(), ModItems.GREEN_GOLDEN_BOOTS.get(),
                    consumer);

            //Steel
            materialRecipes(ModItems.STEEL_INGOT.get(), ModBlocks.STEEL_BLOCK.get(), consumer);

            addGear(ModItems.STEEL_INGOT.get(), ModItems.STEEL_AXE.get(), ModItems.STEEL_PICKAXE.get(), ModItems.STEEL_SWORD.get(),
                    ModItems.STEEL_DAGGER.get(), ModItems.STEEL_SHOVEL.get(), ModItems.STEEL_HOE.get(), ModItems.STEEL_POLISHER.get(),
                    ModItems.STEEL_HELMET.get(), ModItems.STEEL_CHESTPLATE.get(), ModItems.STEEL_LEGGINGS.get(), ModItems.STEEL_BOOTS.get(),
                    consumer);

            //Blue gold
            materialRecipes(ModItems.BLUE_GOLD_INGOT.get(), ModItems.BLUE_GOLD_NUGGET.get(), ModBlocks.BLUE_GOLD_BLOCK.get(), consumer);

            addGear(ModItems.BLUE_GOLD_INGOT.get(), ModItems.BLUE_GOLDEN_AXE.get(), ModItems.BLUE_GOLDEN_PICKAXE.get(), ModItems.BLUE_GOLDEN_SWORD.get(),
                    ModItems.BLUE_GOLDEN_DAGGER.get(), ModItems.BLUE_GOLDEN_SHOVEL.get(), ModItems.BLUE_GOLDEN_HOE.get(), ModItems.BLUE_GOLDEN_POLISHER.get(),
                    ModItems.BLUE_GOLDEN_HELMET.get(), ModItems.BLUE_GOLDEN_CHESTPLATE.get(), ModItems.BLUE_GOLDEN_LEGGINGS.get(), ModItems.BLUE_GOLDEN_BOOTS.get(),
                    consumer);

            //Diamond
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.DIAMOND_POLISHER.get())
                    .pattern(" I")
                    .pattern("# ")
                    .define('I', Items.DIAMOND)
                    .define('#', Tags.Items.RODS_WOODEN)
                    .unlockedBy(getHasName(Items.DIAMOND), has(Items.DIAMOND))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.DIAMOND_DAGGER.get())
                    .pattern("I")
                    .pattern("#")
                    .define('I', Items.DIAMOND)
                    .define('#', Tags.Items.RODS_WOODEN)
                    .unlockedBy(getHasName(Items.DIAMOND), has(Items.DIAMOND))
                    .unlockedBy(getHasName(ModItems.DIAMOND_DAGGER.get()), has(ModItems.DIAMOND_DAGGER.get()))
                    .save(consumer);

        //New vanilla recipes
            //Food
            ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, Items.BREAD, 3)
                    .requires(ModItems.WHEAT_FLOUR.get(), 2)
                    .requires(Items.MILK_BUCKET)
                    .requires(ModItems.YEAST.get())
                    .unlockedBy(getHasName(ModItems.WHEAT_FLOUR.get()), has(ModItems.WHEAT_FLOUR.get()))
                    .unlockedBy(getHasName(Items.WHEAT), has(Items.WHEAT))
                    .save(consumer);
            ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, Items.COOKIE, 8)
                    .requires(ModItems.WHEAT_FLOUR.get(), 2)
                    .requires(Items.COCOA_BEANS, 2)
                    .requires(ModItems.YEAST.get())
                    .unlockedBy(getHasName(ModItems.WHEAT_FLOUR.get()), has(ModItems.WHEAT_FLOUR.get()))
                    .unlockedBy(getHasName(Items.WHEAT), has(Items.WHEAT))
                    .unlockedBy(getHasName(Items.COCOA_BEANS), has(Items.COCOA_BEANS))
                    .save(consumer);
            ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, Items.PUMPKIN_PIE)
                    .requires(ModItems.PUMPKIN_FLOUR.get(), 2)
                    .requires(ModItems.YEAST.get())
                    .unlockedBy(getHasName(ModItems.PUMPKIN_FLOUR.get()), has(ModItems.PUMPKIN_FLOUR.get()))
                    .unlockedBy(getHasName(Items.PUMPKIN), has(Items.PUMPKIN))
                    .save(consumer);

            //Redstone
            ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, Items.REPEATER)
                    .pattern("W#W")
                    .pattern("III")
                    .define('W', Items.REDSTONE_TORCH)
                    .define('#', ModItems.TIN_INGOT.get())
                    .define('I', Blocks.STONE)
                    .unlockedBy(getHasName(ModItems.TIN_INGOT.get()), has(ModItems.TIN_INGOT.get()))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, Items.COMPARATOR)
                    .pattern("WWW")
                    .pattern("AFA")
                    .pattern("III")
                    .define('W', Items.REDSTONE_TORCH)
                    .define('F', ModItems.TIN_INGOT.get())
                    .define('A', Items.REDSTONE)
                    .define('I', Blocks.STONE)
                    .unlockedBy(getHasName(ModItems.TIN_INGOT.get()), has(ModItems.TIN_INGOT.get()))
                    .unlockedBy(getHasName(Items.REDSTONE), has(Items.REDSTONE))
                    .save(consumer);

            //Items
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
                    .requires(ModItems.SULFUR.get())
                    .requires(Items.CHARCOAL)
                    .unlockedBy(getHasName(ModItems.SULFUR.get()), has(ModItems.SULFUR.get()))
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
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.COBBLESTONE)
                    .pattern("CC")
                    .pattern("CC")
                    .define('C', ModItems.COBBLE.get())
                    .unlockedBy(getHasName(ModItems.COBBLE.get()), has(ModItems.COBBLE.get()))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.NETHERRACK)
                    .pattern("NN")
                    .pattern("NN")
                    .define('N', ModItems.NETHERRACK_RUBBLE.get())
                    .unlockedBy(getHasName(ModItems.NETHERRACK_RUBBLE.get()), has(ModItems.NETHERRACK_RUBBLE.get()))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.BLACKSTONE)
                    .pattern("CC")
                    .pattern("CC")
                    .define('C', ModItems.BLACKSTONE_COBBLE.get())
                    .unlockedBy(getHasName(ModItems.BLACKSTONE_COBBLE.get()), has(ModItems.BLACKSTONE_COBBLE.get()))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.COBBLED_DEEPSLATE)
                    .pattern("CC")
                    .pattern("CC")
                    .define('C', ModItems.DEEPSLATE_COBBLE.get())
                    .unlockedBy(getHasName(ModItems.DEEPSLATE_COBBLE.get()), has(ModItems.DEEPSLATE_COBBLE.get()))
                    .save(consumer);

            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.STONE_BRICKS, 4)
                    .pattern("AA")
                    .pattern("AA")
                    .define('A', ModBlocks.POLISHED_STONE.get())
                    .unlockedBy(getHasName(ModBlocks.POLISHED_STONE.get()), has(ModBlocks.POLISHED_STONE.get()))
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
                    .define('B', ModItems.MUD_BRICK.get())
                    .unlockedBy(getHasName(Items.PACKED_MUD), has(Items.PACKED_MUD))
                    .unlockedBy(getHasName(ModItems.MUD_BRICK.get()), has(ModItems.MUD_BRICK.get()))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Blocks.BLAST_FURNACE)
                    .pattern("III")
                    .pattern("IFI")
                    .pattern("###")
                    .define('I', ModItems.STEEL_INGOT.get())
                    .define('F', Blocks.FURNACE)
                    .define('#', Blocks.SMOOTH_STONE)
                    .unlockedBy(getHasName(Blocks.FURNACE), has(Blocks.FURNACE))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Blocks.FURNACE)
                    .pattern("III")
                    .pattern("#F#")
                    .pattern("###")
                    .define('I', ModItems.BRONZE_INGOT.get())
                    .define('F', ModBlocks.ADOBE_FURNACE.get())
                    .define('#', Blocks.COBBLESTONE)
                    .unlockedBy(getHasName(Blocks.FURNACE), has(Blocks.FURNACE))
                    .save(consumer);
    }

    //Helper methods
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

    protected static void blockWithPolishedVersionRecipes(Block baseBlock, Block polishedBlock, Block wallBlock, Block stairBlock, Block slabBlock, Consumer<FinishedRecipe> consumer){
        baseAddRock(baseBlock, polishedBlock,  wallBlock, stairBlock, slabBlock, consumer);
    }

    protected static void blockWithoutPolishedVersionRecipes(Block baseBlock, Block wallBlock, Block stairBlock, Block slabBlock, Consumer<FinishedRecipe> consumer){
        baseAddRock(baseBlock, null, wallBlock, stairBlock, slabBlock, consumer);
    }

    protected static void blockWithoutWallNorPolished(Block baseBlock, Block stairBlock, Block slabBlock, Consumer<FinishedRecipe> consumer){
        baseAddRock(baseBlock, null, null, stairBlock, slabBlock, consumer);
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

    protected static void addGear(ItemLike pIngot, ItemLike pAxe, ItemLike pPickaxe, ItemLike pSword, ItemLike pDagger, ItemLike pShovel,
                                  ItemLike pHoe, ItemLike pPolisher,
                                  @Nullable ItemLike pHelmet, @Nullable ItemLike pChestplate, @Nullable ItemLike pLeggings, @Nullable ItemLike pBoots,
                                  Consumer<FinishedRecipe> pConsumer){
        //Armor
        if (pHelmet != null && pChestplate != null && pLeggings != null && pBoots != null){
            ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, pHelmet)
                    .pattern("###")
                    .pattern("# #")
                    .define('#', pIngot)
                    .unlockedBy(getHasName(pIngot), has(pIngot))
                    .unlockedBy(getHasName(pHelmet), has(pHelmet))
                    .save(pConsumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, pChestplate)
                    .pattern("# #")
                    .pattern("###")
                    .pattern("###")
                    .define('#', pIngot)
                    .unlockedBy(getHasName(pIngot), has(pIngot))
                    .unlockedBy(getHasName(pChestplate), has(pChestplate))
                    .save(pConsumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, pLeggings)
                    .pattern("###")
                    .pattern("# #")
                    .pattern("# #")
                    .define('#', pIngot)
                    .unlockedBy(getHasName(pIngot), has(pIngot))
                    .unlockedBy(getHasName(pLeggings), has(pLeggings))
                    .save(pConsumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, pBoots)
                    .pattern("# #")
                    .pattern("# #")
                    .define('#', pIngot)
                    .unlockedBy(getHasName(pIngot), has(pIngot))
                    .unlockedBy(getHasName(pBoots), has(pBoots))
                    .save(pConsumer);
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

    protected static void addStoneGear(ItemLike pPolisher, Consumer<FinishedRecipe> pConsumer){
        //Tools
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, Items.STONE_SWORD)
                .pattern(" I ")
                .pattern(" IS")
                .pattern(" # ")
                .define('I', ModTags.Items.COBBLE)
                .define('S', Tags.Items.STRING)
                .define('#', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_cobble", has(ModTags.Items.COBBLE))
                .unlockedBy(getHasName(Items.STONE_SWORD), has(Items.STONE_SWORD))
                .save(pConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, Items.STONE_PICKAXE)
                .pattern("III")
                .pattern(" #S")
                .pattern(" # ")
                .define('I', ModTags.Items.COBBLE)
                .define('S', Tags.Items.STRING)
                .define('#', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_cobble", has(ModTags.Items.COBBLE))
                .unlockedBy(getHasName(Items.STONE_PICKAXE), has(Items.STONE_PICKAXE))
                .save(pConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, Items.STONE_AXE)
                .pattern("IIS")
                .pattern("I# ")
                .pattern(" # ")
                .define('I', ModTags.Items.COBBLE)
                .define('S', Tags.Items.STRING)
                .define('#', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_cobble", has(ModTags.Items.COBBLE))
                .unlockedBy(getHasName(Items.STONE_AXE), has(Items.STONE_AXE))
                .save(pConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, Items.STONE_SHOVEL)
                .pattern(" I ")
                .pattern(" #S")
                .pattern(" # ")
                .define('I', ModTags.Items.COBBLE)
                .define('S', Tags.Items.STRING)
                .define('#', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_cobble", has(ModTags.Items.COBBLE))
                .unlockedBy(getHasName(Items.STONE_SHOVEL), has(Items.STONE_SHOVEL))
                .save(pConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, Items.STONE_HOE)
                .pattern("IIS")
                .pattern(" # ")
                .pattern(" # ")
                .define('I', ModTags.Items.COBBLE)
                .define('S', Tags.Items.STRING)
                .define('#', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_cobble", has(ModTags.Items.COBBLE))
                .unlockedBy(getHasName(Items.STONE_HOE), has(Items.STONE_HOE))
                .save(pConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, pPolisher)
                .pattern("SI")
                .pattern("# ")
                .define('I', ModTags.Items.COBBLE)
                .define('S', Tags.Items.STRING)
                .define('#', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_cobble", has(ModTags.Items.COBBLE))
                .unlockedBy(getHasName(pPolisher), has(pPolisher))
                .save(pConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.STONE_DAGGER.get())
                .pattern("I ")
                .pattern("#S")
                .define('I', ModTags.Items.COBBLE)
                .define('S', Tags.Items.STRING)
                .define('#', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_cobble", has(ModTags.Items.COBBLE))
                .unlockedBy(getHasName(ModItems.STONE_DAGGER.get()), has(ModItems.STONE_DAGGER.get()))
                .save(pConsumer);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
    }
}
