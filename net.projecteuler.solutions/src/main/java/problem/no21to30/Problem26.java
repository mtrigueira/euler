package problem.no21to30;

import utils.Decimal;
import utils.Fraction;

import java.math.BigInteger;
import java.util.stream.IntStream;

import static problem.Solution.problem;
import static problem.Solution.solution;

public class Problem26 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=26
        problem("Reciprocal cycles");
        solution(indexOfLargestReciprocalCycle());
    }

    private static long indexOfLargestReciprocalCycle() {
        return IntStream.range(2, 1000)
                .mapToObj(d -> Decimal.of(1, d))
                .filter(Decimal::isReciprocalCycle)
                .reduce(Problem26::largestReciprocalCycle)
                .map(Fraction::denominator)
                .map(BigInteger::longValueExact)
                .orElse(0L);
    }

    private static Decimal largestReciprocalCycle(Decimal a, Decimal b) {
        return a.reciprocalLength() > b.reciprocalLength() ? a : b;
    }
}

