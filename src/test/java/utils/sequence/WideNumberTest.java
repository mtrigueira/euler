package utils.sequence;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import utils.sequence.given.WideNumberSequence;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class WideNumberTest {
    private static final WideNumberSequence seriesTwoDigitsWide = new WideNumberSequence("0123456789", 2);
    private static final WideNumberSequence seriesWide = new WideNumberSequence("0123456789", 10);

    @ParameterizedTest
    @ValueSource(ints = {1, 12, 23, 34, 45, 56, 67, 78, 89})
    void cruise2(int expected) {
        assertEquals(expected, seriesTwoDigitsWide.next());
    }

    @Test
    void onlyOneWideNumber() {
        assertEquals(123456789, seriesWide.next());
        assertFalse(seriesWide.hasNext());
    }

    @Test
    void noSuchElement() {
        WideNumberSequence seq = new WideNumberSequence("2", 1);
        seq.next();
        assertFalse(seq.hasNext());
        assertThrows(NoSuchElementException.class, seq::next);
    }

    @Test
    void arithmeticException() {
        WideNumberSequence seq = new WideNumberSequence("#", 1);
        assertTrue(seq.hasNext());
        assertThrows(NoSuchElementException.class, seq::next);
    }
}