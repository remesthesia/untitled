package com.remesthesia.untitled.impl;

import com.remesthesia.untitled.api.Environment;
import com.remesthesia.untitled.api.Platform;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.loading.FMLLoader;

public final class NeoForgePlatformHelper implements IPlatformHelper{

    @Override
    public boolean isDevelopmentEnvironment() {
        return !FMLLoader.getCurrent().isProduction();
    }

    @Override
    public Environment getEnvironment() {
        return FMLLoader.getCurrent().getDist() == Dist.CLIENT ? Environment.Client : Environment.Server;
    }

    @Override
    public Platform getPlatform() {
        return Platform.NEOFORGE;
    }
}
