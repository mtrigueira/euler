package problem14;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class LongestCollatzSequenceTest {
    static int valueIndexIsChainLength = 0;
    @ParameterizedTest
    @ValueSource(ints = {2,4,8,16,5,10,20,40,13})
    void chainLength(int n) {
        valueIndexIsChainLength++;
        assertEquals(valueIndexIsChainLength, LongestCollatzSequence.chainLength(n));
    }

    @Test
    void getMaxChainLengthNumberForNaturalNumbersBelow() {
        assertEquals(9, LongestCollatzSequence.getMaxChainLengthNumberForNaturalNumbersBelow(14));
    }
}