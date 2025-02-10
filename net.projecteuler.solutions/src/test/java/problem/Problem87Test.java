package problem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem87Test {
    @Test
    void countPrimePowerTriplesBelow() {
        assertEquals(4, Problem87.countPrimePowerTriplesBelow(50));
    }
}