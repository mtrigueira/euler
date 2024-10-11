package utils.sequence;

import org.junit.jupiter.api.Test;
import utils.sequence.arithmetic.IntegerSequence;

import static org.junit.jupiter.api.Assertions.*;

class CachedSequenceTest {
    final IntegerSequence integerSequence = new IntegerSequence();

    @Test
    void cachedSequence() {
        CachedSequence<Integer> cachedSequence = CachedSequence.of(integerSequence);
        assertEquals(1, cachedSequence.next());
        assertEquals(2, cachedSequence.next());
        assertEquals(3, cachedSequence.next());
        cachedSequence.reset();
        assertEquals(1, cachedSequence.next());
        assertEquals(2, cachedSequence.next());
        assertEquals(3, cachedSequence.next());
    }
}