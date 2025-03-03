package utils.sequence;

import java.util.ArrayList;
import java.util.List;

public class CachedSequence<T> extends Sequence<T> {
    private final Sequence<T> wrappedSequence;
    private final List<T> cache = new ArrayList<>();
    private int current = 0;

    public static <T> CachedSequence<T> of(Sequence<T> sequence) {
        return new CachedSequence<>(sequence);
    }

    @Override
    public T next() {
        if (current < cache.size())
            return cache.get(current++);

        T value = wrappedSequence.next();
        cache.add(value);
        current++;
        return value;
    }

    @Override
    public boolean hasNext() {
        if (current < cache.size())
            return true;
        return wrappedSequence.hasNext();
    }

    public void reset() {
        current = 0;
    }

    private CachedSequence(Sequence<T> wrappedSequence) {
        this.wrappedSequence = wrappedSequence;
    }
}
