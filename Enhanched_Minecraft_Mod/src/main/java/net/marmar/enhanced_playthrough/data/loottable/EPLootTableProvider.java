package net.marmar.enhanced_playthrough.data.loottable;

import net.marmar.enhanced_playthrough.data.loottable.advancement.EPAdvancementLootTables;
import net.marmar.enhanced_playthrough.data.loottable.block.EPBlockLootTables;
import net.marmar.enhanced_playthrough.data.loottable.chest.EPChestLootTables;
import net.marmar.enhanced_playthrough.data.loottable.block.VanillaBlockLootTables;
import net.marmar.enhanced_playthrough.data.loottable.entity.EPEntityLootTables;
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
                new LootTableProvider.SubProviderEntry(EPAdvancementLootTables::new, LootContextParamSets.ADVANCEMENT_REWARD),
                new LootTableProvider.SubProviderEntry(EPEntityLootTables::new, LootContextParamSets.ENTITY)
        ));
    }
}
