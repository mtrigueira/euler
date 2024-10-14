package utils.sequence.arithmetic;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.TWO;

public class PentagonalSequence extends ArithmeticNumberSequence<BigInteger> {
    private static final BigInteger THREE = BigInteger.valueOf(3);
    private BigInteger index = ONE;

    private static BigInteger atIndex(BigInteger n) {
        return n.multiply((n.multiply(THREE).subtract(ONE))).divide(TWO);
    }

    public static boolean isPentagonal(BigInteger n) {
        return new BigDecimal(n)
                .multiply(BigDecimal.valueOf(24))
                .add(BigDecimal.ONE)
                .sqrt(new MathContext(35, RoundingMode.CEILING))
                .add(BigDecimal.ONE)
                .remainder(BigDecimal.valueOf(6)).equals(BigDecimal.ZERO);
    }

    @Override
    public BigInteger next() {
        BigInteger result = atIndex(index);
        index = index.add(ONE);
        return result;
    }
}
