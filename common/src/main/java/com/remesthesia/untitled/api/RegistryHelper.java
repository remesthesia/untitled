package com.remesthesia.untitled.api;

import com.remesthesia.untitled.impl.Services;
import net.minecraft.core.Registry;
import net.minecraft.resources.Identifier;

import java.util.function.Function;
import java.util.function.Supplier;

public interface RegistryHelper {
     static RegistryHelper getInstance() {
        return Services.REGISTRY_HELPER_INSTANCE;
    }

    <T> RegistrySupplier<T> register(final Registry<? super T> registry, final Identifier id, final Supplier<? extends T> item);
    <T> RegistrySupplier<T> register(final Registry<? super T> registry, final Identifier id, final Function<Identifier, ? extends T> item);
}
