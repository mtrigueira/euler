package utils.continuedFraction;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;

import static java.math.BigInteger.ONE;

public class IrrationalSqrtContinuedFraction extends SqrtContinuedFraction {
    private static final int INFINITE_LOOP_PROTECTION = 220;
    private final List<BigInteger> a;

    IrrationalSqrtContinuedFraction(int radicand) {
        this.a = sequenceForSqrt(radicand, INFINITE_LOOP_PROTECTION);
    }

    static List<BigInteger> sequenceForSqrt(int radicand, int infiniteLoopProtection) {
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

        while (integerParts.size() < infiniteLoopProtection) {
            a = (a0.multiply(b).add(d)).divide(c);
            integerParts.add(a);

            BigInteger bn = b.multiply(c);
            BigInteger cn = b.pow(2).multiply(n).subtract(d.pow(2)).subtract(a.pow(2).multiply(c.pow(2))).add(BigInteger.TWO.multiply(a).multiply(c).multiply(d));
            BigInteger dn = a.multiply(c.pow(2)).subtract(c.multiply(d));

            BigInteger g = bn.gcd(cn).gcd(dn);
            b = bn.divide(g);
            c = cn.divide(g);
            d = dn.divide(g);

            if (b.equals(b1) && c.equals(c1) && d.equals(d1))
                break;

            if (integerParts.size() == 1) {
                b1 = b;
                c1 = c;
                d1 = d;
            }
        }
        if (integerParts.size() == infiniteLoopProtection) {
            throw new RuntimeException("sqrt(" + n + "): Too many iterations " + integerParts.size() + ". Fix bug, or increase. Terminated sequence " + integerParts);
        }

        return integerParts;
    }

    public int period() {
        return a.size() - 1;
    }

    public BigInteger at(int i) {
        if (i < a.size())
            return a.get(i);
        int period = period();
        int indexInPeriod = (i - 1) % period;
        return a.get(1 + indexInPeriod);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < a.size(); i++) {
            if (i == 1)
                sb.append("(");
            sb.append(a.get(i));
            if (i < a.size() - 1)
                if (i == 0)
                    sb.append("; ");
                else
                    sb.append(", ");
        }
        sb.append(")]");
        return sb.toString();
    }

    public List<BigInteger> atList() {
        return a.subList(0, a.size());
    }
}
