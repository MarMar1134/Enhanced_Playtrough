package net.marmar.enhanced_playthrough.compat.jade;

import net.marmar.enhanced_playthrough.block.custom.grinder.entity.MechanicalGrinderBlockEntity;
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

public enum MechanicalGrinderComponentProvider implements IBlockComponentProvider, IServerDataProvider<BlockAccessor> {
    INSTANCE;

    @Override
    public void appendTooltip(ITooltip iTooltip, BlockAccessor blockAccessor, IPluginConfig iPluginConfig) {
        CompoundTag blockData = blockAccessor.getServerData();
        IElementHelper GUIHelper = IElementHelper.get();

        ListTag blockItems = blockData.getList("mechanical_grinder_contents", Tag.TAG_COMPOUND);
        NonNullList<ItemStack> blockInventory = NonNullList.withSize(2, ItemStack.EMPTY);

        int grindProgress = blockData.getInt("mechanical_grinder.progress");
        int maxGrindProgress = blockData.getInt("mechanical_grinder.maxProgress");

        if (!blockData.contains("mechanical_grinder.progress")){
            return;
        }

        for (int i = 0; i < blockInventory.size(); i++) {
            blockInventory.set(i, ItemStack.of(blockItems.getCompound(i)));
        }

        iTooltip.add(GUIHelper.item(blockInventory.get(0)));

        if (grindProgress != 0) {
            iTooltip.append(new ProgressArrowElement((float) grindProgress / maxGrindProgress));
        }

        iTooltip.append(GUIHelper.item(blockInventory.get(1)));
    }

    @Override
    public void appendServerData(CompoundTag compoundTag, BlockAccessor blockAccessor) {
        MechanicalGrinderBlockEntity blockEntity = (MechanicalGrinderBlockEntity) blockAccessor.getBlockEntity();
        ListTag blockData = new ListTag();

        blockData.add(blockEntity.getInputHandler().getStackInSlot(0).serializeNBT());
        blockData.add(blockEntity.getOutputHandler().getStackInSlot(0).serializeNBT());

        compoundTag.put("mechanical_grinder_contents", blockData);
        compoundTag.putInt("mechanical_grinder.progress", blockEntity.getProgress());
        compoundTag.putInt("mechanical_grinder.maxProgress", blockEntity.getMaxProgress());
    }

    @Override
    public ResourceLocation getUid() {
        return EnhancedPlaythroughJadePlugin.GRINDER;
    }
}
