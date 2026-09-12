package com.remesthesia.untitled;

import com.remesthesia.untitled.api.RegistryHelper;
import com.remesthesia.untitled.impl.NeoForgeRegistryHelper;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(Untitled.MOD_ID)
public final class UntitledNeoForge {

    public UntitledNeoForge(IEventBus eventBus) {
        Untitled.init();

        ((NeoForgeRegistryHelper) RegistryHelper.getInstance()).registerAll(eventBus);
    }
}