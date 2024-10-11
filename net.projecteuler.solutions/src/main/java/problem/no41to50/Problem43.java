package problem.no41to50;

import utils.prime.Prime;
import utils.sequence.arithmetic.PrimeSequence;
import utils.sequence.given.CombinationSequence;

import java.math.BigInteger;
import java.util.List;

import static problem.Solution.problem;
import static problem.Solution.solution;

public class Problem43 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=41
        problem("Pandigital primes");

        solution(findDivisiblePanDigitals());
    }

    private static final List<String> DIGITS = List.of("0123456789".split(""));
    private static final Prime[] primes = PrimeSequence.fromFirst().nextArray(8);
    private static String findDivisiblePanDigitals() {
        return new CombinationSequence<>(DIGITS, (a, b) -> a + b).stream()
                .filter(Problem43::areAllSubstringsDivisible)
                .map(BigInteger::new)
                .reduce(BigInteger::add)
                .map(BigInteger::toString)
                .orElse("No divisible pandigitals found");
    }

    static boolean areAllSubstringsDivisible(String digits) {
        for (int j = 1; j < 8; j++)
            if (!isSubstringDivisible(digits, j)) return false;

        return true;
    }

    private static boolean isSubstringDivisible(String digits, int j) {
        return subInteger(digits, j).mod(primes[j - 1]).signum() == 0;
    }

    private static BigInteger subInteger(String digits, int j) {
        return new BigInteger(digits.substring(j, j + 3));
    }
}
