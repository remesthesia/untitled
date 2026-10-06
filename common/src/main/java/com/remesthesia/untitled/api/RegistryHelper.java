package com.remesthesia.untitled.api;

import com.remesthesia.untitled.impl.Services;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public interface RegistryHelper {
     static RegistryHelper getInstance() {
        return Services.REGISTRY_HELPER_INSTANCE;
    }

    <T> RegistrySupplier<T> register(final Registry<? super T> registry, final Identifier id, final Supplier<? extends T> item);
    <T> RegistrySupplier<T> register(final Registry<? super T> registry, final Identifier id, final Function<Identifier, ? extends T> item);

    <T extends Block> RegistrySupplier<T> registerBlock(final Identifier id, Function<BlockBehaviour.Properties, ? extends T> block, final Supplier<BlockBehaviour.Properties> properties);

    <T extends Item> RegistrySupplier<T> registerItem(final Identifier id, Function<Item.Properties, ? extends T> item, final Supplier<Item.Properties> properties);

    <T> RegistrySupplier<DataComponentType<T>> registerDataComponentType(final Identifier id, final UnaryOperator<DataComponentType.Builder<T>> builder);

    <T extends Entity> RegistrySupplier<EntityType<T>> registerEntityType(final Identifier id, final EntityType.EntityFactory<T> factory, final MobCategory category, final UnaryOperator<EntityType.Builder<T>> builder);
}
