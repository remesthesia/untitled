package com.remesthesia.template.platform;

import com.remesthesia.template.Template;
import com.remesthesia.template.platform.services.IPlatformHelper;

import java.util.ServiceLoader;

public final class Services {
    public static final IPlatformHelper PLATFORM = load(IPlatformHelper.class);

    public static <T> T load(Class<T> clazz) {
        final T loadedService = ServiceLoader.load(clazz, Services.class.getClassLoader())
                .findFirst()
                .orElseThrow(() -> new NullPointerException("Failed to load service for " + clazz.getName()));

        Template.LOGGER.debug("Loaded {} for service {}", loadedService, clazz);
        return loadedService;
    }
}