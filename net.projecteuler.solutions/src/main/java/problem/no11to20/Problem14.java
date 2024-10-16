package problem.no11to20;

import utils.sequence.arithmetic.CollatzSequence;

import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;

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
        AtomicLong maxChainLength = new AtomicLong();
        AtomicLong maxChainLengthNumber = new AtomicLong(0);

        IntStream.range(1, limit).forEach(i -> {
            if(chainLength(i) > maxChainLength.get()) {
                maxChainLength.set(chainLength(i));
                maxChainLengthNumber.set(i);
            }
        });

        return maxChainLengthNumber.get();
    }

    static long chainLength(int i) {
        return CollatzSequence.of(i).stream()
                .takeWhile(a -> !ONE.equals(a))
                .count();
    }
}
