package utils;

import java.util.Objects;

public abstract class Fraction {
    final int d;
    final int n;
    final String stringRepresentation;
    private final double quotient;

    public Fraction(int n, int d, String stringRepresentation) {
        this.n = n;
        this.d = d;
        this.stringRepresentation = stringRepresentation;
        quotient = (double) n / d;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Fraction) obj;
        return this.quotient == that.quotient;
    }

    @Override
    public int hashCode() {
        return Objects.hash(n, d);
    }

    public int denominator() {
        return d;
    }

    @Override
    public String toString() {
        return stringRepresentation;
    }
}
