package net.marmar.enhanced_playthrough.data;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.data.advancement.GemAdvancementGenerator;
import net.marmar.enhanced_playthrough.data.advancement.SurvivalAdvancementGenerator;
import net.marmar.enhanced_playthrough.data.lang.*;
import net.marmar.enhanced_playthrough.data.loottable.modifier.EPGlobalLootModifiersProvider;
import net.marmar.enhanced_playthrough.data.loottable.EPLootTableProvider;
import net.marmar.enhanced_playthrough.data.model.EPBlockStateProvider;
import net.marmar.enhanced_playthrough.data.model.EPItemModelProvider;
import net.marmar.enhanced_playthrough.data.recipe.EPRecipeProvider;
import net.marmar.enhanced_playthrough.data.tag.*;
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
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> LookupProvider = event.getLookupProvider();

        //Worldgen
        generator.addProvider(event.includeServer(), new EPDataPackProvider(packOutput, LookupProvider));

        //Advancements
        GemAdvancementGenerator gem_advancements = new GemAdvancementGenerator();
        SurvivalAdvancementGenerator survival_advancements = new SurvivalAdvancementGenerator();
        generator.addProvider(event.includeServer(), new ForgeAdvancementProvider(packOutput, LookupProvider, existingFileHelper,
                List.of(gem_advancements, survival_advancements)));

        //Recipes
        generator.addProvider(event.includeServer(), new EPRecipeProvider(packOutput));

        //Loot tables
        generator.addProvider(event.includeServer(), EPLootTableProvider.create(packOutput));
        generator.addProvider(event.includeServer(), new EPGlobalLootModifiersProvider(packOutput));

        //Models
        generator.addProvider(event.includeClient(), new EPBlockStateProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new EPItemModelProvider(packOutput, existingFileHelper));

        //POI types
        generator.addProvider(event.includeServer(), new EPPoiTypesTagProvider(packOutput, LookupProvider, existingFileHelper));

        //Tags
        EPBlockTagGenerator blockTagGenerator = generator.addProvider(event.includeServer(),
                new EPBlockTagGenerator(packOutput, LookupProvider, existingFileHelper));
        generator.addProvider(event.includeServer(), new EPItemTagGenerator(packOutput, LookupProvider, blockTagGenerator.contentsGetter(),
                existingFileHelper));
        generator.addProvider(event.includeServer(), new EPBiomeTagGenerator(packOutput, LookupProvider, existingFileHelper));

        //Languages
        generator.addProvider(event.includeClient(), new EnglishLangProvider(packOutput));
        generator.addProvider(event.includeClient(), new ArgentinianLangProvider(packOutput));
        generator.addProvider(event.includeClient(), new UruguayanLangProvider(packOutput));
        generator.addProvider(event.includeClient(), new ChileanLangProvider(packOutput));
        generator.addProvider(event.includeClient(), new EcuadorianLangProvider(packOutput));
        generator.addProvider(event.includeClient(), new SpanishLangProvider(packOutput));
        generator.addProvider(event.includeClient(), new MexicanLangProvider(packOutput));
        generator.addProvider(event.includeClient(), new VenezuelanLangProvider(packOutput));
    }
}
