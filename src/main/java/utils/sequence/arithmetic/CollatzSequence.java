package utils.sequence.arithmetic;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import static utils.property.Evenness.isEven;

public class CollatzSequence extends ArithmeticSequence<Long> {
    private static final Map<Long, Integer> cache = new HashMap<>();
    private long n;

    public static CollatzSequence of(long i) {
        return new CollatzSequence(i);
    }

    @Override
    public Long next() {
        long old = n;

        if (isEven(n))
            n = n / 2;
        else
            n = n * 3 + 1;

        if (n < 0) throw new NoSuchElementException(new ArithmeticException("Sequence overflowed"));

        return old;
    }

    public int count() {
        long old = n;
        int count = 0;
        while (n > 1) {
            if (cache.containsKey(n)) {
                count += cache.get(n);
                break;
            }
            count++;
            next();
        }
        cache.put(old, count);
        return count;
    }

    private CollatzSequence(long start) {
        n = start;
    }
}
