package problem.no61to70;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem69Test {
    @Test
    void maximumTotient() {
        assertEquals(6, Problem69.maximumTotient(10));
        assertEquals(6, Problem69.maximumTotientBruteForce(10));
        assertEquals(6, Problem69.maximumTotientPrimeProduct(10));
        assertEquals(30, Problem69.maximumTotientBruteForce(100));
        assertEquals(30, Problem69.maximumTotientPrimeProduct(100));
    }
}