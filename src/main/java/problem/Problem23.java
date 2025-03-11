package problem;

import utils.sequence.CachedSequence;
import utils.sequence.arithmetic.AbundantSequence;

import java.math.BigInteger;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static problem.Solution.problem;

public class Problem23 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=23
        problem("Non-abundant sums",
                () -> sumOfNonAbundantSums(NON_ABUNDANT_SUM_CEILING));
    }

    static final int NON_ABUNDANT_SUM_CEILING = 28123;
    static Set<BigInteger> abundants;
    static Set<BigInteger> abundantsInOrder;

    static long sumOfNonAbundantSums(int n) {
        abundants = CachedSequence.of(new AbundantSequence())
                .stream()
                .takeWhile(i -> i.longValueExact() <= n)
                .collect(Collectors.toSet());

        abundantsInOrder = new TreeSet<>(abundants);
        return IntStream.rangeClosed(1, n)
                .filter(i -> !hasAbundantSum(i))
                .asLongStream().sum();
    }

    static boolean hasAbundantSum(int n) {
        if (n > NON_ABUNDANT_SUM_CEILING)
            return true;
        BigInteger b = BigInteger.valueOf(n);

        return abundantsInOrder.stream()
                .map(b::subtract)
                .takeWhile(i -> i.signum() > 0)
                .anyMatch(a -> abundants.contains(a));
    }

    private Problem23() {}
}
