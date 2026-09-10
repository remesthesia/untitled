package com.remesthesia.untitled.api;

import com.remesthesia.untitled.impl.IPlatformHelper;
import com.remesthesia.untitled.impl.Services;

public final class PlatformHelper {
    private static final IPlatformHelper INSTANCE = Services.load(IPlatformHelper.class);

    public static IPlatformHelper getInstance() {
        return INSTANCE;
    }
}
