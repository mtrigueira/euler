package problem.no61to70;

import utils.continuedFraction.ContinuedFraction;
import utils.continuedFraction.IrrationalSqrtContinuedFraction;

import static problem.Solution.problem;

public class Problem64 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=64
        problem("Odd period square roots",
                () -> countOddPeriodSquareRoots(10_000));
    }

    static int countOddPeriodSquareRoots(int limitInclusive) {
        int count = 0;

        for (int i = 1; i <= limitInclusive; i++)
            if (Math.sqrt(i)%1!=0)
                if (isPeriodOdd(i))
                    count++;

        return count;
    }

    static boolean isPeriodOdd(int i) {
        ContinuedFraction cf = ContinuedFraction.sqrt(i);
        if (cf instanceof IrrationalSqrtContinuedFraction)
            return ((IrrationalSqrtContinuedFraction) cf).period() % 2 == 1;
        else
            return false;
    }

    private Problem64() {}
}
