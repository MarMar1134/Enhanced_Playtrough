package net.marmar.enhanced_playthrough.item;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.entity.ModEntities;
import net.marmar.enhanced_playthrough.item.custom.tool.*;
import net.marmar.enhanced_playthrough.item.custom.weapon.ModTiers;
import net.marmar.enhanced_playthrough.block.ModBlocks;
import net.marmar.enhanced_playthrough.entity.boat.ModBoatEntity;
import net.marmar.enhanced_playthrough.item.custom.armor.ModArmorItem;
import net.marmar.enhanced_playthrough.item.custom.armor.ModArmorMaterial;
import net.marmar.enhanced_playthrough.item.custom.*;
import net.marmar.enhanced_playthrough.item.custom.weapon.DaggerItem;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(
            ForgeRegistries.ITEMS, EnhancedPlaythrough.MOD_ID
    );
    //Ores
        //raw
        public static final RegistryObject<Item> SULFUR = ITEMS.register(
                "sulfur",() -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> RAW_TIN = ITEMS.register(
                "raw_tin",() -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> RAW_ZINC = ITEMS.register(
                "raw_zinc",() -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> RAW_SILVER = ITEMS.register(
                "raw_silver", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> RAW_ALUMINUM = ITEMS.register(
                "raw_aluminum",() -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> RAW_RUBY = ITEMS.register(
                "raw_ruby", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> RAW_SAPPHIRE = ITEMS.register(
                "raw_sapphire", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> RAW_GARNET = ITEMS.register(
                "raw_garnet", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> RAW_EMERALD = ITEMS.register(
                "raw_emerald", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> RAW_DIAMOND = ITEMS.register(
                "raw_diamond", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> COBALT = ITEMS.register(
                "cobalt", () -> new Item(new Item.Properties()));

        //melted
        public static final RegistryObject<Item> COPPER_NUGGET = ITEMS.register(
                "copper_nugget", () -> new Item(new Item.Properties()));

        public static final RegistryObject<Item> TIN_INGOT = ITEMS.register(
                "tin_ingot",() -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> TIN_NUGGET = ITEMS.register(
                "tin_nugget", () -> new Item(new Item.Properties()));

        public static final RegistryObject<Item> ZINC_INGOT = ITEMS.register(
                "zinc_ingot",() -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> ZINC_NUGGET = ITEMS.register(
                "zinc_nugget", () -> new Item(new Item.Properties()));

        public static final RegistryObject<Item> BRONZE_INGOT = ITEMS.register(
                "bronze_ingot",() -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> BRONZE_NUGGET = ITEMS.register(
                "bronze_nugget", () -> new Item(new Item.Properties()));

        public static final RegistryObject<Item> BRASS_INGOT = ITEMS.register(
                "brass_ingot", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> BRASS_NUGGET = ITEMS.register(
                "brass_nugget", () -> new Item(new Item.Properties()));

        public static final RegistryObject<Item> BRONZIUM_INGOT = ITEMS.register(
                "bronzium_ingot",() -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> BRONZIUM_NUGGET = ITEMS.register(
                "bronzium_nugget", () -> new Item(new Item.Properties()));

        public static final RegistryObject<Item> STEEL_INGOT = ITEMS.register(
                "steel_ingot", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> STEEL_NUGGET = ITEMS.register(
                "steel_nugget", () -> new Item(new Item.Properties()));

        public static final RegistryObject<Item> SILVER_INGOT = ITEMS.register(
                "silver_ingot", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> SILVER_NUGGET = ITEMS.register(
                "silver_nugget", () -> new Item(new Item.Properties()));

        public static final RegistryObject<Item> ALUMINUM_INGOT = ITEMS.register(
                "aluminum_ingot", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> ALUMINUM_NUGGET = ITEMS.register(
                "aluminum_nugget", () -> new Item(new Item.Properties()));

        public static final RegistryObject<Item> ROSE_GOLD_INGOT = ITEMS.register(
                "rose_gold_ingot", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> ROSE_GOLD_NUGGET = ITEMS.register(
                "rose_gold_nugget", () -> new Item(new Item.Properties()));

        public static final RegistryObject<Item> GREEN_GOLD_INGOT = ITEMS.register(
                "green_gold_ingot", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> GREEN_GOLD_NUGGET = ITEMS.register(
                "green_gold_nugget", () -> new Item(new Item.Properties()));

        public static final RegistryObject<Item> BLUE_GOLD_INGOT = ITEMS.register(
                "blue_gold_ingot", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> BLUE_GOLD_NUGGET = ITEMS.register(
                "blue_gold_nugget", () -> new Item(new Item.Properties()));

        public static final RegistryObject<Item> RUBY = ITEMS.register(
                "ruby", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> SAPPHIRE = ITEMS.register(
                "sapphire", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> GARNET = ITEMS.register(
                "garnet", () -> new Item(new Item.Properties()));

        //Dust
        public static final RegistryObject<Item> GOLD_DUST = ITEMS.register(
                "gold_dust", ()-> new Item(new Item.Properties()));
        public static final RegistryObject<Item> SILVER_DUST = ITEMS.register(
                "silver_dust", ()-> new Item(new Item.Properties()));
        public static final RegistryObject<Item> ALUMINUM_DUST = ITEMS.register(
                "aluminum_dust", ()-> new Item(new Item.Properties()));
        public static final RegistryObject<Item> ZINC_DUST = ITEMS.register(
                "zinc_dust", ()-> new Item(new Item.Properties()));
        public static final RegistryObject<Item> TIN_DUST = ITEMS.register(
                "tin_dust", ()-> new Item(new Item.Properties()));
        public static final RegistryObject<Item> COPPER_DUST = ITEMS.register(
                "copper_dust", ()-> new Item(new Item.Properties()));
        public static final RegistryObject<Item> BRASS_DUST = ITEMS.register(
                "brass_dust", ()-> new Item(new Item.Properties()));
        public static final RegistryObject<Item> BRONZE_DUST = ITEMS.register(
                "bronze_dust", ()-> new Item(new Item.Properties()));
        public static final RegistryObject<Item> ROSE_GOLD_DUST = ITEMS.register(
                "rose_gold_dust", ()-> new Item(new Item.Properties()));
        public static final RegistryObject<Item> IRON_DUST = ITEMS.register(
                "iron_dust", ()-> new Item(new Item.Properties()));
        public static final RegistryObject<Item> BRONZIUM_DUST = ITEMS.register(
                "bronzium_dust", ()-> new Item(new Item.Properties()));
        public static final RegistryObject<Item> GREEN_GOLD_DUST = ITEMS.register(
                "green_gold_dust", ()-> new Item(new Item.Properties()));
        public static final RegistryObject<Item> STEEL_DUST = ITEMS.register(
                "steel_dust", ()-> new Item(new Item.Properties()));
        public static final RegistryObject<Item> BLUE_GOLD_DUST = ITEMS.register(
                "blue_gold_dust", ()-> new Item(new Item.Properties()));

    //Templates
    public static final RegistryObject<Item> BRONZIUM_SMITHING_UPGRADE_TEMPLATE = ITEMS.register(
            "bronzium_upgrade_smithing_template", ModSmithingTemplateItem::createBronziumSmithingTemplate);
    public static final RegistryObject<Item> ALUMINUM_SMITHING_UPGRADE_TEMPLATE = ITEMS.register(
            "aluminum_upgrade_smithing_template", ModSmithingTemplateItem::createAluminumSmithingUpgrade);

    //Cobble
    public static final RegistryObject<Item> COBBLE = ITEMS.register(
            "cobble", () -> new CobbleItem(new Item.Properties(), 2));
    public static final RegistryObject<Item> LIMESTONE_COBBLE = ITEMS.register(
            "limestone_cobble", () -> new CobbleItem(new Item.Properties(), 2));
    public static final RegistryObject<Item> DEEPSLATE_COBBLE = ITEMS.register(
            "deepslate_cobble", () -> new CobbleItem(new Item.Properties(), 4));
    public static final RegistryObject<Item> NETHERRACK_RUBBLE = ITEMS.register(
            "netherrack_rubble", () -> new CobbleItem(new Item.Properties(), 1));
    public static final RegistryObject<Item> BLACKSTONE_COBBLE = ITEMS.register(
            "black_cobble", () -> new CobbleItem(new Item.Properties(), 2));

    //Terracotta Shards
    public static final RegistryObject<Item> TERRACOTTA_SHARD = ITEMS.register(
            "terracotta_shard", () -> new CobbleItem(new Item.Properties(), 3));
    public static final RegistryObject<Item> WHITE_TERRACOTTA_SHARD = ITEMS.register(
            "white_terracotta_shard", () -> new CobbleItem(new Item.Properties(), 3));
    public static final RegistryObject<Item> ORANGE_TERRACOTTA_SHARD = ITEMS.register(
            "orange_terracotta_shard", () -> new CobbleItem(new Item.Properties(), 3));
    public static final RegistryObject<Item> MAGENTA_TERRACOTTA_SHARD = ITEMS.register(
            "magenta_terracotta_shard", () -> new CobbleItem(new Item.Properties(), 3));
    public static final RegistryObject<Item> LIGHT_BLUE_TERRACOTTA_SHARD = ITEMS.register(
            "light_blue_terracotta_shard", () -> new CobbleItem(new Item.Properties(), 3));
    public static final RegistryObject<Item> YELLOW_TERRACOTTA_SHARD = ITEMS.register(
            "yellow_terracotta_shard", () -> new CobbleItem(new Item.Properties(), 3));
    public static final RegistryObject<Item> LIME_TERRACOTTA_SHARD = ITEMS.register(
            "lime_terracotta_shard", () -> new CobbleItem(new Item.Properties(), 3));
    public static final RegistryObject<Item> PINK_TERRACOTTA_SHARD = ITEMS.register(
            "pink_terracotta_shard", () -> new CobbleItem(new Item.Properties(), 3));
    public static final RegistryObject<Item> GRAY_TERRACOTTA_SHARD = ITEMS.register(
            "gray_terracotta_shard", () -> new CobbleItem(new Item.Properties(), 3));
    public static final RegistryObject<Item> LIGHT_GRAY_TERRACOTTA_SHARD = ITEMS.register(
            "light_gray_terracotta_shard", () -> new CobbleItem(new Item.Properties(), 3));
    public static final RegistryObject<Item> CYAN_TERRACOTTA_SHARD = ITEMS.register(
            "cyan_terracotta_shard", () -> new CobbleItem(new Item.Properties(), 3));
    public static final RegistryObject<Item> PURPLE_TERRACOTTA_SHARD = ITEMS.register(
            "purple_terracotta_shard", () -> new CobbleItem(new Item.Properties(), 3));
    public static final RegistryObject<Item> BLUE_TERRACOTTA_SHARD = ITEMS.register(
            "blue_terracotta_shard", () -> new CobbleItem(new Item.Properties(), 3));
    public static final RegistryObject<Item> BROWN_TERRACOTTA_SHARD = ITEMS.register(
            "brown_terracotta_shard", () -> new CobbleItem(new Item.Properties(), 3));
    public static final RegistryObject<Item> GREEN_TERRACOTTA_SHARD = ITEMS.register(
            "green_terracotta_shard", () -> new CobbleItem(new Item.Properties(), 3));
    public static final RegistryObject<Item> RED_TERRACOTTA_SHARD = ITEMS.register(
            "red_terracotta_shard", () -> new CobbleItem(new Item.Properties(), 3));
    public static final RegistryObject<Item> BLACK_TERRACOTTA_SHARD = ITEMS.register(
            "black_terracotta_shard", () -> new CobbleItem(new Item.Properties(), 3));

    //Other materials
    public static final RegistryObject<Item> MUD_BRICK = ITEMS.register(
            "mud_brick", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> FIREBRICK = ITEMS.register(
            "firebrick", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ALUMINUM_ROD = ITEMS.register(
            "aluminum_rod", ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> VEGETABLE_FIBBER = ITEMS.register(
            "vegetable_fibber", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> REED_HEAD = ITEMS.register(
            "reeds_head", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> WATER_REED_HEAD = ITEMS.register(
            "water_reeds_head", () -> new Item(new Item.Properties()));

    //Spawn eggs
    public static final RegistryObject<Item> BANDIT_SPAWN_EGG = ITEMS.register(
            "bandit_spawn_egg", ()-> new ForgeSpawnEggItem(ModEntities.BANDIT, 1973532,
                    9343891, new Item.Properties()));

    //Signs
        //Walnut
        public static final RegistryObject<Item> WALNUT_SIGN = ITEMS.register(
                "walnut_sign", () -> new SignItem(new Item.Properties().stacksTo(16),
                        ModBlocks.WALNUT_SIGN.get(), ModBlocks.WALNUT_WALL_SIGN.get()));
        public static final RegistryObject<Item> WALNUT_HANGING_SIGN = ITEMS.register(
                "walnut_hanging_sign", () -> new HangingSignItem(ModBlocks.WALNUT_HANGING_SIGN.get(), ModBlocks.WALNUT_WALL_HANGING_SIGN.get(),
                        new Item.Properties().stacksTo(16)));

        //Apple
        public static final RegistryObject<Item> APPLE_SIGN = ITEMS.register(
                "apple_sign", () -> new SignItem(new Item.Properties().stacksTo(16),
                        ModBlocks.APPLE_SIGN.get(), ModBlocks.APPLE_WALL_SIGN.get()));
        public static final RegistryObject<Item> APPLE_HANGING_SIGN = ITEMS.register(
                "apple_hanging_sign", () -> new HangingSignItem(ModBlocks.APPLE_HANGING_SIGN.get(), ModBlocks.APPLE_WALL_HANGING_SIGN.get(),
                        new Item.Properties().stacksTo(16)));

        //Orange
        public static final RegistryObject<Item> ORANGE_SIGN = ITEMS.register(
                "orange_sign", () -> new SignItem(new Item.Properties().stacksTo(16),
                        ModBlocks.ORANGE_SIGN.get(), ModBlocks.ORANGE_WALL_SIGN.get()));
        public static final RegistryObject<Item> ORANGE_HANGING_SIGN = ITEMS.register(
                "orange_hanging_sign", () -> new HangingSignItem(ModBlocks.ORANGE_HANGING_SIGN.get(), ModBlocks.ORANGE_WALL_HANGING_SIGN.get(),
                        new Item.Properties().stacksTo(16)));

        //Lemon
        public static final RegistryObject<Item> LEMON_SIGN = ITEMS.register(
                "lemon_sign", () -> new SignItem(new Item.Properties().stacksTo(16),
                        ModBlocks.LEMON_SIGN.get(), ModBlocks.LEMON_WALL_SIGN.get()));
        public static final RegistryObject<Item> LEMON_HANGING_SIGN = ITEMS.register(
                "lemon_hanging_sign", () -> new HangingSignItem(ModBlocks.LEMON_HANGING_SIGN.get(), ModBlocks.LEMON_WALL_HANGING_SIGN.get(),
                        new Item.Properties().stacksTo(16)));

    //Boats
        //Walnut
        public static final RegistryObject<Item> WALNUT_BOAT = ITEMS.register("walnut_boat",
                () -> new ModBoatItem(false, ModBoatEntity.Type.WALNUT, new Item.Properties()));
        public static final RegistryObject<Item> WALNUT_CHEST_BOAT = ITEMS.register("walnut_chest_boat",
                () -> new ModBoatItem(true, ModBoatEntity.Type.WALNUT, new Item.Properties()));

        //Apple
        public static final RegistryObject<Item> APPLE_BOAT = ITEMS.register("apple_boat",
                () -> new ModBoatItem(false, ModBoatEntity.Type.APPLE, new Item.Properties()));
        public static final RegistryObject<Item> APPLE_CHEST_BOAT = ITEMS.register("apple_chest_boat",
                () -> new ModBoatItem(true, ModBoatEntity.Type.APPLE, new Item.Properties()));

        //Orange
        public static final RegistryObject<Item> ORANGE_BOAT = ITEMS.register("orange_boat",
                () -> new ModBoatItem(false, ModBoatEntity.Type.ORANGE, new Item.Properties()));
        public static final RegistryObject<Item> ORANGE_CHEST_BOAT = ITEMS.register("orange_chest_boat",
                () -> new ModBoatItem(true, ModBoatEntity.Type.ORANGE, new Item.Properties()));

        //Lemon
        public static final RegistryObject<Item> LEMON_BOAT = ITEMS.register("lemon_boat",
                () -> new ModBoatItem(false, ModBoatEntity.Type.LEMON, new Item.Properties()));
        public static final RegistryObject<Item> LEMON_CHEST_BOAT = ITEMS.register("lemon_chest_boat",
                () -> new ModBoatItem(true, ModBoatEntity.Type.LEMON, new Item.Properties()));

    //Weapons, tools and armors
        //Tools
        public static final RegistryObject<Item> FLINT_AND_COBBLE = ITEMS.register(
                "flint_and_cobble", ()-> new FlintAndSteelItem(new Item.Properties().defaultDurability(16)));
        public static final RegistryObject<Item> FLINT_AND_BRONZE = ITEMS.register(
                "flint_and_bronze", ()-> new FlintAndSteelItem(new Item.Properties().defaultDurability(32)));

        //Wood
        public static final RegistryObject<Item> WOODEN_DAGGER = ITEMS.register(
                "wooden_dagger", () ->  new DaggerItem(Tiers.WOOD, 1, 0.1f, new Item.Properties()));
            //Aluminum wood
            public static final RegistryObject<Item> ALUMINUM_WOODEN_SWORD = ITEMS.register(
                    "aluminum_wooden_sword", () -> new AluminumTools.Sword(Tiers.WOOD, new Item.Properties()));
            public static final RegistryObject<Item> ALUMINUM_WOODEN_DAGGER = ITEMS.register(
                    "aluminum_wooden_dagger", () -> new AluminumTools.Dagger(Tiers.WOOD, 1, 0.1f, new Item.Properties()));
            public static final RegistryObject<Item> ALUMINUM_WOODEN_PICKAXE = ITEMS.register(
                    "aluminum_wooden_pickaxe", () -> new AluminumTools.Pickaxe(Tiers.WOOD, new Item.Properties()));
            public static final RegistryObject<Item> ALUMINUM_WOODEN_AXE = ITEMS.register(
                    "aluminum_wooden_axe", () -> new AluminumTools.Axe(Tiers.WOOD, 6, -3.2f, new Item.Properties()));
            public static final RegistryObject<Item> ALUMINUM_WOODEN_SHOVEL = ITEMS.register(
                    "aluminum_wooden_shovel", () -> new AluminumTools.Shovel(Tiers.WOOD, new Item.Properties()));
            public static final RegistryObject<Item> ALUMINUM_WOODEN_HOE = ITEMS.register(
                    "aluminum_wooden_hoe", () -> new AluminumTools.Hoe(Tiers.WOOD, 0, -3.0f, new Item.Properties()));

        //Stone
        public static final RegistryObject<Item> STONE_POLISHER = ITEMS.register(
                "stone_polisher",() -> new PolisherItem(Tiers.STONE, new Item.Properties()));
        public static final RegistryObject<Item> STONE_DAGGER = ITEMS.register(
                "stone_dagger", () ->  new DaggerItem(Tiers.STONE, 1, 0.1f, new Item.Properties()));
            // Aluminum stone
            public static final RegistryObject<Item> ALUMINUM_STONE_SWORD = ITEMS.register(
                    "aluminum_stone_sword", () -> new AluminumTools.Sword(Tiers.STONE, new Item.Properties()));
            public static final RegistryObject<Item> ALUMINUM_STONE_DAGGER = ITEMS.register(
                    "aluminum_stone_dagger", () -> new AluminumTools.Dagger(Tiers.STONE, 1, 0.1f, new Item.Properties()));
            public static final RegistryObject<Item> ALUMINUM_STONE_PICKAXE = ITEMS.register(
                    "aluminum_stone_pickaxe", () -> new AluminumTools.Pickaxe(Tiers.STONE, new Item.Properties()));
            public static final RegistryObject<Item> ALUMINUM_STONE_AXE = ITEMS.register(
                    "aluminum_stone_axe", () -> new AluminumTools.Axe(Tiers.STONE, 7, -3.2f, new Item.Properties()));
            public static final RegistryObject<Item> ALUMINUM_STONE_SHOVEL = ITEMS.register(
                    "aluminum_stone_shovel", () -> new AluminumTools.Shovel(Tiers.STONE, new Item.Properties()));
            public static final RegistryObject<Item> ALUMINUM_STONE_HOE = ITEMS.register(
                    "aluminum_stone_hoe", () -> new AluminumTools.Hoe(Tiers.STONE, 0, -3.0f, new Item.Properties()));
            public static final RegistryObject<Item> ALUMINUM_STONE_POLISHER = ITEMS.register(
                    "aluminum_stone_polisher", () -> new AluminumTools.Polisher(Tiers.STONE, new Item.Properties()));

        //Gold
        public static final RegistryObject<Item> GOLDEN_POLISHER = ITEMS.register(
                "gold_polisher",() -> new PolisherItem(Tiers.GOLD, new Item.Properties()));
        public static final RegistryObject<Item> GOLDEN_DAGGER = ITEMS.register(
                "golden_dagger", () ->  new DaggerItem(Tiers.GOLD, 1, 0.25f, new Item.Properties()));
            // Aluminum gold
            public static final RegistryObject<Item> ALUMINUM_GOLDEN_SWORD = ITEMS.register(
                    "aluminum_golden_sword", () -> new AluminumTools.Sword(Tiers.GOLD, new Item.Properties()));
            public static final RegistryObject<Item> ALUMINUM_GOLDEN_DAGGER = ITEMS.register(
                    "aluminum_golden_dagger", () -> new AluminumTools.Dagger(Tiers.GOLD, 1, 0.25f, new Item.Properties()));
            public static final RegistryObject<Item> ALUMINUM_GOLDEN_PICKAXE = ITEMS.register(
                    "aluminum_golden_pickaxe", () -> new AluminumTools.Pickaxe(Tiers.GOLD, new Item.Properties()));
            public static final RegistryObject<Item> ALUMINUM_GOLDEN_AXE = ITEMS.register(
                    "aluminum_golden_axe", () -> new AluminumTools.Axe(Tiers.GOLD, 6, -2.4f, new Item.Properties()));
            public static final RegistryObject<Item> ALUMINUM_GOLDEN_SHOVEL = ITEMS.register(
                    "aluminum_golden_shovel", () -> new AluminumTools.Shovel(Tiers.GOLD, new Item.Properties()));
            public static final RegistryObject<Item> ALUMINUM_GOLDEN_HOE = ITEMS.register(
                    "aluminum_golden_hoe", () -> new AluminumTools.Hoe(Tiers.GOLD, 2, -2.4f, new Item.Properties()));
            public static final RegistryObject<Item> ALUMINUM_GOLDEN_POLISHER = ITEMS.register(
                    "aluminum_golden_polisher", () -> new AluminumTools.Polisher(Tiers.GOLD, new Item.Properties()));

        //Silver
        public static final RegistryObject<Item> SILVER_SWORD = ITEMS.register(
                "silver_sword",() -> new SwordItem(ModTiers.SILVER, 1, -2.4f, new Item.Properties()));
        public static final RegistryObject<Item> SILVER_DAGGER = ITEMS.register(
                "silver_dagger", () ->  new DaggerItem(ModTiers.SILVER, 1, 0.25f, new Item.Properties()));
        public static final RegistryObject<Item> SILVER_PICKAXE = ITEMS.register(
                "silver_pickaxe",() -> new PickaxeItem(ModTiers.SILVER, -2, -2.8f, new Item.Properties()));
        public static final RegistryObject<Item> SILVER_AXE = ITEMS.register(
                "silver_axe",() -> new AxeItem(ModTiers.SILVER, 6, -2.4f, new Item.Properties()));
        public static final RegistryObject<Item> SILVER_SHOVEL = ITEMS.register(
                "silver_shovel",() -> new ShovelItem(ModTiers.SILVER, 2, -2.4f, new Item.Properties()));
        public static final RegistryObject<Item> SILVER_HOE = ITEMS.register(
                "silver_hoe",() -> new HoeItem(ModTiers.SILVER, 2, -2.4f, new Item.Properties()));
        public static final RegistryObject<Item> SILVER_POLISHER = ITEMS.register(
                "silver_polisher",() -> new PolisherItem(ModTiers.SILVER, new Item.Properties()));
            //Aluminum silver
            public static final RegistryObject<Item> ALUMINUM_SILVER_SWORD = ITEMS.register(
                    "aluminum_silver_sword",() -> new AluminumTools.Sword(ModTiers.SILVER, new Item.Properties()));
            public static final RegistryObject<Item> ALUMINUM_SILVER_DAGGER = ITEMS.register(
                    "aluminum_silver_dagger", () -> new AluminumTools.Dagger(ModTiers.SILVER, 1, 0.25f, new Item.Properties()));
            public static final RegistryObject<Item> ALUMINUM_SILVER_PICKAXE = ITEMS.register(
                    "aluminum_silver_pickaxe",() -> new AluminumTools.Pickaxe(ModTiers.SILVER, new Item.Properties()));
            public static final RegistryObject<Item> ALUMINUM_SILVER_AXE = ITEMS.register(
                    "aluminum_silver_axe",() -> new AluminumTools.Axe(ModTiers.SILVER, 6, -2.4f, new Item.Properties()));
            public static final RegistryObject<Item> ALUMINUM_SILVER_SHOVEL = ITEMS.register(
                    "aluminum_silver_shovel",() -> new AluminumTools.Shovel(ModTiers.SILVER, new Item.Properties()));
            public static final RegistryObject<Item> ALUMINUM_SILVER_HOE = ITEMS.register(
                    "aluminum_silver_hoe",() -> new AluminumTools.Hoe(ModTiers.SILVER, 2, -2.4f, new Item.Properties()));
            public static final RegistryObject<Item> ALUMINUM_SILVER_POLISHER = ITEMS.register(
                    "aluminum_silver_polisher",() -> new AluminumTools.Polisher(ModTiers.SILVER, new Item.Properties()));

        public static final RegistryObject<Item> SILVER_HELMET = ITEMS.register(
                "silver_helmet", () -> new ModArmorItem(ModArmorMaterial.SILVER, ArmorItem.Type.HELMET, false, new Item.Properties()));
        public static final RegistryObject<Item> SILVER_CHESTPLATE = ITEMS.register(
                "silver_chestplate", () -> new ModArmorItem(ModArmorMaterial.SILVER, ArmorItem.Type.CHESTPLATE, false, new Item.Properties()));
        public static final RegistryObject<Item> SILVER_LEGGINGS = ITEMS.register(
                "silver_leggings", () -> new ModArmorItem(ModArmorMaterial.SILVER, ArmorItem.Type.LEGGINGS, false, new Item.Properties()));
        public static final RegistryObject<Item> SILVER_BOOTS = ITEMS.register(
                "silver_boots", () -> new ModArmorItem(ModArmorMaterial.SILVER, ArmorItem.Type.BOOTS, false, new Item.Properties()));

        //Bronze
        public static final RegistryObject<Item> BRONZE_SWORD = ITEMS.register(
                "bronze_sword",() -> new SwordItem(ModTiers.BRONZE, 2, -2.4F, new Item.Properties()));
        public static final RegistryObject<Item> BRONZE_DAGGER = ITEMS.register(
                "bronze_dagger", () ->  new DaggerItem(ModTiers.BRONZE, 1, 0.25f, new Item.Properties()));
        public static final RegistryObject<Item> BRONZE_PICKAXE = ITEMS.register(
                "bronze_pickaxe",() -> new PickaxeItem(ModTiers.BRONZE, 1, -2.8F,  new Item.Properties()));
        public static final RegistryObject<Item> BRONZE_AXE = ITEMS.register(
                "bronze_axe",() -> new AxeItem(ModTiers.BRONZE, 6, -2F,  new Item.Properties()));
        public static final RegistryObject<Item> BRONZE_SHOVEL = ITEMS.register(
                "bronze_shovel",() -> new ShovelItem(ModTiers.BRONZE, 1, -2F,  new Item.Properties()));
        public static final RegistryObject<Item> BRONZE_HOE = ITEMS.register(
                "bronze_hoe",() -> new HoeItem(ModTiers.BRONZE, 1, -2F,  new Item.Properties()));
        public static final RegistryObject<Item> BRONZE_POLISHER = ITEMS.register(
                "bronze_polisher",() -> new PolisherItem(ModTiers.BRONZE, new Item.Properties()));
            // Aluminum bronze
            public static final RegistryObject<Item> ALUMINUM_BRONZE_SWORD = ITEMS.register(
                    "aluminum_bronze_sword", () -> new AluminumTools.Sword(ModTiers.BRONZE, new Item.Properties()));
            public static final RegistryObject<Item> ALUMINUM_BRONZE_DAGGER = ITEMS.register(
                    "aluminum_bronze_dagger", () -> new AluminumTools.Dagger(ModTiers.BRONZE, 1, 0.25f, new Item.Properties()));
            public static final RegistryObject<Item> ALUMINUM_BRONZE_PICKAXE = ITEMS.register(
                    "aluminum_bronze_pickaxe", () -> new AluminumTools.Pickaxe(ModTiers.BRONZE, new Item.Properties()));
            public static final RegistryObject<Item> ALUMINUM_BRONZE_AXE = ITEMS.register(
                    "aluminum_bronze_axe", () -> new AluminumTools.Axe(ModTiers.BRONZE, 6, -2.0f, new Item.Properties()));
            public static final RegistryObject<Item> ALUMINUM_BRONZE_SHOVEL = ITEMS.register(
                    "aluminum_bronze_shovel", () -> new AluminumTools.Shovel(ModTiers.BRONZE, new Item.Properties()));
            public static final RegistryObject<Item> ALUMINUM_BRONZE_HOE = ITEMS.register(
                    "aluminum_bronze_hoe", () -> new AluminumTools.Hoe(ModTiers.BRONZE, 1, -2.0f, new Item.Properties()));
            public static final RegistryObject<Item> ALUMINUM_BRONZE_POLISHER = ITEMS.register(
                    "aluminum_bronze_polisher", () -> new AluminumTools.Polisher(ModTiers.BRONZE, new Item.Properties()));

         public static final RegistryObject<Item> BRONZE_HELMET = ITEMS.register(
                "bronze_helmet", () -> new ArmorItem(ModArmorMaterial.BRONZE, ArmorItem.Type.HELMET, new Item.Properties()));
        public static final RegistryObject<Item> BRONZE_CHESTPLATE = ITEMS.register(
                "bronze_chestplate", () -> new ArmorItem(ModArmorMaterial.BRONZE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
        public static final RegistryObject<Item> BRONZE_LEGGINGS = ITEMS.register(
                "bronze_leggings", () -> new ArmorItem(ModArmorMaterial.BRONZE, ArmorItem.Type.LEGGINGS, new Item.Properties()));
        public static final RegistryObject<Item> BRONZE_BOOTS = ITEMS.register(
                "bronze_boots", () -> new ArmorItem(ModArmorMaterial.BRONZE, ArmorItem.Type.BOOTS, new Item.Properties()));

        //Brass
        public static final RegistryObject<Item> BRASS_SWORD = ITEMS.register(
                "brass_sword",() -> new SwordItem(ModTiers.BRASS, 3, -2.4F, new Item.Properties()));
        public static final RegistryObject<Item> BRASS_DAGGER = ITEMS.register(
                "brass_dagger", () ->  new DaggerItem(ModTiers.BRASS, 2, 0.25f, new Item.Properties()));
        public static final RegistryObject<Item> BRASS_PICKAXE = ITEMS.register(
                "brass_pickaxe",() -> new PickaxeItem(ModTiers.BRASS, 1, -2.8F,  new Item.Properties()));
        public static final RegistryObject<Item> BRASS_AXE = ITEMS.register(
                "brass_axe",() -> new AxeItem(ModTiers.BRASS, 6, -2F,  new Item.Properties()));
        public static final RegistryObject<Item> BRASS_SHOVEL = ITEMS.register(
                "brass_shovel",() -> new ShovelItem(ModTiers.BRASS, 1, -2F,  new Item.Properties()));
        public static final RegistryObject<Item> BRASS_HOE = ITEMS.register(
                "brass_hoe",() -> new HoeItem(ModTiers.BRASS, 1, -2F,  new Item.Properties()));
        public static final RegistryObject<Item> BRASS_POLISHER = ITEMS.register(
                "brass_polisher",() -> new PolisherItem(ModTiers.BRASS, new Item.Properties()));
            // Aluminum brass
            public static final RegistryObject<Item> ALUMINUM_BRASS_SWORD = ITEMS.register(
                    "aluminum_brass_sword", () -> new AluminumTools.Sword(ModTiers.BRASS, new Item.Properties()));
            public static final RegistryObject<Item> ALUMINUM_BRASS_DAGGER = ITEMS.register(
                    "aluminum_brass_dagger", () -> new AluminumTools.Dagger(ModTiers.BRASS, 2, 0.25f, new Item.Properties()));
            public static final RegistryObject<Item> ALUMINUM_BRASS_PICKAXE = ITEMS.register(
                    "aluminum_brass_pickaxe", () -> new AluminumTools.Pickaxe(ModTiers.BRASS, new Item.Properties()));
            public static final RegistryObject<Item> ALUMINUM_BRASS_AXE = ITEMS.register(
                    "aluminum_brass_axe", () -> new AluminumTools.Axe(ModTiers.BRASS, 6, -2.0f, new Item.Properties()));
            public static final RegistryObject<Item> ALUMINUM_BRASS_SHOVEL = ITEMS.register(
                    "aluminum_brass_shovel", () -> new AluminumTools.Shovel(ModTiers.BRASS, new Item.Properties()));
            public static final RegistryObject<Item> ALUMINUM_BRASS_HOE = ITEMS.register(
                    "aluminum_brass_hoe", () -> new AluminumTools.Hoe(ModTiers.BRASS, 1, -2.0f, new Item.Properties()));
            public static final RegistryObject<Item> ALUMINUM_BRASS_POLISHER = ITEMS.register(
                    "aluminum_brass_polisher", () -> new AluminumTools.Polisher(ModTiers.BRASS, new Item.Properties()));

        public static final RegistryObject<Item> BRASS_HELMET = ITEMS.register(
                "brass_helmet", () -> new ArmorItem(ModArmorMaterial.BRASS, ArmorItem.Type.HELMET, new Item.Properties()));
        public static final RegistryObject<Item> BRASS_CHESTPLATE = ITEMS.register(
                "brass_chestplate", () -> new ArmorItem(ModArmorMaterial.BRASS, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
        public static final RegistryObject<Item> BRASS_LEGGINGS = ITEMS.register(
                "brass_leggings", () -> new ArmorItem(ModArmorMaterial.BRASS, ArmorItem.Type.LEGGINGS, new Item.Properties()));
        public static final RegistryObject<Item> BRASS_BOOTS = ITEMS.register(
                "brass_boots", () -> new ArmorItem(ModArmorMaterial.BRASS, ArmorItem.Type.BOOTS, new Item.Properties()));

        //Rose Gold
        public static final RegistryObject<Item> ROSE_GOLDEN_SWORD = ITEMS.register(
                "rose_golden_sword",() -> new SwordItem(ModTiers.ROSE_GOLD, 2, -2.4F, new Item.Properties()));
        public static final RegistryObject<Item> ROSE_GOLDEN_DAGGER = ITEMS.register(
                "rose_golden_dagger", () ->  new DaggerItem(ModTiers.ROSE_GOLD, 1, 0.25f, new Item.Properties()));
        public static final RegistryObject<Item> ROSE_GOLDEN_PICKAXE = ITEMS.register(
                "rose_golden_pickaxe",() -> new PickaxeItem(ModTiers.ROSE_GOLD, -2, -2.8F, new Item.Properties()));
        public static final RegistryObject<Item> ROSE_GOLDEN_AXE = ITEMS.register(
                "rose_golden_axe",() -> new AxeItem(ModTiers.ROSE_GOLD, 6, -2.4F, new Item.Properties()));
        public static final RegistryObject<Item> ROSE_GOLDEN_SHOVEL = ITEMS.register(
                "rose_golden_shovel",() -> new ShovelItem(ModTiers.ROSE_GOLD, 2, -2.4F, new Item.Properties()));
        public static final RegistryObject<Item> ROSE_GOLDEN_HOE = ITEMS.register(
                "rose_golden_hoe",() -> new HoeItem(ModTiers.ROSE_GOLD, 2, -2.4F, new Item.Properties()));
        public static final RegistryObject<Item> ROSE_GOLDEN_POLISHER = ITEMS.register(
                "rose_golden_polisher", () -> new PolisherItem(ModTiers.ROSE_GOLD, new Item.Properties()));
            // Aluminum rose gold
            public static final RegistryObject<Item> ALUMINUM_ROSE_GOLDEN_SWORD = ITEMS.register(
                    "aluminum_rose_golden_sword", () -> new AluminumTools.Sword(ModTiers.ROSE_GOLD, new Item.Properties()));
            public static final RegistryObject<Item> ALUMINUM_ROSE_GOLDEN_DAGGER = ITEMS.register(
                    "aluminum_rose_golden_dagger", () -> new AluminumTools.Dagger(ModTiers.ROSE_GOLD, 1, 0.25f, new Item.Properties()));
            public static final RegistryObject<Item> ALUMINUM_ROSE_GOLDEN_PICKAXE = ITEMS.register(
                    "aluminum_rose_golden_pickaxe", () -> new AluminumTools.Pickaxe(ModTiers.ROSE_GOLD, new Item.Properties()));
            public static final RegistryObject<Item> ALUMINUM_ROSE_GOLDEN_AXE = ITEMS.register(
                    "aluminum_rose_golden_axe", () -> new AluminumTools.Axe(ModTiers.ROSE_GOLD, 6, -2.4f, new Item.Properties()));
            public static final RegistryObject<Item> ALUMINUM_ROSE_GOLDEN_SHOVEL = ITEMS.register(
                    "aluminum_rose_golden_shovel", () -> new AluminumTools.Shovel(ModTiers.ROSE_GOLD, new Item.Properties()));
            public static final RegistryObject<Item> ALUMINUM_ROSE_GOLDEN_HOE = ITEMS.register(
                    "aluminum_rose_golden_hoe", () -> new AluminumTools.Hoe(ModTiers.ROSE_GOLD, 2, -2.4f, new Item.Properties()));
            public static final RegistryObject<Item> ALUMINUM_ROSE_GOLDEN_POLISHER = ITEMS.register(
                    "aluminum_rose_golden_polisher", () -> new AluminumTools.Polisher(ModTiers.ROSE_GOLD, new Item.Properties()));

        public static final RegistryObject<Item> ROSE_GOLDEN_HELMET = ITEMS.register(
                "rose_golden_helmet", () -> new ModArmorItem(ModArmorMaterial.ROSE_GOLD, ArmorItem.Type.HELMET, true, new Item.Properties()));
        public static final RegistryObject<Item> ROSE_GOLDEN_CHESTPLATE = ITEMS.register(
                "rose_golden_chestplate", () -> new ModArmorItem(ModArmorMaterial.ROSE_GOLD, ArmorItem.Type.CHESTPLATE, true, new Item.Properties()));
        public static final RegistryObject<Item> ROSE_GOLDEN_LEGGINGS = ITEMS.register(
                "rose_golden_leggings", () -> new ModArmorItem(ModArmorMaterial.ROSE_GOLD, ArmorItem.Type.LEGGINGS, true, new Item.Properties()));
        public static final RegistryObject<Item> ROSE_GOLDEN_BOOTS = ITEMS.register(
                "rose_golden_boots", () -> new ModArmorItem(ModArmorMaterial.ROSE_GOLD, ArmorItem.Type.BOOTS, true, new Item.Properties()));

        //Bronzium
        public static final RegistryObject<Item> BRONZIUM_SWORD = ITEMS.register(
                "bronzium_sword",() -> new SwordItem(ModTiers.BRONZIUM, 3, -2.4F, new Item.Properties()));
        public static final RegistryObject<Item> BRONZIUM_DAGGER = ITEMS.register(
                "bronzium_dagger", () ->  new DaggerItem(ModTiers.BRONZIUM, 1, 0.25f, new Item.Properties()));
        public static final RegistryObject<Item> BRONZIUM_PICKAXE = ITEMS.register(
                "bronzium_pickaxe",() -> new PickaxeItem(ModTiers.BRONZIUM, 1, -2.8F,  new Item.Properties()));
        public static final RegistryObject<Item> BRONZIUM_AXE = ITEMS.register(
                "bronzium_axe",() -> new AxeItem(ModTiers.BRONZIUM, 7, -2F,  new Item.Properties()));
        public static final RegistryObject<Item> BRONZIUM_SHOVEL = ITEMS.register(
                "bronzium_shovel",() -> new ShovelItem(ModTiers.BRONZIUM, 1, -2F,  new Item.Properties()));
        public static final RegistryObject<Item> BRONZIUM_HOE = ITEMS.register(
                "bronzium_hoe",() -> new HoeItem(ModTiers.BRONZIUM, 1, -2F,  new Item.Properties()));
        public static final RegistryObject<Item> BRONZIUM_POLISHER = ITEMS.register(
                "bronzium_polisher",() -> new PolisherItem(ModTiers.BRONZIUM, new Item.Properties()));
            // Aluminum bronzium
            public static final RegistryObject<Item> ALUMINUM_BRONZIUM_SWORD = ITEMS.register(
                    "aluminum_bronzium_sword", () -> new AluminumTools.Sword(ModTiers.BRONZIUM, new Item.Properties()));
            public static final RegistryObject<Item> ALUMINUM_BRONZIUM_DAGGER = ITEMS.register(
                    "aluminum_bronzium_dagger", () -> new AluminumTools.Dagger(ModTiers.BRONZIUM, 1, 0.25f, new Item.Properties()));
            public static final RegistryObject<Item> ALUMINUM_BRONZIUM_PICKAXE = ITEMS.register(
                    "aluminum_bronzium_pickaxe", () -> new AluminumTools.Pickaxe(ModTiers.BRONZIUM, new Item.Properties()));
            public static final RegistryObject<Item> ALUMINUM_BRONZIUM_AXE = ITEMS.register(
                    "aluminum_bronzium_axe", () -> new AluminumTools.Axe(ModTiers.BRONZIUM, 7, -2.0f, new Item.Properties()));
            public static final RegistryObject<Item> ALUMINUM_BRONZIUM_SHOVEL = ITEMS.register(
                    "aluminum_bronzium_shovel", () -> new AluminumTools.Shovel(ModTiers.BRONZIUM, new Item.Properties()));
            public static final RegistryObject<Item> ALUMINUM_BRONZIUM_HOE = ITEMS.register(
                    "aluminum_bronzium_hoe", () -> new AluminumTools.Hoe(ModTiers.BRONZIUM, 1, -2.0f, new Item.Properties()));
            public static final RegistryObject<Item> ALUMINUM_BRONZIUM_POLISHER = ITEMS.register(
                    "aluminum_bronzium_polisher", () -> new AluminumTools.Polisher(ModTiers.BRONZIUM, new Item.Properties()));

        public static final RegistryObject<Item> BRONZIUM_HELMET = ITEMS.register(
                "bronzium_helmet", () -> new ModArmorItem(ModArmorMaterial.BRONZIUM, ArmorItem.Type.HELMET, false, new Item.Properties()));
        public static final RegistryObject<Item> BRONZIUM_CHESTPLATE = ITEMS.register(
                "bronzium_chestplate", () -> new ModArmorItem(ModArmorMaterial.BRONZIUM, ArmorItem.Type.CHESTPLATE, false, new Item.Properties()));
        public static final RegistryObject<Item> BRONZIUM_LEGGINGS = ITEMS.register(
                "bronzium_leggings", () -> new ModArmorItem(ModArmorMaterial.BRONZIUM, ArmorItem.Type.LEGGINGS, false, new Item.Properties()));
        public static final RegistryObject<Item> BRONZIUM_BOOTS = ITEMS.register(
                "bronzium_boots", () -> new ModArmorItem(ModArmorMaterial.BRONZIUM, ArmorItem.Type.BOOTS, false, new Item.Properties()));

        //Iron
        public static final RegistryObject<Item> IRON_POLISHER = ITEMS.register(
                "iron_polisher",() -> new PolisherItem(Tiers.IRON, new Item.Properties()));
        public static final RegistryObject<Item> IRON_DAGGER = ITEMS.register(
                "iron_dagger", () ->  new DaggerItem(Tiers.IRON, 2, 0.25f, new Item.Properties()));
            // Aluminum iron
            public static final RegistryObject<Item> ALUMINUM_IRON_SWORD = ITEMS.register(
                    "aluminum_iron_sword", () -> new AluminumTools.Sword(Tiers.IRON, new Item.Properties()));
            public static final RegistryObject<Item> ALUMINUM_IRON_DAGGER = ITEMS.register(
                    "aluminum_iron_dagger", () -> new AluminumTools.Dagger(Tiers.IRON, 1, 0.2f, new Item.Properties()));
            public static final RegistryObject<Item> ALUMINUM_IRON_PICKAXE = ITEMS.register(
                    "aluminum_iron_pickaxe", () -> new AluminumTools.Pickaxe(Tiers.IRON, new Item.Properties()));
            public static final RegistryObject<Item> ALUMINUM_IRON_AXE = ITEMS.register(
                    "aluminum_iron_axe", () -> new AluminumTools.Axe(Tiers.IRON, 6, -2.6f, new Item.Properties()));
            public static final RegistryObject<Item> ALUMINUM_IRON_SHOVEL = ITEMS.register(
                    "aluminum_iron_shovel", () -> new AluminumTools.Shovel(Tiers.IRON, new Item.Properties()));
            public static final RegistryObject<Item> ALUMINUM_IRON_HOE = ITEMS.register(
                    "aluminum_iron_hoe", () -> new AluminumTools.Hoe(Tiers.IRON, 0, -3.0f, new Item.Properties()));
            public static final RegistryObject<Item> ALUMINUM_IRON_POLISHER = ITEMS.register(
                    "aluminum_iron_polisher", () -> new AluminumTools.Polisher(Tiers.IRON, new Item.Properties()));

        //Steel
        public static final RegistryObject<Item> STEEL_SWORD = ITEMS.register(
                "steel_sword",() -> new SwordItem(ModTiers.STEEL, 2, -2.4F, new Item.Properties()));
        public static final RegistryObject<Item> STEEL_DAGGER = ITEMS.register(
                "steel_dagger", () ->  new DaggerItem(ModTiers.STEEL, 1, 0.3f, new Item.Properties()));
        public static final RegistryObject<Item> STEEL_PICKAXE = ITEMS.register(
                "steel_pickaxe",() -> new PickaxeItem(ModTiers.STEEL, 0, -2.8F, new Item.Properties()));
        public static final RegistryObject<Item> STEEL_AXE = ITEMS.register(
                "steel_axe",() -> new AxeItem(ModTiers.STEEL, 4, -2F,  new Item.Properties()));
        public static final RegistryObject<Item> STEEL_SHOVEL = ITEMS.register(
                "steel_shovel",() -> new ShovelItem(ModTiers.STEEL, 1, -2F,  new Item.Properties()));
        public static final RegistryObject<Item> STEEL_HOE = ITEMS.register(
                "steel_hoe",() -> new HoeItem(ModTiers.STEEL, 1, -2F,  new Item.Properties()));
        public static final RegistryObject<Item> STEEL_POLISHER = ITEMS.register(
            "steel_polisher",() -> new PolisherItem(ModTiers.STEEL, new Item.Properties()));
            // Aluminum steel
            public static final RegistryObject<Item> ALUMINUM_STEEL_SWORD = ITEMS.register(
                    "aluminum_steel_sword", () -> new AluminumTools.Sword(ModTiers.STEEL, new Item.Properties()));
            public static final RegistryObject<Item> ALUMINUM_STEEL_DAGGER = ITEMS.register(
                    "aluminum_steel_dagger", () -> new AluminumTools.Dagger(ModTiers.STEEL, 2, 0.3f, new Item.Properties()));
            public static final RegistryObject<Item> ALUMINUM_STEEL_PICKAXE = ITEMS.register(
                    "aluminum_steel_pickaxe", () -> new AluminumTools.Pickaxe(ModTiers.STEEL, new Item.Properties()));
            public static final RegistryObject<Item> ALUMINUM_STEEL_AXE = ITEMS.register(
                    "aluminum_steel_axe", () -> new AluminumTools.Axe(ModTiers.STEEL, 7, -2.0f, new Item.Properties()));
            public static final RegistryObject<Item> ALUMINUM_STEEL_SHOVEL = ITEMS.register(
                    "aluminum_steel_shovel", () -> new AluminumTools.Shovel(ModTiers.STEEL, new Item.Properties()));
            public static final RegistryObject<Item> ALUMINUM_STEEL_HOE = ITEMS.register(
                    "aluminum_steel_hoe", () -> new AluminumTools.Hoe(ModTiers.STEEL, 1, -2.0f, new Item.Properties()));
            public static final RegistryObject<Item> ALUMINUM_STEEL_POLISHER = ITEMS.register(
                    "aluminum_steel_polisher", () -> new AluminumTools.Polisher(ModTiers.STEEL, new Item.Properties()));

        public static final RegistryObject<Item> STEEL_HELMET = ITEMS.register(
            "steel_helmet", () -> new ArmorItem(ModArmorMaterial.STEEL, ArmorItem.Type.HELMET, new Item.Properties()));
        public static final RegistryObject<Item> STEEL_CHESTPLATE = ITEMS.register(
            "steel_chestplate", () -> new ArmorItem(ModArmorMaterial.STEEL, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
        public static final RegistryObject<Item> STEEL_LEGGINGS = ITEMS.register(
            "steel_leggings", () -> new ArmorItem(ModArmorMaterial.STEEL, ArmorItem.Type.LEGGINGS, new Item.Properties()));
        public static final RegistryObject<Item> STEEL_BOOTS = ITEMS.register(
            "steel_boots", () -> new ArmorItem(ModArmorMaterial.STEEL, ArmorItem.Type.BOOTS, new Item.Properties()));

        //Green Gold
        public static final RegistryObject<Item> GREEN_GOLDEN_SWORD = ITEMS.register(
                "green_golden_sword",() -> new SwordItem(ModTiers.GREEN_GOLD, 2, -2.4F, new Item.Properties()));
        public static final RegistryObject<Item> GREEN_GOLDEN_DAGGER = ITEMS.register(
                "green_golden_dagger", () ->  new DaggerItem(ModTiers.GREEN_GOLD, 1, 0.25f, new Item.Properties()));
        public static final RegistryObject<Item> GREEN_GOLDEN_PICKAXE = ITEMS.register(
                "green_golden_pickaxe",() -> new PickaxeItem(ModTiers.GREEN_GOLD, -2, -2.8F, new Item.Properties()));
        public static final RegistryObject<Item> GREEN_GOLDEN_AXE = ITEMS.register(
                "green_golden_axe",() -> new AxeItem(ModTiers.GREEN_GOLD, 6, -2.4F, new Item.Properties()));
        public static final RegistryObject<Item> GREEN_GOLDEN_SHOVEL = ITEMS.register(
                "green_golden_shovel",() -> new ShovelItem(ModTiers.GREEN_GOLD, 2, -2.4F, new Item.Properties()));
        public static final RegistryObject<Item> GREEN_GOLDEN_HOE = ITEMS.register(
                "green_golden_hoe",() -> new HoeItem(ModTiers.GREEN_GOLD, 2, -2.4F, new Item.Properties()));
        public static final RegistryObject<Item> GREEN_GOLDEN_POLISHER = ITEMS.register(
                "green_golden_polisher", () -> new PolisherItem(ModTiers.GREEN_GOLD, new Item.Properties()));
            // Aluminum green gold
            public static final RegistryObject<Item> ALUMINUM_GREEN_GOLDEN_SWORD = ITEMS.register(
                    "aluminum_green_golden_sword", () -> new AluminumTools.Sword(ModTiers.GREEN_GOLD, new Item.Properties()));
            public static final RegistryObject<Item> ALUMINUM_GREEN_GOLDEN_DAGGER = ITEMS.register(
                    "aluminum_green_golden_dagger", () -> new AluminumTools.Dagger(ModTiers.GREEN_GOLD, 1, 0.25f, new Item.Properties()));
            public static final RegistryObject<Item> ALUMINUM_GREEN_GOLDEN_PICKAXE = ITEMS.register(
                    "aluminum_green_golden_pickaxe", () -> new AluminumTools.Pickaxe(ModTiers.GREEN_GOLD, new Item.Properties()));
            public static final RegistryObject<Item> ALUMINUM_GREEN_GOLDEN_AXE = ITEMS.register(
                    "aluminum_green_golden_axe", () -> new AluminumTools.Axe(ModTiers.GREEN_GOLD, 6, -2.4f, new Item.Properties()));
            public static final RegistryObject<Item> ALUMINUM_GREEN_GOLDEN_SHOVEL = ITEMS.register(
                    "aluminum_green_golden_shovel", () -> new AluminumTools.Shovel(ModTiers.GREEN_GOLD, new Item.Properties()));
            public static final RegistryObject<Item> ALUMINUM_GREEN_GOLDEN_HOE = ITEMS.register(
                    "aluminum_green_golden_hoe", () -> new AluminumTools.Hoe(ModTiers.GREEN_GOLD, 2, -2.4f, new Item.Properties()));
            public static final RegistryObject<Item> ALUMINUM_GREEN_GOLDEN_POLISHER = ITEMS.register(
                    "aluminum_green_golden_polisher", () -> new AluminumTools.Polisher(ModTiers.GREEN_GOLD, new Item.Properties()));

        public static final RegistryObject<Item> GREEN_GOLDEN_HELMET = ITEMS.register(
                "green_golden_helmet", () -> new ModArmorItem(ModArmorMaterial.GREEN_GOLD, ArmorItem.Type.HELMET, true, new Item.Properties()));
        public static final RegistryObject<Item> GREEN_GOLDEN_CHESTPLATE = ITEMS.register(
                "green_golden_chestplate", () -> new ModArmorItem(ModArmorMaterial.GREEN_GOLD, ArmorItem.Type.CHESTPLATE, true, new Item.Properties()));
        public static final RegistryObject<Item> GREEN_GOLDEN_LEGGINGS = ITEMS.register(
                "green_golden_leggings", () -> new ModArmorItem(ModArmorMaterial.GREEN_GOLD, ArmorItem.Type.LEGGINGS, true, new Item.Properties()));
        public static final RegistryObject<Item> GREEN_GOLDEN_BOOTS = ITEMS.register(
                "green_golden_boots", () -> new ModArmorItem(ModArmorMaterial.GREEN_GOLD, ArmorItem.Type.BOOTS, true, new Item.Properties()));

        //Blue gold
        public static final RegistryObject<Item> BLUE_GOLDEN_SWORD = ITEMS.register(
                "blue_golden_sword",() -> new SwordItem(ModTiers.BLUE_GOLD, 3, -2.4F, new Item.Properties()));
        public static final RegistryObject<Item> BLUE_GOLDEN_DAGGER = ITEMS.register(
                "blue_golden_dagger", () ->  new DaggerItem(ModTiers.BLUE_GOLD, 2, 0.3f, new Item.Properties()));
        public static final RegistryObject<Item> BLUE_GOLDEN_PICKAXE = ITEMS.register(
                "blue_golden_pickaxe",() -> new PickaxeItem(ModTiers.BLUE_GOLD, -2, -2.8F, new Item.Properties()));
        public static final RegistryObject<Item> BLUE_GOLDEN_AXE = ITEMS.register(
                "blue_golden_axe",() -> new AxeItem(ModTiers.BLUE_GOLD, 4, -2.4F, new Item.Properties()));
        public static final RegistryObject<Item> BLUE_GOLDEN_SHOVEL = ITEMS.register(
                "blue_golden_shovel",() -> new ShovelItem(ModTiers.BLUE_GOLD, -2, -2.4F, new Item.Properties()));
        public static final RegistryObject<Item> BLUE_GOLDEN_HOE = ITEMS.register(
                "blue_golden_hoe",() -> new HoeItem(ModTiers.BLUE_GOLD, -2, -2.4F, new Item.Properties()));
        public static final RegistryObject<Item> BLUE_GOLDEN_POLISHER = ITEMS.register(
                "blue_golden_polisher", () -> new PolisherItem(ModTiers.BLUE_GOLD, new Item.Properties()));
            // Aluminum blue gold
            public static final RegistryObject<Item> ALUMINUM_BLUE_GOLDEN_SWORD = ITEMS.register(
                    "aluminum_blue_golden_sword", () -> new AluminumTools.Sword(ModTiers.BLUE_GOLD, new Item.Properties()));
            public static final RegistryObject<Item> ALUMINUM_BLUE_GOLDEN_DAGGER = ITEMS.register(
                    "aluminum_blue_golden_dagger", () -> new AluminumTools.Dagger(ModTiers.BLUE_GOLD, 1, 0.25f, new Item.Properties()));
            public static final RegistryObject<Item> ALUMINUM_BLUE_GOLDEN_PICKAXE = ITEMS.register(
                    "aluminum_blue_golden_pickaxe", () -> new AluminumTools.Pickaxe(ModTiers.BLUE_GOLD, new Item.Properties()));
            public static final RegistryObject<Item> ALUMINUM_BLUE_GOLDEN_AXE = ITEMS.register(
                    "aluminum_blue_golden_axe", () -> new AluminumTools.Axe(ModTiers.BLUE_GOLD, 6, -2.4f, new Item.Properties()));
            public static final RegistryObject<Item> ALUMINUM_BLUE_GOLDEN_SHOVEL = ITEMS.register(
                    "aluminum_blue_golden_shovel", () -> new AluminumTools.Shovel(ModTiers.BLUE_GOLD, new Item.Properties()));
            public static final RegistryObject<Item> ALUMINUM_BLUE_GOLDEN_HOE = ITEMS.register(
                    "aluminum_blue_golden_hoe", () -> new AluminumTools.Hoe(ModTiers.BLUE_GOLD, 2, -2.4f, new Item.Properties()));
            public static final RegistryObject<Item> ALUMINUM_BLUE_GOLDEN_POLISHER = ITEMS.register(
                    "aluminum_blue_golden_polisher", () -> new AluminumTools.Polisher(ModTiers.BLUE_GOLD, new Item.Properties()));

        public static final RegistryObject<Item> BLUE_GOLDEN_HELMET = ITEMS.register(
                "blue_golden_helmet", () -> new ModArmorItem(ModArmorMaterial.BLUE_GOLD, ArmorItem.Type.HELMET, true, new Item.Properties()));
        public static final RegistryObject<Item> BLUE_GOLDEN_CHESTPLATE = ITEMS.register(
                "blue_golden_chestplate", () -> new ModArmorItem(ModArmorMaterial.BLUE_GOLD, ArmorItem.Type.CHESTPLATE, true, new Item.Properties()));
        public static final RegistryObject<Item> BLUE_GOLDEN_LEGGINGS = ITEMS.register(
                "blue_golden_leggings", () -> new ModArmorItem(ModArmorMaterial.BLUE_GOLD, ArmorItem.Type.LEGGINGS, true, new Item.Properties()));
        public static final RegistryObject<Item> BLUE_GOLDEN_BOOTS = ITEMS.register(
                "blue_golden_boots", () -> new ModArmorItem(ModArmorMaterial.BLUE_GOLD, ArmorItem.Type.BOOTS, true, new Item.Properties()));

        //Diamond
        public static final RegistryObject<Item> DIAMOND_POLISHER = ITEMS.register(
                "diamond_polisher",() -> new PolisherItem(Tiers.DIAMOND, new Item.Properties()));
        public static final RegistryObject<Item> DIAMOND_DAGGER = ITEMS.register(
                "diamond_dagger", () ->  new DaggerItem(Tiers.DIAMOND, 2, 0.3f, new Item.Properties()));
            // Aluminum diamond
            public static final RegistryObject<Item> ALUMINUM_DIAMOND_SWORD = ITEMS.register(
                    "aluminum_diamond_sword", () -> new AluminumTools.Sword(Tiers.DIAMOND, new Item.Properties()));
            public static final RegistryObject<Item> ALUMINUM_DIAMOND_DAGGER = ITEMS.register(
                    "aluminum_diamond_dagger", () -> new AluminumTools.Dagger(Tiers.DIAMOND, 2, 0.3f, new Item.Properties()));
            public static final RegistryObject<Item> ALUMINUM_DIAMOND_PICKAXE = ITEMS.register(
                    "aluminum_diamond_pickaxe", () -> new AluminumTools.Pickaxe(Tiers.DIAMOND, new Item.Properties()));
            public static final RegistryObject<Item> ALUMINUM_DIAMOND_AXE = ITEMS.register(
                    "aluminum_diamond_axe", () -> new AluminumTools.Axe(Tiers.DIAMOND, 5, -2.8f, new Item.Properties()));
            public static final RegistryObject<Item> ALUMINUM_DIAMOND_SHOVEL = ITEMS.register(
                    "aluminum_diamond_shovel", () -> new AluminumTools.Shovel(Tiers.DIAMOND, new Item.Properties()));
            public static final RegistryObject<Item> ALUMINUM_DIAMOND_HOE = ITEMS.register(
                    "aluminum_diamond_hoe", () -> new AluminumTools.Hoe(Tiers.DIAMOND, 0, -3.0f, new Item.Properties()));
            public static final RegistryObject<Item> ALUMINUM_DIAMOND_POLISHER = ITEMS.register(
                    "aluminum_diamond_polisher", () -> new AluminumTools.Polisher(Tiers.DIAMOND, new Item.Properties()));

        //Netherite
        public static final RegistryObject<Item> NETHERITE_POLISHER = ITEMS.register(
                "netherite_polisher",() -> new PolisherItem(Tiers.NETHERITE, new Item.Properties()));
        public static final RegistryObject<Item> NETHERITE_DAGGER = ITEMS.register(
                "netherite_dagger", () ->  new DaggerItem(Tiers.NETHERITE, 2, 0.3f, new Item.Properties()));

    //Plants
    public static final RegistryObject<Item> YERBA_MATE = ITEMS.register(
            "yerba_mate", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GROUNDED_YERBA_MATE = ITEMS.register(
            "grounded_yerba_mate", () -> new Item(new Item.Properties()));

    //Food
        //Flour
        public static final RegistryObject<Item> WHEAT_FLOUR = ITEMS.register(
                "wheat_flour",() -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> PUMPKIN_FLOUR = ITEMS.register(
                "pumpkin_flour",() -> new Item(new Item.Properties()));

        //Seeds
        public static final RegistryObject<Item> YERBA_MATE_SEEDS = ITEMS.register(
                "yerba_mate_seeds",() -> new ItemNameBlockItem(ModBlocks.YERBA_MATE_CROP.get(), new Item.Properties()));
        public static final RegistryObject<Item> ZAPALLO_SEEDS = ITEMS.register(
                "zapallo_seeds",() -> new ItemNameBlockItem(ModBlocks.ZAPALLO_CROP.get(), new Item.Properties()));
        public static final RegistryObject<Item> EGGPLANT_SEEDS = ITEMS.register(
                "eggplant_seeds",() -> new ItemNameBlockItem(ModBlocks.EGGPLANT_CROP.get(), new Item.Properties()));
        public static final RegistryObject<Item> TOMATO_SEEDS = ITEMS.register(
                "tomato_seeds", () -> new ItemNameBlockItem(ModBlocks.TOMATO_CROP.get(), new Item.Properties()));
        public static final RegistryObject<Item> CORN_SEEDS = ITEMS.register(
                "corn_seeds", () -> new ItemNameBlockItem(ModBlocks.CORN_CROP.get(), new Item.Properties()));

        //Wild food
        public static final RegistryObject<Item> WILD_TOMATO = ITEMS.register(
                "wild_tomato",() -> new Item(new Item.Properties().food(ModFoodPropieties.WILD_TOMATO)));
        public static final RegistryObject<Item> WILD_CORN = ITEMS.register(
                "wild_corn",() -> new Item(new Item.Properties().food(ModFoodPropieties.WILD_CORN)));

        //Fruit
        public static final RegistryObject<Item> ORANGE = ITEMS.register(
                "orange",() -> new Item(new Item.Properties().food(ModFoodPropieties.ORANGE)));
        public static final RegistryObject<Item> LEMON = ITEMS.register(
                "lemon",() -> new Item(new Item.Properties().food(ModFoodPropieties.LEMON)));
        public static final RegistryObject<Item> LIME = ITEMS.register(
                "lime",() -> new Item(new Item.Properties().food(ModFoodPropieties.LIME)));
        public static final RegistryObject<Item> GREEN_APPLE = ITEMS.register(
                "green_apple",() -> new Item(new Item.Properties().food(ModFoodPropieties.GREEN_APPLE)));
        public static final RegistryObject<Item> TOMATO = ITEMS.register(
                "tomato",() -> new Item(new Item.Properties().food(ModFoodPropieties.TOMATO)));
        public static final RegistryObject<Item> WALNUT = ITEMS.register(
                "walnut",() -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> PEELED_WALNUT = ITEMS.register(
                "peeled_walnut",() -> new Item(new Item.Properties().food(ModFoodPropieties.PEELED_WALNUT)));

        //Vegetables
        public static final RegistryObject<Item> RICE_GRAINS = ITEMS.register(
                "rice_grains", () -> new Item((new Item.Properties().food(ModFoodPropieties.RICE))));
        public static final RegistryObject<Item> ZAPALLO = ITEMS.register(
                "zapallo", () -> new Item((new Item.Properties().food(ModFoodPropieties.ZAPALLO))));
        public static final RegistryObject<Item> EGGPLANT = ITEMS.register(
                "eggplant", () -> new Item((new Item.Properties().food(ModFoodPropieties.EGGPLANT))));
        public static final RegistryObject<Item> CORN = ITEMS.register(
                "corn", () -> new Item((new Item.Properties().food(ModFoodPropieties.CORN))));

        //Fungi
        public static final RegistryObject<Item> YEAST = ITEMS.register(
                "yeast",() -> new Item(new Item.Properties()));

        //Cooked food
        public static final RegistryObject<Item> RICE_BOWL = ITEMS.register(
                "rice_bowl",() -> new Item(new Item.Properties().food(ModFoodPropieties.RICE_BOWL)));
        public static final RegistryObject<Item> COOKED_ZAPALLO = ITEMS.register(
                "cooked_zapallo", () -> new Item((new Item.Properties().food(ModFoodPropieties.COOKED_ZAPALLO))));
        public static final RegistryObject<Item> COOKED_EGGPLANT = ITEMS.register(
                "cooked_eggplant", () -> new Item((new Item.Properties().food(ModFoodPropieties.COOKED_EGGPLANT))));
        public static final RegistryObject<Item> COOKED_CORN = ITEMS.register(
                "cooked_corn", () -> new Item((new Item.Properties().food(ModFoodPropieties.COOKED_CORN))));
        public static final RegistryObject<Item> EMPTY_MATE = ITEMS.register(
                "empty_mate",() -> new Item(new Item.Properties().stacksTo(1)));
        public static final RegistryObject<Item> MATE = ITEMS.register(
                "mate",() -> new MateItem(new Item.Properties().stacksTo(1).food(ModFoodPropieties.MATE)));

    //Final register
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
