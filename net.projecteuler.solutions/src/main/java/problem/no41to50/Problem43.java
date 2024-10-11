package problem.no41to50;

import utils.Combiner;
import utils.prime.Prime;
import utils.sequence.arithmetic.PrimeSequence;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static java.math.BigInteger.TEN;
import static java.math.BigInteger.ZERO;

public class Problem43 {
    private static final Set<Integer> DIGITS = Set.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
    private static final List<BigInteger> panDigitals = new ArrayList<>();
    private static final Prime[] primes = makePrimeArray();

    private static Prime[] makePrimeArray() {
        ArrayList<Prime> primes = new ArrayList<>();
        PrimeSequence seq = PrimeSequence.fromFirst();
        for (int j = 1; j < 8; j++) {
            Prime divisor = seq.next();
            primes.add(divisor);
        }
        return primes.toArray(new Prime[0]);
    }

    public static void main(String[] args) {
        // https://projecteuler.net/problem=41
        findDivisiblePanDigitals();

        System.out.println(sum());
    }

    private static void findDivisiblePanDigitals() {
        Combiner<Integer> combiner = Combiner.of(DIGITS);
        combiner.combine(Problem43::accumulateIfDivisible);
    }

    private static BigInteger sum() {
        return panDigitals.stream().reduce(BigInteger.ZERO, BigInteger::add);
    }

    private static void accumulateIfDivisible(List<Integer> digits) {
        if (!isSubDivisible(digits)) return;

        BigInteger i = squish(digits);
        panDigitals.add(i);
    }

    static boolean isSubDivisible(List<Integer> digits) {
        for (int j = 1; j < 8; j++) {
            BigInteger sub = squish(digits.subList(j, j + 3));
            if (sub.mod(primes[j - 1]).signum() != 0) return false;
        }
        return true;
    }

    static BigInteger squish(List<Integer> digits) {
        BigInteger value = ZERO;

        for (Integer digit : digits)
            value = value.multiply(TEN).add(BigInteger.valueOf(digit));

        return value;
    }
}
