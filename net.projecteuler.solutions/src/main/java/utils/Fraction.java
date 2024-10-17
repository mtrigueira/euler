package utils;

import java.math.BigInteger;
import java.util.Objects;

public abstract class Fraction {
    final BigInteger d;
    final BigInteger n;
    final String stringRepresentation;

    public Fraction(BigInteger n, BigInteger d, String stringRepresentation) {
        this.n = n;
        this.d = d;
        this.stringRepresentation = stringRepresentation;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Fraction) obj;
        return this.stringRepresentation.equals(that.stringRepresentation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(n, d);
    }

    public BigInteger denominator() {
        return d;
    }

    public BigInteger numerator() {
        return n;
    }

    @Override
    public String toString() {
        return stringRepresentation;
    }
}
