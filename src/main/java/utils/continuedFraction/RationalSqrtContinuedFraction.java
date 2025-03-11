package utils.continuedFraction;

import java.math.BigInteger;

public class RationalSqrtContinuedFraction extends SqrtContinuedFraction {
    private final BigInteger root;

    RationalSqrtContinuedFraction(int radicand) {
        this.root = BigInteger.valueOf(radicand).sqrt();
    }

    @Override
    public String toString() {
        return "[" + root + "]";
    }

    @Override
    public BigInteger at(int i) {
        if (i == 0)
            return root;
        return BigInteger.ZERO;
    }
}
