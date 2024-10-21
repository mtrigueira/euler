package problem.no41to50;

import utils.sequence.arithmetic.TriangleNumberSequence;

import java.math.BigInteger;
import java.util.Optional;

import static problem.Solution.problem;
import static problem.Solution.solution;
import static utils.polyagonal.Polygonal.HEXAGONAL;
import static utils.polyagonal.Polygonal.PENTAGONAL;

public class Problem45 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=45
        problem("Triangular, pentagonal, and hexagonal");
        solution(triangularPentagonalAndHexagonal().map(BigInteger::toString).orElse("Not found"));
    }

    private static Optional<BigInteger> triangularPentagonalAndHexagonal() {
        return new TriangleNumberSequence().stream()
                .filter(PENTAGONAL::is)
                .filter(HEXAGONAL::is)
                .filter(x -> x.compareTo(BigInteger.valueOf(40755)) > 0)
                .findFirst();
    }
}
