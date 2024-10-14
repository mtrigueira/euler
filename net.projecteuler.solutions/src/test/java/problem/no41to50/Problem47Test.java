package problem.no41to50;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem47Test {

    @Test
    void first2ConsecutiveIntegersToHaveFourDistinctPrimes() {
        assertEquals(14, Problem47.firstNConsecutiveIntegersToHaveFourDistinctPrimes(2).orElseThrow().intValueExact());
    }


    @Test
    void first3ConsecutiveIntegersToHaveFourDistinctPrimes() {
        assertEquals(644, Problem47.firstNConsecutiveIntegersToHaveFourDistinctPrimes(3).orElseThrow().intValueExact());
    }
}