package problem.no71to80;

import static problem.Solution.problem;

public class Problem72 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=72
        problem("Counting fractions", () ->
                orderedFractionToLeftOfWhere(1_000_000));
    }

    static long orderedFractionToLeftOfWhere(int lim) {
        long sum = 0;
        int[] duplicates = new int[lim + 1];
        for (int d = 2; d <= lim; d++) {
            int differentNumerators = d - 1;
            int uniqueFractions = differentNumerators - duplicates[d];
            sum += uniqueFractions;
            for (int i = d * 2; i <= lim; i += d)
                duplicates[i] += uniqueFractions;
        }

        return sum;
    }

    private Problem72() {
    }
}