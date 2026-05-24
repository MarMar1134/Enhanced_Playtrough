package net.marmar.enhanced_playthrough.compat.jade;

import net.marmar.enhanced_playthrough.block.custom.epfurnace.entity.AbstractEPFurnaceBlockEntity;
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

public enum EPFurnaceComponentProvider implements IBlockComponentProvider, IServerDataProvider<BlockAccessor> {
        INSTANCE;

    @Override
    public void appendTooltip(ITooltip iTooltip, BlockAccessor blockAccessor, IPluginConfig iPluginConfig) {
        CompoundTag data = blockAccessor.getServerData();
        IElementHelper helper = IElementHelper.get();
        ListTag modFurnaceItems = data.getList("furnace_contents", Tag.TAG_COMPOUND);
        NonNullList<ItemStack> inventory = NonNullList.withSize(3, ItemStack.EMPTY);
        int progress = data.getInt("mod_furnace.progress");
        int maxProgress = data.getInt("mod_furnace.total");

        if (!data.contains("mod_furnace.progress")) {
            return;
        }

        for (int i = 0; i < inventory.size(); i++) {
            inventory.set(i, ItemStack.of(modFurnaceItems.getCompound(i)));
        }

        iTooltip.add(helper.item(inventory.get(0)));
        iTooltip.append(helper.item(inventory.get(1)));

        if (progress != 0) {
            iTooltip.append(new ProgressArrowElement((float) progress / maxProgress));
        }

        iTooltip.append(helper.item(inventory.get(2)));
    }

    @Override
    public ResourceLocation getUid() {
        return EnhancedPlaythroughJadePlugin.MOD_FURNACE;
    }

    @Override
    public void appendServerData(CompoundTag compoundTag, BlockAccessor blockAccessor) {
        AbstractEPFurnaceBlockEntity furnace = (AbstractEPFurnaceBlockEntity) blockAccessor.getBlockEntity();

        ListTag data = new ListTag();

        data.add(furnace.getInputHandler().getStackInSlot(0).serializeNBT());
        data.add(furnace.getFuelHandler().getStackInSlot(0).serializeNBT());
        data.add(furnace.getOutputHandler().getStackInSlot(0).serializeNBT());

        compoundTag.put("furnace_contents", data);

        compoundTag.putInt("mod_furnace.progress", furnace.getProgress());
        compoundTag.putInt("mod_furnace.total", furnace.getMaxProgress());
    }
}
