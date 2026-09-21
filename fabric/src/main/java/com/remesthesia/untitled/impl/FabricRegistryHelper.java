package com.remesthesia.untitled.impl;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Function;
import java.util.function.Supplier;

public final class FabricRegistryHelper implements IRegistryHelper {
    @Override
    public <T> Holder<T> register(Registry<T> registry, Identifier id, Function<Identifier, ? extends T> item) {
        return Registry.registerForHolder(registry, id, item.apply(id));
    }

    @Override
    public Holder<Block> registerBlock(Identifier id, Function<BlockBehaviour.Properties, ? extends Block> block, Supplier<BlockBehaviour.Properties> properties) {
        return Registry.registerForHolder(BuiltInRegistries.BLOCK, id, block.apply(properties.get()));
    }

    @Override
    public Holder<Item> registerItem(Identifier id, Function<Item.Properties, ? extends Item> item, Supplier<Item.Properties> properties) {
        return Registry.registerForHolder(BuiltInRegistries.ITEM, id, item.apply(properties.get()));
    }
}