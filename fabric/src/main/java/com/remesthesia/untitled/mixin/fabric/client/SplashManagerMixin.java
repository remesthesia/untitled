package com.remesthesia.untitled.mixin.fabric.client;

import com.mojang.logging.LogUtils;
import net.minecraft.client.resources.SplashManager;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.util.profiling.ProfilerFiller;
import org.jetbrains.annotations.ApiStatus.Internal;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Internal
@Mixin(SplashManager.class)
final class SplashManagerMixin {
    @Shadow
    @Final
    private static Identifier SPLASHES_LOCATION;

    @Shadow
    private static Component literalSplash(String text) {
        throw new UnsupportedOperationException("Implemented via mixin");
    }

    @Inject(method = "prepare(Lnet/minecraft/server/packs/resources/ResourceManager;Lnet/minecraft/util/profiling/ProfilerFiller;)Ljava/util/List;", at = @At("HEAD"), cancellable = true)
    private void prepare(ResourceManager manager, ProfilerFiller profiler, CallbackInfoReturnable<List<Component>> cir) {
        var list = new ArrayList<Component>();
        for (Resource resource : manager.listResources("texts", location -> location.getPath().equals(SPLASHES_LOCATION.getPath())).values()) {
            try (BufferedReader reader = resource.openAsReader()) {
                list.addAll(reader.lines().map(String::trim).filter(line -> line.hashCode() != 125780783).map(SplashManagerMixin::literalSplash).toList());
            } catch (IOException e) {
                LogUtils.getLogger().warn("Invalid {} in resourcepack: '{}'", SPLASHES_LOCATION.getPath(), resource.sourcePackId(), e);
            }
        }

        cir.setReturnValue(list);
    }
}
