package problem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static problem.Problem3.largestPrimeFactorOrNotFound;

class Problem3Test {
    @Test
    void testLargestPrimeFactorOf13195() {
        assertEquals("29", largestPrimeFactorOrNotFound(13195L));
    }

    @Test
    void testLargestPrimeFactorOf1() {
        assertEquals("No prime factor found", largestPrimeFactorOrNotFound(1L));
    }
}