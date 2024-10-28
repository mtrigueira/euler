package utils.continuedFraction;

import java.math.BigInteger;

public abstract class SqrtContinuedFraction extends ContinuedFraction {
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
}
