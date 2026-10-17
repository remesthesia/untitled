package com.remesthesia.untitled.impl;

import com.remesthesia.untitled.Untitled;
import com.remesthesia.untitled.api.PlatformHelper;

import java.util.ServiceLoader;

import static org.jetbrains.annotations.ApiStatus.*;

@Internal
public final class Services {
    public static PlatformHelper PLATFORM_HELPER_INSTANCE = Services.load(PlatformHelper.class);

    public static <T> T load(Class<T> clazz) {
        final T loadedService = ServiceLoader.load(clazz, Services.class.getClassLoader())
                .findFirst()
                .orElseThrow(() -> new NullPointerException("Failed to load service for " + clazz.getName()));

        Untitled.LOGGER.debug("Loaded {} for service {}", loadedService, clazz);
        return loadedService;
    }
}