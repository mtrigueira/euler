package problem.no11to20.problem12;

import utils.sequence.Sequence;

import java.math.BigInteger;

import static java.math.BigInteger.*;

public class TriangleNumberSequence extends Sequence<BigInteger> {
    private BigInteger current = ZERO;
    private BigInteger count = ONE;

    @Override
    public BigInteger next() {
        current = current.add(count);
        count = count.add(ONE);
        return current;
    }

    @Override
    public boolean hasNext() {
        return true;
    }
}
