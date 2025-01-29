package utils.polyagonal;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static utils.polyagonal.Polygonal.OCTAGONAL;

class OctagonalTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 8, 21, 40, 65})
    void isHexagonalTest(int i) {
        assertTrue(OCTAGONAL.is(i));
    }
}