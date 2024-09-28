package problem7;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PrimeSequenceTest {
    private static final PrimeSequence seq = new PrimeSequence();

    @ParameterizedTest(name = "Next prime is {0}")
    @ValueSource(ints = {2,3,5,7,11,13,17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89})
    void testPrimeSequence(int expected) {
        assertEquals(expected, seq.next());
    }
}