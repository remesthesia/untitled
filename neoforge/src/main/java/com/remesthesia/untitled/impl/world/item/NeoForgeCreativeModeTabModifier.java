package com.remesthesia.untitled.impl.world.item;

import com.remesthesia.untitled.api.world.item.CreativeModeTabModifier;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

public record NeoForgeCreativeModeTabModifier(BuildCreativeModeTabContentsEvent event) implements CreativeModeTabModifier {
}
