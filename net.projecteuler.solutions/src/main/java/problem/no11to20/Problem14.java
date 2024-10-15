package problem.no11to20;

import utils.sequence.Sequence;
import utils.sequence.arithmetic.CollatzSequence;

import java.math.BigInteger;
import java.util.function.Function;

import static java.math.BigInteger.ONE;
import static problem.Solution.problem;
import static problem.Solution.solution;

public class Problem14 {
    public static final int LIMIT = 1000000;

    public static void main(String[] args) {
        // https://projecteuler.net/problem=14
        problem("Longest Collatz sequence");
        solution(getMaxChainLengthNumberForNaturalNumbersBelow(LIMIT));
    }

    static long getMaxChainLengthNumberForNaturalNumbersBelow(int limit) {
        long maxChainLength = 0;
        long maxChainLengthNumber = 0;

        for (int i = 1; i < limit; i++) {
            long length = chainLength(i);
            if(length > maxChainLength) {
                maxChainLength = length;
                maxChainLengthNumber = i;
            }
        }

        return maxChainLengthNumber;
    }

    static long chainLength(int i) {
        return CollatzSequence.of(i).stream()
                .takeWhile(a -> !ONE.equals(a))
                .count();
    }
}
