package com.gildedtros.updater;

import com.gildedtros.Item;
import com.gildedtros.updater.interfaces.ItemUpdater;

public class AgingItemUpdater implements ItemUpdater {
    @Override
    public void update(Item item) {
        item.quality = QualityBounds.cap(item.quality + 1);
        item.sellIn = item.sellIn - 1;
        if (item.sellIn < 0) {
            item.quality = QualityBounds.cap(item.quality + 1);
        }
    }
}
