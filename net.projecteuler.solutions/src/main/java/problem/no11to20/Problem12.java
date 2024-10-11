package problem.no11to20;

import utils.property.Factors;
import utils.sequence.LimitedSequence;
import utils.sequence.arithmetic.TriangleNumberSequence;

import java.math.BigInteger;

import static java.math.BigInteger.ZERO;
import static problem.Solution.problem;
import static problem.Solution.solution;

public class Problem12 {
    public static final int NUMBER_OF_DIVISORS = 500;
    final int numberOfDivisors;

    public Problem12(int numberOfDivisors) {
        this.numberOfDivisors = numberOfDivisors;
    }

    public static void main(String[] args) {
        // https://projecteuler.net/problem=12
        problem("Highly divisible triangular number");
        solution(new Problem12(NUMBER_OF_DIVISORS).triangularNumber());
    }

    static int countFactors(BigInteger candidate) {
        return Factors.of(candidate).size();
    }

    BigInteger triangularNumber() {
        if (numberOfDivisors < 1) return ZERO;

        LimitedSequence<BigInteger> sequence = LimitedSequence.including(
                new TriangleNumberSequence(),
                a -> !hasFewerDivisors(a));

        return sequence.last();
    }

    private boolean hasFewerDivisors(BigInteger a) {
        return countFactors(a) < numberOfDivisors;
    }
}
