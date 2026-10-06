package com.remesthesia.untitled.api.world.item;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;

public interface CreativeModeTabModifier {
    void append(ItemLike... items);
    void append(ItemStack... items);

    void prepend(ItemLike... items);
    void prepend(ItemStack... items);

    void insertAfter(ItemLike target, ItemLike... items);
    void insertAfter(ItemLike target, ItemStack... items);
    void insertAfter(ItemStack target, ItemLike... items);
    void insertAfter(ItemStack target, ItemStack... items);

    void insertBefore(ItemLike target, ItemLike... items);
    void insertBefore(ItemLike target, ItemStack... items);
    void insertBefore(ItemStack target, ItemLike... items);
    void insertBefore(ItemStack target, ItemStack... items);
}
