package com.gildedtros.updater;

final public class QualityBounds {
    static final int MIN_QUALITY = 0;
    static final int MAX_QUALITY = 50;

    private QualityBounds() {}

    public static int cap(int quality) {
        return Math.max(MIN_QUALITY, Math.min(MAX_QUALITY, quality));
    }
}
