package utils.sequence.arithmetic;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TriangleNumberSequenceTest {
    static final TriangleNumberSequence triangleNumberSequence = new TriangleNumberSequence(0L);
    @ParameterizedTest
    @ValueSource(longs =   {1,3,6,10,15,21,28})
    void getTriangleNumber(long next) {
        assertEquals(next, triangleNumberSequence.next());
    }

    @Test
    void overFlowTest() {
        TriangleNumberSequence triangleNumberSequence = new TriangleNumberSequence(Long.MAX_VALUE);
        assertThrows(ArithmeticException.class, triangleNumberSequence::next);
    }
}