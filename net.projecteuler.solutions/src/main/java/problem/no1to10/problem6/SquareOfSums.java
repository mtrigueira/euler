package problem.no1to10.problem6;

public class SquareOfSums {
    public static long of(int i) {
        long sum = 0;

        for (int j = 1; j <= i; j++) sum += j;

        return (long)Math.pow(sum,2);
    }
}
