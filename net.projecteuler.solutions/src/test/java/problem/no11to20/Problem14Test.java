package problem.no11to20;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem14Test {
    @Test
    void getMaxChainLengthNumberForNaturalNumbersBelow() {
        assertEquals(9, Problem14.getMaxChainLengthNumberForNaturalNumbersBelow(14));
    }
}