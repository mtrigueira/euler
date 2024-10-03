package problem21;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FactorsTest {
    @Test
    void factors0() {
        assertEquals(Collections.emptySet(), Factors.of(0));
    }

    @Test
    void factors1() {
        assertEquals(Set.of(1), Factors.of(1));
    }

    @Test
    void factors3() {
        assertEquals(Set.of(1, 3), Factors.of(3));
    }

    @Test
    void factors6() {
        assertEquals(Set.of(1, 2, 3, 6), Factors.of(6));
    }

    @Test
    void factors28() {
        assertEquals(Set.of(1, 2, 4, 7, 14, 28), Factors.of(28));
    }
}