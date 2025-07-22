package net.marmar.enhanced_playthrough.data.advancement;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.block.EPBlocks;
import net.marmar.enhanced_playthrough.data.tag.EPTags;
import net.marmar.enhanced_playthrough.item.EPItems;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;

import java.util.function.Consumer;

public class SurvivalAdvancementGenerator implements ForgeAdvancementProvider.AdvancementGenerator, ICustomAdvancementDisplays {
    @Override
    public void generate(HolderLookup.Provider provider, Consumer<Advancement> consumer, ExistingFileHelper existingFileHelper) {
        ItemPredicate hasCobble = ItemPredicate.Builder.item().of(EPTags.Items.COBBLE).build();

        //Root
        Advancement survival_root = Advancement.Builder.advancement()
                .display(rootDisplayInfo(EPBlocks.ADOBE_ALLOY_FURNACE.get(), "unity_makes_strength"))
                .addCriterion("has_block", hasItems(EPBlocks.ADOBE_ALLOY_FURNACE.get()))
                .save(consumer, new ResourceLocation(EnhancedPlaythrough.MOD_ID, "survival_root"), existingFileHelper);

        Advancement stone_age = Advancement.Builder.advancement()
                .parent(survival_root)
                .display(taskDisplayInfo(EPItems.COBBLE.get(), "stone_age"))
                .addCriterion("has_any_of", hasItems(hasCobble))
                .save(consumer, new ResourceLocation(EnhancedPlaythrough.MOD_ID, "stone_age"), existingFileHelper);

        //Bronze path
        Advancement thats_new = Advancement.Builder.advancement()
                .parent(stone_age)
                .display(taskDisplayInfo(EPItems.BRONZE_INGOT.get(), "thats_new"))
                .addCriterion("has_item", hasItems(EPItems.BRONZE_INGOT.get()))
                .save(consumer, new ResourceLocation(EnhancedPlaythrough.MOD_ID, "thats_new"), existingFileHelper);

        Advancement abrassive_heat = Advancement.Builder.advancement()
                .parent(thats_new)
                .display(taskDisplayInfo(EPItems.BRASS_INGOT.get(), "abrassive_heat"))
                .addCriterion("has_item", hasItems(EPItems.BRASS_INGOT.get()))
                .save(consumer, new ResourceLocation(EnhancedPlaythrough.MOD_ID, "abrassive_heat"), existingFileHelper);

        Advancement mighty_bronze = Advancement.Builder.advancement()
                .parent(abrassive_heat)
                .display(taskDisplayInfo(EPItems.BRONZE_PICKAXE.get(), "mighty_bronze"))
                .addCriterion("has_item", hasItems(EPItems.BRONZE_PICKAXE.get()))
                .save(consumer, new ResourceLocation(EnhancedPlaythrough.MOD_ID, "mighty_bronze"), existingFileHelper);

        Advancement steel_isnt_enough = Advancement.Builder.advancement()
                .parent(mighty_bronze)
                .display(taskDisplayInfo(EPItems.STEEL_INGOT.get(), "steel_isnt_enough"))
                .addCriterion("has_item", hasItems(EPItems.STEEL_INGOT.get()))
                .save(consumer, new ResourceLocation(EnhancedPlaythrough.MOD_ID, "steel_isnt_enough"), existingFileHelper);

        //Gold path
        Advancement blossom = Advancement.Builder.advancement()
                .parent(survival_root)
                .display(taskDisplayInfo(EPItems.ROSE_GOLD_INGOT.get(), "blossom"))
                .addCriterion("has_item", hasItems(EPItems.ROSE_GOLD_INGOT.get()))
                .save(consumer, new ResourceLocation(EnhancedPlaythrough.MOD_ID, "blossom"), existingFileHelper);

        Advancement buttercup = Advancement.Builder.advancement()
                .parent(blossom)
                .display(taskDisplayInfo(EPItems.GREEN_GOLD_INGOT.get(), "buttercup"))
                .addCriterion("has_item", hasItems(EPItems.GREEN_GOLD_INGOT.get()))
                .save(consumer, new ResourceLocation(EnhancedPlaythrough.MOD_ID, "buttercup"), existingFileHelper);

        Advancement bubbles = Advancement.Builder.advancement()
                .parent(buttercup)
                .display(taskDisplayInfo(EPItems.BLUE_GOLD_INGOT.get(), "bubbles"))
                .addCriterion("has_item", hasItems(EPItems.BLUE_GOLD_INGOT.get()))
                .save(consumer, new ResourceLocation(EnhancedPlaythrough.MOD_ID, "bubbles"), existingFileHelper);

        Advancement the_goldenpuff_girls = Advancement.Builder.advancement()
                .parent(survival_root)
                .display(challengeDisplayInfo(EPItems.BLUE_GOLDEN_SWORD.get(), "the_goldenpuff_girls"))
                .addCriterion("has_rose_gold_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(EPItems.ROSE_GOLD_INGOT.get()))
                .addCriterion("has_green_gold_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(EPItems.GREEN_GOLD_INGOT.get()))
                .addCriterion("has_blue_gold_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(EPItems.BLUE_GOLD_INGOT.get()))
                .rewards(AdvancementRewards.Builder.experience(100))
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
