package problem.no11to20.problem17;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberLetterCountsTest {
    @Test
    void forNumbersTo1() {
        assertEquals(3, NumberLetterCounts.forNumbersTo(1));
    }

    @Test
    void forNumbersTo5() {
        assertEquals(19, NumberLetterCounts.forNumbersTo(5));
    }

    @Test
    void forNumbersTo21() {
        assertEquals(121, NumberLetterCounts.forNumbersTo(21));
    }
}