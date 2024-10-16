package utils.data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GridNumberTest {
    @Test
    void toShortGrid1x1() {
        assertArrayEquals(new short[][]{{0}}, GridNumber.toShortGrid("0".lines()));
    }

    @Test
    void toShortGrid1x5() {
        assertArrayEquals(new short[][]{{1, 23, 45, 67, 89}}, GridNumber.toShortGrid("01 23 45 67 89".lines()));
    }

    @Test
    void toShortGrid2x2() {
        assertArrayEquals(new short[][]{{1, 23},{45, 67}}, GridNumber.toShortGrid("01 23\n45 67".lines()));
    }
}