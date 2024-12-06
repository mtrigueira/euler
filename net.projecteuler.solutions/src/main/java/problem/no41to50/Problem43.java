package problem.no41to50;

import utils.prime.Prime;
import utils.sequence.arithmetic.PrimeSequence;
import utils.sequence.given.CombinationSequence;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static problem.Solution.problem;

public class Problem43 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=41
        problem("Pandigital primes",
                () -> findDivisiblePanDigitals(10));
    }

    private static final List<String> DIGITS = List.of("0123456789".split(""));
    private static final Prime[] primes = PrimeSequence.fromFirst().nextArray(DIGITS.size() - 2);

    static String findDivisiblePanDigitals(int limit) {
        return combine(threeDigitPrimeDivisibles()).stream()
                .limit(limit)
                .map(Problem43::prefixWithMissingDigit)
                .map(BigInteger::new)
                .reduce(BigInteger::add)
                .map(BigInteger::toString)
                .orElse("No divisible pandigital found");
    }

    private static Map<Prime, List<String>> threeDigitPrimeDivisibles() {
        Map<Prime, List<String>> ints = new HashMap<>(primes.length);
        IntStream.range(0, primes.length - 1).forEach(i -> {
            Stream<String> threeDigitStream = new CombinationSequence<>(DIGITS, (a, b) -> a + b, 3).stream();
            Prime prime = primes[i];
            int p = prime.intValueExact();
            ints.put(prime, threeDigitStream.mapToInt(Integer::parseInt)
                    .filter(a -> isPerfectlyDivisibleBy(p, a))
                    .mapToObj(Integer::toString)
                    .map(Problem43::fixLeadingZero)
                    .toList());
        });
        return ints;
    }

    private static boolean isPerfectlyDivisibleBy(int p, int a) {
        return a % p == 0;
    }

    private static String fixLeadingZero(String a) {
        return a.length() < 3 ? "0" + a : a;
    }

    private static String prefixWithMissingDigit(String x) {
        List<String> leftOvers = DIGITS.stream().filter(d -> !x.contains(d)).toList();
        return leftOvers.get(0) + x;
    }

    private static List<String> combine(Map<Prime, List<String>> ints) {
        Iterator<List<String>> i = ints.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .iterator();

        return combine(i, i.next());
    }

    private static List<String> combine(Iterator<List<String>> i, List<String> candidates) {
        List<String> right = i.next();
        List<String> result = candidates.stream()
                .flatMap(left -> combine(left, right))
                .filter(Problem43::uniqueDigits).toList();

        return i.hasNext() ? combine(i, result) : result;
    }

    private static Stream<String> combine(String left, List<String> right) {
        String overlap = left.substring(left.length() - 2);
        return right.stream()
                .filter(b -> overlap.equals(b.substring(0, 2)))
                .map(b -> left + b.substring(2));
    }

    private static boolean uniqueDigits(String a) {
        return a.chars().distinct().count() == a.length();
    }

    private Problem43() {
    }
}
