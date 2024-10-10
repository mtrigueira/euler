package problem.no21to30;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigInteger;
import java.util.OptionalInt;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem28Test {
    @Test
    void layersInGridOfSizeNxN() {
        assertEquals(OptionalInt.of(1), Problem28.layersInGridOfSizeNxN(1));
        assertEquals(OptionalInt.empty(), Problem28.layersInGridOfSizeNxN(2));
        assertEquals(OptionalInt.of(2), Problem28.layersInGridOfSizeNxN(3));
        assertEquals(OptionalInt.empty(), Problem28.layersInGridOfSizeNxN(4));
        assertEquals(OptionalInt.of(3), Problem28.layersInGridOfSizeNxN(5));
    }

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