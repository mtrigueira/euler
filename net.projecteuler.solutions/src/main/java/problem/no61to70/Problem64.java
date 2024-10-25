package problem.no61to70;

import utils.ContinuedFraction;

import static problem.Solution.problem;
import static problem.Solution.solution;

public class Problem64 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=64
        problem("Odd period square roots");
        solution(countOddPeriodSquareRoots(10_000));
    }

    static int countOddPeriodSquareRoots(int limitInclusive) {
        int count = 0;

        for (int i = 1; i <= limitInclusive; i++)
            if (!ContinuedFraction.isPerfectSquare(i))
                if (isPeriodOdd(i))
                    count++;

        return count;
    }

    private static boolean isPeriodOdd(int i) {
        return ContinuedFraction.sqrt(i).period() % 2 == 1;
    }
}
