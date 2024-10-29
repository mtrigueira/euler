package utils.data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DigitNumberTest {
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

    @Test
    void negativeTest() {
        assertThrows(IllegalArgumentException.class, ()-> DigitNumber.countDigits(-1));
    }
}