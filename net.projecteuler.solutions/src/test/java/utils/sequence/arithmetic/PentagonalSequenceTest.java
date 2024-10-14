package utils.sequence.arithmetic;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class PentagonalSequenceTest {
    private static PentagonalSequence f;
    private static int lastPentagonal = 1;
    @BeforeAll
    static void setUp() {
        f = new PentagonalSequence();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 12, 22, 35, 51, 70, 92, 117, 145})
    void pentagonalSequenceTest(int i) {
        assertEquals(i, f.next().longValueExact());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 12, 22, 35, 51, 70, 92, 117, 145})
    void isPentagonalTest(int i) {
        BigInteger b = BigInteger.valueOf(i);
        assertTrue(PentagonalSequence.isPentagonal(b));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 12, 22, 35, 51, 70, 92, 117, 145})
    void isNotPentagonalBetweenTest(int i) {
        for(int j = lastPentagonal+1; j < i; j++) {
            BigInteger b = BigInteger.valueOf(j);
            boolean isPentagonal = PentagonalSequence.isPentagonal(b);
            assertFalse(isPentagonal);
        }
        lastPentagonal = i;
    }

    @ParameterizedTest
    @ValueSource(ints = {13})
    void isNotPentagonalTest(int i) {

            BigInteger b = BigInteger.valueOf(i);
            boolean isPentagonal = PentagonalSequence.isPentagonal(b);
            assertFalse(isPentagonal);

    }
}