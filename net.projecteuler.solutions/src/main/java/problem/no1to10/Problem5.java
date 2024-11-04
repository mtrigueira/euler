package problem.no1to10;

import java.util.stream.LongStream;

import static problem.Solution.problem;
import static utils.prime.PrimeChecker.isPrime;

public class Problem5 {
    private Problem5() {}

    public static void main(String[] args) {
        // https://projecteuler.net/problem=5
        problem("Smallest multiple",
                () ->
                        smallestEvenlyDivisibleByAllNaturalNumbersBelow(20));
    }

    public static long smallestEvenlyDivisibleByAllNaturalNumbersBelow(int n) {
        int i = n;
        long primeProduct = 1;
        while (i >= 2) {
            if (isPrime(i))
                primeProduct = primeProduct * i;
            i--;
        }

        i = 2;
        long c = primeProduct;
        while (!isDivisibleByNaturalNumbersTo(c, n))
            c = primeProduct * i++;

        return c;
    }

    static boolean isDivisibleByNaturalNumbersTo(long multiple, long n) {
        return LongStream.rangeClosed(1, n)
                .allMatch(i -> isAFactor(multiple, i));
    }

    private static boolean isAFactor(long i, long candidate) {
        return i % candidate == 0;
    }
}
