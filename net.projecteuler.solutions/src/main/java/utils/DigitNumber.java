package utils;

import problem8.DigitNumberSequence;

public class DigitNumber {
    protected final byte[] digits;

    public DigitNumber(String number) {
        this.digits = DigitNumberSequence.toByteArray(number);
    }

    protected static byte[] toByteArray(String number) {
        byte[] a = new byte[number.length()];

        for (int i = 0; i < number.length(); i++)
            a[i] = (byte) Character.getNumericValue(number.charAt(i));

        return a;
    }
}
