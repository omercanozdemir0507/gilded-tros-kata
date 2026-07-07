package gildedtros.updater;

import com.gildedtros.updater.QualityBounds;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QualityBoundsTest {
    @Test
    void shouldClampToZero_whenQualityIsNegative() {
        // Arrange
        int quality = -5;

        // Act
        int result = QualityBounds.cap(quality);

        // Assert
        assertEquals(0, result);
    }

    @Test
    void shouldClampToFifty_whenQualityExceedsFifty() {
        // Arrange
        int quality = 55;

        // Act
        int result = QualityBounds.cap(quality);

        // Assert
        assertEquals(50, result);
    }

    @Test
    void shouldLeaveQualityUnchanged_whenWithinValidRange() {
        // Arrange
        int quality = 30;

        // Act
        int result = QualityBounds.cap(quality);

        // Assert
        assertEquals(30, result);
    }

    @Test
    void shouldAcceptBoundaryValues_whenQualityIsExactlyZeroOrFifty() {
        // Arrange / Act / Assert
        assertEquals(0, QualityBounds.cap(0));
        assertEquals(50, QualityBounds.cap(50));
    }
}