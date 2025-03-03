package utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class DigitPowerTest {
    @Test
    public void lowLongBound() {
        assertThrows(ArithmeticException.class, () -> DigitPower.forExponent(19));
    }
}