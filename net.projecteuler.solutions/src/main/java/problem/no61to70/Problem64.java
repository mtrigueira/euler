package problem.no61to70;

import utils.SqrtContinuedFraction;

import static problem.Solution.problem;
import static problem.Solution.solution;
import static utils.SqrtContinuedFraction.isPerfectSquare;

public class Problem64 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=64
        problem("Odd period square roots");
        solution(countOddPeriodSquareRoots(10_000));
    }

    static int countOddPeriodSquareRoots(int limitInclusive) {
        int count = 0;

        for (int i = 1; i <= limitInclusive; i++)
            if (!isPerfectSquare(i))
                if (isPeriodOdd(i))
                    count++;

        return count;
    }

    private static boolean isPeriodOdd(int i) {
        SqrtContinuedFraction continuedFraction = SqrtContinuedFraction.sqrt(i);
        if(continuedFraction instanceof SqrtContinuedFraction.IrrationalSqrtContinuedFraction)
            return ((SqrtContinuedFraction.IrrationalSqrtContinuedFraction) continuedFraction).period() % 2 == 1;
        else
            return false;
    }
}
