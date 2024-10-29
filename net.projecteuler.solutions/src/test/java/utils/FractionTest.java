package utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static utils.BigIntegerConstants.big;

class FractionTest {
    @Test
    void notEqualsTest() {
        Fraction f1 = new Fraction(big(1), big(1), "1/1") {
        };
        // noinspection SimplifiableAssertion,EqualsBetweenInconvertibleTypes
        assertFalse(f1.equals("Dummy"));
    }
}
