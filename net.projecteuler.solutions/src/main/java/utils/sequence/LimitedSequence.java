package utils.sequence;

import java.util.NoSuchElementException;

public class LimitedSequence<T> extends Sequence<T> {
    private int current = 0;

    public static <T> LimitedSequence<T> of(Sequence<T> sequence, int maxNumberOfElements) {
        return new LimitedSequence<>(sequence,maxNumberOfElements);
    }

    private final Sequence<T> wrappedSequence;
    private final int maxNumberOfElements;

    private LimitedSequence(Sequence<T> wrappedSequence, int maxNumberOfElements) {
        this.wrappedSequence = wrappedSequence;
        this.maxNumberOfElements = maxNumberOfElements;
    }

    @Override
    public T next() {
        current++;
        if (current > maxNumberOfElements) {
            throw new NoSuchElementException("Reached maximum number of elements: " + maxNumberOfElements);
        }

        return wrappedSequence.next();
    }

    @Override
    public boolean hasNext() {
        if(current >= maxNumberOfElements)
            return false;
        return wrappedSequence.hasNext();
    }

    public T last() {
        T last = null;
        while (hasNext()) {
            last = next();
        }
        return last;
    }
}
