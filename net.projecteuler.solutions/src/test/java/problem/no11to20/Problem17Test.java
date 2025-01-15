package problem.no11to20;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem17Test {
    @Test
    void forNumbersTo1() {
        assertEquals(3, Problem17.forNumbersTo(1));
    }

    @Test
    void forNumbersTo5() {
        assertEquals(19, Problem17.forNumbersTo(5));
    }

    @Test
    void forNumbersTo21() {
        assertEquals(121, Problem17.forNumbersTo(21));
    }
}