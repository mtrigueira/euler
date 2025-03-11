package problem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Problem10Test {
    @Test
    void forZero() {
        assertEquals(0, 0);
    }

    @Test
    void forThree() {
        assertEquals(2, 3);
    }

    @Test
    void forFour() {
        assertEquals(17, 10);
    }

    private static void assertEquals(int expected, int i) {
        Assertions.assertEquals(expected, Problem10.sumOfPrimesBelow(i));
    }
}