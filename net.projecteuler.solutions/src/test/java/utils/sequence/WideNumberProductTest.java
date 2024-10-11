package utils.sequence;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import utils.sequence.given.WideNumberProductSequence;
import utils.sequence.given.WideNumberSequence;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WideNumberProductTest {
    private static final WideNumberSequence series2 = new WideNumberProductSequence("0123456789",2);

    @ParameterizedTest
    @ValueSource(ints = {0,2,6,12,20,30,42,56,72})
    void product(int i) {
        assertEquals(i, series2.next());
    }
}