package utils.prime;

import utils.property.Factors;

import java.math.BigInteger;
import java.util.Iterator;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.TWO;
import static utils.operator.BigComparisonOperator.lessThanOrEqual;
import static utils.sequence.arithmetic.PrimeSequence.THREE;

class BruteForcePrimeChecker {
    public static boolean isPrime(BigInteger candidate) {
        return isPrimeByTrialDivision(candidate);
    }

    static boolean isPrimeByTrialDivision(BigInteger candidate) {
        return hasNoFactorGreaterThanOrEqualTo2(candidate);
    }

    private static boolean hasNoFactorGreaterThanOrEqualTo2(BigInteger candidate) {
        if (candidate.compareTo(ONE) <= 0)
            return false;
        if (Factors.isFactor(candidate, TWO))
            return TWO.equals(candidate);
        BigInteger maxPotentialFactor = candidate.sqrt();

        for (BigInteger i = THREE; lessThanOrEqual(i, maxPotentialFactor); i = i.add(TWO))
            if (Factors.isFactor(candidate, i))
                return false;

        return true;
    }

    public static boolean isPrime(long candidate) {
        return isPrimeByTrialDivision(candidate);
    }

    static boolean isPrimeByTrialDivision(long candidate) {
        return hasNoFactorGreaterThanOrEqualTo2withPrimes(candidate);
    }

    private static boolean hasNoFactorGreaterThanOrEqualTo2withPrimes(long candidate) {
        if (candidate <= 1)
            return false;
        if (Factors.isFactor(candidate, 2))
            return candidate == 2;
        long maxPotentialFactor = (long) Math.sqrt(candidate);
        Iterator<Integer> it = Prime.primes.iterator();

        long i;
        for (i = it.next(); i <= maxPotentialFactor && it.hasNext(); i = it.next())
            if (Factors.isFactor(candidate, i))
                return false;

        for (i += 2; i <= maxPotentialFactor; i += 2)
            if (Factors.isFactor(candidate, i))
                return false;

        return true;
    }

    private BruteForcePrimeChecker() {
    }
}
