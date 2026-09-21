package com.remesthesia.untitled.impl;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Function;
import java.util.function.Supplier;

public interface IRegistryHelper {
    <T> Holder<T> register(final Registry<T> registry, final Identifier id, final Function<Identifier, ? extends T> item);

    Holder<Block> registerBlock(final Identifier id, final Function<BlockBehaviour.Properties, ? extends Block> block, final Supplier<BlockBehaviour.Properties> properties);
    Holder<Item> registerItem(final Identifier id, final Function<Item.Properties, ? extends Item> item, final Supplier<Item.Properties> properties);
}
