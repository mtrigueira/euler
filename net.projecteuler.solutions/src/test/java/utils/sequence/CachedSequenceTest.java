package utils.sequence;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.ZERO;
import static org.junit.jupiter.api.Assertions.*;

class CachedSequenceTest {
    final Sequence testSequence = new Sequence() {
        private BigInteger i = ZERO;
        @Override
        public BigInteger next() {
            i = i.add(ONE);
            return i;
        }
    };

    @Test
    void testSequence() {
        Sequence cachedSequence = testSequence;
        assertEquals(1, cachedSequence.next().longValueExact());
        assertEquals(2, cachedSequence.next().longValueExact());
        assertEquals(3, cachedSequence.next().longValueExact());
    }

    @Test
    void cachedSequence() {
        CachedSequence cachedSequence = CachedSequence.of(testSequence);
        assertEquals(1, cachedSequence.next().longValueExact());
        assertEquals(2, cachedSequence.next().longValueExact());
        assertEquals(3, cachedSequence.next().longValueExact());
        cachedSequence.reset();
        assertEquals(1, cachedSequence.next().longValueExact());
        assertEquals(2, cachedSequence.next().longValueExact());
        assertEquals(3, cachedSequence.next().longValueExact());
    }
}