package net.marmar.enhanced_playthrough.datagen.recipe;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.item.EPItems;
import net.marmar.enhanced_playthrough.recipe.EPSmithingRecipesBuilder;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SmithingTrimRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

import java.util.function.Consumer;

public class SmithingRecipeSubProvider extends RecipeProvider {
    public SmithingRecipeSubProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {

    }

    //Caller
    public static void addSmithingRecipes(Consumer<FinishedRecipe> consumer){
        //Trims for armors
        smithingTrim(consumer, EPItems.ANCIENT_ARMOR_TRIM_SMITHING_TEMPLATE.get());

        //When combining a golden tool with a rose, green or blue gold ingot
        addGoldenUpgrades(consumer);

        //When combining bronze tools with brass tools
        addBronziumUpgrades(consumer);

        //When combining regular tools with leather strips
        addReinforcedUpgrades(consumer);

        //When combining regular or reinforced tools with an aluminum ingot
        addAluminumUpgrades(consumer);

        //When combining regular or reinforced tools with a purple gold ingot
        addPurpleGoldUpgrades(consumer);

        //Netherite
        smithingUpgrade(consumer, Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, EPItems.DIAMOND_POLISHER.get(),
                Items.NETHERITE_INGOT, EPItems.NETHERITE_POLISHER.get());
        smithingUpgrade(consumer, Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, EPItems.DIAMOND_DAGGER.get(),
                Items.NETHERITE_INGOT, EPItems.NETHERITE_DAGGER.get());
    }

    //Methods
    private static void addGoldenUpgrades(Consumer<FinishedRecipe> consumer){
        /*--- ROSE GOLD ---*/
            //Base
            roseGoldenSmithingUpgrade(consumer, Items.GOLDEN_HELMET, EPItems.ROSE_GOLDEN_HELMET.get());
            roseGoldenSmithingUpgrade(consumer, Items.GOLDEN_CHESTPLATE, EPItems.ROSE_GOLDEN_CHESTPLATE.get());
            roseGoldenSmithingUpgrade(consumer, Items.GOLDEN_LEGGINGS, EPItems.ROSE_GOLDEN_LEGGINGS.get());
            roseGoldenSmithingUpgrade(consumer, Items.GOLDEN_BOOTS, EPItems.ROSE_GOLDEN_BOOTS.get());

            roseGoldenSmithingUpgrade(consumer, Items.GOLDEN_PICKAXE, EPItems.ROSE_GOLDEN_PICKAXE.get());
            roseGoldenSmithingUpgrade(consumer, Items.GOLDEN_AXE, EPItems.ROSE_GOLDEN_AXE.get());
            roseGoldenSmithingUpgrade(consumer, Items.GOLDEN_SWORD, EPItems.ROSE_GOLDEN_SWORD.get());
            roseGoldenSmithingUpgrade(consumer, Items.GOLDEN_SHOVEL, EPItems.ROSE_GOLDEN_SHOVEL.get());
            roseGoldenSmithingUpgrade(consumer, Items.GOLDEN_HOE, EPItems.ROSE_GOLDEN_HOE.get());
            roseGoldenSmithingUpgrade(consumer, EPItems.GOLDEN_POLISHER.get(), EPItems.ROSE_GOLDEN_POLISHER.get());
            roseGoldenSmithingUpgrade(consumer, EPItems.GOLDEN_DAGGER.get(), EPItems.ROSE_GOLDEN_DAGGER.get());

            //Reinforced
            roseGoldenSmithingUpgrade(consumer, EPItems.REINFORCED_GOLDEN_PICKAXE.get(), EPItems.REINFORCED_ROSE_GOLDEN_PICKAXE.get());
            roseGoldenSmithingUpgrade(consumer, EPItems.REINFORCED_GOLDEN_AXE.get(), EPItems.REINFORCED_ROSE_GOLDEN_AXE.get());
            roseGoldenSmithingUpgrade(consumer, EPItems.REINFORCED_GOLDEN_SWORD.get(), EPItems.REINFORCED_ROSE_GOLDEN_SWORD.get());
            roseGoldenSmithingUpgrade(consumer, EPItems.REINFORCED_GOLDEN_SHOVEL.get(), EPItems.REINFORCED_ROSE_GOLDEN_SHOVEL.get());
            roseGoldenSmithingUpgrade(consumer, EPItems.REINFORCED_GOLDEN_HOE.get(), EPItems.REINFORCED_ROSE_GOLDEN_HOE.get());
            roseGoldenSmithingUpgrade(consumer, EPItems.REINFORCED_GOLDEN_POLISHER.get(), EPItems.REINFORCED_ROSE_GOLDEN_POLISHER.get());
            roseGoldenSmithingUpgrade(consumer, EPItems.REINFORCED_GOLDEN_DAGGER.get(), EPItems.REINFORCED_ROSE_GOLDEN_DAGGER.get());

            //Aluminum
            roseGoldenSmithingUpgrade(consumer, EPItems.ALUMINUM_GOLDEN_PICKAXE.get(), EPItems.ALUMINUM_ROSE_GOLDEN_PICKAXE.get());
            roseGoldenSmithingUpgrade(consumer, EPItems.ALUMINUM_GOLDEN_AXE.get(), EPItems.ALUMINUM_ROSE_GOLDEN_AXE.get());
            roseGoldenSmithingUpgrade(consumer, EPItems.ALUMINUM_GOLDEN_SWORD.get(), EPItems.ALUMINUM_ROSE_GOLDEN_SWORD.get());
            roseGoldenSmithingUpgrade(consumer, EPItems.ALUMINUM_GOLDEN_SHOVEL.get(), EPItems.ALUMINUM_ROSE_GOLDEN_SHOVEL.get());
            roseGoldenSmithingUpgrade(consumer, EPItems.ALUMINUM_GOLDEN_HOE.get(), EPItems.ALUMINUM_ROSE_GOLDEN_HOE.get());
            roseGoldenSmithingUpgrade(consumer, EPItems.ALUMINUM_GOLDEN_POLISHER.get(), EPItems.ALUMINUM_ROSE_GOLDEN_POLISHER.get());
            roseGoldenSmithingUpgrade(consumer, EPItems.ALUMINUM_GOLDEN_DAGGER.get(), EPItems.ALUMINUM_ROSE_GOLDEN_DAGGER.get());

            //Purple gold
            roseGoldenSmithingUpgrade(consumer, EPItems.PURPLE_GOLD_GOLDEN_PICKAXE.get(), EPItems.PURPLE_GOLD_ROSE_GOLDEN_PICKAXE.get());
            roseGoldenSmithingUpgrade(consumer, EPItems.PURPLE_GOLD_GOLDEN_AXE.get(), EPItems.PURPLE_GOLD_ROSE_GOLDEN_AXE.get());
            roseGoldenSmithingUpgrade(consumer, EPItems.PURPLE_GOLD_GOLDEN_SWORD.get(), EPItems.PURPLE_GOLD_ROSE_GOLDEN_SWORD.get());
            roseGoldenSmithingUpgrade(consumer, EPItems.PURPLE_GOLD_GOLDEN_SHOVEL.get(), EPItems.PURPLE_GOLD_ROSE_GOLDEN_SHOVEL.get());
            roseGoldenSmithingUpgrade(consumer, EPItems.PURPLE_GOLD_GOLDEN_HOE.get(), EPItems.PURPLE_GOLD_ROSE_GOLDEN_HOE.get());
            roseGoldenSmithingUpgrade(consumer, EPItems.PURPLE_GOLD_GOLDEN_POLISHER.get(), EPItems.PURPLE_GOLD_ROSE_GOLDEN_POLISHER.get());
            roseGoldenSmithingUpgrade(consumer, EPItems.PURPLE_GOLD_GOLDEN_DAGGER.get(), EPItems.PURPLE_GOLD_ROSE_GOLDEN_DAGGER.get());

        /*--- GREEN GOLD ---*/
            //Base
            greenGoldenSmithingUpgrade(consumer, Items.GOLDEN_HELMET, EPItems.GREEN_GOLDEN_HELMET.get());
            greenGoldenSmithingUpgrade(consumer, Items.GOLDEN_CHESTPLATE, EPItems.GREEN_GOLDEN_CHESTPLATE.get());
            greenGoldenSmithingUpgrade(consumer, Items.GOLDEN_LEGGINGS, EPItems.GREEN_GOLDEN_LEGGINGS.get());
            greenGoldenSmithingUpgrade(consumer, Items.GOLDEN_BOOTS, EPItems.GREEN_GOLDEN_BOOTS.get());

            greenGoldenSmithingUpgrade(consumer, Items.GOLDEN_PICKAXE, EPItems.GREEN_GOLDEN_PICKAXE.get());
            greenGoldenSmithingUpgrade(consumer, Items.GOLDEN_AXE, EPItems.GREEN_GOLDEN_AXE.get());
            greenGoldenSmithingUpgrade(consumer, Items.GOLDEN_SWORD, EPItems.GREEN_GOLDEN_SWORD.get());
            greenGoldenSmithingUpgrade(consumer, Items.GOLDEN_SHOVEL, EPItems.GREEN_GOLDEN_SHOVEL.get());
            greenGoldenSmithingUpgrade(consumer, Items.GOLDEN_HOE, EPItems.GREEN_GOLDEN_HOE.get());
            greenGoldenSmithingUpgrade(consumer, EPItems.GOLDEN_POLISHER.get(), EPItems.GREEN_GOLDEN_POLISHER.get());
            greenGoldenSmithingUpgrade(consumer, EPItems.GOLDEN_DAGGER.get(), EPItems.GREEN_GOLDEN_DAGGER.get());

            //Reinforced
            greenGoldenSmithingUpgrade(consumer, EPItems.REINFORCED_GOLDEN_PICKAXE.get(), EPItems.REINFORCED_GREEN_GOLDEN_PICKAXE.get());
            greenGoldenSmithingUpgrade(consumer, EPItems.REINFORCED_GOLDEN_AXE.get(), EPItems.REINFORCED_GREEN_GOLDEN_AXE.get());
            greenGoldenSmithingUpgrade(consumer, EPItems.REINFORCED_GOLDEN_SWORD.get(), EPItems.REINFORCED_GREEN_GOLDEN_SWORD.get());
            greenGoldenSmithingUpgrade(consumer, EPItems.REINFORCED_GOLDEN_SHOVEL.get(), EPItems.REINFORCED_GREEN_GOLDEN_SHOVEL.get());
            greenGoldenSmithingUpgrade(consumer, EPItems.REINFORCED_GOLDEN_HOE.get(), EPItems.REINFORCED_GREEN_GOLDEN_HOE.get());
            greenGoldenSmithingUpgrade(consumer, EPItems.REINFORCED_GOLDEN_POLISHER.get(), EPItems.REINFORCED_GREEN_GOLDEN_POLISHER.get());
            greenGoldenSmithingUpgrade(consumer, EPItems.REINFORCED_GOLDEN_DAGGER.get(), EPItems.REINFORCED_GREEN_GOLDEN_DAGGER.get());

            //Aluminum
            greenGoldenSmithingUpgrade(consumer, EPItems.ALUMINUM_GOLDEN_PICKAXE.get(), EPItems.ALUMINUM_GREEN_GOLDEN_PICKAXE.get());
            greenGoldenSmithingUpgrade(consumer, EPItems.ALUMINUM_GOLDEN_AXE.get(), EPItems.ALUMINUM_GREEN_GOLDEN_AXE.get());
            greenGoldenSmithingUpgrade(consumer, EPItems.ALUMINUM_GOLDEN_SWORD.get(), EPItems.ALUMINUM_GREEN_GOLDEN_SWORD.get());
            greenGoldenSmithingUpgrade(consumer, EPItems.ALUMINUM_GOLDEN_SHOVEL.get(), EPItems.ALUMINUM_GREEN_GOLDEN_SHOVEL.get());
            greenGoldenSmithingUpgrade(consumer, EPItems.ALUMINUM_GOLDEN_HOE.get(), EPItems.ALUMINUM_GREEN_GOLDEN_HOE.get());
            greenGoldenSmithingUpgrade(consumer, EPItems.ALUMINUM_GOLDEN_POLISHER.get(), EPItems.ALUMINUM_GREEN_GOLDEN_POLISHER.get());
            greenGoldenSmithingUpgrade(consumer, EPItems.ALUMINUM_GOLDEN_DAGGER.get(), EPItems.ALUMINUM_GREEN_GOLDEN_DAGGER.get());

            //Purple gold
            greenGoldenSmithingUpgrade(consumer, EPItems.PURPLE_GOLD_GOLDEN_PICKAXE.get(), EPItems.PURPLE_GOLD_GREEN_GOLDEN_PICKAXE.get());
            greenGoldenSmithingUpgrade(consumer, EPItems.PURPLE_GOLD_GOLDEN_AXE.get(), EPItems.PURPLE_GOLD_GREEN_GOLDEN_AXE.get());
            greenGoldenSmithingUpgrade(consumer, EPItems.PURPLE_GOLD_GOLDEN_SWORD.get(), EPItems.PURPLE_GOLD_GREEN_GOLDEN_SWORD.get());
            greenGoldenSmithingUpgrade(consumer, EPItems.PURPLE_GOLD_GOLDEN_SHOVEL.get(), EPItems.PURPLE_GOLD_GREEN_GOLDEN_SHOVEL.get());
            greenGoldenSmithingUpgrade(consumer, EPItems.PURPLE_GOLD_GOLDEN_HOE.get(), EPItems.PURPLE_GOLD_GREEN_GOLDEN_HOE.get());
            greenGoldenSmithingUpgrade(consumer, EPItems.PURPLE_GOLD_GOLDEN_POLISHER.get(), EPItems.PURPLE_GOLD_GREEN_GOLDEN_POLISHER.get());
            greenGoldenSmithingUpgrade(consumer, EPItems.PURPLE_GOLD_GOLDEN_DAGGER.get(), EPItems.PURPLE_GOLD_GREEN_GOLDEN_DAGGER.get());

        /*--- BLUE GOLD ---*/
            //Base
            blueGoldenSmithingUpgrade(consumer, Items.GOLDEN_HELMET, EPItems.BLUE_GOLDEN_HELMET.get());
            blueGoldenSmithingUpgrade(consumer, Items.GOLDEN_CHESTPLATE, EPItems.BLUE_GOLDEN_CHESTPLATE.get());
            blueGoldenSmithingUpgrade(consumer, Items.GOLDEN_LEGGINGS, EPItems.BLUE_GOLDEN_LEGGINGS.get());
            blueGoldenSmithingUpgrade(consumer, Items.GOLDEN_BOOTS, EPItems.BLUE_GOLDEN_BOOTS.get());

            blueGoldenSmithingUpgrade(consumer, Items.GOLDEN_PICKAXE, EPItems.BLUE_GOLDEN_PICKAXE.get());
            blueGoldenSmithingUpgrade(consumer, Items.GOLDEN_AXE, EPItems.BLUE_GOLDEN_AXE.get());
            blueGoldenSmithingUpgrade(consumer, Items.GOLDEN_SWORD, EPItems.BLUE_GOLDEN_SWORD.get());
            blueGoldenSmithingUpgrade(consumer, Items.GOLDEN_SHOVEL, EPItems.BLUE_GOLDEN_SHOVEL.get());
            blueGoldenSmithingUpgrade(consumer, Items.GOLDEN_HOE, EPItems.BLUE_GOLDEN_HOE.get());
            blueGoldenSmithingUpgrade(consumer, EPItems.GOLDEN_POLISHER.get(), EPItems.BLUE_GOLDEN_POLISHER.get());
            blueGoldenSmithingUpgrade(consumer, EPItems.GOLDEN_DAGGER.get(), EPItems.BLUE_GOLDEN_DAGGER.get());

            //Reinforced
            blueGoldenSmithingUpgrade(consumer, EPItems.REINFORCED_GOLDEN_PICKAXE.get(), EPItems.REINFORCED_BLUE_GOLDEN_PICKAXE.get());
            blueGoldenSmithingUpgrade(consumer, EPItems.REINFORCED_GOLDEN_AXE.get(), EPItems.REINFORCED_BLUE_GOLDEN_AXE.get());
            blueGoldenSmithingUpgrade(consumer, EPItems.REINFORCED_GOLDEN_SWORD.get(), EPItems.REINFORCED_BLUE_GOLDEN_SWORD.get());
            blueGoldenSmithingUpgrade(consumer, EPItems.REINFORCED_GOLDEN_SHOVEL.get(), EPItems.REINFORCED_BLUE_GOLDEN_SHOVEL.get());
            blueGoldenSmithingUpgrade(consumer, EPItems.REINFORCED_GOLDEN_HOE.get(), EPItems.REINFORCED_BLUE_GOLDEN_HOE.get());
            blueGoldenSmithingUpgrade(consumer, EPItems.REINFORCED_GOLDEN_POLISHER.get(), EPItems.REINFORCED_BLUE_GOLDEN_POLISHER.get());
            blueGoldenSmithingUpgrade(consumer, EPItems.REINFORCED_GOLDEN_DAGGER.get(), EPItems.REINFORCED_BLUE_GOLDEN_DAGGER.get());

            //Aluminum
            blueGoldenSmithingUpgrade(consumer, EPItems.ALUMINUM_GOLDEN_PICKAXE.get(), EPItems.ALUMINUM_BLUE_GOLDEN_PICKAXE.get());
            blueGoldenSmithingUpgrade(consumer, EPItems.ALUMINUM_GOLDEN_AXE.get(), EPItems.ALUMINUM_BLUE_GOLDEN_AXE.get());
            blueGoldenSmithingUpgrade(consumer, EPItems.ALUMINUM_GOLDEN_SWORD.get(), EPItems.ALUMINUM_BLUE_GOLDEN_SWORD.get());
            blueGoldenSmithingUpgrade(consumer, EPItems.ALUMINUM_GOLDEN_SHOVEL.get(), EPItems.ALUMINUM_BLUE_GOLDEN_SHOVEL.get());
            blueGoldenSmithingUpgrade(consumer, EPItems.ALUMINUM_GOLDEN_HOE.get(), EPItems.ALUMINUM_BLUE_GOLDEN_HOE.get());
            blueGoldenSmithingUpgrade(consumer, EPItems.ALUMINUM_GOLDEN_POLISHER.get(), EPItems.ALUMINUM_BLUE_GOLDEN_POLISHER.get());
            blueGoldenSmithingUpgrade(consumer, EPItems.ALUMINUM_GOLDEN_DAGGER.get(), EPItems.ALUMINUM_BLUE_GOLDEN_DAGGER.get());

            //Purple gold
            blueGoldenSmithingUpgrade(consumer, EPItems.PURPLE_GOLD_GOLDEN_PICKAXE.get(), EPItems.PURPLE_GOLD_BLUE_GOLDEN_PICKAXE.get());
            blueGoldenSmithingUpgrade(consumer, EPItems.PURPLE_GOLD_GOLDEN_AXE.get(), EPItems.PURPLE_GOLD_BLUE_GOLDEN_AXE.get());
            blueGoldenSmithingUpgrade(consumer, EPItems.PURPLE_GOLD_GOLDEN_SWORD.get(), EPItems.PURPLE_GOLD_BLUE_GOLDEN_SWORD.get());
            blueGoldenSmithingUpgrade(consumer, EPItems.PURPLE_GOLD_GOLDEN_SHOVEL.get(), EPItems.PURPLE_GOLD_BLUE_GOLDEN_SHOVEL.get());
            blueGoldenSmithingUpgrade(consumer, EPItems.PURPLE_GOLD_GOLDEN_HOE.get(), EPItems.PURPLE_GOLD_BLUE_GOLDEN_HOE.get());
            blueGoldenSmithingUpgrade(consumer, EPItems.PURPLE_GOLD_GOLDEN_POLISHER.get(), EPItems.PURPLE_GOLD_BLUE_GOLDEN_POLISHER.get());
            blueGoldenSmithingUpgrade(consumer, EPItems.PURPLE_GOLD_GOLDEN_DAGGER.get(), EPItems.PURPLE_GOLD_BLUE_GOLDEN_DAGGER.get());
    }

    private static void addBronziumUpgrades(Consumer<FinishedRecipe> consumer){
        bronziumSmithingTemplate(consumer, EPItems.BRASS_AXE.get(), EPItems.BRONZE_AXE.get(), EPItems.BRONZIUM_AXE.get());
        bronziumSmithingTemplate(consumer, EPItems.BRASS_PICKAXE.get(), EPItems.BRONZE_PICKAXE.get(), EPItems.BRONZIUM_PICKAXE.get());
        bronziumSmithingTemplate(consumer, EPItems.BRASS_SHOVEL.get(), EPItems.BRONZE_SHOVEL.get(), EPItems.BRONZIUM_SHOVEL.get());
        bronziumSmithingTemplate(consumer, EPItems.BRASS_HOE.get(), EPItems.BRONZE_HOE.get(), EPItems.BRONZIUM_HOE.get());
        bronziumSmithingTemplate(consumer, EPItems.BRASS_POLISHER.get(), EPItems.BRONZE_POLISHER.get(), EPItems.BRONZIUM_POLISHER.get());
        bronziumSmithingTemplate(consumer, EPItems.BRASS_SWORD.get(), EPItems.BRONZE_SWORD.get(), EPItems.BRONZIUM_SWORD.get());
        bronziumSmithingTemplate(consumer, EPItems.BRASS_DAGGER.get(), EPItems.BRONZE_DAGGER.get(), EPItems.BRONZIUM_DAGGER.get());
        bronziumSmithingTemplate(consumer, EPItems.BRASS_HELMET.get(), EPItems.BRONZE_HELMET.get(), EPItems.BRONZIUM_HELMET.get());
        bronziumSmithingTemplate(consumer, EPItems.BRASS_CHESTPLATE.get(), EPItems.BRONZE_CHESTPLATE.get(), EPItems.BRONZIUM_CHESTPLATE.get());
        bronziumSmithingTemplate(consumer, EPItems.BRASS_LEGGINGS.get(), EPItems.BRONZE_LEGGINGS.get(), EPItems.BRONZIUM_LEGGINGS.get());
        bronziumSmithingTemplate(consumer, EPItems.BRASS_BOOTS.get(), EPItems.BRONZE_BOOTS.get(), EPItems.BRONZIUM_BOOTS.get());
    }

    private static void addReinforcedUpgrades(Consumer<FinishedRecipe> consumer){
        //Gold
        reinforcedSmithingUpgrade(consumer, Items.GOLDEN_SWORD, EPItems.REINFORCED_GOLDEN_SWORD.get());
        reinforcedSmithingUpgrade(consumer, Items.GOLDEN_AXE, EPItems.REINFORCED_GOLDEN_AXE.get());
        reinforcedSmithingUpgrade(consumer, Items.GOLDEN_PICKAXE, EPItems.REINFORCED_GOLDEN_PICKAXE.get());
        reinforcedSmithingUpgrade(consumer, Items.GOLDEN_SHOVEL, EPItems.REINFORCED_GOLDEN_SHOVEL.get());
        reinforcedSmithingUpgrade(consumer, Items.GOLDEN_HOE, EPItems.REINFORCED_GOLDEN_HOE.get());
        reinforcedSmithingUpgrade(consumer, EPItems.GOLDEN_POLISHER.get(), EPItems.REINFORCED_GOLDEN_POLISHER.get());
        reinforcedSmithingUpgrade(consumer, EPItems.GOLDEN_DAGGER.get(), EPItems.REINFORCED_GOLDEN_DAGGER.get());

        //Silver
        reinforcedSmithingUpgrade(consumer, EPItems.SILVER_SWORD.get(), EPItems.REINFORCED_SILVER_SWORD.get());
        reinforcedSmithingUpgrade(consumer, EPItems.SILVER_AXE.get(), EPItems.REINFORCED_SILVER_AXE.get());
        reinforcedSmithingUpgrade(consumer, EPItems.SILVER_PICKAXE.get(), EPItems.REINFORCED_SILVER_PICKAXE.get());
        reinforcedSmithingUpgrade(consumer, EPItems.SILVER_SHOVEL.get(), EPItems.REINFORCED_SILVER_SHOVEL.get());
        reinforcedSmithingUpgrade(consumer, EPItems.SILVER_HOE.get(), EPItems.REINFORCED_SILVER_HOE.get());
        reinforcedSmithingUpgrade(consumer, EPItems.GOLDEN_POLISHER.get(), EPItems.REINFORCED_SILVER_POLISHER.get());
        reinforcedSmithingUpgrade(consumer, EPItems.SILVER_DAGGER.get(), EPItems.REINFORCED_SILVER_DAGGER.get());

        //Iron
        reinforcedSmithingUpgrade(consumer, Items.IRON_SWORD, EPItems.REINFORCED_IRON_SWORD.get());
        reinforcedSmithingUpgrade(consumer, Items.IRON_AXE, EPItems.REINFORCED_IRON_AXE.get());
        reinforcedSmithingUpgrade(consumer, Items.IRON_PICKAXE, EPItems.REINFORCED_IRON_PICKAXE.get());
        reinforcedSmithingUpgrade(consumer, Items.IRON_SHOVEL, EPItems.REINFORCED_IRON_SHOVEL.get());
        reinforcedSmithingUpgrade(consumer, Items.IRON_HOE, EPItems.REINFORCED_IRON_HOE.get());
        reinforcedSmithingUpgrade(consumer, EPItems.IRON_POLISHER.get(), EPItems.REINFORCED_IRON_POLISHER.get());
        reinforcedSmithingUpgrade(consumer, EPItems.IRON_DAGGER.get(), EPItems.REINFORCED_IRON_DAGGER.get());

        //Bronze
        reinforcedSmithingUpgrade(consumer, EPItems.BRONZE_SWORD.get(), EPItems.REINFORCED_BRONZE_SWORD.get());
        reinforcedSmithingUpgrade(consumer, EPItems.BRONZE_AXE.get(), EPItems.REINFORCED_BRONZE_AXE.get());
        reinforcedSmithingUpgrade(consumer, EPItems.BRONZE_PICKAXE.get(), EPItems.REINFORCED_BRONZE_PICKAXE.get());
        reinforcedSmithingUpgrade(consumer, EPItems.BRONZE_SHOVEL.get(), EPItems.REINFORCED_BRONZE_SHOVEL.get());
        reinforcedSmithingUpgrade(consumer, EPItems.BRONZE_HOE.get(), EPItems.REINFORCED_BRONZE_HOE.get());
        reinforcedSmithingUpgrade(consumer, EPItems.BRONZE_POLISHER.get(), EPItems.REINFORCED_BRONZE_POLISHER.get());
        reinforcedSmithingUpgrade(consumer, EPItems.BRONZE_DAGGER.get(), EPItems.REINFORCED_BRONZE_DAGGER.get());

        //Brass
        reinforcedSmithingUpgrade(consumer, EPItems.BRASS_SWORD.get(), EPItems.REINFORCED_BRASS_SWORD.get());
        reinforcedSmithingUpgrade(consumer, EPItems.BRASS_AXE.get(), EPItems.REINFORCED_BRASS_AXE.get());
        reinforcedSmithingUpgrade(consumer, EPItems.BRASS_PICKAXE.get(), EPItems.REINFORCED_BRASS_PICKAXE.get());
        reinforcedSmithingUpgrade(consumer, EPItems.BRASS_SHOVEL.get(), EPItems.REINFORCED_BRASS_SHOVEL.get());
        reinforcedSmithingUpgrade(consumer, EPItems.BRASS_HOE.get(), EPItems.REINFORCED_BRASS_HOE.get());
        reinforcedSmithingUpgrade(consumer, EPItems.BRASS_POLISHER.get(), EPItems.REINFORCED_BRASS_POLISHER.get());
        reinforcedSmithingUpgrade(consumer, EPItems.BRASS_DAGGER.get(), EPItems.REINFORCED_BRASS_DAGGER.get());

        //Rose Gold
        reinforcedSmithingUpgrade(consumer, EPItems.ROSE_GOLDEN_SWORD.get(), EPItems.REINFORCED_ROSE_GOLDEN_SWORD.get());
        reinforcedSmithingUpgrade(consumer, EPItems.ROSE_GOLDEN_AXE.get(), EPItems.REINFORCED_ROSE_GOLDEN_AXE.get());
        reinforcedSmithingUpgrade(consumer, EPItems.ROSE_GOLDEN_PICKAXE.get(), EPItems.REINFORCED_ROSE_GOLDEN_PICKAXE.get());
        reinforcedSmithingUpgrade(consumer, EPItems.ROSE_GOLDEN_SHOVEL.get(), EPItems.REINFORCED_ROSE_GOLDEN_SHOVEL.get());
        reinforcedSmithingUpgrade(consumer, EPItems.ROSE_GOLDEN_HOE.get(), EPItems.REINFORCED_ROSE_GOLDEN_HOE.get());
        reinforcedSmithingUpgrade(consumer, EPItems.ROSE_GOLDEN_POLISHER.get(), EPItems.REINFORCED_ROSE_GOLDEN_POLISHER.get());
        reinforcedSmithingUpgrade(consumer, EPItems.ROSE_GOLDEN_DAGGER.get(), EPItems.REINFORCED_ROSE_GOLDEN_DAGGER.get());

        //Bronzium
        reinforcedSmithingUpgrade(consumer, EPItems.BRONZIUM_SWORD.get(), EPItems.REINFORCED_BRONZIUM_SWORD.get());
        reinforcedSmithingUpgrade(consumer, EPItems.BRONZIUM_AXE.get(), EPItems.REINFORCED_BRONZIUM_AXE.get());
        reinforcedSmithingUpgrade(consumer, EPItems.BRONZIUM_PICKAXE.get(), EPItems.REINFORCED_BRONZIUM_PICKAXE.get());
        reinforcedSmithingUpgrade(consumer, EPItems.BRONZIUM_SHOVEL.get(), EPItems.REINFORCED_BRONZIUM_SHOVEL.get());
        reinforcedSmithingUpgrade(consumer, EPItems.BRONZIUM_HOE.get(), EPItems.REINFORCED_BRONZIUM_HOE.get());
        reinforcedSmithingUpgrade(consumer, EPItems.BRONZIUM_POLISHER.get(), EPItems.REINFORCED_BRONZIUM_POLISHER.get());
        reinforcedSmithingUpgrade(consumer, EPItems.BRONZIUM_DAGGER.get(), EPItems.REINFORCED_BRONZIUM_DAGGER.get());

        //Steel
        reinforcedSmithingUpgrade(consumer, EPItems.STEEL_SWORD.get(), EPItems.REINFORCED_STEEL_SWORD.get());
        reinforcedSmithingUpgrade(consumer, EPItems.STEEL_AXE.get(), EPItems.REINFORCED_STEEL_AXE.get());
        reinforcedSmithingUpgrade(consumer, EPItems.STEEL_PICKAXE.get(), EPItems.REINFORCED_STEEL_PICKAXE.get());
        reinforcedSmithingUpgrade(consumer, EPItems.STEEL_SHOVEL.get(), EPItems.REINFORCED_STEEL_SHOVEL.get());
        reinforcedSmithingUpgrade(consumer, EPItems.STEEL_HOE.get(), EPItems.REINFORCED_STEEL_HOE.get());
        reinforcedSmithingUpgrade(consumer, EPItems.STEEL_POLISHER.get(), EPItems.REINFORCED_STEEL_POLISHER.get());
        reinforcedSmithingUpgrade(consumer, EPItems.STEEL_DAGGER.get(), EPItems.REINFORCED_STEEL_DAGGER.get());

        //Green Gold
        reinforcedSmithingUpgrade(consumer, EPItems.GREEN_GOLDEN_SWORD.get(), EPItems.REINFORCED_GREEN_GOLDEN_SWORD.get());
        reinforcedSmithingUpgrade(consumer, EPItems.GREEN_GOLDEN_AXE.get(), EPItems.REINFORCED_GREEN_GOLDEN_AXE.get());
        reinforcedSmithingUpgrade(consumer, EPItems.GREEN_GOLDEN_PICKAXE.get(), EPItems.REINFORCED_GREEN_GOLDEN_PICKAXE.get());
        reinforcedSmithingUpgrade(consumer, EPItems.GREEN_GOLDEN_SHOVEL.get(), EPItems.REINFORCED_GREEN_GOLDEN_SHOVEL.get());
        reinforcedSmithingUpgrade(consumer, EPItems.GREEN_GOLDEN_HOE.get(), EPItems.REINFORCED_GREEN_GOLDEN_HOE.get());
        reinforcedSmithingUpgrade(consumer, EPItems.GREEN_GOLDEN_POLISHER.get(), EPItems.REINFORCED_GREEN_GOLDEN_POLISHER.get());
        reinforcedSmithingUpgrade(consumer, EPItems.GREEN_GOLDEN_DAGGER.get(), EPItems.REINFORCED_GREEN_GOLDEN_DAGGER.get());

        //Blue Gold
        reinforcedSmithingUpgrade(consumer, EPItems.BLUE_GOLDEN_SWORD.get(), EPItems.REINFORCED_BLUE_GOLDEN_SWORD.get());
        reinforcedSmithingUpgrade(consumer, EPItems.BLUE_GOLDEN_AXE.get(), EPItems.REINFORCED_BLUE_GOLDEN_AXE.get());
        reinforcedSmithingUpgrade(consumer, EPItems.BLUE_GOLDEN_PICKAXE.get(), EPItems.REINFORCED_BLUE_GOLDEN_PICKAXE.get());
        reinforcedSmithingUpgrade(consumer, EPItems.BLUE_GOLDEN_SHOVEL.get(), EPItems.REINFORCED_BLUE_GOLDEN_SHOVEL.get());
        reinforcedSmithingUpgrade(consumer, EPItems.BLUE_GOLDEN_HOE.get(), EPItems.REINFORCED_BLUE_GOLDEN_HOE.get());
        reinforcedSmithingUpgrade(consumer, EPItems.BLUE_GOLDEN_POLISHER.get(), EPItems.REINFORCED_BLUE_GOLDEN_POLISHER.get());
        reinforcedSmithingUpgrade(consumer, EPItems.BLUE_GOLDEN_DAGGER.get(), EPItems.REINFORCED_BLUE_GOLDEN_DAGGER.get());

        //Diamond
        reinforcedSmithingUpgrade(consumer, Items.DIAMOND_SWORD, EPItems.REINFORCED_DIAMOND_SWORD.get());
        reinforcedSmithingUpgrade(consumer, Items.DIAMOND_AXE, EPItems.REINFORCED_DIAMOND_AXE.get());
        reinforcedSmithingUpgrade(consumer, Items.DIAMOND_PICKAXE, EPItems.REINFORCED_DIAMOND_PICKAXE.get());
        reinforcedSmithingUpgrade(consumer, Items.DIAMOND_SHOVEL, EPItems.REINFORCED_DIAMOND_SHOVEL.get());
        reinforcedSmithingUpgrade(consumer, Items.DIAMOND_HOE, EPItems.REINFORCED_DIAMOND_HOE.get());
        reinforcedSmithingUpgrade(consumer, EPItems.DIAMOND_POLISHER.get(), EPItems.REINFORCED_DIAMOND_POLISHER.get());
        reinforcedSmithingUpgrade(consumer, EPItems.DIAMOND_DAGGER.get(), EPItems.REINFORCED_DIAMOND_DAGGER.get());
    }

    private static void addAluminumUpgrades(Consumer<FinishedRecipe> consumer){
        //Gold
        aluminumSmithingUpgrade(consumer, Items.GOLDEN_SWORD, EPItems.ALUMINUM_GOLDEN_SWORD.get());
        aluminumSmithingUpgrade(consumer, Items.GOLDEN_AXE, EPItems.ALUMINUM_GOLDEN_AXE.get());
        aluminumSmithingUpgrade(consumer, Items.GOLDEN_PICKAXE, EPItems.ALUMINUM_GOLDEN_PICKAXE.get());
        aluminumSmithingUpgrade(consumer, Items.GOLDEN_SHOVEL, EPItems.ALUMINUM_GOLDEN_SHOVEL.get());
        aluminumSmithingUpgrade(consumer, Items.GOLDEN_HOE, EPItems.ALUMINUM_GOLDEN_HOE.get());
        aluminumSmithingUpgrade(consumer, EPItems.GOLDEN_POLISHER.get(), EPItems.ALUMINUM_GOLDEN_POLISHER.get());
        aluminumSmithingUpgrade(consumer, EPItems.GOLDEN_DAGGER.get(), EPItems.ALUMINUM_GOLDEN_DAGGER.get());

        aluminumSmithingUpgrade(consumer, EPItems.REINFORCED_GOLDEN_SWORD.get(), EPItems.ALUMINUM_GOLDEN_SWORD.get());
        aluminumSmithingUpgrade(consumer, EPItems.REINFORCED_GOLDEN_AXE.get(), EPItems.ALUMINUM_GOLDEN_AXE.get());
        aluminumSmithingUpgrade(consumer, EPItems.REINFORCED_GOLDEN_PICKAXE.get(), EPItems.ALUMINUM_GOLDEN_PICKAXE.get());
        aluminumSmithingUpgrade(consumer, EPItems.REINFORCED_GOLDEN_SHOVEL.get(), EPItems.ALUMINUM_GOLDEN_SHOVEL.get());
        aluminumSmithingUpgrade(consumer, EPItems.REINFORCED_GOLDEN_HOE.get(), EPItems.ALUMINUM_GOLDEN_HOE.get());
        aluminumSmithingUpgrade(consumer, EPItems.REINFORCED_GOLDEN_POLISHER.get(), EPItems.ALUMINUM_GOLDEN_POLISHER.get());
        aluminumSmithingUpgrade(consumer, EPItems.REINFORCED_GOLDEN_DAGGER.get(), EPItems.ALUMINUM_GOLDEN_DAGGER.get());

        //Silver
        aluminumSmithingUpgrade(consumer, EPItems.SILVER_SWORD.get(), EPItems.ALUMINUM_SILVER_SWORD.get());
        aluminumSmithingUpgrade(consumer, EPItems.SILVER_AXE.get(), EPItems.ALUMINUM_SILVER_AXE.get());
        aluminumSmithingUpgrade(consumer, EPItems.SILVER_PICKAXE.get(), EPItems.ALUMINUM_SILVER_PICKAXE.get());
        aluminumSmithingUpgrade(consumer, EPItems.SILVER_SHOVEL.get(), EPItems.ALUMINUM_SILVER_SHOVEL.get());
        aluminumSmithingUpgrade(consumer, EPItems.SILVER_HOE.get(), EPItems.ALUMINUM_SILVER_HOE.get());
        aluminumSmithingUpgrade(consumer, EPItems.GOLDEN_POLISHER.get(), EPItems.ALUMINUM_SILVER_POLISHER.get());
        aluminumSmithingUpgrade(consumer, EPItems.SILVER_DAGGER.get(), EPItems.ALUMINUM_SILVER_DAGGER.get());

        aluminumSmithingUpgrade(consumer, EPItems.REINFORCED_SILVER_SWORD.get(), EPItems.ALUMINUM_SILVER_SWORD.get());
        aluminumSmithingUpgrade(consumer, EPItems.REINFORCED_SILVER_AXE.get(), EPItems.ALUMINUM_SILVER_AXE.get());
        aluminumSmithingUpgrade(consumer, EPItems.REINFORCED_SILVER_PICKAXE.get(), EPItems.ALUMINUM_SILVER_PICKAXE.get());
        aluminumSmithingUpgrade(consumer, EPItems.REINFORCED_SILVER_SHOVEL.get(), EPItems.ALUMINUM_SILVER_SHOVEL.get());
        aluminumSmithingUpgrade(consumer, EPItems.REINFORCED_SILVER_HOE.get(), EPItems.ALUMINUM_SILVER_HOE.get());
        aluminumSmithingUpgrade(consumer, EPItems.REINFORCED_GOLDEN_POLISHER.get(), EPItems.ALUMINUM_SILVER_POLISHER.get());
        aluminumSmithingUpgrade(consumer, EPItems.REINFORCED_SILVER_DAGGER.get(), EPItems.ALUMINUM_SILVER_DAGGER.get());

        //Iron
        aluminumSmithingUpgrade(consumer, Items.IRON_SWORD, EPItems.ALUMINUM_IRON_SWORD.get());
        aluminumSmithingUpgrade(consumer, Items.IRON_AXE, EPItems.ALUMINUM_IRON_AXE.get());
        aluminumSmithingUpgrade(consumer, Items.IRON_PICKAXE, EPItems.ALUMINUM_IRON_PICKAXE.get());
        aluminumSmithingUpgrade(consumer, Items.IRON_SHOVEL, EPItems.ALUMINUM_IRON_SHOVEL.get());
        aluminumSmithingUpgrade(consumer, Items.IRON_HOE, EPItems.ALUMINUM_IRON_HOE.get());
        aluminumSmithingUpgrade(consumer, EPItems.IRON_POLISHER.get(), EPItems.ALUMINUM_IRON_POLISHER.get());
        aluminumSmithingUpgrade(consumer, EPItems.IRON_DAGGER.get(), EPItems.ALUMINUM_IRON_DAGGER.get());

        aluminumSmithingUpgrade(consumer, EPItems.REINFORCED_IRON_SWORD.get(), EPItems.ALUMINUM_IRON_SWORD.get());
        aluminumSmithingUpgrade(consumer, EPItems.REINFORCED_IRON_AXE.get(), EPItems.ALUMINUM_IRON_AXE.get());
        aluminumSmithingUpgrade(consumer, EPItems.REINFORCED_IRON_PICKAXE.get(), EPItems.ALUMINUM_IRON_PICKAXE.get());
        aluminumSmithingUpgrade(consumer, EPItems.REINFORCED_IRON_SHOVEL.get(), EPItems.ALUMINUM_IRON_SHOVEL.get());
        aluminumSmithingUpgrade(consumer, EPItems.REINFORCED_IRON_HOE.get(), EPItems.ALUMINUM_IRON_HOE.get());
        aluminumSmithingUpgrade(consumer, EPItems.REINFORCED_IRON_POLISHER.get(), EPItems.ALUMINUM_IRON_POLISHER.get());
        aluminumSmithingUpgrade(consumer, EPItems.REINFORCED_IRON_DAGGER.get(), EPItems.ALUMINUM_IRON_DAGGER.get());

        //Bronze
        aluminumSmithingUpgrade(consumer, EPItems.BRONZE_SWORD.get(), EPItems.ALUMINUM_BRONZE_SWORD.get());
        aluminumSmithingUpgrade(consumer, EPItems.BRONZE_AXE.get(), EPItems.ALUMINUM_BRONZE_AXE.get());
        aluminumSmithingUpgrade(consumer, EPItems.BRONZE_PICKAXE.get(), EPItems.ALUMINUM_BRONZE_PICKAXE.get());
        aluminumSmithingUpgrade(consumer, EPItems.BRONZE_SHOVEL.get(), EPItems.ALUMINUM_BRONZE_SHOVEL.get());
        aluminumSmithingUpgrade(consumer, EPItems.BRONZE_HOE.get(), EPItems.ALUMINUM_BRONZE_HOE.get());
        aluminumSmithingUpgrade(consumer, EPItems.BRONZE_POLISHER.get(), EPItems.ALUMINUM_BRONZE_POLISHER.get());
        aluminumSmithingUpgrade(consumer, EPItems.BRONZE_DAGGER.get(), EPItems.ALUMINUM_BRONZE_DAGGER.get());

        aluminumSmithingUpgrade(consumer, EPItems.REINFORCED_BRONZE_SWORD.get(), EPItems.ALUMINUM_BRONZE_SWORD.get());
        aluminumSmithingUpgrade(consumer, EPItems.REINFORCED_BRONZE_AXE.get(), EPItems.ALUMINUM_BRONZE_AXE.get());
        aluminumSmithingUpgrade(consumer, EPItems.REINFORCED_BRONZE_PICKAXE.get(), EPItems.ALUMINUM_BRONZE_PICKAXE.get());
        aluminumSmithingUpgrade(consumer, EPItems.REINFORCED_BRONZE_SHOVEL.get(), EPItems.ALUMINUM_BRONZE_SHOVEL.get());
        aluminumSmithingUpgrade(consumer, EPItems.REINFORCED_BRONZE_HOE.get(), EPItems.ALUMINUM_BRONZE_HOE.get());
        aluminumSmithingUpgrade(consumer, EPItems.REINFORCED_BRONZE_POLISHER.get(), EPItems.ALUMINUM_BRONZE_POLISHER.get());
        aluminumSmithingUpgrade(consumer, EPItems.REINFORCED_BRONZE_DAGGER.get(), EPItems.ALUMINUM_BRONZE_DAGGER.get());

        //Brass
        aluminumSmithingUpgrade(consumer, EPItems.BRASS_SWORD.get(), EPItems.ALUMINUM_BRASS_SWORD.get());
        aluminumSmithingUpgrade(consumer, EPItems.BRASS_AXE.get(), EPItems.ALUMINUM_BRASS_AXE.get());
        aluminumSmithingUpgrade(consumer, EPItems.BRASS_PICKAXE.get(), EPItems.ALUMINUM_BRASS_PICKAXE.get());
        aluminumSmithingUpgrade(consumer, EPItems.BRASS_SHOVEL.get(), EPItems.ALUMINUM_BRASS_SHOVEL.get());
        aluminumSmithingUpgrade(consumer, EPItems.BRASS_HOE.get(), EPItems.ALUMINUM_BRASS_HOE.get());
        aluminumSmithingUpgrade(consumer, EPItems.BRASS_POLISHER.get(), EPItems.ALUMINUM_BRASS_POLISHER.get());
        aluminumSmithingUpgrade(consumer, EPItems.BRASS_DAGGER.get(), EPItems.ALUMINUM_BRASS_DAGGER.get());

        aluminumSmithingUpgrade(consumer, EPItems.REINFORCED_BRASS_SWORD.get(), EPItems.ALUMINUM_BRASS_SWORD.get());
        aluminumSmithingUpgrade(consumer, EPItems.REINFORCED_BRASS_AXE.get(), EPItems.ALUMINUM_BRASS_AXE.get());
        aluminumSmithingUpgrade(consumer, EPItems.REINFORCED_BRASS_PICKAXE.get(), EPItems.ALUMINUM_BRASS_PICKAXE.get());
        aluminumSmithingUpgrade(consumer, EPItems.REINFORCED_BRASS_SHOVEL.get(), EPItems.ALUMINUM_BRASS_SHOVEL.get());
        aluminumSmithingUpgrade(consumer, EPItems.REINFORCED_BRASS_HOE.get(), EPItems.ALUMINUM_BRASS_HOE.get());
        aluminumSmithingUpgrade(consumer, EPItems.REINFORCED_BRASS_POLISHER.get(), EPItems.ALUMINUM_BRASS_POLISHER.get());
        aluminumSmithingUpgrade(consumer, EPItems.REINFORCED_BRASS_DAGGER.get(), EPItems.ALUMINUM_BRASS_DAGGER.get());

        //Rose Gold
        aluminumSmithingUpgrade(consumer, EPItems.ROSE_GOLDEN_SWORD.get(), EPItems.ALUMINUM_ROSE_GOLDEN_SWORD.get());
        aluminumSmithingUpgrade(consumer, EPItems.ROSE_GOLDEN_AXE.get(), EPItems.ALUMINUM_ROSE_GOLDEN_AXE.get());
        aluminumSmithingUpgrade(consumer, EPItems.ROSE_GOLDEN_PICKAXE.get(), EPItems.ALUMINUM_ROSE_GOLDEN_PICKAXE.get());
        aluminumSmithingUpgrade(consumer, EPItems.ROSE_GOLDEN_SHOVEL.get(), EPItems.ALUMINUM_ROSE_GOLDEN_SHOVEL.get());
        aluminumSmithingUpgrade(consumer, EPItems.ROSE_GOLDEN_HOE.get(), EPItems.ALUMINUM_ROSE_GOLDEN_HOE.get());
        aluminumSmithingUpgrade(consumer, EPItems.ROSE_GOLDEN_POLISHER.get(), EPItems.ALUMINUM_ROSE_GOLDEN_POLISHER.get());
        aluminumSmithingUpgrade(consumer, EPItems.ROSE_GOLDEN_DAGGER.get(), EPItems.ALUMINUM_ROSE_GOLDEN_DAGGER.get());

        aluminumSmithingUpgrade(consumer, EPItems.REINFORCED_ROSE_GOLDEN_SWORD.get(), EPItems.ALUMINUM_ROSE_GOLDEN_SWORD.get());
        aluminumSmithingUpgrade(consumer, EPItems.REINFORCED_ROSE_GOLDEN_AXE.get(), EPItems.ALUMINUM_ROSE_GOLDEN_AXE.get());
        aluminumSmithingUpgrade(consumer, EPItems.REINFORCED_ROSE_GOLDEN_PICKAXE.get(), EPItems.ALUMINUM_ROSE_GOLDEN_PICKAXE.get());
        aluminumSmithingUpgrade(consumer, EPItems.REINFORCED_ROSE_GOLDEN_SHOVEL.get(), EPItems.ALUMINUM_ROSE_GOLDEN_SHOVEL.get());
        aluminumSmithingUpgrade(consumer, EPItems.REINFORCED_ROSE_GOLDEN_HOE.get(), EPItems.ALUMINUM_ROSE_GOLDEN_HOE.get());
        aluminumSmithingUpgrade(consumer, EPItems.REINFORCED_ROSE_GOLDEN_POLISHER.get(), EPItems.ALUMINUM_ROSE_GOLDEN_POLISHER.get());
        aluminumSmithingUpgrade(consumer, EPItems.REINFORCED_ROSE_GOLDEN_DAGGER.get(), EPItems.ALUMINUM_ROSE_GOLDEN_DAGGER.get());

        //Bronzium
        aluminumSmithingUpgrade(consumer, EPItems.BRONZIUM_SWORD.get(), EPItems.ALUMINUM_BRONZIUM_SWORD.get());
        aluminumSmithingUpgrade(consumer, EPItems.BRONZIUM_AXE.get(), EPItems.ALUMINUM_BRONZIUM_AXE.get());
        aluminumSmithingUpgrade(consumer, EPItems.BRONZIUM_PICKAXE.get(), EPItems.ALUMINUM_BRONZIUM_PICKAXE.get());
        aluminumSmithingUpgrade(consumer, EPItems.BRONZIUM_SHOVEL.get(), EPItems.ALUMINUM_BRONZIUM_SHOVEL.get());
        aluminumSmithingUpgrade(consumer, EPItems.BRONZIUM_HOE.get(), EPItems.ALUMINUM_BRONZIUM_HOE.get());
        aluminumSmithingUpgrade(consumer, EPItems.BRONZIUM_POLISHER.get(), EPItems.ALUMINUM_BRONZIUM_POLISHER.get());
        aluminumSmithingUpgrade(consumer, EPItems.BRONZIUM_DAGGER.get(), EPItems.ALUMINUM_BRONZIUM_DAGGER.get());

        aluminumSmithingUpgrade(consumer, EPItems.REINFORCED_BRONZIUM_SWORD.get(), EPItems.ALUMINUM_BRONZIUM_SWORD.get());
        aluminumSmithingUpgrade(consumer, EPItems.REINFORCED_BRONZIUM_AXE.get(), EPItems.ALUMINUM_BRONZIUM_AXE.get());
        aluminumSmithingUpgrade(consumer, EPItems.REINFORCED_BRONZIUM_PICKAXE.get(), EPItems.ALUMINUM_BRONZIUM_PICKAXE.get());
        aluminumSmithingUpgrade(consumer, EPItems.REINFORCED_BRONZIUM_SHOVEL.get(), EPItems.ALUMINUM_BRONZIUM_SHOVEL.get());
        aluminumSmithingUpgrade(consumer, EPItems.REINFORCED_BRONZIUM_HOE.get(), EPItems.ALUMINUM_BRONZIUM_HOE.get());
        aluminumSmithingUpgrade(consumer, EPItems.REINFORCED_BRONZIUM_POLISHER.get(), EPItems.ALUMINUM_BRONZIUM_POLISHER.get());
        aluminumSmithingUpgrade(consumer, EPItems.REINFORCED_BRONZIUM_DAGGER.get(), EPItems.ALUMINUM_BRONZIUM_DAGGER.get());

        //Steel
        aluminumSmithingUpgrade(consumer, EPItems.STEEL_SWORD.get(), EPItems.ALUMINUM_STEEL_SWORD.get());
        aluminumSmithingUpgrade(consumer, EPItems.STEEL_AXE.get(), EPItems.ALUMINUM_STEEL_AXE.get());
        aluminumSmithingUpgrade(consumer, EPItems.STEEL_PICKAXE.get(), EPItems.ALUMINUM_STEEL_PICKAXE.get());
        aluminumSmithingUpgrade(consumer, EPItems.STEEL_SHOVEL.get(), EPItems.ALUMINUM_STEEL_SHOVEL.get());
        aluminumSmithingUpgrade(consumer, EPItems.STEEL_HOE.get(), EPItems.ALUMINUM_STEEL_HOE.get());
        aluminumSmithingUpgrade(consumer, EPItems.STEEL_POLISHER.get(), EPItems.ALUMINUM_STEEL_POLISHER.get());
        aluminumSmithingUpgrade(consumer, EPItems.STEEL_DAGGER.get(), EPItems.ALUMINUM_STEEL_DAGGER.get());

        aluminumSmithingUpgrade(consumer, EPItems.REINFORCED_STEEL_SWORD.get(), EPItems.ALUMINUM_STEEL_SWORD.get());
        aluminumSmithingUpgrade(consumer, EPItems.REINFORCED_STEEL_AXE.get(), EPItems.ALUMINUM_STEEL_AXE.get());
        aluminumSmithingUpgrade(consumer, EPItems.REINFORCED_STEEL_PICKAXE.get(), EPItems.ALUMINUM_STEEL_PICKAXE.get());
        aluminumSmithingUpgrade(consumer, EPItems.REINFORCED_STEEL_SHOVEL.get(), EPItems.ALUMINUM_STEEL_SHOVEL.get());
        aluminumSmithingUpgrade(consumer, EPItems.REINFORCED_STEEL_HOE.get(), EPItems.ALUMINUM_STEEL_HOE.get());
        aluminumSmithingUpgrade(consumer, EPItems.REINFORCED_STEEL_POLISHER.get(), EPItems.ALUMINUM_STEEL_POLISHER.get());
        aluminumSmithingUpgrade(consumer, EPItems.REINFORCED_STEEL_DAGGER.get(), EPItems.ALUMINUM_STEEL_DAGGER.get());

        //Green Gold
        aluminumSmithingUpgrade(consumer, EPItems.GREEN_GOLDEN_SWORD.get(), EPItems.ALUMINUM_GREEN_GOLDEN_SWORD.get());
        aluminumSmithingUpgrade(consumer, EPItems.GREEN_GOLDEN_AXE.get(), EPItems.ALUMINUM_GREEN_GOLDEN_AXE.get());
        aluminumSmithingUpgrade(consumer, EPItems.GREEN_GOLDEN_PICKAXE.get(), EPItems.ALUMINUM_GREEN_GOLDEN_PICKAXE.get());
        aluminumSmithingUpgrade(consumer, EPItems.GREEN_GOLDEN_SHOVEL.get(), EPItems.ALUMINUM_GREEN_GOLDEN_SHOVEL.get());
        aluminumSmithingUpgrade(consumer, EPItems.GREEN_GOLDEN_HOE.get(), EPItems.ALUMINUM_GREEN_GOLDEN_HOE.get());
        aluminumSmithingUpgrade(consumer, EPItems.GREEN_GOLDEN_POLISHER.get(), EPItems.ALUMINUM_GREEN_GOLDEN_POLISHER.get());
        aluminumSmithingUpgrade(consumer, EPItems.GREEN_GOLDEN_DAGGER.get(), EPItems.ALUMINUM_GREEN_GOLDEN_DAGGER.get());

        aluminumSmithingUpgrade(consumer, EPItems.REINFORCED_GREEN_GOLDEN_SWORD.get(), EPItems.ALUMINUM_GREEN_GOLDEN_SWORD.get());
        aluminumSmithingUpgrade(consumer, EPItems.REINFORCED_GREEN_GOLDEN_AXE.get(), EPItems.ALUMINUM_GREEN_GOLDEN_AXE.get());
        aluminumSmithingUpgrade(consumer, EPItems.REINFORCED_GREEN_GOLDEN_PICKAXE.get(), EPItems.ALUMINUM_GREEN_GOLDEN_PICKAXE.get());
        aluminumSmithingUpgrade(consumer, EPItems.REINFORCED_GREEN_GOLDEN_SHOVEL.get(), EPItems.ALUMINUM_GREEN_GOLDEN_SHOVEL.get());
        aluminumSmithingUpgrade(consumer, EPItems.REINFORCED_GREEN_GOLDEN_HOE.get(), EPItems.ALUMINUM_GREEN_GOLDEN_HOE.get());
        aluminumSmithingUpgrade(consumer, EPItems.REINFORCED_GREEN_GOLDEN_POLISHER.get(), EPItems.ALUMINUM_GREEN_GOLDEN_POLISHER.get());
        aluminumSmithingUpgrade(consumer, EPItems.REINFORCED_GREEN_GOLDEN_DAGGER.get(), EPItems.ALUMINUM_GREEN_GOLDEN_DAGGER.get());

        //Blue Gold
        aluminumSmithingUpgrade(consumer, EPItems.BLUE_GOLDEN_SWORD.get(), EPItems.ALUMINUM_BLUE_GOLDEN_SWORD.get());
        aluminumSmithingUpgrade(consumer, EPItems.BLUE_GOLDEN_AXE.get(), EPItems.ALUMINUM_BLUE_GOLDEN_AXE.get());
        aluminumSmithingUpgrade(consumer, EPItems.BLUE_GOLDEN_PICKAXE.get(), EPItems.ALUMINUM_BLUE_GOLDEN_PICKAXE.get());
        aluminumSmithingUpgrade(consumer, EPItems.BLUE_GOLDEN_SHOVEL.get(), EPItems.ALUMINUM_BLUE_GOLDEN_SHOVEL.get());
        aluminumSmithingUpgrade(consumer, EPItems.BLUE_GOLDEN_HOE.get(), EPItems.ALUMINUM_BLUE_GOLDEN_HOE.get());
        aluminumSmithingUpgrade(consumer, EPItems.BLUE_GOLDEN_POLISHER.get(), EPItems.ALUMINUM_BLUE_GOLDEN_POLISHER.get());
        aluminumSmithingUpgrade(consumer, EPItems.BLUE_GOLDEN_DAGGER.get(), EPItems.ALUMINUM_BLUE_GOLDEN_DAGGER.get());

        aluminumSmithingUpgrade(consumer, EPItems.REINFORCED_BLUE_GOLDEN_SWORD.get(), EPItems.ALUMINUM_BLUE_GOLDEN_SWORD.get());
        aluminumSmithingUpgrade(consumer, EPItems.REINFORCED_BLUE_GOLDEN_AXE.get(), EPItems.ALUMINUM_BLUE_GOLDEN_AXE.get());
        aluminumSmithingUpgrade(consumer, EPItems.REINFORCED_BLUE_GOLDEN_PICKAXE.get(), EPItems.ALUMINUM_BLUE_GOLDEN_PICKAXE.get());
        aluminumSmithingUpgrade(consumer, EPItems.REINFORCED_BLUE_GOLDEN_SHOVEL.get(), EPItems.ALUMINUM_BLUE_GOLDEN_SHOVEL.get());
        aluminumSmithingUpgrade(consumer, EPItems.REINFORCED_BLUE_GOLDEN_HOE.get(), EPItems.ALUMINUM_BLUE_GOLDEN_HOE.get());
        aluminumSmithingUpgrade(consumer, EPItems.REINFORCED_BLUE_GOLDEN_POLISHER.get(), EPItems.ALUMINUM_BLUE_GOLDEN_POLISHER.get());
        aluminumSmithingUpgrade(consumer, EPItems.REINFORCED_BLUE_GOLDEN_DAGGER.get(), EPItems.ALUMINUM_BLUE_GOLDEN_DAGGER.get());

        //Diamond
        aluminumSmithingUpgrade(consumer, Items.DIAMOND_SWORD, EPItems.ALUMINUM_DIAMOND_SWORD.get());
        aluminumSmithingUpgrade(consumer, Items.DIAMOND_AXE, EPItems.ALUMINUM_DIAMOND_AXE.get());
        aluminumSmithingUpgrade(consumer, Items.DIAMOND_PICKAXE, EPItems.ALUMINUM_DIAMOND_PICKAXE.get());
        aluminumSmithingUpgrade(consumer, Items.DIAMOND_SHOVEL, EPItems.ALUMINUM_DIAMOND_SHOVEL.get());
        aluminumSmithingUpgrade(consumer, Items.DIAMOND_HOE, EPItems.ALUMINUM_DIAMOND_HOE.get());
        aluminumSmithingUpgrade(consumer, EPItems.DIAMOND_POLISHER.get(), EPItems.ALUMINUM_DIAMOND_POLISHER.get());
        aluminumSmithingUpgrade(consumer, EPItems.DIAMOND_DAGGER.get(), EPItems.ALUMINUM_DIAMOND_DAGGER.get());

        aluminumSmithingUpgrade(consumer, EPItems.REINFORCED_DIAMOND_SWORD.get(), EPItems.ALUMINUM_DIAMOND_SWORD.get());
        aluminumSmithingUpgrade(consumer, EPItems.REINFORCED_DIAMOND_AXE.get(), EPItems.ALUMINUM_DIAMOND_AXE.get());
        aluminumSmithingUpgrade(consumer, EPItems.REINFORCED_DIAMOND_PICKAXE.get(), EPItems.ALUMINUM_DIAMOND_PICKAXE.get());
        aluminumSmithingUpgrade(consumer, EPItems.REINFORCED_DIAMOND_SHOVEL.get(), EPItems.ALUMINUM_DIAMOND_SHOVEL.get());
        aluminumSmithingUpgrade(consumer, EPItems.REINFORCED_DIAMOND_HOE.get(), EPItems.ALUMINUM_DIAMOND_HOE.get());
        aluminumSmithingUpgrade(consumer, EPItems.REINFORCED_DIAMOND_POLISHER.get(), EPItems.ALUMINUM_DIAMOND_POLISHER.get());
        aluminumSmithingUpgrade(consumer, EPItems.REINFORCED_DIAMOND_DAGGER.get(), EPItems.ALUMINUM_DIAMOND_DAGGER.get());
    }

    private static void addPurpleGoldUpgrades(Consumer<FinishedRecipe> consumer){
        //Gold
        purpleGoldSmithingUpgrade(consumer, Items.GOLDEN_SWORD, EPItems.PURPLE_GOLD_GOLDEN_SWORD.get());
        purpleGoldSmithingUpgrade(consumer, Items.GOLDEN_AXE, EPItems.PURPLE_GOLD_GOLDEN_AXE.get());
        purpleGoldSmithingUpgrade(consumer, Items.GOLDEN_PICKAXE, EPItems.PURPLE_GOLD_GOLDEN_PICKAXE.get());
        purpleGoldSmithingUpgrade(consumer, Items.GOLDEN_SHOVEL, EPItems.PURPLE_GOLD_GOLDEN_SHOVEL.get());
        purpleGoldSmithingUpgrade(consumer, Items.GOLDEN_HOE, EPItems.PURPLE_GOLD_GOLDEN_HOE.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.GOLDEN_POLISHER.get(), EPItems.PURPLE_GOLD_GOLDEN_POLISHER.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.GOLDEN_DAGGER.get(), EPItems.PURPLE_GOLD_GOLDEN_DAGGER.get());

        purpleGoldSmithingUpgrade(consumer, EPItems.REINFORCED_GOLDEN_SWORD.get(), EPItems.PURPLE_GOLD_GOLDEN_SWORD.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.REINFORCED_GOLDEN_AXE.get(), EPItems.PURPLE_GOLD_GOLDEN_AXE.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.REINFORCED_GOLDEN_PICKAXE.get(), EPItems.PURPLE_GOLD_GOLDEN_PICKAXE.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.REINFORCED_GOLDEN_SHOVEL.get(), EPItems.PURPLE_GOLD_GOLDEN_SHOVEL.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.REINFORCED_GOLDEN_HOE.get(), EPItems.PURPLE_GOLD_GOLDEN_HOE.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.REINFORCED_GOLDEN_POLISHER.get(), EPItems.PURPLE_GOLD_GOLDEN_POLISHER.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.REINFORCED_GOLDEN_DAGGER.get(), EPItems.PURPLE_GOLD_GOLDEN_DAGGER.get());

        //Silver
        purpleGoldSmithingUpgrade(consumer, EPItems.SILVER_SWORD.get(), EPItems.PURPLE_GOLD_SILVER_SWORD.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.SILVER_AXE.get(), EPItems.PURPLE_GOLD_SILVER_AXE.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.SILVER_PICKAXE.get(), EPItems.PURPLE_GOLD_SILVER_PICKAXE.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.SILVER_SHOVEL.get(), EPItems.PURPLE_GOLD_SILVER_SHOVEL.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.SILVER_HOE.get(), EPItems.PURPLE_GOLD_SILVER_HOE.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.GOLDEN_POLISHER.get(), EPItems.PURPLE_GOLD_SILVER_POLISHER.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.SILVER_DAGGER.get(), EPItems.PURPLE_GOLD_SILVER_DAGGER.get());

        purpleGoldSmithingUpgrade(consumer, EPItems.REINFORCED_SILVER_SWORD.get(), EPItems.PURPLE_GOLD_SILVER_SWORD.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.REINFORCED_SILVER_AXE.get(), EPItems.PURPLE_GOLD_SILVER_AXE.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.REINFORCED_SILVER_PICKAXE.get(), EPItems.PURPLE_GOLD_SILVER_PICKAXE.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.REINFORCED_SILVER_SHOVEL.get(), EPItems.PURPLE_GOLD_SILVER_SHOVEL.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.REINFORCED_SILVER_HOE.get(), EPItems.PURPLE_GOLD_SILVER_HOE.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.REINFORCED_GOLDEN_POLISHER.get(), EPItems.PURPLE_GOLD_SILVER_POLISHER.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.REINFORCED_SILVER_DAGGER.get(), EPItems.PURPLE_GOLD_SILVER_DAGGER.get());

        //Iron
        purpleGoldSmithingUpgrade(consumer, Items.IRON_SWORD, EPItems.PURPLE_GOLD_IRON_SWORD.get());
        purpleGoldSmithingUpgrade(consumer, Items.IRON_AXE, EPItems.PURPLE_GOLD_IRON_AXE.get());
        purpleGoldSmithingUpgrade(consumer, Items.IRON_PICKAXE, EPItems.PURPLE_GOLD_IRON_PICKAXE.get());
        purpleGoldSmithingUpgrade(consumer, Items.IRON_SHOVEL, EPItems.PURPLE_GOLD_IRON_SHOVEL.get());
        purpleGoldSmithingUpgrade(consumer, Items.IRON_HOE, EPItems.PURPLE_GOLD_IRON_HOE.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.IRON_POLISHER.get(), EPItems.PURPLE_GOLD_IRON_POLISHER.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.IRON_DAGGER.get(), EPItems.PURPLE_GOLD_IRON_DAGGER.get());

        purpleGoldSmithingUpgrade(consumer, EPItems.REINFORCED_IRON_SWORD.get(), EPItems.PURPLE_GOLD_IRON_SWORD.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.REINFORCED_IRON_AXE.get(), EPItems.PURPLE_GOLD_IRON_AXE.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.REINFORCED_IRON_PICKAXE.get(), EPItems.PURPLE_GOLD_IRON_PICKAXE.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.REINFORCED_IRON_SHOVEL.get(), EPItems.PURPLE_GOLD_IRON_SHOVEL.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.REINFORCED_IRON_HOE.get(), EPItems.PURPLE_GOLD_IRON_HOE.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.REINFORCED_IRON_POLISHER.get(), EPItems.PURPLE_GOLD_IRON_POLISHER.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.REINFORCED_IRON_DAGGER.get(), EPItems.PURPLE_GOLD_IRON_DAGGER.get());

        //Bronze
        purpleGoldSmithingUpgrade(consumer, EPItems.BRONZE_SWORD.get(), EPItems.PURPLE_GOLD_BRONZE_SWORD.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.BRONZE_AXE.get(), EPItems.PURPLE_GOLD_BRONZE_AXE.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.BRONZE_PICKAXE.get(), EPItems.PURPLE_GOLD_BRONZE_PICKAXE.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.BRONZE_SHOVEL.get(), EPItems.PURPLE_GOLD_BRONZE_SHOVEL.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.BRONZE_HOE.get(), EPItems.PURPLE_GOLD_BRONZE_HOE.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.BRONZE_POLISHER.get(), EPItems.PURPLE_GOLD_BRONZE_POLISHER.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.BRONZE_DAGGER.get(), EPItems.PURPLE_GOLD_BRONZE_DAGGER.get());

        purpleGoldSmithingUpgrade(consumer, EPItems.REINFORCED_BRONZE_SWORD.get(), EPItems.PURPLE_GOLD_BRONZE_SWORD.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.REINFORCED_BRONZE_AXE.get(), EPItems.PURPLE_GOLD_BRONZE_AXE.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.REINFORCED_BRONZE_PICKAXE.get(), EPItems.PURPLE_GOLD_BRONZE_PICKAXE.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.REINFORCED_BRONZE_SHOVEL.get(), EPItems.PURPLE_GOLD_BRONZE_SHOVEL.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.REINFORCED_BRONZE_HOE.get(), EPItems.PURPLE_GOLD_BRONZE_HOE.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.REINFORCED_BRONZE_POLISHER.get(), EPItems.PURPLE_GOLD_BRONZE_POLISHER.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.REINFORCED_BRONZE_DAGGER.get(), EPItems.PURPLE_GOLD_BRONZE_DAGGER.get());

        //Brass
        purpleGoldSmithingUpgrade(consumer, EPItems.BRASS_SWORD.get(), EPItems.PURPLE_GOLD_BRASS_SWORD.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.BRASS_AXE.get(), EPItems.PURPLE_GOLD_BRASS_AXE.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.BRASS_PICKAXE.get(), EPItems.PURPLE_GOLD_BRASS_PICKAXE.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.BRASS_SHOVEL.get(), EPItems.PURPLE_GOLD_BRASS_SHOVEL.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.BRASS_HOE.get(), EPItems.PURPLE_GOLD_BRASS_HOE.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.BRASS_POLISHER.get(), EPItems.PURPLE_GOLD_BRASS_POLISHER.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.BRASS_DAGGER.get(), EPItems.PURPLE_GOLD_BRASS_DAGGER.get());

        purpleGoldSmithingUpgrade(consumer, EPItems.REINFORCED_BRASS_SWORD.get(), EPItems.PURPLE_GOLD_BRASS_SWORD.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.REINFORCED_BRASS_AXE.get(), EPItems.PURPLE_GOLD_BRASS_AXE.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.REINFORCED_BRASS_PICKAXE.get(), EPItems.PURPLE_GOLD_BRASS_PICKAXE.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.REINFORCED_BRASS_SHOVEL.get(), EPItems.PURPLE_GOLD_BRASS_SHOVEL.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.REINFORCED_BRASS_HOE.get(), EPItems.PURPLE_GOLD_BRASS_HOE.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.REINFORCED_BRASS_POLISHER.get(), EPItems.PURPLE_GOLD_BRASS_POLISHER.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.REINFORCED_BRASS_DAGGER.get(), EPItems.PURPLE_GOLD_BRASS_DAGGER.get());

        //Rose Gold
        purpleGoldSmithingUpgrade(consumer, EPItems.ROSE_GOLDEN_SWORD.get(), EPItems.PURPLE_GOLD_ROSE_GOLDEN_SWORD.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.ROSE_GOLDEN_AXE.get(), EPItems.PURPLE_GOLD_ROSE_GOLDEN_AXE.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.ROSE_GOLDEN_PICKAXE.get(), EPItems.PURPLE_GOLD_ROSE_GOLDEN_PICKAXE.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.ROSE_GOLDEN_SHOVEL.get(), EPItems.PURPLE_GOLD_ROSE_GOLDEN_SHOVEL.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.ROSE_GOLDEN_HOE.get(), EPItems.PURPLE_GOLD_ROSE_GOLDEN_HOE.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.ROSE_GOLDEN_POLISHER.get(), EPItems.PURPLE_GOLD_ROSE_GOLDEN_POLISHER.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.ROSE_GOLDEN_DAGGER.get(), EPItems.PURPLE_GOLD_ROSE_GOLDEN_DAGGER.get());

        purpleGoldSmithingUpgrade(consumer, EPItems.REINFORCED_ROSE_GOLDEN_SWORD.get(), EPItems.PURPLE_GOLD_ROSE_GOLDEN_SWORD.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.REINFORCED_ROSE_GOLDEN_AXE.get(), EPItems.PURPLE_GOLD_ROSE_GOLDEN_AXE.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.REINFORCED_ROSE_GOLDEN_PICKAXE.get(), EPItems.PURPLE_GOLD_ROSE_GOLDEN_PICKAXE.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.REINFORCED_ROSE_GOLDEN_SHOVEL.get(), EPItems.PURPLE_GOLD_ROSE_GOLDEN_SHOVEL.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.REINFORCED_ROSE_GOLDEN_HOE.get(), EPItems.PURPLE_GOLD_ROSE_GOLDEN_HOE.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.REINFORCED_ROSE_GOLDEN_POLISHER.get(), EPItems.PURPLE_GOLD_ROSE_GOLDEN_POLISHER.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.REINFORCED_ROSE_GOLDEN_DAGGER.get(), EPItems.PURPLE_GOLD_ROSE_GOLDEN_DAGGER.get());

        //Bronzium
        purpleGoldSmithingUpgrade(consumer, EPItems.BRONZIUM_SWORD.get(), EPItems.PURPLE_GOLD_BRONZIUM_SWORD.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.BRONZIUM_AXE.get(), EPItems.PURPLE_GOLD_BRONZIUM_AXE.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.BRONZIUM_PICKAXE.get(), EPItems.PURPLE_GOLD_BRONZIUM_PICKAXE.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.BRONZIUM_SHOVEL.get(), EPItems.PURPLE_GOLD_BRONZIUM_SHOVEL.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.BRONZIUM_HOE.get(), EPItems.PURPLE_GOLD_BRONZIUM_HOE.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.BRONZIUM_POLISHER.get(), EPItems.PURPLE_GOLD_BRONZIUM_POLISHER.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.BRONZIUM_DAGGER.get(), EPItems.PURPLE_GOLD_BRONZIUM_DAGGER.get());

        purpleGoldSmithingUpgrade(consumer, EPItems.REINFORCED_BRONZIUM_SWORD.get(), EPItems.PURPLE_GOLD_BRONZIUM_SWORD.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.REINFORCED_BRONZIUM_AXE.get(), EPItems.PURPLE_GOLD_BRONZIUM_AXE.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.REINFORCED_BRONZIUM_PICKAXE.get(), EPItems.PURPLE_GOLD_BRONZIUM_PICKAXE.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.REINFORCED_BRONZIUM_SHOVEL.get(), EPItems.PURPLE_GOLD_BRONZIUM_SHOVEL.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.REINFORCED_BRONZIUM_HOE.get(), EPItems.PURPLE_GOLD_BRONZIUM_HOE.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.REINFORCED_BRONZIUM_POLISHER.get(), EPItems.PURPLE_GOLD_BRONZIUM_POLISHER.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.REINFORCED_BRONZIUM_DAGGER.get(), EPItems.PURPLE_GOLD_BRONZIUM_DAGGER.get());

        //Steel
        purpleGoldSmithingUpgrade(consumer, EPItems.STEEL_SWORD.get(), EPItems.PURPLE_GOLD_STEEL_SWORD.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.STEEL_AXE.get(), EPItems.PURPLE_GOLD_STEEL_AXE.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.STEEL_PICKAXE.get(), EPItems.PURPLE_GOLD_STEEL_PICKAXE.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.STEEL_SHOVEL.get(), EPItems.PURPLE_GOLD_STEEL_SHOVEL.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.STEEL_HOE.get(), EPItems.PURPLE_GOLD_STEEL_HOE.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.STEEL_POLISHER.get(), EPItems.PURPLE_GOLD_STEEL_POLISHER.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.STEEL_DAGGER.get(), EPItems.PURPLE_GOLD_STEEL_DAGGER.get());

        purpleGoldSmithingUpgrade(consumer, EPItems.REINFORCED_STEEL_SWORD.get(), EPItems.PURPLE_GOLD_STEEL_SWORD.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.REINFORCED_STEEL_AXE.get(), EPItems.PURPLE_GOLD_STEEL_AXE.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.REINFORCED_STEEL_PICKAXE.get(), EPItems.PURPLE_GOLD_STEEL_PICKAXE.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.REINFORCED_STEEL_SHOVEL.get(), EPItems.PURPLE_GOLD_STEEL_SHOVEL.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.REINFORCED_STEEL_HOE.get(), EPItems.PURPLE_GOLD_STEEL_HOE.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.REINFORCED_STEEL_POLISHER.get(), EPItems.PURPLE_GOLD_STEEL_POLISHER.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.REINFORCED_STEEL_DAGGER.get(), EPItems.PURPLE_GOLD_STEEL_DAGGER.get());

        //Green Gold
        purpleGoldSmithingUpgrade(consumer, EPItems.GREEN_GOLDEN_SWORD.get(), EPItems.PURPLE_GOLD_GREEN_GOLDEN_SWORD.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.GREEN_GOLDEN_AXE.get(), EPItems.PURPLE_GOLD_GREEN_GOLDEN_AXE.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.GREEN_GOLDEN_PICKAXE.get(), EPItems.PURPLE_GOLD_GREEN_GOLDEN_PICKAXE.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.GREEN_GOLDEN_SHOVEL.get(), EPItems.PURPLE_GOLD_GREEN_GOLDEN_SHOVEL.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.GREEN_GOLDEN_HOE.get(), EPItems.PURPLE_GOLD_GREEN_GOLDEN_HOE.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.GREEN_GOLDEN_POLISHER.get(), EPItems.PURPLE_GOLD_GREEN_GOLDEN_POLISHER.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.GREEN_GOLDEN_DAGGER.get(), EPItems.PURPLE_GOLD_GREEN_GOLDEN_DAGGER.get());

        purpleGoldSmithingUpgrade(consumer, EPItems.REINFORCED_GREEN_GOLDEN_SWORD.get(), EPItems.PURPLE_GOLD_GREEN_GOLDEN_SWORD.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.REINFORCED_GREEN_GOLDEN_AXE.get(), EPItems.PURPLE_GOLD_GREEN_GOLDEN_AXE.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.REINFORCED_GREEN_GOLDEN_PICKAXE.get(), EPItems.PURPLE_GOLD_GREEN_GOLDEN_PICKAXE.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.REINFORCED_GREEN_GOLDEN_SHOVEL.get(), EPItems.PURPLE_GOLD_GREEN_GOLDEN_SHOVEL.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.REINFORCED_GREEN_GOLDEN_HOE.get(), EPItems.PURPLE_GOLD_GREEN_GOLDEN_HOE.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.REINFORCED_GREEN_GOLDEN_POLISHER.get(), EPItems.PURPLE_GOLD_GREEN_GOLDEN_POLISHER.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.REINFORCED_GREEN_GOLDEN_DAGGER.get(), EPItems.PURPLE_GOLD_GREEN_GOLDEN_DAGGER.get());

        //Blue Gold
        purpleGoldSmithingUpgrade(consumer, EPItems.BLUE_GOLDEN_SWORD.get(), EPItems.PURPLE_GOLD_BLUE_GOLDEN_SWORD.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.BLUE_GOLDEN_AXE.get(), EPItems.PURPLE_GOLD_BLUE_GOLDEN_AXE.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.BLUE_GOLDEN_PICKAXE.get(), EPItems.PURPLE_GOLD_BLUE_GOLDEN_PICKAXE.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.BLUE_GOLDEN_SHOVEL.get(), EPItems.PURPLE_GOLD_BLUE_GOLDEN_SHOVEL.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.BLUE_GOLDEN_HOE.get(), EPItems.PURPLE_GOLD_BLUE_GOLDEN_HOE.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.BLUE_GOLDEN_POLISHER.get(), EPItems.PURPLE_GOLD_BLUE_GOLDEN_POLISHER.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.BLUE_GOLDEN_DAGGER.get(), EPItems.PURPLE_GOLD_BLUE_GOLDEN_DAGGER.get());

        purpleGoldSmithingUpgrade(consumer, EPItems.REINFORCED_BLUE_GOLDEN_SWORD.get(), EPItems.PURPLE_GOLD_BLUE_GOLDEN_SWORD.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.REINFORCED_BLUE_GOLDEN_AXE.get(), EPItems.PURPLE_GOLD_BLUE_GOLDEN_AXE.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.REINFORCED_BLUE_GOLDEN_PICKAXE.get(), EPItems.PURPLE_GOLD_BLUE_GOLDEN_PICKAXE.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.REINFORCED_BLUE_GOLDEN_SHOVEL.get(), EPItems.PURPLE_GOLD_BLUE_GOLDEN_SHOVEL.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.REINFORCED_BLUE_GOLDEN_HOE.get(), EPItems.PURPLE_GOLD_BLUE_GOLDEN_HOE.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.REINFORCED_BLUE_GOLDEN_POLISHER.get(), EPItems.PURPLE_GOLD_BLUE_GOLDEN_POLISHER.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.REINFORCED_BLUE_GOLDEN_DAGGER.get(), EPItems.PURPLE_GOLD_BLUE_GOLDEN_DAGGER.get());

        //Diamond
        purpleGoldSmithingUpgrade(consumer, Items.DIAMOND_SWORD, EPItems.PURPLE_GOLD_DIAMOND_SWORD.get());
        purpleGoldSmithingUpgrade(consumer, Items.DIAMOND_AXE, EPItems.PURPLE_GOLD_DIAMOND_AXE.get());
        purpleGoldSmithingUpgrade(consumer, Items.DIAMOND_PICKAXE, EPItems.PURPLE_GOLD_DIAMOND_PICKAXE.get());
        purpleGoldSmithingUpgrade(consumer, Items.DIAMOND_SHOVEL, EPItems.PURPLE_GOLD_DIAMOND_SHOVEL.get());
        purpleGoldSmithingUpgrade(consumer, Items.DIAMOND_HOE, EPItems.PURPLE_GOLD_DIAMOND_HOE.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.DIAMOND_POLISHER.get(), EPItems.PURPLE_GOLD_DIAMOND_POLISHER.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.DIAMOND_DAGGER.get(), EPItems.PURPLE_GOLD_DIAMOND_DAGGER.get());

        purpleGoldSmithingUpgrade(consumer, EPItems.REINFORCED_DIAMOND_SWORD.get(), EPItems.PURPLE_GOLD_DIAMOND_SWORD.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.REINFORCED_DIAMOND_AXE.get(), EPItems.PURPLE_GOLD_DIAMOND_AXE.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.REINFORCED_DIAMOND_PICKAXE.get(), EPItems.PURPLE_GOLD_DIAMOND_PICKAXE.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.REINFORCED_DIAMOND_SHOVEL.get(), EPItems.PURPLE_GOLD_DIAMOND_SHOVEL.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.REINFORCED_DIAMOND_HOE.get(), EPItems.PURPLE_GOLD_DIAMOND_HOE.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.REINFORCED_DIAMOND_POLISHER.get(), EPItems.PURPLE_GOLD_DIAMOND_POLISHER.get());
        purpleGoldSmithingUpgrade(consumer, EPItems.REINFORCED_DIAMOND_DAGGER.get(), EPItems.PURPLE_GOLD_DIAMOND_DAGGER.get());
    }

    //Helpers
    protected static void smithingUpgrade(Consumer<FinishedRecipe> consumer, ItemLike template, ItemLike base, ItemLike addition, ItemLike result){
        smithingTransformSerialize(consumer, template, base, addition, result);
    }

    protected static void bronziumSmithingTemplate(Consumer<FinishedRecipe> consumer, ItemLike bronzeItem, ItemLike brassItem, ItemLike bronziumItem){
        smithingUpgrade(consumer, EPItems.BRONZIUM_UPGRADE_SMITHING_TEMPLATE.get(), brassItem,
                EPItems.BRONZIUM_INGOT.get(), bronziumItem);
        smithingUpgrade(consumer, EPItems.BRONZIUM_UPGRADE_SMITHING_TEMPLATE.get(), bronzeItem,
                EPItems.BRONZIUM_INGOT.get(), bronziumItem);
    }

    protected static void reinforcedSmithingUpgrade(Consumer<FinishedRecipe> consume, ItemLike baseItem, ItemLike reinforcedItem){
        smithingUpgrade(consume, EPItems.REINFORCED_UPGRADE_SMITHING_TEMPLATE.get(), baseItem, EPItems.LEATHER_STRIPS.get(), reinforcedItem);
    }

    protected static void aluminumSmithingUpgrade(Consumer<FinishedRecipe> consumer, ItemLike baseItem, ItemLike aluminizedItem){
        smithingUpgrade(consumer, EPItems.ALUMINUM_UPGRADE_SMITHING_TEMPLATE.get(), baseItem, EPItems.ALUMINUM_INGOT.get(), aluminizedItem);
    }

    //TODO: Add new smithing template
    protected static void purpleGoldSmithingUpgrade(Consumer<FinishedRecipe> consumer, ItemLike baseItem, ItemLike purpleGoldenizedItem){
        smithingUpgrade(consumer, EPItems.GOLDEN_UPGRADE_SMITHING_TEMPLATE.get(), baseItem, EPItems.PURPLE_GOLD_INGOT.get(), purpleGoldenizedItem);
    }

    protected static void goldenSmithingUpgrade(Consumer<FinishedRecipe> consumer, ItemLike baseItem, ItemLike pIngot, ItemLike resultItem){
        smithingUpgrade(consumer, EPItems.GOLDEN_UPGRADE_SMITHING_TEMPLATE.get(), baseItem, pIngot, resultItem);
    }

    protected static void roseGoldenSmithingUpgrade(Consumer<FinishedRecipe> consumer, ItemLike baseItem, ItemLike resultItem){
        goldenSmithingUpgrade(consumer, baseItem, EPItems.ROSE_GOLD_INGOT.get(), resultItem);
    }

    protected static void greenGoldenSmithingUpgrade(Consumer<FinishedRecipe> consumer, ItemLike baseItem, ItemLike resultItem){
        goldenSmithingUpgrade(consumer, baseItem, EPItems.GREEN_GOLD_INGOT.get(), resultItem);
    }

    protected static void blueGoldenSmithingUpgrade(Consumer<FinishedRecipe> consumer, ItemLike baseItem, ItemLike resultItem){
        goldenSmithingUpgrade(consumer, baseItem, EPItems.BLUE_GOLD_INGOT.get(), resultItem);
    }

    //Builders
    protected static void smithingTransformSerialize(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike template, ItemLike base, ItemLike addition, ItemLike result){
        EPSmithingRecipesBuilder.smithingTransform(template, Ingredient.of(base), Ingredient.of(addition), result)
                .unlockedBy(getHasName(base), has(base))
                .unlockedBy(getHasName(result), has(result))
                .save(pFinishedRecipeConsumer, EnhancedPlaythrough.MOD_ID + ":" + getItemName(result) + "_from_smithing_" + getItemName(base) + "_with_" + getItemName(addition));
    }

    @SuppressWarnings("removal")
    protected static void smithingTrim(Consumer<FinishedRecipe> pConsumer, ItemLike template){
        SmithingTrimRecipeBuilder.smithingTrim(Ingredient.of(template), Ingredient.of(ItemTags.TRIMMABLE_ARMOR), Ingredient.of(ItemTags.TRIM_MATERIALS), RecipeCategory.MISC)
                .unlocks("has_smithing_template", has(template))
                .save(pConsumer, new ResourceLocation(EnhancedPlaythrough.MOD_ID, getItemName(template) + "_smithing_trim"));
    }
}
