package problem.no21to30;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static utils.BigIntegerConstants.big;

class Problem26Test {
    @Test
    void indexOfLargestReciprocalCycle() {
        assertEquals(big(7),Problem26.indexOfLargestReciprocalCycle(11));
    }
}