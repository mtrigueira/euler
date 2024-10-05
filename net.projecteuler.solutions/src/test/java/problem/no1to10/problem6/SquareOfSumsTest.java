package problem.no1to10.problem6;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class SquareOfSumsTest {
    @ParameterizedTest
    @CsvSource({
            "1, 1",
            "2, 9",
            "3, 36",
            "4, 100",
            "10, 3025"
    })

    void sumOfSquaresIs(int i, int expected) {
        assertEquals(expected, SquareOfSums.of(i));
    }
}