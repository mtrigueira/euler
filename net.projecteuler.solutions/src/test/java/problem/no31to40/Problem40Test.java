package problem.no31to40;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import utils.sequence.ChampernowneSequence;

import static org.junit.jupiter.api.Assertions.*;

class Problem40Test {
    static final ChampernowneSequence champernowneSequence = new ChampernowneSequence();

    @ParameterizedTest
    @ValueSource(bytes = {1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 0, 1, 1, 1, 2})
    void test(byte i) {
        assertEquals(i, champernowneSequence.next());
    }
}