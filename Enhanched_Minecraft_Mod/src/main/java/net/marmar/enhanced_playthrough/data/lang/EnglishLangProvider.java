package net.marmar.enhanced_playthrough.data.lang;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.block.EPBlocks;
import net.marmar.enhanced_playthrough.util.enchantment.EPEnchantments;
import net.marmar.enhanced_playthrough.item.EPItems;
import net.minecraft.data.PackOutput;

public class EnglishLangProvider extends AbstractLangProvider {
    public EnglishLangProvider(PackOutput output) {
        super(output, "en_us");
    }

    @Override
    protected void addTranslations() {
        //Creative tabs
        addCreativeTab("weapons", "Combat");
        addCreativeTab("tools", "Tools");
        addCreativeTab("aluminum_tools", "Aluminum tools");
        addCreativeTab("minerals", "Ores and minerals");
        addCreativeTab("jewelery", "Jewelery");
        addCreativeTab("utility", "Utility");
        addCreativeTab("fruits", "Fruits and vegetables");
        addCreativeTab("saplings", "Seeds and saplings");
        addCreativeTab("woodtypes", "Wood");
        addCreativeTab("blocks", "Blocks");
        addCreativeTab("utility_blocks", "Functional blocks");

        //JEI
        addJeiCategory("adobe_furnace", "Basic smelting");
        addJeiCategory("soul_furnace", "Soul basic smelting");
        addJeiCategory("masonry_furnace", "Masonry furnace");
        addJeiCategory("adobe_alloying_furnace", "Alloying");
        addJeiCategory("super_alloying_furnace", "Blast alloying");
        addJeiCategory("gem_polisher", "Gem polishing");
        addJeiCategory("primal_grinder", "Basic grinding");
        addJeiCategory("mechanical_grinder", "Mechanical grinding");

        //Jade
        addJadeConfigTranslation("basic_furnace", "Basic furnace");

        addJadeConfigTranslation("alloy_furnace", "Alloy furnace");

        addJadeConfigTranslation("masonry_furnace", "Masonry furnace");

        addJadeConfigTranslation("gem_polisher", "Gem polisher");
        this.add("jade." + EnhancedPlaythrough.MOD_ID + ".gem_polisher_uses", "Uses left: %d");

        addJadeConfigTranslation("grinder", "Grinder");

        //GUI elements
        addGuiElements("gem_polisher_screen", "Uses");

        //Descriptions
        addDescription("aluminum_tool", "Aluminum handle: 20% more durability");
        addDescription("polisher_item","Used on the Gem polisher as fuel");
        addDescription("silver_armor", "When full equipped: gives Haste to the player");
        addDescription("rose_gold_armor", "When full equipped: gives Haste to the player");
        addDescription("bronzium_armor", "When full equipped: gives Fire Resistance to the player");
        addDescription("green_gold_armor", "When full equipped: gives Haste II to the player");
        addDescription("blue_gold_armor", "When full equipped: gives Haste II to the player");
        addDescription("dagger_bleed", "Bleed probability: ");

        //Sounds
        addSoundDescription("grind", "Active grinder");

        //Death messages
        addDeathMessages("tallReed", "was poked to death by a giant reed",
                "was poked to death by a giant reed whilst trying to escape");
        addDeathMessages("cobble", "died from a piece of cobble to the head",
                "died from a piece of cobble to the head thrown by");
        addDeathMessages("bleed", "bleed to death", "bleed to dead whilst escaping from");

        //Mob effects
        addMobEffect("bleeding", "Bleeding");
        addMobEffect("frostbite", "Frostbite");

        //Advancements
            //Survival
            addSurvivalAdvancement("root", "Enhanced Playthrough",
                    "You started a new journey on this fantastic world, welcome!");
            addSurvivalAdvancement("stone_age", "A cobbled business",
                    "Get a piece of cobble");
            addSurvivalAdvancement("unity_makes_strength", "Unity makes strength",
                    "Craft an alloy furnace");
            addSurvivalAdvancement("blossom", "Blossom",
                    "Alloy some gold with copper to get rose gold");
            addSurvivalAdvancement("buttercup", "Buttercup",
                    "Alloy some gold with silver to get green gold");
            addSurvivalAdvancement("bubbles", "Bubbles",
                    "Alloy some gold with cobalt to get blue gold");
            addSurvivalAdvancement( "the_goldenpuff_girls", "The Goldenpuff Girls",
                    "Get the three gold alloys");

            addSurvivalAdvancement( "thats_new", "That´s... new",
                    "Get a bronze ingot");
            addSurvivalAdvancement( "abrassive_heat", "Plato, the blacksmith",
                    "Get a brass ingot");
            addSurvivalAdvancement("abrass_your_soul", "Abrass your soul",
                    "Get a full brass armor");
            addSurvivalAdvancement("mighty_bronze", "Mighty bronze",
                    "Craft a bronze pickaxe");
            addSurvivalAdvancement( "steel_isnt_enough", "Steel isn´t enough",
                    "Use your alloy furnace to get some steel");
            addSurvivalAdvancement("the_aluminated", "The aluminated",
                    "Get an aluminum ingot");

            //Gems
            addGemAdvancement("root", "The colors of the world",
                    "The world is full of colors, do you want to discover all of them?");
            addGemAdvancement("polish_emerald", "Greedy green",
                    "Get some emeralds and take care of hers");
            addGemAdvancement("polish_sapphire", "Blue storm",
                    "Get some sapphires, and go look close to the sea");
            addGemAdvancement("polish_ruby", "Angry, but not a bird",
                    "Get some rubies and be careful with the pigs");
            addGemAdvancement( "polish_garnet", "The color of my heart",
                    "Get some garnets and show your passion");
            addGemAdvancement("polish_diamond", "Are you here, Lucy?",
                    "Get some diamonds and look to the sky");
            addGemAdvancement("get_all_gems", "Chaos everywhere",
                    "Collect all the gems and become the lord of chaos");

            //Flowers
            addGemAdvancement("first_flower", "The root of all",
                    "Get your first flower");
            addGemAdvancement("all_small_flowers", "David",
                    "Get all the small flowers");
            addGemAdvancement("all_tall_flowers", "Goliat",
                    "Get all the tall flowers");
            addGemAdvancement("all_flowers", "The apothecary diaries",
                    "Get all the flowers");

        //Entities
        addBoatEntity("Boat");
        addChestBoatEntity("Boat with chest");
        addThrowableCobbleEntity("Cobble");

        //Blocks
            //Wild crops
            addBlock(EPBlocks.WILD_WHEAT_CROP, "Wild wheat");
            addBlock(EPBlocks.WILD_TOMATO_CROP, "Wild tomato");
            addBlock(EPBlocks.WILD_CORN_CROP, "Wild corn");

            //Plants
            addBlock(EPBlocks.TALL_REEDS, "Gigant reed");
            addBlock(EPBlocks.REEDS, "Pampas grass");
            addBlock(EPBlocks.SMALL_REEDS, "Andean pampas grass");
            addBlock(EPBlocks.WATER_REEDS, "Reed");

            //Flowers
            addBlock(EPBlocks.COLD_LYRIUM, "Cold lyrium");
            addBlock(EPBlocks.SUCCULENT, "Succulent");

            //Wood
                //Apple
                addBlock(EPBlocks.APPLE_SAPLING, "Apple sapling");
                addBlock(EPBlocks.APPLE_LEAVES, "Apple leaves");
                addBlock(EPBlocks.APPLE_LOG, "Apple log");
                addBlock(EPBlocks.STRIPPED_APPLE_LOG, "Stripped apple log");
                addBlock(EPBlocks.APPLE_WOOD, "Apple wood");
                addBlock(EPBlocks.STRIPPED_APPLE_WOOD, "Stripped apple wood");
                addBlock(EPBlocks.APPLE_PLANKS, "Apple planks");
                addBlock(EPBlocks.APPLE_SLAB, "Apple slab");
                addBlock(EPBlocks.APPLE_STAIRS, "Apple stairs");
                addBlock(EPBlocks.APPLE_FENCE, "Apple fence");
                addBlock(EPBlocks.APPLE_FENCEGATE, "Apple fence gate");
                addBlock(EPBlocks.APPLE_DOOR, "Apple door");
                addBlock(EPBlocks.APPLE_TRAPDOOR, "Apple trapdoor");
                addBlock(EPBlocks.APPLE_BUTTON, "Apple button");
                addBlock(EPBlocks.APPLE_PRESSURE_PLATE, "Apple pressure plate");
                addSign(EPItems.APPLE_SIGN, "Apple sign");
                addHangingSign(EPItems.APPLE_HANGING_SIGN, "Hanging apple sign");
                addItem(EPItems.APPLE_BOAT, "Apple boat");
                addItem(EPItems.APPLE_CHEST_BOAT, "Apple boat with chest");

                //Green apple
                addBlock(EPBlocks.GREEN_APPLE_SAPLING, "Green apple sapling");
                addBlock(EPBlocks.GREEN_APPLE_LEAVES, "Green apple leaves");

                //Walnut
                addBlock(EPBlocks.WALNUT_SAPLING, "Walnut sapling");
                addBlock(EPBlocks.WALNUT_LEAVES, "Walnut leaves");
                addBlock(EPBlocks.WALNUT_LOG, "Walnut log");
                addBlock(EPBlocks.STRIPPED_WALNUT_LOG, "Stripped walnut log");
                addBlock(EPBlocks.WALNUT_WOOD, "Walnut wood");
                addBlock(EPBlocks.STRIPPED_WALNUT_WOOD, "Stripped walnut wood");
                addBlock(EPBlocks.WALNUT_PLANKS, "Walnut planks");
                addBlock(EPBlocks.WALNUT_SLAB, "Walnut slab");
                addBlock(EPBlocks.WALNUT_STAIRS, "Walnut stairs");
                addBlock(EPBlocks.WALNUT_FENCE, "Walnut fence");
                addBlock(EPBlocks.WALNUT_FENCEGATE, "Walnut fence gate");
                addBlock(EPBlocks.WALNUT_DOOR, "Walnut door");
                addBlock(EPBlocks.WALNUT_TRAPDOOR, "Walnut trapdoor");
                addBlock(EPBlocks.WALNUT_BUTTON, "Walnut button");
                addBlock(EPBlocks.WALNUT_PRESSURE_PLATE, "Walnut pressure plate");
                addSign(EPItems.WALNUT_SIGN, "Walnut sign");
                addHangingSign(EPItems.WALNUT_HANGING_SIGN, "Hanging walnut sign");
                addItem(EPItems.WALNUT_BOAT, "Walnut boat");
                addItem(EPItems.WALNUT_CHEST_BOAT, "Walnut boat with chest");

                //Orange
                addBlock(EPBlocks.ORANGE_SAPLING, "Orange sapling");
                addBlock(EPBlocks.ORANGE_LEAVES, "Orange leaves");
                addBlock(EPBlocks.ORANGE_LOG, "Orange log");
                addBlock(EPBlocks.STRIPPED_ORANGE_LOG, "Stripped orange log");
                addBlock(EPBlocks.ORANGE_WOOD, "Orange wood");
                addBlock(EPBlocks.STRIPPED_ORANGE_WOOD, "Stripped orange wood");
                addBlock(EPBlocks.ORANGE_PLANKS, "Orange planks");
                addBlock(EPBlocks.ORANGE_SLAB, "Orange slab");
                addBlock(EPBlocks.ORANGE_STAIRS, "Orange stairs");
                addBlock(EPBlocks.ORANGE_FENCE, "Orange fence");
                addBlock(EPBlocks.ORANGE_FENCEGATE, "Orange fence gate");
                addBlock(EPBlocks.ORANGE_DOOR, "Orange door");
                addBlock(EPBlocks.ORANGE_TRAPDOOR, "Orange trapdoor");
                addBlock(EPBlocks.ORANGE_BUTTON, "Orange button");
                addBlock(EPBlocks.ORANGE_PRESSURE_PLATE, "Orange pressure plate");
                addSign(EPItems.ORANGE_SIGN, "Orange sign");
                addHangingSign(EPItems.ORANGE_HANGING_SIGN, "Hanging orange sign");
                addItem(EPItems.ORANGE_BOAT, "Orange boat");
                addItem(EPItems.ORANGE_CHEST_BOAT, "Orange boat with chest");

                //Lemon
                addBlock(EPBlocks.LEMON_SAPLING, "Lemon sapling");
                addBlock(EPBlocks.LEMON_LEAVES, "Lemon leaves");
                addBlock(EPBlocks.LEMON_LOG, "Lemon log");
                addBlock(EPBlocks.STRIPPED_LEMON_LOG, "Stripped lemon log");
                addBlock(EPBlocks.LEMON_WOOD, "Orange wood");
                addBlock(EPBlocks.STRIPPED_LEMON_WOOD, "Stripped lemon wood");
                addBlock(EPBlocks.LEMON_PLANKS, "Lemon planks");
                addBlock(EPBlocks.LEMON_SLAB, "Lemon slab");
                addBlock(EPBlocks.LEMON_STAIRS, "Lemon stairs");
                addBlock(EPBlocks.LEMON_FENCE, "Lemon fence");
                addBlock(EPBlocks.LEMON_FENCEGATE, "Lemon fence gate");
                addBlock(EPBlocks.LEMON_DOOR, "Lemon door");
                addBlock(EPBlocks.LEMON_TRAPDOOR, "Lemon trapdoor");
                addBlock(EPBlocks.LEMON_BUTTON, "Lemon button");
                addBlock(EPBlocks.LEMON_PRESSURE_PLATE, "Lemon pressure plate");
                addSign(EPItems.LEMON_SIGN, "Lemon sign");
                addHangingSign(EPItems.LEMON_HANGING_SIGN, "Hanging lemon sign");
                addItem(EPItems.LEMON_BOAT, "Lemon boat");
                addItem(EPItems.LEMON_CHEST_BOAT, "Lemon boat with chest");

                //Lime
                addBlock(EPBlocks.LIME_SAPLING, "Lime sapling");
                addBlock(EPBlocks.LIME_LEAVES, "Lime leaves");

            //Polished stone
            addBlock(EPBlocks.POLISHED_STONE, "Polished stone");
            addBlock(EPBlocks.POLISHED_STONE_SLAB, "Polished stone slab");
            addBlock(EPBlocks.POLISHED_STONE_STAIRS, "Polished stone stairs");
            addBlock(EPBlocks.POLISHED_STONE_WALL, "Polished stone wall");

            //Cobbled limestone
            addBlock(EPBlocks.COBBLED_LIMESTONE, "Cobbled limestone");
            addBlock(EPBlocks.COBBLED_LIMESTONE_SLAB, "Cobbled limestone slab");
            addBlock(EPBlocks.COBBLED_LIMESTONE_STAIRS, "Cobbled limestone stairs");
            addBlock(EPBlocks.COBBLED_LIMESTONE_WALL, "Cobbled limestone wall");

            //Limestone
            addBlock(EPBlocks.LIMESTONE, "Limestone");
            addBlock(EPBlocks.LIMESTONE_SLAB, "Limestone slab");
            addBlock(EPBlocks.LIMESTONE_STAIRS, "Limestone stairs");
            addBlock(EPBlocks.LIMESTONE_WALL, "Limestone wall");

            //Polished limestone
            addBlock(EPBlocks.POLISHED_LIMESTONE, "Polished limestone");
            addBlock(EPBlocks.POLISHED_LIMESTONE_SLAB, "Polished limestone slab");
            addBlock(EPBlocks.POLISHED_LIMESTONE_STAIRS, "Polished limestone stairs");
            addBlock(EPBlocks.POLISHED_LIMESTONE_WALL, "Polished limestone wall");

            //Limestone bricks
            addBlock(EPBlocks.LIMESTONE_BRICKS, "Limestone bricks");
            addBlock(EPBlocks.LIMESTONE_BRICK_SLAB, "Limestone bricks slab");
            addBlock(EPBlocks.LIMESTONE_BRICK_STAIRS, "Limestone bricks stairs");
            addBlock(EPBlocks.LIMESTONE_BRICK_WALL, "Limestone bricks wall");

            //Soul
            addBlock(EPBlocks.SOUL_MUD, "Soul mud");
            addBlock(EPBlocks.SOUL_MUD_BRICKS, "Soul mud bricks");
            addBlock(EPBlocks.SOUL_MUD_BRICK_SLAB, "Soul mud brick slab");
            addBlock(EPBlocks.SOUL_MUD_BRICK_STAIRS, "Soul mud brick stairs");
            addBlock(EPBlocks.SOUL_MUD_BRICK_WALL, "Soul mud brick wall");

        //Firebricks
        addBlock(EPBlocks.FIREBRICKS, "Firebricks");
        addBlock(EPBlocks.FIREBRICK_SLAB, "Firebrick slab");
        addBlock(EPBlocks.FIREBRICK_STAIRS, "Firebrick stairs");
        addBlock(EPBlocks.FIREBRICK_WALL, "Firebrick wall");

            //Ores
            addBlock(EPBlocks.TIN_ORE, "Tin ore");
            addBlock(EPBlocks.DEEPSLATE_TIN_ORE, "Deepslate tin ore");
            addBlock(EPBlocks.ZINC_ORE, "Zinc ore");
            addBlock(EPBlocks.DEEPSLATE_ZINC_ORE, "Deepslate zinc ore");
            addBlock(EPBlocks.NETHER_ZINC_ORE, "Nether zinc ore");
            addBlock(EPBlocks.NETHER_COPPER_ORE, "Nether copper ore");
            addBlock(EPBlocks.SULFUR_ORE, "Sulfur ore");
            addBlock(EPBlocks.DEEPSLATE_SULFUR_ORE, "Deepslate sulfur ore");
            addBlock(EPBlocks.NETHER_SULFUR_ORE, "Nether sulfur ore");
            addBlock(EPBlocks.SILVER_ORE, "Silver ore");
            addBlock(EPBlocks.DEEPSLATE_SILVER_ORE, "Deepslate silver ore");
            addBlock(EPBlocks.SAPPHIRE_ORE, "Sapphire ore");
            addBlock(EPBlocks.DEEPSLATE_SAPPHIRE_ORE, "Deepslate sapphire ore");
            addBlock(EPBlocks.RUBY_ORE, "Ruby ore");
            addBlock(EPBlocks.DEEPSLATE_RUBY_ORE, "Deepslate ruby ore");
            addBlock(EPBlocks.NETHER_GARNET_ORE, "Nether garnet ore");
            addBlock(EPBlocks.COBALT_ORE, "Cobalt ore");
            addBlock(EPBlocks.DEEPSLATE_COBALT_ORE, "Deepslate cobalt ore");
            addBlock(EPBlocks.BAUXITE, "Bauxite");
            addBlock(EPBlocks.WHITE_BAUXITE, "White bauxite");
            addBlock(EPBlocks.LIGHT_GRAY_BAUXITE, "Light gray bauxite");
            addBlock(EPBlocks.BROWN_BAUXITE, "Brown bauxite");
            addBlock(EPBlocks.RED_BAUXITE, "Red bauxite");
            addBlock(EPBlocks.ORANGE_BAUXITE, "Orange bauxite");
            addBlock(EPBlocks.YELLOW_BAUXITE, "Yellow bauxite");

            //Ore blocks
            addBlock(EPBlocks.RAW_TIN_BLOCK, "Block of raw tin");
            addBlock(EPBlocks.TIN_BLOCK, "Block of tin");
            addBlock(EPBlocks.RAW_ZINC_BLOCK, "Block of raw zinc");
            addBlock(EPBlocks.ZINC_BLOCK, "Block of zinc");
            addBlock(EPBlocks.RAW_SILVER_BLOCK, "block of raw silver");
            addBlock(EPBlocks.SILVER_BLOCK, "Block of silver");
            addBlock(EPBlocks.RAW_ALUMINUM_BLOCK, "Block of raw aluminum");
            addBlock(EPBlocks.ALUMINUM_BLOCK, "Block of aluminum");
            addBlock(EPBlocks.BRASS_BLOCK, "Block of brass");
            addBlock(EPBlocks.BRONZE_BLOCK, "Block of bronze");
            addBlock(EPBlocks.ROSE_GOLD_BLOCK, "Block of rose gold");
            addBlock(EPBlocks.BRONZIUM_BLOCK, "Block of bronzium");
            addBlock(EPBlocks.GREEN_GOLD_BLOCK, "Block of green gold");
            addBlock(EPBlocks.STEEL_BLOCK, "Block of steel");
            addBlock(EPBlocks.BLUE_GOLD_BLOCK, "Block of blue gold");

            //Block entities
            addBlock(EPBlocks.ADOBE_FURNACE, "Mud furnace");
            addBlock(EPBlocks.SOUL_FURNACE, "Soul mud furnace");
            addBlock(EPBlocks.MASONRY_FURNACE, "Masonry furnace");
            addBlock(EPBlocks.ADOBE_ALLOY_FURNACE, "Bricks alloy furnace");
            addBlock(EPBlocks.SOUL_ALLOY_FURNACE, "Soul bricks alloy furnace");
            addBlock(EPBlocks.SUPER_ALLOY_FURNACE, "Blast alloy furnace");
            addBlock(EPBlocks.GEM_POLISHER, "Gem polisher");
            addBlock(EPBlocks.PRIMAL_GRINDER, "Grinder");
            addBlock(EPBlocks.MECHANICAL_GRINDER, "Mechanical grinder");

        //Items
            //Raw ores
            addItem(EPItems.RAW_TIN, "Raw tin");
            addItem(EPItems.RAW_ZINC, "Raw zinc");
            addItem(EPItems.RAW_SILVER, "Raw silver");
            addItem(EPItems.RAW_ALUMINUM, "Raw aluminum");
            addItem(EPItems.RAW_EMERALD, "Unpolished emerald");
            addItem(EPItems.RAW_SAPPHIRE, "Unpolished sapphire");
            addItem(EPItems.RAW_RUBY, "Unpolished ruby");
            addItem(EPItems.RAW_GARNET, "Unpolished garnet");
            addItem(EPItems.RAW_DIAMOND, "Unpolished diamond");

            //Materials and melted ores
            addItem(EPItems.TIN_INGOT, "Tin ingot");
            addItem(EPItems.TIN_NUGGET, "Tin nugget");
            addItem(EPItems.ZINC_INGOT, "Zinc ingot");
            addItem(EPItems.ZINC_NUGGET, "Zinc nugget");
            addItem(EPItems.SULFUR, "Sulfur");
            addItem(EPItems.SILVER_INGOT, "Silver ingot");
            addItem(EPItems.SILVER_NUGGET, "Silver nugget");
            addItem(EPItems.ALUMINUM_INGOT, "Aluminum ingot");
            addItem(EPItems.ALUMINUM_NUGGET, "Aluminum nugget");
            addItem(EPItems.COPPER_NUGGET, "Copper nugget");
            addItem(EPItems.BRASS_INGOT, "Brass ingot");
            addItem(EPItems.BRASS_NUGGET, "Brass nugget");
            addItem(EPItems.BRONZE_INGOT, "Bronze ingot");
            addItem(EPItems.BRONZE_NUGGET, "Bronze nugget");
            addItem(EPItems.ROSE_GOLD_INGOT, "Rose gold ingot");
            addItem(EPItems.ROSE_GOLD_NUGGET, "Rose gold nugget");
            addItem(EPItems.BRONZIUM_INGOT, "Bronzium ingot");
            addItem(EPItems.BRONZIUM_NUGGET, "Bronzium nugget");
            addItem(EPItems.GREEN_GOLD_INGOT, "Green gold ingot");
            addItem(EPItems.GREEN_GOLD_NUGGET, "Green gold nugget");
            addItem(EPItems.STEEL_INGOT, "Steel ingot");
            addItem(EPItems.STEEL_NUGGET, "Steel nugget");
            addItem(EPItems.BLUE_GOLD_INGOT, "Blue gold ingot");
            addItem(EPItems.BLUE_GOLD_NUGGET, "Blue gold nugget");
            addItem(EPItems.SAPPHIRE, "Sapphire");
            addItem(EPItems.RUBY, "Ruby");
            addItem(EPItems.GARNET, "Garnet");

            //Others
            addItem(EPItems.MUD_BRICK, "Mud brick");
            addItem(EPItems.FIREBRICK, "Firebrick");
            addItem(EPItems.ALUMINUM_ROD, "Aluminum rod");
            addItem(EPItems.COBALT, "Cobalt");
            addItem(EPItems.REEDS_HEAD, "Pampas grass head");
            addItem(EPItems.TALL_REEDS_HEAD, "tall reed head");
            addItem(EPItems.WATER_REEDS_HEAD, "Reed head");
            addItem(EPItems.VEGETABLE_FIBBER, "Vegetable fiber");

            //Cobble
            addItem(EPItems.COBBLE, "Cobble");
            addItem(EPItems.LIMESTONE_COBBLE, "Limestone cobble");
            addItem(EPItems.DEEPSLATE_COBBLE, "Deepslate cobble");
            addItem(EPItems.NETHERRACK_RUBBLE, "Netherrack rubble");
            addItem(EPItems.BLACKSTONE_COBBLE, "Blackstone cobble");

            //Terracotta shards
            addItem(EPItems.TERRACOTTA_SHARD, "Terracotta shard");
            addItem(EPItems.WHITE_TERRACOTTA_SHARD, "White terracotta shard");
            addItem(EPItems.ORANGE_TERRACOTTA_SHARD, "Orange terracotta shard");
            addItem(EPItems.MAGENTA_TERRACOTTA_SHARD, "Magenta terracotta shard");
            addItem(EPItems.LIGHT_BLUE_TERRACOTTA_SHARD, "Light blue terracotta shard");
            addItem(EPItems.YELLOW_TERRACOTTA_SHARD, "Yellow terracotta shard");
            addItem(EPItems.LIME_TERRACOTTA_SHARD, "Lime terracotta shard");
            addItem(EPItems.PINK_TERRACOTTA_SHARD, "Pink terracotta shard");
            addItem(EPItems.GRAY_TERRACOTTA_SHARD, "Gray terracotta shard");
            addItem(EPItems.LIGHT_GRAY_TERRACOTTA_SHARD, "Light gray terracotta shard");
            addItem(EPItems.CYAN_TERRACOTTA_SHARD, "Cyan terracotta shard");
            addItem(EPItems.PURPLE_TERRACOTTA_SHARD, "Purple terracotta shard");
            addItem(EPItems.BLUE_TERRACOTTA_SHARD, "Blue terracotta shard");
            addItem(EPItems.BROWN_TERRACOTTA_SHARD, "Brown terracotta shard");
            addItem(EPItems.GREEN_TERRACOTTA_SHARD, "Green terracotta shard");
            addItem(EPItems.RED_TERRACOTTA_SHARD, "Red terracotta shard");
            addItem(EPItems.BLACK_TERRACOTTA_SHARD, "Black terracotta shard");

            //Dusts
            addItem(EPItems.GOLD_DUST, "Gold dust");
            addItem(EPItems.SILVER_DUST, "Silver dust");
            addItem(EPItems.ALUMINUM_DUST, "Aluminum dust");
            addItem(EPItems.ZINC_DUST, "Zinc dust");
            addItem(EPItems.TIN_DUST, "Tin dust");
            addItem(EPItems.COPPER_DUST, "Copper dust");
            addItem(EPItems.BRASS_DUST, "Brass dust");
            addItem(EPItems.BRONZE_DUST, "Bronze dust");
            addItem(EPItems.ROSE_GOLD_DUST, "Rose gold dust");
            addItem(EPItems.IRON_DUST, "Iron dust");
            addItem(EPItems.BRONZIUM_DUST, "Bronzium dust");
            addItem(EPItems.GREEN_GOLD_DUST, "Green gold dust");
            addItem(EPItems.STEEL_DUST, "Steel dust");
            addItem(EPItems.BLUE_GOLD_DUST, "Blue gold dust");

            //Acids and potions
            addAcid("sulfuric_acid", "Sulfuric acid");

        //Other tools
        addItem(EPItems.FLINT_AND_COBBLE, "Flint & cobble");
        addItem(EPItems.FLINT_AND_BRONZE, "Flint & bronze");

            //Silver equipment
            addItem(EPItems.SILVER_SWORD, "Silver sword");
            addItem(EPItems.SILVER_DAGGER, "Silver dagger");
            addItem(EPItems.SILVER_PICKAXE, "Silver pickaxe");
            addItem(EPItems.SILVER_AXE, "Silver axe");
            addItem(EPItems.SILVER_SHOVEL, "Silver shovel");
            addItem(EPItems.SILVER_HOE, "Silver hoe");
            addItem(EPItems.SILVER_POLISHER, "Silver polisher");
            addItem(EPItems.SILVER_HELMET, "Silver helmet");
            addItem(EPItems.SILVER_CHESTPLATE, "Silver chestplate");
            addItem(EPItems.SILVER_LEGGINGS, "Silver leggings");
            addItem(EPItems.SILVER_BOOTS, "Silver boots");

            addItem(EPItems.ALUMINUM_SILVER_SWORD, "Silver Sword");
            addItem(EPItems.ALUMINUM_SILVER_DAGGER, "Silver Dagger");
            addItem(EPItems.ALUMINUM_SILVER_PICKAXE, "Silver Pickaxe");
            addItem(EPItems.ALUMINUM_SILVER_AXE, "Silver Axe");
            addItem(EPItems.ALUMINUM_SILVER_SHOVEL, "Silver Shovel");
            addItem(EPItems.ALUMINUM_SILVER_HOE, "Silver Hoe");
            addItem(EPItems.ALUMINUM_SILVER_POLISHER, "Silver Polisher");

            //Gold equipment
            addItem(EPItems.GOLDEN_POLISHER, "Golden polisher");
            addItem(EPItems.GOLDEN_DAGGER, "Golden dagger");

            addItem(EPItems.ALUMINUM_GOLDEN_SWORD, "Golden Sword");
            addItem(EPItems.ALUMINUM_GOLDEN_DAGGER, "Golden Dagger");
            addItem(EPItems.ALUMINUM_GOLDEN_PICKAXE, "Golden Pickaxe");
            addItem(EPItems.ALUMINUM_GOLDEN_AXE, "Golden Axe");
            addItem(EPItems.ALUMINUM_GOLDEN_SHOVEL, "Golden Shovel");
            addItem(EPItems.ALUMINUM_GOLDEN_HOE, "Golden Hoe");
            addItem(EPItems.ALUMINUM_GOLDEN_POLISHER, "Golden Polisher");

            //Wood equipment
            addItem(EPItems.WOODEN_DAGGER, "Wooden dagger");

            addItem(EPItems.ALUMINUM_WOODEN_SWORD, "Wooden Sword");
            addItem(EPItems.ALUMINUM_WOODEN_DAGGER, "Wooden Dagger");
            addItem(EPItems.ALUMINUM_WOODEN_PICKAXE, "Wooden Pickaxe");
            addItem(EPItems.ALUMINUM_WOODEN_AXE, "Wooden Axe");
            addItem(EPItems.ALUMINUM_WOODEN_SHOVEL, "Wooden Shovel");
            addItem(EPItems.ALUMINUM_WOODEN_HOE, "Wooden Hoe");

            //Stone equipment
            addItem(EPItems.STONE_POLISHER, "Stone polisher");
            addItem(EPItems.STONE_DAGGER, "Stone dagger");

            addItem(EPItems.ALUMINUM_STONE_SWORD, "Stone Sword");
            addItem(EPItems.ALUMINUM_STONE_DAGGER, "Stone Dagger");
            addItem(EPItems.ALUMINUM_STONE_PICKAXE, "Stone Pickaxe");
            addItem(EPItems.ALUMINUM_STONE_AXE, "Stone Axe");
            addItem(EPItems.ALUMINUM_STONE_SHOVEL, "Stone Shovel");
            addItem(EPItems.ALUMINUM_STONE_HOE, "Stone Hoe");
            addItem(EPItems.ALUMINUM_STONE_POLISHER, "Stone Polisher");

            //Brass equipment
            addItem(EPItems.BRASS_SWORD, "Brass sword");
            addItem(EPItems.BRASS_DAGGER, "Brass dagger");
            addItem(EPItems.BRASS_PICKAXE, "Brass pickaxe");
            addItem(EPItems.BRASS_AXE, "Brass axe");
            addItem(EPItems.BRASS_SHOVEL, "Brass shovel");
            addItem(EPItems.BRASS_HOE, "Brass hoe");
            addItem(EPItems.BRASS_POLISHER, "Brass polisher");
            addItem(EPItems.BRASS_HELMET, "Brass helmet");
            addItem(EPItems.BRASS_CHESTPLATE, "Brass chestplate");
            addItem(EPItems.BRASS_LEGGINGS, "Brass leggings");
            addItem(EPItems.BRASS_BOOTS, "Brass boots");

            addItem(EPItems.ALUMINUM_BRASS_SWORD, "Brass Sword");
            addItem(EPItems.ALUMINUM_BRASS_DAGGER, "Brass Dagger");
            addItem(EPItems.ALUMINUM_BRASS_PICKAXE, "Brass Pickaxe");
            addItem(EPItems.ALUMINUM_BRASS_AXE, "Brass Axe");
            addItem(EPItems.ALUMINUM_BRASS_SHOVEL, "Brass Shovel");
            addItem(EPItems.ALUMINUM_BRASS_HOE, "Brass Hoe");
            addItem(EPItems.ALUMINUM_BRASS_POLISHER, "Brass Polisher");

            //Bronze equipment
            addItem(EPItems.BRONZE_SWORD, "Bronze sword");
            addItem(EPItems.BRONZE_DAGGER, "Bronze dagger");
            addItem(EPItems.BRONZE_PICKAXE, "Bronze pickaxe");
            addItem(EPItems.BRONZE_AXE, "Bronze axe");
            addItem(EPItems.BRONZE_SHOVEL, "Bronze shovel");
            addItem(EPItems.BRONZE_HOE, "Bronze hoe");
            addItem(EPItems.BRONZE_POLISHER, "Bronze polisher");
            addItem(EPItems.BRONZE_HELMET, "Bronze helmet");
            addItem(EPItems.BRONZE_CHESTPLATE, "Bronze chestplate");
            addItem(EPItems.BRONZE_LEGGINGS, "Bronze leggings");
            addItem(EPItems.BRONZE_BOOTS, "Bronze boots");

            addItem(EPItems.ALUMINUM_BRONZE_SWORD, "Bronze Sword");
            addItem(EPItems.ALUMINUM_BRONZE_DAGGER, "Bronze Dagger");
            addItem(EPItems.ALUMINUM_BRONZE_PICKAXE, "Bronze Pickaxe");
            addItem(EPItems.ALUMINUM_BRONZE_AXE, "Bronze Axe");
            addItem(EPItems.ALUMINUM_BRONZE_SHOVEL, "Bronze Shovel");
            addItem(EPItems.ALUMINUM_BRONZE_HOE, "Bronze Hoe");
            addItem(EPItems.ALUMINUM_BRONZE_POLISHER, "Bronze Polisher");

            //Rose golden equipment
            addItem(EPItems.ROSE_GOLDEN_SWORD, "Rose golden sword");
            addItem(EPItems.ROSE_GOLDEN_DAGGER, "Rose golden dagger");
            addItem(EPItems.ROSE_GOLDEN_PICKAXE, "Rose golden pickaxe");
            addItem(EPItems.ROSE_GOLDEN_AXE, "Rose golden axe");
            addItem(EPItems.ROSE_GOLDEN_SHOVEL, "Rose golden shovel");
            addItem(EPItems.ROSE_GOLDEN_HOE, "Rose golden hoe");
            addItem(EPItems.ROSE_GOLDEN_POLISHER, "Rose golden polisher");
            addItem(EPItems.ROSE_GOLDEN_HELMET, "Rose golden helmet");
            addItem(EPItems.ROSE_GOLDEN_CHESTPLATE, "Rose golden chestplate");
            addItem(EPItems.ROSE_GOLDEN_LEGGINGS, "Rose golden leggings");
            addItem(EPItems.ROSE_GOLDEN_BOOTS, "Rose golden boots");

            addItem(EPItems.ALUMINUM_ROSE_GOLDEN_SWORD, "Rose Golden Sword");
            addItem(EPItems.ALUMINUM_ROSE_GOLDEN_DAGGER, "Rose Golden Dagger");
            addItem(EPItems.ALUMINUM_ROSE_GOLDEN_PICKAXE, "Rose Golden Pickaxe");
            addItem(EPItems.ALUMINUM_ROSE_GOLDEN_AXE, "Rose Golden Axe");
            addItem(EPItems.ALUMINUM_ROSE_GOLDEN_SHOVEL, "Rose Golden Shovel");
            addItem(EPItems.ALUMINUM_ROSE_GOLDEN_HOE, "Rose Golden Hoe");
            addItem(EPItems.ALUMINUM_ROSE_GOLDEN_POLISHER, "Rose Golden Polisher");

            //Bronzium equipment
            addItem(EPItems.BRONZIUM_SWORD, "Bronzium sword");
            addItem(EPItems.BRONZIUM_DAGGER, "Bronzium dagger");
            addItem(EPItems.BRONZIUM_PICKAXE, "Bronzium pickaxe");
            addItem(EPItems.BRONZIUM_AXE, "Bronzium axe");
            addItem(EPItems.BRONZIUM_SHOVEL, "Bronzium shovel");
            addItem(EPItems.BRONZIUM_HOE, "Bronzium hoe");
            addItem(EPItems.BRONZIUM_POLISHER, "Bronzium polisher");
            addItem(EPItems.BRONZIUM_HELMET, "Bronzium helmet");
            addItem(EPItems.BRONZIUM_CHESTPLATE, "Bronzium chestplate");
            addItem(EPItems.BRONZIUM_LEGGINGS, "Bronzium leggings");
            addItem(EPItems.BRONZIUM_BOOTS, "Bronzium boots");

            addItem(EPItems.ALUMINUM_BRONZIUM_SWORD, "Bronzium Sword");
            addItem(EPItems.ALUMINUM_BRONZIUM_DAGGER, "Bronzium Dagger");
            addItem(EPItems.ALUMINUM_BRONZIUM_PICKAXE, "Bronzium Pickaxe");
            addItem(EPItems.ALUMINUM_BRONZIUM_AXE, "Bronzium Axe");
            addItem(EPItems.ALUMINUM_BRONZIUM_SHOVEL, "Bronzium Shovel");
            addItem(EPItems.ALUMINUM_BRONZIUM_HOE, "Bronzium Hoe");
            addItem(EPItems.ALUMINUM_BRONZIUM_POLISHER, "Bronzium Polisher");

            //Iron equipment
            addItem(EPItems.IRON_POLISHER, "Iron polisher");
            addItem(EPItems.IRON_DAGGER, "Iron dagger");

            addItem(EPItems.ALUMINUM_IRON_SWORD, "Iron Sword");
            addItem(EPItems.ALUMINUM_IRON_DAGGER, "Iron Dagger");
            addItem(EPItems.ALUMINUM_IRON_PICKAXE, "Iron Pickaxe");
            addItem(EPItems.ALUMINUM_IRON_AXE, "Iron Axe");
            addItem(EPItems.ALUMINUM_IRON_SHOVEL, "Iron Shovel");
            addItem(EPItems.ALUMINUM_IRON_HOE, "Iron Hoe");
            addItem(EPItems.ALUMINUM_IRON_POLISHER, "Iron Polisher");

            //Green golden equipment
            addItem(EPItems.GREEN_GOLDEN_SWORD, "Green golden sword");
            addItem(EPItems.GREEN_GOLDEN_DAGGER, "Green golden dagger");
            addItem(EPItems.GREEN_GOLDEN_PICKAXE, "Green golden pickaxe");
            addItem(EPItems.GREEN_GOLDEN_AXE, "Green golden axe");
            addItem(EPItems.GREEN_GOLDEN_SHOVEL, "Green golden shovel");
            addItem(EPItems.GREEN_GOLDEN_HOE, "Green golden hoe");
            addItem(EPItems.GREEN_GOLDEN_POLISHER, "Green golden polisher");
            addItem(EPItems.GREEN_GOLDEN_HELMET, "Green golden helmet");
            addItem(EPItems.GREEN_GOLDEN_CHESTPLATE, "Green golden chestplate");
            addItem(EPItems.GREEN_GOLDEN_LEGGINGS, "Green golden leggings");
            addItem(EPItems.GREEN_GOLDEN_BOOTS, "Green golden boots");

            addItem(EPItems.ALUMINUM_GREEN_GOLDEN_SWORD, "Green Golden Sword");
            addItem(EPItems.ALUMINUM_GREEN_GOLDEN_DAGGER, "Green Golden Dagger");
            addItem(EPItems.ALUMINUM_GREEN_GOLDEN_PICKAXE, "Green Golden Pickaxe");
            addItem(EPItems.ALUMINUM_GREEN_GOLDEN_AXE, "Green Golden Axe");
            addItem(EPItems.ALUMINUM_GREEN_GOLDEN_SHOVEL, "Green Golden Shovel");
            addItem(EPItems.ALUMINUM_GREEN_GOLDEN_HOE, "Green Golden Hoe");
            addItem(EPItems.ALUMINUM_GREEN_GOLDEN_POLISHER, "Green Golden Polisher");

            //Steel equipment
            addItem(EPItems.STEEL_SWORD, "Steel sword");
            addItem(EPItems.STEEL_DAGGER, "Steel dagger");
            addItem(EPItems.STEEL_PICKAXE, "Steel pickaxe");
            addItem(EPItems.STEEL_AXE, "Steel axe");
            addItem(EPItems.STEEL_SHOVEL, "Steel shovel");
            addItem(EPItems.STEEL_HOE, "Steel hoe");
            addItem(EPItems.STEEL_POLISHER, "Steel polisher");
            addItem(EPItems.STEEL_HELMET, "Steel helmet");
            addItem(EPItems.STEEL_CHESTPLATE, "Steel chestplate");
            addItem(EPItems.STEEL_LEGGINGS, "Steel leggings");
            addItem(EPItems.STEEL_BOOTS, "Steel boots");

            addItem(EPItems.ALUMINUM_STEEL_SWORD, "Steel Sword");
            addItem(EPItems.ALUMINUM_STEEL_DAGGER, "Steel Dagger");
            addItem(EPItems.ALUMINUM_STEEL_PICKAXE, "Steel Pickaxe");
            addItem(EPItems.ALUMINUM_STEEL_AXE, "Steel Axe");
            addItem(EPItems.ALUMINUM_STEEL_SHOVEL, "Steel Shovel");
            addItem(EPItems.ALUMINUM_STEEL_HOE, "Steel Hoe");
            addItem(EPItems.ALUMINUM_STEEL_POLISHER, "Steel Polisher");

            //Blue gold equipment
            addItem(EPItems.BLUE_GOLDEN_SWORD, "Blue Golden sword");
            addItem(EPItems.BLUE_GOLDEN_DAGGER, "Blue Golden dagger");
            addItem(EPItems.BLUE_GOLDEN_PICKAXE, "Blue Golden pickaxe");
            addItem(EPItems.BLUE_GOLDEN_AXE, "Blue Golden axe");
            addItem(EPItems.BLUE_GOLDEN_SHOVEL, "Blue Golden shovel");
            addItem(EPItems.BLUE_GOLDEN_HOE, "Blue Golden hoe");
            addItem(EPItems.BLUE_GOLDEN_POLISHER, "Blue Golden polisher");
            addItem(EPItems.BLUE_GOLDEN_HELMET, "Blue Golden helmet");
            addItem(EPItems.BLUE_GOLDEN_CHESTPLATE, "Blue Golden chestplate");
            addItem(EPItems.BLUE_GOLDEN_LEGGINGS, "Blue Golden leggings");
            addItem(EPItems.BLUE_GOLDEN_BOOTS, "Blue Golden boots");

            addItem(EPItems.ALUMINUM_BLUE_GOLDEN_SWORD, "Blue Golden Sword");
            addItem(EPItems.ALUMINUM_BLUE_GOLDEN_DAGGER, "Blue Golden Dagger");
            addItem(EPItems.ALUMINUM_BLUE_GOLDEN_PICKAXE, "Blue Golden Pickaxe");
            addItem(EPItems.ALUMINUM_BLUE_GOLDEN_AXE, "Blue Golden Axe");
            addItem(EPItems.ALUMINUM_BLUE_GOLDEN_SHOVEL, "Blue Golden Shovel");
            addItem(EPItems.ALUMINUM_BLUE_GOLDEN_HOE, "Blue Golden Hoe");
            addItem(EPItems.ALUMINUM_BLUE_GOLDEN_POLISHER, "Blue Golden Polisher");

            //Diamond equipment
            addItem(EPItems.DIAMOND_POLISHER, "Diamond polisher");
            addItem(EPItems.DIAMOND_DAGGER, "Diamond dagger");

            addItem(EPItems.ALUMINUM_DIAMOND_SWORD, "Diamond Sword");
            addItem(EPItems.ALUMINUM_DIAMOND_DAGGER, "Diamond Dagger");
            addItem(EPItems.ALUMINUM_DIAMOND_PICKAXE, "Diamond Pickaxe");
            addItem(EPItems.ALUMINUM_DIAMOND_AXE, "Diamond Axe");
            addItem(EPItems.ALUMINUM_DIAMOND_SHOVEL, "Diamond Shovel");
            addItem(EPItems.ALUMINUM_DIAMOND_HOE, "Diamond Hoe");
            addItem(EPItems.ALUMINUM_DIAMOND_POLISHER, "Diamond Polisher");

            //Netherite equipment
            addItem(EPItems.NETHERITE_POLISHER, "Netherite polisher");
            addItem(EPItems.NETHERITE_DAGGER, "Netherite dagger");

            //Plants
            addItem(EPItems.YERBA_MATE, "Yerba mate");
            addItem(EPItems.GROUNDED_YERBA_MATE, "Ground yerba mate");

            //Food
                //Wild
                addItem(EPItems.WILD_TOMATO, "Wild tomato");
                addItem(EPItems.WILD_CORN, "Wild corn");

                //Flour
                addItem(EPItems.WHEAT_FLOUR, "Wheat flour");
                addItem(EPItems.PUMPKIN_FLOUR, "Pumpkin flour");

                //Seeds
                addItem(EPItems.YERBA_MATE_SEEDS, "Yerba mate seeds");
                addItem(EPItems.ZAPALLO_SEEDS, "Anco pumpkin seeds");
                addItem(EPItems.TOMATO_SEEDS, "Tomato seeds");
                addItem(EPItems.CORN_SEEDS, "Corn seeds");
                addItem(EPItems.EGGPLANT_SEEDS, "Eggplant seeds");

                //Fruits
                addItem(EPItems.TOMATO, "Tomato");
                addItem(EPItems.LEMON, "Lemon");
                addItem(EPItems.LIME, "Lime");
                addItem(EPItems.ORANGE, "Orange");
                addItem(EPItems.WALNUT, "Walnut");
                addItem(EPItems.PEELED_WALNUT, "Peeled walnut");
                addItem(EPItems.GREEN_APPLE, "Green apple");

                //Vegetables
                addItem(EPItems.CORN, "Corn");
                addItem(EPItems.ZAPALLO, "Anco pumpkin");
                addItem(EPItems.EGGPLANT, "Eggplant");
                addItem(EPItems.RICE_GRAINS, "Rice grains");

                //Cooked
                addItem(EPItems.COOKED_CORN, "Cooked corn");
                addItem(EPItems.COOKED_ZAPALLO, "Cooked anco pumpkin");
                addItem(EPItems.COOKED_EGGPLANT, "Cooked eggplant");

                //Others
                addItem(EPItems.EMPTY_MATE, "Empty mate");
                addItem(EPItems.MATE, "Mate");
                addItem(EPItems.YEAST, "Yeast");
                addItem(EPItems.RICE_BOWL, "Rice bowl");

            //Smithing templates
            addSmithingTitles("Smithing template", "Applies to:", "Ingredients:");

            addSmithingTranslations("bronzium", "Bronzium upgrade", "Bronze equipment, Brass equipment", "Bronzium ingot",
                    "Add a bronze or brass armor, weapon or tool", "Add an bronzium ingot");
            addSmithingTranslations("aluminum", "Aluminum upgrade", "Tools with wooden handle", "Aluminum ingot",
                    "Add any tool with a wooden handle", "Add an aluminum ingot");

            //Enchantments
            addEnchantment(EPEnchantments.FINE_MINING, "Fine mining");
            addEnchantmentDesc("fine_mining", "When is applied, only the ore will be dropped from the block extraction");
            addEnchantment(EPEnchantments.ROUGH_MINING, "Curse of rough mining");
            addEnchantmentDesc("rough_mining", "When is applied, the block is crushed onto his primal components");
            addEnchantment(EPEnchantments.POISON_TOUCH, "Poison touch");
            addEnchantmentDesc("poison_touch", "Gives Poison to the target");
            addEnchantment(EPEnchantments.LIVING_TOUCH, "Living touch");
            addEnchantmentDesc("living_touch", "Gives Healing to the target");
            addEnchantment(EPEnchantments.BLOODY_BLADE, "Bloody blade");
            addEnchantmentDesc("sharp_blade", "Gives Bleeding to the target");
            addEnchantment(EPEnchantments.FROSTBITE, "Frostbite");
            addEnchantmentDesc("frostbite", "Gives Frostbite to the target");

        //Entities
            //Villagers
            addVillagerProfession("jeweler", "Jeweler");

            //Mobs
            addBandit("Bandit");
            addItem(EPItems.BANDIT_SPAWN_EGG, "Spawn bandit");

            addZombieKnight("Zombie knight");
            addItem(EPItems.ZOMBIE_KNIGHT_SPAWN_EGG, "Spawn zombie knight");
    }
}
