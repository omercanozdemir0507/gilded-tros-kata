package com.gildedtros.updater;

import com.gildedtros.Item;
import com.gildedtros.updater.interfaces.ItemUpdater;

public class LegendaryItemUpdater implements ItemUpdater {
    private static final int LEGENDARY_QUALITY = 80;

    @Override
    public void update(Item item) {
        item.quality = LEGENDARY_QUALITY;
    }
}
