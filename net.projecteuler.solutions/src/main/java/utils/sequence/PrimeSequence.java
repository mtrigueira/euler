package utils.sequence;

import utils.Prime;
import utils.Sequence;

public class PrimeSequence extends Sequence {
    private long current = 2;

    @Override
    public long next() {
        long last = current;
        if (current == 2)
            return (int)current++;

        do current += 2;
        while (!Prime.isPrime(current));

        if (last > (long) Integer.MAX_VALUE) throw new RuntimeException("Prime sequence overflow");
        return (int) last;
    }
}
