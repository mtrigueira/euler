package problem.no21to30;

import utils.Decimal;

import static problem.Solution.problem;
import static problem.Solution.solution;

public class Problem26 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=26
        problem("Reciprocal cycles");
        solution(indexOfLargestReciprocalCycle());
    }

    private static int indexOfLargestReciprocalCycle() {
        int max = 0;
        int maxIndex = 0;
        for (int i = 2; i < 1000; i++) {
            Decimal fraction = Decimal.of(1, i);
            if (fraction.isReciprocalCycle())
                if (fraction.reciprocalLength() > max) {
                    max = fraction.reciprocalLength();
                    maxIndex = i;
                }
        }
        return maxIndex;
    }
}

