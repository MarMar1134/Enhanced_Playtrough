package net.marmar.enhanced_playthrough.loot;

import net.marmar.enhanced_playthrough.block.ModBlocks;
import net.marmar.enhanced_playthrough.block.custom.crops.CornCropBlock;
import net.marmar.enhanced_playthrough.block.custom.crops.TomatoCropBlock;
import net.marmar.enhanced_playthrough.block.custom.crops.YerbaMateCropBlock;
import net.marmar.enhanced_playthrough.block.custom.crops.ZapalloCropBlock;
import net.marmar.enhanced_playthrough.enchantment.ModEnchantments;
import net.marmar.enhanced_playthrough.item.ModItems;
import net.minecraft.advancements.critereon.EnchantmentPredicate;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.BonusLevelTableCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {

    public ModBlockLootTables(){
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }
    //Condition builders
        //Base
        protected static final LootItemCondition.Builder HAS_FINE_MINING;
        protected static final LootItemCondition.Builder HAS_SILK_TOUCH;

        //Crops
        protected static final LootItemCondition.Builder YERBA_MATE_BUILDER;
        protected static final LootItemCondition.Builder ZAPALLO_BUILDER;
        protected static final LootItemCondition.Builder EGGPLANT_BUILDER;
        protected static final LootItemCondition.Builder TOMATO_BUILDER;
        protected static final LootItemCondition.Builder CORN_BUILDER;

    @Override
    protected void generate() {
        //Polished stone
        this.dropSelf(ModBlocks.POLISHED_STONE.get());
        this.add(ModBlocks.POLISHED_STONE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.POLISHED_STONE_SLAB.get()));
        this.dropSelf(ModBlocks.POLISHED_STONE_STAIRS.get());
        this.dropSelf(ModBlocks.POLISHED_STONE_WALL.get());

        //Cobbled limestone
        this.dropSelf(ModBlocks.COBBLED_LIMESTONE.get());
        this.add(ModBlocks.COBBLED_LIMESTONE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.COBBLED_LIMESTONE_SLAB.get()));
        this.dropSelf(ModBlocks.COBBLED_LIMESTONE_STAIRS.get());
        this.dropSelf(ModBlocks.COBBLED_LIMESTONE_WALL.get());

        //Limestone
        this.add(ModBlocks.LIMESTONE.get(),
                block -> createLimestoneDrops(ModBlocks.LIMESTONE.get()));
        this.add(ModBlocks.LIMESTONE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.LIMESTONE_SLAB.get()));
        this.dropSelf(ModBlocks.LIMESTONE_STAIRS.get());

        //Polished limestone
        this.dropSelf(ModBlocks.POLISHED_LIMESTONE.get());
        this.add(ModBlocks.POLISHED_LIMESTONE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.POLISHED_LIMESTONE_SLAB.get()));
        this.dropSelf(ModBlocks.POLISHED_LIMESTONE_STAIRS.get());
        this.dropSelf(ModBlocks.POLISHED_LIMESTONE_WALL.get());

        //Limestone bricks
        this.dropSelf(ModBlocks.LIMESTONE_BRICKS.get());
        this.add(ModBlocks.LIMESTONE_BRICK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.LIMESTONE_BRICK_SLAB.get()));
        this.dropSelf(ModBlocks.LIMESTONE_BRICK_STAIRS.get());
        this.dropSelf(ModBlocks.LIMESTONE_BRICK_WALL.get());

        //Soul
        this.dropSelf(ModBlocks.SOUL_MUD.get());
        this.dropSelf(ModBlocks.SOUL_MUD_BRICKS.get());
        this.add(ModBlocks.SOUL_MUD_BRICK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.SOUL_MUD_BRICK_SLAB.get()));
        this.dropSelf(ModBlocks.SOUL_MUD_BRICK_STAIRS.get());
        this.dropSelf(ModBlocks.SOUL_MUD_BRICK_WALL.get());

        //ores
        this.add(ModBlocks.NETHER_COPPER_ORE.get(),
                block -> createOreDrops(ModBlocks.NETHER_COPPER_ORE.get(), 2, 5, Items.RAW_COPPER));

        this.add(ModBlocks.TIN_ORE.get(),
                block -> createOreDrops(ModBlocks.TIN_ORE.get(), 1, 4, ModItems.RAW_TIN.get()));
        this.add(ModBlocks.DEEPSLATE_TIN_ORE.get(),
                block -> createOreDrops(ModBlocks.TIN_ORE.get(), 2, 6, ModItems.RAW_TIN.get()));

        this.add(ModBlocks.ZINC_ORE.get(),
                block -> createOreDrops(ModBlocks.ZINC_ORE.get(), 1, 3, ModItems.RAW_ZINC.get()));
        this.add(ModBlocks.DEEPSLATE_ZINC_ORE.get(),
                block -> createOreDrops(ModBlocks.ZINC_ORE.get(), 2, 5, ModItems.RAW_ZINC.get()));
        this.add(ModBlocks.NETHER_ZINC_ORE.get(),
                block -> createOreDrops(ModBlocks.ZINC_ORE.get(), 3, 7, ModItems.RAW_ZINC.get()));

        this.add(ModBlocks.SULFUR_ORE.get(),
                block -> createOreDrops(ModBlocks.SULFUR_ORE.get(), 2, 5, ModItems.SULFUR.get()));
        this.add(ModBlocks.DEEPSLATE_SULFUR_ORE.get(),
                block -> createOreDrops(ModBlocks.SULFUR_ORE.get(), 3, 7, ModItems.SULFUR.get()));
        this.add(ModBlocks.NETHER_SULFUR_ORE.get(),
                block -> createOreDrops(ModBlocks.SULFUR_ORE.get(), 4, 9, ModItems.SULFUR.get()));

        this.add(ModBlocks.SILVER_ORE.get(),
                block -> createOreDrops(ModBlocks.SILVER_ORE.get(), ModItems.RAW_SILVER.get()));
        this.add(ModBlocks.DEEPSLATE_SILVER_ORE.get(),
                block -> createOreDrops(ModBlocks.DEEPSLATE_SILVER_ORE.get(), ModItems.RAW_SILVER.get()));

        this.add(ModBlocks.RUBI_ORE.get(),
                block -> createGemsDrops(ModBlocks.RUBI_ORE.get(), ModItems.RAW_RUBI.get(), 2, ModItems.RUBI.get(), 1));
        this.add(ModBlocks.DEEPSLATE_RUBI_ORE.get(),
                block -> createGemsDrops(ModBlocks.DEEPSLATE_RUBI_ORE.get(), ModItems.RAW_RUBI.get(), 3, ModItems.RUBI.get(), 2));

        this.add(ModBlocks.SAPPHIRE_ORE.get(),
                block -> createGemsDrops(ModBlocks.SAPPHIRE_ORE.get(), ModItems.RAW_SAPPHIRE.get(), 3, ModItems.SAPPHIRE.get(), 2));
        this.add(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get(),
                block -> createGemsDrops(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get(), ModItems.RAW_SAPPHIRE.get(), 4, ModItems.SAPPHIRE.get(), 3));

        this.add(ModBlocks.NETHER_GARNET_ORE.get(),
                block -> createGemsDrops(ModBlocks.NETHER_GARNET_ORE.get(), ModItems.RAW_GARNET.get(), 2, ModItems.GARNET.get(), 1));

        this.add(ModBlocks.COBALT_ORE.get(),
                block -> createOreDrops(ModBlocks.COBALT_ORE.get(), ModItems.COBALT.get()));
        this.add(ModBlocks.DEEPSLATE_COBALT_ORE.get(),
                block -> createOreDrops(ModBlocks.DEEPSLATE_COBALT_ORE.get(), ModItems.COBALT.get()));

        //ore blocks
        this.dropSelf(ModBlocks.SILVER_BLOCK.get());
        this.dropSelf(ModBlocks.TIN_BLOCK.get());
        this.dropSelf(ModBlocks.ZINC_BLOCK.get());
        this.dropSelf(ModBlocks.BRASS_BLOCK.get());
        this.dropSelf(ModBlocks.BRONZE_BLOCK.get());
        this.dropSelf(ModBlocks.ROSE_GOLD_BLOCK.get());
        this.dropSelf(ModBlocks.BRONZIUM_BLOCK.get());
        this.dropSelf(ModBlocks.STEEL_BLOCK.get());
        this.dropSelf(ModBlocks.GREEN_GOLD_BLOCK.get());
        this.dropSelf(ModBlocks.BLUE_GOLD_BLOCK.get());

        //Tree drops
            //walnut
            this.dropSelf(ModBlocks.WALNUT_SAPLING.get());
            this.dropSelf(ModBlocks.WALNUT_LOG.get());
            this.dropSelf(ModBlocks.STRIPPED_WALNUT_LOG.get());
            this.dropSelf(ModBlocks.WALNUT_WOOD.get());
            this.dropSelf(ModBlocks.STRIPPED_WALNUT_WOOD.get());

            this.add(ModBlocks.WALNUT_LEAVES.get(),
                    block -> createLeaveWithFruitDrop(block, ModBlocks.WALNUT_SAPLING.get(), ModItems.WALNUT.get(), 4f));

            this.dropSelf(ModBlocks.WALNUT_PLANKS.get());

            this.add(ModBlocks.WALNUT_DOOR.get(),
                    block -> createDoorTable(ModBlocks.WALNUT_DOOR.get()));

            this.dropSelf(ModBlocks.WALNUT_TRAPDOOR.get());

            this.dropSelf(ModBlocks.WALNUT_BUTTON.get());

            this.dropSelf(ModBlocks.WALNUT_PRESSURE_PLATE.get());

            this.dropSelf(ModBlocks.WALNUT_STAIRS.get());
            this.add(ModBlocks.WALNUT_SLAB.get(),
                    block -> createSlabItemTable(ModBlocks.WALNUT_SLAB.get()));
            this.dropSelf(ModBlocks.WALNUT_FENCE.get());
            this.dropSelf(ModBlocks.WALNUT_FENCEGATE.get());

            //Apple
            this.dropSelf(ModBlocks.APPLE_SAPLING.get());
            this.dropSelf(ModBlocks.GREEN_APPLE_SAPLING.get());
            this.dropSelf(ModBlocks.APPLE_LOG.get());
            this.dropSelf(ModBlocks.STRIPPED_APPLE_LOG.get());
            this.dropSelf(ModBlocks.APPLE_WOOD.get());
            this.dropSelf(ModBlocks.STRIPPED_APPLE_WOOD.get());

            this.add(ModBlocks.APPLE_LEAVES.get(),
                    block -> createLeaveWithFruitDrop(block, ModBlocks.APPLE_SAPLING.get(), Items.APPLE));
            this.add(ModBlocks.GREEN_APPLE_LEAVES.get(),
                    block -> createLeaveWithFruitDrop(block, ModBlocks.GREEN_APPLE_SAPLING.get(), ModItems.GREEN_APPLE.get()));

            this.dropSelf(ModBlocks.APPLE_PLANKS.get());

            this.add(ModBlocks.APPLE_DOOR.get(),
                    block -> createDoorTable(ModBlocks.APPLE_DOOR.get()));

            this.dropSelf(ModBlocks.APPLE_TRAPDOOR.get());

            this.dropSelf(ModBlocks.APPLE_BUTTON.get());

            this.dropSelf(ModBlocks.APPLE_PRESSURE_PLATE.get());

            this.dropSelf(ModBlocks.APPLE_STAIRS.get());
            this.add(ModBlocks.APPLE_SLAB.get(),
                    block -> createSlabItemTable(ModBlocks.APPLE_SLAB.get()));
            this.dropSelf(ModBlocks.APPLE_FENCE.get());
            this.dropSelf(ModBlocks.APPLE_FENCEGATE.get());

            //Orange
            this.dropSelf(ModBlocks.ORANGE_SAPLING.get());
            this.dropSelf(ModBlocks.ORANGE_LOG.get());
            this.dropSelf(ModBlocks.STRIPPED_ORANGE_LOG.get());
            this.dropSelf(ModBlocks.ORANGE_WOOD.get());
            this.dropSelf(ModBlocks.STRIPPED_ORANGE_WOOD.get());

            this.add(ModBlocks.ORANGE_LEAVES.get(),
                    block -> createLeaveWithFruitDrop(block, ModBlocks.ORANGE_SAPLING.get(), ModItems.ORANGE.get(), 3f));

            this.dropSelf(ModBlocks.ORANGE_PLANKS.get());

            this.add(ModBlocks.ORANGE_DOOR.get(),
                    block -> createDoorTable(ModBlocks.ORANGE_DOOR.get()));

            this.dropSelf(ModBlocks.ORANGE_TRAPDOOR.get());

            this.dropSelf(ModBlocks.ORANGE_BUTTON.get());

            this.dropSelf(ModBlocks.ORANGE_PRESSURE_PLATE.get());

            this.dropSelf(ModBlocks.ORANGE_STAIRS.get());
            this.add(ModBlocks.ORANGE_SLAB.get(),
                    block -> createSlabItemTable(ModBlocks.ORANGE_SLAB.get()));
            this.dropSelf(ModBlocks.ORANGE_FENCE.get());
            this.dropSelf(ModBlocks.ORANGE_FENCEGATE.get());

            //Lemon
            this.dropSelf(ModBlocks.LEMON_SAPLING.get());
            this.dropSelf(ModBlocks.LEMON_LOG.get());
            this.dropSelf(ModBlocks.STRIPPED_LEMON_LOG.get());
            this.dropSelf(ModBlocks.LEMON_WOOD.get());
            this.dropSelf(ModBlocks.STRIPPED_LEMON_WOOD.get());

            this.add(ModBlocks.LEMON_LEAVES.get(),
                    block -> createLeaveWithFruitDrop(block, ModBlocks.LEMON_SAPLING.get(), ModItems.LEMON.get()));

            this.dropSelf(ModBlocks.LEMON_PLANKS.get());

            this.add(ModBlocks.LEMON_DOOR.get(),
                    block -> createDoorTable(ModBlocks.LEMON_DOOR.get()));

            this.dropSelf(ModBlocks.LEMON_TRAPDOOR.get());

            this.dropSelf(ModBlocks.LEMON_BUTTON.get());

            this.dropSelf(ModBlocks.LEMON_PRESSURE_PLATE.get());

            this.dropSelf(ModBlocks.LEMON_STAIRS.get());
            this.add(ModBlocks.LEMON_SLAB.get(),
                    block -> createSlabItemTable(ModBlocks.LEMON_SLAB.get()));
            this.dropSelf(ModBlocks.LEMON_FENCE.get());
            this.dropSelf(ModBlocks.LEMON_FENCEGATE.get());

            //Lime
            this.dropSelf(ModBlocks.LIME_SAPLING.get());
            this.add(ModBlocks.LIME_LEAVES.get(),
                    block -> createLeaveWithFruitDrop(block, ModBlocks.LIME_SAPLING.get(), ModItems.LIME.get(), 3f));

        //Crops
            //Yerba mate
            this.add(ModBlocks.YERBA_MATE_CROP.get(), createCropDrops(ModBlocks.YERBA_MATE_CROP.get(), ModItems.YERBA_MATE.get(),
                ModItems.YERBA_MATE_SEEDS.get(), YERBA_MATE_BUILDER));

            //Zapallo
            this.add(ModBlocks.ZAPALLO_CROP.get(), createCropDrops(ModBlocks.ZAPALLO_CROP.get(), ModItems.ZAPALLO.get(),
                ModItems.ZAPALLO_SEEDS.get(), ZAPALLO_BUILDER));

            //Eggplant
            this.add(ModBlocks.EGGPLANT_CROP.get(), createCropDrops(ModBlocks.EGGPLANT_CROP.get(), ModItems.EGGPLANT.get(),
                ModItems.EGGPLANT_SEEDS.get(), EGGPLANT_BUILDER));

            //Tomato
            this.add(ModBlocks.TOMATO_CROP.get(), createCropDrops(ModBlocks.TOMATO_CROP.get(), ModItems.TOMATO.get(),
                ModItems.TOMATO_SEEDS.get(), TOMATO_BUILDER));

            //Corn
            this.add(ModBlocks.CORN_CROP.get(), createCropDrops(ModBlocks.CORN_CROP.get(), ModItems.CORN.get(),
                 ModItems.CORN_SEEDS.get(), CORN_BUILDER));

         //Entity blocks
        this.dropSelf(ModBlocks.ADOBE_FURNACE.get());
        this.dropSelf(ModBlocks.SOUL_FURNACE.get());

        this.dropSelf(ModBlocks.ADOBE_ALLOYING_FURNACE.get());
        this.dropSelf(ModBlocks.SUPER_ALLOYING_FURNACE.get());
        this.dropSelf(ModBlocks.SOUL_ALLOY_FURNACE.get());

        this.dropSelf(ModBlocks.GEM_POLISHER.get());
        this.dropSelf(ModBlocks.GRINDER.get());
    }

    //Loot table creators
    /**
     *
     * @param leavesBlock references the block that will have the specified loot table.
     * @param saplingBlock references the sapling block that will drop the leave block.
     * @param secondLoot references the second loot that will drop the leave block. by default, the max drop for this method is 2.
     *@return the JSON file of the loot table for the specified block
     */
    protected LootTable.Builder createLeaveWithFruitDrop(Block leavesBlock, Block saplingBlock, Item secondLoot){
        return createLeaveWithFruitDrop(leavesBlock, saplingBlock, secondLoot, 2f);
    }

    /**
     *
     * @param leavesBlock references the block that will have the specified loot table.
     * @param saplingBlock references the sapling block that will drop the leave block.
     * @param secondLoot references the second loot that will drop the leave block.
     *                  You have to define the max quantity of items dropped in the {@code dropsPerLeave} parameter.
     * @param dropsPerLeave defines the max quantity of items dropped by the block.
     *@return the JSON file of the loot table for the specified block
     */
    protected LootTable.Builder createLeaveWithFruitDrop(Block leavesBlock, Block saplingBlock, Item secondLoot, float dropsPerLeave){
        return createLeavesDrops(leavesBlock, saplingBlock, 0.05f)
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(this.applyExplosionCondition(leavesBlock, LootItem.lootTableItem(secondLoot))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0F, dropsPerLeave)))
                                .when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE, 0.05F, 0.055555557F, 0.0625F, 0.08333334F, 0.087F)
                                )));
    }

    protected LootTable.Builder createOreDrops(Block pBlock, ItemLike drop){
        return createOreDrops(pBlock, 1, 1, drop);
    }

    /**
     *
     * @param pBlock specifies the block that will have the loot table
     * @param minDrops specifies the minimum quantity of items that can drop the block
     * @param maxDrops specifies the maximum quantity of items that can drop the block
     * @param drop specifies the item that will be dropped
     * @return the loot table for the specified block
     */
    protected LootTable.Builder createOreDrops(Block pBlock, int minDrops, int maxDrops, ItemLike drop){
        return createSilkTouchDispatchTable(pBlock, this.applyExplosionDecay(pBlock, LootItem.lootTableItem(drop)
                .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    /**
     *
     * @param pBlock references the block that will have the loot table.
     * @return the JSON file of the loot table for the specified block
     */
    protected LootTable.Builder createCopperOreDrops(Block pBlock) {
        return createSilkTouchDispatchTable(pBlock, this.applyExplosionDecay(pBlock, LootItem.lootTableItem(Items.RAW_COPPER)
                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 5.0F)))
                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    /**
     *
     * @param pBlock specifies the block that will have the loot table
     * @param rawGem specifies the raw gem that will be dropped if the pickaxe doesn´t have Fine Mining
     * @param gem specifies the gem that will be dropped if the pickaxe has Fine Mining
     * @param maxGems specifies the max quantity of gems that have the chance to be dropped
     * @return the loot table JSON file with the given conditions
     */
    protected LootTable.Builder createGemsDrops(Block pBlock, ItemLike rawGem, int maxRawGems, ItemLike gem, int maxGems){
        return createSilkTouchDropsWithExtraItem(pBlock, HAS_FINE_MINING, rawGem, maxRawGems, gem, maxGems);
    }

    /**
     *
     * @param pBlock specifies the block that will have the loot table
     * @param pConditionBuilder specifies the condition to be satisfied to acquire the conditional drop
     * @param baseItem specifies the item that will be dropped if the condition isn´t satisfied
     * @param maxBaseDrops specifies the maximum quantity of items that will be dropped in case the condition isn´t satisfied
     * @param conditionalItem specifies the item that will be dropped if the condition is satisfied
     * @param maxDrops specifies the maximum quantity of items that will be dropped in case the condition is satisfied
     * @return the loot table for the specified block
     */
    protected LootTable.Builder createSilkTouchDropsWithExtraItem(Block pBlock, LootItemCondition.Builder pConditionBuilder, ItemLike baseItem, int maxBaseDrops, ItemLike conditionalItem, int maxDrops){
       return LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                .add(LootItem.lootTableItem(pBlock).when(HAS_SILK_TOUCH)

                        .otherwise(LootItem.lootTableItem(conditionalItem).when(pConditionBuilder)
                            .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, maxDrops)))
                            .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE)))

                        .otherwise(this.applyExplosionDecay(pBlock, LootItem.lootTableItem(baseItem)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, maxBaseDrops)))
                                .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE))))));
    }

    /**
     *
     * @param pBlock references the block that will have the loot table.
     * @return the JSON file of the loot table for the specified block
     */
    protected LootTable.Builder createLimestoneDrops(Block pBlock){
        return createSilkTouchDispatchTable(pBlock, this.applyExplosionDecay(pBlock, LootItem.lootTableItem(ModBlocks.COBBLED_LIMESTONE.get())
                 .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1)))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }

    static {
        //Conditional builders
        HAS_FINE_MINING = MatchTool.toolMatches(net.minecraft.advancements.critereon.ItemPredicate.Builder.item()
                .hasEnchantment(new EnchantmentPredicate(ModEnchantments.FINE_MINING.get(), MinMaxBounds.Ints.atLeast(1))));

        HAS_SILK_TOUCH = MatchTool.toolMatches(net.minecraft.advancements.critereon.ItemPredicate.Builder.item()
                .hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1))));

        //Crop builders
        YERBA_MATE_BUILDER = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.YERBA_MATE_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(YerbaMateCropBlock.AGE, 4));

        ZAPALLO_BUILDER = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.ZAPALLO_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(ZapalloCropBlock.AGE, 3));

        EGGPLANT_BUILDER = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.EGGPLANT_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(ZapalloCropBlock.AGE, 5));

        TOMATO_BUILDER = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.TOMATO_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(TomatoCropBlock.AGE, 5));

        CORN_BUILDER = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.CORN_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CornCropBlock.AGE, 7));

    }
}
