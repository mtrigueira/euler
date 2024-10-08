package utils;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class FractionTest {
    @ParameterizedTest
    @ValueSource(ints = {3, 6, 7, 9})
    void isReciprocalCycle(int i) {
        assertTrue(Fraction.of(1, i).isReciprocalCycle());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 4, 5, 8, 10})
    void isNotReciprocalCycle(int i) {
        assertFalse(Fraction.of(1, i).isReciprocalCycle());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 4, 5, 8, 10})
    void fractionsMatchJava(int i) {
        assertEquals(Double.toString(1.0/i), Fraction.of(1, i).toString());
    }
}