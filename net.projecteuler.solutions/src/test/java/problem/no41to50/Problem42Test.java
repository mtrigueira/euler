package problem.no41to50;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem42Test {
    @Test
    void countTriangularWords0() {
        assertEquals(0, Problem42.countTriangularWords("BANANA".lines()));
    }

    @Test
    void countTriangularWords1() {
        assertEquals(1, Problem42.countTriangularWords("SKY".lines()));
    }

    @Test
    void countTriangularWords2() {
        assertEquals(2, Problem42.countTriangularWords("A\nBANANA\nSKY".lines()));
    }
}