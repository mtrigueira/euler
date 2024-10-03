package utils;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SetMakerTest {

    @Test
    void set() {
        assertEquals(Set.of(), SetMaker.set());
    }

    @Test
    void set2() {
        assertEquals(Set.of(1L), SetMaker.set(1));
    }

    @Test
    void set3() {
        assertEquals(Set.of(1L, 2L, 3L, 4L, 5L), SetMaker.set(1, 2, 3, 4, 5));
    }
}