package com.remesthesia.untitled.impl.world.item;

import com.remesthesia.untitled.api.world.item.ICreativeModeTabModifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;

import java.util.function.Consumer;

public interface ICreativeModeTabHelper {
    void modify(ResourceKey<CreativeModeTab> creativeModeTab, Consumer<ICreativeModeTabModifier> consumer);
}
