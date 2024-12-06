package utils.sequence.given;

import utils.data.DigitNumber;
import utils.sequence.Sequence;

public class DigitNumberSequence extends Sequence<Long> {
    final byte[] digits;
    int index = 0;

    protected DigitNumberSequence(String number) {
        this.digits = DigitNumber.of(number).digits();
    }

    public static DigitNumberSequence of(String number) {
        return new DigitNumberSequence(number);
    }

    public Long next() {
        long value = digits[index];
        index++;

        return value;
    }

    public boolean hasNext() {
        return index < digits.length;
    }
}
