package net.marmar.enhanced_playthrough.compat.jade;

import net.marmar.enhanced_playthrough.block.custom.alchemicalduplicator.AlchemicalDuplicatorBlockEntity;
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

public enum AlchemicalDuplicatorComponentProvider implements IBlockComponentProvider, IServerDataProvider<BlockAccessor> {
    INSTANCE;

    @Override
    public void appendTooltip(ITooltip iTooltip, BlockAccessor blockAccessor, IPluginConfig iPluginConfig) {
        CompoundTag blockData = blockAccessor.getServerData();
        IElementHelper GUIHelper = IElementHelper.get();

        ListTag blockItems = blockData.getList("alchemical_duplicator_contents", Tag.TAG_COMPOUND);
        NonNullList<ItemStack> blockInventory = NonNullList.withSize(7, ItemStack.EMPTY);

        int progress = blockData.getInt("alchemical_duplicator.progress");
        int maxProgress = blockData.getInt("alchemical_duplicator.maxProgress");

        if (!blockData.contains("alchemical_duplicator.progress")){
            return;
        }

        for (int i = 0; i < blockInventory.size(); i++) {
            blockInventory.set(i, ItemStack.of(blockItems.getCompound(i)));
        }

        iTooltip.add(GUIHelper.item(blockInventory.get(0)));
        iTooltip.append(GUIHelper.item(blockInventory.get(1)));
        iTooltip.append(GUIHelper.item(blockInventory.get(2)));
        iTooltip.append(new ProgressArrowElement((float) progress / maxProgress));
        iTooltip.append(GUIHelper.item(blockInventory.get(3)));
        iTooltip.append(GUIHelper.item(blockInventory.get(4)));
        iTooltip.append(GUIHelper.item(blockInventory.get(5)));
        iTooltip.append(GUIHelper.item(blockInventory.get(6)));
    }

    @Override
    public void appendServerData(CompoundTag compoundTag, BlockAccessor blockAccessor) {
        AlchemicalDuplicatorBlockEntity alchemicalDuplicator = (AlchemicalDuplicatorBlockEntity) blockAccessor.getBlockEntity();
        ListTag blockData = new ListTag();

        blockData.add(alchemicalDuplicator.getSulfurSlotHandler().getStackInSlot(0).serializeNBT());
        blockData.add(alchemicalDuplicator.getBookSlotHandler().getStackInSlot(0).serializeNBT());
        blockData.add(alchemicalDuplicator.getInputSlotHandler().getStackInSlot(0).serializeNBT());

        blockData.add(alchemicalDuplicator.getOutputSlotHandler().getStackInSlot(0).serializeNBT());
        blockData.add(alchemicalDuplicator.getOutputSlotHandler().getStackInSlot(1).serializeNBT());
        blockData.add(alchemicalDuplicator.getOutputSlotHandler().getStackInSlot(2).serializeNBT());
        blockData.add(alchemicalDuplicator.getOutputSlotHandler().getStackInSlot(3).serializeNBT());

        compoundTag.put("alchemical_duplicator_contents", blockData);
        compoundTag.putInt("alchemical_duplicator.progress", alchemicalDuplicator.getProgress());
        compoundTag.putInt("alchemical_duplicator.maxProgress", alchemicalDuplicator.getMaxProgress());
    }

    @Override
    public ResourceLocation getUid() {
        return EnhancedPlaythroughJadePlugin.ALCHEMICAL_DUPLICATOR;
    }
}
