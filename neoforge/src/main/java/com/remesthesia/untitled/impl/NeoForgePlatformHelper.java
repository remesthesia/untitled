package com.remesthesia.untitled.impl;

import com.remesthesia.untitled.api.Platform;
import com.remesthesia.untitled.api.PlatformHelper;
import org.jetbrains.annotations.ApiStatus.Internal;

@Internal
public final class NeoForgePlatformHelper implements PlatformHelper {
    @Override
    public Platform getPlatform() {
        return Platform.NEOFORGE;
    }
}
