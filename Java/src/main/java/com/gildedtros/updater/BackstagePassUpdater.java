package com.gildedtros.updater;

import com.gildedtros.Item;
import com.gildedtros.updater.interfaces.ItemUpdater;

public class BackstagePassUpdater implements ItemUpdater {
    private static final int LONG_LEAD_THRESHOLD = 10;
    private static final int SHORT_LEAD_THRESHOLD = 5;

    @Override
    public void update(Item item) {
        int increase = increaseFor(item.sellIn);
        item.quality = QualityBounds.cap(item.quality + increase);
        item.sellIn = item.sellIn - 1;
        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }

    private int increaseFor(int sellIn) {
        if (sellIn <= SHORT_LEAD_THRESHOLD) return 3;
        if (sellIn <= LONG_LEAD_THRESHOLD) return 2;
        return 1;
    }
}
