package utils;

import java.math.BigInteger;

public class Decimal extends Fraction {
    public static Decimal of(BigInteger numerator, BigInteger denominator) {
        return new Decimal(numerator, denominator);
    }

    private final int reciprocalLength;

    private Decimal(BigInteger numerator, BigInteger denominator) {
        super(numerator, denominator);
        reciprocalLength = calculateReciprocalLength();
    }

    @Override
    public String toString() {
        return makeString(n.longValueExact(), d.longValueExact());
    }

    public static Decimal of(int i, int d) {
        return of(BigInteger.valueOf(i), BigInteger.valueOf(d));
    }

    private int calculateReciprocalLength() {
        String s = toString();
        return s.contains("(") ? s.indexOf(")") - s.indexOf("(") : 0;
    }

    private static String makeString(long numerator, long denominator) {
        return DecimalStringMaker.toString(LongDivision.of(numerator, denominator));
    }

    public boolean isReciprocalCycle() {
        return reciprocalLength > 0;
    }

    public int reciprocalLength() {
        return reciprocalLength;
    }
}

