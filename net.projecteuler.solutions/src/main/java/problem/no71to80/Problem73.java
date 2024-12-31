package problem.no71to80;

import static problem.Solution.problem;

public class Problem73 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=73
        problem("Counting fractions in a range", () ->
                orderedFractionBetweenOneOverFromDenominatorToOneOverTwoDenominatorWhere(12_000));
    }

    public static final int FROM_DENOMINATOR = 3;
    public static final int TO_DENOMINATOR = 2;

    static long orderedFractionBetweenOneOverFromDenominatorToOneOverTwoDenominatorWhere(int limit) {
        int[] duplicates = new int[limit + 1];
        long sum = 0;

        for (int d = FROM_DENOMINATOR + 1; d <= limit; d++) {
            int fromNumeratorInTermsOfD = d / FROM_DENOMINATOR;
            int toNumeratorInTermsOfD = (d + TO_DENOMINATOR - 1) / TO_DENOMINATOR;
            int numberOfFractionsLessDuplicates =
                    toNumeratorInTermsOfD - fromNumeratorInTermsOfD - 1 - duplicates[d];

            for (int i = d * 2; i <= limit; i += d)
                duplicates[i] += numberOfFractionsLessDuplicates;

            sum += numberOfFractionsLessDuplicates;
        }

        return sum;
    }

    private Problem73() {}
}
