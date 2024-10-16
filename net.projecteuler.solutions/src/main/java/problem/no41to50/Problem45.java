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
    private static final MathContext MATH_CONTEXT = new MathContext(35, RoundingMode.CEILING);
    private static final BigDecimal EIGHT = BigDecimal.valueOf(8);
    private static final BigDecimal FOUR = BigDecimal.valueOf(4);

    public static void main(String[] args) {
        // https://projecteuler.net/problem=45
        problem("Triangular, pentagonal, and hexagonal");
        solution(triangularPentagonalAndHexagonal().map(BigInteger::toString).orElse("Not found"));
    }

    private static Optional<BigInteger> triangularPentagonalAndHexagonal() {
        return new TriangleNumberSequence().stream()
                .filter(PentagonalSequence::isPentagonal)
                .filter(Problem45::isHexagonal)
                .filter(x -> x.compareTo(BigInteger.valueOf(40755)) > 0)
                .findFirst();
    }

    static boolean isHexagonal(BigInteger n) {
        return new BigDecimal(n)
                .multiply(EIGHT)
                .add(BigDecimal.ONE)
                .sqrt(MATH_CONTEXT)
                .add(BigDecimal.ONE)
                .remainder(FOUR)
                .signum() == 0;
    }
}
