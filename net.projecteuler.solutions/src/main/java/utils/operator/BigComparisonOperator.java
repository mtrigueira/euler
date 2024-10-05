package utils.operator;

import java.math.BigInteger;

public class BigComparisonOperator {
    public static boolean lessThan(BigInteger a, BigInteger b) {
        return a.compareTo(b) < 0;
    }

    public static boolean lessThanOrEqual(BigInteger a, BigInteger b) {
        return a.compareTo(b) <= 0;
    }

    public static boolean greaterThan(BigInteger a, BigInteger b) {
        return a.compareTo(b) > 0;
    }

    public static boolean greaterThanOrEqual(BigInteger a, BigInteger b) {
        return a.compareTo(b) >= 0;
    }

    public static boolean equal(BigInteger a, BigInteger b) {
        return a.compareTo(b) == 0;
    }

    public static boolean notEqual(BigInteger a, BigInteger b) {
        return a.compareTo(b) != 0;
    }

    public static boolean lt(BigInteger a, BigInteger b) {
        return lessThan(a, b);
    }

    public static boolean lte(BigInteger a, BigInteger b) {
        return lessThanOrEqual(a, b);
    }

    public static boolean gt(BigInteger a, BigInteger b) {
        return greaterThan(a, b);
    }

    public static boolean gte(BigInteger a, BigInteger b) {
        return greaterThanOrEqual(a, b);
    }

    public static boolean eq(BigInteger a, BigInteger b) {
        return equal(a, b);
    }

    public static boolean neq(BigInteger a, BigInteger b) {
        return notEqual(a, b);
    }
}
