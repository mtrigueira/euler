package problem.no11to20;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem16Test {


    @Test
    void TwoToThe0() {
        assertEquals(1, Problem16.of2ToThe(0));
    }

    @Test
    void TwoToThe1() {
        assertEquals(2, Problem16.of2ToThe(1));
    }

    @Test
    void TwoToThe2() {
        assertEquals(4, Problem16.of2ToThe(2));
    }

    @Test
    void TwoToThe4() {
        assertEquals(7, Problem16.of2ToThe(4));
    }

    @Test
    void TwoToThe15() {
        assertEquals(26, Problem16.of2ToThe(15));
    }
}