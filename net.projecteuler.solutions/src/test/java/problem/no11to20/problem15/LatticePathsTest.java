package problem.no11to20.problem15;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LatticePathsTest {

    @Test
    void test0() {
        assertEquals(0, LatticePaths.count(0));
    }

    @Test
    void test1() {
        assertEquals(2, LatticePaths.count(1));
    }

    @Test
    void test2() {
        assertEquals(6, LatticePaths.count(2));
    }

    @Test
    void test3() {
        assertEquals(20, LatticePaths.count(3));
    }

    @Test
    void test4() {
        assertEquals(70, LatticePaths.count(4));
    }
}