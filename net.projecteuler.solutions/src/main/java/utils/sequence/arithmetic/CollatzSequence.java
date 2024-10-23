package utils.sequence.arithmetic;

import java.math.BigInteger;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.TWO;
import static utils.property.Evenness.isEven;

public class CollatzSequence extends ArithmeticSequence<BigInteger> {
    public static CollatzSequence of(long i) {
        return new CollatzSequence(BigInteger.valueOf(i));
    }

    private static final BigInteger THREE = BigInteger.valueOf(3);
    private BigInteger n;

    private CollatzSequence(BigInteger start) {
        n = start;
    }

    @Override
    public BigInteger next() {
        BigInteger old = n;

        if (isEven(n))
            n = n.divide(TWO);
        else
            n = n.multiply(THREE).add(ONE);

        return old;
    }
}
