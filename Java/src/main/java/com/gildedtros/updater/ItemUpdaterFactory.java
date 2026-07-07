package com.gildedtros.updater;

import com.gildedtros.Item;
import com.gildedtros.updater.interfaces.ItemUpdater;

import java.util.Set;

public class ItemUpdaterFactory {
    private static final String GOOD_WINE = "Good Wine";
    private static final String LEGENDARY_KEYCHAIN = "B-DAWG Keychain";
    private static final String BACKSTAGE_PREFIX = "Backstage passes for ";
    private static final Set<String> SMELLY_ITEMS = Set.of(
            "Duplicate Code", "Long Methods", "Ugly Variable Names");

    private static final ItemUpdater AGING_UPDATER = new AgingItemUpdater();
    private static final ItemUpdater LEGENDARY_UPDATER = new LegendaryItemUpdater();
    private static final ItemUpdater BACKSTAGE_UPDATER = new BackstagePassUpdater();
    private static final ItemUpdater NORMAL_UPDATER = new DegradingItemUpdater(1);
    private static final ItemUpdater SMELLY_UPDATER = new DegradingItemUpdater(2);

    private ItemUpdaterFactory() {}

    public static ItemUpdater getUpdater(Item item) {
        if (GOOD_WINE.equals(item.name)) return AGING_UPDATER;
        if (LEGENDARY_KEYCHAIN.equals(item.name)) return LEGENDARY_UPDATER;
        if (item.name.startsWith(BACKSTAGE_PREFIX)) return BACKSTAGE_UPDATER;
        if (SMELLY_ITEMS.contains(item.name)) return SMELLY_UPDATER;
        return NORMAL_UPDATER;
    }
}
