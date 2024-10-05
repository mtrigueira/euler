package utils.sequence.arithmetic;

import utils.sequence.Sequence;

import java.math.BigInteger;

public class FibonnacciSequence extends Sequence {
    private BigInteger previous = BigInteger.ZERO;
    private BigInteger current = BigInteger.ONE;

    public BigInteger next() {
        BigInteger temp = current;
        current = previous.add(current);
        previous = temp;
        return previous;
    }
    public static FibonnacciSequence of() {
        return new FibonnacciSequence();
    }
}
