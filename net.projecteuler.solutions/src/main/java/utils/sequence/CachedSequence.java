package utils.sequence;

import utils.Sequence;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class CachedSequence extends Sequence {
    private int current = 0;

    public static CachedSequence of(Sequence sequence) {
        return new CachedSequence(sequence);
    }

    private final Sequence sequence;
    private final List<BigInteger> cache = new ArrayList<>();
    private CachedSequence(Sequence sequence) {
        this.sequence = sequence;
    }

    @Override
    public BigInteger next() {
        if(current < cache.size())
            return cache.get(current++);

        BigInteger value = sequence.next();
        cache.add(value);
        current++;
        return value;
    }

    public void reset() {
        current = 0;
    }
}
