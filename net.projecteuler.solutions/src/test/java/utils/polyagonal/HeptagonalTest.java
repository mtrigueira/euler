package utils.polyagonal;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;
import static utils.polyagonal.Polygonal.HEPTAGONAL;

class HeptagonalTest {
    private static int lastHeptagonal = 1;
    private static int lastIndex = 1;
    @ParameterizedTest
    @ValueSource(ints = {1, 7, 18, 34, 55})
    void heptagonalAtTest(int i) {
        assertEquals(i, HEPTAGONAL.at(lastIndex++));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 7, 18, 34, 55})
    void isHeptagonalTest(int i) {
        assertTrue(HEPTAGONAL.is(i));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 7, 18, 34, 55})
    void isNotHeptagonalBetweenTest(int i) {
        for(int j = lastHeptagonal +1; j < i; j++) {
            boolean isHeptagonal = HEPTAGONAL.is(j);
            assertFalse(isHeptagonal);
        }
        lastHeptagonal = i;
    }

    @ParameterizedTest
    @ValueSource(ints = {13})
    void isNotHeptagonalTest(int i) {
        boolean isHeptagonal = HEPTAGONAL.is(i);
        assertFalse(isHeptagonal);
    }
}