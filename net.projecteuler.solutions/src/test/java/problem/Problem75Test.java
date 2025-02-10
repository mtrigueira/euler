package problem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem75Test {
    @Test
    void countSingularRightTriangles12() {
        Assertions.assertEquals(1, Problem75.countSingularRightTriangles(12));
    }

    @Test
    void countSingularRightTriangles48() {
        assertEquals(6,Problem75.countSingularRightTriangles(48));
    }

    @Test
    void countSingularRightTriangles100() {
        assertEquals(11,Problem75.countSingularRightTriangles(100));
    }

    @Test
    void countSingularRightTriangles1000() {
        assertEquals(112,Problem75.countSingularRightTriangles(1000));
    }
}