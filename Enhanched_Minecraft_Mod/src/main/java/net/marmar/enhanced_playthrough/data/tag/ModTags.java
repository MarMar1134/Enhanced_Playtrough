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

public class ModTags {

    public static class Blocks {
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


        private static TagKey<Block> blockTag(String name){
            return BlockTags.create(new ResourceLocation(EnhancedPlaythrough.MOD_ID, name));
        }
    }
    public static class Items {
        //Materials
        public static final TagKey<Item> GOLD = itemTag("gold");
        public static final TagKey<Item> SILVER = itemTag("silver");
        public static final TagKey<Item> BRASS = itemTag("brass");
        public static final TagKey<Item> BRONZE = itemTag("bronze");
        public static final TagKey<Item> ROSE_GOLD = itemTag("rose_gold");
        public static final TagKey<Item> IRON = itemTag("iron");
        public static final TagKey<Item> BRONZIUM = itemTag("bronzium");
        public static final TagKey<Item> GREEN_GOLD = itemTag("green_gold");
        public static final TagKey<Item> STEEL = itemTag("steel");
        public static final TagKey<Item> BLUE_GOLD = itemTag("blue_gold");
        public static final TagKey<Item> RAW_GEM = itemTag("raw_gem");
        public static final TagKey<Item> COBBLE = forgeTag("cobble");

        //Tools
        public static final TagKey<Item> POLISHER = forgeTag("polisher");
        public static final TagKey<Item> DAGGER = forgeTag("dagger");

        //Ingredients
        public static final TagKey<Item> BASIC_INGREDIENT = itemTag("basic_ingredient");
        public static final TagKey<Item> MASONRY_INGREDIENT = itemTag("masonry_ingredient");
        public static final TagKey<Item> ALLOY_INGREDIENT = itemTag("alloy_ingredient");
        public static final TagKey<Item> BLAST_ALLOY_INGREDIENT = itemTag("blast_alloy_ingredient");
        public static final TagKey<Item> PRIMAL_GRIND_INGREDIENT = itemTag("primal_grind_ingredient");
        public static final TagKey<Item> MECHANICAL_GRIND_INGREDIENT = itemTag("mechanical_grind_ingredient");

        //Manufacturable goods (for dusts and nuggets)
        public static final TagKey<Item> GOLD_MANUFACTURABLE = itemTag("gold_manufacturable");
        public static final TagKey<Item> SILVER_MANUFACTURABLE = itemTag("silver_manufacturable");
        public static final TagKey<Item> ZINC_MANUFACTURABLE = itemTag("zinc_manufacturable");
        public static final TagKey<Item> TIN_MANUFACTURABLE = itemTag("tin_manufacturable");
        public static final TagKey<Item> COPPER_MANUFACTURABLE = itemTag("copper_manufacturable");
        public static final TagKey<Item> BRASS_MANUFACTURABLE = itemTag("brass_manufacturable");
        public static final TagKey<Item> BRONZE_MANUFACTURABLE = itemTag("bronze_manufacturable");
        public static final TagKey<Item> ROSE_GOLD_MANUFACTURABLE = itemTag("rose_gold_manufacturable");
        public static final TagKey<Item> IRON_MANUFACTURABLE = itemTag("iron_manufacturable");
        public static final TagKey<Item> BRONZIUM_MANUFACTURABLE = itemTag("bronzium_manufacturable");
        public static final TagKey<Item> GREEN_GOLD_MANUFACTURABLE = itemTag("green_gold_manufacturable");
        public static final TagKey<Item> STEEL_MANUFACTURABLE = itemTag("steel_manufacturable");
        public static final TagKey<Item> BLUE_GOLD_MANUFACTURABLE = itemTag("blue_gold_manufacturable");

        //Logs
        public static final TagKey<Item> WALNUT_LOGS = itemTag("walnut_logs");
        public static final TagKey<Item> APPLE_LOGS = itemTag("apple_logs");
        public static final TagKey<Item> ORANGE_LOGS = itemTag("orange_logs");
        public static final TagKey<Item> LEMON_LOGS = itemTag("lemon_logs");

        private static TagKey<Item> itemTag(String name){
            return ItemTags.create(new ResourceLocation(EnhancedPlaythrough.MOD_ID, name));
        }

        private static TagKey<Item> forgeTag(String name){
            return ItemTags.create(new ResourceLocation("forge", name));
        }
    }

    public static class Biomes {
        //Biomes by temperature
        public static final TagKey<Biome> COLD_BIOMES = biomeTag("cold_biomes");
        public static final TagKey<Biome> TEMPLATE_BIOMES = biomeTag("template_biomes");
        public static final TagKey<Biome> WARM_BIOMES = biomeTag("warm_biomes");

        //Biomes with structures
        public static final TagKey<Biome> JEWELER_HOUSE = structureTag("jeweler_house");

        private static TagKey<Biome> biomeTag(String name){
            return TagKey.create(Registries.BIOME, new ResourceLocation(EnhancedPlaythrough.MOD_ID, name));
        }

        private static TagKey<Biome> structureTag(String name){
            return TagKey.create(Registries.BIOME, new ResourceLocation(EnhancedPlaythrough.MOD_ID, "has_structure/" + name));
        }
    }
}
