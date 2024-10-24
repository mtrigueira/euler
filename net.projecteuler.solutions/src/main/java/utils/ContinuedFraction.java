package utils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static java.math.BigInteger.ONE;
import static problem.Solution.solution;

public class ContinuedFraction {
    public static final int INFINITE_LOOP_PROTECTION = 220;
    List<BigInteger> a;
    int repeatsAt;

    private ContinuedFraction(List<BigInteger> a, int repeatsAt) {
        this.a = a;
        this.repeatsAt = repeatsAt;
    }

    private static ContinuedFraction perfectSquare(int radicand) {
        return new ContinuedFraction(List.of(BigInteger.valueOf(radicand).sqrt()), -1);
    }

    public static ContinuedFraction explicit(List<BigInteger> a, int repeatsAt) {
        return new ContinuedFraction(a, repeatsAt);
    }

    public static ContinuedFraction sqrt(int radicand) {
        if (isPerfectSquare(radicand)) return perfectSquare(radicand);
        List<BigInteger> integerParts = new ArrayList<>();
        BigInteger n = BigInteger.valueOf(radicand);
        BigInteger b = ONE;
        BigInteger c = ONE;
        BigInteger d = BigInteger.ZERO;
        BigInteger dummy = ONE.negate();
        BigInteger b1, c1, d1;
        b1 = c1 = d1 = dummy;

        BigDecimal x = new BigDecimal(n).sqrt(MathContext.DECIMAL128);
        BigInteger a = x.toBigInteger();
        BigInteger a0 = a;

        while (integerParts.size() < INFINITE_LOOP_PROTECTION) {
            a = (a0.multiply(b).add(d)).divide(c);
            integerParts.add(a);

            BigInteger bn = b.multiply(c);
            BigInteger cn = b.pow(2).multiply(n).subtract(d.pow(2)).subtract(a.pow(2).multiply(c.pow(2))).add(BigInteger.TWO.multiply(a).multiply(c).multiply(d));
            BigInteger dn = a.multiply(c.pow(2)).subtract(c.multiply(d));

            BigInteger g = bn.gcd(cn).gcd(dn);
            b = bn.divide(g);
            c = cn.divide(g);
            d = dn.divide(g);

            if (integerParts.size() == 1) {
                b1 = b;
                c1 = c;
                d1 = d;
            } else {
                if (b.equals(b1) && c.equals(c1) && d.equals(d1)) {
                    break;
                }
            }
        }
        if (integerParts.size() == INFINITE_LOOP_PROTECTION) {
            System.out.println(n);
            System.out.println(integerParts);
            throw new RuntimeException("Too many iterations. Doughnut protection blown up. Fix bug, or increase");
        }
        return new ContinuedFraction(integerParts, 1);
    }

    public static boolean isPerfectSquare(int i) {
        return BigInteger.valueOf(i).sqrt().pow(2).intValueExact() == i;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContinuedFraction that)) return false;
        return repeatsAt == that.repeatsAt && Objects.equals(a, that.a);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, repeatsAt);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < a.size(); i++) {
            if (i == repeatsAt) sb.append("(");
            sb.append(a.get(i));
            if (i < a.size() - 1)
                if (i == 0)
                    sb.append("; ");
                else
                    sb.append(", ");
        }
        if (repeatsAt > -1) sb.append(")");
        sb.append("]");
        return sb.toString();
    }

    public int period() {
        int period = a.size() - repeatsAt;
        return period;
    }
}
