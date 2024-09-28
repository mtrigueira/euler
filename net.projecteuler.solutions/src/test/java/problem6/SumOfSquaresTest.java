package problem6;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class SumOfSquaresTest {
    @ParameterizedTest
    @CsvSource({
            "1, 1",
            "2, 5",
            "3, 14",
            "4, 30",
            "10, 385",
            "100, 338350"
    })
    void sumOfSquaresIs(int i, int expected) {
        assertEquals(expected,SumOfSquares.of(i));
    }
}