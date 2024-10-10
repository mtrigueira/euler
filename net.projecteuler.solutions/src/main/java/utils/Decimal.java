package utils;

public class Decimal extends Fraction {
    public static Decimal of(int numerator, int denominator) {
        return new Decimal(numerator, denominator);
    }

    private final int reciprocalLength;

    private Decimal(int numerator, int denominator) {
        super(numerator, denominator, makeString(numerator, denominator));
        reciprocalLength = calculateReciprocalLength();
    }

    private int calculateReciprocalLength() {
        return stringRepresentation.contains("(") ? stringRepresentation.indexOf(")") - stringRepresentation.indexOf("(") : 0;
    }

    private static String makeString(int numerator, int denominator) {
        return DecimalStringMaker.toString(LongDivision.of(numerator, denominator));
    }

    public boolean isReciprocalCycle() {
        return reciprocalLength > 0;
    }

    public int reciprocalLength() {
        return reciprocalLength;
    }
}

