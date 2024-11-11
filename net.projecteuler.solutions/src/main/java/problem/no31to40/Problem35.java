package problem.no31to40;

import utils.prime.CircularPrimeChecker;
import utils.prime.Prime;

import static problem.Solution.problem;

public class Problem35 {
    private Problem35() {}

    public static void main(String[] args) {
        // https://projecteuler.net/problem=35
        problem("Circular primes",
                () -> countCircularPrimesBelow(1_000_000));
    }

    static long countCircularPrimesBelow(int limit) {
        return Prime.eratosthenesSieve(limit)
                .stream()
                .filter(CircularPrimeChecker::isCircularPrime)
                .count();
    }
}
