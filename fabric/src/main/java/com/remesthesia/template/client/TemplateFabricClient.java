package com.remesthesia.template.client;

import net.fabricmc.api.ClientModInitializer;

public final class TemplateFabricClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        TemplateClient.init();
    }
}
