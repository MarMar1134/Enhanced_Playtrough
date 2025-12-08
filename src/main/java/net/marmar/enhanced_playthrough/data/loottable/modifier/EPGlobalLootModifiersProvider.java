package net.marmar.enhanced_playthrough.data.loottable.modifier;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.item.EPItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class EPGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public EPGlobalLootModifiersProvider(PackOutput output) {
        super(output, EnhancedPlaythrough.MOD_ID);
    }

    private Item itemWithEnchantment(ItemLike pItem, Enchantment pEnchantment, int pEnchantLevel){
        ItemStack item = new ItemStack(pItem);
        item.enchant(pEnchantment, pEnchantLevel);
        return item.getItem();
    }

    @Override
    @SuppressWarnings("removal")
    protected void start() {
        //Ancient cities
        add("steel_sword_from_ancient_city", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/ancient_city")).build(),
                LootItemRandomChanceCondition.randomChance(0.15f).build() }, EPItems.STEEL_SWORD.get()));
        add("steel_helmet_from_ancient_city", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/ancient_city")).build(),
                LootItemRandomChanceCondition.randomChance(0.2f).build()}, EPItems.STEEL_HELMET.get()));
        add("steel_chestplate_from_ancient_city", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/ancient_city")).build(),
                LootItemRandomChanceCondition.randomChance(0.15f).build()}, EPItems.STEEL_CHESTPLATE.get()));
        add("steel_leggings_from_ancient_city", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/ancient_city")).build(),
                LootItemRandomChanceCondition.randomChance(0.2f).build()}, EPItems.STEEL_LEGGINGS.get()));
        add("steel_boots_from_ancient_city", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/ancient_city")).build(),
                LootItemRandomChanceCondition.randomChance(0.15f).build()}, EPItems.STEEL_BOOTS.get()));
//        add("frostbite_from_ancient_city_1", new AddItemModifier(new LootItemCondition[]{
//                new LootTableIdCondition.Builder(new ResourceLocation("chests/ancient_city_ice_box")).build(),
//                LootItemRandomChanceCondition.randomChance(0.5f).build()},
//                itemWithEnchantment(Items.BOOK, ModEnchantments.FROSTBITE.get(), 1)));
//        add("frostbite_from_ancient_city_2", new AddItemModifier(new LootItemCondition[]{
//                new LootTableIdCondition.Builder(new ResourceLocation("chests/ancient_city_ice_box")).build(),
//                LootItemRandomChanceCondition.randomChance(0.25f).build()},
//                itemWithEnchantment(Items.BOOK, ModEnchantments.FROSTBITE.get(), 2)));

        //Entities
        add("sulphur_from_blazes", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("entities/blaze")).build(),
                LootItemRandomChanceCondition.randomChance(0.7f).build() }, EPItems.SULFUR.get()));

        add("sulphur_from_witches", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("entities/witch")).build(),
                LootItemRandomChanceCondition.randomChance(0.5f).build() }, EPItems.SULFUR.get()));

        add("sapphires_from_vindicators", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("entities/vindicator")).build(),
                LootItemRandomChanceCondition.randomChance(0.9f).build() }, EPItems.SAPPHIRE.get()));
        add("extra_sapphires_from_vindicators", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("entities/vindicator")).build(),
                LootItemRandomChanceCondition.randomChance(0.6f).build() }, EPItems.SAPPHIRE.get()));

        add("sapphires_from_evokers", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("entities/evoker")).build(),
                LootItemRandomChanceCondition.randomChance(0.8f).build() }, EPItems.SAPPHIRE.get()));
        add("rubies_from_evokers", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("entities/evoker")).build(),
                LootItemRandomChanceCondition.randomChance(0.7f).build() }, EPItems.RUBY.get()));
        add("extra_rubies_from_evokers", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("entities/evoker")).build(),
                LootItemRandomChanceCondition.randomChance(0.5f).build() }, EPItems.RUBY.get()));
        add("totems_from_evokers", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("entities/evoker")).build(),
                LootItemRandomChanceCondition.randomChance(0.65f).build() }, Items.TOTEM_OF_UNDYING));

        //Woodland mansions
        add("totems_off_undying_from_mansions", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("chests/woodland_mansion")).build(),
                LootItemRandomChanceCondition.randomChance(0.3f).build() }, Items.TOTEM_OF_UNDYING));
        add("rubies_from_mansions", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("chests/woodland_mansion")).build(),
                LootItemRandomChanceCondition.randomChance(0.5f).build() }, EPItems.RUBY.get()));
        add("sapphires_from_mansions", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("chests/woodland_mansion")).build(),
                LootItemRandomChanceCondition.randomChance(0.7f).build() }, EPItems.SAPPHIRE.get()));

        //Mineshafts
            //Bronze
            add("bronze_pickaxe_from_mineshaft", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/abandoned_mineshaft")).build(),
                LootItemRandomChanceCondition.randomChance(0.5f).build()}, EPItems.BRONZE_PICKAXE.get()));
            add("bronze_ingot_from_mineshaft", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/abandoned_mineshaft")).build(),
                LootItemRandomChanceCondition.randomChance(0.7f).build()}, EPItems.BRONZE_INGOT.get()));
            add("bronze_nugget_from_mineshaft", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/abandoned_mineshaft")).build(),
                LootItemRandomChanceCondition.randomChance(0.9f).build()}, EPItems.BRONZE_NUGGET.get()));

            //Tin
            add("tin_ingot_from_mineshaft", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/abandoned_mineshaft")).build(),
                LootItemRandomChanceCondition.randomChance(0.7f).build()}, EPItems.TIN_INGOT.get()));

            //Zinc
            add("zinc_ingot_from_mineshaft", new AddItemModifier(new LootItemCondition[] {
                    new LootTableIdCondition.Builder(new ResourceLocation("chests/abandoned_mineshaft")).build(),
                    LootItemRandomChanceCondition.randomChance(0.7f).build()}, EPItems.ZINC_INGOT.get()));

            //Rose gold
            add("rose_gold_ingot_from_mineshaft", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/abandoned_mineshaft")).build(),
                LootItemRandomChanceCondition.randomChance(0.5f).build()}, EPItems.ROSE_GOLD_INGOT.get()));

            //Golden upgrade
            add("golden_smithing_upgrade_template_from_mineshaft", new AddItemModifier(new LootItemCondition[] {
                    new LootTableIdCondition.Builder(new ResourceLocation("chests/abandoned_mineshaft")).build(),
                    LootItemRandomChanceCondition.randomChance(0.45f).build()}, EPItems.GOLDEN_UPGRADE_SMITHING_TEMPLATE.get()));

        //Villages
        add("zapallo_seeds_from_villages", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/village/village_plains_house")).build(),
                LootItemRandomChanceCondition.randomChance(0.7f).build()}, EPItems.ZAPALLO_SEEDS.get()));
        add("eggplant_seeds_from_villages", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/village/village_plains_house")).build(),
                LootItemRandomChanceCondition.randomChance(0.7f).build()}, EPItems.EGGPLANT_SEEDS.get()));
        add("corn_seeds_from_villages", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/village/village_plains_house")).build(),
                LootItemRandomChanceCondition.randomChance(0.7f).build()}, EPItems.CORN_SEEDS.get()));
        add("tomato_seeds_from_villages", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/village/village_plains_house")).build(),
                LootItemRandomChanceCondition.randomChance(0.7f).build()}, EPItems.TOMATO_SEEDS.get()));
        add("yerba_mate_seeds_from_villages", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/village/village_plains_house")).build(),
                LootItemRandomChanceCondition.randomChance(0.7f).build()}, EPItems.YERBA_MATE_SEEDS.get()));

        add("bronze_pickaxe_from_villages", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/village/village_toolsmith")).build(),
                LootItemRandomChanceCondition.randomChance(0.1f).build()}, EPItems.BRONZE_PICKAXE.get()));
        add("bronze_ingot_from_village_toolsmith", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/village/village_toolsmith")).build(),
                LootItemRandomChanceCondition.randomChance(0.2f).build()}, EPItems.BRONZE_INGOT.get()));
        add("bronze_ingot_from_village_weaponsmith", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/village/village_weaponsmith")).build(),
                LootItemRandomChanceCondition.randomChance(0.3f).build()}, EPItems.BRONZE_INGOT.get()));

        add("steel_ingot_from_village_toolsmith", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/village/village_toolsmith")).build(),
                LootItemRandomChanceCondition.randomChance(0.05f).build()}, EPItems.STEEL_INGOT.get()));
        add("steel_ingot_from_village_weaponsmith", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/village/village_weaponsmith")).build(),
                LootItemRandomChanceCondition.randomChance(0.1f).build()}, EPItems.STEEL_INGOT.get()));

        //Spawners
        add("bronze_ingot_from_spawner", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/simple_dungeon")).build(),
                LootItemRandomChanceCondition.randomChance(0.3f).build()}, EPItems.BRONZE_INGOT.get()));
        add("brass_ingot_from_spawner", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/simple_dungeon")).build(),
                LootItemRandomChanceCondition.randomChance(0.45f).build()}, EPItems.BRASS_INGOT.get()));
        add("steel_ingot_from_spawner", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/simple_dungeon")).build(),
                LootItemRandomChanceCondition.randomChance(0.1f).build()}, EPItems.STEEL_INGOT.get()));

        //Nether fortress
        add("brass_ingot_from_nether_bridge", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/nether_bridge")).build(),
                LootItemRandomChanceCondition.randomChance(0.6f).build()}, EPItems.BRASS_INGOT.get()));
        add("bronzium_ingot_from_nether_bridge", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/nether_bridge")).build(),
                LootItemRandomChanceCondition.randomChance(0.3f).build()}, EPItems.BRONZIUM_INGOT.get()));
        add("bronzium_smithing_upgrade_template_from_nether_bridge", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/nether_bridge")).build(),
                LootItemRandomChanceCondition.randomChance(0.2f).build()}, EPItems.BRONZIUM_UPGRADE_SMITHING_TEMPLATE.get()));
        add("bronzium_sword_from_nether_bridge", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/nether_bridge")).build(),
                LootItemRandomChanceCondition.randomChance(0.4f).build()}, EPItems.BRONZIUM_SWORD.get()));
    }
}
