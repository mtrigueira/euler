package utils.property;

import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static utils.Maker.setL;

class ProperDivisorsTest {
    @Test
    void properDivisors0() {
        assertEquals(Collections.emptySet(), ProperDivisors.of(0));
    }

    @Test
    void properDivisors1() {
        assertEquals(Collections.emptySet(), ProperDivisors.of(1));
    }

    @Test
    void properDivisors3() {
        assertEquals(setL(1), ProperDivisors.of(3));
    }

    @Test
    void properDivisors6() {
        assertEquals(setL(1, 2, 3), ProperDivisors.of(6));
    }

    @Test
    void properDivisors28() {
        assertEquals(setL(1, 2, 4, 7, 14), ProperDivisors.of(28));
    }
}