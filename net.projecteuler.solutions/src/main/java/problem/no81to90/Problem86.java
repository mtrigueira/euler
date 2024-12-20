package problem.no81to90;

import static problem.Solution.problem;

public class Problem86 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=86
        problem("Cuboid route", () ->
                solution(1_000_000));
    }

    static int solution(int limit) {
        int m = 1;
        int sum = 0;

        for (; sum <= limit; m++)
            sum += countOfShortestIntegerPathsOfCuboidsFromNbyMbyMUpToMbyMbyM(m, m);

        return m - 1;
    }

    static int countOfShortestIntegerPathsOfCuboidsFromNbyMbyMUpToMbyMbyM(int n, int m) {
        int count = 0;

        for (int i = n; i <= m; i++)
            for (int j = 1; j <= i; j++)
                for (int k = 1; k <= j; k++)
                    if (Cube.of(k, j, i).isShortestRouteInteger())
                        count++;

        return count;
    }

    private static boolean isInteger(double d) {
        return d % 1 == 0;
    }

    private static double min(double... a) {
        double m = a[0];

        for (int i = 1, aLength = a.length; i < aLength; i++)
            m = Math.min(m, a[i]);

        return m;
    }

    private static int max(int... a) {
        int m = a[0];

        for (int i = 1, aLength = a.length; i < aLength; i++)
            m = Math.max(m, a[i]);

        return m;
    }

    record Cube(int x, int y, int z) {
        static Cube of(int a, int b, int c) {
            int x = (int) min(a, b, c);
            int z = max(a, b, c);
            int y = a + b + c - x - z;

            return new Cube(x, y, z);
        }

        double shortestRoute() {
            return Math.sqrt(z * z + (y + x) * (y + x));
        }

        boolean isShortestRouteInteger() {
            return isInteger(shortestRoute());
        }
    }

    private Problem86() {
    }
}
