package problem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem30Test {
    @Test
    void sumForExponentDigitPowers() {
        assertEquals(19316, Problem30.sumWhereDigitPowersSumEqualsNumberFor(4));
    }
}