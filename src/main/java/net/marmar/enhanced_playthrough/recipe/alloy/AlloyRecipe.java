package net.marmar.enhanced_playthrough.recipe.alloy;

import net.marmar.enhanced_playthrough.block.EPBlocks;
import net.marmar.enhanced_playthrough.recipe.EPRecipes;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.marmar.enhanced_playthrough.recipe.recipecategory.AlloyRecipeCategory;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class AlloyRecipe extends AbstractAlloyRecipe implements Recipe<SimpleContainer> {
    private final NonNullList<Ingredient> inputs;
    private final int alloyTime;
    private final float xpAmount;
    private final AlloyRecipeCategory category;
    private final String group;

    public AlloyRecipe(NonNullList<Ingredient> pInputs, ItemStack pOutput, int pAlloyTime, float pXpAmount, ResourceLocation pRecipeId, AlloyRecipeCategory pCategory, String pGroup) {
        super(pInputs, pOutput, pAlloyTime, pXpAmount, pRecipeId, EPRecipes.ALLOY_TYPE.get(), pCategory, pGroup);
        this.inputs = pInputs;
        this.alloyTime = pAlloyTime;
        this.xpAmount = pXpAmount;
        this.category = pCategory;
        this.group = pGroup;
    }

    @Override
    public boolean matches(SimpleContainer simpleContainer, Level level) {
        if (level.isClientSide){
            return false;
        }
        return inputs.get(0).test(simpleContainer.getItem(0)) && inputs.get(1).test(simpleContainer.getItem(1));
    }

    public AlloyRecipeCategory getCategory() {
        return category;
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
        return new ItemStack(EPBlocks.ADOBE_ALLOY_FURNACE.get());
    }

    public static class Type implements RecipeType<AlloyRecipe>{
        public static final Type INSTANCE = new Type();
    }
    public static class Serializer implements RecipeSerializer<AlloyRecipe>{
        public static final Serializer INSTANCE = new Serializer();

        public final int defaultAlloyTime = 0;
        @Override
        public AlloyRecipe fromJson(ResourceLocation resourceLocation, JsonObject jsonObject) {
            AlloyRecipeCategory recipeCategory = AlloyRecipeCategory.findCategory(GsonHelper.getAsString(jsonObject, "category"));

            String group = GsonHelper.getAsString(jsonObject, "group");

            int alloyTime = GsonHelper.getAsInt(jsonObject, "alloytime", defaultAlloyTime);

            float xpAmount = GsonHelper.getAsFloat(jsonObject, "xp");

            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(jsonObject, "output"));

            JsonArray ingredients = GsonHelper.getAsJsonArray(jsonObject, "ingredients");
            NonNullList<Ingredient> inputs = NonNullList.withSize(2, Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++){
                inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
            }

            return new AlloyRecipe(inputs, output, alloyTime, xpAmount, resourceLocation, recipeCategory, group);
        }

        @Override
        public @Nullable AlloyRecipe fromNetwork(ResourceLocation resourceLocation, FriendlyByteBuf friendlyByteBuf) {
            AlloyRecipeCategory recipeCategory = friendlyByteBuf.readEnum(AlloyRecipeCategory.class);

            String group = friendlyByteBuf.readUtf();

            int alloyTime = friendlyByteBuf.readVarInt();

            float xpAmount = friendlyByteBuf.readFloat();

            NonNullList<Ingredient> inputs = NonNullList.withSize(friendlyByteBuf.readInt(), Ingredient.EMPTY);

            inputs.replaceAll(ignored -> Ingredient.fromNetwork(friendlyByteBuf));

            ItemStack output = friendlyByteBuf.readItem();
            return new AlloyRecipe(inputs, output, alloyTime, xpAmount, resourceLocation, recipeCategory, group);
        }

        @Override
        public void toNetwork(FriendlyByteBuf friendlyByteBuf, AlloyRecipe alloyRecipes) {
            friendlyByteBuf.writeEnum(alloyRecipes.category);

            friendlyByteBuf.writeUtf(alloyRecipes.group);

            friendlyByteBuf.writeVarInt(alloyRecipes.alloyTime);

            friendlyByteBuf.writeFloat(alloyRecipes.xpAmount);

            friendlyByteBuf.writeInt(alloyRecipes.inputs.size());

            for (Ingredient ingredient : alloyRecipes.getIngredients()) {
                ingredient.toNetwork(friendlyByteBuf);
            }

            friendlyByteBuf.writeItemStack(alloyRecipes.getResultItem(null), false);
        }
    }
}
