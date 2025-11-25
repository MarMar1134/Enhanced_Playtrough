package net.marmar.enhanced_playthrough.data.tag;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;

public class EPTags {
    public static class Blocks {
        public static final TagKey<Block> BAUXITE_ORES = blockTag("bauxite_ores");
        public static final TagKey<Block> NEEDS_SILVER_TOOL = blockTag("needs_silver_tool");
        public static final TagKey<Block> NEEDS_BRASS_TOOL = blockTag("needs_brass_tool");
        public static final TagKey<Block> NEEDS_BRONZE_TOOL= blockTag("needs_bronze_tool");
        public static final TagKey<Block> NEEDS_ROSE_GOLD_TOOL = blockTag("needs_rose_gold_tool");
        public static final TagKey<Block> NEEDS_BRONZIUM_TOOL = blockTag("needs_bronzium_tool");
        public static final TagKey<Block> NEEDS_GREEN_GOLD_TOOL = blockTag("needs_green_gold_tool");
        public static final TagKey<Block> NEEDS_BLUE_GOLD_TOOL = blockTag("needs_blue_gold_tool");
        public static final TagKey<Block> NEEDS_STEEL_TOOL= blockTag("needs_steel_tool");
        public static final TagKey<Block> BASIC_FURNACE = blockTag("basic_furnace");
        public static final TagKey<Block> ALLOY_FURNACE = blockTag("alloy_furnace");
        public static final TagKey<Block> FURNACE = blockTag("furnace");
        public static final TagKey<Block> DESERT_FLOWER_BASE = blockTag("desert_flower_base");


        private static TagKey<Block> blockTag(String name){
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(EnhancedPlaythrough.MOD_ID,name));
        }
    }
    public static class Items {
        //Ores
        public static final TagKey<Item> TIN_ORES = oreTag("tin");
        public static final TagKey<Item> ZINC_ORES = oreTag("zinc");
        public static final TagKey<Item> SILVER_ORES = oreTag("silver");
        public static final TagKey<Item> BAUXITE_ORES = oreTag("bauxite");
        public static final TagKey<Item> SAPPHIRE_ORES = oreTag("sapphire");
        public static final TagKey<Item> RUBY_ORES = oreTag("ruby");
        public static final TagKey<Item> COBALT_ORES = oreTag("cobalt");

        //Materials
        public static final TagKey<Item> GOLD = itemTag("gold");
        public static final TagKey<Item> SILVER = itemTag("silver");
        public static final TagKey<Item> ALUMINUM = itemTag("aluminum");
        public static final TagKey<Item> ALUMINUM_ROD = itemTag("rods/aluminum");
        public static final TagKey<Item> BRASS = itemTag("brass");
        public static final TagKey<Item> BRONZE = itemTag("bronze");
        public static final TagKey<Item> ROSE_GOLD = itemTag("rose_gold");
        public static final TagKey<Item> IRON = itemTag("iron");
        public static final TagKey<Item> BRONZIUM = itemTag("bronzium");
        public static final TagKey<Item> GREEN_GOLD = itemTag("green_gold");
        public static final TagKey<Item> STEEL = itemTag("steel");
        public static final TagKey<Item> BLUE_GOLD = itemTag("blue_gold");
        public static final TagKey<Item> RAW_GEMS = itemTag("raw_gems");
        public static final TagKey<Item> COBBLE = itemTag("cobble");
        public static final TagKey<Item> TERRACOTTA_SHARD = itemTag("terracotta_shard");

        //Ingots
        public static final TagKey<Item> TIN_INGOT = ingotTag("tin");
        public static final TagKey<Item> ZINC_INGOT = ingotTag("zinc");
        public static final TagKey<Item> SILVER_INGOT = ingotTag("silver");
        public static final TagKey<Item> ALUMINUM_INGOT = ingotTag("aluminum");
        public static final TagKey<Item> BRASS_INGOT = ingotTag("brass");
        public static final TagKey<Item> BRONZE_INGOT = ingotTag("bronze");
        public static final TagKey<Item> ROSE_GOLD_INGOT = ingotTag("rose_gold");
        public static final TagKey<Item> BRONZIUM_INGOT = ingotTag("bronzium");
        public static final TagKey<Item> GREEN_GOLD_INGOT = ingotTag("green_gold");
        public static final TagKey<Item> STEEL_INGOT = ingotTag("steel");
        public static final TagKey<Item> BLUE_GOLD_INGOT = ingotTag("blue_gold");

        //Tools
        public static final TagKey<Item> POLISHER = toolsTag("polishers");
        public static final TagKey<Item> DAGGER = toolsTag("daggers");

        //Ingredients
        public static final TagKey<Item> INGREDIENTS = itemTag("ingredients");
        public static final TagKey<Item> BASIC_SMELT_INGREDIENT = ingredientTag("basic_smelt");
        public static final TagKey<Item> MASONRY_INGREDIENT = ingredientTag("masonry");
        public static final TagKey<Item> ALLOY_INGREDIENT = ingredientTag("alloy");
        public static final TagKey<Item> BLAST_ALLOY_INGREDIENT = ingredientTag("blast_alloy");
        public static final TagKey<Item> PRIMAL_GRIND_INGREDIENT = ingredientTag("primal_grind");
        public static final TagKey<Item> MECHANICAL_GRIND_INGREDIENT = ingredientTag("mechanical_grind");

        //Manufacturable goods (for dusts and nuggets)
        public static final TagKey<Item> MANUFACTURABLE = itemTag("manufacturable");
        public static final TagKey<Item> GOLD_MANUFACTURABLE = manufacturableTag("gold");
        public static final TagKey<Item> SILVER_MANUFACTURABLE = manufacturableTag("silver");
        public static final TagKey<Item> ALUMINUM_MANUFACTURABLE = manufacturableTag("aluminum");
        public static final TagKey<Item> ZINC_MANUFACTURABLE = manufacturableTag("zinc");
        public static final TagKey<Item> TIN_MANUFACTURABLE = manufacturableTag("tin");
        public static final TagKey<Item> COPPER_MANUFACTURABLE = manufacturableTag("copper");
        public static final TagKey<Item> BRASS_MANUFACTURABLE = manufacturableTag("brass");
        public static final TagKey<Item> BRONZE_MANUFACTURABLE = manufacturableTag("bronze");
        public static final TagKey<Item> ROSE_GOLD_MANUFACTURABLE = manufacturableTag("rose_gold");
        public static final TagKey<Item> IRON_MANUFACTURABLE = manufacturableTag("iron");
        public static final TagKey<Item> BRONZIUM_MANUFACTURABLE = manufacturableTag("bronzium");
        public static final TagKey<Item> GREEN_GOLD_MANUFACTURABLE = manufacturableTag("green_gold");
        public static final TagKey<Item> STEEL_MANUFACTURABLE = manufacturableTag("steel");
        public static final TagKey<Item> BLUE_GOLD_MANUFACTURABLE = manufacturableTag("blue_gold");

        //Logs
        public static final TagKey<Item> WALNUT_LOGS = itemTag("walnut_logs");
        public static final TagKey<Item> APPLE_LOGS = itemTag("apple_logs");
        public static final TagKey<Item> ORANGE_LOGS = itemTag("orange_logs");
        public static final TagKey<Item> LEMON_LOGS = itemTag("lemon_logs");

        private static TagKey<Item> itemTag(String name){
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(EnhancedPlaythrough.MOD_ID,name));
        }

        private static TagKey<Item> oreTag(String name){
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(EnhancedPlaythrough.MOD_ID,"ores/" + name));
        }

        private static TagKey<Item> ingredientTag(String name){
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(EnhancedPlaythrough.MOD_ID,"ingredients/" + name));
        }

        private static TagKey<Item> ingotTag(String name){
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(EnhancedPlaythrough.MOD_ID,"ingots/" + name));
        }

        private static TagKey<Item> toolsTag(String name){
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(EnhancedPlaythrough.MOD_ID,"tools/" + name));
        }

        private static TagKey<Item> manufacturableTag(String name){
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(EnhancedPlaythrough.MOD_ID,"manufacturable/" + name));
        }
    }

    public static class Biomes {
        //Biomes by temperature
        public static final TagKey<Biome> COLD_BIOMES = biomeTag("cold_biomes");
        public static final TagKey<Biome> TEMPLATE_BIOMES = biomeTag("template_biomes");
        public static final TagKey<Biome> WARM_BIOMES = biomeTag("warm_biomes");

        //Biomes by characteristics
        public static final TagKey<Biome> DESERT_BIOMES = biomeTag("desert_biomes");
        public static final TagKey<Biome> FROZEN_BIOMES = biomeTag("frozen_biomes");

        //Biomes with structures
        public static final TagKey<Biome> JEWELER_HOUSE = structureTag("jeweler_house");

        //Biomes with extra ores
        public static final TagKey<Biome> HUMIDITY_BIOMES = biomeTag("humidity_biomes");

        //Biomes that can hold specific mobs
        public static final TagKey<Biome> CAN_SPAWN_ZOMBIE_KNIGHT = biomeTag("can_spawn_zombie_knight");
        public static final TagKey<Biome> CAN_SPAWN_SKELETON_BOWMASTER = biomeTag("can_spawn_skeleton_bowmaster");

        private static TagKey<Biome> biomeTag(String name){
            return TagKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(EnhancedPlaythrough.MOD_ID,name));
        }

        private static TagKey<Biome> structureTag(String name){
            return TagKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(EnhancedPlaythrough.MOD_ID,"has_structure/" + name));
        }
    }
}
