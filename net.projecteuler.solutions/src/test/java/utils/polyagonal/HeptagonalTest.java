package utils.polyagonal;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;
import static utils.polyagonal.Polygonal.HEPTAGONAL;

class HeptagonalTest {
     private static final AtomicInteger lastHeptagonal = new AtomicInteger(1);
     private static final AtomicInteger lastIndex = new AtomicInteger(1);

    @ParameterizedTest
    @ValueSource(ints = {1, 7, 18, 34, 55})
    void heptagonalAtTest(int i) {
        assertEquals(i, HEPTAGONAL.at(lastIndex.getAndIncrement()));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 7, 18, 34, 55})
    void isHeptagonalTest(int i) {
        assertTrue(HEPTAGONAL.is(i));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 7, 18, 34, 55})
    void isNotHeptagonalBetweenTest(int i) {
        for(int j = lastHeptagonal.get() +1; j < i; j++) {
            boolean isHeptagonal = HEPTAGONAL.is(j);
            assertFalse(isHeptagonal);
        }
        lastHeptagonal.set(i);
    }

    @ParameterizedTest
    @ValueSource(ints = {13})
    void isNotHeptagonalTest(int i) {
        boolean isHeptagonal = HEPTAGONAL.is(i);
        assertFalse(isHeptagonal);
    }
}