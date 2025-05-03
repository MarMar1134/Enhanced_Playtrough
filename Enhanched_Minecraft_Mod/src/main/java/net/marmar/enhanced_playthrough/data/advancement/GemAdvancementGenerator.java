package net.marmar.enhanced_playthrough.data.advancement;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.block.ModBlocks;
import net.marmar.enhanced_playthrough.item.ModItems;
import net.minecraft.advancements.Advancement;
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
                .display(rootDisplayInfo(ModBlocks.GEM_POLISHER.get(), "root"))
                .addCriterion("spawn", PlayerTrigger.TriggerInstance.tick())
                .save(consumer, new ResourceLocation(EnhancedPlaythrough.MOD_ID, "gem_root"), existingFileHelper);

        Advancement get_emerald = Advancement.Builder.advancement()
                .parent(gems_root)
                .display(taskDisplayInfo(Items.EMERALD, "polish_emerald"))
                .addCriterion("has_material", InventoryChangeTrigger.TriggerInstance.hasItems(Items.EMERALD))
                .requirements(RequirementsStrategy.OR)
                .save(consumer, new ResourceLocation(EnhancedPlaythrough.MOD_ID, "polish_emerald"), existingFileHelper);

        Advancement get_sapphire = Advancement.Builder.advancement()
                .parent(get_emerald)
                .display(taskDisplayInfo(ModItems.SAPPHIRE.get(), "polish_sapphire"))
                .addCriterion("has_material", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SAPPHIRE.get()))
                .requirements(RequirementsStrategy.OR)
                .save(consumer, new ResourceLocation(EnhancedPlaythrough.MOD_ID, "polish_sapphire"), existingFileHelper);

        Advancement get_ruby = Advancement.Builder.advancement()
                .parent(get_sapphire)
                .display(taskDisplayInfo(ModItems.RUBY.get(), "polish_ruby"))
                .addCriterion("has_material", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.RUBY.get()))
                .requirements(RequirementsStrategy.OR)
                .save(consumer, new ResourceLocation(EnhancedPlaythrough.MOD_ID, "polish_ruby"), existingFileHelper);

        Advancement get_garnet = Advancement.Builder.advancement()
                .parent(gems_root)
                .display(taskDisplayInfo(ModItems.GARNET.get(), "polish_garnet"))
                .addCriterion("has_material", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GARNET.get()))
                .requirements(RequirementsStrategy.OR)
                .save(consumer, new ResourceLocation(EnhancedPlaythrough.MOD_ID, "polish_garnet"), existingFileHelper);

        Advancement get_diamond = Advancement.Builder.advancement()
                .parent(get_garnet)
                .display(taskDisplayInfo(Items.DIAMOND, "polish_diamond"))
                .addCriterion("has_material", InventoryChangeTrigger.TriggerInstance.hasItems(Items.DIAMOND))
                .requirements(RequirementsStrategy.OR)
                .save(consumer, new ResourceLocation(EnhancedPlaythrough.MOD_ID, "polish_diamond"), existingFileHelper);

        Advancement get_all_gems = Advancement.Builder.advancement()
                .parent(gems_root)
                .display(challengeDisplayInfo(ModItems.NETHERITE_POLISHER.get(), "get_all_gems"))
                .addCriterion("has_materials", InventoryChangeTrigger.TriggerInstance.hasItems(Items.EMERALD, ModItems.SAPPHIRE.get(), ModItems.RUBY.get(), ModItems.GARNET.get() ,Items.DIAMOND))
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
