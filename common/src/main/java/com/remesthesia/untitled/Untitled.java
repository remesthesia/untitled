package com.remesthesia.untitled;

import net.minecraft.resources.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.jetbrains.annotations.ApiStatus.*;

public final class Untitled {
    @Internal
    public static final Logger LOGGER = LoggerFactory.getLogger("Untitled");
    public static final String MOD_ID = "untitled";

    public static void init() {}

    public static Identifier getIdentifier(String path) {
        return Identifier.fromNamespaceAndPath(MOD_ID, path);
    }
}