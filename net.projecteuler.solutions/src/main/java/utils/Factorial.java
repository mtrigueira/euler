package utils;

import java.math.BigInteger;

import static java.math.BigInteger.ONE;

public class Factorial {
    public static long of(long n) {
        BigInteger f = ofBig(BigInteger.valueOf(n));
        return f.longValueExact();
    }

    public static BigInteger ofBig(BigInteger n) {
        return ONE.equals(n) ? ONE : n.multiply(ofBig(n.subtract(ONE)));
    }
}
