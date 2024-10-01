package utils;

import utils.prime.CachedPrime;

public abstract class Prime {
    public static boolean isPrime(long candidate) {
        if(candidate<2) return false;

        return CachedPrime.isPrime(candidate);
    }
}
