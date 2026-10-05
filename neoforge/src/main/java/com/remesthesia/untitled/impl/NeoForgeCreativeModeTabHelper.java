package com.remesthesia.untitled.impl;

import com.remesthesia.untitled.Untitled;
import com.remesthesia.untitled.api.world.item.ICreativeModeTabModifier;
import com.remesthesia.untitled.impl.world.item.ICreativeModeTabHelper;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;

@EventBusSubscriber(modid = Untitled.MOD_ID)
public class NeoForgeCreativeModeTabHelper implements ICreativeModeTabHelper {
    private static final HashMap<ResourceKey<CreativeModeTab>, List<Consumer<ICreativeModeTabModifier>>> IDK_MAN = new HashMap<>();

    @Override
    public void modify(ResourceKey<CreativeModeTab> creativeModeTab, Consumer<ICreativeModeTabModifier> consumer) {
        IDK_MAN.computeIfAbsent(creativeModeTab, _ -> new ArrayList<>()).add(consumer);
    }

    @SubscribeEvent
    public static void buildContents(BuildCreativeModeTabContentsEvent event) {
        for (var idk : IDK_MAN.get(event.getTabKey())) {
            idk.accept(new NeoForgeCreativeModeTabModifier(event));
        }
    }
}
