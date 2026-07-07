package gildedtros;

import com.gildedtros.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class ItemTest {
    @Test
    void shouldSetNameSellInAndQuality_whenConstructed() {
        // Arrange
        String name = "Good Wine";
        int sellIn = 5;
        int quality = 10;

        // Act
        Item item = new Item(name, sellIn, quality);

        // Assert
        assertEquals("Good Wine", item.name);
        assertEquals(5, item.sellIn);
        assertEquals(10, item.quality);
    }

    @Test
    void shouldFormatAsCommaSeparatedString_whenToStringIsCalled() {
        // Arrange
        Item item = new Item("Good Wine", 5, 10);

        // Act
        String result = item.toString();

        // Assert
        assertEquals("Good Wine, 5, 10", result);
    }

    @Test
    void shouldFormatNegativeSellIn_whenToStringIsCalled() {
        // Arrange
        Item item = new Item("Elixir of the SOLID", -1, 0);

        // Act
        String result = item.toString();

        // Assert
        assertEquals("Elixir of the SOLID, -1, 0", result);
    }

    @Test
    void shouldAllowQualityFields_toBeMutatedDirectly() {
        // Arrange
        Item item = new Item("Elixir of the SOLID", 5, 10);

        // Act
        item.quality = 20;
        item.sellIn = 3;

        // Assert
        assertEquals(20, item.quality);
        assertEquals(3, item.sellIn);
    }
}