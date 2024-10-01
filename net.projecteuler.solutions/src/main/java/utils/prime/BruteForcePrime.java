package utils.prime;

import utils.Prime;

public class BruteForcePrime extends Prime {
    public static boolean isPrime(long candidate) {
        if(candidate<2) return false;

        return new BruteForcePrime(candidate).isPrime();
    }

    final long candidate;
    BruteForcePrime(long candidate) {
        this.candidate = candidate;
    }

    private boolean isPrime() {
        return !hasFactorGreatherThanOrEqualTo2();
    }

    private boolean hasFactorGreatherThanOrEqualTo2() {
        long maxPotentialFactor = (long)Math.sqrt(candidate);

        for(long i=2;i<=maxPotentialFactor;i++)
            if(isAFactor(i))
                return true;

        return false;
    }

    private boolean isAFactor(long factor) {
        return candidate % factor == 0;
    }
}
