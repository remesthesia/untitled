package com.remesthesia.untitled.api;

import com.remesthesia.untitled.impl.Services;

import java.nio.file.Path;

public interface PlatformHelper {
    static PlatformHelper getInstance() {
        return Services.PLATFORM_HELPER_INSTANCE;
    }

    Path getConfigDirectory();
    Environment getEnvironment();
    Path getGameDirectory();
    String getGameVersion();
    Platform getPlatform();
    boolean isDevelopmentEnvironment();
    boolean isModLoaded(String modID);
}
