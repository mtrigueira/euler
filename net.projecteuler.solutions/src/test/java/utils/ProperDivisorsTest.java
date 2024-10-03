package utils;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ProperDivisorsTest {
    @Test
    void factors0() {
        assertEquals(Collections.emptySet(),ProperDivisors.of(0));
    }

    @Test
    void factors1() {
        assertEquals(Set.of(1), ProperDivisors.of(1));
    }

    @Test
    void factors3() {
        assertEquals(Set.of(1), ProperDivisors.of(3));
    }

    @Test
    void factors6() {
        assertEquals(Set.of(1, 2, 3), ProperDivisors.of(6));
    }

    @Test
    void factors28() {
        assertEquals(Set.of(1, 2, 4, 7, 14), ProperDivisors.of(28));
    }
}