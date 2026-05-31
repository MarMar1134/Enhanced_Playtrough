package net.marmar.enhanced_playthrough.recipe.crafting;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;

import java.util.Map;
import java.util.Set;

public class EPShapedRecipe extends ShapedRecipe {
    static int MAX_WIDTH = 3;
    static int MAX_HEIGHT = 3;
    final ItemStack result;
    private final boolean consumeDurability;
    private final int durabilityToConsume;

    public EPShapedRecipe(ResourceLocation pId, String pGroup, CraftingBookCategory pCategory, int pWidth, int pHeight, NonNullList<Ingredient> pRecipeItems, boolean pConsumeDurability, int pDurabilityToConsume, ItemStack pResult, boolean pShowNotification) {
        super(pId, pGroup, pCategory, pWidth, pHeight, pRecipeItems, pResult, pShowNotification);
        this.result = pResult;
        this.consumeDurability = pConsumeDurability;
        this.durabilityToConsume = pDurabilityToConsume;
    }

    static Map<String, Ingredient> keyFromJson(JsonObject pKeyEntry) {
        Map<String, Ingredient> map = Maps.newHashMap();

        for(Map.Entry<String, JsonElement> entry : pKeyEntry.entrySet()) {
            if (entry.getKey().length() != 1) {
                throw new JsonSyntaxException("Invalid key entry: '" + (String)entry.getKey() + "' is an invalid symbol (must be 1 character only).");
            }

            if (" ".equals(entry.getKey())) {
                throw new JsonSyntaxException("Invalid key entry: ' ' is a reserved symbol.");
            }

            map.put(entry.getKey(), Ingredient.fromJson(entry.getValue(), false));
        }

        map.put(" ", Ingredient.EMPTY);
        return map;
    }

    static String[] patternFromJson(JsonArray pPatternArray) {
        String[] astring = new String[pPatternArray.size()];
        if (astring.length > MAX_HEIGHT) {
            throw new JsonSyntaxException("Invalid pattern: too many rows, " + MAX_HEIGHT + " is maximum");
        } else if (astring.length == 0) {
            throw new JsonSyntaxException("Invalid pattern: empty pattern not allowed");
        } else {
            for(int i = 0; i < astring.length; ++i) {
                String s = GsonHelper.convertToString(pPatternArray.get(i), "pattern[" + i + "]");
                if (s.length() > MAX_WIDTH) {
                    throw new JsonSyntaxException("Invalid pattern: too many columns, " + MAX_WIDTH + " is maximum");
                }

                if (i > 0 && astring[0].length() != s.length()) {
                    throw new JsonSyntaxException("Invalid pattern: each row must be the same width");
                }

                astring[i] = s;
            }

            return astring;
        }
    }

    @Override
    public NonNullList<ItemStack> getRemainingItems(CraftingContainer pContainer) {
        NonNullList<ItemStack> remaining = NonNullList.withSize(pContainer.getContainerSize(), ItemStack.EMPTY);

        for (int i = 0; i < remaining.size(); i++) {
            ItemStack stack = pContainer.getItem(i);

            if (stack.isDamageableItem() && this.consumeDurability) {
                ItemStack copy = stack.copy();
                copy.setDamageValue(copy.getDamageValue() + this.durabilityToConsume);

                if (copy.getDamageValue() < copy.getMaxDamage()) {
                    remaining.set(i, copy);
                }
            } else if (stack.hasCraftingRemainingItem()) {
                remaining.set(i, stack.getCraftingRemainingItem());
            }
        }

        return remaining;
    }

    private static int firstNonSpace(String pEntry) {
        int i;
        for(i = 0; i < pEntry.length() && pEntry.charAt(i) == ' '; ++i) {
        }

        return i;
    }

    private static int lastNonSpace(String pEntry) {
        int i;
        for(i = pEntry.length() - 1; i >= 0 && pEntry.charAt(i) == ' '; --i) {
        }

        return i;
    }

    static NonNullList<Ingredient> dissolvePattern(String[] pPattern, Map<String, Ingredient> pKeys, int pPatternWidth, int pPatternHeight) {
        NonNullList<Ingredient> nonnulllist = NonNullList.withSize(pPatternWidth * pPatternHeight, Ingredient.EMPTY);
        Set<String> set = Sets.newHashSet(pKeys.keySet());
        set.remove(" ");

        for(int i = 0; i < pPattern.length; ++i) {
            for(int j = 0; j < pPattern[i].length(); ++j) {
                String s = pPattern[i].substring(j, j + 1);
                Ingredient ingredient = pKeys.get(s);
                if (ingredient == null) {
                    throw new JsonSyntaxException("Pattern references symbol '" + s + "' but it's not defined in the key");
                }

                set.remove(s);
                nonnulllist.set(j + pPatternWidth * i, ingredient);
            }
        }

        if (!set.isEmpty()) {
            throw new JsonSyntaxException("Key defines symbols that aren't used in pattern: " + set);
        } else {
            return nonnulllist;
        }
    }

    static String[] shrink(String... pToShrink) {
        int i = Integer.MAX_VALUE;
        int j = 0;
        int k = 0;
        int l = 0;

        for(int i1 = 0; i1 < pToShrink.length; ++i1) {
            String s = pToShrink[i1];
            i = Math.min(i, firstNonSpace(s));
            int j1 = lastNonSpace(s);
            j = Math.max(j, j1);
            if (j1 < 0) {
                if (k == i1) {
                    ++k;
                }

                ++l;
            } else {
                l = 0;
            }
        }

        if (pToShrink.length == l) {
            return new String[0];
        } else {
            String[] astring = new String[pToShrink.length - l - k];

            for(int k1 = 0; k1 < astring.length; ++k1) {
                astring[k1] = pToShrink[k1 + k].substring(i, j + 1);
            }

            return astring;
        }
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    public static class Serializer implements RecipeSerializer<EPShapedRecipe> {
        public static final Serializer INSTANCE = new Serializer();

        public EPShapedRecipe fromJson(ResourceLocation pRecipeId, JsonObject pJson) {
            String group = GsonHelper.getAsString(pJson, "group", "");

            boolean consumeDurability = GsonHelper.getAsBoolean(pJson, "consume_durability", false);
            int durabilityToConsume = GsonHelper.getAsInt(pJson, "durability_to_consume", 0);

            CraftingBookCategory craftingbookcategory = CraftingBookCategory.CODEC.byName(GsonHelper.getAsString(pJson, "category", null), CraftingBookCategory.MISC);

            Map<String, Ingredient> map = EPShapedRecipe.keyFromJson(GsonHelper.getAsJsonObject(pJson, "key"));

            String[] pattern = EPShapedRecipe.shrink(EPShapedRecipe.patternFromJson(GsonHelper.getAsJsonArray(pJson, "pattern")));
            int width = pattern[0].length();
            int height = pattern.length;

            NonNullList<Ingredient> ingredients = EPShapedRecipe.dissolvePattern(pattern, map, width, height);
            ItemStack result = EPShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(pJson, "result"));

            boolean showNotification = GsonHelper.getAsBoolean(pJson, "show_notification", true);
            return new EPShapedRecipe(pRecipeId, group, craftingbookcategory, width, height, ingredients, consumeDurability, durabilityToConsume, result, showNotification);
        }

        public EPShapedRecipe fromNetwork(ResourceLocation pRecipeId, FriendlyByteBuf pBuffer) {
            int width = pBuffer.readVarInt();
            int height = pBuffer.readVarInt();

            String group = pBuffer.readUtf();

            CraftingBookCategory craftingBookCategory = pBuffer.readEnum(CraftingBookCategory.class);

            boolean consumeDurability = pBuffer.readBoolean();
            int durabilityToConsume = pBuffer.readVarInt();

            NonNullList<Ingredient> ingredients = NonNullList.withSize(width * height, Ingredient.EMPTY);

            for(int k = 0; k < ingredients.size(); ++k) {
                ingredients.set(k, Ingredient.fromNetwork(pBuffer));
            }

            ItemStack result = pBuffer.readItem();

            boolean showNotification = pBuffer.readBoolean();
            return new EPShapedRecipe(pRecipeId, group, craftingBookCategory, width, height, ingredients, consumeDurability, durabilityToConsume, result, showNotification);
        }

        public void toNetwork(FriendlyByteBuf pBuffer, EPShapedRecipe pRecipe) {
            pBuffer.writeVarInt(pRecipe.getWidth());
            pBuffer.writeVarInt(pRecipe.getHeight());
            pBuffer.writeUtf(pRecipe.getGroup());
            pBuffer.writeEnum(pRecipe.category());

            pBuffer.writeBoolean(pRecipe.consumeDurability);
            pBuffer.writeVarInt(pRecipe.durabilityToConsume);

            for(Ingredient ingredient : pRecipe.getIngredients()) {
                ingredient.toNetwork(pBuffer);
            }

            pBuffer.writeItem(pRecipe.result);
            pBuffer.writeBoolean(pRecipe.showNotification());
        }
    }
}
