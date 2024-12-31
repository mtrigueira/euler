package problem.no21to30;

import utils.sequence.arithmetic.FibonacciSequence;

import java.math.BigInteger;

import static problem.Solution.problem;

public class Problem25 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=25
        problem("1000-digit Fibonacci number",
                () -> indexOfFirstFibonacciNumberWithLengthAtLeast(1_000));
    }

    static long indexOfFirstFibonacciNumberWithLengthAtLeast(int i) {
        return FibonacciSequence.of().stream()
                .map(BigInteger::toString)
                .map(String::length)
                .takeWhile(a -> a < i)
                .count() + 1;
    }

    private Problem25() {}
}
