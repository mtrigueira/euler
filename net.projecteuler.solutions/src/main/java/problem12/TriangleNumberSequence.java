package problem12;

import utils.Sequence;

public class TriangleNumberSequence extends Sequence {
    private long current = 0;
    private long count = 1;
    @Override
    public long next() {
        current += count;
        count+=1;
        return current;
    }
}
