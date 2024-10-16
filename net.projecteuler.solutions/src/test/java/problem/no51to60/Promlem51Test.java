package problem.no51to60;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Promlem51Test {

    @Test
    void replacementPrimeCountX3() {
        assertEquals(6, Promlem51.replacementPrimeCount("*3"));
    }

    @Test
    void replacementPrimeCount56XX3() {
        assertEquals(7, Promlem51.replacementPrimeCount("56**3"));
    }
}