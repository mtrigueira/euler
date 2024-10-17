package utils;

import java.math.BigInteger;

public class Decimal extends Fraction {
    public static Decimal of(BigInteger numerator, BigInteger denominator) {
        return new Decimal(numerator, denominator);
    }

    private final int reciprocalLength;

    private Decimal(BigInteger numerator, BigInteger denominator) {
        super(numerator, denominator, makeString(numerator.longValueExact(), denominator.longValueExact()));
        reciprocalLength = calculateReciprocalLength();
    }

    public static Decimal of(int i, int d) {
        return of(BigInteger.valueOf(i), BigInteger.valueOf(d));
    }

    private int calculateReciprocalLength() {
        return stringRepresentation.contains("(") ? stringRepresentation.indexOf(")") - stringRepresentation.indexOf("(") : 0;
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

