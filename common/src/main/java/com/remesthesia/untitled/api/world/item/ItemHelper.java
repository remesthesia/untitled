package com.remesthesia.untitled.api.world.item;

import com.remesthesia.untitled.impl.UntitledServices;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;

import java.util.function.Consumer;

public interface ItemHelper {
    static ItemHelper getInstance() {
        return UntitledServices.ITEM_HELPER_INSTANCE;
    }

    void modifyCreativeModeTab(ResourceKey<CreativeModeTab> key, Consumer<CreativeModeTabModifier> modifier);

    void modifyAllCreativeModeTabs(Consumer<CreativeModeTabsModifier> modifier);
}
