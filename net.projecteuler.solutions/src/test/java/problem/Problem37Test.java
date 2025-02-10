package problem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Problem37Test {
    @Test
    void sumOfTruncatablePrimes() {
        assertEquals(23, Problem37.sumOfTruncatablePrimes(1));
    }

    @Test
    void testSumOfTruncatablePrimes() {
        assertThrows(IllegalArgumentException.class, () -> Problem37.sumOfTruncatablePrimes(60));
    }
}