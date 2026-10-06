package com.remesthesia.untitled.impl.world.item;

import com.remesthesia.untitled.api.world.item.CreativeModeTabsModifier;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

public record NeoForgeCreativeModeTabsModifier(BuildCreativeModeTabContentsEvent event) implements CreativeModeTabsModifier {
    @Override
    public CreativeModeTab getTab() {
        return event.getTab();
    }
}
