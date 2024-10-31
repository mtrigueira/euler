package problem.no61to70;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class Problem69Test {
    @Test
    void maximumTotient() {
        assertEquals(6, Problem69.maximumTotient(10));
    }

    @ParameterizedTest
    @CsvSource({"2,1","3,2","4,2","5,4","6,2","7,6","8,4","9,6","10,4"})
    void findRelativePrimes(int n, int phi) {
        assertEquals(phi, Problem69.findRelativePrimes(n).size());
    }
}