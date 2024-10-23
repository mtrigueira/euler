package utils.sequence.arithmetic;

import java.math.BigInteger;

import static java.math.BigInteger.*;

public class TriangleNumberSequence extends ArithmeticSequence<BigInteger> {
    private BigInteger current = ZERO;
    private BigInteger count = ONE;

    @Override
    public BigInteger next() {
        current = current.add(count);
        count = count.add(ONE);
        return current;
    }
}
