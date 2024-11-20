package problem.no61to70;

import static problem.Solution.problem;

public class Problem73 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=73
        problem("Counting fractions in a range", () ->
                orderedFractionBetweenWhere(3, 2, 12_000));
    }

    static long orderedFractionBetweenWhere(int fromDenominator, int toDenominator, int limit) {
        int[] duplicates = new int[limit + 1];
        long sum = 0;

        for (int d = fromDenominator + 1; d <= limit; d++) {
            int fromNumeratorInTermsOfD = d / fromDenominator;
            int toNumeratorInTermsOfD = (d + toDenominator - 1) / toDenominator;
            int numberOfFractionsLessDuplicates =
                    toNumeratorInTermsOfD - fromNumeratorInTermsOfD - 1 - duplicates[d];

            for (int i = d * 2; i <= limit; i += d)
                duplicates[i] += numberOfFractionsLessDuplicates;

            sum += numberOfFractionsLessDuplicates;
        }

        return sum;
    }
}
