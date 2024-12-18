package problem.no71to80;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem73Test {
    @Test
    void orderedFractionBetweenOneOverFromDenominatorToOneOverTwoDenominatorWhere4() {
        Assertions.assertEquals(0, Problem73.orderedFractionBetweenOneOverFromDenominatorToOneOverTwoDenominatorWhere(4));
    }

    @Test
    void orderedFractionBetweenOneOverFromDenominatorToOneOverTwoDenominatorWhere5() {
        assertEquals(1,Problem73.orderedFractionBetweenOneOverFromDenominatorToOneOverTwoDenominatorWhere(5));
    }

    @Test
    void orderedFractionBetweenOneOverFromDenominatorToOneOverTwoDenominatorWhere6() {
        assertEquals(1,Problem73.orderedFractionBetweenOneOverFromDenominatorToOneOverTwoDenominatorWhere(6));
    }

    @Test
    void orderedFractionBetweenOneOverFromDenominatorToOneOverTwoDenominatorWhere7() {
        assertEquals(2,Problem73.orderedFractionBetweenOneOverFromDenominatorToOneOverTwoDenominatorWhere(7));
    }

    @Test
    void orderedFractionBetweenOneOverFromDenominatorToOneOverTwoDenominatorWhere8() {
        assertEquals(3,Problem73.orderedFractionBetweenOneOverFromDenominatorToOneOverTwoDenominatorWhere(8));
    }

    @Test
    void orderedFractionBetweenOneOverFromDenominatorToOneOverTwoDenominatorWhere9() {
        assertEquals(4,Problem73.orderedFractionBetweenOneOverFromDenominatorToOneOverTwoDenominatorWhere(9));
    }

    @Test
    void orderedFractionBetweenOneOverFromDenominatorToOneOverTwoDenominatorWhere10() {
        assertEquals(4,Problem73.orderedFractionBetweenOneOverFromDenominatorToOneOverTwoDenominatorWhere(10));
    }

    @Test
    void orderedFractionBetweenOneOverFromDenominatorToOneOverTwoDenominatorWhere11() {
        assertEquals(6,Problem73.orderedFractionBetweenOneOverFromDenominatorToOneOverTwoDenominatorWhere(11));
    }

    @Test
    void orderedFractionBetweenOneOverFromDenominatorToOneOverTwoDenominatorWhere12() {
        assertEquals(7,Problem73.orderedFractionBetweenOneOverFromDenominatorToOneOverTwoDenominatorWhere(12));
    }

    @Test
    void orderedFractionBetweenOneOverFromDenominatorToOneOverTwoDenominatorWhere13() {
        assertEquals(9,Problem73.orderedFractionBetweenOneOverFromDenominatorToOneOverTwoDenominatorWhere(13));
    }

    @Test
    void orderedFractionBetweenOneOverFromDenominatorToOneOverTwoDenominatorWhere14() {
        assertEquals(10,Problem73.orderedFractionBetweenOneOverFromDenominatorToOneOverTwoDenominatorWhere(14));
    }

    @Test
    void orderedFractionBetweenOneOverFromDenominatorToOneOverTwoDenominatorWhere15() {
        assertEquals(11,Problem73.orderedFractionBetweenOneOverFromDenominatorToOneOverTwoDenominatorWhere(15));
    }

    @Test
    void orderedFractionBetweenOneOverFromDenominatorToOneOverTwoDenominatorWhere16() {
        assertEquals(12,Problem73.orderedFractionBetweenOneOverFromDenominatorToOneOverTwoDenominatorWhere(16));
    }

    @Test
    void orderedFractionBetweenOneOverFromDenominatorToOneOverTwoDenominatorWhere20() {
        assertEquals(21,Problem73.orderedFractionBetweenOneOverFromDenominatorToOneOverTwoDenominatorWhere(20));
    }

    @Test
    void orderedFractionBetweenOneOverFromDenominatorToOneOverTwoDenominatorWhere21() {
        assertEquals(23,Problem73.orderedFractionBetweenOneOverFromDenominatorToOneOverTwoDenominatorWhere(21));
    }

    @Test
    void orderedFractionBetweenOneOverFromDenominatorToOneOverTwoDenominatorWhere22() {
        assertEquals(24,Problem73.orderedFractionBetweenOneOverFromDenominatorToOneOverTwoDenominatorWhere(22));
    }

    @Test
    void orderedFractionBetweenOneOverFromDenominatorToOneOverTwoDenominatorWhere23() {
        assertEquals(28,Problem73.orderedFractionBetweenOneOverFromDenominatorToOneOverTwoDenominatorWhere(23));
    }

    @Test
    void orderedFractionBetweenOneOverFromDenominatorToOneOverTwoDenominatorWhere24() {
        assertEquals(29,Problem73.orderedFractionBetweenOneOverFromDenominatorToOneOverTwoDenominatorWhere(24));
    }

    @Test
    void orderedFractionBetweenOneOverFromDenominatorToOneOverTwoDenominatorWhere25() {
        assertEquals(29,Problem73.orderedFractionBetweenOneOverFromDenominatorToOneOverTwoDenominatorWhere(24));
    }

    @Test
    void orderedFractionBetweenOneOverFromDenominatorToOneOverTwoDenominatorWhere26() {
        assertEquals(34,Problem73.orderedFractionBetweenOneOverFromDenominatorToOneOverTwoDenominatorWhere(26));
    }

    @Test
    void orderedFractionBetweenOneOverFromDenominatorToOneOverTwoDenominatorWhere29() {
        assertEquals(44,Problem73.orderedFractionBetweenOneOverFromDenominatorToOneOverTwoDenominatorWhere(29));
    }

    @Test
    void orderedFractionBetweenOneOverFromDenominatorToOneOverTwoDenominatorWhere30() {
        assertEquals(46,Problem73.orderedFractionBetweenOneOverFromDenominatorToOneOverTwoDenominatorWhere(30));
    }

    @Test
    void calculateFractionCountBetweenNumbersWhereDenominatorLTELimit() {
        int[] expected = {0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 1, 2, 1, 2, 2, 2, 2, 3, 2, 3, 3, 3, 3, 4, 3, 4, 4, 4, 4, 5, 4};
        int[] numberOfFractions = new int[30 + 1];

        for (int d = 3 + 1; d <= 30; d++) {
            int fromNumeratorInTermsOfThisD = d / 3;
            int toNumeratorInTermsOfThisD = (d + 2 - 1) / 2;
            numberOfFractions[d] = toNumeratorInTermsOfThisD - fromNumeratorInTermsOfThisD - 1;
        }

        assertArrayEquals(expected, numberOfFractions);
    }
}