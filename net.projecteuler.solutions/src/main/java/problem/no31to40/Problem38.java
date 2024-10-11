package problem.no31to40;

import utils.Pandigital;

import static problem.Solution.problem;
import static problem.Solution.solution;

public class Problem38 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=38
        problem("Largest pandigital multiple");
        solution(largestPandigitalMultiple());
    }

    private static long largestPandigitalMultiple() {
        long max = 0;

        for (int i = 1; i < 10_000; i++)
            for (int j = 2; j <= 9; j++) {
                long s = concatenatedProductsIfPandigitalOrZero(i, j);
                if (max < s)
                    max = s;
            }

        return max;
    }

    private static long concatenatedProductsIfPandigitalOrZero(int k, int n) {
        long s = concatenatedProducts(k, n);

        if (!Pandigital.isPandigital(s)) return 0;
        return s;
    }

    private static long concatenatedProducts(int k, int n) {
        long s = 0;

        for (int i = 1; i <= n; i++) {
            int product = i * k;
            s = shiftDigitPlaces(s, product) + product;
            if (lengthOfDigits(s) > 9) return 0;
        }

        return s;
    }

    private static long shiftDigitPlaces(long s, int product) {
        return (long) (s * Math.pow(10, lengthOfDigits(product)));
    }

    private static long lengthOfDigits(long i) {
        return (long) Math.log10(i) + 1;
    }
}
