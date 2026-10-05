package com.remesthesia.untitled;

import com.google.gson.JsonElement;
import com.remesthesia.untitled.api.RegistryHelper;
import com.remesthesia.untitled.api.resource.SimpleJsonResourceModifier;
import com.remesthesia.untitled.impl.NeoForgeRegistryHelper;
import net.minecraft.core.WritableRegistry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.RegistryDataLoader;
import net.minecraft.server.packs.resources.SimpleJsonResourceReloadListener;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

@Mod(Untitled.MOD_ID)
public final class UntitledNeoForge {

    public UntitledNeoForge(IEventBus eventBus) {
        Untitled.init();

        ((NeoForgeRegistryHelper) RegistryHelper.getInstance()).registerAll(eventBus);

        SimpleJsonResourceModifier.modify(Registries.LOOT_TABLE, Identifier.fromNamespaceAndPath("minecraft", "blocks/dirt"),
                jsonObject -> {
            jsonObject.getAsJsonArray("pools")
                    .get(0).getAsJsonObject()
                    .getAsJsonArray("entries")
                    .get(0).getAsJsonObject()
                    .addProperty("name", "minecraft:sand");
                });
    }


}