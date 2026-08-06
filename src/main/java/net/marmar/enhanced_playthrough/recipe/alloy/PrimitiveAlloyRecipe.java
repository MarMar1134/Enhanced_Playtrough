package net.marmar.enhanced_playthrough.recipe.alloy;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.marmar.enhanced_playthrough.recipe.EPRecipes;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class PrimitiveAlloyRecipe extends AbstractAlloyRecipe implements Recipe<SimpleContainer> {
    private final NonNullList<Ingredient> inputs;
    private final int alloyTime;
    private final float xpAmount;
    private final String group;

    public PrimitiveAlloyRecipe(NonNullList<Ingredient> pInputs, ItemStack pOutput, int pAlloyTime, float pXpAmount, ResourceLocation pRecipeId, String pGroup) {
        super(pInputs, pOutput, pAlloyTime, pXpAmount, pRecipeId, EPRecipes.PRIMITIVE_ALLOY_TYPE.get(), pGroup);
        this.inputs = pInputs;
        this.alloyTime = pAlloyTime;
        this.xpAmount = pXpAmount;
        this.group = pGroup;
    }

    @Override
    public boolean matches(SimpleContainer simpleContainer, Level level) {
        if (level.isClientSide){
            return false;
        }
        return inputs.get(0).test(simpleContainer.getItem(0)) && inputs.get(1).test(simpleContainer.getItem(1));
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static class Type implements RecipeType<PrimitiveAlloyRecipe> {
        public static final Type INSTANCE = new Type();
    }

    public static class Serializer implements RecipeSerializer<PrimitiveAlloyRecipe> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public PrimitiveAlloyRecipe fromJson(ResourceLocation pRecipeId, JsonObject jsonObject) {
            String group = GsonHelper.getAsString(jsonObject, "group");

            int alloyTime = GsonHelper.getAsInt(jsonObject, "alloytime", 200);

            float xpAmount = GsonHelper.getAsFloat(jsonObject, "xp");

            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(jsonObject, "output"));

            JsonArray ingredients = GsonHelper.getAsJsonArray(jsonObject, "ingredients");
            NonNullList<Ingredient> inputs = NonNullList.withSize(2, Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++){
                inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
            }

            return new PrimitiveAlloyRecipe(inputs, output, alloyTime, xpAmount, pRecipeId, group);
        }

        @Override
        public @Nullable PrimitiveAlloyRecipe fromNetwork(ResourceLocation pRecipeId, FriendlyByteBuf pBuffer) {
            String group = pBuffer.readUtf();

            int alloyTime = pBuffer.readVarInt();

            float xpAmount = pBuffer.readFloat();

            NonNullList<Ingredient> inputs = NonNullList.withSize(pBuffer.readInt(), Ingredient.EMPTY);

            inputs.replaceAll(ignored -> Ingredient.fromNetwork(pBuffer));

            ItemStack output = pBuffer.readItem();

            return new PrimitiveAlloyRecipe(inputs, output, alloyTime, xpAmount, pRecipeId, group);
        }

        @Override
        public void toNetwork(FriendlyByteBuf pBuffer, PrimitiveAlloyRecipe pRecipe) {
            pBuffer.writeUtf(pRecipe.group);

            pBuffer.writeVarInt(pRecipe.alloyTime);

            pBuffer.writeFloat(pRecipe.xpAmount);

            pBuffer.writeInt(pRecipe.inputs.size());

            for (Ingredient ingredient : pRecipe.getIngredients()) {
                ingredient.toNetwork(pBuffer);
            }

            pBuffer.writeItemStack(pRecipe.getResultItem(null), false);
        }
    }
}
