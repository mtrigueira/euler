package problem.no41to50;

import utils.polyagonal.Polygonal;
import utils.sequence.arithmetic.PolygonalSequence;

import java.util.Optional;

import static problem.Solution.problem;

public class Problem45 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=45
        problem("Triangular, pentagonal, and hexagonal",
                () -> triangularPentagonalAndHexagonalAfter(40755).map(Object::toString).orElse("Not found"));
    }

    static Optional<Long> triangularPentagonalAndHexagonalAfter(int after) {
        return new PolygonalSequence(Polygonal.HEXAGONAL).stream()
                .filter(Polygonal.PENTAGONAL::is)
                .filter(Polygonal.TRIANGULAR::is)
                .dropWhile(n -> n.compareTo((long) after) < 0)
                .findFirst();
    }

    private Problem45() {}
}
