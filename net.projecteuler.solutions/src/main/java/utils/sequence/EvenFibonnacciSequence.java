package utils.sequence;

import utils.Sequence;

import java.math.BigInteger;

import static java.math.BigInteger.*;
import static java.math.BigInteger.ZERO;

public class EvenFibonnacciSequence extends Sequence {
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
