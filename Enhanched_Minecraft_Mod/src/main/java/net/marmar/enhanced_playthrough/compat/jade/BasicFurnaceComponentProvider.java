package net.marmar.enhanced_playthrough.compat.jade;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.block.custom.basicfurnace.entity.AbstractBasicFurnaceBlockEntity;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import snownee.jade.api.BlockAccessor;
import snownee.jade.api.IBlockComponentProvider;
import snownee.jade.api.IServerDataProvider;
import snownee.jade.api.ITooltip;
import snownee.jade.api.config.IPluginConfig;
import snownee.jade.api.ui.IElementHelper;
import snownee.jade.impl.ui.ProgressArrowElement;

public enum BasicFurnaceComponentProvider implements IBlockComponentProvider, IServerDataProvider<BlockAccessor> {
        INSTANCE;

    @Override
    public void appendTooltip(ITooltip iTooltip, BlockAccessor blockAccessor, IPluginConfig iPluginConfig) {
        CompoundTag data = blockAccessor.getServerData();
        IElementHelper helper = IElementHelper.get();
        ListTag basicFurnaceItems = data.getList("furnace_contents", Tag.TAG_COMPOUND);
        NonNullList<ItemStack> inventory = NonNullList.withSize(3, ItemStack.EMPTY);
        int progress = data.getInt("basic_furnace.progress");
        int total = data.getInt("basic_furnace.total");

        if (!data.contains("basic_furnace.progress")) {
            return;
        }

        for (int i = 0; i < inventory.size(); i++) {
            inventory.set(i, ItemStack.of(basicFurnaceItems.getCompound(i)));
        }

        iTooltip.add(helper.item(inventory.get(0)));
        iTooltip.append(helper.item(inventory.get(1)));
        iTooltip.append(new ProgressArrowElement((float) progress / total));
        iTooltip.append(helper.item(inventory.get(2)));
    }

    @Override
    public ResourceLocation getUid() {
        return EnhancedPlaythroughJadePlugin.BASIC_FURNACE;
    }

    @Override
    public void appendServerData(CompoundTag compoundTag, BlockAccessor blockAccessor) {
        AbstractBasicFurnaceBlockEntity furnace = (AbstractBasicFurnaceBlockEntity) blockAccessor.getBlockEntity();

        ListTag data = new ListTag();

        data.add(furnace.getInputHandler().getStackInSlot(0).serializeNBT());
        data.add(furnace.getFuelHandler().getStackInSlot(0).serializeNBT());
        data.add(furnace.getOutputHandler().getStackInSlot(0).serializeNBT());

        compoundTag.put("furnace_contents", data);

        compoundTag.putInt("basic_furnace.progress", furnace.getProgress());
        compoundTag.putInt("basic_furnace.total", furnace.getMaxProgress());
    }
}
