package problem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem85Test {
    @Test
    void test0() {
        assertEquals(0, Problem85.countRectanglesInGrid(0, 0));
    }

    @Test
    void test1() {
        assertEquals(1, Problem85.countRectanglesInGrid(1, 1));
    }

    @Test
    void test2() {
        assertEquals(3, Problem85.countRectanglesInGrid(1, 2));
    }

    @Test
    void test3() {
        assertEquals(6, Problem85.countRectanglesInGrid(1, 3));
    }

    @Test
    void test4() {
        assertEquals(9, Problem85.countRectanglesInGrid(2, 2));
    }

    @Test
    void test5() {
        assertEquals(18, Problem85.countRectanglesInGrid(3, 2));
    }
}