package com.remesthesia.untitled;

import net.fabricmc.api.ModInitializer;

import static org.jetbrains.annotations.ApiStatus.*;

@Internal
public final class UntitledFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        Untitled.init();
    }
}
