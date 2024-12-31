package problem.no1to10;

import java.util.stream.LongStream;

import static problem.Solution.problem;

public class Problem6 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=6
        problem("Sum square difference",
                () ->
                        of(100));
    }

    static long of(int i) {
        return (long) (squareOfSums(i) - sumOfSquares(i));
    }

    static double squareOfSums(int i) {
        return Math.pow(LongStream.rangeClosed(1, i).sum(), 2);
    }

    static double sumOfSquares(int i) {
        return LongStream.rangeClosed(1, i).mapToDouble(j -> Math.pow(j, 2)).sum();
    }

    private Problem6() {}
}
