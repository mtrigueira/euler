package problem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Problem34Test {
    @Test
    void sumOfFactorialsOfDigitsEqualsItself() {
        assertTrue(Problem34.doesSumOfFactorialsOfDigitsEqualsItself(145));
    }

    @Test
    void sumOfFactorialsOfDigitsDoesNotEqualItself() {
        Problem34.doesSumOfFactorialsOfDigitsEqualsItself(120);
        assertFalse(Problem34.doesSumOfFactorialsOfDigitsEqualsItself(123));
    }
}