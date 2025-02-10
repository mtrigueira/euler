package problem;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Problem49Test {
    @Test
    void primePermutations() {
        assertTrue(Problem49.primePermutations(List.of()).contains("148748178147"));
    }

    @Test
    void primePermutationsNotFound() {
        assertEquals("", Problem49.primePermutations(
                List.of(1487,2969)));
    }
}