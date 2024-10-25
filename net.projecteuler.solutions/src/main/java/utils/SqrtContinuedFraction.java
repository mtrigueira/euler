package utils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.math.BigInteger.ONE;

public abstract class SqrtContinuedFraction extends ContinuedFraction {
    private static final int INFINITE_LOOP_PROTECTION = 220;

    private static RationalSqrtContinuedFraction perfectSquare(int radicand) {
        return new RationalSqrtContinuedFraction(radicand);
    }

    public static SqrtContinuedFraction sqrt(int radicand) {
        if (isPerfectSquare(radicand)) return perfectSquare(radicand);
        return new IrrationalSqrtContinuedFraction(radicand);
    }

    public static boolean isPerfectSquare(int i) {
        return BigInteger.valueOf(i).sqrt().pow(2).intValueExact() == i;
    }

    public static class IrrationalSqrtContinuedFraction extends SqrtContinuedFraction {
        private final List<BigInteger> a;
        private final int repeatsAt;

        private IrrationalSqrtContinuedFraction(int radicand) {
            this.a = sequenceForSqrt(radicand);
            this.repeatsAt = 1;
        }

        public int period() {
            return a.size() - repeatsAt;
        }

        private List<BigInteger> sequenceForSqrt(int radicand) {
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

                if (b.equals(b1) && c.equals(c1) && d.equals(d1))
                    break;

                if (integerParts.size() == 1) {
                    b1 = b;
                    c1 = c;
                    d1 = d;
                }
            }
            if (integerParts.size() == INFINITE_LOOP_PROTECTION) {
                System.err.println(n);
                System.err.println(integerParts);
                throw new RuntimeException("Too many iterations. Fix bug, or increase.");
            }

            return integerParts;
        }

        public BigInteger at(int i) {
            if (i < a.size()) return a.get(i);
            int period = period();
            int indexInPeriod = (i - repeatsAt) % period;
            return a.get(repeatsAt + indexInPeriod);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof IrrationalSqrtContinuedFraction that)) return false;
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
                if (i < a.size() - 1) if (i == 0) sb.append("; ");
                else sb.append(", ");
            }
            if (repeatsAt > -1) sb.append(")");
            sb.append("]");
            return sb.toString();
        }

        public List<BigInteger> atList() {
            return a.subList(0, a.size());
        }
    }

    public static class RationalSqrtContinuedFraction extends SqrtContinuedFraction {
        private final BigInteger root;

        private RationalSqrtContinuedFraction(int radicand) {
            this.root = BigInteger.valueOf(radicand).sqrt();
        }

        @Override
        public String toString() {
            return "[" + root + "]";
        }

        @Override
        public BigInteger at(int i) {
            if(i == 0) return root;
            return BigInteger.ZERO;
        }
    }
}
