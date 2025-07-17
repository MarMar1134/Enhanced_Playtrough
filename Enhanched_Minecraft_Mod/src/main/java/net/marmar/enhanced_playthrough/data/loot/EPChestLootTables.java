package net.marmar.enhanced_playthrough.data.loot;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.item.EPItems;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.EmptyLootItem;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.*;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.function.BiConsumer;

public class EPChestLootTables implements LootTableSubProvider {
    public static final ResourceLocation BANDIT_CAMP_CHEST = register("bandit_camp");

    @Override
    public void generate(BiConsumer<ResourceLocation, LootTable.Builder> pOutput) {
        pOutput.accept(BANDIT_CAMP_CHEST, banditChestLootTables());
    }

    public static LootTable.Builder banditChestLootTables(){
        //Less weight == less probability of the item to appear
        return LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(2, 4))
                    .add(LootItem.lootTableItem(EPItems.ALUMINUM_SMITHING_UPGRADE_TEMPLATE.get()).setWeight(1))
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
                    .add(LootItem.lootTableItem(EPItems.BRONZE_INGOT.get()).setWeight(4)
                            .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 4))))
                    .add(LootItem.lootTableItem(EPItems.BRONZE_NUGGET.get()).setWeight(4)
                            .apply(SetItemCountFunction.setCount(UniformGenerator.between(3, 6))))
                    .add(LootItem.lootTableItem(EPItems.COBBLE.get()).setWeight(5)
                            .apply(SetItemCountFunction.setCount(UniformGenerator.between(4,7))))
                    .add(LootItem.lootTableItem(Items.APPLE).setWeight(5)
                            .apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 4))))
                    .add(LootItem.lootTableItem(Items.MUTTON).setWeight(5)
                            .apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 4))))
                    .add(EmptyLootItem.emptyItem().setWeight(7))
                )

                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                    .add(LootItem.lootTableItem(EPItems.STEEL_DAGGER.get()).setWeight(1))
                        .apply(EnchantRandomlyFunction.randomApplicableEnchantment())
                        .when(LootItemRandomChanceCondition.randomChance(0.025f))
                    .add(LootItem.lootTableItem(EPItems.IRON_DAGGER.get()).setWeight(2))
                    .add(LootItem.lootTableItem(EPItems.STONE_DAGGER.get()).setWeight(4))
                    .add(EmptyLootItem.emptyItem().setWeight(6))
                );
    }

//    public static LootTable.Builder ancientCityLootTable() {
//        return LootTable.lootTable().withPool(
//                LootPool.lootPool().setRolls(UniformGenerator.between(5.0F, 10.0F))
//                        .add(LootItem.lootTableItem(Items.ENCHANTED_GOLDEN_APPLE).setWeight(1)
//                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F))))
//                        .add(LootItem.lootTableItem(Items.MUSIC_DISC_OTHERSIDE).setWeight(1))
//                        .add(LootItem.lootTableItem(Items.COMPASS).setWeight(2)
//                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))))
//                        .add(LootItem.lootTableItem(Items.SCULK_CATALYST).setWeight(2)
//                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F))))
//                        .add(LootItem.lootTableItem(Items.NAME_TAG).setWeight(2))
//                        .add(LootItem.lootTableItem(Items.DIAMOND_HOE).setWeight(2)
//                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))
//                                .apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.8F, 1.0F)))
//                                .apply(EnchantWithLevelsFunction.enchantWithLevels(UniformGenerator.between(30.0F, 50.0F))
//                                        .allowTreasure()))
//                        .add(LootItem.lootTableItem(Items.LEAD).setWeight(2)
//                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))))
//                        .add(LootItem.lootTableItem(Items.DIAMOND_HORSE_ARMOR).setWeight(2)
//                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))))
//                        .add(LootItem.lootTableItem(Items.SADDLE).setWeight(2)
//                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))))
//                        .add(LootItem.lootTableItem(Items.MUSIC_DISC_13).setWeight(2))
//                        .add(LootItem.lootTableItem(Items.MUSIC_DISC_CAT).setWeight(2))
//                        .add(LootItem.lootTableItem(Items.DIAMOND_LEGGINGS).setWeight(2)
//                                .apply(EnchantWithLevelsFunction.enchantWithLevels(UniformGenerator.between(30.0F, 50.0F))
//                                        .allowTreasure()))
//                        .add(LootItem.lootTableItem(Items.BOOK).setWeight(3)
//                                .apply((new EnchantRandomlyFunction.Builder()).withEnchantment(Enchantments.SWIFT_SNEAK)))
//                        .add(LootItem.lootTableItem(Items.SCULK).setWeight(3)
//                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(4.0F, 10.0F)))).add(LootItem.lootTableItem(Items.SCULK_SENSOR).setWeight(3).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F)))).add(LootItem.lootTableItem(Items.CANDLE).setWeight(3).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 4.0F)))).add(LootItem.lootTableItem(Items.AMETHYST_SHARD).setWeight(3).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 15.0F)))).add(LootItem.lootTableItem(Items.EXPERIENCE_BOTTLE).setWeight(3).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F)))).add(LootItem.lootTableItem(Items.GLOW_BERRIES).setWeight(3).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 15.0F)))).add(LootItem.lootTableItem(Items.IRON_LEGGINGS).setWeight(3).apply(EnchantWithLevelsFunction.enchantWithLevels(UniformGenerator.between(20.0F, 39.0F)).allowTreasure())).add(LootItem.lootTableItem(Items.ECHO_SHARD).setWeight(4).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F)))).add(LootItem.lootTableItem(Items.DISC_FRAGMENT_5).setWeight(4).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F)))).add(LootItem.lootTableItem(Items.POTION).setWeight(5).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))).apply(SetPotionFunction.setPotion(Potions.STRONG_REGENERATION))).add(LootItem.lootTableItem(Items.BOOK).setWeight(5).apply(EnchantRandomlyFunction.randomApplicableEnchantment())).add(LootItem.lootTableItem(Items.BOOK).setWeight(5).apply(SetItemCountFunction.setCount(UniformGenerator.between(3.0F, 10.0F)))).add(LootItem.lootTableItem(Items.BONE).setWeight(5).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 15.0F)))).add(LootItem.lootTableItem(Items.SOUL_TORCH).setWeight(5).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 15.0F)))).add(LootItem.lootTableItem(Items.COAL).setWeight(7).apply(SetItemCountFunction.setCount(UniformGenerator.between(6.0F, 15.0F))))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(EmptyLootItem.emptyItem().setWeight(75)).add(LootItem.lootTableItem(Items.WARD_ARMOR_TRIM_SMITHING_TEMPLATE).setWeight(4)).add(LootItem.lootTableItem(Items.SILENCE_ARMOR_TRIM_SMITHING_TEMPLATE).setWeight(1)));
//    }

    private static ResourceLocation register(String pName){
        return new ResourceLocation(EnhancedPlaythrough.MOD_ID, "chests/" + pName);
    }
}
