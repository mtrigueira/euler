package problem.no41to50;

import utils.prime.PrimeChecker;
import utils.property.Factors;

import java.math.BigInteger;

import static problem.Solution.problem;
import static problem.Solution.solution;

public class Problem47 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=47
        problem("Distinct primes factors");
        solution(firstNConsecutiveIntegersToHaveNDistinctPrimes(4));
    }

    static BigInteger firstNConsecutiveIntegersToHaveNDistinctPrimes(int n) {
        int consecutiveCount = 0;

        for (long i = 2;true;i++)
            if (Factors.of(i).stream().filter(PrimeChecker::isPrime).distinct().count() == n) {
                if (++consecutiveCount == n)
                    return BigInteger.valueOf(i - n + 1);
            } else
                consecutiveCount = 0;
    }
}
