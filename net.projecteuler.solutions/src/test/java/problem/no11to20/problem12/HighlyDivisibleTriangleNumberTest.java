package problem.no11to20.problem12;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HighlyDivisibleTriangleNumberTest {
    @Test
    void countFactors0() {
        assertEquals(0, HighlyDivisibleTriangleNumber.countFactors(0));
    }

    @Test
    void countFactors1() {
        assertEquals(1, HighlyDivisibleTriangleNumber.countFactors(1));
    }

    @Test
    void countFactors3() {
        assertEquals(2, HighlyDivisibleTriangleNumber.countFactors(3));
    }

    @Test
    void countFactors6() {
        assertEquals(4, HighlyDivisibleTriangleNumber.countFactors(6));
    }

    @Test
    void countFactors28() {
        assertEquals(6, HighlyDivisibleTriangleNumber.countFactors(28));
    }

    @Test
    void withOver5() {
        assertEquals(28, HighlyDivisibleTriangleNumber.withOver(5));
    }

    @Test
    void withOver6() {
        assertEquals(28, HighlyDivisibleTriangleNumber.withOver(6));
    }
}