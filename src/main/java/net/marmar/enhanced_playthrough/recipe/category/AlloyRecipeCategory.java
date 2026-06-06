package net.marmar.enhanced_playthrough.recipe.category;

public enum AlloyRecipeCategory {
    COMPLEX_ALLOY("complex_alloy"),
    SIMPLE_ALLOY("simple_alloy");

    private final String categoryName;

    AlloyRecipeCategory(String pCategoryName){
        this.categoryName = pCategoryName;
    }

    public static AlloyRecipeCategory findCategory(String category_name) {
        for (AlloyRecipeCategory name: values()){
            if (name.categoryName.equals(category_name)){
                return name;
            }
        }
        throw new IllegalStateException("unknown alloy category");
    }

    public String getSerializedName() {
        return categoryName;
    }
}
