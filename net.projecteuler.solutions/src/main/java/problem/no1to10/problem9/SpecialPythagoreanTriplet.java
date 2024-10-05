package problem.no1to10.problem9;

public class SpecialPythagoreanTriplet {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=9
        System.out.println(productWhenSumEquals(1000));
    }

    public static int productWhenSumEquals(int sum) {
        int limit = sum - (1 + 2);

        for (int a = 1; a < limit - 2; a++)
            for (int b = a + 1; b < limit - 1; b++) {
                int c = calculateC(a, b, sum);
                if (isPythagoreanTriplet(a, b, c))
                    return product(a, b, c);
            }

        return -1;
    }

    private static int calculateC(int a, int b, int sum) {
        return sum - a - b;
    }

    private static boolean isPythagoreanTriplet(int a, int b, int c) {
        return a * a + b * b == c * c;
    }

    private static int product(int a, int b, int c) {
        return a * b * c;
    }
}
