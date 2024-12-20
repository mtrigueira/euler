package problem.no81to90;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Problem89Test {
    @Test
    void Counting() {
        getAssertEquals(1, "I");
        getAssertEquals(2, "II");
        getAssertEquals(4, "IV");
        getAssertEquals(5, "V");
        getAssertEquals(6, "VI");
        getAssertEquals(9, "IX");
        getAssertEquals(10, "X");
        getAssertEquals(20, "XX");
        getAssertEquals(50, "L");
        getAssertEquals(40, "XL");
        getAssertEquals(49, "XXXXIIIIIIIII");
        getAssertEquals(49, "XXXXVIIII");
        getAssertEquals(49, "XXXXIX");
        getAssertEquals(49, "XLIIIIIIIII");
        getAssertEquals(49, "XLVIIII");
        getAssertEquals(49, "XLIX");
    }

    @Test
    void smallestToString() {
        assertEquals("MI",Roman.parseRoman("MI").toString());
    }

    private static void getAssertEquals(int expected, String romanNumerals) {
        assertEquals(expected, Roman.parseRoman(romanNumerals).intValue());
    }

    @Test
    void Invalid() {
        assertNumberFormatException("VV");
        assertNumberFormatException("LL");
        assertNumberFormatException("DD");
        assertNumberFormatException("IIV");
        assertNumberFormatException("IIX");
        assertNumberFormatException("?");
    }

    private static void assertNumberFormatException(String romanNumerals) {
        assertThrows(NumberFormatException.class, () -> Roman.parseRoman(romanNumerals));
    }
}
