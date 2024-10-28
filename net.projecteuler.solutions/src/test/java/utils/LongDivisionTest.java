package utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static utils.BigIntegerConstants.big;

class LongDivisionTest {

    @Test
    void nextDigit1div2() {
        LongDivision longDivision = LongDivision.of(1,2);
        assertEquals(0, longDivision.nextDigit());
        assertEquals(5, longDivision.nextDigit());
        assertEquals(0, longDivision.nextDigit());
    }

    @Test
    void nextDigit1div3() {
        LongDivision longDivision = LongDivision.of(1,3);
        assertEquals(0, longDivision.nextDigit());
        assertEquals(3, longDivision.nextDigit());
        assertEquals(3, longDivision.nextDigit());
        assertEquals(3, longDivision.nextDigit());
        assertEquals(3, longDivision.nextDigit());
        assertEquals(3, longDivision.nextDigit());
        assertEquals(3, longDivision.nextDigit());
    }

    @Test
    void nextDigit1div101() {
        LongDivision longDivision = LongDivision.of(1,101);
        assertEquals(0, longDivision.nextDigit());
        assertEquals(0, longDivision.nextDigit());
        assertEquals(0, longDivision.nextDigit());
        assertEquals(9, longDivision.nextDigit());
        assertEquals(9, longDivision.nextDigit());
        assertEquals(0, longDivision.nextDigit());
        assertEquals(0, longDivision.nextDigit());
        assertEquals(9, longDivision.nextDigit());
        assertEquals(9, longDivision.nextDigit());
    }

    @Test
    void bigPairNeq() {
        LongDivision.BigPair a = LongDivision.BigPair.of(big(1), big(2));
        LongDivision.BigPair b = LongDivision.BigPair.of(big(1), big(3));

        assertNotEquals(a, b);

        // noinspection SimplifiableAssertion,EqualsBetweenInconvertibleTypes
        assertFalse(b.equals("dummy"));
    }
}