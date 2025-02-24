package utils.data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LatticeTest {

    @Test
    void test0() {
        assertThrows(IllegalArgumentException.class, () -> {
            //noinspection unused
            long l = Lattice.createLattice(0).countRoutes();
        });
    }

    @Test
    void test1() {
        assertEquals(2, Lattice.createLattice(1).countRoutes());
    }

    @Test
    void test2() {
        assertEquals(6, Lattice.createLattice(2).countRoutes());
    }

    @Test
    void test3() {
        assertEquals(20, Lattice.createLattice(3).countRoutes());
    }

    @Test
    void test4() {
        assertEquals(70, Lattice.createLattice(4).countRoutes());
    }
}