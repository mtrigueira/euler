package problem.no61to70;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem68Test {
    @Test
    void isMagicRing() {
        assertTrue(Problem68.isMagicRing(new int[]{4,2,3,5,3,1,6,1,2}));
    }

    @Test
    void isNotMagicRing() {
        assertFalse(Problem68.isMagicRing(new int[]{4,2,3,5,3,1,6,1,3}));
    }

    @Test
    void makeRing3() {
        assertArrayEquals(new int[]{1,2,3,4,3,5,6,5,2}, Problem68.makeRing("1,2,3,4,5,6"));
    }

    @Test
    void makeRing5() {
        assertArrayEquals(new int[]{1,2,3,4,3,5,6,5,7,8,7,9,10,9,2}, Problem68.makeRing("1,2,3,4,5,6,7,8,9,10"));
    }

    @Test
    void sortRing3() {
        assertArrayEquals(new int[]{4,2,3,5,3,1,6,1,2}, Problem68.sortRing(new int[]{5,3,1,6,1,2,4,2,3}));
    }

    @Test
    void sortRing5() {
        assertArrayEquals(new int[]{1,2,3,4,3,5,6,5,7,8,7,9,10,9,2}, Problem68.sortRing(new int[]{4,3,5,6,5,7,8,7,9,10,9,2,1,2,3}));
    }

    @Test
    void sortRing5WithHorrid10() {
        assertArrayEquals(new int[]{2,5,9,4,9,3,6,3,7,8,7,1,10,1,5}, Problem68.sortRing(new int[]{10,1,5,2,5,9,4,9,3,6,3,7,8,7,1}));
    }

    @Test
    void maximumNgonString() {
        assertEquals("432621513", Problem68.maximumNgonString(3, 9));
    }

    @Test
    void compareGroups() {
        assertEquals(0, Problem68.compareGroups(new int[]{1, 2, 3}, new int[]{1, 2, 3}));
        assertEquals(2, Problem68.compareGroups(new int[]{3,2,1}, new int[]{1,2,3}));
        assertEquals(-2, Problem68.compareGroups(new int[]{1,2,3}, new int[]{3,2,1}));
        assertEquals(9, Problem68.compareGroups(new int[]{10,2,3}, new int[]{1,2,3}));
    }
}