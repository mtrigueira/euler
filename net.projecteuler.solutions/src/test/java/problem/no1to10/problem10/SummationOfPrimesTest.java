package problem.no1to10.problem10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SummationOfPrimesTest {
    @Test
    void forZero() {
        assertEquals(0, SummationOfPrimes.below(0));
    }

    @Test
    void forThree() {
        assertEquals(2, SummationOfPrimes.below(3));
    }

    @Test
    void forFour() {
        assertEquals(17, SummationOfPrimes.below(10));
    }
}