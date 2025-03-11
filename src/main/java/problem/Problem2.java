package problem;

import utils.sequence.arithmetic.EvenFibonacciSequence;

import java.math.BigInteger;

import static java.math.BigInteger.ZERO;
import static problem.Solution.problem;
import static utils.operator.BigComparisonOperator.lessThanOrEqual;

public class Problem2 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=2
        problem("Even Fibonacci numbers", () -> sum(4000000));
    }

    public static BigInteger sum(int limit) {
        return new EvenFibonacciSequence().stream().takeWhile(a -> lessThanOrEqual(a, limit)).reduce(ZERO, BigInteger::add);
    }

    private Problem2() {}
}
