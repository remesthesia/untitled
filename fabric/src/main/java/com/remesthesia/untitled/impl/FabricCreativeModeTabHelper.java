package com.remesthesia.untitled.impl;

import com.remesthesia.untitled.api.world.item.ICreativeModeTabModifier;
import com.remesthesia.untitled.impl.world.item.ICreativeModeTabHelper;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;

import java.util.function.Consumer;

public class FabricCreativeModeTabHelper implements ICreativeModeTabHelper {
    @Override
    public void modify(ResourceKey<CreativeModeTab> creativeModeTab, Consumer<ICreativeModeTabModifier> consumer) {
        CreativeModeTabEvents.modifyOutputEvent(creativeModeTab).register(output -> {
            consumer.accept(new FabricCreativeModeTabModifier(output));
        });
    }
}
