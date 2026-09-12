package com.remesthesia.untitled.impl;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.HashMap;
import java.util.function.Function;
import java.util.function.Supplier;

public final class NeoForgeRegistryHelper implements IRegistryHelper {
    private static final HashMap<String, HashMap<Registry<?>, DeferredRegister<?>>> NAMESPACE_TO_REGISTRY_MAP = new HashMap<>();

    @SuppressWarnings("unchecked")
    @Override
    public <T> Holder<T> register(final Registry<T> registry, final Identifier id, final Function<Identifier, ? extends T> item) {
        final var REGISTRY_TO_REGISTER_MAP = NAMESPACE_TO_REGISTRY_MAP.computeIfAbsent(id.getNamespace(), _ -> new HashMap<>());
        final var REGISTER = (DeferredRegister<T>) REGISTRY_TO_REGISTER_MAP.computeIfAbsent(registry, _ -> DeferredRegister.create(registry, id.getNamespace()));

        return REGISTER.register(id.getPath(), item);
    }

    public Holder<Block> registerBlock(final Identifier id, final Function<BlockBehaviour.Properties, ? extends Block> block, final Supplier<BlockBehaviour.Properties> properties) {
        final var REGISTRY_TO_REGISTER_MAP = NAMESPACE_TO_REGISTRY_MAP.computeIfAbsent(id.getNamespace(), _ -> new HashMap<>());
        final var REGISTER = (DeferredRegister.Blocks) REGISTRY_TO_REGISTER_MAP.computeIfAbsent(BuiltInRegistries.BLOCK, _ -> DeferredRegister.createBlocks(id.getNamespace()));

        return REGISTER.registerBlock(id.getPath(), block, properties);
    }

    public void registerAll(IEventBus eventBus) {
        for(HashMap<Registry<?>, DeferredRegister<?>> REGISTRY_TO_REGISTER_MAP : NAMESPACE_TO_REGISTRY_MAP.values()) {
            for(DeferredRegister<?> REGISTER : REGISTRY_TO_REGISTER_MAP.values()) {
                REGISTER.register(eventBus);
            }
        }
    }
}
