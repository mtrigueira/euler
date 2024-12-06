package utils.sequence.arithmetic;

import utils.polyagonal.Polygonal;

import java.math.BigInteger;

import static java.math.BigInteger.ONE;

public class PolygonalSequence extends ArithmeticSequence<BigInteger> {
    private final Polygonal polygonal;
    private BigInteger index = ONE;

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
