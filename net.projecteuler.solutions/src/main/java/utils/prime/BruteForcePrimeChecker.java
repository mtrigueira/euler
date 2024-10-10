package utils.prime;

import utils.property.Factors;

import java.math.BigInteger;

import static java.math.BigInteger.*;
import static utils.operator.BigComparisonOperator.lessThanOrEqual;

class BruteForcePrimeChecker extends PrimeChecker {
    public static boolean isPrime(BigInteger candidate) {
        return new BruteForcePrimeChecker(candidate).isPrime();
    }

    final BigInteger candidate;

    BruteForcePrimeChecker(BigInteger candidate) {
        this.candidate = candidate;
    }

    private boolean isPrime() {
        return !hasFactorGreaterThanOrEqualTo2();
    }

    private boolean hasFactorGreaterThanOrEqualTo2() {
        BigInteger maxPotentialFactor = candidate.sqrt();

        for (BigInteger i = TWO; lessThanOrEqual(i, maxPotentialFactor); i = i.add(ONE))
            if (Factors.isFactor(candidate, i))
                return true;

        return false;
    }

}
