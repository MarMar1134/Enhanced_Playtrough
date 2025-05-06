package net.marmar.enhanced_playthrough.recipe.recipecategory;

public enum AlloyRecipeCategory {
    COMPLEX_ALLOY("complex_alloy"),
    SIMPLE_ALLOY("simple_alloy");

    private final String category_name;

    AlloyRecipeCategory(String pCategory_name){
        this.category_name = pCategory_name;
    }

    public static AlloyRecipeCategory findCategory(String category_name) {
        for (AlloyRecipeCategory name: values()){
            if (name.category_name.equals(category_name)){
                return name;
            }
        }
        throw new IllegalStateException("unknown alloy category");
    }

    public String getSerializedName() {
        return category_name;
    }
}
