package com.remesthesia.untitled.impl.world.item;

import com.remesthesia.untitled.Untitled;
import com.remesthesia.untitled.api.world.item.CreativeModeTabsModifier;
import com.remesthesia.untitled.api.world.item.CreativeModeTabModifier;
import com.remesthesia.untitled.api.world.item.ItemHelper;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import org.jetbrains.annotations.ApiStatus.Internal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;

@EventBusSubscriber(modid = Untitled.MOD_ID)
@Internal
public final class NeoForgeItemHelper implements ItemHelper {
    private static final List<Consumer<CreativeModeTabsModifier>> ALL_MODIFIERS = new ArrayList<>();
    private static final HashMap<ResourceKey<CreativeModeTab>, List<Consumer<CreativeModeTabModifier>>> MODIFIERS = new HashMap<>();

    @Override
    public void modifyCreativeModeTab(ResourceKey<CreativeModeTab> key, Consumer<CreativeModeTabModifier> modifier) {
        MODIFIERS.computeIfAbsent(key, _ -> new ArrayList<>()).add(modifier);
    }

    @Override
    public void modifyAllCreativeModeTabs(Consumer<CreativeModeTabsModifier> modifier) {
        ALL_MODIFIERS.add(modifier);
    }

    @SubscribeEvent
    private static void buildCreativeModeTabContentsEvent(BuildCreativeModeTabContentsEvent event) {
        for (var modifier : ALL_MODIFIERS) {
            modifier.accept(new NeoForgeCreativeModeTabsModifier(event));
        }

        if (MODIFIERS.containsKey(event.getTabKey())) {
            for (var modifier : MODIFIERS.get(event.getTabKey())) {
                modifier.accept(new NeoForgeCreativeModeTabModifier(event));
            }
        }
    }
}
