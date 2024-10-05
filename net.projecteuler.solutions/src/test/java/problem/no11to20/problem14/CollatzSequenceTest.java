package problem.no11to20.problem14;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CollatzSequenceTest {
    static final CollatzSequence collatzSequence = CollatzSequence.of(13);

    @ParameterizedTest
    @ValueSource(ints = {13,40,20,10,5,16,8,4,2})
    void shouldReturnCorrectCollatzSequence(int number) {
        assertEquals(number, collatzSequence.next().longValueExact());
    }
}