package problem.no31to40;

import utils.Pandigital;

import java.util.stream.LongStream;

import static problem.Solution.problem;

public class Problem38 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=38
        problem("Largest pandigital multiple",
                () -> largestPandigitalMultiple(10_000));
    }

    static long largestPandigitalMultiple(int endExclusive) {
        return LongStream.range(1, endExclusive).flatMap(i ->
                        LongStream.range(2, 9)
                                .map(j -> concatenatedProductsIfPandigitalOrZero(i, j))
                ).max()
                .orElse(0);
    }

    private static long concatenatedProductsIfPandigitalOrZero(long k, long n) {
        long s = concatenatedProducts(k, n);

        return !Pandigital.isPandigital(s) ? 0 : s;
    }

    private static long concatenatedProducts(long k, long n) {
        long s = 0;

        for (int i = 1; i <= n; i++) {
            long product = i * k;
            s = shiftDigitPlaces(s, product) + product;
            if (lengthOfDigits(s) > 9)
                return 0;
        }

        return s;
    }

    private static long shiftDigitPlaces(long s, long product) {
        return (long) (s * Math.pow(10, lengthOfDigits(product)));
    }

    private static long lengthOfDigits(long i) {
        return (long) Math.log10(i) + 1;
    }

    private Problem38() {}
}
