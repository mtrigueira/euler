package utils.continuedFraction;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.Maker;

import static org.junit.jupiter.api.Assertions.*;
import static utils.BigIntegerConstants.big;
import static utils.continuedFraction.SqrtContinuedFraction.sqrt;

class IrrationalSqrtContinuedFractionTest {
    private static void assertIrrationalFraction(ContinuedFraction f, int... a) {
        assertInstanceOf(IrrationalSqrtContinuedFraction.class, f);
        IrrationalSqrtContinuedFraction irrational = (IrrationalSqrtContinuedFraction) f;
        Assertions.assertEquals(Maker.list(a), irrational.atList());
        assertEquals(a.length - 1, irrational.period());

        for (int i = 0; i < a.length; i++)
            assertEquals(big(a[i]), irrational.at(i));

        // repeat once
        for (int i = 1; i < a.length; i++)
            assertEquals(big(a[i]), irrational.at(i+a.length-1));
    }

    private static void assertIrrationalFraction(ContinuedFraction f, String s, int... a) {
        assertIrrationalFraction(f, a);
        assertEquals(s, f.toString());
    }

    @Test
    void estimateSqrt2() {
        assertIrrationalFraction( sqrt(2),"[1; (2)]", 1, 2);
    }

    @Test
    void estimateSqrt3() {
        assertIrrationalFraction(sqrt(3),"[1; (1, 2)]",1, 1, 2);
    }

    @Test
    void estimateSqrt7() {
        assertIrrationalFraction(sqrt(7),"[2; (1, 1, 1, 4)]",2, 1, 1, 1, 4);
    }

    @Test
    void estimateSqrt23() {
        assertIrrationalFraction(sqrt(23),"[4; (1, 3, 1, 8)]",4, 1, 3, 1, 8);
    }

    @Test
    void estimateSqrt46() {
        assertIrrationalFraction(sqrt(46),6, 1, 3, 1, 1, 2, 6, 2, 1, 1, 3, 1, 12);
    }

    @Test
    void estimateSqrt67() {
        assertIrrationalFraction(sqrt(67),8, 5, 2, 1, 1, 7, 1, 1, 2, 5, 16);
    }

    @Test
    void estimateSqrt94() {
        assertIrrationalFraction(sqrt(94),9, 1, 2, 3, 1, 1, 5, 1, 8, 1, 5, 1, 1, 3, 2, 1, 18);
    }

    @Test
    void estimateSqrt2566() {
        assertIrrationalFraction(sqrt(2566),50,1, 1, 1, 9, 2, 6, 1, 3, 5, 2, 1, 2, 2, 1, 1, 1, 1, 4, 1, 2, 1, 1, 4, 33, 1, 1, 4, 3, 6, 2, 3, 1, 16, 9, 6, 1, 1, 1, 4, 5, 1, 2, 1, 10, 1, 1, 13, 1, 19, 3, 50, 3, 19, 1, 13, 1, 1, 10, 1, 2, 1, 5, 4, 1, 1, 1, 6, 9, 16, 1, 3, 2, 6, 3, 4, 1, 1, 33, 4, 1, 1, 2, 1, 4, 1, 1, 1, 1, 2, 2, 1, 2, 5, 3, 1, 6, 2, 9, 1, 1, 1, 100);
    }

    @Test
    void infiniteLoop() {
        assertThrows(RuntimeException.class, () -> IrrationalSqrtContinuedFraction.sequenceForSqrt(2566, 10));
    }
}