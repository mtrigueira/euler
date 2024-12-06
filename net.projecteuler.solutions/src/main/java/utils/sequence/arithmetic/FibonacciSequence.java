package utils.sequence.arithmetic;

import java.math.BigInteger;

public class FibonacciSequence extends ArithmeticSequence<BigInteger> {
    private BigInteger previous = BigInteger.ZERO;
    private BigInteger current = BigInteger.ONE;

    public static FibonacciSequence of() {
        return new FibonacciSequence();
    }

    public BigInteger next() {
        BigInteger temp = current;
        current = previous.add(current);
        previous = temp;
        return previous;
    }
}
