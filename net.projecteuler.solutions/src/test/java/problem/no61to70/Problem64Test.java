package problem.no61to70;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class Problem64Test {
    @Test
    void countOddPeriodSquareRoots() {
        assertEquals(4, Problem64.countOddPeriodSquareRoots(13));
    }

    @Test
    void isPeriodOdd() {
        assertFalse(Problem64.isPeriodOdd(4));
    }
}