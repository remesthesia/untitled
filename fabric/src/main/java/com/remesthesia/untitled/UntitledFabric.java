package com.remesthesia.untitled;

import net.fabricmc.api.ModInitializer;
import org.jetbrains.annotations.ApiStatus.Internal;

@Internal
public final class UntitledFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        Untitled.init();
    }
}
