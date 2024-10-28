package problem.no21to30;

import utils.operator.Aliquot;
import utils.sequence.CachedSequence;
import utils.sequence.arithmetic.AbundantSequence;

import java.math.BigInteger;
import java.util.stream.IntStream;

import static problem.Solution.problem;
import static utils.operator.BigComparisonOperator.lessThanOrEqual;

public class Problem23 {
    static final int NON_ABUNDANT_SUM_CEILING = 28123;
    static final CachedSequence<BigInteger> seq = CachedSequence.of(new AbundantSequence());

    public static void main(String[] args) {
        // https://projecteuler.net/problem=23
        problem("Non-abundant sums",
        () -> sumOfNonAbundantSums(NON_ABUNDANT_SUM_CEILING));
    }

    static long sumOfNonAbundantSums(int n) {
        return IntStream.rangeClosed(1, n)
                .filter(i -> !hasAbundantSum(i))
                .asLongStream().sum();
    }

    static boolean hasAbundantSum(int n) {
        if (n > NON_ABUNDANT_SUM_CEILING) return true;
        BigInteger b = BigInteger.valueOf(n);

        seq.reset();
        long max = n / 2;
        return seq.stream()
                .takeWhile(i -> lessThanOrEqual(i, max))
                .map(b::subtract)
                .anyMatch(Aliquot::isAbundant);
    }
}
