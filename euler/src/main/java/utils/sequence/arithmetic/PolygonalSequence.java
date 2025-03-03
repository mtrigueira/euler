package utils.sequence.arithmetic;

import utils.polyagonal.Polygonal;

public class PolygonalSequence extends ArithmeticSequence<Long> {
    private final Polygonal polygonal;
    private int index = 0;

    public PolygonalSequence(Polygonal polygonal) {
        this.polygonal = polygonal;
    }

    @Override
    public Long next() {
        return (long) polygonal.at(++index);
    }
}
