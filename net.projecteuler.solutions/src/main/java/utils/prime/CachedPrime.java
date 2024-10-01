package utils.prime;

import java.util.SortedSet;
import java.util.TreeSet;

public class CachedPrime extends BruteForcePrime {
    public static boolean isPrime(long candidate) {
        if (candidate < 2) return false;
        if (primes.contains(candidate)) return true;

        return new CachedPrime(candidate).isPrime();
    }

    private CachedPrime(long candidate) {
        super(candidate);
    }

    private static final SortedSet<Long> primes = new TreeSet<>();
    static {
        primes.add(2L);
        primes.add(3L);
    }

    private boolean isPrime() {
        if (!BruteForcePrime.isPrime(candidate))
            return false;

        primes.add(candidate);
        return true;
    }
}
