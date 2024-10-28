package problem.no41to50;

import utils.polyagonal.Polygonal;
import utils.sequence.arithmetic.PolygonalSequence;

import java.math.BigInteger;
import java.util.Optional;

import static problem.Solution.problem;

public class Problem45 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=45
        problem("Triangular, pentagonal, and hexagonal",
        () -> triangularPentagonalAndHexagonalAfter(40755).map(BigInteger::toString).orElse("Not found"));
    }

    static Optional<BigInteger> triangularPentagonalAndHexagonalAfter(int after) {
        return new PolygonalSequence(Polygonal.HEXAGONAL).stream()
                .filter(Polygonal.PENTAGONAL::is)
                .filter(Polygonal.TRIANGULAR::is)
                .dropWhile(n -> n.compareTo(BigInteger.valueOf(after)) < 0)
                .findFirst();
    }
}
