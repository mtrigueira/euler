package utils;

import utils.sequence.DigitNumberSequence;

public class DigitNumber {
    public static DigitNumber of(String string) {
        return new DigitNumber(string);
    }

    protected final byte[] digits;
    protected DigitNumber(String number) {
        this.digits = DigitNumberSequence.toByteArray(number);
    }

    protected static byte[] toByteArray(String number) {
        byte[] a = new byte[number.length()];

        for (int i = 0; i < number.length(); i++)
            a[i] = (byte) Character.getNumericValue(number.charAt(i));

        return a;
    }

    public int sumOfDigits() {
        int sum = 0;

        for (byte digit : digits) sum += digit;

        return sum;
    }
}
