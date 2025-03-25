package net.marmar.enhanced_playthrough.datagen.advancement;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.Util.ModTags;
import net.marmar.enhanced_playthrough.block.ModBlocks;
import net.marmar.enhanced_playthrough.item.ModItems;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.PlayerTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;

import java.util.function.Consumer;

public class GemAdvancementGenerator implements ForgeAdvancementProvider.AdvancementGenerator {
    private static final ResourceLocation GEMS_BACKGROUND = new ResourceLocation("textures/block/emerald_block.png");

    @Override
    public void generate(HolderLookup.Provider provider, Consumer<Advancement> consumer, ExistingFileHelper existingFileHelper) {
        Advancement gems_root = Advancement.Builder.advancement()
                .display(ModBlocks.GEM_POLISHER.get().asItem(), Component.translatable("advancements.title.gems.root"), Component.translatable("advancements.desc.gems.root"), GEMS_BACKGROUND, FrameType.TASK, false, false, true)
                .addCriterion("spawn", PlayerTrigger.TriggerInstance.tick())
                .save(consumer, new ResourceLocation(EnhancedPlaythrough.MOD_ID, "gem_root"), existingFileHelper);

        Advancement get_emerald = Advancement.Builder.advancement()
                .parent(gems_root)
                .display(Items.EMERALD, Component.translatable("advancements.title.gems.polish_emerald"), Component.translatable("advancements.desc.gems.polish_emerald"), GEMS_BACKGROUND, FrameType.TASK, true, true, false)
                .addCriterion("has_material", InventoryChangeTrigger.TriggerInstance.hasItems(Items.EMERALD))
                .requirements(RequirementsStrategy.OR)
                .save(consumer, new ResourceLocation(EnhancedPlaythrough.MOD_ID, "polish_emerald"), existingFileHelper);

        Advancement get_sapphire = Advancement.Builder.advancement()
                .parent(get_emerald)
                .display(ModItems.SAPPHIRE.get(), Component.translatable("advancements.title.gems.polish_sapphire"), Component.translatable("advancements.desc.gems.polish_sapphire"), GEMS_BACKGROUND, FrameType.TASK, true, true, false)
                .addCriterion("has_material", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SAPPHIRE.get()))
                .requirements(RequirementsStrategy.OR)
                .save(consumer, new ResourceLocation(EnhancedPlaythrough.MOD_ID, "polish_sapphire"), existingFileHelper);

        Advancement get_ruby = Advancement.Builder.advancement()
                .parent(get_sapphire)
                .display(ModItems.RUBI.get(), Component.translatable("advancements.title.gems.polish_rubi"), Component.translatable("advancements.desc.gems.polish_rubi"), GEMS_BACKGROUND, FrameType.TASK, true, true, false)
                .addCriterion("has_material", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.RUBI.get()))
                .requirements(RequirementsStrategy.OR)
                .save(consumer, new ResourceLocation(EnhancedPlaythrough.MOD_ID, "polish_ruby"), existingFileHelper);

        Advancement get_garnet = Advancement.Builder.advancement()
                .parent(gems_root)
                .display(ModItems.GARNET.get(), Component.translatable("advancements.title.gems.polish_garnet"), Component.translatable("advancements.desc.gems.polish_garnet"), GEMS_BACKGROUND, FrameType.TASK, true, true, false)
                .addCriterion("has_material", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GARNET.get()))
                .requirements(RequirementsStrategy.OR)
                .save(consumer, new ResourceLocation(EnhancedPlaythrough.MOD_ID, "polish_garnet"), existingFileHelper);

        Advancement get_diamond = Advancement.Builder.advancement()
                .parent(get_garnet)
                .display(Items.DIAMOND, Component.translatable("advancements.title.gems.polish_diamond"), Component.translatable("advancements.desc.gems.polish_diamond"), GEMS_BACKGROUND, FrameType.TASK, true, true, false)
                .addCriterion("has_material", InventoryChangeTrigger.TriggerInstance.hasItems(Items.DIAMOND))
                .requirements(RequirementsStrategy.OR)
                .save(consumer, new ResourceLocation(EnhancedPlaythrough.MOD_ID, "polish_diamond"), existingFileHelper);

        Advancement get_all_gems = Advancement.Builder.advancement()
                .parent(gems_root)
                .display(ModItems.NETHERITE_POLISHER.get(), Component.translatable("advancements.title.gems.get_all_gems"), Component.translatable("advancements.desc.gems.get_all_gems"), GEMS_BACKGROUND, FrameType.CHALLENGE, true, true, false)
                .addCriterion("has_materials", InventoryChangeTrigger.TriggerInstance.hasItems(Items.EMERALD, ModItems.SAPPHIRE.get(), ModItems.RUBI.get(), ModItems.GARNET.get() ,Items.DIAMOND))
                .requirements(RequirementsStrategy.AND)
                .save(consumer, new ResourceLocation(EnhancedPlaythrough.MOD_ID, "get_all_gems"), existingFileHelper);
    }
}
