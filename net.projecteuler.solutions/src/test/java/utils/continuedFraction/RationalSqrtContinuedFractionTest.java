package utils.continuedFraction;

import org.junit.jupiter.api.Test;

import static java.math.BigInteger.ZERO;
import static org.junit.jupiter.api.Assertions.*;
import static utils.BigIntegerConstants.big;
import static utils.continuedFraction.SqrtContinuedFraction.sqrt;

class RationalSqrtContinuedFractionTest {
    @Test
    void estimateSqrt1() {
        assertRationalFraction(sqrt(1), "[1]", 1);
    }

    @Test
    void estimateSqrt4() {
        assertRationalFraction(sqrt(4),"[2]", 2);
    }

    private static void assertRationalFraction(SqrtContinuedFraction f, String s, int a) {
        assertInstanceOf(RationalSqrtContinuedFraction.class, f);
        assertEquals(s, f.toString());
        assertEquals(big(a), f.at(0));
        assertEquals(ZERO, f.at(1));
    }
}