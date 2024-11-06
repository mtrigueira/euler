package problem.no51to60;

import org.junit.jupiter.api.Test;
import utils.prime.Prime;

import static org.junit.jupiter.api.Assertions.*;

class Problem51Test {
    @Test
    void replacementPrimeCountX3() {
        assertEquals(6, Problem51.replacementPrimeCount("*3", 8));
    }

    @Test
    void replacementPrimeCount56XX3() {
        assertEquals(7, Problem51.replacementPrimeCount("56**3", 8));
    }

    @Test
    void smallestPrime() {
        assertEquals(Prime.of("10007").orElseThrow(), Problem51.smallestPrime(6));
    }
}