package problem.no51to60;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem51Test {

    @Test
    void replacementPrimeCountX3() {
        assertEquals(6, Problem51.replacementPrimeCount("*3"));
    }

    @Test
    void replacementPrimeCount56XX3() {
        assertEquals(7, Problem51.replacementPrimeCount("56**3"));
    }
}