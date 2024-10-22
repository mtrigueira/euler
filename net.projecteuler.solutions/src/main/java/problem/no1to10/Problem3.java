package problem.no1to10;

import utils.prime.Prime;
import utils.property.Factors;

import java.math.BigInteger;
import java.util.Optional;

import static problem.Solution.problem;
import static problem.Solution.solution;

public class Problem3 {
    public static final long TARGET = 600851475143L;

    public static void main(String[] args) {
        // https://projecteuler.net/problem=3
        problem("Largest prime factor of " + TARGET);
        solution(largestPrimeFactorOrNotFound(TARGET));
    }

    static String largestPrimeFactorOrNotFound(long target) {
        return Factors.of(target).stream()
                .map(Prime::of)
                .flatMap(Optional::stream)
                .max(BigInteger::compareTo)
                .map(BigInteger::toString).orElse("No prime factor found");
    }
}
