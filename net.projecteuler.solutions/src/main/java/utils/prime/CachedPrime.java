package utils.prime;

import java.math.BigInteger;
import java.util.SortedSet;
import java.util.TreeSet;

import static java.math.BigInteger.TWO;
import static utils.operator.BigComparisonOperator.lessThan;

class CachedPrime extends BruteForcePrime {
    public static boolean isPrime(BigInteger candidate) {
        if (lessThan(candidate,TWO)) return false;
        if (primes.contains(candidate)) return true;

        return new CachedPrime(candidate).isPrime();
    }

    private CachedPrime(BigInteger candidate) {
        super(candidate);
    }

    private static final SortedSet<BigInteger> primes = new TreeSet<>();
    static {
        primes.add(TWO);
        primes.add(BigInteger.valueOf(3));
    }

    private boolean isPrime() {
        if (!BruteForcePrime.isPrime(candidate))
            return false;

        primes.add(candidate);
        return true;
    }
}
