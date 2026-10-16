package com.remesthesia.template;

import net.fabricmc.api.ModInitializer;

import static org.jetbrains.annotations.ApiStatus.*;

@Internal
public final class TemplateFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        Template.init();
    }
}
