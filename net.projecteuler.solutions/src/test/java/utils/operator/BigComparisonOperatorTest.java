package utils.operator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;
import static utils.operator.BigComparisonOperator.*;

class BigComparisonOperatorTest {
    private static final BigInteger LONG_MAX_VALUE = BigInteger.valueOf(Long.MAX_VALUE);
    private static final BigInteger LONG_MIN_VALUE = BigInteger.valueOf(Long.MIN_VALUE);

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 1, 2, 3, 4, 5, 6, 7})
    void test(int i) {
        BigInteger value = BigInteger.valueOf(i);

        assertValueComparedWithItself(value);
        assertValueComparedWithABiggerValue(value);
        assertValueComparedWithASmallerValue(value);
    }

    private static void assertValueComparedWithItself(BigInteger a) {
        // a == b
        assertFalse(lessThan(a, a));
        assertTrue(lessThanOrEqual(a, a));
        assertTrue(equal(a, a));
        assertFalse(notEqual(a, a));
        assertFalse(greaterThan(a, a));
        assertTrue(greaterThanOrEqual(a, a));
        assertShortcuts(a, a);
    }


    private static void assertValueComparedWithABiggerValue(BigInteger a) {
        // a < b
        BigInteger b = LONG_MAX_VALUE;
        assertTrue(lessThan(a, b));
        assertTrue(lessThanOrEqual(a, b));
        assertFalse(equal(a, b));
        assertTrue(notEqual(a, b));
        assertFalse(greaterThan(a, b));
        assertFalse(greaterThanOrEqual(a, b));
        assertShortcuts(a, b);
    }

    private static void assertValueComparedWithASmallerValue(BigInteger a) {
        // a > b
        BigInteger b = LONG_MIN_VALUE;
        assertFalse(lessThan(a, b));
        assertFalse(lessThanOrEqual(a, b));
        assertFalse(equal(a, b));
        assertTrue(notEqual(a, b));
        assertTrue(greaterThan(a, b));
        assertTrue(greaterThanOrEqual(a, b));
        assertShortcuts(a, b);
    }

    private static void assertShortcuts(BigInteger a, BigInteger b) {
        assertEquals(lessThan(a, b), lt(a, b));
        assertEquals(lessThanOrEqual(a, b), lte(a, b));
        assertEquals(equal(a, b), eq(a, b));
        assertEquals(notEqual(a, b), neq(a, b));
        assertEquals(greaterThan(a, b), gt(a, b));
        assertEquals(greaterThanOrEqual(a, b), gte(a, b));
    }
}
