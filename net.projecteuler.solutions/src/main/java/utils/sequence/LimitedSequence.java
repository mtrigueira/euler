package utils.sequence;

import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.stream.Stream;

public class LimitedSequence<T> extends Sequence<T> {
    private final Sequence<T> sequence;
    private final boolean inclusive;
    final Function<T, Boolean> limit;
    private T peek;

    public LimitedSequence(Sequence<T> sequence, Function<T, Boolean> limit, boolean inclusive) {
        this.sequence = sequence;
        this.limit = limit;
        this.inclusive = inclusive;

        peek = sequence.hasNext() ? sequence.next() : null;
        applyLimit(peek);
    }

    public static <T> LimitedSequence<T> including(Sequence<T> sequence, Function<T, Boolean> limit) {
        return of(sequence, limit, true);
    }

    public static <T> LimitedSequence<T> excluding(Sequence<T> sequence, Function<T, Boolean> limit) {
        return of(sequence, limit, false);
    }

    private static <T> LimitedSequence<T> of(Sequence<T> sequence, Function<T, Boolean> limit, boolean inclusive) {
        return new LimitedSequence<>(sequence, limit, inclusive);
    }

    public static <T> T last(Stream<T> s) {
        return s.reduce((a, b) -> b).orElse(null);
    }

    @Override
    public T next() {
        if (!hasNext())
            throw new NoSuchElementException("Limit reached");

        T next = peek;
        peek = sequence.hasNext() ? sequence.next() : null;
        applyLimit(next);

        return next;
    }

    private void applyLimit(T next) {
        if (inclusive) {
            if (limit.apply(next))
                peek = null;
        } else {
            if (limit.apply(peek))
                peek = null;
        }
    }


    @Override
    public boolean hasNext() {
        return (peek != null);
    }

    public T last() {
        return last(stream());
    }
}
