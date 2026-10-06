package com.remesthesia.untitled.impl;

import com.remesthesia.untitled.api.Platform;
import com.remesthesia.untitled.api.PlatformHelper;
import net.fabricmc.loader.api.FabricLoader;
import org.jetbrains.annotations.ApiStatus.Internal;

@Internal
public final class FabricPlatformHelper implements PlatformHelper {
    @Override
    public Platform getPlatform() {
        return Platform.FABRIC;
    }
}
