package utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigInteger;

import static java.math.BigInteger.TWO;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
class EvennessTest {
    private static final BigInteger THREE = BigInteger.valueOf(3);

    @Test
    void isEven() {
        assertTrue(Evenness.isEven(TWO));
    }

    @Test
    void isNotEven() {
        assertFalse(Evenness.isEven(THREE));
    }

    @ParameterizedTest
    @CsvSource({"0","2","4","10","100",Integer.MAX_VALUE/2*2+""})
    void isEven(int i) {
        assertTrue(Evenness.isEven(i));
    }

    @ParameterizedTest
    @CsvSource({"1","3","5","99","9999",Integer.MAX_VALUE/2*2-1+""})
    void isOdd(int i) {
        assertFalse(Evenness.isEven(i));
    }
}