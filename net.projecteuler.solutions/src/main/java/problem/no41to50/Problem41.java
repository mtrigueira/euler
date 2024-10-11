package problem.no41to50;

import utils.Combiner;
import utils.prime.Prime;

import java.math.BigInteger;
import java.util.*;

import static java.math.BigInteger.TEN;
import static java.math.BigInteger.ZERO;

public class Problem41 {
    private static final Set<Integer> DIGITS = Set.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
    private static final List<Prime> primes = new ArrayList<>();

    public static void main(String[] args) {
        // https://projecteuler.net/problem=41
        findPanDigitalPrimes();

        System.out.println(
                maximumPrime()
                        .map(Prime::toString)
                        .orElse("No pandigital primes found")
        );
    }

    private static void findPanDigitalPrimes() {
        SortedSet<Integer> digits = new TreeSet<>(DIGITS);

        while (!digits.isEmpty() && primes.isEmpty()) {
            findPanDigitalPrimes(digits);
            digits.remove(digits.last());
        }
    }

    private static void findPanDigitalPrimes(SortedSet<Integer> digits) {
        Combiner<Integer> combiner = Combiner.of(digits);
        combiner.combine(Problem41::accumulateIfIsPrime);
    }

    private static Optional<Prime> maximumPrime() {
        return primes.stream()
                .reduce(Prime::max);
    }

    private static void accumulateIfIsPrime(List<Integer> digits) {
        Prime.of(squish(digits)).ifPresent(primes::add);
    }

    static BigInteger squish(List<Integer> digits) {
        BigInteger value = ZERO;

        for (Integer digit : digits)
            value = value.multiply(TEN).add(BigInteger.valueOf(digit));

        return value;
    }
}
