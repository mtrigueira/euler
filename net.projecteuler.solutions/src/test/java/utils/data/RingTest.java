package utils.data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static utils.data.Ring.toRing;

class RingTest {
    private static final Ring MAGIC_RING = toRing(4, 2, 3, 5, 3, 1, 6, 1, 2);
    private static final Ring MUGGLE_RING = toRing(4, 2, 3, 5, 3, 1, 6, 1, 3);
    private static final Ring MAGIC_BUT_NOT_RING = toRing(7,6,5,10,5,3,9,3,6,8,6,4,8,4,6);

    @Test
    void isMagicRing() {
        assertTrue(MAGIC_RING.isMagic());
        assertTrue(MAGIC_BUT_NOT_RING.isMagic());
    }

    @Test
    void isNotMagicRing() {
        assertFalse(MUGGLE_RING.isMagic());
    }

    @Test
    void isRing() {
        assertTrue(MAGIC_RING.isRing());
    }

    @Test
    void isNotRing() {
        assertFalse(MUGGLE_RING.isRing());
        assertFalse(MAGIC_BUT_NOT_RING.isRing());
    }

    @Test
    void sortRing3() {
        assertEquals(new Ring(4, 2, 3, 5, 3, 1, 6, 1, 2), new Ring(5, 3, 1, 6, 1, 2, 4, 2, 3).sort());
    }

    @Test
    void sortRing5() {
        assertEquals(new Ring(1, 2, 3, 4, 3, 5, 6, 5, 7, 8, 7, 9, 10, 9, 2), new Ring(4, 3, 5, 6, 5, 7, 8, 7, 9, 10, 9, 2, 1, 2, 3).sort());
    }

    @Test
    void sortRing5WithHorrid10() {
        assertEquals(new Ring(2, 5, 9, 4, 9, 3, 6, 3, 7, 8, 7, 1, 10, 1, 5), new Ring(10, 1, 5, 2, 5, 9, 4, 9, 3, 6, 3, 7, 8, 7, 1).sort());
    }
}