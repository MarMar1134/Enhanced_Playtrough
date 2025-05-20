package net.marmar.enhanced_playthrough.worldgen.structure;

import com.mojang.datafixers.util.Either;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.DynamicOps;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.pools.SinglePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.templatesystem.*;

import java.util.Optional;

public class ModSinglePoolElement extends SinglePoolElement {
    private static final Codec<Either<ResourceLocation, StructureTemplate>> TEMPLATE_CODEC;
    public static final Codec<ModSinglePoolElement> CODEC;
    protected final Optional<String> name;
    protected final Either<ResourceLocation, StructureTemplate> template;
    protected final Holder<StructureProcessorList> processors;

    private static <T> DataResult<T> encodeTemplate(Either<ResourceLocation, StructureTemplate> pTemplate, DynamicOps<T> tDynamicOps, T pParam) {
        Optional<ResourceLocation> resourceLocation = pTemplate.left();
        return resourceLocation.isEmpty() ? DataResult.error(() -> "Can not serialize a runtime pool element") : ResourceLocation.CODEC.encode(resourceLocation.get(), tDynamicOps, pParam);
    }

    protected static <E extends ModSinglePoolElement> RecordCodecBuilder<E, Holder<StructureProcessorList>> modProcessorsCodec() {
        return StructureProcessorType.LIST_CODEC.fieldOf("processors").forGetter(ModSinglePoolElement::getProcessors);
    }

    protected static <E extends ModSinglePoolElement> RecordCodecBuilder<E, Either<ResourceLocation, StructureTemplate>> modTemplateCodec() {
        return TEMPLATE_CODEC.fieldOf("location").forGetter(ModSinglePoolElement::getTemplate);
    }

    protected static <E extends ModSinglePoolElement> RecordCodecBuilder<E, Optional<String>> nameCodec(){
        return Codec.STRING.optionalFieldOf("name").forGetter(ModSinglePoolElement::getName);
    }

    public ModSinglePoolElement(Optional<String> pName, Either<ResourceLocation, StructureTemplate> pEither, Holder<StructureProcessorList> pHolder, StructureTemplatePool.Projection pProjection) {
        super(pEither, pHolder, pProjection);
        this.name = pName;
        this.template = pEither;
        this.processors = pHolder;
    }

    public Optional<String> getName(){
        return this.name;
    }

    public Either<ResourceLocation, StructureTemplate> getTemplate() {
        return this.template;
    }

    public Holder<StructureProcessorList> getProcessors() {
        return this.processors;
    }

    static {
        TEMPLATE_CODEC = Codec.of(ModSinglePoolElement::encodeTemplate, ResourceLocation.CODEC.map(Either::left));
        CODEC = RecordCodecBuilder.create((elementInstance) -> elementInstance.group(nameCodec(), modTemplateCodec(), modProcessorsCodec(), projectionCodec()).apply(elementInstance, ModSinglePoolElement::new));
    }
}
