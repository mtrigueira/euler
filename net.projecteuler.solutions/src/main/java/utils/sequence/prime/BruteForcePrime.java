package utils.sequence.prime;

import utils.Prime;

import java.math.BigInteger;

import static java.math.BigInteger.*;
import static utils.BigComparisonOperator.equal;
import static utils.BigComparisonOperator.lessThanOrEqual;

public class BruteForcePrime extends Prime {
    public static boolean isPrime(BigInteger candidate) {
        if(lessThanOrEqual(candidate, TWO)) return false;

        return new BruteForcePrime(candidate).isPrime();
    }

    final BigInteger candidate;

    BruteForcePrime(BigInteger candidate) {
        this.candidate = candidate;
    }

    private boolean isPrime() {
        return !hasFactorGreaterThanOrEqualTo2();
    }

    private boolean hasFactorGreaterThanOrEqualTo2() {
        BigInteger maxPotentialFactor = candidate.sqrt();

        for(BigInteger i=TWO;lessThanOrEqual(i,maxPotentialFactor);i=i.add(ONE))
            if(isAFactor(i))
                return true;

        return false;
    }

    private boolean isAFactor(BigInteger factor) {
        return equal(candidate.mod(factor), ZERO);
    }
}
