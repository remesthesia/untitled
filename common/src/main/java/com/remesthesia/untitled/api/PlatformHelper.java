package com.remesthesia.untitled.api;

import com.remesthesia.untitled.impl.Services;

public interface PlatformHelper {
    static PlatformHelper getInstance() {
        return Services.PLATFORM_HELPER_INSTANCE;
    }

    Platform getPlatform();
}
