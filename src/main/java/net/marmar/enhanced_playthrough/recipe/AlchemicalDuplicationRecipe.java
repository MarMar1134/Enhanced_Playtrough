package net.marmar.enhanced_playthrough.recipe;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class AlchemicalDuplicationRecipe implements Recipe<SimpleContainer> {
    private final Ingredient input;
    private final ItemStack output;
    private final ResourceLocation recipeId;
    private final float givenXp;

    public AlchemicalDuplicationRecipe(Ingredient pInput, ItemStack pOutput, ResourceLocation pRecipeId, float pXp){
        this.input = pInput;
        this.output = pOutput;
        this.recipeId = pRecipeId;
        this.givenXp = pXp;
    }

    @Override
    public boolean matches(SimpleContainer simpleContainer, Level level) {
        if (level.isClientSide){
            return false;
        }
        return input.test(simpleContainer.getItem(0));
    }

    @Override
    public ItemStack assemble(SimpleContainer simpleContainer, RegistryAccess registryAccess) {
        return this.output.copy();
    }

    @Override
    public boolean canCraftInDimensions(int i, int i1) {
        return true;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess registryAccess) {
        return this.output.copy();
    }

    @Override
    public ResourceLocation getId() {
        return this.recipeId;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static class Type implements RecipeType<AlchemicalDuplicationRecipe> {
        public static final Type INSTANCE = new Type();
    }

    public static class Serializer implements RecipeSerializer<AlchemicalDuplicationRecipe> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public AlchemicalDuplicationRecipe fromJson(ResourceLocation resourceLocation, JsonObject jsonObject) {
            JsonElement ingredientElement = GsonHelper.isArrayNode(jsonObject, "input") ? GsonHelper.getAsJsonArray(jsonObject, "input") : GsonHelper.getAsJsonObject(jsonObject, "input");
            Ingredient ingredient = Ingredient.fromJson(ingredientElement, false);

            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(jsonObject, "output"));

            float xp = GsonHelper.getAsFloat(jsonObject, "xp");

            return new AlchemicalDuplicationRecipe(ingredient, output, resourceLocation, xp);
        }

        @Override
        public @Nullable AlchemicalDuplicationRecipe fromNetwork(ResourceLocation resourceLocation, FriendlyByteBuf friendlyByteBuf) {
            Ingredient ingredient = Ingredient.fromNetwork(friendlyByteBuf);

            ItemStack output = friendlyByteBuf.readItem();

            float xp = friendlyByteBuf.readFloat();

            return new AlchemicalDuplicationRecipe(ingredient, output, resourceLocation, xp);
        }

        @Override
        public void toNetwork(FriendlyByteBuf friendlyByteBuf, AlchemicalDuplicationRecipe alchemicalDuplicationRecipe) {
            alchemicalDuplicationRecipe.input.toNetwork(friendlyByteBuf);

            friendlyByteBuf.writeItemStack(alchemicalDuplicationRecipe.getResultItem(null), false);

            friendlyByteBuf.writeFloat(alchemicalDuplicationRecipe.givenXp);
        }
    }
}
