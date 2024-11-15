package problem.no11to20;

import utils.sequence.arithmetic.CollatzSequence;

import static problem.Solution.problem;

public class Problem14 {
    public static final int LIMIT = 1000000;

    private Problem14() {}

    public static void main(String[] args) {
        // https://projecteuler.net/problem=14
        problem("Longest Collatz sequence",
                () -> getMaxChainLengthNumberForNaturalNumbersBelow(LIMIT));
    }

    static long getMaxChainLengthNumberForNaturalNumbersBelow(int limit) {
        long bestI = 0;
        long bestChainLength = 0;

        for (int i = 1; i < limit; i++) {
            long chainLength = chainLength(i);
            if (chainLength - bestChainLength > 0) {
                bestI = i;
                bestChainLength = chainLength;
            }
        }

        return bestI;
    }

    private static long chainLength(int i) {
        return CollatzSequence.of(i).count();
    }
}
