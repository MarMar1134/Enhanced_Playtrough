package net.marmar.enhanced_playthrough.Util.tab;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.block.ModBlocks;
import net.marmar.enhanced_playthrough.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModTabs {
    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, EnhancedPlaythrough.MOD_ID);

    public static final RegistryObject<CreativeModeTab> UTILITY_BLOCKS = TABS.register(
            "utility_blocks", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModBlocks.ADOBE_ALLOYING_FURNACE.get()))
                    .title(Component.translatable("creativetab." + EnhancedPlaythrough.MOD_ID + ".utility_blocks"))
                    .withTabsAfter(ModTabs.UTILITY.getId())
                    .displayItems(((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.ADOBE_FURNACE.get());
                        output.accept(ModBlocks.SOUL_FURNACE.get());

                        output.accept(ModBlocks.MASONRY_FURNACE.get());

                        output.accept(ModBlocks.ADOBE_ALLOYING_FURNACE.get());
                        output.accept(ModBlocks.SUPER_ALLOYING_FURNACE.get());
                        output.accept(ModBlocks.SOUL_ALLOY_FURNACE.get());

                        output.accept(ModBlocks.GEM_POLISHER.get());

                        output.accept(ModBlocks.PRIMAL_GRINDER.get());
                        output.accept(ModBlocks.MECHANICAL_GRINDER.get());

                        output.accept(ModItems.WALNUT_SIGN.get());
                        output.accept(ModItems.WALNUT_HANGING_SIGN.get());

                        output.accept(ModItems.APPLE_SIGN.get());
                        output.accept(ModItems.APPLE_HANGING_SIGN.get());

                        output.accept(ModItems.ORANGE_SIGN.get());
                        output.accept(ModItems.ORANGE_HANGING_SIGN.get());

                        output.accept(ModItems.LEMON_SIGN.get());
                        output.accept(ModItems.LEMON_HANGING_SIGN.get());
                    }))
                    .build());

    public static final RegistryObject<CreativeModeTab> UTILITY = TABS.register(
            "utility", () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.BRONZE_INGOT.get()))
                    .title(Component.translatable("creativetab." + EnhancedPlaythrough.MOD_ID + ".utility"))
                    .withTabsAfter(ModTabs.TOOLS.getId())
                    .withTabsBefore(ModTabs.UTILITY_BLOCKS.getId())
                    .displayItems((itemDisplayParameters, output) -> {
                        //Cobble
                        output.accept(ModItems.COBBLE.get());
                        output.accept(ModItems.LIMESTONE_COBBLE.get());
                        output.accept(ModItems.DEEPSLATE_COBBLE.get());
                        output.accept(ModItems.NETHERRACK_RUBBLE.get());
                        output.accept(ModItems.BLACKSTONE_COBBLE.get());

                        //Terracotta shards
                        output.accept(ModItems.WHITE_TERRACOTTA_SHARD.get());
                        output.accept(ModItems.ORANGE_TERRACOTTA_SHARD.get());
                        output.accept(ModItems.MAGENTA_TERRACOTTA_SHARD.get());
                        output.accept(ModItems.LIGHT_BLUE_TERRACOTTA_SHARD.get());
                        output.accept(ModItems.YELLOW_TERRACOTTA_SHARD.get());
                        output.accept(ModItems.LIME_TERRACOTTA_SHARD.get());
                        output.accept(ModItems.PINK_TERRACOTTA_SHARD.get());
                        output.accept(ModItems.GRAY_TERRACOTTA_SHARD.get());
                        output.accept(ModItems.LIGHT_GRAY_TERRACOTTA_SHARD.get());
                        output.accept(ModItems.CYAN_TERRACOTTA_SHARD.get());
                        output.accept(ModItems.PURPLE_TERRACOTTA_SHARD.get());
                        output.accept(ModItems.BLUE_TERRACOTTA_SHARD.get());
                        output.accept(ModItems.BROWN_TERRACOTTA_SHARD.get());
                        output.accept(ModItems.GREEN_TERRACOTTA_SHARD.get());
                        output.accept(ModItems.RED_TERRACOTTA_SHARD.get());
                        output.accept(ModItems.BLACK_TERRACOTTA_SHARD.get());
                        output.accept(ModItems.TERRACOTTA_SHARD.get());

                        //Misc
                        output.accept(ModItems.REED_HEAD.get());
                        output.accept(ModItems.WATER_REED_HEAD.get());
                        output.accept(ModItems.VEGETABLE_FIBBER.get());
                        output.accept(ModItems.MUD_BRICK.get());
                        output.accept(ModItems.FIREBRICK.get());
                        output.accept(ModItems.ALUMINUM_ROD.get());
                        output.accept(ModItems.BRONZIUM_SMITHING_UPGRADE_TEMPLATE.get());
                        output.accept(ModItems.ALUMINUM_SMITHING_UPGRADE_TEMPLATE.get());

                        //Raw
                        output.accept(ModItems.RAW_SILVER.get());

                        output.accept(ModItems.RAW_ALUMINUM.get());

                        output.accept(ModItems.RAW_ZINC.get());

                        output.accept(ModItems.RAW_TIN.get());

                        output.accept(ModItems.SULFUR.get());

                        //Melted
                        output.accept(ModItems.SILVER_INGOT.get());
                        output.accept(ModItems.SILVER_DUST.get());
                        output.accept(ModItems.SILVER_NUGGET.get());

                        output.accept(ModItems.ALUMINUM_INGOT.get());
                        output.accept(ModItems.ALUMINUM_DUST.get());
                        output.accept(ModItems.ALUMINUM_NUGGET.get());

                        output.accept(Items.COPPER_INGOT);
                        output.accept(ModItems.COPPER_DUST.get());
                        output.accept((ModItems.COPPER_NUGGET.get()));

                        output.accept(ModItems.ZINC_INGOT.get());
                        output.accept(ModItems.ZINC_DUST.get());
                        output.accept(ModItems.ZINC_NUGGET.get());

                        output.accept((ModItems.TIN_INGOT.get()));
                        output.accept(ModItems.TIN_DUST.get());
                        output.accept((ModItems.TIN_NUGGET.get()));

                        output.accept(ModItems.BRASS_INGOT.get());
                        output.accept(ModItems.BRASS_DUST.get());
                        output.accept(ModItems.BRASS_NUGGET.get());

                        output.accept(ModItems.BRONZE_INGOT.get());
                        output.accept(ModItems.BRONZE_DUST.get());
                        output.accept(ModItems.BRONZE_NUGGET.get());

                        output.accept(ModItems.ROSE_GOLD_INGOT.get());
                        output.accept(ModItems.ROSE_GOLD_DUST.get());
                        output.accept(ModItems.ROSE_GOLD_NUGGET.get());

                        output.accept(Items.IRON_INGOT);
                        output.accept(ModItems.IRON_DUST.get());
                        output.accept(Items.IRON_NUGGET);

                        output.accept(ModItems.BRONZIUM_INGOT.get());
                        output.accept(ModItems.BRONZIUM_DUST.get());
                        output.accept(ModItems.BRONZIUM_NUGGET.get());

                        output.accept(ModItems.GREEN_GOLD_INGOT.get());
                        output.accept(ModItems.GREEN_GOLD_DUST.get());
                        output.accept(ModItems.GREEN_GOLD_NUGGET.get());

                        output.accept(ModItems.STEEL_INGOT.get());
                        output.accept(ModItems.STEEL_DUST.get());
                        output.accept(ModItems.STEEL_NUGGET.get());

                        output.accept(ModItems.BLUE_GOLD_INGOT.get());
                        output.accept(ModItems.BLUE_GOLD_DUST.get());
                        output.accept(ModItems.BLUE_GOLD_NUGGET.get());
                    }).build());

    public static final RegistryObject<CreativeModeTab> TOOLS = TABS.register(
            "tools", () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.STEEL_PICKAXE.get()))
                    .title((Component.translatable("creativetab." + EnhancedPlaythrough.MOD_ID + ".tools")))
                    .withTabsAfter(ModTabs.ALUMINUM_TOOLS.getId())
                    .withTabsBefore(ModTabs.UTILITY.getId())
                    .displayItems((itemDisplayParameters, output) -> {
                        //Silver
                        output.accept(ModItems.SILVER_PICKAXE.get());
                        output.accept(ModItems.SILVER_AXE.get());
                        output.accept(ModItems.SILVER_SHOVEL.get());
                        output.accept(ModItems.SILVER_HOE.get());
                        output.accept(ModItems.SILVER_POLISHER.get());
                        output.accept(ModItems.SILVER_POLISHER.get());

                        //Bronze
                        output.accept(ModItems.BRONZE_PICKAXE.get());
                        output.accept(ModItems.BRONZE_AXE.get());
                        output.accept(ModItems.BRONZE_SHOVEL.get());
                        output.accept(ModItems.BRONZE_HOE.get());
                        output.accept(ModItems.BRONZE_POLISHER.get());

                        //Brass
                        output.accept(ModItems.BRASS_PICKAXE.get());
                        output.accept(ModItems.BRASS_AXE.get());
                        output.accept(ModItems.BRASS_SHOVEL.get());
                        output.accept(ModItems.BRASS_HOE.get());
                        output.accept(ModItems.BRASS_POLISHER.get());

                        //Rose Gold
                        output.accept(ModItems.ROSE_GOLDEN_PICKAXE.get());
                        output.accept(ModItems.ROSE_GOLDEN_AXE.get());
                        output.accept(ModItems.ROSE_GOLDEN_SHOVEL.get());
                        output.accept(ModItems.ROSE_GOLDEN_HOE.get());
                        output.accept(ModItems.ROSE_GOLDEN_POLISHER.get());

                        //Bronzium
                        output.accept(ModItems.BRONZIUM_PICKAXE.get());
                        output.accept(ModItems.BRONZIUM_AXE.get());
                        output.accept(ModItems.BRONZIUM_SHOVEL.get());
                        output.accept(ModItems.BRONZIUM_HOE.get());
                        output.accept(ModItems.BRONZIUM_POLISHER.get());

                        //Green Gold
                        output.accept(ModItems.GREEN_GOLDEN_PICKAXE.get());
                        output.accept(ModItems.GREEN_GOLDEN_AXE.get());
                        output.accept(ModItems.GREEN_GOLDEN_SHOVEL.get());
                        output.accept(ModItems.GREEN_GOLDEN_HOE.get());
                        output.accept(ModItems.GREEN_GOLDEN_POLISHER.get());

                        //Steel
                        output.accept(ModItems.STEEL_PICKAXE.get());
                        output.accept(ModItems.STEEL_AXE.get());
                        output.accept(ModItems.STEEL_SHOVEL.get());
                        output.accept(ModItems.STEEL_HOE.get());
                        output.accept(ModItems.STEEL_POLISHER.get());
                        output.accept(ModItems.STEEL_POLISHER.get());

                        //Blue Gold
                        output.accept(ModItems.BLUE_GOLDEN_PICKAXE.get());
                        output.accept(ModItems.BLUE_GOLDEN_AXE.get());
                        output.accept(ModItems.BLUE_GOLDEN_SHOVEL.get());
                        output.accept(ModItems.BLUE_GOLDEN_HOE.get());
                        output.accept(ModItems.BLUE_GOLDEN_POLISHER.get());

                        //Boats
                        output.accept(ModItems.WALNUT_BOAT.get());
                        output.accept(ModItems.WALNUT_CHEST_BOAT.get());

                        output.accept(ModItems.APPLE_BOAT.get());
                        output.accept(ModItems.APPLE_CHEST_BOAT.get());

                        output.accept(ModItems.ORANGE_BOAT.get());
                        output.accept(ModItems.ORANGE_CHEST_BOAT.get());

                        output.accept(ModItems.LEMON_BOAT.get());
                        output.accept(ModItems.LEMON_CHEST_BOAT.get());
                    }).build());

    public static final RegistryObject<CreativeModeTab> ALUMINUM_TOOLS = TABS.register(
            "aluminum_tools", () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ALUMINUM_STEEL_PICKAXE.get()))
                    .title((Component.translatable("creativetab." + EnhancedPlaythrough.MOD_ID + ".aluminum_tools")))
                    .withTabsAfter(ModTabs.WEAPONS.getId())
                    .withTabsBefore(ModTabs.TOOLS.getId())
                    .displayItems((itemDisplayParameters, output) -> {
                        //Aluminum Wooden
                        output.accept(ModItems.ALUMINUM_WOODEN_PICKAXE.get());
                        output.accept(ModItems.ALUMINUM_WOODEN_AXE.get());
                        output.accept(ModItems.ALUMINUM_WOODEN_SHOVEL.get());
                        output.accept(ModItems.ALUMINUM_WOODEN_HOE.get());
                        output.accept(ModItems.ALUMINUM_WOODEN_SWORD.get());
                        output.accept(ModItems.ALUMINUM_WOODEN_DAGGER.get());

                        //Aluminum Stone
                        output.accept(ModItems.ALUMINUM_STONE_PICKAXE.get());
                        output.accept(ModItems.ALUMINUM_STONE_AXE.get());
                        output.accept(ModItems.ALUMINUM_STONE_SHOVEL.get());
                        output.accept(ModItems.ALUMINUM_STONE_HOE.get());
                        output.accept(ModItems.ALUMINUM_STONE_POLISHER.get());
                        output.accept(ModItems.ALUMINUM_STONE_SWORD.get());
                        output.accept(ModItems.ALUMINUM_STONE_DAGGER.get());

                        //Aluminum Golden
                        output.accept(ModItems.ALUMINUM_GOLDEN_PICKAXE.get());
                        output.accept(ModItems.ALUMINUM_GOLDEN_AXE.get());
                        output.accept(ModItems.ALUMINUM_GOLDEN_SHOVEL.get());
                        output.accept(ModItems.ALUMINUM_GOLDEN_HOE.get());
                        output.accept(ModItems.ALUMINUM_GOLDEN_POLISHER.get());
                        output.accept(ModItems.ALUMINUM_GOLDEN_SWORD.get());
                        output.accept(ModItems.ALUMINUM_GOLDEN_DAGGER.get());

                        //Aluminum Silver
                        output.accept(ModItems.ALUMINUM_SILVER_PICKAXE.get());
                        output.accept(ModItems.ALUMINUM_SILVER_AXE.get());
                        output.accept(ModItems.ALUMINUM_SILVER_SHOVEL.get());
                        output.accept(ModItems.ALUMINUM_SILVER_HOE.get());
                        output.accept(ModItems.ALUMINUM_SILVER_POLISHER.get());
                        output.accept(ModItems.ALUMINUM_SILVER_SWORD.get());
                        output.accept(ModItems.ALUMINUM_SILVER_DAGGER.get());

                        //Aluminum Bronze
                        output.accept(ModItems.ALUMINUM_BRONZE_PICKAXE.get());
                        output.accept(ModItems.ALUMINUM_BRONZE_AXE.get());
                        output.accept(ModItems.ALUMINUM_BRONZE_SHOVEL.get());
                        output.accept(ModItems.ALUMINUM_BRONZE_HOE.get());
                        output.accept(ModItems.ALUMINUM_BRONZE_POLISHER.get());
                        output.accept(ModItems.ALUMINUM_BRONZE_SWORD.get());
                        output.accept(ModItems.ALUMINUM_BRONZE_DAGGER.get());

                        //Aluminum Brass
                        output.accept(ModItems.ALUMINUM_BRASS_PICKAXE.get());
                        output.accept(ModItems.ALUMINUM_BRASS_AXE.get());
                        output.accept(ModItems.ALUMINUM_BRASS_SHOVEL.get());
                        output.accept(ModItems.ALUMINUM_BRASS_HOE.get());
                        output.accept(ModItems.ALUMINUM_BRASS_POLISHER.get());
                        output.accept(ModItems.ALUMINUM_BRASS_SWORD.get());
                        output.accept(ModItems.ALUMINUM_BRASS_DAGGER.get());

                        //Aluminum Rose Gold
                        output.accept(ModItems.ALUMINUM_ROSE_GOLDEN_PICKAXE.get());
                        output.accept(ModItems.ALUMINUM_ROSE_GOLDEN_AXE.get());
                        output.accept(ModItems.ALUMINUM_ROSE_GOLDEN_SHOVEL.get());
                        output.accept(ModItems.ALUMINUM_ROSE_GOLDEN_HOE.get());
                        output.accept(ModItems.ALUMINUM_ROSE_GOLDEN_POLISHER.get());
                        output.accept(ModItems.ALUMINUM_ROSE_GOLDEN_SWORD.get());
                        output.accept(ModItems.ALUMINUM_ROSE_GOLDEN_DAGGER.get());

                        //Aluminum Iron
                        output.accept(ModItems.ALUMINUM_IRON_PICKAXE.get());
                        output.accept(ModItems.ALUMINUM_IRON_AXE.get());
                        output.accept(ModItems.ALUMINUM_IRON_SHOVEL.get());
                        output.accept(ModItems.ALUMINUM_IRON_HOE.get());
                        output.accept(ModItems.ALUMINUM_IRON_POLISHER.get());
                        output.accept(ModItems.ALUMINUM_IRON_SWORD.get());
                        output.accept(ModItems.ALUMINUM_IRON_DAGGER.get());

                        //Aluminum Bronzium
                        output.accept(ModItems.ALUMINUM_BRONZIUM_PICKAXE.get());
                        output.accept(ModItems.ALUMINUM_BRONZIUM_AXE.get());
                        output.accept(ModItems.ALUMINUM_BRONZIUM_SHOVEL.get());
                        output.accept(ModItems.ALUMINUM_BRONZIUM_HOE.get());
                        output.accept(ModItems.ALUMINUM_BRONZIUM_POLISHER.get());
                        output.accept(ModItems.ALUMINUM_BRONZIUM_SWORD.get());
                        output.accept(ModItems.ALUMINUM_BRONZIUM_DAGGER.get());

                        //Aluminum Green Gold
                        output.accept(ModItems.ALUMINUM_GREEN_GOLDEN_PICKAXE.get());
                        output.accept(ModItems.ALUMINUM_GREEN_GOLDEN_AXE.get());
                        output.accept(ModItems.ALUMINUM_GREEN_GOLDEN_SHOVEL.get());
                        output.accept(ModItems.ALUMINUM_GREEN_GOLDEN_HOE.get());
                        output.accept(ModItems.ALUMINUM_GREEN_GOLDEN_POLISHER.get());
                        output.accept(ModItems.ALUMINUM_GREEN_GOLDEN_SWORD.get());
                        output.accept(ModItems.ALUMINUM_GREEN_GOLDEN_DAGGER.get());

                        //Aluminum Steel
                        output.accept(ModItems.ALUMINUM_STEEL_PICKAXE.get());
                        output.accept(ModItems.ALUMINUM_STEEL_AXE.get());
                        output.accept(ModItems.ALUMINUM_STEEL_SHOVEL.get());
                        output.accept(ModItems.ALUMINUM_STEEL_HOE.get());
                        output.accept(ModItems.ALUMINUM_STEEL_POLISHER.get());
                        output.accept(ModItems.ALUMINUM_STEEL_SWORD.get());
                        output.accept(ModItems.ALUMINUM_STEEL_DAGGER.get());

                        //Aluminum Blue Gold
                        output.accept(ModItems.ALUMINUM_BLUE_GOLDEN_PICKAXE.get());
                        output.accept(ModItems.ALUMINUM_BLUE_GOLDEN_AXE.get());
                        output.accept(ModItems.ALUMINUM_BLUE_GOLDEN_SHOVEL.get());
                        output.accept(ModItems.ALUMINUM_BLUE_GOLDEN_HOE.get());
                        output.accept(ModItems.ALUMINUM_BLUE_GOLDEN_POLISHER.get());
                        output.accept(ModItems.ALUMINUM_BLUE_GOLDEN_SWORD.get());
                        output.accept(ModItems.ALUMINUM_BLUE_GOLDEN_DAGGER.get());

                        //Aluminum Diamond
                        output.accept(ModItems.ALUMINUM_DIAMOND_PICKAXE.get());
                        output.accept(ModItems.ALUMINUM_DIAMOND_AXE.get());
                        output.accept(ModItems.ALUMINUM_DIAMOND_SHOVEL.get());
                        output.accept(ModItems.ALUMINUM_DIAMOND_HOE.get());
                        output.accept(ModItems.ALUMINUM_DIAMOND_POLISHER.get());
                        output.accept(ModItems.ALUMINUM_DIAMOND_SWORD.get());
                        output.accept(ModItems.ALUMINUM_DIAMOND_DAGGER.get());
                    }).build());

    public static final RegistryObject<CreativeModeTab> WEAPONS = TABS.register(
            "weapons",() -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.STEEL_SWORD.get()))
                    .title(Component.translatable("creativetab." + EnhancedPlaythrough.MOD_ID + ".weapons"))
                    .withTabsAfter(ModTabs.JEWELERY.getId())
                    .withTabsBefore(ModTabs.ALUMINUM_TOOLS.getId())
                    .displayItems((itemDisplayParameters, output) -> {
                        //Silver
                        output.accept(ModItems.SILVER_SWORD.get());
                        output.accept(ModItems.SILVER_DAGGER.get());
                        output.accept(ModItems.SILVER_HELMET.get());
                        output.accept(ModItems.SILVER_CHESTPLATE.get());
                        output.accept(ModItems.SILVER_LEGGINGS.get());
                        output.accept(ModItems.SILVER_BOOTS.get());

                        //Bronze
                        output.accept(ModItems.BRONZE_SWORD.get());
                        output.accept(ModItems.BRONZE_DAGGER.get());
                        output.accept(ModItems.BRONZE_HELMET.get());
                        output.accept(ModItems.BRONZE_CHESTPLATE.get());
                        output.accept(ModItems.BRONZE_LEGGINGS.get());
                        output.accept(ModItems.BRONZE_BOOTS.get());

                        //Brass
                        output.accept(ModItems.BRASS_SWORD.get());
                        output.accept(ModItems.BRASS_DAGGER.get());
                        output.accept(ModItems.BRASS_HELMET.get());
                        output.accept(ModItems.BRASS_CHESTPLATE.get());
                        output.accept(ModItems.BRASS_LEGGINGS.get());
                        output.accept(ModItems.BRASS_BOOTS.get());

                        //Rose gold
                        output.accept(ModItems.ROSE_GOLDEN_SWORD.get());
                        output.accept(ModItems.ROSE_GOLDEN_DAGGER.get());
                        output.accept(ModItems.ROSE_GOLDEN_HELMET.get());
                        output.accept(ModItems.ROSE_GOLDEN_CHESTPLATE.get());
                        output.accept(ModItems.ROSE_GOLDEN_LEGGINGS.get());
                        output.accept(ModItems.ROSE_GOLDEN_BOOTS.get());

                        //Bronzium
                        output.accept(ModItems.BRONZIUM_SWORD.get());
                        output.accept(ModItems.BRONZIUM_DAGGER.get());
                        output.accept(ModItems.BRONZIUM_HELMET.get());
                        output.accept(ModItems.BRONZIUM_CHESTPLATE.get());
                        output.accept(ModItems.BRONZIUM_LEGGINGS.get());
                        output.accept(ModItems.BRONZIUM_BOOTS.get());

                        //Green gold
                        output.accept(ModItems.GREEN_GOLDEN_SWORD.get());
                        output.accept(ModItems.GREEN_GOLDEN_DAGGER.get());
                        output.accept(ModItems.GREEN_GOLDEN_HELMET.get());
                        output.accept(ModItems.GREEN_GOLDEN_CHESTPLATE.get());
                        output.accept(ModItems.GREEN_GOLDEN_LEGGINGS.get());
                        output.accept(ModItems.GREEN_GOLDEN_BOOTS.get());

                        //Steel
                        output.accept(ModItems.STEEL_SWORD.get());
                        output.accept(ModItems.STEEL_DAGGER.get());
                        output.accept(ModItems.STEEL_HELMET.get());
                        output.accept(ModItems.STEEL_CHESTPLATE.get());
                        output.accept(ModItems.STEEL_LEGGINGS.get());
                        output.accept(ModItems.STEEL_BOOTS.get());

                        //Blue gold
                        output.accept(ModItems.BLUE_GOLDEN_SWORD.get());
                        output.accept(ModItems.BLUE_GOLDEN_DAGGER.get());
                        output.accept(ModItems.BLUE_GOLDEN_HELMET.get());
                        output.accept(ModItems.BLUE_GOLDEN_CHESTPLATE.get());
                        output.accept(ModItems.BLUE_GOLDEN_LEGGINGS.get());
                        output.accept(ModItems.BLUE_GOLDEN_BOOTS.get());
                    })
                    .build());

    public static final RegistryObject<CreativeModeTab> JEWELERY = TABS.register(
            "jewelery", () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.RUBY.get()))
                    .title(Component.translatable("creativetab." + EnhancedPlaythrough.MOD_ID + ".jewelery"))
                    .withTabsAfter(ModTabs.FOODS.getId())
                    .withTabsBefore(ModTabs.WEAPONS.getId())
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.GEM_POLISHER.get());

                        output.accept(ModItems.GOLDEN_POLISHER.get());
                        output.accept(ModItems.SILVER_POLISHER.get());
                        output.accept((ModItems.STONE_POLISHER.get()));
                        output.accept((ModItems.BRONZE_POLISHER.get()));
                        output.accept(ModItems.BRASS_POLISHER.get());
                        output.accept(ModItems.ROSE_GOLDEN_POLISHER.get());
                        output.accept(ModItems.BRONZIUM_POLISHER.get());
                        output.accept(ModItems.IRON_POLISHER.get());
                        output.accept(ModItems.GREEN_GOLDEN_POLISHER.get());
                        output.accept(ModItems.STEEL_POLISHER.get());
                        output.accept(ModItems.BLUE_GOLDEN_POLISHER.get());
                        output.accept(ModItems.DIAMOND_POLISHER.get());
                        output.accept(ModItems.NETHERITE_POLISHER.get());

                        output.accept(ModItems.RAW_EMERALD.get());
                        output.accept(Items.EMERALD);

                        output.accept(ModItems.RAW_SAPPHIRE.get());
                        output.accept(ModItems.SAPPHIRE.get());

                        output.accept(ModItems.RAW_RUBY.get());
                        output.accept(ModItems.RUBY.get());

                        output.accept(ModItems.RAW_GARNET.get());
                        output.accept(ModItems.GARNET.get());

                        output.accept(ModItems.RAW_DIAMOND.get());
                        output.accept(Items.DIAMOND);

                        output.accept(ModBlocks.SAPPHIRE_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get());
                        output.accept(Blocks.EMERALD_ORE);
                        output.accept(Blocks.DEEPSLATE_EMERALD_ORE);
                        output.accept(ModBlocks.RUBY_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_RUBY_ORE.get());
                        output.accept(ModBlocks.NETHER_GARNET_ORE.get());
                        output.accept(Blocks.DIAMOND_ORE);
                        output.accept(Blocks.DEEPSLATE_DIAMOND_ORE);
                    }).build());

    public static final RegistryObject<CreativeModeTab> FOODS = TABS.register(
            "fruits", () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ZAPALLO.get()))
                    .title(Component.translatable("creativetab." + EnhancedPlaythrough.MOD_ID + ".fruits"))
                    .withTabsAfter(ModTabs.SAPLINGS.getId())
                    .withTabsBefore(ModTabs.JEWELERY.getId())
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.YERBA_MATE.get());
                        output.accept(ModItems.GROUNDED_YERBA_MATE.get());

                        output.accept(ModItems.ZAPALLO.get());
                        output.accept(ModItems.COOKED_ZAPALLO.get());

                        output.accept(ModItems.EGGPLANT.get());
                        output.accept(ModItems.COOKED_EGGPLANT.get());

                        output.accept(ModItems.TOMATO.get());

                        output.accept(ModItems.CORN.get());
                        output.accept(ModItems.COOKED_CORN.get());

                        output.accept(ModItems.WALNUT.get());
                        output.accept(ModItems.PEELED_WALNUT.get());

                        output.accept(ModItems.GREEN_APPLE.get());

                        output.accept(ModItems.ORANGE.get());

                        output.accept(ModItems.LEMON.get());

                        output.accept(ModItems.LIME.get());

                        output.accept(ModItems.WHEAT_FLOUR.get());

                        output.accept(ModItems.PUMPKIN_FLOUR.get());

                        output.accept(ModItems.YEAST.get());

                        output.accept(ModItems.EMPTY_MATE.get());
                        output.accept(ModItems.MATE.get());
                    }).build());

    public static final RegistryObject<CreativeModeTab> SAPLINGS = TABS.register(
            "saplings", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModBlocks.WALNUT_SAPLING.get()))
                    .title(Component.translatable("creativetab." + EnhancedPlaythrough.MOD_ID + ".saplings"))
                    .withTabsAfter(ModTabs.WOODTYPES.getId())
                    .withTabsBefore(ModTabs.FOODS.getId())
                    .displayItems((itemDisplayParameters, output) -> {
                        //Seeds
                        output.accept(ModItems.YERBA_MATE_SEEDS.get());
                        output.accept(ModItems.ZAPALLO_SEEDS.get());
                        output.accept(ModItems.EGGPLANT_SEEDS.get());
                        output.accept(ModItems.TOMATO_SEEDS.get());
                        output.accept(ModItems.CORN_SEEDS.get());

                        //Plants
                        output.accept(ModBlocks.SMALL_REEDS.get());
                        output.accept(ModBlocks.REEDS.get());
                        output.accept(ModBlocks.TALL_REEDS.get());
                        output.accept(ModBlocks.WATER_REEDS.get());
                        output.accept(ModBlocks.WILD_WHEAT.get());
                        output.accept(ModBlocks.WILD_TOMATO.get());
                        output.accept(ModBlocks.WILD_CORN.get());

                        //Walnut
                        output.accept(ModBlocks.WALNUT_SAPLING.get());
                        output.accept(ModBlocks.WALNUT_LEAVES.get());

                        //Apple
                        output.accept(ModBlocks.APPLE_SAPLING.get());
                        output.accept(ModBlocks.APPLE_LEAVES.get());
                        output.accept(ModBlocks.GREEN_APPLE_SAPLING.get());
                        output.accept(ModBlocks.GREEN_APPLE_LEAVES.get());

                        //Orange
                        output.accept(ModBlocks.ORANGE_SAPLING.get());
                        output.accept(ModBlocks.ORANGE_LEAVES.get());

                        //lemon
                        output.accept(ModBlocks.LEMON_SAPLING.get());
                        output.accept(ModBlocks.LEMON_LEAVES.get());

                        //Lime
                        output.accept(ModBlocks.LIME_SAPLING.get());
                        output.accept(ModBlocks.LIME_LEAVES.get());
                    }).build());

    public static final RegistryObject<CreativeModeTab> WOODTYPES = TABS.register(
            "woodtypes", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModBlocks.WALNUT_PLANKS.get()))
                    .title(Component.translatable("creativetab." + EnhancedPlaythrough.MOD_ID + ".woodtypes"))
                    .withTabsAfter(ModTabs.MINERALS.getId())
                    .withTabsBefore(ModTabs.SAPLINGS.getId())
                    .displayItems((itemDisplayParameters, output) -> {
                        //Walnut
                        output.accept(ModBlocks.WALNUT_LOG.get());
                        output.accept(ModBlocks.STRIPPED_WALNUT_LOG.get());
                        output.accept(ModBlocks.WALNUT_WOOD.get());
                        output.accept(ModBlocks.STRIPPED_WALNUT_WOOD.get());
                        output.accept(ModBlocks.WALNUT_PLANKS.get());
                        output.accept(ModBlocks.WALNUT_DOOR.get());
                        output.accept(ModBlocks.WALNUT_TRAPDOOR.get());
                        output.accept(ModBlocks.WALNUT_BUTTON.get());
                        output.accept(ModBlocks.WALNUT_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.WALNUT_SLAB.get());
                        output.accept(ModBlocks.WALNUT_STAIRS.get());
                        output.accept(ModBlocks.WALNUT_FENCE.get());
                        output.accept(ModBlocks.WALNUT_FENCEGATE.get());

                        //Apple
                        output.accept(ModBlocks.APPLE_LOG.get());
                        output.accept(ModBlocks.STRIPPED_APPLE_LOG.get());
                        output.accept(ModBlocks.APPLE_WOOD.get());
                        output.accept(ModBlocks.STRIPPED_APPLE_WOOD.get());
                        output.accept(ModBlocks.APPLE_PLANKS.get());
                        output.accept(ModBlocks.APPLE_DOOR.get());
                        output.accept(ModBlocks.APPLE_TRAPDOOR.get());
                        output.accept(ModBlocks.APPLE_BUTTON.get());
                        output.accept(ModBlocks.APPLE_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.APPLE_SLAB.get());
                        output.accept(ModBlocks.APPLE_STAIRS.get());
                        output.accept(ModBlocks.APPLE_FENCE.get());
                        output.accept(ModBlocks.APPLE_FENCEGATE.get());

                        //Orange
                        output.accept(ModBlocks.ORANGE_LOG.get());
                        output.accept(ModBlocks.STRIPPED_ORANGE_LOG.get());
                        output.accept(ModBlocks.ORANGE_WOOD.get());
                        output.accept(ModBlocks.STRIPPED_ORANGE_WOOD.get());
                        output.accept(ModBlocks.ORANGE_PLANKS.get());
                        output.accept(ModBlocks.ORANGE_DOOR.get());
                        output.accept(ModBlocks.ORANGE_TRAPDOOR.get());
                        output.accept(ModBlocks.ORANGE_BUTTON.get());
                        output.accept(ModBlocks.ORANGE_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.ORANGE_SLAB.get());
                        output.accept(ModBlocks.ORANGE_STAIRS.get());
                        output.accept(ModBlocks.ORANGE_FENCE.get());
                        output.accept(ModBlocks.ORANGE_FENCEGATE.get());

                        //Lemon
                        output.accept(ModBlocks.LEMON_LOG.get());
                        output.accept(ModBlocks.STRIPPED_LEMON_LOG.get());
                        output.accept(ModBlocks.LEMON_WOOD.get());
                        output.accept(ModBlocks.STRIPPED_LEMON_WOOD.get());
                        output.accept(ModBlocks.LEMON_PLANKS.get());
                        output.accept(ModBlocks.LEMON_DOOR.get());
                        output.accept(ModBlocks.LEMON_TRAPDOOR.get());
                        output.accept(ModBlocks.LEMON_BUTTON.get());
                        output.accept(ModBlocks.LEMON_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.LEMON_SLAB.get());
                        output.accept(ModBlocks.LEMON_STAIRS.get());
                        output.accept(ModBlocks.LEMON_FENCE.get());
                        output.accept(ModBlocks.LEMON_FENCEGATE.get());
                    }).build());

    public static final RegistryObject<CreativeModeTab> MINERALS = TABS.register(
            "minerals", () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.TIN_ORE.get()))
                    .title(Component.translatable("creativetab." + EnhancedPlaythrough.MOD_ID + ".minerals"))
                    .withTabsAfter(ModTabs.BLOCKS.getId())
                    .withTabsBefore(ModTabs.WOODTYPES.getId())
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.SULFUR_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_SULFUR_ORE.get());
                        output.accept(ModBlocks.NETHER_SULFUR_ORE.get());

                        output.accept(ModBlocks.NETHER_COPPER_ORE.get());

                        output.accept(ModBlocks.TIN_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_TIN_ORE.get());

                        output.accept(ModBlocks.ZINC_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_ZINC_ORE.get());
                        output.accept(ModBlocks.NETHER_ZINC_ORE.get());

                        output.accept(ModBlocks.SILVER_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_SILVER_ORE.get());

                        output.accept(ModBlocks.COBALT_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_COBALT_ORE.get());

                        output.accept(ModBlocks.SAPPHIRE_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get());

                        output.accept(ModBlocks.RUBY_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_RUBY_ORE.get());

                        output.accept(ModBlocks.NETHER_GARNET_ORE.get());

                        // Bauxite
                        output.accept(ModBlocks.BAUXITE.get());
                        output.accept(ModBlocks.WHITE_BAUXITE.get());
                        output.accept(ModBlocks.LIGHT_GRAY_BAUXITE.get());
                        output.accept(ModBlocks.BROWN_BAUXITE.get());
                        output.accept(ModBlocks.RED_BAUXITE.get());
                        output.accept(ModBlocks.ORANGE_BAUXITE.get());
                        output.accept(ModBlocks.YELLOW_BAUXITE.get());
                    }).build());

    public static final RegistryObject<CreativeModeTab> BLOCKS = TABS.register(
            "blocks", () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.POLISHED_LIMESTONE.get()))
                    .title(Component.translatable("creativetab." + EnhancedPlaythrough.MOD_ID + ".blocks"))
                    .withTabsBefore(ModTabs.MINERALS.getId())
                    .withSearchBar()
                    .displayItems((itemDisplayParameters, output) ->{
                        output.accept(ModBlocks.POLISHED_STONE.get());
                        output.accept(ModBlocks.POLISHED_STONE_SLAB.get());
                        output.accept(ModBlocks.POLISHED_STONE_STAIRS.get());
                        output.accept(ModBlocks.POLISHED_STONE_WALL.get());

                        output.accept(ModBlocks.COBBLED_LIMESTONE.get());
                        output.accept(ModBlocks.COBBLED_LIMESTONE_SLAB.get());
                        output.accept(ModBlocks.COBBLED_LIMESTONE_STAIRS.get());
                        output.accept(ModBlocks.COBBLED_LIMESTONE_WALL.get());

                        output.accept(ModBlocks.LIMESTONE.get());
                        output.accept(ModBlocks.LIMESTONE_SLAB.get());
                        output.accept(ModBlocks.LIMESTONE_STAIRS.get());
                        output.accept(ModBlocks.LIMESTONE_WALL.get());

                        output.accept(ModBlocks.POLISHED_LIMESTONE.get());
                        output.accept(ModBlocks.POLISHED_LIMESTONE_SLAB.get());
                        output.accept(ModBlocks.POLISHED_LIMESTONE_STAIRS.get());
                        output.accept(ModBlocks.POLISHED_LIMESTONE_WALL.get());

                        output.accept(ModBlocks.LIMESTONE_BRICKS.get());
                        output.accept(ModBlocks.LIMESTONE_BRICK_SLAB.get());
                        output.accept(ModBlocks.LIMESTONE_BRICK_STAIRS.get());
                        output.accept(ModBlocks.LIMESTONE_BRICK_WALL.get());

                        output.accept(ModBlocks.SOUL_MUD.get());
                        output.accept(ModBlocks.SOUL_MUD_BRICKS.get());
                        output.accept(ModBlocks.SOUL_MUD_BRICK_SLAB.get());
                        output.accept(ModBlocks.SOUL_MUD_BRICK_STAIRS.get());
                        output.accept(ModBlocks.SOUL_MUD_BRICK_WALL.get());

                        output.accept(ModBlocks.FIREBRICKS.get());
                        output.accept(ModBlocks.FIREBRICK_SLAB.get());
                        output.accept(ModBlocks.FIREBRICK_STAIRS.get());
                        output.accept(ModBlocks.FIREBRICK_WALL.get());

                        output.accept(ModBlocks.RAW_SILVER_BLOCK.get());
                        output.accept(ModBlocks.SILVER_BLOCK.get());
                        output.accept(ModBlocks.RAW_ALUMINUM_BLOCK.get());
                        output.accept(ModBlocks.ALUMINUM_BLOCK.get());
                        output.accept(ModBlocks.RAW_TIN_BLOCK.get());
                        output.accept(ModBlocks.TIN_BLOCK.get());
                        output.accept(ModBlocks.RAW_ZINC_BLOCK.get());
                        output.accept(ModBlocks.ZINC_BLOCK.get());
                        output.accept(ModBlocks.BRASS_BLOCK.get());
                        output.accept(ModBlocks.BRONZE_BLOCK.get());
                        output.accept(ModBlocks.ROSE_GOLD_BLOCK.get());
                        output.accept(ModBlocks.BRONZIUM_BLOCK.get());
                        output.accept(ModBlocks.GREEN_GOLD_BLOCK.get());
                        output.accept(ModBlocks.STEEL_BLOCK.get());
                        output.accept(ModBlocks.BLUE_GOLD_BLOCK.get());
                    }).build());

    public static void register(IEventBus eventBus){
        TABS.register(eventBus);
    }
}
