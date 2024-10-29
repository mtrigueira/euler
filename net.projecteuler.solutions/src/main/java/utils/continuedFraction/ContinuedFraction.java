package utils.continuedFraction;

import java.math.BigInteger;

public abstract class ContinuedFraction {
    private static final ContinuedFraction e = new eContinuedFraction();

    public static ContinuedFraction e() {
        return e;
    }

    public abstract BigInteger at(int i);

    private static class eContinuedFraction extends ContinuedFraction {
        @Override
        public BigInteger at(int i) {
            if (i == 0) return BigInteger.TWO;
            if (i % 3 == 2) return BigInteger.valueOf((i + 1) / 3 * 2);
            return BigInteger.ONE;
        }

        @Override
        public String toString() {
            return "[2; 1, 2, 1, 1, 4, ..., 1, 2k, 1, ...]";
        }
    }

    public static ContinuedFraction sqrt(int radicand) {
        if (IrrationalSqrtContinuedFraction.isPerfectSquare(radicand))
            return IrrationalSqrtContinuedFraction.perfectSquare(radicand);

        return new IrrationalSqrtContinuedFraction(radicand);
    }
}
