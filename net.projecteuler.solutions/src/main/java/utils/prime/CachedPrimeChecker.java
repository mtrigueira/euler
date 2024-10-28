package utils.prime;

import java.math.BigInteger;
import java.util.SortedSet;
import java.util.TreeSet;

import static java.math.BigInteger.TWO;

class CachedPrimeChecker {
    private CachedPrimeChecker() {}

    public static boolean isPrime(BigInteger candidate) {
        if (primes.contains(candidate)) return true;

        if (!BruteForcePrimeChecker.isPrime(candidate))
            return false;

        primes.add(candidate);
        return true;
    }

    static final SortedSet<BigInteger> primes = new TreeSet<>();
    static {
        primes.add(TWO);
        primes.add(BigInteger.valueOf(3));
    }
}
