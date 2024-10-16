package utils.data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LatticeTest {

    @Test
    void test0() {
        assertThrows(IllegalArgumentException.class,()-> new Lattice(0).countRoutes());
    }

    @Test
    void test1() {
        assertEquals(2, new Lattice(1).countRoutes());
    }

    @Test
    void test2() {
        assertEquals(6, new Lattice(2).countRoutes());
    }

    @Test
    void test3() {
        assertEquals(20, new Lattice(3).countRoutes());
    }

    @Test
    void test4() {
        assertEquals(70, new Lattice(4).countRoutes());
    }
}