package com.remesthesia.untitled.api;

import com.remesthesia.untitled.impl.IRegistryHelper;
import com.remesthesia.untitled.impl.Services;
import net.minecraft.world.item.CreativeModeTab;

public final class RegistryHelper {
    private static final IRegistryHelper INSTANCE = Services.load(IRegistryHelper.class);

    public static IRegistryHelper getInstance() {
        return INSTANCE;
    }
}
