package net.marmar.enhanced_playthrough.datagen;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.datagen.advancement.GemAdvancementGenerator;
import net.marmar.enhanced_playthrough.datagen.advancement.SurvivalAdvancementGenerator;
import net.marmar.enhanced_playthrough.datagen.language.*;
import net.marmar.enhanced_playthrough.loot.ModGlobalLootModifiersProvider;
import net.marmar.enhanced_playthrough.tag.ModBlockTagGenerator;
import net.marmar.enhanced_playthrough.tag.ModItemTagGenerator;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = EnhancedPlaythrough.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event){
        GemAdvancementGenerator gem_advancements = new GemAdvancementGenerator();
        SurvivalAdvancementGenerator survival_advancements = new SurvivalAdvancementGenerator();

        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> LookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeServer(), new ModRecipeProvider(packOutput));
        generator.addProvider(event.includeServer(), ModLootTableProvider.create(packOutput));

        generator.addProvider(event.includeClient(), new ModBlockStateProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new ModItemModelProvider(packOutput, existingFileHelper));

        generator.addProvider(event.includeServer(), new ModWorldGenProvider(packOutput, LookupProvider));

        generator.addProvider(event.includeServer(), new ModGlobalLootModifiersProvider(packOutput));

        generator.addProvider(event.includeServer(), new ModPoiTypesTagProvider(packOutput, LookupProvider, existingFileHelper));

        generator.addProvider(event.includeServer(), new ForgeAdvancementProvider(packOutput, LookupProvider, existingFileHelper, List.of(gem_advancements, survival_advancements)));

        ModBlockTagGenerator blockTagGenerator= generator.addProvider(event.includeServer(),
        new ModBlockTagGenerator(packOutput, LookupProvider, existingFileHelper));
        generator.addProvider(event.includeServer(), new ModItemTagGenerator(packOutput, LookupProvider, blockTagGenerator.contentsGetter(),
                existingFileHelper));

        //Languages
        generator.addProvider(event.includeClient(), new EnglishLanguageProvider(packOutput));
        generator.addProvider(event.includeClient(), new ArgentinianLanguageProvider(packOutput));
        generator.addProvider(event.includeClient(), new UruguayanLanguageProvider(packOutput));
        generator.addProvider(event.includeClient(), new ChileanLanguageProvider(packOutput));
        generator.addProvider(event.includeClient(), new EcuatorianLanguageProvider(packOutput));
        generator.addProvider(event.includeClient(), new SpanishLanguageProvider(packOutput));
        generator.addProvider(event.includeClient(), new MexicanLanguageProvider(packOutput));
        generator.addProvider(event.includeClient(), new VenezuelanLanguageProvider(packOutput));

    }
}
