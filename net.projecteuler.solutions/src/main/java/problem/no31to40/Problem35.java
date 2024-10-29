package problem.no31to40;

import utils.prime.CircularPrimeChecker;
import utils.sequence.arithmetic.PrimeSequence;

import java.math.BigInteger;

import static problem.Solution.problem;

public class Problem35 {
     private Problem35() {
     }
    public static void main(String[] args) {
        // https://projecteuler.net/problem=35
        problem("Circular primes",
        () -> countCircularPrimesBelow(1_000_000));
    }

    static long countCircularPrimesBelow(int limit) {
        BigInteger b = BigInteger.valueOf(limit);
        return PrimeSequence.fromFirst().stream()
                .takeWhile(a -> a.compareTo(b) < 0)
                .filter(CircularPrimeChecker::isCircularPrime)
                .count();
    }
}
