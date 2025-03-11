package utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static utils.BigIntegerConstants.big;

class FractionTest {
    static final Fraction f1 = new Fraction(big(1), big(1)) {
        @Override
        public String toString() {
            return "1/1";
        }
    };

    @Test
    void notEqualsTest() {
        // noinspection SimplifiableAssertion,EqualsBetweenInconvertibleTypes
        assertFalse(f1.equals("Dummy"));
    }

    @Test
    void equalsTest() {
        assertEquals(f1, f1);
    }
}
