package com.remesthesia.untitled.client;

import com.remesthesia.untitled.Template;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(value = Template.MOD_ID, dist = Dist.CLIENT)
public final class TemplateNeoForgeClient {

    public TemplateNeoForgeClient(IEventBus eventBus) {
        TemplateClient.init();
    }
}