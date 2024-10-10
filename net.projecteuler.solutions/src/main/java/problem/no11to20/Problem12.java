package problem.no11to20;

import utils.property.Factors;
import utils.sequence.arithmetic.TriangleNumberSequence;

import java.math.BigInteger;

import static java.math.BigInteger.ZERO;

public class Problem12 {

    public static final int NUMBER_OF_DIVISORS = 500;

    public static void main(String[] args) {
        System.out.println(withOver(NUMBER_OF_DIVISORS));
    }

    static long withOver(int numberOfDivisors) {
        if (numberOfDivisors < 1) return 0;
        TriangleNumberSequence sequence = new TriangleNumberSequence();
        BigInteger candidate = ZERO;
        int count = 0;

        while (count < numberOfDivisors) {
            candidate = sequence.next();
            count = countFactors(candidate);
        }

        return candidate.longValueExact();
    }

    static int countFactors(BigInteger candidate) {
        return Factors.of(candidate.longValueExact()).size();
    }
}
