package net.marmar.enhanced_playthrough.recipe.crafting;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;

public class EPShapelessRecipe extends ShapelessRecipe {
    final ItemStack result;
    private final boolean consumeDurability;
    private final int durabilityToConsume;

    public EPShapelessRecipe(ResourceLocation pId, String pGroup, CraftingBookCategory pCategory, ItemStack pResult, NonNullList<Ingredient> pIngredients, boolean pConsumeDurability, int pDurabilityToConsume) {
        super(pId, pGroup, pCategory, pResult, pIngredients);
        this.result = pResult;
        this.consumeDurability = pConsumeDurability;
        this.durabilityToConsume = pDurabilityToConsume;
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

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    public static class Serializer implements RecipeSerializer<EPShapelessRecipe> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public EPShapelessRecipe fromJson(ResourceLocation pRecipeId, JsonObject pJson) {
            String group = GsonHelper.getAsString(pJson, "group", "");

            CraftingBookCategory craftingBookCategory = CraftingBookCategory.CODEC.byName(GsonHelper.getAsString(pJson, "category", null), CraftingBookCategory.MISC);

            NonNullList<Ingredient> ingredients = itemsFromJson(GsonHelper.getAsJsonArray(pJson, "ingredients"));

            if (ingredients.isEmpty()) {
                throw new JsonParseException("No ingredients for shapeless recipe");
            } else if (ingredients.size() > 9) {
                throw new JsonParseException("Too many ingredients for shapeless recipe. The maximum is " + 9);
            } else {
                boolean consumeDurability = GsonHelper.getAsBoolean(pJson, "consume_durability", false);
                int durabilityToConsume = GsonHelper.getAsInt(pJson,"durability_to_consume", 0);

                ItemStack result = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(pJson, "result"));

                return new EPShapelessRecipe(pRecipeId, group, craftingBookCategory, result, ingredients, consumeDurability, durabilityToConsume);
            }
        }

        private static NonNullList<Ingredient> itemsFromJson(JsonArray pIngredientArray) {
            NonNullList<Ingredient> ingredients = NonNullList.create();

            for(int i = 0; i < pIngredientArray.size(); ++i) {
                Ingredient ingredient = Ingredient.fromJson(pIngredientArray.get(i), false);
                if (true) {
                    ingredients.add(ingredient);
                }
            }

            return ingredients;
        }

        @Override
        public EPShapelessRecipe fromNetwork(ResourceLocation pRecipeId, FriendlyByteBuf pBuffer) {
            String group = pBuffer.readUtf();

            CraftingBookCategory craftingBookCategory = pBuffer.readEnum(CraftingBookCategory.class);

            int ingredientQuantity = pBuffer.readVarInt();

            NonNullList<Ingredient> ingredients = NonNullList.withSize(ingredientQuantity, Ingredient.EMPTY);

            ingredients.replaceAll(ignored -> Ingredient.fromNetwork(pBuffer));

            boolean consumeDurability = pBuffer.readBoolean();
            int durabilityToConsume = pBuffer.readVarInt();

            ItemStack result = pBuffer.readItem();

            return new EPShapelessRecipe(pRecipeId, group, craftingBookCategory, result, ingredients, consumeDurability, durabilityToConsume);
        }

        @Override
        public void toNetwork(FriendlyByteBuf pBuffer, EPShapelessRecipe pRecipe) {
            pBuffer.writeUtf(pRecipe.getGroup());
            pBuffer.writeEnum(pRecipe.category());
            pBuffer.writeVarInt(pRecipe.getIngredients().size());

            for(Ingredient ingredient : pRecipe.getIngredients()) {
                ingredient.toNetwork(pBuffer);
            }

            pBuffer.writeBoolean(pRecipe.consumeDurability);
            pBuffer.writeVarInt(pRecipe.durabilityToConsume);

            pBuffer.writeItem(pRecipe.result);
        }
    }
}
