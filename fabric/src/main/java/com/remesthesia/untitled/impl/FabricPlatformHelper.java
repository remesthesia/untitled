package com.remesthesia.untitled.impl;

import com.remesthesia.untitled.api.Platform;

public final class FabricPlatformHelper implements IPlatformHelper{

    @Override
    public Platform getPlatform() {
        return Platform.Fabric;
    }
}
