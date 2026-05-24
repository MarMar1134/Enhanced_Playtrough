package net.marmar.enhanced_playthrough.compat.jade;

import net.marmar.enhanced_playthrough.block.custom.grinder.entity.PrimalGrinderBlockEntity;
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

public enum GrinderComponentProvider implements IBlockComponentProvider, IServerDataProvider<BlockAccessor> {
    INSTANCE;

    @Override
    public void appendTooltip(ITooltip iTooltip, BlockAccessor blockAccessor, IPluginConfig iPluginConfig) {
        CompoundTag blockData = blockAccessor.getServerData();
        IElementHelper GUIHelper = IElementHelper.get();

        ListTag blockItems = blockData.getList("grinder_contents", Tag.TAG_COMPOUND);
        NonNullList<ItemStack> blockInventory = NonNullList.withSize(3, ItemStack.EMPTY);

        int grindProgress = blockData.getInt("grinder.progress");
        int maxGrindProgress = blockData.getInt("grinder.maxProgress");

        if (!blockData.contains("grinder.progress")){
            return;
        }

        for (int i = 0; i < blockInventory.size(); i++) {
            blockInventory.set(i, ItemStack.of(blockItems.getCompound(i)));
        }

        iTooltip.add(GUIHelper.item(blockInventory.get(0)));
        iTooltip.append(GUIHelper.item(blockInventory.get(1)));

        if (grindProgress != 0) {
            iTooltip.append(new ProgressArrowElement((float) grindProgress / maxGrindProgress));
        }

        iTooltip.append(GUIHelper.item(blockInventory.get(2)));
    }

    @Override
    public void appendServerData(CompoundTag compoundTag, BlockAccessor blockAccessor) {
        PrimalGrinderBlockEntity blockEntity = (PrimalGrinderBlockEntity) blockAccessor.getBlockEntity();
        ListTag blockData = new ListTag();

        blockData.add(blockEntity.getInputHandler().getStackInSlot(0).serializeNBT());
        blockData.add(blockEntity.getFuelHandler().getStackInSlot(0).serializeNBT());
        blockData.add(blockEntity.getOutputHandler().getStackInSlot(0).serializeNBT());

        compoundTag.put("grinder_contents", blockData);
        compoundTag.putInt("grinder.progress", blockEntity.getProgress());
        compoundTag.putInt("grinder.maxProgress", blockEntity.getMaxProgress());
    }

    @Override
    public ResourceLocation getUid() {
        return EnhancedPlaythroughJadePlugin.GRINDER;
    }
}
