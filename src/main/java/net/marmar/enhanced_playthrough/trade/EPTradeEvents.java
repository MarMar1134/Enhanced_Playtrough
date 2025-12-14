package net.marmar.enhanced_playthrough.trade;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.block.EPBlocks;
import net.marmar.enhanced_playthrough.util.enchantment.EPEnchantments;
import net.marmar.enhanced_playthrough.item.EPItems;
import net.marmar.enhanced_playthrough.entity.villager.EPVillagerProfessions;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = EnhancedPlaythrough.MOD_ID)
public class EPTradeEvents implements ITradeOffers {
    @SubscribeEvent
    public static void subscribeTrades(VillagerTradesEvent event){
        //Farmer
        if (event.getType() == VillagerProfession.FARMER){
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades =event.getTrades();

            trades.get(5).removeAll(trades.get(5));

            //Level 2
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(EPItems.TOMATO.get(), 15),
                    new ItemStack(Items.EMERALD, 1),
                    16, 2, 0.02f));
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(EPItems.ZAPALLO.get(), 10),
                    new ItemStack(Items.EMERALD, 1),
                    16, 2, 0.02f));
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(EPItems.EGGPLANT.get(), 16),
                    new ItemStack(Items.EMERALD, 1),
                    16, 2, 0.02f));
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(EPItems.CORN.get(), 20),
                    new ItemStack(Items.EMERALD, 1),
                    16, 2, 0.02f));

            //Level 5
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(EPItems.RUBY.get(), 15),
                    new ItemStack(Items.EMERALD, 1),
                    16, 2, 0.02f));
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(EPItems.TOMATO.get(), 15),
                    new ItemStack(Items.EMERALD, 1),
                    16, 2, 0.02f));
        }

        //Armorer
        if (event.getType() == VillagerProfession.ARMORER){
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades =event.getTrades();

            trades.get(1).removeAll(trades.get(1));
            trades.get(2).removeAll(trades.get(2));
            trades.get(3).removeAll(trades.get(3));
            trades.get(4).removeAll(trades.get(4));
            trades.get(5).removeAll(trades.get(5));

            //Level 1
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.COAL, 15),
                    new ItemStack(Items.EMERALD, 1),
                    12, 2, 0.05f));

                //Bronze
                trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                        new ItemStack(EPItems.BRONZE_INGOT.get(), 4),
                        new ItemStack(Items.EMERALD, 1),
                        12, 2, 0.05f));
                trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 5),
                        new ItemStack(EPItems.BRONZE_HELMET.get(), 1),
                        12, 1, 0.2f));
                trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 9),
                        new ItemStack(EPItems.BRONZE_CHESTPLATE.get(), 1),
                        12, 1, 0.2f));
                trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 7),
                        new ItemStack(EPItems.BRONZE_LEGGINGS.get(), 1),
                        12, 1, 0.2f));
                trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 4),
                        new ItemStack(EPItems.BRONZE_BOOTS.get(), 1),
                        12, 1, 0.2f));

                //Brass
                trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                        new ItemStack(EPItems.BRASS_INGOT.get(), 4),
                        new ItemStack(Items.EMERALD, 1),
                        12, 2, 0.05f));
                trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 5),
                        new ItemStack(EPItems.BRASS_HELMET.get(), 1),
                        12, 1, 0.2f));
                trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 9),
                        new ItemStack(EPItems.BRASS_CHESTPLATE.get(), 1),
                        12, 1, 0.2f));
                trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 7),
                        new ItemStack(EPItems.BRASS_LEGGINGS.get(), 1),
                        12, 1, 0.2f));
                trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 4),
                        new ItemStack(EPItems.BRASS_BOOTS.get(), 1),
                        12, 1, 0.2f));

            //Level 2
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.IRON_INGOT, 4),
                    new ItemStack(Items.EMERALD, 1),
                    12, 10, 0.05f));
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 6),
                    new ItemStack(EPItems.SAPPHIRE.get(), 6),
                    new ItemStack(Items.BELL, 1),
                    12, 5, 0.2f));

                //Iron
                trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 2),
                        new ItemStack(EPItems.SAPPHIRE.get(), 1),
                        new ItemStack(Items.IRON_HELMET, 1),
                        12, 5, 0.2f));
                trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 4),
                        new ItemStack(EPItems.SAPPHIRE.get(), 1),
                        new ItemStack(Items.IRON_CHESTPLATE, 1),
                        12, 5, 0.2f));
                trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 3),
                        new ItemStack(EPItems.SAPPHIRE.get(), 1),
                        new ItemStack(Items.IRON_LEGGINGS, 1),
                        12, 5, 0.2f));
                trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 1),
                        new ItemStack(EPItems.SAPPHIRE.get(), 1),
                        new ItemStack(Items.IRON_BOOTS, 1),
                        12, 5, 0.2f));

            //Level 3
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(EPItems.STEEL_INGOT.get(), 4),
                    new ItemStack(EPItems.SAPPHIRE.get(), 1),
                    12, 20, 0.2f));
                //Chainmail
                trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                        new ItemStack(EPItems.SAPPHIRE.get(), 3),
                        new ItemStack(Items.CHAINMAIL_LEGGINGS, 1),
                        6, 10, 0.2f));
                trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                        new ItemStack(EPItems.SAPPHIRE.get(), 1),
                        new ItemStack(Items.CHAINMAIL_BOOTS, 1),
                        6, 10, 0.2f));
                //Steel
                trades.get(3).add((pTrader, pRandom) -> ITradeOffers.EnchantedItemOffer(
                        pRandom, EPItems.SAPPHIRE.get(), 7,
                        EPItems.STEEL_LEGGINGS.get(), 6, 10));
                trades.get(3).add((pTrader, pRandom) -> ITradeOffers.EnchantedItemOffer(
                        pRandom, EPItems.SAPPHIRE.get(), 4,
                        EPItems.STEEL_BOOTS.get(), 6, 10));

            //Level 4
            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(EPItems.GREEN_GOLD_INGOT.get(), 4),
                    new ItemStack(EPItems.RUBY.get(), 1),
                    12, 20, 0.05f));
            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(EPItems.ALUMINUM_INGOT.get(), 4),
                    new ItemStack(EPItems.SAPPHIRE.get(), 1),
                    12, 15, 0.02f));
            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(EPItems.SAPPHIRE.get(), Mth.nextInt(pRandom, 3, 6)),
                    new ItemStack(EPItems.ALUMINUM_ROD.get(), 4),
                    12, 15, 0.02f));

                //Chainmail
                trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                        new ItemStack(EPItems.SAPPHIRE.get(), 4),
                        new ItemStack(Items.CHAINMAIL_CHESTPLATE, 1),
                        6, 15, 0.2f));
                trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                        new ItemStack(EPItems.SAPPHIRE.get(), 1),
                        new ItemStack(Items.CHAINMAIL_HELMET, 1),
                        6, 15, 0.2f));
                //Steel
                trades.get(4).add((pTrader, pRandom) -> ITradeOffers.EnchantedItemOffer(
                        pRandom, EPItems.SAPPHIRE.get(), 4,
                        EPItems.RUBY.get(), 1,
                        EPItems.STEEL_CHESTPLATE.get(), 6, 15));
                trades.get(4).add((pTrader, pRandom) -> ITradeOffers.EnchantedItemOffer(
                        pRandom, EPItems.SAPPHIRE.get(), 5,
                        EPItems.STEEL_HELMET.get(), 6, 15));

            //Level 5
            trades.get(5).add((pTrader, pRandom) -> ITradeOffers.EnchantedItemOffer(
                    pRandom, EPItems.RUBY.get(), 7,
                    Items.DIAMOND_LEGGINGS, 3, 30));
            trades.get(5).add((pTrader, pRandom) -> ITradeOffers.EnchantedItemOffer(
                    pRandom, EPItems.RUBY.get(), 4,
                    Items.DIAMOND_BOOTS, 3, 30));
            trades.get(5).add((pTrader, pRandom) -> ITradeOffers.EnchantedItemOffer(
                    pRandom, EPItems.RUBY.get(), 5,
                    Items.DIAMOND_HELMET, 3, 30));
            trades.get(5).add((pTrader, pRandom) -> ITradeOffers.EnchantedItemOffer(
                    pRandom, EPItems.RUBY.get(), 9,
                    Items.DIAMOND_CHESTPLATE, 3, 30));
        }

        //Toolsmith
        if(event.getType() == VillagerProfession.TOOLSMITH){
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades =event.getTrades();

            trades.get(1).removeAll(trades.get(1));
            trades.get(2).removeAll(trades.get(2));
            trades.get(3).removeAll(trades.get(3));
            trades.get(4).removeAll(trades.get(4));
            trades.get(5).removeAll(trades.get(5));

            //Level 1
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.COAL, 15),
                    new ItemStack(Items.EMERALD, 1),
                    12, 2, 0.05f));
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(EPItems.COBBLE.get(), 10),
                    new ItemStack(Items.EMERALD, 1),
                    12, 2, 0.05f));
                //Stone
                trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 1),
                        new ItemStack(EPItems.COBBLE.get(), 2),
                        new ItemStack(Items.STONE_PICKAXE, 1),
                        12, 1, 0.2f));
                trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 1),
                        new ItemStack(EPItems.COBBLE.get(), 1),
                        new ItemStack(Items.STONE_AXE, 1),
                        12, 1, 0.2f));
                trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 1),
                        new ItemStack(EPItems.COBBLE.get(), 1),
                        new ItemStack(Items.STONE_SHOVEL, 1),
                        12, 1, 0.2f));
                trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 1),
                        new ItemStack(EPItems.COBBLE.get(), 1),
                        new ItemStack(Items.STONE_HOE, 1),
                        12, 1, 0.2f));

            //Level 2
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(EPItems.BRONZE_INGOT.get(), 6),
                    new ItemStack(EPItems.SAPPHIRE.get(), 1),
                    12, 10, 0.02f));
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(EPItems.BRASS_INGOT.get(), 4),
                    new ItemStack(Items.EMERALD, 1),
                    12, 10, 0.02f));
                //Brass
                trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 1),
                        new ItemStack(EPItems.BRASS_AXE.get(), 1),
                        6, 5, 0.2f));
                trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 1),
                        new ItemStack(EPItems.BRASS_PICKAXE.get(), 1),
                        6, 5, 0.2f));
                trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 1),
                        new ItemStack(EPItems.BRASS_SHOVEL.get(), 1),
                        6, 5, 0.2f));
                trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 1),
                        new ItemStack(EPItems.BRASS_HOE.get(), 1),
                        6, 5, 0.2f));
                //Bronze
                trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 1),
                        new ItemStack(EPItems.SAPPHIRE.get(), 1),
                        new ItemStack(EPItems.BRONZE_AXE.get(), 1),
                        6, 5, 0.2f));
                trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 1),
                        new ItemStack(EPItems.SAPPHIRE.get(), 1),
                        new ItemStack(EPItems.BRONZE_PICKAXE.get(), 1),
                        6, 5, 0.2f));
                trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 1),
                        new ItemStack(EPItems.SAPPHIRE.get(), 1),
                        new ItemStack(EPItems.BRONZE_SHOVEL.get(), 1),
                        6, 5, 0.2f));
                trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 1),
                        new ItemStack(EPItems.SAPPHIRE.get(), 1),
                        new ItemStack(EPItems.BRONZE_HOE.get(), 1),
                        6, 5, 0.2f));

            //Level 3
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.FLINT, 30),
                    new ItemStack(Items.EMERALD, 1),
                    12, 20, 0.02f));
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.IRON_INGOT, 4),
                    new ItemStack(EPItems.SAPPHIRE.get(), 1),
                    12, 20, 0.02f));
                //Iron
                trades.get(3).add((pTrader, pRandom) -> ITradeOffers.EnchantedItemOffer(
                        pRandom, EPItems.SAPPHIRE.get(), 2,
                        Items.IRON_AXE, 6, 10));
                trades.get(3).add((pTrader, pRandom) -> ITradeOffers.EnchantedItemOffer(
                        pRandom, EPItems.SAPPHIRE.get(), 3,
                        Items.IRON_PICKAXE, 6, 10));
                trades.get(3).add((pTrader, pRandom) -> ITradeOffers.EnchantedItemOffer(
                        pRandom, EPItems.SAPPHIRE.get(), 1,
                        Items.IRON_SHOVEL, 6, 10));
                trades.get(3).add((pTrader, pRandom) -> ITradeOffers.EnchantedItemOffer(
                        pRandom, EPItems.SAPPHIRE.get(), 1,
                        Items.IRON_HOE, 6, 10));


            //Level 4
            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(EPItems.STEEL_INGOT.get(), 4),
                    new ItemStack(EPItems.SAPPHIRE.get(), 1),
                    12, 15, 0.02f));
            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(EPItems.ALUMINUM_INGOT.get(), 4),
                    new ItemStack(EPItems.SAPPHIRE.get(), 1),
                    12, 15, 0.02f));
            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(EPItems.SAPPHIRE.get(), Mth.nextInt(pRandom, 3, 6)),
                    new ItemStack(EPItems.ALUMINUM_ROD.get(), 4),
                    12, 15, 0.02f));
                //Steel
                trades.get(4).add((pTrader, pRandom) -> ITradeOffers.EnchantedItemOffer(pRandom,
                        EPItems.SAPPHIRE.get(), 3,
                        EPItems.STEEL_AXE.get(), 6, 10));
                trades.get(4).add((pTrader, pRandom) -> ITradeOffers.EnchantedItemOffer(pRandom,
                        EPItems.SAPPHIRE.get(), 4,
                        EPItems.STEEL_PICKAXE.get(), 6, 10));
                trades.get(4).add((pTrader, pRandom) -> ITradeOffers.EnchantedItemOffer(pRandom,
                        EPItems.SAPPHIRE.get(), 2,
                        EPItems.STEEL_SHOVEL.get(), 6, 10));
                trades.get(4).add((pTrader, pRandom) -> ITradeOffers.EnchantedItemOffer(pRandom,
                        EPItems.SAPPHIRE.get(), 2,
                        EPItems.STEEL_HOE.get(), 6, 10));

            //Level 5
            trades.get(5).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(EPItems.GREEN_GOLD_INGOT.get(), 4),
                    new ItemStack(EPItems.RUBY.get(), 1),
                    12, 20, 0.05f));
                //Diamond
                trades.get(5).add((pTrader, pRandom) -> ITradeOffers.EnchantedItemOffer(pRandom,
                        EPItems.RUBY.get(), 3,
                        Items.DIAMOND_AXE, 3, 15));
                trades.get(5).add((pTrader, pRandom) -> ITradeOffers.EnchantedItemOffer(pRandom,
                        EPItems.RUBY.get(), 4,
                        Items.DIAMOND_PICKAXE, 3, 15));
                trades.get(5).add((pTrader, pRandom) -> ITradeOffers.EnchantedItemOffer(pRandom,
                        EPItems.RUBY.get(), 2,
                        Items.DIAMOND_SHOVEL, 3, 15));
                trades.get(5).add((pTrader, pRandom) -> ITradeOffers.EnchantedItemOffer(pRandom,
                        EPItems.RUBY.get(), 2,
                        Items.DIAMOND_HOE, 3, 15));
        }

        //Weaponsmith
        if (event.getType() == VillagerProfession.WEAPONSMITH){
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades =event.getTrades();

            trades.get(1).removeAll(trades.get(1));
            trades.get(2).removeAll(trades.get(2));
            trades.get(3).removeAll(trades.get(3));
            trades.get(4).removeAll(trades.get(4));
            trades.get(5).removeAll(trades.get(5));

            //Level 1
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.COAL, 15),
                    new ItemStack(Items.EMERALD, 1),
                    16, 2, 0.05f));
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(EPItems.COBBLE.get(), 10),
                    new ItemStack(Items.EMERALD, 1),
                    16, 2, 0.05f));
                //Stone
                trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 1),
                        new ItemStack(EPItems.COBBLE.get(), 2),
                        new ItemStack(Items.STONE_AXE, 1),
                        12, 1, 0.2f));
                trades.get(1).add((pTrader, pRandom) -> ITradeOffers.EnchantedItemOffer(
                        pRandom, Items.EMERALD, 1,
                        EPItems.COBBLE.get(), 1,
                        Items.STONE_SWORD, 3, 1));
                //Brass
                trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 3),
                        new ItemStack(EPItems.BRASS_AXE.get(), 1),
                        12, 1, 0.2f));
                trades.get(1).add((pTrader, pRandom) -> ITradeOffers.EnchantedItemOffer(
                        pRandom, Items.EMERALD, 2,
                        EPItems.BRASS_SWORD.get(), 3, 1));

            //Level 2
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(EPItems.BRONZE_INGOT.get(), 4),
                    new ItemStack(Items.EMERALD, 1),
                    12, 10, 0.05f));
                //Bronze
                trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 5),
                        new ItemStack(EPItems.BRONZE_AXE.get(), 1),
                        12, 1, 0.2f));
                trades.get(2).add((pTrader, pRandom) -> ITradeOffers.EnchantedItemOffer(
                        pRandom, Items.EMERALD, 3,
                        EPItems.BRONZE_SWORD.get(), 3, 1));


            //Level 3
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.IRON_INGOT, 4),
                    new ItemStack(EPItems.SAPPHIRE.get(), 1),
                    12, 15, 0.05f));
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(EPItems.SAPPHIRE.get(), 4),
                    new ItemStack(Items.IRON_AXE, 1),
                    6, 5, 0.2f));
            trades.get(3).add((pTrader, pRandom) -> ITradeOffers.EnchantedItemOffer(
                    pRandom, EPItems.SAPPHIRE.get(), 1,
                    Items.IRON_SWORD, 3, 5));

            //Level 4
            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(EPItems.STEEL_INGOT.get(), 4),
                    new ItemStack(EPItems.SAPPHIRE.get(), 1),
                    12, 15, 0.05f));
            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(EPItems.DEEPSLATE_COBBLE.get(), 10),
                    new ItemStack(EPItems.SAPPHIRE.get(), 1),
                    12, 15, 0.05f));
                //Steel
                trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                        new ItemStack(EPItems.SAPPHIRE.get(), 3),
                        new ItemStack( EPItems.STEEL_AXE.get(), 1),
                        6, 10, 0.2f));
                trades.get(4).add((pTrader, pRandom) -> ITradeOffers.EnchantedItemOffer(
                        pRandom, EPItems.SAPPHIRE.get(), 3,
                        EPItems.STEEL_SWORD.get(), 3, 10));

            //Level 5
            trades.get(5).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(EPItems.GREEN_GOLD_INGOT.get(), 4),
                    new ItemStack(EPItems.RUBY.get(), 1),
                    12, 20, 0.05f));
            trades.get(5).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(EPItems.RUBY.get(), 3),
                    new ItemStack(Items.DIAMOND_AXE, 1),
                    3, 15, 0.2f));
            trades.get(5).add((pTrader, pRandom) -> ITradeOffers.EnchantedItemOffer(
                    pRandom, EPItems.RUBY.get(), 2,
                    Items.DIAMOND_SWORD, 3, 9));
        }

        //Cleric
        if (event.getType() == VillagerProfession.CLERIC){
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades =event.getTrades();

            trades.get(4).removeAll(trades.get(4));
            trades.get(5).removeAll(trades.get(5));

            //Level 4
            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.SCUTE, 4),
                    new ItemStack(EPItems.SAPPHIRE.get(), 1),
                    12, 30, 0.05f));
            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.GLASS_BOTTLE, 9),
                    new ItemStack(EPItems.SAPPHIRE.get(), 1),
                    12, 30, 0.05f));
            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(EPItems.RUBY.get(), Mth.nextInt(pRandom, 3, 8)),
                    new ItemStack(Items.ENDER_PEARL, 1),
                    6, 15, 0.2f));
            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(EPItems.GARNET.get(), Mth.nextInt(pRandom, 3, 6)),
                    new ItemStack(Items.BLAZE_ROD, 2),
                    6, 15, 0.2f));

            //Level 5
            trades.get(5).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.NETHER_WART, 40),
                    new ItemStack(EPItems.GARNET.get(), 1),
                    6, 15, 0.05f));
            trades.get(5).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(EPItems.SAPPHIRE.get(), 3),
                    new ItemStack(Items.EXPERIENCE_BOTTLE, 1),
                    6, 15, 0.2f));
        }

        //Jeweler
        if (event.getType() == EPVillagerProfessions.JEWELER.get()){
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades =event.getTrades();

            //Level 1
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(EPItems.COBBLE.get(), 6),
                    new ItemStack(Items.EMERALD, 1),
                    16, 2, 0.05f));
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 1),
                    new ItemStack(EPItems.COBBLE.get(), 1),
                    new ItemStack(EPItems.STONE_POLISHER.get(), 1),
                    12, 1, 0.2f));

            //Level 2
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(EPItems.RAW_EMERALD.get(), 2),
                    new ItemStack(EPItems.COBBLE.get(), 6),
                    new ItemStack(Items.EMERALD, 4),
                    16, 10, 0.05f));
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 2),
                    new ItemStack(EPItems.BRASS_POLISHER.get(), 1),
                    12, 5, 0.2f));
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(EPItems.SAPPHIRE.get(), 1),
                    new ItemStack(EPItems.BRONZE_POLISHER.get(), 1),
                    12, 5, 0.2f));

            //Level 3
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 3),
                    new ItemStack(EPItems.RAW_SAPPHIRE.get(), 2),
                    new ItemStack(EPItems.SAPPHIRE.get(), 4),
                    12, 15, 0.05f));
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(EPItems.SAPPHIRE.get(), 2),
                    new ItemStack(EPItems.IRON_POLISHER.get(), 1),
                    6, 10, 0.2f));

            //Level 4
            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(EPItems.SAPPHIRE.get(), 3),
                    new ItemStack(EPItems.RAW_RUBY.get(), 2),
                    new ItemStack(EPItems.RUBY.get(), 4),
                    12, 20, 0.05f));
            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(EPItems.DEEPSLATE_COBBLE.get(), 6),
                    new ItemStack(EPItems.SAPPHIRE.get(), 1),
                    12, 20, 0.05f));
            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(EPItems.SAPPHIRE.get(), 2),
                    new ItemStack(EPItems.STEEL_POLISHER.get(), 1),
                    6, 15, 0.2f));
            trades.get(4).add((pTrader, pRandom) -> ITradeOffers.EnchantedBookOffer(
                    pRandom, EPItems.SAPPHIRE.get(), EPEnchantments.ROUGH_MINING.get(), 15));

            //Level 5
            trades.get(5).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(EPItems.SAPPHIRE.get(), 2),
                    new ItemStack(EPItems.DEEPSLATE_COBBLE.get(), 6),
                    new ItemStack(EPItems.RUBY.get(), 1),
                    12, 20, 0.05f));
            trades.get(5).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(EPItems.RUBY.get(), 3),
                    new ItemStack(EPItems.RAW_GARNET.get(), 2),
                    new ItemStack(EPItems.GARNET.get(), 4),
                    12, 20, 0.05f));
            trades.get(5).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(EPItems.BLACKSTONE_COBBLE.get(), 10),
                    new ItemStack(EPItems.GARNET.get(), 1),
                    12, 20, 0.05f));
            trades.get(5).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(EPItems.RUBY.get(), 2),
                    new ItemStack(EPItems.DIAMOND_POLISHER.get(), 1),
                    3, 15, 0.2f));
            trades.get(5).add((pTrader, pRandom) -> ITradeOffers.EnchantedBookOffer(
                    pRandom, EPItems.RUBY.get(), EPEnchantments.FINE_MINING.get(), 15));
        }

        //Librarian
        if (event.getType() == VillagerProfession.LIBRARIAN){
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades =event.getTrades();

            trades.get(1).removeAll(trades.get(1));
            trades.get(2).removeAll(trades.get(2));
            trades.get(3).removeAll(trades.get(3));
            trades.get(4).removeAll(trades.get(4));
            trades.get(5).removeAll(trades.get(5));

            //Level 1
            trades.get(1).add((pTrader, pRandom)-> new MerchantOffer(
               new ItemStack(Items.PAPER, 24),
               new ItemStack(Items.EMERALD, 1),
                 16, 2, 0.05f));
            trades.get(1).add((pTrader, pRandom)-> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 7),
                    new ItemStack(Items.BOOKSHELF, 1),
                    12, 1, 0.05f));
            trades.get(1).add((pTrader, pRandom)->
                    ITradeOffers.EnchantedBookOffer(pRandom, 1));

            //Level 2
            trades.get(2).add((pTrader, pRandom)-> new MerchantOffer(
                    new ItemStack(Items.BOOK, 4),
                    new ItemStack(Items.EMERALD, 1),
                    12, 10, 0.05f));
            trades.get(2).add((pTrader, pRandom)-> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 1),
                    new ItemStack(Items.LANTERN, 1),
                    12, 5, 0.05f));
            trades.get(2).add((pTrader, pRandom)->
                    ITradeOffers.EnchantedBookOffer(pRandom, 1));

            //Level 3
            trades.get(3).add((pTrader, pRandom)-> new MerchantOffer(
                    new ItemStack(Items.BOOK, 5),
                    new ItemStack(Items.EMERALD, 1),
                    12, 20, 0.05f));
            trades.get(3).add((pTrader, pRandom)-> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 1),
                    new ItemStack(Items.GLASS, 4),
                    12, 10, 0.05f));
            trades.get(3).add((pTrader, pRandom)->
                    ITradeOffers.EnchantedBookOffer(pRandom, 1));

            //Level 4
            trades.get(4).add((pTrader, pRandom)-> new MerchantOffer(
                    new ItemStack(Items.WRITABLE_BOOK, 1),
                    new ItemStack(Items.WRITABLE_BOOK, 1),
                    new ItemStack(Items.EMERALD, 1),
                    12, 30, 0.05f));
            trades.get(4).add((pTrader, pRandom)-> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 4),
                    new ItemStack(Items.COMPASS, 1),
                    12, 15, 0.05f));
            trades.get(4).add((pTrader, pRandom)-> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 5),
                    new ItemStack(Items.CLOCK, 1),
                    12, 15, 0.05f));
            trades.get(4).add((pTrader, pRandom)->
                    ITradeOffers.EnchantedBookOffer(pRandom, 1));

            //Level 5
            trades.get(5).add((pTrader, pRandom)-> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 20),
                    new ItemStack(Items.NAME_TAG, 1),
                    12, 30, 0.05f));
        }
    }

    @SubscribeEvent
    public static void subscribeWandererTrades (WandererTradesEvent event){
        List<VillagerTrades.ItemListing> genericTrades = event.getGenericTrades();
        List<VillagerTrades.ItemListing> rareTrades = event.getRareTrades();

        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, Mth.nextInt(pRandom, 4, 10)),
                new ItemStack(EPBlocks.WATER_REEDS.get(), 1),
                12, 1, 0.05f));

        rareTrades.add(((pTrader, pRandom) -> new MerchantOffer(
                new ItemStack(EPItems.SAPPHIRE.get(), 4),
                new ItemStack(EPBlocks.BAUXITE.get(), 2),
                15, 2, 0.2f)));
    }
}