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

    public static SimpleFraction of(int numerator) {
        return of(BigInteger.valueOf(numerator));
    }

    public static SimpleFraction of(int numerator, int denominator) {
        return of(BigInteger.valueOf(numerator), BigInteger.valueOf(denominator));
    }

    public static SimpleFraction of(BigInteger integer) {
        return of(integer, BigInteger.ONE);
    }

    private static SimpleFraction factory(BigInteger numerator, BigInteger denominator) {
        return new SimpleFraction(numerator, denominator);
    }

    public static SimpleFraction of(int numerator, BigInteger denominator) {
        return of(BigInteger.valueOf(numerator), denominator);
    }

    public static Tupple<BigInteger> parse(String expectedString) {
        String[] split = expectedString.split("/");
        if (split.length > 2)
            throw new NumberFormatException();

        BigInteger n = new BigInteger(split[0]);
        BigInteger d = split.length == 1 ? BigInteger.ONE : new BigInteger(split[1]);

        return new Tupple<>(n, d);
    }

    public static SimpleFraction parseSimpleFraction(String string) {
        Tupple<BigInteger> tupple = parse(string);
        return of(tupple.left(),tupple.right());
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
        BigInteger cm = this.denominator().multiply(that.denominator());

        BigInteger newNumerator = (this.numerator().multiply(cm).divide(this.denominator())
                .add(that.numerator().negate().multiply(cm).divide(that.denominator())));

        BigInteger gcd = cm.gcd(newNumerator);

        return SimpleFraction.of(newNumerator.divide(gcd), cm.divide(gcd));
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
