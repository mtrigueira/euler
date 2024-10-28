package problem.no1to10;

import org.junit.jupiter.params.ParameterizedTest;
import utils.operator.Factorial;

import static org.junit.jupiter.api.Assertions.*;

class Problem5Test {
    @ParameterizedTest(name = "Smallest multiple of {1} should be {0}")
    @org.junit.jupiter.params.provider.CsvSource({
            "1, 1",
            "2, 2",
            "6, 3",
            "12, 4",
            "60, 5",
            "60, 6",
            "420, 7",
            "840, 8",
            "2520, 9",
            "2520, 10",
            "27720, 11",
            "27720, 12",
            "360360, 13"
    })
    void assertMultipleOf(int expected, int i) {
        assertEquals(expected, Problem5.smallestEvenlyDivisibleByAllNaturalNumbersBelow(i));
    }

    @ParameterizedTest(name = "{1}! should be {0}")
    @org.junit.jupiter.params.provider.CsvSource({
            "1, 1",
            "2, 2",
            "6, 3",
            "24, 4",
            "120, 5",
            "3628800, 10",
            "39916800, 11",
            "2432902008176640000, 20"
    })
    void factorial(long expected, int i) {
        assertEquals(expected, Factorial.of(i));
    }
}