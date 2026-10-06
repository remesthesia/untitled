package com.remesthesia.untitled;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(Untitled.MOD_ID)
public final class UntitledNeoForge {

    public UntitledNeoForge(IEventBus eventBus) {
        Untitled.init();
    }
}