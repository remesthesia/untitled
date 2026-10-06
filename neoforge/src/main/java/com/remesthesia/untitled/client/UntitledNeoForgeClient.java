package com.remesthesia.untitled.client;

import com.remesthesia.untitled.Untitled;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import org.jetbrains.annotations.ApiStatus.Internal;

@Internal
@Mod(value = Untitled.MOD_ID, dist = Dist.CLIENT)
public final class UntitledNeoForgeClient {
    public UntitledNeoForgeClient(IEventBus eventBus) {
        UntitledClient.init();
    }
}