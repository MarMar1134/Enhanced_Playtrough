package net.marmar.enhanced_playthrough.menu;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.menu.alchemicalduplicator.AlchemicalDuplicatorMenu;
import net.marmar.enhanced_playthrough.menu.alloyfurnace.AdobeAlloyFurnaceMenu;
import net.marmar.enhanced_playthrough.menu.alloyfurnace.PrimitiveAlloyFurnaceMenu;
import net.marmar.enhanced_playthrough.menu.alloyfurnace.SuperAlloyFurnaceMenu;
import net.marmar.enhanced_playthrough.menu.epfurnace.AdobeFurnaceMenu;
import net.marmar.enhanced_playthrough.menu.epfurnace.SoulFurnaceMenu;
import net.marmar.enhanced_playthrough.menu.gempolisher.GemPolisherMenu;
import net.marmar.enhanced_playthrough.menu.grinder.MechanicalGrinderMenu;
import net.marmar.enhanced_playthrough.menu.grinder.PrimalGrinderMenu;
import net.marmar.enhanced_playthrough.menu.epfurnace.MasonryFurnaceMenu;
import net.marmar.enhanced_playthrough.menu.leatherworker.LeatherworkerStationMenu;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EPMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(ForgeRegistries.MENU_TYPES, EnhancedPlaythrough.MOD_ID);

    //Furnaces
    public static final RegistryObject<MenuType<AdobeFurnaceMenu>> ADOBE_FURNACE_MENU =
            registerMenuType("adobe_furnace_menu", AdobeFurnaceMenu::new);
    public static final RegistryObject<MenuType<SoulFurnaceMenu>> SOUL_FURNACE_MENU =
            registerMenuType("soul_furnace_menu", SoulFurnaceMenu::new);
    public static final RegistryObject<MenuType<MasonryFurnaceMenu>> MASONRY_FURNACE_MENU =
            registerMenuType("masonry_furnace_menu", MasonryFurnaceMenu::new);

    //Alloy furnaces
    public static final RegistryObject<MenuType<PrimitiveAlloyFurnaceMenu>> PRIMITIVE_ALLOY_FURNACE_MENU =
            registerMenuType("primitive_alloy_furnace_menu", PrimitiveAlloyFurnaceMenu::new);
    public static final RegistryObject<MenuType<AdobeAlloyFurnaceMenu>> ADOBE_ALLOY_FURNACE_MENU =
            registerMenuType("adobe_alloy_furnace_menu", AdobeAlloyFurnaceMenu::new);
    public static final RegistryObject<MenuType<SuperAlloyFurnaceMenu>> SUPER_ALLOY_FURNACE_MENU =
            registerMenuType("super_alloy_furnace_menu", SuperAlloyFurnaceMenu::new);

    //Gem polisher
    public static final RegistryObject<MenuType<GemPolisherMenu>> GEM_POLISHER_MENU =
            registerMenuType("gem_polisher_menu", GemPolisherMenu::new);

    //Grinders
    public static final RegistryObject<MenuType<PrimalGrinderMenu>> PRIMAL_GRINDER_MENU =
            registerMenuType("primal_grinder_menu", PrimalGrinderMenu::new);
    public static final RegistryObject<MenuType<MechanicalGrinderMenu>> MECHANICAL_GRINDER_MENU =
            registerMenuType("mechanical_grinder_menu", MechanicalGrinderMenu::new);

    //Alchemical duplicator
    public static final RegistryObject<MenuType<AlchemicalDuplicatorMenu>> ALCHEMICAL_DUPLICATOR_MENU =
            registerMenuType("alchemical_duplicator_menu", AlchemicalDuplicatorMenu::new);

    //Leatherwork station
    public static final RegistryObject<MenuType<LeatherworkerStationMenu>> LEATHERWORKER_STATION_MENU =
            registerMenuType("leatherworker_station_menu", LeatherworkerStationMenu::new);

    //Register methods
    private static <T extends AbstractContainerMenu> RegistryObject<MenuType<T>> registerMenuType(String name, IContainerFactory<T> factory) {
        return MENUS.register(name, () -> IForgeMenuType.create(factory));
    }

    public static void register(IEventBus eventBus){
        EnhancedPlaythrough.LOGGER.info("Registering Enhanced Playthrough menus...");
        MENUS.register(eventBus);
    }
}
