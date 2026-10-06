package com.remesthesia.untitled.impl;

import com.remesthesia.untitled.api.Environment;
import com.remesthesia.untitled.api.Mod;
import com.remesthesia.untitled.api.Platform;
import com.remesthesia.untitled.api.PlatformHelper;
import net.fabricmc.api.EnvType;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.impl.FabricLoaderImpl;
import net.fabricmc.loader.impl.game.minecraft.MinecraftGameProvider;
import org.jetbrains.annotations.ApiStatus.Internal;

import java.nio.file.Path;
import java.util.Optional;

@Internal
public final class FabricPlatformHelper implements PlatformHelper {
    @Override
    public Path getConfigDirectory() {
        return FabricLoader.getInstance().getConfigDir();
    }

    @Override
    public Environment getEnvironment() {
        return FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT ? Environment.Client : Environment.Server;
    }

    @Override
    public Path getGameDirectory() {
        return FabricLoader.getInstance().getGameDir();
    }

    @Override
    public String getGameVersion() {
        return FabricLoader.getInstance().getRawGameVersion();
    }

    @Override
    public Optional<Mod> getMod(String modID) {
        var modContainer = FabricLoader.getInstance().getModContainer(modID);
        return modContainer.map(FabricMod::new);
    }

    @Override
    public Platform getPlatform() {
        return Platform.FABRIC;
    }

    @Override
    public boolean isDevelopmentEnvironment() {
        return FabricLoader.getInstance().isDevelopmentEnvironment();
    }

    @Override
    public boolean isModLoaded(String modID) {
        return FabricLoader.getInstance().isModLoaded(modID);
    }
}
