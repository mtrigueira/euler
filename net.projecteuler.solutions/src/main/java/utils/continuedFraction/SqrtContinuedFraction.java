package utils.continuedFraction;

import java.math.BigInteger;

public abstract class SqrtContinuedFraction extends ContinuedFraction {
    static RationalSqrtContinuedFraction perfectSquare(int radicand) {
        return new RationalSqrtContinuedFraction(radicand);
    }

    public static boolean isPerfectSquare(int i) {
        return BigInteger.valueOf(i).sqrt().pow(2).intValueExact() == i;
    }
}
