package problem.no11to20;

import org.junit.jupiter.api.Test;
import utils.data.Triangle;

import static org.junit.jupiter.api.Assertions.*;

class Problem18Test {
    static final Triangle TINY_TRIANGLE = Triangle.of("""
            3
            7 4
            2 4 6""");
    @Test
    void maxPathSumTINY() {
        assertEquals(14,TINY_TRIANGLE.maxPathSum());
    }

    static final Triangle SMALL_TRIANGLE = Triangle.of("""
            3
            7 4
            2 4 6
            8 5 9 3""");
    @Test
    void maxPathSumSMALL() {
        assertEquals(23,SMALL_TRIANGLE.maxPathSum());
    }
}