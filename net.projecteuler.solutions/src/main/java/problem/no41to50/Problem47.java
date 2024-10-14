package problem.no41to50;

import utils.prime.PrimeChecker;
import utils.property.Factors;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Optional;

import static problem.Solution.problem;
import static problem.Solution.solution;

public class Problem47 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=47
        problem("Distinct primes factors");
        solution(firstNConsecutiveIntegersToHaveFourDistinctPrimes(4).map(BigInteger::toString).orElse("Not Found"));
    }

    static Optional<BigInteger> firstNConsecutiveIntegersToHaveFourDistinctPrimes(int n) {
        ArrayList<ArrayList<Long>> factorTable = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            ArrayList<Long> factors = new ArrayList<>();
            factorTable.add(factors);
        }
        long i = 1;
        int count = 0;
        while (true) {
            ArrayList<Long> factors = factorTable.get(n - 1);
            factors.clear();
            factors.addAll(Factors.of(i).stream().filter(PrimeChecker::isPrime).toList());
            if (factors.stream().distinct().count() == n) {
                count++;
                if (count == n) {
                    return Optional.of(BigInteger.valueOf(i - n + 1));
                }
            } else {
                count = 0;
            }

            i++;
            factors = factorTable.remove(0);
            factorTable.add(factors);
        }
    }
}
