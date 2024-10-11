package utils.sequence;

import org.junit.jupiter.api.Test;
import utils.sequence.arithmetic.IntegerSequence;

import static org.junit.jupiter.api.Assertions.*;

class IntegerSequenceTest {
    final Sequence<Integer> integerSequence = new IntegerSequence();

    @Test
    void testSequence() {
        assertEquals(1, integerSequence.next());
        assertEquals(2, integerSequence.next());
        assertEquals(3, integerSequence.next());
    }
}