package net.marmar.enhanced_playthrough.worldgen.structure.processor;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.ChiseledBookShelfBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import org.jetbrains.annotations.Nullable;

/** This processor can be utilized on any structurePiece that contains a {@code Chiseled Bookshelf}.
 * <p>
 * It takes no parameters, as it only searches for the {@code Chiseled bookshelf} on the piece and tries to insert a {@code Book} on any of his slots.
 * The book can or cannot be enchanted, based on random probability.
 * </p>
 */
public class PopulateLibraryProcessor extends StructureProcessor {
    public static final Codec<PopulateLibraryProcessor> CODEC = Codec.unit(PopulateLibraryProcessor::new);

    public StructureTemplate.StructureBlockInfo processChiseledBookshelf(StructureTemplate.StructureBlockInfo pOriginal, StructureTemplate.StructureBlockInfo pProcessed, StructurePlaceSettings pPlaceSettings) {
        NonNullList<ItemStack> items = NonNullList.withSize(6, ItemStack.EMPTY); //Inventory of the Chiseled Bookshelf

        RandomSource random = RandomSource.create(pProcessed.pos().asLong() ^ pPlaceSettings.getRandom(pProcessed.pos()).nextLong());

        int rolls = 1 + random.nextInt(5); //Number of tries made to insert a book on the block's inventory.

        for (int i = 0; i < rolls; i++) {
            int slot = random.nextInt(6); //Slot where the book will be inserted. It can override another books
            int enchantmentLevel = 5 + random.nextInt(26); //Level of the "Enchanting Table" used on the books, with a maximum of level 30

            ItemStack book = new ItemStack(Items.BOOK);

            int action = random.nextInt(5); //Defines if the book will be enchanted or not.

            switch (action) {
                case 1, 2, 4 -> items.set(slot, book);

                case 0, 3 -> {
                    ItemStack enchantedBook = EnchantmentHelper.enchantItem(random, book, enchantmentLevel, true);
                    items.set(slot, enchantedBook);
                }
            }
        }

        //Generates the list of items to be stored on the chiseled bookshelf. Is stored as an NBT data list.
        ListTag itemsList = new ListTag();
        for (int i = 0; i < items.size(); i++) {
            ItemStack stack = items.get(i);
            if (!stack.isEmpty()) {
                CompoundTag itemTag = new CompoundTag();
                itemTag.putByte("Slot", (byte) i);
                stack.save(itemTag);
                itemsList.add(itemTag);
            }
        }

        //We update the occupied slots NBT data on the block. Without this, the books are stored but not rendered.
        //We also update the block state to tell the entity "there are books here"
        CompoundTag bookshelfTag = pProcessed.nbt() != null ? pProcessed.nbt().copy() : new CompoundTag();
        BlockState state = pProcessed.state();

        for (int i = 0; i < 6; i++) {
            boolean occupied = !items.get(i).isEmpty();
            bookshelfTag.putBoolean("slot_" + i + "_occupied", occupied);
            state = state.setValue(ChiseledBookShelfBlock.SLOT_OCCUPIED_PROPERTIES.get(i), occupied);
        }

        //Final tag. It will be stored directly on the Chiseled Bookshelf
        bookshelfTag.put("Items", itemsList);

        return new StructureTemplate.StructureBlockInfo(pProcessed.pos(), state, bookshelfTag);
    }

    @Override
    public @Nullable StructureTemplate.StructureBlockInfo process(LevelReader pLevel, BlockPos pPos, BlockPos pPivot, StructureTemplate.StructureBlockInfo pOriginal, StructureTemplate.StructureBlockInfo pProcessed, StructurePlaceSettings pPlaceSettings, @Nullable StructureTemplate template) {
        if (pProcessed.state().getBlock() instanceof  ChiseledBookShelfBlock){
            return processChiseledBookshelf(pOriginal, pProcessed, pPlaceSettings);
        }

        return super.process(pLevel, pPos, pPivot, pOriginal, pProcessed, pPlaceSettings, template);
    }

    @Override
    protected StructureProcessorType<?> getType() {
        return EPStructureProcessors.POPULATE_LIBRARY.get();
    }
}
