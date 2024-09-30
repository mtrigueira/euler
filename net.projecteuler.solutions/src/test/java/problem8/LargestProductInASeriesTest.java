package problem8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static problem8.LargestProductInASeries.BIG_NUMBER;

class LargestProductInASeriesTest {
    @Test
    void greatestProductZero() {
        assertEquals(0, LargestProductInASeries.greatestProduct("", 1));
    }

    @Test
    void greatestProductOne() {
        assertEquals(1, LargestProductInASeries.greatestProduct("1", 1));
    }

    @Test
    void greatestProductTwo() {
        assertEquals(2, LargestProductInASeries.greatestProduct("2", 1));
    }

    @Test
    void bigWidthOne() {
        assertEquals(9, LargestProductInASeries.greatestProduct(BIG_NUMBER, 1));
    }

    @Test
    void bigWidthTwo() {
        assertEquals(9*9, LargestProductInASeries.greatestProduct(BIG_NUMBER, 2));
    }

    @Test
    void bigWidthThree() {
        assertEquals(9*9*8, LargestProductInASeries.greatestProduct(BIG_NUMBER, 3));
    }

    @Test
    void bigWidthFour() {
        assertEquals(9*9*8*9, LargestProductInASeries.greatestProduct(BIG_NUMBER, 4));
    }
}