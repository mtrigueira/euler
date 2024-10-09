package utils.sequence.given;

import utils.data.DigitNumber;

public class DigitNumberSequence extends DigitNumber {
    public static DigitNumberSequence of(String number) {
        return new DigitNumberSequence(toByteArray(number));
    }

    int index = 0;

    protected DigitNumberSequence(byte[] digits) {
        super(digits);
    }

    public long next()  {
        long value = digits[index];
        index++;

        return value;
    }

    public boolean hasNext() {
        return index<digits.length;
    }
}
