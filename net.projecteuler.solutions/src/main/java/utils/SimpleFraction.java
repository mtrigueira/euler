package utils;

import java.math.BigInteger;

public class SimpleFraction extends Fraction {
    public static final SimpleFraction ZERO = SimpleFraction.factory(BigInteger.ZERO, BigInteger.ONE);
    public static final SimpleFraction ONE = SimpleFraction.factory( BigInteger.ONE, BigInteger.ONE);
    public static final SimpleFraction TWO = SimpleFraction.factory(BigInteger.TWO, BigInteger.ONE);

    public static SimpleFraction of(BigInteger numerator, BigInteger denominator) {
        return factory(numerator, denominator).simplify();
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
        return of(BigInteger.valueOf(i),cheat);
    }

    private SimpleFraction(BigInteger numerator, BigInteger denominator) {
        super(numerator, denominator, numerator + "/" + denominator);
    }

    private SimpleFraction simplify() {
        if (n.equals(d)) return ONE;
        if (BigInteger.ONE.equals(n.gcd(d))) return this;
        return SimpleFraction.of(n.divide(n.gcd(d)), d.divide(n.gcd(d)));
    }

    public SimpleFraction multiply(SimpleFraction by) {
        BigInteger newN = this.n.multiply(by.n);
        BigInteger newD = this.d.multiply(by.d);
        return SimpleFraction.of(newN, newD);
    }

    public SimpleFraction add(SimpleFraction that) {
        BigInteger cm = this.denominator() .multiply( that.denominator());

        BigInteger newNumerator = (this.numerator().multiply(cm).divide(this.denominator())
                .add(that.numerator().multiply(cm).divide(that.denominator())));

        return SimpleFraction.of(newNumerator, cm);
    }

    public SimpleFraction divide(SimpleFraction that) {
        return SimpleFraction.of( this.numerator().multiply(that.denominator()),
                this.denominator().multiply(that.numerator()));
    }

    public SimpleFraction subtract(SimpleFraction that) {
        return add(that.multiply(SimpleFraction.of(-1)));
    }

    public SimpleFraction reciprocal() {
        return SimpleFraction.of(d, n);
    }

    public BigInteger toBigIntegerExact() {
        if(BigInteger.ONE.equals(denominator())) return numerator();
        throw new ArithmeticException("Fraction is not an integer: " + this);
    }
}
