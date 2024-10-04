package utils.sequence;

import org.junit.jupiter.api.Test;
import utils.Sequence;

import static org.junit.jupiter.api.Assertions.*;

class CachedSequenceTest {
    Sequence testSequence = new Sequence() {
        private long i = 1;
        @Override
        public long next() {
            return i++;
        }
    };

    @Test
    void testSequence() {
        Sequence cachedSequence = testSequence;
        assertEquals(1, cachedSequence.next());
        assertEquals(2, cachedSequence.next());
        assertEquals(3, cachedSequence.next());
    }

    @Test
    void cachedSequence() {
        CachedSequence cachedSequence = CachedSequence.of(testSequence);
        assertEquals(1, cachedSequence.next());
        assertEquals(2, cachedSequence.next());
        assertEquals(3, cachedSequence.next());
        cachedSequence.reset();
        assertEquals(1, cachedSequence.next());
        assertEquals(2, cachedSequence.next());
        assertEquals(3, cachedSequence.next());
    }
}