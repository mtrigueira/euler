package problem25;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ThousandDigitFibonacciNumberTest {

    @Test
    void fibonacci() {
        assertEquals(12, ThousandDigitFibonacciNumber.indexOfFirstFibonacciNumberWithLengthAtLeast(3));
    }
}