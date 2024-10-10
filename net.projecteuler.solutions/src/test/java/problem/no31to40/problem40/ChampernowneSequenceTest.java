package problem.no31to40.problem40;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class ChampernowneSequenceTest {
    static ChampernowneSequence champernowneSequence = new ChampernowneSequence();

    @ParameterizedTest
    @ValueSource(bytes = {1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 0, 1, 1, 1, 2})
    void test(byte i) {
        assertEquals(i, champernowneSequence.next());
    }
}