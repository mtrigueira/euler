package problem.no61to70;

import utils.continuedFraction.ContinuedFraction;
import utils.continuedFraction.IrrationalSqrtContinuedFraction;

import java.math.BigInteger;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.ZERO;
import static problem.Solution.problem;

public class Problem66 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=66
        problem("Diophantine equation",
                () -> largestXForDLessThanOrEqual(1000));
    }

    static int largestXForDLessThanOrEqual(int limit) {
        BigInteger maxX = ZERO;
        int dAtXMax = 0;

        for (int d = 2; d <= limit; d++) {
            if (isSquare(d)) continue;
            IrrationalSqrtContinuedFraction cf = (IrrationalSqrtContinuedFraction) ContinuedFraction.sqrt(d);
            BigInteger p_kMinus1 = ZERO;
            BigInteger p_k = ONE;

            int targetIndex = (cf.period() % 2) == 0 ? cf.period() : 2 * cf.period();
            for (int i = 0; i < targetIndex; i++) {
                BigInteger a_kPlus1 = cf.at(i);
                BigInteger p_kPlus1 = a_kPlus1.multiply(p_k).add(p_kMinus1);
                p_kMinus1 = p_k;
                p_k = p_kPlus1;
            }

            if (p_k.compareTo(maxX) > 0) {
                maxX = p_k;
                dAtXMax = d;
            }
        }

        return dAtXMax;
    }

    private static boolean isSquare(int d) {
        return Math.sqrt(d) % 1 == 0;
    }

    private Problem66() {
    }
}
