package problem.no21to30;

import utils.sequence.LimitedSequence;
import utils.sequence.arithmetic.FibonnacciSequence;

import static problem.Solution.problem;
import static problem.Solution.solution;

public class Problem25 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=25
        problem("1000-digit Fibonacci number");
        solution(indexOfFirstFibonacciNumberWithLengthAtLeast(1_000));
    }

    static long indexOfFirstFibonacciNumberWithLengthAtLeast(int i) {
        return LimitedSequence.including(FibonnacciSequence.of(),
                a -> a.toString().length() >= i).stream().count();
    }
}
