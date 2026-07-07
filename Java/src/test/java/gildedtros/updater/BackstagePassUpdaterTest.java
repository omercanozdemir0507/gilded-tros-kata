package gildedtros.updater;

import com.gildedtros.Item;
import com.gildedtros.updater.BackstagePassUpdater;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BackstagePassUpdaterTest {
    private final BackstagePassUpdater updater = new BackstagePassUpdater();

    @Test
    void shouldIncreaseQualityByOne_whenMoreThanTenDaysRemain() {
        // Arrange
        Item item = new Item("Backstage passes for Re:Factor", 15, 20);

        // Act
        updater.update(item);

        // Assert
        assertEquals(21, item.quality);
    }

    @Test
    void shouldIncreaseQualityByOne_whenElevenDaysRemainBoundary() {
        // Arrange
        Item item = new Item("Backstage passes for Re:Factor", 11, 20);

        // Act
        updater.update(item);

        // Assert
        assertEquals(21, item.quality);
    }

    @Test
    void shouldIncreaseQualityByTwo_whenExactlyTenDaysRemain() {
        // Arrange
        Item item = new Item("Backstage passes for Re:Factor", 10, 20);

        // Act
        updater.update(item);

        // Assert
        assertEquals(22, item.quality);
    }

    @Test
    void shouldIncreaseQualityByTwo_whenSixDaysRemainBoundary() {
        // Arrange
        Item item = new Item("Backstage passes for Re:Factor", 6, 20);

        // Act
        updater.update(item);

        // Assert
        assertEquals(22, item.quality);
    }

    @Test
    void shouldIncreaseQualityByThree_whenExactlyFiveDaysRemain() {
        // Arrange
        Item item = new Item("Backstage passes for Re:Factor", 5, 20);

        // Act
        updater.update(item);

        // Assert
        assertEquals(23, item.quality);
    }

    @Test
    void shouldIncreaseQualityByThree_whenOneDayRemains() {
        // Arrange
        Item item = new Item("Backstage passes for HAXX", 1, 20);

        // Act
        updater.update(item);

        // Assert
        assertEquals(23, item.quality);
    }

    @Test
    void shouldDropQualityToZero_whenConcertHasPassed() {
        // Arrange
        Item item = new Item("Backstage passes for Re:Factor", 0, 40);

        // Act
        updater.update(item);

        // Assert
        assertEquals(-1, item.sellIn);
        assertEquals(0, item.quality);
    }

    @Test
    void shouldNotExceedFifty_whenDoubleIncreaseWouldOverflow() {
        // Arrange
        Item item = new Item("Backstage passes for Re:Factor", 10, 49);

        // Act
        updater.update(item);

        // Assert
        assertEquals(50, item.quality);
    }

    @Test
    void shouldNotExceedFifty_whenTripleIncreaseWouldOverflow() {
        // Arrange
        Item item = new Item("Backstage passes for Re:Factor", 3, 48);

        // Act
        updater.update(item);

        // Assert
        assertEquals(50, item.quality);
    }
}