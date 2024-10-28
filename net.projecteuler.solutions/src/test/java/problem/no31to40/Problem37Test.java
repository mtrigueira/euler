package problem.no31to40;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static utils.BigIntegerConstants.big;

class Problem37Test {
    @Test
    void sumOfTruncatablePrimes() {
        assertEquals(big(23), Problem37.sumOfTruncatablePrimes(1));
    }

    @Test
    void testSumOfTruncatablePrimes() {
        assertThrows(IllegalArgumentException.class, () -> Problem37.sumOfTruncatablePrimes(60));
    }

}