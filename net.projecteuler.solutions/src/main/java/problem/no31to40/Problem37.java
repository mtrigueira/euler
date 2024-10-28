package problem.no31to40;

import utils.prime.Prime;
import utils.prime.TruncatablePrimeChecker;
import utils.sequence.arithmetic.PrimeSequence;

import java.math.BigInteger;

import static java.math.BigInteger.ZERO;
import static problem.Solution.problem;

public class Problem37 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=37
        problem("Truncatable primes",
        () -> sumOfTruncatablePrimes(11));
    }

    static BigInteger sumOfTruncatablePrimes(int limit) {
        if (limit > 11)
            throw new IllegalArgumentException("There are only 11");

        return PrimeSequence.from(11).stream()
                .filter(TruncatablePrimeChecker::isTruncatablePrimeBothDirections)
                .limit(limit)
                .map(Prime::toBigInteger)
                .reduce(ZERO, BigInteger::add);
    }
}
