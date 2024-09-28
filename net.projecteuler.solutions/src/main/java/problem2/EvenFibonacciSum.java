package problem2;

import utils.Sequence;

public class EvenFibonacciSum {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=2
        System.out.println(sum(4000000));
    }

    public static long sum(int limit) {
        Sequence fib = new EvenFibonnacciSequence();
        long sum = 0;

        for (long a = fib.next(); a <= limit; a = fib.next())
            sum += a;

        return sum;
    }
}
