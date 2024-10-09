package problem.no31to40.problem37;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TruncatablePrimesTest {
    public static final BigInteger TRUNCATABLE_IN_BOTH_DIRECTIONS = BigInteger.valueOf(3797);
    public static final BigInteger NOT_TRUNCATABLE = BigInteger.valueOf(3798);

    @Test
    void isTruncatablePrimeBothDirections() {
        assertTrue(TruncatablePrimes.isTruncatablePrimeBothDirections(TRUNCATABLE_IN_BOTH_DIRECTIONS));
        assertFalse(TruncatablePrimes.isTruncatablePrimeBothDirections(NOT_TRUNCATABLE));
    }

    @Test
    void isTruncatablePrime() {
        assertTrue(TruncatablePrimes.isTruncatablePrime(3797));
        assertFalse(TruncatablePrimes.isTruncatablePrime(3798));
    }
}