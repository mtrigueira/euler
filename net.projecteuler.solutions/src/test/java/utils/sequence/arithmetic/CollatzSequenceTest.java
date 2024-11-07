package utils.sequence.arithmetic;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CollatzSequenceTest {
    static final CollatzSequence collatzSequence = CollatzSequence.of(13);

    @ParameterizedTest
    @ValueSource(ints = {13,40,20,10,5,16,8,4,2})
    void shouldReturnCorrectCollatzSequence(int number) {
        assertEquals(number, collatzSequence.next().longValueExact());
    }

    static int valueIndexIsChainLength = 0;
    @ParameterizedTest
    @ValueSource(ints = {2,4,8,16,5,10,20,40,13})
    void chainLength(int n) {
        valueIndexIsChainLength++;
        assertEquals(valueIndexIsChainLength, CollatzSequence.of(n).count());
    }
}