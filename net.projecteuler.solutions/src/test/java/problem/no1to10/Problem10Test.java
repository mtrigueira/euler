package problem.no1to10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

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
        Assertions.assertEquals(BigInteger.valueOf(expected), Problem10.sumOfPrimesBelow(i));
    }
}