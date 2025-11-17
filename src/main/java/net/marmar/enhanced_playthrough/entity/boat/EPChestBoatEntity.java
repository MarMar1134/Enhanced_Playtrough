package net.marmar.enhanced_playthrough.entity.boat;

import net.marmar.enhanced_playthrough.entity.EPEntityTypes;
import net.marmar.enhanced_playthrough.item.EPItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.entity.vehicle.ChestBoat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

public class EPChestBoatEntity extends ChestBoat {
    private static final EntityDataAccessor<Integer> DATA_ID_TYPE = SynchedEntityData.defineId(Boat.class, EntityDataSerializers.INT);

    public EPChestBoatEntity(EntityType<? extends ChestBoat> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public EPChestBoatEntity(Level pLevel, double pX, double pY, double pZ) {
        this(EPEntityTypes.MOD_CHEST_BOAT.get(), pLevel);
        this.setPos(pX, pY, pZ);
        this.xo = pX;
        this.yo = pY;
        this.zo = pZ;
    }

    @Override
    public Item getDropItem() {
       return switch (getModVariant()) {
           case WALNUT -> EPItems.WALNUT_CHEST_BOAT.get();
           case APPLE -> EPItems.APPLE_CHEST_BOAT.get();
           case ORANGE -> EPItems.ORANGE_CHEST_BOAT.get();
           case LEMON -> EPItems.LEMON_CHEST_BOAT.get();
        };
    }

    public void setVariant(EPBoatEntity.Type pVariant) {
        this.entityData.set(DATA_ID_TYPE, pVariant.ordinal());
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_ID_TYPE, EPBoatEntity.Type.WALNUT.ordinal());
    }

    protected void addAdditionalSaveData(CompoundTag pCompound) {
        pCompound.putString("Type", this.getModVariant().getSerializedName());
    }

    protected void readAdditionalSaveData(CompoundTag pCompound) {
        if (pCompound.contains("Type", 8)) {
            this.setVariant(EPBoatEntity.Type.byName(pCompound.getString("Type")));
        }
    }

    public EPBoatEntity.Type getModVariant() {
        return EPBoatEntity.Type.byId(this.entityData.get(DATA_ID_TYPE));
    }
}
