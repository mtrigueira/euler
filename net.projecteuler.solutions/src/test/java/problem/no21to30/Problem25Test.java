package problem.no21to30;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem25Test {
    @Test
    void fibonacci() {
        assertEquals(12, Problem25.indexOfFirstFibonacciNumberWithLengthAtLeast(3));
    }
}