package utils.sequence.arithmetic;

import utils.sequence.Sequence;

import java.math.BigInteger;

import static java.math.BigInteger.*;

public class EvenFibonnacciSequence extends Sequence<BigInteger> {
    private static final BigInteger FOUR = BigInteger.valueOf(4);
    private BigInteger previous = TWO;
    private BigInteger current = ZERO;

    @Override
    public BigInteger next() {
        BigInteger temp = current;
        current = previous.add(current.multiply(FOUR));
        previous = temp;
        return current;
    }
}
