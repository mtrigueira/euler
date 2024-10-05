package problem.no11to20.problem11;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GridTest {

    @Test
    void findMaxProduct0x0w1() {
        assertEquals(0, Grid.of(new short[][]{}).findMaxProduct( 1));
    }

    @Test
    void findMaxProduct1x1w1() {
        assertEquals(1, Grid.of(new short[][]{{1}}).findMaxProduct(1));
    }

    @Test
    void findMaxProduct1x2w1() {
        assertEquals(2, Grid.of(new short[][]{{1,2}}).findMaxProduct( 1));
    }

    @Test
    void findMaxProduct1x2w2() {
        assertEquals(4, Grid.of(new short[][]{{2,2}}).findMaxProduct( 2));
    }

    @Test
    void findMaxProduct2x2w2() {
        assertEquals(12, Grid.of(new short[][]{{1,2},{3,4}}).findMaxProduct(2));
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
}