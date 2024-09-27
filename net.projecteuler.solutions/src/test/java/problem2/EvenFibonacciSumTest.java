package problem2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class EvenFibonacciSumTest {
    @ParameterizedTest
    @CsvSource({
            "0, 0",
            "2, 2",
            "10, 8",
            "44, 34",
            "188, 144",
            "798, 610",
            "3382, 2584",
            "14328, 10946",
            "60696, 46368",
            "257114, 196418",
            "1089154, 832040",
            "4613732, 3524578"
    })
    void assertSumForLimit(int expected, int limit) {
        assertEquals(expected, EvenFibonacciSum.sum(limit));
    }
}