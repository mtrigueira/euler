package problem;

import utils.property.Factors;
import utils.sequence.arithmetic.TriangleNumberSequence;

import static problem.Solution.problem;

public class Problem12 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=12
        problem("Highly divisible triangular number",
                () -> triangularNumber(NUMBER_OF_DIVISORS));
    }

    public static final int NUMBER_OF_DIVISORS = 500;

    static long triangularNumber(int numberOfDivisors) {
        return new TriangleNumberSequence().stream()
                .dropWhile(i -> countFactors(i) < numberOfDivisors)
                .findFirst().orElse(0L);
    }

    static int countFactors(long candidate) {
        return Factors.of(candidate).size();
    }

    private Problem12() {}
}
