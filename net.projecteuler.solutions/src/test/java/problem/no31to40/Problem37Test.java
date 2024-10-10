package problem.no31to40;

import org.junit.jupiter.api.Test;
import utils.prime.Prime;
import utils.prime.TruncatablePrimeChecker;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Problem37Test {
    public static final Prime NOT_TRUNCATABLE = toPrime(3803);
    public static final Prime TRUNCATABLE_IN_BOTH_DIRECTIONS = toPrime(3797);

    @Test
    void isTruncatablePrimeBothDirections() {
        assertTrue(TruncatablePrimeChecker.isTruncatablePrimeBothDirections(TRUNCATABLE_IN_BOTH_DIRECTIONS));
        assertFalse(TruncatablePrimeChecker.isTruncatablePrimeBothDirections(NOT_TRUNCATABLE));
    }

    @Test
    void isTruncatablePrime() {
        assertTrue(TruncatablePrimeChecker.isTruncatablePrime(3797));
        assertFalse(TruncatablePrimeChecker.isTruncatablePrime(3798));
    }

    private static Prime toPrime(int i) {
        return Prime.of(BigInteger.valueOf(i)).orElseThrow();
    }
}