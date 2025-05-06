package net.marmar.enhanced_playthrough.block.custom.wood;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

public class ModWoodTypes {
    public static final WoodType WALNUT = WoodType.register(new WoodType(EnhancedPlaythrough.MOD_ID + ":walnut", BlockSetType.SPRUCE));
    public static final WoodType APPLE = WoodType.register(new WoodType(EnhancedPlaythrough.MOD_ID + ":apple", BlockSetType.OAK));
    public static final WoodType ORANGE = WoodType.register(new WoodType(EnhancedPlaythrough.MOD_ID + "orange", BlockSetType.BIRCH));
    public static final WoodType LEMON = WoodType.register(new WoodType(EnhancedPlaythrough.MOD_ID + ":lemon", BlockSetType.BIRCH));
}
