package problem.no11to20;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem20Test {
    @Test
    void One() {
        assertEquals(1, Problem20.sumOfFactorial(1));
    }

    @Test
    void Two() {
        assertEquals(2, Problem20.sumOfFactorial(2));
    }

    @Test
    void Three() {
        assertEquals(6, Problem20.sumOfFactorial(3));
    }

    @Test
    void Four() {
        assertEquals(6, Problem20.sumOfFactorial(4));
    }

    @Test
    void Ten() {
        assertEquals(27, Problem20.sumOfFactorial(10));
    }
}