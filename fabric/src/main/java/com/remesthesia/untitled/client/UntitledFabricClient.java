package com.remesthesia.untitled.client;

import net.fabricmc.api.ClientModInitializer;

public final class UntitledFabricClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        UntitledClient.init();
    }
}
