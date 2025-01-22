package utils.sequence.given;

import utils.operator.Factorial;
import utils.sequence.Sequence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.BiFunction;

public class CombinationSequence<T> extends Sequence<T> {
    private final List<T> values;
    private final BiFunction<T, T, T> reducer;
    private final int limit;
    private final int maxIndex;
    private int idx = 0;

    public CombinationSequence(List<T> values, BiFunction<T, T, T> reducer) {
        this(values, reducer, values.size());
    }

    public CombinationSequence(List<T> values, BiFunction<T, T, T> reducer, int limit) {
        int n = values.size();
        this.limit = Math.min(limit, n);
        this.values = Collections.unmodifiableList(values);
        this.reducer = reducer;
        maxIndex = n == 0 ? -1 : Math.toIntExact(Factorial.of(n) / (Factorial.of(n - limit)));
    }

    @Override
    public T next() {
        if (!hasNext())
            throw new NoSuchElementException();

        return atIndex(idx++);
    }

    private T atIndex(int at) {
        final int[] index = new int[this.limit];
        int remainder = at;
        for (int i = limit, size = values.size() - limit; --i >= 0; ) {
            index[i] = remainder % ++size;
            remainder /= size;
        }
//        assert remainder == 0;

        List<T> e = new ArrayList<>(values);

        T current = e.remove(index[0]);
        for (int i = 1; i < limit; i++)
            current = reducer.apply(current, e.remove(index[i]));

        return current;
    }

    @Override
    public boolean hasNext() {
        return idx < maxIndex;
    }

    public CombinationSequence<T> skip(int i) {
        idx += i;

        return this;
    }
}
