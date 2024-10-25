package utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static utils.BigIntegerConstants.big;

class SqrtContinuedFractionTest {
    @Test
    void estimateSqrt1() {
        assertRationalFraction(SqrtContinuedFraction.sqrt(1), 1);
    }

    @Test
    void estimateSqrt4() {
        assertRationalFraction(SqrtContinuedFraction.sqrt(4), 2);
    }

    @Test
    void estimateSqrt2() {
        assertIrrationalFraction( SqrtContinuedFraction.sqrt(2),1, 2);
    }

    @Test
    void estimateSqrt3() {
        assertIrrationalFraction(SqrtContinuedFraction.sqrt(3),1, 1, 2);
    }

    @Test
    void estimateSqrt7() {
        assertIrrationalFraction(SqrtContinuedFraction.sqrt(7),2, 1, 1, 1, 4);
    }

    @Test
    void estimateSqrt23() {
        assertIrrationalFraction(SqrtContinuedFraction.sqrt(23),4, 1, 3, 1, 8);
    }

    @Test
    void estimateSqrt46() {
        assertIrrationalFraction(SqrtContinuedFraction.sqrt(46),6, 1, 3, 1, 1, 2, 6, 2, 1, 1, 3, 1, 12);
    }

    @Test
    void estimateSqrt67() {
        assertIrrationalFraction(SqrtContinuedFraction.sqrt(67),8, 5, 2, 1, 1, 7, 1, 1, 2, 5, 16);
    }

    @Test
    void estimateSqrt94() {
        assertIrrationalFraction(SqrtContinuedFraction.sqrt(94),9, 1, 2, 3, 1, 1, 5, 1, 8, 1, 5, 1, 1, 3, 2, 1, 18);
    }

    @Test
    void estimateSqrt2566() {
        assertIrrationalFraction(SqrtContinuedFraction.sqrt(2566),50,1, 1, 1, 9, 2, 6, 1, 3, 5, 2, 1, 2, 2, 1, 1, 1, 1, 4, 1, 2, 1, 1, 4, 33, 1, 1, 4, 3, 6, 2, 3, 1, 16, 9, 6, 1, 1, 1, 4, 5, 1, 2, 1, 10, 1, 1, 13, 1, 19, 3, 50, 3, 19, 1, 13, 1, 1, 10, 1, 2, 1, 5, 4, 1, 1, 1, 6, 9, 16, 1, 3, 2, 6, 3, 4, 1, 1, 33, 4, 1, 1, 2, 1, 4, 1, 1, 1, 1, 2, 2, 1, 2, 5, 3, 1, 6, 2, 9, 1, 1, 1, 100);
    }

    private static void assertRationalFraction(SqrtContinuedFraction f, int a) {
        assertInstanceOf(SqrtContinuedFraction.RationalSqrtContinuedFraction.class, f);
        assertEquals(big(a), f.at(0));
    }

    private static void assertIrrationalFraction(SqrtContinuedFraction f, int... a) {
        assertInstanceOf(SqrtContinuedFraction.IrrationalSqrtContinuedFraction.class, f);
        assertEquals(Maker.list(a), ((SqrtContinuedFraction.IrrationalSqrtContinuedFraction)f).atList());
    }
}