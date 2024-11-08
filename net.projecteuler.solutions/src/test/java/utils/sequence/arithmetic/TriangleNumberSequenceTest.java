package utils.sequence.arithmetic;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TriangleNumberSequenceTest {
    static final TriangleNumberSequence triangleNumberSequence = new TriangleNumberSequence();
    @ParameterizedTest
    @ValueSource(longs =   {1,3,6,10,15,21,28})
    void getTriangleNumber(long next) {
        assertEquals(next, triangleNumberSequence.next());
    }
}