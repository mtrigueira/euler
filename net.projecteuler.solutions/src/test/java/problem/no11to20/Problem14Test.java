package problem.no11to20;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem14Test {
    static int valueIndexIsChainLength = 0;
    @ParameterizedTest
    @ValueSource(ints = {2,4,8,16,5,10,20,40,13})
    void chainLength(int n) {
        valueIndexIsChainLength++;
        assertEquals(valueIndexIsChainLength, Problem14.chainLength(n));
    }

    @Test
    void getMaxChainLengthNumberForNaturalNumbersBelow() {
        assertEquals(9, Problem14.getMaxChainLengthNumberForNaturalNumbersBelow(14));
    }
}