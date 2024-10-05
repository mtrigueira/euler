package problem.no11to20.problem20;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactorialDigitSumTest {
    @Test
    void One() {
        assertEquals(1, FactorialDigitSum.sumOfFactorial(1));
    }

    @Test
    void Two() {
        assertEquals(2, FactorialDigitSum.sumOfFactorial(2));
    }

    @Test
    void Three() {
        assertEquals(6, FactorialDigitSum.sumOfFactorial(3));
    }

    @Test
    void Four() {
        assertEquals(6, FactorialDigitSum.sumOfFactorial(4));
    }

    @Test
    void Ten() {
        assertEquals(27, FactorialDigitSum.sumOfFactorial(10));
    }
}