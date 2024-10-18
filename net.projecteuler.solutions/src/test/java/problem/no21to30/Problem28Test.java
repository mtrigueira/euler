package problem.no21to30;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem28Test {


    @ParameterizedTest
    @CsvSource({
            "1, 1",
            "25, 3",
            "101, 5",
            "961, 11"
    })
    void sumOfDiagonalsInAGridOfSize1x1(int expected, int gridSize) {
        assertEquals(BigInteger.valueOf(expected), Problem28.sumOfDiagonalsInAGridOfSizeNxN(gridSize));
    }
}