package problem.no31to40;

import utils.prime.PrimeChecker;
import utils.prime.TruncatablePrimeChecker;

import static problem.Solution.problem;

public class Problem37 {
    private Problem37() {
    }

    public static void main(String[] args) {
        // https://projecteuler.net/problem=37
        problem("Truncatable primes",
                () -> sumOfTruncatablePrimes(11));
    }

    static long sumOfTruncatablePrimes(int limit) {
        if (limit > 11)
            throw new IllegalArgumentException("There are only 11");

        int i = 11;
        long sum = 0;
        while (limit > 0) {
            if (PrimeChecker.isPrime(i))
                if (TruncatablePrimeChecker.isTruncatablePrimeBothDirections(i)) {
                    sum += i;
                    limit--;
                }
            i+=2;
        }

        return sum;
    }
}
