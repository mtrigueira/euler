package utils.sequence.arithmetic;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import utils.prime.Prime;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PrimeSequenceTest {
    private static final PrimeSequence seq = PrimeSequence.fromFirst();

    @ParameterizedTest(name = "Next prime is {0}")
    @ValueSource(ints = {2,3,5,7,11,13,17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89})
    void testPrimeSequence(int expected) {
        assertEquals(big(expected), seq.next());
    }

    private static Prime big(int val) {
        return Prime.of(BigInteger.valueOf(val)).orElseThrow();
    }
}