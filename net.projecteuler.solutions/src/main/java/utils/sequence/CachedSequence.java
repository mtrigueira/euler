package utils.sequence;

import utils.Sequence;

import java.util.ArrayList;
import java.util.List;

public class CachedSequence extends Sequence {
    private int current = 0;

    public static CachedSequence of(Sequence sequence) {
        return new CachedSequence(sequence);
    }

    private final Sequence sequence;
    private final List<Long> cache = new ArrayList<>();
    private CachedSequence(Sequence sequence) {
        this.sequence = sequence;
    }

    @Override
    public long next() {
        if(current < cache.size())
            return cache.get(current++);

        long value = sequence.next();
        cache.add(value);
        current++;
        return value;
    }

    public void reset() {
        current = 0;
    }
}
