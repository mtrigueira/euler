package utils.sequence.arithmetic;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static utils.BigIntegerConstants.big;

class LycrhelSequenceTest {
    private LycrhelSequence f;

    @Test
    void lycrhel47Test() {
        f = new LycrhelSequence(47);
        assertFalse(f.hasNext());
        assertThrows(NoSuchElementException.class, () -> f.next());
    }

    @Test
    void lycrhel347Test() {
        f = new LycrhelSequence(349);
        assertTrue(f.hasNext());
        assertEquals(big(1292), f.next());
        assertTrue(f.hasNext());
        assertEquals(big(4213), f.next());
        assertFalse(f.hasNext());
        assertThrows(NoSuchElementException.class, () -> f.next());
    }


    @Test
    void lycrhel10677Test() {
        f = new LycrhelSequence(10677);

        for (int i = 0; i <= 50; i++) {
            assertTrue(f.hasNext());
            f.next();
        }
    }
}