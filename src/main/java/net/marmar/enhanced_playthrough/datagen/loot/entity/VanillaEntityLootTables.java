package net.marmar.enhanced_playthrough.datagen.loot.entity;

import net.marmar.enhanced_playthrough.item.EPItems;
import net.minecraft.advancements.critereon.EntityFlagsPredicate;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.LootingEnchantFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.functions.SmeltItemFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemEntityPropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.function.BiConsumer;

public class VanillaEntityLootTables implements LootTableSubProvider {
    public static final ResourceLocation COW = register("cow");
    public static final ResourceLocation PIG = register("pig");

    protected static final EntityPredicate.Builder ENTITY_ON_FIRE = EntityPredicate.Builder.entity()
            .flags(EntityFlagsPredicate.Builder.flags().setOnFire(true).build());

    @Override
    public void generate(BiConsumer<ResourceLocation, LootTable.Builder> biConsumer) {
        biConsumer.accept(COW, createCowLootTable());
        biConsumer.accept(PIG, createPigLootTable());
    }

    public static LootTable.Builder createCowLootTable(){
        return LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(EPItems.COW_HIDE.get())
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0,2)))
                                .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0,1)))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(Items.BEEF)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1,3)))
                                .apply(SmeltItemFunction.smelted()
                                        .when(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS, ENTITY_ON_FIRE)))
                                .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0,1)))));
    }

    public static LootTable.Builder createPigLootTable(){
        return LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(EPItems.PIG_HIDE.get())
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0,2)))
                                .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0,1)))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(Items.PORKCHOP)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1,3)))
                                .apply(SmeltItemFunction.smelted()
                                        .when(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS, ENTITY_ON_FIRE)))
                                .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0,1)))));
    }

    private static ResourceLocation register(String pName){
        return ResourceLocation.fromNamespaceAndPath("minecraft", "entities/" + pName);
    }
}
