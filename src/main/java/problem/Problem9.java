package problem;

import utils.PythagoreanTriangle;

import static problem.Solution.problem;

public class Problem9 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=9
        problem("Special Pythagorean triplet",
                () -> productWhenSumEquals(1000));
    }

    public static int productWhenSumEquals(int sum) {
        int limit = sum - (1 + 2);

        for (int a = 1; a < limit - 2; a++)
            for (int b = a + 1; b < limit - 1; b++) {
                int c = PythagoreanTriangle.calculateC(a, b, sum);
                if (PythagoreanTriangle.isPythagoreanTriplet(a, b, c))
                    return PythagoreanTriangle.product(a, b, c);
            }

        return -1;
    }

    private Problem9() {}
}
