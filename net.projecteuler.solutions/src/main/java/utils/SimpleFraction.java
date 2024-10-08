package utils;

public class SimpleFraction extends Fraction {
    public static SimpleFraction of(int numerator, int denominator) {
        return new SimpleFraction(numerator, denominator);
    }

    private SimpleFraction(int numerator, int denominator) {
        super(numerator, denominator, numerator + "/" + denominator);
    }

    public SimpleFraction simplify() {
        if (n == d) return new SimpleFraction(1, 1);
        int gcd = gcd(n, d);
        if (gcd == 1) return this;
        return SimpleFraction.of(n / gcd, d / gcd);
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public SimpleFraction multiply(SimpleFraction by) {
        int newN = this.n * by.n;
        int newD = this.d * by.d;
        return SimpleFraction.of(newN, newD);
    }
}
