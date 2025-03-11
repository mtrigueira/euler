package problem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Problem52Test {
    @Test
    void permutedMultiples() {
        assertEquals(125874, Problem52.permutedMultiples(2));
    }

    @Test
    void permutedMultiples1() {
        assertEquals(1, Problem52.permutedMultiples(1));
    }

    @Test
    void permutedMultiples0() {
        assertThrows(IllegalArgumentException.class, () -> Problem52.permutedMultiples(0));
    }


}