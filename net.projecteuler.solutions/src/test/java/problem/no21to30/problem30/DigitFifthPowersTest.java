package problem.no21to30.problem30;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DigitFifthPowersTest {
    @Test
    void sumForExponentDigitPowers() {
        assertEquals(19316, DigitFifthPowers.sumWhereDigitPowersSumEqualsNumberFor(4));
    }
}