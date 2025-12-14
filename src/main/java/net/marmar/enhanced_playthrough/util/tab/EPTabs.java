package net.marmar.enhanced_playthrough.util.tab;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.block.EPBlocks;
import net.marmar.enhanced_playthrough.item.EPItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class EPTabs {
    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, EnhancedPlaythrough.MOD_ID);

    public static final RegistryObject<CreativeModeTab> UTILITY_BLOCKS = TABS.register(
            "utility_blocks", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(EPBlocks.ADOBE_ALLOY_FURNACE.get()))
                    .title(Component.translatable("creativetab." + EnhancedPlaythrough.MOD_ID + ".utility_blocks"))
                    .withTabsAfter(EPTabs.UTILITY.getId())
                    .displayItems(((itemDisplayParameters, output) -> {
                        output.accept(EPBlocks.ADOBE_FURNACE.get());
                        output.accept(EPBlocks.SOUL_FURNACE.get());

                        output.accept(EPBlocks.MASONRY_FURNACE.get());

                        output.accept(EPBlocks.ADOBE_ALLOY_FURNACE.get());
                        output.accept(EPBlocks.SUPER_ALLOY_FURNACE.get());
                        output.accept(EPBlocks.SOUL_ALLOY_FURNACE.get());

                        output.accept(EPBlocks.GEM_POLISHER.get());

                        output.accept(EPBlocks.PRIMAL_GRINDER.get());
                        output.accept(EPBlocks.MECHANICAL_GRINDER.get());

                        output.accept(EPBlocks.GROWTH_DETECTOR.get());

                        output.accept(EPItems.WALNUT_SIGN.get());
                        output.accept(EPItems.WALNUT_HANGING_SIGN.get());

                        output.accept(EPItems.APPLE_SIGN.get());
                        output.accept(EPItems.APPLE_HANGING_SIGN.get());

                        output.accept(EPItems.ORANGE_SIGN.get());
                        output.accept(EPItems.ORANGE_HANGING_SIGN.get());

                        output.accept(EPItems.LEMON_SIGN.get());
                        output.accept(EPItems.LEMON_HANGING_SIGN.get());
                    }))
                    .build());

    public static final RegistryObject<CreativeModeTab> UTILITY = TABS.register(
            "utility", () -> CreativeModeTab.builder().icon(() -> new ItemStack(EPItems.BRONZE_INGOT.get()))
                    .title(Component.translatable("creativetab." + EnhancedPlaythrough.MOD_ID + ".utility"))
                    .withTabsAfter(EPTabs.TOOLS.getId())
                    .withTabsBefore(EPTabs.UTILITY_BLOCKS.getId())
                    .displayItems((itemDisplayParameters, output) -> {
                        //Cobble
                        output.accept(EPItems.COBBLE.get());
                        output.accept(EPItems.LIMESTONE_COBBLE.get());
                        output.accept(EPItems.DEEPSLATE_COBBLE.get());
                        output.accept(EPItems.NETHERRACK_RUBBLE.get());
                        output.accept(EPItems.BLACKSTONE_COBBLE.get());

                        //Terracotta shards
                        output.accept(EPItems.WHITE_TERRACOTTA_SHARD.get());
                        output.accept(EPItems.ORANGE_TERRACOTTA_SHARD.get());
                        output.accept(EPItems.MAGENTA_TERRACOTTA_SHARD.get());
                        output.accept(EPItems.LIGHT_BLUE_TERRACOTTA_SHARD.get());
                        output.accept(EPItems.YELLOW_TERRACOTTA_SHARD.get());
                        output.accept(EPItems.LIME_TERRACOTTA_SHARD.get());
                        output.accept(EPItems.PINK_TERRACOTTA_SHARD.get());
                        output.accept(EPItems.GRAY_TERRACOTTA_SHARD.get());
                        output.accept(EPItems.LIGHT_GRAY_TERRACOTTA_SHARD.get());
                        output.accept(EPItems.CYAN_TERRACOTTA_SHARD.get());
                        output.accept(EPItems.PURPLE_TERRACOTTA_SHARD.get());
                        output.accept(EPItems.BLUE_TERRACOTTA_SHARD.get());
                        output.accept(EPItems.BROWN_TERRACOTTA_SHARD.get());
                        output.accept(EPItems.GREEN_TERRACOTTA_SHARD.get());
                        output.accept(EPItems.RED_TERRACOTTA_SHARD.get());
                        output.accept(EPItems.BLACK_TERRACOTTA_SHARD.get());
                        output.accept(EPItems.TERRACOTTA_SHARD.get());

                        //Misc
                        output.accept(EPItems.REEDS_HEAD.get());
                        output.accept(EPItems.TALL_REEDS_HEAD.get());
                        output.accept(EPItems.WATER_REEDS_HEAD.get());
                        output.accept(EPItems.PLANT_FIBER.get());
                        output.accept(EPItems.MUD_BRICK.get());
                        output.accept(EPItems.FIREBRICK.get());
                        output.accept(EPItems.ALUMINUM_ROD.get());
                        output.accept(EPItems.BRONZIUM_UPGRADE_SMITHING_TEMPLATE.get());
                        output.accept(EPItems.ALUMINUM_UPGRADE_SMITHING_TEMPLATE.get());
                        output.accept(EPItems.GOLDEN_UPGRADE_SMITHING_TEMPLATE.get());

                        //Raw
                        output.accept(EPItems.RAW_SILVER.get());

                        output.accept(EPItems.RAW_ALUMINUM.get());

                        output.accept(EPItems.RAW_ZINC.get());

                        output.accept(EPItems.RAW_TIN.get());

                        output.accept(EPItems.SULFUR.get());

                        //Melted
                        output.accept(EPItems.SILVER_INGOT.get());
                        output.accept(EPItems.SILVER_DUST.get());
                        output.accept(EPItems.SILVER_NUGGET.get());

                        output.accept(EPItems.ALUMINUM_INGOT.get());
                        output.accept(EPItems.ALUMINUM_DUST.get());
                        output.accept(EPItems.ALUMINUM_NUGGET.get());

                        output.accept(Items.COPPER_INGOT);
                        output.accept(EPItems.COPPER_DUST.get());
                        output.accept((EPItems.COPPER_NUGGET.get()));

                        output.accept(EPItems.ZINC_INGOT.get());
                        output.accept(EPItems.ZINC_DUST.get());
                        output.accept(EPItems.ZINC_NUGGET.get());

                        output.accept((EPItems.TIN_INGOT.get()));
                        output.accept(EPItems.TIN_DUST.get());
                        output.accept((EPItems.TIN_NUGGET.get()));

                        output.accept(EPItems.BRASS_INGOT.get());
                        output.accept(EPItems.BRASS_DUST.get());
                        output.accept(EPItems.BRASS_NUGGET.get());

                        output.accept(EPItems.BRONZE_INGOT.get());
                        output.accept(EPItems.BRONZE_DUST.get());
                        output.accept(EPItems.BRONZE_NUGGET.get());

                        output.accept(EPItems.ROSE_GOLD_INGOT.get());
                        output.accept(EPItems.ROSE_GOLD_DUST.get());
                        output.accept(EPItems.ROSE_GOLD_NUGGET.get());

                        output.accept(Items.IRON_INGOT);
                        output.accept(EPItems.IRON_DUST.get());
                        output.accept(Items.IRON_NUGGET);

                        output.accept(EPItems.BRONZIUM_INGOT.get());
                        output.accept(EPItems.BRONZIUM_DUST.get());
                        output.accept(EPItems.BRONZIUM_NUGGET.get());

                        output.accept(EPItems.GREEN_GOLD_INGOT.get());
                        output.accept(EPItems.GREEN_GOLD_DUST.get());
                        output.accept(EPItems.GREEN_GOLD_NUGGET.get());

                        output.accept(EPItems.STEEL_INGOT.get());
                        output.accept(EPItems.STEEL_DUST.get());
                        output.accept(EPItems.STEEL_NUGGET.get());

                        output.accept(EPItems.BLUE_GOLD_INGOT.get());
                        output.accept(EPItems.BLUE_GOLD_DUST.get());
                        output.accept(EPItems.BLUE_GOLD_NUGGET.get());

                        output.accept(EPItems.CALIBRATED_QUARTZ.get());
                    }).build());

    public static final RegistryObject<CreativeModeTab> TOOLS = TABS.register(
            "tools", () -> CreativeModeTab.builder().icon(() -> new ItemStack(EPItems.STEEL_PICKAXE.get()))
                    .title((Component.translatable("creativetab." + EnhancedPlaythrough.MOD_ID + ".tools")))
                    .withTabsAfter(EPTabs.ALUMINUM_TOOLS.getId())
                    .withTabsBefore(EPTabs.UTILITY.getId())
                    .displayItems((itemDisplayParameters, output) -> {
                        //Silver
                        output.accept(EPItems.SILVER_PICKAXE.get());
                        output.accept(EPItems.SILVER_AXE.get());
                        output.accept(EPItems.SILVER_SHOVEL.get());
                        output.accept(EPItems.SILVER_HOE.get());
                        output.accept(EPItems.SILVER_POLISHER.get());
                        output.accept(EPItems.SILVER_POLISHER.get());

                        //Bronze
                        output.accept(EPItems.BRONZE_PICKAXE.get());
                        output.accept(EPItems.BRONZE_AXE.get());
                        output.accept(EPItems.BRONZE_SHOVEL.get());
                        output.accept(EPItems.BRONZE_HOE.get());
                        output.accept(EPItems.BRONZE_POLISHER.get());

                        //Brass
                        output.accept(EPItems.BRASS_PICKAXE.get());
                        output.accept(EPItems.BRASS_AXE.get());
                        output.accept(EPItems.BRASS_SHOVEL.get());
                        output.accept(EPItems.BRASS_HOE.get());
                        output.accept(EPItems.BRASS_POLISHER.get());

                        //Rose Gold
                        output.accept(EPItems.ROSE_GOLDEN_PICKAXE.get());
                        output.accept(EPItems.ROSE_GOLDEN_AXE.get());
                        output.accept(EPItems.ROSE_GOLDEN_SHOVEL.get());
                        output.accept(EPItems.ROSE_GOLDEN_HOE.get());
                        output.accept(EPItems.ROSE_GOLDEN_POLISHER.get());

                        //Bronzium
                        output.accept(EPItems.BRONZIUM_PICKAXE.get());
                        output.accept(EPItems.BRONZIUM_AXE.get());
                        output.accept(EPItems.BRONZIUM_SHOVEL.get());
                        output.accept(EPItems.BRONZIUM_HOE.get());
                        output.accept(EPItems.BRONZIUM_POLISHER.get());

                        //Green Gold
                        output.accept(EPItems.GREEN_GOLDEN_PICKAXE.get());
                        output.accept(EPItems.GREEN_GOLDEN_AXE.get());
                        output.accept(EPItems.GREEN_GOLDEN_SHOVEL.get());
                        output.accept(EPItems.GREEN_GOLDEN_HOE.get());
                        output.accept(EPItems.GREEN_GOLDEN_POLISHER.get());

                        //Steel
                        output.accept(EPItems.STEEL_PICKAXE.get());
                        output.accept(EPItems.STEEL_AXE.get());
                        output.accept(EPItems.STEEL_SHOVEL.get());
                        output.accept(EPItems.STEEL_HOE.get());
                        output.accept(EPItems.STEEL_POLISHER.get());
                        output.accept(EPItems.STEEL_POLISHER.get());

                        //Blue Gold
                        output.accept(EPItems.BLUE_GOLDEN_PICKAXE.get());
                        output.accept(EPItems.BLUE_GOLDEN_AXE.get());
                        output.accept(EPItems.BLUE_GOLDEN_SHOVEL.get());
                        output.accept(EPItems.BLUE_GOLDEN_HOE.get());
                        output.accept(EPItems.BLUE_GOLDEN_POLISHER.get());

                        //Boats
                        output.accept(EPItems.WALNUT_BOAT.get());
                        output.accept(EPItems.WALNUT_CHEST_BOAT.get());

                        output.accept(EPItems.APPLE_BOAT.get());
                        output.accept(EPItems.APPLE_CHEST_BOAT.get());

                        output.accept(EPItems.ORANGE_BOAT.get());
                        output.accept(EPItems.ORANGE_CHEST_BOAT.get());

                        output.accept(EPItems.LEMON_BOAT.get());
                        output.accept(EPItems.LEMON_CHEST_BOAT.get());
                    }).build());

    public static final RegistryObject<CreativeModeTab> ALUMINUM_TOOLS = TABS.register(
            "aluminum_tools", () -> CreativeModeTab.builder().icon(() -> new ItemStack(EPItems.ALUMINUM_STEEL_PICKAXE.get()))
                    .title((Component.translatable("creativetab." + EnhancedPlaythrough.MOD_ID + ".aluminum_tools")))
                    .withTabsAfter(EPTabs.WEAPONS.getId())
                    .withTabsBefore(EPTabs.TOOLS.getId())
                    .displayItems((itemDisplayParameters, output) -> {
                        //Aluminum Wooden
                        output.accept(EPItems.ALUMINUM_WOODEN_PICKAXE.get());
                        output.accept(EPItems.ALUMINUM_WOODEN_AXE.get());
                        output.accept(EPItems.ALUMINUM_WOODEN_SHOVEL.get());
                        output.accept(EPItems.ALUMINUM_WOODEN_HOE.get());
                        output.accept(EPItems.ALUMINUM_WOODEN_SWORD.get());
                        output.accept(EPItems.ALUMINUM_WOODEN_DAGGER.get());

                        //Aluminum Stone
                        output.accept(EPItems.ALUMINUM_STONE_PICKAXE.get());
                        output.accept(EPItems.ALUMINUM_STONE_AXE.get());
                        output.accept(EPItems.ALUMINUM_STONE_SHOVEL.get());
                        output.accept(EPItems.ALUMINUM_STONE_HOE.get());
                        output.accept(EPItems.ALUMINUM_STONE_POLISHER.get());
                        output.accept(EPItems.ALUMINUM_STONE_SWORD.get());
                        output.accept(EPItems.ALUMINUM_STONE_DAGGER.get());

                        //Aluminum Golden
                        output.accept(EPItems.ALUMINUM_GOLDEN_PICKAXE.get());
                        output.accept(EPItems.ALUMINUM_GOLDEN_AXE.get());
                        output.accept(EPItems.ALUMINUM_GOLDEN_SHOVEL.get());
                        output.accept(EPItems.ALUMINUM_GOLDEN_HOE.get());
                        output.accept(EPItems.ALUMINUM_GOLDEN_POLISHER.get());
                        output.accept(EPItems.ALUMINUM_GOLDEN_SWORD.get());
                        output.accept(EPItems.ALUMINUM_GOLDEN_DAGGER.get());

                        //Aluminum Silver
                        output.accept(EPItems.ALUMINUM_SILVER_PICKAXE.get());
                        output.accept(EPItems.ALUMINUM_SILVER_AXE.get());
                        output.accept(EPItems.ALUMINUM_SILVER_SHOVEL.get());
                        output.accept(EPItems.ALUMINUM_SILVER_HOE.get());
                        output.accept(EPItems.ALUMINUM_SILVER_POLISHER.get());
                        output.accept(EPItems.ALUMINUM_SILVER_SWORD.get());
                        output.accept(EPItems.ALUMINUM_SILVER_DAGGER.get());

                        //Aluminum Bronze
                        output.accept(EPItems.ALUMINUM_BRONZE_PICKAXE.get());
                        output.accept(EPItems.ALUMINUM_BRONZE_AXE.get());
                        output.accept(EPItems.ALUMINUM_BRONZE_SHOVEL.get());
                        output.accept(EPItems.ALUMINUM_BRONZE_HOE.get());
                        output.accept(EPItems.ALUMINUM_BRONZE_POLISHER.get());
                        output.accept(EPItems.ALUMINUM_BRONZE_SWORD.get());
                        output.accept(EPItems.ALUMINUM_BRONZE_DAGGER.get());

                        //Aluminum Brass
                        output.accept(EPItems.ALUMINUM_BRASS_PICKAXE.get());
                        output.accept(EPItems.ALUMINUM_BRASS_AXE.get());
                        output.accept(EPItems.ALUMINUM_BRASS_SHOVEL.get());
                        output.accept(EPItems.ALUMINUM_BRASS_HOE.get());
                        output.accept(EPItems.ALUMINUM_BRASS_POLISHER.get());
                        output.accept(EPItems.ALUMINUM_BRASS_SWORD.get());
                        output.accept(EPItems.ALUMINUM_BRASS_DAGGER.get());

                        //Aluminum Rose Gold
                        output.accept(EPItems.ALUMINUM_ROSE_GOLDEN_PICKAXE.get());
                        output.accept(EPItems.ALUMINUM_ROSE_GOLDEN_AXE.get());
                        output.accept(EPItems.ALUMINUM_ROSE_GOLDEN_SHOVEL.get());
                        output.accept(EPItems.ALUMINUM_ROSE_GOLDEN_HOE.get());
                        output.accept(EPItems.ALUMINUM_ROSE_GOLDEN_POLISHER.get());
                        output.accept(EPItems.ALUMINUM_ROSE_GOLDEN_SWORD.get());
                        output.accept(EPItems.ALUMINUM_ROSE_GOLDEN_DAGGER.get());

                        //Aluminum Iron
                        output.accept(EPItems.ALUMINUM_IRON_PICKAXE.get());
                        output.accept(EPItems.ALUMINUM_IRON_AXE.get());
                        output.accept(EPItems.ALUMINUM_IRON_SHOVEL.get());
                        output.accept(EPItems.ALUMINUM_IRON_HOE.get());
                        output.accept(EPItems.ALUMINUM_IRON_POLISHER.get());
                        output.accept(EPItems.ALUMINUM_IRON_SWORD.get());
                        output.accept(EPItems.ALUMINUM_IRON_DAGGER.get());

                        //Aluminum Bronzium
                        output.accept(EPItems.ALUMINUM_BRONZIUM_PICKAXE.get());
                        output.accept(EPItems.ALUMINUM_BRONZIUM_AXE.get());
                        output.accept(EPItems.ALUMINUM_BRONZIUM_SHOVEL.get());
                        output.accept(EPItems.ALUMINUM_BRONZIUM_HOE.get());
                        output.accept(EPItems.ALUMINUM_BRONZIUM_POLISHER.get());
                        output.accept(EPItems.ALUMINUM_BRONZIUM_SWORD.get());
                        output.accept(EPItems.ALUMINUM_BRONZIUM_DAGGER.get());

                        //Aluminum Green Gold
                        output.accept(EPItems.ALUMINUM_GREEN_GOLDEN_PICKAXE.get());
                        output.accept(EPItems.ALUMINUM_GREEN_GOLDEN_AXE.get());
                        output.accept(EPItems.ALUMINUM_GREEN_GOLDEN_SHOVEL.get());
                        output.accept(EPItems.ALUMINUM_GREEN_GOLDEN_HOE.get());
                        output.accept(EPItems.ALUMINUM_GREEN_GOLDEN_POLISHER.get());
                        output.accept(EPItems.ALUMINUM_GREEN_GOLDEN_SWORD.get());
                        output.accept(EPItems.ALUMINUM_GREEN_GOLDEN_DAGGER.get());

                        //Aluminum Steel
                        output.accept(EPItems.ALUMINUM_STEEL_PICKAXE.get());
                        output.accept(EPItems.ALUMINUM_STEEL_AXE.get());
                        output.accept(EPItems.ALUMINUM_STEEL_SHOVEL.get());
                        output.accept(EPItems.ALUMINUM_STEEL_HOE.get());
                        output.accept(EPItems.ALUMINUM_STEEL_POLISHER.get());
                        output.accept(EPItems.ALUMINUM_STEEL_SWORD.get());
                        output.accept(EPItems.ALUMINUM_STEEL_DAGGER.get());

                        //Aluminum Blue Gold
                        output.accept(EPItems.ALUMINUM_BLUE_GOLDEN_PICKAXE.get());
                        output.accept(EPItems.ALUMINUM_BLUE_GOLDEN_AXE.get());
                        output.accept(EPItems.ALUMINUM_BLUE_GOLDEN_SHOVEL.get());
                        output.accept(EPItems.ALUMINUM_BLUE_GOLDEN_HOE.get());
                        output.accept(EPItems.ALUMINUM_BLUE_GOLDEN_POLISHER.get());
                        output.accept(EPItems.ALUMINUM_BLUE_GOLDEN_SWORD.get());
                        output.accept(EPItems.ALUMINUM_BLUE_GOLDEN_DAGGER.get());

                        //Aluminum Diamond
                        output.accept(EPItems.ALUMINUM_DIAMOND_PICKAXE.get());
                        output.accept(EPItems.ALUMINUM_DIAMOND_AXE.get());
                        output.accept(EPItems.ALUMINUM_DIAMOND_SHOVEL.get());
                        output.accept(EPItems.ALUMINUM_DIAMOND_HOE.get());
                        output.accept(EPItems.ALUMINUM_DIAMOND_POLISHER.get());
                        output.accept(EPItems.ALUMINUM_DIAMOND_SWORD.get());
                        output.accept(EPItems.ALUMINUM_DIAMOND_DAGGER.get());
                    }).build());

    public static final RegistryObject<CreativeModeTab> WEAPONS = TABS.register(
            "weapons",() -> CreativeModeTab.builder().icon(() -> new ItemStack(EPItems.STEEL_SWORD.get()))
                    .title(Component.translatable("creativetab." + EnhancedPlaythrough.MOD_ID + ".weapons"))
                    .withTabsAfter(EPTabs.JEWELERY.getId())
                    .withTabsBefore(EPTabs.ALUMINUM_TOOLS.getId())
                    .displayItems((itemDisplayParameters, output) -> {
                        //Silver
                        output.accept(EPItems.SILVER_SWORD.get());
                        output.accept(EPItems.SILVER_DAGGER.get());
                        output.accept(EPItems.SILVER_HELMET.get());
                        output.accept(EPItems.SILVER_CHESTPLATE.get());
                        output.accept(EPItems.SILVER_LEGGINGS.get());
                        output.accept(EPItems.SILVER_BOOTS.get());

                        //Bronze
                        output.accept(EPItems.BRONZE_SWORD.get());
                        output.accept(EPItems.BRONZE_DAGGER.get());
                        output.accept(EPItems.BRONZE_HELMET.get());
                        output.accept(EPItems.BRONZE_CHESTPLATE.get());
                        output.accept(EPItems.BRONZE_LEGGINGS.get());
                        output.accept(EPItems.BRONZE_BOOTS.get());

                        //Brass
                        output.accept(EPItems.BRASS_SWORD.get());
                        output.accept(EPItems.BRASS_DAGGER.get());
                        output.accept(EPItems.BRASS_HELMET.get());
                        output.accept(EPItems.BRASS_CHESTPLATE.get());
                        output.accept(EPItems.BRASS_LEGGINGS.get());
                        output.accept(EPItems.BRASS_BOOTS.get());

                        //Rose gold
                        output.accept(EPItems.ROSE_GOLDEN_SWORD.get());
                        output.accept(EPItems.ROSE_GOLDEN_DAGGER.get());
                        output.accept(EPItems.ROSE_GOLDEN_HELMET.get());
                        output.accept(EPItems.ROSE_GOLDEN_CHESTPLATE.get());
                        output.accept(EPItems.ROSE_GOLDEN_LEGGINGS.get());
                        output.accept(EPItems.ROSE_GOLDEN_BOOTS.get());

                        //Bronzium
                        output.accept(EPItems.BRONZIUM_SWORD.get());
                        output.accept(EPItems.BRONZIUM_DAGGER.get());
                        output.accept(EPItems.BRONZIUM_HELMET.get());
                        output.accept(EPItems.BRONZIUM_CHESTPLATE.get());
                        output.accept(EPItems.BRONZIUM_LEGGINGS.get());
                        output.accept(EPItems.BRONZIUM_BOOTS.get());

                        //Green gold
                        output.accept(EPItems.GREEN_GOLDEN_SWORD.get());
                        output.accept(EPItems.GREEN_GOLDEN_DAGGER.get());
                        output.accept(EPItems.GREEN_GOLDEN_HELMET.get());
                        output.accept(EPItems.GREEN_GOLDEN_CHESTPLATE.get());
                        output.accept(EPItems.GREEN_GOLDEN_LEGGINGS.get());
                        output.accept(EPItems.GREEN_GOLDEN_BOOTS.get());

                        //Steel
                        output.accept(EPItems.STEEL_SWORD.get());
                        output.accept(EPItems.STEEL_DAGGER.get());
                        output.accept(EPItems.STEEL_HELMET.get());
                        output.accept(EPItems.STEEL_CHESTPLATE.get());
                        output.accept(EPItems.STEEL_LEGGINGS.get());
                        output.accept(EPItems.STEEL_BOOTS.get());

                        //Blue gold
                        output.accept(EPItems.BLUE_GOLDEN_SWORD.get());
                        output.accept(EPItems.BLUE_GOLDEN_DAGGER.get());
                        output.accept(EPItems.BLUE_GOLDEN_HELMET.get());
                        output.accept(EPItems.BLUE_GOLDEN_CHESTPLATE.get());
                        output.accept(EPItems.BLUE_GOLDEN_LEGGINGS.get());
                        output.accept(EPItems.BLUE_GOLDEN_BOOTS.get());
                    })
                    .build());

    public static final RegistryObject<CreativeModeTab> JEWELERY = TABS.register(
            "jewelery", () -> CreativeModeTab.builder().icon(() -> new ItemStack(EPItems.RUBY.get()))
                    .title(Component.translatable("creativetab." + EnhancedPlaythrough.MOD_ID + ".jewelery"))
                    .withTabsAfter(EPTabs.FOODS.getId())
                    .withTabsBefore(EPTabs.WEAPONS.getId())
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(EPBlocks.GEM_POLISHER.get());

                        output.accept(EPItems.GOLDEN_POLISHER.get());
                        output.accept(EPItems.SILVER_POLISHER.get());
                        output.accept((EPItems.STONE_POLISHER.get()));
                        output.accept((EPItems.BRONZE_POLISHER.get()));
                        output.accept(EPItems.BRASS_POLISHER.get());
                        output.accept(EPItems.ROSE_GOLDEN_POLISHER.get());
                        output.accept(EPItems.BRONZIUM_POLISHER.get());
                        output.accept(EPItems.IRON_POLISHER.get());
                        output.accept(EPItems.GREEN_GOLDEN_POLISHER.get());
                        output.accept(EPItems.STEEL_POLISHER.get());
                        output.accept(EPItems.BLUE_GOLDEN_POLISHER.get());
                        output.accept(EPItems.DIAMOND_POLISHER.get());
                        output.accept(EPItems.NETHERITE_POLISHER.get());

                        output.accept(EPItems.RAW_EMERALD.get());
                        output.accept(Items.EMERALD);

                        output.accept(EPItems.RAW_SAPPHIRE.get());
                        output.accept(EPItems.SAPPHIRE.get());

                        output.accept(EPItems.RAW_RUBY.get());
                        output.accept(EPItems.RUBY.get());

                        output.accept(EPItems.RAW_GARNET.get());
                        output.accept(EPItems.GARNET.get());

                        output.accept(EPItems.RAW_DIAMOND.get());
                        output.accept(Items.DIAMOND);

                        output.accept(EPBlocks.SAPPHIRE_ORE.get());
                        output.accept(EPBlocks.DEEPSLATE_SAPPHIRE_ORE.get());
                        output.accept(Blocks.EMERALD_ORE);
                        output.accept(Blocks.DEEPSLATE_EMERALD_ORE);
                        output.accept(EPBlocks.RUBY_ORE.get());
                        output.accept(EPBlocks.DEEPSLATE_RUBY_ORE.get());
                        output.accept(EPBlocks.NETHER_GARNET_ORE.get());
                        output.accept(Blocks.DIAMOND_ORE);
                        output.accept(Blocks.DEEPSLATE_DIAMOND_ORE);
                    }).build());

    public static final RegistryObject<CreativeModeTab> FOODS = TABS.register(
            "fruits", () -> CreativeModeTab.builder().icon(() -> new ItemStack(EPItems.ZAPALLO.get()))
                    .title(Component.translatable("creativetab." + EnhancedPlaythrough.MOD_ID + ".fruits"))
                    .withTabsAfter(EPTabs.SAPLINGS.getId())
                    .withTabsBefore(EPTabs.JEWELERY.getId())
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(EPItems.YERBA_MATE.get());
                        output.accept(EPItems.GROUNDED_YERBA_MATE.get());

                        output.accept(EPItems.ZAPALLO.get());
                        output.accept(EPItems.COOKED_ZAPALLO.get());

                        output.accept(EPItems.EGGPLANT.get());
                        output.accept(EPItems.COOKED_EGGPLANT.get());

                        output.accept(EPItems.TOMATO.get());

                        output.accept(EPItems.CORN.get());
                        output.accept(EPItems.COOKED_CORN.get());

                        output.accept(EPItems.WALNUT.get());
                        output.accept(EPItems.PEELED_WALNUT.get());

                        output.accept(EPItems.GREEN_APPLE.get());

                        output.accept(EPItems.ORANGE.get());

                        output.accept(EPItems.LEMON.get());

                        output.accept(EPItems.LIME.get());

                        output.accept(EPItems.WHEAT_FLOUR.get());

                        output.accept(EPItems.PUMPKIN_FLOUR.get());

                        output.accept(EPItems.YEAST.get());

                        output.accept(EPItems.EMPTY_MATE.get());
                        output.accept(EPItems.MATE.get());
                    }).build());

    public static final RegistryObject<CreativeModeTab> SAPLINGS = TABS.register(
            "saplings", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(EPBlocks.WALNUT_SAPLING.get()))
                    .title(Component.translatable("creativetab." + EnhancedPlaythrough.MOD_ID + ".saplings"))
                    .withTabsAfter(EPTabs.WOODTYPES.getId())
                    .withTabsBefore(EPTabs.FOODS.getId())
                    .displayItems((itemDisplayParameters, output) -> {
                        //Seeds
                        output.accept(EPItems.YERBA_MATE_SEEDS.get());
                        output.accept(EPItems.ZAPALLO_SEEDS.get());
                        output.accept(EPItems.EGGPLANT_SEEDS.get());
                        output.accept(EPItems.TOMATO_SEEDS.get());
                        output.accept(EPItems.CORN_SEEDS.get());

                        //Plants
                        output.accept(EPBlocks.REEDS.get());
                        output.accept(EPBlocks.SMALL_REEDS.get());
                        output.accept(EPBlocks.TALL_REEDS.get());
                        output.accept(EPBlocks.WATER_REEDS.get());

                        output.accept(EPBlocks.WILD_WHEAT_CROP.get());
                        output.accept(EPBlocks.WILD_TOMATO_CROP.get());
                        output.accept(EPBlocks.WILD_CORN_CROP.get());

                        output.accept(EPBlocks.COLD_LYRIUM.get());
                        output.accept(EPBlocks.SUCCULENT.get());

                        //Walnut
                        output.accept(EPBlocks.WALNUT_SAPLING.get());
                        output.accept(EPBlocks.WALNUT_LEAVES.get());

                        //Apple
                        output.accept(EPBlocks.APPLE_SAPLING.get());
                        output.accept(EPBlocks.APPLE_LEAVES.get());
                        output.accept(EPBlocks.APPLE_LEAVES_WITH_FRUIT.get());
                        output.accept(EPBlocks.GREEN_APPLE_SAPLING.get());
                        output.accept(EPBlocks.GREEN_APPLE_LEAVES.get());
                        output.accept(EPBlocks.GREEN_APPLE_LEAVES_WITH_FRUIT.get());

                        //Orange
                        output.accept(EPBlocks.ORANGE_SAPLING.get());
                        output.accept(EPBlocks.ORANGE_LEAVES.get());
                        output.accept(EPBlocks.ORANGE_LEAVES_WITH_FRUIT.get());

                        //lemon
                        output.accept(EPBlocks.LEMON_SAPLING.get());
                        output.accept(EPBlocks.LEMON_LEAVES.get());
                        output.accept(EPBlocks.LEMON_LEAVES_WITH_FRUIT.get());

                        //Lime
                        output.accept(EPBlocks.LIME_SAPLING.get());
                        output.accept(EPBlocks.LIME_LEAVES.get());
                        output.accept(EPBlocks.LIME_LEAVES_WITH_FRUIT.get());
                    }).build());

    public static final RegistryObject<CreativeModeTab> WOODTYPES = TABS.register(
            "woodtypes", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(EPBlocks.WALNUT_PLANKS.get()))
                    .title(Component.translatable("creativetab." + EnhancedPlaythrough.MOD_ID + ".woodtypes"))
                    .withTabsAfter(EPTabs.MINERALS.getId())
                    .withTabsBefore(EPTabs.SAPLINGS.getId())
                    .displayItems((itemDisplayParameters, output) -> {
                        //Walnut
                        output.accept(EPBlocks.WALNUT_LOG.get());
                        output.accept(EPBlocks.STRIPPED_WALNUT_LOG.get());
                        output.accept(EPBlocks.WALNUT_WOOD.get());
                        output.accept(EPBlocks.STRIPPED_WALNUT_WOOD.get());
                        output.accept(EPBlocks.WALNUT_PLANKS.get());
                        output.accept(EPBlocks.WALNUT_DOOR.get());
                        output.accept(EPBlocks.WALNUT_TRAPDOOR.get());
                        output.accept(EPBlocks.WALNUT_BUTTON.get());
                        output.accept(EPBlocks.WALNUT_PRESSURE_PLATE.get());
                        output.accept(EPBlocks.WALNUT_SLAB.get());
                        output.accept(EPBlocks.WALNUT_STAIRS.get());
                        output.accept(EPBlocks.WALNUT_FENCE.get());
                        output.accept(EPBlocks.WALNUT_FENCEGATE.get());

                        //Apple
                        output.accept(EPBlocks.APPLE_LOG.get());
                        output.accept(EPBlocks.STRIPPED_APPLE_LOG.get());
                        output.accept(EPBlocks.APPLE_WOOD.get());
                        output.accept(EPBlocks.STRIPPED_APPLE_WOOD.get());
                        output.accept(EPBlocks.APPLE_PLANKS.get());
                        output.accept(EPBlocks.APPLE_DOOR.get());
                        output.accept(EPBlocks.APPLE_TRAPDOOR.get());
                        output.accept(EPBlocks.APPLE_BUTTON.get());
                        output.accept(EPBlocks.APPLE_PRESSURE_PLATE.get());
                        output.accept(EPBlocks.APPLE_SLAB.get());
                        output.accept(EPBlocks.APPLE_STAIRS.get());
                        output.accept(EPBlocks.APPLE_FENCE.get());
                        output.accept(EPBlocks.APPLE_FENCEGATE.get());

                        //Orange
                        output.accept(EPBlocks.ORANGE_LOG.get());
                        output.accept(EPBlocks.STRIPPED_ORANGE_LOG.get());
                        output.accept(EPBlocks.ORANGE_WOOD.get());
                        output.accept(EPBlocks.STRIPPED_ORANGE_WOOD.get());
                        output.accept(EPBlocks.ORANGE_PLANKS.get());
                        output.accept(EPBlocks.ORANGE_DOOR.get());
                        output.accept(EPBlocks.ORANGE_TRAPDOOR.get());
                        output.accept(EPBlocks.ORANGE_BUTTON.get());
                        output.accept(EPBlocks.ORANGE_PRESSURE_PLATE.get());
                        output.accept(EPBlocks.ORANGE_SLAB.get());
                        output.accept(EPBlocks.ORANGE_STAIRS.get());
                        output.accept(EPBlocks.ORANGE_FENCE.get());
                        output.accept(EPBlocks.ORANGE_FENCEGATE.get());

                        //Lemon
                        output.accept(EPBlocks.LEMON_LOG.get());
                        output.accept(EPBlocks.STRIPPED_LEMON_LOG.get());
                        output.accept(EPBlocks.LEMON_WOOD.get());
                        output.accept(EPBlocks.STRIPPED_LEMON_WOOD.get());
                        output.accept(EPBlocks.LEMON_PLANKS.get());
                        output.accept(EPBlocks.LEMON_DOOR.get());
                        output.accept(EPBlocks.LEMON_TRAPDOOR.get());
                        output.accept(EPBlocks.LEMON_BUTTON.get());
                        output.accept(EPBlocks.LEMON_PRESSURE_PLATE.get());
                        output.accept(EPBlocks.LEMON_SLAB.get());
                        output.accept(EPBlocks.LEMON_STAIRS.get());
                        output.accept(EPBlocks.LEMON_FENCE.get());
                        output.accept(EPBlocks.LEMON_FENCEGATE.get());
                    }).build());

    public static final RegistryObject<CreativeModeTab> MINERALS = TABS.register(
            "minerals", () -> CreativeModeTab.builder().icon(() -> new ItemStack(EPBlocks.TIN_ORE.get()))
                    .title(Component.translatable("creativetab." + EnhancedPlaythrough.MOD_ID + ".minerals"))
                    .withTabsAfter(EPTabs.BLOCKS.getId())
                    .withTabsBefore(EPTabs.WOODTYPES.getId())
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(EPBlocks.SULFUR_ORE.get());
                        output.accept(EPBlocks.DEEPSLATE_SULFUR_ORE.get());
                        output.accept(EPBlocks.NETHER_SULFUR_ORE.get());

                        output.accept(EPBlocks.NETHER_COPPER_ORE.get());

                        output.accept(EPBlocks.TIN_ORE.get());
                        output.accept(EPBlocks.DEEPSLATE_TIN_ORE.get());

                        output.accept(EPBlocks.ZINC_ORE.get());
                        output.accept(EPBlocks.DEEPSLATE_ZINC_ORE.get());
                        output.accept(EPBlocks.NETHER_ZINC_ORE.get());

                        output.accept(EPBlocks.SILVER_ORE.get());
                        output.accept(EPBlocks.DEEPSLATE_SILVER_ORE.get());

                        output.accept(EPBlocks.COBALT_ORE.get());
                        output.accept(EPBlocks.DEEPSLATE_COBALT_ORE.get());

                        output.accept(EPBlocks.SAPPHIRE_ORE.get());
                        output.accept(EPBlocks.DEEPSLATE_SAPPHIRE_ORE.get());

                        output.accept(EPBlocks.RUBY_ORE.get());
                        output.accept(EPBlocks.DEEPSLATE_RUBY_ORE.get());

                        output.accept(EPBlocks.NETHER_GARNET_ORE.get());

                        // Bauxite
                        output.accept(EPBlocks.BAUXITE.get());
                        output.accept(EPBlocks.WHITE_BAUXITE.get());
                        output.accept(EPBlocks.LIGHT_GRAY_BAUXITE.get());
                        output.accept(EPBlocks.BROWN_BAUXITE.get());
                        output.accept(EPBlocks.RED_BAUXITE.get());
                        output.accept(EPBlocks.ORANGE_BAUXITE.get());
                        output.accept(EPBlocks.YELLOW_BAUXITE.get());
                    }).build());

    public static final RegistryObject<CreativeModeTab> BLOCKS = TABS.register(
            "blocks", () -> CreativeModeTab.builder().icon(() -> new ItemStack(EPBlocks.POLISHED_LIMESTONE.get()))
                    .title(Component.translatable("creativetab." + EnhancedPlaythrough.MOD_ID + ".blocks"))
                    .withTabsBefore(EPTabs.MINERALS.getId())
                    .withSearchBar()
                    .displayItems((itemDisplayParameters, output) ->{
                        output.accept(EPBlocks.POLISHED_STONE.get());
                        output.accept(EPBlocks.POLISHED_STONE_SLAB.get());
                        output.accept(EPBlocks.POLISHED_STONE_STAIRS.get());
                        output.accept(EPBlocks.POLISHED_STONE_WALL.get());

                        output.accept(EPBlocks.COBBLED_LIMESTONE.get());
                        output.accept(EPBlocks.COBBLED_LIMESTONE_SLAB.get());
                        output.accept(EPBlocks.COBBLED_LIMESTONE_STAIRS.get());
                        output.accept(EPBlocks.COBBLED_LIMESTONE_WALL.get());

                        output.accept(EPBlocks.LIMESTONE.get());
                        output.accept(EPBlocks.LIMESTONE_SLAB.get());
                        output.accept(EPBlocks.LIMESTONE_STAIRS.get());
                        output.accept(EPBlocks.LIMESTONE_WALL.get());

                        output.accept(EPBlocks.POLISHED_LIMESTONE.get());
                        output.accept(EPBlocks.POLISHED_LIMESTONE_SLAB.get());
                        output.accept(EPBlocks.POLISHED_LIMESTONE_STAIRS.get());
                        output.accept(EPBlocks.POLISHED_LIMESTONE_WALL.get());

                        output.accept(EPBlocks.LIMESTONE_BRICKS.get());
                        output.accept(EPBlocks.LIMESTONE_BRICK_SLAB.get());
                        output.accept(EPBlocks.LIMESTONE_BRICK_STAIRS.get());
                        output.accept(EPBlocks.LIMESTONE_BRICK_WALL.get());

                        output.accept(EPBlocks.SOUL_MUD.get());
                        output.accept(EPBlocks.SOUL_MUD_BRICKS.get());
                        output.accept(EPBlocks.SOUL_MUD_BRICK_SLAB.get());
                        output.accept(EPBlocks.SOUL_MUD_BRICK_STAIRS.get());
                        output.accept(EPBlocks.SOUL_MUD_BRICK_WALL.get());

                        output.accept(EPBlocks.FIREBRICKS.get());
                        output.accept(EPBlocks.FIREBRICK_SLAB.get());
                        output.accept(EPBlocks.FIREBRICK_STAIRS.get());
                        output.accept(EPBlocks.FIREBRICK_WALL.get());

                        output.accept(EPBlocks.RAW_SILVER_BLOCK.get());
                        output.accept(EPBlocks.SILVER_BLOCK.get());
                        output.accept(EPBlocks.RAW_ALUMINUM_BLOCK.get());
                        output.accept(EPBlocks.ALUMINUM_BLOCK.get());
                        output.accept(EPBlocks.RAW_TIN_BLOCK.get());
                        output.accept(EPBlocks.TIN_BLOCK.get());
                        output.accept(EPBlocks.RAW_ZINC_BLOCK.get());
                        output.accept(EPBlocks.ZINC_BLOCK.get());
                        output.accept(EPBlocks.BRASS_BLOCK.get());
                        output.accept(EPBlocks.BRONZE_BLOCK.get());
                        output.accept(EPBlocks.ROSE_GOLD_BLOCK.get());
                        output.accept(EPBlocks.BRONZIUM_BLOCK.get());
                        output.accept(EPBlocks.GREEN_GOLD_BLOCK.get());
                        output.accept(EPBlocks.STEEL_BLOCK.get());
                        output.accept(EPBlocks.BLUE_GOLD_BLOCK.get());

                        output.accept(EPBlocks.CALIBRATED_QUARTZ_BLOCK.get());
                        output.accept(EPBlocks.SMOOTH_CALIBRATED_QUARTZ_BLOCK.get());
                        output.accept(EPBlocks.CHISELED_CALIBRATED_QUARTZ_BLOCK.get());
                        output.accept(EPBlocks.CALIBRATED_QUARTZ_PILLAR.get());
                        output.accept(EPBlocks.CALIBRATED_QUARTZ_BRICKS.get());
                    }).build());

    public static void register(IEventBus eventBus){
        EnhancedPlaythrough.LOGGER.info("Registering Enhanced Playthrough tabs...");
        TABS.register(eventBus);
    }
}
