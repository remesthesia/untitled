package com.remesthesia.untitled.impl;

import com.remesthesia.untitled.api.Mod;
import net.neoforged.fml.ModContainer;
import net.neoforged.neoforgespi.language.IModFileInfo;

public record NeoForgeMod(ModContainer modContainer, IModFileInfo modFileInfo) implements Mod {
    @Override
    public String getDescription() {
        return modContainer.getModInfo().getDescription();
    }

    @Override
    public String getID() {
        return modContainer.getModId();
    }

    @Override
    public String getLicense() {
        return modFileInfo.getLicense();
    }

    @Override
    public String getName() {
        return modContainer.getModInfo().getDisplayName();
    }

    @Override
    public String getVersion() {
        return modFileInfo.versionString();
    }
}
