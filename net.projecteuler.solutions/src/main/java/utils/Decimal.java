package utils;

import java.math.BigInteger;

public class Decimal extends Fraction {
    private final int reciprocalLength;

    public static Decimal of(BigInteger numerator, BigInteger denominator) {
        return new Decimal(numerator, denominator);
    }

    public static Decimal of(int i, int d) {
        return of(BigInteger.valueOf(i), BigInteger.valueOf(d));
    }

    private static String makeString(long numerator, long denominator) {
        return DecimalStringMaker.toString(LongDivision.of(numerator, denominator));
    }

    @Override
    public String toString() {
        return makeString(n.longValueExact(), d.longValueExact());
    }

    private int calculateReciprocalLength() {
        String s = toString();
        return s.contains("(") ? s.indexOf(")") - s.indexOf("(") : 0;
    }

    public boolean isReciprocalCycle() {
        return reciprocalLength > 0;
    }

    public int reciprocalLength() {
        return reciprocalLength;
    }

    private Decimal(BigInteger numerator, BigInteger denominator) {
        super(numerator, denominator);
        reciprocalLength = calculateReciprocalLength();
    }
}

