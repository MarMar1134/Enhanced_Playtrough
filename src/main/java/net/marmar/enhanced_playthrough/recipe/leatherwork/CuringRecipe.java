package net.marmar.enhanced_playthrough.recipe.leatherwork;

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
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;

public class CuringRecipe implements Recipe<SimpleContainer> {
    private final ResourceLocation recipeId;
    private final Ingredient catalyst;
    private final Ingredient input;
    private final FluidStack fluid;
    private final int fluidAmount;
    private final ItemStack output;
    private final int outputAmount;

    public CuringRecipe(ResourceLocation pRecipeId, Ingredient pCatalyst, Ingredient pInput, FluidStack pFluid, int pFluidAmount, ItemStack pOutput, int pOutputAmount) {
        this.recipeId = pRecipeId;
        this.catalyst = pCatalyst;
        this.input = pInput;
        this.fluid = pFluid;
        this.fluidAmount = pFluidAmount;
        this.output = pOutput;
        this.outputAmount = pOutputAmount;
    }

    @Override
    public boolean matches(SimpleContainer pContainer, Level pLevel) {
        return this.catalyst.test(pContainer.getItem(0)) && this.input.test(pContainer.getItem(1));
    }

    @Override
    public ItemStack assemble(SimpleContainer pContainer, RegistryAccess pRegistryAccess) {
        return this.output.copy();
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    public Ingredient getCatalyst() {
        return this.catalyst;
    }

    public Ingredient getInput() {
        return this.input;
    }

    public FluidStack getFluidStack()  {
        return this.fluid;
    }

    public int getFluidAmount() {
        return this.fluidAmount;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess pRegistryAccess) {
        return this.output.copy();
    }

    public int getOutputAmount() {
        return this.outputAmount;
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

    public static class Type implements RecipeType<CuringRecipe> {
        public static final Type INSTANCE = new Type();
    }

    @SuppressWarnings("removal")
    public static class Serializer implements RecipeSerializer<CuringRecipe> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public CuringRecipe fromJson(ResourceLocation pRecipeId, JsonObject jsonObject) {
            //Catalyst
            JsonObject catalystObject = GsonHelper.getAsJsonObject(jsonObject,"catalyst", null);

            JsonElement catalystElement = GsonHelper.isArrayNode(catalystObject, "item") ? GsonHelper.getAsJsonArray(catalystObject, "item") : GsonHelper.getAsJsonObject(catalystObject, "item");
            Ingredient catalyst = Ingredient.fromJson(catalystElement, false);

            //Input
            JsonObject inputObject = GsonHelper.getAsJsonObject(jsonObject, "input", null);

            JsonElement inputElement = GsonHelper.isArrayNode(inputObject, "item") ? GsonHelper.getAsJsonArray(inputObject, "item") : GsonHelper.getAsJsonObject(inputObject, "item");
            Ingredient input = Ingredient.fromJson(inputElement, false);

            //Fluid
            Fluid fluid = ForgeRegistries.FLUIDS.getValue(new ResourceLocation(inputObject.get("fluid").getAsString()));
            int fluidAmount = GsonHelper.getAsInt(inputObject, "fluid_amount", 0);

            FluidStack fluidStack = new FluidStack(fluid, fluidAmount);

            //Output
            JsonObject outputObject = GsonHelper.getAsJsonObject(jsonObject, "output", null);

            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(outputObject, "item"));
            int outputAmount = GsonHelper.getAsInt(outputObject, "leather_amount", 0);

            return new CuringRecipe(pRecipeId, catalyst, input, fluidStack, fluidAmount, output, outputAmount);
        }

        @Override
        public @Nullable CuringRecipe fromNetwork(ResourceLocation pRecipeId, FriendlyByteBuf pBuffer) {
            Ingredient catalyst = Ingredient.fromNetwork(pBuffer);

            Ingredient input = Ingredient.fromNetwork(pBuffer);

            FluidStack fluid  = FluidStack.readFromPacket(pBuffer);
            int fluidAmount = pBuffer.readVarInt();

            ItemStack output = pBuffer.readItem();
            int amount = pBuffer.readVarInt();

            return new CuringRecipe(pRecipeId, catalyst, input, fluid, fluidAmount, output, amount);
        }

        @Override
        public void toNetwork(FriendlyByteBuf pBuffer, CuringRecipe pRecipe) {
            pRecipe.catalyst.toNetwork(pBuffer);

            pRecipe.input.toNetwork(pBuffer);

            pRecipe.getFluidStack().writeToPacket(pBuffer);
            pBuffer.writeVarInt(pRecipe.fluidAmount);

            pBuffer.writeItemStack(pRecipe.getResultItem(null), false);
            pBuffer.writeVarInt(pRecipe.outputAmount);
        }
    }
}
