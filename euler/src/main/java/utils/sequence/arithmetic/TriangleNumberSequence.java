package utils.sequence.arithmetic;

public class TriangleNumberSequence extends ArithmeticSequence<Long> {
    private long current;
    private long count = 1L;

    public TriangleNumberSequence(long from) {
        current = from;
    }

    @Override
    public Long next() {
        current += count;
        if (current < 0)
            throw new ArithmeticException("Sequence overflowed");
        count++;
        return current;
    }
}
