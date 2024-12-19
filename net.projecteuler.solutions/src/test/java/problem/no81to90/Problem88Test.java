package problem.no81to90;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem88Test {
    @Test
    void minimalProductSum2() {
        assertEquals(4, Problem88.minimalProductSum(2));
    }

    @Test
    void minimalProductSum3() {
        assertEquals(6, Problem88.minimalProductSum(3));
    }

    @Test
    void minimalProductSum5() {
        assertEquals(8, Problem88.minimalProductSum(5));
    }

    @Test
    void minimalProductSum6() {
        assertEquals(12, Problem88.minimalProductSum(6));
    }

    @Test
    void minimalProductSum92() {
        assertEquals(112, Problem88.minimalProductSum(92));
    }

    @Test
    void solution12() {
        assertEquals(61, Problem88.solution());
    }
}