package utils;

import java.math.BigInteger;

public class SimpleFraction extends Fraction {
    public static final SimpleFraction ZERO = SimpleFraction.factory(BigInteger.ZERO, BigInteger.ONE);
    public static final SimpleFraction ONE = SimpleFraction.factory(BigInteger.ONE, BigInteger.ONE);
    public static final SimpleFraction TWO = SimpleFraction.factory(BigInteger.TWO, BigInteger.ONE);

    public static SimpleFraction of(BigInteger numerator, BigInteger denominator) {
        BigInteger gcd = numerator.gcd(denominator);
        return factory(numerator.divide(gcd), denominator.divide(gcd));
    }

    public static SimpleFraction of(int nRight) {
        return of(BigInteger.valueOf(nRight));
    }

    public static SimpleFraction of(int nRight, int dRight) {
        return of(BigInteger.valueOf(nRight), BigInteger.valueOf(dRight));
    }

    public static SimpleFraction of(BigInteger aSubN) {
        return of(aSubN, BigInteger.ONE);
    }

    private static SimpleFraction factory(BigInteger numerator, BigInteger denominator) {
        return new SimpleFraction(numerator, denominator);
    }

    public static SimpleFraction of(int i, BigInteger cheat) {
        return of(BigInteger.valueOf(i), cheat);
    }

    public SimpleFraction multiply(SimpleFraction by) {
        BigInteger newN = this.n.multiply(by.n);
        BigInteger newD = this.d.multiply(by.d);
        return SimpleFraction.of(newN, newD);
    }

    public SimpleFraction add(SimpleFraction that) {
        BigInteger cm = this.denominator().multiply(that.denominator());

        BigInteger newNumerator = (this.numerator().multiply(cm).divide(this.denominator())
                .add(that.numerator().multiply(cm).divide(that.denominator())));

        BigInteger gcd = cm.gcd(newNumerator);

        return SimpleFraction.of(newNumerator.divide(gcd), cm.divide(gcd));
    }

    public SimpleFraction divide(SimpleFraction that) {
        return SimpleFraction.of(this.numerator().multiply(that.denominator()),
                this.denominator().multiply(that.numerator()));
    }

    public SimpleFraction subtract(SimpleFraction that) {
        return add(that.multiply(SimpleFraction.of(-1)));
    }

    public SimpleFraction reciprocal() {
        return SimpleFraction.of(d, n);
    }

    public BigInteger toBigIntegerExact() {
        if (isInteger())
            return numerator();
        throw new ArithmeticException("Fraction is not an integer: " + this);
    }

    public boolean isInteger() {
        return BigInteger.ONE.equals(denominator());
    }

    @Override
    public String toString() {
        return n + "/" + d;
    }

    private SimpleFraction(BigInteger numerator, BigInteger denominator) {
        super(numerator, denominator);
    }
}
