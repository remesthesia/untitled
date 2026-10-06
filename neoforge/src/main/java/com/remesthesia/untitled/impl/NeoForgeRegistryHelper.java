package com.remesthesia.untitled.impl;

import com.remesthesia.untitled.api.RegistryHelper;
import com.remesthesia.untitled.api.RegistrySupplier;
import net.minecraft.core.Registry;
import net.minecraft.resources.Identifier;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.ApiStatus.Internal;

import java.util.HashMap;
import java.util.function.Function;
import java.util.function.Supplier;

@Internal
public final class NeoForgeRegistryHelper implements RegistryHelper {
    private static final HashMap<String, HashMap<Registry<?>, DeferredRegister<?>>> NAMESPACE_TO_REGISTRY_MAP = new HashMap<>();

    @Override
    public <T> RegistrySupplier<T> register(Registry<? super T> registry, Identifier id, Supplier<? extends T> item) {
        final var REGISTER = getRegister(id.getNamespace(), registry);
        return new NeoForgeRegistrySupplier<>(REGISTER.register(id.getPath(), item));
    }

    @Override
    public <T> RegistrySupplier<T> register(Registry<? super T> registry, Identifier id, Function<Identifier, ? extends T> item) {
        final var REGISTER = getRegister(id.getNamespace(), registry);
        return new NeoForgeRegistrySupplier<>(REGISTER.register(id.getPath(), item));
    }

    @SuppressWarnings("unchecked")
    private <T> DeferredRegister<T> getRegister(String namespace, Registry<T> registry) {
        final var REGISTRY_TO_REGISTER_MAP = NAMESPACE_TO_REGISTRY_MAP.computeIfAbsent(namespace, _ -> new HashMap<>());
        return (DeferredRegister<T>)REGISTRY_TO_REGISTER_MAP.computeIfAbsent(registry, _ -> DeferredRegister.create(registry,  namespace));
    }

    public void registerAll(IEventBus eventBus) {
        for(HashMap<Registry<?>, DeferredRegister<?>> REGISTRY_TO_REGISTER_MAP : NAMESPACE_TO_REGISTRY_MAP.values()) {
            for(DeferredRegister<?> REGISTER : REGISTRY_TO_REGISTER_MAP.values()) {
                REGISTER.register(eventBus);
            }
        }
    }
}
