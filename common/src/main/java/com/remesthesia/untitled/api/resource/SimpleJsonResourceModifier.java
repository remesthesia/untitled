package com.remesthesia.untitled.api.resource;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.remesthesia.untitled.Untitled;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;

import static org.jetbrains.annotations.ApiStatus.*;

public final class SimpleJsonResourceModifier {
    private static final HashMap<String, HashMap<Identifier, List<Consumer<JsonObject>>>> PREFIX_TO_MAP = new HashMap<>();

    public static void modify(ResourceKey<? extends Registry<?>> registry, Identifier identifier, Consumer<JsonObject> consumer) {
        modify(Registries.elementsDirPath(registry), identifier, consumer);
    }

    public static void modify(String prefix, Identifier identifier, Consumer<JsonObject> consumer) {
        final var IDENTIFIER_TO_MODIFICATIONS = PREFIX_TO_MAP.computeIfAbsent(prefix, _ -> new HashMap<>());
        final var MODIFICATIONS = IDENTIFIER_TO_MODIFICATIONS.computeIfAbsent(identifier, _ -> new ArrayList<>());

        MODIFICATIONS.add(consumer);
    }

    @Internal
    public static JsonElement run(String prefix, Identifier identifier, JsonElement jsonElement) {
        if (!PREFIX_TO_MAP.containsKey(prefix)) return jsonElement;

        final var IDENTIFIER_TO_MODIFICATIONS = PREFIX_TO_MAP.get(prefix);
        if (!IDENTIFIER_TO_MODIFICATIONS.containsKey(identifier)) return jsonElement;

        final var MODIFICATIONS = IDENTIFIER_TO_MODIFICATIONS.get(identifier);

        var jsonObject = jsonElement.getAsJsonObject();
        for (var modification : MODIFICATIONS) {
            try {
                modification.accept(jsonObject);
            } catch (Exception ex) {
                Untitled.LOGGER.error(ex.getMessage());
            }
        }

        return jsonObject;
    }
}
