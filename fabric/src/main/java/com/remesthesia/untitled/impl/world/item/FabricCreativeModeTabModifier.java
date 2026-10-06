package com.remesthesia.untitled.impl.world.item;

import com.remesthesia.untitled.api.world.item.CreativeModeTabModifier;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTabOutput;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;

public record FabricCreativeModeTabModifier(FabricCreativeModeTabOutput output) implements CreativeModeTabModifier {
    @Override
    public void append(ItemLike... items) {
        for (var item : items) output.accept(item);
    }

    @Override
    public void append(ItemStack... items) {
        for (var item : items) output.accept(item);
    }

    @Override
    public void prepend(ItemLike... items) {
        for (var item : items) output.prepend(item);
    }

    @Override
    public void prepend(ItemStack... items) {
        for (var item : items) output.prepend(item);
    }

    @Override
    public void insertAfter(ItemLike target, ItemLike... items) {
        output.insertAfter(target, items);
    }

    @Override
    public void insertAfter(ItemLike target, ItemStack... items) {
        output.insertAfter(target, items);
    }

    @Override
    public void insertAfter(ItemStack target, ItemLike... items) {
        output.insertAfter(target, items);
    }

    @Override
    public void insertAfter(ItemStack target, ItemStack... items) {
        output.insertAfter(target, items);
    }

    @Override
    public void insertBefore(ItemLike target, ItemLike... items) {
        output.insertBefore(target, items);
    }

    @Override
    public void insertBefore(ItemLike target, ItemStack... items) {
        output.insertBefore(target, items);
    }

    @Override
    public void insertBefore(ItemStack target, ItemLike... items) {
        output.insertBefore(target, items);
    }

    @Override
    public void insertBefore(ItemStack target, ItemStack... items) {
        output.insertBefore(target, items);
    }
}
