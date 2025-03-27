package net.marmar.enhanced_playthrough.compat.jade;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.block.custom.gempolisher.entity.GemPolisherBlockEntity;
import net.minecraft.ChatFormatting;
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

public enum GemPolisherComponentProvider implements IBlockComponentProvider, IServerDataProvider<BlockAccessor> {
    INSTANCE;

    @Override
    public void appendTooltip(ITooltip iTooltip, BlockAccessor blockAccessor, IPluginConfig iPluginConfig) {
        CompoundTag blockData = blockAccessor.getServerData();
        IElementHelper GUIHelper = IElementHelper.get();

        ListTag blockItems = blockData.getList("gem_polisher_contents", Tag.TAG_COMPOUND);
        NonNullList<ItemStack> blockInventory = NonNullList.withSize(3, ItemStack.EMPTY);

        int polishProgress = blockData.getInt("gem_polisher.progress");
        int maxPolishProgress = blockData.getInt("gem_polisher.maxProgress");
        int uses = blockAccessor.getServerData().getInt("gem_polisher.uses");

        if (!blockData.contains("gem_polisher.progress")){
            return;
        } else {
            for (int i = 0; i < blockInventory.size(); i++) {
                blockInventory.set(i, ItemStack.of(blockItems.getCompound(i)));
            }

            iTooltip.add(GUIHelper.item(blockInventory.get(0)));
            iTooltip.append(GUIHelper.item(blockInventory.get(1)));
            iTooltip.append(new ProgressArrowElement((float) polishProgress / maxPolishProgress));
            iTooltip.append(GUIHelper.item(blockInventory.get(2)));
        }

        if (uses != 0) {
            iTooltip.add(Component.translatable("jade." + EnhancedPlaythrough.MOD_ID + ".gem_polisher_uses",
                    uses).withStyle(ChatFormatting.ITALIC));
        }
    }

    @Override
    public void appendServerData(CompoundTag compoundTag, BlockAccessor blockAccessor) {
        GemPolisherBlockEntity blockEntity = (GemPolisherBlockEntity) blockAccessor.getBlockEntity();
        ListTag blockData = new ListTag();

        blockData.add(blockEntity.getToolHandler().getStackInSlot(0).serializeNBT());
        blockData.add(blockEntity.getInputHandler().getStackInSlot(0).serializeNBT());
        blockData.add(blockEntity.getOutputHandler().getStackInSlot(0).serializeNBT());

        compoundTag.put("gem_polisher_contents", blockData);
        compoundTag.putInt("gem_polisher.progress", blockEntity.getProgress());
        compoundTag.putInt("gem_polisher.maxProgress", blockEntity.getMaxProgress());
        compoundTag.putInt("gem_polisher.uses", blockEntity.getUses());


    }

    @Override
    public ResourceLocation getUid() {
        return EnhancedPlaythroughJadePlugin.GEM_POLISHER;
    }
}
