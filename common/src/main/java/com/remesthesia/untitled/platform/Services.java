package com.remesthesia.untitled.platform;

import com.remesthesia.untitled.Untitled;
import com.remesthesia.untitled.platform.services.IPlatformHelper;

import java.util.ServiceLoader;

public final class Services {
    public static final IPlatformHelper PLATFORM = load(IPlatformHelper.class);

    public static <T> T load(Class<T> clazz) {
        final T loadedService = ServiceLoader.load(clazz, Services.class.getClassLoader())
                .findFirst()
                .orElseThrow(() -> new NullPointerException("Failed to load service for " + clazz.getName()));

        Untitled.LOGGER.debug("Loaded {} for service {}", loadedService, clazz);
        return loadedService;
    }
}