package net.marmar.enhanced_playthrough.recipe.grind;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.marmar.enhanced_playthrough.block.EPBlocks;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import org.jetbrains.annotations.Nullable;

public class MechanicalGrindRecipe extends AbstractGrindRecipe {
    private final Ingredient input;
    private final String group;

    public MechanicalGrindRecipe(Ingredient pInput, ItemStack pOutput, ResourceLocation pRecipeId, String pGroup) {
        super(pInput, pOutput, pRecipeId);
        this.input = pInput;
        this.group = pGroup;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    @Override
    public ItemStack getToastSymbol() {
        return new ItemStack(EPBlocks.MECHANICAL_GRINDER.get());
    }

    public static class Type implements RecipeType<MechanicalGrindRecipe>{
        public static final Type INSTANCE = new Type();
    }

    public static class Serializer implements RecipeSerializer<MechanicalGrindRecipe>{
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public MechanicalGrindRecipe fromJson(ResourceLocation pRecipeId, JsonObject jsonObject) {
            String group = GsonHelper.getAsString(jsonObject, "group");

            JsonElement ingredientElement = GsonHelper.isArrayNode(jsonObject, "ingredient") ? GsonHelper.getAsJsonArray(jsonObject, "ingredient") : GsonHelper.getAsJsonObject(jsonObject, "ingredient");
            Ingredient ingredient = Ingredient.fromJson(ingredientElement, false);

            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(jsonObject, "output"));

            return new MechanicalGrindRecipe(ingredient, output, pRecipeId, group);
        }

        @Override
        public @Nullable MechanicalGrindRecipe fromNetwork(ResourceLocation pRecipeId, FriendlyByteBuf pBuffer) {
            String group = pBuffer.readUtf();

            Ingredient ingredient = Ingredient.fromNetwork(pBuffer);

            ItemStack output = pBuffer.readItem();

            return new MechanicalGrindRecipe(ingredient, output, pRecipeId, group);
        }

        @Override
        public void toNetwork(FriendlyByteBuf pBuffer, MechanicalGrindRecipe pRecipe) {
            pBuffer.writeUtf(pRecipe.group);

            pRecipe.input.toNetwork(pBuffer);

            pBuffer.writeItemStack(pRecipe.getResultItem(null), false);
        }
    }
}
