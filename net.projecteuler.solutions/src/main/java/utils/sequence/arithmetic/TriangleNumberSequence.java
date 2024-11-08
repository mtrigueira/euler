package utils.sequence.arithmetic;

public class TriangleNumberSequence extends ArithmeticSequence<Long> {
    private long current = 0L;
    private long count = 1L;

    @Override
    public Long next() {
        current += count;
        count++;
        return current;
    }
}
