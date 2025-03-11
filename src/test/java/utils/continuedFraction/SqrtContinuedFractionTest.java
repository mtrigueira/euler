package utils.continuedFraction;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static utils.continuedFraction.SqrtContinuedFraction.isPerfectSquare;

class SqrtContinuedFractionTest {
    @Test
    void test4() {
        assertTrue(isPerfectSquare(4));
    }

    @Test
    void test3() {
        assertFalse(isPerfectSquare(3));
    }
}