package problem.no41to50;

import utils.prime.Prime;
import utils.prime.PrimeChecker;
import utils.sequence.given.CombinationSequence;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static problem.Solution.problem;
import static problem.Solution.solution;

public class Problem41 {
    private static final List<String> DIGITS = List.of("123456789".split(""));

    public static void main(String[] args) {
        // https://projecteuler.net/problem=41
        problem("Pandigital prime");
        solution(
                findPanDigitalPrimes()
                        .map(Prime::toString)
                        .orElse("No pandigital primes found")
        );
    }

    private static Optional<Prime> findPanDigitalPrimes() {
        ArrayList<String> digits = new ArrayList<>(DIGITS);
        Optional<Prime> maybeMaxPrime;

        do {
            maybeMaxPrime = findMaxPanDigitalPrime(digits);
            if(maybeMaxPrime.isPresent()) return maybeMaxPrime;
            digits.removeLast();
        } while (!digits.isEmpty());

        return Optional.empty();
    }

    private static Optional<Prime> findMaxPanDigitalPrime(List<String> digits) {
        CombinationSequence<String> combiner = new CombinationSequence<>(digits, (a, b) -> a + b);

        return combiner.stream()
                .map(BigInteger::new)
                .filter(PrimeChecker::isPrime)
                .max(BigInteger::compareTo).flatMap(Prime::of);
    }
}
