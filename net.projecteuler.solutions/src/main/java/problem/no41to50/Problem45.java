package problem.no41to50;

import utils.sequence.arithmetic.PentagonalSequence;
import utils.sequence.arithmetic.TriangleNumberSequence;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Optional;

import static problem.Solution.problem;
import static problem.Solution.solution;

public class Problem45 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=45
        problem("Triangular, pentagonal, and hexagonal");
        solution(triangularPentagonalAndHexagonal().map(BigInteger::toString).orElse("Not found"));
    }

    private static Optional<BigInteger> triangularPentagonalAndHexagonal() {
        return new TriangleNumberSequence().stream()
                .filter(PentagonalSequence::isPentagonal)
                .filter(Problem45::isHexagonal)
                .filter(x->x.compareTo(BigInteger.valueOf(40755))>0)
                .findFirst();
    }

    static boolean isHexagonal(BigInteger n) {
        // x = (1 + √(1 + 8y)) / 4
        return new BigDecimal(n)
                .multiply(BigDecimal.valueOf(8))
                .add(BigDecimal.ONE)
                .sqrt(new MathContext(35, RoundingMode.CEILING))
                .add(BigDecimal.ONE)
                .remainder(BigDecimal.valueOf(4)).equals(BigDecimal.ZERO);
    }
}
