package problem3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class LargestPrimeFactorTest {
    @ParameterizedTest
    @CsvSource({
            "2, 2",
            "3, 3",
            "4, 2",
            "5, 5",
            "6, 3",
            "7, 7",
            "8, 2",
            "9, 3",
            "10, 5",
            "11, 11",
            "12, 3",
            "13, 13",
            "14, 7",
            "15, 5",
            "16, 2",
            "17, 17",
            "18, 3",
            "19, 19",
            "20, 5",
            "29, 29",
            "13195, 29"
    })
    void testLargestPrimeFactor(int i, int expected) {
        assertEquals(expected, LargestPrimeFactor.largestPrimeFactor(i));
    }
}