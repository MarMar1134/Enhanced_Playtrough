package net.marmar.enhanced_playthrough.compat.jade;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.block.alloyfurnace.AbstractAlloyFurnaceBlock;
import net.marmar.enhanced_playthrough.block.alloyfurnace.entity.AbstractAlloyFurnaceBlockEntity;
import net.marmar.enhanced_playthrough.block.modfurnace.AbstractModFurnaceBlock;
import net.marmar.enhanced_playthrough.block.modfurnace.entity.AbstractModFurnaceBlockEntity;
import net.marmar.enhanced_playthrough.block.gempolisher.GemPolisherBlock;
import net.marmar.enhanced_playthrough.block.gempolisher.GemPolisherBlockEntity;
import net.marmar.enhanced_playthrough.block.grinder.MechanicalGrinderBlock;
import net.marmar.enhanced_playthrough.block.grinder.PrimalGrinderBlock;
import net.marmar.enhanced_playthrough.block.grinder.entity.MechanicalGrinderBlockEntity;
import net.marmar.enhanced_playthrough.block.grinder.entity.PrimalGrinderBlockEntity;
import net.minecraft.resources.ResourceLocation;
import snownee.jade.api.IWailaClientRegistration;
import snownee.jade.api.IWailaCommonRegistration;
import snownee.jade.api.IWailaPlugin;
import snownee.jade.api.WailaPlugin;

@WailaPlugin
public class EnhancedPlaythroughJadePlugin implements IWailaPlugin {
    public static final ResourceLocation MOD_FURNACE = new ResourceLocation(EnhancedPlaythrough.MOD_ID, "basic_furnace");
    public static final ResourceLocation ALLOY_FURNACE = new ResourceLocation(EnhancedPlaythrough.MOD_ID, "alloy_furnace");
    public static final ResourceLocation GEM_POLISHER = new ResourceLocation(EnhancedPlaythrough.MOD_ID, "gem_polisher");
    public static final ResourceLocation GRINDER = new ResourceLocation(EnhancedPlaythrough.MOD_ID, "grinder");

    @Override
    public void register(IWailaCommonRegistration registration) {
        registration.registerBlockDataProvider(ModFurnaceComponentProvider.INSTANCE, AbstractModFurnaceBlockEntity.class);
        registration.registerBlockDataProvider(AlloyFurnaceComponentProvider.INSTANCE, AbstractAlloyFurnaceBlockEntity.class);
        registration.registerBlockDataProvider(GemPolisherComponentProvider.INSTANCE, GemPolisherBlockEntity.class);
        registration.registerBlockDataProvider(GrinderComponentProvider.INSTANCE, PrimalGrinderBlockEntity.class);
        registration.registerBlockDataProvider(MechanicalGrinderComponentProvider.INSTANCE, MechanicalGrinderBlockEntity.class);
    }

    @Override
    public void registerClient(IWailaClientRegistration registration) {
        registration.registerBlockComponent(ModFurnaceComponentProvider.INSTANCE, AbstractModFurnaceBlock.class);
        registration.registerBlockComponent(AlloyFurnaceComponentProvider.INSTANCE, AbstractAlloyFurnaceBlock.class);
        registration.registerBlockComponent(GemPolisherComponentProvider.INSTANCE, GemPolisherBlock.class);
        registration.registerBlockComponent(GrinderComponentProvider.INSTANCE, PrimalGrinderBlock.class);
        registration.registerBlockComponent(MechanicalGrinderComponentProvider.INSTANCE, MechanicalGrinderBlock.class);
    }
}
