package utils.prime;

import utils.property.Factors;

import java.math.BigInteger;

import static java.math.BigInteger.*;
import static utils.operator.BigComparisonOperator.lessThanOrEqual;

class BruteForcePrimeChecker {
    private BruteForcePrimeChecker() {}

    public static boolean isPrime(BigInteger candidate) {
        if(candidate.compareTo(ONE)<=0) return false;
        return !hasFactorGreaterThanOrEqualTo2(candidate);
    }

    private static boolean hasFactorGreaterThanOrEqualTo2(BigInteger candidate) {
        BigInteger maxPotentialFactor = candidate.sqrt();

        for (BigInteger i = TWO; lessThanOrEqual(i, maxPotentialFactor); i = i.add(ONE))
            if (Factors.isFactor(candidate, i))
                return true;

        return false;
    }
}
