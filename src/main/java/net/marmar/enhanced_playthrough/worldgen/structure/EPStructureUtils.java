package net.marmar.enhanced_playthrough.worldgen.structure;

import it.unimi.dsi.fastutil.longs.Long2BooleanMap;
import it.unimi.dsi.fastutil.longs.Long2BooleanOpenHashMap;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.levelgen.structure.Structure;

public class EPStructureUtils {
    private static final Long2BooleanMap CACHE = new Long2BooleanOpenHashMap();

    //Caches the chunk position of the structure to avoid reading the entire chunk every time a mob tries to spawn
    private static boolean isInside(ServerLevelAccessor level, BlockPos pos, Structure structure) {
        long chunk = pos.asLong() >> 4;

        if (CACHE.containsKey(chunk)) {
            return CACHE.get(chunk);
        }

        boolean inside = level.getLevel().structureManager().getStructureAt(pos, structure).isValid();

        CACHE.put(chunk, inside);
        return inside;
    }

    /**Checks if the mob is inside the given structure and saves the structure's chunk position
     * @param level the player's level
     * @param pos the position where the mob tries to spawn
     * @param structureKey the key of the structure designed to spawn
     * @return true if the mob is inside the structure, false otherwise
     */
    public static boolean isInsideStructure(ServerLevelAccessor level, BlockPos pos, ResourceKey<Structure> structureKey){
        Structure structure = level.registryAccess().registryOrThrow(Registries.STRUCTURE).get(structureKey);

        if (structure == null) return false;

        return isInside(level, pos, structure);
    }
}
