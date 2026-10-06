package com.remesthesia.untitled;

import com.remesthesia.untitled.api.RegistryHelper;
import com.remesthesia.untitled.impl.NeoForgeRegistryHelper;
import com.remesthesia.untitled.impl.Services;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import org.jetbrains.annotations.ApiStatus.Internal;

@Internal
@Mod(Untitled.MOD_ID)
public final class UntitledNeoForge {

    public UntitledNeoForge(IEventBus eventBus) {
        Untitled.init();
        ((NeoForgeRegistryHelper)RegistryHelper.getInstance()).registerAll(eventBus);
    }
}