package problem.no41to50;

import utils.prime.PrimeChecker;
import utils.property.Factors;

import java.math.BigInteger;

import static problem.Solution.problem;

public class Problem47 {
     private Problem47() {
     }
    public static void main(String[] args) {
        // https://projecteuler.net/problem=47
        problem("Distinct primes factors",
        () -> firstNConsecutiveIntegersToHaveNDistinctPrimes(4));
    }

    static BigInteger firstNConsecutiveIntegersToHaveNDistinctPrimes(int n) {
        int consecutiveCount = 0;

        for (long i = 2; ; i++)
            if (Factors.of(i).stream().filter(PrimeChecker::isPrime).count() == n) {
                if (++consecutiveCount == n)
                    return BigInteger.valueOf(i - n + 1);
            } else
                consecutiveCount = 0;
    }
}
