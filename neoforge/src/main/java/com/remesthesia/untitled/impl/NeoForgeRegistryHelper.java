package com.remesthesia.untitled.impl;

import com.remesthesia.untitled.Untitled;
import com.remesthesia.untitled.api.RegistryHelper;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.ApiStatus.Internal;

import java.util.HashMap;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

@EventBusSubscriber(modid = Untitled.MOD_ID)
@Internal
public final class NeoForgeRegistryHelper implements RegistryHelper { }
