package utils.sequence.arithmetic;

import utils.sequence.Sequence;

public class IntegerSequence extends Sequence<Integer> {
    private int i;

    public IntegerSequence(int from) {
        i = from;
    }

    @Override
    public Integer next() {
        if (i == Integer.MAX_VALUE)
            throw new ArithmeticException("Sequence overflowed");
        i++;
        return i;
    }

    @Override
    public boolean hasNext() {
        return true;
    }
}
