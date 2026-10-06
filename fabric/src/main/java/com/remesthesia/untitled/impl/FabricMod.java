package com.remesthesia.untitled.impl;

import com.remesthesia.untitled.api.Mod;
import net.fabricmc.loader.api.ModContainer;

public record FabricMod(ModContainer modContainer) implements Mod {
    @Override
    public String getDescription() {
        return modContainer.getMetadata().getDescription();
    }

    @Override
    public String getID() {
        return modContainer.getMetadata().getId();
    }

    @Override
    public String getLicense() {
        for (var license : modContainer.getMetadata().getLicense()) return license;
        return "";
    }

    @Override
    public String getName() {
        return modContainer.getMetadata().getName();
    }

    @Override
    public String getVersion() {
        return modContainer.getMetadata().getVersion().getFriendlyString();
    }
}
