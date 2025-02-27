package net.marmar.enhanced_playthrough.recipe.alloy;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.recipe.ModRecipes;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.marmar.enhanced_playthrough.recipe.category.AlloyRecipeCategory;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class AlloyingFurnaceRecipe extends AbstractAlloyRecipe implements Recipe<SimpleContainer> {
    private final NonNullList<Ingredient> inputs;
    private final int alloyTime;
    private final AlloyRecipeCategory category;
    private final String group;

    public AlloyingFurnaceRecipe(NonNullList<Ingredient> inputs, ItemStack output, int alloyingTime, ResourceLocation id, AlloyRecipeCategory category, String group) {
        super(inputs, output, alloyingTime, id, ModRecipes.ALLOYING_TYPE.get(), category, group);
        this.inputs = inputs;
        this.alloyTime = alloyingTime;
        this.category = category;
        this.group = group;
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



    public static class Type implements RecipeType<AlloyingFurnaceRecipe>{
        public static final Type INSTANCE = new Type();
        private static String ID = "ore_alloying";
    }
    public static class Serializer implements RecipeSerializer<AlloyingFurnaceRecipe>{
        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID = new ResourceLocation(EnhancedPlaythrough.MOD_ID, "ore_alloying");

        public final int defaultAlloyTime = 0;
        @Override
        public AlloyingFurnaceRecipe fromJson(ResourceLocation resourceLocation, JsonObject jsonObject) {
            AlloyRecipeCategory recipeCategory = AlloyRecipeCategory.findCategory(GsonHelper.getAsString(jsonObject, "category"));

            String group = GsonHelper.getAsString(jsonObject, "group");

            int alloyTime = GsonHelper.getAsInt(jsonObject, "alloytime", defaultAlloyTime);

            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(jsonObject, "output"));

            JsonArray ingredients = GsonHelper.getAsJsonArray(jsonObject, "ingredients");
            NonNullList<Ingredient> inputs = NonNullList.withSize(2, Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++){
                inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
            }

            return new AlloyingFurnaceRecipe(inputs, output, alloyTime, resourceLocation, recipeCategory, group);
        }

        @Override
        public @Nullable AlloyingFurnaceRecipe fromNetwork(ResourceLocation resourceLocation, FriendlyByteBuf friendlyByteBuf) {
            AlloyRecipeCategory recipeCategory = friendlyByteBuf.readEnum(AlloyRecipeCategory.class);

            String group = friendlyByteBuf.readUtf();

            int alloyTime = friendlyByteBuf.readVarInt();

            NonNullList<Ingredient> inputs = NonNullList.withSize(friendlyByteBuf.readInt(), Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++){
                inputs.set(i, Ingredient.fromNetwork(friendlyByteBuf));
            }

            ItemStack output = friendlyByteBuf.readItem();
            return new AlloyingFurnaceRecipe(inputs, output, alloyTime, resourceLocation, recipeCategory, group);
        }

        @Override
        public void toNetwork(FriendlyByteBuf friendlyByteBuf, AlloyingFurnaceRecipe alloyingFurnaceRecipes) {
            friendlyByteBuf.writeEnum(alloyingFurnaceRecipes.category);

            friendlyByteBuf.writeUtf(alloyingFurnaceRecipes.group);

            friendlyByteBuf.writeVarInt(alloyingFurnaceRecipes.alloyTime);

            friendlyByteBuf.writeInt(alloyingFurnaceRecipes.inputs.size());

            for (Ingredient ingredient : alloyingFurnaceRecipes.getIngredients()) {
                ingredient.toNetwork(friendlyByteBuf);
            }
            friendlyByteBuf.writeItemStack(alloyingFurnaceRecipes.getResultItem(null), false);
        }
    }
}
