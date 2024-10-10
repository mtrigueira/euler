package problem.no11to20.problem14;

import utils.sequence.arithmetic.CollatzSequence;

public class LongestCollatzSequence {

    public static final int LIMIT = 1000000;

    public static void main(String[] args) {
        System.out.println(getMaxChainLengthNumberForNaturalNumbersBelow(LIMIT));
    }

    static int getMaxChainLengthNumberForNaturalNumbersBelow(int limit) {
        int maxChainLength = 0;
        int maxChainLengthNumber = 0;

        for (int i = 1; i < limit; i++) {
            int length = chainLength(i);
            if(length > maxChainLength) {
                maxChainLength = length;
                maxChainLengthNumber = i;
            }
        }

        return maxChainLengthNumber;
    }

    static int chainLength(int i) {
        CollatzSequence seq = CollatzSequence.of(i);
        int length = 0;

        for(long n = seq.next().longValueExact(); n != 1; n= seq.next().longValueExact())
            length++;

        return length;
    }
}
