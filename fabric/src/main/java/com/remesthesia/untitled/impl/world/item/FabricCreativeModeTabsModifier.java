package com.remesthesia.untitled.impl.world.item;

import com.remesthesia.untitled.api.world.item.CreativeModeTabsModifier;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTabOutput;
import net.minecraft.world.item.CreativeModeTab;

public record FabricCreativeModeTabsModifier(CreativeModeTab creativeModeTab, FabricCreativeModeTabOutput output) implements CreativeModeTabsModifier {
    @Override
    public CreativeModeTab getTab() {
        return creativeModeTab;
    }
}
