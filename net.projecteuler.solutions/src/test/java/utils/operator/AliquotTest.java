package utils.operator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AliquotTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 13, 14, 15})
    void isNotAbundant(int i) {
        assertFalse(Aliquot.isAbundant(i));
    }

    @ParameterizedTest
    @ValueSource(ints = {12, 18, 20, 24, 30, 36, 40, 42, 48, 54, 56, 60, 66, 70, 72, 78, 80, 84, 88, 90, 96, 100})
    void isAbundant(int i) {
        assertTrue(Aliquot.isAbundant(i));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 7, 8, 9, 10, 11, 13, 14, 12, 18, 20, 24, 30, 36, 40, 42, 48, 54, 56, 60})
    void isNotPerfect(int i) {
        assertFalse(Aliquot.isPerfect(i));
    }

    @ParameterizedTest
    @ValueSource(ints = {6, 28, 496, 8128})
    void isPerfect(int i) {
        assertTrue(Aliquot.isPerfect(i));
    }

    @ParameterizedTest
    @ValueSource(ints = {6, 28, 496, 8128, 12, 18, 20, 24, 30, 36, 40, 42, 48})
    void isNotDeficient(int i) {
        assertFalse(Aliquot.isDeficient(i));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 7, 8, 9, 10, 11, 13, 14, 15, 16, 17, 19, 21, 22, 23, 25, 26, 27, 29, 31, 32})
    void isDeficient(int i) {
        assertTrue(Aliquot.isDeficient(i));
    }
}