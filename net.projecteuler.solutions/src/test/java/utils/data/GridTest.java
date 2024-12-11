package utils.data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GridTest {

    public static final short[][] EMPTY = {};
    public static final short[][] ONE_BY_ONE = {{1}};
    public static final short[][] ONE_BY_TWO = {{1, 2}};
    public static final short[][] TWO_BY_TWO = {{1, 2}, {3, 4}};

    @Test
    void findMaxProduct0x0w0() {
        assertEquals(0, Grid.of(EMPTY).findMaxProduct( 0));
    }

    @Test
    void findMaxProduct0x0w1() {
        assertEquals(0, Grid.of(EMPTY).findMaxProduct( 1));
    }

    @Test
    void findMaxProduct1x1w1() {
        assertEquals(1, Grid.of(ONE_BY_ONE).findMaxProduct(1));
    }

    @Test
    void findMaxProduct1x2w1() {
        assertEquals(2, Grid.of(ONE_BY_TWO).findMaxProduct( 1));
    }

    @Test
    void findMaxProduct1x2w2() {
        assertEquals(4, Grid.of(new short[][]{{2,2}}).findMaxProduct( 2));
    }

    @Test
    void findMaxProduct2x2w2() {
        assertEquals(12, Grid.of(TWO_BY_TWO).findMaxProduct(2));
    }

    @Test
    void findMaxProduct2x2w2vertical() {
        assertEquals(4, Grid.of(new short[][]{{2,1},{2,1}}).findMaxProduct(2));
    }

    @Test
    void findMaxProduct2x2w2diagonalDownRight() {
        assertEquals(4, Grid.of(new short[][]{{2,1},{1,2}}).findMaxProduct(2));
    }

    @Test
    void findMaxProduct2x2w2diagonalDownLeft() {
        assertEquals(4, Grid.of(new short[][]{{1,2},{2,1}}).findMaxProduct(2));
    }

    @Test
    void testToString() {
        assertEquals("           1\n", Grid.of(ONE_BY_ONE).toString());
    }
    @Test
    void testToString2() {
        assertEquals(
                """
                                   1           2
                                   3           4
                        """, Grid.of(TWO_BY_TWO).toString());
    }
}