package utils.sequence;

import org.junit.jupiter.api.Test;
import utils.sequence.arithmetic.IntegerSequence;

import static org.junit.jupiter.api.Assertions.*;

class CachedSequenceTest {
    final IntegerSequence integerSequence = new IntegerSequence(0);

    @Test
    void cachedSequence() {
        CachedSequence<Integer> cachedSequence = CachedSequence.of(integerSequence);
        assertTrue(cachedSequence.hasNext());
        assertEquals(1, cachedSequence.next());
        assertTrue(cachedSequence.hasNext());
        assertEquals(2, cachedSequence.next());
        assertTrue(cachedSequence.hasNext());
        assertEquals(3, cachedSequence.next());
        assertTrue(cachedSequence.hasNext());
        cachedSequence.reset();
        assertTrue(cachedSequence.hasNext());
        assertEquals(1, cachedSequence.next());
        assertTrue(cachedSequence.hasNext());
        assertEquals(2, cachedSequence.next());
        assertTrue(cachedSequence.hasNext());
        assertEquals(3, cachedSequence.next());
        assertTrue(cachedSequence.hasNext());
    }
}