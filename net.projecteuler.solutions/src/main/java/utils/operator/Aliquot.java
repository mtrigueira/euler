package utils.operator;

import utils.property.ProperDivisors;

import java.math.BigInteger;

import static java.math.BigInteger.ZERO;
import static utils.operator.BigComparisonOperator.*;

public class Aliquot {
    private Aliquot() {
    }

    public static boolean isAbundant(long i) {
        return isAbundant(BigInteger.valueOf(i));
    }
    public static boolean isPerfect(long i) {
        return isPerfect(BigInteger.valueOf(i));
    }
    public static boolean isDeficient(long i) {
        return isDeficient(BigInteger.valueOf(i));
    }

    public static boolean isAbundant(BigInteger i) {
        return greaterThan(sumOfDivisors(i),i);
    }

    public static boolean isPerfect(BigInteger i) {
        return equal(sumOfDivisors(i),i);
    }

    public static boolean isDeficient(BigInteger i) {
        return lessThan(sumOfDivisors(i), i);
    }

    private static BigInteger sumOfDivisors(BigInteger i) {
        return ProperDivisors.of(i.longValueExact()).stream()
                .reduce(BigInteger::add)
                .orElse(ZERO);
    }
}
