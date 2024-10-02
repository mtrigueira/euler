package problem14;

import utils.Sequence;

import static utils.Evenness.isEven;

public class CollatzSequence extends Sequence {
    public static CollatzSequence of(int i) {
        return new CollatzSequence(i);
    }
    private long n;
    private CollatzSequence(long start) {
        n = start;
    }

    @Override
    public long next() {
        long old = n;

        if (isEven(n))
            n /= 2;
        else
            n = 3 * n + 1;

        return old;
    }
}
