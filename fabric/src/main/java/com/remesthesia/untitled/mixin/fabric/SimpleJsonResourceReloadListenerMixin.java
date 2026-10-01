package com.remesthesia.untitled.mixin.fabric;

import com.google.gson.JsonElement;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DynamicOps;
import com.remesthesia.untitled.Untitled;
import com.remesthesia.untitled.api.resource.SimpleJsonResourceModifier;
import net.minecraft.resources.FileToIdConverter;
import net.minecraft.resources.Identifier;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimpleJsonResourceReloadListener;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import java.io.Reader;
import java.util.Map;

@Mixin(SimpleJsonResourceReloadListener.class)
public final class SimpleJsonResourceReloadListenerMixin {
    @WrapOperation(
            method = "scanDirectory(Lnet/minecraft/server/packs/resources/ResourceManager;Lnet/minecraft/resources/FileToIdConverter;Lcom/mojang/serialization/DynamicOps;Lcom/mojang/serialization/Codec;Ljava/util/Map;)V",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/util/StrictJsonParser;parse(Ljava/io/Reader;)Lcom/google/gson/JsonElement;"
            )
    )
    private static <T> JsonElement scanDirectory(Reader reader, Operation<JsonElement> original, ResourceManager manager, FileToIdConverter lister, DynamicOps<JsonElement> ops, Codec<T> codec, Map<Identifier, T> result, @Local(name = "entry") Map.Entry<Identifier, Resource> entry, @Local(name = "id") Identifier id) {
        return SimpleJsonResourceModifier.run(lister.prefix(), id, original.call(reader));
    }
}
