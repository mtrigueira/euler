package problem.no61to70;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem73Test {
    @Test
    void orderedFractionBetweenWhere4() {
        assertEquals(0,Problem73.orderedFractionBetweenWhere(3, 2,4));
    }

    @Test
    void orderedFractionBetweenWhere5() {
        assertEquals(1,Problem73.orderedFractionBetweenWhere(3, 2,5));
    }

    @Test
    void orderedFractionBetweenWhere6() {
        assertEquals(1,Problem73.orderedFractionBetweenWhere(3, 2,6));
    }

    @Test
    void orderedFractionBetweenWhere7() {
        assertEquals(2,Problem73.orderedFractionBetweenWhere(3, 2,7));
    }

    @Test
    void orderedFractionBetweenWhere8() {
        assertEquals(3,Problem73.orderedFractionBetweenWhere(3, 2,8));
    }

    @Test
    void orderedFractionBetweenWhere9() {
        assertEquals(4,Problem73.orderedFractionBetweenWhere(3, 2,9));
    }

    @Test
    void orderedFractionBetweenWhere10() {
        assertEquals(4,Problem73.orderedFractionBetweenWhere(3, 2,10));
    }

    @Test
    void orderedFractionBetweenWhere11() {
        assertEquals(6,Problem73.orderedFractionBetweenWhere(3, 2,11));
    }

    @Test
    void orderedFractionBetweenWhere12() {
        assertEquals(7,Problem73.orderedFractionBetweenWhere(3, 2,12));
    }

    @Test
    void orderedFractionBetweenWhere13() {
        assertEquals(9,Problem73.orderedFractionBetweenWhere(3, 2,13));
    }

    @Test
    void orderedFractionBetweenWhere14() {
        assertEquals(10,Problem73.orderedFractionBetweenWhere(3, 2,14));
    }

    @Test
    void orderedFractionBetweenWhere15() {
        assertEquals(11,Problem73.orderedFractionBetweenWhere(3, 2,15));
    }

    @Test
    void orderedFractionBetweenWhere16() {
        assertEquals(12,Problem73.orderedFractionBetweenWhere(3, 2,16));
    }

    @Test
    void orderedFractionBetweenWhere20() {
        assertEquals(21,Problem73.orderedFractionBetweenWhere(3, 2,20));
    }

    @Test
    void orderedFractionBetweenWhere21() {
        assertEquals(23,Problem73.orderedFractionBetweenWhere(3, 2,21));
    }

    @Test
    void orderedFractionBetweenWhere22() {
        assertEquals(24,Problem73.orderedFractionBetweenWhere(3, 2,22));
    }

    @Test
    void orderedFractionBetweenWhere23() {
        assertEquals(28,Problem73.orderedFractionBetweenWhere(3, 2,23));
    }

    @Test
    void orderedFractionBetweenWhere24() {
        assertEquals(29,Problem73.orderedFractionBetweenWhere(3, 2,24));
    }

    @Test
    void orderedFractionBetweenWhere25() {
        assertEquals(29,Problem73.orderedFractionBetweenWhere(3, 2,24));
    }

    @Test
    void orderedFractionBetweenWhere26() {
        assertEquals(34,Problem73.orderedFractionBetweenWhere(3, 2,26));
    }

    @Test
    void orderedFractionBetweenWhere29() {
        assertEquals(44,Problem73.orderedFractionBetweenWhere(3, 2,29));
    }

    @Test
    void orderedFractionBetweenWhere30() {
        assertEquals(46,Problem73.orderedFractionBetweenWhere(3, 2,30));
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