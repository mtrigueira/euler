package utils.sequence.arithmetic;

import utils.polyagonal.Polygonal;

import java.math.BigInteger;

import static java.math.BigInteger.ONE;

public class PolygonalSequence extends ArithmeticNumberSequence<BigInteger> {
    private BigInteger index = ONE;
    private final Polygonal polygonal;

    public PolygonalSequence(Polygonal polygonal) {
        this.polygonal = polygonal;
    }

    @Override
    public BigInteger next() {
        BigInteger result = polygonal.at(index);
        index = index.add(ONE);
        return result;
    }
}
