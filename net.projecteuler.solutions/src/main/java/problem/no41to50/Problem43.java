package problem.no41to50;

import utils.Arrays;
import utils.prime.Prime;
import utils.sequence.arithmetic.PrimeSequence;
import utils.sequence.given.CombinationSequence;

import java.math.BigInteger;
import java.util.List;

public class Problem43 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=41
        System.out.println(findDivisiblePanDigitals());
    }

    private static final List<String> DIGITS = List.of("0123456789".split(""));
    private static final Prime[] primes = Arrays.makeArray(PrimeSequence.fromFirst(), 8);

    private static BigInteger findDivisiblePanDigitals() {
        CombinationSequence<String> combiner = new CombinationSequence<>(DIGITS, (a, b) -> a + b);
        BigInteger sum = BigInteger.ZERO;

        for (String digits = combiner.next(); combiner.hasNext(); digits = combiner.next())
            if (areAllSubstringsDivisible(digits))
                sum = sum.add(new BigInteger(digits));

        return sum;
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
