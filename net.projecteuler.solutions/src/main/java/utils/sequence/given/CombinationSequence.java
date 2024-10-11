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
    private T current;
    private CombinationSequence<T> remainderSequence;

    public CombinationSequence(List<T> values, BiFunction<T, T, T> reducer) {
        this.values = values;
        this.iterator = values.iterator();
        this.reducer = reducer;
        current = null;
    }

    @Override
    public T next() {
        if (current == null|| !remainderSequence.hasNext()) {
            current = iterator.next();
            if(values.size()>1) {
                ArrayList<T> remainder = new ArrayList<>(values);
                remainder.remove(current);
                remainderSequence = new CombinationSequence<>(remainder, reducer);
            }
        }

        if(values.size()==1)
            return current;

        return reducer.apply(current, remainderSequence.next());
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext()|| (remainderSequence!=null&&remainderSequence.hasNext());
    }
}
