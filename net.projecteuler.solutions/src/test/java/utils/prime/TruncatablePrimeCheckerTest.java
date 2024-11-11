package utils.prime;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TruncatablePrimeCheckerTest {
    public static final long NOT_TRUNCATABLE = 3803;
    public static final long TRUNCATABLE_IN_BOTH_DIRECTIONS = 3797;

    @Test
    void isTruncatablePrimeBothDirections() {
        assertTrue(TruncatablePrimeChecker.isTruncatablePrimeBothDirections(TRUNCATABLE_IN_BOTH_DIRECTIONS));
        assertFalse(TruncatablePrimeChecker.isTruncatablePrimeBothDirections(NOT_TRUNCATABLE));
    }

    @Test
    void isTruncatablePrime() {
        assertTrue(TruncatablePrimeChecker.isTruncatablePrimeL(TRUNCATABLE_IN_BOTH_DIRECTIONS));
        assertFalse(TruncatablePrimeChecker.isTruncatablePrimeL(3798));
        assertTrue(TruncatablePrimeChecker.isTruncatablePrimeR(TRUNCATABLE_IN_BOTH_DIRECTIONS));
        assertFalse(TruncatablePrimeChecker.isTruncatablePrimeR(3798));
    }
}