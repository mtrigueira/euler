package utils.sequence.arithmetic;

import utils.prime.Prime;

import java.math.BigInteger;

import static java.math.BigInteger.ONE;

public class CompositeSequence extends ArithmeticSequence<BigInteger> {
    private final PrimeSequence p = PrimeSequence.from(5);
    private Prime lastPrime = p.next();
    private BigInteger i = BigInteger.valueOf(4);

    @Override
    public BigInteger next() {
        BigInteger current = i;
        i = i.add(ONE);
        if (lastPrime.equals(i)) {
            lastPrime = p.next();
            i = i.add(ONE);
        }

        return current;
    }
}
