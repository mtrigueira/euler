package problem.no1to10.problem2;

import utils.sequence.arithmetic.EvenFibonnacciSequence;

public class EvenFibonacciSum {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=2
        System.out.println(sum(4000000));
    }

    public static long sum(int limit) {
        EvenFibonnacciSequence fib = new EvenFibonnacciSequence();
        long sum = 0;

        for (long a = fib.next().longValueExact(); a <= limit; a = fib.next().longValueExact())
            sum += a;

        return sum;
    }
}
