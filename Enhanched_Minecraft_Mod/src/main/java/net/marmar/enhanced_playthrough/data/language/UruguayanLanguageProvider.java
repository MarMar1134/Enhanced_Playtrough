package net.marmar.enhanced_playthrough.data.language;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.block.ModBlocks;
import net.marmar.enhanced_playthrough.util.enchantment.ModEnchantments;
import net.marmar.enhanced_playthrough.item.ModItems;
import net.minecraft.data.PackOutput;

public class UruguayanLanguageProvider extends AbstractModLanguageProvider{
    public UruguayanLanguageProvider(PackOutput output) {
        super(output, "es_uy");
    }

    @Override
    protected void addTranslations() {
        //Creative tabs
        addCreativeTab("weapons", "Armas y armaduras");
        addCreativeTab("tools", "Herramientas");
        addCreativeTab("aluminum_tools", "Herramientas de aluminio");
        addCreativeTab("minerals", "Minerales");
        addCreativeTab("jewelery", "Joyeria");
        addCreativeTab("utility", "Utiles");
        addCreativeTab("fruits", "Frutas y vegetales");
        addCreativeTab("saplings", "Semillas");
        addCreativeTab("woodtypes", "Madera");
        addCreativeTab("blocks", "Bloques varios");
        addCreativeTab("utility_blocks", "Bloques funcionales");

        //JEI
        addJeiCategory("adobe_furnace", "Fundición básica");
        addJeiCategory("soul_furnace", "Fundición básica de almas");
        addJeiCategory("masonry_furnace", "Horno de mamposteria");
        addJeiCategory("adobe_alloying_furnace", "Aleación");
        addJeiCategory("super_alloying_furnace", "Alta aleación");
        addJeiCategory("gem_polisher", "Pulido de gemas");
        addJeiCategory("primal_grinder", "Molienda");
        addJeiCategory("mechanical_grinder", "Molienda mecánizada");

        //Jade
        addJadeConfigTranslation("basic_furnace", "Hornos primitívos");

        addJadeConfigTranslation("masonry_furnace", "Horno de mamposteria");

        addJadeConfigTranslation("alloy_furnace", "Hornos de aleación");

        addJadeConfigTranslation("gem_polisher", "Pulido de gemas");
        this.add("jade." + EnhancedPlaythrough.MOD_ID + ".gem_polisher_uses", "Usos restantes: %d");

        addJadeConfigTranslation("grinder", "Molienda");

        //GUI elements
        addGuiElements("gem_polisher_screen", "Usos");

        //Descriptions
        addDescription("aluminum_tool", "Mango de aluminio: 20% mayor durabilidad");
        addDescription("polisher_item","Utilizado en el pulidor de gemas como combustible");
        addDescription("silver_armor", "Con toda la equipación: otorga Apuro al jugador");
        addDescription("rose_gold_armor", "Con toda la equipación: otorga Apuro al jugador");
        addDescription("bronzium_armor", "Con toda la equipación: otorga Resistencia al fuego al jugador");
        addDescription("green_gold_armor", "Con toda la equipación: otorga Apuro II al jugador");
        addDescription("blue_gold_armor", "Con toda la equipación: otorga Apuro II al jugador");
        addDescription("dagger_bleed", "Probabilidad de sangrado: ");

        //Sounds
        addSoundDescription("grind", "Molienda activada");

        //Death messages
        addDeathMessages("tallReed", "ha muerto pinchado por un carrizo",
                "ha muerto pinchado por un carrizo mientras escapaba de");
        addDeathMessages("cobble", "ha muerto de un piedrazo en la cabeza",
                "ha muerto de un piedrazo en la cabeza mientras luchaba con");
        addDeathMessages("bleed", "ha muerto desangrado", "ha muerto desangrado mientras huia de");

        //Mob effects
        addMobEffect("bleeding", "Sangrado");

        //Advancements
            //Survival
            addSurvivalAdvancement("root", "Enhanced Playthrough",
                    "Iniciaste una nueva aventura en este mundo fantástico, ¡bienvenido!");
            addSurvivalAdvancement("stone_age", "Un asunto adoquinado",
                    "Obtené un pedazo de adoquín");
            addSurvivalAdvancement("unity_makes_strength", "La unión hace la fuerza",
                    "Crafteá un horno de aleación");
            addSurvivalAdvancement("blossom", "Bombón",
                    "Fundí oro y cobre para obtener oro rosado");
            addSurvivalAdvancement("buttercup", "Bellota",
                    "Fundí oro y plata para obtener oro verde");
            addSurvivalAdvancement("bubbles", "Búrbuja",
                    "Fundí oro y cobalto para obtener oro azul");
            addSurvivalAdvancement("the_goldenpuff_girls", "Las chicas súper-doradas",
                    "Conseguí las tres aleaciones de oro");
            addSurvivalAdvancement("thats_new", "Eso... es nuevo",
                    "Obtené un lingote de bronce");
            addSurvivalAdvancement( "abrassive_heat", "Platón, el herrero",
                    "Obtené un lingote de latón");
            addSurvivalAdvancement( "mighty_bronze", "Bronceado divino",
                    "Obtené un pico de bronce");
            addSurvivalAdvancement("steel_isnt_enough", "No tiende a-cero",
                    "Utilizá tu horno de aleación para fundir algo de acero");

            //Gems
            addGemAdvancement("root", "Los colores del mundo",
                    "Nuestro mundo reluce en colores, y las gemas representan bien eso");
            addGemAdvancement("polish_emerald", "Intento de grinch",
                    "Consegui algunas esmeraldas y cuidalas de los, ¿quienes?");
            addGemAdvancement("polish_sapphire", "Horizonte azulado",
                    "Consegui algunos záfiros y visitá un rato el mar");
            addGemAdvancement("polish_ruby", "Pajarito enojón",
                    "Consegui algunos rubies y mostrale a los cerdos quién manda");
            addGemAdvancement("polish_garnet", "El color de mi corazón",
                    "Consegui algunos granates y demostrá tu pasión");
            addGemAdvancement("polish_diamond", "Estás acá, Lucy?",
                    "Consegui algunos diamantes para poder ver mejor el cielo");
            addGemAdvancement("get_all_gems", "Caos por doquier",
                    "Consegui todas las gemas y convertite en el señor del caos");

        //Entities
        addBoatEntity("Barco");
        addChestBoatEntity("Barco con cofre");
        addThrowableCobbleEntity("Adoquín");

        //Blocks
            //Wild crops
            addBlock(ModBlocks.WILD_WHEAT, "Trigo silvestre");
            addBlock(ModBlocks.WILD_TOMATO, "Tomate silvestre");
            addBlock(ModBlocks.WILD_CORN, "Maiz silvestre");

            //Plants
            addBlock(ModBlocks.TALL_REEDS, "Carrizo");
            addBlock(ModBlocks.REEDS, "Plumero");
            addBlock(ModBlocks.SMALL_REEDS, "Plumero andino");
            addBlock(ModBlocks.WATER_REEDS, "Junco");

            //Wood
                //Apple
                addBlock(ModBlocks.APPLE_SAPLING, "Brote de manzano");
                addBlock(ModBlocks.APPLE_LEAVES, "Hojas de manzano");
                addBlock(ModBlocks.APPLE_LOG, "Tronco de manzano");
                addBlock(ModBlocks.STRIPPED_APPLE_LOG, "Tronco de manzano pelado");
                addBlock(ModBlocks.APPLE_WOOD, "Leño de manzana");
                addBlock(ModBlocks.STRIPPED_APPLE_WOOD, "Leño de manzano pelado");
                addBlock(ModBlocks.APPLE_PLANKS, "Tablones de manzano");
                addBlock(ModBlocks.APPLE_SLAB, "Baldosa de manzano");
                addBlock(ModBlocks.APPLE_STAIRS, "Escaleras de manzano");
                addBlock(ModBlocks.APPLE_FENCE, "Varandilla de manzano");
                addBlock(ModBlocks.APPLE_FENCEGATE, "Puerta de varandilla de manzano");
                addBlock(ModBlocks.APPLE_DOOR, "Puerta de manzano");
                addBlock(ModBlocks.APPLE_TRAPDOOR, "Trampilla de manzano");
                addBlock(ModBlocks.APPLE_BUTTON, "Botón de manzano");
                addBlock(ModBlocks.APPLE_PRESSURE_PLATE, "Placa de presión de manzano");
                addSign(ModItems.APPLE_SIGN, "Cartel de manzano");
                addHangingSign(ModItems.APPLE_HANGING_SIGN,"Cartel de manzano colgante");
                addItem(ModItems.APPLE_BOAT, "Barco de manzano");
                addItem(ModItems.APPLE_CHEST_BOAT, "Barco de manzano con cofre");

                //Green apple
                addBlock(ModBlocks.GREEN_APPLE_SAPLING, "Brote de manzano verde");
                addBlock(ModBlocks.GREEN_APPLE_LEAVES, "Hojas de manzano verde");

                //Walnut
                addBlock(ModBlocks.WALNUT_SAPLING, "Brote de nogal");
                addBlock(ModBlocks.WALNUT_LEAVES, "Hojas de nogal");
                addBlock(ModBlocks.WALNUT_LOG, "Tronco de nogal");
                addBlock(ModBlocks.STRIPPED_WALNUT_LOG, "Tronco de nogal pelado");
                addBlock(ModBlocks.WALNUT_WOOD, "Leño de nogal");
                addBlock(ModBlocks.STRIPPED_WALNUT_WOOD, "Leño de nogal pelado");
                addBlock(ModBlocks.WALNUT_PLANKS, "Tablones de nogal");
                addBlock(ModBlocks.WALNUT_SLAB, "Baldosa de nogal");
                addBlock(ModBlocks.WALNUT_STAIRS, "Escaleras de nogal");
                addBlock(ModBlocks.WALNUT_FENCE, "Varandilla de nogal");
                addBlock(ModBlocks.WALNUT_FENCEGATE, "Puerta de varandilla de nogal");
                addBlock(ModBlocks.WALNUT_DOOR, "Puerta de nogal");
                addBlock(ModBlocks.WALNUT_TRAPDOOR, "Trampilla de nogal");
                addBlock(ModBlocks.WALNUT_BUTTON, "Botón de nogal");
                addBlock(ModBlocks.WALNUT_PRESSURE_PLATE, "Placa de presión de nogal");
                addSign(ModItems.WALNUT_SIGN, "Cartel de nogal");
                addHangingSign(ModItems.WALNUT_HANGING_SIGN,"Cartel de nogal colgante");
                addItem(ModItems.WALNUT_BOAT, "Barco de nogal");
                addItem(ModItems.WALNUT_CHEST_BOAT, "Barco de nogal con cofre");

                //Orange
                addBlock(ModBlocks.ORANGE_SAPLING, "Brote de naranjo");
                addBlock(ModBlocks.ORANGE_LEAVES, "Hojas de naranjo");
                addBlock(ModBlocks.ORANGE_LOG, "Tronco de naranjo");
                addBlock(ModBlocks.STRIPPED_ORANGE_LOG, "Tronco de naranjo pelado");
                addBlock(ModBlocks.ORANGE_WOOD, "Leño de naranjo");
                addBlock(ModBlocks.STRIPPED_ORANGE_WOOD, "Leño de naranjo pelado");
                addBlock(ModBlocks.ORANGE_PLANKS, "Tablones de naranjo");
                addBlock(ModBlocks.ORANGE_SLAB, "Baldosa de naranjo");
                addBlock(ModBlocks.ORANGE_STAIRS, "Escaleras de naranjo");
                addBlock(ModBlocks.ORANGE_FENCE, "Varandilla de naranjo");
                addBlock(ModBlocks.ORANGE_FENCEGATE, "Puerta de varandilla de naranjo");
                addBlock(ModBlocks.ORANGE_DOOR, "Puerta de naranjo");
                addBlock(ModBlocks.ORANGE_TRAPDOOR, "Trampilla de naranjo");
                addBlock(ModBlocks.ORANGE_BUTTON, "Botón de naranjo");
                addBlock(ModBlocks.ORANGE_PRESSURE_PLATE, "Placa de presión de naranjo");
                addSign(ModItems.ORANGE_SIGN, "Cartel de naranjo");
                addHangingSign(ModItems.ORANGE_HANGING_SIGN,"Cartel de naranjo colgante");
                addItem(ModItems.ORANGE_BOAT, "Barco de naranjo");
                addItem(ModItems.ORANGE_CHEST_BOAT, "Barco de naranjo con cofre");

                //Lemon
                addBlock(ModBlocks.LEMON_SAPLING, "Brote de limonero");
                addBlock(ModBlocks.LEMON_LEAVES, "Hojas de limonero");
                addBlock(ModBlocks.LEMON_LOG, "Tronco de limonero");
                addBlock(ModBlocks.STRIPPED_LEMON_LOG, "Tronco de limonero pelado");
                addBlock(ModBlocks.LEMON_WOOD, "Leño de limonero");
                addBlock(ModBlocks.STRIPPED_LEMON_WOOD, "Leño de limonero pelado");
                addBlock(ModBlocks.LEMON_PLANKS, "Tablones de limonero");
                addBlock(ModBlocks.LEMON_SLAB, "Baldosa de limonero");
                addBlock(ModBlocks.LEMON_STAIRS, "Escaleras de limonero");
                addBlock(ModBlocks.LEMON_FENCE, "Varandilla de limonero");
                addBlock(ModBlocks.LEMON_FENCEGATE, "Puerta de varandilla de limonero");
                addBlock(ModBlocks.LEMON_DOOR, "Puerta de limonero");
                addBlock(ModBlocks.LEMON_TRAPDOOR, "Trampilla de limonero");
                addBlock(ModBlocks.LEMON_BUTTON, "Botón de limonero");
                addBlock(ModBlocks.LEMON_PRESSURE_PLATE, "Placa de presión de limonero");
                addSign(ModItems.LEMON_SIGN, "Cartel de limonero");
                addHangingSign(ModItems.LEMON_HANGING_SIGN,"Cartel de limonero colgante");
                addItem(ModItems.LEMON_BOAT, "Barco de limonero");
                addItem(ModItems.LEMON_CHEST_BOAT, "Barco de limonero con cofre");

                //Lime
                addBlock(ModBlocks.LIME_SAPLING, "Brote de limera");
                addBlock(ModBlocks.LIME_LEAVES, "Hojas de limera");

        //Polished stone
        addBlock(ModBlocks.POLISHED_STONE, "Piedra pulida");
        addBlock(ModBlocks.POLISHED_STONE_SLAB, "Baldosa de piedra pulida");
        addBlock(ModBlocks.POLISHED_STONE_STAIRS, "Escaleras de piedra pulida");
        addBlock(ModBlocks.POLISHED_STONE_WALL, "Pared de piedra pulida");

        //Cobbled limestone
        addBlock(ModBlocks.COBBLED_LIMESTONE, "Adoquin de piedra caliza");
        addBlock(ModBlocks.COBBLED_LIMESTONE_SLAB, "Baldosa de adoquines de piedra caliza");
        addBlock(ModBlocks.COBBLED_LIMESTONE_STAIRS, "Escaleras de adoquines de piedra caliza");
        addBlock(ModBlocks.COBBLED_LIMESTONE_WALL, "Pared de adoquines de piedra caliza");

        //Limestone
        addBlock(ModBlocks.LIMESTONE, "Piedra caliza");
        addBlock(ModBlocks.LIMESTONE_SLAB, "Baldosa de piedra caliza");
        addBlock(ModBlocks.LIMESTONE_STAIRS, "Escaleras de piedra caliza");
        addBlock(ModBlocks.LIMESTONE_WALL, "Pared de piedra caliza");

        //Polished limestone
        addBlock(ModBlocks.POLISHED_LIMESTONE, "Piedra caliza pulida");
        addBlock(ModBlocks.POLISHED_LIMESTONE_SLAB, "Baldosa de piedra caliza pulida");
        addBlock(ModBlocks.POLISHED_LIMESTONE_STAIRS, "Escaleras de piedra caliza pulida");
        addBlock(ModBlocks.POLISHED_LIMESTONE_WALL, "Pared de piedra caliza pulida");

        //Limestone bricks
        addBlock(ModBlocks.LIMESTONE_BRICKS, "Ladrillos de piedra caliza");
        addBlock(ModBlocks.LIMESTONE_BRICK_SLAB, "Baldosa de ladrillos de piedra caliza");
        addBlock(ModBlocks.LIMESTONE_BRICK_STAIRS, "Escaleras de ladrillos de piedra caliza");
        addBlock(ModBlocks.LIMESTONE_BRICK_WALL, "Pared de ladrillos de piedra caliza");

        //Soul
        addBlock(ModBlocks.SOUL_MUD, "Barro de almas");
        addBlock(ModBlocks.SOUL_MUD_BRICKS, "Ladrillos de adobe de almas");
        addBlock(ModBlocks.SOUL_MUD_BRICK_SLAB, "Baldosa de ladrillos de adobe de almas");
        addBlock(ModBlocks.SOUL_MUD_BRICK_STAIRS, "Escaleras de ladrillos de adobe de almas");
        addBlock(ModBlocks.SOUL_MUD_BRICK_WALL, "Pared de ladrillos de adobe de almas");

        //Firebricks
        addBlock(ModBlocks.FIREBRICKS, "Ladrillos refractarios");
        addBlock(ModBlocks.FIREBRICK_SLAB, "Baldosa de ladrillos refractarios");
        addBlock(ModBlocks.FIREBRICK_STAIRS, "Escaleras de ladrillos refractarios");
        addBlock(ModBlocks.FIREBRICK_WALL, "Pared de ladrillos refractarios");

        //Ores
        addBlock(ModBlocks.TIN_ORE, "Mineral de estaño");
        addBlock(ModBlocks.DEEPSLATE_TIN_ORE, "Mineral de estaño de pizarra profunda");
        addBlock(ModBlocks.ZINC_ORE, "Mineral de zinc");
        addBlock(ModBlocks.DEEPSLATE_ZINC_ORE, "Mineral de zinc de pizarra profunda");
        addBlock(ModBlocks.NETHER_ZINC_ORE, "Mineral de zinc del nether");
        addBlock(ModBlocks.NETHER_COPPER_ORE, "Mineral de cobre del nether");
        addBlock(ModBlocks.SULFUR_ORE, "Mineral de azufre");
        addBlock(ModBlocks.DEEPSLATE_SULFUR_ORE, "Mineral de azufre de pizarra profunda");
        addBlock(ModBlocks.NETHER_SULFUR_ORE, "Mineral de azufre del nether");
        addBlock(ModBlocks.SILVER_ORE, "Mineral de plata");
        addBlock(ModBlocks.DEEPSLATE_SILVER_ORE, "Mineral de plata de pizarra profunda");
        addBlock(ModBlocks.SAPPHIRE_ORE, "Mineral de zafiro");
        addBlock(ModBlocks.DEEPSLATE_SAPPHIRE_ORE, "Mineral de zaphiro de pizarra profunda");
        addBlock(ModBlocks.RUBY_ORE, "Mineral de rubi");
        addBlock(ModBlocks.DEEPSLATE_RUBY_ORE, "Mineral de rubi de pizarra profunda");
        addBlock(ModBlocks.NETHER_GARNET_ORE, "Mineral de granate del nether");
        addBlock(ModBlocks.COBALT_ORE, "Mineral de cobalto");
        addBlock(ModBlocks.DEEPSLATE_COBALT_ORE, "Mineral de cobalto de pizarra profunda");
        addBlock(ModBlocks.BAUXITE, "Bauxita");
        addBlock(ModBlocks.WHITE_BAUXITE, "Bauxita blanca");
        addBlock(ModBlocks.LIGHT_GRAY_BAUXITE, "Bauxita gris claro");
        addBlock(ModBlocks.BROWN_BAUXITE, "Bauxita marrón");
        addBlock(ModBlocks.RED_BAUXITE, "Bauxita roja");
        addBlock(ModBlocks.ORANGE_BAUXITE, "Bauxita naranja");
        addBlock(ModBlocks.YELLOW_BAUXITE, "Bauxita amarilla");

        //Ore blocks
        addBlock(ModBlocks.RAW_TIN_BLOCK, "Bloque de estaño crudo");
        addBlock(ModBlocks.TIN_BLOCK, "Bloque de estaño");
        addBlock(ModBlocks.RAW_ZINC_BLOCK, "Bloque de zinc crudo");
        addBlock(ModBlocks.ZINC_BLOCK, "Bloque de zinc");
        addBlock(ModBlocks.RAW_SILVER_BLOCK, "Bloque de plata cruda");
        addBlock(ModBlocks.SILVER_BLOCK, "Bloque de plata");
        addBlock(ModBlocks.RAW_ALUMINUM_BLOCK, "Bloque de aluminio crudo");
        addBlock(ModBlocks.ALUMINUM_BLOCK, "Bloque de aluminio");
        addBlock(ModBlocks.BRASS_BLOCK, "Bloque de latón");
        addBlock(ModBlocks.BRONZE_BLOCK, "Bloque de bronce");
        addBlock(ModBlocks.ROSE_GOLD_BLOCK, "Bloque de oro rosado");
        addBlock(ModBlocks.BRONZIUM_BLOCK, "Bloque de broncio");
        addBlock(ModBlocks.GREEN_GOLD_BLOCK, "Bloque de oro verde");
        addBlock(ModBlocks.STEEL_BLOCK, "Bloque de acero");
        addBlock(ModBlocks.BLUE_GOLD_BLOCK, "Bloque de oro azul");

        //Block entities
        addBlock(ModBlocks.ADOBE_FURNACE, "Horno de barro");
        addBlock(ModBlocks.SOUL_FURNACE, "Horno de barro de almas");
        addBlock(ModBlocks.MASONRY_FURNACE, "Horno de mamposteria");
        addBlock(ModBlocks.ADOBE_ALLOYING_FURNACE, "Horno de aleación de larillos");
        addBlock(ModBlocks.SOUL_ALLOY_FURNACE, "Horno de aleación de almas");
        addBlock(ModBlocks.SUPER_ALLOYING_FURNACE, "Alto horno de aleación");
        addBlock(ModBlocks.GEM_POLISHER, "Mesa de pulido");
        addBlock(ModBlocks.PRIMAL_GRINDER, "Moledora");
        addBlock(ModBlocks.MECHANICAL_GRINDER, "Moledora mecánizada");

        //Items
            //Raw ores
            addItem(ModItems.RAW_TIN, "Estaño crudo");
            addItem(ModItems.RAW_ZINC, "Zinc crudo");
            addItem(ModItems.RAW_SILVER, "Plata cruda");
            addItem(ModItems.RAW_ALUMINUM, "Aluminio crudo");
            addItem(ModItems.RAW_EMERALD, "Esmeralda impura");
            addItem(ModItems.RAW_SAPPHIRE, "Zafiro impuro");
            addItem(ModItems.RAW_RUBY, "Rubi impuro");
            addItem(ModItems.RAW_GARNET, "Granate impuro");
            addItem(ModItems.RAW_DIAMOND, "Diamante impuro");

            //Materials and melted ores
            addItem(ModItems.TIN_INGOT, "Lingote de estaño");
            addItem(ModItems.TIN_NUGGET, "Pepita de estaño");
            addItem(ModItems.ZINC_INGOT, "Lingote de zinc");
            addItem(ModItems.ZINC_NUGGET, "Pepita de zinc");
            addItem(ModItems.SULFUR, "Azufre");
            addItem(ModItems.SILVER_INGOT, "Lingote de plata");
            addItem(ModItems.SILVER_NUGGET, "Pepita de plata");
            addItem(ModItems.ALUMINUM_INGOT, "Lingote de aluminio");
            addItem(ModItems.ALUMINUM_NUGGET, "Pepita de aluminio");
            addItem(ModItems.COPPER_NUGGET, "Pepita de cobre");
            addItem(ModItems.BRASS_INGOT, "Lingote de latón");
            addItem(ModItems.BRASS_NUGGET, "Pepita de latón");
            addItem(ModItems.BRONZE_INGOT, "Lingote de bronce");
            addItem(ModItems.BRONZE_NUGGET, "Pepita de bronce");
            addItem(ModItems.ROSE_GOLD_INGOT, "Lingote de oro rosado");
            addItem(ModItems.ROSE_GOLD_NUGGET, "Pepita de oro rosado");
            addItem(ModItems.BRONZIUM_INGOT, "Lingote de broncio");
            addItem(ModItems.BRONZIUM_NUGGET, "Pepita de broncio");
            addItem(ModItems.GREEN_GOLD_INGOT, "Lingote de oro verde");
            addItem(ModItems.GREEN_GOLD_NUGGET, "Pepita de oro verde");
            addItem(ModItems.STEEL_INGOT, "Lingote de acero");
            addItem(ModItems.STEEL_NUGGET, "Pepita de acero");
            addItem(ModItems.BLUE_GOLD_INGOT, "Lingote de oro azul");
            addItem(ModItems.BLUE_GOLD_NUGGET, "Pepita de oro verde");
            addItem(ModItems.SAPPHIRE, "Zafiro");
            addItem(ModItems.RUBY, "Rubí");
            addItem(ModItems.GARNET, "Granate");

            //Others
            addItem(ModItems.MUD_BRICK, "Ladrillo de adobe");
            addItem(ModItems.FIREBRICK, "Ladrillo refractario");
            addItem(ModItems.ALUMINUM_ROD, "Vara de aluminio");
            addItem(ModItems.COBALT, "Cobalto");
            addItem(ModItems.REED_HEAD, "Cabeza de caña");
            addItem(ModItems.WATER_REED_HEAD, "Cabeza de junco");
            addItem(ModItems.VEGETABLE_FIBBER, "Fibra vegetal");

            //Cobble
            addItem(ModItems.COBBLE, "Adoquín");
            addItem(ModItems.LIMESTONE_COBBLE, "Adoquín de piedra caliza");
            addItem(ModItems.DEEPSLATE_COBBLE, "Adoquín de pizarra profunda");
            addItem(ModItems.NETHERRACK_RUBBLE, "Restos de netherrack");
            addItem(ModItems.BLACKSTONE_COBBLE, "Adoquín de piedra negra");

            //Terracotta shards
            addItem(ModItems.TERRACOTTA_SHARD, "Fragmento de terracota");
            addItem(ModItems.WHITE_TERRACOTTA_SHARD, "Fragmento de terracota blanca");
            addItem(ModItems.ORANGE_TERRACOTTA_SHARD, "Fragmento de terracota naranja");
            addItem(ModItems.MAGENTA_TERRACOTTA_SHARD, "Fragmento de terracota magenta");
            addItem(ModItems.LIGHT_BLUE_TERRACOTTA_SHARD, "Fragmento de terracota celeste");
            addItem(ModItems.YELLOW_TERRACOTTA_SHARD, "Fragmento de terracota amarilla");
            addItem(ModItems.LIME_TERRACOTTA_SHARD, "Fragmento de terracota lima");
            addItem(ModItems.PINK_TERRACOTTA_SHARD, "Fragmento de terracota rosada");
            addItem(ModItems.GRAY_TERRACOTTA_SHARD, "Fragmento de terracota gris");
            addItem(ModItems.LIGHT_GRAY_TERRACOTTA_SHARD, "Fragmento de terracota gris claro");
            addItem(ModItems.CYAN_TERRACOTTA_SHARD, "Fragmento de terracota cian");
            addItem(ModItems.PURPLE_TERRACOTTA_SHARD, "Fragmento de terracota morada");
            addItem(ModItems.BLUE_TERRACOTTA_SHARD, "Fragmento de terracota azul");
            addItem(ModItems.BROWN_TERRACOTTA_SHARD, "Fragmento de terracota marrón");
            addItem(ModItems.GREEN_TERRACOTTA_SHARD, "Fragmento de terracota verde");
            addItem(ModItems.RED_TERRACOTTA_SHARD, "Fragmento de terracota roja");
            addItem(ModItems.BLACK_TERRACOTTA_SHARD, "Fragmento de terracota negra");

            //Dusts
            addItem(ModItems.GOLD_DUST, "Pólvo de oro");
            addItem(ModItems.SILVER_DUST, "Pólvo de plata");
            addItem(ModItems.ALUMINUM_DUST, "Pólvo de aluminio");
            addItem(ModItems.ZINC_DUST, "Pólvo de zinc");
            addItem(ModItems.TIN_DUST, "Pólvo de estaño");
            addItem(ModItems.COPPER_DUST, "Pólvo de cobre");
            addItem(ModItems.BRASS_DUST, "Pólvo de latón");
            addItem(ModItems.BRONZE_DUST, "Pólvo de bronce");
            addItem(ModItems.ROSE_GOLD_DUST, "Pólvo de oro rosado");
            addItem(ModItems.IRON_DUST, "Pólvo de hierro");
            addItem(ModItems.BRONZIUM_DUST, "Pólvo de broncio");
            addItem(ModItems.GREEN_GOLD_DUST, "Pólvo de oro verde");
            addItem(ModItems.STEEL_DUST, "Pólvo de acero");
            addItem(ModItems.BLUE_GOLD_DUST, "Pólvo de oro azul");

            //Acids and potions
            addAcid("sulfuric_acid", "Ácido sulfurico");

        //Other tools
        addItem(ModItems.FLINT_AND_COBBLE, "Encendedor de adoquines");
        addItem(ModItems.FLINT_AND_BRONZE, "Encendedor de bronce");

        //Silver equipment
        addItem(ModItems.SILVER_SWORD, "Espada de plata");
        addItem(ModItems.SILVER_DAGGER, "Daga de plata");
        addItem(ModItems.SILVER_PICKAXE, "Pico de plata");
        addItem(ModItems.SILVER_AXE, "Hacha de plata");
        addItem(ModItems.SILVER_SHOVEL, "Pala de plata");
        addItem(ModItems.SILVER_HOE, "Azada de plata");
        addItem(ModItems.SILVER_POLISHER, "Pulidora de plata");
        addItem(ModItems.SILVER_HELMET, "Casco de plata");
        addItem(ModItems.SILVER_CHESTPLATE, "Pechera de plata");
        addItem(ModItems.SILVER_LEGGINGS, "Pantalones de plata");
        addItem(ModItems.SILVER_BOOTS, "Botas de plata");

        addItem(ModItems.ALUMINUM_SILVER_SWORD, "Espada de plata");
        addItem(ModItems.ALUMINUM_SILVER_DAGGER, "Daga de plata");
        addItem(ModItems.ALUMINUM_SILVER_PICKAXE, "Pico de plata");
        addItem(ModItems.ALUMINUM_SILVER_AXE, "Hacha de plata");
        addItem(ModItems.ALUMINUM_SILVER_SHOVEL, "Pala de plata");
        addItem(ModItems.ALUMINUM_SILVER_HOE, "Azadón de plata");
        addItem(ModItems.ALUMINUM_SILVER_POLISHER, "Pulidora de plata");

        //Gold equipment
        addItem(ModItems.GOLDEN_POLISHER, "Pulidora de oro");
        addItem(ModItems.GOLDEN_DAGGER, "Daga de oro");

        addItem(ModItems.ALUMINUM_GOLDEN_SWORD, "Espada de oro");
        addItem(ModItems.ALUMINUM_GOLDEN_DAGGER, "Daga de oro");
        addItem(ModItems.ALUMINUM_GOLDEN_PICKAXE, "Pico de oro");
        addItem(ModItems.ALUMINUM_GOLDEN_AXE, "Hacha de oro");
        addItem(ModItems.ALUMINUM_GOLDEN_SHOVEL, "Pala de oro");
        addItem(ModItems.ALUMINUM_GOLDEN_HOE, "Azadón de oro");
        addItem(ModItems.ALUMINUM_GOLDEN_POLISHER, "Pulidora de oro");

        //Wood equipment
        addItem(ModItems.WOODEN_DAGGER, "Daga de madera");

        addItem(ModItems.ALUMINUM_WOODEN_SWORD, "Espada de madera");
        addItem(ModItems.ALUMINUM_WOODEN_DAGGER, "Daga de madera");
        addItem(ModItems.ALUMINUM_WOODEN_PICKAXE, "Pico de madera");
        addItem(ModItems.ALUMINUM_WOODEN_AXE, "Hacha de madera");
        addItem(ModItems.ALUMINUM_WOODEN_SHOVEL, "Pala de madera");
        addItem(ModItems.ALUMINUM_WOODEN_HOE, "Azadón de madera");

        //Stone equipment
        addItem(ModItems.STONE_POLISHER, "Pulidora de piedra");
        addItem(ModItems.STONE_DAGGER, "Daga de piedra");

        addItem(ModItems.ALUMINUM_STONE_SWORD, "Espada de piedra");
        addItem(ModItems.ALUMINUM_STONE_DAGGER, "Daga de piedra");
        addItem(ModItems.ALUMINUM_STONE_PICKAXE, "Pico de piedra");
        addItem(ModItems.ALUMINUM_STONE_AXE, "Hacha de piedra");
        addItem(ModItems.ALUMINUM_STONE_SHOVEL, "Pala de piedra");
        addItem(ModItems.ALUMINUM_STONE_HOE, "Azadón de piedra");
        addItem(ModItems.ALUMINUM_STONE_POLISHER, "Pulidora de piedra");

        //Brass equipment
        addItem(ModItems.BRASS_SWORD, "Espada de latón");
        addItem(ModItems.BRASS_DAGGER, "Daga de latón");
        addItem(ModItems.BRASS_PICKAXE, "Pico de latón");
        addItem(ModItems.BRASS_AXE, "Hacha de latón");
        addItem(ModItems.BRASS_SHOVEL, "Pala de latón");
        addItem(ModItems.BRASS_HOE, "Azada de latón");
        addItem(ModItems.BRASS_POLISHER, "Pulidora de latón");
        addItem(ModItems.BRASS_HELMET, "Casco de latón");
        addItem(ModItems.BRASS_CHESTPLATE, "Pechera de latón");
        addItem(ModItems.BRASS_LEGGINGS, "Pantalones de latón");
        addItem(ModItems.BRASS_BOOTS, "Botas de latón");

        addItem(ModItems.ALUMINUM_BRASS_SWORD, "Espada de latón");
        addItem(ModItems.ALUMINUM_BRASS_DAGGER, "Daga de latón");
        addItem(ModItems.ALUMINUM_BRASS_PICKAXE, "Pico de latón");
        addItem(ModItems.ALUMINUM_BRASS_AXE, "Hacha de latón");
        addItem(ModItems.ALUMINUM_BRASS_SHOVEL, "Pala de latón");
        addItem(ModItems.ALUMINUM_BRASS_HOE, "Azadón de latón");
        addItem(ModItems.ALUMINUM_BRASS_POLISHER, "Pulidora de latón");

        //Bronze equipment
        addItem(ModItems.BRONZE_SWORD, "Espada de bronce");
        addItem(ModItems.BRONZE_DAGGER, "Daga de bronce");
        addItem(ModItems.BRONZE_PICKAXE, "Pico de bronce");
        addItem(ModItems.BRONZE_AXE, "Hacha de bronce");
        addItem(ModItems.BRONZE_SHOVEL, "Pala de bronce");
        addItem(ModItems.BRONZE_HOE, "Azada de bronce");
        addItem(ModItems.BRONZE_POLISHER, "Pulidora de bronce");
        addItem(ModItems.BRONZE_HELMET, "Casco de bronce");
        addItem(ModItems.BRONZE_CHESTPLATE, "Pechera de bronce");
        addItem(ModItems.BRONZE_LEGGINGS, "Pantalones de bronce");
        addItem(ModItems.BRONZE_BOOTS, "Botas de bronce");

        addItem(ModItems.ALUMINUM_BRONZE_SWORD, "Espada de bronce");
        addItem(ModItems.ALUMINUM_BRONZE_DAGGER, "Daga de bronce");
        addItem(ModItems.ALUMINUM_BRONZE_PICKAXE, "Pico de bronce");
        addItem(ModItems.ALUMINUM_BRONZE_AXE, "Hacha de bronce");
        addItem(ModItems.ALUMINUM_BRONZE_SHOVEL, "Pala de bronce");
        addItem(ModItems.ALUMINUM_BRONZE_HOE, "Azadón de bronce");
        addItem(ModItems.ALUMINUM_BRONZE_POLISHER, "Pulidora de bronce");

        //Rose golden equipment
        addItem(ModItems.ROSE_GOLDEN_SWORD, "Espada de oro rosado");
        addItem(ModItems.ROSE_GOLDEN_DAGGER, "Daga de oro rosado");
        addItem(ModItems.ROSE_GOLDEN_PICKAXE, "Pico de oro rosado");
        addItem(ModItems.ROSE_GOLDEN_AXE, "Hacha de oro rosado");
        addItem(ModItems.ROSE_GOLDEN_SHOVEL, "Pala de oro rosado");
        addItem(ModItems.ROSE_GOLDEN_HOE, "Azada de oro rosado");
        addItem(ModItems.ROSE_GOLDEN_POLISHER, "Pulidora de oro rosado");
        addItem(ModItems.ROSE_GOLDEN_HELMET, "Casco de oro rosado");
        addItem(ModItems.ROSE_GOLDEN_CHESTPLATE, "Pechera de oro rosado");
        addItem(ModItems.ROSE_GOLDEN_LEGGINGS, "Pantalones de oro rosado");
        addItem(ModItems.ROSE_GOLDEN_BOOTS, "Botas de oro rosado");

        addItem(ModItems.ALUMINUM_ROSE_GOLDEN_SWORD, "Espada de oro rosado");
        addItem(ModItems.ALUMINUM_ROSE_GOLDEN_DAGGER, "Daga de oro rosado");
        addItem(ModItems.ALUMINUM_ROSE_GOLDEN_PICKAXE, "Pico de oro rosado");
        addItem(ModItems.ALUMINUM_ROSE_GOLDEN_AXE, "Hacha de oro rosado");
        addItem(ModItems.ALUMINUM_ROSE_GOLDEN_SHOVEL, "Pala de oro rosado");
        addItem(ModItems.ALUMINUM_ROSE_GOLDEN_HOE, "Azadón de oro rosado");
        addItem(ModItems.ALUMINUM_ROSE_GOLDEN_POLISHER, "Pulidora de oro rosado");

        //Bronzium equipment
        addItem(ModItems.BRONZIUM_SWORD, "Espada de broncio");
        addItem(ModItems.BRONZIUM_DAGGER, "Daga de broncio");
        addItem(ModItems.BRONZIUM_PICKAXE, "Pico de broncio");
        addItem(ModItems.BRONZIUM_AXE, "Hacha de broncio");
        addItem(ModItems.BRONZIUM_SHOVEL, "Pala de broncio");
        addItem(ModItems.BRONZIUM_HOE, "Azada de broncio");
        addItem(ModItems.BRONZIUM_POLISHER, "Pulidora de broncio");
        addItem(ModItems.BRONZIUM_HELMET, "Casco de broncio");
        addItem(ModItems.BRONZIUM_CHESTPLATE, "Pechera de broncio");
        addItem(ModItems.BRONZIUM_LEGGINGS, "Pantalones de broncio");
        addItem(ModItems.BRONZIUM_BOOTS, "Botas de broncio");

        addItem(ModItems.ALUMINUM_BRONZIUM_SWORD, "Espada de broncio");
        addItem(ModItems.ALUMINUM_BRONZIUM_DAGGER, "Daga de broncio");
        addItem(ModItems.ALUMINUM_BRONZIUM_PICKAXE, "Pico de broncio");
        addItem(ModItems.ALUMINUM_BRONZIUM_AXE, "Hacha de broncio");
        addItem(ModItems.ALUMINUM_BRONZIUM_SHOVEL, "Pala de broncio");
        addItem(ModItems.ALUMINUM_BRONZIUM_HOE, "Azadón de broncio");
        addItem(ModItems.ALUMINUM_BRONZIUM_POLISHER, "Pulidora de broncio");

        //Iron equipment
        addItem(ModItems.IRON_POLISHER, "Pulidora de hierro");
        addItem(ModItems.IRON_DAGGER, "Daga de hierro");

        addItem(ModItems.ALUMINUM_IRON_SWORD, "Espada de hierro");
        addItem(ModItems.ALUMINUM_IRON_DAGGER, "Daga de hierro");
        addItem(ModItems.ALUMINUM_IRON_PICKAXE, "Pico de hierro");
        addItem(ModItems.ALUMINUM_IRON_AXE, "Hacha de hierro");
        addItem(ModItems.ALUMINUM_IRON_SHOVEL, "Pala de hierro");
        addItem(ModItems.ALUMINUM_IRON_HOE, "Azadón de hierro");
        addItem(ModItems.ALUMINUM_IRON_POLISHER, "Pulidora de hierro");

        //Green golden equipment
        addItem(ModItems.GREEN_GOLDEN_SWORD, "Espada de oro verde");
        addItem(ModItems.GREEN_GOLDEN_DAGGER, "Daga de oro verde");
        addItem(ModItems.GREEN_GOLDEN_PICKAXE, "Pico de oro verde");
        addItem(ModItems.GREEN_GOLDEN_AXE, "Hacha de oro verde");
        addItem(ModItems.GREEN_GOLDEN_SHOVEL, "Pala de oro verde");
        addItem(ModItems.GREEN_GOLDEN_HOE, "Azada de oro verde");
        addItem(ModItems.GREEN_GOLDEN_POLISHER, "Pulidora de oro verde");
        addItem(ModItems.GREEN_GOLDEN_HELMET, "Casco de oro verde");
        addItem(ModItems.GREEN_GOLDEN_CHESTPLATE, "Pechera de oro verde");
        addItem(ModItems.GREEN_GOLDEN_LEGGINGS, "Pantalones de oro verde");
        addItem(ModItems.GREEN_GOLDEN_BOOTS, "Botas de oro verde");

        addItem(ModItems.ALUMINUM_GREEN_GOLDEN_SWORD, "Espada de oro verde");
        addItem(ModItems.ALUMINUM_GREEN_GOLDEN_DAGGER, "Daga de oro verde");
        addItem(ModItems.ALUMINUM_GREEN_GOLDEN_PICKAXE, "Pico de oro verde");
        addItem(ModItems.ALUMINUM_GREEN_GOLDEN_AXE, "Hacha de oro verde");
        addItem(ModItems.ALUMINUM_GREEN_GOLDEN_SHOVEL, "Pala de oro verde");
        addItem(ModItems.ALUMINUM_GREEN_GOLDEN_HOE, "Azadón de oro verde");
        addItem(ModItems.ALUMINUM_GREEN_GOLDEN_POLISHER, "Pulidora de oro verde");

        //Steel equipment
        addItem(ModItems.STEEL_SWORD, "Espada de acero");
        addItem(ModItems.STEEL_DAGGER, "Daga de acero");
        addItem(ModItems.STEEL_PICKAXE, "Pico de acero");
        addItem(ModItems.STEEL_AXE, "Hacha de acero");
        addItem(ModItems.STEEL_SHOVEL, "Pala de acero");
        addItem(ModItems.STEEL_HOE, "Azada de acero");
        addItem(ModItems.STEEL_POLISHER, "Pulidora de acero");
        addItem(ModItems.STEEL_HELMET, "Casco de acero");
        addItem(ModItems.STEEL_CHESTPLATE, "Pechera de acero");
        addItem(ModItems.STEEL_LEGGINGS, "Pantalones de acero");
        addItem(ModItems.STEEL_BOOTS, "Botas de acero");

        addItem(ModItems.ALUMINUM_STEEL_SWORD, "Espada de acero");
        addItem(ModItems.ALUMINUM_STEEL_DAGGER, "Daga de acero");
        addItem(ModItems.ALUMINUM_STEEL_PICKAXE, "Pico de acero");
        addItem(ModItems.ALUMINUM_STEEL_AXE, "Hacha de acero");
        addItem(ModItems.ALUMINUM_STEEL_SHOVEL, "Pala de acero");
        addItem(ModItems.ALUMINUM_STEEL_HOE, "Azadón de acero");
        addItem(ModItems.ALUMINUM_STEEL_POLISHER, "Pulidora de acero");

        //Blue gold equipment
        addItem(ModItems.BLUE_GOLDEN_SWORD, "Espada de oro azul");
        addItem(ModItems.BLUE_GOLDEN_DAGGER, "Daga de oro azul");
        addItem(ModItems.BLUE_GOLDEN_PICKAXE, "Pico de oro azul");
        addItem(ModItems.BLUE_GOLDEN_AXE, "Hacha de oro azul");
        addItem(ModItems.BLUE_GOLDEN_SHOVEL, "Pala de oro azul");
        addItem(ModItems.BLUE_GOLDEN_HOE, "Azada de oro azul");
        addItem(ModItems.BLUE_GOLDEN_POLISHER, "Pulidora de oro azul");
        addItem(ModItems.BLUE_GOLDEN_HELMET, "Casco de oro azul");
        addItem(ModItems.BLUE_GOLDEN_CHESTPLATE, "Pechera de oro azul");
        addItem(ModItems.BLUE_GOLDEN_LEGGINGS, "Pantalones de oro azul");
        addItem(ModItems.BLUE_GOLDEN_BOOTS, "Botas de oro azul");

        addItem(ModItems.ALUMINUM_BLUE_GOLDEN_SWORD, "Espada de oro azul");
        addItem(ModItems.ALUMINUM_BLUE_GOLDEN_DAGGER, "Daga de oro azul");
        addItem(ModItems.ALUMINUM_BLUE_GOLDEN_PICKAXE, "Pico de oro azul");
        addItem(ModItems.ALUMINUM_BLUE_GOLDEN_AXE, "Hacha de oro azul");
        addItem(ModItems.ALUMINUM_BLUE_GOLDEN_SHOVEL, "Pala de oro azul");
        addItem(ModItems.ALUMINUM_BLUE_GOLDEN_HOE, "Azadón de oro azul");
        addItem(ModItems.ALUMINUM_BLUE_GOLDEN_POLISHER, "Pulidora de oro azul");

        //Diamond equipment
        addItem(ModItems.DIAMOND_POLISHER, "Pulidora de diamante");
        addItem(ModItems.DIAMOND_DAGGER, "Daga de diamante");

        addItem(ModItems.ALUMINUM_DIAMOND_SWORD, "Espada de diamante");
        addItem(ModItems.ALUMINUM_DIAMOND_DAGGER, "Daga de diamante");
        addItem(ModItems.ALUMINUM_DIAMOND_PICKAXE, "Pico de diamante");
        addItem(ModItems.ALUMINUM_DIAMOND_AXE, "Hacha de diamante");
        addItem(ModItems.ALUMINUM_DIAMOND_SHOVEL, "Pala de diamante");
        addItem(ModItems.ALUMINUM_DIAMOND_HOE, "Azadón de diamante");
        addItem(ModItems.ALUMINUM_DIAMOND_POLISHER, "Pulidora de diamante");

        //Netherite equipment
        addItem(ModItems.NETHERITE_POLISHER, "Pulidora de netherita");
        addItem(ModItems.NETHERITE_DAGGER, "Daga de netherita");

        //Plants
        addItem(ModItems.YERBA_MATE, "Yerba mate");
        addItem(ModItems.GROUNDED_YERBA_MATE, "Yerba mate molida");

        //Food
            //Wild
            addItem(ModItems.WILD_TOMATO, "Tomate silvestre");
            addItem(ModItems.WILD_CORN, "Choclo silvestre");

            //Flour
            addItem(ModItems.WHEAT_FLOUR, "Harina de trigo");
            addItem(ModItems.PUMPKIN_FLOUR, "Harina de calabaza");

            //Seeds
            addItem(ModItems.YERBA_MATE_SEEDS, "Semillas de yerba mate");
            addItem(ModItems.ZAPALLO_SEEDS, "Semillas de calabaza");
            addItem(ModItems.TOMATO_SEEDS, "Semillas de tomate");
            addItem(ModItems.CORN_SEEDS, "Semillas de choclo");
            addItem(ModItems.EGGPLANT_SEEDS, "Semillas de berenjena");

            //Fruits
            addItem(ModItems.TOMATO, "Tomate");
            addItem(ModItems.LEMON, "Limón");
            addItem(ModItems.LIME, "Lima");
            addItem(ModItems.ORANGE, "Naranja");
            addItem(ModItems.WALNUT, "Nuez");
            addItem(ModItems.PEELED_WALNUT, "Nuez pelada");
            addItem(ModItems.GREEN_APPLE, "Manzana verde");

            //Vegetables
            addItem(ModItems.CORN, "Choclo");
            addItem(ModItems.ZAPALLO, "Calabaza");
            addItem(ModItems.EGGPLANT, "Berenjena");
            addItem(ModItems.RICE_GRAINS, "Granos de arroz");

            //Cooked
            addItem(ModItems.COOKED_CORN, "Choclo cocido");
            addItem(ModItems.COOKED_ZAPALLO, "Calabaza cocida");
            addItem(ModItems.COOKED_EGGPLANT, "Berejena cocida");

            //Others
            addItem(ModItems.EMPTY_MATE, "Mate vacio");
            addItem(ModItems.MATE, "Mate");
            addItem(ModItems.YEAST, "Levadura");
            addItem(ModItems.RICE_BOWL, "Bowl de arroz");

        //Smithing templates
        addSmithingTitles("Plantilla de herreria", "Se aplica a:", "Ingredientes:");

        addSmithingTranslations("bronzium", "Mejora de broncio", "Equipo de bronze, equipo de latón",
                "Lingote de broncio", "Coloque un arma, herramienta o armadora de bronce o de latón", "Coloque un Lingote de broncio");

        addSmithingTranslations("aluminum", "Mejora de aluminio", "Equipación con mango de madera",
                "Lingote de aluminio", "Coloque cualquier equipo con un mango de madera", "Coloque un lingote de aluminio");

        //Enchantments
        addEnchantment(ModEnchantments.FINE_MINING, "Minado fino");
        addEnchantmentDesc("fine_mining", "Al ser aplicado, permite obtener el mineral puro al picar una mena");
        addEnchantment(ModEnchantments.ROUGH_MINING, "Maldición de minado bruzco");
        addEnchantmentDesc("rough_mining", "Al ser aplicado, destruye el bloque minado a sus componentes primarios");
        addEnchantment(ModEnchantments.POISON_TOUCH, "Corte venenoso");
        addEnchantmentDesc("poison_touch", "Aplica Veneno al objetivo");
        addEnchantment(ModEnchantments.LIVING_TOUCH, "Corte regenerativo");
        addEnchantmentDesc("living_touch", "Aplica Curación al objetivo");
        addEnchantment(ModEnchantments.SHARP_BLADE, "Hoja sangrienta");
        addEnchantmentDesc("sharp_blade", "Al ser aplicado, provoca Sangrado al objetivo");

        //Entities
            //Villagers
            addVillagerProfession("jeweler", "Joyero");

            //Mobs
            addBandit("Ladrón");
            addItem(ModItems.BANDIT_SPAWN_EGG, "Generar ladrón");
    }
}
