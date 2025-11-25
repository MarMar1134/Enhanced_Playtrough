package net.marmar.enhanced_playthrough.data.loottable.entity;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
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
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceWithLootingCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.function.BiConsumer;

public class EPEntityLootTables implements LootTableSubProvider {
    public static final ResourceLocation ZOMBIE_KNIGHT_LOCATION = register("zombie_knight");
    public static final ResourceLocation SKELETON_BOWMASTER_LOCATION = register("skeleton_bowmaster");

    @Override
    public void generate(BiConsumer<ResourceLocation, LootTable.Builder> pOutput) {
        pOutput.accept(ZOMBIE_KNIGHT_LOCATION, zombieKnightLootTable());
        pOutput.accept(SKELETON_BOWMASTER_LOCATION, skeletonBowmasterLootTable());
    }

    protected static final EntityPredicate.Builder ENTITY_ON_FIRE = EntityPredicate.Builder.entity()
            .flags(EntityFlagsPredicate.Builder.flags().setOnFire(true).build());

    public static LootTable.Builder zombieKnightLootTable(){
        return LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(Items.ROTTEN_FLESH)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0, 3)))
                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0, 1)))))

                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(EPItems.ZAPALLO.get())
                        .apply(SmeltItemFunction.smelted()
                                .when(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS, ENTITY_ON_FIRE))))
                .add(LootItem.lootTableItem(EPItems.EGGPLANT.get())
                        .apply(SmeltItemFunction.smelted()
                                .when(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS, ENTITY_ON_FIRE))))
                .add(LootItem.lootTableItem(EPItems.STEEL_INGOT.get()))
                        .when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.025f, 0.1f)));
    }

    public static LootTable.Builder skeletonBowmasterLootTable(){
        return LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(Items.BONE)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0, 3)))
                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0, 1)))))

                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(EPItems.ALUMINUM_ARROW.get())
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0, 2)))
                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0, 1)))));
    }

    private static ResourceLocation register(String pName){
        return ResourceLocation.fromNamespaceAndPath(EnhancedPlaythrough.MOD_ID, "entities/" + pName);
    }
}
