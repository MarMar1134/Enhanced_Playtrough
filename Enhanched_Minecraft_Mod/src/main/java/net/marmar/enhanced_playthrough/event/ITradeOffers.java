package net.marmar.enhanced_playthrough.event;

import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.EnchantedBookItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;

public interface ITradeOffers {
    /**
     * The following method creates a MerchantOffer that enchants the provided item and multiplies his base price based on the enchantment´s level and quality
     * @param pRandom the random source for the calculations
     * @param pCoin the coin used to buy the item
     * @param pBaseCost the base cost of the item, used as reference
     * @param pReward the offered item
     * @param pMaxUses the stock of the offered item
     * @param pVillagerXp the amount of xp that will receive the villager
     * @return the offer
     */
    static MerchantOffer EnchantedItemOffer(RandomSource pRandom, ItemLike pCoin, int pBaseCost, ItemLike pReward, int pMaxUses, int pVillagerXp){
        int costMultiplier = 5 + pRandom.nextInt(15);
        int finalCost = Math.min(pBaseCost + costMultiplier, 64);

        ItemStack enchantedItem = EnchantmentHelper.enchantItem(pRandom, new ItemStack(pReward), costMultiplier, false);

        return new MerchantOffer(new ItemStack(pCoin, finalCost), enchantedItem, pMaxUses, pVillagerXp, 0.2f);
    }

    /**
     * The following method creates a MerchantOffer that enchants the provided item and multiplies his base price based on the enchantment´s level and quality
     * @param pRandom the random source for the calculations
     * @param pFirstCoin the main coin used to buy the item
     * @param pFirstCoinCost the base cost of the item, used as reference
     * @param pSecondCoin the auxiliary coin used to buy the item
     * @param pSecondCoinCost the auxiliary cost of the item, used as reference
     * @param pReward the offered item
     * @param pMaxUses the stock of the offered item
     * @param pVillagerXp the amount of xp that will receive the villager
     * @return the offer
     */
    static MerchantOffer EnchantedItemOffer(RandomSource pRandom, ItemLike pFirstCoin, int pFirstCoinCost, ItemLike pSecondCoin, int pSecondCoinCost, ItemLike pReward, int pMaxUses, int pVillagerXp){
        int costMultiplier = 5 + pRandom.nextInt(15);
        int firstCoinCost = Math.min(pFirstCoinCost + costMultiplier, 64);
        int secondCoinCost = Math.min(pSecondCoinCost + costMultiplier, 64);

        ItemStack enchantedItem = EnchantmentHelper.enchantItem(pRandom, new ItemStack(pReward), costMultiplier, false);

        return new MerchantOffer(new ItemStack(pFirstCoin, firstCoinCost), new ItemStack(pSecondCoin, secondCoinCost), enchantedItem, pMaxUses, pVillagerXp, 0.2f);
    }

    /**
     * The following method enchants a book with a random enchantment selected from the IsTradeable method of the Enchantment class
     * @param pRandom the random source for the calculations
     * @param pCoin the item used to buy the enchanted book
     * @param pVillagerXp the amount of xp that will receive the villager
     * @return the offer
     */
    static MerchantOffer EnchantedBookOffer(RandomSource pRandom, ItemLike pCoin, int pVillagerXp){
        List<Enchantment> enchantments =  ForgeRegistries.ENCHANTMENTS.getValues().stream().filter(Enchantment::isTradeable).toList();
        Enchantment selectedEnchantment = enchantments.get(pRandom.nextInt(enchantments.size()));

        int enchantmentLevel = Mth.nextInt(pRandom, selectedEnchantment.getMinLevel(), selectedEnchantment.getMaxLevel());

        int enchantmentPrice = 2 + pRandom.nextInt(5 + enchantmentLevel * 10) + 3 * enchantmentLevel;

        if (selectedEnchantment.isTreasureOnly()){
            enchantmentPrice *= 2;
        }
        if (enchantmentPrice > 64){
            enchantmentPrice = 64;
        }

        ItemStack enchantedBookItem = EnchantedBookItem.createForEnchantment(new EnchantmentInstance(selectedEnchantment, enchantmentLevel));

        return new MerchantOffer(new ItemStack(pCoin, enchantmentPrice), new ItemStack(Items.BOOK, 1), enchantedBookItem,
                12, pVillagerXp, 0.2f);
    }

    /**
     * The following method enchants a book with the specified {@code enchantment}
     * @param pRandom the random source
     * @param pCoin the item used to buy the enchanted book
     * @param pEnchantment the enchantment that will receive the book
     * @param pVillagerXp the amount of xp that will receive the villager
     * @return the offer
     */
    static MerchantOffer EnchantedBookOffer(RandomSource pRandom, ItemLike pCoin, Enchantment pEnchantment, int pVillagerXp){
        int enchantmentLevel = Mth.nextInt(pRandom, pEnchantment.getMinLevel(), pEnchantment.getMaxLevel());

        int enchantmentPrice = 2 + pRandom.nextInt(5 + enchantmentLevel * 10) + 3 * enchantmentLevel;

        if (pEnchantment.isTreasureOnly()){
            enchantmentPrice *= 2;
        }
        if (enchantmentPrice > 64){
            enchantmentPrice = 64;
        }

        ItemStack enchantedBookItem = EnchantedBookItem.createForEnchantment(new EnchantmentInstance(pEnchantment, enchantmentLevel));

        return new MerchantOffer(new ItemStack(pCoin, enchantmentPrice), new ItemStack(Items.BOOK, 1), enchantedBookItem,
                12, pVillagerXp, 0.2f);
    }
}
