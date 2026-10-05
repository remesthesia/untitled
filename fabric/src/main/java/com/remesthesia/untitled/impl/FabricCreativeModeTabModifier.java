package com.remesthesia.untitled.impl;

import com.remesthesia.untitled.api.world.item.ICreativeModeTabModifier;
import com.remesthesia.untitled.impl.world.item.ICreativeModeTabHelper;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTabOutput;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;

public record FabricCreativeModeTabModifier(FabricCreativeModeTabOutput output) implements ICreativeModeTabModifier {

    @Override
    public void append(ItemStack... items) {
        for (var item : items) {
            output.accept(item);
        }
    }

    @Override
    public void prepend(ItemStack... items) {
        for (int i = items.length - 1; i > 0; i--) {
            output.prepend(items[i]);
        }
    }

    @Override
    public void insertAfter(ItemLike target, ItemStack... items) {
        output.insertAfter(target, items);
    }

    @Override
    public void insertAfter(ItemStack target, ItemStack... items) {
        output.insertAfter(target, items);
    }

    @Override
    public void insertAfter(ItemLike target, ItemLike... items) {
        output.insertAfter(target, items);
    }

    @Override
    public void insertAfter(ItemStack target, ItemLike... items) {
        output.insertAfter(target, items);
    }

    @Override
    public void insertBefore(ItemLike target, ItemStack... items) {
        output.insertAfter(target, items);
    }

    @Override
    public void insertBefore(ItemStack target, ItemStack... items) {
        output.insertAfter(target, items);
    }

    @Override
    public void insertBefore(ItemLike target, ItemLike... items) {
        output.insertAfter(target, items);
    }

    @Override
    public void insertBefore(ItemStack target, ItemLike... items) {
        output.insertAfter(target, items);
    }
}
