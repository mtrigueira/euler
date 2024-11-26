package utils.prime;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigInteger;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static utils.BigIntegerConstants.big;

class PrimeTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 4, 6, 8, 9, 10, 12, 14, 15, 16, 18, 20, 21, 22, 24, 25, 26, 27, 28, 30, 32, 33, 34, 35, 36})
    void isNotPrime(int notPrime) {
        assertIsNotPrime(notPrime);
    }

    private static void assertIsNotPrime(int notPrime) {
        boolean isPrime = PrimeChecker.isPrime(notPrime);
        assertPrimeImplementations(notPrime, isPrime);
        assertFalse(isPrime);
        assertFalse(CachedPrimeChecker.isPrime(big(notPrime)));
        assertEquals(Optional.empty(), Prime.of(Integer.toString(notPrime)));
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89})
    void isPrime(int prime) {
        boolean isPrime = PrimeChecker.isPrime(prime);
        assertPrimeImplementations(prime, isPrime);
        assertTrue(isPrime);
    }

    private static void assertPrimeImplementations(int candidate, boolean isPrime) {
        BigInteger i = big(candidate);

        if(isPrime) {
            Prime p = Prime.of(Integer.toString(candidate)).orElseThrow();
            CachedPrimeChecker.primes.remove(p);
            assertFalse(CachedPrimeChecker.primes.contains(p));
        }
        assertEquals(isPrime, BruteForcePrimeChecker.isPrime(i));
        if(isPrime) {
            Prime p = Prime.of(Integer.toString(candidate)).orElseThrow();
            assertTrue(CachedPrimeChecker.primes.contains(p));
        }
        assertEquals(isPrime, CachedPrimeChecker.isPrime(i));
        assertEquals(isPrime, BruteForcePrimeChecker.isPrime(candidate));
    }

    @Test
    void primeFactorBuilder() {
        assertEquals(Set.of(),Prime.primeFactorBuilder(1));
    }
}