package net.marmar.enhanced_playthrough.data.advancement;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.block.ModBlocks;
import net.marmar.enhanced_playthrough.data.tag.ModTags;
import net.marmar.enhanced_playthrough.item.ModItems;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;

import java.util.function.Consumer;

public class SurvivalAdvancementGenerator implements ForgeAdvancementProvider.AdvancementGenerator, ICustomAdvancementDisplays {
    @Override
    public void generate(HolderLookup.Provider provider, Consumer<Advancement> consumer, ExistingFileHelper existingFileHelper) {
        ItemPredicate hasCobble = ItemPredicate.Builder.item().of(ModTags.Items.COBBLE).build();
        ItemPredicate specialGoldenIngots = ItemPredicate.Builder.item()
                .of(ModItems.ROSE_GOLD_INGOT.get(), ModItems.GREEN_GOLD_INGOT.get(), ModItems.BLUE_GOLD_INGOT.get()).build();

        //Root
        Advancement survival_root = Advancement.Builder.advancement()
                .display(rootDisplayInfo(ModBlocks.ADOBE_ALLOYING_FURNACE.get(), "unity_makes_strength"))
                .addCriterion("has_block", hasItems(ModBlocks.ADOBE_ALLOYING_FURNACE.get()))
                .save(consumer, new ResourceLocation(EnhancedPlaythrough.MOD_ID, "survival_root"), existingFileHelper);

        Advancement stone_age = Advancement.Builder.advancement()
                .parent(survival_root)
                .display(taskDisplayInfo(ModItems.COBBLE.get(), "stone_age"))
                .addCriterion("has_any_of", hasItems(hasCobble))
                .save(consumer, new ResourceLocation(EnhancedPlaythrough.MOD_ID, "stone_age"), existingFileHelper);

        //Bronze path
        Advancement thats_new = Advancement.Builder.advancement()
                .parent(stone_age)
                .display(taskDisplayInfo(ModItems.BRONZE_INGOT.get(), "thats_new"))
                .addCriterion("has_item", hasItems(ModItems.BRONZE_INGOT.get()))
                .save(consumer, new ResourceLocation(EnhancedPlaythrough.MOD_ID, "thats_new"), existingFileHelper);

        Advancement abrassive_heat = Advancement.Builder.advancement()
                .parent(thats_new)
                .display(taskDisplayInfo(ModItems.BRASS_INGOT.get(), "abrassive_heat"))
                .addCriterion("has_item", hasItems(ModItems.BRASS_INGOT.get()))
                .save(consumer, new ResourceLocation(EnhancedPlaythrough.MOD_ID, "abrassive_heat"), existingFileHelper);

        Advancement mighty_bronze = Advancement.Builder.advancement()
                .parent(abrassive_heat)
                .display(taskDisplayInfo(ModItems.BRONZE_PICKAXE.get(), "mighty_bronze"))
                .addCriterion("has_item", hasItems(ModItems.BRONZE_PICKAXE.get()))
                .save(consumer, new ResourceLocation(EnhancedPlaythrough.MOD_ID, "mighty_bronze"), existingFileHelper);

        Advancement steel_isnt_enough = Advancement.Builder.advancement()
                .parent(mighty_bronze)
                .display(taskDisplayInfo(ModItems.STEEL_INGOT.get(), "steel_isnt_enough"))
                .addCriterion("has_item", hasItems(ModItems.STEEL_INGOT.get()))
                .save(consumer, new ResourceLocation(EnhancedPlaythrough.MOD_ID, "steel_isnt_enough"), existingFileHelper);

        //Gold path
        Advancement blossom = Advancement.Builder.advancement()
                .parent(survival_root)
                .display(taskDisplayInfo(ModItems.ROSE_GOLD_INGOT.get(), "blossom"))
                .addCriterion("has_item", hasItems(ModItems.ROSE_GOLD_INGOT.get()))
                .save(consumer, new ResourceLocation(EnhancedPlaythrough.MOD_ID, "blossom"), existingFileHelper);

        Advancement buttercup = Advancement.Builder.advancement()
                .parent(blossom)
                .display(taskDisplayInfo(ModItems.GREEN_GOLD_INGOT.get(), "buttercup"))
                .addCriterion("has_item", hasItems(ModItems.GREEN_GOLD_INGOT.get()))
                .save(consumer, new ResourceLocation(EnhancedPlaythrough.MOD_ID, "buttercup"), existingFileHelper);

        Advancement bubbles = Advancement.Builder.advancement()
                .parent(buttercup)
                .display(taskDisplayInfo(ModItems.BLUE_GOLD_INGOT.get(), "bubbles"))
                .addCriterion("has_item", hasItems(ModItems.BLUE_GOLD_INGOT.get()))
                .save(consumer, new ResourceLocation(EnhancedPlaythrough.MOD_ID, "bubbles"), existingFileHelper);

        Advancement the_goldenpuff_girls = Advancement.Builder.advancement()
                .parent(survival_root)
                .display(challengeDisplayInfo(ModItems.BLUE_GOLDEN_SWORD.get(), "the_goldenpuff_girls"))
                .addCriterion("has_items", hasItems(specialGoldenIngots))
                .requirements(RequirementsStrategy.AND)
                .save(consumer, new ResourceLocation(EnhancedPlaythrough.MOD_ID, "the_goldenpuff_girls"), existingFileHelper);
    }

    @Override
    public ResourceLocation categoryBackGround() {
        return new ResourceLocation(EnhancedPlaythrough.MOD_ID, "textures/block/bronze_block.png");
    }

    @Override
    public String categoryName() {
        return "survival";
    }
}
