package problem.no21to30;

import utils.prime.PrimeChecker;

import java.util.stream.IntStream;

import static problem.Solution.problem;
import static utils.prime.PrimeChecker.isPrime;

public class Problem27 {
     private Problem27() {
     }
    public static void main(String[] args) {
        // https://projecteuler.net/problem=27
        problem("Quadratic primes",
        () -> productOfCoefficientsThatMaximiseConsecutiveValuesThatArePrime(1000, 1000));
    }

    static long productOfCoefficientsThatMaximiseConsecutiveValuesThatArePrime(int aExclusive, int bInclusive) {
        return IntStream.rangeClosed(-bInclusive, bInclusive)
                .filter(PrimeChecker::isPrime)
                .boxed()
                .flatMap(b -> IntStream.range(-aExclusive+1, aExclusive)
                        .mapToObj(a -> new Ugly(a * b, getN(a, b)))
                )
                .reduce((L, R) -> (L.n > R.n) ? L : R)
                .map(u -> u.product)
                .orElse(0);
    }

    private static int getN(int a, int b) {
        long candidate;

        for (int n = 1; ; n++) {
            candidate = (long)n * n+ (long)a * n + b;
            if (!isPrime(candidate))
                return n - 1;
        }
    }

    record Ugly(int product, int n) {
    }
}
