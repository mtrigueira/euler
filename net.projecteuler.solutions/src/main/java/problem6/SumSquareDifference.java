package problem6;

public class SumSquareDifference {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=6
        System.out.println(of(100));
    }

    static long of(int i) {
        return SquareOfSums.of(i) - SumOfSquares.of(i);
    }
}
