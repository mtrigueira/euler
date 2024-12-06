package utils.data;

import java.math.BigInteger;

public class DigitNumber {
    protected final byte[] digits;

    protected DigitNumber(byte[] digits) {
        this.digits = digits;
    }

    public static DigitNumber of(String number) {
        return new DigitNumber(toByteArray(number));
    }

    public static DigitNumber of(long i) {
        return new DigitNumber(toByteArray(i));
    }

    public static DigitNumber of(BigInteger i) {
        return of(i.toString());
    }

    public static byte[] toByteArray(String number) {
        byte[] a = new byte[number.length()];

        for (int i = 0; i < number.length(); i++)
            a[i] = (byte) Character.getNumericValue(number.charAt(i));

        return a;
    }

    public static byte[] toByteArray(long number) {
        int count = countDigits(number);
        byte[] digits = new byte[count];

        for (int i = 0; i < count; i++)
            digits[count - i - 1] = (byte) ((number / Math.pow(10, i)) % 10);

        return digits;
    }

    public static int countDigits(long number) {
        if (number < 0) throw new IllegalArgumentException("Number must be non-negative");
        return (int) (Math.log10(number) + 1);
    }

    public byte[] digits() {
        return digits;
    }

    public int sumOfDigits() {
        int sum = 0;

        for (byte digit : digits) sum += digit;

        return sum;
    }
}
