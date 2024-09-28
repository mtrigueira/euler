package problem7;

import utils.Sequence;

public class PrimeSequence extends Sequence {
    private long current = 2;

    @Override
    public long next() {
        long last = current;
        if (current == 2)
            return (int)current++;

        current += 2;
        while (!Prime.isPrime(current))
            current += 2;

        if (last > (long) Integer.MAX_VALUE) throw new RuntimeException("Prime sequence overflow");
        return (int) last;
    }
}
