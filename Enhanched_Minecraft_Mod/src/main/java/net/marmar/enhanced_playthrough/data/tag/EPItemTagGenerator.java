package net.marmar.enhanced_playthrough.data.tag;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.block.EPBlocks;
import net.marmar.enhanced_playthrough.item.EPItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class EPItemTagGenerator extends ItemTagsProvider {
    public EPItemTagGenerator(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> lookupProviderBlocks, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, lookupProvider, lookupProviderBlocks, EnhancedPlaythrough.MOD_ID, existingFileHelper);
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(ItemTags.LOGS_THAT_BURN).add(
                //Walnut
                EPBlocks.WALNUT_LOG.get().asItem(),
                EPBlocks.STRIPPED_WALNUT_LOG.get().asItem(),
                EPBlocks.WALNUT_WOOD.get().asItem(),
                EPBlocks.STRIPPED_WALNUT_WOOD.get().asItem(),

                //Apple
                EPBlocks.APPLE_LOG.get().asItem(),
                EPBlocks.STRIPPED_APPLE_LOG.get().asItem(),
                EPBlocks.APPLE_WOOD.get().asItem(),
                EPBlocks.STRIPPED_APPLE_WOOD.get().asItem(),

                //Orange
                EPBlocks.ORANGE_LOG.get().asItem(),
                EPBlocks.STRIPPED_ORANGE_LOG.get().asItem(),
                EPBlocks.ORANGE_WOOD.get().asItem(),
                EPBlocks.STRIPPED_ORANGE_WOOD.get().asItem(),

                //Lemon
                EPBlocks.LEMON_LOG.get().asItem(),
                EPBlocks.STRIPPED_LEMON_LOG.get().asItem(),
                EPBlocks.LEMON_WOOD.get().asItem(),
                EPBlocks.STRIPPED_LEMON_WOOD.get().asItem()
        );

        this.tag(ItemTags.SIGNS).add(
                EPItems.WALNUT_SIGN.get(),
                EPItems.APPLE_SIGN.get(),
                EPItems.ORANGE_SIGN.get(),
                EPItems.LEMON_SIGN.get()
        );

        this.tag(ItemTags.HANGING_SIGNS).add(
                EPItems.WALNUT_HANGING_SIGN.get(),
                EPItems.APPLE_HANGING_SIGN.get(),
                EPItems.ORANGE_HANGING_SIGN.get(),
                EPItems.LEMON_HANGING_SIGN.get()
        );

        this.tag(ItemTags.PLANKS).add(
                EPBlocks.WALNUT_PLANKS.get().asItem(),
                EPBlocks.APPLE_PLANKS.get().asItem(),
                EPBlocks.ORANGE_PLANKS.get().asItem(),
                EPBlocks.LEMON_PLANKS.get().asItem()
        );

        this.tag(EPTags.Items.WALNUT_LOGS).add(
                EPBlocks.WALNUT_LOG.get().asItem(),
                EPBlocks.STRIPPED_WALNUT_LOG.get().asItem(),
                EPBlocks.WALNUT_WOOD.get().asItem(),
                EPBlocks.STRIPPED_WALNUT_WOOD.get().asItem()
        );

        this.tag(EPTags.Items.APPLE_LOGS).add(
                EPBlocks.APPLE_LOG.get().asItem(),
                EPBlocks.STRIPPED_APPLE_LOG.get().asItem(),
                EPBlocks.APPLE_WOOD.get().asItem(),
                EPBlocks.STRIPPED_APPLE_WOOD.get().asItem()
        );

        this.tag(EPTags.Items.ORANGE_LOGS).add(
                EPBlocks.ORANGE_LOG.get().asItem(),
                EPBlocks.STRIPPED_ORANGE_LOG.get().asItem(),
                EPBlocks.ORANGE_WOOD.get().asItem(),
                EPBlocks.STRIPPED_ORANGE_WOOD.get().asItem()
        );

        this.tag(EPTags.Items.LEMON_LOGS).add(
                EPBlocks.LEMON_LOG.get().asItem(),
                EPBlocks.STRIPPED_LEMON_LOG.get().asItem(),
                EPBlocks.LEMON_WOOD.get().asItem(),
                EPBlocks.STRIPPED_LEMON_WOOD.get().asItem()
        );

        this.tag(Tags.Items.STRING).add(
                EPItems.VEGETABLE_FIBBER.get()
        );

        this.tag(EPTags.Items.COBBLE).add(
                EPItems.COBBLE.get(),
                EPItems.LIMESTONE_COBBLE.get(),
                EPItems.DEEPSLATE_COBBLE.get(),
                EPItems.BLACKSTONE_COBBLE.get()
        );

        this.tag(EPTags.Items.TERRACOTTA_SHARD).add(
                EPItems.TERRACOTTA_SHARD.get(),
                EPItems.WHITE_TERRACOTTA_SHARD.get(),
                EPItems.ORANGE_TERRACOTTA_SHARD.get(),
                EPItems.MAGENTA_TERRACOTTA_SHARD.get(),
                EPItems.LIGHT_BLUE_TERRACOTTA_SHARD.get(),
                EPItems.YELLOW_TERRACOTTA_SHARD.get(),
                EPItems.LIME_TERRACOTTA_SHARD.get(),
                EPItems.PINK_TERRACOTTA_SHARD.get(),
                EPItems.GRAY_TERRACOTTA_SHARD.get(),
                EPItems.LIGHT_GRAY_TERRACOTTA_SHARD.get(),
                EPItems.CYAN_TERRACOTTA_SHARD.get(),
                EPItems.PURPLE_TERRACOTTA_SHARD.get(),
                EPItems.BLUE_TERRACOTTA_SHARD.get(),
                EPItems.BROWN_TERRACOTTA_SHARD.get(),
                EPItems.GREEN_TERRACOTTA_SHARD.get(),
                EPItems.RED_TERRACOTTA_SHARD.get(),
                EPItems.BLACK_TERRACOTTA_SHARD.get()
        );

        this.tag(Tags.Items.RAW_MATERIALS).add(
                EPItems.RAW_TIN.get(),
                EPItems.RAW_ZINC.get(),
                EPItems.RAW_SILVER.get(),
                EPItems.RAW_ALUMINUM.get(),
                EPItems.RAW_EMERALD.get(),
                EPItems.RAW_SAPPHIRE.get(),
                EPItems.RAW_RUBY.get(),
                EPItems.RAW_DIAMOND.get()
        );

        this.tag(EPTags.Items.BASIC_INGREDIENT).add(
                Items.RAW_COPPER,
                Blocks.COPPER_ORE.asItem(),
                EPItems.RAW_ZINC.get(),
                EPBlocks.ZINC_ORE.get().asItem(),
                EPItems.RAW_TIN.get(),
                EPBlocks.TIN_ORE.get().asItem(),
                Items.BEEF,
                Items.CHICKEN,
                Items.PORKCHOP,
                Items.MUTTON,
                Items.RABBIT,
                Items.KELP,
                Items.SALMON,
                Items.COD,
                Items.POTATO,
                Items.CLAY_BALL,
                EPItems.ZAPALLO.get(),
                EPItems.CORN.get(),
                EPItems.EGGPLANT.get()
        );

        this.tag(EPTags.Items.MASONRY_INGREDIENT).add(
                Items.CLAY_BALL,
                Items.BRICK,
                Blocks.CLAY.asItem(),
                Blocks.WHITE_TERRACOTTA.asItem(),
                Blocks.BLACK_TERRACOTTA.asItem(),
                Blocks.YELLOW_TERRACOTTA.asItem(),
                Blocks.RED_TERRACOTTA.asItem(),
                Blocks.BLUE_TERRACOTTA.asItem(),
                Blocks.GREEN_TERRACOTTA.asItem(),
                Blocks.BROWN_TERRACOTTA.asItem(),
                Blocks.PURPLE_TERRACOTTA.asItem(),
                Blocks.PINK_TERRACOTTA.asItem(),
                Blocks.MAGENTA_TERRACOTTA.asItem(),
                Blocks.CYAN_TERRACOTTA.asItem(),
                Blocks.LIGHT_BLUE_TERRACOTTA.asItem(),
                Blocks.GRAY_TERRACOTTA.asItem(),
                Blocks.LIGHT_GRAY_TERRACOTTA.asItem(),
                Blocks.ORANGE_TERRACOTTA.asItem(),
                Blocks.LIME_TERRACOTTA.asItem(),
                Blocks.NETHERRACK.asItem(),
                Blocks.COBBLESTONE.asItem(),
                Blocks.STONE.asItem(),
                Blocks.STONE_BRICKS.asItem(),
                Blocks.COBBLED_DEEPSLATE.asItem(),
                Blocks.DEEPSLATE.asItem(),
                Blocks.DEEPSLATE_BRICKS.asItem(),
                Blocks.DEEPSLATE_TILES.asItem(),
                Blocks.SAND.asItem(),
                Blocks.RED_SAND.asItem(),
                Blocks.SANDSTONE.asItem(),
                Blocks.RED_SANDSTONE.asItem()
        );

        this.tag(EPTags.Items.ALLOY_INGREDIENT).add(
                Items.RAW_COPPER,
                Items.RAW_IRON,
                Items.COAL,
                EPItems.RAW_TIN.get(),
                EPItems.RAW_ZINC.get()
        );

        this.tag(EPTags.Items.BLAST_ALLOY_INGREDIENT).addTags(EPTags.Items.ALLOY_INGREDIENT).add(
                        Items.RAW_GOLD,
                        Items.COPPER_INGOT,
                        Items.IRON_INGOT,
                        Items.GOLD_INGOT,
                        EPItems.TIN_INGOT.get(),
                        EPItems.ZINC_INGOT.get(),
                        EPItems.SILVER_INGOT.get(),
                        EPItems.COBALT.get()
                );

        this.tag(EPTags.Items.PRIMAL_GRIND_INGREDIENT)
                .addTags(ItemTags.WOOL,
                        EPTags.Items.ZINC_MANUFACTURABLE,
                        EPTags.Items.TIN_MANUFACTURABLE,
                        EPTags.Items.COPPER_MANUFACTURABLE,
                        EPTags.Items.BRASS_MANUFACTURABLE,
                        EPTags.Items.BRONZE_MANUFACTURABLE
        ).add(
                EPBlocks.COBBLED_LIMESTONE.get().asItem(),
                Blocks.COBBLESTONE.asItem(),
                Blocks.COBBLED_DEEPSLATE.asItem(),
                EPBlocks.SMALL_REEDS.get().asItem(),
                EPBlocks.REEDS.get().asItem(),
                EPBlocks.TALL_REEDS.get().asItem(),
                EPItems.YERBA_MATE.get(),
                Items.WHEAT,
                Items.PUMPKIN,
                Items.SUGAR_CANE,
                Items.BONE,
                Items.BONE_MEAL,
                Items.LILY_OF_THE_VALLEY,
                Items.AZURE_BLUET,
                Items.OXEYE_DAISY,
                Items.WHITE_TULIP,
                Items.COCOA_BEANS,
                Items.POPPY,
                Items.RED_TULIP,
                Items.BEETROOT,
                Items.TORCHFLOWER,
                Items.ORANGE_TULIP,
                EPItems.ORANGE.get(),
                EPItems.LEMON.get(),
                Items.DANDELION,
                Items.BLUE_ORCHID,
                Items.CORNFLOWER,
                EPItems.LIME.get(),
                Items.ALLIUM,
                Items.PINK_TULIP,
                Items.PINK_PETALS
        );

        this.tag(EPTags.Items.MECHANICAL_GRIND_INGREDIENT)
                .addTags(EPTags.Items.PRIMAL_GRIND_INGREDIENT,
                        EPTags.Items.SILVER_MANUFACTURABLE,
                        EPTags.Items.GOLD_MANUFACTURABLE,
                        EPTags.Items.ROSE_GOLD_MANUFACTURABLE,
                        EPTags.Items.IRON_MANUFACTURABLE,
                        EPTags.Items.BRONZIUM_MANUFACTURABLE,
                        EPTags.Items.GREEN_GOLD_MANUFACTURABLE,
                        EPTags.Items.STEEL_MANUFACTURABLE,
                        EPTags.Items.BLUE_GOLD_MANUFACTURABLE
                ).add(
                Items.WITHER_ROSE,
                Items.ROSE_BUSH,
                Items.SUNFLOWER,
                Items.LAPIS_LAZULI,
                Items.PEONY
        );

        this.tag(EPTags.Items.ALUMINUM_ROD).add(
                EPItems.ALUMINUM_ROD.get()
        );

        this.tag(EPTags.Items.GOLD_MANUFACTURABLE).add(
                Items.GOLDEN_AXE, Items.GOLDEN_PICKAXE, Items.GOLDEN_SHOVEL, EPItems.GOLDEN_POLISHER.get(), Items.GOLDEN_HOE, Items.GOLDEN_SWORD,
                EPItems.GOLDEN_DAGGER.get(), EPItems.ALUMINUM_GOLDEN_AXE.get(), EPItems.ALUMINUM_GOLDEN_PICKAXE.get(),
                EPItems.ALUMINUM_GOLDEN_SWORD.get(), EPItems.ALUMINUM_GOLDEN_DAGGER.get(), EPItems.ALUMINUM_GOLDEN_SHOVEL.get(),
                EPItems.ALUMINUM_GOLDEN_HOE.get(), EPItems.ALUMINUM_GOLDEN_POLISHER.get(), Items.GOLDEN_HELMET, Items.GOLDEN_CHESTPLATE, Items.GOLDEN_LEGGINGS, Items.GOLDEN_BOOTS);

        this.tag(EPTags.Items.SILVER_MANUFACTURABLE).add(
                EPItems.SILVER_AXE.get(), EPItems.SILVER_HOE.get(), EPItems.SILVER_PICKAXE.get(),
                EPItems.SILVER_POLISHER.get(), EPItems.SILVER_SHOVEL.get(), EPItems.SILVER_SWORD.get(), EPItems.SILVER_DAGGER.get(),
                EPItems.ALUMINUM_SILVER_AXE.get(), EPItems.ALUMINUM_SILVER_PICKAXE.get(),
                EPItems.ALUMINUM_SILVER_SWORD.get(), EPItems.ALUMINUM_SILVER_DAGGER.get(), EPItems.ALUMINUM_SILVER_SHOVEL.get(),
                EPItems.ALUMINUM_SILVER_HOE.get(), EPItems.ALUMINUM_SILVER_POLISHER.get(),
                EPItems.SILVER_HELMET.get(), EPItems.SILVER_CHESTPLATE.get(), EPItems.SILVER_LEGGINGS.get(), EPItems.SILVER_BOOTS.get());

        this.tag(EPTags.Items.ALUMINUM_MANUFACTURABLE).add(EPItems.RAW_ALUMINUM.get(), EPItems.ALUMINUM_INGOT.get());

        this.tag(EPTags.Items.ZINC_MANUFACTURABLE).add(EPItems.RAW_ZINC.get(), EPItems.ZINC_INGOT.get());

        this.tag(EPTags.Items.TIN_MANUFACTURABLE).add(EPItems.RAW_TIN.get(), EPItems.TIN_INGOT.get());

        this.tag(EPTags.Items.COPPER_MANUFACTURABLE).add(Items.COPPER_INGOT, Items.RAW_COPPER);

        this.tag(EPTags.Items.BRASS_MANUFACTURABLE).add(
                EPItems.BRASS_AXE.get(), EPItems.BRASS_HOE.get(), EPItems.BRASS_PICKAXE.get(),
                EPItems.BRASS_POLISHER.get(), EPItems.BRASS_SHOVEL.get(), EPItems.BRASS_SWORD.get(), EPItems.BRASS_DAGGER.get(),
                EPItems.ALUMINUM_BRASS_AXE.get(), EPItems.ALUMINUM_BRASS_PICKAXE.get(),
                EPItems.ALUMINUM_BRASS_SWORD.get(), EPItems.ALUMINUM_BRASS_DAGGER.get(), EPItems.ALUMINUM_BRASS_SHOVEL.get(),
                EPItems.ALUMINUM_BRASS_HOE.get(), EPItems.ALUMINUM_BRASS_POLISHER.get(),
                EPItems.BRASS_HELMET.get(), EPItems.BRASS_CHESTPLATE.get(), EPItems.BRASS_LEGGINGS.get(), EPItems.BRASS_BOOTS.get());

        this.tag(EPTags.Items.BRONZE_MANUFACTURABLE).add(
                EPItems.BRONZE_AXE.get(), EPItems.BRONZE_HOE.get(), EPItems.BRONZE_PICKAXE.get(),
                EPItems.BRONZE_POLISHER.get(), EPItems.BRONZE_SHOVEL.get(), EPItems.BRONZE_SWORD.get(), EPItems.BRONZE_DAGGER.get(),
                EPItems.ALUMINUM_BRONZE_AXE.get(), EPItems.ALUMINUM_BRONZE_PICKAXE.get(),
                EPItems.ALUMINUM_BRONZE_SWORD.get(), EPItems.ALUMINUM_BRONZE_DAGGER.get(), EPItems.ALUMINUM_BRONZE_SHOVEL.get(),
                EPItems.ALUMINUM_BRONZE_HOE.get(), EPItems.ALUMINUM_BRONZE_POLISHER.get(),
                EPItems.BRONZE_HELMET.get(), EPItems.BRONZE_CHESTPLATE.get(), EPItems.BRONZE_LEGGINGS.get(), EPItems.BRONZE_BOOTS.get());

        this.tag(EPTags.Items.ROSE_GOLD_MANUFACTURABLE).add(
                EPItems.ROSE_GOLDEN_AXE.get(), EPItems.ROSE_GOLDEN_HOE.get(), EPItems.ROSE_GOLDEN_PICKAXE.get(),
                EPItems.ROSE_GOLDEN_POLISHER.get(), EPItems.ROSE_GOLDEN_SHOVEL.get(), EPItems.ROSE_GOLDEN_SWORD.get(), EPItems.ROSE_GOLDEN_DAGGER.get(),
                EPItems.ALUMINUM_ROSE_GOLDEN_AXE.get(), EPItems.ALUMINUM_ROSE_GOLDEN_PICKAXE.get(),
                EPItems.ALUMINUM_ROSE_GOLDEN_SWORD.get(), EPItems.ALUMINUM_ROSE_GOLDEN_DAGGER.get(), EPItems.ALUMINUM_ROSE_GOLDEN_SHOVEL.get(),
                EPItems.ALUMINUM_ROSE_GOLDEN_HOE.get(), EPItems.ALUMINUM_ROSE_GOLDEN_POLISHER.get(),
                EPItems.ROSE_GOLDEN_HELMET.get(), EPItems.ROSE_GOLDEN_CHESTPLATE.get(), EPItems.ROSE_GOLDEN_LEGGINGS.get(), EPItems.ROSE_GOLDEN_BOOTS.get());

        this.tag(EPTags.Items.IRON_MANUFACTURABLE).add(
                Items.IRON_AXE, Items.IRON_PICKAXE, Items.IRON_SHOVEL, EPItems.IRON_POLISHER.get(), Items.IRON_HOE, Items.IRON_SWORD,
                EPItems.IRON_DAGGER.get(), EPItems.ALUMINUM_IRON_AXE.get(), EPItems.ALUMINUM_IRON_PICKAXE.get(),
                EPItems.ALUMINUM_IRON_SWORD.get(), EPItems.ALUMINUM_IRON_DAGGER.get(), EPItems.ALUMINUM_IRON_SHOVEL.get(),
                EPItems.ALUMINUM_IRON_HOE.get(), EPItems.ALUMINUM_IRON_POLISHER.get(), Items.IRON_HELMET, Items.IRON_CHESTPLATE, Items.IRON_LEGGINGS, Items.IRON_BOOTS);

        this.tag(EPTags.Items.BRONZIUM_MANUFACTURABLE).add(
                EPItems.BRONZIUM_AXE.get(), EPItems.BRONZIUM_HOE.get(), EPItems.BRONZIUM_POLISHER.get(), EPItems.BRONZIUM_PICKAXE.get(), EPItems.BRONZIUM_SHOVEL.get(), EPItems.BRONZIUM_SWORD.get(),
                EPItems.BRONZIUM_DAGGER.get(), EPItems.BRONZIUM_HELMET.get(), EPItems.BRONZIUM_CHESTPLATE.get(), EPItems.BRONZIUM_LEGGINGS.get(), EPItems.BRONZIUM_BOOTS.get());

        this.tag(EPTags.Items.GREEN_GOLD_MANUFACTURABLE).add(
                EPItems.GREEN_GOLDEN_AXE.get(), EPItems.GREEN_GOLDEN_HOE.get(), EPItems.GREEN_GOLDEN_PICKAXE.get(),
                EPItems.GREEN_GOLDEN_POLISHER.get(), EPItems.GREEN_GOLDEN_SHOVEL.get(), EPItems.GREEN_GOLDEN_SWORD.get(), EPItems.GREEN_GOLDEN_DAGGER.get(),
                EPItems.ALUMINUM_GREEN_GOLDEN_AXE.get(), EPItems.ALUMINUM_GREEN_GOLDEN_PICKAXE.get(),
                EPItems.ALUMINUM_GREEN_GOLDEN_SWORD.get(), EPItems.ALUMINUM_GREEN_GOLDEN_DAGGER.get(), EPItems.ALUMINUM_GREEN_GOLDEN_SHOVEL.get(),
                EPItems.ALUMINUM_GREEN_GOLDEN_HOE.get(), EPItems.ALUMINUM_GREEN_GOLDEN_POLISHER.get(),
                EPItems.GREEN_GOLDEN_HELMET.get(), EPItems.GREEN_GOLDEN_CHESTPLATE.get(), EPItems.GREEN_GOLDEN_LEGGINGS.get(), EPItems.GREEN_GOLDEN_BOOTS.get());

        this.tag(EPTags.Items.STEEL_MANUFACTURABLE).add(
                EPItems.STEEL_AXE.get(), EPItems.STEEL_HOE.get(), EPItems.STEEL_POLISHER.get(),
                EPItems.STEEL_PICKAXE.get(), EPItems.STEEL_SHOVEL.get(), EPItems.STEEL_SWORD.get(), EPItems.STEEL_DAGGER.get(),
                EPItems.ALUMINUM_STEEL_AXE.get(), EPItems.ALUMINUM_STEEL_PICKAXE.get(),
                EPItems.ALUMINUM_STEEL_SWORD.get(), EPItems.ALUMINUM_STEEL_DAGGER.get(), EPItems.ALUMINUM_STEEL_SHOVEL.get(),
                EPItems.ALUMINUM_STEEL_HOE.get(), EPItems.ALUMINUM_STEEL_POLISHER.get(),
                EPItems.STEEL_HELMET.get(), EPItems.STEEL_CHESTPLATE.get(), EPItems.STEEL_LEGGINGS.get(), EPItems.STEEL_BOOTS.get());

        this.tag(EPTags.Items.BLUE_GOLD_MANUFACTURABLE).add(
                EPItems.BLUE_GOLDEN_AXE.get(), EPItems.BLUE_GOLDEN_HOE.get(), EPItems.BLUE_GOLDEN_PICKAXE.get(),
                EPItems.BLUE_GOLDEN_POLISHER.get(), EPItems.BLUE_GOLDEN_SHOVEL.get(), EPItems.BLUE_GOLDEN_SWORD.get(), EPItems.BLUE_GOLDEN_DAGGER.get(),
                EPItems.ALUMINUM_BLUE_GOLDEN_AXE.get(), EPItems.ALUMINUM_BLUE_GOLDEN_PICKAXE.get(),
                EPItems.ALUMINUM_BLUE_GOLDEN_SWORD.get(), EPItems.ALUMINUM_BLUE_GOLDEN_DAGGER.get(), EPItems.ALUMINUM_BLUE_GOLDEN_SHOVEL.get(),
                EPItems.ALUMINUM_BLUE_GOLDEN_HOE.get(), EPItems.ALUMINUM_BLUE_GOLDEN_POLISHER.get(),
                EPItems.BLUE_GOLDEN_HELMET.get(), EPItems.BLUE_GOLDEN_CHESTPLATE.get(), EPItems.BLUE_GOLDEN_LEGGINGS.get(), EPItems.BLUE_GOLDEN_BOOTS.get());

        this.tag(EPTags.Items.BAUXITE_ORE).add(
                EPBlocks.BAUXITE.get().asItem(),
                EPBlocks.WHITE_BAUXITE.get().asItem(),
                EPBlocks.LIGHT_GRAY_BAUXITE.get().asItem(),
                EPBlocks.BROWN_BAUXITE.get().asItem(),
                EPBlocks.RED_BAUXITE.get().asItem(),
                EPBlocks.ORANGE_BAUXITE.get().asItem(),
                EPBlocks.YELLOW_BAUXITE.get().asItem()
        );

        this.tag(Tags.Items.INGOTS).add(
                EPItems.SILVER_INGOT.get(),
                EPItems.ALUMINUM_INGOT.get(),
                EPItems.TIN_INGOT.get(),
                EPItems.ZINC_INGOT.get(),
                EPItems.BRONZE_INGOT.get(),
                EPItems.BRASS_INGOT.get(),
                EPItems.ROSE_GOLD_INGOT.get(),
                EPItems.BRONZIUM_INGOT.get(),
                EPItems.STEEL_INGOT.get(),
                EPItems.GREEN_GOLD_INGOT.get(),
                EPItems.BLUE_GOLD_INGOT.get()
        );

        //Specific ingots
        this.tag(EPTags.Items.SILVER_INGOT).add(EPItems.SILVER_INGOT.get());
        this.tag(EPTags.Items.ALUMINUM_INGOT).add(EPItems.ALUMINUM_INGOT.get());
        this.tag(EPTags.Items.BRASS_INGOT).add(EPItems.BRASS_INGOT.get());
        this.tag(EPTags.Items.BRONZE_INGOT).add(EPItems.BRONZE_INGOT.get());
        this.tag(EPTags.Items.ROSE_GOLD_INGOT).add(EPItems.ROSE_GOLD_INGOT.get());
        this.tag(EPTags.Items.BRONZIUM_INGOT).add(EPItems.BRONZIUM_INGOT.get());
        this.tag(EPTags.Items.GREEN_GOLD_INGOT).add(EPItems.GREEN_GOLD_INGOT.get());
        this.tag(EPTags.Items.STEEL_INGOT).add(EPItems.STEEL_INGOT.get());
        this.tag(EPTags.Items.BLUE_GOLD_INGOT).add(EPItems.BLUE_GOLD_INGOT.get());
        this.tag(EPTags.Items.TIN_INGOT).add(EPItems.TIN_INGOT.get());
        this.tag(EPTags.Items.ZINC_INGOT).add(EPItems.ZINC_INGOT.get());

        this.tag(Tags.Items.DUSTS).add(
                EPItems.GOLD_DUST.get(),
                EPItems.SILVER_DUST.get(),
                EPItems.ALUMINUM_DUST.get(),
                EPItems.ZINC_DUST.get(),
                EPItems.TIN_DUST.get(),
                EPItems.COPPER_DUST.get(),
                EPItems.BRASS_DUST.get(),
                EPItems.BRONZE_DUST.get(),
                EPItems.ROSE_GOLD_DUST.get(),
                EPItems.IRON_DUST.get(),
                EPItems.BRONZIUM_DUST.get(),
                EPItems.GREEN_GOLD_DUST.get(),
                EPItems.STEEL_DUST.get(),
                EPItems.BLUE_GOLD_DUST.get()
        );

        this.tag(Tags.Items.NUGGETS).add(
                EPItems.SILVER_NUGGET.get(),
                EPItems.ALUMINUM_NUGGET.get(),
                EPItems.COPPER_NUGGET.get(),
                EPItems.TIN_NUGGET.get(),
                EPItems.ZINC_NUGGET.get(),
                EPItems.BRONZE_NUGGET.get(),
                EPItems.BRASS_NUGGET.get(),
                EPItems.ROSE_GOLD_NUGGET.get(),
                EPItems.BRONZIUM_NUGGET.get(),
                EPItems.STEEL_NUGGET.get(),
                EPItems.GREEN_GOLD_NUGGET.get(),
                EPItems.BLUE_GOLD_NUGGET.get()
        );

        this.tag(ItemTags.STONE_CRAFTING_MATERIALS).add(
                EPBlocks.COBBLED_LIMESTONE.get().asItem()
        );

        this.tag(EPTags.Items.GOLD).add(
                Items.GOLDEN_AXE, Items.GOLDEN_PICKAXE, Items.GOLDEN_SHOVEL, Items.GOLDEN_SWORD, EPItems.GOLDEN_DAGGER.get(),
                EPItems.GOLDEN_POLISHER.get(), Items.GOLDEN_HOE, Items.GOLDEN_HELMET, Items.GOLDEN_CHESTPLATE, Items.GOLDEN_LEGGINGS,
                Items.GOLDEN_BOOTS
        );

        this.tag(EPTags.Items.BRONZE).add(
                EPItems.BRONZE_INGOT.get(), EPItems.BRONZE_NUGGET.get(), EPBlocks.BRONZE_BLOCK.get().asItem(),
                EPItems.BRONZE_SWORD.get(), EPItems.BRONZE_DAGGER.get(),
                EPItems.BRONZE_PICKAXE.get(), EPItems.BRONZE_AXE.get(), EPItems.BRONZE_SHOVEL.get(), EPItems.BRONZE_HOE.get(),
                EPItems.BRONZE_POLISHER.get(),
                EPItems.BRONZE_HELMET.get(), EPItems.BRONZE_CHESTPLATE.get(), EPItems.BRONZE_LEGGINGS.get(), EPItems.BRONZE_BOOTS.get()
        );

        this.tag(EPTags.Items.BRASS).add(
                EPItems.BRASS_INGOT.get(), EPItems.BRASS_NUGGET.get(), EPBlocks.BRASS_BLOCK.get().asItem(),
                EPItems.BRASS_SWORD.get(), EPItems.BRASS_DAGGER.get(),
                EPItems.BRASS_PICKAXE.get(), EPItems.BRASS_AXE.get(), EPItems.BRASS_SHOVEL.get(), EPItems.BRASS_HOE.get(),
                EPItems.BRASS_POLISHER.get(),
                EPItems.BRASS_HELMET.get(), EPItems.BRASS_CHESTPLATE.get(), EPItems.BRASS_LEGGINGS.get(), EPItems.BRASS_BOOTS.get()
        );

        this.tag(EPTags.Items.ROSE_GOLD).add(
                EPItems.ROSE_GOLD_INGOT.get(), EPItems.ROSE_GOLD_NUGGET.get(), EPBlocks.ROSE_GOLD_BLOCK.get().asItem(),
                EPItems.ROSE_GOLDEN_SWORD.get(), EPItems.ROSE_GOLDEN_DAGGER.get(),
                EPItems.ROSE_GOLDEN_PICKAXE.get(), EPItems.ROSE_GOLDEN_AXE.get(), EPItems.ROSE_GOLDEN_SHOVEL.get(), EPItems.ROSE_GOLDEN_HOE.get(),
                EPItems.ROSE_GOLDEN_POLISHER.get(),
                EPItems.ROSE_GOLDEN_HELMET.get(), EPItems.ROSE_GOLDEN_CHESTPLATE.get(), EPItems.ROSE_GOLDEN_LEGGINGS.get(), EPItems.ROSE_GOLDEN_BOOTS.get()
        );

        this.tag(EPTags.Items.IRON).add(
                Items.IRON_AXE, Items.IRON_PICKAXE, Items.IRON_SHOVEL, Items.IRON_SWORD, EPItems.IRON_DAGGER.get(), EPItems.IRON_POLISHER.get(),
                Items.IRON_HOE, Items.IRON_HELMET, Items.IRON_CHESTPLATE, Items.IRON_LEGGINGS, Items.IRON_BOOTS
        );

        this.tag(EPTags.Items.BRONZIUM).add(
                EPItems.BRONZIUM_INGOT.get(), EPItems.BRONZIUM_NUGGET.get(), EPBlocks.BRONZIUM_BLOCK.get().asItem(),
                EPItems.BRONZIUM_SWORD.get(), EPItems.BRONZIUM_DAGGER.get(), EPItems.BRONZIUM_PICKAXE.get(),
                EPItems.BRONZIUM_AXE.get(), EPItems.BRONZIUM_SHOVEL.get(), EPItems.BRONZIUM_HOE.get(), EPItems.BRONZIUM_POLISHER.get(),
                EPItems.BRONZIUM_HELMET.get(), EPItems.BRONZIUM_CHESTPLATE.get(), EPItems.BRONZIUM_LEGGINGS.get(), EPItems.BRONZIUM_BOOTS.get()
        );

        this.tag(EPTags.Items.STEEL).add(
                EPItems.STEEL_INGOT.get(), EPItems.STEEL_NUGGET.get(), EPBlocks.STEEL_BLOCK.get().asItem(),
                EPItems.STEEL_SWORD.get(), EPItems.STEEL_DAGGER.get(), EPItems.STEEL_PICKAXE.get(),
                EPItems.STEEL_AXE.get(), EPItems.STEEL_SHOVEL.get(), EPItems.STEEL_HOE.get(), EPItems.STEEL_POLISHER.get(),
                EPItems.STEEL_HELMET.get(), EPItems.STEEL_CHESTPLATE.get(), EPItems.STEEL_LEGGINGS.get(), EPItems.STEEL_BOOTS.get()
                );

        this.tag(EPTags.Items.GREEN_GOLD).add(
                EPItems.GREEN_GOLD_INGOT.get(), EPItems.GREEN_GOLD_NUGGET.get(), EPBlocks.GREEN_GOLD_BLOCK.get().asItem(),
                EPItems.GREEN_GOLDEN_SWORD.get(), EPItems.GREEN_GOLDEN_DAGGER.get(), EPItems.GREEN_GOLDEN_PICKAXE.get(),
                EPItems.GREEN_GOLDEN_AXE.get(), EPItems.GREEN_GOLDEN_SHOVEL.get(), EPItems.GREEN_GOLDEN_HOE.get(), EPItems.GREEN_GOLDEN_POLISHER.get(),
                EPItems.GREEN_GOLDEN_HELMET.get(), EPItems.GREEN_GOLDEN_CHESTPLATE.get(), EPItems.GREEN_GOLDEN_LEGGINGS.get(), EPItems.GREEN_GOLDEN_BOOTS.get()
        );

        this.tag(EPTags.Items.BLUE_GOLD).add(
                EPItems.BLUE_GOLD_INGOT.get(), EPItems.BLUE_GOLD_NUGGET.get(), EPBlocks.BLUE_GOLD_BLOCK.get().asItem(),
                EPItems.BLUE_GOLDEN_SWORD.get(), EPItems.BLUE_GOLDEN_DAGGER.get(), EPItems.BLUE_GOLDEN_PICKAXE.get(),
                EPItems.BLUE_GOLDEN_AXE.get(), EPItems.BLUE_GOLDEN_SHOVEL.get(), EPItems.BLUE_GOLDEN_HOE.get(), EPItems.BLUE_GOLDEN_POLISHER.get(),
                EPItems.BLUE_GOLDEN_HELMET.get(), EPItems.BLUE_GOLDEN_CHESTPLATE.get(), EPItems.BLUE_GOLDEN_LEGGINGS.get(), EPItems.BLUE_GOLDEN_BOOTS.get()
        );

        this.tag(EPTags.Items.SILVER).add(
                EPItems.SILVER_INGOT.get(), EPItems.SILVER_NUGGET.get(), EPBlocks.SILVER_BLOCK.get().asItem(),
                EPItems.SILVER_SWORD.get(), EPItems.SILVER_DAGGER.get(),
                EPItems.SILVER_PICKAXE.get(), EPItems.SILVER_AXE.get(), EPItems.SILVER_SHOVEL.get(), EPItems.SILVER_HOE.get(),
                EPItems.SILVER_POLISHER.get(),
                EPItems.SILVER_HELMET.get(), EPItems.SILVER_CHESTPLATE.get(), EPItems.SILVER_LEGGINGS.get(), EPItems.SILVER_BOOTS.get()
                );

        this.tag(EPTags.Items.ALUMINUM).add(EPItems.ALUMINUM_INGOT.get(), EPItems.ALUMINUM_NUGGET.get(), EPItems.ALUMINUM_ROD.get());

        this.tag(ItemTags.TRIMMABLE_ARMOR).add(
                EPItems.SILVER_HELMET.get(), EPItems.SILVER_CHESTPLATE.get(), EPItems.SILVER_LEGGINGS.get(), EPItems.SILVER_BOOTS.get(),
                EPItems.BRONZE_HELMET.get(), EPItems.BRONZE_CHESTPLATE.get(), EPItems.BRONZE_LEGGINGS.get(), EPItems.BRONZE_BOOTS.get(),
                EPItems.BRASS_HELMET.get(), EPItems.BRASS_CHESTPLATE.get(), EPItems.BRASS_LEGGINGS.get(), EPItems.BRASS_BOOTS.get(),
                EPItems.ROSE_GOLDEN_HELMET.get(), EPItems.ROSE_GOLDEN_CHESTPLATE.get(), EPItems.ROSE_GOLDEN_LEGGINGS.get(), EPItems.ROSE_GOLDEN_BOOTS.get(),
                EPItems.BRONZIUM_HELMET.get(), EPItems.BRONZIUM_CHESTPLATE.get(), EPItems.BRONZIUM_LEGGINGS.get(), EPItems.BRONZIUM_BOOTS.get(),
                EPItems.GREEN_GOLDEN_HELMET.get(), EPItems.GREEN_GOLDEN_CHESTPLATE.get(), EPItems.GREEN_GOLDEN_LEGGINGS.get(), EPItems.GREEN_GOLDEN_BOOTS.get(),
                EPItems.STEEL_HELMET.get(), EPItems.STEEL_CHESTPLATE.get(), EPItems.STEEL_LEGGINGS.get(), EPItems.STEEL_BOOTS.get(),
                EPItems.BLUE_GOLDEN_HELMET.get(), EPItems.BLUE_GOLDEN_CHESTPLATE.get(), EPItems.BLUE_GOLDEN_LEGGINGS.get(), EPItems.BLUE_GOLDEN_BOOTS.get()
                );

        this.tag(EPTags.Items.RAW_GEM).add(
                EPItems.RAW_RUBY.get(),
                EPItems.RAW_SAPPHIRE.get(),
                EPItems.RAW_GARNET.get(),
                EPItems.RAW_EMERALD.get(),
                EPItems.RAW_DIAMOND.get()
                );

        this.tag(EPTags.Items.POLISHER).add(
                EPItems.SILVER_POLISHER.get(),
                EPItems.GOLDEN_POLISHER.get(),
                EPItems.STONE_POLISHER.get(),
                EPItems.BRASS_POLISHER.get(),
                EPItems.BRONZE_POLISHER.get(),
                EPItems.ROSE_GOLDEN_POLISHER.get(),
                EPItems.BRONZIUM_POLISHER.get(),
                EPItems.GREEN_GOLDEN_POLISHER.get(),
                EPItems.IRON_POLISHER.get(),
                EPItems.STEEL_POLISHER.get(),
                EPItems.BLUE_GOLDEN_POLISHER.get(),
                EPItems.DIAMOND_POLISHER.get(),
                EPItems.NETHERITE_POLISHER.get(),
                //Aluminum
                EPItems.ALUMINUM_STONE_POLISHER.get(),
                EPItems.ALUMINUM_GOLDEN_POLISHER.get(),
                EPItems.ALUMINUM_SILVER_POLISHER.get(),
                EPItems.ALUMINUM_BRONZE_POLISHER.get(),
                EPItems.ALUMINUM_BRASS_POLISHER.get(),
                EPItems.ALUMINUM_ROSE_GOLDEN_POLISHER.get(),
                EPItems.ALUMINUM_BRONZIUM_POLISHER.get(),
                EPItems.ALUMINUM_IRON_POLISHER.get(),
                EPItems.ALUMINUM_STEEL_POLISHER.get(),
                EPItems.ALUMINUM_GREEN_GOLDEN_POLISHER.get(),
                EPItems.ALUMINUM_BLUE_GOLDEN_POLISHER.get(),
                EPItems.ALUMINUM_DIAMOND_POLISHER.get()
        );

        this.tag(EPTags.Items.DAGGER).add(
                EPItems.SILVER_DAGGER.get(),
                EPItems.GOLDEN_DAGGER.get(),
                EPItems.WOODEN_DAGGER.get(),
                EPItems.STONE_DAGGER.get(),
                EPItems.BRASS_DAGGER.get(),
                EPItems.BRONZE_DAGGER.get(),
                EPItems.ROSE_GOLDEN_DAGGER.get(),
                EPItems.BRONZIUM_DAGGER.get(),
                EPItems.GREEN_GOLDEN_DAGGER.get(),
                EPItems.IRON_DAGGER.get(),
                EPItems.STEEL_DAGGER.get(),
                EPItems.BLUE_GOLDEN_DAGGER.get(),
                EPItems.DIAMOND_DAGGER.get(),
                EPItems.NETHERITE_DAGGER.get(),
                //Aluminum
                EPItems.ALUMINUM_WOODEN_DAGGER.get(),
                EPItems.ALUMINUM_STONE_DAGGER.get(),
                EPItems.ALUMINUM_GOLDEN_DAGGER.get(),
                EPItems.ALUMINUM_SILVER_DAGGER.get(),
                EPItems.ALUMINUM_BRONZE_DAGGER.get(),
                EPItems.ALUMINUM_BRASS_DAGGER.get(),
                EPItems.ALUMINUM_ROSE_GOLDEN_DAGGER.get(),
                EPItems.ALUMINUM_BRONZIUM_DAGGER.get(),
                EPItems.ALUMINUM_IRON_DAGGER.get(),
                EPItems.ALUMINUM_STEEL_DAGGER.get(),
                EPItems.ALUMINUM_GREEN_GOLDEN_DAGGER.get(),
                EPItems.ALUMINUM_BLUE_GOLDEN_DAGGER.get(),
                EPItems.ALUMINUM_DIAMOND_DAGGER.get()
        );

        this.tag(ItemTags.BEACON_PAYMENT_ITEMS).add(
                EPItems.RUBY.get(),
                EPItems.SAPPHIRE.get(),
                EPItems.GARNET.get(),
                EPItems.SILVER_INGOT.get(),
                EPItems.ALUMINUM_INGOT.get(),
                EPItems.TIN_INGOT.get(),
                EPItems.ZINC_INGOT.get(),
                EPItems.BRASS_INGOT.get(),
                EPItems.BRONZE_INGOT.get(),
                EPItems.ROSE_GOLD_INGOT.get(),
                EPItems.BRONZIUM_INGOT.get(),
                EPItems.STEEL_INGOT.get(),
                EPItems.GREEN_GOLD_INGOT.get(),
                EPItems.BLUE_GOLD_INGOT.get()
        );

        this.tag(ItemTags.PIGLIN_LOVED).add(
                EPItems.ROSE_GOLD_INGOT.get(),
                EPItems.GREEN_GOLD_INGOT.get(),
                EPItems.BLUE_GOLD_INGOT.get()
        );
    }

}
