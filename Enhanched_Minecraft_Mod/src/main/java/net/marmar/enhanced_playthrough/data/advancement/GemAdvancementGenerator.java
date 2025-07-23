package net.marmar.enhanced_playthrough.data.advancement;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.block.EPBlocks;
import net.marmar.enhanced_playthrough.data.tag.EPTags;
import net.marmar.enhanced_playthrough.item.EPItems;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;

import java.util.function.Consumer;

public class GemAdvancementGenerator implements ForgeAdvancementProvider.AdvancementGenerator, ICustomAdvancementDisplays {
    public ItemPredicate HAS_POLISHER = ItemPredicate.Builder.item().of(EPTags.Items.POLISHER).build();
    public ItemPredicate HAS_SMALL_FLOWER = ItemPredicate.Builder.item().of(ItemTags.SMALL_FLOWERS).build();
    public ItemPredicate HAS_TALL_FLOWER = ItemPredicate.Builder.item().of(ItemTags.TALL_FLOWERS).build();

    @Override
    public void generate(HolderLookup.Provider provider, Consumer<Advancement> consumer, ExistingFileHelper existingFileHelper) {
        Advancement gems_root = Advancement.Builder.advancement()
                .display(rootDisplayInfo(EPBlocks.GEM_POLISHER.get(), "root"))
                .addCriterion("has_polisher", hasItems(HAS_POLISHER))
                .save(consumer, new ResourceLocation(EnhancedPlaythrough.MOD_ID, "gem_root"), existingFileHelper);

        //Gems path
        Advancement get_emerald = Advancement.Builder.advancement()
                .parent(gems_root)
                .display(taskDisplayInfo(Items.EMERALD, "polish_emerald"))
                .addCriterion("has_emerald", hasItems(Items.EMERALD))
                .save(consumer, new ResourceLocation(EnhancedPlaythrough.MOD_ID, "polish_emerald"), existingFileHelper);

        Advancement get_sapphire = Advancement.Builder.advancement()
                .parent(get_emerald)
                .display(taskDisplayInfo(EPItems.SAPPHIRE.get(), "polish_sapphire"))
                .addCriterion("has_sapphire", hasItems(EPItems.SAPPHIRE.get()))
                .save(consumer, new ResourceLocation(EnhancedPlaythrough.MOD_ID, "polish_sapphire"), existingFileHelper);

        Advancement get_ruby = Advancement.Builder.advancement()
                .parent(get_sapphire)
                .display(taskDisplayInfo(EPItems.RUBY.get(), "polish_ruby"))
                .addCriterion("has_ruby", hasItems(EPItems.RUBY.get()))
                .save(consumer, new ResourceLocation(EnhancedPlaythrough.MOD_ID, "polish_ruby"), existingFileHelper);

        Advancement get_garnet = Advancement.Builder.advancement()
                .parent(gems_root)
                .display(taskDisplayInfo(EPItems.GARNET.get(), "polish_garnet"))
                .addCriterion("has_garnet", hasItems(EPItems.GARNET.get()))
                .save(consumer, new ResourceLocation(EnhancedPlaythrough.MOD_ID, "polish_garnet"), existingFileHelper);

        Advancement get_diamond = Advancement.Builder.advancement()
                .parent(get_garnet)
                .display(taskDisplayInfo(Items.DIAMOND, "polish_diamond"))
                .addCriterion("has_diamond", hasItems(Items.DIAMOND))
                .save(consumer, new ResourceLocation(EnhancedPlaythrough.MOD_ID, "polish_diamond"), existingFileHelper);

        Advancement get_all_gems = Advancement.Builder.advancement()
                .parent(gems_root)
                .display(challengeDisplayInfo(EPItems.NETHERITE_POLISHER.get(), "get_all_gems"))
                .addCriterion("has_emerald", hasItems(Items.EMERALD))
                .addCriterion("has_sapphire", hasItems(EPItems.SAPPHIRE.get()))
                .addCriterion("has_ruby", hasItems(EPItems.RUBY.get()))
                .addCriterion("has_diamond", hasItems(Items.DIAMOND))
                .addCriterion("has_garnet", hasItems(EPItems.GARNET.get()))
                .rewards(AdvancementRewards.Builder.experience(100))
                .rewards(AdvancementRewards.Builder.loot(advancementReward("get_all_gems")))
                .requirements(RequirementsStrategy.AND)
                .save(consumer, new ResourceLocation(EnhancedPlaythrough.MOD_ID, "get_all_gems"), existingFileHelper);

        //Flowers path
        Advancement first_flower = Advancement.Builder.advancement()
                .parent(gems_root)
                .display(taskDisplayInfo(Items.POPPY, "first_flower"))
                .addCriterion("has_small_flower", hasItems(HAS_SMALL_FLOWER))
                .addCriterion("has_tall_flower", hasItems(HAS_TALL_FLOWER))
                .addCriterion("has_cold_lyrium", hasItems(EPBlocks.COLD_LYRIUM.get())).addCriterion("has_succulent", hasItems(EPBlocks.SUCCULENT.get()))
                .requirements(RequirementsStrategy.OR)
                .save(consumer, new ResourceLocation(EnhancedPlaythrough.MOD_ID, "first_flower"), existingFileHelper);

        Advancement all_small_flowers = Advancement.Builder.advancement()
                .parent(first_flower)
                .display(taskDisplayInfo(Items.DANDELION, "all_small_flowers"))
                .addCriterion("has_dandelion", hasItems(Items.DANDELION)).addCriterion("has_poppy", hasItems(Items.POPPY))
                .addCriterion("has_blue_orchid", hasItems(Items.BLUE_ORCHID)).addCriterion("has_allium", hasItems(Items.ALLIUM))
                .addCriterion("has_azure_bluet", hasItems(Items.AZURE_BLUET)).addCriterion("has_red_tulip", hasItems(Items.RED_TULIP))
                .addCriterion("has_orange_tulip", hasItems(Items.ORANGE_TULIP)).addCriterion("has_white_tulip", hasItems(Items.WHITE_TULIP))
                .addCriterion("has_pink_tulip", hasItems(Items.PINK_TULIP)).addCriterion("has_oxeye_daisy", hasItems(Items.OXEYE_DAISY))
                .addCriterion("has_cornflower", hasItems(Items.CORNFLOWER)).addCriterion("has_lily_of_the_valley", hasItems(Items.LILY_OF_THE_VALLEY))
                .addCriterion("has_wither_rose", hasItems(Items.WITHER_ROSE)).addCriterion("has_torchflower", hasItems(Items.TORCHFLOWER))
                .addCriterion("has_cold_lyrium", hasItems(EPBlocks.COLD_LYRIUM.get())).addCriterion("has_succulent", hasItems(EPBlocks.SUCCULENT.get()))
                .rewards(AdvancementRewards.Builder.experience(200))
                .requirements(RequirementsStrategy.AND)
                .save(consumer, new ResourceLocation(EnhancedPlaythrough.MOD_ID, "all_small_flowers"), existingFileHelper);

        Advancement all_tall_flowers = Advancement.Builder.advancement()
                .parent(first_flower)
                .display(taskDisplayInfo(Items.ROSE_BUSH, "all_tall_flowers"))
                .addCriterion("has_sunflower", hasItems(Items.SUNFLOWER)).addCriterion("has_lilac", hasItems(Items.LILAC))
                .addCriterion("has_peony", hasItems(Items.PEONY)).addCriterion("has_rose_bush", hasItems(Items.ROSE_BUSH))
                .addCriterion("has_pitcher_plant", hasItems(Items.PITCHER_PLANT))
                .rewards(AdvancementRewards.Builder.experience(140))
                .requirements(RequirementsStrategy.AND)
                .save(consumer, new ResourceLocation(EnhancedPlaythrough.MOD_ID, "all_tall_flowers"), existingFileHelper);

        Advancement all_flowers = Advancement.Builder.advancement()
                .parent(first_flower)
                .display(challengeDisplayInfo(Items.SHEARS, "all_flowers"))
                .addCriterion("has_dandelion", hasItems(Items.DANDELION)).addCriterion("has_poppy", hasItems(Items.POPPY))
                .addCriterion("has_blue_orchid", hasItems(Items.BLUE_ORCHID)).addCriterion("has_allium", hasItems(Items.ALLIUM))
                .addCriterion("has_azure_bluet", hasItems(Items.AZURE_BLUET)).addCriterion("has_red_tulip", hasItems(Items.RED_TULIP))
                .addCriterion("has_orange_tulip", hasItems(Items.ORANGE_TULIP)).addCriterion("has_white_tulip", hasItems(Items.WHITE_TULIP))
                .addCriterion("has_pink_tulip", hasItems(Items.PINK_TULIP)).addCriterion("has_oxeye_daisy", hasItems(Items.OXEYE_DAISY))
                .addCriterion("has_cornflower", hasItems(Items.CORNFLOWER)).addCriterion("has_lily_of_the_valley", hasItems(Items.LILY_OF_THE_VALLEY))
                .addCriterion("has_wither_rose", hasItems(Items.WITHER_ROSE)).addCriterion("has_torchflower", hasItems(Items.TORCHFLOWER))
                .addCriterion("has_cold_lyrium", hasItems(EPBlocks.COLD_LYRIUM.get())).addCriterion("has_succulent", hasItems(EPBlocks.SUCCULENT.get()))
                .addCriterion("has_sunflower", hasItems(Items.SUNFLOWER)).addCriterion("has_lilac", hasItems(Items.LILAC))
                .addCriterion("has_peony", hasItems(Items.PEONY)).addCriterion("has_rose_bush", hasItems(Items.ROSE_BUSH))
                .addCriterion("has_pitcher_plant", hasItems(Items.PITCHER_PLANT))
                .rewards(AdvancementRewards.Builder.experience(400))
                .rewards(AdvancementRewards.Builder.loot(advancementReward("all_flowers")))
                .requirements(RequirementsStrategy.AND)
                .save(consumer, new ResourceLocation(EnhancedPlaythrough.MOD_ID, "all_flowers"), existingFileHelper);
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
