package utils.sequence.arithmetic;

import utils.sequence.Sequence;

public abstract class ArithmeticSequence<T extends Number> extends Sequence<T> {
    @Override
    public abstract T next();

    @Override
    public boolean hasNext() {
        return true;
    }
}
