package net.marmar.enhanced_playthrough.datagen.loot;

import net.marmar.enhanced_playthrough.datagen.loot.advancement.EPAdvancementLootTables;
import net.marmar.enhanced_playthrough.datagen.loot.block.EPIBlockLootTables;
import net.marmar.enhanced_playthrough.datagen.loot.chest.EPChestLootTables;
import net.marmar.enhanced_playthrough.datagen.loot.block.VanillaIBlockLootTables;
import net.marmar.enhanced_playthrough.datagen.loot.entity.EPEntityLootTables;
import net.marmar.enhanced_playthrough.datagen.loot.entity.VanillaEntityLootTables;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Set;

public class EPLootTableProvider {
    public static LootTableProvider create(PackOutput output){
        return new LootTableProvider(output, Set.of(), List.of(
                new LootTableProvider.SubProviderEntry(EPIBlockLootTables::new, LootContextParamSets.BLOCK),
                new LootTableProvider.SubProviderEntry(VanillaIBlockLootTables::new, LootContextParamSets.BLOCK),
                new LootTableProvider.SubProviderEntry(EPChestLootTables::new, LootContextParamSets.CHEST),
                new LootTableProvider.SubProviderEntry(EPAdvancementLootTables::new, LootContextParamSets.ADVANCEMENT_REWARD),
                new LootTableProvider.SubProviderEntry(EPEntityLootTables::new, LootContextParamSets.ENTITY),
                new LootTableProvider.SubProviderEntry(VanillaEntityLootTables::new, LootContextParamSets.ENTITY)
        ));
    }
}
