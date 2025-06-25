package net.marmar.enhanced_playthrough.data.loot;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.Util.enchantment.ModEnchantments;
import net.marmar.enhanced_playthrough.item.ModItems;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.EmptyLootItem;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.*;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.function.BiConsumer;

public class ModChestLootTables implements LootTableSubProvider {
    public static final ResourceLocation BANDIT_CAMP_CHEST = register("bandit_camp");

    @Override
    public void generate(BiConsumer<ResourceLocation, LootTable.Builder> pOutput) {
        pOutput.accept(BANDIT_CAMP_CHEST, banditChestLootTables());
    }

    public static LootTable.Builder banditChestLootTables(){
        //Less weight == less probability of the item to appear
        return LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(2, 4))
                    .add(LootItem.lootTableItem(Items.MUSIC_DISC_CAT).setWeight(1))
                    .add(LootItem.lootTableItem(Items.IRON_INGOT).setWeight(2)
                            .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))))
                    .add(LootItem.lootTableItem(Items.LEATHER_CHESTPLATE).setWeight(2))
                    .add(LootItem.lootTableItem(Items.LEATHER_LEGGINGS).setWeight(2))
                    .add(LootItem.lootTableItem(Items.IRON_NUGGET).setWeight(3)
                            .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))))
                    .add(LootItem.lootTableItem(Items.LEATHER_HELMET).setWeight(3))
                    .add(LootItem.lootTableItem(Items.LEATHER_BOOTS).setWeight(3))
                    .add(LootItem.lootTableItem(Items.LEATHER).setWeight(4)
                            .apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 7))))
                    .add(LootItem.lootTableItem(Items.WHITE_WOOL).setWeight(4)
                            .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))))
                    .add(LootItem.lootTableItem(Items.STRING).setWeight(4)
                            .apply(SetItemCountFunction.setCount(UniformGenerator.between(3, 6))))
                    .add(LootItem.lootTableItem(ModItems.BRONZE_INGOT.get()).setWeight(4)
                            .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 4))))
                    .add(LootItem.lootTableItem(ModItems.BRONZE_NUGGET.get()).setWeight(4)
                            .apply(SetItemCountFunction.setCount(UniformGenerator.between(3, 6))))
                    .add(LootItem.lootTableItem(ModItems.COBBLE.get()).setWeight(5)
                            .apply(SetItemCountFunction.setCount(UniformGenerator.between(4,7))))
                    .add(LootItem.lootTableItem(Items.APPLE).setWeight(5)
                            .apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 4))))
                    .add(LootItem.lootTableItem(Items.MUTTON).setWeight(5)
                            .apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 4))))
                    .add(EmptyLootItem.emptyItem().setWeight(7))
                )

                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                    .add(LootItem.lootTableItem(ModItems.STEEL_DAGGER.get()).setWeight(1))
                        .apply(EnchantRandomlyFunction.randomApplicableEnchantment())
                        .when(LootItemRandomChanceCondition.randomChance(0.025f))
                    .add(LootItem.lootTableItem(ModItems.IRON_DAGGER.get()).setWeight(2))
                    .add(LootItem.lootTableItem(ModItems.STONE_DAGGER.get()).setWeight(4))
                    .add(EmptyLootItem.emptyItem().setWeight(6))
                );
    }

    private static ResourceLocation register(String pName){
        return new ResourceLocation(EnhancedPlaythrough.MOD_ID, "chests/" + pName);
    }
}
