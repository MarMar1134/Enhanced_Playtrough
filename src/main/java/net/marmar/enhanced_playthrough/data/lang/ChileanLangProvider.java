package net.marmar.enhanced_playthrough.data.lang;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.block.EPBlocks;
import net.marmar.enhanced_playthrough.util.enchantment.EPEnchantments;
import net.marmar.enhanced_playthrough.item.EPItems;
import net.minecraft.data.PackOutput;

public class ChileanLangProvider extends AbstractLangProvider {
    public ChileanLangProvider(PackOutput output) {
        super(output, "es_cl");
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
        addJeiCategory("adobe_alloying_furnace", "Aleación");
        addJeiCategory("super_alloying_furnace", "Alta aleación");
        addJeiCategory("gem_polisher", "Pulido de gemas");
        addJeiCategory("primal_grinder", "Molienda");
        addJeiCategory("mechanical_grinder", "Molienda mecánizada");
        addJeiCategory("alchemical_duplicator", "Duplicación alquimica");

        addJeiItemDesc("plant_fiber", "Material usado en la fabricación de distintos objetos." +
                "\nSirve como reemplazo del hilo tradicional, y se fabrica con plantas altas en fibra.");
        addJeiItemDesc("reeds_head", "Material obtenido de una planta fibrosa." +
                "\nSe utiliza en la fabricación de Fibra vegetal.");
        addJeiItemDesc("bronzium_upgrade", "Plantilla de mejora para un material místico: el Broncio." +
                "\nTransforma materiales de Bronce y Latón a Broncio, el cual posee cualidades ignífugas.");
        addJeiItemDesc("aluminum_upgrade", "Plantilla de mejora para un material más moderno: el Aluminio." +
                "\nReemplaza el mango de armas y herramientas por uno de aluminio, otorgando mayor durabilidad.");
        addJeiItemDesc("golden_upgrade", "Plantilla de mejora que transforma las propiedades de objetos áureos." +
                "\nImbuye de magia las armaduras, otorgando Apuro al portador. Con armas y herramientas, les hace actuar como si fuesen de un nivel" +
                "superior al suyo mismo.");
        addJeiItemDesc("dusts", "Material obtenido de la molienda del metal." +
                "\nSe puede fundir en un horno y obtener un lingote de dicho metal, recuperando parte del material perdido.");
        addJeiItemDesc("calibrated_quartz", "Material obtenido al alear Cuarzo y Estaño." +
                "\nSe utiliza en la fabricación de distintos circuitos.");

        //Jade
        addJadeConfigTranslation("basic_furnace", "Hornos primitívos");

        addJadeConfigTranslation("alloy_furnace", "Hornos de aleación");

        addJadeConfigTranslation("masonry_furnace", "Horno de mamposteria");

        addJadeConfigTranslation("gem_polisher", "Pulido de gemas");
        this.add("jade." + EnhancedPlaythrough.MOD_ID + ".gem_polisher_uses", "Usos restantes: %d");

        addJadeConfigTranslation("grinder", "Molienda");

        addJadeConfigTranslation("alchemical_duplicator", "Duplicación alquimica");

        //GUI elements
        addGuiElements("gem_polisher_screen", "Usos");

        //Descriptions
        addDescription("leather_stick_tool", "Mango reforzado: 10% mayor durabilidad");
        addDescription("aluminum_stick_tool", "Mango de aluminio: 20% mayor durabilidad");
        addDescription("polisher_item", "Utilizado en el pulidor de gemas como combustible");
        addDescription("silver_armor", "Con toda la equipación: otorga Apuro al jugador");
        addDescription("rose_gold_armor", "Con toda la equipación: otorga Apuro al jugador");
        addDescription("bronzium_armor", "Con toda la equipación: otorga Resistencia al fuego al jugador");
        addDescription("green_gold_armor", "Con toda la equipación: otorga Apuro II al jugador");
        addDescription("blue_gold_armor", "Con toda la equipación: otorga Apuro II al jugador");
        addDescription("dagger_bleed", "Probabilidad de sangrado: ");
        addDescription("raw_gem", "Debe ser pulida");

        //Sounds
        addSoundDescription("grind", "Molienda activada");

        //Zombie knight
        addSoundDescription("zombie_knight_ambient", "Zombi caballero quejándose");
        addSoundDescription("zombie_knight_step", "Zombi caballero caminando");
        addSoundDescription("zombie_knight_hurt", "Zombi caballero siendo herido");
        addSoundDescription("zombie_knight_death", "Zombi caballero muriendo");

        //Skeleton bowmaster
        addSoundDescription("skeleton_bowmaster_ambient", "Maestre esqueleto chirriando sus huesos");
        addSoundDescription("skeleton_bowmaster_step", "Maestre esqueleto caminando");
        addSoundDescription("skeleton_bowmaster_hurt", "Maestre esqueleto siendo herido");
        addSoundDescription("skeleton_bowmaster_death", "Maestre esqueleto muriendo");

        //Lycans
            //Werellager
            addSoundDescription("werellager_ambient", "Lobillano aullando");
            addSoundDescription("werellager_step", "Lobillano caminando");
            addSoundDescription("werellager_hurt", "Lobillano quejándose de dolor");
            addSoundDescription("werellager_death", "Lobillano muriendo");

        //Death messages
        addDeathMessages("tallReed", "ha muerto pinchado por un carrizo",
                "ha muerto pinchado por un carrizo mientras escapaba de");
        addDeathMessages("cobble", "ha muerto de un piedrazo en la cabeza",
                "ha muerto de un piedrazo en la cabeza mientras luchaba con");
        addDeathMessages("bleed", "ha muerto desangrado", "ha muerto desangrado mientras huia de");

        //Mob effects
        addMobEffect("bleeding", "Sangrado");
        addMobEffect("frostbite", "Congelación");

        //Advancements
        //Survival
        addSurvivalAdvancement("survival_root", "Enhanced Playthrough",
                "Iniciaste una nueva aventura en este mundo fantástico, ¡bienvenido!");
        addSurvivalAdvancement("stone_age", "Un asunto adoquinado",
                "Obtén un pedazo de adoquín");
        addSurvivalAdvancement("unity_makes_strength", "La unión hace la fuerza",
                "Craftea un horno de aleación");
        addSurvivalAdvancement("ancient_knowledge", "Conocimiento antiguo",
                "Encuentra el Dominio del Señor Antiguo");
        addSurvivalAdvancement("blossom", "Bombón",
                "Funde oro y cobre para obtener oro rosado");
        addSurvivalAdvancement("buttercup", "Bellota",
                "Funde oro y plata para obtener oro verde");
        addSurvivalAdvancement("bubbles", "Búrbuja",
                "Funde oro y cobalto para obtener oro azul");
        addSurvivalAdvancement("the_goldenpuff_girls", "Las chicas súper-doradas",
                "Consigue las tres aleaciones de oro");

        addSurvivalAdvancement("thats_new", "Eso... es nuevo",
                "Obtén un lingote de bronce");
        addSurvivalAdvancement("abrassive_heat", "Platón, el herrero",
                "Obtén un lingote de latón");
        addSurvivalAdvancement("abrass_your_soul", "Amor platónico",
                "Obtén una armadura de latón");
        addSurvivalAdvancement("mighty_bronze", "Bronceado divino",
                "Obtén un pico de bronce");
        addSurvivalAdvancement("steel_isnt_enough", "No tiende a-cero",
                "Utiliza tu horno de aleación para fundir algo de acero");
        addSurvivalAdvancement("the_aluminated", "El aluminado",
                "Obtén un lingote de aluminio");
        addSurvivalAdvancement("vale_4", "Quiero vale 4",
                "Crafteá un duplicador alquímico");

        //Gems
        addGemAdvancement("colours_root", "Los colores del mundo",
                "Nuestro mundo reluce en colores, ¿que tal si vas a descubrirlos todos?");

        addGemAdvancement("has_any_polisher", "Tarea fina",
                "Craftéa una herramienta de pulido");
        addGemAdvancement("polish_emerald", "Intento de grinch",
                "Consigue algunas esmeraldas y cuidalas de los, ¿quienes?");
        addGemAdvancement("polish_sapphire", "Horizonte azulado",
                "Consigue algunos záfiros y visita un rato el mar");
        addGemAdvancement("polish_ruby", "Pajarito enojón",
                "Consigue algunos rubies y muestrale a los cerdos quién manda");
        addGemAdvancement("polish_garnet", "El color de mi corazón",
                "Consigue algunos granates y demuestra tu pasión");
        addGemAdvancement("polish_diamond", "Estás aquí, Lucy?",
                "Consigue algunos diamantes para poder ver mejor el cielo");
        addGemAdvancement("get_all_gems", "Caos por doquier",
                "Consigue todas las gemas y conviertete en el señor del caos");

        //Flowers
        addGemAdvancement("first_flower", "La raiz de todo",
                "Obtén tu primer flor");
        addGemAdvancement("all_small_flowers", "David",
                "Obtén todas las flores pequeñas");
        addGemAdvancement("all_tall_flowers", "Goliat",
                "Obtén todas las flores altas");
        addGemAdvancement("all_flowers", "El diario de la botecaria",
                "Obtén todas las flores");

        //Rotten crops
        addGemAdvancement("any_rotten_crop", "... Está horrible",
                "Obtén un cultivo podrido/venenoso");
        addGemAdvancement("rotten_stew", "El fuego purifica",
                "Recolecta tus cultivos podridos y prepara un guiso para luego... cocinarlo");

        //Entities
        addBoatEntity("Barco");
        addChestBoatEntity("Barco con cofre");
        addThrowableCobbleEntity("Adoquín");
        addAluminumArrowEntity("Flecha de aluminio");

        //Blocks
        //Wild crops
        addBlock(EPBlocks.WILD_WHEAT_CROP, "Trigo silvestre");
        addBlock(EPBlocks.WILD_TOMATO_CROP, "Tomate silvestre");
        addBlock(EPBlocks.WILD_CORN_CROP, "Maiz silvestre");

        //Plants
        addBlock(EPBlocks.TALL_REEDS, "Carrizo");
        addBlock(EPBlocks.REEDS, "Plumero");
        addBlock(EPBlocks.KENAF, "Kenaf");
        addBlock(EPBlocks.SMALL_REEDS, "Plumero andino");
        addBlock(EPBlocks.WATER_REEDS, "Junco");

        //Flowers
        addBlock(EPBlocks.COLD_LYRIUM, "Lirio helado");
        addBlock(EPBlocks.SUCCULENT, "Suculenta");

        //Wood
        //Apple
        addBlock(EPBlocks.APPLE_SAPLING, "Brote de manzano");
        addBlock(EPBlocks.APPLE_LEAVES, "Hojas de manzano");
        addBlock(EPBlocks.APPLE_LEAVES_WITH_FRUIT, "Hojas de manzano con fruta");
        addBlock(EPBlocks.APPLE_LOG, "Tronco de manzano");
        addBlock(EPBlocks.STRIPPED_APPLE_LOG, "Tronco de manzano pelado");
        addBlock(EPBlocks.APPLE_WOOD, "Leño de manzana");
        addBlock(EPBlocks.STRIPPED_APPLE_WOOD, "Leño de manzano pelado");
        addBlock(EPBlocks.APPLE_PLANKS, "Tablones de manzano");
        addBlock(EPBlocks.APPLE_SLAB, "Baldosa de manzano");
        addBlock(EPBlocks.APPLE_STAIRS, "Escaleras de manzano");
        addBlock(EPBlocks.APPLE_FENCE, "Varandilla de manzano");
        addBlock(EPBlocks.APPLE_FENCEGATE, "Puerta de varandilla de manzano");
        addBlock(EPBlocks.APPLE_DOOR, "Puerta de manzano");
        addBlock(EPBlocks.APPLE_TRAPDOOR, "Trampilla de manzano");
        addBlock(EPBlocks.APPLE_BUTTON, "Botón de manzano");
        addBlock(EPBlocks.APPLE_PRESSURE_PLATE, "Placa de presión de manzano");
        addSign(EPItems.APPLE_SIGN, "Cartel de manzano");
        addHangingSign(EPItems.APPLE_HANGING_SIGN, "Cartel de manzano colgante");
        addItem(EPItems.APPLE_BOAT, "Barco de manzano");
        addItem(EPItems.APPLE_CHEST_BOAT, "Barco de manzano con cofre");

        //Green apple
        addBlock(EPBlocks.GREEN_APPLE_SAPLING, "Brote de manzano verde");
        addBlock(EPBlocks.GREEN_APPLE_LEAVES, "Hojas de manzano verde");
        addBlock(EPBlocks.GREEN_APPLE_LEAVES_WITH_FRUIT, "Hojas de manzano verde con fruta");

        //Walnut
        addBlock(EPBlocks.WALNUT_SAPLING, "Brote de nogal");
        addBlock(EPBlocks.WALNUT_LEAVES, "Hojas de nogal");
        addBlock(EPBlocks.WALNUT_LOG, "Tronco de nogal");
        addBlock(EPBlocks.STRIPPED_WALNUT_LOG, "Tronco de nogal pelado");
        addBlock(EPBlocks.WALNUT_WOOD, "Leño de nogal");
        addBlock(EPBlocks.STRIPPED_WALNUT_WOOD, "Leño de nogal pelado");
        addBlock(EPBlocks.WALNUT_PLANKS, "Tablones de nogal");
        addBlock(EPBlocks.WALNUT_SLAB, "Baldosa de nogal");
        addBlock(EPBlocks.WALNUT_STAIRS, "Escaleras de nogal");
        addBlock(EPBlocks.WALNUT_FENCE, "Varandilla de nogal");
        addBlock(EPBlocks.WALNUT_FENCEGATE, "Puerta de varandilla de nogal");
        addBlock(EPBlocks.WALNUT_DOOR, "Puerta de nogal");
        addBlock(EPBlocks.WALNUT_TRAPDOOR, "Trampilla de nogal");
        addBlock(EPBlocks.WALNUT_BUTTON, "Botón de nogal");
        addBlock(EPBlocks.WALNUT_PRESSURE_PLATE, "Placa de presión de nogal");
        addSign(EPItems.WALNUT_SIGN, "Cartel de nogal");
        addHangingSign(EPItems.WALNUT_HANGING_SIGN, "Cartel de nogal colgante");
        addItem(EPItems.WALNUT_BOAT, "Barco de nogal");
        addItem(EPItems.WALNUT_CHEST_BOAT, "Barco de nogal con cofre");

        //Orange
        addBlock(EPBlocks.ORANGE_SAPLING, "Brote de naranjo");
        addBlock(EPBlocks.ORANGE_LEAVES, "Hojas de naranjo");
        addBlock(EPBlocks.ORANGE_LEAVES_WITH_FRUIT, "Hojas de naranjo con fruta");
        addBlock(EPBlocks.ORANGE_LOG, "Tronco de naranjo");
        addBlock(EPBlocks.STRIPPED_ORANGE_LOG, "Tronco de naranjo pelado");
        addBlock(EPBlocks.ORANGE_WOOD, "Leño de naranjo");
        addBlock(EPBlocks.STRIPPED_ORANGE_WOOD, "Leño de naranjo pelado");
        addBlock(EPBlocks.ORANGE_PLANKS, "Tablones de naranjo");
        addBlock(EPBlocks.ORANGE_SLAB, "Baldosa de naranjo");
        addBlock(EPBlocks.ORANGE_STAIRS, "Escaleras de naranjo");
        addBlock(EPBlocks.ORANGE_FENCE, "Varandilla de naranjo");
        addBlock(EPBlocks.ORANGE_FENCEGATE, "Puerta de varandilla de naranjo");
        addBlock(EPBlocks.ORANGE_DOOR, "Puerta de naranjo");
        addBlock(EPBlocks.ORANGE_TRAPDOOR, "Trampilla de naranjo");
        addBlock(EPBlocks.ORANGE_BUTTON, "Botón de naranjo");
        addBlock(EPBlocks.ORANGE_PRESSURE_PLATE, "Placa de presión de naranjo");
        addSign(EPItems.ORANGE_SIGN, "Cartel de naranjo");
        addHangingSign(EPItems.ORANGE_HANGING_SIGN, "Cartel de naranjo colgante");
        addItem(EPItems.ORANGE_BOAT, "Barco de naranjo");
        addItem(EPItems.ORANGE_CHEST_BOAT, "Barco de naranjo con cofre");

        //Lemon
        addBlock(EPBlocks.LEMON_SAPLING, "Brote de limonero");
        addBlock(EPBlocks.LEMON_LEAVES, "Hojas de limonero");
        addBlock(EPBlocks.LEMON_LEAVES_WITH_FRUIT, "Hojas de limonero con fruta");
        addBlock(EPBlocks.LEMON_LOG, "Tronco de limonero");
        addBlock(EPBlocks.STRIPPED_LEMON_LOG, "Tronco de limonero pelado");
        addBlock(EPBlocks.LEMON_WOOD, "Leño de limonero");
        addBlock(EPBlocks.STRIPPED_LEMON_WOOD, "Leño de limonero pelado");
        addBlock(EPBlocks.LEMON_PLANKS, "Tablones de limonero");
        addBlock(EPBlocks.LEMON_SLAB, "Baldosa de limonero");
        addBlock(EPBlocks.LEMON_STAIRS, "Escaleras de limonero");
        addBlock(EPBlocks.LEMON_FENCE, "Varandilla de limonero");
        addBlock(EPBlocks.LEMON_FENCEGATE, "Puerta de varandilla de limonero");
        addBlock(EPBlocks.LEMON_DOOR, "Puerta de limonero");
        addBlock(EPBlocks.LEMON_TRAPDOOR, "Trampilla de limonero");
        addBlock(EPBlocks.LEMON_BUTTON, "Botón de limonero");
        addBlock(EPBlocks.LEMON_PRESSURE_PLATE, "Placa de presión de limonero");
        addSign(EPItems.LEMON_SIGN, "Cartel de limonero");
        addHangingSign(EPItems.LEMON_HANGING_SIGN, "Cartel de limonero colgante");
        addItem(EPItems.LEMON_BOAT, "Barco de limonero");
        addItem(EPItems.LEMON_CHEST_BOAT, "Barco de limonero con cofre");

        //Lime
        addBlock(EPBlocks.LIME_SAPLING, "Brote de limera");
        addBlock(EPBlocks.LIME_LEAVES, "Hojas de limera");
        addBlock(EPBlocks.LIME_LEAVES_WITH_FRUIT, "Hojas de limera con fruta");

        //Polished stone
        addBlock(EPBlocks.POLISHED_STONE, "Piedra pulida");
        addBlock(EPBlocks.POLISHED_STONE_SLAB, "Baldosa de piedra pulida");
        addBlock(EPBlocks.POLISHED_STONE_STAIRS, "Escaleras de piedra pulida");
        addBlock(EPBlocks.POLISHED_STONE_WALL, "Pared de piedra pulida");

        //Cobbled limestone
        addBlock(EPBlocks.COBBLED_LIMESTONE, "Adoquin de piedra caliza");
        addBlock(EPBlocks.COBBLED_LIMESTONE_SLAB, "Baldosa de adoquines de piedra caliza");
        addBlock(EPBlocks.COBBLED_LIMESTONE_STAIRS, "Escaleras de adoquines de piedra caliza");
        addBlock(EPBlocks.COBBLED_LIMESTONE_WALL, "Pared de adoquines de piedra caliza");

        //Limestone
        addBlock(EPBlocks.LIMESTONE, "Piedra caliza");
        addBlock(EPBlocks.LIMESTONE_SLAB, "Baldosa de piedra caliza");
        addBlock(EPBlocks.LIMESTONE_STAIRS, "Escaleras de piedra caliza");
        addBlock(EPBlocks.LIMESTONE_WALL, "Pared de piedra caliza");

        //Polished limestone
        addBlock(EPBlocks.POLISHED_LIMESTONE, "Piedra caliza pulida");
        addBlock(EPBlocks.POLISHED_LIMESTONE_SLAB, "Baldosa de piedra caliza pulida");
        addBlock(EPBlocks.POLISHED_LIMESTONE_STAIRS, "Escaleras de piedra caliza pulida");
        addBlock(EPBlocks.POLISHED_LIMESTONE_WALL, "Pared de piedra caliza pulida");

        //Limestone bricks
        addBlock(EPBlocks.LIMESTONE_BRICKS, "Ladrillos de piedra caliza");
        addBlock(EPBlocks.LIMESTONE_BRICK_SLAB, "Baldosa de ladrillos de piedra caliza");
        addBlock(EPBlocks.LIMESTONE_BRICK_STAIRS, "Escaleras de ladrillos de piedra caliza");
        addBlock(EPBlocks.LIMESTONE_BRICK_WALL, "Pared de ladrillos de piedra caliza");

        //Cobbled soulstone
        addBlock(EPBlocks.COBBLED_SOULSTONE, "Adoquin de piedra de almas");
        addBlock(EPBlocks.COBBLED_SOULSTONE_SLAB, "Baldosa de adoquines de piedra de almas");
        addBlock(EPBlocks.COBBLED_SOULSTONE_STAIRS, "Escaleras de adoquines de piedra de almas");
        addBlock(EPBlocks.COBBLED_SOULSTONE_WALL, "Pared de adoquines de piedra de almas");

        //Soulstone
        addBlock(EPBlocks.SOULSTONE, "Piedra de almas");
        addBlock(EPBlocks.SOULSTONE_SLAB, "Baldosa de piedra de almas");
        addBlock(EPBlocks.SOULSTONE_STAIRS, "Escaleras de piedra de almas");
        addBlock(EPBlocks.SOULSTONE_WALL, "Pared de piedra de almas");

        //Soulstone bricks
        addBlock(EPBlocks.SOULSTONE_BRICKS, "Ladrillos de piedra de almas");
        addBlock(EPBlocks.SOULSTONE_BRICK_SLAB, "Baldosa de ladrillos de piedra de almas");
        addBlock(EPBlocks.SOULSTONE_BRICK_STAIRS, "Escaleras de ladrillos de piedra de almas");
        addBlock(EPBlocks.SOULSTONE_BRICK_WALL, "Pared de ladrillos de piedra de almas");

        //Firebricks
        addBlock(EPBlocks.FIREBRICKS, "Ladrillos refractarios");
        addBlock(EPBlocks.FIREBRICK_SLAB, "Baldosa de ladrillos refractarios");
        addBlock(EPBlocks.FIREBRICK_STAIRS, "Escaleras de ladrillos refractarios");
        addBlock(EPBlocks.FIREBRICK_WALL, "Pared de ladrillos refractarios");

        //Ores
        addBlock(EPBlocks.TIN_ORE, "Mineral de estaño");
        addBlock(EPBlocks.DEEPSLATE_TIN_ORE, "Mineral de estaño de pizarra profunda");
        addBlock(EPBlocks.ZINC_ORE, "Mineral de zinc");
        addBlock(EPBlocks.DEEPSLATE_ZINC_ORE, "Mineral de zinc de pizarra profunda");
        addBlock(EPBlocks.NETHER_ZINC_ORE, "Mineral de zinc del nether");
        addBlock(EPBlocks.NETHER_COPPER_ORE, "Mineral de cobre del nether");
        addBlock(EPBlocks.SULFUR_ORE, "Mineral de azufre");
        addBlock(EPBlocks.DEEPSLATE_SULFUR_ORE, "Mineral de azufre de pizarra profunda");
        addBlock(EPBlocks.NETHER_SULFUR_ORE, "Mineral de azufre del nether");
        addBlock(EPBlocks.SILVER_ORE, "Mineral de plata");
        addBlock(EPBlocks.DEEPSLATE_SILVER_ORE, "Mineral de plata de pizarra profunda");
        addBlock(EPBlocks.SAPPHIRE_ORE, "Mineral de zafiro");
        addBlock(EPBlocks.DEEPSLATE_SAPPHIRE_ORE, "Mineral de zaphiro de pizarra profunda");
        addBlock(EPBlocks.RUBY_ORE, "Mineral de rubi");
        addBlock(EPBlocks.DEEPSLATE_RUBY_ORE, "Mineral de rubi profundo");
        addBlock(EPBlocks.NETHER_GARNET_ORE, "Mineral de granate del nether");
        addBlock(EPBlocks.COBALT_ORE, "Mineral de cobalto");
        addBlock(EPBlocks.DEEPSLATE_COBALT_ORE, "Mineral de cobalto de pizarra profunda");
        addBlock(EPBlocks.BAUXITE, "Bauxita");
        addBlock(EPBlocks.WHITE_BAUXITE, "Bauxita blanca");
        addBlock(EPBlocks.LIGHT_GRAY_BAUXITE, "Bauxita gris claro");
        addBlock(EPBlocks.BROWN_BAUXITE, "Bauxita marrón");
        addBlock(EPBlocks.RED_BAUXITE, "Bauxita roja");
        addBlock(EPBlocks.ORANGE_BAUXITE, "Bauxita naranja");
        addBlock(EPBlocks.YELLOW_BAUXITE, "Bauxita amarilla");

        //Ore blocks
        addBlock(EPBlocks.RAW_TIN_BLOCK, "Bloque de estaño en bruto");
        addBlock(EPBlocks.TIN_BLOCK, "Bloque de estaño");
        addBlock(EPBlocks.RAW_ZINC_BLOCK, "Bloque de zinc en bruto");
        addBlock(EPBlocks.ZINC_BLOCK, "Bloque de zinc");
        addBlock(EPBlocks.SULFUR_BLOCK, "Bloque de azufre");
        addBlock(EPBlocks.RAW_SILVER_BLOCK, "Bloque de plata en bruto");
        addBlock(EPBlocks.SILVER_BLOCK, "Bloque de plata");
        addBlock(EPBlocks.RAW_ALUMINUM_BLOCK, "Bloque de aluminio en bruto");
        addBlock(EPBlocks.ALUMINUM_BLOCK, "Bloque de aluminio");
        addBlock(EPBlocks.BRASS_BLOCK, "Bloque de latón");
        addBlock(EPBlocks.BRONZE_BLOCK, "Bloque de bronce");
        addBlock(EPBlocks.ROSE_GOLD_BLOCK, "Bloque de oro rosado");
        addBlock(EPBlocks.BRONZIUM_BLOCK, "Bloque de broncio");
        addBlock(EPBlocks.GREEN_GOLD_BLOCK, "Bloque de oro verde");
        addBlock(EPBlocks.STEEL_BLOCK, "Bloque de acero");
        addBlock(EPBlocks.BLUE_GOLD_BLOCK, "Bloque de oro azul");

        //Calibrated quartz
        addBlock(EPBlocks.CALIBRATED_QUARTZ_BLOCK, "Bloque de cuarzo calibrado");
        addBlock(EPBlocks.SMOOTH_CALIBRATED_QUARTZ_BLOCK, "Bloque de cuarzo calibrado liso");
        addBlock(EPBlocks.CHISELED_CALIBRATED_QUARTZ_BLOCK, "Bloque de cuarzo calibrado cincelado");
        addBlock(EPBlocks.CALIBRATED_QUARTZ_PILLAR, "Pilar de cuarzo calibrado");
        addBlock(EPBlocks.CALIBRATED_QUARTZ_BRICKS, "Ladrillos de cuarzo calibrado");

        //Block entities
        addBlock(EPBlocks.ADOBE_FURNACE, "Horno de adobe");
        addBlock(EPBlocks.SOUL_FURNACE, "Horno de adobe de almas");
        addBlock(EPBlocks.MASONRY_FURNACE, "Horno de mamposteria");
        addBlock(EPBlocks.ADOBE_ALLOY_FURNACE, "Horno de aleación de larillos");
        addBlock(EPBlocks.SOUL_ALLOY_FURNACE, "Horno de aleación de almas");
        addBlock(EPBlocks.SUPER_ALLOY_FURNACE, "Alto horno de aleación");
        addBlock(EPBlocks.GEM_POLISHER, "Mesa de pulido");
        addBlock(EPBlocks.PRIMAL_GRINDER, "Moledora");
        addBlock(EPBlocks.MECHANICAL_GRINDER, "Moledora mecánizada");
        addBlock(EPBlocks.ALCHEMICAL_DUPLICATOR, "Duplicador alquímico");
        addBlock(EPBlocks.GROWTH_DETECTOR, "Detector de crecimiento");

        //Items
        //Raw ores
        addItem(EPItems.RAW_TIN, "Estaño en bruto");
        addItem(EPItems.RAW_ZINC, "Zinc en bruto");
        addItem(EPItems.RAW_SILVER, "Plata en bruto");
        addItem(EPItems.RAW_ALUMINUM, "Aluminio en bruto");
        addItem(EPItems.RAW_EMERALD, "Esmeralda impura");
        addItem(EPItems.RAW_SAPPHIRE, "Zafiro impuro");
        addItem(EPItems.RAW_RUBY, "Rubi impuro");
        addItem(EPItems.RAW_GARNET, "Granate impuro");
        addItem(EPItems.RAW_DIAMOND, "Diamante impuro");

        //Materials and melted ores
        addItem(EPItems.TIN_INGOT, "Lingote de estaño");
        addItem(EPItems.TIN_NUGGET, "Pepita de estaño");
        addItem(EPItems.ZINC_INGOT, "Lingote de zinc");
        addItem(EPItems.ZINC_NUGGET, "Pepita de zinc");
        addItem(EPItems.SULFUR, "Azufre");
        addItem(EPItems.SILVER_INGOT, "Lingote de plata");
        addItem(EPItems.SILVER_NUGGET, "Pepita de plata");
        addItem(EPItems.ALUMINUM_INGOT, "Lingote de aluminio");
        addItem(EPItems.ALUMINUM_NUGGET, "Pepita de aluminio");
        addItem(EPItems.COPPER_NUGGET, "Pepita de cobre");
        addItem(EPItems.BRASS_INGOT, "Lingote de latón");
        addItem(EPItems.BRASS_NUGGET, "Pepita de latón");
        addItem(EPItems.BRONZE_INGOT, "Lingote de bronce");
        addItem(EPItems.BRONZE_NUGGET, "Pepita de bronce");
        addItem(EPItems.ROSE_GOLD_INGOT, "Lingote de oro rosado");
        addItem(EPItems.ROSE_GOLD_NUGGET, "Pepita de oro rosado");
        addItem(EPItems.BRONZIUM_INGOT, "Lingote de broncio");
        addItem(EPItems.BRONZIUM_NUGGET, "Pepita de broncio");
        addItem(EPItems.GREEN_GOLD_INGOT, "Lingote de oro verde");
        addItem(EPItems.GREEN_GOLD_NUGGET, "Pepita de oro verde");
        addItem(EPItems.STEEL_INGOT, "Lingote de acero");
        addItem(EPItems.STEEL_NUGGET, "Pepita de acero");
        addItem(EPItems.BLUE_GOLD_INGOT, "Lingote de oro azul");
        addItem(EPItems.BLUE_GOLD_NUGGET, "Pepita de oro verde");
        addItem(EPItems.SAPPHIRE, "Zafiro");
        addItem(EPItems.RUBY, "Rubí");
        addItem(EPItems.GARNET, "Granate");

        //Others
        addItem(EPItems.MUD_BRICK, "Ladrillo de adobe");
        addItem(EPItems.FIREBRICK, "Ladrillo refractario");
        addItem(EPItems.LEATHER_STRIPS, "Tiras de cuero");
        addItem(EPItems.REINFORCED_STICK, "Palo reforzado");
        addItem(EPItems.ALUMINUM_ROD, "Vara de aluminio");
        addItem(EPItems.COBALT, "Cobalto");
        addItem(EPItems.REEDS_HEAD, "Cabeza de plumero");
        addItem(EPItems.KENAF_BRANCH, "Rama de kenaf");
        addItem(EPItems.TALL_REEDS_HEAD, "Cabeza de carrizo");
        addItem(EPItems.WATER_REEDS_HEAD, "Cabeza de junco");
        addItem(EPItems.PLANT_FIBER, "Fibra vegetal");
        addItem(EPItems.LIME, "Cal");

        //Hide
        addItem(EPItems.COW_HIDE, "Piel de vaca");
        addItem(EPItems.PIG_HIDE, "Piel de cerdo");
        addItem(EPItems.WERELLAGER_HIDE, "Piel de lobillano");

        //Cobble
        addItem(EPItems.COBBLE, "Adoquín");
        addItem(EPItems.LIMESTONE_COBBLE, "Adoquín de piedra caliza");
        addItem(EPItems.DEEPSLATE_COBBLE, "Adoquín de pizarra profunda");
        addItem(EPItems.NETHERRACK_RUBBLE, "Restos de netherrack");
        addItem(EPItems.SOULSTONE_COBBLE, "Adoquín de piedra de almas");
        addItem(EPItems.BLACKSTONE_COBBLE, "Adoquín de piedra negra");

        //Terracotta shards
        addItem(EPItems.TERRACOTTA_SHARD, "Fragmento de terracota");
        addItem(EPItems.WHITE_TERRACOTTA_SHARD, "Fragmento de terracota blanca");
        addItem(EPItems.ORANGE_TERRACOTTA_SHARD, "Fragmento de terracota naranja");
        addItem(EPItems.MAGENTA_TERRACOTTA_SHARD, "Fragmento de terracota magenta");
        addItem(EPItems.LIGHT_BLUE_TERRACOTTA_SHARD, "Fragmento de terracota celeste");
        addItem(EPItems.YELLOW_TERRACOTTA_SHARD, "Fragmento de terracota amarilla");
        addItem(EPItems.LIME_TERRACOTTA_SHARD, "Fragmento de terracota lima");
        addItem(EPItems.PINK_TERRACOTTA_SHARD, "Fragmento de terracota rosada");
        addItem(EPItems.GRAY_TERRACOTTA_SHARD, "Fragmento de terracota gris");
        addItem(EPItems.LIGHT_GRAY_TERRACOTTA_SHARD, "Fragmento de terracota gris claro");
        addItem(EPItems.CYAN_TERRACOTTA_SHARD, "Fragmento de terracota cian");
        addItem(EPItems.PURPLE_TERRACOTTA_SHARD, "Fragmento de terracota morada");
        addItem(EPItems.BLUE_TERRACOTTA_SHARD, "Fragmento de terracota azul");
        addItem(EPItems.BROWN_TERRACOTTA_SHARD, "Fragmento de terracota marrón");
        addItem(EPItems.GREEN_TERRACOTTA_SHARD, "Fragmento de terracota verde");
        addItem(EPItems.RED_TERRACOTTA_SHARD, "Fragmento de terracota roja");
        addItem(EPItems.BLACK_TERRACOTTA_SHARD, "Fragmento de terracota negra");

        //Dusts
        addItem(EPItems.GOLD_DUST, "Pólvo de oro");
        addItem(EPItems.SILVER_DUST, "Pólvo de plata");
        addItem(EPItems.ALUMINUM_DUST, "Pólvo de aluminio");
        addItem(EPItems.ZINC_DUST, "Pólvo de zinc");
        addItem(EPItems.TIN_DUST, "Pólvo de estaño");
        addItem(EPItems.COPPER_DUST, "Pólvo de cobre");
        addItem(EPItems.BRASS_DUST, "Pólvo de latón");
        addItem(EPItems.BRONZE_DUST, "Pólvo de bronce");
        addItem(EPItems.ROSE_GOLD_DUST, "Pólvo de oro rosado");
        addItem(EPItems.IRON_DUST, "Pólvo de hierro");
        addItem(EPItems.BRONZIUM_DUST, "Pólvo de broncio");
        addItem(EPItems.GREEN_GOLD_DUST, "Pólvo de oro verde");
        addItem(EPItems.STEEL_DUST, "Pólvo de acero");
        addItem(EPItems.BLUE_GOLD_DUST, "Pólvo de oro azul");

        //Manufactured
        addItem(EPItems.CALIBRATED_QUARTZ, "Cuarzo calibrado");

        //Acids and potions
        addAcid("sulfuric_acid", "Ácido sulfurico");

        //Other tools
        addItem(EPItems.FLINT_AND_COBBLE, "Pedernal y adoquín");
        addItem(EPItems.FLINT_AND_BRONZE, "Pedernal y bronce");

        //Silver equipment
        addItem(EPItems.SILVER_SWORD, "Espada de plata");
        addItem(EPItems.SILVER_DAGGER, "Daga de plata");
        addItem(EPItems.SILVER_PICKAXE, "Picota de plata");
        addItem(EPItems.SILVER_AXE, "Hacha de plata");
        addItem(EPItems.SILVER_SHOVEL, "Pala de plata");
        addItem(EPItems.SILVER_HOE, "Azada de plata");
        addItem(EPItems.SILVER_POLISHER, "Pulidora de plata");
        addItem(EPItems.SILVER_HELMET, "Casco de plata");
        addItem(EPItems.SILVER_CHESTPLATE, "Pechera de plata");
        addItem(EPItems.SILVER_LEGGINGS, "Pantalones de plata");
        addItem(EPItems.SILVER_BOOTS, "Botas de plata");

        addItem(EPItems.ALUMINUM_SILVER_SWORD, "Espada de plata");
        addItem(EPItems.ALUMINUM_SILVER_DAGGER, "Daga de plata");
        addItem(EPItems.ALUMINUM_SILVER_PICKAXE, "Pico de plata");
        addItem(EPItems.ALUMINUM_SILVER_AXE, "Hacha de plata");
        addItem(EPItems.ALUMINUM_SILVER_SHOVEL, "Pala de plata");
        addItem(EPItems.ALUMINUM_SILVER_HOE, "Azadón de plata");
        addItem(EPItems.ALUMINUM_SILVER_POLISHER, "Pulidora de plata");

        //Gold equipment
        addItem(EPItems.GOLDEN_POLISHER, "Pulidora de oro");
        addItem(EPItems.GOLDEN_DAGGER, "Daga de oro");

        addItem(EPItems.ALUMINUM_GOLDEN_SWORD, "Espada de oro");
        addItem(EPItems.ALUMINUM_GOLDEN_DAGGER, "Daga de oro");
        addItem(EPItems.ALUMINUM_GOLDEN_PICKAXE, "Pico de oro");
        addItem(EPItems.ALUMINUM_GOLDEN_AXE, "Hacha de oro");
        addItem(EPItems.ALUMINUM_GOLDEN_SHOVEL, "Pala de oro");
        addItem(EPItems.ALUMINUM_GOLDEN_HOE, "Azadón de oro");
        addItem(EPItems.ALUMINUM_GOLDEN_POLISHER, "Pulidora de oro");

        //Wood equipment
        addItem(EPItems.WOODEN_DAGGER, "Daga de madera");

        //Stone equipment
        addItem(EPItems.STONE_POLISHER, "Pulidora de piedra");
        addItem(EPItems.STONE_DAGGER, "Daga de piedra");

        //Brass equipment
        addItem(EPItems.BRASS_SWORD, "Espada de latón");
        addItem(EPItems.BRASS_DAGGER, "Daga de latón");
        addItem(EPItems.BRASS_PICKAXE, "Picota de latón");
        addItem(EPItems.BRASS_AXE, "Hacha de latón");
        addItem(EPItems.BRASS_SHOVEL, "Pala de latón");
        addItem(EPItems.BRASS_HOE, "Azada de latón");
        addItem(EPItems.BRASS_POLISHER, "Pulidora de latón");
        addItem(EPItems.BRASS_HELMET, "Casco de latón");
        addItem(EPItems.BRASS_CHESTPLATE, "Pechera de latón");
        addItem(EPItems.BRASS_LEGGINGS, "Pantalones de latón");
        addItem(EPItems.BRASS_BOOTS, "Botas de latón");

        addItem(EPItems.ALUMINUM_BRASS_SWORD, "Espada de latón");
        addItem(EPItems.ALUMINUM_BRASS_DAGGER, "Daga de latón");
        addItem(EPItems.ALUMINUM_BRASS_PICKAXE, "Pico de latón");
        addItem(EPItems.ALUMINUM_BRASS_AXE, "Hacha de latón");
        addItem(EPItems.ALUMINUM_BRASS_SHOVEL, "Pala de latón");
        addItem(EPItems.ALUMINUM_BRASS_HOE, "Azadón de latón");
        addItem(EPItems.ALUMINUM_BRASS_POLISHER, "Pulidora de latón");

        //Bronze equipment
        addItem(EPItems.BRONZE_SWORD, "Espada de bronce");
        addItem(EPItems.BRONZE_DAGGER, "Daga de bronce");
        addItem(EPItems.BRONZE_PICKAXE, "Picota de bronce");
        addItem(EPItems.BRONZE_AXE, "Hacha de bronce");
        addItem(EPItems.BRONZE_SHOVEL, "Pala de bronce");
        addItem(EPItems.BRONZE_HOE, "Azada de bronce");
        addItem(EPItems.BRONZE_POLISHER, "Pulidora de bronce");
        addItem(EPItems.BRONZE_HELMET, "Casco de bronce");
        addItem(EPItems.BRONZE_CHESTPLATE, "Pechera de bronce");
        addItem(EPItems.BRONZE_LEGGINGS, "Pantalones de bronce");
        addItem(EPItems.BRONZE_BOOTS, "Botas de bronce");

        addItem(EPItems.ALUMINUM_BRONZE_SWORD, "Espada de bronce");
        addItem(EPItems.ALUMINUM_BRONZE_DAGGER, "Daga de bronce");
        addItem(EPItems.ALUMINUM_BRONZE_PICKAXE, "Pico de bronce");
        addItem(EPItems.ALUMINUM_BRONZE_AXE, "Hacha de bronce");
        addItem(EPItems.ALUMINUM_BRONZE_SHOVEL, "Pala de bronce");
        addItem(EPItems.ALUMINUM_BRONZE_HOE, "Azadón de bronce");
        addItem(EPItems.ALUMINUM_BRONZE_POLISHER, "Pulidora de bronce");

        //Rose golden equipment
        addItem(EPItems.ROSE_GOLDEN_SWORD, "Espada de oro rosado");
        addItem(EPItems.ROSE_GOLDEN_DAGGER, "Daga de oro rosado");
        addItem(EPItems.ROSE_GOLDEN_PICKAXE, "Picota de oro rosado");
        addItem(EPItems.ROSE_GOLDEN_AXE, "Hacha de oro rosado");
        addItem(EPItems.ROSE_GOLDEN_SHOVEL, "Pala de oro rosado");
        addItem(EPItems.ROSE_GOLDEN_HOE, "Azada de oro rosado");
        addItem(EPItems.ROSE_GOLDEN_POLISHER, "Pulidora de oro rosado");
        addItem(EPItems.ROSE_GOLDEN_HELMET, "Casco de oro rosado");
        addItem(EPItems.ROSE_GOLDEN_CHESTPLATE, "Pechera de oro rosado");
        addItem(EPItems.ROSE_GOLDEN_LEGGINGS, "Pantalones de oro rosado");
        addItem(EPItems.ROSE_GOLDEN_BOOTS, "Botas de oro rosado");

        addItem(EPItems.ALUMINUM_ROSE_GOLDEN_SWORD, "Espada de oro rosado");
        addItem(EPItems.ALUMINUM_ROSE_GOLDEN_DAGGER, "Daga de oro rosado");
        addItem(EPItems.ALUMINUM_ROSE_GOLDEN_PICKAXE, "Pico de oro rosado");
        addItem(EPItems.ALUMINUM_ROSE_GOLDEN_AXE, "Hacha de oro rosado");
        addItem(EPItems.ALUMINUM_ROSE_GOLDEN_SHOVEL, "Pala de oro rosado");
        addItem(EPItems.ALUMINUM_ROSE_GOLDEN_HOE, "Azadón de oro rosado");
        addItem(EPItems.ALUMINUM_ROSE_GOLDEN_POLISHER, "Pulidora de oro rosado");

        //Bronzium equipment
        addItem(EPItems.BRONZIUM_SWORD, "Espada de broncio");
        addItem(EPItems.BRONZIUM_DAGGER, "Daga de broncio");
        addItem(EPItems.BRONZIUM_PICKAXE, "Picota de broncio");
        addItem(EPItems.BRONZIUM_AXE, "Hacha de broncio");
        addItem(EPItems.BRONZIUM_SHOVEL, "Pala de broncio");
        addItem(EPItems.BRONZIUM_HOE, "Azada de broncio");
        addItem(EPItems.BRONZIUM_POLISHER, "Pulidora de broncio");
        addItem(EPItems.BRONZIUM_HELMET, "Casco de broncio");
        addItem(EPItems.BRONZIUM_CHESTPLATE, "Pechera de broncio");
        addItem(EPItems.BRONZIUM_LEGGINGS, "Pantalones de broncio");
        addItem(EPItems.BRONZIUM_BOOTS, "Botas de broncio");

        addItem(EPItems.ALUMINUM_BRONZIUM_SWORD, "Espada de broncio");
        addItem(EPItems.ALUMINUM_BRONZIUM_DAGGER, "Daga de broncio");
        addItem(EPItems.ALUMINUM_BRONZIUM_PICKAXE, "Pico de broncio");
        addItem(EPItems.ALUMINUM_BRONZIUM_AXE, "Hacha de broncio");
        addItem(EPItems.ALUMINUM_BRONZIUM_SHOVEL, "Pala de broncio");
        addItem(EPItems.ALUMINUM_BRONZIUM_HOE, "Azadón de broncio");
        addItem(EPItems.ALUMINUM_BRONZIUM_POLISHER, "Pulidora de broncio");

        //Iron equipment
        addItem(EPItems.IRON_POLISHER, "Pulidora de hierro");
        addItem(EPItems.IRON_DAGGER, "Daga de hierro");

        addItem(EPItems.ALUMINUM_IRON_SWORD, "Espada de hierro");
        addItem(EPItems.ALUMINUM_IRON_DAGGER, "Daga de hierro");
        addItem(EPItems.ALUMINUM_IRON_PICKAXE, "Pico de hierro");
        addItem(EPItems.ALUMINUM_IRON_AXE, "Hacha de hierro");
        addItem(EPItems.ALUMINUM_IRON_SHOVEL, "Pala de hierro");
        addItem(EPItems.ALUMINUM_IRON_HOE, "Azadón de hierro");
        addItem(EPItems.ALUMINUM_IRON_POLISHER, "Pulidora de hierro");

        //Green golden equipment
        addItem(EPItems.GREEN_GOLDEN_SWORD, "Espada de oro verde");
        addItem(EPItems.GREEN_GOLDEN_DAGGER, "Daga de oro verde");
        addItem(EPItems.GREEN_GOLDEN_PICKAXE, "Picota de oro verde");
        addItem(EPItems.GREEN_GOLDEN_AXE, "Hacha de oro verde");
        addItem(EPItems.GREEN_GOLDEN_SHOVEL, "Pala de oro verde");
        addItem(EPItems.GREEN_GOLDEN_HOE, "Azada de oro verde");
        addItem(EPItems.GREEN_GOLDEN_POLISHER, "Pulidora de oro verde");
        addItem(EPItems.GREEN_GOLDEN_HELMET, "Casco de oro verde");
        addItem(EPItems.GREEN_GOLDEN_CHESTPLATE, "Pechera de oro verde");
        addItem(EPItems.GREEN_GOLDEN_LEGGINGS, "Pantalones de oro verde");
        addItem(EPItems.GREEN_GOLDEN_BOOTS, "Botas de oro verde");

        addItem(EPItems.ALUMINUM_GREEN_GOLDEN_SWORD, "Espada de oro verde");
        addItem(EPItems.ALUMINUM_GREEN_GOLDEN_DAGGER, "Daga de oro verde");
        addItem(EPItems.ALUMINUM_GREEN_GOLDEN_PICKAXE, "Pico de oro verde");
        addItem(EPItems.ALUMINUM_GREEN_GOLDEN_AXE, "Hacha de oro verde");
        addItem(EPItems.ALUMINUM_GREEN_GOLDEN_SHOVEL, "Pala de oro verde");
        addItem(EPItems.ALUMINUM_GREEN_GOLDEN_HOE, "Azadón de oro verde");
        addItem(EPItems.ALUMINUM_GREEN_GOLDEN_POLISHER, "Pulidora de oro verde");

        //Steel equipment
        addItem(EPItems.STEEL_SWORD, "Espada de acero");
        addItem(EPItems.STEEL_DAGGER, "Daga de acero");
        addItem(EPItems.STEEL_PICKAXE, "Picota de acero");
        addItem(EPItems.STEEL_AXE, "Hacha de acero");
        addItem(EPItems.STEEL_SHOVEL, "Pala de acero");
        addItem(EPItems.STEEL_HOE, "Azada de acero");
        addItem(EPItems.STEEL_POLISHER, "Pulidora de acero");
        addItem(EPItems.STEEL_HELMET, "Casco de acero");
        addItem(EPItems.STEEL_CHESTPLATE, "Pechera de acero");
        addItem(EPItems.STEEL_LEGGINGS, "Pantalones de acero");
        addItem(EPItems.STEEL_BOOTS, "Botas de acero");

        addItem(EPItems.ALUMINUM_STEEL_SWORD, "Espada de acero");
        addItem(EPItems.ALUMINUM_STEEL_DAGGER, "Daga de acero");
        addItem(EPItems.ALUMINUM_STEEL_PICKAXE, "Pico de acero");
        addItem(EPItems.ALUMINUM_STEEL_AXE, "Hacha de acero");
        addItem(EPItems.ALUMINUM_STEEL_SHOVEL, "Pala de acero");
        addItem(EPItems.ALUMINUM_STEEL_HOE, "Azadón de acero");
        addItem(EPItems.ALUMINUM_STEEL_POLISHER, "Pulidora de acero");

        //Blue gold equipment
        addItem(EPItems.BLUE_GOLDEN_SWORD, "Espada de oro azul");
        addItem(EPItems.BLUE_GOLDEN_DAGGER, "Daga de oro azul");
        addItem(EPItems.BLUE_GOLDEN_PICKAXE, "Picota de oro azul");
        addItem(EPItems.BLUE_GOLDEN_AXE, "Hacha de oro azul");
        addItem(EPItems.BLUE_GOLDEN_SHOVEL, "Pala de oro azul");
        addItem(EPItems.BLUE_GOLDEN_HOE, "Azada de oro azul");
        addItem(EPItems.BLUE_GOLDEN_POLISHER, "Pulidora de oro azul");
        addItem(EPItems.BLUE_GOLDEN_HELMET, "Casco de oro azul");
        addItem(EPItems.BLUE_GOLDEN_CHESTPLATE, "Pechera de oro azul");
        addItem(EPItems.BLUE_GOLDEN_LEGGINGS, "Pantalones de oro azul");
        addItem(EPItems.BLUE_GOLDEN_BOOTS, "Botas de oro azul");

        addItem(EPItems.ALUMINUM_BLUE_GOLDEN_SWORD, "Espada de oro azul");
        addItem(EPItems.ALUMINUM_BLUE_GOLDEN_DAGGER, "Daga de oro azul");
        addItem(EPItems.ALUMINUM_BLUE_GOLDEN_PICKAXE, "Pico de oro azul");
        addItem(EPItems.ALUMINUM_BLUE_GOLDEN_AXE, "Hacha de oro azul");
        addItem(EPItems.ALUMINUM_BLUE_GOLDEN_SHOVEL, "Pala de oro azul");
        addItem(EPItems.ALUMINUM_BLUE_GOLDEN_HOE, "Azadón de oro azul");
        addItem(EPItems.ALUMINUM_BLUE_GOLDEN_POLISHER, "Pulidora de oro azul");

        //Diamond equipment
        addItem(EPItems.DIAMOND_POLISHER, "Pulidora de diamante");
        addItem(EPItems.DIAMOND_DAGGER, "Daga de diamante");

        addItem(EPItems.ALUMINUM_DIAMOND_SWORD, "Espada de diamante");
        addItem(EPItems.ALUMINUM_DIAMOND_DAGGER, "Daga de diamante");
        addItem(EPItems.ALUMINUM_DIAMOND_PICKAXE, "Pico de diamante");
        addItem(EPItems.ALUMINUM_DIAMOND_AXE, "Hacha de diamante");
        addItem(EPItems.ALUMINUM_DIAMOND_SHOVEL, "Pala de diamante");
        addItem(EPItems.ALUMINUM_DIAMOND_HOE, "Azadón de diamante");
        addItem(EPItems.ALUMINUM_DIAMOND_POLISHER, "Pulidora de diamante");

        //Netherite equipment
        addItem(EPItems.NETHERITE_POLISHER, "Pulidora de netherita");
        addItem(EPItems.NETHERITE_DAGGER, "Daga de netherita");

        //Plants
        addItem(EPItems.YERBA_MATE, "Yerba mate");
        addItem(EPItems.GROUNDED_YERBA_MATE, "Yerba mate molida");

        //Food
        //Wild
        addItem(EPItems.WILD_TOMATO, "Tomate silvestre");
        addItem(EPItems.WILD_CORN, "Maiz silvestre");

        //Flour
        addItem(EPItems.WHEAT_FLOUR, "Harina de trigo");
        addItem(EPItems.PUMPKIN_FLOUR, "Harina de calabaza");

        //Seeds
        addItem(EPItems.YERBA_MATE_SEEDS, "Semillas de yerba mate");
        addItem(EPItems.ZAPALLO_SEEDS, "Semillas de zapallo");
        addItem(EPItems.TOMATO_SEEDS, "Semillas de tomate");
        addItem(EPItems.CORN_SEEDS, "Semillas de maiz");
        addItem(EPItems.EGGPLANT_SEEDS, "Semillas de berenjena");

        //Fruits
        addItem(EPItems.TOMATO, "Tomate");
        addItem(EPItems.LEMON, "Limón");
        addItem(EPItems.LIME_FRUIT, "Lima");
        addItem(EPItems.ORANGE, "Naranja");
        addItem(EPItems.WALNUT, "Nuez");
        addItem(EPItems.PEELED_WALNUT, "Nuez pelada");
        addItem(EPItems.GREEN_APPLE, "Manzana verde");

        //Vegetables
        addItem(EPItems.CORN, "Maiz");
        addItem(EPItems.ZAPALLO, "Zapallo");
        addItem(EPItems.EGGPLANT, "Berenjena");
        addItem(EPItems.RICE_GRAINS, "Granos de arroz");

        //Rotten
        addItem(EPItems.ROTTEN_CARROT, "Zanahoria podrida");
        addItem(EPItems.ROTTEN_CORN, "Maíz podrido");
        addItem(EPItems.ROTTEN_ZAPALLO, "Zapallo podrido");
        addItem(EPItems.ROTTEN_EGGPLANT, "Berenjena podrida");
        addItem(EPItems.ROTTEN_TOMATO, "Tomate podrido");

        //Cooked
        addItem(EPItems.COOKED_CORN, "Maiz cocido");
        addItem(EPItems.COOKED_ZAPALLO, "Zapallo cocido");
        addItem(EPItems.COOKED_EGGPLANT, "Berejena cocida");

        //Others
        addItem(EPItems.EMPTY_MATE, "Mate vacio");
        addItem(EPItems.MATE, "Mate");

        addItem(EPItems.RAW_ROTTEN_STEW, "Guiso podrido crudo");
        addItem(EPItems.ROTTEN_STEW, "Guiso podrido");

        addItem(EPItems.YEAST, "Levadura");
        addItem(EPItems.RICE_BOWL, "Bowl de arroz");

        //Smithing templates
        addSmithingTemplateTitle("Plantilla de herreria", "Se aplica a:", "Ingredientes:");

        addSmithingUpgrade("bronzium", "Mejora de broncio", "Equipo de bronze, equipo de latón",
                "Lingote de broncio", "Coloque un arma, herramienta o armadora de bronce o de latón",
                "Coloque un Lingote de broncio");

        addSmithingUpgrade("aluminum", "Mejora de aluminio", "Equipación con mango de madera",
                "Lingote de aluminio", "Coloque cualquier equipo con un mango de madera",
                "Coloque un lingote de aluminio");

        addSmithingUpgrade("golden", "Mejora áurea", "Equipación de oro",
                "Lingote de oro rosa, Lingote de oro verde, Lingote de oro azul", "Coloque cualquier equipo de oro",
                "Coloque un lingote de oro rosa, verde o azul");

        addTrimPattern("ancient", "Ornamento antiguo");

        //Trim materials
        addTrimMaterial("aluminum", "Aluminio");
        addTrimMaterial("silver", "Plata");
        addTrimMaterial("zinc", "Zinc");
        addTrimMaterial("bronze", "Bronce");
        addTrimMaterial("brass", "Latón");
        addTrimMaterial("bronzium", "Broncio");
        addTrimMaterial("steel", "Acero");
        addTrimMaterial("rose_gold", "Oro rosado");
        addTrimMaterial("green_gold", "Oro verde");
        addTrimMaterial("blue_gold", "Oro azul");
        addTrimMaterial("ruby", "Rubí");
        addTrimMaterial("sapphire", "Zafiro");
        addTrimMaterial("garnet", "Granate");

        //Enchantments
        addEnchantment(EPEnchantments.FINE_MINING, "Minado fino");
        addEnchantmentDesc("fine_mining", "Al ser aplicado, permite obtener el mineral puro al picar una mena");
        addEnchantment(EPEnchantments.ROUGH_MINING, "Maldición de minado bruzco");
        addEnchantmentDesc("rough_mining", "Al ser aplicado, destruye el bloque minado a sus componentes primarios");
        addEnchantment(EPEnchantments.POISON_TOUCH, "Corte venenoso");
        addEnchantmentDesc("poison_touch", "Aplica Veneno al objetivo");
        addEnchantment(EPEnchantments.LIVING_TOUCH, "Corte regenerativo");
        addEnchantmentDesc("living_touch", "Aplica Curación al objetivo");
        addEnchantment(EPEnchantments.BLOODY_BLADE, "Hoja sangrienta");
        addEnchantmentDesc("sharp_blade", "Al ser aplicado, provoca Sangrado al objetivo");
        addEnchantment(EPEnchantments.FROSTBITE, "Congelación");
        addEnchantmentDesc("frostbite", "Al ser aplicado, aplica Congelación al objetivo");
        addEnchantment(EPEnchantments.SILVER_BLESSING, "Bendición plateada");
        addEnchantmentDesc("silver_blessing", "Anula el escudo natural de los licántropos ante armas que no estén hechas de plata");

        //Entities
        //Villagers
        addVillagerProfession("jeweler", "Joyero");

        //Mobs
        addBandit("Ladrón");
        addItem(EPItems.BANDIT_SPAWN_EGG, "Generar ladrón");

        addZombieKnight("Zombi caballero");
        addItem(EPItems.ZOMBIE_KNIGHT_SPAWN_EGG, "Generar zombi caballero");

        addSkeletonBowmaster("Maestre esqueleto");
        addItem(EPItems.SKELETON_BOWMASTER_SPAWN_EGG, "Generar maestre esqueleto");

        addWerellager("Lobillano");
        addItem(EPItems.WERELLAGER_SPAWN_EGG, "Generar lobillano");
    }
}
