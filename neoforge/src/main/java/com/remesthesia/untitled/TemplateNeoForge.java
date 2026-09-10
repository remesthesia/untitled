package com.remesthesia.untitled;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(Template.MOD_ID)
public final class TemplateNeoForge {

    public TemplateNeoForge(IEventBus eventBus) {
        Template.init();
    }
}