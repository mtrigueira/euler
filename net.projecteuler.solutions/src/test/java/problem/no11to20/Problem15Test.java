package problem.no11to20;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem15Test {

    @Test
    void test0() {
        assertEquals(0, Problem15.count(0));
    }

    @Test
    void test1() {
        assertEquals(2, Problem15.count(1));
    }

    @Test
    void test2() {
        assertEquals(6, Problem15.count(2));
    }

    @Test
    void test3() {
        assertEquals(20, Problem15.count(3));
    }

    @Test
    void test4() {
        assertEquals(70, Problem15.count(4));
    }
}