package com.remesthesia.untitled.impl.world.item;

import com.remesthesia.untitled.api.world.item.CreativeModeTabModifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

public record NeoForgeCreativeModeTabModifier(BuildCreativeModeTabContentsEvent event) implements CreativeModeTabModifier {
    @Override
    public void append(ItemLike... items) {
        for (var item : items) event.accept(new ItemStack(item));
    }

    @Override
    public void append(ItemStack... items) {
        for (var item : items) event.accept(item);
    }

    @Override
    public void prepend(ItemLike... items) {
        for (var item : items) event.insertFirst(new ItemStack(item), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
    }

    @Override
    public void prepend(ItemStack... items) {
        for (var item : items) event.insertFirst(item, CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
    }

    @Override
    public void insertAfter(ItemLike target, ItemLike... items) {
        for (var item : items) event.insertAfter(new ItemStack(target), new ItemStack(item), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
    }

    @Override
    public void insertAfter(ItemLike target, ItemStack... items) {
        for (var item : items) event.insertAfter(new ItemStack(target), item, CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
    }

    @Override
    public void insertAfter(ItemStack target, ItemLike... items) {
        for (var item : items) event.insertAfter(target, new ItemStack(item), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
    }

    @Override
    public void insertAfter(ItemStack target, ItemStack... items) {
        for (var item : items) event.insertAfter(target, item, CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
    }

    @Override
    public void insertBefore(ItemLike target, ItemLike... items) {
        for (var item : items) event.insertBefore(new ItemStack(target), new ItemStack(item), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
    }

    @Override
    public void insertBefore(ItemLike target, ItemStack... items) {
        for (var item : items) event.insertBefore(new ItemStack(target), item, CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
    }

    @Override
    public void insertBefore(ItemStack target, ItemLike... items) {
        for (var item : items) event.insertBefore(target, new ItemStack(item), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
    }

    @Override
    public void insertBefore(ItemStack target, ItemStack... items) {
        for (var item : items) event.insertBefore(target, item, CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
    }
}
