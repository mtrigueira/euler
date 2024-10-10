package problem.no1to10;

public class Problem6 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=6
        System.out.println(of(100));
    }

    static long of(int i) {
        return SquareOfSums.of(i) - SumOfSquares.of(i);
    }

    public static class SquareOfSums {
        public static long of(int i) {
            long sum = 0;

            for (int j = 1; j <= i; j++) sum += j;

            return (long)Math.pow(sum,2);
        }
    }

    public static class SumOfSquares {
        public static long of(int i) {
            double sum = 0;
            for (int j = 1; j <= i; j++)
                sum += Math.pow(j,2);

            return (long)sum;
        }
    }
}
