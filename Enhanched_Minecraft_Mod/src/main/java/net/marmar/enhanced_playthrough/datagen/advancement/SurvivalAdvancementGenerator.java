package net.marmar.enhanced_playthrough.datagen.advancement;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.block.ModBlocks;
import net.marmar.enhanced_playthrough.item.ModItems;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;

import java.util.function.Consumer;

public class SurvivalAdvancementGenerator implements ForgeAdvancementProvider.AdvancementGenerator {
    private static final ResourceLocation SURVIVAL_BACKGROUND = new ResourceLocation(EnhancedPlaythrough.MOD_ID, "textures/block/bronze_block.png");

    @Override
    public void generate(HolderLookup.Provider provider, Consumer<Advancement> consumer, ExistingFileHelper existingFileHelper) {
        //Root
        Advancement survival_root = Advancement.Builder.advancement()
                .display(ModBlocks.ADOBE_ALLOYING_FURNACE.get(), Component.translatable("advancements.title.survival.unity_makes_strength"), Component.translatable("advancements.desc.survival.unity_makes_strength"), SURVIVAL_BACKGROUND, FrameType.TASK, false, false, false)
                .addCriterion("has_block", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.ADOBE_ALLOYING_FURNACE.get()))
                .save(consumer, new ResourceLocation(EnhancedPlaythrough.MOD_ID, "survival_root"), existingFileHelper);

        //Bronze path
        Advancement thats_new = Advancement.Builder.advancement()
                .parent(survival_root)
                .display(ModItems.BRONZE_INGOT.get(), Component.translatable("advancements.title.survival.thats_new"), Component.translatable("advancements.desc.survival.thats_new"), SURVIVAL_BACKGROUND, FrameType.TASK, true, true, false)
                .addCriterion("has_item", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.BRONZE_INGOT.get()))
                .save(consumer, new ResourceLocation(EnhancedPlaythrough.MOD_ID, "thats_new"), existingFileHelper);

        Advancement abrassive_heat = Advancement.Builder.advancement()
                .parent(thats_new)
                .display(ModItems.BRASS_INGOT.get(), Component.translatable("advancements.title.survival.abrassive_heat"), Component.translatable("advancements.desc.survival.abrassive_heat"), SURVIVAL_BACKGROUND, FrameType.TASK, true, true, false)
                .addCriterion("has_item", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.BRASS_INGOT.get()))
                .save(consumer, new ResourceLocation(EnhancedPlaythrough.MOD_ID, "abrassive_heat"), existingFileHelper);

        Advancement mighty_bronze = Advancement.Builder.advancement()
                .parent(thats_new)
                .display(ModItems.BRONZE_PICKAXE.get(), Component.translatable("advancements.title.survival.mighty_bronze"), Component.translatable("advancements.desc.survival.mighty_bronze"), SURVIVAL_BACKGROUND, FrameType.TASK, true, true, false)
                .addCriterion("has_item", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.BRONZE_PICKAXE.get()))
                .save(consumer, new ResourceLocation(EnhancedPlaythrough.MOD_ID, "mighty_bronze"), existingFileHelper);

        Advancement steel_isnt_enough = Advancement.Builder.advancement()
                .parent(mighty_bronze)
                .display(ModItems.STEEL_INGOT.get(), Component.translatable("advancements.title.survival.steel_isnt_enough"), Component.translatable("advancements.desc.survival.steel_isnt_enough"), SURVIVAL_BACKGROUND, FrameType.TASK, true, true, false)
                .addCriterion("has_item", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.STEEL_INGOT.get()))
                .save(consumer, new ResourceLocation(EnhancedPlaythrough.MOD_ID, "steel_isnt_enough"), existingFileHelper);

        //Gold path
        Advancement blossom = Advancement.Builder.advancement()
                .parent(survival_root)
                .display(ModItems.ROSE_GOLD_INGOT.get(), Component.translatable("advancements.title.survival.blossom"), Component.translatable("advancements.desc.survival.blossom"), SURVIVAL_BACKGROUND, FrameType.TASK, true, true, false)
                .addCriterion("has_item", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ROSE_GOLD_INGOT.get()))
                .save(consumer, new ResourceLocation(EnhancedPlaythrough.MOD_ID, "blossom"), existingFileHelper);

        Advancement buttercup = Advancement.Builder.advancement()
                .parent(blossom)
                .display(ModItems.GREEN_GOLD_INGOT.get(), Component.translatable("advancements.title.survival.buttercup"), Component.translatable("advancements.desc.survival.buttercup"), SURVIVAL_BACKGROUND, FrameType.TASK, true, true, false)
                .addCriterion("has_item", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GREEN_GOLD_INGOT.get()))
                .save(consumer, new ResourceLocation(EnhancedPlaythrough.MOD_ID, "buttercup"), existingFileHelper);

        Advancement bubbles = Advancement.Builder.advancement()
                .parent(buttercup)
                .display(ModItems.BLUE_GOLD_INGOT.get(), Component.translatable("advancements.title.survival.bubbles"), Component.translatable("advancements.desc.survival.bubbles"), SURVIVAL_BACKGROUND, FrameType.TASK, true, true, false)
                .addCriterion("has_item", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.BLUE_GOLD_INGOT.get()))
                .save(consumer, new ResourceLocation(EnhancedPlaythrough.MOD_ID, "bubbles"), existingFileHelper);

        Advancement the_goldenpuff_girls = Advancement.Builder.advancement()
                .parent(survival_root)
                .display(ModItems.BLUE_GOLD_INGOT.get(), Component.translatable("advancements.title.survival.the_goldenpuff_girls"), Component.translatable("advancements.desc.survival.the_goldenpuff_girls"), SURVIVAL_BACKGROUND, FrameType.CHALLENGE, true, true, false)
                .addCriterion("has_item", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ROSE_GOLD_INGOT.get(), ModItems.GREEN_GOLD_INGOT.get(), ModItems.BLUE_GOLD_INGOT.get()))
                .requirements(RequirementsStrategy.AND)
                .save(consumer, new ResourceLocation(EnhancedPlaythrough.MOD_ID, "the_goldenpuff_girls"), existingFileHelper);
    }
}
