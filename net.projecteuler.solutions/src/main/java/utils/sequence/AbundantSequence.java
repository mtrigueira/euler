package utils.sequence;

import utils.Sequence;

import static utils.Aliquot.isAbundant;

public class AbundantSequence extends Sequence {
    private static final int FIRST_ABUNDANT_NUMBER = 12;
    private long n = FIRST_ABUNDANT_NUMBER - 1;
    @Override
    public long next() {
        do n++;
        while (!isAbundant(n));

        return n;
    }
}
