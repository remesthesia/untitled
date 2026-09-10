package com.remesthesia.untitled.impl;

import com.remesthesia.untitled.api.Environment;
import com.remesthesia.untitled.api.Platform;

public interface IPlatformHelper {

    boolean isDevelopmentEnvironment();

    Environment getEnvironment();

    Platform getPlatform();
}
