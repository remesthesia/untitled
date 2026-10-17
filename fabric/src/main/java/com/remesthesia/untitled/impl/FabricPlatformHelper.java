package com.remesthesia.untitled.impl;

import com.remesthesia.untitled.api.Platform;
import com.remesthesia.untitled.api.PlatformHelper;

import static org.jetbrains.annotations.ApiStatus.*;

@Internal
public final class FabricPlatformHelper implements PlatformHelper {
    @Override
    public Platform getPlatform() {
        return Platform.Fabric;
    }
}
