package utils.sequence.given;

import utils.sequence.Sequence;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.BiFunction;

public class CombinationSequence<T> extends Sequence<T> {
    private final List<T> values;
    private final BiFunction<T, T, T> reducer;
    private final int limit;
    private final int[] index;

    public CombinationSequence(List<T> values, BiFunction<T, T, T> reducer) {
        this(values, reducer, values.size());
    }

    public CombinationSequence(List<T> values, BiFunction<T, T, T> reducer, int limit) {
        //noinspection unchecked
        this((T[]) values.toArray(), reducer, limit);
    }

    public CombinationSequence(T[] values, BiFunction<T, T, T> reducer, int limit) {
        int n = values.length;
        this.index = new int[n];
        this.values = List.of(values);
        this.reducer = reducer;
        this.limit = Math.min(limit, n);
    }

    @Override
    public T next() {
        if (!hasNext())
            throw new NoSuchElementException();

        T current = current();

        advanceIndecies();

        return current;
    }

    private void advanceIndecies() {
        for (int i = limit; --i >= 0; ) {
            if (++index[i] < values.size() - i)
                return;

            if (i > 0)
                index[i] = 0;
        }
    }

    private T current() {
        List<T> e = new ArrayList<>(values);

        T current = e.remove(index[0]);
        for (int i = 1; i < limit; i++)
            current = reducer.apply(current, e.remove(index[i]));

        return current;
    }

    @Override
    public boolean hasNext() {
        return !values.isEmpty() && index[0] < values.size();
    }

    public CombinationSequence<T> skip(int i) {
        for (int k = 0; k < i; k++)
            advanceIndecies();

        return this;
    }
}
