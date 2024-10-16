package problem.no1to10;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Problem6Test {
    @ParameterizedTest
    @CsvSource({
            "1, 0",
            "2, 4",
            "3, 22",
            "4, 70",
            "10, 2640"
    })

    void problem6(int i, int expected) {
        assertEquals(expected, Problem6.of(i));
    }

    @ParameterizedTest
    @CsvSource({
            "1, 1",
            "2, 9",
            "3, 36",
            "4, 100",
            "10, 3025"
    })

    void squareOfSumsIs(int i, int expected) {
        assertEquals(expected, Problem6.squareOfSums(i));
    }

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
        assertEquals(expected, Problem6.sumOfSquares(i));
    }
}
