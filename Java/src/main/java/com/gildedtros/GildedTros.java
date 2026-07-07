package com.gildedtros;

import com.gildedtros.updater.ItemUpdaterFactory;

public class GildedTros {
    Item[] items;

    public GildedTros(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            ItemUpdaterFactory.getUpdater(item).update(item);
        }
    }
}