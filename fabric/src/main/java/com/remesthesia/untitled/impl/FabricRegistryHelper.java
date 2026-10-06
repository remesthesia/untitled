package com.remesthesia.untitled.impl;

import com.remesthesia.untitled.api.RegistryHelper;
import com.remesthesia.untitled.api.RegistrySupplier;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

import static org.jetbrains.annotations.ApiStatus.Internal;

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

    @Override
    public <T extends Block> RegistrySupplier<T> registerBlock(Identifier id, Function<BlockBehaviour.Properties, ? extends T> block, Supplier<BlockBehaviour.Properties> properties) {
        return new FabricRegistrySupplier<>(Registry.register(BuiltInRegistries.BLOCK, id, block.apply(properties.get().setId(ResourceKey.create(Registries.BLOCK, id)))));
    }

    @Override
    public <T extends Item> RegistrySupplier<T> registerItem(Identifier id, Function<Item.Properties, ? extends T> item, Supplier<Item.Properties> properties) {
        return new FabricRegistrySupplier<>(Registry.register(BuiltInRegistries.ITEM, id, item.apply(properties.get().setId(ResourceKey.create(Registries.ITEM, id)))));
    }

    @Override
    public <T> RegistrySupplier<DataComponentType<T>> registerDataComponentType(Identifier id, UnaryOperator<DataComponentType.Builder<T>> builder) {
        return new FabricRegistrySupplier<>(Registry.register(BuiltInRegistries.DATA_COMPONENT_TYPE, id, builder.apply(DataComponentType.builder()).build()));
    }

    @Override
    public <T extends Entity> RegistrySupplier<EntityType<T>> registerEntityType(Identifier id, EntityType.EntityFactory<T> factory, MobCategory category, UnaryOperator<EntityType.Builder<T>> builder) {
        return new FabricRegistrySupplier<>(Registry.register(BuiltInRegistries.ENTITY_TYPE, id, builder.apply(EntityType.Builder.of(factory, category)).build(ResourceKey.create(Registries.ENTITY_TYPE, id))));
    }
}
