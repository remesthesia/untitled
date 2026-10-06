package com.remesthesia.untitled.api.world.item;

import com.remesthesia.untitled.impl.Services;

public interface ItemHelper {
    static ItemHelper getInstance() {
        return Services.ITEM_HELPER_INSTANCE;
    }
}
