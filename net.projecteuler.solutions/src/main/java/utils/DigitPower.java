package utils;

public class DigitPower {
    private final long[] digitPower;
    private final long maxSum;

    public static DigitPower forExponent(int i) {
        return new DigitPower(i);
    }

    private long[] makeDigitPower(int exponent) {
        long[] digitPower = new long[10];

        for (int i = 0; i <= 9; i++)
            digitPower[i] = toLongExact(Math.pow(i, exponent));

        return digitPower;
    }

    private long toLongExact(double d) {
        if ((long) d != d)
            throw new ArithmeticException("long overflow");
        return (long) d;
    }

    public long sumOfDigitPowersFor(int i) {
        String digits = String.valueOf(i);
        long sum = 0;
        for (int j = 0; j < digits.length(); j++)
            sum += digitPower[digits.charAt(j) - '0'];
        return sum;
    }

    public long getMaxPossibleSum() {
        return maxSum;
    }

    private DigitPower(int exponent) {
        digitPower = makeDigitPower(exponent);
        maxSum = toLongExact(Math.pow(9, exponent) * 10);
    }
}
