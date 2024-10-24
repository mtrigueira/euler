package utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContinuedFractionTest {
    @Test
    void estimateSqrt1() {
        assertEquals(continuedFraction(1), ContinuedFraction.sqrt(1));
    }

    @Test
    void estimateSqrt4() {
        assertEquals(continuedFraction(2), ContinuedFraction.sqrt(4));
    }

    @Test
    void estimateSqrt2() {
        assertEquals(continuedFractionR(1,1, 2), ContinuedFraction.sqrt(2));
    }

    @Test
    void estimateSqrt3() {
        assertEquals(continuedFractionR(1, 1, 1, 2), ContinuedFraction.sqrt(3));
    }

    @Test
    void estimateSqrt7() {
        assertEquals(continuedFractionR(1,2, 1, 1, 1, 4), ContinuedFraction.sqrt(7));
    }

    @Test
    void estimateSqrt23() {
        assertEquals(continuedFractionR(1,4, 1, 3, 1, 8), ContinuedFraction.sqrt(23));
    }

    @Test
    void estimateSqrt46() {
        assertEquals(continuedFractionR(1,6, 1, 3, 1, 1, 2, 6, 2, 1, 1, 3, 1, 12), ContinuedFraction.sqrt(46));
    }

    @Test
    void estimateSqrt67() {
        assertEquals(continuedFractionR(1,8, 5, 2, 1, 1, 7, 1, 1, 2, 5, 16), ContinuedFraction.sqrt(67));
    }

    @Test
    void estimateSqrt94() {
        assertEquals(continuedFractionR(1,9, 1, 2, 3, 1, 1, 5, 1, 8, 1, 5, 1, 1, 3, 2, 1, 18), ContinuedFraction.sqrt(94));
    }

    @Test
    void estimateSqrt2566() {
        assertEquals(continuedFractionR(1,50,1, 1, 1, 9, 2, 6, 1, 3, 5, 2, 1, 2, 2, 1, 1, 1, 1, 4, 1, 2, 1, 1, 4, 33, 1, 1, 4, 3, 6, 2, 3, 1, 16, 9, 6, 1, 1, 1, 4, 5, 1, 2, 1, 10, 1, 1, 13, 1, 19, 3, 50, 3, 19, 1, 13, 1, 1, 10, 1, 2, 1, 5, 4, 1, 1, 1, 6, 9, 16, 1, 3, 2, 6, 3, 4, 1, 1, 33, 4, 1, 1, 2, 1, 4, 1, 1, 1, 1, 2, 2, 1, 2, 5, 3, 1, 6, 2, 9, 1, 1, 1, 100), ContinuedFraction.sqrt(2566));
    }

    private static ContinuedFraction continuedFraction(int... a) {
        return ContinuedFraction.explicit(Maker.list(a), -1);
    }

    private static ContinuedFraction continuedFractionR(int repeatsAt, int... a) {
        return ContinuedFraction.explicit(Maker.list(a), repeatsAt);
    }
}