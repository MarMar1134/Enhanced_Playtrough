package net.marmar.enhanced_playthrough.data.advancement;

public enum AdvancementCategory {
    SURVIVAL("survival"),
    GEMS("gems");

    private final String category;

    AdvancementCategory(String pCategory){
        this.category = pCategory;
    }

    public String getCategory() {
        return this.category;
    }
}
