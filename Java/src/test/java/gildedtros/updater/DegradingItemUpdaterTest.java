package gildedtros.updater;

import com.gildedtros.Item;
import com.gildedtros.updater.DegradingItemUpdater;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DegradingItemUpdaterTest {
    private final DegradingItemUpdater normalUpdater = new DegradingItemUpdater(1);
    private final DegradingItemUpdater smellyUpdater = new DegradingItemUpdater(2);

    @Test
    void shouldDegradeQualityByOne_whenSellByDateNotReached() {
        // Arrange
        Item item = new Item("Elixir of the SOLID", 5, 10);

        // Act
        normalUpdater.update(item);

        // Assert
        assertEquals(4, item.sellIn);
        assertEquals(9, item.quality);
    }

    @Test
    void shouldDegradeQualityTwiceAsFast_whenSellByDateHasPassed() {
        // Arrange
        Item item = new Item("Elixir of the SOLID", 0, 10);

        // Act
        normalUpdater.update(item);

        // Assert
        assertEquals(-1, item.sellIn);
        assertEquals(8, item.quality);
    }

    @Test
    void shouldNotDropQualityBelowZero_whenQualityIsAlreadyZero() {
        // Arrange
        Item item = new Item("Elixir of the SOLID", 5, 0);

        // Act
        normalUpdater.update(item);

        // Assert
        assertEquals(0, item.quality);
    }

    @Test
    void shouldNotDropQualityBelowZero_whenExpiredAndDoubleDegrading() {
        // Arrange
        Item item = new Item("Elixir of the SOLID", 0, 1);

        // Act
        normalUpdater.update(item);

        // Assert
        assertEquals(0, item.quality);
    }

    @Test
    void shouldDegradeQualityTwiceAsFastAsNormalItem_whenItemIsSmelly() {
        // Arrange
        Item item = new Item("Duplicate Code", 5, 10);

        // Act
        smellyUpdater.update(item);

        // Assert
        assertEquals(4, item.sellIn);
        assertEquals(8, item.quality);
    }

    @Test
    void shouldDegradeQualityFourTimesAsFast_whenSmellyItemHasExpired() {
        // Arrange
        Item item = new Item("Duplicate Code", 0, 10);

        // Act
        smellyUpdater.update(item);

        // Assert
        assertEquals(-1, item.sellIn);
        assertEquals(6, item.quality);
    }
}