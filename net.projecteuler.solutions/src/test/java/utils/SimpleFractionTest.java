package utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;
import static utils.SimpleFraction.ONE;
import static utils.SimpleFraction.TWO;

class SimpleFractionTest {
    @ParameterizedTest
    @ValueSource(ints = {3, 6, 7, 9})
    void isReciprocalCycle(int i) {
        assertTrue(Decimal.of(1, i).isReciprocalCycle());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 4, 5, 8, 10})
    void isNotReciprocalCycle(int i) {
        assertFalse(Decimal.of(1, i).isReciprocalCycle());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 4, 5, 8, 10})
    void fractionsMatchJava(int i) {
        assertEquals(Double.toString(1.0/i), Decimal.of(1, i).toString());
    }

    public static final SimpleFraction HALF = SimpleFraction.of(1, 2);
    public static final SimpleFraction THREE = SimpleFraction.of(3, 1);

    @Test
    void add() {
        assertEquals(TWO, ONE.add(ONE));
        assertEquals(THREE, TWO.add(ONE));
        assertEquals(THREE, ONE.add(TWO));
        assertEquals(ONE, HALF.add(HALF).simplify());
        assertEquals(TWO, HALF.add(HALF).add(HALF).add(HALF).simplify());
    }

    @Test
    void divide() {
        assertEquals(ONE, TWO.divide(TWO).simplify());
        assertEquals(HALF, ONE.divide(TWO));
    }
}