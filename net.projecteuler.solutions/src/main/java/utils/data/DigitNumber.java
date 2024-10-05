package utils.data;

import utils.sequence.given.DigitNumberSequence;

public class DigitNumber {
    public static DigitNumber of(String string) {
        return new DigitNumber(string);
    }

    protected final byte[] digits;
    protected DigitNumber(String number) {
        this.digits = DigitNumberSequence.toByteArray(number);
    }

    public static byte[] toByteArray(String number) {
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
