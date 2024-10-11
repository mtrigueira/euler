package problem.no1to10;

import utils.sequence.LimitedSequence;
import utils.sequence.arithmetic.EvenFibonnacciSequence;

import java.math.BigInteger;

import static java.math.BigInteger.ZERO;
import static problem.Solution.problem;
import static problem.Solution.solution;
import static utils.operator.BigComparisonOperator.lessThanOrEqual;

public class Problem2 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=2
        problem("Even Fibonacci numbers");
        solution(sum(4000000));
    }

    public static BigInteger sum(int limit) {
        return LimitedSequence.excluding(
                new EvenFibonnacciSequence(),
                new Problem2(limit)::isLimitReached)
                .stream()
                .reduce(ZERO, BigInteger::add);
    }

    private final BigInteger bigLimit;
    Problem2(int limit) {
        bigLimit = BigInteger.valueOf(limit);
    }

    private boolean isLimitReached(BigInteger fibonacciNumber) {
        boolean b = lessThanOrEqual(fibonacciNumber, bigLimit);
        return !b;
    }
}
