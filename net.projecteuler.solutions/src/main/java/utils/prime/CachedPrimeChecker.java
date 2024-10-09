package utils.prime;

import java.math.BigInteger;
import java.util.SortedSet;
import java.util.TreeSet;

import static java.math.BigInteger.TWO;
import static utils.operator.BigComparisonOperator.lessThan;

class CachedPrimeChecker extends BruteForcePrimeChecker {
    public static boolean isPrime(BigInteger candidate) {
        if (lessThan(candidate,TWO)) return false;
        if (primes.contains(candidate)) return true;

        return new CachedPrimeChecker(candidate).isPrime();
    }

    private CachedPrimeChecker(BigInteger candidate) {
        super(candidate);
    }

    private static final SortedSet<BigInteger> primes = new TreeSet<>();
    static {
        primes.add(TWO);
        primes.add(BigInteger.valueOf(3));
    }

    private boolean isPrime() {
        if (!BruteForcePrimeChecker.isPrime(candidate))
            return false;

        primes.add(candidate);

        return true;
    }
}
