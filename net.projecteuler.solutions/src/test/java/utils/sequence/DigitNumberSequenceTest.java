package utils.sequence;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import utils.sequence.given.DigitNumberSequence;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class DigitNumberSequenceTest {
    private static final DigitNumberSequence DIGIT_NUMBER_SEQUENCE = DigitNumberSequence.of("0123456789");

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4,5,6,7,8,9})
    void checkSequence(int expected) {
        assertTrue(DIGIT_NUMBER_SEQUENCE.hasNext());
        assertEquals(expected, DIGIT_NUMBER_SEQUENCE.next());
        if(expected == 9) {
            assertFalse(DIGIT_NUMBER_SEQUENCE.hasNext());
            assertThrows(NoSuchElementException.class, DIGIT_NUMBER_SEQUENCE::next);
        }
    }
}