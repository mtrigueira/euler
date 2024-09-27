package problem2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class EvenFibonacciTest {
    @ParameterizedTest
    @CsvSource({
            "0, 0",
            "2, 2",
            "10, 8",
            "44, 34"
    })
    void assertSumForLimit(int expected, int limit) {
        assertEquals(expected, EvenFibonacci.sum(limit));
    }
}