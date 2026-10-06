package com.remesthesia.untitled.api;

import com.remesthesia.untitled.impl.Services;

public interface RegistryHelper {
     static RegistryHelper getInstance() {
        return Services.REGISTRY_HELPER_INSTANCE;
    }
}
