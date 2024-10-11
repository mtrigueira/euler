package problem.no21to30;

import utils.sequence.CachedSequence;
import utils.sequence.arithmetic.AbundantSequence;

import java.math.BigInteger;

import static java.math.BigInteger.TWO;
import static problem.Solution.problem;
import static problem.Solution.solution;
import static utils.operator.Aliquot.isAbundant;
import static utils.operator.BigComparisonOperator.lessThanOrEqual;

public class Problem23 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=23
        problem("Non-abundant sums");
        solution(sumOfNonAbundantSums(NON_ABUNDANT_SUM_CEILING));
    }

    static final int NON_ABUNDANT_SUM_CEILING = 28123;
    static final CachedSequence<BigInteger> seq = CachedSequence.of(new AbundantSequence());

    static long sumOfNonAbundantSums(int n) {
        long sum = 0;
        for (int i = 1; i <= n; i++)
            if (!hasAbundantSum(i))
                sum += i;

        return sum;
    }

    static boolean hasAbundantSum(int n) {
        if (n > NON_ABUNDANT_SUM_CEILING) return true;
        BigInteger b = BigInteger.valueOf(n);

        seq.reset();
        BigInteger max = BigInteger.valueOf(n).divide(TWO);
        for (BigInteger i = seq.next(); lessThanOrEqual(i, max); i = seq.next())
            if (isAbundant(b.subtract(i)))
                return true;

        return false;
    }
}
