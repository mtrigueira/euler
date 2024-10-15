package problem.no1to10;

import utils.prime.Prime;
import utils.sequence.arithmetic.PrimeSequence;

import java.math.BigInteger;

import static java.math.BigInteger.ZERO;
import static problem.Solution.problem;
import static problem.Solution.solution;
import static utils.operator.BigComparisonOperator.lessThan;

public class Problem10 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=10
        problem("Sum of primes below 2,000,000");

        solution(sumOfPrimesBelow(2_000_000));
    }

    static BigInteger sumOfPrimesBelow(int i) {
        return PrimeSequence.fromFirst().stream()
                .takeWhile(a -> lessThan(a, i))
                .map(Prime::bigInteger)
                .reduce(ZERO, BigInteger::add);
    }
}
