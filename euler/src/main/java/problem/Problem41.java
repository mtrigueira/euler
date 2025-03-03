package problem;

import utils.prime.Prime;
import utils.prime.PrimeChecker;
import utils.sequence.given.CombinationSequence;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static problem.Solution.problem;

public class Problem41 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=41
        problem("Pandigital prime",
                () ->
                        findPanDigitalPrimes(10)
                                .map(Prime::toString)
                                .orElse("No pandigital primes found")
        );
    }

    private static final List<String> DIGITS = List.of("123456789".split(""));

    static Optional<Prime> findPanDigitalPrimes(int digitCount) {
        ArrayList<String> digits = new ArrayList<>(DIGITS.subList(0, digitCount - 1));
        Optional<Prime> maybeMaxPrime;

        while (!digits.isEmpty()) {
            maybeMaxPrime = findMaxPanDigitalPrime(digits);
            if (maybeMaxPrime.isPresent())
                return maybeMaxPrime;
            digits.removeLast();
        }

        return Optional.empty();
    }

    private static Optional<Prime> findMaxPanDigitalPrime(List<String> digits) {
        return new CombinationSequence<>(digits, (a, b) -> a + b).stream()
                .map(BigInteger::new)
                .filter(PrimeChecker::isPrime)
                .max(BigInteger::compareTo)
                .flatMap(Prime::of);
    }

    private Problem41() {}
}
