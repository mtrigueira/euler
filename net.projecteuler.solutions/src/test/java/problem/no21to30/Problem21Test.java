package problem.no21to30;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import utils.Amicable;

import static org.junit.jupiter.api.Assertions.*;

class Problem21Test {
    @ParameterizedTest
    @CsvSource({"220,284", "1184,1210", "2620,2924"})
    void areAmicable220and284(int a, int b) {
        assertTrue(new Amicable(b).areAmicable(a, b));
    }

    @Test
    void areNotAmicable11() {
        assertFalse(new Amicable(11).areAmicable(1, 1));
    }

    @ParameterizedTest
    @ValueSource(ints = {220, 284, 1184, 1210, 2620, 2924})
    void hasAmicable(int a) {
        assertTrue(new Amicable(2924).hasAmicable(a));
    }

    @ParameterizedTest
    @ValueSource(ints = {221, 285, 1185, 1211, 2621, 2923})
    void hasNoAmicable(int a) {
        assertFalse(new Amicable(2924).hasAmicable(a));
    }

    @Test
    void below220() {
        assertTrue(new Amicable(221).hasAmicable(220));
    }

    @Test
    void sumBelow220() {
        assertEquals(0, Problem21.below(220));
    }
}