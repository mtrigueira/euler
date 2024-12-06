package utils.prime;

import java.math.BigInteger;

import static java.math.BigInteger.TWO;
import static utils.operator.BigComparisonOperator.lessThan;

public abstract class PrimeChecker {
    public static boolean isPrime(long candidate) {
        return BruteForcePrimeChecker.isPrime(candidate);
    }

    public static boolean isPrime(BigInteger candidate) {
        if (lessThan(candidate, TWO)) return false;

        return CachedPrimeChecker.isPrime(candidate);
    }

    private PrimeChecker() {
    }
}
