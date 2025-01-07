package problem.no91to100;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem95Test {
    @Test
    void chainLength() {
        assertEquals(0, new Problem95.ChainMaker(100).chain(102).length());
    }

    @Test
    void chainLength28() {
        assertEquals(1, new Problem95.ChainMaker(100).chain(28).length());
    }

    @Test
    void chainLength220() {
        assertEquals(2, new Problem95.ChainMaker(285).chain(220).length());
    }

    @Test
    void chainLength284() {
        // As per optimisation only the smallest value in a chain will return non NIL
        assertEquals(0, new Problem95.ChainMaker(285).chain(284).length());
    }

    @Test
    void chainLength12496() {
        assertEquals(5, new Problem95.ChainMaker(15473).chain(12496).length());
    }

    @Test
    void sol() {
        assertEquals(-1, new Problem95().solution(2));
    }
}