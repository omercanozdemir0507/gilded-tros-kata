package gildedtros.updater;

import com.gildedtros.Item;
import com.gildedtros.updater.LegendaryItemUpdater;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LegendaryItemUpdaterTest {
    private final LegendaryItemUpdater updater = new LegendaryItemUpdater();

    @Test
    void shouldSetQualityToEighty_regardlessOfInitialQuality() {
        // Arrange
        Item item = new Item("B-DAWG Keychain", 5, 42);

        // Act
        updater.update(item);

        // Assert
        assertEquals(80, item.quality);
    }

    @Test
    void shouldNeverChangeSellIn_whenItemIsLegendary() {
        // Arrange
        Item item = new Item("B-DAWG Keychain", 5, 80);

        // Act
        updater.update(item);

        // Assert
        assertEquals(5, item.sellIn);
    }

    @Test
    void shouldNeverChangeSellInOrQuality_whenSellInIsAlreadyNegative() {
        // Arrange
        Item item = new Item("B-DAWG Keychain", -1, 80);

        // Act
        updater.update(item);

        // Assert
        assertEquals(-1, item.sellIn);
        assertEquals(80, item.quality);
    }
}