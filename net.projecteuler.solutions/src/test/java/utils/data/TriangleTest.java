package utils.data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TriangleTest {
    public static final Triangle TINY_TRIANGLE = Triangle.of("""
            3
            7 4
            2 4 6""");
    static final Triangle SMALL_TRIANGLE = Triangle.of("""
            3
            7 4
            2 4 6
            8 5 9 3""");
    static final Triangle BAD_TRIANGLE = Triangle.of("""
            3
            """ + Short.MAX_VALUE + " " + Short.MAX_VALUE);

    @Test
    void maxPathSumTINY() {
        assertEquals(14, TINY_TRIANGLE.maxPathSum());
    }

    @Test
    void maxPathSumSMALL() {
        assertEquals(23, SMALL_TRIANGLE.maxPathSum());
    }

    @Test
    void maxPathSumBAD() {
        assertThrows(ArithmeticException.class, BAD_TRIANGLE::maxPathSum);
    }

    @Test
    void toStringSMALLTest() {
        assertEquals("""
                3
                7 4
                2 4 6
                8 5 9 3""", SMALL_TRIANGLE.toString());
    }
}