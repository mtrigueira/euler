package problem.no61to70;

import static problem.Solution.problem;

public class Problem72 {
    private Problem72() {
    }

    public static void main(String[] args) {
        // https://projecteuler.net/problem=72
        problem("Counting fractions", () ->
                orderedFractionToLeftOfWhere(1_000_000));
    }

    static int orderedFractionToLeftOfWhere(int lim) {
        int sum = 0;
        int[] count = new int[lim + 1];
        for (int d = 2; d <= lim; d++) {
            count[d] = d - 1;
            for (int i = d * 2; i <= lim; i += d)
                count[i]++;
        }

        for (int i = 2; i <= lim; i++)
            sum+=count[i];

        return sum;
    }
}