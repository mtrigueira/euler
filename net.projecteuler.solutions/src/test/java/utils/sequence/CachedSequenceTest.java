package utils.sequence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CachedSequenceTest {
    final Sequence<Integer> simpleTestSequence = new Sequence<>() {
        private int i = 0;

        @Override
        public Integer next() {
            i++;
            return i;
        }
    };

    @Test
    void testSequence() {
        assertEquals(1, simpleTestSequence.next());
        assertEquals(2, simpleTestSequence.next());
        assertEquals(3, simpleTestSequence.next());
    }

    @Test
    void cachedSequence() {
        CachedSequence<Integer> cachedSequence = CachedSequence.of(simpleTestSequence);
        assertEquals(1, cachedSequence.next());
        assertEquals(2, cachedSequence.next());
        assertEquals(3, cachedSequence.next());
        cachedSequence.reset();
        assertEquals(1, cachedSequence.next());
        assertEquals(2, cachedSequence.next());
        assertEquals(3, cachedSequence.next());
    }
}