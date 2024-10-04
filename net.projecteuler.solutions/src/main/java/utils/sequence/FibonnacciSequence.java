package utils.sequence;

import utils.Sequence;

import java.math.BigInteger;

public class FibonnacciSequence extends Sequence {
    private BigInteger previous = BigInteger.ZERO;
    private BigInteger current = BigInteger.ONE;

    @Override
    public long next() {
        return nextBig().longValueExact();
    }

    public BigInteger nextBig() {
        BigInteger temp = current;
        current = previous.add(current);
        previous = temp;
        return previous;
    }
    public static FibonnacciSequence of() {
        return new FibonnacciSequence();
    }
}
