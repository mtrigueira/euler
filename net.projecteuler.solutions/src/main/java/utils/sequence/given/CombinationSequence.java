package utils.sequence.given;

import utils.operator.Factorial;
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
        if (limit > 1)
            nextRemainderOrCurrent();
    }

    @Override
    public T next() {
        if (limit == 1)
            return iterator.next();

        if (!remainderSequence.hasNext())
            nextRemainderOrCurrent();


        return reducer.apply(current, remainderSequence.next());
    }

    private void nextRemainderOrCurrent() {
        current = iterator.next();

        ArrayList<T> remainder = new ArrayList<>(values);
        remainder.remove(current);
        remainderSequence = new CombinationSequence<>(remainder, reducer, limit - 1);
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext() || (remainderSequence != null && remainderSequence.hasNext());
    }

    public CombinationSequence<T> skip(int i) {
        int combinations = Factorial.ofBig(values.size()-1).intValueExact();

        while (i >= combinations) {
            i -= combinations;
            nextRemainderOrCurrent();
        }

        if(i>0&&limit>1)
            remainderSequence = remainderSequence.skip(i);

        return this;
    }
}
