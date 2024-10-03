package problem21;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class AmicableNumbersTest {
    @ParameterizedTest
    @CsvSource({"220,284","1184,1210","2620,2924"})
    void areAmicable220and284(int a, int b) {
        assertTrue(new AmicableNumbers(b).areAmicable(a, b));
    }

    @Test
    void areNotAmicable11() {
        assertFalse(new AmicableNumbers(11).areAmicable(1, 1));
    }

    @ParameterizedTest
    @ValueSource(ints = {220,284,1184,1210,2620,2924})
    void hasAmicable(int a) {
        assertTrue(new AmicableNumbers(2924).hasAmicable(a));
    }

    @ParameterizedTest
    @ValueSource(ints = {221,285,1185,1211,2621,2923})
    void hasNoAmicable(int a) {
        assertFalse(new AmicableNumbers(2924).hasAmicable(a));
    }

}