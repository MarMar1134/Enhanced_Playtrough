package net.marmar.enhanced_playthrough.data.loot;

import net.marmar.enhanced_playthrough.block.ModBlocks;
import net.marmar.enhanced_playthrough.block.custom.crop.CornCropBlock;
import net.marmar.enhanced_playthrough.block.custom.crop.TomatoCropBlock;
import net.marmar.enhanced_playthrough.block.custom.crop.YerbaMateCropBlock;
import net.marmar.enhanced_playthrough.block.custom.crop.ZapalloCropBlock;
import net.marmar.enhanced_playthrough.util.enchantment.ModEnchantments;
import net.marmar.enhanced_playthrough.item.ModItems;
import net.minecraft.advancements.critereon.EnchantmentPredicate;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.*;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

public interface BlockLootTableBuilders {
    float[] BASE_FRUIT_CHANCES = new float[]{0.005F, 0.0055555557F, 0.00625F, 0.008333334F, 0.025F};
    float[] BASE_SAPLING_CHANCES = new float[]{0.05F, 0.0625F, 0.083333336F, 0.1F};
    float[] BASE_STICK_CHANCES = new float[]{0.02F, 0.022222223F, 0.025F, 0.033333335F, 0.1F};

    LootItemCondition.Builder IS_WOODEN_PICKAXE = MatchTool.toolMatches(ItemPredicate.Builder.item().of(Items.WOODEN_PICKAXE));

    LootItemCondition.Builder IS_WOODEN_OR_STONE_PICKAXE = MatchTool.toolMatches(ItemPredicate.Builder.item().of(Items.WOODEN_PICKAXE))
            .or(MatchTool.toolMatches(ItemPredicate.Builder.item().of(Items.STONE_PICKAXE)));

    LootItemCondition.Builder IS_STEEL_PICKAXE = MatchTool.toolMatches(ItemPredicate.Builder.item().of(ModItems.STEEL_PICKAXE.get()));

    LootItemCondition.Builder HAS_FINE_MINING = MatchTool.toolMatches(ItemPredicate.Builder.item()
            .hasEnchantment(new EnchantmentPredicate(ModEnchantments.FINE_MINING.get(), MinMaxBounds.Ints.atLeast(1))));

    LootItemCondition.Builder HAS_NOT_FINE_MINING_NOR_ROUGH_MINING = MatchTool.toolMatches(ItemPredicate.Builder.item()
                    .hasEnchantment(new EnchantmentPredicate(ModEnchantments.FINE_MINING.get(), MinMaxBounds.Ints.atLeast(1))))
            .or(MatchTool.toolMatches(ItemPredicate.Builder.item()
                    .hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1)))))
            .or(MatchTool.toolMatches(ItemPredicate.Builder.item()
                    .hasEnchantment(new EnchantmentPredicate(ModEnchantments.ROUGH_MINING.get(), MinMaxBounds.Ints.atLeast(1)))))
            .invert();

    LootItemCondition.Builder HAS_ROUGH_MINING = MatchTool.toolMatches(ItemPredicate.Builder.item()
            .hasEnchantment(new EnchantmentPredicate(ModEnchantments.ROUGH_MINING.get(), MinMaxBounds.Ints.atLeast(1))));

    LootItemCondition.Builder HAS_SILK_TOUCH_AND_NOT_SPECIAL_PICKAXES = MatchTool.toolMatches(ItemPredicate.Builder.item()
                    .hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1))))
            .and(IS_STEEL_PICKAXE.invert()).and(IS_WOODEN_OR_STONE_PICKAXE.invert());

    LootItemCondition.Builder HAS_NOT_ROUGH_MINING_OR_WOODEN_PICKAXE = MatchTool.toolMatches(ItemPredicate.Builder.item()
                    .hasEnchantment(new EnchantmentPredicate(ModEnchantments.ROUGH_MINING.get(), MinMaxBounds.Ints.atLeast(1)))).invert()
            .and(IS_WOODEN_PICKAXE.invert());

    LootItemCondition.Builder HAS_NOT_ROUGH_MINING_OR_WOODEN_AND_STONE_PICKAXE = MatchTool.toolMatches(ItemPredicate.Builder.item()
                    .hasEnchantment(new EnchantmentPredicate(ModEnchantments.ROUGH_MINING.get(), MinMaxBounds.Ints.atLeast(1)))).invert()
            .and(IS_WOODEN_OR_STONE_PICKAXE.invert());

    LootItemCondition.Builder HAS_NOT_ROUGH_MINING_OR_STEEL_PICKAXE = MatchTool.toolMatches(ItemPredicate.Builder.item()
                    .hasEnchantment(new EnchantmentPredicate(ModEnchantments.ROUGH_MINING.get(), MinMaxBounds.Ints.atLeast(1)))).invert()
            .and(IS_STEEL_PICKAXE.invert());

    LootItemCondition.Builder CUSTOM_HAS_SILK_TOUCH = MatchTool.toolMatches(ItemPredicate.Builder.item()
            .hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1))));

    LootItemCondition.Builder CUSTOM_HAS_SHEARS = MatchTool.toolMatches(ItemPredicate.Builder.item().of(Items.SHEARS));

    LootItemCondition.Builder CUSTOM_HAS_SHEARS_OR_SILK_TOUCH = MatchTool.toolMatches(ItemPredicate.Builder.item().of(Items.SHEARS))
            .or(MatchTool.toolMatches(ItemPredicate.Builder.item()
                    .hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1)))));

    LootItemCondition.Builder CUSTOM_HAS_NO_SHEARS_OR_SILK_TOUCH = MatchTool.toolMatches(ItemPredicate.Builder.item().of(Items.SHEARS))
            .or(MatchTool.toolMatches(ItemPredicate.Builder.item()
                    .hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1))))).invert();

    //Crop builders
    LootItemCondition.Builder YERBA_MATE_BUILDER = LootItemBlockStatePropertyCondition
            .hasBlockStateProperties(ModBlocks.YERBA_MATE_CROP.get())
            .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(YerbaMateCropBlock.AGE, 4));

    LootItemCondition.Builder ZAPALLO_BUILDER = LootItemBlockStatePropertyCondition
            .hasBlockStateProperties(ModBlocks.ZAPALLO_CROP.get())
            .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(ZapalloCropBlock.AGE, 3));

    LootItemCondition.Builder EGGPLANT_BUILDER = LootItemBlockStatePropertyCondition
            .hasBlockStateProperties(ModBlocks.EGGPLANT_CROP.get())
            .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(ZapalloCropBlock.AGE, 5));

    LootItemCondition.Builder TOMATO_BUILDER = LootItemBlockStatePropertyCondition
            .hasBlockStateProperties(ModBlocks.TOMATO_CROP.get())
            .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(TomatoCropBlock.AGE, 5));

    LootItemCondition.Builder CORN_BUILDER = LootItemBlockStatePropertyCondition
            .hasBlockStateProperties(ModBlocks.CORN_CROP.get())
            .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CornCropBlock.AGE, 7));

    /**
     * @param pBlock specifies the block that will have the loot table
     * @param minDrops specifies the minimum quantity of items that can drop the block
     * @param maxDrops specifies the maximum quantity of items that can drop the block
     * @param pRawOre specifies the dropped ore
     * @param pRemnant specifies the type of cobble dropped if the player does not have Fine Mining
     * @return the loot table for the specified block
     */
    default LootTable.Builder createBaseOreDrops(Block pBlock, int minDrops, int maxDrops, ItemLike pRawOre, ItemLike pRemnant){
        return LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(pBlock).when(CUSTOM_HAS_SILK_TOUCH)
                                .otherwise(LootItem.lootTableItem(pRawOre).when(HAS_FINE_MINING)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                                        .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE)))))

                .withPool(LootPool.lootPool()
                        .add(LootItem.lootTableItem(pRawOre)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                                .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE)))
                        .when(HAS_NOT_FINE_MINING_NOR_ROUGH_MINING))

                .withPool(LootPool.lootPool()
                        .add(LootItem.lootTableItem(pRemnant)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3)))
                                .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE)))
                        .when(HAS_NOT_FINE_MINING_NOR_ROUGH_MINING))

                .withPool(LootPool.lootPool()
                        .add(LootItem.lootTableItem(pRemnant)
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(4)))
                                .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE)))
                        .when(HAS_ROUGH_MINING));
    }

    default LootTable.Builder createOreDrops(Block pBlock, int minDrops, int maxDrops, ItemLike drop){
        return createBaseOreDrops(pBlock, minDrops, maxDrops, drop, ModItems.COBBLE.get());
    }

    default LootTable.Builder createDeepslateOreDrops(Block pBlock, int minDrops, int maxDrops, ItemLike drop){
        return createBaseOreDrops(pBlock, minDrops, maxDrops, drop, ModItems.DEEPSLATE_COBBLE.get());
    }

    default LootTable.Builder createOreDrops(Block pBlock, ItemLike drop){
        return createBaseOreDrops(pBlock, 1, 1, drop, ModItems.COBBLE.get());
    }

    default LootTable.Builder createDeepslateOreDrops(Block pBlock, ItemLike drop){
        return createBaseOreDrops(pBlock, 1, 1, drop, ModItems.DEEPSLATE_COBBLE.get());
    }

    default LootTable.Builder createBauxiteOreDrops(Block pBlock, ItemLike terracottaShard){
        return createBaseOreDrops(pBlock, 1, 1, ModItems.RAW_ALUMINUM.get(), terracottaShard);
    }

    default LootTable.Builder createNetherOreDrops(Block pBlock, int minDrops, int maxDrops, ItemLike pDrop){
        return createBaseOreDrops(pBlock, minDrops, maxDrops, pDrop, ModItems.NETHERRACK_RUBBLE.get());
    }

    /**
     * The following method is a base used to generate a loot table for a gem ore
     * @param pBlock specifies the block of the given loot table
     * @param rawGem specifies the raw gem
     * @param maxRawGems specifies the quantity of raw gems
     * @param polishedGem specifies the polished gem
     * @param maxPolishedGems specifies the quantity of polished gems
     * @param cobbleType specifies the type of cobble dropped if the player does not have Fine Mining
     * @return the loot table JSON file
     */
    default LootTable.Builder createBaseGemsDrops(Block pBlock, ItemLike rawGem, int maxRawGems, ItemLike polishedGem, int maxPolishedGems, ItemLike cobbleType){
        return LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(pBlock).when(CUSTOM_HAS_SILK_TOUCH)
                                .otherwise(LootItem.lootTableItem(polishedGem).when(HAS_FINE_MINING)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, maxPolishedGems)))
                                        .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE)))))

                .withPool(LootPool.lootPool()
                        .add(LootItem.lootTableItem(rawGem)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, maxRawGems)))
                                .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE)))
                        .when(HAS_NOT_FINE_MINING_NOR_ROUGH_MINING))

                .withPool(LootPool.lootPool()
                        .add(LootItem.lootTableItem(cobbleType)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3)))
                                .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE)))
                        .when(HAS_NOT_FINE_MINING_NOR_ROUGH_MINING))

                .withPool(LootPool.lootPool()
                        .add(LootItem.lootTableItem(cobbleType)
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(4)))
                                .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE)))
                        .when(HAS_ROUGH_MINING));
    }

    default LootTable.Builder createGemsDrops(Block pBlock, ItemLike rawGem, int maxRawGems, ItemLike gem, int maxGems){
        return createBaseGemsDrops(pBlock, rawGem, maxRawGems, gem, maxGems, ModItems.COBBLE.get());
    }

    default LootTable.Builder createDeepslateGemsDrops(Block pBlock, ItemLike rawGem, int maxRawGems, ItemLike gem, int maxGems){
        return createBaseGemsDrops(pBlock, rawGem, maxRawGems, gem, maxGems, ModItems.DEEPSLATE_COBBLE.get());
    }

    default LootTable.Builder createNetherGemsDrops(Block pBlock, ItemLike rawGem, int maxRawGems, ItemLike gem, int maxGems){
        return createBaseGemsDrops(pBlock, rawGem, maxRawGems, gem, maxGems, ModItems.NETHERRACK_RUBBLE.get());
    }

    /**
     * The following method is used to generate a loot table for a rock-type block
     * @param silkTouchRock the base block, obtainable only with Silk Touch
     * @param cobbleRock the cobbled version of the block
     * @param cobbleType the cobble item that will be dropped if not mined with appropriate tools
     * @param pCondition the condition required to get the {@code cobble type}
     * @return the loot table
     */
    default LootTable.Builder createBaseRockDrops(Block silkTouchRock, Block cobbleRock, ItemLike cobbleType, LootItemCondition.Builder pickaxeType, LootItemCondition.Builder pCondition){
        return LootTable.lootTable()
                //If it has silk touch, drops the block itself. Otherwise, checks if the pickaxe type is correct and
                //is not enchanted with rough mining. If the pickaxe is not enchanted, drops the cobble variant
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                    .add(LootItem.lootTableItem(silkTouchRock).when(HAS_SILK_TOUCH_AND_NOT_SPECIAL_PICKAXES)
                            .otherwise(LootItem.lootTableItem(cobbleRock).when(pickaxeType))))

                //If it has Rough mining (no matter the pickaxe), drops 4 cobble of its type
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                    .add(LootItem.lootTableItem(cobbleType)
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(4)))
                        .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE)))
                        .when(HAS_ROUGH_MINING))

                //If is one of the selected conditions, drops 1 to 3 cobble of its type
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(cobbleType)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3)))
                                .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE)))
                        .when(pCondition));
    }

    default LootTable.Builder createRockDrops(Block baseRock, Block cobbleRock, ItemLike cobbleType){
        return createBaseRockDrops(baseRock, cobbleRock, cobbleType, HAS_NOT_ROUGH_MINING_OR_WOODEN_AND_STONE_PICKAXE, IS_WOODEN_OR_STONE_PICKAXE);
    }

    default LootTable.Builder createHardRockDrops(Block baseRock, Block cobbleRock, ItemLike cobbleType){
        return createBaseRockDrops(baseRock, cobbleRock, cobbleType, HAS_NOT_ROUGH_MINING_OR_STEEL_PICKAXE, IS_STEEL_PICKAXE);
    }

    default LootTable.Builder createTerracottaDrops(Block baseBlock, ItemLike terracottaShard){
        return createBaseRockDrops(baseBlock,baseBlock, terracottaShard, HAS_NOT_ROUGH_MINING_OR_WOODEN_PICKAXE, IS_WOODEN_PICKAXE);
    }

    default LootTable.Builder createRoughMiningDrops(Block pBlock, ItemLike pRoughDrop, int pRoughQuantity){
        return LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                //When doesn't have Rough mining, the base block is dropped
                .add(LootItem.lootTableItem(pBlock)).when(HAS_ROUGH_MINING.invert()))

                //When has Rough mining, the alternative loot is dropped
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(pRoughDrop)
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(pRoughQuantity)))
                                .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE)))
                        .when(HAS_ROUGH_MINING));
    }

    /**
     * The following method generates a loot table for a wild crop block
     * @param pPlant specifies the crop whose loot table will be generated
     * @param pSeed specifies the seed of the crop (or his fruit/vegetable)
     * @param pMaxQuantity specifies the maximum quantity of seeds that can be dropped per block
     * @return the JSON of the crop
     */
    default LootTable.Builder createPlantWithSeedsDrops(Block pPlant, ItemLike pSeed, int pMaxQuantity, float pChances){
        return LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                .add(LootItem.lootTableItem(pPlant).when(CUSTOM_HAS_SHEARS)
                        .otherwise(LootItem.lootTableItem(pSeed)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0, pMaxQuantity)))
                                .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE))
                                .when(LootItemRandomChanceCondition.randomChance(pChances)))));
    }

    default LootTable.Builder createPlantDrops(Block pPlant){
        return LootTable.lootTable().withPool(LootPool.lootPool().when(CUSTOM_HAS_SHEARS)
                .add(LootItem.lootTableItem(pPlant)));
    }

    default LootTable.Builder createLeavesWithFruitDrops(Block pBlock, Block pSapling, float[] pSaplingChances, ItemLike pFruit, int pMaxFruitQuantity, float[] pFruitChances){
        return LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1f))
                .add(LootItem.lootTableItem(pBlock).when(CUSTOM_HAS_SHEARS_OR_SILK_TOUCH)))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1f))
                        .add(LootItem.lootTableItem(pFruit)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, pMaxFruitQuantity)))
                                .when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE, pFruitChances)))
                        .when(CUSTOM_HAS_NO_SHEARS_OR_SILK_TOUCH))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1f))
                        .add(LootItem.lootTableItem(Items.STICK)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1f, 2f)))
                                .when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE, BASE_STICK_CHANCES)))
                        .when(CUSTOM_HAS_NO_SHEARS_OR_SILK_TOUCH))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1f))
                        .add(LootItem.lootTableItem(pSapling)
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1)))
                                .when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE, pSaplingChances)))
                        .when(CUSTOM_HAS_NO_SHEARS_OR_SILK_TOUCH));
    }

    default LootTable.Builder createLeavesWithFruitDrops(Block pBlock, Block pSapling, ItemLike pFruit, int pMaxFruitQuantity, float... pFruitChances){
        return createLeavesWithFruitDrops(pBlock, pSapling, BASE_SAPLING_CHANCES, pFruit, pMaxFruitQuantity, pFruitChances);
    }

    default LootTable.Builder createLeavesWithFruitDrops(Block pBlock, Block pSapling, ItemLike pFruit, int pFruits){
        return createLeavesWithFruitDrops(pBlock, pSapling, BASE_SAPLING_CHANCES, pFruit, pFruits, BASE_FRUIT_CHANCES);
    }

    default LootTable.Builder createLeavesWithFruitDrops(Block pBlock, Block pSapling, ItemLike pFruit, float... pFruitChances){
        return createLeavesWithFruitDrops(pBlock, pSapling, BASE_SAPLING_CHANCES, pFruit, 1, pFruitChances);
    }

    default LootTable.Builder createLeavesWithFruitDrops(Block pBlock, Block pSapling, ItemLike pFruit){
        return createLeavesWithFruitDrops(pBlock, pSapling, BASE_SAPLING_CHANCES, pFruit, 1, BASE_FRUIT_CHANCES);
    }

    default LootTable.Builder createLeavesWithFruitDrops(Block pBlock, Block pSapling, float[] pSaplingChances, ItemLike pFruit, float... pFruitChances){
        return createLeavesWithFruitDrops(pBlock, pSapling, pSaplingChances, pFruit, 1, pFruitChances);
    }

    default LootTable.Builder createLeavesWithoutFruitDrops(Block pBlock, Block pSapling, float... pSaplingChances){
        return LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1f))
                        .add(LootItem.lootTableItem(pBlock).when(CUSTOM_HAS_SHEARS_OR_SILK_TOUCH)))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1f))
                        .add(LootItem.lootTableItem(Items.STICK)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1f, 2f)))
                                .when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE, BASE_STICK_CHANCES)))
                        .when(CUSTOM_HAS_NO_SHEARS_OR_SILK_TOUCH))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1f))
                        .add(LootItem.lootTableItem(pSapling)
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1)))
                                .when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE, pSaplingChances)))
                        .when(CUSTOM_HAS_NO_SHEARS_OR_SILK_TOUCH));
    }

    default LootTable.Builder createLeavesWithoutFruitDrops(Block pBlock, Block pSapling){
        return createLeavesWithoutFruitDrops(pBlock, pSapling, BASE_SAPLING_CHANCES);
    }
}
