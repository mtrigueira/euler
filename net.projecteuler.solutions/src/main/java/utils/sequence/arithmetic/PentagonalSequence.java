package utils.sequence.arithmetic;

import java.math.BigInteger;

import static java.math.BigInteger.ONE;
import static utils.polyagonal.Polygonal.PENTAGONAL;

public class PentagonalSequence extends ArithmeticNumberSequence<BigInteger> {
    private BigInteger index = ONE;

    @Override
    public BigInteger next() {
        BigInteger result = PENTAGONAL.at(index);
        index = index.add(ONE);
        return result;
    }
}
