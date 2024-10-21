package utils.polyagonal;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;
import static utils.polyagonal.Polygonal.PENTAGONAL;

class PentagonalTest {
    static int n = 1;
    private static int lastPENTAGONAL = 1;

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 12, 22, 35, 51, 70, 92, 117, 145})
    void atPosition(int x) {
        BigInteger i = BigInteger.valueOf(n++);
        BigInteger j = BigInteger.valueOf(x);
        assertEquals(j, PENTAGONAL.at(i));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 12, 22, 35, 51, 70, 92, 117, 145})
    void isPentagonalTest(int i) {
        BigInteger b = BigInteger.valueOf(i);
        assertTrue(PENTAGONAL.is(b));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 12, 22, 35, 51, 70, 92, 117, 145})
    void isNotPENTAGONALBetweenTest(int i) {
        for (int j = lastPENTAGONAL + 1; j < i; j++) {
            BigInteger b = BigInteger.valueOf(j);
            boolean isPENTAGONAL = PENTAGONAL.is(b);
            assertFalse(isPENTAGONAL);
        }
        lastPENTAGONAL = i;
    }

    @ParameterizedTest
    @ValueSource(ints = {13})
    void isNotPentagonalTest(int i) {

        BigInteger b = BigInteger.valueOf(i);
        boolean isPENTAGONAL = PENTAGONAL.is(b);
        assertFalse(isPENTAGONAL);

    }
}