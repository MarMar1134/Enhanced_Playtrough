package net.marmar.enhanced_playthrough.data.language;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.block.ModBlocks;
import net.marmar.enhanced_playthrough.util.enchantment.ModEnchantments;
import net.marmar.enhanced_playthrough.item.ModItems;
import net.minecraft.data.PackOutput;

public class EnglishLanguageProvider extends AbstractModLanguageProvider {
    public EnglishLanguageProvider(PackOutput output) {
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
            addSurvivalAdvancement("mighty_bronze", "Mighty bronze",
                    "Craft a bronze pickaxe");
            addSurvivalAdvancement( "steel_isnt_enough", "Steel isn´t enough",
                    "Use your alloy furnace to get some steel");

            //Gems
            addGemAdvancement("root", "The colors of the world",
                    "The world is full of colors, and the gems are a great representation of that");
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

        //Entities
        addBoatEntity("Boat");
        addChestBoatEntity("Boat with chest");
        addThrowableCobbleEntity("Cobble");

        //Blocks
            //Wild crops
            addBlock(ModBlocks.WILD_WHEAT, "Wild wheat");
            addBlock(ModBlocks.WILD_TOMATO, "Wild tomato");
            addBlock(ModBlocks.WILD_CORN, "Wild corn");

            //Plants
            addBlock(ModBlocks.TALL_REEDS, "Gigant reed");
            addBlock(ModBlocks.REEDS, "Pampas grass");
            addBlock(ModBlocks.SMALL_REEDS, "Andean pampas grass");
            addBlock(ModBlocks.WATER_REEDS, "Reed");

            //Wood
                //Apple
                addBlock(ModBlocks.APPLE_SAPLING, "Apple sapling");
                addBlock(ModBlocks.APPLE_LEAVES, "Apple leaves");
                addBlock(ModBlocks.APPLE_LOG, "Apple log");
                addBlock(ModBlocks.STRIPPED_APPLE_LOG, "Stripped apple log");
                addBlock(ModBlocks.APPLE_WOOD, "Apple wood");
                addBlock(ModBlocks.STRIPPED_APPLE_WOOD, "Stripped apple wood");
                addBlock(ModBlocks.APPLE_PLANKS, "Apple planks");
                addBlock(ModBlocks.APPLE_SLAB, "Apple slab");
                addBlock(ModBlocks.APPLE_STAIRS, "Apple stairs");
                addBlock(ModBlocks.APPLE_FENCE, "Apple fence");
                addBlock(ModBlocks.APPLE_FENCEGATE, "Apple fence gate");
                addBlock(ModBlocks.APPLE_DOOR, "Apple door");
                addBlock(ModBlocks.APPLE_TRAPDOOR, "Apple trapdoor");
                addBlock(ModBlocks.APPLE_BUTTON, "Apple button");
                addBlock(ModBlocks.APPLE_PRESSURE_PLATE, "Apple pressure plate");
                addSign(ModItems.APPLE_SIGN, "Apple sign");
                addHangingSign(ModItems.APPLE_HANGING_SIGN, "Hanging apple sign");
                addItem(ModItems.APPLE_BOAT, "Apple boat");
                addItem(ModItems.APPLE_CHEST_BOAT, "Apple boat with chest");

                //Green apple
                addBlock(ModBlocks.GREEN_APPLE_SAPLING, "Green apple sapling");
                addBlock(ModBlocks.GREEN_APPLE_LEAVES, "Green apple leaves");

                //Walnut
                addBlock(ModBlocks.WALNUT_SAPLING, "Walnut sapling");
                addBlock(ModBlocks.WALNUT_LEAVES, "Walnut leaves");
                addBlock(ModBlocks.WALNUT_LOG, "Walnut log");
                addBlock(ModBlocks.STRIPPED_WALNUT_LOG, "Stripped walnut log");
                addBlock(ModBlocks.WALNUT_WOOD, "Walnut wood");
                addBlock(ModBlocks.STRIPPED_WALNUT_WOOD, "Stripped walnut wood");
                addBlock(ModBlocks.WALNUT_PLANKS, "Walnut planks");
                addBlock(ModBlocks.WALNUT_SLAB, "Walnut slab");
                addBlock(ModBlocks.WALNUT_STAIRS, "Walnut stairs");
                addBlock(ModBlocks.WALNUT_FENCE, "Walnut fence");
                addBlock(ModBlocks.WALNUT_FENCEGATE, "Walnut fence gate");
                addBlock(ModBlocks.WALNUT_DOOR, "Walnut door");
                addBlock(ModBlocks.WALNUT_TRAPDOOR, "Walnut trapdoor");
                addBlock(ModBlocks.WALNUT_BUTTON, "Walnut button");
                addBlock(ModBlocks.WALNUT_PRESSURE_PLATE, "Walnut pressure plate");
                addSign(ModItems.WALNUT_SIGN, "Walnut sign");
                addHangingSign(ModItems.WALNUT_HANGING_SIGN, "Hanging walnut sign");
                addItem(ModItems.WALNUT_BOAT, "Walnut boat");
                addItem(ModItems.WALNUT_CHEST_BOAT, "Walnut boat with chest");

                //Orange
                addBlock(ModBlocks.ORANGE_SAPLING, "Orange sapling");
                addBlock(ModBlocks.ORANGE_LEAVES, "Orange leaves");
                addBlock(ModBlocks.ORANGE_LOG, "Orange log");
                addBlock(ModBlocks.STRIPPED_ORANGE_LOG, "Stripped orange log");
                addBlock(ModBlocks.ORANGE_WOOD, "Orange wood");
                addBlock(ModBlocks.STRIPPED_ORANGE_WOOD, "Stripped orange wood");
                addBlock(ModBlocks.ORANGE_PLANKS, "Orange planks");
                addBlock(ModBlocks.ORANGE_SLAB, "Orange slab");
                addBlock(ModBlocks.ORANGE_STAIRS, "Orange stairs");
                addBlock(ModBlocks.ORANGE_FENCE, "Orange fence");
                addBlock(ModBlocks.ORANGE_FENCEGATE, "Orange fence gate");
                addBlock(ModBlocks.ORANGE_DOOR, "Orange door");
                addBlock(ModBlocks.ORANGE_TRAPDOOR, "Orange trapdoor");
                addBlock(ModBlocks.ORANGE_BUTTON, "Orange button");
                addBlock(ModBlocks.ORANGE_PRESSURE_PLATE, "Orange pressure plate");
                addSign(ModItems.ORANGE_SIGN, "Orange sign");
                addHangingSign(ModItems.ORANGE_HANGING_SIGN, "Hanging orange sign");
                addItem(ModItems.ORANGE_BOAT, "Orange boat");
                addItem(ModItems.ORANGE_CHEST_BOAT, "Orange boat with chest");

                //Lemon
                addBlock(ModBlocks.LEMON_SAPLING, "Lemon sapling");
                addBlock(ModBlocks.LEMON_LEAVES, "Lemon leaves");
                addBlock(ModBlocks.LEMON_LOG, "Lemon log");
                addBlock(ModBlocks.STRIPPED_LEMON_LOG, "Stripped lemon log");
                addBlock(ModBlocks.LEMON_WOOD, "Orange wood");
                addBlock(ModBlocks.STRIPPED_LEMON_WOOD, "Stripped lemon wood");
                addBlock(ModBlocks.LEMON_PLANKS, "Lemon planks");
                addBlock(ModBlocks.LEMON_SLAB, "Lemon slab");
                addBlock(ModBlocks.LEMON_STAIRS, "Lemon stairs");
                addBlock(ModBlocks.LEMON_FENCE, "Lemon fence");
                addBlock(ModBlocks.LEMON_FENCEGATE, "Lemon fence gate");
                addBlock(ModBlocks.LEMON_DOOR, "Lemon door");
                addBlock(ModBlocks.LEMON_TRAPDOOR, "Lemon trapdoor");
                addBlock(ModBlocks.LEMON_BUTTON, "Lemon button");
                addBlock(ModBlocks.LEMON_PRESSURE_PLATE, "Lemon pressure plate");
                addSign(ModItems.LEMON_SIGN, "Lemon sign");
                addHangingSign(ModItems.LEMON_HANGING_SIGN, "Hanging lemon sign");
                addItem(ModItems.LEMON_BOAT, "Lemon boat");
                addItem(ModItems.LEMON_CHEST_BOAT, "Lemon boat with chest");

                //Lime
                addBlock(ModBlocks.LIME_SAPLING, "Lime sapling");
                addBlock(ModBlocks.LIME_LEAVES, "Lime leaves");

            //Polished stone
            addBlock(ModBlocks.POLISHED_STONE, "Polished stone");
            addBlock(ModBlocks.POLISHED_STONE_SLAB, "Polished stone slab");
            addBlock(ModBlocks.POLISHED_STONE_STAIRS, "Polished stone stairs");
            addBlock(ModBlocks.POLISHED_STONE_WALL, "Polished stone wall");

            //Cobbled limestone
            addBlock(ModBlocks.COBBLED_LIMESTONE, "Cobbled limestone");
            addBlock(ModBlocks.COBBLED_LIMESTONE_SLAB, "Cobbled limestone slab");
            addBlock(ModBlocks.COBBLED_LIMESTONE_STAIRS, "Cobbled limestone stairs");
            addBlock(ModBlocks.COBBLED_LIMESTONE_WALL, "Cobbled limestone wall");

            //Limestone
            addBlock(ModBlocks.LIMESTONE, "Limestone");
            addBlock(ModBlocks.LIMESTONE_SLAB, "Limestone slab");
            addBlock(ModBlocks.LIMESTONE_STAIRS, "Limestone stairs");
            addBlock(ModBlocks.LIMESTONE_WALL, "Limestone wall");

            //Polished limestone
            addBlock(ModBlocks.POLISHED_LIMESTONE, "Polished limestone");
            addBlock(ModBlocks.POLISHED_LIMESTONE_SLAB, "Polished limestone slab");
            addBlock(ModBlocks.POLISHED_LIMESTONE_STAIRS, "Polished limestone stairs");
            addBlock(ModBlocks.POLISHED_LIMESTONE_WALL, "Polished limestone wall");

            //Limestone bricks
            addBlock(ModBlocks.LIMESTONE_BRICKS, "Limestone bricks");
            addBlock(ModBlocks.LIMESTONE_BRICK_SLAB, "Limestone bricks slab");
            addBlock(ModBlocks.LIMESTONE_BRICK_STAIRS, "Limestone bricks stairs");
            addBlock(ModBlocks.LIMESTONE_BRICK_WALL, "Limestone bricks wall");

            //Soul
            addBlock(ModBlocks.SOUL_MUD, "Soul mud");
            addBlock(ModBlocks.SOUL_MUD_BRICKS, "Soul mud bricks");
            addBlock(ModBlocks.SOUL_MUD_BRICK_SLAB, "Soul mud brick slab");
            addBlock(ModBlocks.SOUL_MUD_BRICK_STAIRS, "Soul mud brick stairs");
            addBlock(ModBlocks.SOUL_MUD_BRICK_WALL, "Soul mud brick wall");

        //Firebricks
        addBlock(ModBlocks.FIREBRICKS, "Firebricks");
        addBlock(ModBlocks.FIREBRICK_SLAB, "Firebrick slab");
        addBlock(ModBlocks.FIREBRICK_STAIRS, "Firebrick stairs");
        addBlock(ModBlocks.FIREBRICK_WALL, "Firebrick wall");

            //Ores
            addBlock(ModBlocks.TIN_ORE, "Tin ore");
            addBlock(ModBlocks.DEEPSLATE_TIN_ORE, "Deepslate tin ore");
            addBlock(ModBlocks.ZINC_ORE, "Zinc ore");
            addBlock(ModBlocks.DEEPSLATE_ZINC_ORE, "Deepslate zinc ore");
            addBlock(ModBlocks.NETHER_ZINC_ORE, "Nether zinc ore");
            addBlock(ModBlocks.NETHER_COPPER_ORE, "Nether copper ore");
            addBlock(ModBlocks.SULFUR_ORE, "Sulfur ore");
            addBlock(ModBlocks.DEEPSLATE_SULFUR_ORE, "Deepslate sulfur ore");
            addBlock(ModBlocks.NETHER_SULFUR_ORE, "Nether sulfur ore");
            addBlock(ModBlocks.SILVER_ORE, "Silver ore");
            addBlock(ModBlocks.DEEPSLATE_SILVER_ORE, "Deepslate silver ore");
            addBlock(ModBlocks.SAPPHIRE_ORE, "Sapphire ore");
            addBlock(ModBlocks.DEEPSLATE_SAPPHIRE_ORE, "Deepslate sapphire ore");
            addBlock(ModBlocks.RUBY_ORE, "Ruby ore");
            addBlock(ModBlocks.DEEPSLATE_RUBY_ORE, "Deepslate ruby ore");
            addBlock(ModBlocks.NETHER_GARNET_ORE, "Nether garnet ore");
            addBlock(ModBlocks.COBALT_ORE, "Cobalt ore");
            addBlock(ModBlocks.DEEPSLATE_COBALT_ORE, "Deepslate cobalt ore");
            addBlock(ModBlocks.BAUXITE, "Bauxite");
            addBlock(ModBlocks.WHITE_BAUXITE, "White bauxite");
            addBlock(ModBlocks.LIGHT_GRAY_BAUXITE, "Light gray bauxite");
            addBlock(ModBlocks.BROWN_BAUXITE, "Brown bauxite");
            addBlock(ModBlocks.RED_BAUXITE, "Red bauxite");
            addBlock(ModBlocks.ORANGE_BAUXITE, "Orange bauxite");
            addBlock(ModBlocks.YELLOW_BAUXITE, "Yellow bauxite");

            //Ore blocks
            addBlock(ModBlocks.RAW_TIN_BLOCK, "Block of raw tin");
            addBlock(ModBlocks.TIN_BLOCK, "Block of tin");
            addBlock(ModBlocks.RAW_ZINC_BLOCK, "Block of raw zinc");
            addBlock(ModBlocks.ZINC_BLOCK, "Block of zinc");
            addBlock(ModBlocks.RAW_SILVER_BLOCK, "block of raw silver");
            addBlock(ModBlocks.SILVER_BLOCK, "Block of silver");
            addBlock(ModBlocks.RAW_ALUMINUM_BLOCK, "Block of raw aluminum");
            addBlock(ModBlocks.ALUMINUM_BLOCK, "Block of aluminum");
            addBlock(ModBlocks.BRASS_BLOCK, "Block of brass");
            addBlock(ModBlocks.BRONZE_BLOCK, "Block of bronze");
            addBlock(ModBlocks.ROSE_GOLD_BLOCK, "Block of rose gold");
            addBlock(ModBlocks.BRONZIUM_BLOCK, "Block of bronzium");
            addBlock(ModBlocks.GREEN_GOLD_BLOCK, "Block of green gold");
            addBlock(ModBlocks.STEEL_BLOCK, "Block of steel");
            addBlock(ModBlocks.BLUE_GOLD_BLOCK, "Block of blue gold");

            //Block entities
            addBlock(ModBlocks.ADOBE_FURNACE, "Mud furnace");
            addBlock(ModBlocks.SOUL_FURNACE, "Soul mud furnace");
            addBlock(ModBlocks.MASONRY_FURNACE, "Masonry furnace");
            addBlock(ModBlocks.ADOBE_ALLOYING_FURNACE, "Bricks alloy furnace");
            addBlock(ModBlocks.SOUL_ALLOY_FURNACE, "Soul bricks alloy furnace");
            addBlock(ModBlocks.SUPER_ALLOYING_FURNACE, "Blast alloy furnace");
            addBlock(ModBlocks.GEM_POLISHER, "Gem polisher");
            addBlock(ModBlocks.PRIMAL_GRINDER, "Grinder");
            addBlock(ModBlocks.MECHANICAL_GRINDER, "Mechanical grinder");

        //Items
            //Raw ores
            addItem(ModItems.RAW_TIN, "Raw tin");
            addItem(ModItems.RAW_ZINC, "Raw zinc");
            addItem(ModItems.RAW_SILVER, "Raw silver");
            addItem(ModItems.RAW_ALUMINUM, "Raw aluminum");
            addItem(ModItems.RAW_EMERALD, "Unpolished emerald");
            addItem(ModItems.RAW_SAPPHIRE, "Unpolished sapphire");
            addItem(ModItems.RAW_RUBY, "Unpolished ruby");
            addItem(ModItems.RAW_GARNET, "Unpolished garnet");
            addItem(ModItems.RAW_DIAMOND, "Unpolished diamond");

            //Materials and melted ores
            addItem(ModItems.TIN_INGOT, "Tin ingot");
            addItem(ModItems.TIN_NUGGET, "Tin nugget");
            addItem(ModItems.ZINC_INGOT, "Zinc ingot");
            addItem(ModItems.ZINC_NUGGET, "Zinc nugget");
            addItem(ModItems.SULFUR, "Sulfur");
            addItem(ModItems.SILVER_INGOT, "Silver ingot");
            addItem(ModItems.SILVER_NUGGET, "Silver nugget");
            addItem(ModItems.ALUMINUM_INGOT, "Aluminum ingot");
            addItem(ModItems.ALUMINUM_NUGGET, "Aluminum nugget");
            addItem(ModItems.COPPER_NUGGET, "Copper nugget");
            addItem(ModItems.BRASS_INGOT, "Brass ingot");
            addItem(ModItems.BRASS_NUGGET, "Brass nugget");
            addItem(ModItems.BRONZE_INGOT, "Bronze ingot");
            addItem(ModItems.BRONZE_NUGGET, "Bronze nugget");
            addItem(ModItems.ROSE_GOLD_INGOT, "Rose gold ingot");
            addItem(ModItems.ROSE_GOLD_NUGGET, "Rose gold nugget");
            addItem(ModItems.BRONZIUM_INGOT, "Bronzium ingot");
            addItem(ModItems.BRONZIUM_NUGGET, "Bronzium nugget");
            addItem(ModItems.GREEN_GOLD_INGOT, "Green gold ingot");
            addItem(ModItems.GREEN_GOLD_NUGGET, "Green gold nugget");
            addItem(ModItems.STEEL_INGOT, "Steel ingot");
            addItem(ModItems.STEEL_NUGGET, "Steel nugget");
            addItem(ModItems.BLUE_GOLD_INGOT, "Blue gold ingot");
            addItem(ModItems.BLUE_GOLD_NUGGET, "Blue gold nugget");
            addItem(ModItems.SAPPHIRE, "Sapphire");
            addItem(ModItems.RUBY, "Ruby");
            addItem(ModItems.GARNET, "Garnet");

            //Others
            addItem(ModItems.MUD_BRICK, "Mud brick");
            addItem(ModItems.FIREBRICK, "Firebrick");
            addItem(ModItems.ALUMINUM_ROD, "Aluminum rod");
            addItem(ModItems.COBALT, "Cobalt");
            addItem(ModItems.REED_HEAD, "Pampas grass head");
            addItem(ModItems.WATER_REED_HEAD, "Reed head");
            addItem(ModItems.VEGETABLE_FIBBER, "Vegetable fiber");

            //Cobble
            addItem(ModItems.COBBLE, "Cobble");
            addItem(ModItems.LIMESTONE_COBBLE, "Limestone cobble");
            addItem(ModItems.DEEPSLATE_COBBLE, "Deepslate cobble");
            addItem(ModItems.NETHERRACK_RUBBLE, "Netherrack rubble");
            addItem(ModItems.BLACKSTONE_COBBLE, "Blackstone cobble");

            //Terracotta shards
            addItem(ModItems.TERRACOTTA_SHARD, "Terracotta shard");
            addItem(ModItems.WHITE_TERRACOTTA_SHARD, "White terracotta shard");
            addItem(ModItems.ORANGE_TERRACOTTA_SHARD, "Orange terracotta shard");
            addItem(ModItems.MAGENTA_TERRACOTTA_SHARD, "Magenta terracotta shard");
            addItem(ModItems.LIGHT_BLUE_TERRACOTTA_SHARD, "Light blue terracotta shard");
            addItem(ModItems.YELLOW_TERRACOTTA_SHARD, "Yellow terracotta shard");
            addItem(ModItems.LIME_TERRACOTTA_SHARD, "Lime terracotta shard");
            addItem(ModItems.PINK_TERRACOTTA_SHARD, "Pink terracotta shard");
            addItem(ModItems.GRAY_TERRACOTTA_SHARD, "Gray terracotta shard");
            addItem(ModItems.LIGHT_GRAY_TERRACOTTA_SHARD, "Light gray terracotta shard");
            addItem(ModItems.CYAN_TERRACOTTA_SHARD, "Cyan terracotta shard");
            addItem(ModItems.PURPLE_TERRACOTTA_SHARD, "Purple terracotta shard");
            addItem(ModItems.BLUE_TERRACOTTA_SHARD, "Blue terracotta shard");
            addItem(ModItems.BROWN_TERRACOTTA_SHARD, "Brown terracotta shard");
            addItem(ModItems.GREEN_TERRACOTTA_SHARD, "Green terracotta shard");
            addItem(ModItems.RED_TERRACOTTA_SHARD, "Red terracotta shard");
            addItem(ModItems.BLACK_TERRACOTTA_SHARD, "Black terracotta shard");

            //Dusts
            addItem(ModItems.GOLD_DUST, "Gold dust");
            addItem(ModItems.SILVER_DUST, "Silver dust");
            addItem(ModItems.ALUMINUM_DUST, "Aluminum dust");
            addItem(ModItems.ZINC_DUST, "Zinc dust");
            addItem(ModItems.TIN_DUST, "Tin dust");
            addItem(ModItems.COPPER_DUST, "Copper dust");
            addItem(ModItems.BRASS_DUST, "Brass dust");
            addItem(ModItems.BRONZE_DUST, "Bronze dust");
            addItem(ModItems.ROSE_GOLD_DUST, "Rose gold dust");
            addItem(ModItems.IRON_DUST, "Iron dust");
            addItem(ModItems.BRONZIUM_DUST, "Bronzium dust");
            addItem(ModItems.GREEN_GOLD_DUST, "Green gold dust");
            addItem(ModItems.STEEL_DUST, "Steel dust");
            addItem(ModItems.BLUE_GOLD_DUST, "Blue gold dust");

            //Acids and potions
            addAcid("sulfuric_acid", "Sulfuric acid");

        //Other tools
        addItem(ModItems.FLINT_AND_COBBLE, "Flint & cobble");
        addItem(ModItems.FLINT_AND_BRONZE, "Flint & bronze");

            //Silver equipment
            addItem(ModItems.SILVER_SWORD, "Silver sword");
            addItem(ModItems.SILVER_DAGGER, "Silver dagger");
            addItem(ModItems.SILVER_PICKAXE, "Silver pickaxe");
            addItem(ModItems.SILVER_AXE, "Silver axe");
            addItem(ModItems.SILVER_SHOVEL, "Silver shovel");
            addItem(ModItems.SILVER_HOE, "Silver hoe");
            addItem(ModItems.SILVER_POLISHER, "Silver polisher");
            addItem(ModItems.SILVER_HELMET, "Silver helmet");
            addItem(ModItems.SILVER_CHESTPLATE, "Silver chestplate");
            addItem(ModItems.SILVER_LEGGINGS, "Silver leggings");
            addItem(ModItems.SILVER_BOOTS, "Silver boots");

            addItem(ModItems.ALUMINUM_SILVER_SWORD, "Silver Sword");
            addItem(ModItems.ALUMINUM_SILVER_DAGGER, "Silver Dagger");
            addItem(ModItems.ALUMINUM_SILVER_PICKAXE, "Silver Pickaxe");
            addItem(ModItems.ALUMINUM_SILVER_AXE, "Silver Axe");
            addItem(ModItems.ALUMINUM_SILVER_SHOVEL, "Silver Shovel");
            addItem(ModItems.ALUMINUM_SILVER_HOE, "Silver Hoe");
            addItem(ModItems.ALUMINUM_SILVER_POLISHER, "Silver Polisher");

            //Gold equipment
            addItem(ModItems.GOLDEN_POLISHER, "Golden polisher");
            addItem(ModItems.GOLDEN_DAGGER, "Golden dagger");

            addItem(ModItems.ALUMINUM_GOLDEN_SWORD, "Golden Sword");
            addItem(ModItems.ALUMINUM_GOLDEN_DAGGER, "Golden Dagger");
            addItem(ModItems.ALUMINUM_GOLDEN_PICKAXE, "Golden Pickaxe");
            addItem(ModItems.ALUMINUM_GOLDEN_AXE, "Golden Axe");
            addItem(ModItems.ALUMINUM_GOLDEN_SHOVEL, "Golden Shovel");
            addItem(ModItems.ALUMINUM_GOLDEN_HOE, "Golden Hoe");
            addItem(ModItems.ALUMINUM_GOLDEN_POLISHER, "Golden Polisher");

            //Wood equipment
            addItem(ModItems.WOODEN_DAGGER, "Wooden dagger");

            addItem(ModItems.ALUMINUM_WOODEN_SWORD, "Wooden Sword");
            addItem(ModItems.ALUMINUM_WOODEN_DAGGER, "Wooden Dagger");
            addItem(ModItems.ALUMINUM_WOODEN_PICKAXE, "Wooden Pickaxe");
            addItem(ModItems.ALUMINUM_WOODEN_AXE, "Wooden Axe");
            addItem(ModItems.ALUMINUM_WOODEN_SHOVEL, "Wooden Shovel");
            addItem(ModItems.ALUMINUM_WOODEN_HOE, "Wooden Hoe");

            //Stone equipment
            addItem(ModItems.STONE_POLISHER, "Stone polisher");
            addItem(ModItems.STONE_DAGGER, "Stone dagger");

            addItem(ModItems.ALUMINUM_STONE_SWORD, "Stone Sword");
            addItem(ModItems.ALUMINUM_STONE_DAGGER, "Stone Dagger");
            addItem(ModItems.ALUMINUM_STONE_PICKAXE, "Stone Pickaxe");
            addItem(ModItems.ALUMINUM_STONE_AXE, "Stone Axe");
            addItem(ModItems.ALUMINUM_STONE_SHOVEL, "Stone Shovel");
            addItem(ModItems.ALUMINUM_STONE_HOE, "Stone Hoe");
            addItem(ModItems.ALUMINUM_STONE_POLISHER, "Stone Polisher");

            //Brass equipment
            addItem(ModItems.BRASS_SWORD, "Brass sword");
            addItem(ModItems.BRASS_DAGGER, "Brass dagger");
            addItem(ModItems.BRASS_PICKAXE, "Brass pickaxe");
            addItem(ModItems.BRASS_AXE, "Brass axe");
            addItem(ModItems.BRASS_SHOVEL, "Brass shovel");
            addItem(ModItems.BRASS_HOE, "Brass hoe");
            addItem(ModItems.BRASS_POLISHER, "Brass polisher");
            addItem(ModItems.BRASS_HELMET, "Brass helmet");
            addItem(ModItems.BRASS_CHESTPLATE, "Brass chestplate");
            addItem(ModItems.BRASS_LEGGINGS, "Brass leggings");
            addItem(ModItems.BRASS_BOOTS, "Brass boots");

            addItem(ModItems.ALUMINUM_BRASS_SWORD, "Brass Sword");
            addItem(ModItems.ALUMINUM_BRASS_DAGGER, "Brass Dagger");
            addItem(ModItems.ALUMINUM_BRASS_PICKAXE, "Brass Pickaxe");
            addItem(ModItems.ALUMINUM_BRASS_AXE, "Brass Axe");
            addItem(ModItems.ALUMINUM_BRASS_SHOVEL, "Brass Shovel");
            addItem(ModItems.ALUMINUM_BRASS_HOE, "Brass Hoe");
            addItem(ModItems.ALUMINUM_BRASS_POLISHER, "Brass Polisher");

            //Bronze equipment
            addItem(ModItems.BRONZE_SWORD, "Bronze sword");
            addItem(ModItems.BRONZE_DAGGER, "Bronze dagger");
            addItem(ModItems.BRONZE_PICKAXE, "Bronze pickaxe");
            addItem(ModItems.BRONZE_AXE, "Bronze axe");
            addItem(ModItems.BRONZE_SHOVEL, "Bronze shovel");
            addItem(ModItems.BRONZE_HOE, "Bronze hoe");
            addItem(ModItems.BRONZE_POLISHER, "Bronze polisher");
            addItem(ModItems.BRONZE_HELMET, "Bronze helmet");
            addItem(ModItems.BRONZE_CHESTPLATE, "Bronze chestplate");
            addItem(ModItems.BRONZE_LEGGINGS, "Bronze leggings");
            addItem(ModItems.BRONZE_BOOTS, "Bronze boots");

            addItem(ModItems.ALUMINUM_BRONZE_SWORD, "Bronze Sword");
            addItem(ModItems.ALUMINUM_BRONZE_DAGGER, "Bronze Dagger");
            addItem(ModItems.ALUMINUM_BRONZE_PICKAXE, "Bronze Pickaxe");
            addItem(ModItems.ALUMINUM_BRONZE_AXE, "Bronze Axe");
            addItem(ModItems.ALUMINUM_BRONZE_SHOVEL, "Bronze Shovel");
            addItem(ModItems.ALUMINUM_BRONZE_HOE, "Bronze Hoe");
            addItem(ModItems.ALUMINUM_BRONZE_POLISHER, "Bronze Polisher");

            //Rose golden equipment
            addItem(ModItems.ROSE_GOLDEN_SWORD, "Rose golden sword");
            addItem(ModItems.ROSE_GOLDEN_DAGGER, "Rose golden dagger");
            addItem(ModItems.ROSE_GOLDEN_PICKAXE, "Rose golden pickaxe");
            addItem(ModItems.ROSE_GOLDEN_AXE, "Rose golden axe");
            addItem(ModItems.ROSE_GOLDEN_SHOVEL, "Rose golden shovel");
            addItem(ModItems.ROSE_GOLDEN_HOE, "Rose golden hoe");
            addItem(ModItems.ROSE_GOLDEN_POLISHER, "Rose golden polisher");
            addItem(ModItems.ROSE_GOLDEN_HELMET, "Rose golden helmet");
            addItem(ModItems.ROSE_GOLDEN_CHESTPLATE, "Rose golden chestplate");
            addItem(ModItems.ROSE_GOLDEN_LEGGINGS, "Rose golden leggings");
            addItem(ModItems.ROSE_GOLDEN_BOOTS, "Rose golden boots");

            addItem(ModItems.ALUMINUM_ROSE_GOLDEN_SWORD, "Rose Golden Sword");
            addItem(ModItems.ALUMINUM_ROSE_GOLDEN_DAGGER, "Rose Golden Dagger");
            addItem(ModItems.ALUMINUM_ROSE_GOLDEN_PICKAXE, "Rose Golden Pickaxe");
            addItem(ModItems.ALUMINUM_ROSE_GOLDEN_AXE, "Rose Golden Axe");
            addItem(ModItems.ALUMINUM_ROSE_GOLDEN_SHOVEL, "Rose Golden Shovel");
            addItem(ModItems.ALUMINUM_ROSE_GOLDEN_HOE, "Rose Golden Hoe");
            addItem(ModItems.ALUMINUM_ROSE_GOLDEN_POLISHER, "Rose Golden Polisher");

            //Bronzium equipment
            addItem(ModItems.BRONZIUM_SWORD, "Bronzium sword");
            addItem(ModItems.BRONZIUM_DAGGER, "Bronzium dagger");
            addItem(ModItems.BRONZIUM_PICKAXE, "Bronzium pickaxe");
            addItem(ModItems.BRONZIUM_AXE, "Bronzium axe");
            addItem(ModItems.BRONZIUM_SHOVEL, "Bronzium shovel");
            addItem(ModItems.BRONZIUM_HOE, "Bronzium hoe");
            addItem(ModItems.BRONZIUM_POLISHER, "Bronzium polisher");
            addItem(ModItems.BRONZIUM_HELMET, "Bronzium helmet");
            addItem(ModItems.BRONZIUM_CHESTPLATE, "Bronzium chestplate");
            addItem(ModItems.BRONZIUM_LEGGINGS, "Bronzium leggings");
            addItem(ModItems.BRONZIUM_BOOTS, "Bronzium boots");

            addItem(ModItems.ALUMINUM_BRONZIUM_SWORD, "Bronzium Sword");
            addItem(ModItems.ALUMINUM_BRONZIUM_DAGGER, "Bronzium Dagger");
            addItem(ModItems.ALUMINUM_BRONZIUM_PICKAXE, "Bronzium Pickaxe");
            addItem(ModItems.ALUMINUM_BRONZIUM_AXE, "Bronzium Axe");
            addItem(ModItems.ALUMINUM_BRONZIUM_SHOVEL, "Bronzium Shovel");
            addItem(ModItems.ALUMINUM_BRONZIUM_HOE, "Bronzium Hoe");
            addItem(ModItems.ALUMINUM_BRONZIUM_POLISHER, "Bronzium Polisher");

            //Iron equipment
            addItem(ModItems.IRON_POLISHER, "Iron polisher");
            addItem(ModItems.IRON_DAGGER, "Iron dagger");

            addItem(ModItems.ALUMINUM_IRON_SWORD, "Iron Sword");
            addItem(ModItems.ALUMINUM_IRON_DAGGER, "Iron Dagger");
            addItem(ModItems.ALUMINUM_IRON_PICKAXE, "Iron Pickaxe");
            addItem(ModItems.ALUMINUM_IRON_AXE, "Iron Axe");
            addItem(ModItems.ALUMINUM_IRON_SHOVEL, "Iron Shovel");
            addItem(ModItems.ALUMINUM_IRON_HOE, "Iron Hoe");
            addItem(ModItems.ALUMINUM_IRON_POLISHER, "Iron Polisher");

            //Green golden equipment
            addItem(ModItems.GREEN_GOLDEN_SWORD, "Green golden sword");
            addItem(ModItems.GREEN_GOLDEN_DAGGER, "Green golden dagger");
            addItem(ModItems.GREEN_GOLDEN_PICKAXE, "Green golden pickaxe");
            addItem(ModItems.GREEN_GOLDEN_AXE, "Green golden axe");
            addItem(ModItems.GREEN_GOLDEN_SHOVEL, "Green golden shovel");
            addItem(ModItems.GREEN_GOLDEN_HOE, "Green golden hoe");
            addItem(ModItems.GREEN_GOLDEN_POLISHER, "Green golden polisher");
            addItem(ModItems.GREEN_GOLDEN_HELMET, "Green golden helmet");
            addItem(ModItems.GREEN_GOLDEN_CHESTPLATE, "Green golden chestplate");
            addItem(ModItems.GREEN_GOLDEN_LEGGINGS, "Green golden leggings");
            addItem(ModItems.GREEN_GOLDEN_BOOTS, "Green golden boots");

            addItem(ModItems.ALUMINUM_GREEN_GOLDEN_SWORD, "Green Golden Sword");
            addItem(ModItems.ALUMINUM_GREEN_GOLDEN_DAGGER, "Green Golden Dagger");
            addItem(ModItems.ALUMINUM_GREEN_GOLDEN_PICKAXE, "Green Golden Pickaxe");
            addItem(ModItems.ALUMINUM_GREEN_GOLDEN_AXE, "Green Golden Axe");
            addItem(ModItems.ALUMINUM_GREEN_GOLDEN_SHOVEL, "Green Golden Shovel");
            addItem(ModItems.ALUMINUM_GREEN_GOLDEN_HOE, "Green Golden Hoe");
            addItem(ModItems.ALUMINUM_GREEN_GOLDEN_POLISHER, "Green Golden Polisher");

            //Steel equipment
            addItem(ModItems.STEEL_SWORD, "Steel sword");
            addItem(ModItems.STEEL_DAGGER, "Steel dagger");
            addItem(ModItems.STEEL_PICKAXE, "Steel pickaxe");
            addItem(ModItems.STEEL_AXE, "Steel axe");
            addItem(ModItems.STEEL_SHOVEL, "Steel shovel");
            addItem(ModItems.STEEL_HOE, "Steel hoe");
            addItem(ModItems.STEEL_POLISHER, "Steel polisher");
            addItem(ModItems.STEEL_HELMET, "Steel helmet");
            addItem(ModItems.STEEL_CHESTPLATE, "Steel chestplate");
            addItem(ModItems.STEEL_LEGGINGS, "Steel leggings");
            addItem(ModItems.STEEL_BOOTS, "Steel boots");

            addItem(ModItems.ALUMINUM_STEEL_SWORD, "Steel Sword");
            addItem(ModItems.ALUMINUM_STEEL_DAGGER, "Steel Dagger");
            addItem(ModItems.ALUMINUM_STEEL_PICKAXE, "Steel Pickaxe");
            addItem(ModItems.ALUMINUM_STEEL_AXE, "Steel Axe");
            addItem(ModItems.ALUMINUM_STEEL_SHOVEL, "Steel Shovel");
            addItem(ModItems.ALUMINUM_STEEL_HOE, "Steel Hoe");
            addItem(ModItems.ALUMINUM_STEEL_POLISHER, "Steel Polisher");

            //Blue gold equipment
            addItem(ModItems.BLUE_GOLDEN_SWORD, "Blue Golden sword");
            addItem(ModItems.BLUE_GOLDEN_DAGGER, "Blue Golden dagger");
            addItem(ModItems.BLUE_GOLDEN_PICKAXE, "Blue Golden pickaxe");
            addItem(ModItems.BLUE_GOLDEN_AXE, "Blue Golden axe");
            addItem(ModItems.BLUE_GOLDEN_SHOVEL, "Blue Golden shovel");
            addItem(ModItems.BLUE_GOLDEN_HOE, "Blue Golden hoe");
            addItem(ModItems.BLUE_GOLDEN_POLISHER, "Blue Golden polisher");
            addItem(ModItems.BLUE_GOLDEN_HELMET, "Blue Golden helmet");
            addItem(ModItems.BLUE_GOLDEN_CHESTPLATE, "Blue Golden chestplate");
            addItem(ModItems.BLUE_GOLDEN_LEGGINGS, "Blue Golden leggings");
            addItem(ModItems.BLUE_GOLDEN_BOOTS, "Blue Golden boots");

            addItem(ModItems.ALUMINUM_BLUE_GOLDEN_SWORD, "Blue Golden Sword");
            addItem(ModItems.ALUMINUM_BLUE_GOLDEN_DAGGER, "Blue Golden Dagger");
            addItem(ModItems.ALUMINUM_BLUE_GOLDEN_PICKAXE, "Blue Golden Pickaxe");
            addItem(ModItems.ALUMINUM_BLUE_GOLDEN_AXE, "Blue Golden Axe");
            addItem(ModItems.ALUMINUM_BLUE_GOLDEN_SHOVEL, "Blue Golden Shovel");
            addItem(ModItems.ALUMINUM_BLUE_GOLDEN_HOE, "Blue Golden Hoe");
            addItem(ModItems.ALUMINUM_BLUE_GOLDEN_POLISHER, "Blue Golden Polisher");

            //Diamond equipment
            addItem(ModItems.DIAMOND_POLISHER, "Diamond polisher");
            addItem(ModItems.DIAMOND_DAGGER, "Diamond dagger");

            addItem(ModItems.ALUMINUM_DIAMOND_SWORD, "Diamond Sword");
            addItem(ModItems.ALUMINUM_DIAMOND_DAGGER, "Diamond Dagger");
            addItem(ModItems.ALUMINUM_DIAMOND_PICKAXE, "Diamond Pickaxe");
            addItem(ModItems.ALUMINUM_DIAMOND_AXE, "Diamond Axe");
            addItem(ModItems.ALUMINUM_DIAMOND_SHOVEL, "Diamond Shovel");
            addItem(ModItems.ALUMINUM_DIAMOND_HOE, "Diamond Hoe");
            addItem(ModItems.ALUMINUM_DIAMOND_POLISHER, "Diamond Polisher");

            //Netherite equipment
            addItem(ModItems.NETHERITE_POLISHER, "Netherite polisher");
            addItem(ModItems.NETHERITE_DAGGER, "Netherite dagger");

            //Plants
            addItem(ModItems.YERBA_MATE, "Yerba mate");
            addItem(ModItems.GROUNDED_YERBA_MATE, "Ground yerba mate");

            //Food
                //Wild
                addItem(ModItems.WILD_TOMATO, "Wild tomato");
                addItem(ModItems.WILD_CORN, "Wild corn");

                //Flour
                addItem(ModItems.WHEAT_FLOUR, "Wheat flour");
                addItem(ModItems.PUMPKIN_FLOUR, "Pumpkin flour");

                //Seeds
                addItem(ModItems.YERBA_MATE_SEEDS, "Yerba mate seeds");
                addItem(ModItems.ZAPALLO_SEEDS, "Anco pumpkin seeds");
                addItem(ModItems.TOMATO_SEEDS, "Tomato seeds");
                addItem(ModItems.CORN_SEEDS, "Corn seeds");
                addItem(ModItems.EGGPLANT_SEEDS, "Eggplant seeds");

                //Fruits
                addItem(ModItems.TOMATO, "Tomato");
                addItem(ModItems.LEMON, "Lemon");
                addItem(ModItems.LIME, "Lime");
                addItem(ModItems.ORANGE, "Orange");
                addItem(ModItems.WALNUT, "Walnut");
                addItem(ModItems.PEELED_WALNUT, "Peeled walnut");
                addItem(ModItems.GREEN_APPLE, "Green apple");

                //Vegetables
                addItem(ModItems.CORN, "Corn");
                addItem(ModItems.ZAPALLO, "Anco pumpkin");
                addItem(ModItems.EGGPLANT, "Eggplant");
                addItem(ModItems.RICE_GRAINS, "Rice grains");

                //Cooked
                addItem(ModItems.COOKED_CORN, "Cooked corn");
                addItem(ModItems.COOKED_ZAPALLO, "Cooked anco pumpkin");
                addItem(ModItems.COOKED_EGGPLANT, "Cooked eggplant");

                //Others
                addItem(ModItems.EMPTY_MATE, "Empty mate");
                addItem(ModItems.MATE, "Mate");
                addItem(ModItems.YEAST, "Yeast");
                addItem(ModItems.RICE_BOWL, "Rice bowl");

            //Smithing templates
            addSmithingTitles("Smithing template", "Applies to:", "Ingredients:");

            addSmithingTranslations("bronzium", "Bronzium upgrade", "Bronze equipment, Brass equipment", "Bronzium ingot",
                    "Add a bronze or brass armor, weapon or tool", "Add an bronzium ingot");
            addSmithingTranslations("aluminum", "Aluminum upgrade", "Tools with wooden handle", "Aluminum ingot",
                    "Add any tool with a wooden handle", "Add an aluminum ingot");

            //Enchantments
            addEnchantment(ModEnchantments.FINE_MINING, "Fine mining");
            addEnchantmentDesc("fine_mining", "When is applied, only the ore will be dropped from the block extraction");
            addEnchantment(ModEnchantments.ROUGH_MINING, "Curse of rough mining");
            addEnchantmentDesc("rough_mining", "When is applied, the block is crushed onto his primal components");
            addEnchantment(ModEnchantments.POISON_TOUCH, "Poison touch");
            addEnchantmentDesc("poison_touch", "Gives Poison to the target");
            addEnchantment(ModEnchantments.LIVING_TOUCH, "Living touch");
            addEnchantmentDesc("living_touch", "Gives Healing to the target");
            addEnchantment(ModEnchantments.SHARP_BLADE, "Bloody blade");
            addEnchantmentDesc("sharp_blade", "Gives Bleeding to the target");

        //Entities
            //Villagers
            addVillagerProfession("jeweler", "Jeweler");

            //Mobs
            addBandit("Bandit");
            addItem(ModItems.BANDIT_SPAWN_EGG, "Spawn bandit");
    }
}
