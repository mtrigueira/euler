package problem8;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class DigitNumberTest {
    private static final DigitNumber seriesdigitNumber = new DigitNumber("0123456789");

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4,5,6,7,8,9})
    void cruise(int expected) {
        assertEquals(expected, seriesdigitNumber.next());
    }

    @Test
    void toByteArrayEmptyString() {
        assertArrayEquals(new byte[]{}, DigitNumber.toByteArray(""));
    }

    @Test
    void toByteArrayZero() {
        assertArrayEquals(new byte[]{0}, DigitNumber.toByteArray("0"));
    }

    @Test
    void toByteArrayZeroOne() {
        assertArrayEquals(new byte[]{0,1}, DigitNumber.toByteArray("01"));
    }

    @Test
    void toByteArrayBigger() {
        assertArrayEquals(new byte[]{0,1,2,3,4,5,6,7,8,9}, DigitNumber.toByteArray("0123456789"));
    }
}