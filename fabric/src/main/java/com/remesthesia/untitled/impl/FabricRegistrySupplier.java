package com.remesthesia.untitled.impl;

import com.remesthesia.untitled.api.RegistrySupplier;

import static org.jetbrains.annotations.ApiStatus.*;

@Internal
public record FabricRegistrySupplier<T>(T src) implements RegistrySupplier<T> {
    @Override
    public T get() {
        return src;
    }
}
