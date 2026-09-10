package com.remesthesia.template;

import net.minecraft.resources.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Template {
    public static final String MOD_ID = "template";
    public static final Logger LOGGER = LoggerFactory.getLogger("Template");

    public static void init() {}

    public static Identifier getIdentifier(String path) {
        return Identifier.fromNamespaceAndPath(MOD_ID, path);
    }
}