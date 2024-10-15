package problem.no41to50;

import utils.prime.Prime;
import utils.sequence.arithmetic.PrimeSequence;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static problem.Solution.problem;
import static problem.Solution.solution;

public class Problem49 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=49
        problem("Prime permutations");
        solution(primePermutations());
    }

    private static String primePermutations() {
        List<Prime> primes = withAtLeast3permutations(listOf4DigitPrimesExcluding1487());
        List<Prime> aList = primes.subList(0, primes.size() - 2);
        List<Prime> bList = primes.subList(1, primes.size() - 1);

        for (Prime a : aList) {
            for (Prime b : bList)
                if (arePermutations(a, b)) {
                    List<Prime> cList = primes.subList(primes.size() - bList.size() - 1, primes.size());
                    for (Prime c : cList)
                        if (arePermutations(b, c))
                            if (areEquidistant(a, b, c))
                                return ("" + a + b + c);
                }
            bList = bList.subList(1, bList.size() - 1);
        }

        return "Not found";
    }

    private static boolean areEquidistant(Prime a, Prime b, Prime c) {
        return delta(b, a) == delta(c, b);
    }

    private static int delta(Prime b, Prime a) {
        return b.intValue() - a.intValue();
    }

    private static boolean arePermutations(Prime a, Prime b) {
        return sortDigits(a).equals(sortDigits(b));
    }

    private static List<Prime> withAtLeast3permutations(List<Prime> primes) {
        List<String> sortedStrings = primes.stream().map(Problem49::sortDigits).toList();

        Set<String> atLeast3permutations = sortedStrings.stream()
                .filter(a -> Collections.frequency(sortedStrings, a) > 2)
                .collect(Collectors.toSet());
        return primes.stream()
                .filter(a -> atLeast3permutations.contains(sortDigits(a)))
                .toList();
    }

    private static List<Prime> listOf4DigitPrimesExcluding1487() {
        return PrimeSequence.fromFirst().stream()
                .dropWhile(a -> a.intValue() < 1000)
                .takeWhile(a -> a.intValue() < 10000)
                .filter(a -> a.intValue() != 1487)
                .toList();
    }

    private static String sortDigits(Prime a) {
        return a.toString().chars()
                .sorted()
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
