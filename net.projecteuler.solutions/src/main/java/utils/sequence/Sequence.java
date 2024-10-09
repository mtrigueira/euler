package utils.sequence;

import java.util.Iterator;

public abstract class Sequence<T> implements Iterator<T> {
    public abstract T next();

    @Override
    public abstract boolean hasNext();
}
