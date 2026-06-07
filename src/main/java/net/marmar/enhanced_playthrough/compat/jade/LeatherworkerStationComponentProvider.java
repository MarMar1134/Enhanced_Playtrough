package net.marmar.enhanced_playthrough.compat.jade;

import net.marmar.enhanced_playthrough.block.custom.leatherworker.LeatherworkerStationBlockEntity;
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

public enum LeatherworkerStationComponentProvider implements IBlockComponentProvider, IServerDataProvider<BlockAccessor> {
    INSTANCE;

    @Override
    public void appendTooltip(ITooltip iTooltip, BlockAccessor blockAccessor, IPluginConfig iPluginConfig) {
        CompoundTag blockData = blockAccessor.getServerData();
        IElementHelper GUIHelper = IElementHelper.get();

        ListTag blockItems = blockData.getList("leatherworker_station.contents", Tag.TAG_COMPOUND);
        NonNullList<ItemStack> blockInventory = NonNullList.withSize(4, ItemStack.EMPTY);

        int progress = blockData.getInt("leatherworker_station.progress");
        int maxProgress = blockData.getInt("leatherworker_station.maxProgress");


        if (!blockData.contains("leatherworker_station.progress")){
            return;
        }

        for (int i = 0; i < blockInventory.size(); i++) {
            blockInventory.set(i, ItemStack.of(blockItems.getCompound(i)));
        }

        iTooltip.add(GUIHelper.item(blockInventory.get(0)));
        iTooltip.append(GUIHelper.item(blockInventory.get(1)));

        if (progress != 0) {
            iTooltip.append(new ProgressArrowElement((float) progress / maxProgress));
        }

        iTooltip.append(GUIHelper.item(blockInventory.get(2)));
    }

    @Override
    public void appendServerData(CompoundTag compoundTag, BlockAccessor blockAccessor) {
        LeatherworkerStationBlockEntity leatherworkerStation = (LeatherworkerStationBlockEntity) blockAccessor.getBlockEntity();
        ListTag blockData = new ListTag();

        blockData.add(leatherworkerStation.getLimeHandler().getStackInSlot(0).serializeNBT());
        blockData.add(leatherworkerStation.getSkinHandler().getStackInSlot(0).serializeNBT());
        blockData.add(leatherworkerStation.getLeatherHandler().getStackInSlot(0).serializeNBT());

        compoundTag.put("leatherworker_station.contents", blockData);
        compoundTag.putInt("leatherworker_station.progress", leatherworkerStation.getProgress());
        compoundTag.putInt("leatherworker_station.maxProgress", leatherworkerStation.getMaxProgress());
    }

    @Override
    public ResourceLocation getUid() {
        return EnhancedPlaythroughJadePlugin.LEATHERWORKER_STATION;
    }
}
