package utils.sequence.given;

import utils.sequence.Sequence;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.BiFunction;

public class CombinationSequence<T> extends Sequence<T> {
    private final T[][] values;
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
        this.values = (T[][]) new Object[n][n];
        this.index = new int[n];
        if (n > 0)
            this.values[0] = values;
        splatValues(1);
        this.reducer = reducer;
        this.limit = Math.min(limit, n);
    }

    private void splatValues(int fromIndex) {
        int n = values.length;
        for (int i = fromIndex; i < n; i++)
            System.arraycopy(values[i - 1], 1, this.values[i], 0, n - i);
    }

    private void curateValues(int fromIndex) {
        int n = values.length;
        for (int i = fromIndex; i < n; i++) {
            System.arraycopy(values[i - 1], 0, values[i], 0, index[i - 1]);
            System.arraycopy(values[i - 1], index[i - 1] + 1, values[i], index[i - 1], values.length - index[i - 1] - 1);
        }
    }

    @Override
    public T next() {
        if (!hasNext())
            throw new NoSuchElementException();

        T current = current();

        int earliestDelta = advanceIndecies();
        if (earliestDelta != Integer.MAX_VALUE)
            curateValues(earliestDelta + 1);

        return current;
    }

    private int advanceIndecies() {
        for (int i = limit - 1; i >= 0; i--) {
            index[i]++;
            if (index[i] >= values.length - i) {
                if (i > 0)
                    index[i] = 0;
                continue;
            }
            return i;
        }
        return Integer.MAX_VALUE;
    }

    private T current() {
        T current = values[limit - 1][index[limit - 1]];
        for (int i = limit - 2; i >= 0; i--)
            current = reducer.apply(values[i][index[i]], current);

        return current;
    }

    @Override
    public boolean hasNext() {
        return values.length > 0 && index[0] < values.length;
    }

    public CombinationSequence<T> skip(int i) {
        int earliestDelta = Integer.MAX_VALUE;

        for (int k = 0; k < i; k++)
            earliestDelta = Math.min(earliestDelta,advanceIndecies());
        if (earliestDelta != Integer.MAX_VALUE)
            curateValues(earliestDelta + 1);

        return this;
    }
}
