package com.remesthesia.untitled.impl;

import com.remesthesia.untitled.api.Environment;
import com.remesthesia.untitled.api.Mod;
import com.remesthesia.untitled.api.Platform;
import com.remesthesia.untitled.api.PlatformHelper;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.ModList;
import net.neoforged.fml.loading.FMLLoader;
import net.neoforged.fml.loading.FMLPaths;
import org.jetbrains.annotations.ApiStatus.Internal;

import javax.swing.text.html.Option;
import java.nio.file.Path;
import java.util.Optional;

@Internal
public final class NeoForgePlatformHelper implements PlatformHelper {
    @Override
    public Path getConfigDirectory() {
        return FMLPaths.CONFIGDIR.get();
    }

    @Override
    public Environment getEnvironment() {
        return FMLLoader.getCurrent().getDist() == Dist.CLIENT ? Environment.Client : Environment.Server;
    }

    @Override
    public Path getGameDirectory() {
        return FMLPaths.GAMEDIR.get();
    }

    @Override
    public String getGameVersion() {
        return FMLLoader.getCurrent().getVersionInfo().mcVersion();
    }

    @Override
    public Optional<Mod> getMod(String modID) {
        return ModList.get().getModContainerById(modID).map(modContainer -> new NeoForgeMod(modContainer, ModList.get().getModFileById(modID)));
    }

    @Override
    public Platform getPlatform() {
        return Platform.NEOFORGE;
    }

    @Override
    public boolean isDevelopmentEnvironment() {
        return !FMLLoader.getCurrent().isProduction();
    }

    @Override
    public boolean isModLoaded(String modID) {
        return ModList.get().isLoaded(modID);
    }
}
