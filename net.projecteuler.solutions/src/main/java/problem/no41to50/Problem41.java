package problem.no41to50;

import utils.prime.Prime;
import utils.sequence.given.CombinationSequence;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Problem41 {
    private static final List<String> DIGITS = List.of("123456789".split(""));

    public static void main(String[] args) {
        // https://projecteuler.net/problem=41
        System.out.println(
                findPanDigitalPrimes()
                        .map(Prime::toString)
                        .orElse("No pandigital primes found")
        );
    }

    private static Optional<Prime> findPanDigitalPrimes() {
        ArrayList<String> digits = new ArrayList<>(DIGITS);
        Optional<Prime> maybeMaxPrime = Optional.empty();

        while (!digits.isEmpty() && maybeMaxPrime.isEmpty()) {
            maybeMaxPrime = findMaxPanDigitalPrime(digits);
            digits.removeLast();
        }

        return maybeMaxPrime;
    }

    private static Optional<Prime> findMaxPanDigitalPrime(List<String> digits) {
        CombinationSequence<String> combiner = new CombinationSequence<>(digits, (a, b) -> a + b);

        Optional<Prime> max = Optional.empty();
        while (combiner.hasNext()) {
            String i = combiner.next();
            Optional<Prime> optionalPrime = Prime.of(new BigInteger(i));
            if (optionalPrime.isPresent())
                if (max.isEmpty() || max.get().compareTo(optionalPrime.get()) < 0)
                    max = optionalPrime;
        }
        return max;
    }
}
