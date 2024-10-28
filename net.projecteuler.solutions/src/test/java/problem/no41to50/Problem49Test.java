package problem.no41to50;

import org.junit.jupiter.api.Test;
import utils.prime.Prime;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Problem49Test {
    @Test
    void primePermutations() {
        assertEquals("148748178147", Problem49.primePermutations(List.of()));
    }

    @Test
    void primePermutationsNotFound() {
        assertEquals("Not found", Problem49.primePermutations(
                List.of(Prime.of("1487").orElseThrow(),
                        Prime.of("2969").orElseThrow())));
    }
}