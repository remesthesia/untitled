package com.remesthesia.untitled.impl;

import com.remesthesia.untitled.Untitled;
import com.remesthesia.untitled.api.PlatformHelper;
import com.remesthesia.untitled.api.RegistryHelper;
import com.remesthesia.untitled.api.world.item.ItemHelper;

import java.util.ServiceLoader;

import static org.jetbrains.annotations.ApiStatus.*;

@Internal
public final class UntitledServices {
    public static final ItemHelper ITEM_HELPER_INSTANCE  = UntitledServices.load(ItemHelper.class);
    public static final PlatformHelper PLATFORM_HELPER_INSTANCE = UntitledServices.load(PlatformHelper.class);
    public static final RegistryHelper REGISTRY_HELPER_INSTANCE = UntitledServices.load(RegistryHelper.class);

    public static <T> T load(Class<T> clazz) {
        final var instance = ServiceLoader.load(clazz, UntitledServices.class.getClassLoader())
                .findFirst()
                .orElseThrow(() -> new NullPointerException("Failed to load service for " + clazz.getName()));

        Untitled.LOGGER.debug("Loaded {} for service {}", instance, clazz);
        return instance;
    }
}
