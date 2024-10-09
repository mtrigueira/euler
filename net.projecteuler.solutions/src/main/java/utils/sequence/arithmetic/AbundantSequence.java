package utils.sequence.arithmetic;

import utils.sequence.Sequence;

import java.math.BigInteger;

import static java.math.BigInteger.ONE;
import static utils.operator.Aliquot.isAbundant;

public class AbundantSequence extends Sequence<BigInteger> {
    private static final BigInteger FIRST_ABUNDANT_NUMBER = BigInteger.valueOf(12);
    private BigInteger n = FIRST_ABUNDANT_NUMBER.subtract(ONE);
    @Override
    public BigInteger next() {
        do
            n = n.add(ONE);
        while (!isAbundant(n));

        return n;
    }
}
