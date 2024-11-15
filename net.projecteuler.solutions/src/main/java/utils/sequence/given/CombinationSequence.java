package utils.sequence.given;

import utils.operator.Factorial;
import utils.sequence.Sequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.BiFunction;

public class CombinationSequence<T> extends Sequence<T> {
    private final T[] values;
    private final BiFunction<T, T, T> reducer;
    private final int limit;
    private int index = 0;
    private T current;
    private CombinationSequence<T> remainderSequence;

    public CombinationSequence(List<T> values, BiFunction<T, T, T> reducer) {
        this(values, reducer, values.size());
    }

    public CombinationSequence(List<T> values, BiFunction<T, T, T> reducer, int limit) {
        //noinspection unchecked
        this((T[]) values.toArray(), reducer, limit);
    }

    public CombinationSequence(T[] values, BiFunction<T, T, T> reducer, int limit) {
        this.values = values;
        this.reducer = reducer;
        this.limit = limit;
        current = null;
        if (limit > 1)
            nextRemainderOrCurrent();
    }

    @Override
    public T next() {
        if (limit == 1)
            return values[index++];

        if (!remainderSequence.hasNext())
            nextRemainderOrCurrent();


        return reducer.apply(current, remainderSequence.next());
    }

    private void nextRemainderOrCurrent() {
        if (index >= values.length)
            throw new NoSuchElementException();
        else
            current = values[index++];

        if (values.length > 1) {
            //noinspection unchecked
            T[] r = (T[]) new Object[values.length - 1];
            System.arraycopy(values, 0, r, 0, index - 1);
            System.arraycopy(values, index, r, index - 1, values.length - index);
            remainderSequence = new CombinationSequence<>(r, reducer, limit - 1);
        }
    }

    @Override
    public boolean hasNext() {
        return index < values.length || (remainderSequence != null && remainderSequence.hasNext());
    }

    public CombinationSequence<T> skip(int i) {
        int combinations = Factorial.ofBig(values.length - 1).intValueExact();

        while (i >= combinations) {
            i -= combinations;
            nextRemainderOrCurrent();
        }

        if (i > 0 && limit > 1)
            remainderSequence = remainderSequence.skip(i);

        return this;
    }
}
