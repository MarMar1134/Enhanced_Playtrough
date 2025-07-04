package net.marmar.enhanced_playthrough.data.tag;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.block.ModBlocks;
import net.marmar.enhanced_playthrough.item.ModItems;
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

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> lookupProviderBlocks, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, lookupProvider, lookupProviderBlocks, EnhancedPlaythrough.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(ItemTags.LOGS_THAT_BURN).add(
                //Walnut
                ModBlocks.WALNUT_LOG.get().asItem(),
                ModBlocks.STRIPPED_WALNUT_LOG.get().asItem(),
                ModBlocks.WALNUT_WOOD.get().asItem(),
                ModBlocks.STRIPPED_WALNUT_WOOD.get().asItem(),

                //Apple
                ModBlocks.APPLE_LOG.get().asItem(),
                ModBlocks.STRIPPED_APPLE_LOG.get().asItem(),
                ModBlocks.APPLE_WOOD.get().asItem(),
                ModBlocks.STRIPPED_APPLE_WOOD.get().asItem(),

                //Orange
                ModBlocks.ORANGE_LOG.get().asItem(),
                ModBlocks.STRIPPED_ORANGE_LOG.get().asItem(),
                ModBlocks.ORANGE_WOOD.get().asItem(),
                ModBlocks.STRIPPED_ORANGE_WOOD.get().asItem(),

                //Lemon
                ModBlocks.LEMON_LOG.get().asItem(),
                ModBlocks.STRIPPED_LEMON_LOG.get().asItem(),
                ModBlocks.LEMON_WOOD.get().asItem(),
                ModBlocks.STRIPPED_LEMON_WOOD.get().asItem()
        );

        this.tag(ItemTags.SIGNS).add(
                ModItems.WALNUT_SIGN.get(),
                ModItems.APPLE_SIGN.get(),
                ModItems.ORANGE_SIGN.get(),
                ModItems.LEMON_SIGN.get()
        );

        this.tag(ItemTags.HANGING_SIGNS).add(
                ModItems.WALNUT_HANGING_SIGN.get(),
                ModItems.APPLE_HANGING_SIGN.get(),
                ModItems.ORANGE_HANGING_SIGN.get(),
                ModItems.LEMON_HANGING_SIGN.get()
        );

        this.tag(ItemTags.PLANKS).add(
                ModBlocks.WALNUT_PLANKS.get().asItem(),
                ModBlocks.APPLE_PLANKS.get().asItem(),
                ModBlocks.ORANGE_PLANKS.get().asItem(),
                ModBlocks.LEMON_PLANKS.get().asItem()
        );

        this.tag(ModTags.Items.WALNUT_LOGS).add(
                ModBlocks.WALNUT_LOG.get().asItem(),
                ModBlocks.STRIPPED_WALNUT_LOG.get().asItem(),
                ModBlocks.WALNUT_WOOD.get().asItem(),
                ModBlocks.STRIPPED_WALNUT_WOOD.get().asItem()
        );

        this.tag(ModTags.Items.APPLE_LOGS).add(
                ModBlocks.APPLE_LOG.get().asItem(),
                ModBlocks.STRIPPED_APPLE_LOG.get().asItem(),
                ModBlocks.APPLE_WOOD.get().asItem(),
                ModBlocks.STRIPPED_APPLE_WOOD.get().asItem()
        );

        this.tag(ModTags.Items.ORANGE_LOGS).add(
                ModBlocks.ORANGE_LOG.get().asItem(),
                ModBlocks.STRIPPED_ORANGE_LOG.get().asItem(),
                ModBlocks.ORANGE_WOOD.get().asItem(),
                ModBlocks.STRIPPED_ORANGE_WOOD.get().asItem()
        );

        this.tag(ModTags.Items.LEMON_LOGS).add(
                ModBlocks.LEMON_LOG.get().asItem(),
                ModBlocks.STRIPPED_LEMON_LOG.get().asItem(),
                ModBlocks.LEMON_WOOD.get().asItem(),
                ModBlocks.STRIPPED_LEMON_WOOD.get().asItem()
        );

        this.tag(Tags.Items.STRING).add(
                ModItems.VEGETABLE_FIBBER.get()
        );

        this.tag(ModTags.Items.COBBLE).add(
                ModItems.COBBLE.get(),
                ModItems.LIMESTONE_COBBLE.get(),
                ModItems.DEEPSLATE_COBBLE.get(),
                ModItems.BLACKSTONE_COBBLE.get()
        );

        this.tag(ModTags.Items.TERRACOTTA_SHARD).add(
                ModItems.TERRACOTTA_SHARD.get(),
                ModItems.WHITE_TERRACOTTA_SHARD.get(),
                ModItems.ORANGE_TERRACOTTA_SHARD.get(),
                ModItems.MAGENTA_TERRACOTTA_SHARD.get(),
                ModItems.LIGHT_BLUE_TERRACOTTA_SHARD.get(),
                ModItems.YELLOW_TERRACOTTA_SHARD.get(),
                ModItems.LIME_TERRACOTTA_SHARD.get(),
                ModItems.PINK_TERRACOTTA_SHARD.get(),
                ModItems.GRAY_TERRACOTTA_SHARD.get(),
                ModItems.LIGHT_GRAY_TERRACOTTA_SHARD.get(),
                ModItems.CYAN_TERRACOTTA_SHARD.get(),
                ModItems.PURPLE_TERRACOTTA_SHARD.get(),
                ModItems.BLUE_TERRACOTTA_SHARD.get(),
                ModItems.BROWN_TERRACOTTA_SHARD.get(),
                ModItems.GREEN_TERRACOTTA_SHARD.get(),
                ModItems.RED_TERRACOTTA_SHARD.get(),
                ModItems.BLACK_TERRACOTTA_SHARD.get()
        );

        this.tag(Tags.Items.RAW_MATERIALS).add(
                ModItems.RAW_TIN.get(),
                ModItems.RAW_ZINC.get(),
                ModItems.RAW_SILVER.get(),
                ModItems.RAW_ALUMINUM.get(),
                ModItems.RAW_EMERALD.get(),
                ModItems.RAW_SAPPHIRE.get(),
                ModItems.RAW_RUBY.get(),
                ModItems.RAW_DIAMOND.get()
        );

        this.tag(ModTags.Items.BASIC_INGREDIENT).add(
                Items.RAW_COPPER,
                Blocks.COPPER_ORE.asItem(),
                ModItems.RAW_ZINC.get(),
                ModBlocks.ZINC_ORE.get().asItem(),
                ModItems.RAW_TIN.get(),
                ModBlocks.TIN_ORE.get().asItem(),
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
                ModItems.ZAPALLO.get(),
                ModItems.CORN.get(),
                ModItems.EGGPLANT.get()
        );

        this.tag(ModTags.Items.MASONRY_INGREDIENT).add(
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

        this.tag(ModTags.Items.ALLOY_INGREDIENT).add(
                Items.RAW_COPPER,
                Items.RAW_IRON,
                Items.COAL,
                ModItems.RAW_TIN.get(),
                ModItems.RAW_ZINC.get()
        );

        this.tag(ModTags.Items.BLAST_ALLOY_INGREDIENT).addTags(ModTags.Items.ALLOY_INGREDIENT).add(
                        Items.RAW_GOLD,
                        Items.COPPER_INGOT,
                        Items.IRON_INGOT,
                        Items.GOLD_INGOT,
                        ModItems.TIN_INGOT.get(),
                        ModItems.ZINC_INGOT.get(),
                        ModItems.SILVER_INGOT.get(),
                        ModItems.COBALT.get()
                );

        this.tag(ModTags.Items.PRIMAL_GRIND_INGREDIENT)
                .addTags(ItemTags.WOOL,
                        ModTags.Items.ZINC_MANUFACTURABLE,
                        ModTags.Items.TIN_MANUFACTURABLE,
                        ModTags.Items.COPPER_MANUFACTURABLE,
                        ModTags.Items.BRASS_MANUFACTURABLE,
                        ModTags.Items.BRONZE_MANUFACTURABLE
        ).add(
                ModBlocks.COBBLED_LIMESTONE.get().asItem(),
                Blocks.COBBLESTONE.asItem(),
                Blocks.COBBLED_DEEPSLATE.asItem(),
                ModBlocks.SMALL_REEDS.get().asItem(),
                ModBlocks.REEDS.get().asItem(),
                ModBlocks.TALL_REEDS.get().asItem(),
                ModItems.YERBA_MATE.get(),
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
                ModItems.ORANGE.get(),
                ModItems.LEMON.get(),
                Items.DANDELION,
                Items.BLUE_ORCHID,
                Items.CORNFLOWER,
                ModItems.LIME.get(),
                Items.ALLIUM,
                Items.PINK_TULIP,
                Items.PINK_PETALS
        );

        this.tag(ModTags.Items.MECHANICAL_GRIND_INGREDIENT)
                .addTags(ModTags.Items.PRIMAL_GRIND_INGREDIENT,
                        ModTags.Items.SILVER_MANUFACTURABLE,
                        ModTags.Items.GOLD_MANUFACTURABLE,
                        ModTags.Items.ROSE_GOLD_MANUFACTURABLE,
                        ModTags.Items.IRON_MANUFACTURABLE,
                        ModTags.Items.BRONZIUM_MANUFACTURABLE,
                        ModTags.Items.GREEN_GOLD_MANUFACTURABLE,
                        ModTags.Items.STEEL_MANUFACTURABLE,
                        ModTags.Items.BLUE_GOLD_MANUFACTURABLE
                ).add(
                Items.WITHER_ROSE,
                Items.ROSE_BUSH,
                Items.SUNFLOWER,
                Items.LAPIS_LAZULI,
                Items.PEONY
        );

        this.tag(ModTags.Items.ALUMINUM_ROD).add(
                ModItems.ALUMINUM_ROD.get()
        );

        this.tag(ModTags.Items.GOLD_MANUFACTURABLE).add(
                Items.GOLDEN_AXE, Items.GOLDEN_PICKAXE, Items.GOLDEN_SHOVEL, ModItems.GOLDEN_POLISHER.get(), Items.GOLDEN_HOE, Items.GOLDEN_SWORD,
                ModItems.GOLDEN_DAGGER.get(),ModItems.ALUMINUM_GOLDEN_AXE.get(), ModItems.ALUMINUM_GOLDEN_PICKAXE.get(),
                ModItems.ALUMINUM_GOLDEN_SWORD.get(), ModItems.ALUMINUM_GOLDEN_DAGGER.get(), ModItems.ALUMINUM_GOLDEN_SHOVEL.get(),
                ModItems.ALUMINUM_GOLDEN_HOE.get(), ModItems.ALUMINUM_GOLDEN_POLISHER.get(), Items.GOLDEN_HELMET, Items.GOLDEN_CHESTPLATE, Items.GOLDEN_LEGGINGS, Items.GOLDEN_BOOTS);

        this.tag(ModTags.Items.SILVER_MANUFACTURABLE).add(
                ModItems.SILVER_AXE.get(), ModItems.SILVER_HOE.get(), ModItems.SILVER_PICKAXE.get(),
                ModItems.SILVER_POLISHER.get(), ModItems.SILVER_SHOVEL.get(), ModItems.SILVER_SWORD.get(), ModItems.SILVER_DAGGER.get(),
                ModItems.ALUMINUM_SILVER_AXE.get(), ModItems.ALUMINUM_SILVER_PICKAXE.get(),
                ModItems.ALUMINUM_SILVER_SWORD.get(), ModItems.ALUMINUM_SILVER_DAGGER.get(), ModItems.ALUMINUM_SILVER_SHOVEL.get(),
                ModItems.ALUMINUM_SILVER_HOE.get(), ModItems.ALUMINUM_SILVER_POLISHER.get(),
                ModItems.SILVER_HELMET.get(), ModItems.SILVER_CHESTPLATE.get(), ModItems.SILVER_LEGGINGS.get(), ModItems.SILVER_BOOTS.get());

        this.tag(ModTags.Items.ALUMINUM_MANUFACTURABLE).add(ModItems.RAW_ALUMINUM.get(), ModItems.ALUMINUM_INGOT.get());

        this.tag(ModTags.Items.ZINC_MANUFACTURABLE).add(ModItems.RAW_ZINC.get(), ModItems.ZINC_INGOT.get());

        this.tag(ModTags.Items.TIN_MANUFACTURABLE).add(ModItems.RAW_TIN.get(), ModItems.TIN_INGOT.get());

        this.tag(ModTags.Items.COPPER_MANUFACTURABLE).add(Items.COPPER_INGOT, Items.RAW_COPPER);

        this.tag(ModTags.Items.BRASS_MANUFACTURABLE).add(
                ModItems.BRASS_AXE.get(), ModItems.BRASS_HOE.get(), ModItems.BRASS_PICKAXE.get(),
                ModItems.BRASS_POLISHER.get(), ModItems.BRASS_SHOVEL.get(), ModItems.BRASS_SWORD.get(), ModItems.BRASS_DAGGER.get(),
                ModItems.ALUMINUM_BRASS_AXE.get(), ModItems.ALUMINUM_BRASS_PICKAXE.get(),
                ModItems.ALUMINUM_BRASS_SWORD.get(), ModItems.ALUMINUM_BRASS_DAGGER.get(), ModItems.ALUMINUM_BRASS_SHOVEL.get(),
                ModItems.ALUMINUM_BRASS_HOE.get(), ModItems.ALUMINUM_BRASS_POLISHER.get(),
                ModItems.BRASS_HELMET.get(), ModItems.BRASS_CHESTPLATE.get(), ModItems.BRASS_LEGGINGS.get(), ModItems.BRASS_BOOTS.get());

        this.tag(ModTags.Items.BRONZE_MANUFACTURABLE).add(
                ModItems.BRONZE_AXE.get(), ModItems.BRONZE_HOE.get(), ModItems.BRONZE_PICKAXE.get(),
                ModItems.BRONZE_POLISHER.get(), ModItems.BRONZE_SHOVEL.get(), ModItems.BRONZE_SWORD.get(), ModItems.BRONZE_DAGGER.get(),
                ModItems.ALUMINUM_BRONZE_AXE.get(), ModItems.ALUMINUM_BRONZE_PICKAXE.get(),
                ModItems.ALUMINUM_BRONZE_SWORD.get(), ModItems.ALUMINUM_BRONZE_DAGGER.get(), ModItems.ALUMINUM_BRONZE_SHOVEL.get(),
                ModItems.ALUMINUM_BRONZE_HOE.get(), ModItems.ALUMINUM_BRONZE_POLISHER.get(),
                ModItems.BRONZE_HELMET.get(), ModItems.BRONZE_CHESTPLATE.get(), ModItems.BRONZE_LEGGINGS.get(), ModItems.BRONZE_BOOTS.get());

        this.tag(ModTags.Items.ROSE_GOLD_MANUFACTURABLE).add(
                ModItems.ROSE_GOLDEN_AXE.get(), ModItems.ROSE_GOLDEN_HOE.get(), ModItems.ROSE_GOLDEN_PICKAXE.get(),
                ModItems.ROSE_GOLDEN_POLISHER.get(), ModItems.ROSE_GOLDEN_SHOVEL.get(), ModItems.ROSE_GOLDEN_SWORD.get(), ModItems.ROSE_GOLDEN_DAGGER.get(),
                ModItems.ALUMINUM_ROSE_GOLDEN_AXE.get(), ModItems.ALUMINUM_ROSE_GOLDEN_PICKAXE.get(),
                ModItems.ALUMINUM_ROSE_GOLDEN_SWORD.get(), ModItems.ALUMINUM_ROSE_GOLDEN_DAGGER.get(), ModItems.ALUMINUM_ROSE_GOLDEN_SHOVEL.get(),
                ModItems.ALUMINUM_ROSE_GOLDEN_HOE.get(), ModItems.ALUMINUM_ROSE_GOLDEN_POLISHER.get(),
                ModItems.ROSE_GOLDEN_HELMET.get(), ModItems.ROSE_GOLDEN_CHESTPLATE.get(), ModItems.ROSE_GOLDEN_LEGGINGS.get(), ModItems.ROSE_GOLDEN_BOOTS.get());

        this.tag(ModTags.Items.IRON_MANUFACTURABLE).add(
                Items.IRON_AXE, Items.IRON_PICKAXE, Items.IRON_SHOVEL, ModItems.IRON_POLISHER.get(), Items.IRON_HOE, Items.IRON_SWORD,
                ModItems.IRON_DAGGER.get(),ModItems.ALUMINUM_IRON_AXE.get(), ModItems.ALUMINUM_IRON_PICKAXE.get(),
                ModItems.ALUMINUM_IRON_SWORD.get(), ModItems.ALUMINUM_IRON_DAGGER.get(), ModItems.ALUMINUM_IRON_SHOVEL.get(),
                ModItems.ALUMINUM_IRON_HOE.get(), ModItems.ALUMINUM_IRON_POLISHER.get(), Items.IRON_HELMET, Items.IRON_CHESTPLATE, Items.IRON_LEGGINGS, Items.IRON_BOOTS);

        this.tag(ModTags.Items.BRONZIUM_MANUFACTURABLE).add(
                ModItems.BRONZIUM_AXE.get(), ModItems.BRONZIUM_HOE.get(), ModItems.BRONZIUM_POLISHER.get(), ModItems.BRONZIUM_PICKAXE.get(), ModItems.BRONZIUM_SHOVEL.get(), ModItems.BRONZIUM_SWORD.get(),
                ModItems.BRONZIUM_DAGGER.get(), ModItems.BRONZIUM_HELMET.get(), ModItems.BRONZIUM_CHESTPLATE.get(), ModItems.BRONZIUM_LEGGINGS.get(), ModItems.BRONZIUM_BOOTS.get());

        this.tag(ModTags.Items.GREEN_GOLD_MANUFACTURABLE).add(
                ModItems.GREEN_GOLDEN_AXE.get(), ModItems.GREEN_GOLDEN_HOE.get(), ModItems.GREEN_GOLDEN_PICKAXE.get(),
                ModItems.GREEN_GOLDEN_POLISHER.get(), ModItems.GREEN_GOLDEN_SHOVEL.get(), ModItems.GREEN_GOLDEN_SWORD.get(), ModItems.GREEN_GOLDEN_DAGGER.get(),
                ModItems.ALUMINUM_GREEN_GOLDEN_AXE.get(), ModItems.ALUMINUM_GREEN_GOLDEN_PICKAXE.get(),
                ModItems.ALUMINUM_GREEN_GOLDEN_SWORD.get(), ModItems.ALUMINUM_GREEN_GOLDEN_DAGGER.get(), ModItems.ALUMINUM_GREEN_GOLDEN_SHOVEL.get(),
                ModItems.ALUMINUM_GREEN_GOLDEN_HOE.get(), ModItems.ALUMINUM_GREEN_GOLDEN_POLISHER.get(),
                ModItems.GREEN_GOLDEN_HELMET.get(), ModItems.GREEN_GOLDEN_CHESTPLATE.get(), ModItems.GREEN_GOLDEN_LEGGINGS.get(), ModItems.GREEN_GOLDEN_BOOTS.get());

        this.tag(ModTags.Items.STEEL_MANUFACTURABLE).add(
                ModItems.STEEL_AXE.get(), ModItems.STEEL_HOE.get(), ModItems.STEEL_POLISHER.get(),
                ModItems.STEEL_PICKAXE.get(), ModItems.STEEL_SHOVEL.get(), ModItems.STEEL_SWORD.get(), ModItems.STEEL_DAGGER.get(),
                ModItems.ALUMINUM_STEEL_AXE.get(), ModItems.ALUMINUM_STEEL_PICKAXE.get(),
                ModItems.ALUMINUM_STEEL_SWORD.get(), ModItems.ALUMINUM_STEEL_DAGGER.get(), ModItems.ALUMINUM_STEEL_SHOVEL.get(),
                ModItems.ALUMINUM_STEEL_HOE.get(), ModItems.ALUMINUM_STEEL_POLISHER.get(),
                ModItems.STEEL_HELMET.get(), ModItems.STEEL_CHESTPLATE.get(), ModItems.STEEL_LEGGINGS.get(), ModItems.STEEL_BOOTS.get());

        this.tag(ModTags.Items.BLUE_GOLD_MANUFACTURABLE).add(
                ModItems.BLUE_GOLDEN_AXE.get(), ModItems.BLUE_GOLDEN_HOE.get(), ModItems.BLUE_GOLDEN_PICKAXE.get(),
                ModItems.BLUE_GOLDEN_POLISHER.get(), ModItems.BLUE_GOLDEN_SHOVEL.get(), ModItems.BLUE_GOLDEN_SWORD.get(), ModItems.BLUE_GOLDEN_DAGGER.get(),
                ModItems.ALUMINUM_BLUE_GOLDEN_AXE.get(), ModItems.ALUMINUM_BLUE_GOLDEN_PICKAXE.get(),
                ModItems.ALUMINUM_BLUE_GOLDEN_SWORD.get(), ModItems.ALUMINUM_BLUE_GOLDEN_DAGGER.get(), ModItems.ALUMINUM_BLUE_GOLDEN_SHOVEL.get(),
                ModItems.ALUMINUM_BLUE_GOLDEN_HOE.get(), ModItems.ALUMINUM_BLUE_GOLDEN_POLISHER.get(),
                ModItems.BLUE_GOLDEN_HELMET.get(), ModItems.BLUE_GOLDEN_CHESTPLATE.get(), ModItems.BLUE_GOLDEN_LEGGINGS.get(), ModItems.BLUE_GOLDEN_BOOTS.get());

        this.tag(ModTags.Items.BAUXITE_ORE).add(
                ModBlocks.BAUXITE.get().asItem(),
                ModBlocks.WHITE_BAUXITE.get().asItem(),
                ModBlocks.LIGHT_GRAY_BAUXITE.get().asItem(),
                ModBlocks.BROWN_BAUXITE.get().asItem(),
                ModBlocks.RED_BAUXITE.get().asItem(),
                ModBlocks.ORANGE_BAUXITE.get().asItem(),
                ModBlocks.YELLOW_BAUXITE.get().asItem()
        );

        this.tag(Tags.Items.INGOTS).add(
                ModItems.SILVER_INGOT.get(),
                ModItems.ALUMINUM_INGOT.get(),
                ModItems.TIN_INGOT.get(),
                ModItems.ZINC_INGOT.get(),
                ModItems.BRONZE_INGOT.get(),
                ModItems.BRASS_INGOT.get(),
                ModItems.ROSE_GOLD_INGOT.get(),
                ModItems.BRONZIUM_INGOT.get(),
                ModItems.STEEL_INGOT.get(),
                ModItems.GREEN_GOLD_INGOT.get(),
                ModItems.BLUE_GOLD_INGOT.get()
        );

        //Specific ingots
        this.tag(ModTags.Items.SILVER_INGOT).add(ModItems.SILVER_INGOT.get());
        this.tag(ModTags.Items.ALUMINUM_INGOT).add(ModItems.ALUMINUM_INGOT.get());
        this.tag(ModTags.Items.BRASS_INGOT).add(ModItems.BRASS_INGOT.get());
        this.tag(ModTags.Items.BRONZE_INGOT).add(ModItems.BRONZE_INGOT.get());
        this.tag(ModTags.Items.ROSE_GOLD_INGOT).add(ModItems.ROSE_GOLD_INGOT.get());
        this.tag(ModTags.Items.BRONZIUM_INGOT).add(ModItems.BRONZIUM_INGOT.get());
        this.tag(ModTags.Items.GREEN_GOLD_INGOT).add(ModItems.GREEN_GOLD_INGOT.get());
        this.tag(ModTags.Items.STEEL_INGOT).add(ModItems.STEEL_INGOT.get());
        this.tag(ModTags.Items.BLUE_GOLD_INGOT).add(ModItems.BLUE_GOLD_INGOT.get());
        this.tag(ModTags.Items.TIN_INGOT).add(ModItems.TIN_INGOT.get());
        this.tag(ModTags.Items.ZINC_INGOT).add(ModItems.ZINC_INGOT.get());

        this.tag(Tags.Items.DUSTS).add(
                ModItems.GOLD_DUST.get(),
                ModItems.SILVER_DUST.get(),
                ModItems.ALUMINUM_DUST.get(),
                ModItems.ZINC_DUST.get(),
                ModItems.TIN_DUST.get(),
                ModItems.COPPER_DUST.get(),
                ModItems.BRASS_DUST.get(),
                ModItems.BRONZE_DUST.get(),
                ModItems.ROSE_GOLD_DUST.get(),
                ModItems.IRON_DUST.get(),
                ModItems.BRONZIUM_DUST.get(),
                ModItems.GREEN_GOLD_DUST.get(),
                ModItems.STEEL_DUST.get(),
                ModItems.BLUE_GOLD_DUST.get()
        );

        this.tag(Tags.Items.NUGGETS).add(
                ModItems.SILVER_NUGGET.get(),
                ModItems.ALUMINUM_NUGGET.get(),
                ModItems.COPPER_NUGGET.get(),
                ModItems.TIN_NUGGET.get(),
                ModItems.ZINC_NUGGET.get(),
                ModItems.BRONZE_NUGGET.get(),
                ModItems.BRASS_NUGGET.get(),
                ModItems.ROSE_GOLD_NUGGET.get(),
                ModItems.BRONZIUM_NUGGET.get(),
                ModItems.STEEL_NUGGET.get(),
                ModItems.GREEN_GOLD_NUGGET.get(),
                ModItems.BLUE_GOLD_NUGGET.get()
        );

        this.tag(ItemTags.STONE_CRAFTING_MATERIALS).add(
                ModBlocks.COBBLED_LIMESTONE.get().asItem()
        );

        this.tag(ModTags.Items.GOLD).add(
                Items.GOLDEN_AXE, Items.GOLDEN_PICKAXE, Items.GOLDEN_SHOVEL, Items.GOLDEN_SWORD, ModItems.GOLDEN_DAGGER.get(),
                ModItems.GOLDEN_POLISHER.get(), Items.GOLDEN_HOE, Items.GOLDEN_HELMET, Items.GOLDEN_CHESTPLATE, Items.GOLDEN_LEGGINGS,
                Items.GOLDEN_BOOTS
        );

        this.tag(ModTags.Items.BRONZE).add(
                ModItems.BRONZE_INGOT.get(), ModItems.BRONZE_NUGGET.get(), ModBlocks.BRONZE_BLOCK.get().asItem(),
                ModItems.BRONZE_SWORD.get(), ModItems.BRONZE_DAGGER.get(),
                ModItems.BRONZE_PICKAXE.get(), ModItems.BRONZE_AXE.get(), ModItems.BRONZE_SHOVEL.get(), ModItems.BRONZE_HOE.get(),
                ModItems.BRONZE_POLISHER.get(),
                ModItems.BRONZE_HELMET.get(), ModItems.BRONZE_CHESTPLATE.get(), ModItems.BRONZE_LEGGINGS.get(), ModItems.BRONZE_BOOTS.get()
        );

        this.tag(ModTags.Items.BRASS).add(
                ModItems.BRASS_INGOT.get(), ModItems.BRASS_NUGGET.get(), ModBlocks.BRASS_BLOCK.get().asItem(),
                ModItems.BRASS_SWORD.get(), ModItems.BRASS_DAGGER.get(),
                ModItems.BRASS_PICKAXE.get(), ModItems.BRASS_AXE.get(), ModItems.BRASS_SHOVEL.get(), ModItems.BRASS_HOE.get(),
                ModItems.BRASS_POLISHER.get(),
                ModItems.BRASS_HELMET.get(), ModItems.BRASS_CHESTPLATE.get(), ModItems.BRASS_LEGGINGS.get(), ModItems.BRASS_BOOTS.get()
        );

        this.tag(ModTags.Items.ROSE_GOLD).add(
                ModItems.ROSE_GOLD_INGOT.get(), ModItems.ROSE_GOLD_NUGGET.get(), ModBlocks.ROSE_GOLD_BLOCK.get().asItem(),
                ModItems.ROSE_GOLDEN_SWORD.get(), ModItems.ROSE_GOLDEN_DAGGER.get(),
                ModItems.ROSE_GOLDEN_PICKAXE.get(), ModItems.ROSE_GOLDEN_AXE.get(), ModItems.ROSE_GOLDEN_SHOVEL.get(), ModItems.ROSE_GOLDEN_HOE.get(),
                ModItems.ROSE_GOLDEN_POLISHER.get(),
                ModItems.ROSE_GOLDEN_HELMET.get(), ModItems.ROSE_GOLDEN_CHESTPLATE.get(), ModItems.ROSE_GOLDEN_LEGGINGS.get(), ModItems.ROSE_GOLDEN_BOOTS.get()
        );

        this.tag(ModTags.Items.IRON).add(
                Items.IRON_AXE, Items.IRON_PICKAXE, Items.IRON_SHOVEL, Items.IRON_SWORD, ModItems.IRON_DAGGER.get(), ModItems.IRON_POLISHER.get(),
                Items.IRON_HOE, Items.IRON_HELMET, Items.IRON_CHESTPLATE, Items.IRON_LEGGINGS, Items.IRON_BOOTS
        );

        this.tag(ModTags.Items.BRONZIUM).add(
                ModItems.BRONZIUM_INGOT.get(), ModItems.BRONZIUM_NUGGET.get(), ModBlocks.BRONZIUM_BLOCK.get().asItem(),
                ModItems.BRONZIUM_SWORD.get(), ModItems.BRONZIUM_DAGGER.get(), ModItems.BRONZIUM_PICKAXE.get(),
                ModItems.BRONZIUM_AXE.get(), ModItems.BRONZIUM_SHOVEL.get(), ModItems.BRONZIUM_HOE.get(), ModItems.BRONZIUM_POLISHER.get(),
                ModItems.BRONZIUM_HELMET.get(), ModItems.BRONZIUM_CHESTPLATE.get(), ModItems.BRONZIUM_LEGGINGS.get(), ModItems.BRONZIUM_BOOTS.get()
        );

        this.tag(ModTags.Items.STEEL).add(
                ModItems.STEEL_INGOT.get(), ModItems.STEEL_NUGGET.get(), ModBlocks.STEEL_BLOCK.get().asItem(),
                ModItems.STEEL_SWORD.get(), ModItems.STEEL_DAGGER.get(), ModItems.STEEL_PICKAXE.get(),
                ModItems.STEEL_AXE.get(), ModItems.STEEL_SHOVEL.get(), ModItems.STEEL_HOE.get(), ModItems.STEEL_POLISHER.get(),
                ModItems.STEEL_HELMET.get(), ModItems.STEEL_CHESTPLATE.get(), ModItems.STEEL_LEGGINGS.get(), ModItems.STEEL_BOOTS.get()
                );

        this.tag(ModTags.Items.GREEN_GOLD).add(
                ModItems.GREEN_GOLD_INGOT.get(), ModItems.GREEN_GOLD_NUGGET.get(), ModBlocks.GREEN_GOLD_BLOCK.get().asItem(),
                ModItems.GREEN_GOLDEN_SWORD.get(), ModItems.GREEN_GOLDEN_DAGGER.get(), ModItems.GREEN_GOLDEN_PICKAXE.get(),
                ModItems.GREEN_GOLDEN_AXE.get(), ModItems.GREEN_GOLDEN_SHOVEL.get(), ModItems.GREEN_GOLDEN_HOE.get(), ModItems.GREEN_GOLDEN_POLISHER.get(),
                ModItems.GREEN_GOLDEN_HELMET.get(), ModItems.GREEN_GOLDEN_CHESTPLATE.get(), ModItems.GREEN_GOLDEN_LEGGINGS.get(), ModItems.GREEN_GOLDEN_BOOTS.get()
        );

        this.tag(ModTags.Items.BLUE_GOLD).add(
                ModItems.BLUE_GOLD_INGOT.get(), ModItems.BLUE_GOLD_NUGGET.get(), ModBlocks.BLUE_GOLD_BLOCK.get().asItem(),
                ModItems.BLUE_GOLDEN_SWORD.get(), ModItems.BLUE_GOLDEN_DAGGER.get(), ModItems.BLUE_GOLDEN_PICKAXE.get(),
                ModItems.BLUE_GOLDEN_AXE.get(), ModItems.BLUE_GOLDEN_SHOVEL.get(), ModItems.BLUE_GOLDEN_HOE.get(), ModItems.BLUE_GOLDEN_POLISHER.get(),
                ModItems.BLUE_GOLDEN_HELMET.get(), ModItems.BLUE_GOLDEN_CHESTPLATE.get(), ModItems.BLUE_GOLDEN_LEGGINGS.get(), ModItems.BLUE_GOLDEN_BOOTS.get()
        );

        this.tag(ModTags.Items.SILVER).add(
                ModItems.SILVER_INGOT.get(), ModItems.SILVER_NUGGET.get(), ModBlocks.SILVER_BLOCK.get().asItem(),
                ModItems.SILVER_SWORD.get(), ModItems.SILVER_DAGGER.get(),
                ModItems.SILVER_PICKAXE.get(), ModItems.SILVER_AXE.get(), ModItems.SILVER_SHOVEL.get(), ModItems.SILVER_HOE.get(),
                ModItems.SILVER_POLISHER.get(),
                ModItems.SILVER_HELMET.get(), ModItems.SILVER_CHESTPLATE.get(), ModItems.SILVER_LEGGINGS.get(), ModItems.SILVER_BOOTS.get()
                );

        this.tag(ModTags.Items.ALUMINUM).add(ModItems.ALUMINUM_INGOT.get(), ModItems.ALUMINUM_NUGGET.get(), ModItems.ALUMINUM_ROD.get());

        this.tag(ItemTags.TRIMMABLE_ARMOR).add(
                ModItems.SILVER_HELMET.get(), ModItems.SILVER_CHESTPLATE.get(), ModItems.SILVER_LEGGINGS.get(), ModItems.SILVER_BOOTS.get(),
                ModItems.BRONZE_HELMET.get(), ModItems.BRONZE_CHESTPLATE.get(), ModItems.BRONZE_LEGGINGS.get(), ModItems.BRONZE_BOOTS.get(),
                ModItems.BRASS_HELMET.get(), ModItems.BRASS_CHESTPLATE.get(), ModItems.BRASS_LEGGINGS.get(), ModItems.BRASS_BOOTS.get(),
                ModItems.ROSE_GOLDEN_HELMET.get(), ModItems.ROSE_GOLDEN_CHESTPLATE.get(), ModItems.ROSE_GOLDEN_LEGGINGS.get(), ModItems.ROSE_GOLDEN_BOOTS.get(),
                ModItems.BRONZIUM_HELMET.get(), ModItems.BRONZIUM_CHESTPLATE.get(), ModItems.BRONZIUM_LEGGINGS.get(), ModItems.BRONZIUM_BOOTS.get(),
                ModItems.GREEN_GOLDEN_HELMET.get(), ModItems.GREEN_GOLDEN_CHESTPLATE.get(), ModItems.GREEN_GOLDEN_LEGGINGS.get(), ModItems.GREEN_GOLDEN_BOOTS.get(),
                ModItems.STEEL_HELMET.get(), ModItems.STEEL_CHESTPLATE.get(), ModItems.STEEL_LEGGINGS.get(), ModItems.STEEL_BOOTS.get(),
                ModItems.BLUE_GOLDEN_HELMET.get(), ModItems.BLUE_GOLDEN_CHESTPLATE.get(), ModItems.BLUE_GOLDEN_LEGGINGS.get(), ModItems.BLUE_GOLDEN_BOOTS.get()
                );

        this.tag(ModTags.Items.RAW_GEM).add(
                ModItems.RAW_RUBY.get(),
                ModItems.RAW_SAPPHIRE.get(),
                ModItems.RAW_GARNET.get(),
                ModItems.RAW_EMERALD.get(),
                ModItems.RAW_DIAMOND.get()
                );

        this.tag(ModTags.Items.POLISHER).add(
                ModItems.SILVER_POLISHER.get(),
                ModItems.GOLDEN_POLISHER.get(),
                ModItems.STONE_POLISHER.get(),
                ModItems.BRASS_POLISHER.get(),
                ModItems.BRONZE_POLISHER.get(),
                ModItems.ROSE_GOLDEN_POLISHER.get(),
                ModItems.BRONZIUM_POLISHER.get(),
                ModItems.GREEN_GOLDEN_POLISHER.get(),
                ModItems.IRON_POLISHER.get(),
                ModItems.STEEL_POLISHER.get(),
                ModItems.BLUE_GOLDEN_POLISHER.get(),
                ModItems.DIAMOND_POLISHER.get(),
                ModItems.NETHERITE_POLISHER.get(),
                //Aluminum
                ModItems.ALUMINUM_STONE_POLISHER.get(),
                ModItems.ALUMINUM_GOLDEN_POLISHER.get(),
                ModItems.ALUMINUM_SILVER_POLISHER.get(),
                ModItems.ALUMINUM_BRONZE_POLISHER.get(),
                ModItems.ALUMINUM_BRASS_POLISHER.get(),
                ModItems.ALUMINUM_ROSE_GOLDEN_POLISHER.get(),
                ModItems.ALUMINUM_BRONZIUM_POLISHER.get(),
                ModItems.ALUMINUM_IRON_POLISHER.get(),
                ModItems.ALUMINUM_STEEL_POLISHER.get(),
                ModItems.ALUMINUM_GREEN_GOLDEN_POLISHER.get(),
                ModItems.ALUMINUM_BLUE_GOLDEN_POLISHER.get(),
                ModItems.ALUMINUM_DIAMOND_POLISHER.get()
        );

        this.tag(ModTags.Items.DAGGER).add(
                ModItems.SILVER_DAGGER.get(),
                ModItems.GOLDEN_DAGGER.get(),
                ModItems.WOODEN_DAGGER.get(),
                ModItems.STONE_DAGGER.get(),
                ModItems.BRASS_DAGGER.get(),
                ModItems.BRONZE_DAGGER.get(),
                ModItems.ROSE_GOLDEN_DAGGER.get(),
                ModItems.BRONZIUM_DAGGER.get(),
                ModItems.GREEN_GOLDEN_DAGGER.get(),
                ModItems.IRON_DAGGER.get(),
                ModItems.STEEL_DAGGER.get(),
                ModItems.BLUE_GOLDEN_DAGGER.get(),
                ModItems.DIAMOND_DAGGER.get(),
                ModItems.NETHERITE_DAGGER.get(),
                //Aluminum
                ModItems.ALUMINUM_WOODEN_DAGGER.get(),
                ModItems.ALUMINUM_STONE_DAGGER.get(),
                ModItems.ALUMINUM_GOLDEN_DAGGER.get(),
                ModItems.ALUMINUM_SILVER_DAGGER.get(),
                ModItems.ALUMINUM_BRONZE_DAGGER.get(),
                ModItems.ALUMINUM_BRASS_DAGGER.get(),
                ModItems.ALUMINUM_ROSE_GOLDEN_DAGGER.get(),
                ModItems.ALUMINUM_BRONZIUM_DAGGER.get(),
                ModItems.ALUMINUM_IRON_DAGGER.get(),
                ModItems.ALUMINUM_STEEL_DAGGER.get(),
                ModItems.ALUMINUM_GREEN_GOLDEN_DAGGER.get(),
                ModItems.ALUMINUM_BLUE_GOLDEN_DAGGER.get(),
                ModItems.ALUMINUM_DIAMOND_DAGGER.get()
        );

        this.tag(ItemTags.BEACON_PAYMENT_ITEMS).add(
                ModItems.RUBY.get(),
                ModItems.SAPPHIRE.get(),
                ModItems.GARNET.get(),
                ModItems.SILVER_INGOT.get(),
                ModItems.ALUMINUM_INGOT.get(),
                ModItems.TIN_INGOT.get(),
                ModItems.ZINC_INGOT.get(),
                ModItems.BRASS_INGOT.get(),
                ModItems.BRONZE_INGOT.get(),
                ModItems.ROSE_GOLD_INGOT.get(),
                ModItems.BRONZIUM_INGOT.get(),
                ModItems.STEEL_INGOT.get(),
                ModItems.GREEN_GOLD_INGOT.get(),
                ModItems.BLUE_GOLD_INGOT.get()
        );

        this.tag(ItemTags.PIGLIN_LOVED).add(
                ModItems.ROSE_GOLD_INGOT.get(),
                ModItems.GREEN_GOLD_INGOT.get(),
                ModItems.BLUE_GOLD_INGOT.get()
        );
    }

}
