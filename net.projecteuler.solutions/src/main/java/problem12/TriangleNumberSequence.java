package problem12;

import utils.Sequence;

import java.math.BigInteger;

import static java.math.BigInteger.*;
import static java.math.BigInteger.ONE;

public class TriangleNumberSequence extends Sequence {
    private BigInteger current = ZERO;
    private BigInteger count = ONE;

    @Override
    public BigInteger next() {
        current = current.add(count);
        count = count.add(ONE);
        return current;
    }
}
