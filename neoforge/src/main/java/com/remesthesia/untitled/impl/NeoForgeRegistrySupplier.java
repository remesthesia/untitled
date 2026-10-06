package com.remesthesia.untitled.impl;

import com.remesthesia.untitled.api.RegistrySupplier;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.ApiStatus;

import static org.jetbrains.annotations.ApiStatus.*;

@Internal
public record NeoForgeRegistrySupplier<T>(DeferredHolder<? super T, T> src) implements RegistrySupplier<T> {
    @Override
    public T get() {
        return src.get();
    }
}
