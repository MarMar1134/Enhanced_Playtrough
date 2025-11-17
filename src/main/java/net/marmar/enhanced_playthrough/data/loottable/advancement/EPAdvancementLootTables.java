package net.marmar.enhanced_playthrough.data.loottable.advancement;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.item.EPItems;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.EnchantRandomlyFunction;

import java.util.function.BiConsumer;

public class EPAdvancementLootTables implements LootTableSubProvider {
    public static final ResourceLocation THE_GOLDENPUFF_GIRLS = register("the_goldenpuff_girls");
    public static final ResourceLocation ABRASS_YOUR_SOUL = register("abrass_your_soul");
    public static final ResourceLocation GET_ALL_GEMS = register("get_all_gems");
    public static final ResourceLocation ALL_FLOWERS = register("all_flowers");

    @Override
    public void generate(BiConsumer<ResourceLocation, LootTable.Builder> pOutput) {
        pOutput.accept(THE_GOLDENPUFF_GIRLS, goldenPuffGirlsLootTable());
        pOutput.accept(ABRASS_YOUR_SOUL, abrassYourSoulLootTable());
        pOutput.accept(GET_ALL_GEMS, getAllGemsLootTable());
        pOutput.accept(ALL_FLOWERS, allFlowersLootTable());
    }

    protected static LootTable.Builder goldenPuffGirlsLootTable(){
        return LootTable.lootTable().withPool(LootPool.lootPool()
                .add(LootItem.lootTableItem(EPItems.BLUE_GOLDEN_SWORD.get()))
                .apply((new EnchantRandomlyFunction.Builder()).withEnchantment(Enchantments.SHARPNESS)));
    }

    protected static LootTable.Builder abrassYourSoulLootTable(){
        return LootTable.lootTable().withPool(LootPool.lootPool()
                .add(LootItem.lootTableItem(EPItems.BRASS_PICKAXE.get()))
                .apply((new EnchantRandomlyFunction.Builder()).withEnchantment(Enchantments.BLOCK_EFFICIENCY))
                .apply((new EnchantRandomlyFunction.Builder()).withEnchantment(Enchantments.UNBREAKING)));

    }

    protected static LootTable.Builder getAllGemsLootTable(){
        return LootTable.lootTable().withPool(LootPool.lootPool()
                .add(LootItem.lootTableItem(EPItems.NETHERITE_POLISHER.get())));
    }

    protected static LootTable.Builder allFlowersLootTable(){
        return LootTable.lootTable().withPool(LootPool.lootPool()
                .add(LootItem.lootTableItem(Items.SHEARS))
                .apply((new EnchantRandomlyFunction.Builder()).withEnchantment(Enchantments.MENDING)));
    }

    private static ResourceLocation register(String pName){
        return new ResourceLocation(EnhancedPlaythrough.MOD_ID, "advancements/" + pName);
    }
}
