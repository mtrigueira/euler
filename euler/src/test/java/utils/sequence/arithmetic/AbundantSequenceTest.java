package utils.sequence.arithmetic;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AbundantSequenceTest {
    static final AbundantSequence abundantSequence = new AbundantSequence();

    @ParameterizedTest
    @ValueSource(ints = {12, 18, 20, 24, 30, 36, 40, 42, 48, 54, 56, 60, 66, 70, 72, 78, 80, 84, 88, 90, 96, 100})
    void nextTest(int nextAbundant) {
        assertEquals(nextAbundant, abundantSequence.next().longValueExact());
    }
}