package problem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem35Test {
    @Test
    void countCircularPrimesBelow10() {
        assertEquals(4, Problem35.countCircularPrimesBelow(10));
    }

    @Test
    void countCircularPrimesBelow100() {
        assertEquals(13, Problem35.countCircularPrimesBelow(100));
    }
}