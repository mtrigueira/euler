package problem.no21to30.problem25;

import utils.sequence.arithmetic.FibonnacciSequence;

import java.math.BigInteger;

public class ThousandDigitFibonacciNumber {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=25
        System.out.println(indexOfFirstFibonacciNumberWithLengthAtLeast(1_000));
    }

    static long indexOfFirstFibonacciNumberWithLengthAtLeast(int i) {
        FibonnacciSequence fib = FibonnacciSequence.of();
        long count = 0;

        for(BigInteger a = fib.next();; a = fib.next()) {
            count++;
            if(a.toString().length() >= i)
                return count;
        }
    }
}
