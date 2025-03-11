package utils;

import java.math.BigInteger;

public abstract class Fraction {
    final BigInteger d;
    final BigInteger n;

    public Fraction(BigInteger n, BigInteger d) {
        this.n = n;
        this.d = d;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof Fraction that))
            return false;
        return n.equals(that.n) && d.equals(that.d);
    }

    @Override
    public int hashCode() {
        return d.intValue() + n.intValue();
    }

    public BigInteger denominator() {
        return d;
    }

    public BigInteger numerator() {
        return n;
    }

    @Override
    public abstract String toString();
}
