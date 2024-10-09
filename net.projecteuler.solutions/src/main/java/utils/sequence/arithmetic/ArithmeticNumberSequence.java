package utils.sequence.arithmetic;

public abstract class ArithmeticNumberSequence<T extends Number> extends ArithmeticSequence<T> {
    @Override
    public abstract T next();

    @Override
    public boolean hasNext() {
        return true;
    }
}
