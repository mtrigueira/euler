package problem.no31to40.problem34;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DigitFactorialsTest {
    @Test
    void check() {
        assertTrue(DigitFactorials.doesSumOfFactorialsOfDigitsEqualsItself(145));

    }

    @Test
    void check2() {
        DigitFactorials.doesSumOfFactorialsOfDigitsEqualsItself(120);
        assertFalse(DigitFactorials.doesSumOfFactorialsOfDigitsEqualsItself(123));
    }
}