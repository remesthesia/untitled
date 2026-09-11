package com.remesthesia.untitled.impl;

import com.remesthesia.untitled.api.Environment;
import com.remesthesia.untitled.api.Platform;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.loading.FMLLoader;

import java.nio.file.Path;

public final class NeoForgePlatformHelper implements IPlatformHelper {

    @Override
    public boolean isDevelopmentEnvironment() {
        return !FMLLoader.getCurrent().isProduction();
    }

    @Override
    public Environment getEnvironment() {
        return FMLLoader.getCurrent().getDist() == Dist.CLIENT ? Environment.Client : Environment.Server;
    }

    @Override
    public Path getDirectory() {
        return FMLLoader.getCurrent().getGameDir();
    }

    @Override
    public Platform getPlatform() {
        return Platform.NEOFORGE;
    }
}
