package com.remesthesia.untitled;

import net.fabricmc.api.ModInitializer;

public final class TemplateFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        Template.init();
    }
}
