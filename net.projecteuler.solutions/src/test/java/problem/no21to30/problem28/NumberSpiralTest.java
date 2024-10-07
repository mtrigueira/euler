package problem.no21to30.problem28;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigInteger;
import java.util.OptionalInt;

import static org.junit.jupiter.api.Assertions.*;

class NumberSpiralTest {
    @Test
    void layersInGridOfSizeNxN() {
        assertEquals(OptionalInt.of(1), NumberSpiral.layersInGridOfSizeNxN(1));
        assertEquals(OptionalInt.empty(), NumberSpiral.layersInGridOfSizeNxN(2));
        assertEquals(OptionalInt.of(2), NumberSpiral.layersInGridOfSizeNxN(3));
        assertEquals(OptionalInt.empty(), NumberSpiral.layersInGridOfSizeNxN(4));
        assertEquals(OptionalInt.of(3), NumberSpiral.layersInGridOfSizeNxN(5));
    }

    @ParameterizedTest
    @CsvSource({
            "1, 1",
            "25, 3",
            "101, 5",
            "961, 11"
    })
    void sumOfDiagonalsInAGridOfSize1x1(int expected, int gridSize) {
        assertEquals(BigInteger.valueOf(expected), NumberSpiral.sumOfDiagonalsInAGridOfSizeNxN(gridSize));
    }
}