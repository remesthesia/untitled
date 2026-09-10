package com.remesthesia.untitled;

import net.minecraft.resources.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Untitled {
    public static final String MOD_ID = "untitled";
    public static final Logger LOGGER = LoggerFactory.getLogger("Untitled");

    public static void init() {}

    public static Identifier getIdentifier(String path) {
        return Identifier.fromNamespaceAndPath(MOD_ID, path);
    }
}