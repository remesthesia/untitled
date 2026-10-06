package com.remesthesia.untitled.impl;

import com.remesthesia.untitled.api.RegistryHelper;
import com.remesthesia.untitled.api.RegistrySupplier;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.ApiStatus.Internal;

import java.util.HashMap;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

@Internal
public final class NeoForgeRegistryHelper implements RegistryHelper {
    private static final HashMap<String, HashMap<Registry<?>, DeferredRegister<?>>> NAMESPACE_TO_REGISTRY_MAP = new HashMap<>();

    @Override
    public <T> RegistrySupplier<T> register(Registry<? super T> registry, Identifier id, Supplier<? extends T> item) {
        return new NeoForgeRegistrySupplier<>(getRegister(id.getNamespace(), registry).register(id.getPath(), item));
    }

    @Override
    public <T> RegistrySupplier<T> register(Registry<? super T> registry, Identifier id, Function<Identifier, ? extends T> item) {
        return new NeoForgeRegistrySupplier<>(getRegister(id.getNamespace(), registry).register(id.getPath(), item));
    }

    @Override
    public <T extends Block> RegistrySupplier<T> registerBlock(Identifier id, Function<BlockBehaviour.Properties, ? extends T> block, Supplier<BlockBehaviour.Properties> properties) {
        final var REGISTRY_TO_REGISTER_MAP = NAMESPACE_TO_REGISTRY_MAP.computeIfAbsent(id.getNamespace(), _ -> new HashMap<>());
        final var REGISTER = (DeferredRegister.Blocks)REGISTRY_TO_REGISTER_MAP.computeIfAbsent(BuiltInRegistries.BLOCK, _ -> DeferredRegister.createBlocks(id.getNamespace()));

        return new NeoForgeRegistrySupplier<>(REGISTER.registerBlock(id.getPath(), block, properties));
    }

    @Override
    public <T extends Item> RegistrySupplier<T> registerItem(Identifier id, Function<Item.Properties, ? extends T> item, Supplier<Item.Properties> properties) {
        final var REGISTRY_TO_REGISTER_MAP = NAMESPACE_TO_REGISTRY_MAP.computeIfAbsent(id.getNamespace(), _ -> new HashMap<>());
        final var REGISTER = (DeferredRegister.Items)REGISTRY_TO_REGISTER_MAP.computeIfAbsent(BuiltInRegistries.ITEM, _ -> DeferredRegister.createItems(id.getNamespace()));

        return new NeoForgeRegistrySupplier<>(REGISTER.registerItem(id.getPath(), item, properties));
    }

    @Override
    public <T> RegistrySupplier<DataComponentType<T>> registerDataComponentType(Identifier id, UnaryOperator<DataComponentType.Builder<T>> builder) {
        final var REGISTRY_TO_REGISTER_MAP = NAMESPACE_TO_REGISTRY_MAP.computeIfAbsent(id.getNamespace(), _ -> new HashMap<>());
        final var REGISTER = (DeferredRegister.DataComponents)REGISTRY_TO_REGISTER_MAP.computeIfAbsent(BuiltInRegistries.DATA_COMPONENT_TYPE, _ -> DeferredRegister.createDataComponents(Registries.DATA_COMPONENT_TYPE, id.getNamespace()));

        return new NeoForgeRegistrySupplier<>(REGISTER.registerComponentType(id.getPath(), builder));
    }

    @Override
    public <T extends Entity> RegistrySupplier<EntityType<T>> registerEntityType(Identifier id, EntityType.EntityFactory<T> factory, MobCategory category, UnaryOperator<EntityType.Builder<T>> builder) {
        final var REGISTRY_TO_REGISTER_MAP = NAMESPACE_TO_REGISTRY_MAP.computeIfAbsent(id.getNamespace(), _ -> new HashMap<>());
        final var REGISTER = (DeferredRegister.Entities)REGISTRY_TO_REGISTER_MAP.computeIfAbsent(BuiltInRegistries.ENTITY_TYPE, _ -> DeferredRegister.createEntities(id.getNamespace()));

        return new NeoForgeRegistrySupplier<>(REGISTER.registerEntityType(id.getPath(), factory, category, builder));
    }


    @SuppressWarnings("unchecked")
    private <T> DeferredRegister<T> getRegister(String namespace, Registry<T> registry) {
        final var REGISTRY_TO_REGISTER_MAP = NAMESPACE_TO_REGISTRY_MAP.computeIfAbsent(namespace, _ -> new HashMap<>());
        return (DeferredRegister<T>)REGISTRY_TO_REGISTER_MAP.computeIfAbsent(registry, _ -> DeferredRegister.create(registry,  namespace));
    }

    public void registerAll(IEventBus eventBus) {
        for(var REGISTRY_TO_REGISTER_MAP : NAMESPACE_TO_REGISTRY_MAP.values()) {
            for(DeferredRegister<?> REGISTER : REGISTRY_TO_REGISTER_MAP.values()) {
                REGISTER.register(eventBus);
            }
        }
    }
}
