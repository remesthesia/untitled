package com.remesthesia.untitled.impl.world.item;

import com.remesthesia.untitled.api.world.item.CreativeModeTabModifier;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTabOutput;

public record FabricCreativeModeTabModifier(FabricCreativeModeTabOutput output) implements CreativeModeTabModifier {
}
