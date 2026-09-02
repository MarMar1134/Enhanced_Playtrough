package net.marmar.enhanced_playthrough.datagen.advancement;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.block.EPBlocks;
import net.marmar.enhanced_playthrough.datagen.tag.EPTags;
import net.marmar.enhanced_playthrough.item.EPItems;
import net.marmar.enhanced_playthrough.util.trigger.weaponkill.WeaponKillTrigger;
import net.marmar.enhanced_playthrough.worldgen.structure.EPStructures;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;

import java.util.function.Consumer;

@SuppressWarnings("removal")
public class SurvivalAdvancementGenerator implements ForgeAdvancementProvider.AdvancementGenerator, iAdvancementUtils {
    @Override
    public void generate(HolderLookup.Provider provider, Consumer<Advancement> consumer, ExistingFileHelper existingFileHelper) {
        ItemPredicate hasCobble = ItemPredicate.Builder.item().of(EPTags.Items.COBBLE).build();

        //Root
        Advancement root = Advancement.Builder.advancement()
                .display(rootDisplayInfo(EPItems.STEEL_SWORD.get(), "survival_root"))
                .addCriterion("is_alive", PlayerTrigger.TriggerInstance.tick())
                .save(consumer, ResourceLocation.fromNamespaceAndPath(EnhancedPlaythrough.MOD_ID, "survival_root"), existingFileHelper);

        Advancement stone_age = Advancement.Builder.advancement()
                .parent(root)
                .display(taskDisplayInfo(EPItems.COBBLE.get(), "stone_age"))
                .addCriterion("has_any_of", hasItems(hasCobble))
                .save(consumer, new ResourceLocation(EnhancedPlaythrough.MOD_ID, "stone_age"), existingFileHelper);

        Advancement unity_makes_strength = Advancement.Builder.advancement()
                .parent(stone_age)
                .display(taskDisplayInfo(EPBlocks.PRIMITIVE_ALLOY_FURNACE.get(), "unity_makes_strength"))
                .addCriterion("has_block", hasItems(EPBlocks.PRIMITIVE_ALLOY_FURNACE.get()))
                .save(consumer, new ResourceLocation(EnhancedPlaythrough.MOD_ID, "unity_makes_strength"), existingFileHelper);

        //Bronze path
        Advancement thats_new = Advancement.Builder.advancement()
                .parent(unity_makes_strength)
                .display(taskDisplayInfo(EPItems.BRONZE_INGOT.get(), "thats_new"))
                .addCriterion("has_item", hasItems(EPItems.BRONZE_INGOT.get()))
                .save(consumer, new ResourceLocation(EnhancedPlaythrough.MOD_ID, "thats_new"), existingFileHelper);

            //Brass branch
            Advancement abrassive_heat = Advancement.Builder.advancement()
                    .parent(unity_makes_strength)
                    .display(taskDisplayInfo(EPItems.BRASS_INGOT.get(), "abrassive_heat"))
                    .addCriterion("has_item", hasItems(EPItems.BRASS_INGOT.get()))
                    .save(consumer, new ResourceLocation(EnhancedPlaythrough.MOD_ID, "abrassive_heat"), existingFileHelper);

            Advancement abrass_your_soul = Advancement.Builder.advancement()
                    .parent(abrassive_heat)
                    .display(challengeDisplayInfo(EPItems.BRASS_CHESTPLATE.get(), "abrass_your_soul"))
                    .addCriterion("has_helmet", hasItems(EPItems.BRASS_HELMET.get()))
                    .addCriterion("has_chestplate", hasItems(EPItems.BRASS_CHESTPLATE.get()))
                    .addCriterion("has_leggings", hasItems(EPItems.BRASS_LEGGINGS.get()))
                    .addCriterion("has_boots", hasItems(EPItems.BRASS_BOOTS.get()))
                    .rewards(AdvancementRewards.Builder.loot(advancementReward("abrass_your_soul")))
                    .requirements(RequirementsStrategy.AND)
                    .save(consumer, new ResourceLocation(EnhancedPlaythrough.MOD_ID, "abrass_your_soul"), existingFileHelper);

        Advancement mighty_bronze = Advancement.Builder.advancement()
                .parent(thats_new)
                .display(taskDisplayInfo(EPItems.BRONZE_PICKAXE.get(), "mighty_bronze"))
                .addCriterion("has_item", hasItems(EPItems.BRONZE_PICKAXE.get()))
                .save(consumer, new ResourceLocation(EnhancedPlaythrough.MOD_ID, "mighty_bronze"), existingFileHelper);

        Advancement thick_as_thieves = Advancement.Builder.advancement()
                .parent(mighty_bronze)
                .display(taskDisplayInfo(EPBlocks.ADOBE_ALLOY_FURNACE.get(), "thick_as_thieves"))
                .addCriterion("has_bricks_alloy_furnace", hasItems(EPBlocks.ADOBE_ALLOY_FURNACE.get()))
                .save(consumer, new ResourceLocation(EnhancedPlaythrough.MOD_ID, "thick_as_thieves"), existingFileHelper);

        Advancement steel_isnt_enough = Advancement.Builder.advancement()
                .parent(thick_as_thieves)
                .display(taskDisplayInfo(EPItems.STEEL_INGOT.get(), "steel_isnt_enough"))
                .addCriterion("has_item", hasItems(EPItems.STEEL_INGOT.get()))
                .save(consumer, new ResourceLocation(EnhancedPlaythrough.MOD_ID, "steel_isnt_enough"), existingFileHelper);

        //Aluminum branch
            Advancement the_aluminated = Advancement.Builder.advancement()
                    .parent(steel_isnt_enough)
                    .display(taskDisplayInfo(EPItems.ALUMINUM_INGOT.get(), "the_aluminated"))
                    .addCriterion("has_aluminum_ingot", hasItems(EPItems.ALUMINUM_INGOT.get()))
                    .save(consumer, new ResourceLocation(EnhancedPlaythrough.MOD_ID, "the_aluminated"), existingFileHelper);

            Advancement the_conspiration = Advancement.Builder.advancement()
                    .parent(the_aluminated)
                    .display(taskDisplayInfo(EPBlocks.MASONRY_FURNACE.get(), "the_conspiration"))
                    .addCriterion("has_masonry_furnace", hasItems(EPBlocks.MASONRY_FURNACE.get()))
                    .save(consumer, new ResourceLocation(EnhancedPlaythrough.MOD_ID, "the_conspiration"), existingFileHelper);

//        Advancement vale_4 = Advancement.Builder.advancement()
//                .parent(steel_isnt_enough)
//                .display(taskDisplayInfo(EPBlocks.ALCHEMICAL_DUPLICATOR.get(), "vale_4"))
//                .addCriterion("has_alchemical_duplicator", hasItems(EPBlocks.ALCHEMICAL_DUPLICATOR.get()))
//                .save(consumer, new ResourceLocation(EnhancedPlaythrough.MOD_ID, "vale_4"), existingFileHelper);

        //Gold path
        Advancement ancient_knowledge = Advancement.Builder.advancement()
                .parent(thick_as_thieves)
                .display(taskDisplayInfo(Items.MAP, "ancient_knowledge"))
                .addCriterion("is_in_structure", inStructure(EPStructures.ANCIENT_LORDS_DOMAIN))
                .save(consumer, new ResourceLocation(EnhancedPlaythrough.MOD_ID, "ancient_knowledge"), existingFileHelper);

        Advancement blossom = Advancement.Builder.advancement()
                .parent(ancient_knowledge)
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
                .parent(bubbles)
                .display(challengeDisplayInfo(EPItems.BLUE_GOLDEN_SWORD.get(), "the_goldenpuff_girls"))
                .addCriterion("has_rose_gold_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(EPItems.ROSE_GOLD_INGOT.get()))
                .addCriterion("has_green_gold_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(EPItems.GREEN_GOLD_INGOT.get()))
                .addCriterion("has_blue_gold_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(EPItems.BLUE_GOLD_INGOT.get()))
                .rewards(AdvancementRewards.Builder.experience(100))
                .rewards(AdvancementRewards.Builder.loot(advancementReward("the_goldenpuff_girls")))
                .requirements(RequirementsStrategy.AND)
                .save(consumer, new ResourceLocation(EnhancedPlaythrough.MOD_ID, "the_goldenpuff_girls"), existingFileHelper);

            //Purple gold branch
            Advancement design_choices = Advancement.Builder.advancement()
                    .parent(ancient_knowledge)
                    .display(taskDisplayInfo(EPItems.PURPLE_GOLD_INGOT.get(), "design_choices"))
                    .addCriterion("has_purple_gold_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(EPItems.PURPLE_GOLD_INGOT.get()))
                    .save(consumer, new ResourceLocation(EnhancedPlaythrough.MOD_ID, "design_choices"), existingFileHelper);

            Advancement the_man_behind_the_slaughter = Advancement.Builder.advancement()
                    .parent(design_choices)
                    .display(challengeDisplayInfo(EPItems.PURPLE_GOLD_IRON_DAGGER.get(), "the_man_behind_the_slaughter"))
                    .addCriterion("killed_villagers", WeaponKillTrigger.killedWithWeapon(
                            EntityPredicate.Builder.entity().of(EntityType.VILLAGER)
                                    .flags(EntityFlagsPredicate.Builder.flags().setIsBaby(true).build()),
                            ItemPredicate.Builder.item().of(EPItems.PURPLE_GOLD_IRON_DAGGER.get()),
                            MinMaxBounds.Ints.atLeast(5)
                    ))
                    .rewards(AdvancementRewards.Builder.experience(1987))
                    .save(consumer, new ResourceLocation(EnhancedPlaythrough.MOD_ID, "the_man_behind_the_slaughter"), existingFileHelper);
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