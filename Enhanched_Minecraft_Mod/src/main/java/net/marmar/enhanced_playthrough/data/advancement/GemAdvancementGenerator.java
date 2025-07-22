package net.marmar.enhanced_playthrough.data.advancement;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.block.EPBlocks;
import net.marmar.enhanced_playthrough.item.EPItems;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.PlayerTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;

import java.util.function.Consumer;

public class GemAdvancementGenerator implements ForgeAdvancementProvider.AdvancementGenerator, ICustomAdvancementDisplays {
    @Override
    public void generate(HolderLookup.Provider provider, Consumer<Advancement> consumer, ExistingFileHelper existingFileHelper) {
        Advancement gems_root = Advancement.Builder.advancement()
                .display(rootDisplayInfo(EPBlocks.GEM_POLISHER.get(), "root"))
                .addCriterion("spawn", PlayerTrigger.TriggerInstance.tick())
                .save(consumer, new ResourceLocation(EnhancedPlaythrough.MOD_ID, "gem_root"), existingFileHelper);

        Advancement get_emerald = Advancement.Builder.advancement()
                .parent(gems_root)
                .display(taskDisplayInfo(Items.EMERALD, "polish_emerald"))
                .addCriterion("has_emerald", InventoryChangeTrigger.TriggerInstance.hasItems(Items.EMERALD))
                .save(consumer, new ResourceLocation(EnhancedPlaythrough.MOD_ID, "polish_emerald"), existingFileHelper);

        Advancement get_sapphire = Advancement.Builder.advancement()
                .parent(get_emerald)
                .display(taskDisplayInfo(EPItems.SAPPHIRE.get(), "polish_sapphire"))
                .addCriterion("has_sapphire", InventoryChangeTrigger.TriggerInstance.hasItems(EPItems.SAPPHIRE.get()))
                .save(consumer, new ResourceLocation(EnhancedPlaythrough.MOD_ID, "polish_sapphire"), existingFileHelper);

        Advancement get_ruby = Advancement.Builder.advancement()
                .parent(get_sapphire)
                .display(taskDisplayInfo(EPItems.RUBY.get(), "polish_ruby"))
                .addCriterion("has_ruby", InventoryChangeTrigger.TriggerInstance.hasItems(EPItems.RUBY.get()))
                .save(consumer, new ResourceLocation(EnhancedPlaythrough.MOD_ID, "polish_ruby"), existingFileHelper);

        Advancement get_garnet = Advancement.Builder.advancement()
                .parent(gems_root)
                .display(taskDisplayInfo(EPItems.GARNET.get(), "polish_garnet"))
                .addCriterion("has_garnet", InventoryChangeTrigger.TriggerInstance.hasItems(EPItems.GARNET.get()))
                .save(consumer, new ResourceLocation(EnhancedPlaythrough.MOD_ID, "polish_garnet"), existingFileHelper);

        Advancement get_diamond = Advancement.Builder.advancement()
                .parent(get_garnet)
                .display(taskDisplayInfo(Items.DIAMOND, "polish_diamond"))
                .addCriterion("has_diamond", InventoryChangeTrigger.TriggerInstance.hasItems(Items.DIAMOND))
                .save(consumer, new ResourceLocation(EnhancedPlaythrough.MOD_ID, "polish_diamond"), existingFileHelper);

        Advancement get_all_gems = Advancement.Builder.advancement()
                .parent(gems_root)
                .display(challengeDisplayInfo(EPItems.NETHERITE_POLISHER.get(), "get_all_gems"))
                .addCriterion("has_emerald", InventoryChangeTrigger.TriggerInstance.hasItems(Items.EMERALD))
                .addCriterion("has_sapphire", InventoryChangeTrigger.TriggerInstance.hasItems(EPItems.SAPPHIRE.get()))
                .addCriterion("has_ruby", InventoryChangeTrigger.TriggerInstance.hasItems(EPItems.RUBY.get()))
                .addCriterion("has_diamond", InventoryChangeTrigger.TriggerInstance.hasItems(Items.EMERALD))
                .addCriterion("has_garnet", InventoryChangeTrigger.TriggerInstance.hasItems(EPItems.GARNET.get()))
                .rewards(AdvancementRewards.Builder.experience(100))
                .requirements(RequirementsStrategy.AND)
                .save(consumer, new ResourceLocation(EnhancedPlaythrough.MOD_ID, "get_all_gems"), existingFileHelper);
    }

    @Override
    public ResourceLocation categoryBackGround() {
        return new ResourceLocation("textures/block/emerald_block.png");
    }

    @Override
    public String categoryName() {
        return "gems";
    }
}
