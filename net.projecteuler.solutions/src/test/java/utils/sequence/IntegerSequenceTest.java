package utils.sequence;

import org.junit.jupiter.api.Test;
import utils.sequence.arithmetic.IntegerSequence;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class IntegerSequenceTest {
    final Sequence<Integer> integerSequence = new IntegerSequence(0);

    @Test
    void testSequence() {
        assertEquals(1, integerSequence.next());
        assertEquals(2, integerSequence.next());
        assertEquals(3, integerSequence.next());
    }

    @Test
    void testOverflow() {
        assertThrows(ArithmeticException.class, () ->
                new IntegerSequence(Integer.MAX_VALUE).next());
    }
}