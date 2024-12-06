package utils.property;

import java.math.BigInteger;

import static java.math.BigInteger.ZERO;
import static utils.operator.BigComparisonOperator.lessThan;

public class Evenness {
    public static boolean isEven(long i) {
        return i % 2 == 0;
    }

    public static boolean isEven(BigInteger i) {
        return lessThan(i, ZERO) == i.testBit(0);
    }

    private Evenness() {
    }
}
