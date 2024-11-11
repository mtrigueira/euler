package utils.prime;

import static utils.prime.PrimeChecker.isPrime;

public class TruncatablePrimeChecker {
    private TruncatablePrimeChecker() {
    }

    static boolean isTruncatablePrimeL(long i) {
        if (i < 10) return isPrime(i);
        if (!isPrime(i)) return false;
        return isTruncatablePrimeL(truncateL(i));
    }

    static boolean isTruncatablePrimeR(long i) {
        if (i < 10) return isPrime(i);
        if (!isPrime(i)) return false;
        return isTruncatablePrimeR(truncateR(i));
    }

    private static long truncateL(long i) {
        int length = (int)Math.log10(i);
        return i % (long) Math.pow(10, length);
    }

    private static long truncateR(long i) {
        return i / 10;
    }

    public static boolean isTruncatablePrimeBothDirections(long prime) {
        return isTruncatablePrimeL(truncateL(prime)) && isTruncatablePrimeR(truncateR(prime));
    }
}
