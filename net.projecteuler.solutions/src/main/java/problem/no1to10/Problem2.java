package problem.no1to10;

import utils.sequence.arithmetic.EvenFibonnacciSequence;

import java.math.BigInteger;

import static java.math.BigInteger.ZERO;
import static utils.operator.BigComparisonOperator.lessThanOrEqual;

public class Problem2 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=2
        System.out.println(sum(4000000));
    }

    public static BigInteger sum(int limit) {
        EvenFibonnacciSequence fib = new EvenFibonnacciSequence();
        BigInteger sum = ZERO;
        BigInteger bigLimit = BigInteger.valueOf(limit);

        for (BigInteger a = fib.next(); lessThanOrEqual(a,bigLimit); a = fib.next())
            sum = sum.add(a);

        return sum;
    }
}
