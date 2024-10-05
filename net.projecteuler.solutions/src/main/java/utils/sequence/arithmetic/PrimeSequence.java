package utils.sequence.arithmetic;

import utils.prime.Prime;
import utils.sequence.Sequence;

import java.math.BigInteger;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.TWO;
import static utils.operator.BigComparisonOperator.equal;

public class PrimeSequence extends Sequence {
    private BigInteger current = TWO;

    @Override
    public BigInteger next() {
        BigInteger last = current;
        if (equal(current, TWO)) {
            current = current.add(ONE);
            return last;
        }

        do
            current = current.add(TWO);
        while (!Prime.isPrime(current));

        return last;
    }
}
