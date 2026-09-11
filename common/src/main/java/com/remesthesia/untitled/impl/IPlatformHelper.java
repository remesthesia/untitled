package com.remesthesia.untitled.impl;

import com.remesthesia.untitled.api.Environment;
import com.remesthesia.untitled.api.Platform;

import java.nio.file.Path;

public interface IPlatformHelper {

    boolean isDevelopmentEnvironment();

    Environment getEnvironment();

    Path getDirectory();

    Platform getPlatform();
}
