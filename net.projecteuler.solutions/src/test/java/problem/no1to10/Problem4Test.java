package problem.no1to10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Problem4Test {
    @Test
    void forOneDigit() {
        assertEquals(9L, Problem4.productOfDigits(1));
    }

    @Test
    void forTwoDigits() {
        assertEquals(9009L, Problem4.productOfDigits(2));
    }

    @Test
    void forThreeDigits() {
        assertEquals(906609L, Problem4.productOfDigits(3));
    }

    @Test
    void forFourDigits() {
        assertEquals(99000099L, Problem4.productOfDigits(4));
    }

    @Test
    void forFiveDigits() {
        assertEquals(9966006699L, Problem4.productOfDigits(5));
    }

    @Test
    void forSixDigits() {
        assertEquals(999000000999L, Problem4.productOfDigits(6));
    }

    @Test
    void forZeroDigit() {
        assertThrows(RuntimeException.class, ()->Problem4.productOfDigits(0));
    }
}
