package problem.no21to30;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem28Test {
    @ParameterizedTest(name = "f({1}) = {0}")
    @CsvSource({
            "1, 1",
            "25, 3",
            "101, 5",
            "961, 11"
    })
    void sumOfDiagonalsInAGridOfSizeNxN(int expected, int gridSize) {
        assertEquals(expected, Problem28.sumOfDiagonalsInAGridOfSizeNxN(gridSize));
    }
}