package problem.no31to40;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static utils.BigIntegerConstants.big;

class Problem37Test {
    @Test
    void sumOfTruncatablePrimes() {
        assertEquals(big(23), Problem37.sumOfTruncatablePrimes(1));
    }
}