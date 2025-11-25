package net.marmar.enhanced_playthrough.entity;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class EPModelLayers {
    //Boats
        //Walnut
        public static final ModelLayerLocation WALNUT_BOAT_LAYER = registerBoatLayer("walnut");
        public static final ModelLayerLocation WALNUT_CHEST_BOAT_LAYER = registerChestBoatLayer("walnut");

        //Apple
        public static final ModelLayerLocation APPLE_BOAT_LAYER = registerBoatLayer("apple");
        public static final ModelLayerLocation APPLE_CHEST_BOAT_LAYER = registerChestBoatLayer("apple");

        //Orange
        public static final ModelLayerLocation ORANGE_BOAT_LAYER = registerBoatLayer("orange");
        public static final ModelLayerLocation ORANGE_CHEST_BOAT_LAYER = registerChestBoatLayer("orange");

        //Lemon
        public static final ModelLayerLocation LEMON_BOAT_LAYER = registerBoatLayer("lemon");
        public static final ModelLayerLocation LEMON_CHEST_BOAT_LAYER = registerChestBoatLayer("lemon");

    //Entities
        //Bandit
        public static final ModelLayerLocation BANDIT = registerMainLayer("bandit");

        //Zombie knight
        public static final ModelLayerLocation ZOMBIE_KNIGHT = registerMainLayer("zombie_knight");
        public static final ModelLayerLocation ZOMBIE_KNIGHT_INNER_ARMOR = registerInnerArmorLayer("zombie_knight_inner_armor");
        public static final ModelLayerLocation ZOMBIE_KNIGHT_OUTER_ARMOR = registerOuterArmorLayer("zombie_knight_outer_armor");
        public static final ModelLayerLocation ZOMBIE_KNIGHT_OUTER = registerOuterLayer("zombie_knight_outer");

        //Skeleton bowmaster
        public static final ModelLayerLocation SKELETON_BOWMASTER = registerMainLayer("skeleton_bowmaster");
        public static final ModelLayerLocation SKELETON_BOWMASTER_INNER_ARMOR = registerInnerArmorLayer("skeleton_bowmaster_inner_armor");
        public static final ModelLayerLocation SKELETON_BOWMASTER_OUTER_ARMOR = registerOuterArmorLayer("skeleton_bowmaster_outer_armor");
        public static final ModelLayerLocation SKELETON_BOWMASTER_OUTER = registerOuterLayer("skeleton_bowmaster_outer");

   //Helper methods
    private static ResourceLocation modLoc(String pPath){
        return ResourceLocation.fromNamespaceAndPath(EnhancedPlaythrough.MOD_ID, pPath);
    }

   public static ModelLayerLocation registerBoatLayer(String pLayer){
       return new ModelLayerLocation(modLoc("boat/" + pLayer), "main");
   }

    public static ModelLayerLocation registerChestBoatLayer(String pLayer){
        return new ModelLayerLocation(modLoc("chest_boat/" + pLayer), "main");
    }

    public static ModelLayerLocation registerMainLayer(String pLayer){
        return new ModelLayerLocation(modLoc(pLayer), "main");
    }

    public static ModelLayerLocation registerInnerArmorLayer(String pLayer){
        return new ModelLayerLocation(modLoc(pLayer), "inner_armor");
    }

    public static ModelLayerLocation registerOuterArmorLayer(String pLayer){
        return new ModelLayerLocation(modLoc(pLayer), "outer_armor");
    }

    public static ModelLayerLocation registerOuterLayer(String pLayer){
        return new ModelLayerLocation(modLoc(pLayer), "outer");
    }
}
