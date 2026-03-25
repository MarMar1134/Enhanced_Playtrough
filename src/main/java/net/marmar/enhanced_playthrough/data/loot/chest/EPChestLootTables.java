package net.marmar.enhanced_playthrough.data.loot.chest;

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
    public static final ResourceLocation ANCIENT_LORDS_DOMAIN_BEDROOMS = register("ancient_lords_domain/bedrooms");
    public static final ResourceLocation ANCIENT_LORDS_DOMAIN_STORAGE_ROOM_FOOD = register("ancient_lords_domain/storage_room/food");
    public static final ResourceLocation ANCIENT_LORDS_DOMAIN_STORAGE_ROOM_MATERIALS = register("ancient_lords_domain/storage_room/materials");
    public static final ResourceLocation ANCIENT_LORDS_DOMAIN_TRAINING_ROOM_FOOD = register("ancient_lords_domain/training_room/food");
    public static final ResourceLocation ANCIENT_LORDS_DOMAIN_TRAINING_ROOM_EQUIPMENT = register("ancient_lords_domain/training_room/equipment");
    public static final ResourceLocation ANCIENT_LORDS_DOMAIN_TRESSURE_ROOM_BARREL = register("ancient_lords_domain/tressure_room/barrel");
    public static final ResourceLocation ANCIENT_LORDS_DOMAIN_TRESSURE_ROOM_CHEST = register("ancient_lords_domain/tressure_room/chest");

    @Override
    public void generate(BiConsumer<ResourceLocation, LootTable.Builder> pOutput) {
        pOutput.accept(BANDIT_CAMP_CHEST, banditChestLootTables());

        pOutput.accept(ANCIENT_LORDS_DOMAIN_BEDROOMS, ancientLordsDomainBedroomsLootTable());
        pOutput.accept(ANCIENT_LORDS_DOMAIN_STORAGE_ROOM_FOOD, ancientLordsDomainStorageRoomFoodLootTable());
        pOutput.accept(ANCIENT_LORDS_DOMAIN_STORAGE_ROOM_MATERIALS, ancientLordsDomainStorageRoomMaterialsLootTable());
        pOutput.accept(ANCIENT_LORDS_DOMAIN_TRAINING_ROOM_FOOD, ancientLordsDomainTrainingRoomFoodLootTable());
        pOutput.accept(ANCIENT_LORDS_DOMAIN_TRAINING_ROOM_EQUIPMENT, ancientLordsDomainTrainingRoomEquipmentLootTable());
        pOutput.accept(ANCIENT_LORDS_DOMAIN_TRESSURE_ROOM_BARREL, ancientLordsDomainTressureRoomBarrelLootTable());
        pOutput.accept(ANCIENT_LORDS_DOMAIN_TRESSURE_ROOM_CHEST, ancientLordsDomainTressureRoomChestLootTable());
    }

    public static LootTable.Builder banditChestLootTables(){
        //Less weight == less probability of the item to appear
        return LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(2, 4))
                    .add(LootItem.lootTableItem(Items.IRON_INGOT).setWeight(3)
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
                )

                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(EPItems.ALUMINUM_UPGRADE_SMITHING_TEMPLATE.get()).setWeight(2))
                        .add(EmptyLootItem.emptyItem().setWeight(4)));
    }

    public static LootTable.Builder ancientLordsDomainBedroomsLootTable(){
        return LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(2,4))
                        .add(EmptyLootItem.emptyItem().setWeight(6))
                        .add(LootItem.lootTableItem(Items.BONE).setWeight(4)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2,5))))
                        .add(LootItem.lootTableItem(Items.STRING).setWeight(4)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(4,6))))
                        .add(LootItem.lootTableItem(Items.ROTTEN_FLESH).setWeight(3)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(3,5))))
                        .add(LootItem.lootTableItem(Items.CANDLE).setWeight(2)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1,3))))
                )
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(EmptyLootItem.emptyItem().setWeight(8))
                        .add(LootItem.lootTableItem(EPItems.IRON_DAGGER.get()).setWeight(2)
                                .apply(EnchantRandomlyFunction.randomApplicableEnchantment())
                                .apply(SetItemDamageFunction.setDamage(UniformGenerator.between(30,40))))
                        .add(LootItem.lootTableItem(EPItems.STEEL_DAGGER.get()).setWeight(1)
                                .apply(EnchantRandomlyFunction.randomApplicableEnchantment())
                                .apply(SetItemDamageFunction.setDamage(UniformGenerator.between(30,40))))
                )
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(2,4))
                        .add(EmptyLootItem.emptyItem().setWeight(14))
                        .add(LootItem.lootTableItem(Items.IRON_SWORD).setWeight(3)
                                .apply(EnchantRandomlyFunction.randomApplicableEnchantment())
                                .apply(SetItemDamageFunction.setDamage(UniformGenerator.between(30,40))))
                        .add(LootItem.lootTableItem(Items.BOOK).setWeight(1)
                                .apply(EnchantRandomlyFunction.randomApplicableEnchantment()))
                )
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(EmptyLootItem.emptyItem().setWeight(20))
                        .add(LootItem.lootTableItem(EPItems.ANCIENT_ARMOR_TRIM_SMITHING_TEMPLATE.get()).setWeight(2)
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1))))
                );
    }

    public static LootTable.Builder ancientLordsDomainStorageRoomFoodLootTable(){
        return LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(2,4))
                        .add(EmptyLootItem.emptyItem().setWeight(9))
                        .add(LootItem.lootTableItem(Items.APPLE).setWeight(6)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2,4))))
                        .add(LootItem.lootTableItem(Items.WHEAT).setWeight(5)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(3,6))))
                        .add(LootItem.lootTableItem(Items.CARROT).setWeight(4)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1,3))))
                        .add(LootItem.lootTableItem(Items.POTATO).setWeight(4)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1,3))))
                )
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(EmptyLootItem.emptyItem().setWeight(8))
                        .add(LootItem.lootTableItem(Items.BEETROOT).setWeight(6)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1,2))))
                        .add(LootItem.lootTableItem(Items.GOLDEN_CARROT).setWeight(4)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1,2))))
                )
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(1,2))
                        .add(EmptyLootItem.emptyItem().setWeight(8))
                        .add(LootItem.lootTableItem(EPItems.CORN.get()).setWeight(6)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(3,6))))
                        .add(LootItem.lootTableItem(EPItems.TOMATO.get()).setWeight(5)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2,3))))
                        .add(LootItem.lootTableItem(EPItems.ZAPALLO.get()).setWeight(4)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2,4))))
                        .add(LootItem.lootTableItem(EPItems.EGGPLANT.get()).setWeight(3)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2,4))))
                )
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(1,2))
                        .add(LootItem.lootTableItem(Items.WHEAT_SEEDS).setWeight(6)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2,4))))
                        .add(LootItem.lootTableItem(EPItems.CORN_SEEDS.get()).setWeight(5)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1,3))))
                        .add(LootItem.lootTableItem(EPItems.TOMATO_SEEDS.get()).setWeight(4)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1,2))))
                        .add(LootItem.lootTableItem(EPItems.ZAPALLO_SEEDS.get()).setWeight(3)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2,3))))
                        .add(LootItem.lootTableItem(EPItems.EGGPLANT_SEEDS.get()).setWeight(2)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1,2))))
                );
    }

    public static LootTable.Builder ancientLordsDomainStorageRoomMaterialsLootTable(){
        return LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(2,4))
                        .add(EmptyLootItem.emptyItem().setWeight(9))
                        .add(LootItem.lootTableItem(EPItems.BRONZE_NUGGET.get()).setWeight(7)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(3,5))))
                        .add(LootItem.lootTableItem(Items.IRON_NUGGET).setWeight(6)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2,5))))
                        .add(LootItem.lootTableItem(EPItems.BRONZE_INGOT.get()).setWeight(5)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2,4))))
                        .add(LootItem.lootTableItem(Items.IRON_INGOT).setWeight(4)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1,3))))
                        .add(LootItem.lootTableItem(EPItems.STEEL_INGOT.get()).setWeight(3)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1,3))))
                        .add(LootItem.lootTableItem(EPItems.STEEL_SWORD.get()).setWeight(1)
                                .apply(EnchantRandomlyFunction.randomApplicableEnchantment()))
                )
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(2,4))
                        .add(EmptyLootItem.emptyItem().setWeight(8))
                        .add(LootItem.lootTableItem(Items.STICK).setWeight(6)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2,4))))
                        .add(LootItem.lootTableItem(Items.COAL).setWeight(5)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(3,6))))
                        .add(LootItem.lootTableItem(EPItems.BRONZE_NUGGET.get()).setWeight(4)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(3,5))))
                        .add(LootItem.lootTableItem(Items.IRON_NUGGET).setWeight(3)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2,5))))
                        .add(LootItem.lootTableItem(EPItems.BRONZE_SWORD.get()).setWeight(2)
                                .apply(EnchantRandomlyFunction.randomApplicableEnchantment()))
                        .add(LootItem.lootTableItem(EPItems.GOLDEN_UPGRADE_SMITHING_TEMPLATE.get()).setWeight(1)
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1))))
                )
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(EmptyLootItem.emptyItem().setWeight(20))
                        .add(LootItem.lootTableItem(EPItems.ANCIENT_ARMOR_TRIM_SMITHING_TEMPLATE.get()).setWeight(2)
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1))))
                );
    }

    public static LootTable.Builder ancientLordsDomainTrainingRoomEquipmentLootTable(){
        return LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(2,4))
                        .add(EmptyLootItem.emptyItem().setWeight(9))
                        .add(LootItem.lootTableItem(Items.ARROW).setWeight(7)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(3,7))))
                        .add(LootItem.lootTableItem(EPItems.ALUMINUM_ARROW.get()).setWeight(6)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2,5))))
                        .add(LootItem.lootTableItem(Items.STRING).setWeight(5)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2,3))))
                        .add(LootItem.lootTableItem(Items.FLINT).setWeight(4)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2,4))))
                )
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(1,2))
                        .add(EmptyLootItem.emptyItem().setWeight(9))
                        .add(LootItem.lootTableItem(Items.IRON_SWORD).setWeight(7)
                                .apply(EnchantRandomlyFunction.randomApplicableEnchantment())
                                .when(LootItemRandomChanceCondition.randomChance(0.25f))
                                .apply(SetItemDamageFunction.setDamage(UniformGenerator.between(30,40))))
                        .add(LootItem.lootTableItem(EPItems.IRON_DAGGER.get()).setWeight(6)
                                .apply(EnchantRandomlyFunction.randomApplicableEnchantment())
                                .when(LootItemRandomChanceCondition.randomChance(0.5f))
                                .apply(SetItemDamageFunction.setDamage(UniformGenerator.between(30,40))))
                        .add(LootItem.lootTableItem(EPItems.STEEL_DAGGER.get()).setWeight(5)
                                .apply(EnchantRandomlyFunction.randomApplicableEnchantment())
                                .when(LootItemRandomChanceCondition.randomChance(0.5f))
                                .apply(SetItemDamageFunction.setDamage(UniformGenerator.between(30,40))))
                        .add(LootItem.lootTableItem(EPItems.STEEL_SWORD.get()).setWeight(4)
                                .apply(EnchantRandomlyFunction.randomApplicableEnchantment())
                                .when(LootItemRandomChanceCondition.randomChance(0.25f))
                                .apply(SetItemDamageFunction.setDamage(UniformGenerator.between(30,40))))
                )
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(1,2))
                        .add(EmptyLootItem.emptyItem().setWeight(10))
                        .add(LootItem.lootTableItem(EPItems.BRONZE_SWORD.get()).setWeight(6)
                                .apply(EnchantRandomlyFunction.randomApplicableEnchantment())
                                .when(LootItemRandomChanceCondition.randomChance(0.75f))
                                .apply(SetItemDamageFunction.setDamage(UniformGenerator.between(30,40))))
                        .add(LootItem.lootTableItem(Items.BOW).setWeight(5)
                                .apply(EnchantRandomlyFunction.randomApplicableEnchantment())
                                .when(LootItemRandomChanceCondition.randomChance(0.5f))
                                .apply(SetItemDamageFunction.setDamage(UniformGenerator.between(30,40))))
                        .add(LootItem.lootTableItem(EPItems.STEEL_AXE.get()).setWeight(3)
                                .apply(EnchantRandomlyFunction.randomApplicableEnchantment())
                                .when(LootItemRandomChanceCondition.randomChance(0.5f))
                                .apply(SetItemDamageFunction.setDamage(UniformGenerator.between(30,40))))
                );
    }

    public static LootTable.Builder ancientLordsDomainTrainingRoomFoodLootTable(){
        return LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(2,4))
                        .add(EmptyLootItem.emptyItem().setWeight(9))
                        .add(LootItem.lootTableItem(Items.APPLE).setWeight(7)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1,3))))
                        .add(LootItem.lootTableItem(Items.ROTTEN_FLESH).setWeight(6)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2,3))))
                        .add(LootItem.lootTableItem(Items.CARROT).setWeight(5)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1,2))))
                        .add(LootItem.lootTableItem(Items.GOLDEN_CARROT).setWeight(2)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1,2))))
                );
    }

    public static LootTable.Builder ancientLordsDomainTressureRoomBarrelLootTable(){
        return LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(2,4))
                        .add(EmptyLootItem.emptyItem().setWeight(9))
                        .add(LootItem.lootTableItem(Items.GOLD_NUGGET).setWeight(7)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(3,7))))
                        .add(LootItem.lootTableItem(Items.GOLDEN_APPLE).setWeight(4)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1,2))))
                        .add(LootItem.lootTableItem(EPItems.ALUMINUM_INGOT.get()).setWeight(3)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2,5))))
                        .add(LootItem.lootTableItem(Items.DIAMOND).setWeight(2)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1,2))))
                )
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(1,2))
                        .add(EmptyLootItem.emptyItem().setWeight(8))
                        .add(LootItem.lootTableItem(Items.GOLD_INGOT).setWeight(5)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2,5))))
                        .add(LootItem.lootTableItem(Items.BOOK).setWeight(3)
                                .apply(EnchantRandomlyFunction.randomApplicableEnchantment()))
                )
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(EmptyLootItem.emptyItem().setWeight(20))
                        .add(LootItem.lootTableItem(EPItems.ANCIENT_ARMOR_TRIM_SMITHING_TEMPLATE.get()).setWeight(2)
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1))))
                );
    }

    public static LootTable.Builder ancientLordsDomainTressureRoomChestLootTable(){
        return LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(2,4))
                        .add(EmptyLootItem.emptyItem().setWeight(9))
                        .add(LootItem.lootTableItem(Items.GOLD_NUGGET).setWeight(7)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(3,7))))
                        .add(LootItem.lootTableItem(Items.GOLD_INGOT).setWeight(5)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2,5))))
                        .add(LootItem.lootTableItem(Items.GOLDEN_APPLE).setWeight(4)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1,2))))
                        .add(LootItem.lootTableItem(Items.BOOK).setWeight(3)
                                .apply(EnchantRandomlyFunction.randomApplicableEnchantment()))
                        .add(LootItem.lootTableItem(Items.DIAMOND).setWeight(2)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1,2))))
                )
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(1,2))
                        .add(EmptyLootItem.emptyItem().setWeight(8))
                        .add(LootItem.lootTableItem(EPItems.GOLDEN_UPGRADE_SMITHING_TEMPLATE.get()).setWeight(5)
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1))))
                        .add(LootItem.lootTableItem(Items.ENCHANTED_GOLDEN_APPLE).setWeight(4)
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1))))
                )
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(EmptyLootItem.emptyItem().setWeight(20))
                        .add(LootItem.lootTableItem(EPItems.ANCIENT_ARMOR_TRIM_SMITHING_TEMPLATE.get()).setWeight(2)
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1))))
                );
    }

    @SuppressWarnings("removal")
    private static ResourceLocation register(String pName){
        return new ResourceLocation(EnhancedPlaythrough.MOD_ID, "chests/" + pName);
    }
}
