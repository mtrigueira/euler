package utils.roman;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RomanDigitTest {
    @Test
    void testEquals() {
        assertEquals(RomanDigit.M, RomanDigit.romanDigit("M"));
        assertNotEquals(RomanDigit.M, RomanDigit.romanDigit("X"));
        //noinspection SimplifiableAssertion
        assertFalse(RomanDigit.M.equals(new Object()));
    }

    @Test
    void testHashCode() {
        assertEquals(RomanDigit.M.hashCode(), RomanDigit.romanDigit("M").hashCode());
    }
}