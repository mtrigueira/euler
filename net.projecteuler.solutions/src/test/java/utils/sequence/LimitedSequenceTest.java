package utils.sequence;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class LimitedSequenceTest {
    final LimitedSequence<Integer> limitedSequence = LimitedSequence.of(new IntegerSequence(),2);

    @Test
    void limitedSequence() {
        assertTrue(limitedSequence.hasNext());
        assertEquals(1, limitedSequence.next());
        assertTrue(limitedSequence.hasNext());
        assertEquals(2, limitedSequence.next());
        assertFalse(limitedSequence.hasNext());
        assertThrows(NoSuchElementException.class, limitedSequence::next);
    }
}