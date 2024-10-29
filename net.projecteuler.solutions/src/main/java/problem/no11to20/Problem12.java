package problem.no11to20;

import utils.property.Factors;
import utils.sequence.arithmetic.TriangleNumberSequence;

import java.math.BigInteger;

import static java.math.BigInteger.ZERO;
import static problem.Solution.problem;

public class Problem12 {
     private Problem12() {
     }
    public static final int NUMBER_OF_DIVISORS = 500;

    public static void main(String[] args) {
        // https://projecteuler.net/problem=12
        problem("Highly divisible triangular number",
        () -> triangularNumber(NUMBER_OF_DIVISORS));
    }

    static BigInteger triangularNumber(int numberOfDivisors) {
        return new TriangleNumberSequence().stream()
                .dropWhile(i-> countFactors(i) < numberOfDivisors)
                .findFirst().orElse(ZERO);
    }

    static int countFactors(BigInteger candidate) {
        return Factors.of(candidate).size();
    }
}
