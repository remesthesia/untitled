package com.remesthesia.untitled.client;

import net.fabricmc.api.ClientModInitializer;
import org.jetbrains.annotations.ApiStatus.Internal;

@Internal
public final class UntitledFabricClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        UntitledClient.init();
    }
}
