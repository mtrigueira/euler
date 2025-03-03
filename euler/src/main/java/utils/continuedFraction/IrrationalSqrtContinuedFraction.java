package utils.continuedFraction;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


public class IrrationalSqrtContinuedFraction extends SqrtContinuedFraction {
    private static final int INFINITE_LOOP_PROTECTION = 220;
    private final List<Integer> a;

    private static List<Integer> sequenceForSqrt(int radicand, int infiniteLoopProtection) {
        List<Integer> integerParts = new ArrayList<>();
        int b = 1;
        int c = 1;
        int d = 0;
        int dummy = -1;
        int b1, c1, d1;
        b1 = c1 = d1 = dummy;

        int a = (int) Math.sqrt(radicand);
        final int a0 = a;

        while (integerParts.size() < infiniteLoopProtection) {
            a = (a0 * b + d) / c;
            integerParts.add(a);

            final int bn = b * c;
            final int cn = b * b * radicand - (d * d) - (a * a * c * c) + (2 * a * c * d);
            final int dn = a * c * c - (c * d);

            final int g = gcd(bn, gcd(cn, dn));
            b = bn / g;
            c = cn / g;
            d = dn / g;

            if (b == b1 && c == c1 && d == d1)
                break;

            if (integerParts.size() == 1) {
                b1 = b;
                c1 = c;
                d1 = d;
            }
        }


        return integerParts;
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    static IrrationalSqrtContinuedFraction createIrrationalSqrtContinuedFraction(int radicand,
                                                                                 int infiniteLoopProtection) {
        IrrationalSqrtContinuedFraction f = new IrrationalSqrtContinuedFraction(radicand, infiniteLoopProtection);
        if (f.a.size() == infiniteLoopProtection) {
            throw new RuntimeException("sqrt(" + radicand + "): Too many iterations " + infiniteLoopProtection + ". Fix bug, or increase. Terminated sequence " + f.a);
        }
        return f;
    }

    static IrrationalSqrtContinuedFraction createIrrationalSqrtContinuedFraction(int radicand) {
        return createIrrationalSqrtContinuedFraction(radicand, INFINITE_LOOP_PROTECTION);
    }

    public int period() {
        return a.size() - 1;
    }

    public BigInteger at(int i) {
        if (i < a.size())
            return BigInteger.valueOf(a.get(i));
        int period = period();
        int indexInPeriod = (i - 1) % period;
        return BigInteger.valueOf(a.get(1 + indexInPeriod));
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

    private IrrationalSqrtContinuedFraction(int radicand, int infiniteLoopProtection) {
        this.a = sequenceForSqrt(radicand, infiniteLoopProtection);
    }
}

