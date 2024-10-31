package problem.no61to70;

import org.junit.jupiter.api.Test;
import utils.data.Triangle;

import static org.junit.jupiter.api.Assertions.*;

class Problem67Test {
    public static final Triangle TRIANGLE = Triangle.of("""
            3
            7 4
            2 4 6""");

    @Test
    void maxPathSum() {
        assertEquals(14, TRIANGLE.maxPathSum());
    }
}