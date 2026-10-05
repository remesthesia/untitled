package com.remesthesia.untitled;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;

public final class UntitledFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        Untitled.init();
        CreativeModeTabEvents.modifyOutputEvent().register((tab) -> tab.insertaf());
    }
}
