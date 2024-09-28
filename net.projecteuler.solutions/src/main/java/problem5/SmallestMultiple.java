package problem5;

public class SmallestMultiple {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=5
        System.out.println(of(20));
    }

    public static long of(int n) {
        long maxCandidate = factorial(n);

        for (long candidate = 1; candidate <= maxCandidate; candidate++)
            if (isDivisibleByNaturalNumbersTo(candidate, n))
                return candidate;

        return -1;
    }

    static long factorial(long n) {
        return (n == 1) ? 1 : n * factorial(n - 1);
    }

    static boolean isDivisibleByNaturalNumbersTo(long multiple, long n) {
        for (long i = 1; i <= n; i++)
            if (!isAFactor(multiple, i))
                return false;

        return true;
    }

    private static boolean isAFactor(long i, long candidate) {
        return i % candidate == 0;
    }
}
