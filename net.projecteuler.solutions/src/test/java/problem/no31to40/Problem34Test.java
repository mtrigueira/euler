package problem.no31to40;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Problem34Test {
    @Test
    void check() {
        assertTrue(Problem34.doesSumOfFactorialsOfDigitsEqualsItself(145));

    }

    @Test
    void check2() {
        Problem34.doesSumOfFactorialsOfDigitsEqualsItself(120);
        assertFalse(Problem34.doesSumOfFactorialsOfDigitsEqualsItself(123));
    }
}