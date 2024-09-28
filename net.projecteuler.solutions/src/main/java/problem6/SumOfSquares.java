package problem6;

public class SumOfSquares {
    public static long of(int i) {
        double sum = 0;
        for (int j = 1; j <= i; j++)
            sum += Math.pow(j,2);

        return (long)sum;
    }
}
