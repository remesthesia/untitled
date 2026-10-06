package com.remesthesia.untitled.impl.world.item;

import com.remesthesia.untitled.api.world.item.CreativeModeTabModifier;
import com.remesthesia.untitled.api.world.item.ItemHelper;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import org.jetbrains.annotations.ApiStatus.Internal;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

@Internal
public final class FabricItemHelper implements ItemHelper {
    @Override
    public void modifyCreativeModeTab(ResourceKey<CreativeModeTab> key, Consumer<CreativeModeTabModifier> modifier) {
        CreativeModeTabEvents.modifyOutputEvent(key).register(output -> {
            modifier.accept(new FabricCreativeModeTabModifier(output));
        });
    }

    @Override
    public void modifyAllCreativeModeTabs(BiConsumer<CreativeModeTab, CreativeModeTabModifier> modifier) {
        CreativeModeTabEvents.MODIFY_OUTPUT_ALL.register((tab, output) -> {
            modifier.accept(tab, new FabricCreativeModeTabModifier(output));
        });
    }
}
