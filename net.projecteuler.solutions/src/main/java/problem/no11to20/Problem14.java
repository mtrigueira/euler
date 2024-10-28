package problem.no11to20;

import utils.sequence.arithmetic.CollatzSequence;

import java.util.stream.IntStream;

import static java.math.BigInteger.ONE;
import static problem.Solution.problem;

public class Problem14 {
    public static final int LIMIT = 1000000;

    public static void main(String[] args) {
        // https://projecteuler.net/problem=14
        problem("Longest Collatz sequence",
        () -> getMaxChainLengthNumberForNaturalNumbersBelow(LIMIT));
    }

    static long getMaxChainLengthNumberForNaturalNumbersBelow(int limit) {
        return IntStream.range(1, limit)
                .mapToObj(i -> new Ugly(i, chainLength(i)))
                .max((a, b) -> Math.toIntExact(a.chainLength - b.chainLength))
                .map(u -> u.i)
                .orElseThrow();
    }

    static long chainLength(int i) {
        return CollatzSequence.of(i).stream()
                .takeWhile(a -> !ONE.equals(a))
                .count();
    }

    private record Ugly(int i, long chainLength) {}
}
