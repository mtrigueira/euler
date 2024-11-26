package utils.sequence.arithmetic;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;
import static utils.sequence.arithmetic.EulersPhiSequence.*;

class EulersPhiSequenceTest {
    @ParameterizedTest
    @CsvSource({"2,1","3,2","4,2","5,4","6,2","7,6","8,4","9,6","10,4"})
    void countRelativePrimesTest(int n, int phi) {
        assertEquals(phi, phiBruteForce(n));
        assertEquals(phi, phiEulersProductFormula(n));
    }

    @Test
    void next() {
        EulersPhiSequence e = new EulersPhiSequence();
        assertEquals(1,e.next());
    }
}