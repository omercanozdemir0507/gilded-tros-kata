package gildedtros.updater;

import com.gildedtros.Item;
import com.gildedtros.updater.AgingItemUpdater;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AgingItemUpdaterTest {
    private final AgingItemUpdater updater = new AgingItemUpdater();

    @Test
    void shouldIncreaseQualityByOne_whenSellByDateNotReached() {
        // Arrange
        Item item = new Item("Good Wine", 2, 10);

        // Act
        updater.update(item);

        // Assert
        assertEquals(1, item.sellIn);
        assertEquals(11, item.quality);
    }

    @Test
    void shouldIncreaseQualityTwiceAsFast_whenSellByDateHasPassed() {
        // Arrange
        Item item = new Item("Good Wine", 0, 10);

        // Act
        updater.update(item);

        // Assert
        assertEquals(-1, item.sellIn);
        assertEquals(12, item.quality);
    }

    @Test
    void shouldNotExceedFifty_whenQualityIsAlreadyAtMax() {
        // Arrange
        Item item = new Item("Good Wine", 5, 50);

        // Act
        updater.update(item);

        // Assert
        assertEquals(50, item.quality);
    }

    @Test
    void shouldNotExceedFifty_whenDoubleIncreaseWouldOverflow() {
        // Arrange
        Item item = new Item("Good Wine", 0, 49);

        // Act
        updater.update(item);

        // Assert
        assertEquals(50, item.quality);
    }
}