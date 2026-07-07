package gildedtros;

import com.gildedtros.GildedTros;
import com.gildedtros.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedTrosTest {

    @Test
    void shouldUpdateAllItemTypesCorrectly_afterOneDay() {
        // Arrange
        Item[] items = new Item[] {
                new Item("Ring of Cleansening Code", 10, 20),
                new Item("Good Wine", 2, 0),
                new Item("B-DAWG Keychain", 5, 80),
                new Item("Backstage passes for Re:Factor", 15, 20),
                new Item("Duplicate Code", 3, 6)
        };
        GildedTros app = new GildedTros(items);

        // Act
        app.updateQuality();

        // Assert
        assertEquals(19, items[0].quality);
        assertEquals(1, items[1].quality);
        assertEquals(80, items[2].quality);
        assertEquals(21, items[3].quality);
        assertEquals(4, items[4].quality);
    }

    @Test
    void shouldDropBackstagePassQualityToZero_whenConcertHasPassed() {
        // Arrange
        Item[] items = new Item[] { new Item("Backstage passes for Re:Factor", 0, 40) };
        GildedTros app = new GildedTros(items);

        // Act
        app.updateQuality();

        // Assert
        assertEquals(0, items[0].quality);
    }

    @Test
    void shouldNeverChangeLegendaryItem_acrossMultipleDays() {
        // Arrange
        Item[] items = new Item[] { new Item("B-DAWG Keychain", 0, 80) };
        GildedTros app = new GildedTros(items);

        // Act
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();

        // Assert
        assertEquals(0, items[0].sellIn);
        assertEquals(80, items[0].quality);
    }

}
