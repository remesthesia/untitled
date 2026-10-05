package com.remesthesia.untitled.impl;

import com.remesthesia.untitled.api.world.item.ICreativeModeTabModifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

import java.util.Arrays;
import java.util.Collections;

public record NeoForgeCreativeModeTabModifier(BuildCreativeModeTabContentsEvent event) implements ICreativeModeTabModifier {
    @Override
    public void append(ItemStack... items) {
        for (var item : items) {
            event.accept(item);
        }
    }

    @Override
    public void prepend(ItemStack... items) {
        for (int i = items.length - 1; i > 0; i--) {
            event.insertFirst(items[i], CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
    }

    @Override
    public void insertAfter(ItemLike target, ItemStack... items) {
        for (int i = items.length - 1; i > 0; i--) {
            event.insertAfter(new ItemStack(target), items[i], CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
    }

    @Override
    public void insertAfter(ItemStack target, ItemStack... items) {
        for (int i = items.length - 1; i > 0; i--) {
            event.insertAfter(target, items[i], CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
    }

    @Override
    public void insertAfter(ItemLike target, ItemLike... items) {
        for (int i = items.length - 1; i > 0; i--) {
            event.insertAfter(new ItemStack(target), new ItemStack(items[i]), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
    }

    @Override
    public void insertAfter(ItemStack target, ItemLike... items) {
        for (int i = items.length - 1; i > 0; i--) {
            event.insertAfter(target, new ItemStack(items[i]), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
    }

    @Override
    public void insertBefore(ItemLike target, ItemStack... items) {
        for (var item : items) {
            event.insertBefore(new ItemStack(target), item, CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
    }

    @Override
    public void insertBefore(ItemStack target, ItemStack... items) {
        for (var item : items) {
            event.insertBefore(target, item, CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
    }

    @Override
    public void insertBefore(ItemLike target, ItemLike... items) {
        for (var item : items) {
            event.insertBefore(new ItemStack(target), new ItemStack(item), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
    }

    @Override
    public void insertBefore(ItemStack target, ItemLike... items) {
        for (var item : items) {
            event.insertBefore(target, new ItemStack(item), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
    }
}
