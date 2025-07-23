package net.marmar.enhanced_playthrough.data.loot;

import net.marmar.enhanced_playthrough.data.loot.table.EPAdvancementLootTables;
import net.marmar.enhanced_playthrough.data.loot.table.EPBlockLootTables;
import net.marmar.enhanced_playthrough.data.loot.table.EPChestLootTables;
import net.marmar.enhanced_playthrough.data.loot.table.VanillaBlockLootTables;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Set;

public class EPLootTableProvider {
    public static LootTableProvider create(PackOutput output){
        return new LootTableProvider(output, Set.of(), List.of(
                new LootTableProvider.SubProviderEntry(EPBlockLootTables::new, LootContextParamSets.BLOCK),
                new LootTableProvider.SubProviderEntry(VanillaBlockLootTables::new, LootContextParamSets.BLOCK),
                new LootTableProvider.SubProviderEntry(EPChestLootTables::new, LootContextParamSets.CHEST),
                new LootTableProvider.SubProviderEntry(EPAdvancementLootTables::new, LootContextParamSets.ADVANCEMENT_REWARD)
        ));
    }
}
