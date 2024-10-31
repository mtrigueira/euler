package utils.sequence.given;

import utils.sequence.Sequence;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.BiFunction;

public class CombinationSequence<T> extends Sequence<T> {
    private final List<T> values;
    private final Iterator<T> iterator;
    private final BiFunction<T, T, T> reducer;
    private final int limit;
    private T current;
    private CombinationSequence<T> remainderSequence;

    public CombinationSequence(List<T> values, BiFunction<T, T, T> reducer) {
        this(values, reducer, values.size());
    }

    public CombinationSequence(List<T> values, BiFunction<T, T, T> reducer, int limit) {
        this.values = values;
        this.iterator = values.iterator();
        this.reducer = reducer;
        this.limit = limit;
        current = null;
    }

    @Override
    public T next() {
        if (current == null || !remainderSequence.hasNext()) {
            current = iterator.next();
            if (limit > 1) {
                ArrayList<T> remainder = new ArrayList<>(values);
                remainder.remove(current);
                remainderSequence = new CombinationSequence<>(remainder, reducer, limit - 1);
            }
        }

        if (limit == 1) {
            T result = current;
            current = null;
            return result;
        }

        return reducer.apply(current, remainderSequence.next());
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext() || (remainderSequence != null && remainderSequence.hasNext());
    }
}
