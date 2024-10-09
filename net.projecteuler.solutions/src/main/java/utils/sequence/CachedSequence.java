package utils.sequence;

import java.util.ArrayList;
import java.util.List;

public class CachedSequence<T> extends Sequence<T> {
    private int current = 0;

    public static <T> CachedSequence<T> of(Sequence<T> sequence) {
        return new CachedSequence<>(sequence);
    }

    private final Sequence<T> sequence;
    private final List<T> cache = new ArrayList<>();
    private CachedSequence(Sequence<T> sequence) {
        this.sequence = sequence;
    }

    @Override
    public T next() {
        if(current < cache.size())
            return cache.get(current++);

        T value = sequence.next();
        cache.add(value);
        current++;
        return value;
    }

    public void reset() {
        current = 0;
    }
}
