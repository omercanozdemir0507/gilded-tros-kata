package com.gildedtros.updater;

import com.gildedtros.Item;
import com.gildedtros.updater.interfaces.ItemUpdater;

public class DegradingItemUpdater implements ItemUpdater {
    private final int degradeRate;

    public DegradingItemUpdater(int degradeRate) {
        this.degradeRate = degradeRate;
    }

    @Override
    public void update(Item item) {
        item.quality = QualityBounds.cap(item.quality - degradeRate);
        item.sellIn = item.sellIn - 1;
        if (item.sellIn < 0) {
            item.quality = QualityBounds.cap(item.quality - degradeRate);
        }
    }
}
