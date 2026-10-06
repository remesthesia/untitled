package com.remesthesia.untitled.impl;

import com.remesthesia.untitled.api.RegistryHelper;
import com.remesthesia.untitled.api.RegistrySupplier;
import net.minecraft.core.Registry;
import net.minecraft.resources.Identifier;

import java.util.function.Function;
import java.util.function.Supplier;

import static org.jetbrains.annotations.ApiStatus.*;

@Internal
public final class FabricRegistryHelper implements RegistryHelper {

    @Override
    public <T> RegistrySupplier<T> register(Registry<? super T> registry, Identifier id, Supplier<? extends T> item) {
        return new FabricRegistrySupplier<>(Registry.register(registry, id, item.get()));
    }

    @Override
    public <T> RegistrySupplier<T> register(Registry<? super T> registry, Identifier id, Function<Identifier, ? extends T> item) {
        return new FabricRegistrySupplier<>(Registry.register(registry, id, item.apply(id)));
    }
}
