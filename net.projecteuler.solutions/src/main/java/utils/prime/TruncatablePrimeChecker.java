package utils.prime;

import static utils.prime.PrimeChecker.isPrime;

public class TruncatablePrimeChecker {
    private static boolean isTruncatablePrime(long i, boolean leftToRight) {
        if (i < 10) return isPrime(i);

        if (!isPrime(i)) return false;
        long truncated = leftToRight ? truncate(i) : truncateR(i);

        return isTruncatablePrime(truncated, leftToRight);
    }

    private static long truncate(long i) {
        int length = String.valueOf(i).length();
        return i % (long) Math.pow(10, length - 1);
    }

    private static long truncateR(long i) {
        return i / 10;
    }

    public static boolean isTruncatablePrime(long i) {
        return isTruncatablePrime(i, true);
    }

    public static boolean isTruncatablePrimeBothDirections(Prime prime) {
        long i = prime.longValueExact();
        return isTruncatablePrime(i, true) && isTruncatablePrime(i, false);
    }
}
