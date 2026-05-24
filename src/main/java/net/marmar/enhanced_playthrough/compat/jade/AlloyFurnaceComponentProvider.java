package net.marmar.enhanced_playthrough.compat.jade;

import net.marmar.enhanced_playthrough.block.custom.alloyfurnace.entity.AbstractAlloyFurnaceBlockEntity;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import snownee.jade.api.BlockAccessor;
import snownee.jade.api.IBlockComponentProvider;
import snownee.jade.api.IServerDataProvider;
import snownee.jade.api.ITooltip;
import snownee.jade.api.config.IPluginConfig;
import snownee.jade.api.ui.IElementHelper;
import snownee.jade.impl.ui.ProgressArrowElement;

public enum AlloyFurnaceComponentProvider implements IBlockComponentProvider, IServerDataProvider<BlockAccessor> {
    INSTANCE;

    @Override
    public void appendTooltip(ITooltip iTooltip, BlockAccessor blockAccessor, IPluginConfig iPluginConfig) {
        CompoundTag blockData = blockAccessor.getServerData();
        IElementHelper GUIHelper = IElementHelper.get();

        ListTag blockItems = blockData.getList("alloy_furnace_contents", Tag.TAG_COMPOUND);
        NonNullList<ItemStack> blockInventory = NonNullList.withSize(4, ItemStack.EMPTY);

        int alloyProgress = blockData.getInt("alloy_furnace.progress");
        int maxAlloyProgress = blockData.getInt("alloy_furnace.maxProgress");


        if (!blockData.contains("alloy_furnace.progress")){
            return;
        }

        for (int i = 0; i < blockInventory.size(); i++) {
            blockInventory.set(i, ItemStack.of(blockItems.getCompound(i)));
        }

        iTooltip.add(GUIHelper.item(blockInventory.get(0)));
        iTooltip.append(GUIHelper.item(blockInventory.get(1)));
        iTooltip.append(GUIHelper.item(blockInventory.get(2)));

        if (alloyProgress != 0) {
            iTooltip.append(new ProgressArrowElement((float) alloyProgress / maxAlloyProgress));
        }

        iTooltip.append(GUIHelper.item(blockInventory.get(3)));
    }

    @Override
    public void appendServerData(CompoundTag compoundTag, BlockAccessor blockAccessor) {
        AbstractAlloyFurnaceBlockEntity alloyFurnaceBlockEntity = (AbstractAlloyFurnaceBlockEntity) blockAccessor.getBlockEntity();
        ListTag blockData = new ListTag();

        blockData.add(alloyFurnaceBlockEntity.getFirstInputHandler().getStackInSlot(0).serializeNBT());
        blockData.add(alloyFurnaceBlockEntity.getSecondInputHandler().getStackInSlot(0).serializeNBT());
        blockData.add(alloyFurnaceBlockEntity.getFuelHandler().getStackInSlot(0).serializeNBT());
        blockData.add(alloyFurnaceBlockEntity.getOutputHandler().getStackInSlot(0).serializeNBT());

        compoundTag.put("alloy_furnace_contents", blockData);
        compoundTag.putInt("alloy_furnace.progress", alloyFurnaceBlockEntity.getProgress());
        compoundTag.putInt("alloy_furnace.maxProgress", alloyFurnaceBlockEntity.getMaxProgress());

    }

    @Override
    public ResourceLocation getUid() {
        return EnhancedPlaythroughJadePlugin.ALLOY_FURNACE;
    }
}
