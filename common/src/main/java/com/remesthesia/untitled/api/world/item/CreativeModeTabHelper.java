package com.remesthesia.untitled.api.world.item;

import com.remesthesia.untitled.impl.Services;
import com.remesthesia.untitled.impl.world.item.ICreativeModeTabHelper;

public final class CreativeModeTabHelper {
    private static final ICreativeModeTabHelper INSTANCE = Services.load(ICreativeModeTabHelper.class);

    public static ICreativeModeTabHelper getInstance() {
        return INSTANCE;
    }
}
