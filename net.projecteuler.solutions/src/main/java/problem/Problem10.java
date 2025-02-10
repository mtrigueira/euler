package problem;

import utils.prime.Prime;

import static problem.Solution.problem;

public class Problem10 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=10
        problem("Sum of primes below 2,000,000",
                () ->
                        sumOfPrimesBelow(2_000_000));
    }

    static long sumOfPrimesBelow(int i) {
        return Prime.eratosthenesSieve(i).stream()
                .mapToLong(a -> a)
                .sum();
    }

    private Problem10() {}
}
