package problem.no21to30.problem23;

import utils.Stopwatch;
import utils.sequence.arithmetic.AbundantSequence;
import utils.sequence.CachedSequence;

import java.math.BigInteger;

import static java.math.BigInteger.TWO;
import static utils.operator.Aliquot.isAbundant;
import static utils.operator.BigComparisonOperator.lessThanOrEqual;

public class NonAbundantSums {
    public static void main(String[] args) {
        Stopwatch t = Stopwatch.start();
        System.out.println(sumOfNonAbundantSums(NON_ABUNDANT_SUM_CEILING));
        t.println();
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
