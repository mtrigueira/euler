package problem16;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PowerDigitSumTest {

    @Test
    void TwoToThe0() {
        assertEquals(1, PowerDigitSum.of2ToThe(0));
    }

    @Test
    void TwoToThe1() {
        assertEquals(2, PowerDigitSum.of2ToThe(1));
    }

    @Test
    void TwoToThe2() {
        assertEquals(4, PowerDigitSum.of2ToThe(2));
    }

    @Test
    void TwoToThe4() {
        assertEquals(7, PowerDigitSum.of2ToThe(4));
    }

    @Test
    void TwoToThe15() {
        assertEquals(26, PowerDigitSum.of2ToThe(15));
    }
}