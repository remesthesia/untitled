package com.remesthesia.untitled;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import org.jetbrains.annotations.ApiStatus.Internal;

@Internal
@Mod(Untitled.MOD_ID)
public final class UntitledNeoForge {

    public UntitledNeoForge(IEventBus eventBus) {
        Untitled.init();
    }
}