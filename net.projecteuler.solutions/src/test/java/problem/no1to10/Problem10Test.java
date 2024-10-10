package problem.no1to10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem10Test {
    @Test
    void forZero() {
        assertEquals(0, Problem10.below(0));
    }

    @Test
    void forThree() {
        assertEquals(2, Problem10.below(3));
    }

    @Test
    void forFour() {
        assertEquals(17, Problem10.below(10));
    }
}